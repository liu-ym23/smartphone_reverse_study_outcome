package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.music.widget.MusicPlayerSlidingInfoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\rJ \u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ViewPager2Container;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "disallowParentInterceptDownEvent", "", "startX", "startY", "childIntercept", "onFinishInflate", "", "initViewPager2", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onHorizontalActionMove", "endX", "disX", "disY", "requestDisallowInterceptTouchEvent", "disallowIntercept", "requestDisallowIntercept", "onVerticalActionMove", "endY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ViewPager2Container extends RelativeLayout {
    public ViewPager2 a;
    public int b;
    public int c;

    public ViewPager2Container(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ViewPager2Container(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        int r0 = 0;
        View r1 = getChildAt(0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r2 = (ViewGroup) r1;
        int r3 = r2.getChildCount();
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        View r5 = r2.getChildAt(r4);
        if ((r5 instanceof MusicPlayerSlidingInfoView) == true) goto L9;
        r4 = r4 + 1;
    L9:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L17;
        int r7 = r6.getChildCount();
    L12:
        if (r0 >= r7) goto L23;
        ViewPager2 r8 = r6.getChildAt(r0);
        if ((r8 instanceof ViewPager2) == true) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        this.a = r8;
        return;
    L23:
        return;
    L17:
        return;
    L8:
        r5 = null;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r1) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        a();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (this.a != null) goto L6;
        a();
    L6:
        if (this.a == null) goto L8;
        int r0 = r10.getAction();
        boolean r1 = true;
        if (r0 != 0) goto L12;
        this.b = (int) r10.getX();
        this.c = (int) r10.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L132:
        return super.onInterceptTouchEvent(r10);
    L12:
        if (r0 != 1) goto L14;
    L129:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L14:
        if (r0 != 2) goto L16;
        ViewPager2 r2 = this.a;
        if (r2 != null) goto L21;
    L23:
        boolean r3 = false;
    L24:
        RecyclerView.Adapter r4 = null;
        if (r3 == true) goto L40;
        ViewPager2 r5 = this.a;
        if (r5 == null) goto L29;
        RecyclerView.Adapter r6 = r5.getAdapter();
    L30:
        if (r6 == null) goto L39;
        ViewPager2 r7 = this.a;
        if (r7 == null) goto L36;
        RecyclerView.Adapter r8 = r7.getAdapter();
        if (r8 == null) goto L36;
        int r9 = r8.getItemCount();
    L37:
        if (r9 > 1) goto L39;
    L36:
        r9 = 0;
    L39:
        boolean r11 = false;
    L41:
        if (r11 == false) goto L43;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L43:
        int r12 = (int) r10.getX();
        int r13 = (int) r10.getY();
        int r14 = Math.abs(r12 - this.b);
        int r15 = Math.abs(r13 - this.c);
        ViewPager2 r16 = this.a;
        if (r16 != null) goto L46;
    L48:
        boolean r17 = false;
    L49:
        if (r17 == false) goto L84;
        ViewPager2 r18 = this.a;
        if (r18 == null) goto L53;
        RecyclerView.Adapter r19 = r18.getAdapter();
    L54:
        if (r19 == null) goto L132;
        ViewPager2 r20 = this.a;
        if (r20 == null) goto L59;
        Integer r21 = Integer.valueOf(r20.getCurrentItem());
    L60:
        ViewPager2 r22 = this.a;
        if (r22 == null) goto L63;
        r4 = r22.getAdapter();
    L63:
        Intrinsics.checkNotNull(r4);
        int r23 = r4.getItemCount();
        if (r15 <= r14) goto L82;
        if (r21 != null) goto L68;
    L72:
        ViewParent r24 = getParent();
        int r25 = r23 - 1;
        if (r21 != null) goto L76;
    L81:
        r24.requestDisallowInterceptTouchEvent(r1);
        goto L132
    L76:
        if (r21.intValue() != r25) goto L81;
        if ((r13 - this.c) >= 0) goto L81;
        r1 = false;
        goto L81
    L68:
        if (r21.intValue() != 0) goto L72;
        if ((r13 - this.c) >= 0) goto L72;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L82:
        if (r14 <= r15) goto L132;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L59:
        r21 = null;
        goto L60
    L53:
        r19 = null;
        goto L54
    L84:
        ViewPager2 r26 = this.a;
        if (r26 != null) goto L87;
    L89:
        boolean r27 = false;
    L90:
        if (r27 == false) goto L132;
        ViewPager2 r28 = this.a;
        if (r28 == null) goto L94;
        RecyclerView.Adapter r29 = r28.getAdapter();
    L95:
        if (r29 == null) goto L132;
        if ((r14 * 2) <= r15) goto L128;
        ViewPager2 r30 = this.a;
        if (r30 == null) goto L102;
        r4 = Integer.valueOf(r30.getCurrentItem());
    L102:
        ViewPager2 r31 = this.a;
        if (r31 == null) goto L107;
        RecyclerView.Adapter r32 = r31.getAdapter();
        if (r32 == null) goto L107;
        int r33 = r32.getItemCount();
    L108:
        if (r4 != null) goto L111;
    L115:
        int r34 = r33 - 1;
        if (r4 != null) goto L119;
    L124:
        boolean r35 = true;
    L125:
        if (r35 == false) goto L127;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L132
    L127:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L132
    L119:
        if (r4.intValue() != r34) goto L124;
        if ((r12 - this.b) >= 0) goto L124;
        r35 = false;
        goto L125
    L111:
        if (r4.intValue() != 0) goto L115;
        if ((r12 - this.b) <= 0) goto L115;
        getParent().requestDisallowInterceptTouchEvent(false);
    L107:
        r33 = 0;
        goto L108
    L128:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L132
    L94:
        r29 = null;
        goto L95
    L87:
        if (r26.getOrientation() != 0) goto L89;
        r27 = true;
        goto L90
    L46:
        if (r16.getOrientation() != 1) goto L48;
        r17 = true;
        goto L49
    L29:
        r6 = null;
    L40:
        r11 = true;
        goto L41
    L21:
        if (r2.isUserInputEnabled() == true) goto L23;
        r3 = true;
        goto L24
    L16:
        if (r0 == 3) goto L129;
    L8:
        return super.onInterceptTouchEvent(r10);
    }

    public ViewPager2Container(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ViewPager2Container(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
