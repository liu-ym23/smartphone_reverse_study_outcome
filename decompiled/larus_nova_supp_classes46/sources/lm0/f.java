package lm0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Integer r3 = (Integer) r2;
        ALogger.d("ExitMicTimeLimitTrigger", "insert");
        e r4 = this.a;
        r4.d(r4.f);
    }
}
