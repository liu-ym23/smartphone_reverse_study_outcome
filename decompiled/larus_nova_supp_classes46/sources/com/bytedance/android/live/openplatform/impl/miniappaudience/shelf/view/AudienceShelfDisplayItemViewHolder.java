package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.utils.b;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qq0.k;
import rq0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/view/AudienceShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayItemViewHolder;", "Lrq0/a;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceShelfDisplayItemViewHolder extends CommonShelfDisplayItemViewHolder<a> {
    public final k k;

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean X3() {
        b r0 = b.b;
        return b.b.h();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Y3() {
        b r0 = b.b;
        return b.b.i();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Z3() {
        b r0 = b.b;
        return b.b.e();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean T3(com.bytedance.android.live.openplatform.api.model.shelf.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return r3.a.c(false);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String V3(com.bytedance.android.live.openplatform.api.model.shelf.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return r3.c(null);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String W3(com.bytedance.android.live.openplatform.api.model.shelf.a r2) {
        a r3 = (a) r2;
        Intrinsics.checkNotNullParameter(r3, "cardInfo");
        return r3.a.j(true);
    }

    public AudienceShelfDisplayItemViewHolder(View r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.k = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final void U3(CommonProductLabelLayout r2, com.bytedance.android.live.openplatform.api.model.shelf.a r3) {
        a r4 = (a) r3;
        Intrinsics.checkNotNullParameter(r2, "labelLayout");
        Intrinsics.checkNotNullParameter(r4, "cardInfo");
        Intrinsics.checkNotNullParameter(r4, "displayCardInfo");
        List<ProductLabelInfo> r5 = rq0.b.b(r4.a, r4.b);
        if ((!r5.isEmpty()) == false) goto L5;
        r2.r(r5);
        r2.setVisibility(0);
        return;
    L5:
        r2.setVisibility(8);
    }
}
