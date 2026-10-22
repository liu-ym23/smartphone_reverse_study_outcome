package j41;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public d(int r2) {
        this.a = 720;
        this.b = r2;
    }

    public final Object apply(Object r4) {
        Bitmap r5 = (Bitmap) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        return Bitmap.createScaledBitmap(r5, this.a, this.b, false);
    }
}
