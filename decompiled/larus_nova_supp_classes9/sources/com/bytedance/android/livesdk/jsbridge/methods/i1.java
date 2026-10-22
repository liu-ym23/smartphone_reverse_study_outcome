package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveRunAiServiceResultModel;
import com.bytedance.android.livesdkapi.ai.callback.IAiCallback;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i1 implements IAiCallback {
    public final /* synthetic */ j1 a;
    public final /* synthetic */ LiveRunAiServiceResultModel b;

    public final void onCompleted(JSONObject r5) {
        this.a.getClass();
        String r1 = null;
        j1.j("ai result", null);
        this.b.c(LiveRunAiServiceResultModel.Code.Success);
        LiveRunAiServiceResultModel r0 = this.b;
        if (r5 == null) goto L7;
        JSONObject r2 = r5.optJSONObject("result");
        if (r2 == null) goto L7;
        JsonObject r3 = this.a.l(r2);
    L8:
        r0.setResult(r3);
        LiveRunAiServiceResultModel r4 = this.b;
        if (r5 == null) goto L11;
        Integer r6 = Integer.valueOf(r5.optInt("result_code"));
    L12:
        r4.e(r6);
        if (Intrinsics.areEqual(this.b.b(), 0) == false) goto L15;
        this.a.getClass();
        j1.j("ai success", null);
    L21:
        LiveRunAiServiceResultModel r7 = this.b;
        if (r5 == null) goto L24;
        r1 = r5.optString("error_msg");
    L24:
        r7.d(r1);
        this.a.finishWithResult(this.b);
        Logger.d(this.a.a, "onCompleted: code=" + this.b.a() + ", result=" + r5);
        return;
    L15:
        j1 r8 = this.a;
        if (r5 == null) goto L19;
        String r9 = r5.optString("error_msg");
        if (r9 == null) goto L19;
    L20:
        r8.getClass();
        j1.j("ai fail", r9);
    L19:
        r9 = BuildConfig.FLAVOR;
        goto L20
    L11:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public i1(j1 r1, LiveRunAiServiceResultModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
