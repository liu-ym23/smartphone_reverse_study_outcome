package n5a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformViewPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements k {
    public final v5a.b a;
    public final View b;

    @Override // n5a.k
    public final void b() {
        this.a.invalidate();
    }

    @Override // n5a.k
    public final void onViewDetached() {
        d(this.a);
    }

    @Override // n5a.k
    public final void release() {
        v5a.b r0 = this.a;
        r0.e = null;
        Surface r2 = r0.f;
        if (r2 == null) goto L5;
        r2.release();
        r0.f = null;
    L5:
        r0.getContext().unregisterComponentCallbacks(r0.q);
        d(this.b);
    }

    public static void d(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((r1.getParent() instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r1.getParent()).removeView(r1);
        return;
    }

    @Override // n5a.k
    public final void a(FlutterView r3) {
        if (this.a.willNotDraw() == false) goto L5;
        return;
    L5:
        d(this.a);
        r3.addView(this.a, 0);
        v5a.b r4 = this.a;
        if (r4.o == false) goto L9;
        r4.p = Math.max(r4.p, 2);
        r4.postInvalidateOnAnimation();
        return;
    }

    @Override // n5a.k
    public final Size c(int r3, int r4, int r5, int r6) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L6:
        r1.height = r6;
        r1.width = r5;
        r1.leftMargin = r3;
        r1.topMargin = r4;
        this.a.setLayoutParams(r1);
        if (r5 <= this.a.getBufferWidth()) goto L9;
    L10:
        v5a.b r7 = this.a;
        r7.c = r5;
        r7.d = r6;
        SurfaceTexture r8 = r7.e;
        if (r8 == null) goto L13;
        r8.setDefaultBufferSize(r5, r6);
    L13:
        if (r5 <= 0) goto L19;
        if (r6 <= 0) goto L19;
        v5a.b r9 = this.a;
        if (r9.o == false) goto L19;
        r9.p = Math.max(r9.p, 2);
        r9.postInvalidateOnAnimation();
    L19:
        return new Size(this.a.getBufferWidth(), this.a.getBufferHeight());
    L9:
        if (r6 <= this.a.getBufferHeight()) goto L13;
    L5:
        r1 = new FrameLayout.LayoutParams(r5, r6);
        goto L6
    }

    public p(Context r2, SurfaceTexture r3, View r4, boolean r5, boolean r6, n r7, PlatformViewPlugin.a r8) {
        v5a.b r0 = new v5a.b(r2);
        this.a = r0;
        this.b = r4;
        r0.setPostDrawRedrawEnabled(true);
        r0.setTexture(r3);
        r0.setWillNotDraw(true ^ r5);
        r0.setSystemTouchDispatchEnabled(r6);
        r0.setTouchDispatchTargetChecker(r7);
        r0.setTouchDispatchResultListener(r8);
        r0.addView(r4, new FrameLayout.LayoutParams(-1, -1));
    }
}
