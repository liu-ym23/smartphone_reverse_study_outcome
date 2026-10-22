package tj0;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ g a;

    public d(g r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r4 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r3;
        Intrinsics.checkNotNullParameter(r4, "struct");
        g r0 = this.a;
        r0.getClass();
        return Single.defer(new a(r0, r4)).retryWhen(new b(r4)).map(new c(r4));
    }
}
