package com.bytedance.badger.t;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final int a;
    public final List b;
    public final byte[] c;

    public d(int r1, List r2, byte[] r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final l b(int r2) {
        int r3 = r2 + 2;
        if (r3 < this.b.size()) goto L7;
        return null;
    L7:
        return (l) ListProtector.get(this.b, r3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(d.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L24;
        d r6 = (d) r5;
        if (this.a == r6.a) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.b, r6.b)) == false) goto L20;
        return false;
    L20:
        if (Arrays.equals(this.c, r6.c) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.NativeResult");
    L8:
        r2 = null;
        goto L10
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.c);
    }

    public final String toString() {
        return "NativeResult(eventId=" + this.a + ", nodes=" + this.b + ", rawPayload=" + Arrays.toString(this.c) + ")";
    }

    public final boolean e() {
        if ((!this.b.isEmpty()) == true) goto L5;
    L13:
        return false;
    L5:
        if ((ListProtector.get(this.b, 0) instanceof g) == false) goto L13;
        Object r0 = ListProtector.get(this.b, 0);
        if (r0 == null) goto L12;
        if (((g) r0).a != 0) goto L13;
        return true;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.IntVal");
    }

    public static boolean f(d r2) {
        l r3 = r2.b(0);
        if ((r3 instanceof e) == true) goto L5;
        return false;
    L5:
        return ((e) r3).a;
    }

    public final List d(Function1 r7) {
        l r1 = b(0);
    L17:
        e = move-exception;
        com.bytedance.badger.e.e("NativeResult", "Failed to convert TLVNode to object list: " + e.getMessage());
        return CollectionsKt.emptyList();
    L4:
        if ((r1 instanceof h) == false) goto L28;
        List r2 = ((h) r1).a;     // Catch: Exception -> L17
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L17
        Iterator r4 = r2.iterator();     // Catch: Exception -> L17
    L7:
        if (r4.hasNext() == false) goto L29;
        n r5 = (n) r7.invoke((l) r4.next());     // Catch: Exception -> L11
    L13:
        if (r5 == null) goto L7;
        r3.add(r5);     // Catch: Exception -> L17
        goto L7
    L11:
        e = move-exception;
        com.bytedance.badger.e.e("NativeResult", "Failed to convert list item to object: " + e.getMessage());     // Catch: Exception -> L17
        r5 = null;
        goto L13
    L29:
        return r3;
    L28:
        return CollectionsKt.emptyList();
    }

    public static int a(d r2, int r3, int r4) {
        int r1 = 0;
        if ((r4 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r1 = -1;
    L8:
        l r5 = r2.b(r3);
        if ((r5 instanceof g) == true) goto L11;
        return r1;
    L11:
        return ((g) r5).a;
    }

    public static String c(d r1, int r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        String r4 = "";
    L9:
        l r5 = r1.b(r2);
        if ((r5 instanceof k) == true) goto L12;
        return r4;
    L12:
        return ((k) r5).a;
    L8:
        r4 = null;
        goto L9
    }
}
