package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.user.IUserService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ CommentSettingDialog a;

    public c(CommentSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        FragmentActivity r5 = this.a.getContext();
        if (r5 == null) goto L28;
        int r0 = PrivilegeSettingDetailDialog.l;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter("live_take_page", "from");
        if ((r5 instanceof FragmentActivity) == false) goto L26;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if ((r6.findFragmentByTag("PrivilegeSettingDetailDialog") instanceof PrivilegeSettingDetailDialog) == false) goto L16;
        PrivilegeSettingDetailDialog r1 = r6.findFragmentByTag("PrivilegeSettingDetailDialog");
        if (r1 == null) goto L15;
        PrivilegeSettingDetailDialog r2 = r1;
        r2.setAnimationType("right");
        r2.setShouldUseNewPanel(true);
        if (r2.isAdded() == true) goto L26;
        PrivilegeSettingDetailDialog.a.a(r2, r6);
    L17:
        HashMap r7 = new HashMap();
        r7.put("user_id", jc1.k.n(IUserService.class).user().n());
        r7.put("enter_from", "live_take_page");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_danmu_restriction_settings_show", r7, new Object[0]);
        goto L26
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.api.anchorsetting.PrivilegeSettingDetailDialog");
    L16:
        PrivilegeSettingDetailDialog.a.a(new PrivilegeSettingDetailDialog(), r6);
    L26:
        this.a.dismiss();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L29;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L29:
        return;
    }
}
