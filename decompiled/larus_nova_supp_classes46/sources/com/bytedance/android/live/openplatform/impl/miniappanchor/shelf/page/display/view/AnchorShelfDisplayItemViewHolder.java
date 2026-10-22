package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.AnchorShelfDisplayTradeLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/AnchorShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/a;", "a", "b", "c", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayItemViewHolder extends CommonShelfDisplayItemViewHolder<com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a> {
    public final TextView k;
    public final AnchorShelfDisplayTradeLayout l;
    public final c m;
    public final b n;
    public final AnchorShelfDisplayTradeLayout.a o;

    public static final class a {
    }

    public interface b {
        void gw(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r1);

        void tW(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r1);
    }

    public interface c {
        void l50(int r1, long r2);
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean X3() {
        com.bytedance.android.live.openplatform.api.utils.a r0 = com.bytedance.android.live.openplatform.api.utils.a.a;
        return com.bytedance.android.live.openplatform.api.utils.a.a.h();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Y3() {
        com.bytedance.android.live.openplatform.api.utils.a r0 = com.bytedance.android.live.openplatform.api.utils.a.a;
        return com.bytedance.android.live.openplatform.api.utils.a.a.i();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Z3() {
        com.bytedance.android.live.openplatform.api.utils.a r0 = com.bytedance.android.live.openplatform.api.utils.a.a;
        return com.bytedance.android.live.openplatform.api.utils.a.a.e();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean T3(com.bytedance.android.live.openplatform.api.model.shelf.a r2) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r3 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return r3.a.c(true);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String V3(com.bytedance.android.live.openplatform.api.model.shelf.a r2) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r3 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return r3.c(null);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String W3(com.bytedance.android.live.openplatform.api.model.shelf.a r2) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r3 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return r3.a.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final void U3(CommonProductLabelLayout r4, com.bytedance.android.live.openplatform.api.model.shelf.a r5) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r6 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r5;
        Intrinsics.checkNotNullParameter(r4, "labelLayout");
        Intrinsics.checkNotNullParameter(r6, "cardInfo");
        ProductInfo r7 = r6.getProductInfo();
        if (r7 == null) goto L14;
        com.bytedance.android.live.openplatform.api.utils.a r1 = com.bytedance.android.live.openplatform.api.utils.a.a;
        if (r1.h() == true) goto L7;
    L13:
        r4.setVisibility(8);
        return;
    L7:
        if (r1.j() == false) goto L13;
        List<ProductLabelInfo> r2 = r7.labelList;
        if (r2 == null) goto L13;
        if ((!r2.isEmpty()) != true) goto L13;
        List<ProductLabelInfo> r8 = r7.labelList;
        Intrinsics.checkNotNull(r8);
        r4.r(r8);
        r4.setVisibility(0);
        return;
    L14:
        r4.setVisibility(8);
    }

    public AnchorShelfDisplayItemViewHolder(View r2, c r3, b r4, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.a r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "onItemExplainButtonClickListener");
        Intrinsics.checkNotNullParameter(r4, "onItemClickListener");
        Intrinsics.checkNotNullParameter(r5, "config");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.k = (TextView) r2.findViewById(2131384490);
        this.l = (AnchorShelfDisplayTradeLayout) r2.findViewById(2131389301);
    }
}
