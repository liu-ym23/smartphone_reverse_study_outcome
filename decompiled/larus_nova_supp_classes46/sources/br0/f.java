package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livesdk.config.c90;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends lr0.a {
    public f(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        boolean r4 = zq0.b.a();
        Bundle r0 = new Bundle();
        if (r4 == true) goto L15;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r5 = AnchorMiniGameDataContext.a.a();
        if (r5 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.getOpenCamera();
        if (r6 == null) goto L11;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L11;
    L13:
        if (r7.booleanValue() == false) goto L15;
        boolean r8 = true;
    L16:
        r0.putBoolean("camera_capture_status", r8);
        return r0;
    L11:
        r7 = (Boolean) c90.a.getValue();
    L15:
        r8 = false;
        goto L16
    }
}
