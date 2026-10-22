package com.bytedance.android.livesdk.gift.platform.business.normal.utils;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static PointF a(float r19, PointF r20, int r21, int r23) {
        Intrinsics.checkNotNullParameter(r20, "centerPointF");
        PointF r4 = new PointF();
        float r5 = r19 % 90;
        if (r5 == 0.0f) goto L5;
    L8:
        if (r5 == 0.0f) goto L10;
    L13:
        double r6 = Math.toRadians(r19);
        double r8 = Math.tan(r6);
        double r10 = Math.sin(r6);
        Math.cos(r6);
        float r0 = r20.y;
        float r13 = r20.x;
        double r7 = ((double) r0) - (((double) r13) * r8);
        if (r8 < 0.0d) goto L23;
        if (r8 > 1.0d) goto L23;
        if (r10 <= 0) goto L20;
        r4.x = r13 + (r21 / 2.0f);
    L21:
        r4.y = (float) ((((double) r4.x) * r8) + r7);
    L30:
        if (r8 < (-1.0d)) goto L39;
        if (r8 > 0.0d) goto L39;
        if (r10 <= 0) goto L36;
        r4.x = r20.x - (r21 / 2.0f);
    L37:
        r4.y = (float) ((r8 * ((double) r4.x)) + r7);
    L45:
        return r4;
    L36:
        r4.x = r20.x + (r21 / 2.0f);
    L39:
        if (r8 >= (-1)) goto L45;
        if (r10 <= 0) goto L43;
        r4.y = r20.y + (r23 / 2.0f);
    L44:
        r4.x = (float) ((((double) r4.y) - r7) / r8);
        goto L45
    L43:
        r4.y = r20.y - (r23 / 2.0f);
        goto L44
    L20:
        r4.x = r13 - (r21 / 2.0f);
    L23:
        if (r8 <= 1) goto L30;
        if (r10 <= 0) goto L27;
        r4.y = r0 + (r23 / 2.0f);
    L28:
        r4.x = (float) ((((double) r4.y) - r7) / r8);
        goto L30
    L27:
        r4.y = r0 - (r23 / 2.0f);
        goto L28
    L10:
        if (r19 <= 0) goto L13;
        r4.x = r20.x;
        r4.y = r20.y + (r23 / 2);
        return r4;
    L5:
        if (r19 >= 0) goto L8;
        r4.x = r20.x;
        r4.y = r20.y - (r23 / 2);
        return r4;
    }
}
