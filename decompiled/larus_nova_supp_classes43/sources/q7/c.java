package q7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.annie.Annie;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class c extends d implements o7.a, o7.c {
    public final Path f;
    public final RectF g;
    public final Paint h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public o7.c.a o;
    public boolean p;
    public boolean q;
    public ViewParent r;
    public boolean s;
    public float t;
    public VelocityTracker u;

    @Override // o7.a
    public final void b() {
        this.s = false;
        this.t = 0.0f;
    }

    public final void d() {
        this.g.set(getScrollX(), getScrollY(), getScrollX() + getWidth(), getScrollY() + getHeight());
        this.f.reset();
        this.f.setFillType(Path.FillType.INVERSE_WINDING);
    }

    public c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.f = new Path();
        this.g = new RectF();
        Paint r11 = new Paint(1);
        this.h = r11;
        r11.setStyle(Paint.Style.FILL);
        r11.setColor(0);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.s == false) goto L37;
        int r0 = r10.getAction();
        if (r0 == 0) goto L33;
        if (r0 != 1) goto L8;
    L30:
        VelocityTracker r1 = this.u;
        if (r1 == null) goto L37;
        r1.clear();
        r1.recycle();
        goto L37
    L8:
        if (r0 != 2) goto L10;
        VelocityTracker r11 = this.u;
        if (r11 == null) goto L15;
        r11.addMovement(r10);
    L15:
        VelocityTracker r12 = this.u;
        if (r12 == null) goto L18;
        r12.computeCurrentVelocity(IServerListener.WHAT_BYTELINK_SINK_ERROR);
    L18:
        VelocityTracker r13 = this.u;
        if (r13 == null) goto L21;
        float r14 = r13.getYVelocity();
    L23:
        if (Math.abs(r14) <= this.t) goto L27;
        ViewParent r15 = e(this);
        this.r = r15;
        if (r15 == null) goto L37;
        r15.requestDisallowInterceptTouchEvent(false);
        goto L37
    L27:
        ViewParent r16 = e(this);
        this.r = r16;
        if (r16 == null) goto L37;
        r16.requestDisallowInterceptTouchEvent(true);
        goto L37
    L21:
        r14 = 0.0f;
        goto L23
    L10:
        if (r0 == 3) goto L30;
    L33:
        this.u = VelocityTracker.obtain();
        ViewParent r17 = e(this);
        this.r = r17;
        if (r17 == null) goto L37;
        r17.requestDisallowInterceptTouchEvent(true);
    L37:
        return super.dispatchTouchEvent(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ViewParent e(View r10) {
        ViewParent r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ViewParent r11 = r10.getParent();
        if (r11 != 0) goto L8;
        return null;
    L8:
        boolean r1 = ((ca.b) Annie.getService$default(ca.b.class, null, 2, null)).G1(r11);
        if ((r11 instanceof CoordinatorLayout) == false) goto L11;
        return r11;
    L11:
        if ((r11 instanceof ViewPager) == false) goto L13;
        return r11;
    L13:
        if ((r11 instanceof AbsListView) == false) goto L15;
        return r11;
    L15:
        if ((r11 instanceof ScrollView) == true) goto L25;
        if (r1 == false) goto L19;
        return r11;
    L19:
        if ((r11 instanceof View) == true) goto L21;
        return r11;
    L21:
        return e((View) r11);
    L25:
        return r11;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        if (this.i != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        d();
        Path r1 = this.f;
        RectF r11 = this.g;
        float r12 = this.i;
        r1.addRoundRect(r11, r12, r12, Path.Direction.CW);
        r10.drawPath(this.f, this.h);
        return;
    L8:
        float r13 = this.j;
        if (r13 != 0.0f) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == true) goto L14;
    L32:
        d();
        float r15 = this.j;
        float r16 = this.k;
        float r17 = this.m;
        float r18 = this.l;
        this.f.addRoundRect(this.g, new float[]{r15, r15, r16, r16, r17, r17, r18, r18}, Path.Direction.CW);
        r10.drawPath(this.f, this.h);
        return;
    L14:
        if (r13 != 0.0f) goto L16;
        boolean r19 = true;
    L17:
        if (r19 == false) goto L32;
        if (this.l != 0.0f) goto L21;
        boolean r20 = true;
    L22:
        if (r20 == false) goto L32;
        if (this.m != 0.0f) goto L26;
        boolean r21 = true;
    L27:
        if (r21 == false) goto L32;
        if (this.n == false) goto L35;
        d();
        this.f.addRoundRect(this.g, 0.0f, 0.0f, Path.Direction.CW);
        r10.drawPath(this.f, this.h);
        return;
    L35:
        return;
    L26:
        r21 = false;
        goto L27
    L21:
        r20 = false;
        goto L22
    L16:
        r19 = false;
        goto L17
    L11:
        r14 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.p == false) goto L12;
        if (r10.getAction() != 0) goto L12;
        if (this.q == true) goto L12;
        ViewParent r0 = e(this);
        this.r = r0;
        if (r0 == null) goto L12;
        r0.requestDisallowInterceptTouchEvent(true);
    L12:
        return super.onTouchEvent(r10);
    }

    public final void setEnableTouchEventCheck(boolean r1) {
        this.p = r1;
        if (r1 == false) goto L6;
        this.q = true;
        return;
    }

    @Override // o7.c
    public void setOnScrollChangeListener(o7.c.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.o = r10;
    }

    @Override // o7.a
    public void setRadius(float r1) {
        this.i = r1;
        this.n = true;
        invalidate();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onScrollChanged(int r10, int r11, int r12, int r13) {
        if (this.p == true) goto L5;
    L10:
        o7.c.a r0 = this.o;
        if (r0 == null) goto L13;
        r0.a(r10, r11, r12, r13);
    L13:
        super.onScrollChanged(r10, r11, r12, r13);
        return;
    L5:
        if (r11 != 0) goto L9;
        this.q = true;
        ViewParent r1 = e(this);
        if (r1 == null) goto L10;
        r1.requestDisallowInterceptTouchEvent(false);
        goto L10
    L9:
        this.q = false;
        goto L10
    }

    @Override // o7.a
    public final void setRadius(float r10, float r11, float r12, float r13) {
        this.i = 0.0f;
        this.j = r10;
        this.k = r11;
        this.l = r13;
        this.m = r12;
        this.n = true;
        invalidate();
    }
}
