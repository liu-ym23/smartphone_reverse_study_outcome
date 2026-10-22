package ys9;

import android.view.View;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.l;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Balloon a(final View r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r5, TplType.MENU);
        Balloon.a r0 = new Balloon.a(r4.getContext());
        r0.n(Integer.MIN_VALUE);
        r0.j(Integer.MIN_VALUE);
        r0.z = 16.0f;
        r0.e(ArrowPositionRules.ALIGN_BALLOON);
        r0.f(0);
        r0.p = 0.5f;
        r0.v = 0;
        r0.g(BalloonAnimation.FADE);
        r0.g0 = true;
        r0.h(true);
        r0.T = true;
        r0.l(new a(r4));
        r0.c(c.b(2130972060, r4.getContext(), 2131243034));
        Intrinsics.checkNotNullParameter(r5, "layout");
        r0.I = r5;
        Balloon r6 = r0.b();
        l.c(r4, "ext_balloon_pop", new WeakReference(r6));
        return r6;
    }
}
