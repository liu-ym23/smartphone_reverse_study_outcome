package s9;

import com.bytedance.android.annie.Annie;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<T> implements Consumer {
    public static final d<T> a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void accept(Object r10) {
        int r0 = x8.a.a;
        x8.a.b(Annie.ANNIE_TAG, String.valueOf(((Throwable) r10).getMessage()), false);
    }
}
