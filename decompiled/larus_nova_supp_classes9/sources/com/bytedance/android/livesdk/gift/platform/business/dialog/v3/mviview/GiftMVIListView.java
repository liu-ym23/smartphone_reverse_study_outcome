package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIListView extends com.bytedance.android.anya.e<GiftPanelState, GiftListViewState, GiftAction> {
    public final Collection<com.bytedance.android.anya.z<GiftListViewState, ?, ?>> k;
    public final ViewGroup l;
    public final ViewGroup m;
    public final Function0<Boolean> n;

    public final Collection<com.bytedance.android.anya.z<GiftListViewState, ?, ?>> p() {
        return this.k;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIListView$bindToParent$1 r0 = GiftMVIListView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIListView(Context r2, ViewGroup r3, ViewGroup r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "currentContext");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "parentView");
        Intrinsics.checkNotNullParameter(r5, "animationFun");
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.k = CollectionsKt.listOf(new GiftMVIVerticalListView(r2, r3, r4, r5));
    }
}
