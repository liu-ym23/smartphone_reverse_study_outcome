package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.utils.c;
import com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.CardAvatarsLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fm3.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductLabelListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductLabelListAdapter$CommonProductLabelViewHolder;", "CommonProductLabelViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductLabelListAdapter extends RecyclerView.Adapter<CommonProductLabelViewHolder> {
    public final List<ProductLabelInfo> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductLabelListAdapter$CommonProductLabelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class CommonProductLabelViewHolder extends RecyclerView.ViewHolder {
        public final CardAvatarsLayout a;
        public final TextView b;
        public final TextView c;
        public final View d;

        public CommonProductLabelViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (CardAvatarsLayout) r2.findViewById(2131377777);
            this.b = (TextView) r2.findViewById(2131377814);
            this.c = (TextView) r2.findViewById(2131384632);
            this.d = r2.findViewById(2131369232);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public CommonProductLabelListAdapter(List<ProductLabelInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        CommonProductLabelViewHolder r9 = (CommonProductLabelViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        ProductLabelInfo r10 = (ProductLabelInfo) ListProtector.get(this.a, r8);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "labelInfo");
        List<ImageModel> r0 = r10.leftIconList;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        int r3 = 8;
        if (r2 == false) goto L12;
        r9.a.setVisibility(8);
    L13:
        r9.b.setTextSize(r10.fontSize);
        r9.c.setTextSize(r10.fontSize);
        TextView r4 = r9.b;
        int r5 = c.a;
        r4.setTextColor(c.a(r10.fontColor));
        r9.c.setTextColor(c.a(r10.fontColor));
        View r6 = r9.d;
        if (r10.dividingLine == false) goto L16;
        r3 = 0;
    L16:
        r6.setVisibility(r3);
        View r11 = ((RecyclerView.ViewHolder) r9).itemView;
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setCornerRadius(e.a(((RecyclerView.ViewHolder) r9).itemView.getContext(), 2.0f));
        r12.setStroke(UtilityKotlinExtentionsKt.i(1), c.a(r10.borderColor));
        Unit r13 = Unit.INSTANCE;
        r11.setBackground(r12);
        String r14 = r10.rightText;
        if (r14 != null) goto L19;
    L22:
        if (r1 == false) goto L24;
        UtilityKotlinExtentionsKt.t(r9.c);
    L25:
        r9.b.setText(r10.leftText);
        UtilityKotlinExtentionsKt.w(r9.b);
        return;
    L24:
        r9.c.setText(r10.rightText);
        UtilityKotlinExtentionsKt.w(r9.c);
        goto L25
    L19:
        if (StringsKt.isBlank(r14) == true) goto L22;
        r1 = false;
        goto L22
    L12:
        r9.a.setVisibility(0);
        r9.a.a(r10.leftIconList);
        goto L13
    L5:
        if (r0.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new CommonProductLabelViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566960, r4, false));
    }
}
