package com.ss.android.lark.insets;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"com/ss/android/lark/insets/BaseWindowInsetsHandler$createCoordinator$coordinator$1", "Lcom/ss/android/lark/insets/FitSystemCoordinator;", "decorDrawable", "Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "getDecorDrawable", "()Lcom/ss/android/lark/insets/InsetsDecorationDrawable;", "checkDecorEdge", "", "getCheckDecorEdge", "()Z", "setCheckDecorEdge", "(Z)V", "requestLayout", "", "invalidate", "isDarkMode", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "Landroid/view/View;", "insets", "getScreenBounds", "Landroid/graphics/Rect;", "context", "Landroid/content/Context;", "updateDecorDrawableEdgeVisibility", "consumeWindowInsets", "nonNullInsets", "insets_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BaseWindowInsetsHandler$createCoordinator$coordinator$1 implements FitSystemCoordinator {
    public final g a;
    public boolean b;
    public final /* synthetic */ View c;
    public final /* synthetic */ c d;

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ BaseWindowInsetsHandler$createCoordinator$coordinator$1 a;
        public final /* synthetic */ View b;

        public a(BaseWindowInsetsHandler$createCoordinator$coordinator$1 r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
            boolean r16 = false;
            this.a.a.setBounds(0, 0, this.b.getWidth(), this.b.getHeight());
            BaseWindowInsetsHandler$createCoordinator$coordinator$1 r17 = this.a;
            if (r17.b == false) goto L41;
            int[] r18 = r17.d.l;
            ArraysKt.fill$default(r18, 0, 0, 0, 6, null);
            r17.c.getLocationOnScreen(r18);
            int r19 = r18[0];
            int r20 = r18[1];
            int r110 = r17.c.getWidth() + r19;
            int r111 = r17.c.getHeight() + r20;
            Context r112 = r17.c.getContext();
            r17.d.m.setEmpty();
            Object r113 = r112.getSystemService("window");
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.WindowManager");
            WindowManager r114 = (WindowManager) r113;
            if (Build.VERSION.SDK_INT < 30) goto L8;
            WindowMetrics r115 = r114.getCurrentWindowMetrics();
            r17.d.m.set(r115.getBounds());
            Rect r116 = r17.d.m;
        L9:
            g r117 = r17.a;
            if (r20 > r116.top) goto L12;
            boolean r21 = true;
        L14:
            if (r21 == r117.j) goto L17;
            r117.j = r21;
            r117.invalidateSelf();
        L17:
            g r22 = r17.a;
            if (r111 < (r116.bottom - 1)) goto L20;
            boolean r118 = true;
        L22:
            if (r118 == r22.k) goto L25;
            r22.k = r118;
            r22.invalidateSelf();
        L25:
            g r23 = r17.a;
            if (r19 > r116.left) goto L28;
            boolean r24 = true;
        L30:
            if (r24 == r23.l) goto L33;
            r23.l = r24;
            r23.invalidateSelf();
        L33:
            g r25 = r17.a;
            if (r110 < r116.right) goto L37;
            r16 = true;
        L37:
            if (r16 == r25.m) goto L42;
            r25.m = r16;
            r25.invalidateSelf();
            return;
        L42:
            return;
        L28:
            r24 = false;
            goto L30
        L20:
            r118 = false;
            goto L22
        L12:
            r21 = false;
            goto L14
        L8:
            DisplayMetrics r119 = new DisplayMetrics();
            r114.getDefaultDisplay().getRealMetrics(r119);
            r17.d.m.set(0, 0, r119.widthPixels, r119.heightPixels);
            r116 = r17.d.m;
            goto L9
        }
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ BaseWindowInsetsHandler$createCoordinator$coordinator$1 a;

        public b(BaseWindowInsetsHandler$createCoordinator$coordinator$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            this.a.a.setBounds(0, 0, r1.getWidth(), r1.getHeight());
        }
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final void invalidate() {
        this.c.invalidate();
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final boolean isDarkMode() {
        if ((this.c.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final void requestLayout() {
        this.c.requestLayout();
    }

    @Override // com.ss.android.lark.insets.FitSystemCoordinator
    public final g a() {
        return this.a;
    }

    public BaseWindowInsetsHandler$createCoordinator$coordinator$1(View r4, c r5) {
        this.c = r4;
        this.d = r5;
        g r6 = new g();
        this.a = r6;
        if (r4.isLaidOut() == true) goto L5;
    L7:
        r4.addOnLayoutChangeListener(new b(this));
    L8:
        r4.getOverlay().add(r6);
        r4.addOnLayoutChangeListener(new a(this, r4));
        return;
    L5:
        if (r4.isLayoutRequested() == true) goto L7;
        r6.setBounds(0, 0, r4.getWidth(), r4.getHeight());
        goto L8
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r8, WindowInsetsCompat r9) {
        Intrinsics.checkNotNullParameter(r8, "v");
        Intrinsics.checkNotNullParameter(r9, "insets");
        if (Build.VERSION.SDK_INT >= 30) goto L22;
        WindowInsets r10 = r9.toWindowInsets();
        if (r10 == null) goto L18;
        c r0 = this.d;
        int r2 = c.n;
        r0.getClass();
        boolean r3 = true;
        if (r10.getSystemWindowInsetTop() == 0) goto L9;
    L15:
        boolean r11 = false;
    L16:
        if (r11 != true) goto L18;
    L19:
        if (r3 == false) goto L22;
        return r9;
    L9:
        if (r10.getSystemWindowInsetBottom() != 0) goto L15;
        if (r10.getSystemWindowInsetLeft() != 0) goto L15;
        if (r10.getSystemWindowInsetRight() != 0) goto L15;
        r11 = true;
    L18:
        r3 = false;
    L22:
        if (this.d.g == false) goto L24;
        int r12 = WindowInsetsCompat.Type.ime() | 0;
    L26:
        if (this.d.j == false) goto L29;
        r12 = r12 | WindowInsetsCompat.Type.displayCutout();
    L29:
        if (this.d.i == false) goto L32;
        r12 = (r12 | WindowInsetsCompat.Type.statusBars()) | WindowInsetsCompat.Type.captionBar();
    L32:
        if (this.d.h == false) goto L34;
        r12 = r12 | WindowInsetsCompat.Type.navigationBars();
    L34:
        Insets r13 = r9.getInsets(r12);
        Insets r1 = r9.getInsets(WindowInsetsCompat.Type.systemBars());
        int r4 = r13.top + this.d.k;
        int r5 = WindowInsetsUtils.a;
        View r6 = this.c;
        int r7 = r13.bottom;
        r6.setPadding(r13.left, r4, r13.right, r7);
        this.a.a(r1);
        c r14 = this.d;
        int r15 = r14.e;
        g r16 = this.a;
        r16.f = r15;
        int r17 = r14.f;
        r16.g = r17;
        r16.h = r17;
        r16.i = r17;
        int r18 = Math.max(r13.left, 0);
        int r19 = Math.max(r13.right, 0);
        WindowInsetsCompat r20 = r9.inset(r18, Math.max(r13.top, 0), r19, Math.max(r13.bottom, 0));
        OnApplyWindowInsetsListener r21 = this.d.b;
        if (r21 == null) goto L38;
        r20 = r21.onApplyWindowInsets(this.c, r20);
    L38:
        return r20;
    L24:
        r12 = 0;
        goto L26
    }
}
