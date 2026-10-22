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
public final class g implements com.larus.share.impl.panel.g {
    public final /* synthetic */ kw9.b a;
    public final /* synthetic */ DriveShareDialogFragment b;

    @Override // com.larus.share.impl.panel.g
    public final boolean d(String r1, String r2, Boolean r3) {
        return true;
    }

    @Override // com.larus.share.impl.panel.g
    public final void a(String r8) {
        com.larus.share.impl.e r0 = com.larus.share.impl.a.a;
        kw9.d r1 = this.a.b;
        com.larus.share.impl.a.o(r1.c, r8, r1.d, r1.e);
        ShareOfficeDocDelegate r9 = ShareOfficeDocDelegate.b;
        ShareDocType r2 = ShareDocType.DRIVE;
        String r3 = this.a.b.a;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        if (r9.a(r2, r3) == false) goto L8;
        return;
    L8:
        if (((Boolean) this.b.g.getValue()).booleanValue() == true) goto L27;
        DriveShareDialogFragment r10 = this.b;
        FragmentActivity r4 = r10.getActivity();
        if (r4 == null) goto L28;
        FragmentManager r5 = r4.getSupportFragmentManager();
        if (r5 == null) goto L29;
        CommonDialog.a r6 = new CommonDialog.a();
        r6.i(r10.getString(2131909874));
        r6.g(r10.getString(2131909873));
        CommonDialog.a.f(r6, new h(r10), r10.getString(2131909872), false, 12);
        Context r7 = r10.getContext();
        if (r7 != null) goto L17;
        r7 = AppHost.a.getApplication();
    L17:
        com.larus.common_ui.dialog.f0 r11 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r7, v19.c.b(2130972123, r10.getContext(), 2131103203))), null, 5);
        Intrinsics.checkNotNullParameter(r11, "commonDialogTextStyleConfig");
        r6.D = r11;
        CommonDialog.a.e(r6, new i(), r10.getString(2131900202), 4);
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
        kw9.d r1 = this.a.b;
        com.larus.share.impl.a.q(r1.c, r4, r1.d, r1.e);
    }

    @Override // com.larus.share.impl.panel.g
    public final void e(String r4) {
        FLogger.a.i("DriveShareDialogFragment", "onShare: channel = " + r4);
    L11:
        e = move-exception;
        FLogger.a.e("DriveShareDialogFragment", "no argument constructor, dismiss failed", e);
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

    public g(kw9.b r1, DriveShareDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.larus.share.impl.panel.g
    public final boolean b(Context r6, DialogFragment r7, View r8, jr9.a r9) {
        Intrinsics.checkNotNullParameter(r9, "shareItemConfig");
        boolean r0 = false;
        if (Intrinsics.areEqual(r9.b(), "copy_feishu_link") == false) goto L27;
        IOfficePlatformService r10 = (IOfficePlatformService) ServiceManager.get().getService(IOfficePlatformService.class);
        kw9.d r2 = this.a.b;
        String r3 = r2.a;
        int r4 = r2.b;
        if (r10 != null) goto L7;
    L19:
        if (r7 != null) goto L40;
    L26:
        return true;
    L40:
        r7.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L26;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L26
    L7:
        if (r10.c(Integer.valueOf(r4)) == false) goto L19;
        IOfficePlatformService.FeishuDocType r5 = r10.d(Integer.valueOf(r4));
        if (r5 == null) goto L16;
        if (r3 != null) goto L12;
    L13:
        r0 = true;
    L14:
        if (r0 == true) goto L16;
        String r1 = r10.a(r5, r3);
    L17:
        r10.b(r6, r1, r7, r9);
        return true;
    L12:
        if (r3.length() != 0) goto L14;
    L16:
        r1 = null;
        goto L17
    L27:
        ShareOfficeDocDelegate r12 = ShareOfficeDocDelegate.b;
        ShareDocType r13 = ShareDocType.DRIVE;
        String r14 = this.a.b.a;
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        if (r12.a(r13, r14) == true) goto L36;
        if (((Boolean) this.b.g.getValue()).booleanValue() == true) goto L36;
        return true;
    L36:
        if (this.a.b.f == true) goto L39;
        FLogger.a.i("DriveShareDialogFragment", "[setupSharePanel] needChangeShareContent: false");
        return false;
    L39:
        return true;
    }
}
