package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public static final boolean a(u r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isOpenPlatformPlugin");
        if (r2.interactId != InteractID.OpenGame.getValue()) goto L5;
    L12:
        return true;
    L5:
        if (r2.interactId == InteractID.OpenMicroApp.getValue()) goto L12;
        if (r2.interactId == InteractID.SonicMiniGame.getValue()) goto L12;
        if (r2.interactId == InteractID.OpenMicroGame.getValue()) goto L12;
        return false;
    }
}
