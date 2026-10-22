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
public final class r0 implements com.larus.share.impl.panel.g {
    public final /* synthetic */ kw9.f a;
    public final /* synthetic */ SheetShareDialogFragment b;

    @Override // com.larus.share.impl.panel.g
    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    @Override // com.larus.share.impl.panel.g
    public final void a(String r8) {
        com.larus.share.impl.e r0 = com.larus.share.impl.a.a;
        kw9.g r1 = this.a.d;
        com.larus.share.impl.a.o(r1.b, r8, r1.c, r1.d);
        kw9.f r2 = this.a;
        kw9.g r3 = r2.d;
        com.larus.share.impl.a.j(r3.b, r8, r2.c, r3.d);
        String r9 = this.b.d.d.a;
        if (r9 != null) goto L6;
        r9 = "";
    L6:
        if (ShareOfficeDocDelegate.b.a(ShareDocType.SHEET, r9) == false) goto L8;
        return;
    L8:
        if (((Boolean) this.b.g.getValue()).booleanValue() == true) goto L27;
        SheetShareDialogFragment r10 = this.b;
        FragmentActivity r4 = r10.getActivity();
        if (r4 == null) goto L28;
        FragmentManager r5 = r4.getSupportFragmentManager();
        if (r5 == null) goto L29;
        CommonDialog.a r6 = new CommonDialog.a();
        r6.i(r10.getString(2131909874));
        r6.g(r10.getString(2131909873));
        CommonDialog.a.f(r6, new s0(r10), r10.getString(2131909872), false, 12);
        Context r7 = r10.getContext();
        if (r7 != null) goto L17;
        r7 = AppHost.a.getApplication();
    L17:
        com.larus.common_ui.dialog.f0 r11 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r7, v19.c.b(2130972123, r10.getContext(), 2131103203))), null, 5);
        Intrinsics.checkNotNullParameter(r11, "commonDialogTextStyleConfig");
        r6.D = r11;
        CommonDialog.a.e(r6, new t0(), r10.getString(2131900202), 4);
        CommonDialog r12 = r6.a();
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, null, r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r12, r13) == true) goto L30;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L21:
        r12.show(r5, null);
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
        kw9.g r1 = this.a.d;
        com.larus.share.impl.a.q(r1.b, r4, r1.c, r1.d);
    }

    @Override // com.larus.share.impl.panel.g
    public final void e(String r4) {
        FLogger.a.i("SheetShareDialogFragment", "onShare: channel = " + r4);
    L11:
        e = move-exception;
        FLogger.a.e("SheetShareDialogFragment", "no argument constructor, dismiss failed", e);
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

    public r0(kw9.f r1, SheetShareDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.share.impl.panel.g
    public final boolean b(Context r6, DialogFragment r7, View r8, jr9.a r9) {
        Intrinsics.checkNotNullParameter(r9, "shareItemConfig");
        boolean r0 = false;
        if (Intrinsics.areEqual(r9.b(), "copy_feishu_link") == false) goto L20;
        IOfficePlatformService r10 = (IOfficePlatformService) ServiceManager.get().getService(IOfficePlatformService.class);
        kw9.f r2 = this.b.d;
        String r3 = null;
        if (r2 == null) goto L9;
        kw9.g r4 = r2.d;
        if (r4 == null) goto L9;
        String r5 = r4.a;
    L10:
        if (r10 == null) goto L17;
        if (r5 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L17;
        r3 = r10.a(IOfficePlatformService.FeishuDocType.SHEET, r5);
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
        kw9.f r11 = this.b.d;
        if (r11 == null) goto L26;
        kw9.g r12 = r11.d;
        if (r12 == null) goto L26;
        String r13 = r12.a;
        if (r13 == null) goto L26;
    L28:
        if (ShareOfficeDocDelegate.b.a(ShareDocType.SHEET, r13) == true) goto L33;
        if (((Boolean) this.b.g.getValue()).booleanValue() == true) goto L33;
        return true;
    L33:
        if (this.a.d.e == true) goto L36;
        FLogger.a.i("SheetShareDialogFragment", "needChangeShareContent: false");
        return false;
    L36:
        return true;
    L26:
        r13 = "";
        goto L28
    }
}
