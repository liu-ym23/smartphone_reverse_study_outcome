package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.LiveNotifyLongPressResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.notifyLongPress")
public final class q6 extends w20.b3<JsonObject, LiveNotifyLongPressResultModel> {
    public q6() {
    }

    public final void invoke(Object r5, CallContext r6) {
        Intrinsics.checkNotNullParameter((JsonObject) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        ALogger.i("LiveNotifyLongPressMethod", "invoke");
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);     // Catch: Exception -> L12
        IRoom r0 = null;
        if (r7 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.o r8 = IRoomContextService.a.a(r7, null, 0, 3);     // Catch: Exception -> L12
        if (r8 == null) goto L10;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();     // Catch: Exception -> L12
        if (r9 == null) goto L10;
        r0 = (IRoom) r9.getValue();     // Catch: Exception -> L12
    L10:
        xs2.b.a().post(new zg1.h1(26, r0));     // Catch: Exception -> L12
        LiveNotifyLongPressResultModel r11 = new LiveNotifyLongPressResultModel();     // Catch: Exception -> L12
        r11.a(LiveNotifyLongPressResultModel.Code.Success);     // Catch: Exception -> L12
        Unit r1 = Unit.INSTANCE;     // Catch: Exception -> L12
        finishWithResult(r11);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ALogger.e("LiveNotifyLongPressMethod", "invoke failed ex " + e.getMessage());
        LiveNotifyLongPressResultModel r12 = new LiveNotifyLongPressResultModel();
        r12.a(LiveNotifyLongPressResultModel.Code.Failed);
        r12.b(e.getMessage());
        Unit r13 = Unit.INSTANCE;
        finishWithResult(r12);
    }
}
