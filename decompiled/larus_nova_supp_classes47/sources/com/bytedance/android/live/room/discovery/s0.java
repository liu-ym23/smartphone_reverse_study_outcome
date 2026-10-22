package com.bytedance.android.live.room.discovery;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s0 implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ TopLeftActivityBannerWidget b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r1) {
    }

    public final void onNewResultImpl(Bitmap r4) {
        if (r4 != null) goto L17;
        return;
    L17:
        Bitmap r5 = Bitmap.createBitmap(r4);     // Catch: OutOfMemoryError -> L6
    L7:
        if (r5 != null) goto L9;
        return;
    L9:
        if (r5.isRecycled() == false) goto L11;
        return;
    L11:
        if (r5.getWidth() != 0) goto L13;
        return;
    L13:
        if (r5.getHeight() == 0) goto L22;
        int r0 = TopLeftActivityBannerWidget.f;
        int r1 = s1.f(22.0f);
        int r2 = (r5.getWidth() * r1) / r5.getHeight();
        this.a.getLayoutParams().width = r2;
        this.a.getLayoutParams().height = r1;
        String.valueOf(r2);
        this.a.setImageBitmap(r5);
        this.b.getClass();
        Unit r6 = Unit.INSTANCE;
        return;
    L22:
        return;
    L6:
        r5 = null;
        goto L7
    }

    public s0(ImageView r1, TopLeftActivityBannerWidget r2) {
        this.a = r1;
        this.b = r2;
    }
}
