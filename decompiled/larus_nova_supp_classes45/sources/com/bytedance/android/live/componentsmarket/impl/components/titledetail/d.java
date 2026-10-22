package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import zg1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            if (r3 != null) goto L4;
        L6:
            this.a.a.a.a.onTouchEvent(r3);
            return true;
        L4:
            if (r3.getAction() != 0) goto L6;
            xs2.b.a().post(new d0());
            goto L6
        }
    }

    public d(e r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Widget) this.a.a).contentView.setOnTouchListener(new a(this));     // Catch: Throwable -> L4
        ((Widget) this.a.a).contentView.setOnClickListener(f.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
