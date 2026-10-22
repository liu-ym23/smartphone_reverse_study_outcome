package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000278B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\tJ\u0014\u0010#\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0%J\u0014\u0010&\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0%J\u000e\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0013J\u000e\u0010)\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0013J\u0018\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0013H\u0016J\u0018\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0013H\u0016J\u0010\u00102\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020\u0013H\u0016J\u0010\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\u0013H\u0016J\u000e\u00106\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017¨\u00069"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter$FilterViewHolder;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "items", "", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "getItems", "()Ljava/util/List;", "onFilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnFilterItemClick;", "getOnFilterItemClick", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnFilterItemClick;", "setOnFilterItemClick", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnFilterItemClick;)V", "recommendItemBgColor", "", "getRecommendItemBgColor", "()Ljava/lang/Integer;", "setRecommendItemBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "unSelectedBgColor", "getUnSelectedBgColor", "setUnSelectedBgColor", "unSelectedBgBorderColor", "getUnSelectedBgBorderColor", "setUnSelectedBgBorderColor", "add", "", "data", "index", "addAll", "collection", "", "resetAll", "update", "resId", "setItemUnSelectedBgColor", "setItemUnSelectedBgBorderColor", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "getItemId", "", "itemPosition", "FilterViewHolder", "Companion", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class FilterAdapter extends RecyclerView.Adapter<FilterViewHolder> {
    public final Context a;
    public final List<cpc.a> b;
    public FilterView.b c;
    public Integer d;
    public Integer e;
    public Integer f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter$FilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "<init>", "(Landroid/view/View;I)V", "getViewType", "()I", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class FilterViewHolder extends RecyclerView.ViewHolder {
        public final int a;

        public FilterViewHolder(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r3;
        }
    }

    public static final class a {
    }

    public static final class b extends OnSingleClickListener {
        public final /* synthetic */ FilterAdapter a;
        public final /* synthetic */ cpc.a b;

        public final void onSingleClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            FilterView.b r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }

        public b(FilterAdapter r1, cpc.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends OnSingleClickListener {
        public final /* synthetic */ FilterAdapter a;
        public final /* synthetic */ cpc.a b;

        public final void onSingleClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            FilterView.b r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }

        public c(FilterAdapter r1, cpc.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public FilterAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new ArrayList();
        setHasStableIds(true);
    }

    public final long getItemId(int r3) {
        return ((cpc.a) ListProtector.get(this.b, r3)).hashCode();
    }

    public final int getItemViewType(int r2) {
        if ((((cpc.a) ListProtector.get(this.b, r2)) instanceof cpc.b) == false) goto L5;
        return 0;
    L5:
        return 2;
    }

    public final void update(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        int r3 = ((ArrayList) this.b).indexOf(r2);
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= ((ArrayList) this.b).size()) goto L9;
        notifyItemChanged(r3);
        return;
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((FilterViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void y2(FilterViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        if (r12.a != 0) goto L15;
        cpc.a r14 = (cpc.a) ListProtector.get(this.b, r13);
        String r2 = r14.b;
        if (StringsKt.contains$default(r2, "{{name}}", false, 2, null) == false) goto L7;
        List r0 = StringsKt.split$default(r2, new String[]{"{{name}}"}, false, 0, 6, null);
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372534)).setText((CharSequence) ListProtector.get(r0, 0));
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372530)).setText((CharSequence) ListProtector.get(r0, 1));
    L8:
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372475).setImageBitmap((Bitmap) CollectionsKt.firstOrNull(r14.c));
        TextView r1 = (TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372506);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.SubFilterDataDependency.BaseOnQueryFilterData");
        r1.setText(((cpc.b) r14).a());
        Integer r3 = this.d;
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372531).setBackgroundResource(r4);
    L11:
        Integer r5 = this.e;
        if (r5 == null) goto L14;
        int r6 = r5.intValue();
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372511).setBackgroundResource(r6);
    L14:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new b(this, r14));
        return;
    L7:
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372534)).setText("");
        ((TextView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372530)).setText("");
        goto L8
    L15:
        cpc.a r15 = (cpc.a) ListProtector.get(this.b, r13);
        SearchFilterView r7 = (SearchFilterView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131372532);
        if (r15.a() == false) goto L18;
        String r8 = r15.b;
        List<Bitmap> r9 = r15.c;
        r7.a = true;
        r7.w = r8;
        r7.x = r9;
        r7.requestLayout();
    L24:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new c(this, r15));
        return;
    L18:
        r7.setUnSelectedText(r15.b);
        Integer r10 = this.e;
        if (r10 == null) goto L21;
        r7.setItemUnSelectedBgColor(r10.intValue());
    L21:
        Integer r11 = this.f;
        if (r11 == null) goto L24;
        r7.setItemUnSelectedBgBorderColor(r11.intValue());
        goto L24
    }

    public FilterViewHolder z2(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 0) goto L6;
        return new FilterViewHolder(LayoutInflater.from(this.a).inflate(2131563703, r5, false), r6);
    L6:
        return new FilterViewHolder(LayoutInflater.from(this.a).inflate(2131561109, r5, false), r6);
    }
}
