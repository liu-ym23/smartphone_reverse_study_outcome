package j8b;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements Consumer {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        if (r3 == null) goto L9;
        FileAuthMonitor.UpdateTrigger[] r0 = FileAuthMonitor.a;
        String r4 = r3.getMessage();
        if (r4 != null) goto L7;
        r4 = BuildConfig.FLAVOR;
    L7:
        FileAuthMonitor.i(r4);
        return;
    }
}
