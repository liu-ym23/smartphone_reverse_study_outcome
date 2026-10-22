package com.bytedance.android.live.liveinteract.utils;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(HashMap r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        sh0.i0 r1 = sh0.j0.a(null);
        if (r1 != null) goto L5;
    L12:
        r4.put("is_from_game", "0");
        return;
    L5:
        if (r1.g() != true) goto L12;
        int r2 = sh0.h0.a;
        com.bytedance.android.live.liveinteract.revenue.game.e r0 = (com.bytedance.android.live.liveinteract.revenue.game.e) sh0.j0.d(null, "linkmic_game_state");
        r4.put("is_from_game", "1");
        if (r0 == null) goto L10;
        String r3 = r0.b;
        if (r3 == null) goto L10;
    L11:
        r4.put("game_id", r3);
        return;
    L10:
        r3 = "";
        goto L11
    }

    public static void b(HashMap r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        sh0.i0 r1 = sh0.j0.a(null);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.g() != true) goto L19;
        int r2 = sh0.h0.a;
        com.bytedance.android.live.liveinteract.revenue.game.e r0 = (com.bytedance.android.live.liveinteract.revenue.game.e) sh0.j0.d(null, "linkmic_game_state");
        if (r0 == null) goto L10;
        String r4 = r0.c;
        if (r4 == null) goto L10;
    L11:
        r3.put("play_mode", r4);
        if (r0 == null) goto L15;
        String r5 = r0.b;
        if (r5 == null) goto L15;
    L16:
        r3.put("game_id", r5);
        return;
    L15:
        r5 = "";
    L10:
        r4 = "danmu";
        goto L11
    }
}
