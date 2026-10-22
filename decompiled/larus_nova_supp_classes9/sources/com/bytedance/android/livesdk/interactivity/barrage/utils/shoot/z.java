package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ x a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d b;
    public final /* synthetic */ r22.a.b c;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        x r3 = this.a;
        r3.d = true;
        if (r3.e == false) goto L6;
        this.c.a(this.b);
        return;
    }

    public final void onNewResultImpl(Bitmap r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isRecycled() == true) goto L25;
        Bitmap r4 = BitmapTranslateUtils.b(r3);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isRecycled() == true) goto L26;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r0 = this.b;
        if ((r0 instanceof q72.f) == true) goto L14;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r1 = null;
    L15:
        q72.f r2 = (q72.f) r1;
        if (r2 == null) goto L18;
        r2.a = r4;
    L18:
        x r5 = this.a;
        r5.d = true;
        if (r5.e == false) goto L24;
        this.c.a(r0);
        return;
    L24:
        return;
    L14:
        r1 = r0;
        goto L15
    L26:
        return;
    }

    public z(x r1, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2, r22.a.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
