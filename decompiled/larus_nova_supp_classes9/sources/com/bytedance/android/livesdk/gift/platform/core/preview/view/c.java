package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ UgcGiftPoolDialog a;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L15:
            this.a.a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
        L20:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            return;
        }
    }

    public c(UgcGiftPoolDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        View r4 = this.a.k;
        if (r4 == null) goto L5;
        r4.setVisibility(8);
    L5:
        UgcGiftPoolDialog r5 = this.a;
        int r0 = UgcGiftPoolDialog.r;
        r5.T90();
        MainThreadPostUtils.c(new a(this), 50);
    }
}
