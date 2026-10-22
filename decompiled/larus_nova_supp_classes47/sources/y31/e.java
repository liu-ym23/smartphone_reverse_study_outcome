package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKActBaseViewHolder;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.ActTitleInfoView;
import com.bytedance.android.livesdk.link.model.v9;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends me.drakeet.multitype.b<a, PKActBaseViewHolder> {
    public final ActTitleInfoView.b b;

    public static final class a {
        public final String a;
        public final v9 b;

        public a(String r2, v9 r3) {
            Intrinsics.checkNotNullParameter(r2, "activityId");
            Intrinsics.checkNotNullParameter(r3, "titleArea");
            this.a = r2;
            this.b = r3;
        }
    }

    public e(ActTitleInfoView.b r1) {
        this.b = r1;
    }

    public final void g(RecyclerView.ViewHolder r2) {
        PKActBaseViewHolder r3 = (PKActBaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.getClass();
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        PKActBaseViewHolder r6 = (PKActBaseViewHolder) r4;
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        r6.getClass();
        if (r7 == null) goto L17;
        v9 r0 = r7.b;
        if (r0 == null) goto L19;
        Object r1 = ((RecyclerView.ViewHolder) r6).itemView;
        if ((r1 instanceof ActTitleInfoView) == true) goto L10;
        r1 = null;
    L10:
        ActTitleInfoView r2 = (ActTitleInfoView) r1;
        if (r2 == null) goto L18;
        r2.setListener(r6.a);
        String r8 = r7.a;
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        r2.update(r8, r0);
        return;
    L18:
        return;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.ViewGroup, com.bytedance.android.live.revlink.impl.pk.flexactivity.ActTitleInfoView] */
    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        ?? r5 = new ActTitleInfoView(r4.getContext());
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r6 = Unit.INSTANCE;
        return new PKActBaseViewHolder(r5, this.b);
    }
}
