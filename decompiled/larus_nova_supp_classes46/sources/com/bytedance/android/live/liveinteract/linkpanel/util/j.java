package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "source");
            ALogger.i("InvitePageLogger", "logBeforeInvite: source = ".concat(r1));
        }
    }

    static {
    }
}
