package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "adInfo")
public final class y extends w20.a<w20.f7, w20.g7> {
    public y() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.f7 r8 = (w20.f7) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        w20.g7 r9 = new w20.g7();
        JsonObject r0 = new JsonObject();
        JSONObject r1 = com.bytedance.android.livesdk.utils.a3.a;
        if (r1 == null) goto L16;
        String r3 = r8.a();
        String r11 = r8.b();
        if (Intrinsics.areEqual(r3, com.bytedance.android.livesdk.utils.a3.b) == true) goto L7;
    L10:
        boolean r12 = false;
    L11:
        if (r12 == false) goto L16;
        Iterator<String> r13 = r1.keys();
    L14:
        if (r13.hasNext() == false) goto L19;
        String r4 = r13.next();
        r0.addProperty(r4, JSONObjectProtectorUtils.getString(r1, r4));
    L19:
        r9.a(1);
        r9.b(r0);
        finishWithResult(r9);
        return;
    L7:
        if (Intrinsics.areEqual(r11, com.bytedance.android.livesdk.utils.a3.c) == false) goto L10;
        if (r3 == null) goto L10;
        r12 = true;
    L16:
        am2.n r14 = am2.n.f();
        int r2 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r14.c()) == false) goto L19;
        r0.addProperty("is_other_channel", r14.d);
        r0.addProperty("creative_id", r14.c());
        r0.addProperty("log_extra", r14.d());
        r0.addProperty("IESLiveEffectAdTrackExtraServiceKey", r14.b);
        r0.addProperty("is_ad_coin", Boolean.valueOf(r14.g));
        r0.addProperty("task_key", r14.b());
        goto L19
    }
}
