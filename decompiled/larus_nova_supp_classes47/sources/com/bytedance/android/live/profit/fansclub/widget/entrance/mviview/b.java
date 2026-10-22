package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIComposableView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends BaseMVIComposableView<eu0.j, eu0.h> {
    public final Collection<com.bytedance.android.anya.z<eu0.j, ?, ?>> k;
    public final Context l;
    public final DataCenter m;
    public final ViewGroup n;
    public final View o;
    public final ViewGroup p;
    public final ViewGroup q;
    public final ViewGroup r;

    public final void i() {
        com.bytedance.android.live.profit.fansclub.widget.entrance.data.i r0 = fu0.b.a(this.m);
        if (r0 == null) goto L6;
        r0.d = false;
        return;
    }

    public final Context getContext() {
        return this.l;
    }

    public final Collection<com.bytedance.android.anya.z<eu0.j, ?, ?>> p() {
        return this.k;
    }

    public b(Context r3, DataCenter r4, ViewGroup r5, View r6, ViewGroup r7, ViewGroup r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "containerView");
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        this.q = r8;
        this.r = r9;
        if (r6 != null) goto L5;
        this.o = LayoutInflater.from(r3).inflate(2131567553, r5, true);
    L5:
        ViewGroup r10 = null;
        if (r7 != null) goto L12;
        View r12 = this.o;
        if (r12 == null) goto L10;
        ViewGroup r13 = (ViewGroup) r12.findViewById(2131373092);
    L11:
        this.p = r13;
        goto L12
    L10:
        r13 = null;
    L12:
        if (r8 != null) goto L18;
        View r14 = this.o;
        if (r14 == null) goto L16;
        ViewGroup r15 = (ViewGroup) r14.findViewById(2131386656);
    L17:
        this.q = r15;
        goto L18
    L16:
        r15 = null;
    L18:
        if (r9 != null) goto L23;
        View r16 = this.o;
        if (r16 == null) goto L22;
        r10 = (ViewGroup) r16.findViewById(2131370113);
    L22:
        this.r = r10;
    L23:
        ViewGroup r17 = this.p;
        if (r17 != null) goto L26;
    L30:
        List r18 = CollectionsKt.emptyList();
    L31:
        this.k = r18;
        return;
    L26:
        if (this.q == null) goto L30;
        if (this.r == null) goto L30;
        Intrinsics.checkNotNull(r17);
        ViewGroup r19 = this.q;
        Intrinsics.checkNotNull(r19);
        ViewGroup r20 = this.r;
        Intrinsics.checkNotNull(r20);
        r18 = CollectionsKt.listOf(new Object[]{new FollowMVIView(r3, r4, r17, false), new SingleEntranceMVIView(r3, r4, r19, false), new DoubleEntranceMVIView(r3, r4, r20)});
        goto L31
    }
}
