package qq0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.PrivateMsgEntranceItemViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends me.drakeet.multitype.b<lo0.a, PrivateMsgEntranceItemViewHolder> {
    public final PrivateMsgEntranceItemViewHolder.a b;

    public l(d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        PrivateMsgEntranceItemViewHolder r6 = (PrivateMsgEntranceItemViewHolder) r4;
        lo0.a r7 = (lo0.a) r5;
        Intrinsics.checkNotNullParameter(r6, "vh");
        Intrinsics.checkNotNullParameter(r7, "privateMsgEntranceInfo");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "privateMsgEntranceInfo");
        HSImageView r0 = r6.a;
        String r1 = r7.a();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        ImageLoader.bindImage(r0, r1);
        HSImageView r3 = r6.b;
        String r8 = r7.f();
        if (r8 == null) goto L9;
        r2 = r8;
    L9:
        ImageLoader.bindImage(r3, r2);
        r6.c.setText(r7.h());
        r6.d.setText(r7.c());
        r6.e.setText(r7.d());
        r6.e.setOnClickListener(new m(r6, r7));
        r6.f.a(r7);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new PrivateMsgEntranceItemViewHolder(r3.inflate(2131566953, r4, false), this.b);
    }
}
