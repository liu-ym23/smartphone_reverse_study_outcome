package com.ss.android.lark.chat.utils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l1 {
    public static Boolean a;
    public static Boolean b;

    public static final class a {
    }

    static {
    }

    public static boolean a() {
        if (b != null) goto L5;
        b = Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("im.message.thread_reply_bubble_optimize"));
    L5:
        Boolean r0 = b;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Boolean");
        return r0.booleanValue();
    }
}
