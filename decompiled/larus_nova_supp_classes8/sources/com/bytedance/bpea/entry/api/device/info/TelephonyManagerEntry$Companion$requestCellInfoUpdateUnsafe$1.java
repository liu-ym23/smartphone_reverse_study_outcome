package com.bytedance.bpea.entry.api.device.info;

import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelephonyManagerEntry$Companion$requestCellInfoUpdateUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TelephonyManager.CellInfoCallback $callback;
    final /* synthetic */ Executor $executor;
    final /* synthetic */ TelephonyManager $this_requestCellInfoUpdateUnsafe;

    public TelephonyManagerEntry$Companion$requestCellInfoUpdateUnsafe$1(TelephonyManager r1, Executor r2, TelephonyManager.CellInfoCallback r3) {
        this.$this_requestCellInfoUpdateUnsafe = r1;
        this.$executor = r2;
        this.$callback = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1680invoke() {
        this.$this_requestCellInfoUpdateUnsafe.requestCellInfoUpdate(this.$executor, this.$callback);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1680invoke();
        return Unit.INSTANCE;
    }
}
