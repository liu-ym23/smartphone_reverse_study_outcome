package nlb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends SimpleTarget<Bitmap> {
    public final /* synthetic */ long a;
    public final /* synthetic */ g b;
    public final /* synthetic */ LargeImageView c;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r3) {
        LargeImageView r4 = this.c;
        g r0 = this.b;
        int r1 = LargeImageView.f;
        r4.s(r0);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r6) {
        Bitmap r7 = (Bitmap) r6;
        long r0 = System.currentTimeMillis() - this.a;
        this.c.r("get preview resource success, costTime:" + r0);
        if (this.c.n(this.b) == true) goto L6;
        this.c.q(this.b, r7);
        return;
    }

    public f(LargeImageView r1, long r2, g r4) {
        this.c = r1;
        this.a = r2;
        this.b = r4;
    }
}
