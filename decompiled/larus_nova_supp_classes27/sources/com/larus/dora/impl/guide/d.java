package com.larus.dora.impl.guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraTextBtnBalloonBinding;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonCenterAlign;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class d extends DoraBaseGuide {
    public Balloon g;

    public abstract int A();

    public abstract int z();

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void h() {
        Balloon r0 = this.g;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        this.g = null;
        t();
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String k() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r0 != null) goto L6;
        return "DoraBalloonGuide";
    L6:
        return r0;
    }

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        super(r2);
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void x(j59.a r5, final Fragment r6, View r7) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r5, "state");
        g49.d.d(k(), "show() called, fragment=" + r6 + ", anchorView=" + r7 + ", state=" + r5);
        if (r6 == null) goto L6;
        Context r8 = r6.getContext();
        if (r8 == null) goto L6;
    L7:
        final LarusDoraTextBtnBalloonBinding r9 = LarusDoraTextBtnBalloonBinding.a(LayoutInflater.from(r8));
        TextView r0 = r9.d;
        int r1 = j0.a;
        r0.setText(j0.d(A()));
        r9.b.setText(j0.d(z()));
        e1.d(r9.b, new b(this, r6));
        e1.d(r9.c, new c(this, r9));
        if (r6 == null) goto L11;
        Context r2 = r6.getContext();
        if (r2 == null) goto L11;
    L12:
        Balloon.a r3 = new Balloon.a(r2);
        r3.d = 1.0f;
        r3.j(86);
        r3.z = 16.0f;
        r3.e(ArrowPositionRules.ALIGN_BALLOON);
        r3.f(0);
        r3.p = 0.5f;
        r3.v = 0;
        r3.g(BalloonAnimation.FADE);
        r3.g0 = false;
        r3.W = r6;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L15;
        long r10 = r4.t();
    L16:
        r3.V = r10;
        r3.h(false);
        r3.k(r9);
        r3.l(new a(this));
        Balloon r11 = r3.b();
        this.g = r11;
        r9.a.setTag(r11);
        if (r7 == null) goto L19;
        r11.s(r7, 0, c7.b(8));
        return;
    L19:
        if (r6 == null) goto L21;
        View r12 = r6.getView();
    L22:
        if (r12 == null) goto L24;
        r11.y(r12, 0, 0, BalloonCenterAlign.TOP);
        return;
    L24:
        g49.d.b(k(), "show() failed: no anchor and fragment view is null");
        y(404);
        q();
        return;
    L21:
        r12 = null;
        goto L22
    L15:
        r10 = 10000;
    L11:
        r2 = AppHost.a.getApplication();
    L6:
        r8 = AppHost.a.getApplication();
        goto L7
    }
}
