package br0;

import android.graphics.Rect;
import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.cast.LiveMgCastContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends lr0.a {
    public e(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        qo0.a.c("minigame_live_cast", "onEvent on_live_biz_camera_preview_rect");
        if (((LiveMgCastContextService) this.a.getService(LiveMgCastContextService.class)).i() == false) goto L14;
        if (r3 == null) goto L15;
        Rect r4 = (Rect) r3.getParcelable("camera_little_window_rect");
        if (r4 == null) goto L16;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r0 = AnchorMiniGameDataContext.a.a();
        if (r0 == null) goto L17;
        com.bytedance.live.datacontext.m<Rect> r1 = r0.getLittleWindowRect();
        if (r1 == null) goto L18;
        r1.setValue(r4);
        return null;
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    }
}
