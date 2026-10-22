package com.bytedance.bpea.entry.api.device.info;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelephonyManagerEntry$Companion$listenUnsafe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $events;
    final /* synthetic */ PhoneStateListener $listener;
    final /* synthetic */ TelephonyManager $this_listenUnsafe;

    public TelephonyManagerEntry$Companion$listenUnsafe$1(TelephonyManager r1, PhoneStateListener r2, int r3) {
        this.$this_listenUnsafe = r1;
        this.$listener = r2;
        this.$events = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1679invoke() {
        this.$this_listenUnsafe.listen(this.$listener, this.$events);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1679invoke();
        return Unit.INSTANCE;
    }
}
