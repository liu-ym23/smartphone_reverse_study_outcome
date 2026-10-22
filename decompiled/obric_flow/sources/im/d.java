package im;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.BitmapBuffer;
import com.lynx.animax.drawable.BitmapBufferGroup;
import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;
import com.lynx.animax.util.AnimaXLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends View implements h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitmapBufferGroup f17583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f17584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimaXSurfaceDrawable f17585c;
    public final AnimaXPlayer d;
    public boolean e;
    public boolean f;
    public BitmapBuffer g;

    public d(AnimaXPlayer r5) {
        super(r5.f9552c.f17580b);
        this.e = false;
        this.f = false;
        this.d = r5;
        this.f17584b = new Paint(6);
        r5.g = true;
        this.f17583a = new BitmapBufferGroup(this);
        b r10 = r5.f9552c;
        if (r10 == null) goto L9;
        BaseAbility r11 = r10.f17579a;
        if (r11 == null) goto L9;
        r11.f9576b = new WeakReference(this);
        return;
    L9:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXImageView", "initView fail, missing AnimaXContext or Ability.");
    }

    @Override // im.h
    public final void a() {
        if (this.f17585c == null) goto L5;
        return;
    L5:
        if (this.f == false) goto L10;
        this.d.f9553h = true;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXImageView", "The Surface has not been created yet; Creating a temporary one.");
        onSizeChanged(1, 1, 0, 0);
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

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Bitmap getCurrentBitmap() {
        BitmapBuffer r5 = this.g;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getBitmap();
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
        return this.d;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        if (this.f == false) goto L5;
        return;
    L5:
        super.onAttachedToWindow();
        VisibilityState r5 = VisibilityState.f;
        this.d.g(true, r5);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        if (this.f == false) goto L5;
        return;
    L5:
        super.onDetachedFromWindow();
        VisibilityState r5 = VisibilityState.f;
        this.d.g(false, r5);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.g != null) goto L12;
        BitmapBufferGroup r10 = this.f17583a;
        BitmapBuffer r11 = (BitmapBuffer) r10.f9604a.get();
        if (r11 != null) goto L7;
    L10:
        BitmapBuffer r12 = null;
    L11:
        this.g = r12;
        goto L12
    L7:
        if (((BitmapBuffer.BufferState) r11.f9600c.get()) != BitmapBuffer.BufferState.f9602b) goto L10;
        r12 = (BitmapBuffer) r10.f9604a.getAndSet(null);
    L12:
        BitmapBuffer r13 = this.g;
        if (r13 != null) goto L16;
        return;
    L16:
        if (((BitmapBuffer.BufferState) r13.f9600c.get()) == BitmapBuffer.BufferState.f9602b) goto L19;
        this.g.b();
        this.g = null;
        return;
    L19:
        Bitmap r14 = this.g.getBitmap();
        if (r14 != null) goto L22;
        return;
    L22:
        if (r14.isRecycled() == true) goto L28;
        int r15 = r5.save();
        r5.drawBitmap(r14, 0.0f, 0.0f, this.f17584b);
        r5.restoreToCount(r15);
        Choreographer.getInstance().postFrameCallback(new c(this));
        return;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L6;
        boolean r14 = true;
    L7:
        VisibilityState r15 = VisibilityState.e;
        AnimaXPlayer r5 = this.d;
        r5.g(r14, r15);
        if (r10 <= 0) goto L22;
        if (r11 <= 0) goto L22;
        BitmapBuffer r16 = this.g;
        if (r16 == null) goto L14;
        r16.b();
        this.g = null;
    L14:
        AnimaXSurfaceDrawable r17 = this.f17585c;
        if (r17 != null) goto L19;
        AnimaXSurfaceDrawable r18 = new AnimaXSurfaceDrawable(null, null, this.f17583a, r10, r11);
        this.f17585c = r18;
        r5.f(r18);
        return;
    L19:
        if (r17.a(r10, r11) == false) goto L24;
        r5.k(this.f17585c);
        return;
    L24:
        return;
    L22:
        String r19 = com.lynx.tasm.base.h.b(r10, r11, "Skip invalid size: ", " / ");
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXImageView", r19);
        return;
    L6:
        r14 = false;
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.e == false) goto L8;
        if (r5 == null) goto L8;
        if (r5.getAction() != 0) goto L8;
        getPlayer().b(r5.getX(), r5.getY());
    L8:
        if (r5 != null) goto L10;
        return false;
    L10:
        return super.onTouchEvent(r5);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r5) {
        super.onVisibilityAggregated(r5);
        if (this.f == false) goto L5;
        return;
    L5:
        this.d.g(r5, VisibilityState.g);
    }

    @Override // im.h
    public final void release() {
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXImageView", "release: " + this);
        BitmapBuffer r5 = this.g;
        if (r5 == null) goto L5;
        r5.b();
    L5:
        BitmapBufferGroup r10 = this.f17583a;
        BitmapBuffer r11 = (BitmapBuffer) r10.f9605b.poll();
        if (r11 == null) goto L8;
        r11.b();
        goto L5
    L8:
        BitmapBuffer r12 = (BitmapBuffer) r10.f9604a.getAndSet(null);
        if (r12 == null) goto L11;
        r12.b();
    L11:
        this.d.p();
    }

    @Override // android.view.View
    public void setAlpha(float r5) {
        super.setAlpha(r5);
        boolean r10 = false;
        if (getAlpha() <= 0.0f) goto L5;
        boolean r11 = true;
    L7:
        if (r5 <= 0.0f) goto L9;
        r10 = true;
    L9:
        if (r11 == r10) goto L12;
        this.d.g(r10, VisibilityState.d);
        return;
    L12:
        return;
    L5:
        r11 = false;
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
        this.e = r5;
    }

    @Override // im.f
    public void setEndFrame(int r5) {
        getPlayer().setEndFrame(r5);
    }

    @Override // im.f
    public void setFpsEventInterval(long r5) {
        getPlayer().setFpsEventInterval(r5);
    }

    @Override // im.h
    public void setIgnoreAttachStatus(boolean r5) {
        this.f = r5;
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
        super.setVisibility(r5);
        if (r5 != 0) goto L5;
        boolean r10 = true;
    L6:
        VisibilityState r11 = VisibilityState.f9582c;
        this.d.g(r10, r11);
        return;
    L5:
        r10 = false;
        goto L6
    }
}
