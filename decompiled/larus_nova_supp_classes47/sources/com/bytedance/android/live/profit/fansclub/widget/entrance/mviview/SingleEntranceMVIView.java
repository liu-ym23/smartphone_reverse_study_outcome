package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import eu0.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleEntranceMVIView extends com.bytedance.android.anya.e<eu0.j, m0, eu0.h> {
    public final View k;
    public final ViewGroup l;
    public final ViewGroup m;
    public final ViewGroup n;
    public final Collection<com.bytedance.android.anya.z<m0, ?, ?>> o;
    public final Context p;
    public final DataCenter q;
    public final ViewGroup r;

    public final void g() {
        this.n.setOnClickListener(new w0(new SingleEntranceMVIView$onAttach$1(this), 1000));
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(this.q);
        if (r0 == null) goto L5;
        boolean r1 = r0.A();
    L6:
        ViewGroup r2 = this.n;
        if (r1 == false) goto L9;
        int r3 = 2131919998;
    L10:
        r3.c(r2, s1.B(r3), true);
        return;
    L9:
        r3 = 2131919999;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final Context getContext() {
        return this.p;
    }

    public final Collection<com.bytedance.android.anya.z<m0, ?, ?>> p() {
        return this.o;
    }

    public final void a(com.bytedance.android.anya.dsl.f<eu0.j> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleEntranceMVIView$bindToParent$1 r0 = SingleEntranceMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean r(com.bytedance.android.anya.a0 r2, Function1<? super com.bytedance.android.anya.a0, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Intrinsics.checkNotNullParameter(r3, "dispatchEffect");
        if (this.r.getVisibility() == 0) goto L7;
        return false;
    L7:
        return ((Boolean) r3.invoke(r2)).booleanValue();
    }

    public final void q(com.bytedance.android.anya.k r4, MVIState r5, Function1 r6) {
        m0 r7 = (m0) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r6, "dispatchDiff");
        r0<m0, Boolean> r0 = r7.getShow();
        Object r1 = r4.c.a(r0);
        if (r1 == null) goto L8;
        r4.b.a.invoke(r0);
        if (((Boolean) r1).booleanValue() == false) goto L7;
        this.r.setVisibility(0);
        goto L8
    L7:
        this.r.setVisibility(8);
    L8:
        com.bytedance.android.anya.internal.r r8 = r7.b;
        KProperty r2 = m0.g[1];
        r8.getClass();
        Object r3 = r4.c.a(r8);
        if (r3 == null) goto L23;
        r4.b.a.invoke(r8);
        if (((Boolean) r3).booleanValue() == false) goto L23;
        fu0.b.a(this.q);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r9 = fu0.b.a(this.q);
        if (r9 != null) goto L15;
    L17:
        fu0.b.a(this.q);
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r10 = fu0.b.a(this.q);
        if (r10 != null) goto L20;
    L22:
        int r12 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.k(this.q);
        goto L23
    L20:
        if (r10.F() != true) goto L22;
        int r13 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.g(this.q);
        goto L23
    L15:
        if (r9.K() != true) goto L17;
        int r14 = com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.a;
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.j.m(this.q);
    L23:
        r6.invoke(r4);
    }

    public SingleEntranceMVIView(Context r6, DataCenter r7, ViewGroup r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "containerView");
        this.p = r6;
        this.q = r7;
        this.r = r8;
        View r10 = LayoutInflater.from(r6).inflate(2131567561, r8, true);
        this.k = r10;
        ViewGroup r0 = (ViewGroup) r10.findViewById(2131386670);
        this.l = r0;
        ViewGroup r1 = (ViewGroup) r10.findViewById(2131386654);
        this.m = r1;
        ViewGroup r12 = (ViewGroup) r10.findViewById(2131386686);
        this.n = r12;
        this.o = CollectionsKt.listOf(new com.bytedance.android.anya.d[]{new SingleLiveFansClubMVIView(r6, r7, r0, r9), new SingleEcomFansClubMVIView(r6, r7, r1, r9), new SingleVipMVIView(r6, r7, r12), new SingleCommonVipMVIView(r6, r12)});
    }
}
