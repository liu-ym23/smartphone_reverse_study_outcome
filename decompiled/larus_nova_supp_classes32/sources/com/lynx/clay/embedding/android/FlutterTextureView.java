package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterTextureView extends TextureView implements s5a.c {
    public boolean a;
    public boolean b;
    public FlutterRenderer c;
    public Surface d;
    public SurfaceTexture e;
    public final boolean f;

    public class a implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ FlutterTextureView a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r1) {
        }

        public a(FlutterTextureView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
            c5a.c.e();
            FlutterTextureView r4 = this.a;
            r4.a = false;
            if (r4.f == false) goto L6;
            return false;
        L6:
            if (r4.b == false) goto L17;
            FlutterRenderer r1 = r4.c;
            if (r1 == null) goto L16;
            r1.b(false);
            SurfaceTexture r0 = r4.e;
            if (r0 == null) goto L12;
            r0.release();
            r4.e = null;
        L12:
            Surface r2 = r4.d;
            if (r2 == null) goto L19;
            r2.release();
            r4.d = null;
            return true;
        L19:
            return true;
        L16:
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        L17:
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r2, int r3, int r4) {
            c5a.c.e();
            FlutterTextureView r5 = this.a;
            if (r5.f == false) goto L12;
            SurfaceTexture r6 = r5.e;
            if (r2 == r6) goto L11;
            if (r6 == null) goto L8;
            r6.release();
            r5.e = null;
        L8:
            Surface r7 = r5.d;
            if (r7 == null) goto L11;
            r7.release();
            r5.d = null;
        L11:
            this.a.e = r2;
        L12:
            FlutterTextureView r8 = this.a;
            Surface r9 = r8.d;
            if (r9 == null) goto L15;
            r9.release();
            r8.d = null;
        L15:
            FlutterTextureView r10 = this.a;
            r10.d = new Surface(r2);
            FlutterTextureView r11 = this.a;
            r11.a = true;
            if (r11.b == true) goto L18;
            return;
        L18:
            if (r11.c == null) goto L23;
            if (r11.getSurfaceTexture() == null) goto L23;
            r11.c.a(r11.d, false);
            return;
        L23:
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r2, int r3, int r4) {
            c5a.c.e();
            FlutterTextureView r5 = this.a;
            if (r5.b == true) goto L5;
            return;
        L5:
            if (r5.c == null) goto L8;
            c5a.c.e();
            r5.c.a.onSurfaceChanged(r3, r4);
            return;
        L8:
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
    }

    @Override // s5a.c
    public final void b() {
        if (this.c != null) goto L5;
        c5a.c.d(5, "FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        return;
    L5:
        if (getWindowToken() == null) goto L16;
        c5a.c.e();
        FlutterRenderer r0 = this.c;
        if (r0 == null) goto L15;
        r0.b(false);
        SurfaceTexture r1 = this.e;
        if (r1 == null) goto L11;
        r1.release();
        this.e = null;
    L11:
        Surface r2 = this.d;
        if (r2 == null) goto L19;
        r2.release();
        this.d = null;
    L19:
        this.c = null;
        this.b = false;
        return;
    L15:
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    L16:
        this.c.b(false);
        Surface r3 = this.d;
        if (r3 == null) goto L19;
        r3.release();
        this.d = null;
        goto L19
    }

    @Override // s5a.c
    public final void pause() {
        if (this.c == null) goto L5;
        this.c = null;
        this.b = false;
        return;
    L5:
        c5a.c.d(5, "FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e == null) goto L14;
        Surface r0 = this.d;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isValid() == true) goto L9;
        return;
    L9:
        if (this.a == false) goto L11;
        return;
    L11:
        if (this.e == getSurfaceTexture()) goto L18;
        setSurfaceTexture(this.e);
        this.a = true;
        return;
    L18:
        return;
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.c;
    }

    public FlutterTextureView(Context r2) {
        this(r2, null);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r3) {
        c5a.c.e();
        if (this.c == null) goto L5;
        c5a.c.e();
        this.c.b(false);
    L5:
        this.c = r3;
        this.b = true;
        if (this.a == false) goto L14;
        c5a.c.e();
        if (this.c == null) goto L13;
        if (getSurfaceTexture() == null) goto L13;
        this.c.a(this.d, false);
        return;
    L13:
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
    }

    public FlutterTextureView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
        this.b = false;
        this.f = true;
        setSurfaceTextureListener(new a(this));
        setOpaque(false);
    }
}
