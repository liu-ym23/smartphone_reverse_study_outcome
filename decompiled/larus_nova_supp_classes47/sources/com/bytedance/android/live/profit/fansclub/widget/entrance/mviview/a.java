package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIComposableView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends BaseMVIComposableView<eu0.j, eu0.h> {
    public final View k;
    public final ViewGroup l;
    public final ViewGroup m;
    public final ViewGroup n;
    public final ViewGroup o;
    public final Context p;
    public final DataCenter q;
    public final ViewGroup r;
    public final boolean s;
    public final boolean t;

    public final void i() {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(this.q);
        if (r0 == null) goto L6;
        r0.d = false;
        return;
    }

    public final Collection<com.bytedance.android.anya.z<eu0.j, ?, ?>> p() {
        if (this.t == true) goto L6;
        UtilityKotlinExtentionsKt.t(this.m);
        UtilityKotlinExtentionsKt.t(this.n);
        return CollectionsKt.listOf(new com.bytedance.android.anya.d[]{new FollowMVIView(this.p, this.q, this.l, this.s), new TipMVIView(this.p, this.q, this.o)});
    L6:
        UtilityKotlinExtentionsKt.w(this.m);
        UtilityKotlinExtentionsKt.w(this.n);
        return CollectionsKt.listOf(new Object[]{new FollowMVIView(this.p, this.q, this.l, this.s), new SingleEntranceMVIView(this.p, this.q, this.m, this.s), new DoubleEntranceMVIView(this.p, this.q, this.n), new TipMVIView(this.p, this.q, this.o)});
    }

    public final Context getContext() {
        return this.p;
    }

    public a(Context r2, DataCenter r3, ViewGroup r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        this.p = r2;
        this.q = r3;
        this.r = r4;
        this.s = r5;
        this.t = r6;
        LayoutInflater r7 = LayoutInflater.from(r2);
        if (r5 == false) goto L5;
        int r8 = 2131567555;
    L6:
        View r9 = r7.inflate(r8, r4, true);
        this.k = r9;
        this.l = (ViewGroup) r9.findViewById(2131373092);
        this.m = (ViewGroup) r9.findViewById(2131386656);
        this.n = (ViewGroup) r9.findViewById(2131370113);
        this.o = (ViewGroup) r9.findViewById(2131388722);
        return;
    L5:
        r8 = 2131567553;
        goto L6
    }
}
