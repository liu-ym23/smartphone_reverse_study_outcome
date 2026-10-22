package v5a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.VirtualDisplay;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import n5a.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public c a;
    public final Context b;
    public final int c;
    public final View.OnFocusChangeListener d;
    public final Surface e;
    public final SurfaceTexture f;
    public VirtualDisplay g;
    public int h;
    public int i;

    public static class a implements ViewTreeObserver.OnDrawListener {
        public final View a;
        public Runnable b;

        /* JADX INFO: renamed from: v5a.e$a$a, reason: collision with other inner class name */
        public class RunnableC0118a implements Runnable {
            public final /* synthetic */ a a;

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.getViewTreeObserver().removeOnDrawListener(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0118a(a r1) {
                this.a = r1;
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            Runnable r0 = this.b;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.run();
            this.b = null;
            this.a.post(new RunnableC0118a(this));
        }

        public a(View r1, d.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public e(Context r7, VirtualDisplay r8, o.a r9, Surface r10, SurfaceTexture r11, o.b r12, int r13) {
        this.b = r7;
        this.d = r12;
        this.e = r10;
        this.f = r11;
        this.g = r8;
        Resources r14 = r7.getResources();
        this.c = WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).densityDpi;
        c r15 = new c(r7, this.g.getDisplay(), r9, r13, r12);
        this.a = r15;
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r15);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
    }
}
