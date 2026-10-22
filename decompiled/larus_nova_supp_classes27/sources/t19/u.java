package t19;

import android.view.View;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ LottieAdapterView b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.setAnimation("lottie/toast_loading.json");
        this.b.playAnimation();
    }

    public u(View r1, LottieAdapterView r2) {
        this.a = r1;
        this.b = r2;
    }
}
