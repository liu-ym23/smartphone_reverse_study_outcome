package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/view/GroupTitleLayout;", "Landroid/widget/FrameLayout;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "", "setChartClickListener", "Landroid/widget/TextView;", "c", "Lkotlin/Lazy;", "getGroupTitleTextView", "()Landroid/widget/TextView;", "groupTitleTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupTitleLayout extends FrameLayout {
    public final ViewGroup a;
    public final View b;
    public final Lazy c;
    public SpecItemGroupLayout.d d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GroupTitleLayout a;
        public final /* synthetic */ String b;

        public a(GroupTitleLayout r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            SpecItemGroupLayout.d r11 = this.a.d;
            if (r11 == null) goto L5;
            r11.b();
        L5:
            ECLiveHybridUtil.k(this.a.getContext(), this.b, false, false, false, null, 252);
        }
    }

    public GroupTitleLayout(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public GroupTitleLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    private final TextView getGroupTitleTextView() {
        return (TextView) this.c.getValue();
    }

    private final void setChartClickListener(String r10) {
        View r0 = this.a.findViewById(2131365498);
        if (r10.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.setOnClickListener(new a(this, r10));
        return;
    L8:
        r0.setOnClickListener(null);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void b(cg.e r10) {
        Intrinsics.checkNotNullParameter(r10, "groupTitleVO");
        ViewGroup.LayoutParams r0 = null;
        if (r10.equals(null) == false) goto L5;
        return;
    L5:
        cg.j r1 = r10.a;
        getGroupTitleTextView().setTextColor(r1.a);
        getGroupTitleTextView().setTextSize(2, r1.b);
        getGroupTitleTextView().getPaint().setFakeBoldText(r1.c);
        getGroupTitleTextView().setIncludeFontPadding(false);
        getGroupTitleTextView().setText(r1.d);
        if (r1.e == false) goto L8;
        TextView r11 = getGroupTitleTextView();
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-2, -2);
        r12.setMargins(0, (int) UIUtils.dip2Px(getContext().getApplicationContext(), 16.0f), 0, 0);
        Unit r13 = Unit.INSTANCE;
        r11.setLayoutParams(r12);
    L9:
        cg.c r14 = r10.b;
        if (r14 == null) goto L23;
        this.b.setVisibility(0);
        SimpleDraweeView r15 = this.a.findViewById(2131374665);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof LinearLayout.LayoutParams) == false) goto L15;
        r0 = r16;
    L15:
        LinearLayout.LayoutParams r17 = (LinearLayout.LayoutParams) r0;
        if (r17 == null) goto L19;
        r17.width = vf4.a.b(Integer.valueOf(r14.d));
        r17.height = vf4.a.b(Integer.valueOf(r14.e));
        r15.setLayoutParams(r17);
    L19:
        if (r14.c != null) goto L21;
        r15.setVisibility(8);
    L22:
        ((TextView) this.a.findViewById(2131390298)).setText(r14.b);
        setChartClickListener(r14.f);
        return;
    L21:
        com.bytedance.android.ec.core.utils.y.a(r15, r14.c);
        goto L22
    L23:
        this.b.setVisibility(8);
        return;
    L8:
        TextView r18 = getGroupTitleTextView();
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(-2, -2);
        r19.setMargins(0, 0, 0, 0);
        Unit r20 = Unit.INSTANCE;
        r18.setLayoutParams(r19);
        goto L9
    }

    public final void a(cg.e r10, SpecItemGroupLayout.d r11) {
        Intrinsics.checkNotNullParameter(r10, "groupTitleVO");
        ViewGroup.LayoutParams r0 = null;
        if (r10.equals(null) == false) goto L5;
        return;
    L5:
        cg.j r1 = r10.a;
        if (r11 == null) goto L8;
        this.d = r11;
    L8:
        getGroupTitleTextView().setTextColor(r1.a);
        getGroupTitleTextView().setTextSize(2, r1.b);
        getGroupTitleTextView().getPaint().setFakeBoldText(r1.c);
        getGroupTitleTextView().setIncludeFontPadding(false);
        getGroupTitleTextView().setText(r1.d);
        if (r1.e == false) goto L11;
        TextView r12 = getGroupTitleTextView();
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        r13.setMargins(0, (int) UIUtils.dip2Px(getContext().getApplicationContext(), 16.0f), 0, 0);
        Unit r14 = Unit.INSTANCE;
        r12.setLayoutParams(r13);
    L11:
        this.a.addView(getGroupTitleTextView(), 0);
        cg.c r15 = r10.b;
        if (r15 == null) goto L25;
        this.b.setVisibility(0);
        SimpleDraweeView r16 = this.a.findViewById(2131374665);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if ((r17 instanceof LinearLayout.LayoutParams) == false) goto L17;
        r0 = r17;
    L17:
        LinearLayout.LayoutParams r18 = (LinearLayout.LayoutParams) r0;
        if (r18 == null) goto L21;
        r18.width = vf4.a.b(Integer.valueOf(r15.d));
        r18.height = vf4.a.b(Integer.valueOf(r15.e));
        r16.setLayoutParams(r18);
    L21:
        if (r15.c != null) goto L23;
        r16.setVisibility(8);
    L24:
        ((TextView) this.a.findViewById(2131390298)).setText(r15.b);
        setChartClickListener(r15.f);
    L26:
        addView(this.a);
        return;
    L23:
        com.bytedance.android.ec.core.utils.y.a(r16, r15.c);
        goto L24
    L25:
        this.b.setVisibility(8);
        goto L26
    }

    public GroupTitleLayout(final Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.c = LazyKt.lazy(new GroupTitleLayout$groupTitleTextView$2(r10));
        View r13 = LayoutInflater.from(r10).inflate(2131564771, this, false);
        if (r13 == null) goto L7;
        ViewGroup r14 = (ViewGroup) r13;
        this.a = r14;
        this.b = r14.findViewById(2131365498);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public /* synthetic */ GroupTitleLayout(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
