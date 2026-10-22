package com.lynx.animax.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.BitmapBuffer;
import com.lynx.animax.drawable.BitmapBufferGroup;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.lottieadapter.LottieAdapterAnimaX$w;
import java.lang.ref.WeakReference;
import o4a.c;
import x4a.b;
import x4a.d;
import x4a.e;
import x4a.f;
import x4a.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXImageView extends View implements g, e {
    public final BitmapBufferGroup a;
    public final Paint b;
    public AnimaXSurfaceDrawable c;
    public final AnimaXPlayer d;
    public boolean e;
    public boolean f;
    public BitmapBuffer g;

    @Override // x4a.g
    public final /* synthetic */ void d(MotionEvent r1) {
        f.a(this, r1);
    }

    @Override // q4a.b
    public final void e() {
        if (this.c == null) goto L5;
        return;
    L5:
        if (this.f == false) goto L10;
        this.d.i = true;
        AnimaXLog.b("AnimaXImageView", "The Surface has not been created yet; Creating a temporary one.");
        onSizeChanged(1, 1, 0, 0);
        return;
    }

    public Bitmap getCurrentBitmap() {
        BitmapBuffer r0 = this.g;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getBitmap();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        if (this.f == false) goto L5;
        return;
    L5:
        super.onAttachedToWindow();
        this.d.z(true, VisibilityState.ATTACH);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        if (this.f == false) goto L5;
        return;
    L5:
        super.onDetachedFromWindow();
        this.d.z(false, VisibilityState.ATTACH);
    }

    @Override // x4a.g
    public final void release() {
        AnimaXLog.b("AnimaXImageView", "release: " + this);
        BitmapBuffer r0 = this.g;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.a.a();
        this.d.s();
    }

    @Override // x4a.e
    public final void cancel() {
        getPlayer().cancel();
    }

    public AnimaXComposition getComposition() {
        return getPlayer().getComposition();
    }

    @Override // x4a.e
    public double getCurrentFrame() {
        return getPlayer().getCurrentFrame();
    }

    @Override // x4a.e
    public double getDurationMs() {
        return getPlayer().getDurationMs();
    }

    @Override // x4a.e
    public final boolean isAnimating() {
        return getPlayer().isAnimating();
    }

    @Override // x4a.e
    public final void pause() {
        getPlayer().pause();
    }

    @Override // x4a.e
    public final void play() {
        getPlayer().play();
    }

    @Override // x4a.e
    public final void resume() {
        getPlayer().resume();
    }

    @Override // x4a.g, x4a.e
    public d getPlayer() {
        return this.d;
    }

    public AnimaXImageView(Context r3) {
        super(r3);
        this.e = false;
        this.f = false;
        AnimaXPlayer r0 = new AnimaXPlayer(new AnimaXContext(new AnimaXContext.a(new c(), r3)));
        this.d = r0;
        this.b = new Paint(6);
        r0.h = true;
        this.a = new BitmapBufferGroup(this);
        g(null);
    }

    @Override // x4a.e
    public final void a(int r2) {
        getPlayer().a(r2);
    }

    @Override // x4a.e
    public final void c(LottieAdapterAnimaX$w r2) {
        getPlayer().c(r2);
    }

    public final void g(AttributeSet r5) {
        AnimaXContext r0 = this.d.c;
        if (r0 != null) goto L5;
    L12:
        AnimaXLog.a("AnimaXImageView", "initView fail, missing AnimaXContext or Ability.");
        return;
    L5:
        if (r0.getAbility() == null) goto L12;
        BaseAbility r2 = r0.getAbility();
        r2.getClass();
        r2.b = new WeakReference(this);
        r0.getAbility().f = true;
        f(r0.getContext(), r5);     // Catch: NullPointerException -> L10
        return;
    L10:
        AnimaXLog.a("AnimaXImageView", "initAttributes fail, context's theme is null.");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r5) {
        super.onDraw(r5);
        if (this.g != null) goto L5;
        this.g = this.a.c(null);
    L5:
        BitmapBuffer r0 = this.g;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.c.get() == BitmapBuffer.BufferState.Ready) goto L12;
        this.g.a();
        this.g = null;
        return;
    L12:
        Bitmap r1 = this.g.getBitmap();
        if (r1 != null) goto L15;
        return;
    L15:
        if (r1.isRecycled() == true) goto L20;
        int r2 = r5.save();
        r5.drawBitmap(r1, 0.0f, 0.0f, this.b);
        r5.restoreToCount(r2);
        Choreographer.getInstance().postFrameCallback(new b(this));
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.e == false) goto L5;
        f.a(this, r2);
    L5:
        if (r2 != null) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r3) {
        super.onVisibilityAggregated(r3);
        if (this.f == false) goto L5;
        return;
    L5:
        this.d.z(r3, VisibilityState.AGGREGATED);
    }

    @Override // android.view.View
    public void setAlpha(float r5) {
        super.setAlpha(r5);
        boolean r1 = false;
        if (getAlpha() <= 0.0f) goto L5;
        boolean r0 = true;
    L7:
        if (r5 <= 0.0f) goto L9;
        r1 = true;
    L9:
        if (r0 == r1) goto L12;
        this.d.z(r1, VisibilityState.OPACITY);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public void setAntiAliasing(boolean r2) {
        getPlayer().l(r2);
    }

    @Override // x4a.e
    public void setAutoPlay(boolean r2) {
        getPlayer().setAutoPlay(r2);
    }

    @Override // x4a.e
    public void setAutoReverse(boolean r2) {
        getPlayer().setAutoReverse(r2);
    }

    @Override // x4a.e
    public void setComposition(AnimaXComposition r2) {
        getPlayer().setComposition(r2);
    }

    public void setDynamicResource(boolean r2) {
        getPlayer().k(r2);
    }

    public void setEnableAudio(boolean r2) {
        getPlayer().setEnableAudio(r2);
    }

    @Override // x4a.g
    public void setEnableTapLayerEvent(boolean r1) {
        this.e = r1;
    }

    @Override // x4a.e
    public void setEndFrame(int r2) {
        getPlayer().setEndFrame(r2);
    }

    public void setFpsEventInterval(long r2) {
        getPlayer().j(r2);
    }

    @Override // x4a.g
    public void setIgnoreAttachStatus(boolean r1) {
        this.f = r1;
    }

    @Override // x4a.e
    public void setImageFolder(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        getPlayer().setImageFolder(r2);
        return;
    }

    @Override // x4a.e
    public void setJson(String r2) {
        getPlayer().setJson(r2);
    }

    public void setKeepLastFrame(boolean r2) {
        getPlayer().e(r2);
    }

    @Override // x4a.e
    public void setLoop(boolean r2) {
        getPlayer().setLoop(r2);
    }

    @Override // x4a.e
    public void setLoopCount(int r2) {
        getPlayer().setLoopCount(r2);
    }

    @Override // x4a.e
    public void setMaxFrameRate(double r2) {
        getPlayer().setMaxFrameRate(r2);
    }

    public void setMuted(boolean r2) {
        getPlayer().setMuted(r2);
    }

    @Override // x4a.e
    public void setObjectFit(ObjectFit r2) {
        getPlayer().setObjectFit(r2);
    }

    public void setObjectPosition(ObjectPosition r2) {
        getPlayer().d(r2);
    }

    @Override // x4a.e
    public void setProgress(float r2) {
        getPlayer().setProgress(r2);
    }

    @Override // x4a.e
    public void setSpeed(float r2) {
        getPlayer().setSpeed(r2);
    }

    @Override // x4a.e
    public void setSrc(String r2) {
        getPlayer().setSrc(r2);
    }

    @Override // x4a.e
    public void setStartFrame(int r2) {
        getPlayer().setStartFrame(r2);
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        AnimaXPlayer r0 = this.d;
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        r0.z(r4, VisibilityState.VISIBLE);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public AnimaXImageView(AnimaXContext r3) {
        super(r3.getContext());
        this.e = false;
        this.f = false;
        AnimaXPlayer r0 = new AnimaXPlayer(r3);
        this.d = r0;
        this.b = new Paint(6);
        r0.h = true;
        this.a = new BitmapBufferGroup(this);
        g(null);
    }

    public AnimaXImageView(AnimaXPlayer r3) {
        super(r3.c.getContext());
        this.e = false;
        this.f = false;
        this.d = r3;
        this.b = new Paint(6);
        r3.h = true;
        this.a = new BitmapBufferGroup(this);
        g(null);
    }

    public AnimaXImageView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.e = false;
        this.f = false;
        AnimaXPlayer r0 = new AnimaXPlayer(new AnimaXContext(new AnimaXContext.a(new c(), r3)));
        this.d = r0;
        this.b = new Paint(6);
        r0.h = true;
        this.a = new BitmapBufferGroup(this);
        g(r4);
    }

    @Override // x4a.e
    public final void b(int[] r2, boolean r3) {
        getPlayer().b(r2, r3);
    }

    public final void f(Context r3, AttributeSet r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3.getTheme() != null) goto L8;
        AnimaXLog.a("AnimaXImageView", "initAttributes fail, context's theme is null.");
        return;
    L8:
        TypedArray r5 = r3.obtainStyledAttributes(r4, new int[]{2130968798, 2130968799, 2130968800, 2130968801});
        String r0 = r5.getString(0);
        if (r0 == null) goto L11;
        this.d.setSrc(r0);
    L11:
        this.d.setAutoPlay(r5.getBoolean(1, true));
        this.d.setLoop(r5.getBoolean(2, false));
        String r6 = r5.getString(3);
        if (r6 == null) goto L14;
        this.d.setObjectFit(y4a.c.a(r6));
    L14:
        r5.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r7, int r8, int r9, int r10) {
        super.onSizeChanged(r7, r8, r9, r10);
        AnimaXPlayer r11 = this.d;
        if (r7 <= 0) goto L6;
        if (r8 <= 0) goto L6;
        boolean r12 = true;
    L7:
        r11.z(r12, VisibilityState.SIZE);
        if (r7 <= 0) goto L22;
        if (r8 <= 0) goto L22;
        BitmapBuffer r13 = this.g;
        if (r13 == null) goto L14;
        r13.a();
        this.g = null;
    L14:
        AnimaXSurfaceDrawable r14 = this.c;
        if (r14 != null) goto L19;
        AnimaXSurfaceDrawable r15 = new AnimaXSurfaceDrawable(null, null, this.a, r7, r8);
        this.c = r15;
        this.d.p(r15);
        return;
    L19:
        if (r14.a(r7, r8) == false) goto L24;
        this.d.y(this.c);
        return;
    L24:
        return;
    L22:
        AnimaXLog.b("AnimaXImageView", "Skip invalid size: " + r7 + " / " + r8);
        return;
    L6:
        r12 = false;
        goto L7
    }
}
