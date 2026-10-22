package com.larus.dora.impl.guide;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.guide.widget.DoraGuideBottomSheetDialogFragment;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class a0 extends DoraBaseGuide {
    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final String k() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r0 != null) goto L6;
        return "DoraDialogGuide";
    L6:
        return r0;
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void h() {
        t();
    }

    public a0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "page");
        super(r2);
    }

    @Override // com.larus.dora.impl.guide.DoraBaseGuide
    public final void x(j59.a r8, Fragment r9, View r10) {
        Intrinsics.checkNotNullParameter(r8, "state");
        if (r9 != null) goto L5;
    L31:
        g49.d.b(k(), "showDialog() failed: fragment is null or detached");
        t();
        return;
    L5:
        if (r9.isDetached() == true) goto L31;
        DoraNotificationGuide r0 = (DoraNotificationGuide) this;
        Intrinsics.checkNotNullParameter(r8, "state");
        Intrinsics.checkNotNullParameter(r9, "fragment");
        g49.d.d(r0.k(), "showDialog() called, fragment=" + r9 + ", isResumed=" + r9.isResumed() + ", isAdded=" + r9.isAdded());
        if (r9.isAdded() == true) goto L10;
        g49.d.b(r0.k(), "showDialog() failed: fragment is not added");
        r0.t();
        return;
    L10:
        FragmentManager r11 = r9.getParentFragmentManager();
        if (r11.isStateSaved() == false) goto L14;
        g49.d.b(r0.k(), "showDialog() failed: fragment manager state is saved");
        r0.t();
        return;
    L14:
        if (r11.findFragmentByTag(r0.k()) == null) goto L16;
        g49.d.d(r0.k(), "showDialog() skipped: dialog already showing");
        return;
    L16:
        int r12 = DoraGuideBottomSheetDialogFragment.l;
        boolean r13 = v19.h.a;
        if (v19.h.b(AppHost.a.getApplication()) == false) goto L19;
        String r14 = "dark";
    L20:
        String r15 = StringsKt.replace$default("https://p3-starweave-source.byteimg.com/user_guide/image_dora_notification_common_avatar_${light_mode}.png", "${light_mode}", r14, false, 4, null);
        StringBuilder r1 = new StringBuilder();
        int r2 = j0.a;
        r1.append(j0.d(2131903933));
        r1.append(j0.d(2131900385));
        String r3 = r1.toString();
        String r4 = j0.d(2131903655);
        String r5 = j0.d(2131902193);
        Integer r6 = Integer.valueOf(v19.c.b(2130971221, null, 2131166811));
        Intrinsics.checkNotNullParameter(r15, "avatarUrl");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        Intrinsics.checkNotNullParameter(r5, "confirmText");
        DoraGuideBottomSheetDialogFragment r7 = new DoraGuideBottomSheetDialogFragment();
        r7.e = r15;
        r7.f = r3;
        r7.g = r4;
        r7.h = r5;
        r7.i = r6;
        r7.j = false;
        r7.d = new h0(r0, r9, r7);
        String r16 = r0.k();     // Catch: Exception -> L28
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L28
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, r16, r17);     // Catch: Exception -> L28
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r7, r17) == false) goto L34;
    L26:
        g49.d.d(r0.k(), "dialog.show() called successfully");     // Catch: Exception -> L28
        return;
    L34:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
    L25:
        r7.show(r11, r16);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        g49.d.c(r0.k(), "dialog.show() failed with exception: " + e.getMessage(), e);
        r0.t();
        return;
    L19:
        r14 = "light";
        goto L20
    }
}
