package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ q22.a a;
    public final /* synthetic */ r22.a.b b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        this.b.a(this.a);
    }

    public final void onNewResultImpl(Bitmap r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isRecycled() == true) goto L15;
        Bitmap r3 = BitmapTranslateUtils.b(r2);
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.isRecycled() == true) goto L16;
        q22.a r0 = this.a;
        r0.a = r3;
        this.b.a(r0);
        return;
    L16:
        return;
    }

    public p(q22.a r1, r22.a.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
