package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "updateUnreadCount")
public final class z7 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
    public z7() {
    }

    public final Object invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "callCtx");
        int r5 = JSONObjectProtectorUtils.getInt(r4, "count");
        Disposable r6 = om2.a.b;
        IHostDouyinIm r7 = TTLiveSDK.hostService().hostDouyinIm();
        if (r7 != null) goto L5;
    L9:
        om2.a.b(r5);
    L11:
        return Unit.INSTANCE;
    L5:
        if (r7.isAuthSuccess() != true) goto L9;
        if (((Boolean) LiveConfigSettingKeys.SHOW_DOUYIN_IM_ENTRANCE.getValue()).booleanValue() == false) goto L9;
        goto L9
    }
}
