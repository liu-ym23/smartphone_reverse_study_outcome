package com.bytedance.android.live.draggablecomponent;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableConstraintLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableConstraintLayout extends FrameLayout {
    public WeakReference<LiveVerticalViewPager> a;
    public float b;
    public float c;
    public float d;
    public float e;
    public c61.f f;
    public final GestureDetector g;
    public boolean h;
    public boolean i;
    public final Rect j;
    public final int k;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ DraggableConstraintLayout a;

        public a(DraggableConstraintLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            if (this.a.getChildCount() <= 0) goto L5;
            DraggableConstraintLayout r0 = this.a;
            r0.b = r3.getX();
            DraggableConstraintLayout r1 = this.a;
            r1.c = r3.getY();
            if (DraggableConstraintLayout.a(this.a.f) == false) goto L10;
            return true;
        L10:
            return super.onDown(r3);
        L5:
            return super.onDown(r3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r9, MotionEvent r11, float r12, float r13) {
            Intrinsics.checkNotNullParameter(r11, "e2");
            if (this.a.getChildCount() <= 0) goto L5;
            c61.f r0 = this.a.f;
            if (r0 == null) goto L54;
            int r1 = r0.getDraggableConfig().e;
            int r2 = 0;
            if (r1 >= 0) goto L12;
            r1 = 0;
        L12:
            int r3 = r0.getDraggableConfig().g;
            if (r3 <= this.a.getHeight()) goto L16;
            r3 = this.a.getHeight();
        L16:
            int r4 = r0.getDraggableConfig().d;
            if (r4 < 0) goto L19;
            r2 = r4;
        L19:
            int r5 = r0.getDraggableConfig().f;
            if (r5 <= this.a.getWidth()) goto L24;
            r5 = this.a.getWidth();
        L24:
            if (r0.getDraggableConfig().e < 0) goto L26;
        L27:
            float r6 = r3;
            if (((r0.getMView().getY() + r0.getMView().getHeight()) + (r11.getY() - this.a.c)) > r6) goto L33;
            if ((r0.getMView().getY() + (r11.getY() - this.a.c)) < r1) goto L33;
            r0.getMView().setY(r0.getMView().getY() + (r11.getY() - this.a.c));
            this.a.c = r11.getY();
        L39:
            if (r0.getDraggableConfig().d < 0) goto L41;
        L42:
            float r7 = r5;
            if (((r0.getMView().getX() + r0.getMView().getWidth()) + (r11.getX() - this.a.b)) > r7) goto L48;
            if ((r0.getMView().getX() + (r11.getX() - this.a.b)) < r2) goto L48;
            r0.getMView().setX(r0.getMView().getX() + (r11.getX() - this.a.b));
            this.a.b = r11.getX();
        L48:
            if (((r0.getMView().getX() + r0.getMView().getWidth()) + (r11.getX() - this.a.b)) < r7) goto L50;
            r0.getMView().setX(r7 - r0.getMView().getWidth());
            this.a.b = r11.getX();
            goto L54
        L50:
            float r8 = r2;
            if ((r0.getMView().getX() + (r11.getX() - this.a.b)) > r8) goto L54;
            r0.getMView().setX(r8);
            this.a.b = r11.getX();
            goto L54
        L41:
            if (r0.getDraggableConfig().f < 0) goto L54;
        L33:
            if (((r0.getMView().getY() + r0.getMView().getHeight()) + (r11.getY() - this.a.c)) < r6) goto L35;
            r0.getMView().setY(r6 - r0.getMView().getHeight());
            this.a.c = r11.getY();
            goto L39
        L35:
            float r14 = r1;
            if ((r0.getMView().getY() + (r11.getY() - this.a.c)) > r14) goto L39;
            r0.getMView().setY(r14);
            goto L39
        L26:
            if (r0.getDraggableConfig().g < 0) goto L39;
        L54:
            if (DraggableConstraintLayout.a(this.a.f) == false) goto L60;
            c61.f r15 = this.a.f;
            if (r15 == null) goto L58;
            r15.getMView().getX();
            r15.getMView().getY();
            r15.b();
        L58:
            return true;
        L60:
            return super.onScroll(r9, r11, r12, r13);
        L5:
            return super.onScroll(r9, r11, r12, r13);
        }
    }

    public DraggableConstraintLayout(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.b = Float.MIN_VALUE;
        this.c = Float.MIN_VALUE;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.g = new GestureDetector(getContext(), new a(this));
        this.j = new Rect();
        int r4 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        ALogger.d("DraggableConstraintLayout", "touchSlop:" + r4);
        Unit r0 = Unit.INSTANCE;
        this.k = r4;
    }

    public static boolean a(c61.f r1) {
        if (r1 == null) goto L14;
        c61.h r2 = r1.getDraggableConfig();
        if (r2 == null) goto L14;
        if (r2.g < 0) goto L8;
    L13:
        return true;
    L8:
        if (r2.e >= 0) goto L13;
        if (r2.d >= 0) goto L13;
        if (r2.f >= 0) goto L13;
    L14:
        return false;
    }

    public static ViewGroup b(View r1) {
        if ((r1 instanceof LiveVerticalViewPager) == true) goto L5;
        Object r2 = r1.getParent();
        if ((r2 instanceof View) == true) goto L9;
        return null;
    L9:
        return b((View) r2);
    L5:
        return (ViewGroup) r1;
    }

    public static List c(View r2) {
        ArrayList r0 = new ArrayList();
        if ((r2 instanceof ViewGroup) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L13;
        Sequence<View> r4 = UtilityKotlinExtentionsKt.g(r3);
        if (r4 == null) goto L13;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        View r1 = (View) r5.next();
        r0.add(r1);
        r0.addAll(c(r1));
    L13:
        return r0;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "ev");
        int r0 = r11.getActionMasked();
        c61.f r1 = null;
        Object r2 = null;
        if (r0 == 0) goto L46;
        if (r0 != 1) goto L6;
    L45:
        this.h = false;
        this.i = false;
    L87:
        if (this.f == null) goto L93;
        if (this.h == false) goto L93;
        return true;
    L93:
        return super.onInterceptTouchEvent(r11);
    L6:
        if (r0 != 2) goto L8;
        float r3 = r11.getX() - this.d;
        float r4 = r11.getY() - this.e;
        c61.f r5 = this.f;
        if (r5 == null) goto L87;
        if (a(r5) == true) goto L15;
        this.h = false;
        goto L87
    L15:
        if (Math.abs(r4) <= this.k) goto L17;
    L18:
        Iterator r6 = ((ArrayList) c(r5.getMView())).iterator();
    L20:
        if (r6.hasNext() == false) goto L41;
        Object r7 = r6.next();
        View r8 = (View) r7;
        k.a(this, r8, this.j);
        if (this.j.contains((int) this.d, (int) this.e) == false) goto L33;
        float r9 = 0;
        if (r4 >= r9) goto L29;
        if (r8.canScrollVertically(1) == false) goto L29;
    L32:
        boolean r12 = true;
    L34:
        this.j.setEmpty();
        if (r12 == false) goto L20;
        r2 = r7;
    L29:
        if (r4 <= r9) goto L33;
        if (r8.canScrollVertically(-1) == true) goto L32;
    L33:
        r12 = false;
    L37:
        th = move-exception;
        this.j.setEmpty();
        throw th;
    L41:
        if (((View) r2) == null) goto L43;
        this.i = true;
    L43:
        this.h = !this.i;
        goto L87
    L17:
        if (Math.abs(r3) <= this.k) goto L87;
    L8:
        if (r0 == 3) goto L45;
    L46:
        Float r13 = Float.valueOf(r11.getX());
        Float r14 = Float.valueOf(r11.getY());
        Sequence<View> r15 = UtilityKotlinExtentionsKt.g(this);
        if (r15 == null) goto L65;
        Iterator r16 = r15.iterator();
    L50:
        if (r16.hasNext() == false) goto L65;
        View r17 = (View) r16.next();
        k.a(this, r17, this.j);
        Rect r18 = this.j;     // Catch: Throwable -> L62
        int r19 = Integer.MIN_VALUE;
        if (r13 == null) goto L55;
        int r21 = (int) r13.floatValue();     // Catch: Throwable -> L62
    L56:
        if (r14 == null) goto L59;
        r19 = (int) r14.floatValue();     // Catch: Throwable -> L62
    L59:
        if (r18.contains(r21, r19) == true) goto L60;
        this.j.setEmpty();
        goto L50
    L60:
        this.j.setEmpty();
    L67:
        if ((r17 instanceof c61.f) == true) goto L69;
        r17 = null;
    L69:
        c61.f r22 = (c61.f) r17;
        if (r22 == null) goto L85;
        WeakReference<LiveVerticalViewPager> r23 = this.a;
        if (r23 != null) goto L74;
    L75:
        ViewGroup r24 = b(this);
        if ((r24 instanceof LiveVerticalViewPager) == false) goto L78;
        this.a = new WeakReference(r24);
    L78:
        Unit r25 = Unit.INSTANCE;
    L79:
        WeakReference<LiveVerticalViewPager> r26 = this.a;
        if (r26 == null) goto L84;
        LiveVerticalViewPager r27 = r26.get();
        if (r27 == null) goto L84;
        r27.requestDisallowInterceptTouchEvent(true);
    L84:
        Unit r28 = Unit.INSTANCE;
        r1 = r22;
        goto L85
    L74:
        if (r23.get() != null) goto L79;
    L85:
        this.f = r1;
        this.b = r11.getX();
        this.c = r11.getY();
        this.d = r11.getX();
        this.e = r11.getY();
        this.i = false;
        this.h = false;
        goto L87
    L55:
        r21 = Integer.MIN_VALUE;
    L62:
        th = move-exception;
        this.j.setEmpty();
        throw th;
    L65:
        r17 = null;
        goto L67
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.f == null) goto L7;
        GestureDetector r0 = this.g;
        Intrinsics.checkNotNull(r2);
        return r0.onTouchEvent(r2);
    L7:
        return super.onTouchEvent(r2);
    }

    public DraggableConstraintLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = Float.MIN_VALUE;
        this.c = Float.MIN_VALUE;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.g = new GestureDetector(getContext(), new a(this));
        this.j = new Rect();
        int r4 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        ALogger.d("DraggableConstraintLayout", "touchSlop:" + r4);
        Unit r5 = Unit.INSTANCE;
        this.k = r4;
    }

    public DraggableConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = Float.MIN_VALUE;
        this.c = Float.MIN_VALUE;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.g = new GestureDetector(getContext(), new a(this));
        this.j = new Rect();
        int r5 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        ALogger.d("DraggableConstraintLayout", "touchSlop:" + r5);
        Unit r6 = Unit.INSTANCE;
        this.k = r5;
    }
}
