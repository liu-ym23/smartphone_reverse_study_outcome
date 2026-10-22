package tt1;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j<T> implements Consumer {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final void accept(Object r3) {
        f2.c("当前网络不佳，请稍后重试", 0);
        x8.a.c("anchor_highlight", (Throwable) r3, false);
    }
}
