package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m1 implements com.bytedance.android.scope.o, k1 {
    public m1() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.k1
    public final GiftReceiverViewState.Mode c() {
        return GiftReceiverViewState.Mode.Receiver;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.k1
    public final GiftOnlineReceiverMVIView a(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        return new GiftOnlineReceiverMVIView(r2, r3);
    }
}
