package y81;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ l a;

    public c0(l r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        LottieAnimationView r3 = this.a.v;
        if (r3 == null) goto L6;
        r3.playAnimation();
        return;
    }
}
