package com.bytedance.android.ec.common.impl.sku.view;

import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ui.ec.widget.popup.BubblePopupWindow;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f extends BubblePopupWindow {
    public boolean a;
    public int b;
    public final View c;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ Function0 b;

        public a(f r1, Function0 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r10, MotionEvent r11) {
            if (this.a.isOutsideTouchable() == true) goto L26;
            if (r11 == null) goto L17;
            f r12 = this.a;
            float r13 = r11.getX(0);
            float r14 = r11.getY(0);
            if (r13 <= (r12.b + vf4.a.b(26))) goto L8;
        L14:
            boolean r15 = false;
        L15:
            if (r15 == false) goto L17;
            this.b.invoke();
            goto L26
        L8:
            if (r13 < (r12.b - vf4.a.b(4))) goto L14;
            if (r14 > 0) goto L14;
            if (r14 < vf4.a.b(-28)) goto L14;
            r15 = true;
        L17:
            if (r11 == null) goto L19;
            float r16 = r11.getY(0);
        L21:
            if (r16 < 0) goto L26;
            View r17 = this.a.getContentView();
            if (r17 == null) goto L26;
            r17.dispatchTouchEvent(r11);
            goto L26
        L19:
            r16 = 0.0f;
        L26:
            if (this.a.isFocusable() == true) goto L28;
        L30:
            return false;
        L28:
            if (this.a.isOutsideTouchable() == true) goto L30;
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        StackTraceElement[] r0 = new Exception().getStackTrace();
        if (r0.length >= 2) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("dispatchKeyEvent", r0[1].getMethodName()) == true) goto L7;
        return;
    L7:
        if (this.c.isAttachedToWindow() == false) goto L12;
        if (isShowing() == false) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L12:
        if (isShowing() == false) goto L18;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    }

    public f(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super(ExtKt.getActivity(r10), false, false);
        this.c = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View r19, String r20, Function0<Unit> r21, Function0<Unit> r22, Function0<Unit> r23) {
        Intrinsics.checkNotNullParameter(r19, "parent");
        Intrinsics.checkNotNullParameter(r21, "addCartListener");
        Intrinsics.checkNotNullParameter(r22, "stopRemindListener");
        Intrinsics.checkNotNullParameter(r23, "closeFragmentListener");
        setFocusable(true);
        setOutsideTouchable(false);
        setBackgroundDrawable(new ColorDrawable(0));
        LinearLayout r10 = new LinearLayout(this.c.getContext());
        r10.setOrientation(1);
        r10.setGravity(17);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-2, vf4.a.b(74)));
        TextView r11 = new TextView(this.c.getContext());
        r11.setText(r20);
        r11.setGravity(17);
        r11.setTextSize(13.0f);
        r11.setTextColor(-1);
        r11.setMaxLines(1);
        r11.setEllipsize(TextUtils.TruncateAt.END);
        com.bytedance.android.shopping.extensions.f.e(r11, 500);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r11.setMaxWidth(UIUtils.getScreenWidth(r11.getContext()) - ((int) UIUtils.dip2Px(r11.getContext(), 42.0f)));
        r10.addView(r11);
        LinearLayout r12 = new LinearLayout(this.c.getContext());
        r12.setOrientation(0);
        r12.setGravity(17);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r13 = null;
    L5:
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        if (r14 == null) goto L8;
        r14.topMargin = vf4.a.b(8);
        r12.setLayoutParams(r14);
    L8:
        TextView r15 = new TextView(this.c.getContext());
        r15.setText("不再提醒");
        r15.setTextSize(12.0f);
        r15.setGravity(17);
        r15.setTextColor(-1);
        com.bytedance.android.shopping.extensions.f.e(r15, 500);
        r15.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(78), vf4.a.b(23)));
        r15.setBackground(com.bytedance.commerce.base.drawable.a.a(SkuBubblePopupView$initView$stopRemindButton$1$1.INSTANCE));
        r15.setOnTouchListener(new e(r15));
        r15.setOnClickListener(new b(r22));
        TextView r1 = new TextView(this.c.getContext());
        r1.setText("加入购物车");
        r1.setTextSize(12.0f);
        r1.setTextColor(-1);
        r1.setGravity(17);
        com.bytedance.android.shopping.extensions.f.e(r1, 500);
        r1.setLayoutParams(new ViewGroup.LayoutParams(vf4.a.b(78), vf4.a.b(24)));
        r1.setBackground(com.bytedance.commerce.base.drawable.a.a(SkuBubblePopupView$initView$addCartButton$1$1.INSTANCE));
        r1.setOnTouchListener(new d(r1));
        r1.setOnClickListener(new c(r21));
        r12.addView(r15);
        FrameLayout r0 = new FrameLayout(this.c.getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(vf4.a.b(8), -2));
        Unit r16 = Unit.INSTANCE;
        r12.addView(r0);
        r12.addView(r1);
        r10.addView(r12);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L11
        setBubbleView(r10, Boolean.TRUE);     // Catch: Throwable -> L11
        setArrowVerticalSize(7);     // Catch: Throwable -> L11
        setArrowLongSize(20);     // Catch: Throwable -> L11
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r24 = Result.exceptionOrNull-impl(r18);
        if (r24 == null) goto L16;
        ECExceptionMonitor.e(r24);
    L16:
        r10.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        setAutoDismissDelayMillis(0);
        this.b = r10.getMeasuredWidth();
        setTouchInterceptor(new a(this, r23));
        setBgColor(ColorProtector.parseColor("#393B44"));
        setNeedPath(false);
        setInAnimTime(100);
        setShadowLayerYOffset(4);
        setShowOutAnim(false);
        setShadowLayerColor(0);
        setHorizontalPadding(12);
        show(r19, (int) ((r10.getMeasuredWidth() / 2.0f) + vf4.a.b(Double.valueOf(3.5d))), -((int) ((r10.getMeasuredWidth() / 2.0f) + vf4.a.b(4))), 0, 80);
        this.a = true;
        return;
    L11:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
