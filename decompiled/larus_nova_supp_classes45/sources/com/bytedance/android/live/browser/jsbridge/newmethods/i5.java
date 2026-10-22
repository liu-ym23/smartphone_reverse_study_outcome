package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetVisualEventTrackingEditorResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getVisualEventTrackingEditor")
public final class i5 extends w20.x1<JsonObject, GetVisualEventTrackingEditorResultModel> {

    public static final class a {
    }

    static {
    }

    public i5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r4 = r3.getContext().getSharedPreferences("jsb_virtual_event_tracking_debug_settings", 0).getBoolean("switch_status", false);
        GetVisualEventTrackingEditorResultModel r5 = new GetVisualEventTrackingEditorResultModel();
        r5.a(GetVisualEventTrackingEditorResultModel.Code.Success);
        GetVisualEventTrackingEditorResultModel.a r0 = new GetVisualEventTrackingEditorResultModel.a();
        r0.a(Boolean.valueOf(r4));
        Unit r6 = Unit.INSTANCE;
        r5.b(r0);
        finishWithResult(r5);
    }
}
