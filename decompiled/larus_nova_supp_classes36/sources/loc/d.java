package loc;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends SimpleTarget<Drawable> {
    public final /* synthetic */ ImageView a;

    public d(ImageView r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r3) {
        super.onLoadFailed(r3);
        this.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.a.setImageDrawable(r3);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r2) {
        Drawable r3 = (Drawable) r2;
        if (r3 == null) goto L7;
        this.a.setImageDrawable(r3);
        return;
    }
}
