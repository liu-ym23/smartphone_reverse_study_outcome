package rkb;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b extends SimpleTarget<Drawable> {
    public final ImageView a;

    public b(ImageView r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public void onLoadCleared(Drawable r3) {
        super.onLoadCleared(r3);
        this.a.setImageDrawable(null);
        this.a.setImageDrawable(r3);
    }
}
