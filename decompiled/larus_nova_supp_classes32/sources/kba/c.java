package kba;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.ui.ObricListeningVisualView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowVisibilityChangeListener {
    public static final /* synthetic */ int m = 0;
    public final View a;
    public final Function0<String> b;
    public final Function1<Float, Unit> c;
    public boolean d;
    public boolean e;
    public float f;
    public boolean g;
    public boolean h;
    public long i;
    public long j;
    public final d k;
    public final b l;

    public static final class a {
    }

    static {
    }

    public c() {
        throw null;
    }

    public final void a(String r9) {
        if (this.g == false) goto L6;
        this.g = false;
        this.a.removeCallbacks(this.l);
        FLogger.a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_start_cancelled: trigger=" + r9 + " mode=" + ((String) this.b.invoke()));
    L6:
        if (this.h == true) goto L8;
        return;
    L8:
        long r4 = SystemClock.uptimeMillis();
        this.h = false;
        this.a.removeCallbacks(this.k);
        FLogger.a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_stopped: trigger=" + r9 + " durationMs=" + (r4 - this.i) + " mode=" + ((String) this.b.invoke()));
        this.i = 0;
        this.j = 0;
    }

    public final void b(String r4) {
        if (this.d == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == true) goto L14;
        a(r4);
        return;
    L14:
        if (this.h == false) goto L16;
        return;
    L16:
        if (this.g == true) goto L23;
        this.g = true;
        FLogger.a.i("ListeningFakeAmplitudePlayer", "fake_amplitude_start_scheduled: trigger=" + r4 + " delayMs=1100 mode=" + ((String) this.b.invoke()));
        this.a.postDelayed(this.l, 1100);
        return;
    L23:
        return;
    L5:
        if (this.e == true) goto L11;
        if (this.a.isAttachedToWindow() == false) goto L11;
        if (this.a.getWindowVisibility() != 0) goto L11;
        r0 = true;
        goto L12
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.getViewTreeObserver().addOnWindowVisibilityChangeListener(this);
        b("view_attached");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3.isAlive() == false) goto L5;
        r3.removeOnWindowVisibilityChangeListener(this);
    L5:
        a("view_detached");
    }

    @Override // android.view.ViewTreeObserver.OnWindowVisibilityChangeListener
    public final void onWindowVisibilityChanged(int r1) {
        b("window_visibility_changed");
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [kba.b] */
    public c(ObricListeningVisualView r1, com.obric.assistant.activation.presentation.ui.b r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.f = kba.a.b(0);
        this.k = new d(this);
        this.l = new b(this);
        r1.addOnAttachStateChangeListener(this);
    }
}
