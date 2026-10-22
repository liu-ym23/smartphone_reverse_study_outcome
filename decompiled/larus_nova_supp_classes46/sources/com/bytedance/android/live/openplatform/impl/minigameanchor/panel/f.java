package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ MiniGameFeaturePanelDialog a;

    public f(MiniGameFeaturePanelDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        LiveMiniGameFeaturePanelViewModel r5 = this.a.g;
        if (r5 == null) goto L5;
        r5.exitMount();
    L5:
        r3.dismiss();
        OpenPlatformContext r6 = this.a.e;
        if (r6 == null) goto L11;
        AnchorMiniGameAppLogContextService r7 = (AnchorMiniGameAppLogContextService) r6.getService(AnchorMiniGameAppLogContextService.class);
        if (r7 == null) goto L12;
        HashMap<String, String> r8 = new HashMap();
        r8.put("screen_split_rate", "0.3");
        r8.put("click_type", "exit");
        Unit r0 = Unit.INSTANCE;
        r7.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_click", r8);
        return;
    L12:
        return;
    }
}
