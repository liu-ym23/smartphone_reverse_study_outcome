package com.bytedance.awemeopen.infra.plugs.fresco;

import android.graphics.Bitmap;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends BaseBitmapDataSubscriber {
    public final /* synthetic */ l64.b a;

    public e(l64.b r1) {
        this.a = r1;
    }

    public final void onFailureImpl(DataSource r1) {
        com.bytedance.awemeopen.infra.base.image.c r2 = this.a.u.a.k;
        if (r2 == null) goto L6;
        r2.onFail();
        return;
    }

    public final void onNewResultImpl(Bitmap r7) {
        int r0 = r7.getWidth();
        int r1 = r7.getHeight();
        int r2 = r0 * r1;
        if (r2 <= 262144) goto L5;
        double r3 = Math.sqrt((r2 * 1.0f) / 262144);
        r0 = (int) Math.ceil(((double) r0) / r3);
        r1 = (int) Math.ceil(((double) r1) / r3);
    L5:
        Bitmap r8 = Bitmap.createBitmap(r7, 0, 0, r0, r1);
        com.bytedance.awemeopen.infra.base.image.c r4 = this.a.u.a.k;
        if (r4 == null) goto L9;
        r4.onSuccess(r8);
        return;
    }
}
