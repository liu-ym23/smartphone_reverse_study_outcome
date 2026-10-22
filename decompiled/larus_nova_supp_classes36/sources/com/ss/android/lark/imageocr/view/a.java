package com.ss.android.lark.imageocr.view;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.MotionEvent;
import com.ss.android.lark.imageocr.mvp.g;
import com.ss.android.lark.imageocr.utils.DrawObjectsPool;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends plb.a {
    public final ArrayList<ilb.b> f;
    public final b g;
    public final int h;
    public boolean i;
    public boolean j;
    public final Point k;
    public final Point l;

    /* JADX INFO: renamed from: com.ss.android.lark.imageocr.view.a$a, reason: collision with other inner class name */
    public static final class C0098a {
    }

    public interface b {
        void a();

        void f();
    }

    static {
    }

    public final void f() {
        ArrayList<ilb.b> r0 = this.f;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((ilb.b) r2.next()).j);
        goto L4
    L6:
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        ilb.a r4 = (ilb.a) r3.next();
        r4.b = false;
        r4.c = false;
        goto L8
    L10:
        this.i = false;
        this.j = false;
        this.k.set(0, 0);
        this.l.set(0, 0);
    }

    @Override // plb.a
    public final void b(Canvas r20) {
        a r0 = this;
        Canvas r1 = r20;
        Intrinsics.checkNotNullParameter(r1, "canvas");
        long r2 = System.currentTimeMillis();
        r20.save();
        Iterator r4 = r0.f.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        ilb.b r5 = (ilb.b) r4.next();
        RectF r6 = r0.c;
        int r7 = com.ss.android.lark.imageocr.utils.b.a;
        Intrinsics.checkNotNullParameter(r6, "contentRectF");
        Intrinsics.checkNotNullParameter(r5, "result");
        float r8 = r6.right;
        float r9 = r6.left;
        float r10 = r8 - r9;
        float r11 = r6.bottom;
        float r12 = r6.top;
        float r13 = r11 - r12;
        float r14 = (r5.b * r10) + r9;
        float r15 = (r5.c * r13) + r12;
        float r16 = (r5.d * r10) + r9;
        float r17 = (r5.e * r13) + r12;
        float r18 = (r5.f * r10) + r9;
        float r19 = (r5.g * r13) + r12;
        Iterator r110 = r4;
        float r21 = r9 + (r5.h * r10);
        float r22 = r12 + (r5.i * r13);
        float r23 = com.ss.android.lark.imageocr.utils.b.a(r14, r15, r21, r22);
        float r24 = com.ss.android.lark.imageocr.utils.b.a(r14, r15, r16, r17);
        float r25 = com.ss.android.lark.imageocr.utils.b.a(r16, r17, r18, r19);
        long r111 = r2;
        float r3 = RangesKt.coerceAtLeast(r24, com.ss.android.lark.imageocr.utils.b.a(r21, r22, r18, r19));
        float r26 = RangesKt.coerceAtLeast(r23, r25);
        float r27 = RangesKt.coerceAtMost((float) (Math.atan2(r17 - r15, r16 - r14) * 57.29577951308232d), (float) (Math.atan2(r19 - r22, r18 - r21) * 57.29577951308232d));
        Lazy r28 = DrawObjectsPool.j;
        ((RectF) r28.getValue()).setEmpty();
        RectF r29 = (RectF) r28.getValue();
        float r112 = r14 - DrawObjectsPool.a();
        r29.left = r112;
        r29.top = r15;
        r29.right = (r112 + r3) + (2 * DrawObjectsPool.a());
        r29.bottom = r29.top + r26;
        Lazy r30 = DrawObjectsPool.m;
        ((Path) r30.getValue()).reset();
        Path r31 = (Path) r30.getValue();
        r31.addRoundRect(r29, DrawObjectsPool.a(), DrawObjectsPool.a(), Path.Direction.CCW);
        Lazy r32 = DrawObjectsPool.n;
        ((Matrix) r32.getValue()).reset();
        Matrix r33 = (Matrix) r32.getValue();
        r33.setRotate(r27, r29.left, r29.top);
        Lazy r34 = DrawObjectsPool.l;
        ((Path) r34.getValue()).reset();
        Path r35 = (Path) r34.getValue();
        r35.addPath(r31, r33);
        ilb.a r36 = r5.j;
        r36.a.setPath(r35, this.d);
        if (r36.d == false) goto L8;
        Canvas r37 = r20;
        r37.drawPath(r35, (Paint) DrawObjectsPool.g.getValue());
        r37.drawPath(r35, (Paint) DrawObjectsPool.h.getValue());
    L9:
        r37.clipPath(r35, Region.Op.DIFFERENCE);
        r1 = r37;
        r0 = this;
        r4 = r110;
        r2 = r111;
        goto L4
    L8:
        r37 = r20;
        r37.drawPath(r35, (Paint) DrawObjectsPool.f.getValue());
        goto L9
    L10:
        r1.drawColor(r0.h);
        r20.restore();
        Log.i("ImageViewOCRPlusProvider", "onDrawFinish costTime:" + (System.currentTimeMillis() - r2));
    }

    @Override // plb.a
    public final boolean c(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (r10.getPointerCount() != 2) goto L7;
        this.g.a();
        return false;
    L7:
        if (r10.getAction() != 1) goto L9;
    L53:
        f();
        return false;
    L9:
        if (r10.getAction() == 3) goto L53;
        ArrayList<ilb.b> r0 = this.f;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L16;
        r4.add(((ilb.b) r1.next()).j);
        goto L13
    L16:
        if (r10.getAction() != 0) goto L25;
        f();
        Iterator r2 = r4.iterator();
    L19:
        if (r2.hasNext() == false) goto L25;
        ilb.a r5 = (ilb.a) r2.next();
        if (r5.a.contains((int) r10.getX(), (int) r10.getY()) == false) goto L19;
        this.i = true;
        this.k.x = (int) r10.getX();
        this.k.y = (int) r10.getY();
        r5.b = true;
        boolean r11 = !r5.d;
        this.j = r11;
        r5.d = r11;
        this.g.f();
        return true;
    L25:
        if (this.i == true) goto L28;
        return false;
    L28:
        if (r10.getAction() != 2) goto L51;
        this.l.x = (int) r10.getX();
        this.l.y = (int) r10.getY();
        Point r12 = this.k;
        Point r3 = this.l;
        Lazy r6 = DrawObjectsPool.a;
        Intrinsics.checkNotNullParameter(r12, "startPoint");
        Intrinsics.checkNotNullParameter(r3, "endPoint");
        int r7 = RangesKt.coerceAtMost(r12.x, r3.x);
        int r8 = RangesKt.coerceAtMost(r12.y, r3.y);
        int r9 = RangesKt.coerceAtLeast(r12.x, r3.x);
        int r13 = RangesKt.coerceAtLeast(r12.y, r3.y);
        if (r7 != r9) goto L32;
        r9 = r9 + 1;
    L32:
        if (r8 != r13) goto L34;
        r13 = r13 + 1;
    L34:
        Lazy r14 = DrawObjectsPool.k;
        ((Rect) r14.getValue()).setEmpty();
        Rect r15 = (Rect) r14.getValue();
        r15.set(r7, r8, r9, r13);
        ArrayList r16 = new ArrayList();
        Iterator r17 = r4.iterator();
    L36:
        if (r17.hasNext() == false) goto L40;
        Object r18 = r17.next();
        if (((ilb.a) r18).b == true) goto L36;
        r16.add(r18);
        goto L36
    L40:
        Iterator r19 = r16.iterator();
    L42:
        if (r19.hasNext() == false) goto L51;
        ilb.a r20 = (ilb.a) r19.next();
        if (r20.a.op(r15, Region.Op.INTERSECT) == true) goto L45;
        if (r20.c == false) goto L42;
        if (this.j == false) goto L42;
        r20.d = false;
        goto L42
    L45:
        r20.c = true;
        r20.d = this.j;
    L51:
        this.g.f();
        return true;
    }

    public a(SubsamplingScaleImageView r2, ArrayList r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "lines");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.h = LarkContext.getApplication().getResources().getColor(2131099929);
        this.k = new Point();
        this.l = new Point();
    }
}
