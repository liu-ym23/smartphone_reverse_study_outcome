package com.bytedance.android.live.room.navi.userinfo.cert;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ RoomImageLayoutController a;
    public final /* synthetic */ k b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        this.a.a = false;
        ALogger.e("room_cert", "render cert UI failed：the image download fail");
    }

    public final void onNewResultImpl(Bitmap r5) {
        Intrinsics.checkNotNullParameter(r5, "bitmap");
        this.a.a = false;
        if (r5.isRecycled() == false) goto L6;
        return;
    L6:
        if (this.a.c().getParent() == null) goto L9;
        RoomImageLayoutController r0 = this.a;
        r0.c.b(r5, r0.c(), this.b);
        this.a.c().setImageBitmap(r5.copy(Bitmap.Config.ARGB_8888, false));
        this.a.c.onShow();
        return;
    }

    public c(RoomImageLayoutController r1, k r2) {
        this.a = r1;
        this.b = r2;
    }
}
