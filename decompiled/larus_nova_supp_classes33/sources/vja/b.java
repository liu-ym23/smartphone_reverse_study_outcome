package vja;

import android.app.Activity;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
        new mja.b();
    }

    @JvmStatic
    public static final void a(Activity r8, TransitionAnimStyle r9) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "animStyle");
        int r0 = a.a[r9.ordinal()];
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L6;
        TransitionAnimStyle r1 = r9;
    L8:
        String r3 = r8.getClass().getSimpleName();
        if (r9 == r1) goto L11;
        mja.a.C0063a r6 = mja.a.a;
        mja.a.b("TransitionAnimHelper", "overrideEnterAnim, " + r9 + " is deprecated: , use " + r1 + " instead, activity: " + r3);
    L12:
        int r2 = a.b[r1.ordinal()];
        if (r2 == 1) goto L23;
        if (r2 != 2) goto L16;
        r8.overridePendingTransition(2130772569, 2130772570);
        return;
    L16:
        if (r2 == 3) goto L21;
        mja.a.C0063a r10 = mja.a.a;
        String r11 = "overrideEnterAnim, unsupported anim style: " + r9 + "，activity: " + r3;
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        if (mja.a.a == null) goto L20;
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        return;
    L20:
        Intrinsics.checkNotNullParameter("TransitionAnimHelper", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        return;
    L21:
        r8.overridePendingTransition(2130772575, 2130772576);
        return;
    L23:
        r8.overridePendingTransition(2130772532, 2130772533);
        return;
    L11:
        mja.a.C0063a r7 = mja.a.a;
        mja.a.d("TransitionAnimHelper", "overrideEnterAnim, animStyle: " + r9 + "，activity: " + r3);
        goto L12
    L6:
        r1 = TransitionAnimStyle.Modal;
        goto L8
    L7:
        r1 = TransitionAnimStyle.Standard;
        goto L8
    }
}
