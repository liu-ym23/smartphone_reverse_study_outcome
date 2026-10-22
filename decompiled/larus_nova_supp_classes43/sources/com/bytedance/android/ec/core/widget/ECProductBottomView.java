package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.model.response.ECSpannableText;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0014B\u0013\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rB\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B%\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R#\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECProductBottomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "h", "Lkotlin/Lazy;", "getAnchorPriceView", "()Landroid/view/View;", "anchorPriceView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECProductBottomView extends ConstraintLayout implements View.OnClickListener {
    public final Guideline a;
    public final ECDraweeView b;
    public final List<View> c;
    public int d;
    public final TextView e;
    public final ECAutoScaleLayout f;
    public final ECDraweeView g;
    public final Lazy h;
    public final ECDraweeView i;
    public com.bytedance.android.ec.model.response.u j;

    public static final class a {
    }

    static {
    }

    private final View getAnchorPriceView() {
        return (View) this.h.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductBottomView(Context r14) {
        super(r14);
        Guideline r15 = new Guideline(getContext());
        r15.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(-2, -2);
        r0.orientation = 0;
        Unit r10 = Unit.INSTANCE;
        r15.setLayoutParams(r0);
        this.a = r15;
        ECDraweeView r1 = new ECDraweeView(getContext(), null, 0, 6, null);
        r1.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(r1.getDp(20), r1.getDp(42));
        r11.setMargins(r1.getDp(8), r1.getDp(6), 0, r1.getDp(6));
        r1.setLayoutParams(r11);
        this.b = r1;
        this.c = new ArrayList();
        TextView r12 = new TextView(getContext());
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -1);
        r13.gravity = 5;
        r12.setLayoutParams(r13);
        r12.setTextSize(12.0f);
        r12.setTextColor(th.a.a(r12.getContext(), 2131105989));
        this.e = r12;
        ECAutoScaleLayout r16 = new ECAutoScaleLayout(getContext());
        r16.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r17 = new ConstraintLayout.LayoutParams(0, -2);
        r17.setMargins(vf4.a.b(16), vf4.a.b(Double.valueOf(19.3d)), vf4.a.b(1), 0);
        r16.setLayoutParams(r17);
        r16.setScaleType(2);
        r16.addView(r12);
        this.f = r16;
        ECDraweeView r18 = new ECDraweeView(getContext(), null, 0, 6, null);
        r18.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r19 = new ConstraintLayout.LayoutParams(r18.getDp(9), r18.getDp(9));
        r19.setMargins(0, 0, r18.getDp(8), 0);
        r18.setLayoutParams(r19);
        this.g = r18;
        this.h = LazyKt.lazy(new ECProductBottomView$anchorPriceView$2(this));
        ECDraweeView r20 = new ECDraweeView(getContext(), null, 0, 6, null);
        r20.setId(ViewCompat.generateViewId());
        r20.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.i = r20;
        addView(r20);
        addView(r15);
        addView(r1);
        addView(r16);
        addView(r18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(com.bytedance.android.ec.model.response.u r26) {
        Intrinsics.checkNotNullParameter(r26, "data");
        this.j = r26;
        int r10 = vf4.a.b(42);
        int r11 = vf4.a.b(8);
        int r12 = vf4.a.b(6);
        int r13 = vf4.a.b(6);
        int r14 = vf4.a.b(6);
        int r15 = vf4.a.b(6);
        int r16 = vf4.a.b(42);
        getAnchorPriceView().setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        c.a(this.g, r26.g(), r26.d);
        TextView r17 = this.e;
        SpannableStringBuilder r18 = new SpannableStringBuilder();
        List r19 = r26.f();
        if (r19 == null) goto L13;
        Iterator r110 = r19.iterator();
    L6:
        if (r110.hasNext() == false) goto L13;
        ECSpannableText r111 = (ECSpannableText) r110.next();
        String r20 = r111.getText();
        int r112 = com.bytedance.android.ec.core.utils.s.a;
        Integer r113 = com.bytedance.android.ec.core.utils.s.b(r111.getColor());
        if (r20 == null) goto L12;
        if (r113 == null) goto L12;
        int r21 = r113.intValue();
        int r114 = r18.length();
        r18.append(r20);
        r18.setSpan(new ForegroundColorSpan(r21), r114, r18.length(), 33);
    L12:
        r110 = r110;
    L13:
        Unit r22 = Unit.INSTANCE;
        r17.setText(r18);
        c.a(this.b, r26.d(), r26.c);
        if (r26.e == null) goto L22;
        RoundingParams r23 = this.i.getRoundingParams();
        Resources r115 = Resources.getSystem();
        r23.setCornersRadius(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics())));
        this.i.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        Rect r24 = r26.f;
        if (r24 == null) goto L18;
        wg.a.f(this.i, vf4.a.b(Integer.valueOf(r24.left)), vf4.a.b(Integer.valueOf(r24.top)), vf4.a.b(Integer.valueOf(r24.right)), vf4.a.b(Integer.valueOf(r24.bottom)));
    L18:
        Integer r25 = r26.b;
        if (r25 == null) goto L21;
        h0.e(this.i, UriUtil.getUriForResourceId(r25.intValue()).toString(), null, null, null, 120);
    L23:
        ConstraintLayout.LayoutParams r27 = this.b.getLayoutParams();
        if (r27 == null) goto L56;
        ConstraintLayout.LayoutParams r28 = r27;
        ((ViewGroup.MarginLayoutParams) r28).height = r16;
        r28.setMargins(vf4.a.b(8), r14, 0, r15);
        List r29 = r26.c();
        if (r29 == null) goto L41;
        Iterator r30 = r29.iterator();
        int r31 = 0;
    L29:
        if (r30.hasNext() == false) goto L41;
        Object r32 = r30.next();
        int r33 = r31 + 1;
        if (r31 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        com.bytedance.android.ec.model.response.t r34 = (com.bytedance.android.ec.model.response.t) r32;
        if (r31 < ((ArrayList) this.c).size()) goto L37;
        View r116 = LayoutInflater.from(getContext()).inflate(2131564709, null);
        r116.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(r10, r10);
        r117.setMargins(r11, r12, 0, r13);
        Unit r118 = Unit.INSTANCE;
        r116.setLayoutParams(r117);
        this.d++;
        ((ArrayList) this.c).add(r116);
        addView(r116);
    L37:
        int r119 = this.d;
        if (r31 < r119) goto L40;
        this.d = r119 + 1;
        ((View) ListProtector.get(this.c, r31)).setVisibility(0);
    L40:
        ECLiveImageUtils.i(((View) ListProtector.get(this.c, r31)).findViewById(2131376519), r34.a(), 2, 0);
        ((View) ListProtector.get(this.c, r31)).setOnClickListener(this);
        ((View) ListProtector.get(this.c, r31)).findViewById(2131372824).setVisibility(8);
        r31 = r33;
    L41:
        List r1 = r26.c();
        if (r1 != null) goto L45;
        r1 = CollectionsKt.emptyList();
    L45:
        if (this.d <= r1.size()) goto L49;
        int r35 = r1.size();
        int r36 = this.d;
    L47:
        if (r35 >= r36) goto L49;
        this.d--;
        ((View) ListProtector.get(this.c, r35)).setVisibility(8);
        r35 = r35 + 1;
    L49:
        setOnClickListener(this);
        ConstraintSet r37 = new ConstraintSet();
        r37.clone(this);
        r37.connect(this.a.getId(), 3, 0, 3);
        r37.connect(this.i.getId(), 6, 0, 6);
        r37.connect(this.i.getId(), 3, 0, 3);
        r37.connect(this.b.getId(), 6, 0, 6);
        r37.connect(this.b.getId(), 3, this.a.getId(), 4);
        int r38 = this.b.getId();
        int r39 = this.d;
        int r40 = 0;
    L51:
        if (r40 >= r39) goto L53;
        int r41 = ((View) ListProtector.get(this.c, r40)).getId();
        r37.connect(r41, 6, r38, 7);
        r37.connect(r41, 3, this.a.getId(), 4);
        r37.connect(r41, 4, 0, 4);
        r40 = r40 + 1;
        r38 = r41;
        goto L51
    L53:
        r37.connect(this.f.getId(), 6, r38, 7);
        r37.connect(this.f.getId(), 7, this.g.getId(), 6);
        r37.connect(this.f.getId(), 3, this.a.getId(), 4);
        r37.connect(this.g.getId(), 6, this.f.getId(), 7);
        r37.connect(this.g.getId(), 7, 0, 7);
        r37.connect(this.g.getId(), 3, this.f.getId(), 3);
        r37.connect(this.g.getId(), 4, this.f.getId(), 4);
        r37.applyTo(this);
        return;
    L56:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L21:
        c.a(this.i, r26.a(), null);
        goto L23
    L22:
        c.a(this.i, r26.a(), r26.b);
        goto L23
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        com.bytedance.android.ec.model.response.u r0 = this.j;
        if (r0 == null) goto L16;
        Function2 r1 = r0.a;
        if (r1 == null) goto L17;
        int r11 = this.d;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L12;
        if (Intrinsics.areEqual((View) ListProtector.get(this.c, r13), r10) == true) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        r12 = r13 + 1;
    L12:
        Unit r14 = (Unit) r1.invoke(r10, Integer.valueOf(r12));
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductBottomView(Context r13, AttributeSet r14) {
        super(r13, r14);
        Guideline r15 = new Guideline(getContext());
        r15.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(-2, -2);
        r16.orientation = 0;
        Unit r10 = Unit.INSTANCE;
        r15.setLayoutParams(r16);
        this.a = r15;
        ECDraweeView r17 = new ECDraweeView(getContext(), null, 0, 6, null);
        r17.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r11 = new ConstraintLayout.LayoutParams(r17.getDp(20), r17.getDp(42));
        r11.setMargins(r17.getDp(8), r17.getDp(6), 0, r17.getDp(6));
        r17.setLayoutParams(r11);
        this.b = r17;
        this.c = new ArrayList();
        TextView r12 = new TextView(getContext());
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -1);
        r18.gravity = 5;
        r12.setLayoutParams(r18);
        r12.setTextSize(12.0f);
        r12.setTextColor(th.a.a(r12.getContext(), 2131105989));
        this.e = r12;
        ECAutoScaleLayout r19 = new ECAutoScaleLayout(getContext());
        r19.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, -2);
        r20.setMargins(vf4.a.b(16), vf4.a.b(Double.valueOf(19.3d)), vf4.a.b(1), 0);
        r19.setLayoutParams(r20);
        r19.setScaleType(2);
        r19.addView(r12);
        this.f = r19;
        ECDraweeView r0 = new ECDraweeView(getContext(), null, 0, 6, null);
        r0.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r21 = new ConstraintLayout.LayoutParams(r0.getDp(9), r0.getDp(9));
        r21.setMargins(0, 0, r0.getDp(8), 0);
        r0.setLayoutParams(r21);
        this.g = r0;
        this.h = LazyKt.lazy(new ECProductBottomView$anchorPriceView$2(this));
        ECDraweeView r1 = new ECDraweeView(getContext(), null, 0, 6, null);
        r1.setId(ViewCompat.generateViewId());
        r1.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.i = r1;
        addView(r1);
        addView(r15);
        addView(r17);
        addView(r19);
        addView(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductBottomView(Context r12, AttributeSet r13, int r14) {
        super(r12, r13, r14);
        Guideline r15 = new Guideline(getContext());
        r15.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(-2, -2);
        r16.orientation = 0;
        Unit r1 = Unit.INSTANCE;
        r15.setLayoutParams(r16);
        this.a = r15;
        ECDraweeView r17 = new ECDraweeView(getContext(), null, 0, 6, null);
        r17.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(r17.getDp(20), r17.getDp(42));
        r10.setMargins(r17.getDp(8), r17.getDp(6), 0, r17.getDp(6));
        r17.setLayoutParams(r10);
        this.b = r17;
        this.c = new ArrayList();
        TextView r11 = new TextView(getContext());
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -1);
        r18.gravity = 5;
        r11.setLayoutParams(r18);
        r11.setTextSize(12.0f);
        r11.setTextColor(th.a.a(r11.getContext(), 2131105989));
        this.e = r11;
        ECAutoScaleLayout r19 = new ECAutoScaleLayout(getContext());
        r19.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, -2);
        r20.setMargins(vf4.a.b(16), vf4.a.b(Double.valueOf(19.3d)), vf4.a.b(1), 0);
        r19.setLayoutParams(r20);
        r19.setScaleType(2);
        r19.addView(r11);
        this.f = r19;
        ECDraweeView r110 = new ECDraweeView(getContext(), null, 0, 6, null);
        r110.setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r21 = new ConstraintLayout.LayoutParams(r110.getDp(9), r110.getDp(9));
        r21.setMargins(0, 0, r110.getDp(8), 0);
        r110.setLayoutParams(r21);
        this.g = r110;
        this.h = LazyKt.lazy(new ECProductBottomView$anchorPriceView$2(this));
        ECDraweeView r0 = new ECDraweeView(getContext(), null, 0, 6, null);
        r0.setId(ViewCompat.generateViewId());
        r0.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        this.i = r0;
        addView(r0);
        addView(r15);
        addView(r17);
        addView(r19);
        addView(r110);
    }
}
