package com.ss.android.lark.forwardv3.forward.imageforward;

import android.content.Context;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.forwardv3.ForwardNewActivity;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.DisableConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r6, @ImageSource int r7, int r8, ForwardTemplateNew r9) {
        ImageSource.Companion.getClass();
        if (r7 != 0) goto L5;
    L19:
        String r10 = "UNKNOWN";
    L20:
        Log.i("ImageForward", "start forward image:\nfrom: ".concat(r10));
        if (r6 != null) goto L25;
        Log.e("ImageForward", "context is null");
        return;
    L25:
        if (r9.getForwardTargetConfig().d != null) goto L27;
        ForwardTargetConfig r11 = r9.getForwardTargetConfig();
        IncludeConfig.CREATOR.getClass();
        r11.d = IncludeConfig.b.a();
    L27:
        IncludeConfig r12 = r9.getForwardTargetConfig().d;
        if (r12 == null) goto L31;
        EntityItem.a r1 = new EntityItem.a();
        r1.a(new AIConfig());
        r12.a(r1.c());
    L31:
        if (r9.getForwardTargetConfig().e != null) goto L33;
        ForwardTargetConfig r13 = r9.getForwardTargetConfig();
        DisableConfig.a r2 = new DisableConfig.a();
        EntityItem.a r3 = new EntityItem.a();
        r3.e(new ThreadConfig.a().a());
        r2.a(r3.c());
        r13.e = r2.b();
    L33:
        r9.setType(5);
        int r14 = ForwardNewActivity.b;
        ForwardNewActivity.a.a(r6, r9, r8, ActivityAnimationManager.ANIM_SLIDE_UP_IN, ActivityAnimationManager.ANIM_SLIDE_BOTTOM_OUT, 32);
        return;
    L5:
        if (r7 != 1) goto L7;
        r10 = "PHOTO_EDITOR_IMAGE";
        goto L20
    L7:
        if (r7 != 2) goto L9;
        r10 = "POST_IMAGE";
        goto L20
    L9:
        if (r7 != 3) goto L11;
        r10 = "CCM_DOC_IMAGE";
        goto L20
    L11:
        if (r7 == 4) goto L15;
        if (r7 != 5) goto L19;
        r10 = "VC_ROOM_WHITE_BOARD";
        goto L20
    L15:
        r10 = "UD_SHARE_PANEL_IMAGE";
        goto L20
    }
}
