package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.VideoRoomPreApplyTitleViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends me.drakeet.multitype.b<a, VideoRoomPreApplyTitleViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public o() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        VideoRoomPreApplyTitleViewHolder r4 = (VideoRoomPreApplyTitleViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter((a) r3, "item");
        ((TextView) r4.a.getValue()).setText(2131894405);
        ((TextView) r4.b.getValue()).setText(2131923706);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new VideoRoomPreApplyTitleViewHolder(r3.inflate(2131566434, r4, false));
    }
}
