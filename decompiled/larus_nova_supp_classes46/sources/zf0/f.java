package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.GuestApplyPaidQueueViewHolder;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends me.drakeet.multitype.b<a, GuestApplyPaidQueueViewHolder> {
    public final Function1<Integer, Unit> b;
    public final boolean c;
    public final Function1<Integer, Unit> d;

    public static final class a {
        public final int a;
        public final ApplyTitlePanelType b;
        public final Pair<Integer, Integer> c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            ApplyTitlePanelType r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Pair<Integer, Integer> r5 = this.c;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "GuestApplyPaidQueueData(tabIndex=" + this.a + ", panelType=" + this.b + ", pair=" + this.c + ")";
        }

        public /* synthetic */ a(int r2, Pair r3) {
            this(r2, ApplyTitlePanelType.UNKNOWN, r3);
        }

        public a(int r2, ApplyTitlePanelType r3, Pair<Integer, Integer> r4) {
            Intrinsics.checkNotNullParameter(r3, "panelType");
            Intrinsics.checkNotNullParameter(r4, "pair");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        GuestApplyPaidQueueViewHolder r5 = (GuestApplyPaidQueueViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.T3(r6.a, r6.b, r6.c);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new GuestApplyPaidQueueViewHolder(r4.inflate(2131567124, r5, false), this.c, this.b, this.d);
    }

    public f(Function1 r2, Function1 r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = null;
    L9:
        Intrinsics.checkNotNullParameter(r2, "tabClickListener");
        this.b = r2;
        this.c = r0;
        this.d = r3;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
