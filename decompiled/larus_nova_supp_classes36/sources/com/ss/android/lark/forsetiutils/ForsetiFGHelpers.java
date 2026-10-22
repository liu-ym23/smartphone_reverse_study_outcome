package com.ss.android.lark.forsetiutils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiFGHelpers {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(ForsetiFGHelpers$enableForseti$2.INSTANCE);
        b = LazyKt.lazy(ForsetiFGHelpers$enableResponsiveCompoentInner$2.INSTANCE);
    }

    public static boolean d() {
        if (((Boolean) b.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == false) goto L7;
        return true;
    }

    public static boolean e() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    public static boolean a(BizType r3) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        if (e() == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti." + r3.getKey()) == true) goto L7;
        return true;
    }

    public static boolean b(BizType r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        Intrinsics.checkNotNullParameter(r4, "pageName");
        if (a(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti." + r3.getKey() + '.' + r4) == true) goto L7;
        return true;
    }

    public static boolean c(BizType r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "bizType");
        Intrinsics.checkNotNullParameter(r4, "featureId");
        if (a(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti." + r3.getKey() + '.' + r4) == true) goto L7;
        return true;
    }
}
