package com.bytedance.bpea.entry.api.device.info;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
final class SettingsEntry$Companion$getOAIDUnsafe$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Context $context;

    public SettingsEntry$Companion$getOAIDUnsafe$1(Context r1) {
        this.$context = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1626invoke() {
        return Settings.Global.getString(this.$context.getContentResolver(), "pps_oaid");
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1626invoke();
    }
}
