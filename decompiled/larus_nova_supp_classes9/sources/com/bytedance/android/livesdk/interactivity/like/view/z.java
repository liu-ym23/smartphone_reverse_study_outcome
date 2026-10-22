package com.bytedance.android.livesdk.interactivity.like.view;

import android.graphics.Bitmap;
import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface z {

    public static final class a {
        public static /* synthetic */ void a(z r15, Bitmap r16, PointF r17, PointF r18, boolean r19, float r20, f32.i r21, int r23) {
            if ((r23 & 4) == 0) goto L5;
            PointF r4 = new PointF();
        L7:
            if ((r23 & 32) == 0) goto L9;
            float r6 = 0.0f;
        L11:
            if ((r23 & 64) == 0) goto L13;
            f32.i r7 = new f32.i(0, false, false, false, false, 63);
        L14:
            r15.a(r16, r17, r4, 0, r6, r7);
            return;
        L13:
            r7 = r21;
            goto L14
        L9:
            r6 = r20;
            goto L11
        L5:
            r4 = r18;
            goto L7
        }
    }

    void a(Bitmap r1, PointF r2, PointF r3, int r4, float r5, f32.i r6);

    void clear();

    void load();
}
