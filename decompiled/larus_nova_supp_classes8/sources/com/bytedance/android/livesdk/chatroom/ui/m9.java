package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m9 implements View.OnFocusChangeListener {
    public final /* synthetic */ TicketPriceInputDialogFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ m9 a;

        public a(m9 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TicketPriceInputDialogFragment r0 = this.a.a;     // Catch: Throwable -> L7
            if (r0.f != null) goto L5;
            i40.h.a("show key board return, edit text view null");     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            com.bytedance.android.livesdk.utils.t2.b(r0.getContext(), r0.f);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    public m9(TicketPriceInputDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r3, boolean r4) {
        r3.postDelayed(new a(this), 100);
        r3.setOnFocusChangeListener(null);
    }
}
