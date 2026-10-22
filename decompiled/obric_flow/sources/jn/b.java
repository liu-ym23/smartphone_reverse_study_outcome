package jn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends FrameLayout implements com.lynx.tasm.behavior.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f18363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f18364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18365c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.b f18366h;

    public b(Context r5) {
        super(r5, null);
        this.d = XSwiperUI.G;
        this.e = XSwiperUI.H;
        this.f = 0;
        this.g = 0;
        this.f18365c = (int) com.lynx.tasm.utils.g.a(7.0f, 0.0f);
        f r10 = new f(r5);
        this.f18363a = r10;
        addView(r10, new FrameLayout.LayoutParams(-1, -1));
        this.f18364b = new LinearLayout(r5);
        d(0);
    }

    public static GradientDrawable a(int r5) {
        GradientDrawable r10 = new GradientDrawable();
        r10.setShape(1);
        r10.setColor(r5);
        return r10;
    }

    public final void b() {
        View r5 = new View(getContext());
        r5.setClickable(false);
        int r10 = this.f18365c;
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(r10, r10);
        if (this.g != 1) goto L5;
        int r12 = r10 / 2;
        r11.bottomMargin = r12;
        r11.topMargin = r12;
    L6:
        LinearLayout r13 = this.f18364b;
        r13.addView(r5, r11);
        int r14 = r13.getChildCount();
        int r15 = this.d;
        if (r14 != r15) goto L10;
        r5.setBackground(a(r15));
        return;
    L10:
        r5.setBackground(a(this.e));
        return;
    L5:
        int r16 = r10 / 2;
        r11.rightMargin = r16;
        r11.leftMargin = r16;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public final void bindDrawChildHook(com.lynx.tasm.behavior.ui.b r5) {
        this.f18366h = r5;
    }

    public final void c() {
        LinearLayout r5 = this.f18364b;
        int r10 = r5.getChildCount();
    L3:
        r10 = r10 - 1;
        if (r10 <= (-1)) goto L10;
        View r11 = r5.getChildAt(r10);
        if (r10 != this.f) goto L8;
        r11.setBackground(a(this.d));
        goto L3
    L8:
        r11.setBackground(a(this.e));
        goto L3
    }

    public final void d(int r10) {
        LinearLayout r5 = this.f18364b;
        int r11 = 0;
        if (r10 != 1) goto L5;
        r5.setGravity(16);
        r5.setOrientation(1);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -1);
        r12.rightMargin = (int) com.lynx.tasm.utils.g.a(10.0f, 0.0f);
        r12.gravity = 8388629;
    L6:
        addView(r5, r12);
        int r13 = r5.getChildCount();
        r5.removeAllViews();
    L7:
        if (r11 >= r13) goto L9;
        b();
        r11 = r11 + 1;
        goto L7
    L9:
        c();
        return;
    L5:
        r5.setGravity(17);
        r5.setOrientation(0);
        r12 = new FrameLayout.LayoutParams(-1, -2);
        r12.bottomMargin = (int) com.lynx.tasm.utils.g.a(10.0f, 0.0f);
        r12.gravity = 81;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        this.f18366h.beforeDispatchDraw(r5);
        super.dispatchDraw(r5);
    }
}
