package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002&'B)\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001bH\u0014J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\f\u0010#\u001a\u00020\u001b*\u00020\u000bH\u0002J\f\u0010$\u001a\u00020\u001b*\u00020\u000bH\u0002J\f\u0010%\u001a\u00020\u001b*\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelActionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipseButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "clearButton", "isClearConfirming", "", "isExpanded", "()Z", "setExpanded", "(Z)V", "onActionButtonClickedListener", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelActionView$OnActionButtonClickedListener;", "getOnActionButtonClickedListener", "()Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelActionView$OnActionButtonClickedListener;", "setOnActionButtonClickedListener", "(Lcom/suite/lark/platform/component/widget/floatingpanel/impl/view/FloatingPanelActionView$OnActionButtonClickedListener;)V", "resetClearButtonRunnable", "Lkotlin/Function0;", "", "clearConfirmTransition", "Landroidx/transition/TransitionSet;", "onDetachedFromWindow", "setVisibility", "visibility", "cancelAndExecutePendingRunnable", "showClearConfirm", "applyStyle", "showClearIcon", "showConfirmText", "Companion", "OnActionButtonClickedListener", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FloatingPanelActionView extends LinearLayout {
    public static final int f = 0;
    public final UDButton a;
    public boolean b;
    public d c;
    public final Function0<Unit> d;
    public final TransitionSet e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FloatingPanelActionView a;

        public a(FloatingPanelActionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            d r2 = this.a.getOnActionButtonClickedListener();
            if (r2 == null) goto L6;
            r2.a();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ FloatingPanelActionView a;

        public b(FloatingPanelActionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            FloatingPanelActionView r6 = this.a;
            if (r6.b == false) goto L8;
            d r7 = r6.getOnActionButtonClickedListener();
            if (r7 == null) goto L13;
            r7.b();
            return;
        L13:
            return;
        L8:
            TransitionManager.beginDelayedTransition(r6, r6.e);
            r6.b = true;
            Button r0 = r6.a;
            if (r0 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("clearButton");
            r0 = null;
        L11:
            r0.setText(2131892373);
            r0.applyStyle(2131953832);
            r0.setTextColor(UDColorUtils.getColor(r0.getContext(), 2131106622));
            r6.postDelayed(new e(r6.d), 5000);
        }
    }

    public static final class c {
    }

    public interface d {
        void a();

        void b();
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Function0 a;

        public e(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public FloatingPanelActionView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FloatingPanelActionView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setExpanded(boolean r1) {
    }

    static {
        f = UIHelper.dp2px(36.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(new e(this.d));
        this.d.invoke();
    }

    public final d getOnActionButtonClickedListener() {
        return this.c;
    }

    public static void a(UDButton r2) {
        r2.setTextColor(UDColorUtils.getColor(r2.getContext(), 2131106622));
        r2.setBackgroundColor(UDColorUtils.getColorStateList(r2.getContext(), 2131100551));
        r2.setStrokeColor(UDColorUtils.getColorStateList(r2.getContext(), 2131103351));
    }

    public static void b(UDButton r4) {
        com.larksuite.component.universe_design.button.e.e(r4, UDIconUtils.getIconDrawable(r4.getContext(), 2131254123, UDColorUtils.getColor(r4.getContext(), 2131102419), new UDDimension.Dp(18)), FloatingPanelActionView$showClearIcon$1.INSTANCE);
        r4.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        int r1 = f;
        r0.width = r1;
        r0.height = r1;
        r4.setLayoutParams(r0);
    }

    public final void setOnActionButtonClickedListener(d r1) {
        this.c = r1;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        int r0 = getVisibility();
        super.setVisibility(r2);
        if (r0 != 0) goto L7;
        if (r2 == 0) goto L8;
        removeCallbacks(new e(this.d));
        this.d.invoke();
        return;
    L8:
        return;
    }

    public FloatingPanelActionView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.d = new FloatingPanelActionView$resetClearButtonRunnable$1(this);
        this.e = new TransitionSet().addTransition(new ChangeBounds()).setDuration(200);
        LayoutInflater.from(r3).inflate(2131563319, this);
        setOrientation(0);
        setGravity(8388613);
        UDButton r6 = findViewById(2131373006);
        UDButton r7 = findViewById(2131373005);
        this.a = r7;
        a(r6);
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        UDButton r1 = null;
    L6:
        a(r1);
        r6.setText(2131892374);
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        UDButton r2 = null;
    L10:
        b(r2);
        r6.setOnClickListener(new a(this));
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("clearButton");
        r7 = null;
    L13:
        r7.setOnClickListener(new b(this));
        return;
    L9:
        r2 = r7;
        goto L10
    L5:
        r1 = r7;
        goto L6
    }

    public /* synthetic */ FloatingPanelActionView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
