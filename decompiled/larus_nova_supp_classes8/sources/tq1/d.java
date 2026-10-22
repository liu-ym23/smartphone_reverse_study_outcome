package tq1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ALogger.e("ReplayListDataProvider", "fetch series error", (Throwable) r3);
        this.a.g.setValue(Boolean.FALSE);
    }
}
