package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.content.Context;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OrderSongRequiredConfig {
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b a;
    public final Function3<String, TabLayout, Context, Unit> b;
    public final Function0<Unit> c;
    public final Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> d;

    public OrderSongRequiredConfig() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OrderSongRequiredConfig) == false) goto L14;
        OrderSongRequiredConfig r4 = (OrderSongRequiredConfig) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Function3<String, TabLayout, Context, Unit> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Function0<Unit> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r11 = this.d;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return r9 + r1;
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
        return "OrderSongRequiredConfig(commonOrderSongViewModel=" + this.a + ", fillCustomTabAction=" + this.b + ", fillFirstLevelTabArrayListAction=" + this.c + ", bindFirstLevelTabFragmentAction=" + this.d + ")";
    }

    public /* synthetic */ OrderSongRequiredConfig(int r4) {
        this(null, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrderSongRequiredConfig(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2, Function3<? super String, ? super TabLayout, ? super Context, Unit> r3, Function0<Unit> r4, Function1<? super List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "fillCustomTabAction");
        Intrinsics.checkNotNullParameter(r4, "fillFirstLevelTabArrayListAction");
        Intrinsics.checkNotNullParameter(r5, "bindFirstLevelTabFragmentAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
