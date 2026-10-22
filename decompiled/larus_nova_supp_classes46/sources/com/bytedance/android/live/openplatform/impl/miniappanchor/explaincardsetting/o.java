package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements View.OnFocusChangeListener {
    public final /* synthetic */ ExplainCardTitleEditorDialog a;

    public static final class a implements Runnable {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditText r0 = (EditText) this.a.a.S90(2131388860);     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            EditText r1 = (EditText) this.a.a.S90(2131388860);     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            Editable r2 = r1.getText();     // Catch: Throwable -> L10
        L8:
            r0.setSelection(r2.toString().length());     // Catch: Throwable -> L10
            return;
        L7:
            r2 = null;
            goto L8
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public o(ExplainCardTitleEditorDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        if (r2 == false) goto L5;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    }
}
