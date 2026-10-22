package com.bytedance.gkfs.io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f4898a = null;

    static {
        f4898a = new char[]{'G', 'K', 'F', 'S'};
    }

    public static final int a(byte[] r5, int r10) {
        int r11 = UInt.m219constructorimpl(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) (r5[r10] & UByte.MAX_VALUE)) & UByte.MAX_VALUE) << 24);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.b(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) (r5[r10 + 1] & UByte.MAX_VALUE)) & UByte.MAX_VALUE) << 16, r11);
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.b(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) (r5[r10 + 2] & UByte.MAX_VALUE)) & UByte.MAX_VALUE) << 8, r12);
        return androidx.room.jarjarred.org.antlr.runtime.a.b(UByte.m142constructorimpl((byte) (r5[r10 + 3] & UByte.MAX_VALUE)) & UByte.MAX_VALUE, r13);
    }

    public static m b(File r19, File r20, Throwable r21, GkFSError r22) {
        return new m(new j(r20, new k(0, 0, 7), CollectionsKt.emptyList()), r19, com.bytedance.gkfs.cdc.c.g, new l(new n(false, r21, r22), 0, 0, null, 0, 0, 0, 254));
    }

    public static Pair c(FileInputStream r10, com.bytedance.gkfs.d r11) {
        byte[] r5 = new byte[15];
        int r12 = r10.read(r5);
        if (r12 < 15) goto L31;
        ByteArrayInputStream r13 = new ByteArrayInputStream(r5);
        char[] r14 = f4898a;
        int r15 = 0;
    L6:
        if (r15 >= 4) goto L12;
        char r16 = r14[r15];
        char r17 = (char) r13.read();
        if (r17 != r16) goto L11;
        r15 = r15 + 1;
        goto L6
    L11:
        throw new IOException("Read unexpected magic number value " + r17 + " in index " + r15 + ", " + r16 + " is correct!");
    L12:
        int r18 = r13.read();
        if (r18 < 1) goto L29;
        long r19 = ULong.m298constructorimpl(ULong.m298constructorimpl(255 & ((long) UByte.m142constructorimpl((byte) r13.read()))) + ULong.m298constructorimpl(ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 8) + ULong.m298constructorimpl(ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 16) + ULong.m298constructorimpl(ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 24) + ULong.m298constructorimpl(ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 32) + ULong.m298constructorimpl(ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 40) + ULong.m298constructorimpl(ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 48) + ULong.m298constructorimpl(ULong.m298constructorimpl(((long) UByte.m142constructorimpl((byte) r13.read())) & 255) << 56))))))));
        if (r19 <= 0) goto L27;
        int r20 = UShort.m405constructorimpl((short) androidx.room.jarjarred.org.antlr.runtime.a.b(UByte.m142constructorimpl((byte) r13.read()) & UByte.MAX_VALUE, UInt.m219constructorimpl(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) r13.read()) & UByte.MAX_VALUE) << 8))) & UShort.MAX_VALUE;
        if (r20 <= 0) goto L25;
        int r21 = r20 * 44;
        byte[] r22 = new byte[r21];
        int r110 = r10.read(r22);
        if (r110 < r21) goto L23;
        return TuplesKt.to(new k(r18, r19, r21 + 15), new h(r22, r20, r11));
    L23:
        throw new IOException(com.lynx.tasm.base.h.b(r21, r110, "read chunks info failed, except ", " but received "));
    L25:
        throw new IOException("Invalid chunk count " + r20 + '!');
    L27:
        throw new IOException("origin size from header is " + r19 + '!');
    L29:
        throw new IOException(com.lynx.jsbridge.a.d(r18, "Minimum version of SDK be able to support is 1, but file version is "));
    L31:
        throw new IOException(com.lynx.jsbridge.a.d(r12, "read header meta failed, except  15 but received "));
    }

    public static void d(FileOutputStream r16, long r17, ArrayList r19) {
        CharIterator r11 = ArrayIteratorsKt.iterator(f4898a);
    L4:
        if (r11.hasNext() == false) goto L6;
        r16.write(r11.next().charValue());
        goto L4
    L6:
        r16.write(1);
        r16.write(new byte[]{(byte) (r17 >>> 56), (byte) (r17 >>> 48), (byte) (r17 >>> 40), (byte) (r17 >>> 32), (byte) (r17 >>> 24), (byte) (r17 >>> 16), (byte) (r17 >>> 8), (byte) r17});
        int r5 = r19.size();
        r16.write(new byte[]{(byte) (r5 >>> 8), (byte) r5});
        Iterator r10 = r19.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        f r12 = (f) r10.next();
        String r13 = r12.f4865a.f4858a;
        if (r13 == null) goto L16;
        char[] r14 = r13.toCharArray();
        int r15 = r14.length;
        int r18 = 0;
    L12:
        if (r18 >= r15) goto L14;
        r16.write(r14[r18]);
        r18 = r18 + 1;
        goto L12
    L14:
        int r20 = (int) r12.f4866b;
        r16.write(new byte[]{(byte) (r20 >>> 24), (byte) (r20 >>> 16), (byte) (r20 >>> 8), (byte) r20});
        goto L8
    L16:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
