package ks9;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends EditText implements x6a.e {
    public x6a.i a;
    public Function2<? super Integer, ? super Integer, Unit> b;
    public boolean c;

    public final /* synthetic */ void applyRendererClipBounds(boolean r1, Rect r2) {
        x6a.d.a(this, r1, r2);
    }

    public final /* synthetic */ void applyRendererOpacity(float r1) {
        x6a.d.b(this, r1);
    }

    public final /* synthetic */ void applyRendererTransform(float[] r1) {
        x6a.d.c(this, r1);
    }

    public final /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r1) {
        return x6a.d.d(this, r1);
    }

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public View getView() {
        return this;
    }

    public final /* synthetic */ void invalidateForRenderer() {
        x6a.d.i(this);
    }

    public final /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    public final /* synthetic */ void requestLayoutForRenderer() {
        x6a.d.j(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    public final boolean getHasDrawn() {
        return this.c;
    }

    public final Function2<Integer, Integer, Unit> getOnSelectionChangedListener() {
        return this.b;
    }

    public x6a.i getRenderer() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.dispatchDraw(r2);
        x6a.i r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        x6a.i r0 = this.a;
        if (r0 == null) goto L5;
        r0.g(r2);
        r0.c(r2);
    L5:
        super.onDraw(r2);
        this.c = true;
    }

    public final void setOnSelectionChangedListener(Function2<? super Integer, ? super Integer, Unit> r1) {
        this.b = r1;
    }

    public void setRenderer(x6a.i r2) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        this.a = r2;
    }

    public final x6a.i createRenderer(PlatformRendererContext r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "platformRendererContext");
        return new x6a.i(r2, r3);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r2, int r3) {
        super.onSelectionChanged(r2, r3);
        Function2<? super Integer, ? super Integer, Unit> r0 = this.b;
        if (r0 == null) goto L6;
        r0.invoke(Integer.valueOf(r2), Integer.valueOf(r3));
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        x6a.i r0 = this.a;
        if (r0 == null) goto L7;
        LynxBaseUI r1 = r0.h;
        if (r1 == null) goto L7;
        r1.measure();
    L7:
        super.onLayout(r2, r3, r4, r5, r6);
    }
}
