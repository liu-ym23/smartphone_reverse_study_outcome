package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Consumer<Bitmap> {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L16;
        View r0 = this.a.a;
        if (r0 == null) goto L17;
        View r1 = r0.findViewById(2131374718);
        if (r1 == null) goto L15;
        ALogger.e("ToolbarRoomChannelBehavior", "load remote img.");
        r1.setBackground(new BitmapDrawable(r5));
        return;
    L15:
        return;
    L17:
        return;
    }
}
