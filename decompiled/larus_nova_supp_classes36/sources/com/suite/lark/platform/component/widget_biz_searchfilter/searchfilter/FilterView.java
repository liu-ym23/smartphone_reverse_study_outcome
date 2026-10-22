package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

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
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\u0010\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0015J\u0014\u0010\"\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u0014\u0010&\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020\u0017J\u0006\u0010*\u001a\u00020\u0017J\u0006\u0010+\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mResetTv", "Landroid/widget/TextView;", "mFilterRv", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "mGradientBorder", "Landroid/view/View;", "mFilterAdapter", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter;", "mOnResetClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnResetClick;", "mOnFilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnFilterItemClick;", "initFilterView", "", "setGradientBorderBackground", "resId", "", "setRecommendItemBgColor", "setItemUnSelectedBgColor", "setItemUnSelectedBgBorderColor", "setOnResetClick", "onResetClick", "setOnFilterItemClick", "onFilterItemClick", "addAll", "collection", "", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "resetAll", "update", "data", "scrollToLeft", "hide", "show", "Companion", "IOnResetClick", "IOnFilterItemClick", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FilterView extends FrameLayout {
    public static final /* synthetic */ int f = 0;
    public TextView a;
    public CommonRecyclerView b;
    public View c;
    public FilterAdapter d;
    public b e;

    public static final class a {
    }

    public interface b {
        void a(cpc.a r1);
    }

    public interface c {
    }

    static {
    }

    public final void setOnResetClick(c r1) {
    }

    public FilterView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setGradientBorderBackground(int r2) {
        View r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
        r0 = null;
    L5:
        r0.setBackgroundResource(r2);
    }

    public final void setItemUnSelectedBgBorderColor(int r3) {
        FilterAdapter r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
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
        FilterAdapter r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
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

    public final void setOnFilterItemClick(b r1) {
        this.e = r1;
    }

    public final void setRecommendItemBgColor(int r3) {
        FilterAdapter r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
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

    public final void update(cpc.a r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        FilterAdapter r1 = this.d;
        RecyclerView r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
        r1 = null;
    L5:
        r1.update(r5);
        FilterAdapter r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
        r2 = null;
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        int r6 = ((ArrayList) r2.b).indexOf(r5);
        if (r6 < 0) goto L21;
        FilterAdapter r0 = this.d;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
        r0 = null;
    L14:
        if (r6 >= r0.getItemCount()) goto L22;
        RecyclerView r4 = this.b;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
    L19:
        r3.scrollToPosition(r6);
        return;
    L18:
        r3 = r4;
        goto L19
    L22:
        return;
    }

    public FilterView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        LayoutInflater.from(getContext()).inflate(2131561111, this, true);
        this.a = (TextView) findViewById(2131372510);
        this.b = findViewById(2131372512);
        this.c = findViewById(2131373887);
        this.d = new FilterAdapter(getContext());
        TextView r12 = this.a;
        FilterAdapter r13 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r12 = null;
    L5:
        r12.setOnClickListener(new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.a(this));
        ViewGroup r14 = this.b;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
        r14 = null;
    L8:
        int r2 = 0;
        r14.setLayoutManager(new LinearLayoutManager(r14.getContext(), 0, false));
        FilterAdapter r0 = this.d;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
    L12:
        r13.c = new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.b(this);
        r14.setAdapter(r13);
        int r15 = r14.getItemDecorationCount();
    L13:
        if (r2 >= r15) goto L15;
        r14.removeItemDecorationAt(r2);
        r2 = r2 + 1;
        goto L13
    L15:
        r14.addItemDecoration(new FilterViewItemDecoration(UIHelper.dp2px(16.0f), UIHelper.dp2px(14.0f), UIHelper.dp2px(16.0f), UIHelper.dp2px(14.0f), UIHelper.dp2px(10.0f)));
        return;
    L11:
        r13 = r0;
        goto L12
    }
}
