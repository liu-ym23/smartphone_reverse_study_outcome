package com.ss.android.lark.forwardv3.utils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b() {
        boolean r0 = a("lark.forward.mention_preview", false);
        Log.i("FGUtils", "FG key: core.forward.mention_preview: " + r0);
        return r0;
    }

    public static boolean c() {
        boolean r0 = a("core.forward.message_reference_update", false);
        Log.i("FGUtils", "FG key: core.forward.create_group_loading: " + r0);
        return !r0;
    }

    public static void d() {
        Log.i("FGUtils", "FG key: im.forward.recentview.recentforward, is " + a("im.forward.recentview.recentforward", false));
    }

    public static boolean a(String r1, boolean r2) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r1, r2);
    }
}
