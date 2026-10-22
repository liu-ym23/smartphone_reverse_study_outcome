package n8a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.utils.BlurUtils;
import com.lynx.xelement.blur.LynxUIBlurView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends com.lynx.tasm.behavior.ui.view.a implements ViewTreeObserver.OnPreDrawListener {
    public static final String B = null;
    public boolean A;
    public RenderNode a;
    public float b;
    public boolean c;
    public boolean d;
    public float e;
    public Bitmap f;
    public d g;
    public boolean h;
    public int[] i;
    public int[] j;
    public LynxUIBlurView k;
    public View l;
    public final Rect m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final Object r;
    public volatile RenderScript s;
    public volatile ScriptIntrinsicBlur t;
    public volatile boolean u;
    public Allocation v;
    public int w;
    public int x;
    public boolean y;
    public volatile boolean z;

    /* JADX INFO: renamed from: n8a.a$a, reason: collision with other inner class name */
    public class RunnableC0102a implements Runnable {
        public final /* synthetic */ a a;

        public final void a() {
            a r0 = this.a;
            if (r0.u == true) goto L48;
            TraceEvent.beginSection("BlurView.createRenderScript");
            RenderScript r1 = RenderScript.create(r0.getContext());     // Catch: RuntimeException -> L32 Throwable -> L36
            ScriptIntrinsicBlur r2 = ScriptIntrinsicBlur.create(r1, Element.U8_4(r1));     // Catch: RuntimeException -> L30 Throwable -> L36
            TraceEvent.endSection("BlurView.createRenderScript");
            Object r3 = r0.r;
            monitor-enter(r3);
        L27:
            th = move-exception;
            throw th;
        L11:
            if (r0.u == false) goto L14;
            monitor-exit(r3);     // Catch: Throwable -> L27
            boolean r4 = false;
        L17:
            if (r4 == true) goto L23;
            if (r1 == null) goto L20;
            r1.destroy();
        L20:
            if (r2 == null) goto L46;
            r2.destroy();
            return;
        L46:
            return;
        L23:
            if (r0.z == false) goto L49;
            r0.post(new n8a.b(r0));
            return;
        L49:
            return;
        L14:
            r0.s = r1;     // Catch: Throwable -> L27
            r0.t = r2;     // Catch: Throwable -> L27
            monitor-exit(r3);     // Catch: Throwable -> L27
            r4 = true;
        L30:
            e = e;
        L34:
            if (r1 == null) goto L38;
            r1.destroy();     // Catch: Throwable -> L36
        L38:
            throw e;     // Catch: Throwable -> L36
        L32:
            e = e;
            r1 = null;
        L36:
            th = move-exception;
            TraceEvent.endSection("BlurView.createRenderScript");
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC0102a(a r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ a b;

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.b;     // Catch: Throwable -> L8
            boolean r1 = this.a;     // Catch: Throwable -> L8
            r0.c = r1;     // Catch: Throwable -> L8
            if (r1 == false) goto L5;
            a.c(r0);     // Catch: Throwable -> L8
            a r2 = this.b;     // Catch: Throwable -> L8
            r2.f(r2.getWidth(), this.b.getHeight());     // Catch: Throwable -> L8
        L6:
            this.b.invalidate();     // Catch: Throwable -> L8
            return;
        L5:
            r0.getViewTreeObserver().removeOnPreDrawListener(r0);     // Catch: Throwable -> L8
            r0.o = false;     // Catch: Throwable -> L8
            r0.q = false;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public b(a r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ a a;

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L6
            if (r0.A == false) goto L9;
            r0.updateBlur();     // Catch: Throwable -> L6
            a r1 = this.a;     // Catch: Throwable -> L6
            r1.A = false;     // Catch: Throwable -> L6
            r1.invalidate();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    static {
        B = a.class.getSimpleName();
    }

    private void getTargetParent() {
        TraceEvent.beginSection("BlurView.getTargetParent");
        LynxUIBlurView r1 = this.k;
        if (r1 != null) goto L6;
        TraceEvent.endSection("BlurView.getTargetParent");
        return;
    L6:
        View r2 = r1.N();
        if (r2 == null) goto L10;
        this.l = r2;
        TraceEvent.endSection("BlurView.getTargetParent");
        return;
    L10:
        this.m.setEmpty();
        this.n = false;
        setTargetBlurParent(this.k.O());
        TraceEvent.endSection("BlurView.getTargetParent");
    }

    public final void e() {
        boolean r1 = true;
        if (this.s == null) goto L35;
        if (this.t == null) goto L35;
        if (this.f != null) goto L10;
        return;
    L10:
        if (this.b == 0.0f) goto L40;
        Allocation r0 = Allocation.createFromBitmap(this.s, this.f);
        Bitmap r2 = this.f;     // Catch: Throwable -> L26 RSRuntimeException -> L28
        if (r2.getHeight() == this.x) goto L16;
    L18:
        r1 = false;
    L19:
        if (r1 == true) goto L24;
        Allocation r3 = this.v;     // Catch: Throwable -> L26 RSRuntimeException -> L28
        if (r3 == null) goto L23;
        r3.destroy();     // Catch: Throwable -> L26 RSRuntimeException -> L28
    L23:
        this.v = Allocation.createTyped(this.s, r0.getType());     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.w = this.f.getWidth();     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.x = this.f.getHeight();     // Catch: Throwable -> L26 RSRuntimeException -> L28
    L24:
        this.t.setRadius(this.b);     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.t.setInput(r0);     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.t.forEach(this.v);     // Catch: Throwable -> L26 RSRuntimeException -> L28
        this.v.copyTo(this.f);     // Catch: Throwable -> L26 RSRuntimeException -> L28
    L29:
        r0.destroy();
        return;
    L16:
        if (r2.getWidth() != this.w) goto L18;
    L26:
        th = move-exception;
        r0.destroy();
        throw th;
    L28:
        BlurUtils.iterativeBoxBlur(this.f, (int) this.b);     // Catch: Throwable -> L26
        goto L29
    L40:
        return;
    L35:
        if (Build.VERSION.SDK_INT >= 31) goto L41;
        this.y = true;
        return;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        TraceEvent.beginSection("BlurView.updateBlur");
        View r1 = this.l;
        if (r1 != null) goto L5;
    L7:
        TraceEvent.endSection("BlurView.updateBlur");
        return true;
    L5:
        if (r1.isDirty() == false) goto L7;
        this.A = true;
        post(new c(this));
        goto L7
    }

    public final void updateBlur() {
        if (this.c == true) goto L5;
        return;
    L5:
        if (this.d == true) goto L8;
        return;
    L8:
        if (this.n == false) goto L10;
        getTargetParent();
    L10:
        this.f.eraseColor(0);
        this.g.save();
        if (this.n == true) goto L14;
        boolean r0 = true;
    L17:
        if (r0 == false) goto L32;
        int[] r1 = this.i;
        if (r1 == null) goto L28;
        int[] r3 = this.j;
        if (r3 == null) goto L28;
        if (r1.length < 2) goto L28;
        if (r3.length < 2) goto L28;
        int r4 = r3[0] - r1[0];
        int r2 = r3[1] - r1[1];
        float r5 = getHeight() / this.f.getHeight();
        float r6 = getWidth() / this.f.getWidth();
        this.g.translate((-r4) / r6, (-r2) / r5);
        this.g.scale(1.0f / r6, 1.0f / r5);
    L28:
        TraceEvent.beginSection("BlurView.draw");
        View r7 = this.l;
        if (r7 == null) goto L31;
        r7.draw(this.g);
    L31:
        TraceEvent.endSection("BlurView.draw");
    L32:
        this.g.restore();
        TraceEvent.beginSection("BlurView.blur");
        if (BlurUtils.createEffect(this.a, this.b) == true) goto L35;
        e();
    L35:
        RenderNode r8 = this.a;
        if (r8 == null) goto L38;
        r8.beginRecording().drawBitmap(this.f, 0.0f, 0.0f, null);
        this.a.endRecording();
    L38:
        TraceEvent.endSection("BlurView.blur");
        return;
    L14:
        if (this.m.isEmpty() == false) goto L16;
        r0 = false;
        goto L17
    L16:
        float r9 = getHeight() / this.f.getHeight();
        float r10 = getWidth() / this.f.getWidth();
        d r11 = this.g;
        Rect r12 = this.m;
        r0 = r11.clipRect(r12.left / r10, r12.top / r9, r12.right / r10, r12.bottom / r9);
        goto L17
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.z = true;
        if (this.c == true) goto L5;
        return;
    L5:
        if (isHardwareAccelerated() == true) goto L8;
        LLog.e(B, "BlurView can't be used in not hardware-accelerated window!");
        return;
    L8:
        if (this.q == false) goto L13;
        getViewTreeObserver().addOnPreDrawListener(this);
        this.q = false;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.z = false;
        if (this.o == false) goto L6;
        getViewTreeObserver().removeOnPreDrawListener(this);
        this.q = true;
        return;
    }

    public a(Context r4) {
        super(r4);
        this.c = true;
        this.e = 6.0f;
        this.h = false;
        this.m = new Rect();
        this.p = true;
        this.r = new Object();
        this.u = false;
        this.y = false;
        this.z = false;
        this.A = false;
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 29) goto L6;
        this.a = new RenderNode("BlurView");
    L6:
        if (r5 >= 23) goto L9;
        this.c = false;
        return;
    L9:
        if (r5 >= 31) goto L13;
        LynxThreadPool.b().execute(new RunnableC0102a(this));
        return;
    }

    public static /* synthetic */ void c(a r0) {
        r0.getTargetParent();
    }

    private void setTargetBlurParent(LynxBaseUI r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isFlatten() == false) goto L10;
        if ((r2.getDrawParent() instanceof LynxUI) == false) goto L10;
        this.l = ((LynxUI) r2.getDrawParent()).getView();
        return;
    L10:
        if ((r2 instanceof LynxUI) == false) goto L14;
        this.l = ((LynxUI) r2).getView();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public final void draw(Canvas r6) {
        if (this.b != 0.0f) goto L5;
    L34:
        boolean r0 = true;
    L35:
        if (r0 == false) goto L38;
        super.draw(r6);
        return;
    L38:
        return;
    L5:
        if (this.d == false) goto L34;
        if (this.y == true) goto L34;
        if ((r6 instanceof d) == false) goto L12;
        r0 = false;
        goto L35
    L12:
        float r1 = getHeight() / this.f.getHeight();
        float r2 = getWidth() / this.f.getWidth();
        r6.save();
        if (this.h == false) goto L24;
        LynxUIBlurView r3 = this.k;
        if (r3 == null) goto L24;
        if (r3.getLynxBackground() == null) goto L19;
        BackgroundDrawable r4 = (BackgroundDrawable) this.k.getLynxBackground().b;
    L20:
        if (r4 == null) goto L24;
        Path r5 = r4.l();
        if (r5 == null) goto L24;
        r6.clipPath(r5);
        goto L24
    L19:
        r4 = null;
    L24:
        r6.scale(r2, r1);
        if (this.f == null) goto L33;
        TraceEvent.beginSection("BlurView.innerDraw");
        if (this.a != null) goto L29;
    L31:
        r6.drawBitmap(this.f, 0.0f, 0.0f, null);
    L32:
        TraceEvent.endSection("BlurView.innerDraw");
        goto L33
    L29:
        if (r6.isHardwareAccelerated() == false) goto L31;
        r6.drawRenderNode(this.a);
    L33:
        r6.restore();
        goto L34
    }

    public void setBlurRadius(float r3) {
        if (r3 >= 0.0f) goto L6;
        r3 = 0.0f;
    L6:
        if (this.b == r3) goto L9;
        this.b = r3;
        postInvalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a
    public void setBlurSampling(int r1) {
        super.setBlurSampling(r1);
        this.e = r1;
    }

    public void setBlurViewLocation(int[] r1) {
        this.j = r1;
    }

    public void setEnableBlurAutoUpdate(boolean r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        r3 = false;
    L6:
        if (this.c == r3) goto L9;
        post(new b(this, r3));
        return;
    }

    public void setExperimentalUpdateBlurRadius(boolean r1) {
        this.p = r1;
    }

    public void setHasRadiusIfRadiusChanged(boolean r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        return;
    }

    public void setLynxBaseUI(LynxUIBlurView r1) {
        this.k = r1;
    }

    public void setRootLocation(int[] r1) {
        this.i = r1;
    }

    public final void f(int r5, int r6) {
        if (this.o == false) goto L5;
    L7:
        float r7 = r5;
        if (((int) Math.ceil(r7 / this.e)) == 0) goto L33;
        float r8 = r6;
        if (((int) Math.ceil(r8 / this.e)) == 0) goto L33;
        int r0 = (int) Math.ceil(r7 / this.e);
        int r2 = r0 % 64;
        if (r2 == 0) goto L16;
        r0 = (r0 - r2) + 64;
    L16:
        int r9 = (int) Math.ceil(r8 / (r7 / r0));
        if (r0 <= 0) goto L31;
        if (r9 <= 0) goto L31;
        setWillNotDraw(false);
        Bitmap r3 = this.f;
        if (r3 != null) goto L23;
    L26:
        TraceEvent.beginSection("BlurView.createBitmap");
        this.f = Bitmap.createBitmap(r0, r9, Bitmap.Config.ARGB_8888);
        TraceEvent.endSection("BlurView.createBitmap");
        this.g = new d(this.f);
        RenderNode r10 = this.a;
        if (r10 == null) goto L29;
        r10.setPosition(0, 0, this.f.getWidth(), this.f.getHeight());
    L29:
        this.d = true;
        return;
    L23:
        if (r3.getHeight() != r9) goto L26;
        if (this.f.getWidth() == r0) goto L29;
    L31:
        setWillNotDraw(true);
        return;
    L33:
        setWillNotDraw(true);
        return;
    L5:
        if (this.c == false) goto L7;
        getViewTreeObserver().addOnPreDrawListener(this);
        this.o = true;
        goto L7
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.c == false) goto L10;
        if (this.h == false) goto L10;
        if (getBackground() == null) goto L10;
        getBackground().setBounds(0, 0, r1, r2);
    L10:
        if (this.p == true) goto L13;
        f(r1, r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.c == false) goto L6;
        getTargetParent();
        return;
    }
}
