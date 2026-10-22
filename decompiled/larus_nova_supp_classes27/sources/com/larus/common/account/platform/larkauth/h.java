package com.larus.common.account.platform.larkauth;

import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.api.ILoginService;
import com.larus.common_ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import n38.u;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements u {
    public final /* synthetic */ LarkAuthorization a;
    public final /* synthetic */ FragmentActivity b;

    public final void a() {
        this.a.getClass();
    }

    public final void b() {
        this.a.getClass();
        CommonDialog r0 = this.a.d;
        if (r0 == null) goto L13;
        r0.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public h(LarkAuthorization r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void c(int r18, String r110) {
        this.a.getClass();
        if (r18 != 1056) goto L20;
        CommonDialog r0 = this.a.d;
        if (r0 != null) goto L26;
    L12:
        this.a.getClass();
        ILoginService r1 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r1 == null) goto L15;
        r1.x(true, null, "enterprise_account_unavailable");
    L15:
        s r5 = s.a;
        FragmentActivity r6 = this.b;
        if (r110 != null) goto L18;
        String r7 = r6.getString(2131905546);
    L19:
        s.j(r5, r6, r7, null, false, 28);
        return;
    L18:
        r7 = r110;
        goto L19
    L26:
        r0.dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L12;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L12
    L20:
        s r11 = s.a;
        FragmentActivity r12 = this.b;
        if (r110 != null) goto L23;
        String r13 = r12.getString(2131910343);
    L24:
        s.j(r11, r12, r13, null, false, 28);
        return;
    L23:
        r13 = r110;
        goto L24
    }
}
