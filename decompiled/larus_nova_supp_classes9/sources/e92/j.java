package e92;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ k a;

    public j(k r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ApiServerException r5 = (Throwable) r4;
        k r0 = this.a;
        r0.c = false;
        if ((r5 instanceof ApiServerException) == false) goto L5;
        IESUIUtils.displayToast(r0.d, r5.getPrompt());
        return;
    L5:
        f2.b(2131919727, 0);
    }
}
