package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.event.BridgeContextService;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends lr0.a {
    public m(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r6) {
        if (((LiveMgMountContextService) this.a.getService(LiveMgMountContextService.class)).c == false) goto L11;
        qo0.a.c("minigame OnLiveBizStopCastEventListener", "ON_LIVE_BIZ_STOP_CAST");
        LiveMgCastContextService r7 = (LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class);
        MiniAppInstance r1 = this.a.getMiniGameInstance();
        if (r1 == null) goto L7;
        String r2 = r1.getAppId();
    L8:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r7.q(r2, "user trigger");
    L12:
        return null;
    L7:
        r2 = null;
        goto L8
    L11:
        BridgeContextService r8 = (BridgeContextService) ((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).getOpenPlatformContext().getService(BridgeContextService.class);
        Bundle r3 = new Bundle();
        r3.putBoolean("key_is_success", false);
        JSONObject r4 = new JSONObject();
        r4.put("errMsg", "minigame is not mounted");
        Unit r5 = Unit.INSTANCE;
        r3.putString("key_extra", r4.toString());
        r8.g("command_live_cast_stop", r3);
        goto L12
    }
}
