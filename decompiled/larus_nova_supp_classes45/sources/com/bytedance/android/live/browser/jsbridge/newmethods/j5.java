package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j5 implements Callback<JsonObject> {
    public final /* synthetic */ GetVisualEventTrackingSettingsMethod a;

    public j5(GetVisualEventTrackingSettingsMethod r1) {
        this.a = r1;
    }

    public final void onFailure(Call<JsonObject> r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "t");
        this.a.finishWithFailure(r3);
    }

    public final void onResponse(Call<JsonObject> r2, SsResponse<JsonObject> r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "response");
        JsonArray r4 = ((JsonObject) r3.body()).getAsJsonArray("data");
        this.a.j(r4);
        GetVisualEventTrackingSettingsMethod.a = r4;
    }
}
