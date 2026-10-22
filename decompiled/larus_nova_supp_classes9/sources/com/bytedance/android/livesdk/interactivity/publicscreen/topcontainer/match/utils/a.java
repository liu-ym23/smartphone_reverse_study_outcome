package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.d("MatchMsgTAG", r1);
    }

    @JvmStatic
    public static final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("MatchMsgTAG", r1);
    }
}
