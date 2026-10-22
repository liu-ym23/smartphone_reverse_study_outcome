package mv1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.adapter.AppointmentListAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements b90.a {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final BaseViewHolder<Object> a(ViewGroup r4, Object[] r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        return new AppointmentListAdapter.AppointmentItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131565160, r4, false), this.a.c.getContext(), 3, this.a.c);
    }
}
