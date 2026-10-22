package com.ss.android.lark.movable.selection;

import android.view.View;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ o b;

    public static final class a implements Runnable {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public l(LinearLayout r1, o r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.post(new a(this.b));
    }
}
