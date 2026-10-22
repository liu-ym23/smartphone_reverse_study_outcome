package com.bytedance.badger.monitor;

import c74.a;
import com.bytedance.badger.t.e;
import com.bytedance.badger.t.g;
import com.bytedance.badger.t.i;
import com.bytedance.badger.t.j;
import com.bytedance.badger.t.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class b extends Lambda implements Function1 {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
        super(1);
    }

    public Object invoke(Object r17) {
        l r0 = (l) r17;
        if ((r0 instanceof j) == false) goto L42;
        j r1 = (j) r0;
        if (r1.a.size() < 6) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L40;
        Object r3 = ListProtector.get(r1.a, 0);
        if (r3 == null) goto L38;
        int r6 = ((g) r3).a;
        Object r4 = ListProtector.get(r1.a, 1);
        if (r4 == null) goto L36;
        long r7 = ((i) r4).a;
        Object r5 = ListProtector.get(r1.a, 2);
        if (r5 == null) goto L34;
        long r9 = ((i) r5).a;
        Object r8 = ListProtector.get(r1.a, 3);
        if (r8 == null) goto L32;
        long r12 = ((i) r8).a;
        Object r10 = ListProtector.get(r1.a, 4);
        if (r10 == null) goto L30;
        boolean r13 = ((e) r10).a;
        Object r14 = ListProtector.get(r1.a, 5);
        if (r14 == null) goto L28;
        boolean r15 = ((e) r14).a;
        Object r16 = ListProtector.get(r1.a, 6);
        if (r16 == null) goto L26;
        return new a(r6, r7, r9, r12, r13, r15, ((e) r16).a);
    L26:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.BoolVal");
    L28:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.BoolVal");
    L30:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.BoolVal");
    L32:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.LongVal");
    L34:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.LongVal");
    L36:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.LongVal");
    L38:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.IntVal");
    L40:
        throw new IllegalArgumentException("Insufficient fields in node".toString());
    L7:
        r2 = false;
        goto L8
    L42:
        throw new IllegalArgumentException("Expected ObjectVal node".toString());
    }
}
