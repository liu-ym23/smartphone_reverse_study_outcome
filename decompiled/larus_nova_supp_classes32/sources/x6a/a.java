package x6a;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.render.PlatformRendererContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends ViewGroup implements e {
    public i a;

    @Override // x6a.e
    public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        d.a(this, r1, r2);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererOpacity(float r1) {
        d.b(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ void applyRendererTransform(float[] r1) {
        d.c(this, r1);
    }

    @Override // x6a.e
    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return d.d(this, r1);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // x6a.e
    public View getView() {
        return this;
    }

    @Override // x6a.e
    public final /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    @Override // x6a.e
    public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // x6a.e
    public final /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        d.l(this, r1);
    }

    @Override // x6a.e
    public i getRenderer() {
        return this.a;
    }

    public a(LynxContext r1) {
        super(r1);
        setWillNotDraw(false);
        setClipChildren(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        this.a.a(r2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        this.a.g(r2);
    }

    @Override // x6a.e
    public void setRenderer(i r1) {
        this.a = r1;
    }

    public i createRenderer(PlatformRendererContext r2, int r3) {
        return new i(r2, r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        Rect r3 = this.a.a;
        setMeasuredDimension(r3.width(), r3.height());
        this.a.i();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        this.a.b(r2, r3);
        boolean r5 = super.drawChild(r2, r3, r4);
        this.a.getClass();
        r2.restore();
        return r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        this.a.h();
    }
}
