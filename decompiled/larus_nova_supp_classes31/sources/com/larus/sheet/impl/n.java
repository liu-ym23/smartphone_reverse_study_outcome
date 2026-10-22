package com.larus.sheet.impl;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.sheet.biz.impl.databinding.LarusLayoutSheetDetailFragmentBinding;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n implements pw9.a {
    public final /* synthetic */ SheetFragment a;

    @Override // pw9.a
    public final void a() {
        this.a.ba0();
        final SheetFragment r0 = this.a;
        LarusLayoutSheetDetailFragmentBinding r1 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r0).e;
        if (r1 == null) goto L8;
        FrameLayout r2 = r1.f;
        if (r2 == null) goto L9;
        r2.postDelayed(new m(r0), 500);
        return;
    L9:
        return;
    }

    @Override // pw9.a
    public final int b() {
        SheetFragment r0 = this.a;
        int r1 = SheetFragment.R;
        return r0.ha0();
    }

    @Override // pw9.a
    public final int getChatInputHeight() {
        SheetFragment r0 = this.a;
        int r1 = SheetFragment.R;
        return r0.ia0();
    }

    @Override // pw9.a
    public final void requestChatInputFocus() {
        SheetFragment r0 = this.a;
        int r1 = SheetFragment.R;
        LarusLayoutSheetDetailFragmentBinding r2 = (LarusLayoutSheetDetailFragmentBinding) ((OfficeBaseFragment) r0).e;
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

    public n(SheetFragment r1) {
        this.a = r1;
    }

    @Override // pw9.a
    public final void c(boolean r5) {
        SheetFragment r0 = this.a;
        r0.getClass();
        FLogger.a.i("SheetFragment", "setChatInputVisible() called with: isVisible = " + r5);
        Fragment r1 = ((OfficeBaseFragment) r0).f;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isAdded() == false) goto L9;
        r0.ra0(r5, "setSlidesChatInputVisible");
        return;
    }
}
