package com.bytedance.awemeopen.infra.plugs.settings;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SettingsEventHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final String r1, final String r2, final String r3) {
        Intrinsics.checkNotNullParameter(r1, "aoAppId");
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "reason");
        AoPool.a(new SettingsEventHelper$monitorWriteFailed$1(r1, r2, r3));
    }

    public static void b(final String r12, final long r13, final String r15, final int r16, final String r17, final String r18, final int r19) {
        final long r5 = 0;
        Intrinsics.checkNotNullParameter(r12, "bdpAppId");
        Intrinsics.checkNotNullParameter(r15, "result");
        Intrinsics.checkNotNullParameter(r17, "errorMsg");
        Intrinsics.checkNotNullParameter(r18, "from");
        AoPool.a(new SettingsEventHelper$mpSettingsRequestResult$1(r12, r13, r15, r5, r16, r17, r18, r19));
    }
}
