package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.base.model.message.c5;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final String a;
    public final String b;
    public final Map<String, c5> c;
    public final String d;
    public final float e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;
    public final Function1<Throwable, Unit> h;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L20;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.e, r4.e) == 0) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, c5> r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + Float.floatToIntBits(this.e)) * 31;
        Function0<Unit> r10 = this.f;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Function0<Unit> r14 = this.g;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Function1<Throwable, Unit> r17 = this.h;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
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
        return "DressPlayData { playId=" + this.a + ", dressId=" + this.b + ", centerY=" + this.e + " }";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, Map<String, ? extends c5> r3, String r4, float r5, Function0<Unit> r6, Function0<Unit> r7, Function1<? super Throwable, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "dressId");
        Intrinsics.checkNotNullParameter(r4, "userAvatar");
        Intrinsics.checkNotNullParameter(r6, "onClick");
        Intrinsics.checkNotNullParameter(r7, "onFinish");
        Intrinsics.checkNotNullParameter(r8, "onError");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        StringBuilder r9 = new StringBuilder();
        r9.append(ThreadMethodProxy.currentThread().getId());
        r9.append(':');
        r9.append(System.nanoTime());
        this.a = r9.toString();
    }
}
