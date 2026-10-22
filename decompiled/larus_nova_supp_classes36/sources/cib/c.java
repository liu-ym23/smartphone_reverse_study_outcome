package cib;

import android.app.Activity;
import androidx.core.math.MathUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ForsetiMode a(Activity r1, Integer r2) {
        if (r2 == null) goto L13;
        r2.intValue();
        if (r1 == null) goto L6;
        b(r1, r2.intValue());
        if (r2.intValue() >= UIUtils.dp2px(r1, 636.0f)) goto L11;
        return ForsetiMode.Compact;
    L11:
        return ForsetiMode.Regular;
    L6:
        return ForsetiMode.Unknown;
    L13:
        return ForsetiMode.Unknown;
    }

    public static com.ss.android.lark.base.embedded.e b(Activity r4, int r5) {
        int r0 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.placeholder_cover_feed_disabled") == false) goto L5;
        int r1 = com.ss.android.lark.base.embedded.e.c;
        return com.ss.android.lark.base.embedded.e.a.b(r4, r5);
    L5:
        int r2 = com.ss.android.lark.base.embedded.e.c;
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 < com.ss.android.lark.base.embedded.e.a.a(r4, 854.0f)) goto L8;
        float r6 = r5;
        MathUtils.clamp(com.ss.android.lark.base.embedded.e.a.a(r4, 420.0f), MathKt.roundToInt(0.3f * r6), MathKt.roundToInt(r6 * 0.375f));
        com.ss.android.lark.base.embedded.e r7 = new com.ss.android.lark.base.embedded.e(com.ss.android.lark.base.embedded.e.a.a(r4, 854.0f), com.ss.android.lark.base.embedded.e.a.a(r4, 550.0f));
    L10:
        return r7;
    L8:
        r7 = new com.ss.android.lark.base.embedded.e(com.ss.android.lark.base.embedded.e.a.a(r4, 636.0f), com.ss.android.lark.base.embedded.e.a.a(r4, 550.0f));
        goto L10
    }
}
