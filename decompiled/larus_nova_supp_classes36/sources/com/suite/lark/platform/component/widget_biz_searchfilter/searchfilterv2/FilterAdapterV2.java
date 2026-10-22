package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u00061"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterAdapterV2;", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onV2FilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;", "getOnV2FilterItemClick", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;", "setOnV2FilterItemClick", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;)V", "commonRecFilterShowListener", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;", "getCommonRecFilterShowListener", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;", "setCommonRecFilterShowListener", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;)V", "selectedBgColor", "", "Ljava/lang/Integer;", "selectedBgBoarderColor", "selectedTextColor", "unSelectedTextColor", "selectedArrowColor", "unSelectedArrowColor", "setItemSelectedBgBorderColor", "", "res", "setItemSelectedBgColor", "setSelectedArrowColor", "resId", "setUnSelectedArrowColor", "setSelectedTextColor", "setUnSelectedTextColor", "onCreateViewHolder", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter$FilterViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateItemUISetting", "filterData", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FilterAdapterV2 extends FilterAdapter {
    public final Context g;
    public FilterViewV2.c h;
    public FilterViewV2.b i;
    public Integer j;
    public Integer k;
    public Integer l;
    public Integer m;
    public Integer n;
    public Integer o;

    public static final class a extends OnSingleClickListener {
        public final /* synthetic */ FilterAdapterV2 a;
        public final /* synthetic */ cpc.a b;

        public final void onSingleClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            FilterViewV2.c r3 = this.a.h;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }

        public a(FilterAdapterV2 r1, cpc.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b extends OnSingleClickListener {
        public final /* synthetic */ FilterAdapterV2 a;
        public final /* synthetic */ cpc.a b;

        public final void onSingleClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            FilterViewV2.c r3 = this.a.h;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }

        public b(FilterAdapterV2 r1, cpc.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public FilterAdapterV2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.g = r2;
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((FilterAdapter.FilterViewHolder) r1, r2);
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter
    public final void y2(FilterAdapter.FilterViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        if (r12.a != 0) goto L15;
        cpc.a r14 = (cpc.a) ListProtector.get(this.b, r13);
        String r4 = r14.b;
        if (StringsKt.contains$default(r4, "{{name}}", false, 2, null) == false) goto L7;
        List r0 = StringsKt.split$default(r4, new String[]{"{{name}}"}, false, 0, 6, null);
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372534)).setText((CharSequence) ListProtector.get(r0, 0));
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372530)).setText((CharSequence) ListProtector.get(r0, 1));
    L8:
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372475).setImageBitmap((Bitmap) CollectionsKt.firstOrNull(r14.c));
        TextView r1 = (TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372506);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.SubFilterDataDependency.BaseOnQueryFilterData");
        r1.setText(((cpc.b) r14).a());
        Integer r2 = this.d;
        if (r2 == null) goto L11;
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372531).setBackgroundResource(r2.intValue());
    L11:
        Integer r3 = this.e;
        if (r3 == null) goto L14;
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372511).setBackgroundResource(r3.intValue());
    L14:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new a(this, r14));
        return;
    L7:
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372534)).setText("");
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372530)).setText("");
        goto L8
    L15:
        cpc.a r15 = (cpc.a) ListProtector.get(this.b, r13);
        SearchFilterViewV2 r5 = (SearchFilterViewV2) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372533);
        r5.setCancelClickListener(new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.a(this, r15));
        if (r15.d == true) goto L18;
        r5.setRightArrowVisibility(false);
    L20:
        if (r15.a() == false) goto L40;
        String r6 = r15.b;
        List<Bitmap> r7 = r15.c;
        int r8 = r15.b();
        r5.a = true;
        r5.J = r6;
        r5.M = r7;
        if (r8 > 1) goto L24;
        r5.K = null;
    L28:
        r5.requestLayout();
        r5.invalidate();
        Integer r9 = this.j;
        if (r9 == null) goto L31;
        r5.setItemSelectedBgColor(r9.intValue());
    L31:
        Integer r10 = this.k;
        if (r10 == null) goto L34;
        r5.setItemSelectedBgBorderColor(r10.intValue());
    L34:
        Integer r11 = this.l;
        if (r11 == null) goto L37;
        r5.setSelectedTextColor(r11.intValue());
    L37:
        Integer r16 = this.n;
        if (r16 == null) goto L52;
        r5.setSelectedArrowColor(r16.intValue());
    L52:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new b(this, r15));
        if (r12.a != 1) goto L59;
        FilterViewV2.b r17 = this.i;
        if (r17 == null) goto L60;
        r17.a(r15);
        return;
    L60:
        return;
    L59:
        return;
    L24:
        if (r5.L == false) goto L26;
        r5.K = "+" + (r8 - 1);
        goto L28
    L26:
        r5.K = UIHelper.mustacheFormat(2131892449, "SearchOptions", Integer.toString(r8 - 1));
        goto L28
    L40:
        r5.setUnSelectedText(r15.b);
        Integer r18 = this.e;
        if (r18 == null) goto L43;
        r5.setItemUnSelectedBgColor(r18.intValue());
    L43:
        Integer r19 = this.f;
        if (r19 == null) goto L46;
        r5.setItemUnSelectedBgBorderColor(r19.intValue());
    L46:
        Integer r20 = this.m;
        if (r20 == null) goto L49;
        r5.setUnSelectedTextColor(r20.intValue());
    L49:
        Integer r21 = this.o;
        if (r21 == null) goto L52;
        r5.setUnSelectedArrowColor(r21.intValue());
        goto L52
    L18:
        r5.setRightArrowVisibility(true);
        goto L20
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter
    public final FilterAdapter.FilterViewHolder z2(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 0) goto L6;
        return new FilterAdapter.FilterViewHolder(LayoutInflater.from(this.g).inflate(2131563703, r5, false), r6);
    L6:
        return new FilterAdapter.FilterViewHolder(LayoutInflater.from(this.g).inflate(2131561110, r5, false), r6);
    }
}
