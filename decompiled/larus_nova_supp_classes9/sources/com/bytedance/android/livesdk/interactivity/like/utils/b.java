package com.bytedance.android.livesdk.interactivity.like.utils;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "spm");
        Intrinsics.checkNotNullParameter(r5, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a(r4).addArg("info", r5), "DiggWidget");
    }

    public static void a(String r2, boolean r3, boolean r4, boolean r5, Room r6) {
        Intrinsics.checkNotNullParameter("a100.a100.a175", "spm");
        Intrinsics.checkNotNullParameter(r2, "triggerReason");
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append(", Anchor:");
        r0.append(r3);
        r0.append(", Portrait:");
        r0.append(r4);
        r0.append(", isLogin:");
        r0.append(jc1.k.n(IUserService.class).user().isLogin());
        r0.append(", RoomEnable:");
        if (r6 == null) goto L7;
        RoomAuthStatus r7 = r6.getRoomAuthStatus();
        if (r7 == null) goto L7;
        Boolean r8 = Boolean.valueOf(r7.getEnableDigg());
    L8:
        r0.append(r8);
        r0.append(", DiggHide:");
        r0.append(r5);
        b("a100.a100.a175", r0.toString());
        return;
    L7:
        r8 = null;
        goto L8
    }
}
