package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ImageUtil.LoadImageCallback {
    public final /* synthetic */ BaseEnterView a;

    public final void onFailed(Exception r1) {
    }

    public b(BaseEnterView r1) {
        this.a = r1;
    }

    public final void onSuccess(Bitmap r2) {
        if (r2 == null) goto L10;
        HSImageView r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.setImageBitmap(r2);
    L6:
        this.a.invalidate();
        BaseEnterView r3 = this.a;
        e r1 = r3.g;
        if (r1 == null) goto L11;
        ((UserEnterLevelView) r1).e(r3);
        return;
    L11:
        return;
    }
}
