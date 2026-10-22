package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LiveMgMountContextService a;
    public final /* synthetic */ Function1 b;

    public g(LiveMgMountContextService r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        ApiServerException r12 = (Throwable) r11;
        if ((r12 instanceof ApiServerException) == false) goto L15;
        ApiServerException r13 = r12;
        String r0 = r13.getPrompt();
        if (r0 != null) goto L7;
        r0 = r13.getErrorMsg();
    L7:
        f2.c(r0, 0);
        Function1 r1 = this.b;
        if (r1 == null) goto L10;
        Unit r2 = (Unit) r1.invoke("api server exception, stop load candy toolbar");
    L10:
        LiveMgMountContextService r3 = this.a;
        int r7 = LiveMgMountContextService.h;
        AnchorMiniGameAppLogContextService r4 = (AnchorMiniGameAppLogContextService) r3.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r8 = new HashMap();
        if (r13.getErrorCode() != 28006033) goto L13;
        String r9 = "risk_control";
    L14:
        r8.put("error_type", r9);
        r8.put("error_code", String.valueOf(r13.getErrorCode()));
        r8.put("api_name", "game_start");
        r8.put("result", "fail");
        Unit r14 = Unit.INSTANCE;
        r4.reportLiveRoomMgAppLog("livesdk_mg_room_net_result", r8);
        return;
    L13:
        r9 = "server_exception";
        goto L14
    L15:
        qo0.a.b("LiveMgMountContextService", "request game/start fail", r12);
        f2.b(2131920998, 0);
        Function1 r15 = this.b;
        if (r15 == null) goto L18;
        Unit r16 = (Unit) r15.invoke("network request fail, stop load candy toolbar");
    L18:
        LiveMgMountContextService r17 = this.a;
        int r5 = LiveMgMountContextService.h;
        AnchorMiniGameAppLogContextService r18 = (AnchorMiniGameAppLogContextService) r17.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r6 = new HashMap();
        r6.put("error_type", "network");
        r6.put("api_name", "game_start");
        r6.put("result", "fail");
        Unit r10 = Unit.INSTANCE;
        r18.reportLiveRoomMgAppLog("livesdk_mg_room_net_result", r6);
    }
}
