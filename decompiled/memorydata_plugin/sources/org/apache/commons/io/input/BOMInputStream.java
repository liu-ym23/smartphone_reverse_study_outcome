package org.apache.commons.io.input;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public class BOMInputStream extends ProxyInputStream {
    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = null;
    private final List<ByteOrderMark> boms;
    private ByteOrderMark byteOrderMark;
    private int fbIndex;
    private int fbLength;
    private int[] firstBytes;
    private final boolean include;
    private int markFbIndex;
    private boolean markedAtStart;

    static {
        ByteOrderMarkLengthComparator = $$Lambda$BOMInputStream$o1VQyiiWzTqQfScjaryUnRB8Ns.INSTANCE;
    }

    public BOMInputStream(InputStream r1, boolean r2, ByteOrderMark... r3) {
        super(r1);
        if (IOUtils.length(r3) == 0) goto L7;
        this.include = r2;
        List<ByteOrderMark> r4 = Arrays.asList(r3);
        r4.sort(ByteOrderMarkLengthComparator);
        this.boms = r4;
        return;
    L7:
        throw new IllegalArgumentException("No BOMs specified");
    }

    public BOMInputStream(InputStream r2, ByteOrderMark... r3) {
        this(r2, false, r3);
    }

    private ByteOrderMark find() {
        Iterator<ByteOrderMark> r0 = this.boms.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ByteOrderMark r1 = (ByteOrderMark) ZeusTransformUtils.preCheckCast(r0.next(), ByteOrderMark.class, "com.obric.memorydata.plugin");
        if (matches(r1) == false) goto L4;
        return r1;
    L8:
        return null;
    }

    static /* synthetic */ int lambda$static$0(ByteOrderMark r0, ByteOrderMark r1) {
        int r2 = r0.length();
        return Integer.compare(r1.length(), r2);
    }

    private boolean matches(ByteOrderMark r5) {
        int r1 = 0;
    L4:
        if (r1 >= r5.length()) goto L9;
        if (r5.get(r1) != this.firstBytes[r1]) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private int readFirstBytes() {
        getBOM();
        int r0 = this.fbIndex;
        if (r0 >= this.fbLength) goto L5;
        int[] r1 = this.firstBytes;
        this.fbIndex = r0 + 1;
        return r1[r0];
    L5:
        return -1;
    }

    public ByteOrderMark getBOM() {
        if (this.firstBytes != null) goto L20;
        this.fbLength = 0;
        this.firstBytes = new int[((ByteOrderMark) ZeusTransformUtils.preCheckCast(this.boms.get(0), ByteOrderMark.class, "com.obric.memorydata.plugin")).length()];
        int r1 = 0;
    L5:
        int[] r2 = this.firstBytes;
        if (r1 >= r2.length) goto L11;
        r2[r1] = this.in.read();
        this.fbLength++;
        if (this.firstBytes[r1] < 0) goto L11;
        r1 = r1 + 1;
    L11:
        ByteOrderMark r3 = find();
        this.byteOrderMark = r3;
        if (r3 == null) goto L20;
        if (this.include == true) goto L20;
        if (r3.length() >= this.firstBytes.length) goto L18;
        this.fbIndex = this.byteOrderMark.length();
        goto L20
    L18:
        this.fbLength = 0;
    L20:
        return this.byteOrderMark;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this.markFbIndex = this.fbIndex;     // Catch: Throwable -> L10
        if (this.firstBytes != null) goto L6;
        boolean r0 = true;
    L7:
        this.markedAtStart = r0;     // Catch: Throwable -> L10
        this.in.mark(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = readFirstBytes();
        if (r0 < 0) goto L6;
        return r0;
    L6:
        return this.in.read();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r5, int r6, int r7) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r7 <= 0) goto L8;
        if (r0 < 0) goto L8;
        r0 = readFirstBytes();
        if (r0 < 0) goto L3;
        r5[r6] = (byte) (r0 & 255);
        r7 = r7 - 1;
        r1 = r1 + 1;
        r6 = r6 + 1;
    L8:
        int r4 = this.in.read(r5, r6, r7);
        if (r4 >= 0) goto L14;
        if (r1 > 0) goto L22;
        return -1;
    L22:
        return r1;
    L14:
        return r1 + r4;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.fbIndex = this.markFbIndex;     // Catch: Throwable -> L9
        if (this.markedAtStart == false) goto L6;
        this.firstBytes = null;     // Catch: Throwable -> L9
    L6:
        this.in.reset();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long r5) {
        int r0 = 0;
    L3:
        long r1 = r0;
        if (r5 <= r1) goto L9;
        if (readFirstBytes() < 0) goto L9;
        r0 = r0 + 1;
    L9:
        return this.in.skip(r5 - r1) + r1;
    }
}
