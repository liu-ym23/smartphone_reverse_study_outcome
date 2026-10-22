package tj0;

import android.graphics.Bitmap;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.avatarmix.d a;

    public c(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Bitmap r3 = (Bitmap) r2;
        Intrinsics.checkNotNullParameter(r3, "bitmap");
        return TuplesKt.to(this.a, r3);
    }
}
