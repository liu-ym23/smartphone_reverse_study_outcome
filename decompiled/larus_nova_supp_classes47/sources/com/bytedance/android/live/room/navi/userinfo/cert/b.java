package com.bytedance.android.live.room.navi.userinfo.cert;

import android.graphics.Bitmap;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ a a;
    public final /* synthetic */ ImageView b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        this.a.a = false;
    }

    public final void onNewResultImpl(Bitmap r4) {
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        this.a.a = false;
        if (r4.isRecycled() == false) goto L5;
        return;
    L5:
        ImageView r0 = this.b;
        if (r0 == null) goto L8;
        ViewParent r1 = r0.getParent();
    L9:
        if (r1 == null) goto L12;
        this.b.setImageBitmap(r4.copy(Bitmap.Config.ARGB_8888, false));
        this.a.c.onShow();
        return;
    L12:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public b(a r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}
