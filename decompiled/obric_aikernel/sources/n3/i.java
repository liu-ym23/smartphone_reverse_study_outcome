package n3;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FileChannel f11197c;

    public i(File r10) {
        if (r10 == null) goto L9;
        if (r10.exists() == false) goto L9;
        this.f11197c = new FileInputStream(r10).getChannel();
        return;
    L9:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long a(d r10, long r11, long r12) {
        long r13 = 0;
    L4:
        if (r13 >= r11) goto L15;
        e r14 = r10.b(r13);
        if (r14.f11190a != 1) goto L13;
        long r15 = r14.f11192c;
        if (r15 > r12) goto L13;
        if (r12 > (r14.f11193d + r15)) goto L13;
        return (r12 - r15) + r14.f11191b;
    L13:
        r13 = r13 + 1;
        goto L4
    L15:
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d c() {
        this.f11197c.position(0);
        ByteBuffer r10 = ByteBuffer.allocate(8);
        r10.order(ByteOrder.LITTLE_ENDIAN);
        if (r(r10, 0) != 1179403647) goto L17;
        short r11 = k(r10, 4);
        if (k(r10, 5) != 2) goto L7;
        boolean r12 = true;
    L8:
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L15;
        return new h(r12, this);
    L15:
        throw new IllegalStateException("Invalid class type!");
    L10:
        return new g(r12, this);
    L7:
        r12 = false;
        goto L8
    L17:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11197c.close();
    }

    public List<String> f() {
        this.f11197c.position(0);
        ArrayList r10 = new ArrayList();
        d r11 = c();
        ByteBuffer r12 = ByteBuffer.allocate(8);
        if (r11.f11184a == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        long r14 = r11.f11188e;
        int r15 = 0;
        if (r14 != 65535) goto L9;
        r14 = r11.c(0).f11194a;
    L9:
        long r16 = 0;
    L11:
        if (r16 >= r14) goto L16;
        e r17 = r11.b(r16);
        if (r17.f11190a == 2) goto L14;
        r16 = r16 + 1;
        goto L11
    L14:
        long r18 = r17.f11191b;
    L18:
        if (r18 == 0) goto L20;
        ArrayList r19 = new ArrayList();
        long r110 = 0;
    L22:
        c r20 = r11.a(r18, r15);
        long r21 = r20.f11182a;
        if (r21 != 1) goto L26;
        r19.add(Long.valueOf(r20.f11183b));
    L28:
        r15 = r15 + 1;
        if (r20.f11182a != 0) goto L22;
        if (r110 == 0) goto L38;
        long r22 = a(r11, r14, r110);
        Iterator r23 = r19.iterator();
    L34:
        if (r23.hasNext() == false) goto L36;
        r10.add(p(r12, ((Long) r23.next()).longValue() + r22));
        goto L34
    L36:
        return r10;
    L38:
        throw new IllegalStateException("String table offset not found!");
    L26:
        if (r21 != 5) goto L28;
        r110 = r20.f11183b;
        goto L28
    L20:
        return Collections.unmodifiableList(r10);
    L16:
        r18 = 0;
        goto L18
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    protected void i(ByteBuffer r10, long r11, int r12) {
        r10.position(0);
        r10.limit(r12);
        long r13 = 0;
    L4:
        if (r13 >= r12) goto L10;
        int r14 = this.f11197c.read(r10, r11 + r13);
        if (r14 == (-1)) goto L9;
        r13 = r13 + ((long) r14);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r10.position(0);
    }

    protected short k(ByteBuffer r10, long r11) {
        i(r10, r11, 1);
        return (short) (r10.get() & 255);
    }

    protected int l(ByteBuffer r10, long r11) {
        i(r10, r11, 2);
        return r10.getShort() & UShort.MAX_VALUE;
    }

    protected long o(ByteBuffer r10, long r11) {
        i(r10, r11, 8);
        return r10.getLong();
    }

    protected String p(ByteBuffer r10, long r11) {
        StringBuilder r12 = new StringBuilder();
    L3:
        long r13 = 1 + r11;
        short r14 = k(r10, r11);
        if (r14 == 0) goto L7;
        r12.append((char) r14);
        r11 = r13;
        goto L3
    L7:
        return r12.toString();
    }

    protected long r(ByteBuffer r10, long r11) {
        i(r10, r11, 4);
        return ((long) r10.getInt()) & 4294967295L;
    }
}
