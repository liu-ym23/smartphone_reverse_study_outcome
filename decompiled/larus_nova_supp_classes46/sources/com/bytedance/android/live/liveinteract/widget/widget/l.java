package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ LinkDistributeSettingDialog b;

    public static final class a implements LinkDistributionHelpDialog.a {
        public final /* synthetic */ l a;

        @Override // com.bytedance.android.live.liveinteract.widget.widget.LinkDistributionHelpDialog.a
        public final void onBackPressed() {
            LinkDistributeSettingDialog r0 = this.a.b;
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r0);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
        }

        public a(l r1) {
            this.a = r1;
        }
    }

    public l(String r1, LinkDistributeSettingDialog r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.LinkDistributeSettingDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        LinkDistributionHelpDialog r6 = new LinkDistributionHelpDialog(this.a, new a(this));
        ?? r0 = this.b;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r0);
    L17:
        LiveDialogFragment.a r2 = LiveDialogFragment.Companion;
        FragmentActivity r3 = ContextUtil.contextToFragmentActivity(this.b.getContext());
        r2.getClass();
        LiveDialogFragment.a.a(r3, r6);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L17
    }
}
