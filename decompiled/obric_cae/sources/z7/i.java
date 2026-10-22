package z7;

import com.qualcomm.qti.qesdk.QesdkUtils;
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

/* JADX INFO: loaded from: classes.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileChannel f14294a;

    public i(File r8) {
        if (r8.exists() == false) goto L7;
        this.f14294a = new FileInputStream(r8).getChannel();
        return;
    L7:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public final List<String> a() {
        FileChannel r8 = this.f14294a;
        r8.position(0);
        ArrayList r10 = new ArrayList();
        r8.position(0);
        ByteBuffer r11 = ByteBuffer.allocate(8);
        ByteOrder r12 = ByteOrder.LITTLE_ENDIAN;
        r11.order(r12);
        if (n(r11, 0) != 1179403647) goto L68;
        i(r11, 4, 1);
        short r13 = (short) (r11.get() & 255);
        i(r11, 5, 1);
        if (((short) (r11.get() & 255)) != 2) goto L7;
        boolean r14 = true;
    L8:
        if (r13 != 1) goto L10;
        d r15 = new g(r14, this);
    L12:
        ByteBuffer r16 = ByteBuffer.allocate(8);
        if (r15.f14281a == false) goto L15;
        r12 = ByteOrder.BIG_ENDIAN;
    L15:
        r16.order(r12);
        long r17 = r15.f14285e;
        if (r17 != 65535) goto L18;
        r17 = r15.c().f14291a;
    L18:
        long r18 = 0;
    L20:
        if (r18 >= r17) goto L25;
        e r19 = r15.b(r18);
        if (r19.f14287a == 2) goto L23;
        r18 = r18 + 1;
        goto L20
    L23:
        long r20 = r19.f14288b;
    L27:
        if (r20 == 0) goto L29;
        ArrayList r110 = new ArrayList();
        long r111 = 0;
        int r112 = 0;
    L31:
        c r113 = r15.a(r112, r20);
        long r21 = r113.f14279a;
        if (r21 != 1) goto L35;
        r110.add(Long.valueOf(r113.f14280b));
    L37:
        r112 = r112 + 1;
        if (r113.f14279a != 0) goto L31;
        if (r111 == 0) goto L63;
        long r22 = 0;
    L43:
        if (r22 >= r17) goto L61;
        e r23 = r15.b(r22);
        if (r23.f14287a != 1) goto L59;
        long r24 = r23.f14289c;
        if (r24 > r111) goto L59;
        if (r111 > (r23.f14290d + r24)) goto L59;
        long r114 = (r111 - r24) + r23.f14288b;
        Iterator r25 = r110.iterator();
    L52:
        if (r25.hasNext() == false) goto L58;
        long r26 = ((Long) r25.next()).longValue() + r114;
        StringBuilder r27 = new StringBuilder();
    L54:
        long r28 = r26 + 1;
        i(r16, r26, 1);
        short r29 = (short) (r16.get() & 255);
        if (r29 == 0) goto L57;
        r27.append((char) r29);
        r26 = r28;
        goto L54
    L57:
        r10.add(r27.toString());
        goto L52
    L58:
        return r10;
    L59:
        r22 = r22 + 1;
        goto L43
    L61:
        throw new IllegalStateException("Could not map vma to file offset!");
    L63:
        throw new IllegalStateException("String table offset not found!");
    L35:
        if (r21 != 5) goto L37;
        r111 = r113.f14280b;
        goto L37
    L29:
        return Collections.unmodifiableList(r10);
    L25:
        r20 = 0;
        goto L27
    L10:
        if (r13 != 2) goto L66;
        r15 = new h(r14, this);
        goto L12
    L66:
        throw new IllegalStateException("Invalid class type!");
    L7:
        r14 = false;
        goto L8
    L68:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f14294a.close();
    }

    public final void i(ByteBuffer r8, long r10, int r11) {
        r8.position(0);
        r8.limit(r11);
        long r12 = 0;
    L4:
        if (r12 >= r11) goto L10;
        int r13 = this.f14294a.read(r8, r10 + r12);
        if (r13 == (-1)) goto L9;
        r12 = r12 + ((long) r13);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r8.position(0);
    }

    public final int k(ByteBuffer r8, long r10) {
        i(r8, r10, 2);
        return r8.getShort() & 65535;
    }

    public final long n(ByteBuffer r8, long r10) {
        i(r8, r10, 4);
        return ((long) r8.getInt()) & QesdkUtils.LIMITS.UINT_32_UPPER;
    }
}
