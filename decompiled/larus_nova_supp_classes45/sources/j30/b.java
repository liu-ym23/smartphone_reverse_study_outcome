package j30;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    public final DataCenter c;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        JsonObject r0 = new JsonObject();
        DataCenter r1 = this.c;
        Boolean r2 = Boolean.FALSE;
        r0.addProperty("enter_from_dou_plus", (Boolean) r1.get("enter_from_dou_plus", r2));
        r0.addProperty("enter_from_effect_ad", (Boolean) this.c.get("enter_from_effect_ad", r2));
        HashMap r3 = (HashMap) this.c.get("live_douplus_log_extra", new HashMap());
        if (r3 != null) goto L5;
        r3 = new HashMap();
    L5:
        Gson r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("gson");
    L8:
        r0.add("live_douplus_log_extra", GsonProtectorUtils.toJsonTree(r4, r3).getAsJsonObject());
        HashMap r5 = (HashMap) this.c.get("live_effect_ad_log_extra_map", new HashMap());
        if (r5 != null) goto L11;
        r5 = new HashMap();
    L11:
        Gson r6 = this.a;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("gson");
    L14:
        r0.add("live_effect_ad_log_extra_map", GsonProtectorUtils.toJsonTree(r6, r5).getAsJsonObject());
        return r0;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.c.b;
    }

    public b(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }
}
