package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.broadcastgame.api.model.c0;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"reportClick", "", "clickType", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LiveMgMountContextService this$0;

    public LiveMgMountContextService$showStarAtlasAgreementDialog$1(LiveMgMountContextService r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(String r5) {
        Intrinsics.checkNotNullParameter(r5, "clickType");
        LiveMgMountContextService r0 = this.this$0;
        int r1 = LiveMgMountContextService.h;
        AnchorMiniGameAppLogContextService r2 = (AnchorMiniGameAppLogContextService) r0.getOpenPlatformContext().getService(AnchorMiniGameAppLogContextService.class);
        HashMap<String, String> r3 = new HashMap();
        int r4 = v.a;
        c0 r6 = this.this$0.f;
        if (r6 == null) goto L5;
        String r7 = r6.a;
    L6:
        r3.put("source", v.a(r7));
        r3.put("click_type", r5);
        Unit r8 = Unit.INSTANCE;
        r2.reportLiveRoomMgAppLog("mp_star_task_authorization_click", r3);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
