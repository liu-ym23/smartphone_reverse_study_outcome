package com.bytedance.android.live.effect;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ LiveBeautifyDialogFragment b;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;

        public a(d r1) {
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
            this.a.b.dismiss();     // Catch: Exception -> L5 Throwable -> L10
        L20:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            return;
        }
    }

    public d(View r1, LiveBeautifyDialogFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        FrameLayout r4 = (FrameLayout) this.a.findViewById(2131372277);
        if (r4 == null) goto L5;
        r4.setVisibility(4);
    L5:
        ConstraintLayout r5 = this.b.S90(2131378622);
        if (r5 == null) goto L8;
        r5.setVisibility(4);
    L8:
        ConstraintLayout r6 = this.b.S90(2131378622);
        if (r6 == null) goto L12;
        r6.post(new a(this));
        return;
    }
}
