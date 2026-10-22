package com.bytedance.android.livesdk.interactivity.quickcomment;

import com.bytedance.android.logsdk.format.Spm;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final void a(String r5) {
        Intrinsics.checkNotNullParameter("a100.a100.a318", "spm");
        Intrinsics.checkNotNullParameter(r5, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a318").addArg("info", r5), "LiveQuickComment");
    }
}
