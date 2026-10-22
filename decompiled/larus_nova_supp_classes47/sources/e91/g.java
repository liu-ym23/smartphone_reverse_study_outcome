package e91;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ h a;
    public final /* synthetic */ k b;

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        this.a.a = false;
        ALogger.e("room_cert", "render cert UI failed：the image download fail");
    }

    public final void onNewResultImpl(Bitmap r5) {
        this.a.a = false;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L16;
        ImageView r0 = this.a.c;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getParent() == null) goto L15;
        this.a.b.b(r5, r0, this.b);
        r0.setImageBitmap(r5.copy(Bitmap.Config.ARGB_8888, false));
        this.a.b.onShow();
        return;
    L15:
        return;
    }

    public g(h r1, k r2) {
        this.a = r1;
        this.b = r2;
    }
}
