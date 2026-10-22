package h6b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends SimpleTarget<Drawable> {
    public final /* synthetic */ b a;
    public final /* synthetic */ ImageView b;

    public final void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        this.b.setImageDrawable(this.a.b);
    }

    public final void onResourceReady(Object r4) {
        Drawable r5 = (Drawable) r4;
        super.onResourceReady(r5);
        if (r5 != null) goto L5;
    L7:
        this.b.setImageDrawable(r5);
        return;
    L5:
        if (this.a.f == null) goto L7;
        r5.mutate();
        r5.setTint(com.ss.android.lark.export.entity.preview.a.a(this.a.f, this.b.getContext(), null));
        goto L7
    }

    public d(b r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }
}
