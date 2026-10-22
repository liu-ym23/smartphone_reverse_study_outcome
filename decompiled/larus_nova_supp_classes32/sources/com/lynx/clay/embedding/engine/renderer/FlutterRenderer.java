package com.lynx.clay.embedding.engine.renderer;

import android.os.Handler;
import android.view.Surface;
import com.lynx.clay.embedding.engine.FlutterJNI;
import s5a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterRenderer {
    public final FlutterJNI a;
    public Surface b;
    public boolean c;
    public boolean d;
    public final a e;

    public static final class ViewportMetrics {
        public int densityDpi;
        public float devicePixelRatio;
        public float fontScale;
        public int height;
        public boolean nightMode;
        public int screenHeight;
        public int screenWidth;
        public int systemGestureInsetBottom;
        public int systemGestureInsetLeft;
        public int systemGestureInsetRight;
        public int systemGestureInsetTop;
        public int viewInsetBottom;
        public int viewInsetLeft;
        public int viewInsetRight;
        public int viewInsetTop;
        public int viewPaddingBottom;
        public int viewPaddingLeft;
        public int viewPaddingRight;
        public int viewPaddingTop;
        public int width;

        public ViewportMetrics() {
            this.screenWidth = 0;
            this.screenHeight = 0;
            this.fontScale = 1.0f;
            this.nightMode = false;
            this.devicePixelRatio = 1.0f;
            this.densityDpi = 0;
            this.width = 0;
            this.height = 0;
            this.viewPaddingTop = 0;
            this.viewPaddingRight = 0;
            this.viewPaddingBottom = 0;
            this.viewPaddingLeft = 0;
            this.viewInsetTop = 0;
            this.viewInsetRight = 0;
            this.viewInsetBottom = 0;
            this.viewInsetLeft = 0;
            this.systemGestureInsetTop = 0;
            this.systemGestureInsetRight = 0;
            this.systemGestureInsetBottom = 0;
            this.systemGestureInsetLeft = 0;
        }
    }

    public class a implements b {
        public final /* synthetic */ FlutterRenderer a;

        @Override // s5a.b
        public final void a() {
            this.a.d = false;
        }

        @Override // s5a.b
        public final void b() {
            this.a.d = true;
        }

        public a(FlutterRenderer r1) {
            this.a = r1;
        }
    }

    public FlutterJNI getFlutterJNI() {
        return this.a;
    }

    public FlutterRenderer(FlutterJNI r2) {
        this.c = false;
        this.d = false;
        new Handler();
        a r0 = new a(this);
        this.e = r0;
        this.a = r2;
        r2.addIsDisplayingFlutterUiListener(r0);
    }

    public final void b(boolean r2) {
        if (r2 == false) goto L4;
        this.a.onRenderSurfaceDestroyed();
    L5:
        this.b = null;
        this.c = false;
        if (this.d == false) goto L8;
        this.e.a();
    L8:
        this.d = false;
        return;
    L4:
        this.a.onSurfaceDestroyed();
        goto L5
    }

    public final void a(Surface r2, boolean r3) {
        if (this.b == null) goto L5;
        b(this.c);
    L5:
        this.b = r2;
        this.c = r3;
        if (r3 == false) goto L8;
        this.a.onRenderSurfaceCreated(r2);
        return;
    L8:
        this.a.onSurfaceCreated(r2);
    }
}
