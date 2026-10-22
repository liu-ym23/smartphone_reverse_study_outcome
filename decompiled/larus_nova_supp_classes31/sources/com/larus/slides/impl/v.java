package com.larus.slides.impl;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.office.base.view.CotHeaderView;
import com.larus.slides.biz.impl.databinding.LarusLayoutSlidesDetailFragmentBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v implements ax9.a {
    public final /* synthetic */ SlidesFragment a;

    @Override // ax9.a
    public final void a() {
        this.a.ba0();
        final SlidesFragment r0 = this.a;
        LarusLayoutSlidesDetailFragmentBinding r1 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r0).e;
        if (r1 == null) goto L8;
        FrameLayout r2 = r1.f;
        if (r2 == null) goto L9;
        r2.postDelayed(new u(r0), 500);
        return;
    L9:
        return;
    }

    @Override // ax9.a
    public final void b() {
        FLogger.a.i("SlidesFragment", "notifyRenderFinish");
        SlidesFragment r0 = this.a;
        r0.N = false;
        LarusLayoutSlidesDetailFragmentBinding r1 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r0).e;
        if (r1 == null) goto L7;
        CotHeaderView r2 = r1.e;
        if (r2 == null) goto L7;
        e1.o(r2);
    L7:
        SlidesFragment r3 = this.a;
        r3.D = false;
        Fragment r4 = ((OfficeBaseFragment) r3).f;
        if (r4 == null) goto L15;
        t1a.b r5 = s1a.a.g(r4);
        if (r5 == null) goto L16;
        va8.k0 r6 = r5.getAbility(va8.k0.class);
        if (r6 == null) goto L17;
        r6.KI();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // ax9.a
    public final void c() {
        FLogger.a.i("SlidesFragment", "notifyRenderStart");
        this.a.D = true;
    }

    @Override // ax9.a
    public final int getChatInputHeight() {
        SlidesFragment r0 = this.a;
        int r1 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r2 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r0).e;
        if (r2 == null) goto L7;
        FrameLayout r3 = r2.f;
        if (r3 == null) goto L7;
        View r4 = r3.findViewById(2131375324);
    L8:
        if (r4 == null) goto L10;
        int r5 = r4.getHeight();
    L11:
        if (r5 <= 0) goto L13;
        return r5;
    L13:
        return c7.b(110);
    L10:
        r5 = 0;
    L7:
        r4 = null;
        goto L8
    }

    @Override // ax9.a
    public final void requestChatInputFocus() {
        SlidesFragment r0 = this.a;
        int r1 = SlidesFragment.O;
        LarusLayoutSlidesDetailFragmentBinding r2 = (LarusLayoutSlidesDetailFragmentBinding) ((OfficeBaseFragment) r0).e;
        boolean r3 = false;
        if (r2 == null) goto L9;
        FrameLayout r4 = r2.f;
        if (r4 == null) goto L9;
        if (r4.getVisibility() != 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L24;
        Fragment r6 = ((OfficeBaseFragment) this.a).f;
        if (r6 == null) goto L16;
        t1a.b r7 = s1a.a.g(r6);
        if (r7 == null) goto L16;
        va8.o r8 = (va8.o) r7.getAbility(va8.o.class);
    L17:
        if (r8 != null) goto L19;
    L21:
        if (r3 == false) goto L25;
        va8.o.a.a(r8, true);
        r8.i00();
        return;
    L25:
        return;
    L19:
        if (r8.hh() == true) goto L21;
        r3 = true;
    L16:
        r8 = null;
        goto L17
    L24:
        return;
    L9:
        r5 = false;
        goto L10
    }

    public v(SlidesFragment r1) {
        this.a = r1;
    }
}
