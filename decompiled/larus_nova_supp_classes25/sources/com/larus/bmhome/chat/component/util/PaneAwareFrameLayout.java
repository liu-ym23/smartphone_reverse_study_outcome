package com.larus.bmhome.chat.component.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import ce8.i;
import ce8.j;
import ce8.k;
import ce8.l;
import ce8.m;
import ce8.n;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J0\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\u001c\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u000103H\u0002J \u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0018\u00108\u001a\u00020#2\u0006\u00105\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002R$\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/component/util/PaneAwareFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paneProvider", "Lkotlin/Function0;", "Landroid/view/View;", "getPaneProvider", "()Lkotlin/jvm/functions/Function0;", "setPaneProvider", "(Lkotlin/jvm/functions/Function0;)V", "windowProvider", "Landroid/view/Window;", "getWindowProvider", "setWindowProvider", "maskProvider", "getMaskProvider", "setMaskProvider", "observedPane", "pendingRetryLayout", "", "pendingInitialInsetsAdjust", "initialInsetsPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "initialInsetsViewTreeObserver", "Landroid/view/ViewTreeObserver;", "paneLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "onAttachedToWindow", "", "onDetachedFromWindow", "installInitialInsetsGuard", "removeInitialInsetsPreDrawListener", "applyInitialInsetsAdjust", "ensurePaneObserver", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "resolvePaneGeometry", "Lkotlin/Triple;", "syncWindow", "paneLeft", "paneBottomToRoot", "paneWidth", "syncMask", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PaneAwareFrameLayout extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public Function0<? extends View> a;
    public Function0<? extends Window> b;
    public Function0<? extends View> c;
    public View d;
    public boolean e;
    public boolean f;
    public n g;
    public ViewTreeObserver h;
    public final m i;

    public PaneAwareFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PaneAwareFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        Function0<? extends View> r0 = this.a;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = (View) r0.invoke();
    L6:
        if (r2 != null) goto L8;
    L10:
        r1 = r2;
    L11:
        View r3 = this.d;
        if (r1 != r3) goto L14;
        return;
    L14:
        if (r3 == null) goto L16;
        r3.removeOnLayoutChangeListener(this.i);
    L16:
        this.d = r1;
        if (r1 == null) goto L20;
        r1.addOnLayoutChangeListener(this.i);
        return;
    L20:
        return;
    L8:
        if (r2.isAttachedToWindow() == true) goto L10;
    L5:
        r2 = null;
        goto L6
    }

    public final void c() {
        n r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r1 = this.h;
        if (r1 == null) goto L10;
        boolean r3 = true;
        if (r1.isAlive() != true) goto L10;
    L11:
        if (r3 == false) goto L13;
        r1.removeOnPreDrawListener(r0);
    L13:
        this.g = null;
        this.h = null;
        return;
    L10:
        r3 = false;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View r0 = this.d;
        if (r0 == null) goto L5;
        r0.removeOnLayoutChangeListener(this.i);
    L5:
        this.d = null;
        this.f = false;
        c();
        super.onDetachedFromWindow();
    }

    public final void a() {
        if (isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (this.f == true) goto L8;
        return;
    L8:
        this.f = false;
        WeakHashMap<View, Boolean> r0 = PaneAwareBottomSheetController.d;
        View r1 = this;
    L9:
        View r2 = null;
        if (r1 == null) goto L18;
        if (r1.getId() == 2131368870) goto L19;
        Object r3 = r1.getParent();
        if ((r3 instanceof View) == true) goto L16;
        r1 = null;
        goto L9
    L16:
        r1 = (View) r3;
    L19:
        if (r1 == null) goto L33;
        PaneAwareBottomSheetController.a.b(r1);
        Object r4 = r1.getParent();
        if ((r4 instanceof View) == false) goto L24;
        View r5 = (View) r4;
    L25:
        if (r5 == null) goto L33;
        PaneAwareBottomSheetController.a.b(r5);
        Object r6 = r5.getParent();
        if ((r6 instanceof View) == false) goto L30;
        r2 = (View) r6;
    L30:
        if (r2 == null) goto L33;
        PaneAwareBottomSheetController.a.b(r2);
        goto L33
    L24:
        r5 = null;
    L33:
        requestLayout();
        return;
    L18:
        r1 = null;
        goto L19
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        WeakHashMap<View, Boolean> r0 = PaneAwareBottomSheetController.d;
        View r1 = this;
    L3:
        View r2 = null;
        if (r1 == null) goto L12;
        if (r1.getId() == 2131368870) goto L13;
        Object r3 = r1.getParent();
        if ((r3 instanceof View) == true) goto L10;
        r1 = null;
        goto L3
    L10:
        r1 = (View) r3;
    L13:
        if (r1 == null) goto L35;
        PaneAwareBottomSheetController.a.b(r1);
        WeakHashMap<View, Boolean> r4 = PaneAwareBottomSheetController.d;
        Boolean r5 = r4.get(r1);
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r6) == true) goto L18;
        r4.put(r1, r6);
        ViewCompat.setOnApplyWindowInsetsListener(r1, new i());
    L18:
        Object r7 = r1.getParent();
        if ((r7 instanceof View) == false) goto L21;
        View r8 = (View) r7;
    L22:
        if (r8 == null) goto L35;
        PaneAwareBottomSheetController.a.b(r8);
        if (Intrinsics.areEqual(r4.get(r8), r6) == true) goto L27;
        r4.put(r8, r6);
        ViewCompat.setOnApplyWindowInsetsListener(r8, new i());
    L27:
        Object r9 = r8.getParent();
        if ((r9 instanceof View) == false) goto L30;
        r2 = (View) r9;
    L30:
        if (r2 == null) goto L35;
        PaneAwareBottomSheetController.a.b(r2);
        if (Intrinsics.areEqual(r4.get(r2), r6) == true) goto L35;
        r4.put(r2, r6);
        ViewCompat.setOnApplyWindowInsetsListener(r2, new i());
        goto L35
    L21:
        r8 = null;
    L35:
        ViewCompat.requestApplyInsets(this);
        if (this.f == true) goto L47;
        this.f = true;
        n r10 = new n(this);
        ViewTreeObserver r11 = getViewTreeObserver();
        this.h = r11;
        r11.addOnPreDrawListener(r10);
        this.g = r10;
        post(new j(this));
        return;
    L47:
        return;
    L12:
        r1 = null;
        goto L13
    }

    public final Function0<View> getMaskProvider() {
        return this.c;
    }

    public final Function0<View> getPaneProvider() {
        return this.a;
    }

    public final Function0<Window> getWindowProvider() {
        return this.b;
    }

    public final void setMaskProvider(Function0<? extends View> r1) {
        this.c = r1;
    }

    public final void setPaneProvider(Function0<? extends View> r1) {
        this.a = r1;
    }

    public final void setWindowProvider(Function0<? extends Window> r1) {
        this.b = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        b();
        Function0<? extends View> r0 = this.a;
        if (r0 == null) goto L7;
        View r1 = (View) r0.invoke();
        if (r1 == null) goto L7;
        int r4 = r1.getWidth();
    L8:
        if (r4 <= 0) goto L10;
        r2 = View.MeasureSpec.makeMeasureSpec(r4, 1073741824);
    L10:
        super.onMeasure(r2, r3);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [ce8.m] */
    public PaneAwareFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setFitsSystemWindows(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new l());
        this.i = new m(this);
    }

    public /* synthetic */ PaneAwareFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        super.onLayout(r11, r12, r13, r14, r15);
        b();
        Function0<? extends View> r16 = this.a;
        FrameLayout.LayoutParams r17 = null;
        boolean r18 = false;
        if (r16 == null) goto L28;
        View r19 = (View) r16.invoke();
        if (r19 == null) goto L28;
        int r110 = r19.getWidth();
        int r0 = r19.getHeight();
        if (r110 <= 0) goto L24;
        if (r0 <= 0) goto L24;
        View r1 = r19.getRootView();
        if (r1 == null) goto L28;
        if (r1.getHeight() <= 0) goto L28;
        if (r1.getWidth() <= 0) goto L28;
        WeakHashMap<View, Boolean> r2 = PaneAwareBottomSheetController.d;
        Pair r111 = PaneAwareBottomSheetController.a.c(r19, r1);
        if (r111 == null) goto L28;
        int r3 = ((Number) r111.component1()).intValue();
        int r112 = ((Number) r111.component2()).intValue();
        Triple r4 = new Triple(Integer.valueOf(RangesKt.coerceAtLeast(r3, 0)), Integer.valueOf(RangesKt.coerceAtLeast(r1.getHeight() - (r112 + r0), 0)), Integer.valueOf(r110));
    L29:
        if (r4 != null) goto L31;
        return;
    L31:
        int r113 = ((Number) r4.component1()).intValue();
        int r114 = ((Number) r4.component2()).intValue();
        int r5 = ((Number) r4.component3()).intValue();
        Function0<? extends Window> r6 = this.b;
        if (r6 == null) goto L51;
        Window r7 = (Window) r6.invoke();
        if (r7 == null) goto L51;
        WindowManager.LayoutParams r8 = r7.getAttributes();
        if (r8.width == r5) goto L39;
    L48:
        boolean r9 = true;
    L49:
        if (r9 == false) goto L51;
        StringBuilder r10 = new StringBuilder();
        r10.append(r8.width);
        r10.append(',');
        r10.append(r8.height);
        r10.append(',');
        r10.append(r8.x);
        r10.append(',');
        r10.append(r8.y);
        r10.append(',');
        r10.append(r8.gravity);
        String r20 = r10.toString();
        r8.width = r5;
        r8.height = -2;
        r8.gravity = 8388691;
        r8.x = r113;
        r8.y = r114;
        r7.setAttributes(r8);
        FLogger.a.d("PaneAwareBSC", "syncWindow: " + r20 + " -> " + r5 + ",-2," + r113 + ',' + r114 + ",8388691");
        goto L51
    L39:
        if (r8.height != (-2)) goto L48;
        if (r8.x != r113) goto L48;
        if (r8.y != r114) goto L48;
        if (r8.gravity != 8388691) goto L48;
        r9 = false;
    L51:
        Function0<? extends View> r115 = this.c;
        if (r115 == null) goto L71;
        View r116 = (View) r115.invoke();
        if (r116 == null) goto L73;
        ViewGroup.LayoutParams r21 = r116.getLayoutParams();
        if ((r21 instanceof FrameLayout.LayoutParams) == false) goto L59;
        r17 = (FrameLayout.LayoutParams) r21;
    L59:
        if (r17 != null) goto L62;
        return;
    L62:
        if (r17.width == r5) goto L64;
    L67:
        r18 = true;
    L68:
        if (r18 == false) goto L72;
        StringBuilder r117 = new StringBuilder();
        r117.append(r17.width);
        r117.append(',');
        r117.append(r17.height);
        r117.append(',');
        r117.append(r17.leftMargin);
        String r118 = r117.toString();
        r17.width = r5;
        r17.height = -1;
        r17.leftMargin = r113;
        r17.gravity = 8388659;
        r116.setLayoutParams(r17);
        FLogger.a.d("PaneAwareBSC", "syncMask: (w,h,left) " + r118 + " -> " + r5 + ",MATCH_PARENT," + r113);
        return;
    L72:
        return;
    L64:
        if (r17.leftMargin != r113) goto L67;
        if (r17.height == (-1)) goto L68;
    L73:
        return;
    L71:
        return;
    L24:
        if (r19.isLaidOut() == true) goto L28;
        if (this.e == true) goto L28;
        this.e = true;
        r19.post(new k(this));
    L28:
        r4 = null;
        goto L29
    }
}
