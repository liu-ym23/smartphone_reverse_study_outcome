package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.graphics.Bitmap;
import android.text.Spannable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements yr2.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bitmap[] c;
    public final /* synthetic */ VideoGiftView d;

    public final void a(py.k r1) {
    }

    public final void b(Spannable r4, yr2.a.a r5) {
        if (this.d.getContext() != null) goto L5;
        return;
    L5:
        TextView r6 = new TextView(this.d.getContext());
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(this.a, this.b);
        r0.gravity = 17;
        r6.setLayoutParams(r0);
        r6.setMaxLines(1);
        r6.setText(r4);
        r6.setGravity(17);
        r6.setDrawingCacheEnabled(true);
        r6.measure(View.MeasureSpec.makeMeasureSpec(this.a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
        r6.layout(0, 0, r6.getMeasuredWidth(), r6.getMeasuredHeight());
        this.c[0] = Bitmap.createBitmap(r6.getDrawingCache());
        r6.destroyDrawingCache();
    }

    public m(VideoGiftView r1, int r2, int r3, Bitmap[] r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
