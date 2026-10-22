package yc2;

import android.text.TextUtils;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    public final void accept(Object r2) {
        CustomApiServerException r3 = (Throwable) r2;
        if ((r3 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r4 = r3;
        if (TextUtils.isEmpty(r4.getPrompt()) == true) goto L9;
        f2.c(r4.getPrompt(), 0);
        return;
    L9:
        return;
    }
}
