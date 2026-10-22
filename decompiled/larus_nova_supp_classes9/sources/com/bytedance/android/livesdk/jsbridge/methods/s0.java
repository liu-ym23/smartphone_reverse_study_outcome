package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "fetch_session_info")
public final class s0 extends c<t0, FetchSessionInfoResultModel> {
    public s0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        t0 r5 = (t0) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((r4.getContext() instanceof FragmentActivity) == false) goto L28;
        String r6 = r5.getIdentifier();
        if (r6 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == false) goto L13;
        finishWithFailure(new Throwable("no input key"));
        return;
    L13:
        JSONObject r8 = jc1.k.n(IHostLiveLocalLife.class).fetchSessionInfo(r6);
        if (r8 == null) goto L24;
        FetchSessionInfoResultModel r9 = new FetchSessionInfoResultModel();
        r9.a(FetchSessionInfoResultModel.Code.Success);
        FetchSessionInfoResultModel.a r0 = new FetchSessionInfoResultModel.a();
        JsonElement r10 = GsonHelper.parser().parse(r8.toString());     // Catch: Exception -> L22
        if (r10 == null) goto L19;
        JsonObject r11 = r10.getAsJsonObject();     // Catch: Exception -> L22
    L20:
        r0.a(r11);     // Catch: Exception -> L22
    L23:
        Unit r13 = Unit.INSTANCE;
        r9.b(r0);
        finishWithResult(r9);
        return;
    L19:
        r11 = null;
    L22:
        finishWithFailure(new Throwable("no session info"));
        goto L23
    L24:
        new FetchSessionInfoMethod$invoke$2(this);
        return;
    L7:
        if (r6.length() == 0) goto L10;
        r7 = false;
        goto L11
    }
}
