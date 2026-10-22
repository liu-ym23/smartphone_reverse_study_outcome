package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J \u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J \u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R9\u0010\u0012\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larus/common_ui/view/CommonSlideRootContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "startX", "startY", "touchSlop", "dismissOffset", "", "actionMoveOffset", "dismissCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "orientation", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function1;", "setDismissCallback", "(Lkotlin/jvm/functions/Function1;)V", "onFinishInflate", "initViewPager2", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onHorizontalActionMove", "endX", "disX", "disY", "onVerticalActionMove", "endY", "onTouchEvent", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonSlideRootContainer extends ConstraintLayout {
    public ViewPager2 a;
    public int b;
    public int c;
    public final int d;
    public final float e;
    public Function1<? super Integer, Unit> f;

    public CommonSlideRootContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonSlideRootContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        int r0 = getChildCount();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L15;
        ViewPager2 r4 = getChildAt(r2);
        if ((r4 instanceof ViewPager2) == false) goto L13;
        if (r4.getVisibility() != 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        this.a = r4;
        goto L15
    L10:
        r5 = false;
    L13:
        r2 = r2 + 1;
    L15:
        if (this.a != null) goto L52;
        ViewGroup r1 = (ViewGroup) findViewById(2131367728);
        if (r1 != null) goto L19;
        return;
    L19:
        if (r1.getChildCount() < 1) goto L67;
        View r3 = r1.getChildAt(0);
        if (r3 != null) goto L24;
        return;
    L24:
        if ((r3 instanceof ViewGroup) == false) goto L63;
        ViewGroup r6 = (ViewGroup) r3;
        if (r6.getChildCount() < 1) goto L68;
        ViewPager2 r7 = r6.getChildAt(0);
        if ((r7 instanceof ViewPager2) == false) goto L37;
        if (r7.getVisibility() != 0) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L37;
        this.a = r7;
        return;
    L33:
        r8 = false;
    L37:
        if ((r7 instanceof ViewGroup) == false) goto L39;
        ViewGroup r9 = (ViewGroup) r7;
    L40:
        if (r9 == null) goto L65;
        int r10 = r9.getChildCount();
        int r11 = 0;
    L42:
        if (r11 >= r10) goto L69;
        ViewPager2 r12 = r9.getChildAt(r11);
        if ((r12 instanceof ViewPager2) == false) goto L51;
        if (r12.getVisibility() != 0) goto L48;
        boolean r13 = true;
    L49:
        if (r13 == false) goto L51;
        this.a = r12;
        return;
    L48:
        r13 = false;
    L51:
        r11 = r11 + 1;
        goto L42
    L69:
        return;
    L65:
        return;
    L39:
        r9 = null;
        goto L40
    L68:
        return;
    L63:
        return;
    L67:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onFinishInflate() {
        super/*android.view.ViewGroup*/.onFinishInflate();
        R5();
    }

    public final Function1<Integer, Unit> getDismissCallback() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        if (this.a != null) goto L6;
        R5();
    L6:
        if (this.a == null) goto L8;
        int r0 = r10.getAction();
        if (r0 != 0) goto L12;
        this.b = (int) r10.getX();
        this.c = (int) r10.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L156:
        return false;
    L12:
        if (r0 != 2) goto L156;
        ViewPager2 r1 = this.a;
        if (r1 != null) goto L17;
    L19:
        boolean r2 = false;
    L20:
        RecyclerView.Adapter r3 = null;
        if (r2 == true) goto L36;
        ViewPager2 r4 = this.a;
        if (r4 == null) goto L25;
        RecyclerView.Adapter r5 = r4.getAdapter();
    L26:
        if (r5 == null) goto L35;
        ViewPager2 r6 = this.a;
        if (r6 == null) goto L32;
        RecyclerView.Adapter r7 = r6.getAdapter();
        if (r7 == null) goto L32;
        int r8 = r7.getItemCount();
    L33:
        if (r8 > 1) goto L35;
    L32:
        r8 = 0;
    L35:
        boolean r9 = false;
    L37:
        int r11 = (int) r10.getX();
        int r12 = (int) r10.getY();
        int r13 = Math.abs(r11 - this.b);
        int r14 = Math.abs(r12 - this.c);
        int r15 = this.d;
        if (r13 >= r15) goto L42;
        if (r14 >= r15) goto L42;
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r10);
    L42:
        if (r13 <= r14) goto L50;
        ViewPager2 r16 = this.a;
        if (r16 != null) goto L46;
    L48:
        boolean r17 = false;
    L49:
        if (r17 == false) goto L50;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
    L60:
        if (r9 == false) goto L78;
        if (r13 <= r14) goto L69;
        ViewPager2 r18 = this.a;
        if (r18 != null) goto L65;
    L67:
        boolean r110 = false;
    L68:
        if (r110 == false) goto L69;
    L77:
        return true;
    L65:
        if (r18.getOrientation() != 0) goto L67;
        r110 = true;
    L69:
        if (r14 <= r13) goto L78;
        ViewPager2 r111 = this.a;
        if (r111 != null) goto L73;
    L75:
        boolean r112 = false;
    L76:
        if (r112 == false) goto L78;
    L73:
        if (r111.getOrientation() != 1) goto L75;
        r112 = true;
    L78:
        ViewPager2 r113 = this.a;
        if (r113 != null) goto L81;
    L83:
        boolean r114 = false;
    L84:
        if (r114 == false) goto L116;
        ViewPager2 r115 = this.a;
        if (r115 == null) goto L88;
        RecyclerView.Adapter r116 = r115.getAdapter();
    L89:
        if (r116 == null) goto L158;
        ViewPager2 r117 = this.a;
        if (r117 == null) goto L94;
        Integer r118 = Integer.valueOf(r117.getCurrentItem());
    L95:
        ViewPager2 r20 = this.a;
        if (r20 == null) goto L98;
        r3 = r20.getAdapter();
    L98:
        Intrinsics.checkNotNull(r3);
        int r21 = r3.getItemCount();
        if (r14 <= r13) goto L114;
        if (r118 != null) goto L103;
    L106:
        int r22 = r21 - 1;
        if (r118 == null) goto L114;
        if (r118.intValue() != r22) goto L114;
        if ((r12 - this.c) >= 0) goto L114;
        return true;
    L103:
        if (r118.intValue() != 0) goto L106;
        if ((r12 - this.c) <= 0) goto L106;
        return true;
    L114:
        return false;
    L94:
        r118 = null;
        goto L95
    L158:
        return true;
    L88:
        r116 = null;
        goto L89
    L116:
        ViewPager2 r119 = this.a;
        if (r119 != null) goto L119;
    L121:
        boolean r120 = false;
    L122:
        if (r120 == false) goto L156;
        ViewPager2 r121 = this.a;
        if (r121 == null) goto L126;
        RecyclerView.Adapter r122 = r121.getAdapter();
    L127:
        if (r122 == null) goto L161;
        if (r13 <= r14) goto L153;
        ViewPager2 r123 = this.a;
        if (r123 == null) goto L133;
        r3 = Integer.valueOf(r123.getCurrentItem());
    L133:
        ViewPager2 r124 = this.a;
        if (r124 == null) goto L138;
        RecyclerView.Adapter r125 = r124.getAdapter();
        if (r125 == null) goto L138;
        int r126 = r125.getItemCount();
    L139:
        if (r3 != null) goto L142;
    L145:
        int r127 = r126 - 1;
        if (r3 == null) goto L153;
        if (r3.intValue() != r127) goto L153;
        if ((r11 - this.b) >= 0) goto L153;
        return true;
    L142:
        if (r3.intValue() != 0) goto L145;
        if ((r11 - this.b) <= 0) goto L145;
        return true;
    L138:
        r126 = 0;
    L153:
        return false;
    L161:
        return true;
    L126:
        r122 = null;
        goto L127
    L119:
        if (r119.getOrientation() != 0) goto L121;
        r120 = true;
        goto L122
    L81:
        if (r113.getOrientation() != 1) goto L83;
        r114 = true;
        goto L84
    L46:
        if (r16.getOrientation() != 0) goto L48;
        r17 = true;
    L50:
        if (r13 >= r14) goto L59;
        ViewPager2 r128 = this.a;
        if (r128 != null) goto L54;
    L56:
        boolean r129 = false;
    L57:
        if (r129 == false) goto L59;
    L54:
        if (r128.getOrientation() != 1) goto L56;
        r129 = true;
    L59:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L60
    L25:
        r5 = null;
    L36:
        r9 = true;
        goto L37
    L17:
        if (r1.isUserInputEnabled() == true) goto L19;
        r2 = true;
        goto L20
    L8:
        return super/*android.view.ViewGroup*/.onInterceptTouchEvent(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        if (this.a != null) goto L6;
        R5();
    L6:
        if (this.a != null) goto L10;
        return super/*android.view.ViewGroup*/.onTouchEvent(r8);
    L10:
        if (r8.getActionMasked() != 2) goto L71;
        float r0 = r8.getX() - this.b;
        float r1 = r8.getY() - this.c;
        if (Math.abs(r0) > this.d) goto L14;
    L23:
        boolean r2 = false;
    L25:
        if (Math.abs(r1) > this.d) goto L27;
    L36:
        boolean r3 = false;
    L37:
        if (r2 == true) goto L40;
        if (r3 == false) goto L71;
    L40:
        if (r0 <= this.e) goto L49;
        ViewPager2 r9 = this.a;
        if (r9 != null) goto L44;
    L46:
        boolean r10 = false;
    L47:
        if (r10 == false) goto L49;
        boolean r11 = true;
    L51:
        if (r1 <= this.e) goto L60;
        ViewPager2 r4 = this.a;
        if (r4 != null) goto L55;
    L57:
        boolean r5 = false;
    L58:
        if (r5 == false) goto L60;
        boolean r6 = true;
    L61:
        if (r11 == false) goto L65;
        Function1<? super Integer, Unit> r12 = this.f;
        if (r12 == null) goto L65;
        r12.invoke(0);
    L65:
        if (r6 == false) goto L69;
        Function1<? super Integer, Unit> r13 = this.f;
        if (r13 == null) goto L69;
        r13.invoke(1);
    L69:
        return true;
    L55:
        if (r4.getOrientation() != 1) goto L57;
        r5 = true;
    L60:
        r6 = false;
        goto L61
    L44:
        if (r9.getOrientation() != 0) goto L46;
        r10 = true;
    L49:
        r11 = false;
        goto L51
    L27:
        if (Math.abs(r1) <= Math.abs(r0)) goto L36;
        ViewPager2 r7 = this.a;
        if (r7 != null) goto L31;
    L33:
        boolean r14 = false;
    L34:
        if (r14 == false) goto L36;
        r3 = true;
        goto L37
    L31:
        if (r7.getOrientation() != 1) goto L33;
        r14 = true;
        goto L34
    L14:
        if (Math.abs(r0) <= Math.abs(r1)) goto L23;
        ViewPager2 r15 = this.a;
        if (r15 != null) goto L18;
    L20:
        boolean r16 = false;
    L21:
        if (r16 == false) goto L23;
        r2 = true;
        goto L25
    L18:
        if (r15.getOrientation() != 0) goto L20;
        r16 = true;
    L71:
        return super/*android.view.ViewGroup*/.onTouchEvent(r8);
    }

    public final void setDismissCallback(Function1<? super Integer, Unit> r1) {
        this.f = r1;
    }

    public CommonSlideRootContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = ViewConfiguration.get(r2).getScaledTouchSlop();
        this.e = 150.0f;
    }

    public /* synthetic */ CommonSlideRootContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
