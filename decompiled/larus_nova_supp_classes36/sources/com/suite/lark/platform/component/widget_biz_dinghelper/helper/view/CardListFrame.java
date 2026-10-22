package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000 \u007f2\u00020\u0001:\u0001\u007fB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;J\u0016\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020\nJ\u0014\u00109\u001a\u00020\u000e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0=J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;J\u0006\u0010?\u001a\u00020\u000eJ\u000e\u0010@\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;J\u0006\u0010A\u001a\u00020\u000eJ\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010C\u001a\u00020\u000eJ\u0006\u0010D\u001a\u00020\u000eJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020\nJ\u0006\u0010H\u001a\u00020\nJ\u0006\u0010I\u001a\u00020\u000eJ\u0006\u0010J\u001a\u00020\u000eJ\u0018\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\nH\u0014J0\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020\nH\u0014J\b\u0010V\u001a\u00020\u000eH\u0014J\b\u0010W\u001a\u00020\u000eH\u0016J\b\u0010]\u001a\u00020\u000eH\u0002J\u0010\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u000203H\u0002J\b\u0010`\u001a\u00020\u000eH\u0002J\b\u0010a\u001a\u00020\u000eH\u0002J\u0018\u0010b\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010c\u001a\u00020\u000eJ\b\u0010d\u001a\u00020\u000eH\u0003J\b\u0010e\u001a\u00020\u000eH\u0002J\b\u0010f\u001a\u00020\u000eH\u0002J\b\u0010g\u001a\u00020\u000eH\u0002R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R7\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010h\u001a\u00020i8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bj\u0010kR\u001b\u0010n\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010m\u001a\u0004\bp\u0010qR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010m\u001a\u0004\bt\u0010qR\u001b\u0010v\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010m\u001a\u0004\bw\u0010qR\u001b\u0010y\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010m\u001a\u0004\bz\u0010qR\u001b\u0010|\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010m\u001a\u0004\b}\u0010q¨\u0006\u0080\u0001"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardListFrame;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onClearClick", "Lkotlin/Function0;", "", "getOnClearClick", "()Lkotlin/jvm/functions/Function0;", "setOnClearClick", "(Lkotlin/jvm/functions/Function0;)V", "onExpand", "getOnExpand", "setOnExpand", "onEllipsize", "getOnEllipsize", "setOnEllipsize", "onCardClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "getOnCardClick", "()Lkotlin/jvm/functions/Function1;", "setOnCardClick", "(Lkotlin/jvm/functions/Function1;)V", "onTopCardClick", "getOnTopCardClick", "setOnTopCardClick", "onTopCardMovedOut", "getOnTopCardMovedOut", "setOnTopCardMovedOut", "onCardViewRemoved", "getOnCardViewRemoved", "setOnCardViewRemoved", "actionLayout", "Landroid/widget/LinearLayout;", "actionLayoutBottom", "cardList", "Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/CardListLayout;", "cardScrollView", "Landroid/widget/ScrollView;", "clearButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "clearButtonBottom", "ellipsizeButton", "ellipsizeButtonBottom", "topCardContainer", "Lcom/suite/lark/platform/component/widget_biz_dinghelper/helper/view/TopCardContainer;", "addCardView", "view", "Landroid/view/View;", "views", "", "addTopCardView", "clearTopCardView", "replaceTopCardView", "removeFirstCardView", "removeCardViewAt", "removeAllCardViews", "removeTopCardViewNoAnim", "hasCardView", "", "cardCount", "bannerCount", "expand", "ellipsize", "maxWidth", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "left", "top", "right", "bottom", "firstLayoutAfterAttachToWindow", "onDetachedFromWindow", "requestLayout", "clearState", "bottomClearState", "reInitClearButtonCallback", "Ljava/lang/Runnable;", "reInitBottomClearButtonCallback", "initViews", "initClearButton", "button", "initEllipsizeButton", "initButtonColors", "onCardViewClicked", "release", "settleTopView", "removeTopCardViews", "ensureActionLayoutState", "onRemoveCardAnimEnd", "addTransition", "Landroidx/transition/Transition;", "getAddTransition", "()Landroidx/transition/Transition;", "addTransition$delegate", "Lkotlin/Lazy;", "transition", "Landroidx/transition/TransitionSet;", "getTransition", "()Landroidx/transition/TransitionSet;", "transition$delegate", "removeCardTransition", "getRemoveCardTransition", "removeCardTransition$delegate", "addTopCardTransition", "getAddTopCardTransition", "addTopCardTransition$delegate", "fadeOutTopCardTransition", "getFadeOutTopCardTransition", "fadeOutTopCardTransition$delegate", "removeTopCardTransition", "getRemoveTopCardTransition", "removeTopCardTransition$delegate", "Companion", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CardListFrame extends FrameLayout {
    public final Lazy A;
    public final Lazy B;
    public Function0<Unit> a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public Function1<? super Integer, Unit> d;
    public Function0<Unit> e;
    public Function0<Unit> f;
    public Function0<Unit> g;
    public LinearLayout h;
    public LinearLayout i;
    public CardListLayout j;
    public ScrollView k;
    public UDButton l;
    public UDButton m;
    public UDButton n;
    public UDButton o;
    public TopCardContainer p;
    public final int q;
    public boolean r;
    public int s;
    public int t;
    public final h u;
    public final g v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CardListFrame a;

        public b(CardListFrame r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.d();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CardListFrame a;

        public c(CardListFrame r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.d();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CardListFrame a;

        public d(CardListFrame r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CardListFrame r6 = this.a;
            int r0 = r6.s;
            if (r0 == 0) goto L10;
            if (r0 != 1) goto L26;
            Function0<Unit> r7 = r6.getOnClearClick();
            if (r7 == null) goto L9;
            r7.invoke();
        L9:
            this.a.d();
            return;
        L26:
            return;
        L10:
            LinearLayout r8 = r6.h;
            Button r1 = null;
            if (r8 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
            r8 = null;
        L13:
            TransitionManager.beginDelayedTransition(r8);
            Button r9 = this.a.l;
            if (r9 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            r9 = null;
        L16:
            r9.setText(2131892373);
            UDButton r10 = this.a.l;
            if (r10 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            r10 = null;
        L19:
            r10.applyStyle(2131953832);
            Button r11 = this.a.l;
            if (r11 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        L23:
            r1.setTextColor(UDColorUtils.getColor(this.a.getContext(), 2131106622));
            CardListFrame r12 = this.a;
            r12.s = 1;
            r12.postDelayed(r12.u, 5000);
            return;
        L22:
            r1 = r11;
            goto L23
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ CardListFrame a;

        public e(CardListFrame r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            CardListFrame r6 = this.a;
            int r0 = r6.t;
            if (r0 == 0) goto L10;
            if (r0 != 1) goto L26;
            Function0<Unit> r7 = r6.getOnClearClick();
            if (r7 == null) goto L9;
            r7.invoke();
        L9:
            this.a.d();
            return;
        L26:
            return;
        L10:
            LinearLayout r8 = r6.i;
            Button r1 = null;
            if (r8 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");
            r8 = null;
        L13:
            TransitionManager.beginDelayedTransition(r8);
            Button r9 = this.a.m;
            if (r9 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
            r9 = null;
        L16:
            r9.setText(2131892373);
            UDButton r10 = this.a.m;
            if (r10 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
            r10 = null;
        L19:
            r10.applyStyle(2131953832);
            Button r11 = this.a.m;
            if (r11 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        L23:
            r1.setTextColor(UDColorUtils.getColor(this.a.getContext(), 2131106622));
            CardListFrame r12 = this.a;
            r12.t = 1;
            r12.postDelayed(r12.v, 5000);
            return;
        L22:
            r1 = r11;
            goto L23
        }
    }

    public static final class f implements TopCardContainer.a {
        public final /* synthetic */ CardListFrame a;

        @Override // com.suite.lark.platform.component.widget_biz_dinghelper.helper.view.TopCardContainer.a
        public final void a() {
            TopCardContainer r0 = this.a.p;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
            r0 = null;
        L5:
            int r1 = r0.getChildCount();
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L8;
            r0.getChildAt(r2).setVisibility(4);
            r2 = r2 + 1;
            goto L6
        L8:
            Function0<Unit> r3 = this.a.getOnTopCardMovedOut();
            if (r3 == null) goto L13;
            r3.invoke();
            return;
        }

        public f(CardListFrame r1) {
            this.a = r1;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CardListFrame a;

        public g(CardListFrame r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardListFrame r0 = this.a;     // Catch: Throwable -> L11
            r0.t = 0;     // Catch: Throwable -> L11
            LinearLayout r1 = r0.i;     // Catch: Throwable -> L11
            UDButton r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");     // Catch: Throwable -> L11
            r1 = null;
        L5:
            TransitionManager.beginDelayedTransition(r1);     // Catch: Throwable -> L11
            CardListFrame r3 = this.a;     // Catch: Throwable -> L11
            UDButton r4 = r3.m;     // Catch: Throwable -> L11
            if (r4 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");     // Catch: Throwable -> L11
        L9:
            r3.f(r2);     // Catch: Throwable -> L11
            return;
        L8:
            r2 = r4;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ CardListFrame a;

        public h(CardListFrame r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardListFrame r0 = this.a;     // Catch: Throwable -> L11
            r0.s = 0;     // Catch: Throwable -> L11
            LinearLayout r1 = r0.h;     // Catch: Throwable -> L11
            UDButton r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("actionLayout");     // Catch: Throwable -> L11
            r1 = null;
        L5:
            TransitionManager.beginDelayedTransition(r1);     // Catch: Throwable -> L11
            CardListFrame r3 = this.a;     // Catch: Throwable -> L11
            UDButton r4 = r3.l;     // Catch: Throwable -> L11
            if (r4 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");     // Catch: Throwable -> L11
        L9:
            r3.f(r2);     // Catch: Throwable -> L11
            return;
        L8:
            r2 = r4;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    static {
    }

    private final TransitionSet getAddTopCardTransition() {
        return (TransitionSet) this.z.getValue();
    }

    private final Transition getAddTransition() {
        return (Transition) this.w.getValue();
    }

    private final TransitionSet getFadeOutTopCardTransition() {
        return (TransitionSet) this.A.getValue();
    }

    private final TransitionSet getRemoveCardTransition() {
        return (TransitionSet) this.y.getValue();
    }

    private final TransitionSet getRemoveTopCardTransition() {
        return (TransitionSet) this.B.getValue();
    }

    private final TransitionSet getTransition() {
        return (TransitionSet) this.x.getValue();
    }

    public final void d() {
        CardListLayout r0 = this.j;
        Button r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r0 = null;
    L6:
        if (r0.a == true) goto L8;
        return;
    L8:
        ScrollView r1 = this.k;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r1 = null;
    L11:
        TransitionManager.beginDelayedTransition(r1, getTransition());
        CardListLayout r3 = this.j;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r3 = null;
    L14:
        r3.a = false;
        r3.T5();
        LinearLayout r4 = this.h;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
        r4 = null;
    L17:
        r4.setVisibility(8);
        Function0<Unit> r5 = this.c;
        if (r5 == null) goto L20;
        r5.invoke();
    L20:
        setOnClickListener(null);
        setClickable(false);
        UDButton r6 = this.l;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r6 = null;
    L23:
        f(r6);
        this.s = 0;
        Button r7 = this.l;
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r7 = null;
    L26:
        r7.removeCallbacks(this.u);
        UDButton r8 = this.m;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r8 = null;
    L29:
        f(r8);
        this.t = 0;
        Button r9 = this.m;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
    L33:
        r2.removeCallbacks(this.v);
        return;
    L32:
        r2 = r9;
        goto L33
    }

    public final void e() {
        Button r0 = this.n;
        UDButton r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r0 = null;
    L5:
        r0.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        UDButton r1 = this.n;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r1 = null;
    L8:
        r1.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), 2131100551));
        UDButton r3 = this.n;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r3 = null;
    L11:
        r3.setStrokeColor(UDColorUtils.getColorStateList(getContext(), 2131103351));
        Button r4 = this.o;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r4 = null;
    L14:
        r4.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        UDButton r5 = this.o;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r5 = null;
    L17:
        r5.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), 2131100551));
        UDButton r6 = this.o;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r6 = null;
    L20:
        r6.setStrokeColor(UDColorUtils.getColorStateList(getContext(), 2131103351));
        Button r7 = this.l;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r7 = null;
    L23:
        r7.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        UDButton r8 = this.l;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r8 = null;
    L26:
        r8.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), 2131100551));
        UDButton r9 = this.l;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r9 = null;
    L29:
        r9.setStrokeColor(UDColorUtils.getColorStateList(getContext(), 2131103351));
        Button r10 = this.m;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r10 = null;
    L32:
        r10.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        UDButton r11 = this.m;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r11 = null;
    L35:
        r11.setBackgroundColor(UDColorUtils.getColorStateList(getContext(), 2131100551));
        UDButton r12 = this.m;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
    L39:
        r2.setStrokeColor(UDColorUtils.getColorStateList(getContext(), 2131103351));
        return;
    L38:
        r2 = r12;
        goto L39
    }

    public final void g() {
        this.h = (LinearLayout) findViewById(2131362103);
        this.i = (LinearLayout) findViewById(2131362104);
        this.j = (CardListLayout) findViewById(2131365186);
        this.k = (ScrollView) findViewById(2131365212);
        this.l = findViewById(2131366937);
        this.m = findViewById(2131366938);
        this.n = findViewById(2131371517);
        this.o = findViewById(2131371518);
        this.p = (TopCardContainer) findViewById(2131386683);
        CardListLayout r0 = this.j;
        TopCardContainer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r0 = null;
    L5:
        r0.setChildrenOnClickListener(new CardListFrame$initViews$1(this));
        Button r2 = this.n;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r2 = null;
    L8:
        r2.setOnClickListener(new b(this));
        Button r3 = this.o;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
        r3 = null;
    L11:
        r3.setOnClickListener(new c(this));
        UDButton r4 = this.l;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r4 = null;
    L14:
        f(r4);
        UDButton r5 = this.m;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r5 = null;
    L17:
        f(r5);
        e();
        Button r6 = this.l;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r6 = null;
    L20:
        r6.setOnClickListener(new d(this));
        Button r7 = this.m;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("clearButtonBottom");
        r7 = null;
    L23:
        r7.setOnClickListener(new e(this));
        TopCardContainer r8 = this.p;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
    L27:
        r1.setOnTopCardMoveOutListener(new f(this));
        return;
    L26:
        r1 = r8;
        goto L27
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (this.r == false) goto L9;
        this.r = false;
        TopCardContainer r0 = this.p;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r0 = null;
    L7:
        r0.requestLayout();
        return;
    }

    public final Function1<Integer, Unit> getOnCardClick() {
        return this.d;
    }

    public final Function0<Unit> getOnCardViewRemoved() {
        return this.g;
    }

    public final Function0<Unit> getOnClearClick() {
        return this.a;
    }

    public final Function0<Unit> getOnEllipsize() {
        return this.c;
    }

    public final Function0<Unit> getOnExpand() {
        return this.b;
    }

    public final Function0<Unit> getOnTopCardClick() {
        return this.e;
    }

    public final Function0<Unit> getOnTopCardMovedOut() {
        return this.f;
    }

    public CardListFrame(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LayoutInflater.from(getContext()).inflate(2131559256, this, true);
        g();
        this.q = (int) new UDDimension.Dp(360).toPixels(getContext());
        this.u = new h(this);
        this.v = new g(this);
        this.w = LazyKt.lazy(new CardListFrame$addTransition$2(this));
        this.x = LazyKt.lazy(new CardListFrame$transition$2(this));
        this.y = LazyKt.lazy(new CardListFrame$removeCardTransition$2(this));
        this.z = LazyKt.lazy(new CardListFrame$addTopCardTransition$2(this));
        this.A = LazyKt.lazy(new CardListFrame$fadeOutTopCardTransition$2(this));
        this.B = LazyKt.lazy(new CardListFrame$removeTopCardTransition$2(this));
    }

    public static final void b(CardListFrame r3) {
        ScrollView r0 = r3.k;
        TopCardContainer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r0 = null;
    L5:
        TransitionManager.beginDelayedTransition(r0, r3.getRemoveTopCardTransition());
        TopCardContainer r4 = r3.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
    L9:
        r1.removeAllViews();
        return;
    L8:
        r1 = r4;
        goto L9
    }

    public static final void c(CardListFrame r5) {
        TopCardContainer r0 = r5.p;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r0 = null;
    L6:
        if (r0.getChildCount() == 0) goto L24;
        TopCardContainer r1 = r5.p;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r1 = null;
    L11:
        TopCardContainer r3 = r5.p;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r3 = null;
    L14:
        final View r2 = r1.getChildAt(r3.getChildCount() - 1);
        TopCardContainer r4 = r5.p;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r4 = null;
    L17:
        Iterator r6 = SequencesKt.filter(ViewGroupKt.getChildren(r4), new CardListFrame$settleTopView$1(r2)).iterator();
    L19:
        if (r6.hasNext() == false) goto L28;
        View r7 = (View) r6.next();
        TopCardContainer r8 = r5.p;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
        r8 = null;
    L23:
        r8.removeView(r7);
        goto L19
    L28:
        return;
    }

    public final void f(UDButton r5) {
        com.larksuite.component.universe_design.button.e.e(r5, UDIconUtils.getIconDrawable(getContext(), 2131254123, UDColorUtils.getColor(getContext(), 2131102419), new UDDimension.Dp(18)), CardListFrame$initClearButton$1.INSTANCE);
        r5.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        int r0 = (int) new UDDimension.Dp(36).toPixels(getContext());
        r6.width = r0;
        r6.height = r0;
    }

    public final void setOnCardClick(Function1<? super Integer, Unit> r1) {
        this.d = r1;
    }

    public final void setOnCardViewRemoved(Function0<Unit> r1) {
        this.g = r1;
    }

    public final void setOnClearClick(Function0<Unit> r1) {
        this.a = r1;
    }

    public final void setOnEllipsize(Function0<Unit> r1) {
        this.c = r1;
    }

    public final void setOnExpand(Function0<Unit> r1) {
        this.b = r1;
    }

    public final void setOnTopCardClick(Function0<Unit> r1) {
        this.e = r1;
    }

    public final void setOnTopCardMovedOut(Function0<Unit> r1) {
        this.f = r1;
    }

    public CardListFrame(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(getContext()).inflate(2131559256, this, true);
        g();
        this.q = (int) new UDDimension.Dp(360).toPixels(getContext());
        this.u = new h(this);
        this.v = new g(this);
        this.w = LazyKt.lazy(new CardListFrame$addTransition$2(this));
        this.x = LazyKt.lazy(new CardListFrame$transition$2(this));
        this.y = LazyKt.lazy(new CardListFrame$removeCardTransition$2(this));
        this.z = LazyKt.lazy(new CardListFrame$addTopCardTransition$2(this));
        this.A = LazyKt.lazy(new CardListFrame$fadeOutTopCardTransition$2(this));
        this.B = LazyKt.lazy(new CardListFrame$removeTopCardTransition$2(this));
    }

    public static final void a(CardListFrame r4, int r5) {
        ConstraintLayout r0 = r4.j;
        Button r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r0 = null;
    L6:
        if (r0.getChildCount() <= 1) goto L38;
        CardListLayout r2 = r4.j;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r2 = null;
    L11:
        if (r2.a == true) goto L38;
        CardListLayout r6 = r4.j;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r6 = null;
    L16:
        if (r6.a == true) goto L44;
        ScrollView r7 = r4.k;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r7 = null;
    L21:
        TransitionManager.beginDelayedTransition(r7, r4.getTransition());
        CardListLayout r8 = r4.j;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r8 = null;
    L24:
        r8.a = true;
        r8.R5();
        r8.T5();
        LinearLayout r9 = r4.h;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayout");
        r9 = null;
    L27:
        r9.setVisibility(0);
        r4.setOnClickListener(new com.suite.lark.platform.component.widget_biz_dinghelper.helper.view.b(r4));
        Function0<Unit> r10 = r4.b;
        if (r10 == null) goto L30;
        r10.invoke();
    L30:
        Button r11 = r4.n;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButton");
        r11 = null;
    L33:
        r11.setText(2131892374);
        Button r12 = r4.o;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("ellipsizeButtonBottom");
    L37:
        r1.setText(2131892374);
        r4.e();
        return;
    L36:
        r1 = r12;
        goto L37
    L44:
        return;
    L38:
        Function1<? super Integer, Unit> r13 = r4.d;
        if (r13 == null) goto L43;
        r13.invoke(Integer.valueOf(r5));
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        int r1 = View.MeasureSpec.getSize(r6);
        int r2 = j08.b.d(getContext(), r0);
        int r3 = j08.b.d(getContext(), r1);
        ScrollView r4 = this.k;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r4 = null;
    L5:
        ViewGroup.LayoutParams r7 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
        if (r3 >= 480) goto L9;
        r8.width = this.q;
        r8.gravity = 1;
    L12:
        super.onMeasure(r5, r6);
        return;
    L9:
        if (r2 < 600) goto L11;
        r8.width = this.q;
        r8.gravity = 5;
        goto L12
    L11:
        r8.width = -1;
        r8.gravity = 8388659;
        goto L12
    }

    public CardListFrame(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(getContext()).inflate(2131559256, this, true);
        g();
        this.q = (int) new UDDimension.Dp(360).toPixels(getContext());
        this.u = new h(this);
        this.v = new g(this);
        this.w = LazyKt.lazy(new CardListFrame$addTransition$2(this));
        this.x = LazyKt.lazy(new CardListFrame$transition$2(this));
        this.y = LazyKt.lazy(new CardListFrame$removeCardTransition$2(this));
        this.z = LazyKt.lazy(new CardListFrame$addTopCardTransition$2(this));
        this.A = LazyKt.lazy(new CardListFrame$fadeOutTopCardTransition$2(this));
        this.B = LazyKt.lazy(new CardListFrame$removeTopCardTransition$2(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        ConstraintLayout r6 = this.j;
        LinearLayout r7 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardList");
        r6 = null;
    L5:
        int r8 = r6.getHeight();
        ScrollView r9 = this.k;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("cardScrollView");
        r9 = null;
    L9:
        if (r8 <= r9.getHeight()) goto L15;
        LinearLayout r10 = this.i;
        if (r10 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");
    L14:
        r7.setVisibility(0);
        return;
    L13:
        r7 = r10;
        goto L14
    L15:
        LinearLayout r11 = this.i;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("actionLayoutBottom");
    L19:
        r7.setVisibility(8);
        return;
    L18:
        r7 = r11;
        goto L19
    }
}
