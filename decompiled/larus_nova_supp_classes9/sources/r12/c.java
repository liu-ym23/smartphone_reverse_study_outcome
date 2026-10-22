package r12;

import com.bytedance.android.livesdk.gift.model.p2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ e a;

    public c(e r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        p2 r2 = (p2) r1;
        this.a.finishWithSuccess();
    }
}
