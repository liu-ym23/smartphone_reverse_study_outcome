package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007J\u001c\u0010\u000b\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/view/PaidQueueTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "tab", "", "setCurrentTab", "getSortValueAb", "Lkotlin/Function1;", "tabOnClickListener", "setTabOnClickListener", "listener", "setSortOnClickListener", "setDefaultTab", "Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/ApplyTitlePanelType;", "panelType", "setPanelType", "Lkotlin/Pair;", "pair", "setApplyUserCount", "", "visible", "setQueueSortTypeVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidQueueTabView extends ConstraintLayout {
    public c90.a a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final View e;
    public final TextView f;
    public final ImageView g;
    public Function1<? super Integer, Unit> h;
    public Function1<? super Integer, Unit> i;
    public int j;
    public int k;
    public ApplyTitlePanelType l;
    public Integer m;

    public static final class a {
    }

    static {
    }

    public PaidQueueTabView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PaidQueueTabView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getSortValueAb() {
        return 2131897296;
    }

    private final void setCurrentTab(int r8) {
        String r1 = "#FF161823";
        if (r8 != 2) goto L5;
        String r3 = "#FF161823";
    L7:
        if (r8 == 1) goto L10;
        r1 = "#7F161823";
    L10:
        TextView r2 = this.b;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L13:
        r2.setTextColor(ColorProtector.parseColor(r3));
        TextView r4 = this.c;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L16:
        r4.setTextColor(ColorProtector.parseColor(r1));
        if (r8 != 2) goto L19;
        int r5 = 2131921197;
    L20:
        TextView r6 = this.d;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSortType");
    L23:
        r6.setText(s1.B(r5));
        String r7 = s1.C(2131921161, new Object[]{Integer.valueOf(this.k)});
        String r9 = s1.C(2131921200, new Object[]{Integer.valueOf(this.j)});
        if (2 != r8) goto L32;
        TextView r10 = this.b;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L28:
        r3.a(r10, s1.B(2131915929) + r9);
        TextView r11 = this.c;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L31:
        r3.a(r11, r7);
        return;
    L32:
        TextView r12 = this.b;
        if (r12 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L35:
        r3.a(r12, r9);
        TextView r13 = this.c;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L38:
        r3.a(r13, s1.B(2131915929) + r7);
        return;
    L19:
        r5 = T5(((Number) b6.B.getValue()).intValue());
        goto L20
    L5:
        r3 = "#7F161823";
        goto L7
    }

    public final int T5(int r2) {
        switch(r2) {
            case 40: goto L11;
            case 41: goto L10;
            case 42: goto L6;
            default: goto L11;
        };
    L11:
        return 2131912777;
    L6:
        if (this.l != ApplyTitlePanelType.GUEST_APPLY) goto L8;
        return 2131912774;
    L8:
        return 2131912773;
    L10:
        return getSortValueAb();
    }

    public final void setApplyUserCount(Pair<Integer, Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, "pair");
        this.k = ((Number) r6.getFirst()).intValue();
        this.j = ((Number) r6.getSecond()).intValue();
        TextView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L5:
        r0.setText(s1.C(2131921161, new Object[]{r6.getFirst()}));
        TextView r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L8:
        r1.setText(s1.C(2131921200, new Object[]{r6.getSecond()}));
    }

    public final void setDefaultTab(int r1) {
        setCurrentTab(r1);
    }

    public final void setPanelType(ApplyTitlePanelType r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        this.l = r2;
    }

    public final void setQueueSortTypeVisibility(boolean r3) {
        this.m = (Integer) b6.B.getValue();
        TextView r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSortType");
    L6:
        if (r3 == false) goto L8;
        int r4 = 0;
    L9:
        r0.setVisibility(r4);
        ImageView r5 = this.g;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSortRuleIv");
    L12:
        r5.setVisibility(8);
        return;
    L8:
        r4 = 8;
        goto L9
    }

    public final void setSortOnClickListener(Function1<? super Integer, Unit> r1) {
        this.i = r1;
    }

    public final void setTabOnClickListener(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "tabOnClickListener");
        this.h = r2;
    }

    public static final /* synthetic */ void R5(PaidQueueTabView r0, int r1) {
        r0.setCurrentTab(r1);
    }

    public final void U5(TextView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$updateBubbleSelectUi");
        if (r3 == false) goto L5;
        r2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131251102, 0);
        return;
    L5:
        r2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaidQueueTabView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = ApplyTitlePanelType.UNKNOWN;
        this.m = (Integer) b6.B.getValue();
        LayoutInflater.from(r2).inflate(2131567600, this, true);
        TextView r5 = (TextView) findViewById(2131381837);
        this.b = r5;
        TextView r6 = (TextView) findViewById(2131367566);
        this.c = r6;
        this.d = (TextView) findViewById(2131363196);
        View r7 = findViewById(2131387941);
        this.e = r7;
        this.f = (TextView) findViewById(2131391491);
        this.g = (ImageView) findViewById(2131376569);
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L5:
        r5.setOnClickListener(x0.a(new AnonymousClass1(this)));
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L8:
        r6.setOnClickListener(x0.a(new AnonymousClass2(this)));
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSortContainer");
    L11:
        r7.setOnClickListener(x0.a(new AnonymousClass3(this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final c90.a S5(PaidQueueTabView r19, View r20, int r21) {
        c90.a r0 = r19.a;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        int r10 = s1.f(10.0f);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = null;
        Context r2 = r19.getContext();
        if (r2 == null) goto L20;
        c90.a.a r12 = new c90.a.a((Activity) r2);
        r12.f = false;
        r12.r = true;
        r12.e = -1;
        r12.b = false;
        r12.s = true;
        r12.d = -s1.f(10.0f);
        r12.c = -s1.f(10.0f);
        r12.q = 0.1f;
        r12.p = false;
        r12.h = s1.f(110.0f) + ((int) UIUtils.dip2Px(r12.x, 14.0f));
        r12.a = ColorProtector.parseColor("#FFFFFF");
        um2.a r15 = new um2.a(r19.getContext());
        r15.setOrientation(1);
        r15.setPadding(0, r10, 0, 0);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = null;
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = null;
        PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 r4 = new PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1(r6, r7, r5, r19, r10, r11, r21);
        r15.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(110), -2));
        if (o.k() == false) goto L10;
        TextView r1 = new TextView(r15.getContext());
        r5.element = r1;
        r11.element = r1;
        r1.setText(2131912773);
        r1.setGravity(8388611);
        r1.setTextSize(1, 14.0f);
        r1.setTextColor(ColorProtector.parseColor("#161823"));
        ViewGroup.LayoutParams r13 = new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(100), -2);
        r1.setGravity(8388611);
        r1.setPadding(r10, r10, r10, r10);
        Unit r14 = Unit.INSTANCE;
        r1.setLayoutParams(r13);
        r1.setLines(1);
        r1.setCompoundDrawablePadding(s1.f(5.0f));
        PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 r3 = r4;
        r3.invoke(r21);
        r1.setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.view.a(r3, r19));
        r15.addView(r1);
        View r8 = new View(r15.getContext());
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(1)));
        r8.setBackgroundColor(ColorProtector.parseColor("#E3E3E5"));
        r15.addView(r8);
    L11:
        TextView r9 = new TextView(r15.getContext());
        r9.setText(r19.getSortValueAb());
        r7.element = r9;
        if (((View) r11.element) != null) goto L14;
        r11.element = r9;
    L14:
        r9.setGravity(8388611);
        r9.setTextColor(ColorProtector.parseColor("#161823"));
        r9.setTextSize(1, 14.0f);
        r9.setCompoundDrawablePadding(s1.f(5.0f));
        r3.invoke(r21);
        ViewGroup.LayoutParams r16 = new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(100), -2);
        r9.setGravity(8388611);
        r9.setPadding(r10, r10, r10, r10);
        Unit r17 = Unit.INSTANCE;
        r9.setLayoutParams(r16);
        r9.setLines(1);
        r9.setOnClickListener(new b(r3, r19));
        r15.addView(r9);
        View r18 = (View) r11.element;
        if (r18 == null) goto L17;
        r18.postDelayed(new c(r11), 500);
    L17:
        View r22 = new View(r15.getContext());
        r22.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(1)));
        r22.setBackgroundColor(ColorProtector.parseColor("#E3E3E5"));
        r15.addView(r22);
        TextView r23 = new TextView(r15.getContext());
        r6.element = r23;
        r23.setText(2131912777);
        r23.setGravity(8388611);
        r23.setTextSize(1, 14.0f);
        r23.setTextColor(ColorProtector.parseColor("#161823"));
        ViewGroup.LayoutParams r24 = new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(100), -2);
        r23.setGravity(8388611);
        r23.setPadding(r10, r10, r10, r10);
        r23.setLayoutParams(r24);
        r23.setLines(1);
        r23.setCompoundDrawablePadding(s1.f(5.0f));
        r3.invoke(r19.m.intValue());
        r23.setOnClickListener(new d(r3, r19));
        r15.addView(r23);
        Intrinsics.checkNotNullParameter(r15, "view");
        r12.g = r15;
        c90.a r25 = new c90.a(r12);
        ((LivePopupWindow) r25).b = 10;
        r25.i(r20, 80, true);
        return r25;
    L10:
        r3 = r4;
        goto L11
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public /* synthetic */ PaidQueueTabView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
