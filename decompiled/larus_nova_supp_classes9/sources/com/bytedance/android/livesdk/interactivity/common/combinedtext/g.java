package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ ClipImageView a;
    public final /* synthetic */ DisplayImageListView.b b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r3) {
        DisplayImageListView.b r4 = this.b;
        int r0 = r4.a + 1;
        r4.a = r0;
        if (r0 != r4.b) goto L6;
        r4.c.invoke();
        return;
    }

    public final void onNewResultImpl(Bitmap r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.isRecycled() == true) goto L22;
        Bitmap r4 = Bitmap.createBitmap(r3);     // Catch: OutOfMemoryError -> L8
    L9:
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.isRecycled() == true) goto L23;
        this.a.setImageBitmap(r4);
        DisplayImageListView.b r5 = this.b;
        int r0 = r5.a + 1;
        r5.a = r0;
        if (r0 != r5.b) goto L21;
        r5.c.invoke();
        return;
    L21:
        return;
    L23:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public g(ClipImageView r1, DisplayImageListView.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
