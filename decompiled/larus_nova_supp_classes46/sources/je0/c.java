package je0;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Function0 c;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
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

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.getHeight() <= 0) goto L13;
        ViewTreeObserver r0 = this.a.getViewTreeObserver();
        if (r0 == null) goto L7;
        r0.removeOnGlobalLayoutListener(this);
    L7:
        long r1 = this.b;
        if (r1 != 0) goto L11;
        this.c.invoke();
        return;
    L11:
        this.a.postDelayed(new a(this), r1);
        return;
    }

    public c(View r1, long r2, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
