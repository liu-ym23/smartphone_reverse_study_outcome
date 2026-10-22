package com.ss.android.lark.forseti.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.ui.g;
import com.ss.android.lark.forseti.widget.bean.ArrowDirection;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\u00020\u0001:\u0001=B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0014J\u0010\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020'H\u0002J\b\u00101\u001a\u00020'H\u0002J0\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0015J\u0006\u00108\u001a\u00020\u001fJ\u0016\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0015J\u000e\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020%R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiPopoverViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "shadowSizePadding", "", "popoverPosition", "Lcom/ss/android/lark/forseti/widget/bean/PopoverPosition;", "horizontalSafeMargin", "minWidthFoldInPixels", "popoverWidthInDp", "", "getPopoverWidthInDp", "()F", "popoverHeightInDp", "getPopoverHeightInDp", "isCMode", "", "shadow", "Lcom/ss/android/lark/forseti/widget/ForsetiPopoverShadowLayout;", "forsetiInnerOptions", "Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "getForsetiInnerOptions", "()Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "setForsetiInnerOptions", "(Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;)V", "value", "Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "currentViewType", "setCurrentViewType", "(Lcom/ss/android/lark/api/bean/ForsetiPageViewType;)V", "viewTypeChangeListeners", "", "Lcom/ss/android/lark/api/ui/IForsetiPageViewTypeListener;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onViewAdded", "child", "Landroid/view/View;", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "triggerDisplayModeChanged", "triggerPageViewTypeChanged", "onLayout", "changed", "left", "top", "right", "bottom", "getCurrentPageViewType", "addPageViewTypeChangeListener", "listener", "isSticky", "removePageViewTypeChangeListener", "Companion", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiPopoverViewGroup extends FrameLayout {
    public final int a;
    public dib.a b;
    public final int c;
    public boolean d;
    public final ForsetiPopoverShadowLayout e;
    public uua.a f;
    public ForsetiPageViewType g;
    public final List<g> h;

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ ForsetiPopoverViewGroup a;

        public a(ForsetiPopoverViewGroup r1) {
            this.a = r1;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r6, WindowInsetsCompat r7) {
            Intrinsics.checkNotNullParameter(r6, "<unused var>");
            Intrinsics.checkNotNullParameter(r7, "insets");
            ForsetiPopoverViewGroup r8 = this.a;
            if (r8.d == false) goto L5;
            r8.setPadding(r8.getPaddingLeft(), 0, r8.getPaddingRight(), 0);
            return new WindowInsetsCompat.Builder(r7).build();
        L5:
            Insets r9 = r7.getInsets(WindowInsetsCompat.Type.systemBars());
            this.a.setPadding(0, r9.top, 0, r9.bottom);
            View r0 = this.a.getChildAt(0);
            int r2 = Math.max(0, this.a.getMeasuredHeight() - (MathKt.roundToInt(r0.getY()) + r0.getMeasuredHeight()));
            Log.i("FST_PopoverViewGroup", "this.measuredHeight = " + this.a.getMeasuredHeight() + ", theOnlyChild.y = " + r0.getY() + ", theOnlyChild.measuredHeight = " + r0.getMeasuredHeight());
            return new WindowInsetsCompat.Builder(r7).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r9.left, 0, r9.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(0, 0, 0, r7.getInsets(WindowInsetsCompat.Type.ime()).bottom - r2)).build();
        }
    }

    public static final class b {
    }

    static {
    }

    private final float getPopoverHeightInDp() {
        uua.a r0 = this.f;
        if (r0 == null) goto L15;
        vua.a r1 = r0.c;
        if (r1 == null) goto L15;
        Float r2 = Float.valueOf(r1.d);
        if (r2.floatValue() <= 0.0f) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        return r2.floatValue();
    L9:
        r3 = false;
    L15:
        return 600.0f;
    }

    private final float getPopoverWidthInDp() {
        uua.a r0 = this.f;
        if (r0 == null) goto L15;
        vua.a r1 = r0.c;
        if (r1 == null) goto L15;
        Float r2 = Float.valueOf(r1.c);
        if (r2.floatValue() <= 0.0f) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        return r2.floatValue();
    L9:
        r3 = false;
    L15:
        return 375.0f;
    }

    public final ForsetiPageViewType getCurrentPageViewType() {
        return this.g;
    }

    public final uua.a getForsetiInnerOptions() {
        return this.f;
    }

    public ForsetiPopoverViewGroup(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    private final void setCurrentViewType(ForsetiPageViewType r3) {
        if (this.g == r3) goto L8;
        this.g = r3;
        Iterator<T> r0 = this.h.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        ((g) r0.next()).a(r3);
        goto L6
    L10:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        super.dispatchDraw(r7);
        int r8 = getChildCount() - 1;
        boolean r2 = false;
    L4:
        if ((-1) >= r8) goto L49;
        com.ss.android.lark.api.ui.c r3 = getChildAt(r8);
        if (r3.getVisibility() != 0) goto L24;
        int r4 = getMeasuredWidth();
        int r5 = r3.getLeft();
        if (r5 < 0) goto L11;
        if (r5 >= r4) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L24;
        if (r3.getMeasuredWidth() <= 0) goto L24;
        int r9 = getMeasuredHeight();
        int r10 = r3.getTop();
        if (r10 < 0) goto L19;
        if (r10 >= r9) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L24;
        if (r3.getMeasuredHeight() <= 0) goto L24;
        boolean r12 = true;
    L25:
        com.ss.android.lark.api.ui.c r13 = null;
        if (r12 == false) goto L39;
        if (r2 == true) goto L39;
        if ((r3 instanceof com.ss.android.lark.api.ui.c) == false) goto L31;
        r13 = r3;
    L31:
        if (r13 != null) goto L33;
    L37:
        r2 = true;
    L47:
        r8 = r8 - 1;
        goto L4
    L33:
        if (this.d == false) goto L35;
        ForsetiNodeMode r14 = ForsetiNodeMode.NORMAL_C;
    L36:
        r13.a(r14);
        goto L37
    L35:
        r14 = ForsetiNodeMode.STACK_R;
    L39:
        if ((r3 instanceof com.ss.android.lark.api.ui.c) == false) goto L41;
        r13 = r3;
    L41:
        if (r13 == null) goto L47;
        if (this.d == false) goto L45;
        ForsetiNodeMode r15 = ForsetiNodeMode.INVISIBLE_C;
    L46:
        r13.a(r15);
        goto L47
    L45:
        r15 = ForsetiNodeMode.INVISIBLE_R;
    L19:
        r11 = false;
    L11:
        r6 = false;
    L24:
        r12 = false;
        goto L25
    L49:
        if (this.d == true) goto L51;
        ForsetiPageViewType r16 = ForsetiPageViewType.POPOVER_R_VIEW;
    L53:
        if (this.g == r16) goto L60;
        setCurrentViewType(r16);
        return;
    L60:
        return;
    L51:
        r16 = ForsetiPageViewType.POPOVER_C_VIEW;
        goto L53
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r3) {
        Intrinsics.checkNotNullParameter(r3, "child");
        if (getChildCount() > 1) goto L7;
        super.onViewAdded(r3);
        return;
    L7:
        throw new IllegalStateException("Maximum 1 child");
    }

    public final void setForsetiInnerOptions(uua.a r6) {
        this.f = r6;
        boolean r0 = true;
        int r1 = -2;
        if (r6 == null) goto L9;
        vua.a r3 = r6.c;
        if (r3 == null) goto L9;
        if (r3.c != (-2)) goto L9;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        int r5 = -2;
    L14:
        if (r6 == null) goto L20;
        vua.a r7 = r6.c;
        if (r7 == null) goto L20;
        if (r7.d != (-2)) goto L20;
    L21:
        if (r0 == true) goto L24;
        r1 = -1;
    L24:
        this.e.setLayoutParams(new FrameLayout.LayoutParams(r5, r1));
        return;
    L20:
        r0 = false;
        goto L21
    L13:
        r5 = -1;
    L9:
        r4 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.view.View, android.view.ViewGroup, com.larksuite.component.universe_design.shadow.UDShadowLayout, com.ss.android.lark.forseti.widget.ForsetiPopoverShadowLayout] */
    public ForsetiPopoverViewGroup(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = f.a(r2, 32.0f);
        f.a(r2, 12.0f);
        this.c = f.a(r2, 636.0f);
        ?? r4 = new ForsetiPopoverShadowLayout(r2, null);
        r4.setId(2131373232);
        r4.setShadowColor(ContextCompat.getColor(r2, 2131108970));
        r4.setShadowSize(UDShadowLayout.Size.S5);
        this.e = r4;
        this.g = ForsetiPageViewType.POPOVER_R_VIEW;
        this.h = new ArrayList();
        addView(r4);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        int r0 = View.MeasureSpec.getSize(r11);
        int r1 = View.MeasureSpec.getSize(r12);
        if (getChildCount() <= 0) goto L28;
        boolean r2 = false;
        View r4 = getChildAt(0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
        int r3 = f.a(getContext(), getPopoverWidthInDp() + 64.0f);
        int r5 = f.a(getContext(), getPopoverHeightInDp() + 64.0f);
        if (r0 >= this.c) goto L9;
        r3 = r0;
    L9:
        if (r0 <= r3) goto L11;
        boolean r7 = true;
    L12:
        boolean r8 = !r7;
        if (this.d == r8) goto L15;
        r2 = true;
    L15:
        if (r2 == false) goto L17;
        this.d = r8;
        requestApplyInsets();
    L17:
        if (r7 == true) goto L20;
        r5 = r1;
    L20:
        if (r2 == false) goto L26;
        ForsetiPopoverShadowLayout r6 = this.e;
        if (this.d == false) goto L24;
        UDShadowLayout.Size r9 = UDShadowLayout.Size.NONE;
    L25:
        r6.setShadowSize(r9);
        goto L26
    L24:
        r9 = UDShadowLayout.Size.S5;
    L26:
        measureChildWithMargins(r4, r11, r0 - r3, r12, r1 - r5);
        setMeasuredDimension(r0, r1);
        return;
    L11:
        r7 = false;
        goto L12
    L28:
        setMeasuredDimension(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        super.onLayout(r19, r20, r21, r22, r23);
        if (this.d == false) goto L5;
        return;
    L5:
        WindowInsetsCompat r1 = ViewCompat.getRootWindowInsets(this);
        if (r1 == null) goto L8;
        Insets r2 = r1.getInsets(WindowInsetsCompat.Type.systemBars());
    L9:
        if (r2 == null) goto L11;
        int r4 = r2.top;
    L12:
        if (r2 == null) goto L14;
        int r3 = r2.bottom;
    L15:
        Iterator r5 = ViewGroupKt.getChildren(this).iterator();
    L17:
        if (r5.hasNext() == false) goto L92;
        View r6 = (View) r5.next();
        if ((r6 instanceof ForsetiPopoverShadowLayout) == false) goto L21;
        ForsetiPopoverShadowLayout r7 = (ForsetiPopoverShadowLayout) r6;
    L22:
        Log.d("FST_PopoverViewGroup", "measuredWidth: " + r6.getMeasuredWidth() + ", measuredHeight: " + r6.getMeasuredHeight());
        boolean r8 = r6 instanceof ViewGroup;
        if (r8 == false) goto L25;
        ViewGroup r10 = (ViewGroup) r6;
    L27:
        if (r10 == null) goto L33;
        Sequence r11 = ViewGroupKt.getChildren(r10);
        if (r11 == null) goto L33;
        View r12 = (View) SequencesKt.lastOrNull(r11);
        if (r12 == null) goto L33;
        int r14 = r12.getMeasuredWidth();
    L34:
        if (r8 == false) goto L36;
        ViewGroup r9 = (ViewGroup) r6;
    L37:
        if (r9 == null) goto L43;
        Sequence r13 = ViewGroupKt.getChildren(r9);
        if (r13 == null) goto L43;
        View r15 = (View) SequencesKt.lastOrNull(r13);
        if (r15 == null) goto L43;
        int r16 = r15.getMeasuredHeight();
    L44:
        Activity r17 = ContextsKt.findActivity(getContext());
        if (r17 == null) goto L51;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L51;
        View r24 = a(r18);
        if (r24 == null) goto L51;
        int r110 = r24.getWidth();
    L52:
        Activity r25 = ContextsKt.findActivity(getContext());
        if (r25 == null) goto L59;
        Window r26 = r25.getWindow();
        if (r26 == null) goto L59;
        View r27 = a(r26);
        if (r27 == null) goto L59;
        int r111 = r27.getHeight();
    L60:
        Context r112 = getContext();
        uua.a r28 = this.f;
        if (r28 == null) goto L63;
        vua.a r113 = r28.c;
    L64:
        this.b = eib.a.a(r112, r113, r14, r16, r110, r111);
        Log.d("FST_PopoverViewGroup", "popoverPosition: " + this.b);
        dib.a r114 = this.b;
        if (r114 == null) goto L67;
        int r115 = r114.a;
    L68:
        int r116 = this.a;
        int r117 = r115 - r116;
        if (r114 == null) goto L71;
        int r118 = r114.b;
    L72:
        int r119 = Math.max(r118 - r116, r4);
        dib.a r120 = this.b;
        if (r120 == null) goto L76;
        ArrowDirection r121 = r120.c;
        if (r121 == null) goto L76;
    L77:
        float r122 = 0.0f;
        if (r120 == null) goto L80;
        float r123 = r120.d;
    L81:
        int r29 = this.a;
        float r30 = r29 + r123;
        if (r120 == null) goto L84;
        r122 = r120.e;
    L84:
        dib.a r31 = new dib.a(r117, r119, r121, r30, r122 + r29);
        if (r7 == null) goto L87;
        r7.setPopoverPosition(r31);
    L87:
        int r32 = r31.a;
        int r33 = r6.getMeasuredWidth() + r32;
        int r124 = r23 - r3;
        int r34 = Math.min(r31.b + r6.getMeasuredHeight(), r124);
        if ((r31.b + r6.getMeasuredHeight()) <= r124) goto L90;
        int r125 = r124 - r6.getMeasuredHeight();
    L91:
        r6.layout(r32, r125, r33, r34);
        Log.d("FST_PopoverViewGroup", "onLayout=, child: " + r6 + ", newL: " + r32 + ", newT: " + r125 + ", newR: " + r33 + ", newB: " + r34);
        goto L17
    L90:
        r125 = r31.b;
        goto L91
    L80:
        r123 = 0.0f;
    L76:
        r121 = ArrowDirection.NONE;
        goto L77
    L71:
        r118 = 0;
        goto L72
    L67:
        r115 = 0;
        goto L68
    L63:
        r113 = null;
    L59:
        r111 = -1;
    L51:
        r110 = -1;
    L43:
        r16 = -1;
        goto L44
    L36:
        r9 = null;
    L33:
        r14 = -1;
        goto L34
    L25:
        r10 = null;
        goto L27
    L21:
        r7 = null;
        goto L22
    L92:
        return;
    L14:
        r3 = 0;
        goto L15
    L11:
        r4 = 0;
        goto L12
    L8:
        r2 = null;
        goto L9
    }
}
