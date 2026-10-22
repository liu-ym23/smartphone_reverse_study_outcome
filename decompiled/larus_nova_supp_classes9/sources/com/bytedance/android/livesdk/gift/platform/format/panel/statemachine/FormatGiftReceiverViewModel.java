package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.GiftReceiverStateHelperKt;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FormatGiftReceiverViewModel extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements l, o {
    public static final /* synthetic */ int g = 0;
    public final vlc.d e;
    public final StateMachine<com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> f;

    public static final class a {
    }

    static {
    }

    public final void onMessage(tlc.d r1) {
    }

    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void a() {
        super.a();
        vlc.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public final void onStop() {
        a();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r0 = this.f;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    public FormatGiftReceiverViewModel(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super((LifecycleOwner) r2);
        this.e = (vlc.d) r3.get("data_message_manager");
        this.f = GiftReceiverStateHelperKt.a(new FormatGiftReceiverViewModel$receiverStateMachine$1(this));
    }
}
