package yk0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.livepkaudience.dialog.viewholder.PKAudienceSearchFootViewHolder;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends b<C0295a, PKAudienceSearchFootViewHolder> {

    /* JADX INFO: renamed from: yk0.a$a, reason: collision with other inner class name */
    public static final class C0295a {
        public int a;

        public C0295a() {
        }

        public final int getType() {
            return this.a;
        }
    }

    public a() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        PKAudienceSearchFootViewHolder r4 = (PKAudienceSearchFootViewHolder) r2;
        C0295a r5 = (C0295a) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        int r6 = r5.getType();
        if (r6 != 0) goto L6;
        r4.a.setText(2131921546);
        return;
    L6:
        if (r6 != 1) goto L8;
        r4.a.setText(2131921548);
        return;
    L8:
        r4.getClass();
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new PKAudienceSearchFootViewHolder(r4.inflate(2131566348, r5, false));
    }
}
