package kw0;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r1) {
        Throwable r2 = (Throwable) r1;
        RxUtil.getNoOpThrowable();
    }
}
