package com.ss.android.lark.forseti.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import cib.f;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.ForsetiStackChainBottomSheetBehaviorV2;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.ss.android.lark.api.bean.ForsetiNodeMode;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.api.ui.g;
import com.ss.android.lark.api.ui.i;
import com.ss.android.lark.base.embedded.LKSplitController;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 V2\u00020\u0001:\u0002VWB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0014J$\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\t2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0016J\u0006\u0010?\u001a\u00020\u000eJ\u0010\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020BH\u0014J\u000e\u0010C\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010D\u001a\u000205H\u0014J\b\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u000205H\u0002J\u000e\u0010G\u001a\u0002052\u0006\u0010/\u001a\u00020\tJ\u000e\u0010H\u001a\u0002052\u0006\u0010I\u001a\u00020\u000eJ\u000e\u0010J\u001a\u0002052\u0006\u0010I\u001a\u00020\u000eJ\u000e\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020\tJ\u0006\u0010M\u001a\u00020\u0017J\u0016\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u000eJ\u000e\u0010Q\u001a\u0002052\u0006\u0010O\u001a\u00020\u001dJ\u000e\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\u000eJ\u000e\u0010T\u001a\u0002052\u0006\u0010*\u001a\u00020\tJ\b\u0010U\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001b\u0010#\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b$\u0010 R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R$\u0010*\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxHeightInPixelsLevel0", "", "minVerticalPadding", "expandThreshold", "", "isCMode", "", "cModeInitialized", "childHeightGreaterThanThreshold", "Ljava/lang/Boolean;", "peekHeightInPx", "isSkipCollapsed", "forsetiStackStyleChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiStackStyleChangeListener;", "value", "Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "currentViewType", "setCurrentViewType", "(Lcom/ss/android/lark/api/bean/ForsetiPageViewType;)V", "viewTypeChangeListeners", "", "Lcom/ss/android/lark/api/ui/IForsetiPageViewTypeListener;", "nestedScrollOptimizeDisableFG", "getNestedScrollOptimizeDisableFG", "()Z", "nestedScrollOptimizeDisableFG$delegate", "Lkotlin/Lazy;", "multiStackDisableFG", "getMultiStackDisableFG", "multiStackDisableFG$delegate", "shadow", "Lcom/ss/android/lark/forseti/widget/ForsetiStackShadowLayout;", "isValidPeekHeight", "Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "style", "getStyle", "()Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "setStyle", "(Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;)V", "pendingBottomSheetState", "swipeToDismissDisabled", "swipeToDismissDisabledV2", "chainHelper", "Lcom/ss/android/lark/forseti/widget/StackChainHelper;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "onViewAdded", "isCModeStatus", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "setForsetiStackStyleChangeListener", "onDetachedFromWindow", "triggerDisplayModeChanged", "triggerPageViewTypeChanged", "setPendingBottomSheetState", "setSwipeToDismissDisabled", "disabled", "setSwipeToDismissDisabledV2", "setPeekHeightInPx", "height", "getCurrentPageViewType", "addPageViewTypeChangeListener", "listener", "isSticky", "removePageViewTypeChangeListener", "skipCollapsed", "skip", "updateStyle", "getSystemBarsTop", "Companion", "Style", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiStackChainViewGroup extends FrameLayout {
    public final int a;
    public final int b;
    public final float c;
    public boolean d;
    public boolean e;
    public Boolean f;
    public int g;
    public boolean h;
    public i i;
    public ForsetiPageViewType j;
    public final List<g> k;
    public final Lazy l;
    public final Lazy m;
    public final ForsetiStackShadowLayout n;
    public Style o;
    public int p;
    public boolean q;
    public boolean r;
    public final e s;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/forseti/widget/ForsetiStackChainViewGroup$Style;", "", "<init>", "(Ljava/lang/String;I)V", "UNINITIALIZED", "HALF_STACK", "STACK", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum Style extends Enum<Style> {
        public static final Style HALF_STACK = null;
        public static final Style STACK = null;
        public static final Style UNINITIALIZED = null;
        public static final /* synthetic */ Style[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Style> getEntries() {
            return b;
        }

        static {
            Style r0 = new Style("UNINITIALIZED", 0);
            UNINITIALIZED = r0;
            Style r1 = new Style("HALF_STACK", 1);
            HALF_STACK = r1;
            Style r3 = new Style("STACK", 2);
            STACK = r3;
            Style[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Style[] values() {
            return (Style[]) a.clone();
        }

        public static Style valueOf(String r1) {
            return (Style) r27.a.a(Style.class, r1);
        }

        public Style(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ ForsetiStackChainViewGroup a;
        public final /* synthetic */ Context b;

        public a(ForsetiStackChainViewGroup r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r7, WindowInsetsCompat r8) {
            Intrinsics.checkNotNullParameter(r7, "<unused var>");
            Intrinsics.checkNotNullParameter(r8, "insets");
            if (this.a.d == false) goto L23;
            Activity r9 = ContextsKt.findActivity(this.b);
            if (this.a.getStyle() != Style.HALF_STACK) goto L7;
        L16:
            Insets r10 = r8.getInsets(WindowInsetsCompat.Type.systemBars());
            ForsetiStackChainViewGroup r1 = this.a;
            r1.setPadding(r1.getPaddingLeft(), r10.top, r1.getPaddingRight(), 0);
            if (ForsetiStackChainViewGroup.a(this.a) == true) goto L27;
            WindowInsetsCompat.Builder r11 = new WindowInsetsCompat.Builder(r8).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r10.left, 0, r10.right, r10.bottom));
            if (this.a.findFocus() != null) goto L26;
            r11.setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE);
        L26:
            return r11.build();
        L27:
            return new WindowInsetsCompat.Builder(r8).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r10.left, 0, r10.right, r10.bottom)).build();
        L7:
            if (this.a.getStyle() != Style.STACK) goto L15;
            if (r9 == null) goto L15;
            LKSplitController r2 = LKSplitController.b;
            if (LKSplitController.a.a().e() == false) goto L12;
            boolean r12 = com.ss.android.lark.base.embedded.b.c(r9);
        L13:
            if (r12 == false) goto L15;
        L12:
            r12 = false;
        L15:
            ForsetiStackChainViewGroup r13 = this.a;
            r13.setPadding(r13.getPaddingLeft(), 0, r13.getPaddingRight(), 0);
            return new WindowInsetsCompat.Builder(r8).build();
        L23:
            Insets r14 = r8.getInsets(WindowInsetsCompat.Type.systemBars());
            this.a.setPadding(0, r14.top, 0, r14.bottom);
            View r3 = this.a.getChildAt(0);
            int r4 = Math.max(0, this.a.getMeasuredHeight() - (MathKt.roundToInt(r3.getY()) + r3.getMeasuredHeight()));
            Log.i("FST_StackViewGroup", "this.measuredHeight = " + this.a.getMeasuredHeight() + ", theOnlyChild.y = " + r3.getY() + ", theOnlyChild.measuredHeight = " + r3.getMeasuredHeight());
            Insets r5 = r8.getInsets(WindowInsetsCompat.Type.ime());
            WindowInsetsCompat r15 = new WindowInsetsCompat.Builder(r8).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r14.left, 0, r14.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(0, 0, 0, r5.bottom - r4)).build();
            Log.i("FST_StackViewGroup", "onApplyWindowInsetsListener imeInsets = " + r5 + ", childToBottom = " + r4);
            return r15;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ ForsetiStackChainViewGroup a;
        public final /* synthetic */ boolean b;

        public c(ForsetiStackChainViewGroup r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            BottomSheetBehavior r10 = BottomSheetBehavior.from(this.a);
            int r11 = 3;
            if (this.a.getStyle() != Style.HALF_STACK) goto L16;
            ForsetiStackChainViewGroup r12 = this.a;
            if (r12.d == false) goto L16;
            if (this.b == false) goto L16;
            r10.setSkipCollapsed(r12.h);
            ForsetiStackChainViewGroup r13 = this.a;
            int r14 = r13.p;
            if (r14 == 0) goto L12;
            r11 = r14;
        L15:
            r10.setState(r11);
        L20:
            this.a.p = 0;
            return;
        L12:
            if (r13.b() == true) goto L15;
            r11 = 4;
        L16:
            r10.setSkipCollapsed(true);
            int r15 = this.a.p;
            if (r15 == 0) goto L19;
            r11 = r15;
        L19:
            r10.setState(r11);
            goto L20
        }
    }

    static {
    }

    private final boolean getMultiStackDisableFG() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    private final boolean getNestedScrollOptimizeDisableFG() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    public final boolean b() {
        if (this.g <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getSystemBarsTop() {
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(this);
        if (r0 == null) goto L7;
        Insets r1 = r0.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r1 == null) goto L7;
        return r1.top;
    L7:
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = null;
    }

    public final ForsetiPageViewType getCurrentPageViewType() {
        return this.j;
    }

    public final Style getStyle() {
        return this.o;
    }

    public ForsetiStackChainViewGroup(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ boolean a(ForsetiStackChainViewGroup r0) {
        return r0.getMultiStackDisableFG();
    }

    private final void setCurrentViewType(ForsetiPageViewType r3) {
        if (this.j == r3) goto L8;
        this.j = r3;
        Iterator<T> r0 = this.k.iterator();
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
        if (this.d == true) goto L52;
        ForsetiPageViewType r16 = ForsetiPageViewType.MODAL_R_VIEW;
    L56:
        if (this.j == r16) goto L63;
        setCurrentViewType(r16);
        return;
    L63:
        return;
    L52:
        if (this.o != Style.HALF_STACK) goto L54;
        r16 = ForsetiPageViewType.MODAL_C_HALF_VIEW;
        goto L56
    L54:
        r16 = ForsetiPageViewType.MODAL_C_FULL_VIEW;
        goto L56
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

    public final void setForsetiStackStyleChangeListener(i r2) {
        Intrinsics.checkNotNullParameter(r2, "forsetiStackStyleChangeListener");
        this.i = r2;
    }

    public final void setPeekHeightInPx(int r2) {
        if (r2 == this.g) goto L6;
        this.g = r2;
        requestLayout();
        return;
    }

    public final void setPendingBottomSheetState(int r1) {
        this.p = r1;
    }

    public final void setStyle(Style r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.o = r2;
        BottomSheetBehavior r3 = BottomSheetBehavior.from(this);
        r3.setHideable(true);
        if (this.e == false) goto L5;
        this.e = false;
        return;
    L5:
        r3.setState(5);
    }

    public final void setSwipeToDismissDisabled(boolean r1) {
        this.q = r1;
    }

    public final void setSwipeToDismissDisabledV2(boolean r1) {
        this.r = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.view.View, android.view.ViewGroup, com.larksuite.component.universe_design.shadow.UDShadowLayout, com.ss.android.lark.forseti.widget.ForsetiStackShadowLayout] */
    public ForsetiStackChainViewGroup(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = f.a(r2, 900.0f);
        this.b = f.a(r2, 8.0f);
        this.c = 0.75f;
        this.j = ForsetiPageViewType.MODAL_R_VIEW;
        this.k = new ArrayList();
        this.l = LazyKt.lazy(ForsetiStackChainViewGroup$nestedScrollOptimizeDisableFG$2.INSTANCE);
        this.m = LazyKt.lazy(ForsetiStackChainViewGroup$multiStackDisableFG$2.INSTANCE);
        ?? r4 = new ForsetiStackShadowLayout(r2, null);
        r4.setId(2131373233);
        r4.setShadowColor(ContextCompat.getColor(r2, 2131108970));
        r4.setShadowSize(UDShadowLayout.Size.S5);
        this.n = r4;
        this.o = Style.UNINITIALIZED;
        this.s = new e(r2);
        addView(r4);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this, r2));
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r13, int r14) {
        int r0 = View.MeasureSpec.getSize(r13);
        int r1 = View.MeasureSpec.getSize(r14);
        if (getChildCount() <= 0) goto L130;
        View r9 = getChildAt(0);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.View");
        e r3 = this.s;
        r3.getClass();
        if (Math.min(r0, r1) < r3.c) goto L10;
        int r4 = r3.b;
        if (r0 < ((r3.a * 2) + r4)) goto L10;
    L12:
        if (r0 <= r4) goto L14;
        boolean r5 = true;
    L15:
        boolean r6 = !r5;
        if (this.e == true) goto L18;
    L21:
        boolean r11 = true;
    L22:
        if (r11 == false) goto L24;
        this.d = r6;
        this.e = true;
        requestApplyInsets();
    L24:
        if (r5 == false) goto L28;
        int r7 = this.a;
        int r8 = r1 - r7;
        int r10 = this.b * 2;
        if (r8 >= r10) goto L29;
        r7 = r1 - r10;
    L29:
        if (r11 == false) goto L77;
        ForsetiStackShadowLayout r12 = this.n;
        if (this.d == false) goto L33;
        UDShadowLayout.Size r15 = UDShadowLayout.Size.NONE;
    L34:
        r12.setShadowSize(r15);
        if (getMultiStackDisableFG() == false) goto L37;
    L41:
        ForsetiStackChainBottomSheetBehaviorV2 r16 = BottomSheetBehavior.from(this);
        Style r17 = this.o;
        Style r18 = Style.STACK;
        if (r17 != r18) goto L44;
        r16.setDraggable(!this.d);
    L46:
        if (getNestedScrollOptimizeDisableFG() == false) goto L55;
        if (this.q == false) goto L51;
        r16.setDraggable(false);
        goto L55
    L51:
        if (this.o != r18) goto L53;
        r16.setDraggable(!this.d);
        goto L55
    L53:
        r16.setDraggable(true);
    L55:
        if (this.r == false) goto L58;
        r16.setDraggable(false);
    L58:
        if ((r16 instanceof ForsetiStackChainBottomSheetBehaviorV2) == false) goto L60;
        ForsetiStackChainBottomSheetBehaviorV2 r19 = r16;
    L61:
        if (r19 == null) goto L63;
        r19.setDisableSheetBehavior(this.r);
    L63:
        ViewGroup.LayoutParams r20 = r9.getLayoutParams();
        if (r20 == null) goto L75;
        FrameLayout.LayoutParams r21 = (FrameLayout.LayoutParams) r20;
        if (this.o == Style.HALF_STACK) goto L68;
    L70:
        int r22 = 17;
    L71:
        r21.gravity = r22;
        r9.setLayoutParams(r21);
        i r23 = this.i;
        if (r23 == null) goto L77;
        r23.a(this.d);
        goto L77
    L68:
        if (this.d == false) goto L70;
        r22 = 80;
        goto L71
    L75:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L60:
        r19 = null;
        goto L61
    L44:
        r16.setDraggable(true);
        goto L46
    L37:
        if (this.o != Style.HALF_STACK) goto L41;
        if (this.d == false) goto L41;
        this.n.setIsHalfDisplay(true);
        goto L41
    L33:
        r15 = UDShadowLayout.Size.S5;
    L77:
        if (b() == true) goto L79;
    L83:
        int r24 = View.MeasureSpec.makeMeasureSpec(r1, Target.SIZE_ORIGINAL);
    L84:
        int r25 = r0 - r4;
        Style r26 = this.o;
        if (r26 != Style.STACK) goto L87;
    L94:
        int r27 = r14;
    L95:
        measureChildWithMargins(r9, r13, r25, r27, r1 - r7);
        setMeasuredDimension(r0, r1);
        if (r9.getMeasuredHeight() > (getMeasuredHeight() * this.c)) goto L98;
    L100:
        boolean r110 = false;
    L101:
        boolean r111 = !Intrinsics.areEqual(this.f, Boolean.valueOf(r110));
        this.f = Boolean.valueOf(r110);
        if (r11 == true) goto L107;
        if (r111 == true) goto L107;
        if (b() == true) goto L107;
        return;
    L107:
        if (isLaidOut() == true) goto L109;
    L128:
        addOnLayoutChangeListener(new c(this, r110));
        return;
    L109:
        if (isLayoutRequested() == true) goto L128;
        BottomSheetBehavior r112 = BottomSheetBehavior.from(this);
        int r28 = 3;
        if (getStyle() == Style.HALF_STACK) goto L113;
    L123:
        r112.setSkipCollapsed(true);
        int r113 = this.p;
        if (r113 == 0) goto L126;
        r28 = r113;
    L126:
        r112.setState(r28);
    L127:
        this.p = 0;
        return;
    L113:
        if (this.d == false) goto L123;
        if (r110 == false) goto L123;
        r112.setSkipCollapsed(this.h);
        int r114 = this.p;
        if (r114 == 0) goto L119;
        r28 = r114;
    L122:
        r112.setState(r28);
        goto L127
    L119:
        if (b() == true) goto L122;
        r28 = 4;
        goto L122
    L98:
        if (getMeasuredHeight() < this.s.c) goto L100;
        r110 = true;
        goto L101
    L87:
        if (r26 == Style.HALF_STACK) goto L89;
    L93:
        r27 = r24;
        goto L95
    L89:
        if (this.d == true) goto L93;
        if (b() == false) goto L93;
    L79:
        if (this.o != Style.HALF_STACK) goto L83;
        if (this.d == false) goto L83;
        r24 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(this.g + getSystemBarsTop(), r1), 1073741824);
        goto L84
    L28:
        r7 = r1;
        goto L29
    L18:
        if (this.d != r6) goto L21;
        r11 = false;
        goto L22
    L14:
        r5 = false;
    L10:
        r4 = r0;
        goto L12
    L130:
        setMeasuredDimension(r0, r1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3, int r4, ViewGroup.LayoutParams r5) {
        if ((r5 instanceof FrameLayout.LayoutParams) == false) goto L5;
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5;
    L6:
        if (r6 != null) goto L8;
        Log.e("FST_StackViewGroup", "params convert to LayoutParams returns null, set center gravity failed.");
    L9:
        super.addView(r3, r4, r6);
        return;
    L8:
        r6.gravity = 17;
        goto L9
    L5:
        r6 = null;
        goto L6
    }
}
