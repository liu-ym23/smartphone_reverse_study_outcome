package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import kotlin.jvm.internal.Intrinsics;
import r52.k2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final Boolean a = null;

    static {
        a = (Boolean) k2.a.getValue();
    }

    public static boolean a(IRoom r5) {
        StringBuilder r0 = new StringBuilder("enableAI = ");
        Boolean r1 = a;
        r0.append(r1);
        r0.append(", roomAuth:");
        String r2 = null;
        if (r5 == null) goto L7;
        IRoomAuthStatus r3 = r5.getRoomAuthStatus();
        if (r3 == null) goto L7;
        Boolean r4 = Boolean.valueOf(r3.isEnableAIClone());
    L8:
        r0.append(r4);
        ALogger.i("AICloneTag", r0.toString());
        boolean r6 = PadConfigUtils.c();
        boolean r7 = FoldScreenUtils.f();
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L13;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L13;
        String r10 = r9.n();
    L14:
        if (r5 == null) goto L16;
        r2 = r5.getAnchorId();
    L16:
        boolean r11 = Intrinsics.areEqual(r10, r2);
        if (r6 == true) goto L28;
        if (r7 == true) goto L28;
        if (r11 == true) goto L28;
        if (r1.booleanValue() == false) goto L28;
        if (r5 == null) goto L28;
        IRoomAuthStatus r13 = r5.getRoomAuthStatus();
        if (r13 == null) goto L28;
        if (r13.isEnableAIClone() != true) goto L28;
        return true;
    L28:
        return false;
    L13:
        r10 = null;
    L7:
        r4 = null;
        goto L8
    }
}
