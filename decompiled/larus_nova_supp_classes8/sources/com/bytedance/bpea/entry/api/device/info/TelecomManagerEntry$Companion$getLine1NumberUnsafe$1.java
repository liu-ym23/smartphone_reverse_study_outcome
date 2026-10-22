package com.bytedance.bpea.entry.api.device.info;

import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class TelecomManagerEntry$Companion$getLine1NumberUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PhoneAccountHandle $accountHandle;
    final /* synthetic */ TelecomManager $this_getLine1NumberUnsafe;

    public TelecomManagerEntry$Companion$getLine1NumberUnsafe$1(TelecomManager r1, PhoneAccountHandle r2) {
        this.$this_getLine1NumberUnsafe = r1;
        this.$accountHandle = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1636invoke() {
        return this.$this_getLine1NumberUnsafe.getLine1Number(this.$accountHandle);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1636invoke();
    }
}
