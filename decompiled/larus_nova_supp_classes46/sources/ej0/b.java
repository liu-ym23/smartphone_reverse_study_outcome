package ej0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        ALogger.e("ttlive_link_paid", "handlePromptPaidLinkProfileManual failed " + ((Throwable) r3));
    }
}
