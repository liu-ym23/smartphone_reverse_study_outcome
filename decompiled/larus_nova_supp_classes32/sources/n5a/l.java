package n5a;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.plugin.platform.PlatformViewsController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements k {
    public final int a;
    public final View b;
    public final PlatformViewsController c;

    @Override // n5a.k
    public final void a(FlutterView r1) {
    }

    @Override // n5a.k
    public final void onViewDetached() {
    }

    @Override // n5a.k
    public final void release() {
    }

    @Override // n5a.k
    public final void b() {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public final void d(m r5) {
        PlatformViewsController r0 = this.c;
        int r1 = this.a;
        r0.e.put(r1, true);
        r0.f.put(r1, r5);
        e5a.a r2 = r0.g.get(r1);
        if (r2 == null) goto L6;
        r2.setSystemTouchDispatchEnabled(true);
        r2.setTouchDispatchResultListener(r5);
        return;
    }

    public l(FlutterView r2, int r3, View r4, boolean r5) {
        this.a = r3;
        this.b = r4;
        FlutterEngine r6 = r2.getAttachedFlutterEngine();
        if (r6 == null) goto L20;
        PlatformViewsController r7 = r6.f;
        this.c = r7;
        r7.getClass();
        r4.setWillNotDraw(false);
        r7.d.put(r3, r4);
        View r8 = r7.d.get(r3);
        if (r8 == null) goto L7;
        r8.setWillNotDraw(!r5);
    L7:
        e5a.a r9 = r7.g.get(r3);
        if (r9 == null) goto L21;
        ViewGroup r10 = (ViewGroup) r9.getParent();
        if (r5 == true) goto L13;
        if (r10 == null) goto L13;
        r10.removeView(r9);
        return;
    L13:
        if (r5 == false) goto L23;
        FlutterView r11 = r7.c;
        if (r11 == null) goto L24;
        if (r10 != null) goto L25;
        r11.addView(r9);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L21:
        return;
    L20:
        throw new IllegalStateException("FlutterEngine is not attached to FlutterView");
    }

    @Override // n5a.k
    public final Size c(int r1, int r2, int r3, int r4) {
        return new Size(r3, r4);
    }
}
