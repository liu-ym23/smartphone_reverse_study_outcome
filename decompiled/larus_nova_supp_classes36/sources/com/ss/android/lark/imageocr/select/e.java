package com.ss.android.lark.imageocr.select;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.imageocr.view.OCRPickTextView;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public c a;
    public c b;
    public d c;
    public final com.ss.android.lark.imageocr.select.c d;
    public final Context e;
    public final SelectTextView f;
    public Spannable g;
    public int h;
    public int i;
    public final int j;
    public final int k;
    public Rect l;
    public Rect m;
    public final List<com.ss.android.lark.imageocr.select.b> n;
    public final boolean o;
    public boolean p;
    public boolean q;
    public k r;
    public l s;
    public final RunnableC0097e t;

    public static final class a {
        public final SelectTextView a;
        public int b;
        public float c;
        public int d;
        public List<com.ss.android.lark.imageocr.select.b> e;
        public boolean f;

        public a(OCRPickTextView r2) {
            Intrinsics.checkNotNullParameter(r2, "mTextView");
            this.a = r2;
            this.b = -15500842;
            this.c = 24.0f;
            this.d = -5250572;
        }
    }

    public static final class b {
    }

    public final class c extends View {
        public boolean a;
        public final PopupWindow b;
        public final Paint c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public final int[] l;
        public final /* synthetic */ e m;

        public final int a() {
            return (this.l[0] - this.g) + this.m.f.getPaddingLeft();
        }

        public final void c() {
            this.m.f.getLocationInWindow(this.l);
            Layout r0 = this.m.f.getLayout();
            if (this.a == false) goto L13;
            PopupWindow r1 = this.b;
            int r4 = (((int) r0.getPrimaryHorizontal(this.m.d.a)) - this.e) + a();
            int r2 = r0.getLineBottom(r0.getLineForOffset(this.m.d.a)) + (this.l[1] + this.m.f.getPaddingTop());
            if ((r1 instanceof PopupWindow) == false) goto L10;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r1) == false) goto L10;
            r1.update(r4, r2, -1, -1);
            return;
        L10:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r1, r4, r2, -1, -1) == true) goto L26;
            r1.update(r4, r2, -1, -1);
            return;
        L26:
            return;
        L13:
            PopupWindow r3 = this.b;
            int r5 = ((int) r0.getPrimaryHorizontal(this.m.d.b)) + a();
            int r6 = r0.getLineBottom(r0.getLineForOffset(this.m.d.b)) + (this.l[1] + this.m.f.getPaddingTop());
            if ((r3 instanceof PopupWindow) == false) goto L19;
            if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r3) == false) goto L19;
            r3.update(r5, r6, -1, -1);
            return;
        L19:
            if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r3, r5, r6, -1, -1) == true) goto L27;
            r3.update(r5, r6, -1, -1);
            return;
        }

        @Override // android.view.View
        public final void onDraw(Canvas r10) {
            Intrinsics.checkNotNullParameter(r10, "canvas");
            int r0 = this.d;
            r10.drawCircle(this.g + r0, r0, r0, this.c);
            if (this.a == false) goto L5;
            int r1 = this.d;
            int r2 = this.g;
            r10.drawRect(r1 + r2, 0.0f, (r1 * 2) + r2, r1, this.c);
            return;
        L5:
            int r3 = this.g;
            int r4 = this.d;
            r10.drawRect(r3, 0.0f, r3 + r4, r4, this.c);
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            int r0 = r4.getAction();
            if (r0 == 0) goto L17;
            if (r0 != 1) goto L6;
        L14:
            d r5 = this.m.c;
            if (r5 == null) goto L18;
            r5.a();
        L18:
            return true;
        L6:
            if (r0 != 2) goto L8;
            d r1 = this.m.c;
            if (r1 == null) goto L13;
            PopupWindow r2 = r1.a;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
        L13:
            int r3 = (int) r4.getRawX();
            int r6 = (int) r4.getRawY();
            update((r3 + this.h) - this.e, (r6 + this.i) - this.f);
            goto L18
        L8:
            if (r0 == 3) goto L14;
        L17:
            com.ss.android.lark.imageocr.select.c r7 = this.m.d;
            this.j = r7.a;
            this.k = r7.b;
            this.h = (int) r4.getX();
            this.i = (int) r4.getY();
            goto L18
        }

        public c(e r6, boolean r7) {
            this.m = r6;
            super(r6.e);
            this.a = r7;
            Paint r8 = new Paint(1);
            this.c = r8;
            int r0 = r6.k / 2;
            this.d = r0;
            int r2 = r0 * 2;
            this.e = r2;
            int r1 = r0 * 2;
            this.f = r1;
            this.g = 25;
            this.l = new int[2];
            r8.setColor(r6.j);
            PopupWindow r9 = new PopupWindow(this);
            this.b = r9;
            r9.setClippingEnabled(false);
            r9.setWidth(r2 + (25 * 2));
            r9.setHeight(r1 + (25 / 2));
            invalidate();
        }

        public final void b(int r11, int r12) {
            this.m.f.getLocationInWindow(this.l);
            if (this.a == false) goto L5;
            int r0 = this.e;
        L6:
            int r13 = (r11 - r0) + a();
            boolean r2 = true;
            int r14 = r12 + (this.l[1] + this.m.f.getPaddingTop());
            Rect r1 = this.m.m;
            if (r1 != null) goto L9;
        L13:
            PopupWindow r3 = this.b;
            SelectTextView r8 = this.m.f;
            if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L17;
            return;
        L17:
            if ((r3 instanceof PopupWindow) == true) goto L19;
        L21:
            OverlaySource r9 = PopupWindowLancet.resolveSource(r8);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r3, r8, r9, 0, r13, r14) == true) goto L29;
            r3.showAtLocation(r8, 0, r13, r14);
            PopupWindowLancet.trackAfterShow(r3, r9, r8);
            return;
        L29:
            return;
        L19:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r3) == false) goto L21;
            r3.showAtLocation(r8, 0, r13, r14);
            return;
        L9:
            if (r1.contains(r13, r14) == true) goto L12;
            r2 = false;
        L12:
            if (r2 == true) goto L13;
            return;
        L5:
            r0 = 0;
            goto L6
        }

        public final void update(int r13, int r14) {
            this.m.f.getLocationOnScreen(this.l);
            if (this.a == false) goto L5;
            int r0 = this.m.d.a;
        L6:
            int[] r1 = this.l;
            boolean r2 = false;
            int r15 = r13 - r1[0];
            int r16 = (r14 - r1[1]) - this.m.f.getLineHeight();
            SelectTextView r3 = this.m.f;
            int r4 = com.ss.android.lark.imageocr.select.d.a;
            Intrinsics.checkNotNullParameter(r3, "textView");
            Layout r5 = r3.getLayout();
            if (r5 != null) goto L9;
            int r17 = -1;
        L41:
            if (r17 == r0) goto L74;
            e r18 = this.m;
            r18.d.c = null;
            SelectTextView r19 = r18.f;
            r19.b = -1;
            r19.c = -1;
            r19.invalidate();
            boolean r110 = this.a;
            if (r110 == false) goto L58;
            int r6 = this.k;
            if (r17 <= r6) goto L55;
            e r7 = this.m;
            c r8 = r7.a;
            if (r8 != null) goto L49;
        L51:
            if (r2 == true) goto L54;
            r8 = r7.b;
        L54:
            this.a = !r110;
            invalidate();
            Intrinsics.checkNotNull(r8);
            r8.a = !r8.a;
            r8.invalidate();
            int r111 = this.k;
            this.j = r111;
            this.m.c(r111, r17);
            r8.c();
        L72:
            c();
            return;
        L49:
            if (r8.a == true) goto L51;
            r2 = true;
            goto L51
        L55:
            if (r17 != r6) goto L57;
            this.m.c(r17 - 1, r6);
            goto L72
        L57:
            this.m.c(r17, r6);
            goto L72
        L58:
            int r112 = this.j;
            if (r17 >= r112) goto L69;
            e r113 = this.m;
            c r9 = r113.a;
            if (r9 != null) goto L63;
        L65:
            if (r2 == true) goto L68;
            r9 = r113.b;
        L68:
            Intrinsics.checkNotNull(r9);
            r9.a = !r9.a;
            r9.invalidate();
            this.a = !this.a;
            invalidate();
            int r114 = this.j;
            this.k = r114;
            this.m.c(r17, r114);
            r9.c();
            goto L72
        L63:
            if (r9.a != true) goto L65;
            r2 = true;
            goto L65
        L69:
            if (r112 != r17) goto L71;
            this.m.c(r112, r17 + 1);
            goto L72
        L71:
            this.m.c(r112, r17);
            goto L72
        L74:
            return;
        L9:
            int r10 = r5.getLineForVertical(r16);
            if (r0 > 0) goto L12;
        L14:
            boolean r11 = false;
        L15:
            if (r11 == false) goto L19;
            int r12 = r0 - 1;
            int r20 = (int) r5.getPrimaryHorizontal(r12);
            int r21 = (int) r5.getLineRight(r10);
            if (r15 <= (r21 - ((r21 - r20) / 2))) goto L19;
        L20:
            int r22 = r5.getLineForOffset(r12);
            int r23 = r5.getLineTop(r22);
            int r24 = r5.getLineBottom(r22);
            int r115 = (r24 - r23) / 2;
            if (r10 != (r22 + 1)) goto L25;
            if ((r16 - r24) >= r115) goto L25;
        L28:
            r10 = r22;
        L29:
            r17 = r5.getOffsetForHorizontal(r10, r15);
            if (r17 >= (r3.getText().length() - 1)) goto L41;
            int r25 = r17 + 1;
            if (r25 > 0) goto L34;
        L36:
            boolean r26 = false;
        L37:
            if (r26 == false) goto L41;
            int r27 = (int) r5.getPrimaryHorizontal(r17);
            int r28 = (int) r5.getLineRight(r10);
            if (r15 <= (r28 - ((r28 - r27) / 2))) goto L41;
            r17 = r25;
            goto L41
        L34:
            if (r5.getLineForOffset(r25) != (r5.getLineForOffset(r25 - 1) + 1)) goto L36;
            r26 = true;
        L25:
            if (r10 != (r22 - 1)) goto L29;
            if ((r23 - r16) >= r115) goto L29;
        L19:
            r12 = r0;
            goto L20
        L12:
            if (r5.getLineForOffset(r0) != (r5.getLineForOffset(r0 - 1) + 1)) goto L14;
            r11 = true;
            goto L15
        L5:
            r0 = this.m.d.b;
            goto L6
        }
    }

    public final class d {
        public final PopupWindow a;
        public final int[] b;
        public final int c;
        public final int d;
        public int e;
        public final /* synthetic */ e f;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ com.ss.android.lark.imageocr.select.b a;
            public final /* synthetic */ e b;

            public a(com.ss.android.lark.imageocr.select.b r1, e r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                com.ss.android.lark.imageocr.select.b r4 = this.a;
                r4.c.a(r4.a, this.b.d.c);
                this.b.b();
            }
        }

        public final void a() {
            this.f.f.getLocationInWindow(this.b);
            Layout r0 = this.f.f.getLayout();
            Layout r1 = this.f.f.getLayout();
            boolean r2 = true;
            float r3 = 0.0f;
            if (r1 == null) goto L16;
            com.ss.android.lark.imageocr.select.c r4 = this.f.d;
            int r5 = r4.a + 1;
            int r6 = r4.b;
            if (r5 > r6) goto L16;
        L8:
            if (r1.getLineForOffset(r5) != r1.getLineForOffset(this.f.d.a)) goto L16;
            float r7 = r1.getPrimaryHorizontal(r5) - r1.getPrimaryHorizontal(this.f.d.a);
            if (r7 <= r3) goto L14;
            r3 = r7;
        L14:
            if (r5 == r6) goto L16;
            r5 = r5 + 1;
        L13:
            Log.e("TextViewSelectHelper", "getPrimaryHorizontal failed");
        L16:
            int r8 = (((int) r0.getPrimaryHorizontal(this.f.d.a)) - ((int) ((this.c - r3) / 2))) + this.b[0];
            int r9 = ((r0.getLineTop(r0.getLineForOffset(this.f.d.a)) + this.b[1]) - this.d) - 16;
            if (r8 > 0) goto L20;
            r8 = 16;
        L20:
            if (ImageWidgetFG.a() == false) goto L24;
            int r10 = this.c;
            int r11 = r8 + r10;
            int r12 = this.e;
            if (r11 <= (r12 - 16)) goto L27;
            r8 = (r12 - r10) - 16;
        L27:
            this.a.setElevation(8.0f);
            Rect r13 = this.f.l;
            if (r13 != null) goto L30;
        L34:
            PopupWindow r14 = this.a;
            SelectTextView r15 = this.f.f;
            if (PopupWindowLancet.hasSubWindowToken(r15) == false) goto L38;
            return;
        L38:
            if ((r14 instanceof PopupWindow) == true) goto L40;
        L42:
            OverlaySource r16 = PopupWindowLancet.resolveSource(r15);
            if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r14, r15, r16, 0, r8, r9) == true) goto L54;
            r14.showAtLocation(r15, 0, r8, r9);
            PopupWindowLancet.trackAfterShow(r14, r16, r15);
            return;
        L54:
            return;
        L40:
            if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r14) == false) goto L42;
            r14.showAtLocation(r15, 0, r8, r9);
            return;
        L30:
            if (r13.contains(r8, r9) == true) goto L33;
            r2 = false;
        L33:
            if (r2 == true) goto L34;
            return;
        L24:
            int r17 = this.c + r8;
            Context r18 = this.f.e;
            int r19 = com.ss.android.lark.imageocr.select.d.a;
            Intrinsics.checkNotNullParameter(r18, "context");
            Resources r20 = r18.getResources();
            if (r17 <= (WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).widthPixels - 16)) goto L27;
            Context r21 = this.f.e;
            Intrinsics.checkNotNullParameter(r21, "context");
            Resources r22 = r21.getResources();
            r8 = (WindowDisplayMetricsOverride.apply(r22, r22.getDisplayMetrics()).widthPixels - this.c) - 16;
            goto L27
        }

        public d(e r11, Context r12) {
            this.f = r11;
            this.b = new int[2];
            View r0 = LayoutInflater.from(r12).inflate(2131564986, null);
            ViewGroup r1 = (ViewGroup) r0.findViewById(2131375029);
            List<com.ss.android.lark.imageocr.select.b> r13 = r11.n;
            Intrinsics.checkNotNull(r13);
            int r14 = r13.size();
            int r4 = 0;
        L3:
            if (r4 >= r14) goto L9;
            com.ss.android.lark.imageocr.select.b r5 = (com.ss.android.lark.imageocr.select.b) ListProtector.get(this.f.n, r4);
            View r6 = LayoutInflater.from(r12).inflate(2131564985, null);
            TextView r7 = (TextView) r6.findViewById(2131375032);
            View r8 = r6.findViewById(2131375033);
            r7.setText(r5.b);
            if (r4 == (this.f.n.size() - 1)) goto L7;
            int r9 = 0;
        L8:
            r8.setVisibility(r9);
            r6.setOnClickListener(new a(r5, this.f));
            r1.addView(r6);
            r4 = r4 + 1;
            goto L3
        L7:
            r9 = 8;
            goto L8
        L9:
            r0.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.c = r0.getMeasuredWidth();
            this.d = r0.getMeasuredHeight();
            PopupWindow r15 = new PopupWindow(r0, -2, -2, false);
            this.a = r15;
            r15.setClippingEnabled(false);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.imageocr.select.e$e, reason: collision with other inner class name */
    public static final class RunnableC0097e implements Runnable {
        public final /* synthetic */ e a;

        public RunnableC0097e(e r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r0 = this.a;     // Catch: Throwable -> L15
            if (r0.q == true) goto L18;
            d r1 = r0.c;     // Catch: Throwable -> L15
            if (r1 == null) goto L8;
            r1.a();     // Catch: Throwable -> L15
        L8:
            e r2 = this.a;     // Catch: Throwable -> L15
            c r3 = r2.a;     // Catch: Throwable -> L15
            if (r3 == null) goto L11;
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L15
            r2.d(r3);     // Catch: Throwable -> L15
        L11:
            e r4 = this.a;     // Catch: Throwable -> L15
            c r5 = r4.b;     // Catch: Throwable -> L15
            if (r5 == null) goto L22;
            Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L15
            r4.d(r5);     // Catch: Throwable -> L15
            return;
        L22:
            return;
        L18:
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.d.c = null;
        SelectTextView r0 = this.f;
        r0.b = -1;
        r0.c = -1;
        r0.invalidate();
        this.q = true;
        c r1 = this.a;
        if (r1 == null) goto L5;
        PopupWindow r2 = r1.b;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L5:
        c r3 = this.b;
        if (r3 == null) goto L8;
        PopupWindow r4 = r3.b;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
    L8:
        d r5 = this.c;
        if (r5 == null) goto L12;
        PopupWindow r6 = r5.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r6);
        r6.dismiss();
        return;
    }

    public e(a r4) {
        Intrinsics.checkNotNullParameter(r4, "builder");
        this.d = new com.ss.android.lark.imageocr.select.c();
        this.q = true;
        this.t = new RunnableC0097e(this);
        SelectTextView r0 = r4.a;
        this.f = r0;
        r0.setSelectionColor(r4.d);
        Context r1 = r0.getContext();
        this.e = r1;
        this.j = r4.b;
        float r2 = r4.c;
        int r3 = com.ss.android.lark.imageocr.select.d.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Resources r5 = r1.getResources();
        this.k = (int) ((r2 * WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density) + 0.5f);
        this.n = r4.e;
        this.o = r4.f;
    }

    public final void d(c r4) {
        Layout r0 = this.f.getLayout();
        if (r4.a == false) goto L5;
        int r1 = this.d.a;
    L11:
        r4.b((int) r0.getPrimaryHorizontal(r1), r0.getLineBottom(r0.getLineForOffset(r1)));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("TextViewSelectHelper", "show cursor exception:" + e);
        return;
    L5:
        r1 = this.d.b;
        goto L11
    }

    public final void c(int r3, int r4) {
        StringBuilder r0 = new StringBuilder("totalSize:");
        Spannable r1 = this.g;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.length());
    L6:
        r0.append(r2);
        r0.append(", startPos:");
        r0.append(r3);
        r0.append(", endPos:");
        r0.append(r4);
        Log.d("TextViewSelectHelper", r0.toString());
        Spannable r5 = this.g;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r3 < 0) goto L13;
        Intrinsics.checkNotNull(r5);
        if (r3 >= r5.length()) goto L13;
        this.d.a = r3;
    L13:
        if (r4 <= 0) goto L17;
        Spannable r6 = this.g;
        Intrinsics.checkNotNull(r6);
        if (r4 > r6.length()) goto L17;
        this.d.b = r4;
    L17:
        com.ss.android.lark.imageocr.select.c r7 = this.d;
        int r8 = r7.a;
        int r9 = r7.b;
        if (r8 <= r9) goto L20;
        r7.a = r9;
        r7.b = r8;
    L20:
        int r10 = r7.a;
        if (r10 < 0) goto L30;
        Spannable r11 = this.g;
        Intrinsics.checkNotNull(r11);
        if (r10 >= r11.length()) goto L31;
        int r12 = this.d.b;
        if (r12 <= 0) goto L32;
        Spannable r13 = this.g;
        Intrinsics.checkNotNull(r13);
        if (r12 > r13.length()) goto L33;
        com.ss.android.lark.imageocr.select.c r14 = this.d;
        Spannable r15 = this.g;
        Intrinsics.checkNotNull(r15);
        com.ss.android.lark.imageocr.select.c r16 = this.d;
        r14.c = r15.subSequence(r16.a, r16.b).toString();
        SelectTextView r17 = this.f;
        com.ss.android.lark.imageocr.select.c r18 = this.d;
        int r19 = r18.a;
        int r20 = r18.b;
        r17.b = r19;
        r17.c = r20;
        r17.invalidate();
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(e r3, int r4, int r5) {
        r3.b();
        r3.q = false;
        if (r3.c != null) goto L6;
        r3.c = new d(r3, r3.e);
    L6:
        if (r3.a != null) goto L9;
        r3.a = new c(r3, true);
    L9:
        if (r3.b != null) goto L11;
        r3.b = new c(r3, false);
    L11:
        SelectTextView r0 = r3.f;
        int r1 = com.ss.android.lark.imageocr.select.d.a;
        Intrinsics.checkNotNullParameter(r0, "textView");
        Layout r2 = r0.getLayout();
        if (r2 == null) goto L16;
        int r6 = r2.getOffsetForHorizontal(r2.getLineForVertical(r5), r4);
        if (((int) r2.getPrimaryHorizontal(r6)) <= r4) goto L17;
        r6 = r2.getOffsetToLeftOf(r6);
    L17:
        int r7 = r6 + 2;
        if ((r3.f.getText() instanceof Spannable) == false) goto L21;
        CharSequence r8 = r3.f.getText();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.text.Spannable");
        r3.g = (Spannable) r8;
    L21:
        if (r3.g != null) goto L23;
        return;
    L23:
        if (r6 >= r3.f.getText().length()) goto L31;
        r3.c(r6, r7);
        c r9 = r3.a;
        Intrinsics.checkNotNull(r9);
        r3.d(r9);
        c r10 = r3.b;
        Intrinsics.checkNotNull(r10);
        r3.d(r10);
        d r11 = r3.c;
        if (r11 == null) goto L30;
        r11.a();
        return;
    L30:
        return;
    L31:
        return;
    L16:
        r6 = -1;
        goto L17
    }
}
