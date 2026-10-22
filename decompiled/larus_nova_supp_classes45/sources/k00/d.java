package k00;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        ALogger.e("AnchorShareListHelper", r4.toString(), r4);
        r4.printStackTrace();
    }
}
