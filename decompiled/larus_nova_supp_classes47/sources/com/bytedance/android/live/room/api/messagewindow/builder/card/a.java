package com.bytedance.android.live.room.api.messagewindow.builder.card;

import android.content.Context;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final DataCenter a;
    public final Object b;
    public final int c;
    public final Context d;
    public final MsgWindowPosition e;
    public final Function1<CardMountingsBuilder.ContainerBuilder, Unit> f;
    public final Function1<CardMountingsBuilder.b, Unit> g;
    public final Function1<CardMountingsBuilder.d, Unit> h;
    public final Function1<CardMountingsBuilder.a, Unit> i;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L24;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        DataCenter r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.c) * 31;
        Context r7 = this.d;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        MsgWindowPosition r10 = this.e;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Function1<CardMountingsBuilder.ContainerBuilder, Unit> r14 = this.f;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        Function1<CardMountingsBuilder.b, Unit> r17 = this.g;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        Function1<CardMountingsBuilder.d, Unit> r20 = this.h;
        if (r20 == null) goto L29;
        int r22 = r20.hashCode();
    L30:
        int r23 = (r19 + r22) * 31;
        Function1<CardMountingsBuilder.a, Unit> r24 = this.i;
        if (r24 == null) goto L34;
        r1 = r24.hashCode();
    L34:
        return r23 + r1;
    L29:
        r22 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
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
        return "CardMountings(dataCenter=" + this.a + ", identity=" + this.b + ", priority=" + this.c + ", context=" + this.d + ", position=" + this.e + ", containerBuilderInit=" + this.f + ", lifeCycleBuilderInit=" + this.g + ", strategyBuilderInit=" + this.h + ", argsBuilderInit=" + this.i + ")";
    }

    public final Context getContext() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(DataCenter r2, Object r3, int r4, Context r5, MsgWindowPosition r6, Function1<? super CardMountingsBuilder.ContainerBuilder, Unit> r7, Function1<? super CardMountingsBuilder.b, Unit> r8, Function1<? super CardMountingsBuilder.d, Unit> r9, Function1<? super CardMountingsBuilder.a, Unit> r10) {
        Intrinsics.checkNotNullParameter(r3, "identity");
        Intrinsics.checkNotNullParameter(r6, "position");
        Intrinsics.checkNotNullParameter(r7, "containerBuilderInit");
        Intrinsics.checkNotNullParameter(r8, "lifeCycleBuilderInit");
        Intrinsics.checkNotNullParameter(r9, "strategyBuilderInit");
        Intrinsics.checkNotNullParameter(r10, "argsBuilderInit");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
