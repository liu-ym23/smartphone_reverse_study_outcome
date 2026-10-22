package com.bytedance.android.livesdk.interactivity;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.comment.data.f a;

    public k(com.bytedance.android.livesdk.interactivity.api.comment.data.f r1) {
        this.a = r1;
    }

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        StringBuilder r3 = new StringBuilder("load icon failed, icon type is ");
        r3.append(this.a.type);
        r3.append(" uri is ");
        py.k r0 = this.a.icon;
        if (r0 == null) goto L5;
        String r1 = r0.getUri();
    L6:
        r3.append(r1);
        String r4 = r3.toString();
        if (r4 != null) goto L9;
        r4 = BuildConfig.FLAVOR;
    L9:
        ALogger.e("CommentPresent", r4);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onNewResultImpl(Bitmap r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isRecycled() == true) goto L19;
        Bitmap r3 = Bitmap.createBitmap(r2);     // Catch: OutOfMemoryError -> L8
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.isRecycled() == true) goto L20;
        this.a.a = r3;
        return;
    L20:
        return;
    L8:
        r3 = null;
        goto L9
    }
}
