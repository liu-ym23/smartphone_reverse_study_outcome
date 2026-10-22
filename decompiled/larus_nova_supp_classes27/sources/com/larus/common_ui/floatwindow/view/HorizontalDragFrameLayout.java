package com.larus.common_ui.floatwindow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000289B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u000203H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001c\u0010.\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'¨\u0006:"}, d2 = {"Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "isDragging", "", "allowDragGesture", "allowClickGesture", "isDragCancelledByVerticalMove", "lastDragEventTime", "", "lastDragVelocityX", "touchSlop", "onDragListener", "Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnHorizontalDragListener;", "getOnDragListener", "()Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnHorizontalDragListener;", "setOnDragListener", "(Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnHorizontalDragListener;)V", "onClickHotAreaListener", "Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnClickHotAreaListener;", "getOnClickHotAreaListener", "()Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnClickHotAreaListener;", "setOnClickHotAreaListener", "(Lcom/larus/common_ui/floatwindow/view/HorizontalDragFrameLayout$OnClickHotAreaListener;)V", "dragHotArea", "Lkotlin/ranges/IntRange;", "getDragHotArea", "()Lkotlin/ranges/IntRange;", "setDragHotArea", "(Lkotlin/ranges/IntRange;)V", "dragHotAreaX", "getDragHotAreaX", "setDragHotAreaX", "clickHotArea", "getClickHotArea", "setClickHotArea", "clickHotAreaX", "getClickHotAreaX", "setClickHotAreaX", "isInDragHotArea", "ev", "Landroid/view/MotionEvent;", "isInClickHotArea", "onInterceptTouchEvent", "onTouchEvent", "event", "OnHorizontalDragListener", "OnClickHotAreaListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalDragFrameLayout extends FrameLayout {
    public float a;
    public float b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public long g;
    public float h;
    public final int i;
    public b j;
    public a k;
    public IntRange l;
    public IntRange m;
    public IntRange n;
    public IntRange o;

    public interface a {
        void a();
    }

    public interface b {
        void a(float r1);

        void c(float r1);
    }

    public HorizontalDragFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HorizontalDragFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final IntRange getClickHotArea() {
        return this.n;
    }

    public final IntRange getClickHotAreaX() {
        return this.o;
    }

    public final IntRange getDragHotArea() {
        return this.l;
    }

    public final IntRange getDragHotAreaX() {
        return this.m;
    }

    public final a getOnClickHotAreaListener() {
        return this.k;
    }

    public final b getOnDragListener() {
        return this.j;
    }

    public final boolean a(MotionEvent r7) {
        IntRange r0 = this.n;
        if (r0 != null) goto L5;
        return false;
    L5:
        IntRange r2 = this.o;
        int r3 = r0.getFirst();
        int r1 = r0.getLast();
        int r4 = (int) r7.getY();
        if (r3 > r4) goto L9;
        if (r4 > r1) goto L9;
        boolean r5 = true;
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r5 == false) goto L20;
        if (r8 == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L12:
        if (r2.contains((int) r7.getX()) == true) goto L15;
        r8 = false;
    L9:
        r5 = false;
        goto L10
    }

    public final boolean b(MotionEvent r6) {
        IntRange r0 = this.l;
        IntRange r1 = this.m;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r2 == false) goto L19;
        if (r7 == false) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L11:
        if (r1.contains((int) r6.getX()) == true) goto L14;
        r7 = false;
        goto L15
    L5:
        if (r0.contains((int) r6.getY()) == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        int r0 = r7.getActionMasked();
        if (r0 == 0) goto L36;
        if (r0 != 1) goto L6;
    L35:
        this.d = false;
        this.e = false;
        this.c = false;
        this.f = false;
    L45:
        return super.onInterceptTouchEvent(r7);
    L6:
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L35;
    L11:
        if (this.d == true) goto L15;
        if (this.e == true) goto L15;
    L17:
        return super.onInterceptTouchEvent(r7);
    L15:
        if (this.f == true) goto L17;
        float r1 = r7.getRawX() - this.a;
        float r3 = r7.getRawY() - this.b;
        float r2 = Math.abs(r1);
        float r4 = Math.abs(r3);
        boolean r5 = this.c;
        if (r5 == false) goto L21;
    L26:
        if (r5 == true) goto L45;
        if (this.d == false) goto L45;
        if (r2 <= this.i) goto L45;
        if (r2 <= (r4 * 1.5f)) goto L45;
        this.c = true;
        this.e = false;
        return true;
    L21:
        if (r4 <= this.i) goto L26;
        if (r4 <= r2) goto L26;
        this.f = true;
        this.d = false;
        this.e = false;
        this.c = false;
        return super.onInterceptTouchEvent(r7);
    L36:
        this.d = b(r7);
        boolean r6 = a(r7);
        this.e = r6;
        if (this.d == true) goto L41;
        if (r6 == true) goto L41;
        this.c = false;
        this.e = false;
        this.f = false;
        return super.onInterceptTouchEvent(r7);
    L41:
        this.a = r7.getRawX();
        this.b = r7.getRawY();
        this.c = false;
        this.f = false;
        this.g = r7.getEventTime();
        this.h = 0.0f;
        if (this.e == false) goto L45;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        int r0 = r12.getActionMasked();
        if (r0 != 0) goto L5;
        this.d = b(r12);
        boolean r1 = a(r12);
        this.e = r1;
        if (this.d == true) goto L72;
        if (r1 == true) goto L72;
        this.c = false;
        this.e = false;
        this.f = false;
        return super.onTouchEvent(r12);
    L72:
        this.a = r12.getRawX();
        this.b = r12.getRawY();
        this.c = false;
        this.f = false;
        this.g = r12.getEventTime();
        this.h = 0.0f;
        return true;
    L5:
        if (r0 == 1) goto L44;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L44;
        return super.onTouchEvent(r12);
    L13:
        if (this.d == true) goto L17;
        if (this.e == true) goto L17;
    L19:
        return super.onTouchEvent(r12);
    L17:
        if (this.f == true) goto L19;
        float r2 = r12.getRawX() - this.a;
        float r3 = r12.getRawY() - this.b;
        float r7 = Math.abs(r2);
        float r4 = Math.abs(r3);
        boolean r8 = this.c;
        if (r8 == false) goto L23;
    L28:
        if (r8 == true) goto L37;
        if (this.d == false) goto L37;
        if (r7 <= this.i) goto L37;
        if (r7 <= (r4 * 1.5f)) goto L37;
        this.c = true;
        this.e = false;
    L37:
        if (this.c == false) goto L42;
        this.h = (r2 / RangesKt.coerceAtLeast(r12.getEventTime() - this.g, 1)) * 1000.0f;
        b r5 = this.j;
        if (r5 == null) goto L41;
        r5.a(r2);
    L41:
        this.a = r12.getRawX();
        this.b = r12.getRawY();
        this.g = r12.getEventTime();
    L42:
        return true;
    L23:
        if (r4 <= this.i) goto L28;
        if (r4 <= r7) goto L28;
        this.f = true;
        this.d = false;
        this.e = false;
        this.c = false;
        return super.onTouchEvent(r12);
    L44:
        if (this.c == false) goto L59;
        long r6 = RangesKt.coerceAtLeast(r12.getEventTime() - this.g, 1);
        if (r12.getActionMasked() != 1) goto L54;
        float r13 = r12.getRawX() - this.a;
        if (r13 != 0.0f) goto L50;
        boolean r9 = true;
    L51:
        if (r9 == false) goto L53;
        float r14 = this.h;
    L55:
        b r10 = this.j;
        if (r10 == null) goto L65;
        r10.c(r14);
    L65:
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.h = 0.0f;
        return true;
    L53:
        r14 = (r13 / r6) * 1000.0f;
        goto L55
    L50:
        r9 = false;
        goto L51
    L54:
        r14 = 0.0f;
        goto L55
    L59:
        if (this.e == false) goto L65;
        if (this.f == true) goto L65;
        a r15 = this.k;
        if (r15 == null) goto L65;
        r15.a();
        goto L65
    }

    public final void setClickHotArea(IntRange r1) {
        this.n = r1;
    }

    public final void setClickHotAreaX(IntRange r1) {
        this.o = r1;
    }

    public final void setDragHotArea(IntRange r1) {
        this.l = r1;
    }

    public final void setDragHotAreaX(IntRange r1) {
        this.m = r1;
    }

    public final void setOnClickHotAreaListener(a r1) {
        this.k = r1;
    }

    public final void setOnDragListener(b r1) {
        this.j = r1;
    }

    public HorizontalDragFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    public /* synthetic */ HorizontalDragFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
