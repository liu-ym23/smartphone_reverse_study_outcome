package p20;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        if (r3 == null) goto L5;
        String r4 = r3.getMessage();
    L6:
        ALogger.i("DebugHybridTools_JSB", String.valueOf(r4));
        return;
    L5:
        r4 = null;
        goto L6
    }
}
