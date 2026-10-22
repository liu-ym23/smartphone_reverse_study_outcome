package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ q72.b a;
    public final /* synthetic */ r22.a.b b;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d c;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        q72.b r3 = this.a;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.c != true) goto L9;
        this.b.a(this.c);
        return;
    }

    public final void onNewResultImpl(Bitmap r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isRecycled() == true) goto L23;
        Bitmap r3 = BitmapTranslateUtils.b(r2);
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.isRecycled() == true) goto L24;
        q72.b r0 = this.a;
        if (r0 == null) goto L14;
        r0.a = r3;
    L14:
        if (r0 != null) goto L16;
        return;
    L16:
        if (r0.c != true) goto L22;
        this.b.a(this.c);
        return;
    L22:
        return;
    L24:
        return;
    }

    public d(q72.b r1, r22.a.b r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
