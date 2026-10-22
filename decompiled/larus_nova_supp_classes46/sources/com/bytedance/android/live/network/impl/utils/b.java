package com.bytedance.android.live.network.impl.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int c = 0;
    public final Scene a;
    public final PATH b;

    public static final class a {
        public static void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "msg");
            ALogger.i("LiveApiRetryLogger", r1);
        }
    }

    static {
    }

    public b(Scene r2, PATH r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "path");
        this.a = r2;
        this.b = r3;
    }
}
