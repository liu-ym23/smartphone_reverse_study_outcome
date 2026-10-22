package wpb;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements e {
    public final Bitmap a;

    public c(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        this.a = r2;
    }

    @Override // wpb.e
    public final Flowable<Bitmap> a(Drawable r1) {
        return Flowable.just(this.a);
    }
}
