package com.ss.ugc.effectplatform.preload;

import java.util.List;
import java.util.ListIterator;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final String g = null;
    public static final a h = null;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final long e;
    public final String f;

    public static final class a {
        public a() {
        }

        public static String[] a(String r4) {
            List r5 = new Regex(c.g).split(r4, 0);
            if (r5.isEmpty() == true) goto L13;
            ListIterator r1 = r5.listIterator(r5.size());
        L6:
            if (r1.hasPrevious() == false) goto L13;
            if (((String) r1.previous()).length() != 0) goto L10;
            boolean r2 = true;
        L11:
            if (r2 == true) goto L6;
            List r6 = CollectionsKt.take(r5, r1.nextIndex() + 1);
        L14:
            Object[] r7 = r6.toArray(new String[0]);
            if (r7 == null) goto L19;
            return (String[]) r7;
        L19:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        L10:
            r2 = false;
        L13:
            r6 = CollectionsKt.emptyList();
            goto L14
        }
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L18;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        long r13 = this.e;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        String r15 = this.f;
        if (r15 == null) goto L22;
        r1 = r15.hashCode();
    L22:
        return r14 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PreloadDbBean(file_name=" + this.a + ", resource_key=" + this.b + ", uri=" + this.c + ", res_name=" + this.d + ", last_access_time=" + this.e + ", businessKey=" + this.f + ")";
    }

    static {
        h = new a();
        g = ",";
    }

    public c(String r1, String r2, String r3, String r4, long r5, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
    }
}
