package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ q72.e a;
    public final /* synthetic */ r22.a.b b;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d c;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        q72.e r3 = this.a;
        if (r3 == null) goto L5;
        r3.b = true;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.d != true) goto L11;
        this.b.a(this.c);
        return;
    }

    public final void onNewResultImpl(Bitmap r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isRecycled() == true) goto L26;
        Bitmap r3 = BitmapTranslateUtils.b(r2);
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.isRecycled() == true) goto L27;
        q72.e r0 = this.a;
        if (r0 == null) goto L15;
        r0.a = r3;
    L15:
        if (r0 == null) goto L17;
        r0.b = true;
    L17:
        if (r0 != null) goto L19;
        return;
    L19:
        if (r0.d != true) goto L25;
        this.b.a(this.c);
        return;
    L25:
        return;
    L27:
        return;
    }

    public v(q72.e r1, r22.a.b r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
