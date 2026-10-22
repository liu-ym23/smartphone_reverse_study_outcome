package tj0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.avatarmix.d a;

    public b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r1) {
        this.a = r1;
    }

    public final Object apply(Object r4) {
        Flowable r5 = (Flowable) r4;
        Intrinsics.checkNotNullParameter(r5, "errors");
        ALogger.d("MicseatMixer", "retry fetch bitmap, struct: " + this.a);
        return r5.delay(1, TimeUnit.SECONDS).take(10);
    }
}
