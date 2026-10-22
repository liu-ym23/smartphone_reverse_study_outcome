package com.larus.bmhome.chat.bubble.floating.runtime;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static IBubbleBannerRuntimeService c() {
        return (IBubbleBannerRuntimeService) ServiceManager.get().getService(IBubbleBannerRuntimeService.class);
    }

    public static pc8.e b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "promptId");
        IBubbleBannerRuntimeService r0 = c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r1);
    }

    public static boolean a(String r1, BubbleBannerDismissReason r2) {
        Intrinsics.checkNotNullParameter(r1, "promptId");
        Intrinsics.checkNotNullParameter(r2, "reason");
        IBubbleBannerRuntimeService r0 = c();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.h(r1, r2) != true) goto L7;
        return true;
    }

    public static void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "promptId");
        IBubbleBannerRuntimeService r0 = c();
        if (r0 == null) goto L6;
        r0.g(r1, r2);
        return;
    }
}
