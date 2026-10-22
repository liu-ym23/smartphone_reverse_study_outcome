package com.bytedance.gkfs.io;

import ai.j0;
import java.security.MessageDigest;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4857b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4858a;

    static {
        f4857b = new c(StringsKt.D(40, "f"));
    }

    public c(String r5) {
        this.f4858a = r5;
        if (r5.length() != 40) goto L5;
        return;
    L5:
        StringBuilder r10 = com.lynx.tasm.utils.e.b("Invalid identifier:", r5, ", except size is 40 but receive ");
        r10.append(r5.length());
        throw new IllegalArgumentException(r10.toString());
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        String r10 = ((c) r5).f4858a;
        if (Intrinsics.areEqual(this.f4858a, r10) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f4858a.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("ChunkIdentifier("), this.f4858a, ')');
    }

    public c(final cb.a r10, int r11) {
        int r5 = 0;
        if (r11 == r10.f1168c) goto L13;
        Function1<Integer, Byte> r12 = new ChunkIdentifier$Companion$computeHash$bytes$1(r10);
        cb.a r13 = new cb.a(r11);
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L12;
        byte r15 = ((Number) r12.invoke(Integer.valueOf(r14))).byteValue();
        int r16 = r13.f1168c;
        if (r14 >= r16) goto L10;
        int r17 = r14 / 4096;
        ((byte[]) r13.f1167b.get(r17))[r14 - (r17 * 4096)] = r15;
        r14 = r14 + 1;
        goto L6
    L10:
        StringBuilder r18 = com.lynx.tasm.p.d(r14, "index ", " is larger than array size ");
        r18.append(r16);
        throw new IndexOutOfBoundsException(r18.toString());
    L12:
        r10 = r13;
    L13:
        MessageDigest r19 = MessageDigest.getInstance("SHA-1");
        Iterator r20 = r10.f1167b.iterator();
    L15:
        if (r20.hasNext() == false) goto L17;
        r19.update((byte[]) r20.next());
        goto L15
    L17:
        byte[] r21 = r19.digest();
        if (r21 == null) goto L27;
        if (r21.length == 0) goto L27;
        StringBuffer r22 = new StringBuffer(r21.length * 2);
        int r23 = r21.length;
    L22:
        if (r5 >= r23) goto L24;
        byte r24 = r21[r5];
        char[] r25 = com.bytedance.gkfs.cdc.d.f4828a;
        r22.append(r25[(r24 & 240) >> 4]);
        r22.append(r25[r24 & 15]);
        r5 = r5 + 1;
        goto L22
    L24:
        this(r22.toString());
        return;
    L27:
        throw new NullPointerException("bytes array MUST not be NULL!");
    }
}
