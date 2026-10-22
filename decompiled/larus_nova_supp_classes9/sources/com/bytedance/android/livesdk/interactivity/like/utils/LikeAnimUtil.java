package com.bytedance.android.livesdk.interactivity.like.utils;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LikeAnimUtil {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;

    public static AccelerateDecelerateInterpolator a() {
        return (AccelerateDecelerateInterpolator) b.getValue();
    }

    public static LinearInterpolator b() {
        return (LinearInterpolator) c.getValue();
    }

    static {
        a = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$pathInterpolator$2.INSTANCE);
        b = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$accelerateDecelerateInterpolator$2.INSTANCE);
        c = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$linearInterpolator$2.INSTANCE);
        d = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$othersLikeAlphaValuesHolder$2.INSTANCE);
        e = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$hotRoomOthersLikeAlphaValuesHolder$2.INSTANCE);
        f = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$selfOneLikePropertyValuesHolder$2.INSTANCE);
        g = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$selfTwoLikePropertyValuesHolder$2.INSTANCE);
        h = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$tapLikeScaleValuesHolder$2.INSTANCE);
        i = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(LikeAnimUtil$tapLikeAlphaValuesHolder$2.INSTANCE);
    }
}
