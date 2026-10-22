package v5a;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import n5a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ Runnable b;

    public class a implements Runnable {
        public final /* synthetic */ d a;

        @Override // java.lang.Runnable
        public final void run() {
            d r0 = this.a;     // Catch: Throwable -> L4
            r0.a.postDelayed(r0.b, 128);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r1) {
            this.a = r1;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r3) {
        View r4 = this.a;
        e.a r1 = new e.a(r4, new a(this));
        r4.getViewTreeObserver().addOnDrawListener(r1);
        this.a.removeOnAttachStateChangeListener(this);
    }

    public d(View r1, o.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
