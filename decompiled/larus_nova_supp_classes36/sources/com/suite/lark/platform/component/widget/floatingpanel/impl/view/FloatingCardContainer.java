package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OneShotPreDrawListener;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 V2\u00020\u0001:\u0002VWB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)J2\u0010*\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010&2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010-2\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J&\u0010.\u001a\u00020!2\u001e\u0010/\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0-0100J\u000e\u00102\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0014\u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00020)00J\u0006\u00105\u001a\u00020!J \u00106\u001a\u00020!2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0002J\u0006\u00109\u001a\u00020!J\u0006\u0010:\u001a\u00020!J\b\u0010;\u001a\u00020!H\u0002J\u0006\u0010<\u001a\u00020!J\u0012\u0010=\u001a\u00020!2\b\b\u0002\u0010>\u001a\u00020\u001bH\u0002J\u0012\u0010?\u001a\u00020!2\b\b\u0002\u0010>\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020!H\u0002J\u0006\u0010A\u001a\u00020\u001bJ\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000700J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000700J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000700J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0014J\u0018\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0014J0\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0007H\u0014J\u0012\u0010Q\u001a\u00020\u001b2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\u0012\u0010T\u001a\u00020S2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010U\u001a\u00020SH\u0014J\u0012\u0010T\u001a\u00020S2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006X"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipsizeBottomMargin", "ellipsizedHorizontalMargin", "minCardHeight", "totalCreatedCardCount", "onFloatingCardClickListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;", "getOnFloatingCardClickListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;", "setOnFloatingCardClickListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/OnFloatingCardClickListener;)V", "onExpandStatusChangedListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer$OnExpandStatusChangedListener;", "getOnExpandStatusChangedListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer$OnExpandStatusChangedListener;", "setOnExpandStatusChangedListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardContainer$OnExpandStatusChangedListener;)V", "value", "", "isExpanded", "()Z", "setExpanded", "(Z)V", "bindToScrollView", "", "scrollView", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelScrollView;", "addCard", "cardView", "Landroid/view/View;", "index", "id", "", "createAndAddWrapper", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingCardWrapperView;", "lazyCard", "Lkotlin/Function0;", "refreshCards", "viewItems", "", "Lkotlin/Pair;", "removeCard", "removeCards", "ids", "removeAllCards", "releaseWrappers", "condition", "Lkotlin/Function1;", "expand", "collapse", "countCreatedCardCount", "lazyExpandCardList", "ensureChildrenStatus", "lazyUpdate", "ensureChildrenVisibility", "ensureChildrenTransform", "needAnimationOptimization", "getAnimExceptCardIds", "getCollapsedAnimExceptCardIds", "getOutOfScreenCardIds", "getChildDrawingOrder", "childCount", "drawingPosition", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "generateDefaultLayoutParams", "Companion", "OnExpandStatusChangedListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FloatingCardContainer extends ViewGroup {
    public static final /* synthetic */ int h = 0;
    public final int a;
    public final int b;
    public int c;
    public int d;
    public com.suite.lark.platform.component.widget.floatingpanel.impl.view.e e;
    public b f;
    public boolean g;

    public static final class a {
    }

    public interface b {
        void O9(boolean r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ FloatingCardContainer a;
        public final /* synthetic */ String b;

        public c(FloatingCardContainer r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            com.suite.lark.platform.component.widget.floatingpanel.impl.view.e r0 = this.a.getOnFloatingCardClickListener();
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r3);
            r0.a(r3, this.b);
            return;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ FloatingCardContainer b;

        public d(View r1, FloatingCardContainer r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FloatingCardContainer r0 = this.b;     // Catch: Throwable -> L4
            int r1 = FloatingCardContainer.h;     // Catch: Throwable -> L4
            r0.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ FloatingCardContainer a;

        public e(FloatingCardContainer r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            FloatingCardContainer r10 = this.a;
            int r11 = FloatingCardContainer.h;
            r10.c(false);
        }
    }

    static {
    }

    public FloatingCardContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FloatingCardContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        setExpanded(false);
        if (getChildCount() <= 0) goto L6;
        c(false);
        requestLayout();
        return;
    }

    public final void f() {
        setExpanded(true);
        if (getChildCount() <= 0) goto L6;
        c(g());
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r1, int r2) {
        return (r1 - 1) - r2;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public final void d() {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        int r1 = 0;
        if (this.g == false) goto L11;
        int r0 = getChildCount();
    L8:
        if (r1 >= r0) goto L21;
        View r2 = getChildAt(r1);
        r2.setScaleX(1.0f);
        r2.setScaleY(1.0f);
        r2.setTranslationY(0.0f);
        r1 = r1 + 1;
        goto L8
    L21:
        return;
    L11:
        if (getMeasuredWidth() != 0) goto L14;
        OneShotPreDrawListener.add(this, new d(this, this));
        return;
    L14:
        int r3 = getChildAt(0).getMeasuredHeight();
        int r4 = getChildCount();
    L15:
        if (r1 >= r4) goto L26;
        View r5 = getChildAt(r1);
        float r6 = Math.min(r1, 2);
        float r7 = (getMeasuredWidth() - ((this.b * 2) * r6)) / getMeasuredWidth();
        if (r1 >= 3) goto L19;
        int r8 = Math.min(r3, r5.getMeasuredHeight());
    L20:
        r5.setScaleX(r7);
        r5.setScaleY(r7);
        r5.setTranslationY(((this.a * r6) + (r8 / 2)) - ((r8 * r7) / 2));
        r1 = r1 + 1;
        goto L15
    L19:
        r8 = r5.getMeasuredHeight();
        goto L20
    }

    public final boolean g() {
        if (getChildCount() <= 15) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<Integer> getAnimExceptCardIds() {
        if (g() == false) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount();
        int r2 = 15;
    L7:
        if (r2 >= r1) goto L9;
        r0.add(Integer.valueOf(getChildAt(r2).getId()));
        r2 = r2 + 1;
        goto L7
    L9:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getCollapsedAnimExceptCardIds() {
        if (g() == false) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount();
        int r2 = 4;
    L7:
        if (r2 >= r1) goto L9;
        r0.add(Integer.valueOf(getChildAt(r2).getId()));
        r2 = r2 + 1;
        goto L7
    L9:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<Integer> getOutOfScreenCardIds() {
        if (g() == false) goto L30;
        int r1 = 3;
        if (getChildCount() <= 3) goto L30;
        ArrayList r0 = new ArrayList();
        int[] r3 = new int[2];
        getRootView().getLocationInWindow(r3);
        int r4 = r3[1];
        int r5 = getRootView().getHeight() + r4;
        int[] r2 = new int[2];
        int r6 = getChildCount();
        boolean r8 = false;
    L8:
        if (r1 >= r6) goto L28;
        View r9 = getChildAt(r1);
        if (r8 == false) goto L12;
        r0.add(Integer.valueOf(r9.getId()));
    L27:
        r1 = r1 + 1;
        goto L8
    L12:
        r9.getLocationInWindow(r2);
        int r10 = r2[1];
        int r11 = r9.getHeight() + r10;
        if (r4 > r10) goto L16;
        if (r10 >= r5) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == true) goto L27;
        if (r4 > r11) goto L21;
        if (r11 >= r5) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == true) goto L27;
        if (r10 <= r5) goto L26;
        r8 = true;
    L26:
        r0.add(Integer.valueOf(r9.getId()));
    L21:
        r13 = false;
    L16:
        r12 = false;
        goto L17
    L28:
        return r0;
    L30:
        return CollectionsKt.emptyList();
    }

    public final b getOnExpandStatusChangedListener() {
        return this.f;
    }

    public final com.suite.lark.platform.component.widget.floatingpanel.impl.view.e getOnFloatingCardClickListener() {
        return this.e;
    }

    private final void setExpanded(boolean r5) {
        if (this.g != r5) goto L5;
        return;
    L5:
        this.g = r5;
        if (r5 == false) goto L15;
        int r0 = 0;
        this.d = 0;
        int r1 = getChildCount();
    L8:
        if (r0 >= r1) goto L15;
        View r2 = getChildAt(r0);
        if ((r2 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L14;
        if (((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r2).getChildCount() <= 0) goto L14;
        this.d++;
    L14:
        r0 = r0 + 1;
    L15:
        b r3 = this.f;
        if (r3 == null) goto L23;
        r3.O9(r5);
        return;
    }

    public final void c(boolean r1) {
        e(r1);
        d();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.MarginLayoutParams;
    }

    public final void e(boolean r5) {
        if (this.g == false) goto L10;
        if (r5 == false) goto L6;
        int r6 = 15;
    L7:
        int r0 = 0;
    L8:
        if (r0 >= r6) goto L17;
        getChildAt(r0).setVisibility(0);
        r0 = r0 + 1;
        goto L8
    L17:
        return;
    L6:
        r6 = getChildCount();
        goto L7
    L10:
        int r7 = getChildCount();
        int r1 = 0;
    L11:
        if (r1 >= r7) goto L22;
        View r2 = getChildAt(r1);
        if (r1 >= 3) goto L15;
        int r3 = 0;
    L16:
        r2.setVisibility(r3);
        r1 = r1 + 1;
        goto L11
    L15:
        r3 = 4;
        goto L16
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    public final void h(List<? extends Pair<String, ? extends Function0<? extends View>>> r10) {
        Intrinsics.checkNotNullParameter(r10, "viewItems");
        StringBuilder r0 = new StringBuilder("refreshCards: count: ");
        ArrayList r11 = (ArrayList) r10;
        r0.append(r11.size());
        Log.i("FloatingCardContainer", r0.toString());
        LinkedHashMap r1 = new LinkedHashMap();
        int r2 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        View r4 = getChildAt(r3);
        if ((r4 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L9;
        String r5 = ((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r4).getCardId();
        if (r5 == null) goto L9;
        r1.put(r5, r4);
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        removeAllViews();
        if (r11.size() <= 15) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        setExpanded(false);
    L16:
        Iterator r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L29;
        Pair r7 = (Pair) r12.next();
        String r8 = (String) r7.component1();
        Function0<? extends View> r9 = (Function0) r7.component2();
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r13 = (com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r1.remove(r8);
        if (r13 != null) goto L21;
        if (getChildCount() < 3) goto L27;
        if (r6 == false) goto L27;
        b(null, r9, getChildCount(), r8);
    L27:
        b((View) r9.invoke(), null, getChildCount(), r8);
        goto L18
    L21:
        addView(r13);
        goto L18
    L29:
        if ((!r1.isEmpty()) == false) goto L36;
        Iterator r14 = r1.entrySet().iterator();
    L32:
        if (r14.hasNext() == false) goto L34;
        ((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) ((Map.Entry) r14.next()).getValue()).removeAllViews();
        goto L32
    L34:
        r1.clear();
    L36:
        if (getChildCount() <= 0) goto L59;
        requestLayout();
        View r15 = getChildAt(0);
        if (r15.isLaidOut() == true) goto L40;
    L42:
        r15.addOnLayoutChangeListener(new e(this));
        return;
    L40:
        if (r15.isLayoutRequested() == true) goto L42;
        c(false);
        return;
    L59:
        return;
    L13:
        r6 = false;
        goto L14
    }

    public final void i(Function1<? super com.suite.lark.platform.component.widget.floatingpanel.impl.view.d, Boolean> r4) {
        int r0 = getChildCount();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L12;
        View r1 = getChildAt(r0);
        if ((r1 instanceof com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) == false) goto L3;
        if (r4 != null) goto L9;
    L10:
        ((com.suite.lark.platform.component.widget.floatingpanel.impl.view.d) r1).removeAllViews();
        removeView(r1);
        goto L3
    L9:
        if (((Boolean) r4.invoke(r1)).booleanValue() == false) goto L3;
    }

    public final void setOnExpandStatusChangedListener(b r1) {
        this.f = r1;
    }

    public final void setOnFloatingCardClickListener(com.suite.lark.platform.component.widget.floatingpanel.impl.view.e r1) {
        this.e = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new ViewGroup.MarginLayoutParams(r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r14, int r15) {
        int r0 = View.MeasureSpec.getSize(r14);
        int r2 = 0;
        int r3 = Integer.MAX_VALUE;
        if (this.g == false) goto L11;
        int r1 = getChildCount();
        int r4 = 0;
        int r5 = Integer.MAX_VALUE;
    L5:
        if (r2 >= r1) goto L10;
        View r11 = getChildAt(r2);
        measureChildWithMargins(r11, r14, 0, r15, 0);
        if (r11.getMeasuredHeight() <= 0) goto L9;
        r5 = Math.min(r11.getMeasuredHeight(), r5);
    L9:
        r4 = r4 + r11.getMeasuredHeight();
        r2 = r2 + 1;
        goto L5
    L10:
        setMeasuredDimension(r0, r4);
    L20:
        this.c = r5;
        return;
    L11:
        int r6 = getChildCount();
        int r7 = 0;
        int r8 = 0;
    L12:
        if (r7 >= r6) goto L19;
        View r12 = getChildAt(r7);
        measureChildWithMargins(r12, r14, 0, r15, 0);
        if (r12.getMeasuredHeight() <= 0) goto L16;
        r3 = Math.min(r12.getMeasuredHeight(), r3);
    L16:
        if (r7 != 0) goto L18;
        r8 = r12.getMeasuredHeight();
    L18:
        r7 = r7 + 1;
        goto L12
    L19:
        setMeasuredDimension(r0, r8 + (Math.max(0, Math.min(getChildCount(), 3) - 1) * this.a));
        r5 = r3;
        goto L20
    }

    public FloatingCardContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = UIUtils.dp2px(r2, 8.0f);
        this.b = UIUtils.dp2px(r2, 12.0f);
        setChildrenDrawingOrderEnabled(true);
    }

    public /* synthetic */ FloatingCardContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final com.suite.lark.platform.component.widget.floatingpanel.impl.view.d b(View r3, Function0<? extends View> r4, int r5, String r6) {
        com.suite.lark.platform.component.widget.floatingpanel.impl.view.d r0 = new com.suite.lark.platform.component.widget.floatingpanel.impl.view.d(getContext());
        r0.setCardId(r6);
        if (r3 == null) goto L5;
        r0.a(r3);
    L5:
        if (r4 != null) goto L7;
    L11:
        r0.setOnClickListener(new c(this, r6));
        addView(r0, r5, new ViewGroup.MarginLayoutParams(-1, -2));
        return r0;
    L7:
        if (r5 >= 15) goto L9;
        boolean r7 = true;
    L10:
        r0.c(r4, r7);
        goto L11
    L9:
        r7 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if (this.g == false) goto L10;
        int r8 = getChildCount();
        int r9 = 0;
        int r10 = 0;
    L8:
        if (r9 >= r8) goto L17;
        View r11 = getChildAt(r9);
        r11.layout(0, r10, r11.getMeasuredWidth(), r11.getMeasuredHeight() + r10);
        r10 = r10 + r11.getMeasuredHeight();
        r9 = r9 + 1;
        goto L8
    L17:
        return;
    L10:
        int r12 = getChildAt(0).getMeasuredHeight();
        int r13 = getChildCount();
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L22;
        View r15 = getChildAt(r14);
        if (r14 >= 3) goto L15;
        int r0 = Math.min(r12, r15.getMeasuredHeight());
    L16:
        r15.layout(0, r12 - r0, r15.getMeasuredWidth(), r12);
        r14 = r14 + 1;
        goto L11
    L15:
        r0 = r15.getMeasuredHeight();
        goto L16
    }
}
