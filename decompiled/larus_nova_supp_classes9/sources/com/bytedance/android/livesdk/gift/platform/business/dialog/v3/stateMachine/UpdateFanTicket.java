package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@TraceExclude
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateFanTicket;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UpdateFanTicket extends GiftRepoAction {
    private final JSONObject data;

    public final JSONObject getData() {
        return this.data;
    }

    public UpdateFanTicket(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super("UpdateFanTicket");
        this.data = r2;
    }
}
