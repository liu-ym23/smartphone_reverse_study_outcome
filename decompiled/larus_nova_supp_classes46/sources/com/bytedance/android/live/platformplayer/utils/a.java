package com.bytedance.android.live.platformplayer.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        com.bytedance.android.live.core.log.g.i("LiveBackgroundOpt", r3);
    }
}
