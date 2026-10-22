package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkUserViewHolder;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends me.drakeet.multitype.b<a, AnchorLinkUserViewHolder> {
    public final int b;
    public final i21.b c;

    public static final class a {
        public IRoom a;
        public IRivalExtraInfo b;
        public int c;
        public List<? extends IBattleRivalTag> d;
        public m2 e;
        public int f;
        public String g;
        public final String h;
        public boolean i;
        public int j;

        public a() {
            this.h = "link_banner";
        }
    }

    public final void g(RecyclerView.ViewHolder r2) {
        AnchorLinkUserViewHolder r3 = (AnchorLinkUserViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getClass();
    }

    public g(int r2, i21.b r3) {
        Intrinsics.checkNotNullParameter(r3, "mListener");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r9, Object r10) {
        AnchorLinkUserViewHolder r0 = (AnchorLinkUserViewHolder) r9;
        a r1 = (a) r10;
        Intrinsics.checkNotNullParameter(r0, "holder");
        Intrinsics.checkNotNullParameter(r1, "item");
        r0.V3(r1, r1.a, r1.e, r1.b, r1.c, r1.d, r1.f);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (this.b != 2) goto L5;
        t21.a r1 = new s21.e(r4, r5);
    L6:
        r1.init();
        return new AnchorLinkUserViewHolder(r1, this.c);
    L5:
        r1 = new s21.b(r4, r5);
        goto L6
    }
}
