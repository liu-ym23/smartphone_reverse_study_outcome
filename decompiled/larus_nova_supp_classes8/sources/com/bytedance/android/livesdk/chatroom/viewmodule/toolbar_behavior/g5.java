package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.android.livesdk.widget.VSShareReverseView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g5 implements Consumer<Bitmap> {
    public final /* synthetic */ View a;
    public final /* synthetic */ e5 b;

    public final void accept(Object r4) throws Exception {
        Bitmap r5 = (Bitmap) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRecycled() == true) goto L21;
        View r0 = this.b.h;
        if (r0 == null) goto L22;
        View r1 = r0.findViewById(2131374718);
        VSShareReverseView r2 = this.a;
        if (r2 != null) goto L13;
    L15:
        if (r1 == null) goto L20;
        r1.setBackground(new BitmapDrawable(r5));
        return;
    L20:
        return;
    L13:
        if ((r2 instanceof VSShareReverseView) == false) goto L15;
        r2.setImageDrawable(new BitmapDrawable(r5));
        return;
    L22:
        return;
    }

    public g5(e5 r1, VSShareReverseView r2) {
        this.b = r1;
        this.a = r2;
    }
}
