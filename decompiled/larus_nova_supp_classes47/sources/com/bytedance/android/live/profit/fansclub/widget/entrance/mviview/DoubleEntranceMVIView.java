package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DoubleEntranceMVIView extends com.bytedance.android.anya.e<eu0.j, eu0.f, eu0.h> {
    public final View k;
    public final ViewGroup l;
    public final ViewGroup m;
    public final ViewGroup n;
    public final ViewGroup o;
    public final Collection<com.bytedance.android.anya.z<eu0.f, ?, ?>> p;
    public final Context q;
    public final DataCenter r;
    public final ViewGroup s;

    public final Context getContext() {
        return this.q;
    }

    public final Collection<com.bytedance.android.anya.z<eu0.f, ?, ?>> p() {
        return this.p;
    }

    public final void a(com.bytedance.android.anya.dsl.f<eu0.j> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        DoubleEntranceMVIView$bindToParent$1 r0 = DoubleEntranceMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean r(com.bytedance.android.anya.a0 r2, Function1<? super com.bytedance.android.anya.a0, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Intrinsics.checkNotNullParameter(r3, "dispatchEffect");
        if (this.s.getVisibility() == 0) goto L7;
        return false;
    L7:
        return ((Boolean) r3.invoke(r2)).booleanValue();
    }

    public DoubleEntranceMVIView(Context r7, DataCenter r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "containerView");
        this.q = r7;
        this.r = r8;
        this.s = r9;
        View r10 = LayoutInflater.from(r7).inflate(2131567552, r9, true);
        this.k = r10;
        ViewGroup r0 = (ViewGroup) r10.findViewById(2131377794);
        this.l = r0;
        ViewGroup r1 = (ViewGroup) r10.findViewById(2131377761);
        this.m = r1;
        ViewGroup r3 = (ViewGroup) r10.findViewById(2131384643);
        this.n = r3;
        ViewGroup r12 = (ViewGroup) r10.findViewById(2131384565);
        this.o = r12;
        this.p = CollectionsKt.listOf(new com.bytedance.android.anya.d[]{new LeftLiveFansClubMVIView(r7, r8, r0), new LeftEcomFansClubMVIView(r7, r8, r1), new RightVipMVIView(r7, r8, r3), new RightCommonVipMVIView(r7, r8, r12)});
    }

    public final void q(com.bytedance.android.anya.k r4, MVIState r5, Function1 r6) {
        eu0.f r7 = (eu0.f) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r6, "dispatchDiff");
        r0<eu0.f, Boolean> r0 = r7.getShow();
        Object r1 = r4.c.a(r0);
        if (r1 == null) goto L8;
        r4.b.a.invoke(r0);
        if (((Boolean) r1).booleanValue() == false) goto L7;
        this.s.setVisibility(0);
        goto L8
    L7:
        this.s.setVisibility(8);
    L8:
        com.bytedance.android.anya.internal.r r8 = r7.b;
        KProperty r2 = eu0.f.g[1];
        r8.getClass();
        Object r3 = r4.c.a(r8);
        if (r3 == null) goto L18;
        r4.b.a.invoke(r8);
        if (((Boolean) r3).booleanValue() == false) goto L18;
        fu0.b.a(this.r);
        int r9 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.m(this.r);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r10 = fu0.b.a(this.r);
        if (r10 != null) goto L15;
    L17:
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.k(this.r);
        goto L18
    L15:
        if (r10.F() != true) goto L17;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.g(this.r);
    L18:
        r6.invoke(r4);
    }
}
