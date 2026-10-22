package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.chatroom.widget.LandscapeBlockCommentWidget;
import com.bytedance.android.livesdk.config.a40;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.jvm.internal.Intrinsics;
import r52.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements yr1.a, com.bytedance.android.scope.o {
    public b() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // yr1.a
    public final boolean c() {
        return ((Boolean) s0.a.getValue()).booleanValue();
    }

    @Override // yr1.a
    public final String a() {
        return r3.b();
    }

    @Override // yr1.a
    public final void d(boolean r2) {
        if (r2 == false) goto L4;
        l42.a.d.setDefaultValue(BarrageSetting.getDefaultVSLiveSetting());
        return;
    L4:
        l42.a.d.setDefaultValue(new BarrageSetting());
    }

    @Override // yr1.a
    public final a f(ViewGroup r6) {
        Integer r0 = a40.a.getValue();
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L15:
        i40.g r7 = null;
    L16:
        if (r7 != null) goto L18;
        return null;
    L18:
        return new a(r7);
    L11:
        if (r0.intValue() != 2) goto L15;
        if (r6 == null) goto L14;
        r6.setWillNotDraw(false);
    L14:
        r7 = new i40.f();
        goto L16
    L6:
        if (r0.intValue() != 1) goto L8;
        r7 = new i40.g(false);
        goto L16
    }

    @Override // yr1.a
    public final void g(LottieAnimationView r2) {
        Intrinsics.checkNotNullParameter(r2, "ivLandscapeBlock");
        LandscapeBlockCommentWidget.b.getClass();
        LandscapeBlockCommentWidget.a.b(r2);
    }
}
