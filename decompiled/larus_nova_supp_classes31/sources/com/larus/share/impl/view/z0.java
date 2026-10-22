package com.larus.share.impl.view;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.platform.service.IOfficePlatformService;
import com.larus.share.service.ShareDocType;
import com.larus.share.service.ShareOfficeDocDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class z0 implements com.larus.share.impl.panel.g {
    public final /* synthetic */ kw9.i a;
    public final /* synthetic */ SlidesShareDialogFragment b;

    @Override // com.larus.share.impl.panel.g
    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    @Override // com.larus.share.impl.panel.g
    public final void a(String r8) {
        com.larus.share.impl.e r0 = com.larus.share.impl.a.a;
        kw9.j r1 = this.a.d;
        com.larus.share.impl.a.o(r1.b, r8, r1.c, r1.d);
        kw9.i r2 = this.a;
        kw9.j r3 = r2.d;
        com.larus.share.impl.a.j(r3.b, r8, r2.c, r3.d);
        ShareOfficeDocDelegate r9 = ShareOfficeDocDelegate.b;
        ShareDocType r4 = ShareDocType.SLIDES;
        String r5 = this.b.d.d.a;
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r9.a(r4, r5) == false) goto L8;
        return;
    L8:
        if (((Boolean) this.b.g.getValue()).booleanValue() == true) goto L27;
        SlidesShareDialogFragment r10 = this.b;
        FragmentActivity r6 = r10.getActivity();
        if (r6 == null) goto L28;
        FragmentManager r7 = r6.getSupportFragmentManager();
        if (r7 == null) goto L29;
        CommonDialog.a r11 = new CommonDialog.a();
        r11.i(r10.getString(2131909874));
        r11.g(r10.getString(2131909873));
        CommonDialog.a.f(r11, new a1(r10), r10.getString(2131909872), false, 12);
        Context r12 = r10.getContext();
        if (r12 != null) goto L17;
        r12 = AppHost.a.getApplication();
    L17:
        com.larus.common_ui.dialog.f0 r13 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r12, v19.c.b(2130972123, r10.getContext(), 2131103203))), null, 5);
        Intrinsics.checkNotNullParameter(r13, "commonDialogTextStyleConfig");
        r11.D = r13;
        CommonDialog.a.e(r11, new b1(), r10.getString(2131900202), 4);
        CommonDialog r14 = r11.a();
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, null, r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r14, r15) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L21:
        r14.show(r7, null);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // com.larus.share.impl.panel.g
    public final void c(String r4) {
        com.larus.share.impl.e r0 = com.larus.share.impl.a.a;
        kw9.j r1 = this.a.d;
        com.larus.share.impl.a.q(r1.b, r4, r1.c, r1.d);
    }

    @Override // com.larus.share.impl.panel.g
    public final void e(String r4) {
        FLogger.a.i("SlidesShareDialogFragment", "onShare: channel = " + r4);
    L11:
        e = move-exception;
        FLogger.a.e("SlidesShareDialogFragment", "no argument constructor, dismiss failed", e);
        return;
    L14:
        this.b.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L19:
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L11
        Throwable r5 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L11
        if (r5 == null) goto L18;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L11
        return;
    }

    public z0(kw9.i r1, SlidesShareDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.share.impl.panel.g
    public final boolean b(Context r6, DialogFragment r7, View r8, jr9.a r9) {
        Intrinsics.checkNotNullParameter(r9, "shareItemConfig");
        boolean r0 = false;
        if (Intrinsics.areEqual(r9.b(), "copy_feishu_link") == false) goto L20;
        IOfficePlatformService r10 = (IOfficePlatformService) ServiceManager.get().getService(IOfficePlatformService.class);
        kw9.i r2 = this.b.d;
        String r3 = null;
        if (r2 == null) goto L9;
        kw9.j r4 = r2.d;
        if (r4 == null) goto L9;
        String r5 = r4.a;
    L10:
        if (r10 == null) goto L17;
        if (r5 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L17;
        r3 = r10.a(IOfficePlatformService.FeishuDocType.SLIDES, r5);
        goto L17
    L13:
        if (r5.length() != 0) goto L15;
    L17:
        if (r10 == null) goto L19;
        r10.b(r6, r3, r7, r9);
    L19:
        return true;
    L9:
        r5 = null;
        goto L10
    L20:
        ShareOfficeDocDelegate r11 = ShareOfficeDocDelegate.b;
        ShareDocType r12 = ShareDocType.SLIDES;
        kw9.i r13 = this.b.d;
        if (r13 == null) goto L26;
        kw9.j r14 = r13.d;
        if (r14 == null) goto L26;
        String r15 = r14.a;
        if (r15 == null) goto L26;
    L28:
        if (r11.a(r12, r15) == true) goto L33;
        if (((Boolean) this.b.g.getValue()).booleanValue() == true) goto L33;
        return true;
    L33:
        if (this.a.d.e == true) goto L36;
        FLogger.a.i("SlidesShareDialogFragment", "needChangeShareContent: false");
        return false;
    L36:
        return true;
    L26:
        r15 = "";
        goto L28
    }
}
