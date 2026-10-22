package tj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ g a;

    public e(g r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Pair r6 = (Pair) r5;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r0 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r6.component1();
        Bitmap r7 = (Bitmap) r6.component2();
        ALogger.d("MicseatMixer", "get bitmap success, struct: " + r0);
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a r1 = this.a.c;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "struct");
        Intrinsics.checkNotNullParameter(r7, "cache");
        ConcurrentHashMap<String, Pair<String, Bitmap>> r2 = r1.a;
        int r3 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.b;
        r2.put(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C0097a.a(r0), TuplesKt.to(r0.c, r7));
    L5:
        this.a.f.b(r0, r7.copy(Bitmap.Config.ARGB_8888, false));
    }
}
