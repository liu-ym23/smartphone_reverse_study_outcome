package com.bytedance.android.live.liveinteract.animation;

import android.graphics.PointF;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0 {
    public static final float a(EPointF r2, EPointF r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        Intrinsics.checkNotNullParameter(r3, "p2");
        double r0 = 360;
        return (float) ((((((double) (((float) Math.atan2(((PointF) r2).y - ((PointF) r3).y, ((PointF) r2).x - ((PointF) r3).x)) * 180)) / 3.141592653589793d) - ((double) 90)) + r0) % r0);
    }
}
