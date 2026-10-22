package com.larksuite.component.ui.imageview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import h18.e;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LKUIBadgeDrawable2 extends Drawable implements View.OnLayoutChangeListener {
    public static final /* synthetic */ int i = 0;
    public final Lazy a;
    public float b;
    public float c;
    public final Lazy d;
    public final Lazy e;
    public final WeakReference<View> f;
    public final Lazy g;
    public boolean h;

    public static final class a {
        @JvmStatic
        public static LKUIBadgeDrawable2 a(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            if (r5 < 0) goto L6;
            if (r5 >= 2) goto L6;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L19;
            Object r2 = r4.getTag(2131378567);
            if (r2 != null) goto L11;
        L12:
            r2 = new LKUIBadgeDrawable2[2];
        L13:
            LKUIBadgeDrawable2[] r3 = (LKUIBadgeDrawable2[]) r2;
            if (r3[r5] != null) goto L16;
            r3[r5] = new LKUIBadgeDrawable2(r4);
        L16:
            r4.setTag(2131378567, r3);
            LKUIBadgeDrawable2 r6 = r3[r5];
            Intrinsics.checkNotNull(r6);
            return r6;
        L11:
            if ((r2 instanceof Object[]) == true) goto L13;
        L19:
            throw new IndexOutOfBoundsException("only support 2 badge");
        L6:
            r1 = false;
            goto L7
        }
    }

    public final class b {
        public final LKUIBadgeDrawable2 a;
        public String b;
        public float c;
        public float d;
        public float e;
        public int f;
        public Drawable g;
        public float h;
        public Drawable i;
        public int j;
        public int k;
        public final /* synthetic */ LKUIBadgeDrawable2 l;

        public final LKUIBadgeDrawable2 a() {
            LKUIBadgeDrawable2 r0 = this.a;
            WeakReference<View> r1 = r0.f;
            View r2 = null;
            if (r1 == null) goto L5;
            View r3 = r1.get();
        L7:
            if (Intrinsics.areEqual(this, r0.a()) == true) goto L25;
            if (r3 == null) goto L25;
            b r4 = r0.a();
            r4.getClass();
            Intrinsics.checkNotNullParameter(this, "model");
            r4.b = this.b;
            r4.c = this.c;
            r4.f = this.f;
            r4.d = this.d;
            r4.e = this.e;
            r4.h = this.h;
            r4.g = this.g;
            r4.i = this.i;
            r4.j = this.j;
            r4.k = this.k;
            WeakReference<View> r5 = r0.f;
            if (r5 == null) goto L13;
            r2 = r5.get();
        L13:
            if (r2 != null) goto L15;
        L17:
            boolean r6 = false;
        L18:
            if (r6 == true) goto L23;
            ViewGroup r7 = (ViewGroup) r3.getParent();
            if (r7 == null) goto L22;
            r3 = r7;
        L22:
            r3.getOverlay().remove(r0);
            r3.getOverlay().add(r0);
            r0.h = true;
            r0.d();
            r3.addOnLayoutChangeListener(r0);
            goto L25
        L23:
            r0.d();
            goto L25
        L15:
            if (r0.h == false) goto L17;
            r6 = true;
        L25:
            return this.a;
        L5:
            r3 = null;
            goto L7
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (((((((((r0 + r3) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f) * 31;
            Drawable r5 = this.g;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (((r4 + r6) * 31) + Float.floatToIntBits(this.h)) * 31;
            Drawable r8 = this.i;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            return ((((r7 + r2) * 31) + this.j) * 31) + this.k;
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.ui.imageview.LKUIBadgeDrawable2.Model");
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
            return false;
        L19:
            if (this.c != r6.c) goto L21;
            boolean r1 = true;
        L22:
            if (r1 == true) goto L25;
            return false;
        L25:
            if (this.d != r6.d) goto L27;
            boolean r3 = true;
        L28:
            if (r3 == true) goto L31;
            return false;
        L31:
            if (this.e != r6.e) goto L33;
            boolean r4 = true;
        L34:
            if (r4 == true) goto L37;
            return false;
        L37:
            if (this.f == r6.f) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L43;
            return false;
        L43:
            if (this.h != r6.h) goto L45;
            boolean r7 = true;
        L46:
            if (r7 == true) goto L49;
            return false;
        L49:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L52;
            return false;
        L52:
            if (this.j == r6.j) goto L55;
            return false;
        L55:
            if (this.k == r6.k) goto L57;
            return false;
        L57:
            return true;
        L45:
            r7 = false;
            goto L46
        L33:
            r4 = false;
            goto L34
        L27:
            r3 = false;
            goto L28
        L21:
            r1 = false;
            goto L22
        L8:
            r2 = null;
            goto L10
        }

        public b(LKUIBadgeDrawable2 r2, LKUIBadgeDrawable2 r3) {
            Intrinsics.checkNotNullParameter(r3, "drawable");
            this.l = r2;
            this.a = r3;
            this.c = 10.0f;
            this.d = 15.0f;
            this.e = 10.0f;
            this.f = -1;
            this.j = 1;
            this.k = 3;
        }
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public final b a() {
        return (b) this.d.getValue();
    }

    public final com.larksuite.component.ui.imageview.b b() {
        return (com.larksuite.component.ui.imageview.b) this.g.getValue();
    }

    public final b c() {
        b r0 = (b) this.e.getValue();
        r0.b = null;
        r0.c = 10.0f;
        r0.d = 15.0f;
        r0.e = 10.0f;
        r0.h = 0.0f;
        r0.f = -1;
        r0.g = null;
        r0.i = null;
        r0.j = 1;
        r0.k = 3;
        return (b) this.e.getValue();
    }

    public final void d() {
        WeakReference<View> r0 = this.f;
        if (r0 == null) goto L71;
        View r1 = r0.get();
        if (r1 == null) goto L72;
        Rect r2 = new Rect();
        r1.getDrawingRect(r2);
        ViewGroup r3 = (ViewGroup) r1.getParent();
        if (r3 == null) goto L10;
        r3.offsetDescendantRectToMyCoords(r1, r2);
    L10:
        if (r2.isEmpty() == false) goto L12;
        return;
    L12:
        int r4 = r1.getPaddingLeft();
        int r5 = r1.getPaddingTop();
        int r6 = r1.getPaddingRight();
        int r7 = r1.getPaddingBottom();
        com.larksuite.component.ui.imageview.b r8 = b();
        String r9 = a().b;
        if (Intrinsics.areEqual(r8.b, r9) == true) goto L15;
        r8.c = -1.0f;
        r8.b = r9;
    L15:
        com.larksuite.component.ui.imageview.b r10 = b();
        float r11 = a().c;
        if (r10.a.getTextSize() != r11) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L21;
        r10.a.setTextSize(r11);
        r10.c = -1.0f;
        r10.d = -1.0f;
    L21:
        float r13 = b().a();
        com.larksuite.component.ui.imageview.b r14 = b();
        float r15 = r14.d;
        if (r15 > 0.0f) goto L25;
        Paint.FontMetrics r16 = r14.a.getFontMetrics();
        r15 = r16.descent - r16.ascent;
    L25:
        Drawable r17 = a().g;
        if (r17 == null) goto L28;
        float r19 = r17.getIntrinsicWidth();
    L29:
        Drawable r110 = a().g;
        if (r110 == null) goto L32;
        float r111 = r110.getIntrinsicHeight();
    L33:
        Drawable r112 = a().i;
        if (r112 == null) goto L36;
        float r113 = r112.getIntrinsicWidth();
    L37:
        Drawable r114 = a().i;
        if (r114 == null) goto L40;
        float r115 = r114.getIntrinsicHeight();
    L42:
        if (r13 <= 0.0f) goto L44;
        float r116 = 2;
        float r20 = Math.max(r13 + (a().d * r116), r113) / r116;
        float r21 = Math.max(r15 + (a().e * r116), r115) / r116;
    L45:
        this.b = r2.right - r6;
        if (a().j != 1) goto L48;
        float r22 = r2.top + r5;
    L49:
        this.c = r22;
        if (a().k != 2) goto L57;
        this.b -= r20;
        float r23 = this.c;
        if (a().j != 1) goto L54;
        float r24 = r21;
    L55:
        this.c = r23 + r24;
    L63:
        Drawable r25 = a().i;
        if (r25 == null) goto L66;
        float r26 = this.b;
        float r27 = this.c;
        r25.setBounds((int) (r26 - r20), (int) (r27 - r21), (int) (r26 + r20), (int) (r27 + r21));
    L66:
        Drawable r29 = a().g;
        if (r29 == null) goto L69;
        float r30 = this.b;
        float r31 = 2;
        float r32 = r19 / r31;
        float r33 = this.c;
        float r117 = r111 / r31;
        r29.setBounds((int) (r30 - r32), (int) (r33 - r117), (int) (r30 + r32), (int) (r33 + r117));
    L69:
        Rect r34 = (Rect) this.a.getValue();
        float r35 = this.b;
        float r36 = this.c;
        r34.set((int) (r35 - r20), (int) (r36 - r21), (int) (r35 + r20), (int) (r36 + r21));
        invalidateSelf();
        return;
    L54:
        r24 = -r21;
        goto L55
    L57:
        if (a().k != 3) goto L63;
        this.b -= (((r2.width() - r4) - r6) / 2) * 0.2929f;
        float r37 = (((r2.height() - r5) - r7) / 2) * 0.2929f;
        float r38 = this.c;
        if (a().j == 1) goto L62;
        r37 = -r37;
    L62:
        this.c = r38 + r37;
        goto L63
    L48:
        r22 = r2.bottom - r7;
        goto L49
    L44:
        float r39 = 2;
        r20 = Math.max(r19, r113) / r39;
        r21 = Math.max(r111, r115) / r39;
        goto L45
    L40:
        r115 = 0.0f;
        goto L42
    L36:
        r113 = 0.0f;
        goto L37
    L32:
        r111 = 0.0f;
        goto L33
    L28:
        r19 = 0.0f;
        goto L29
    L18:
        r12 = false;
        goto L19
    L72:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((Rect) this.a.getValue()).height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((Rect) this.a.getValue()).width();
    }

    public LKUIBadgeDrawable2() {
        this.a = LazyKt.lazy(LKUIBadgeDrawable2$badgeBounds$2.INSTANCE);
        this.d = LazyKt.lazy(new LKUIBadgeDrawable2$currentModel$2(this));
        this.e = LazyKt.lazy(new LKUIBadgeDrawable2$updateModel$2(this));
        this.g = LazyKt.lazy(LKUIBadgeDrawable2$textDrawableHelper$2.INSTANCE);
    }

    public LKUIBadgeDrawable2(View r3) {
        this();
        this.f = new WeakReference(r3);
        com.larksuite.component.ui.imageview.b r0 = b();
        int r1 = e.a;
        Typeface r4 = e.a(r3.getContext());
        r0.a.setTypeface(r4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        if (isVisible() == false) goto L39;
        WeakReference<View> r1 = this.f;
        if (r1 == null) goto L7;
        View r2 = r1.get();
    L8:
        boolean r3 = false;
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L42;
        Drawable r5 = a().i;
        if (r5 == null) goto L19;
        r5.draw(r7);
    L19:
        Drawable r6 = a().g;
        if (r6 == null) goto L22;
        r6.draw(r7);
    L22:
        String r8 = a().b;
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L30:
        if ((!r9) == false) goto L40;
        com.larksuite.component.ui.imageview.b r10 = b();
        r10.a.setColor(a().f);
        com.larksuite.component.ui.imageview.b r11 = b();
        int r12 = ((Rect) this.a.getValue()).centerX();
        int r13 = ((Rect) this.a.getValue()).centerY();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r7, "canvas");
        CharSequence r0 = r11.b;
        if (r0 != null) goto L34;
    L35:
        r3 = true;
    L36:
        if (r3 == true) goto L41;
        r11.a.setTextAlign(Paint.Align.CENTER);
        CharSequence r14 = r11.b;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.String");
        r7.drawText((String) r14, r12, r13 - ((r11.a.descent() + r11.a.ascent()) / 2), r11.a);
        return;
    L41:
        return;
    L34:
        if (r0.length() != 0) goto L36;
    L40:
        return;
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
        goto L30
    L42:
        return;
    L11:
        if (this.h == false) goto L13;
        r4 = true;
        goto L14
    L7:
        r2 = null;
        goto L8
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        d();
    }
}
