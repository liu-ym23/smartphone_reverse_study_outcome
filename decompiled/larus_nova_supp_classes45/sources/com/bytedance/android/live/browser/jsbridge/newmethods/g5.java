package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.GetRevenueLotteryLogParamsResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getRevenueLotteryLogParams")
public final class g5 extends w20.s1<JsonObject, GetRevenueLotteryLogParamsResultModel> {
    public g5() {
    }

    public final void invoke(Object r8, CallContext r9) {
        Intrinsics.checkNotNullParameter((JsonObject) r8, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        IMiddlewareUserService r11 = jc1.k.f(IMiddlewareUserService.class);
        String r12 = "";
        if (r11 == null) goto L8;
        com.bytedance.android.livesdk.user.e r13 = r11.user();
        if (r13 == null) goto L8;
        String r14 = r13.n();
        if (r14 == null) goto L8;
    L9:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("function_type2", jc1.k.n(IInteractService.class).getFunctionTypeForLog());
        com.bytedance.live.datacontext.i r1 = com.bytedance.android.livesdk.chatroom.utils.o3.f().getLiveMode();
        if (r1 == null) goto L12;
        LiveMode r2 = (LiveMode) r1.getValue();
    L14:
        if (r2 == null) goto L29;
        int r3 = f5.a[r2.ordinal()];
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L27;
        if (r3 == 3) goto L26;
        if (r3 != 4) goto L22;
        r12 = "voice_live";
        goto L29
    L22:
        if (r3 != 5) goto L29;
        r12 = "media";
        goto L29
    L26:
        r12 = "third_party";
        goto L29
    L27:
        r12 = "game";
        goto L29
    L28:
        r12 = "video_live";
    L29:
        r0.put("live_type", r12);
        r0.put("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
        UserType r15 = jc1.k.n(IInteractService.class).tryGetTargetUserType(r14);
        if (r15 == null) goto L44;
        int r16 = f5.b[r15.ordinal()];
        if (r16 == 1) goto L41;
        if (r16 == 2) goto L40;
        if (r16 == 3) goto L39;
        if (r16 == 4) goto L39;
        throw new NoWhenBranchMatchedException();
    L39:
        String r17 = "user";
    L42:
        r0.put("user_type", r17);
        goto L44
    L40:
        r17 = "guest";
        goto L42
    L41:
        r17 = "anchor";
    L44:
        if (jc1.k.n(IKtvService.class).isAudienceSingEnableSwitchOn() == false) goto L46;
        String r18 = "on";
    L47:
        r0.put("order_status", r18);
        GetRevenueLotteryLogParamsResultModel r19 = new GetRevenueLotteryLogParamsResultModel();
        r19.a(GetRevenueLotteryLogParamsResultModel.Code.Success);
        GetRevenueLotteryLogParamsResultModel.a r21 = new GetRevenueLotteryLogParamsResultModel.a();
        r21.a(GsonProtectorUtils.toJson(GsonHelper.get(), r0));
        Unit r4 = Unit.INSTANCE;
        r19.b(r21);
        finishWithResult(r19);
        return;
    L46:
        r18 = "off";
        goto L47
    L12:
        r2 = null;
    L8:
        r14 = "";
        goto L9
    }
}
