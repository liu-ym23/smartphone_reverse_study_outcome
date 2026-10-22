package s0b;

import com.ss.android.lark.officesdk.utils.di.j;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T> implements Consumer {
    public static final f<T> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r3) {
        j.c("CML_TAG_GeckoResManager", "executeCheckUpdate failed", (Throwable) r3);
    }
}
