package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FormatGiftTabViewModel extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements o {
    public final StateMachine<GiftStateMachineConfig.h, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> e;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        a();
    }

    public FormatGiftTabViewModel(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super((LifecycleOwner) r2);
        int r3 = GiftStateMachineConfig.a;
        this.e = GiftStateMachineConfig.c(new FormatGiftTabViewModel$tabStateMachine$1(this));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<GiftStateMachineConfig.h, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r0 = this.e;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }
}
