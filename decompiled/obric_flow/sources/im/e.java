package im;

import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaXLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends TextureView implements TextureView.SurfaceTextureListener, cm.a, h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FirstFrameAwareSurfaceTexture f17586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimaXSurfaceDrawable f17588c;
    public boolean d;
    public boolean e;
    public int f;
    public final AnimaXPlayer g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17590i;

    public e(AnimaXPlayer r10) {
        super(r10.f9552c.f17580b);
        this.f17587b = false;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.f17589h = false;
        this.f17590i = false;
        this.g = r10;
        b r11 = r10.f9552c;
        if (r11 == null) goto L19;
        BaseAbility r12 = r11.f17579a;
        if (r12 == null) goto L19;
        r12.f9576b = new WeakReference(this);
        this.f17590i = jm.b.b(jm.b.a("ANIMAX_UPDATE_TEXTURE_WHEN_VISIBLE", r12));
        setOpaque(false);
        setNeedAlphaWorkaround(true);
        setSurfaceTextureListener(this);
        FirstFrameAwareSurfaceTexture r13 = new FirstFrameAwareSurfaceTexture();
        this.f17586a = r13;
        Surface r5 = new Surface(r13);
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", "create Surface: " + r5);
        monitor-enter(r13);
        r13.g = new WeakReference(r5);     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
        r13.detachFromGLContext();
        r13.f9608a = new WeakReference(this);
        if (r13.f9610c == false) goto L14;
        setNeedAlphaWorkaround(false);
    L14:
        r13.d = new WeakReference(this);
        e();
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXView", "initView fail, missing AnimaXContext or Ability.");
    }

    private void setNeedAlphaWorkaround(boolean r5) {
        String r10 = jm.b.f18354a;
    }

    @Override // im.h
    public final void a() {
        if (this.f17588c == null) goto L5;
        return;
    L5:
        if (this.d == false) goto L10;
        this.g.f9553h = true;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", "The Surface has not been created yet; Creating a temporary one.");
        onSurfaceTextureAvailable(null, 1, 1);
        return;
    }

    public final void c(int r10, int r11) {
        if (r10 <= 0) goto L5;
        if (r11 <= 0) goto L5;
        boolean r5 = true;
    L6:
        VisibilityState r12 = VisibilityState.e;
        AnimaXPlayer r13 = this.g;
        r13.g(r5, r12);
        if (r10 <= 0) goto L18;
        if (r11 <= 0) goto L18;
        AnimaXSurfaceDrawable r14 = this.f17588c;
        if (r14 != null) goto L15;
        FirstFrameAwareSurfaceTexture r15 = this.f17586a;
        AnimaXSurfaceDrawable r16 = new AnimaXSurfaceDrawable(r15.b(), r15, null, r10, r11);
        this.f17588c = r16;
        r13.f(r16);
        return;
    L15:
        if (r14.a(r10, r11) == false) goto L20;
        r13.k(this.f17588c);
        return;
    L20:
        return;
    L18:
        String r17 = com.lynx.tasm.base.h.b(r10, r11, "Skip invalid size: ", " / ");
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", r17);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void d() {
        setNeedAlphaWorkaround(false);
    }

    public final void e() {
        SurfaceTexture r5 = getSurfaceTexture();
        FirstFrameAwareSurfaceTexture r10 = this.f17586a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.equals(r5) == true) goto L12;
        if (r5 == null) goto L9;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", "Init TextureView but it has already another st.");
    L9:
        setSurfaceTexture(r10);
        return;
    }

    @Override // im.f
    public b getAnimaXContext() {
        return getPlayer().getAnimaXContext();
    }

    @Override // im.f
    public AnimaXComposition getComposition() {
        return getPlayer().getComposition();
    }

    @Override // im.f
    public double getCurrentFrame() {
        return getPlayer().getCurrentFrame();
    }

    @Override // im.f
    public double getDurationMs() {
        return getPlayer().getDurationMs();
    }

    @Override // im.h, im.g
    @NonNull
    public f getPlayer() {
        return this.g;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        String r5 = jm.b.f18354a;
        if (this.d == false) goto L5;
        return;
    L5:
        super.onAttachedToWindow();
        VisibilityState r10 = VisibilityState.f;
        this.g.g(true, r10);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        String r5 = jm.b.f18354a;
        if (this.d == false) goto L5;
        return;
    L5:
        super.onDetachedFromWindow();
        VisibilityState r10 = VisibilityState.f;
        this.g.g(false, r10);
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXView", "onSizeChanged before added to view tree, may produce npe on some devices");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r5, int r10, int r11) {
        AnimaXLog.LogLevel r12 = AnimaXLog.LogLevel.f9713a;
        AnimaXLog.a(r12, "AnimaXView", "onSurfaceTextureAvailable: " + r5 + ", width: " + r10 + ", height: " + r11 + ", this: " + this);
        if (this.f17587b == false) goto L6;
        AnimaXLog.a(r12, "AnimaXView", "onSurfaceTextureAvailable failed as view is destroyed.");
        return;
    L6:
        e();
        c(r10, r11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r5) {
        String r10 = "onSurfaceTextureDestroyed: " + r5 + ", mHasDestroyed: " + this.f17587b + ", this: " + this;
        AnimaXLog.LogLevel r11 = AnimaXLog.LogLevel.f9713a;
        AnimaXLog.a(r11, "AnimaXView", r10);
        if (jm.b.f18356c == true) goto L5;
        return false;
    L5:
        if (this.f17587b == true) goto L10;
        AnimaXLog.a(r11, "AnimaXView", "needTextureDestroyWorkaround, try to postAtFrontOnUI.");
        this.f = getVisibility();
        this.e = true;
        setVisibility(4);
        com.lynx.tasm.ui.image.h r12 = new com.lynx.tasm.ui.image.h(this, 25);
        Handler r13 = jm.c.a();
        Message r14 = Message.obtain(r13, r12);
        r14.setAsynchronous(true);
        r13.sendMessageAtFrontOfQueue(r14);
        return false;
    L10:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r5, int r10, int r11) {
        AnimaXLog.LogLevel r12 = AnimaXLog.LogLevel.f9713a;
        AnimaXLog.a(r12, "AnimaXView", "onSurfaceTextureSizeChanged: " + r5 + ", width: " + r10 + ", height: " + r11 + ", this: " + this);
        if (this.f17587b == false) goto L6;
        AnimaXLog.a(r12, "AnimaXView", "onSurfaceTextureSizeChanged failed as view is destroyed.");
        return;
    L6:
        c(r10, r11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r5) {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.f17589h == false) goto L9;
        if (r5 == null) goto L9;
        if (r5.getAction() != 0) goto L9;
        getPlayer().b(r5.getX(), r5.getY());
    L9:
        return super.onTouchEvent(r5);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r5) {
        super.onVisibilityAggregated(r5);
        if (this.d == false) goto L5;
        return;
    L5:
        this.g.g(r5, VisibilityState.g);
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        super.onVisibilityChanged(r5, r10);
        if (this.f17590i == false) goto L8;
        if (r5 != this) goto L9;
        if (r10 != 0) goto L10;
        e();
        return;
    L10:
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        if (this.f17590i == true) goto L5;
        return;
    L5:
        if (getVisibility() != 0) goto L10;
        if (r5 != 0) goto L11;
        e();
        return;
    L11:
        return;
    }

    @Override // im.h
    public final void release() {
        if (this.f17587b == false) goto L5;
        return;
    L5:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", "release: " + this);
        this.f17587b = true;
        this.g.p();
    }

    @Override // android.view.View
    public void setAlpha(float r5) {
        float r10 = getAlpha();
        super.setAlpha(r5);
        boolean r11 = false;
        if (r10 <= 0.0f) goto L5;
        boolean r12 = true;
    L7:
        if (r5 <= 0.0f) goto L9;
        r11 = true;
    L9:
        if (r12 == r11) goto L12;
        this.g.g(r11, VisibilityState.d);
        return;
    L12:
        return;
    L5:
        r12 = false;
        goto L7
    }

    @Override // im.f
    public void setAntiAliasing(boolean r5) {
        getPlayer().setAntiAliasing(r5);
    }

    @Override // im.f
    public void setAutoPlay(boolean r5) {
        getPlayer().setAutoPlay(r5);
    }

    @Override // im.f
    public void setAutoReverse(boolean r5) {
        getPlayer().setAutoReverse(r5);
    }

    @Override // android.view.View
    public void setBackground(Drawable r5) {
        super.setBackground(r5);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXView", "setBackground fail, message: " + e.getMessage());
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r5) {
        super.setBackgroundDrawable(r5);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXView", "setBackgroundDrawable fail, message: " + e.getMessage());
    }

    @Override // im.f
    public void setComposition(AnimaXComposition r5) {
        getPlayer().setComposition(r5);
    }

    @Override // im.f
    public void setDynamicResource(boolean r5) {
        getPlayer().setDynamicResource(r5);
    }

    @Override // im.h
    public void setEnableTapLayerEvent(boolean r5) {
        this.f17589h = r5;
    }

    @Override // im.f
    public void setEndFrame(int r5) {
        getPlayer().setEndFrame(r5);
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r5) {
        super.setForeground(r5);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXView", "setForeground fail, message: " + e.getMessage());
    }

    @Override // im.f
    public void setFpsEventInterval(long r5) {
        getPlayer().setFpsEventInterval(r5);
    }

    @Override // im.h
    public void setIgnoreAttachStatus(boolean r5) {
        this.d = r5;
    }

    @Override // im.f
    public void setImageFolder(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L9;
        getPlayer().setImageFolder(r5);
        return;
    }

    @Override // im.f
    public void setJson(String r5) {
        getPlayer().setJson(r5);
    }

    @Override // im.f
    public void setKeepLastFrame(boolean r5) {
        getPlayer().setKeepLastFrame(r5);
    }

    @Override // im.f
    public void setLoop(boolean r5) {
        getPlayer().setLoop(r5);
    }

    @Override // im.f
    public void setLoopCount(int r5) {
        getPlayer().setLoopCount(r5);
    }

    @Override // im.f
    public void setMaxFrameRate(double r5) {
        getPlayer().setMaxFrameRate(r5);
    }

    @Override // im.f
    public void setObjectFit(ObjectFit r5) {
        getPlayer().setObjectFit(r5);
    }

    @Override // im.f
    public void setObjectPosition(ObjectPosition r5) {
        getPlayer().setObjectPosition(r5);
    }

    @Override // im.f
    public void setProgress(float r5) {
        getPlayer().setProgress(r5);
    }

    @Override // im.f
    public void setSpeed(float r5) {
        getPlayer().setSpeed(r5);
    }

    @Override // im.f
    public void setSrc(String r5) {
        getPlayer().setSrc(r5);
    }

    @Override // im.f
    public void setSrcPolyfill(JavaOnlyMap r5) {
        getPlayer().setSrcPolyfill(r5);
    }

    @Override // im.f
    public void setStartFrame(int r5) {
        getPlayer().setStartFrame(r5);
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        if (this.e == false) goto L7;
        this.f = r5;
        if (r5 != 0) goto L7;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXView", "Force visiblity to INVISIBLE due to workaround.");
        r5 = 4;
    L7:
        super.setVisibility(r5);
        if (r5 != 0) goto L10;
        boolean r10 = true;
    L11:
        VisibilityState r11 = VisibilityState.f9582c;
        this.g.g(r10, r11);
        return;
    L10:
        r10 = false;
        goto L11
    }
}
