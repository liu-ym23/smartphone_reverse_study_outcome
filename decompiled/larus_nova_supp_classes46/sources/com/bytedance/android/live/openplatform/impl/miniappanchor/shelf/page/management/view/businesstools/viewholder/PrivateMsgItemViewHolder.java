package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bq0.a;
import bq0.c;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/PrivateMsgItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/businesstools/viewholder/BaseBusinessToolItemViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivateMsgItemViewHolder extends BaseBusinessToolItemViewHolder {
    public final LinearLayout e;
    public final ImageView f;
    public final TextView g;

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder
    public final void T3(a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.T3(r3);
        if ((r3 instanceof c) == false) goto L9;
        this.e.setVisibility(0);
        if (((c) r3).f == false) goto L7;
        this.f.setImageResource(2131252362);
        this.g.setText(s1.B(2131920363));
        return;
    L7:
        this.f.setImageResource(2131252361);
        this.g.setText(s1.B(2131920361));
        return;
    }

    public PrivateMsgItemViewHolder(View r2, BaseBusinessToolItemViewHolder.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "businessToolItemListener");
        super(r2, r3);
        LinearLayout r4 = (LinearLayout) r2.findViewById(2131364972);
        this.e = r4;
        this.f = (ImageView) r4.findViewById(2131364973);
        this.g = (TextView) r4.findViewById(2131364974);
    }
}
