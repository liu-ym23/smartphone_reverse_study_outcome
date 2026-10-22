package com.larksuite.component.card.component.lottie;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00122\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0012B\u0013\b\u0014\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0014\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/component/lottie/LottieUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/airbnb/lottie/LottieAnimationView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "param", "", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "createView", "Landroid/content/Context;", "setSrc", "", "src", "", "getRes", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class LottieUI extends LynxUI<LottieAnimationView> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public LottieUI(LynxContext r1) {
        super(r1);
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        LottieAnimationView r0 = new LottieAnimationView(r2);
        r0.setRepeatCount(-1);
        return r0;
    }

    @LynxProp(name = "src")
    public final void setSrc(String r3) {
        Uri r4 = UriProtector.parse(r3);
        if (Intrinsics.areEqual("raw", r4.getScheme()) == false) goto L9;
        String r5 = r4.getHost();
        if (r5 == null) goto L9;
        if (Intrinsics.areEqual(r5, "loading_anim") == false) goto L9;
        int r6 = 2131820626;
    L10:
        if ((-1) == r6) goto L18;
        LottieAnimationView r0 = ((LynxUI) this).mView;
        if (r0 == null) goto L14;
        r0.setAnimation(r6);
    L14:
        LottieAnimationView r7 = ((LynxUI) this).mView;
        if (r7 == null) goto L19;
        r7.playAnimation();
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r6 = -1;
        goto L10
    }
}
