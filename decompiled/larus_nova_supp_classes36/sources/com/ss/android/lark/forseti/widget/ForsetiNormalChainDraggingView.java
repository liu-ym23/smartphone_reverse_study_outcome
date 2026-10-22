package com.ss.android.lark.forseti.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 22\u00020\u0001:\u000212B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0014J\u000e\u0010&\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010'\u001a\u00020\"2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010+\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020 H\u0002J\b\u00100\u001a\u00020\"H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "outerRectangle", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper$Region;", "innerRectangle", "status", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;", "getStatus", "()Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;", "setStatus", "(Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;)V", "draggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "getDraggingHelper", "()Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "setDraggingHelper", "(Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;)V", "isDraggingSupport", "", "()Z", "setDraggingSupport", "(Z)V", "isKeyboardVisible", "animationYOffset", "", "setKeyboardStateListener", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateDraggingStatus", "setForsetiColumnsDraggingHelper", "drawRectanglesInDraggingUnderFull", "drawRectanglesUnderFull", "drawRectangles", "drawFullScreenLine", "drawHalfScreenLines", "animateButtonPosition", "fromOffset", "toOffset", "onDetachedFromWindow", "DraggingStatus", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiNormalChainDraggingView extends FrameLayout {
    public ForsetiColumnsDraggingHelper.b a;
    public DraggingStatus b;
    public ForsetiColumnsDraggingHelper c;
    public boolean d;
    public boolean e;
    public float f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView$DraggingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DRAGGING_UNDER_FULL", "UN_DRAGGING_UNDER_FULL", "UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum DraggingStatus extends Enum<DraggingStatus> {
        public static final DraggingStatus DRAGGING_UNDER_FULL = null;
        public static final DraggingStatus UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL = null;
        public static final DraggingStatus UN_DRAGGING_UNDER_FULL = null;
        public static final /* synthetic */ DraggingStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DraggingStatus> getEntries() {
            return b;
        }

        static {
            DraggingStatus r0 = new DraggingStatus("DRAGGING_UNDER_FULL", 0);
            DRAGGING_UNDER_FULL = r0;
            DraggingStatus r1 = new DraggingStatus("UN_DRAGGING_UNDER_FULL", 1);
            UN_DRAGGING_UNDER_FULL = r1;
            DraggingStatus r3 = new DraggingStatus("UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL", 2);
            UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL = r3;
            DraggingStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DraggingStatus[] values() {
            return (DraggingStatus[]) a.clone();
        }

        public static DraggingStatus valueOf(String r1) {
            return (DraggingStatus) r27.a.a(DraggingStatus.class, r1);
        }

        public DraggingStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DraggingStatus.values().length];
            r0[DraggingStatus.DRAGGING_UNDER_FULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DraggingStatus.UN_DRAGGING_UNDER_FULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DraggingStatus.UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public ForsetiNormalChainDraggingView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ForsetiNormalChainDraggingView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public final ForsetiColumnsDraggingHelper getDraggingHelper() {
        return this.c;
    }

    public final DraggingStatus getStatus() {
        return this.b;
    }

    public final void a(Canvas r9) {
        ForsetiColumnsDraggingHelper r0 = this.c;
        float r5 = (r0.s - r0.B.getStrokeWidth()) / 2.0f;
        r9.drawLine(r5, 0.0f, r5, getMeasuredHeight(), this.c.D);
    }

    public final void b(Canvas r17) {
        ForsetiColumnsDraggingHelper r1 = this.c;
        ForsetiColumnsDraggingHelper.b r4 = null;
        if (ForsetiColumnsDraggingHelper.h(r1.z) == false) goto L5;
        ForsetiColumnsDraggingHelper.b r7 = null;
    L6:
        if (r7 == null) goto L8;
        float r9 = r7.a;
        float r2 = r7.b;
        float r3 = this.f;
        float r10 = r2 - r3;
        float r11 = r7.c;
        float r12 = r7.d - r3;
        ForsetiColumnsDraggingHelper r5 = this.c;
        float r14 = r5.n;
        r17.drawRoundRect(r9, r10, r11, r12, r14, r14, r5.B);
    L9:
        this.a = r7;
        ForsetiColumnsDraggingHelper r6 = this.c;
        if (ForsetiColumnsDraggingHelper.h(r6.z) == true) goto L13;
        int r8 = r6.s;
        int r13 = r6.q;
        float r15 = (r8 - r13) / 2.0f;
        float r16 = r6.z;
        float r18 = r6.p;
        float r19 = (r16 - r18) / 2.0f;
        r4 = new ForsetiColumnsDraggingHelper.b(r15, r19, r13 + r15, r18 + r19);
    L13:
        if (r4 == null) goto L16;
        float r20 = r4.a;
        float r21 = r4.b;
        float r22 = this.f;
        float r23 = r21 - r22;
        float r24 = r4.c;
        float r25 = r4.d - r22;
        ForsetiColumnsDraggingHelper r26 = this.c;
        float r110 = r26.r;
        r17.drawRoundRect(r20, r23, r24, r25, r110, r110, r26.E);
        return;
    L16:
        return;
    L8:
        r7 = null;
        goto L9
    L5:
        int r27 = r1.s;
        int r28 = r1.m;
        float r29 = (r27 - r28) / 2.0f;
        float r30 = r1.z;
        float r31 = r1.l;
        float r32 = (r30 - r31) / 2.0f;
        r7 = new ForsetiColumnsDraggingHelper.b(r29, r32, r28 + r29, r31 + r32);
        goto L6
    }

    public final void c(Canvas r15) {
        ForsetiColumnsDraggingHelper r0 = this.c;
        ForsetiColumnsDraggingHelper.b r2 = null;
        if (ForsetiColumnsDraggingHelper.h(r0.z) == false) goto L5;
        ForsetiColumnsDraggingHelper.b r6 = null;
    L6:
        this.a = r6;
        Path r1 = new Path();
        ForsetiColumnsDraggingHelper r3 = this.c;
        float r4 = r3.n;
        Paint r5 = r3.C;
        ForsetiColumnsDraggingHelper.b r7 = this.a;
        if (r7 == null) goto L9;
        float r8 = r7.a;
    L10:
        if (r7 == null) goto L12;
        float r9 = r7.b;
    L13:
        float r10 = this.f;
        float r11 = r9 - r10;
        if (r7 == null) goto L16;
        float r12 = r7.c;
    L17:
        if (r7 == null) goto L19;
        float r13 = r7.d;
    L20:
        float r14 = r13 - r10;
        r1.reset();
        r1.moveTo(r8, r11);
        r1.lineTo(r12 - r4, r11);
        float r16 = 2 * r4;
        float r17 = r12 - r16;
        r1.arcTo(new RectF(r17, r11, r12, r11 + r16), -90.0f, 90.0f);
        r1.lineTo(r12, r14 - r4);
        r1.arcTo(new RectF(r17, r14 - r16, r12, r14), 0.0f, 90.0f);
        r1.lineTo(r8, r14);
        r1.close();
        r15.drawPath(r1, r5);
        ForsetiColumnsDraggingHelper r18 = this.c;
        if (ForsetiColumnsDraggingHelper.h(r18.z) == true) goto L24;
        float r19 = ((r18.o - r18.q) / 2.0f) + ((r18.s - r18.B.getStrokeWidth()) / 2.0f);
        float r20 = r18.q + r19;
        float r21 = r18.z;
        float r22 = r18.p;
        float r23 = (r21 - r22) / 2.0f;
        r2 = new ForsetiColumnsDraggingHelper.b(r19, r23, r20, r22 + r23);
    L24:
        if (r2 == null) goto L27;
        float r24 = r2.a;
        float r25 = r2.b;
        float r26 = this.f;
        float r27 = r25 - r26;
        float r28 = r2.c;
        float r29 = r2.d - r26;
        ForsetiColumnsDraggingHelper r30 = this.c;
        float r31 = r30.r;
        r15.drawRoundRect(r24, r27, r28, r29, r31, r31, r30.E);
        return;
    L27:
        return;
    L19:
        r13 = 0.0f;
        goto L20
    L16:
        r12 = 0.0f;
        goto L17
    L12:
        r9 = 0.0f;
        goto L13
    L9:
        r8 = 0.0f;
        goto L10
    L5:
        float r32 = (r0.s - r0.B.getStrokeWidth()) / 2.0f;
        float r33 = r0.o + r32;
        float r34 = r0.z;
        float r35 = r0.l;
        float r36 = (r34 - r35) / 2.0f;
        r6 = new ForsetiColumnsDraggingHelper.b(r32, r36, r33, r35 + r36);
        goto L6
    }

    public final void d(Canvas r17) {
        ForsetiColumnsDraggingHelper r1 = this.c;
        ForsetiColumnsDraggingHelper.b r3 = null;
        if (ForsetiColumnsDraggingHelper.h(r1.z) == false) goto L5;
        ForsetiColumnsDraggingHelper.b r7 = null;
    L6:
        this.a = r7;
        Path r2 = new Path();
        ForsetiColumnsDraggingHelper r4 = this.c;
        float r5 = r4.n;
        if (r4.e() == true) goto L9;
        Paint r6 = this.c.F;
    L11:
        if (this.c.e() == true) goto L13;
        Paint r8 = this.c.G;
    L14:
        Paint r14 = r8;
        ForsetiColumnsDraggingHelper.b r9 = this.a;
        if (r9 == null) goto L17;
        float r10 = r9.a;
    L18:
        if (r9 == null) goto L20;
        float r11 = r9.b;
    L21:
        float r12 = this.f;
        float r13 = r11 - r12;
        if (r9 == null) goto L24;
        float r15 = r9.c;
    L25:
        if (r9 == null) goto L27;
        float r16 = r9.d;
    L28:
        float r18 = r16 - r12;
        r2.reset();
        r2.moveTo(r10, r13);
        r2.lineTo(r15 - r5, r13);
        float r19 = 2 * r5;
        float r110 = r15 - r19;
        r2.arcTo(new RectF(r110, r13, r15, r13 + r19), -90.0f, 90.0f);
        r2.lineTo(r15, r18 - r5);
        r2.arcTo(new RectF(r110, r18 - r19, r15, r18), 0.0f, 90.0f);
        r2.lineTo(r10, r18);
        r2.close();
        r17.drawPath(r2, r6);
        ForsetiColumnsDraggingHelper r20 = this.c;
        if (ForsetiColumnsDraggingHelper.h(r20.z) == true) goto L32;
        float r21 = ((r20.m - r20.q) / 2.0f) + ((r20.s - r20.B.getStrokeWidth()) / 2.0f);
        float r22 = r20.q + r21;
        float r23 = r20.z;
        float r24 = r20.p;
        float r25 = (r23 - r24) / 2.0f;
        r3 = new ForsetiColumnsDraggingHelper.b(r21, r25, r22, r24 + r25);
    L32:
        if (r3 == null) goto L35;
        float r26 = r3.a;
        float r27 = r3.b;
        float r28 = this.f;
        float r111 = r3.c;
        float r112 = r3.d - r28;
        float r113 = this.c.r;
        r17.drawRoundRect(r26, r27 - r28, r111, r112, r113, r113, r14);
        return;
    L35:
        return;
    L27:
        r16 = 0.0f;
        goto L28
    L24:
        r15 = 0.0f;
        goto L25
    L20:
        r11 = 0.0f;
        goto L21
    L17:
        r10 = 0.0f;
        goto L18
    L13:
        r8 = this.c.E;
        goto L14
    L9:
        r6 = this.c.C;
        goto L11
    L5:
        float r29 = (r1.s - r1.B.getStrokeWidth()) / 2.0f;
        float r30 = r1.m + r29;
        float r31 = r1.z;
        float r32 = r1.l;
        float r33 = (r31 - r32) / 2.0f;
        r7 = new ForsetiColumnsDraggingHelper.b(r29, r33, r30, r32 + r33);
        goto L6
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        if (this.c.f() == true) goto L19;
        a(r9);
        if (this.d == true) goto L8;
        Log.i("ForsetiNormalChainDraggingView", "current not support dragging, stops to draw button.");
        return;
    L8:
        int r0 = b.a[this.b.ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L14;
        b(r9);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        d(r9);
        return;
    L16:
        c(r9);
        return;
    L19:
        if (this.d == true) goto L22;
        Log.i("ForsetiNormalChainDraggingView", "current not support dragging, stops to draw button.");
        a(r9);
        return;
    L22:
        int r1 = b.a[this.b.ordinal()];
        if (r1 == 1) goto L30;
        if (r1 == 2) goto L29;
        if (r1 != 3) goto L28;
        b(r9);
        ForsetiColumnsDraggingHelper r2 = this.c;
        float r3 = (r2.s - r2.B.getStrokeWidth()) / 2.0f;
        float r4 = getMeasuredHeight();
        ForsetiColumnsDraggingHelper r5 = this.c;
        float r6 = (r4 - r5.l) / 2.0f;
        r9.drawLine(r3, 0.0f, r3, r6, r5.D);
        r9.drawLine(r3, r6 + this.c.l, r3, getMeasuredHeight(), this.c.D);
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        d(r9);
        a(r9);
        return;
    L30:
        c(r9);
        a(r9);
    }

    public final void setDraggingHelper(ForsetiColumnsDraggingHelper r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setDraggingSupport(boolean r1) {
        this.d = r1;
    }

    public final void setForsetiColumnsDraggingHelper(ForsetiColumnsDraggingHelper r1) {
        if (r1 == null) goto L5;
        this.c = r1;
        return;
    }

    public final void setStatus(DraggingStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public ForsetiNormalChainDraggingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = DraggingStatus.UN_DRAGGING_OR_DRAGGING_UNDER_HALF_FULL;
        this.c = new ForsetiColumnsDraggingHelper(r2);
        setWillNotDraw(false);
        if (this.c.f() == false) goto L5;
        Log.i("ForsetiNormalChainDraggingView", "setKeyboardStateListener: optimizeDraggingViewUnderKeyboardDisabled");
        return;
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new c(this));
    }

    public /* synthetic */ ForsetiNormalChainDraggingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
