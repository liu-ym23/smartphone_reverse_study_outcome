package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKRivalsSearchFootViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p extends me.drakeet.multitype.b<a, PKRivalsSearchFootViewHolder> {

    public static final class a {
        public int a;

        public a() {
        }

        public final int getType() {
            return this.a;
        }
    }

    public p() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        PKRivalsSearchFootViewHolder r4 = (PKRivalsSearchFootViewHolder) r2;
        a r5 = (a) r3;
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
        return new PKRivalsSearchFootViewHolder(r4.inflate(2131566366, r5, false));
    }
}
