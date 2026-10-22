package br0;

import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.mount.LiveMgMountContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends lr0.a {
    public l(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r7) {
        if (((LiveMgMountContextService) this.a.getService(LiveMgMountContextService.class)).c == false) goto L20;
        if (r7 == null) goto L21;
        Rect r0 = (Rect) r7.getParcelable("live_cast_rect");
        Rect r2 = (Rect) r7.getParcelable("camera_little_window_rect");
        if (r0 == null) goto L21;
        if (r2 == null) goto L21;
        String r4 = "";
        String r8 = r7.getString("extra_param", "");
        LiveMgCastContextService r3 = (LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class);     // Catch: Exception -> L18
        MiniAppInstance r5 = this.a.getMiniGameInstance();     // Catch: Exception -> L18
        if (r5 == null) goto L12;
        String r6 = r5.getAppId();     // Catch: Exception -> L18
    L13:
        if (r6 == null) goto L16;
        r4 = r6;
    L16:
        r3.l(r4, r0, r2, new JSONObject(r8));     // Catch: Exception -> L18
        goto L21
    L12:
        r6 = null;
    L18:
        e = move-exception;
        int r1 = qo0.a.a;
        qo0.a.c("MiniGame OnLiveBizStartCastEventListener", "ON_LIVE_BIZ_START_CAST exception: " + e.getMessage());
        ((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).j("ON_LIVE_BIZ_START_CAST extraParam parse error");
    L21:
        return null;
    L20:
        ((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).j("minigame is not mounted");
        goto L21
    }
}
