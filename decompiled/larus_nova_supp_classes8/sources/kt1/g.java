package kt1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements Consumer<Throwable> {
    public g() {
    }

    public final void accept(Object r2) throws Exception {
        ALogger.e("Diagnose", ((Throwable) r2).getMessage());
    }
}
