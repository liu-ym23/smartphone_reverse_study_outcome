package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OpenCustomBuyPage;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftPanelEffect;", "schemaUrl", BuildConfig.FLAVOR, "(Ljava/lang/String;)V", "getSchemaUrl", "()Ljava/lang/String;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenCustomBuyPage implements GiftPanelEffect {
    private final String schemaUrl;

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public OpenCustomBuyPage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "schemaUrl");
        this.schemaUrl = r2;
    }
}
