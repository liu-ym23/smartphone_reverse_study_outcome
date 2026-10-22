package ny1;

import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r2) {
        CustomApiServerException r3 = (Throwable) r2;
        if ((r3 instanceof CustomApiServerException) == false) goto L6;
        int r0 = ToastUtil.a;
        ToastUtil.b(r3.getPrompt(), 0);
        return;
    }
}
