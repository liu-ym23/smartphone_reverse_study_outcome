package com.bytedance.bpea.entry.api.device.info;

import android.telecom.TelecomManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelecomManagerEntry$Companion$showInCallScreenUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $showDialpad;
    final /* synthetic */ TelecomManager $this_showInCallScreenUnsafe;

    public TelecomManagerEntry$Companion$showInCallScreenUnsafe$1(TelecomManager r1, boolean r2) {
        this.$this_showInCallScreenUnsafe = r1;
        this.$showDialpad = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1639invoke() {
        this.$this_showInCallScreenUnsafe.showInCallScreen(this.$showDialpad);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1639invoke();
        return Unit.INSTANCE;
    }
}
