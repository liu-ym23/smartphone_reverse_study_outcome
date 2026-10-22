package tj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<V> implements Callable {
    public final /* synthetic */ g a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.avatarmix.d b;

    public a(g r1, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final SingleSource<? extends Bitmap> call() {
        ALogger.d("MicseatMixer", "fetch bitmap, struct: " + this.b);
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a r0 = this.a.c;
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "struct");
        ConcurrentHashMap<String, Pair<String, Bitmap>> r2 = r0.a;
        int r3 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.b;
        Pair<String, Bitmap> r4 = r2.get(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C0097a.a(r1));
        if (r4 == null) goto L7;
        Bitmap r5 = (Bitmap) r4.getSecond();
    L8:
        if (r5 != null) goto L10;
    L12:
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.c r6 = this.a.d;
        if (r6 == null) goto L16;
        Intrinsics.checkNotNull(r6);
        return r6.a(this.b);
    L16:
        return Single.error(new Throwable("micseat view is null"));
    L10:
        if (r5.isRecycled() == true) goto L12;
        return Single.just(r5);
    L7:
        r5 = null;
        goto L8
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
