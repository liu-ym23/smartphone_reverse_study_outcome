package rp1;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r2) {
        ALogger.e("VSVideoProgressUtil", (Throwable) r2);
    }
}
