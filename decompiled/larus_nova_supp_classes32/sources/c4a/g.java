package c4a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(BotModel r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (z2.a.chatImmerseEnable() == true) goto L8;
        return false;
    L8:
        if (r2.getBgImgOpen() == true) goto L10;
        return false;
    L10:
        if (o0.d(r2.getBgImgUrl()) == true) goto L12;
        return false;
    L12:
        if (o0.d(r2.getBgImgColor()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static void c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r0 = r2.getTag(2131383772);
        if ((r0 instanceof AnimatorSet) == false) goto L5;
        AnimatorSet r1 = (AnimatorSet) r0;
    L6:
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        r2.setScaleX(1.0f);
        r2.setScaleY(1.0f);
        r2.setAlpha(1.0f);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void b(View r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        c(r8);
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r8, "scaleX", new float[]{1.0f, 0.96f, 1.0f, 0.94f, 1.0f}).setDuration(1000);
        r2.setRepeatCount(-1);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r8, "scaleY", new float[]{1.0f, 0.96f, 1.0f, 0.94f, 1.0f}).setDuration(1000);
        r6.setRepeatCount(-1);
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r8, "alpha", new float[]{1.0f, 0.7f, 0.7f, 0.7f, 1.0f}).setDuration(1000);
        r1.setRepeatCount(-1);
        AnimatorSet.Builder r3 = r0.play(r2).with(r6);
        if (r9 == false) goto L5;
        r3.with(r1);
    L5:
        r0.start();
        r8.setTag(2131383772, r0);
    }
}
