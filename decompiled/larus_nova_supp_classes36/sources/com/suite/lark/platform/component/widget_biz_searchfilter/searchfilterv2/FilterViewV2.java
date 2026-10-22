package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterViewItemDecoration;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 :2\u00020\u0001:\u0004:;<=B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u0013J\u0010\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0015J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0017J\u0014\u0010.\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u0014\u00102\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u000e\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u000201J\u000e\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u001cJ\u0006\u00107\u001a\u00020\u0019J\u0006\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020\u0019R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mResetTv", "Landroid/widget/TextView;", "mFilterRv", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "mGradientBorder", "Landroid/view/View;", "mV2FilterAdapter", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterAdapterV2;", "mOnResetClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnResetClick;", "mOnFilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;", "mCommonRecFilterShowListener", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;", "initFilterView", "", "setSelectedArrowColor", "resId", "", "setUnSelectedArrowColor", "setSelectedTextColor", "setUnSelectedTextColor", "setResetTvBgColor", "setGradientBorderBackground", "setRecommendItemBgColor", "setItemSelectedBgColor", "res", "setItemSelectedBgBorderColor", "setItemUnSelectedBgColor", "setItemUnSelectedBgBorderColor", "setOnResetClick", "onResetClick", "setOnFilterItemClick", "onFilterItemClick", "setOnCommonRecFilterShowListener", "l", "addAll", "collection", "", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "resetAll", "update", "data", "scrollTo", "index", "scrollToLeft", "hide", "show", "Companion", "IOnResetClick", "IOnFilterItemClick", "IOnCommonRecFilterItemShow", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FilterViewV2 extends FrameLayout {
    public TextView a;
    public CommonRecyclerView b;
    public View c;
    public FilterAdapterV2 d;
    public d e;
    public c f;
    public b g;

    public static final class a {
    }

    public interface b {
        void a(cpc.a r1);
    }

    public interface c {
        void a(cpc.a r1);

        void b(cpc.a r1);
    }

    public interface d {
        void a();
    }

    static {
    }

    public final void b() {
        TextView r0 = this.a;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r0 = null;
    L5:
        r0.setVisibility(8);
        View r2 = this.c;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void c() {
        TextView r0 = this.a;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r0 = null;
    L5:
        r0.setVisibility(0);
        View r2 = this.c;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
    L9:
        r1.setVisibility(0);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public FilterViewV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(Collection<? extends cpc.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "collection");
        if ((!r3.isEmpty()) == false) goto L11;
        FilterAdapterV2 r1 = this.d;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r1 = null;
    L7:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "collection");
        if ((!r3.isEmpty()) == false) goto L12;
        ((ArrayList) r1.b).addAll(r3);
        r1.notifyDataSetChanged();
        return;
    L12:
        return;
    }

    public final void setGradientBorderBackground(int r2) {
        View r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
        r0 = null;
    L5:
        r0.setBackgroundResource(r2);
    }

    public final void setItemSelectedBgBorderColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.k;
        if (r1 != null) goto L9;
    L10:
        r0.k = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setItemSelectedBgColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.j;
        if (r1 != null) goto L9;
    L10:
        r0.j = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setItemUnSelectedBgBorderColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.f;
        if (r1 != null) goto L9;
    L10:
        r0.f = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setItemUnSelectedBgColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.e;
        if (r1 != null) goto L9;
    L10:
        r0.e = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setOnCommonRecFilterShowListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.g = r2;
    }

    public final void setOnFilterItemClick(c r1) {
        this.f = r1;
    }

    public final void setOnResetClick(d r1) {
        this.e = r1;
    }

    public final void setRecommendItemBgColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.d;
        if (r1 != null) goto L9;
    L10:
        r0.d = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setResetTvBgColor(int r3) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r0 = null;
    L5:
        r0.setBackgroundColor(y9c.d.c(getContext(), r3));
    }

    public final void setSelectedArrowColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.n;
        if (r1 != null) goto L9;
    L10:
        r0.n = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setSelectedTextColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.l;
        if (r1 != null) goto L9;
    L10:
        r0.l = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setUnSelectedArrowColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.o;
        if (r1 != null) goto L9;
    L10:
        r0.o = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void setUnSelectedTextColor(int r3) {
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        Integer r1 = r0.m;
        if (r1 != null) goto L9;
    L10:
        r0.m = Integer.valueOf(r3);
        r0.notifyDataSetChanged();
        return;
    L9:
        if (r1.intValue() != r3) goto L10;
    }

    public final void update(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r0 = null;
    L5:
        r0.update(r2);
    }

    public FilterViewV2(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        LayoutInflater.from(getContext()).inflate(2131561111, this, true);
        this.a = (TextView) findViewById(2131372510);
        this.b = findViewById(2131372512);
        this.c = findViewById(2131373887);
        this.d = new FilterAdapterV2(getContext());
        TextView r12 = this.a;
        FilterAdapterV2 r13 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r12 = null;
    L5:
        r12.setOnClickListener(new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.b(this));
        RecyclerView r14 = this.b;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
        r14 = null;
    L8:
        r14.setItemAnimator(null);
        ViewGroup r15 = this.b;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
        r15 = null;
    L11:
        int r2 = 0;
        r15.setLayoutManager(new LinearLayoutManager(r15.getContext(), 0, false));
        FilterAdapterV2 r0 = this.d;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
    L15:
        r13.h = new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.c(this);
        r13.i = new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.d(this);
        r15.setAdapter(r13);
        int r16 = r15.getItemDecorationCount();
    L16:
        if (r2 >= r16) goto L18;
        r15.removeItemDecorationAt(r2);
        r2 = r2 + 1;
        goto L16
    L18:
        r15.addItemDecoration(new FilterViewItemDecoration(UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(10.0f)));
        return;
    L14:
        r13 = r0;
        goto L15
    }
}
