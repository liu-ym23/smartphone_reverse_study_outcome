package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.TalkRoomNormalApplyTitleViewHolder;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m extends me.drakeet.multitype.b<a, TalkRoomNormalApplyTitleViewHolder> {
    public final com.bytedance.android.live.liveinteract.linkpanel.list.a b;
    public final LinkedList<?> c;

    public static final class a {
        public final boolean a;
        public final int b;
        public final ApplyTitlePanelType c;

        public /* synthetic */ a(boolean r2, int r3) {
            this(r2, r3, ApplyTitlePanelType.UNKNOWN);
        }

        public a(boolean r2, int r3, ApplyTitlePanelType r4) {
            Intrinsics.checkNotNullParameter(r4, "panelType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public m(com.bytedance.android.live.liveinteract.linkpanel.list.a r1, LinkedList<?> r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        TalkRoomNormalApplyTitleViewHolder r5 = (TalkRoomNormalApplyTitleViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.T3(r6.a, r6.b, r6.c);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new TalkRoomNormalApplyTitleViewHolder(r3.inflate(2131566416, r4, false), this.b, this.c);
    }
}
