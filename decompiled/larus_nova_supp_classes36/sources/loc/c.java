package loc;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends SimpleTarget<Drawable> {
    public final /* synthetic */ SimpleTarget<Drawable> a;

    public c(com.suite.lark.platform.component.cta.newstyle.a r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        this.a.onLoadFailed(r2);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r2) {
        SimpleTarget<Drawable> r0 = this.a;
        r0.onResourceReady((Drawable) r2);
    }
}
