package com.larus.bmhome.view.crop;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.utils.logger.FLogger;
import gt8.l;
import gt8.o;
import gt8.p;
import gt8.q;
import gt8.r;
import gt8.s;
import gt8.u;
import gt8.v;
import gt8.w;
import gt8.x;
import gt8.z;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements Runnable {
    public final /* synthetic */ ImageCropView a;
    public final /* synthetic */ Runnable b;

    /* JADX INFO: renamed from: com.larus.bmhome.view.crop.a$a, reason: collision with other inner class name */
    public static final class C0050a implements gt8.d.c {
        public final /* synthetic */ ImageCropView a;

        @Override // gt8.d.c
        public final void b() {
        }

        @Override // gt8.d.c
        public final void e() {
        }

        @Override // gt8.d.c
        public final void a() {
            ImageCropView.a r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        public C0050a(ImageCropView r1) {
            this.a = r1;
        }

        @Override // gt8.d.c
        public final void d(z r2) {
            Intrinsics.checkNotNullParameter(r2, "imageShowLocationHelper");
            z r0 = this.a.k;
            if (r0 == null) goto L5;
            r0.d(r2);
        L5:
            ImageCropView.a r3 = this.a.o;
            if (r3 == null) goto L8;
            r3.c();
        L8:
            this.a.invalidate();
        }

        @Override // gt8.d.c
        public final void f(RectF r10) {
            Intrinsics.checkNotNullParameter(r10, "imageRect");
            this.a.h.set(r10);
            o r11 = this.a.b;
            if (r11 == null) goto L6;
            RectF r0 = new RectF(r11.q);
            float r1 = r0.centerX();
            float r2 = r0.centerY();
            PointF r3 = new PointF(r0.left, r0.top);
            PointF r4 = new PointF(r0.right, r0.top);
            PointF r5 = new PointF(r0.left, r0.bottom);
            PointF r6 = new PointF(r0.right, r0.bottom);
            float r7 = -90;
            o.g(r3, r1, r2, r7);
            o.g(r4, r1, r2, r7);
            o.g(r5, r1, r2, r7);
            o.g(r6, r1, r2, r7);
            r0.set(ht8.a.a(r3, r4, r5, r6));
            r11.q.set(r0);
            r11.h(r11.q);
            r11.d.b(r11.q);
            r11.i();
            return;
        }

        @Override // gt8.d.c
        public final void c(RectF r6, RectF r7, float r8) {
            Intrinsics.checkNotNullParameter(r6, "start");
            Intrinsics.checkNotNullParameter(r7, "end");
            o r2 = this.a.b;
            if (r2 == null) goto L11;
            Intrinsics.checkNotNullParameter(r6, "start");
            Intrinsics.checkNotNullParameter(r7, "end");
            r2.r = new RectF(r6);
            boolean r0 = true;
            r2.w = true;
            r2.z = ((-90) * r8) + 0.0f;
            float r9 = (((r7.width() - r6.height()) * r8) / r6.height()) + 1;
            RectF r1 = new RectF(r6);
            float r3 = r6.centerX();
            float r10 = r6.centerY();
            r1.left = ((r1.left - r3) * r9) + r3;
            r1.right = ((r1.right - r3) * r9) + r3;
            r1.top = ((r1.top - r10) * r9) + r10;
            r1.bottom = ((r1.bottom - r10) * r9) + r10;
            r2.r = r1;
            if (r8 == 1.0f) goto L8;
            r0 = false;
        L8:
            if (r0 == false) goto L12;
            r2.w = false;
            return;
        L12:
            return;
        }
    }

    public static final class b implements gt8.d.e {
        public final /* synthetic */ ImageCropView a;

        @Override // gt8.d.e
        public final RectF a() {
            o r0 = this.a.b;
            if (r0 == null) goto L6;
            return new RectF(r0.q);
        L6:
            return new RectF();
        }

        @Override // gt8.d.e
        public final RectF b() {
            return this.a.f;
        }

        public b(ImageCropView r1) {
            this.a = r1;
        }
    }

    public static final class c implements gt8.d.InterfaceC0110d {
        public final /* synthetic */ ImageCropView a;

        public c(ImageCropView r1) {
            this.a = r1;
        }

        @Override // gt8.d.InterfaceC0110d
        public final boolean a(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            o r0 = this.a.b;
            if (r0 == null) goto L28;
            float r2 = r6.getX();
            float r7 = r6.getY();
            if (r0.i.contains(r2, r7) == false) goto L8;
        L6:
            return true;
        L8:
            if (r0.j.contains(r2, r7) == true) goto L6;
            if (r0.k.contains(r2, r7) == true) goto L6;
            if (r0.l.contains(r2, r7) == true) goto L6;
            if (r0.m.contains(r2, r7) == true) goto L6;
            if (r0.n.contains(r2, r7) == true) goto L6;
            if (r0.o.contains(r2, r7) == true) goto L6;
            if (r0.p.contains(r2, r7) == true) goto L6;
            return false;
        L28:
            return false;
        }

        @Override // gt8.d.InterfaceC0110d
        public final void onTouchEvent(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            o r1 = this.a.b;
            if (r1 == null) goto L125;
            Intrinsics.checkNotNullParameter(r10, "event");
            float r0 = r10.getX();
            float r2 = r10.getY();
            z r3 = r1.b;
            if (r3.b() == false) goto L7;
            float r4 = r3.c.x;
            float r5 = r3.a.height();
        L8:
            int r6 = 2;
            float r7 = 2;
            float r8 = RangesKt.coerceAtMost(r4 + (r5 / r7), r1.c.getViewWidth());
            z r9 = r1.b;
            if (r9.b() == false) goto L11;
            float r11 = r9.c.x;
            float r12 = r9.a.height();
        L12:
            float r13 = r11 - (r12 / r7);
            float r14 = 0.0f;
            float r15 = RangesKt.coerceAtLeast(r13, 0.0f);
            if (r0 <= r8) goto L16;
            r0 = r8;
        L18:
            z r16 = r1.b;
            if (r16.b() == false) goto L21;
            float r17 = r16.c.y;
            float r18 = r16.a.width();
        L22:
            float r19 = RangesKt.coerceAtMost(r17 + (r18 / r7), r1.c.getViewHeight());
            z r20 = r1.b;
            if (r20.b() == false) goto L25;
            float r21 = r20.c.y;
            float r22 = r20.a.width();
        L26:
            float r23 = RangesKt.coerceAtLeast(r21 - (r22 / r7), 0.0f);
            if (r2 <= r19) goto L30;
            r2 = r19;
        L32:
            int r110 = r10.getAction();
            boolean r24 = false;
            if (r110 == 0) goto L72;
            if (r110 == 1) goto L41;
            if (r110 != 2) goto L123;
            o.b r111 = r1.h;
            if (r111 == null) goto L123;
            r111.a(r0, r2);
        L123:
            r1.c.a();
            return;
        L41:
            if (r1.g == 0) goto L43;
            r1.d.a();
        L43:
            r1.g = 0;
            RectF r112 = r1.f();
            RectF r25 = new RectF(r1.q);
            if (Math.abs(r112.width() - r25.width()) >= 0.001f) goto L46;
        L64:
            r24 = true;
        L65:
            if (r24 == true) goto L69;
            o.b r113 = r1.h;
            if (r113 == null) goto L123;
            r113.c(r1.A);
            goto L123
        L69:
            r1.d.b(r1.q);
            o.b r114 = r1.h;
            if (r114 == null) goto L123;
            r114.b();
            goto L123
        L46:
            if (Math.abs(r112.height() - r25.height()) < 0.001f) goto L64;
            z r115 = r1.f.a();
            if (r115 == null) goto L51;
            float r116 = r115.e();
        L52:
            float r117 = r116 / r1.a.width();
            z r26 = r1.f.a();
            if (r26 == null) goto L59;
            if (r26.b() == false) goto L57;
            r14 = r26.a.width();
            goto L59
        L57:
            r14 = r26.a.height();
        L59:
            if (RangesKt.coerceAtLeast(r117, r14 / r1.a.height()) < 3.0f) goto L64;
            if (r1.q.width() < r1.A.width()) goto L65;
            if (r1.q.height() < r1.A.height()) goto L65;
        L51:
            r116 = 0.0f;
            goto L52
        L72:
            r1.A = new RectF(r1.q);
            if (r1.i.contains(r0, r2) == false) goto L76;
            r6 = 1;
        L97:
            r1.g = r6;
            if (r1.i.contains(r0, r2) == false) goto L101;
            o.b r118 = new w(r1);
        L122:
            r1.h = r118;
            goto L123
        L101:
            if (r1.j.contains(r0, r2) == false) goto L104;
            r118 = new x(r1);
            goto L122
        L104:
            if (r1.k.contains(r0, r2) == false) goto L107;
            r118 = new q(r1);
            goto L122
        L107:
            if (r1.l.contains(r0, r2) == false) goto L110;
            r118 = new r(r1);
            goto L122
        L110:
            if (r1.m.contains(r0, r2) == false) goto L113;
            r118 = new v(r1);
            goto L122
        L113:
            if (r1.n.contains(r0, r2) == false) goto L116;
            r118 = new s(r1);
            goto L122
        L116:
            if (r1.o.contains(r0, r2) == false) goto L119;
            r118 = new p(r1);
            goto L122
        L119:
            if (r1.p.contains(r0, r2) == false) goto L121;
            r118 = new u(r1);
            goto L122
        L121:
            r118 = null;
            goto L122
        L76:
            if (r1.j.contains(r0, r2) == true) goto L97;
            if (r1.k.contains(r0, r2) == false) goto L82;
            r6 = 3;
            goto L97
        L82:
            if (r1.l.contains(r0, r2) == false) goto L85;
            r6 = 4;
            goto L97
        L85:
            if (r1.m.contains(r0, r2) == false) goto L88;
            r6 = 5;
            goto L97
        L88:
            if (r1.n.contains(r0, r2) == false) goto L91;
            r6 = 6;
            goto L97
        L91:
            if (r1.o.contains(r0, r2) == false) goto L94;
            r6 = 7;
            goto L97
        L94:
            if (r1.p.contains(r0, r2) == false) goto L96;
            r6 = 8;
            goto L97
        L96:
            r6 = 0;
            goto L97
        L30:
            if (r2 >= r23) goto L32;
            r2 = r23;
            goto L32
        L25:
            r21 = r20.c.y;
            r22 = r20.a.height();
            goto L26
        L21:
            r17 = r16.c.y;
            r18 = r16.a.height();
            goto L22
        L16:
            if (r0 >= r15) goto L18;
            r0 = r15;
            goto L18
        L11:
            r11 = r9.c.x;
            r12 = r9.a.width();
            goto L12
        L7:
            r4 = r3.c.x;
            r5 = r3.a.width();
            goto L8
        }
    }

    public static final class d implements o.g {
        public final /* synthetic */ ImageCropView a;

        @Override // gt8.o.g
        public final void a() {
            this.a.invalidate();
        }

        @Override // gt8.o.g
        public final int getViewHeight() {
            return this.a.getHeight();
        }

        @Override // gt8.o.g
        public final int getViewWidth() {
            return this.a.getWidth();
        }

        public d(ImageCropView r1) {
            this.a = r1;
        }
    }

    public static final class e implements o.d {
        public final /* synthetic */ ImageCropView a;

        @Override // gt8.o.d
        public final void a() {
            ImageCropView.a r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public e(ImageCropView r1) {
            this.a = r1;
        }

        @Override // gt8.o.d
        public final void b(RectF r2) {
            if (r2 == null) goto L4;
            this.a.c.set(r2);
        L4:
            ImageCropView.a r3 = this.a.o;
            if (r3 == null) goto L8;
            r3.c();
            return;
        }
    }

    public static final class f implements o.e {
        public z a;
        public final /* synthetic */ ImageCropView b;

        @Override // gt8.o.e
        public final void a() {
            this.b.l = false;
        }

        @Override // gt8.o.e
        public final void d() {
            this.b.l = false;
        }

        public f(ImageCropView r1) {
            this.b = r1;
        }

        @Override // gt8.o.e
        public final void b(RectF r4) {
            Intrinsics.checkNotNullParameter(r4, "clipRegion");
            ImageCropView r0 = this.b;
            r0.l = true;
            r0.g = new RectF(r4);
            z r1 = this.b.k;
            if (r1 == null) goto L6;
            this.a = new z(r1);
            FLogger.a.i("PhotoClipView", "onTransitionStart : clipRegion = " + r4 + ", locationBeforeTransition = " + this.a);
            return;
        }

        @Override // gt8.o.e
        public final void c(RectF r9) {
            Intrinsics.checkNotNullParameter(r9, "currClipRect");
            FLogger.a.i("PhotoClipView", "onTransitionUpdate : locationBeforeTransition = " + this.a + ", mStartClipRect = " + this.b.g);
            ImageCropView r0 = this.b;
            gt8.d r1 = r0.d;
            if (r1 == null) goto L7;
            z r2 = this.a;
            z r3 = r1.b;
            Intrinsics.checkNotNull(r2);
            r3.d(r2);
            z r4 = r0.k;
            if (r4 == null) goto L7;
            RectF r5 = r0.g;
            Intrinsics.checkNotNullParameter(r5, "startRect");
            Intrinsics.checkNotNullParameter(r9, "endRect");
            float r6 = r9.width() / r5.width();
            float r7 = r9.height() / r5.height();
            float r8 = GuidePriority.COMMERCE_CREDIT_PRIORITY;
            float r10 = MathKt.roundToInt(r6 * r8) / 1000.0f;
            float r11 = MathKt.roundToInt(r7 * r8) / 1000.0f;
            r1.b.c(r10, r11, r5.centerX(), r5.centerY());
            RectF r12 = new RectF(r5);
            int r13 = ht8.a.a;
            ht8.a.e(r12, r12.centerX(), r12.centerY(), r10, r11);
            r1.b.c.offset(r9.centerX() - r12.centerX(), r9.centerY() - r12.centerY());
            r4.d(r1.b);
        L7:
            this.b.invalidate();
        }
    }

    public static final class g implements o.c {
        public final /* synthetic */ ImageCropView a;

        @Override // gt8.o.c
        public final z a() {
            return this.a.k;
        }

        public g(ImageCropView r1) {
            this.a = r1;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.ImageView, com.larus.bmhome.view.crop.ImageCropView] */
    public final void a() {
        ImageCropView r0 = this.a;
        Bitmap r1 = r0.a;
        if (r1 != null) goto L5;
    L9:
        ?? r2 = this.a;
        RectF r3 = r2.f;
        int r4 = ImageCropView.q;
        r3.left = r4;
        r3.right = r2.getWidth() - r4;
        RectF r5 = r2.f;
        int r6 = ImageCropView.r;
        r5.top = r6;
        r5.bottom = r2.getHeight() - r6;
        ImageCropView r7 = this.a;
        r7.h = r7.l();
        ImageCropView r8 = this.a;
        r8.k = new z(r8.h, 0, new PointF(this.a.h.centerX(), this.a.h.centerY()));
        float r9 = this.a.n;
        if (r9 > 0.0f) goto L13;
        r9 = 0.42666668f;
    L13:
        FLogger.a.i("PhotoClipView", "clipRatio is:" + r9);
        ImageCropView r10 = this.a;
        int r11 = o.f.a;
        r10.c = o.f.a(r10.m, r10.h, r9);
        ImageCropView r12 = this.a;
        Bitmap r13 = this.a.a;
        Intrinsics.checkNotNull(r13);
        z r14 = this.a.k;
        Intrinsics.checkNotNull(r14);
        r12.e = new l(r13, r14);
        ImageCropView r15 = this.a;
        ImageCropView r16 = this.a;
        RectF r17 = r16.h;
        z r18 = r16.k;
        Intrinsics.checkNotNull(r18);
        ImageCropView r19 = this.a;
        r15.d = new gt8.d(r17, r18, r19.c, new C0050a(r19), new b(r19), new c(r19));
        ImageCropView r20 = this.a;
        ImageCropView r21 = this.a;
        RectF r22 = r21.h;
        z r23 = r21.k;
        Intrinsics.checkNotNull(r23);
        ImageCropView r24 = this.a;
        r20.b = new o(r22, r23, new d(r24), new e(r24), new f(r24), new g(r24));
        this.a.j = true;
        Runnable r25 = this.b;
        if (r25 == null) goto L17;
        r25.run();
        return;
    L17:
        return;
    L5:
        if (r1.isRecycled() == true) goto L9;
        float r26 = RangesKt.coerceAtMost(r1.getWidth(), r1.getHeight());
        float r27 = ImageCropView.p;
        if (r26 >= r27) goto L9;
        float r28 = r27 / r26;
        r0.a = Bitmap.createScaledBitmap(r1, (int) (r1.getWidth() * r28), (int) (r1.getHeight() * r28), true);
        goto L9
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

    public a(ImageCropView r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }
}
