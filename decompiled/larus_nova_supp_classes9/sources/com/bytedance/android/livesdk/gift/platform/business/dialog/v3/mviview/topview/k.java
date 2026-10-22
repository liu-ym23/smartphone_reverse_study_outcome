package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements l1, com.bytedance.android.scope.o {
    public k() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1
    public final int a() {
        return 2131369256;
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1
    public final GiftTopViewState.Mode c() {
        return GiftTopViewState.Mode.DIY;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1
    public final BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?> d(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        return new GiftMVIDIYTopView(r2, r3);
    }
}
