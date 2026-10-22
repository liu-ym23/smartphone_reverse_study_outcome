package n5a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import com.lynx.clay.embedding.android.FlutterView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements k {
    public final Context a;
    public final SurfaceTexture b;
    public final int c;
    public final View d;
    public final a e;
    public final b f;
    public v5a.e g;

    public class a implements v5a.a {
        public final /* synthetic */ View a;
        public final /* synthetic */ o b;

        public a(o r1, View r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements View.OnFocusChangeListener {
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r1, boolean r2) {
        }

        public b() {
        }
    }

    public class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }

        public c() {
        }
    }

    @Override // n5a.k
    public final void a(FlutterView r1) {
    }

    @Override // n5a.k
    public final void onViewDetached() {
    }

    @Override // n5a.k
    public final void b() {
        View r0 = this.d;
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    @Override // n5a.k
    public final void release() {
        a r0 = this.e;
        if (r0 == null) goto L8;
        v5a.e r1 = r0.b.g;
        if (r1 == null) goto L9;
        r1.a.cancel();
        v5a.c r2 = r1.a;
        r2.d.removeAllViews();
        r2.c.removeAllViews();
        r1.g.release();
        return;
    L9:
        return;
    }

    public o(Context r1, SurfaceTexture r2, int r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = new a(this, r4);
        this.f = new b();
    }

    @Override // n5a.k
    public final Size c(int r21, int r22, int r23, int r24) {
        v5a.e r10 = this.g;
        View r11 = null;
        v5a.e r12 = null;
        r12 = null;
        r12 = null;
        v5a.a r13 = null;
        if (r10 != null) goto L14;
        Context r14 = this.a;
        a r15 = this.e;
        SurfaceTexture r16 = this.b;
        int r17 = this.c;
        b r18 = this.f;
        Resources r2 = r14.getResources();
        WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics());
        if (r23 == 0) goto L12;
        if (r24 == 0) goto L12;
        r16.setDefaultBufferSize(r23, r24);
        Surface r7 = new Surface(r16);
        DisplayManager r1 = (DisplayManager) r14.getSystemService("display");
        Resources r3 = r14.getResources();
        VirtualDisplay r4 = r1.createVirtualDisplay("flutter-vd", r23, r24, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).densityDpi, r7, 0);
        if (r4 == null) goto L12;
        r12 = new v5a.e(r14, r4, r15, r7, r16, r18, r17);
        r12.h = r23;
        r12.i = r24;
    L12:
        this.g = r12;
    L39:
        if (this.g == null) goto L41;
        v5a.e r5 = this.g;
        return new Size(r5.h, r5.i);
    L41:
        return new Size(0, 0);
    L14:
        if (r23 == r10.h) goto L16;
    L17:
        c r19 = new c();
        v5a.c r6 = r10.a;
        if (r6 != null) goto L20;
        View r8 = null;
    L24:
        boolean r110 = r8.isFocused();
        v5a.c r9 = r10.a;
        r9.d.removeAllViews();
        r9.c.removeAllViews();
        v5a.c.e r111 = r9.e;
        r10.g.setSurface(null);
        r10.g.release();
        r10.h = r23;
        r10.i = r24;
        r10.f.setDefaultBufferSize(r23, r24);
        r10.g = ((DisplayManager) r10.b.getSystemService("display")).createVirtualDisplay("flutter-vd", r23, r24, r10.c, r10.e, 0);
        v5a.c r20 = r10.a;
        if (r20 == null) goto L32;
        v5a.a r25 = r20.e.a;
        if (r25 == null) goto L31;
        r13 = r25;
    L31:
        r11 = ((a) r13).a;
    L32:
        r11.addOnAttachStateChangeListener(new v5a.d(r11, r19));
        v5a.c r26 = new v5a.c(r10.b, r10.g.getDisplay(), r111, r10.d, r110);
        if (DialogLancet.shouldBlockDialogShow(r26) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r26);
    L37:
        r10.a.cancel();
        r10.a = r26;
        goto L39
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L36:
        DialogLancet.beforeDialogShow(r26);
        r26.show();
        DialogLancet.afterDialogShow(r26);
        goto L37
    L20:
        v5a.a r27 = r6.e.a;
        if (r27 != null) goto L23;
        r27 = null;
    L23:
        r8 = ((a) r27).a;
        goto L24
    L16:
        if (r24 == r10.i) goto L39;
        goto L17
    }
}
