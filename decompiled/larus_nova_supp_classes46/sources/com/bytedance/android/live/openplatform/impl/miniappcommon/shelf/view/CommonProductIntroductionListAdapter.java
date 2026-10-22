package com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.utils.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionListAdapter$CommonProductIntroductionViewHolder;", "CommonProductIntroductionViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonProductIntroductionListAdapter extends RecyclerView.Adapter<CommonProductIntroductionViewHolder> {
    public final List<ProductIntroductionInfo> a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonProductIntroductionListAdapter$CommonProductIntroductionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class CommonProductIntroductionViewHolder extends RecyclerView.ViewHolder {
        public CommonProductIntroductionViewHolder(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public CommonProductIntroductionListAdapter(List<ProductIntroductionInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "itemList");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        CommonProductIntroductionViewHolder r6 = (CommonProductIntroductionViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        ProductIntroductionInfo r0 = (ProductIntroductionInfo) ListProtector.get(this.a, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "productIntroductionInfo");
        View r7 = ((RecyclerView.ViewHolder) r6).itemView;
        if (r7 == null) goto L11;
        TextView r8 = (TextView) r7;
        r8.setText(r0.content);
        int r1 = c.a;
        r8.setTextColor(c.a(r0.fontColor));
        r8.setTextSize(r0.fontSize);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, -2);
        if (r5 == 0) goto L7;
        r2.setMargins(UtilityKotlinExtentionsKt.i(6), 0, UtilityKotlinExtentionsKt.i(6), 0);
    L8:
        Unit r9 = Unit.INSTANCE;
        r8.setLayoutParams(r2);
        r8.setEllipsize(TextUtils.TruncateAt.END);
        r8.setMaxLines(1);
        return;
    L7:
        r2.setMargins(0, 0, UtilityKotlinExtentionsKt.i(6), 0);
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new CommonProductIntroductionViewHolder(new TextView(r2.getContext()));
    }
}
