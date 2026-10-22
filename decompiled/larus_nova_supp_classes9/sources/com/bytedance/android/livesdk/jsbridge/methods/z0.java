package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeService;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getLiveLocalLifeRoomInfo")
public final class z0 extends e<JsonObject, GetLiveLocalLifeRoomInfoResultModel> {
    public z0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((JsonObject) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((r4.getContext() instanceof FragmentActivity) == false) goto L18;
        ILiveService r5 = TTLiveService.getLiveService();
        if (r5 == null) goto L13;
        ILiveLocalLifeService r6 = (ILiveLocalLifeService) r5.liveLocalLifeService(ILiveLocalLifeService.class);
        if (r6 == null) goto L13;
        FragmentActivity r7 = r4.getContext();
        if (r7 == null) goto L12;
        JSONObject r8 = r6.getCurrentRoomInfo(r7);
    L14:
        if (r8 != null) goto L16;
        finishWithFailure(new Throwable("context is not FragmentActivity"));
        return;
    L16:
        GetLiveLocalLifeRoomInfoResultModel r9 = new GetLiveLocalLifeRoomInfoResultModel();
        r9.a(GetLiveLocalLifeRoomInfoResultModel.Code.Success);
        GetLiveLocalLifeRoomInfoResultModel.a r0 = new GetLiveLocalLifeRoomInfoResultModel.a();
        r0.a(1);
        r0.b(r8.toString());
        Unit r10 = Unit.INSTANCE;
        r9.b(r0);
        finishWithResult(r9);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L13:
        r8 = null;
        goto L14
    }
}
