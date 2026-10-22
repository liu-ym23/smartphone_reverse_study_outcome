package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/view/PrivateMsgEntranceItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivateMsgEntranceItemViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final HSImageView b;
    public final TextView c;
    public final TextView d;
    public final Button e;
    public final a f;

    public interface a {
        void a(lo0.a r1);

        void b(lo0.a r1);
    }

    public PrivateMsgEntranceItemViewHolder(View r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.f = r3;
        this.a = r2.findViewById(2131383052);
        this.b = r2.findViewById(2131383056);
        this.c = (TextView) r2.findViewById(2131383063);
        this.d = (TextView) r2.findViewById(2131383055);
        this.e = (Button) r2.findViewById(2131383053);
    }
}
