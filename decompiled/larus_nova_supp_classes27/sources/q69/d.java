package q69;

import com.airbnb.lottie.LottieAnimationView;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public static final void a(LottieAnimationView r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.cancelAnimation();
        if (r3 == false) goto L5;
        String r0 = "charging";
    L6:
        r1.setContentDescription(r0);
        boolean r4 = h.a;
        if (h.a(null) == false) goto L11;
        if (r3 == false) goto L10;
        String r5 = "charging_dark";
    L14:
        r1.setAnimation(r5.concat("/data.json"));
        r1.setImageAssetsFolder(r5.concat("/images/"));
        float r6 = r2 / 100.0f;
        r1.setMinAndMaxProgress(r6, r6);
        r1.playAnimation();
        return;
    L10:
        r5 = "default_dark";
        goto L14
    L11:
        if (r3 == false) goto L13;
        r5 = "charging_light";
        goto L14
    L13:
        r5 = "default_light";
        goto L14
    L5:
        r0 = "not charging";
        goto L6
    }

    public static final void b(LottieAdapterView r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.cancelAnimation();
        if (r3 == false) goto L5;
        String r0 = "charging";
    L6:
        r1.setContentDescription(r0);
        boolean r4 = h.a;
        if (h.a(null) == false) goto L11;
        if (r3 == false) goto L10;
        String r5 = "charging_dark";
    L14:
        r1.setAnimation(r5.concat("/data.json"));
        r1.setImageAssetsFolder(r5.concat("/images/"));
        float r6 = r2 / 100.0f;
        r1.setMinAndMaxProgress(r6, r6);
        r1.playAnimation();
        return;
    L10:
        r5 = "default_dark";
        goto L14
    L11:
        if (r3 == false) goto L13;
        r5 = "charging_light";
        goto L14
    L13:
        r5 = "default_light";
        goto L14
    L5:
        r0 = "not charging";
        goto L6
    }
}
