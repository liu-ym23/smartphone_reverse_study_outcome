package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f997b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TypedValue f998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TypedValue f999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TypedValue f1000o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TypedValue f1001p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f1002q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f1003r;

    public interface a {
    }

    public ContentFrameLayout(Context r8, AttributeSet r10) {
        super(r8, r10, 0);
        this.f1002q = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1000o != null) goto L6;
        this.f1000o = new TypedValue();
    L6:
        return this.f1000o;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1001p != null) goto L6;
        this.f1001p = new TypedValue();
    L6:
        return this.f1001p;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f998m != null) goto L6;
        this.f998m = new TypedValue();
    L6:
        return this.f998m;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f999n != null) goto L6;
        this.f999n = new TypedValue();
    L6:
        return this.f999n;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f996a != null) goto L6;
        this.f996a = new TypedValue();
    L6:
        return this.f996a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f997b != null) goto L6;
        this.f997b = new TypedValue();
    L6:
        return this.f997b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a r8 = this.f1003r;
        if (r8 == null) goto L6;
        r8.getClass();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a r8 = this.f1003r;
        if (r8 == null) goto L23;
        AppCompatDelegateImpl r10 = ((androidx.appcompat.app.j) r8).f658a;
        b0 r11 = r10.B;
        if (r11 == null) goto L8;
        r11.l();
    L8:
        if (r10.G == null) goto L13;
        r10.f596v.getDecorView().removeCallbacks(r10.H);
        if (r10.G.isShowing() == true) goto L21;
    L12:
        r10.G = null;
        goto L13
    L21:
        r10.G.dismiss();     // Catch: IllegalArgumentException -> L20
    L13:
        j0.h0 r12 = r10.I;
        if (r12 == null) goto L16;
        r12.b();
    L16:
        androidx.appcompat.view.menu.f r13 = r10.Q(0).f608h;
        if (r13 == null) goto L24;
        r13.d(true);
        return;
    L24:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r17, int r18) {
        DisplayMetrics r8 = getContext().getResources().getDisplayMetrics();
        boolean r10 = true;
        if (r8.widthPixels >= r8.heightPixels) goto L5;
        boolean r11 = true;
    L6:
        int r12 = View.MeasureSpec.getMode(r17);
        int r13 = View.MeasureSpec.getMode(r18);
        Rect r14 = this.f1002q;
        if (r12 != Integer.MIN_VALUE) goto L22;
        if (r11 == false) goto L10;
        TypedValue r15 = this.f999n;
    L11:
        if (r15 == null) goto L22;
        int r16 = r15.type;
        if (r16 == 0) goto L22;
        if (r16 != 5) goto L17;
        float r19 = r15.getDimension(r8);
    L16:
        int r110 = (int) r19;
    L20:
        if (r110 <= 0) goto L22;
        int r111 = View.MeasureSpec.makeMeasureSpec(Math.min(r110 - (r14.left + r14.right), View.MeasureSpec.getSize(r17)), 1073741824);
        boolean r112 = true;
    L23:
        if (r13 != Integer.MIN_VALUE) goto L38;
        if (r11 == false) goto L26;
        TypedValue r20 = this.f1000o;
    L27:
        if (r20 == null) goto L38;
        int r113 = r20.type;
        if (r113 == 0) goto L38;
        if (r113 != 5) goto L33;
        float r21 = r20.getDimension(r8);
    L32:
        int r22 = (int) r21;
    L36:
        if (r22 <= 0) goto L38;
        int r23 = View.MeasureSpec.makeMeasureSpec(Math.min(r22 - (r14.top + r14.bottom), View.MeasureSpec.getSize(r18)), 1073741824);
    L39:
        super.onMeasure(r111, r23);
        int r114 = getMeasuredWidth();
        int r115 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        if (r112 == true) goto L58;
        if (r12 != Integer.MIN_VALUE) goto L58;
        if (r11 == false) goto L44;
        TypedValue r24 = this.f997b;
    L45:
        if (r24 == null) goto L58;
        int r25 = r24.type;
        if (r25 == 0) goto L58;
        if (r25 != 5) goto L51;
        float r26 = r24.getDimension(r8);
    L50:
        int r27 = (int) r26;
    L54:
        if (r27 <= 0) goto L56;
        r27 = r27 - (r14.left + r14.right);
    L56:
        if (r114 >= r27) goto L58;
        r115 = View.MeasureSpec.makeMeasureSpec(r27, 1073741824);
    L59:
        if (r10 == false) goto L62;
        super.onMeasure(r115, r23);
        return;
    L62:
        return;
    L51:
        if (r25 != 6) goto L53;
        int r28 = r8.widthPixels;
        r26 = r24.getFraction(r28, r28);
        goto L50
    L53:
        r27 = 0;
        goto L54
    L44:
        r24 = this.f996a;
    L58:
        r10 = false;
        goto L59
    L33:
        if (r113 != 6) goto L35;
        int r116 = r8.heightPixels;
        r21 = r20.getFraction(r116, r116);
        goto L32
    L35:
        r22 = 0;
        goto L36
    L26:
        r20 = this.f1001p;
    L38:
        r23 = r18;
        goto L39
    L17:
        if (r16 != 6) goto L19;
        int r117 = r8.widthPixels;
        r19 = r15.getFraction(r117, r117);
        goto L16
    L19:
        r110 = 0;
        goto L20
    L10:
        r15 = this.f998m;
    L22:
        r111 = r17;
        r112 = false;
        goto L23
    L5:
        r11 = false;
        goto L6
    }

    public void setAttachListener(a r8) {
        this.f1003r = r8;
    }
}
