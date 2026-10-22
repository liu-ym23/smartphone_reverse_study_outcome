package com.ss.ugc.live.barrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import plc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/live/barrage/view/SurfaceBarrageLayout;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lplc/a;", "", "enable", "", "setEnableTouch", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barrage_release"}, k = 1, mv = {1, 4, 0})
public final class SurfaceBarrageLayout extends SurfaceView implements SurfaceHolder.Callback, a {
    public final ArrayList<AbsBarrageController> a;
    public AbsBarrageController b;
    public boolean c;
    public final SurfaceHolder d;
    public boolean e;

    public SurfaceBarrageLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SurfaceBarrageLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
    }

    public final void c() {
        if (this.e == true) goto L5;
        return;
    L5:
        SurfaceHolder r0 = this.d;
        if (r0 == null) goto L8;
        Canvas r1 = r0.lockCanvas();
    L9:
        if (r1 == null) goto L18;
        int r2 = 0;
        r1.drawColor(0, PorterDuff.Mode.CLEAR);
        int r3 = this.a.size();
    L11:
        if (r2 >= r3) goto L13;
        AbsBarrageController r4 = (AbsBarrageController) ListProtector.get(this.a, r2);
        r4.d(r1);
        r4.c(r1);
        r2 = r2 + 1;
        goto L11
    L13:
        SurfaceHolder r5 = this.d;
        if (r5 == null) goto L19;
        r5.unlockCanvasAndPost(r1);
        return;
    L19:
        return;
    L18:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<AbsBarrageController> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().m();
        goto L4
    }

    @Override // plc.a
    public final void a(AbsBarrageController r3) {
        int r0 = this.a.size();
        if (r3 == null) goto L6;
        ListProtector.add(this.a, r0, r3);
        return;
    }

    @Override // plc.a
    public final void b(AbsBarrageController r2) {
        if (r2 == null) goto L5;
        this.a.remove(r2);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (this.c == false) goto L35;
        int r0 = r5.getAction();
        if (r0 == 0) goto L25;
        if (r0 != 1) goto L8;
        AbsBarrageController r1 = this.b;
        if (r1 != null) goto L36;
    L33:
        return super.onTouchEvent(r5);
    L36:
        boolean r6 = r1.k(r5);     // Catch: Throwable -> L22
        this.b = null;
        return r6;
    L22:
        th = move-exception;
        this.b = null;
        throw th;
    L8:
        if (r0 != 2) goto L10;
    L12:
        AbsBarrageController r2 = this.b;
        if (r2 == null) goto L33;
        return r2.k(r5);
    L10:
        if (r0 == 3) goto L12;
    L25:
        Iterator<AbsBarrageController> r3 = this.a.iterator();
    L27:
        if (r3.hasNext() == false) goto L33;
        AbsBarrageController r4 = r3.next();
        if (r4.k(r5) == false) goto L27;
        this.b = r4;
        return true;
    L35:
        return super.onTouchEvent(r5);
    }

    @Override // plc.a
    public void setEnableTouch(boolean r1) {
        this.c = r1;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r3) {
        this.e = true;
        SurfaceHolder r4 = this.d;
        if (r4 == null) goto L5;
        Canvas r5 = r4.lockCanvas();
    L6:
        if (r5 == null) goto L11;
        r5.drawColor(0, PorterDuff.Mode.CLEAR);
        SurfaceHolder r0 = this.d;
        if (r0 == null) goto L12;
        r0.unlockCanvasAndPost(r5);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r1) {
        this.e = false;
    }

    public SurfaceBarrageLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
        this.c = true;
        setZOrderMediaOverlay(true);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        SurfaceHolder r4 = getHolder();
        this.d = r4;
        if (r4 == null) goto L5;
        r4.addCallback(this);
    L5:
        if (r4 == null) goto L8;
        r4.setFormat(-2);
        return;
    }

    public /* synthetic */ SurfaceBarrageLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
