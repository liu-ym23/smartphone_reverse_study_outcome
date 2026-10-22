package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetVisualEventTrackingSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getVisualEventTrackingSettings")
public final class GetVisualEventTrackingSettingsMethod extends w20.y1<JsonObject, GetVisualEventTrackingSettingsResultModel> {
    public static JsonArray a;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0003\u0010\u0003\u001a\u00020\u0002H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/GetVisualEventTrackingSettingsMethod$VirtualEventSettingsApi;", "", "", "aid", "Lcom/bytedance/retrofit2/Call;", "Lcom/google/gson/JsonObject;", "getSettingsApi", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface VirtualEventSettingsApi {
        public static final a a = null;

        public static final class a {
            public static final VirtualEventSettingsApi a = null;
            public static final /* synthetic */ a b = null;

            public a() {
            }

            static {
                b = new a();
                a = (VirtualEventSettingsApi) RetrofitUtils.createSsService("https://logview.zijieapi.com", VirtualEventSettingsApi.class);
            }
        }

        static {
            a = a.b;
        }

        @GET("/api/config/get_online_configs/")
        Call<JsonObject> getSettingsApi(@Query("appId") String r1);
    }

    public static final class a {
    }

    static {
    }

    public GetVisualEventTrackingSettingsMethod() {
    }

    public final void j(JsonArray r4) {
        if (r4 != null) goto L4;
        finishWithFailure();     // Catch: Exception -> L10
        return;
    L4:
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L10
        Iterator r5 = r4.iterator();     // Catch: Exception -> L10
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.add(((JsonElement) r5.next()).toString());     // Catch: Exception -> L10
        goto L6
    L8:
        GetVisualEventTrackingSettingsResultModel r6 = new GetVisualEventTrackingSettingsResultModel();     // Catch: Exception -> L10
        r6.a(GetVisualEventTrackingSettingsResultModel.Code.Success);     // Catch: Exception -> L10
        GetVisualEventTrackingSettingsResultModel.a r1 = new GetVisualEventTrackingSettingsResultModel.a();     // Catch: Exception -> L10
        GetVisualEventTrackingSettingsResultModel.b r2 = new GetVisualEventTrackingSettingsResultModel.b();     // Catch: Exception -> L10
        r2.a(r0);     // Catch: Exception -> L10
        Unit r3 = Unit.INSTANCE;     // Catch: Exception -> L10
        r1.a(r2);     // Catch: Exception -> L10
        r6.b(r1);     // Catch: Exception -> L10
        finishWithResult(r6);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        finishWithFailure(e);
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        JsonArray r4 = a;
        if (r4 == null) goto L5;
        j(r4);
        return;
    L5:
        VirtualEventSettingsApi.a.getClass();
        VirtualEventSettingsApi.a.a.getSettingsApi("1128").enqueue(new j5(this));
    }
}
