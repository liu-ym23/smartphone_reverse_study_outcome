package c72;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer a;

    public b(androidx.core.util.Consumer r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        ApiServerException r4 = (Throwable) r3;
        androidx.core.util.Consumer r0 = this.a;
        if (r0 == null) goto L6;
        r0.accept(Boolean.FALSE);
    L6:
        if ((r4 instanceof ApiServerException) == false) goto L16;
        ApiServerException r5 = r4;
        String r1 = r5.getPrompt();
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
        f2.c(r5.getPrompt(), 0);
        return;
    L10:
        if (r1.length() == 0) goto L13;
        r2 = false;
    L16:
        f2.b(2131923435, 0);
    }
}
