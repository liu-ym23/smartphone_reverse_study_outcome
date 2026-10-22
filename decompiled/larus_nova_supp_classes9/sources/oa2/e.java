package oa2;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements IHostFrescoHelper.GetBitmapCallBack {
    public final /* synthetic */ ChatCarnivalView a;

    public e(ChatCarnivalView r1) {
        this.a = r1;
    }

    public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
        ALogger.e("ChatCarnivalView", "load title image failed when warmup");
    }

    public final void onNewResultImpl(Bitmap r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isRecycled() == true) goto L24;
        Bitmap r5 = r4.copy(Bitmap.Config.ARGB_8888, false);
        if (r5 != null) goto L10;
        return;
    L10:
        if (r5.isRecycled() == true) goto L25;
        this.a.i.setImageBitmap(r5);
        int r1 = r5.getHeight() / 26;     // Catch: Exception -> L17
        if (r1 == 0) goto L18;
        int r6 = s1.f(r5.getWidth() / r1);     // Catch: Exception -> L17
        ViewGroup.LayoutParams r2 = this.a.i.getLayoutParams();     // Catch: Exception -> L17
        r2.width = r6;     // Catch: Exception -> L17
        this.a.i.setLayoutParams(r2);     // Catch: Exception -> L17
    L18:
        ALogger.i("ChatCarnivalView", "load title image success when warmup");
        return;
    L17:
        ALogger.e("ChatCarnivalView", "calculate image size error");
        goto L18
    L25:
        return;
    }
}
