package fx0;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        RxUtil.getNoOpThrowable();
        this.a.finishWithResult(new b.c(3, null));
    }
}
