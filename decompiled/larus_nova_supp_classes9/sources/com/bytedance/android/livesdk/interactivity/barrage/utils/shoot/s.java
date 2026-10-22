package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ q22.d a;
    public final /* synthetic */ r22.a.b b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        this.b.a(this.a);
    }

    public final void onNewResultImpl(Bitmap r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isRecycled() == true) goto L15;
        Bitmap r4 = BitmapTranslateUtils.b(r3);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isRecycled() == true) goto L16;
        q22.d r0 = this.a;
        r0.a.a = r4;
        this.b.a(r0);
        return;
    L16:
        return;
    }

    public s(q22.d r1, r22.a.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
