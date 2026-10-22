package lf;

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
import kotlin.UByte;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileChannel f19606a;

    public c(File r5) {
        if (r5.exists() == false) goto L7;
        this.f19606a = new FileInputStream(r5).getChannel();
        return;
    L7:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public final List b() {
        FileChannel r5 = this.f19606a;
        r5.position(0);
        ArrayList r10 = new ArrayList();
        r5.position(0);
        ByteBuffer r11 = ByteBuffer.allocate(8);
        ByteOrder r12 = ByteOrder.LITTLE_ENDIAN;
        r11.order(r12);
        if (f(r11, 0) != 1179403647) goto L94;
        d(4, r11, 1);
        short r13 = (short) (r11.get() & UByte.MAX_VALUE);
        d(5, r11, 1);
        if (((short) (r11.get() & UByte.MAX_VALUE)) != 2) goto L7;
        boolean r14 = true;
    L8:
        if (r13 != 1) goto L10;
        b r15 = new b(r14, this, 0);
    L12:
        ByteBuffer r16 = ByteBuffer.allocate(8);
        if (r15.f19603a == false) goto L15;
        r12 = ByteOrder.BIG_ENDIAN;
    L15:
        r16.order(r12);
        long r17 = r15.e;
        if (r17 == WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L18;
    L30:
        long r18 = 0;
    L32:
        if (r18 >= r17) goto L37;
        d r19 = r15.a(r18);
        if (r19.f19607a == 2) goto L35;
        r18 = r18 + 1;
        goto L32
    L35:
        long r20 = r19.f19608b;
    L39:
        if (r20 == 0) goto L41;
        ArrayList r110 = new ArrayList();
        long r111 = 0;
        int r112 = 0;
    L44:
        switch(r15.f) {
            case 0: goto L50;
            default: goto L45;
        };
    L45:
        a r21 = new a();
        ByteBuffer r113 = ByteBuffer.allocate(8);
        if (r15.f19603a == false) goto L48;
        ByteOrder r114 = ByteOrder.BIG_ENDIAN;
    L49:
        r113.order(r114);
        long r22 = ((long) (r112 * 16)) + r20;
        c r115 = r15.g;
        r115.d(r22, r113, 8);
        r21.f19601a = r113.getLong();
        r115.d(r22 + 8, r113, 8);
        r21.f19602b = r113.getLong();
    L55:
        long r23 = r21.f19601a;
        if (r23 != 1) goto L59;
        r110.add(Long.valueOf(r21.f19602b));
    L61:
        r111 = r111;
    L62:
        r112 = r112 + 1;
        if (r21.f19601a == 0) goto L65;
        r10 = r10;
        goto L44
    L65:
        if (r111 == 0) goto L89;
        long r24 = 0;
    L68:
        if (r24 >= r17) goto L87;
        d r25 = r15.a(r24);
        if (r25.f19607a != 1) goto L85;
        long r26 = r25.f19609c;
        if (r26 > r111) goto L85;
        if (r111 > (r25.d + r26)) goto L85;
        long r116 = (r111 - r26) + r25.f19608b;
        Iterator r27 = r110.iterator();
    L77:
        if (r27.hasNext() == false) goto L84;
        long r28 = ((Long) r27.next()).longValue() + r116;
        StringBuilder r29 = new StringBuilder();
    L79:
        long r30 = r28 + 1;
        d(r28, r16, 1);
        short r31 = (short) (r16.get() & UByte.MAX_VALUE);
        if (r31 == 0) goto L82;
        r29.append((char) r31);
        r28 = r30;
        goto L79
    L82:
        ArrayList r32 = r10;
        r32.add(r29.toString());
        r10 = r32;
        goto L77
    L84:
        return r10;
    L85:
        r24 = r24 + 1;
        r10 = r10;
        goto L68
    L87:
        throw new IllegalStateException("Could not map vma to file offset!");
    L89:
        throw new IllegalStateException("String table offset not found!");
    L59:
        if (r23 != 5) goto L61;
        r111 = r21.f19602b;
        goto L62
    L48:
        r114 = ByteOrder.LITTLE_ENDIAN;
        goto L49
    L50:
        r21 = new a();
        ByteBuffer r33 = ByteBuffer.allocate(4);
        if (r15.f19603a == false) goto L53;
        ByteOrder r34 = ByteOrder.BIG_ENDIAN;
    L54:
        r33.order(r34);
        long r117 = ((long) (r112 * 8)) + r20;
        c r35 = r15.g;
        r21.f19601a = r35.f(r33, r117);
        r21.f19602b = r35.f(r33, r117 + 4);
        goto L55
    L53:
        r34 = ByteOrder.LITTLE_ENDIAN;
        goto L54
    L41:
        return Collections.unmodifiableList(r10);
    L37:
        r20 = 0;
        goto L39
    L18:
        switch(r15.f) {
            case 0: goto L24;
            default: goto L19;
        };
    L19:
        e r36 = new e();
        ByteBuffer r37 = ByteBuffer.allocate(8);
        if (r15.f19603a == false) goto L22;
        ByteOrder r118 = ByteOrder.BIG_ENDIAN;
    L23:
        r37.order(r118);
        r36.f19610a = r15.g.f(r37, (r15.f19605c + ((long) 0)) + 44);
    L29:
        r17 = r36.f19610a;
        goto L30
    L22:
        r118 = ByteOrder.LITTLE_ENDIAN;
        goto L23
    L24:
        r36 = new e();
        ByteBuffer r38 = ByteBuffer.allocate(4);
        if (r15.f19603a == false) goto L27;
        ByteOrder r119 = ByteOrder.BIG_ENDIAN;
    L28:
        r38.order(r119);
        r36.f19610a = r15.g.f(r38, (r15.f19605c + ((long) 0)) + 28);
        goto L29
    L27:
        r119 = ByteOrder.LITTLE_ENDIAN;
        goto L28
    L10:
        if (r13 != 2) goto L92;
        r15 = new b(r14, this, 1);
        goto L12
    L92:
        throw new IllegalStateException("Invalid class type!");
    L7:
        r14 = false;
        goto L8
    L94:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f19606a.close();
    }

    public final void d(long r10, ByteBuffer r11, int r12) {
        r11.position(0);
        r11.limit(r12);
        long r5 = 0;
    L4:
        if (r5 >= r12) goto L10;
        int r13 = this.f19606a.read(r11, r10 + r5);
        if (r13 == (-1)) goto L9;
        r5 = r5 + ((long) r13);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r11.position(0);
    }

    public final int e(ByteBuffer r5, long r10) {
        d(r10, r5, 2);
        return r5.getShort() & UShort.MAX_VALUE;
    }

    public final long f(ByteBuffer r5, long r10) {
        d(r10, r5, 4);
        return ((long) r5.getInt()) & 4294967295L;
    }
}
