package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static final void a(String r2) {
        Intrinsics.checkNotNullParameter("PlayModeService", "tag");
        Intrinsics.checkNotNullParameter(r2, "content");
        ALogger.d("PlayModeIncompatible_PlayModeService", r2);
    }
}
