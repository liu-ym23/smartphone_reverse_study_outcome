package t19;

import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o implements Function1 {
    public /* synthetic */ o() {
    }

    public final Object invoke(Object r2) {
        LottieAdapterView r3 = (LottieAdapterView) r2;
        Intrinsics.checkNotNullParameter(r3, "$this$showWithLottie");
        r3.setRepeatMode(1);
        r3.setRepeatCount(-1);
        r3.setImageAssetsFolder("");
        if (r3.isAttachedToWindow() == false) goto L5;
        r3.setAnimation("lottie/toast_loading.json");
        r3.playAnimation();
    L7:
        return Unit.INSTANCE;
    L5:
        r3.addOnAttachStateChangeListener(new t(r3, r3));
        goto L7
    }
}
