package qq0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayItemViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends me.drakeet.multitype.b<rq0.a, AudienceShelfDisplayItemViewHolder> {
    public final k b;

    public h(AudienceShelfDisplayDialog.e r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        AudienceShelfDisplayItemViewHolder r10 = (AudienceShelfDisplayItemViewHolder) r8;
        rq0.a r11 = (rq0.a) r9;
        Intrinsics.checkNotNullParameter(r10, "vh");
        Intrinsics.checkNotNullParameter(r11, "cardInfo");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "cardInfo");
        r10.a4(r11);
        boolean r2 = false;
        if (r11.getStatus() != 1) goto L12;
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r0 = MiniAppDataContext.a.b();
        if (r0 == null) goto L9;
        List<ShelfCardInfo> r1 = r0.cardInfoList;
        if (r1 == null) goto L9;
        int r3 = r1.size();
    L10:
        if (r3 <= 1) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        ((RecyclerView.ViewHolder) r10).itemView.setBackgroundResource(2131249558);
    L16:
        ((RecyclerView.ViewHolder) r10).itemView.setOnClickListener(new j(r10, r11, r4));
        Button r5 = r10.f;
        ProductInfo r6 = r11.getProductInfo();
        String r7 = null;
        if (r6 == null) goto L19;
        String r12 = r6.actionText;
    L20:
        if (r12 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == false) goto L26;
        String r13 = s1.B(2131920456);
    L30:
        r5.setText(r13);
        r5.setOnClickListener(new i(r10, r11, r4));
        return;
    L26:
        ProductInfo r14 = r11.getProductInfo();
        if (r14 == null) goto L29;
        r7 = r14.actionText;
    L29:
        r13 = r7;
        goto L30
    L22:
        if (StringsKt.isBlank(r12) == false) goto L24;
    L19:
        r12 = null;
        goto L20
    L15:
        ((RecyclerView.ViewHolder) r10).itemView.setBackgroundResource(2131249557);
    L9:
        r3 = 0;
    L12:
        r4 = false;
        goto L13
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new AudienceShelfDisplayItemViewHolder(r3.inflate(2131566956, r4, false), this.b);
    }
}
