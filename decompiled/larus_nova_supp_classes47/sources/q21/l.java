package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.TabTitleItemViewHolder;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.n;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l extends me.drakeet.multitype.b<a, TabTitleItemViewHolder> {

    public static final class a {
        public final int a;
        public final CharSequence b;
        public final MutableLiveData<Integer> c;

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
            CharSequence r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            MutableLiveData<Integer> r5 = this.c;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "TabTitleItemViewBinderData(tabIndex=" + this.a + ", title=" + this.b + ", tabSelectedIndex=" + this.c + ")";
        }

        public a(int r2, CharSequence r3, MutableLiveData<Integer> r4) {
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "tabSelectedIndex");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public l() {
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        TabTitleItemViewHolder r5 = (TabTitleItemViewHolder) r3;
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.c = Integer.valueOf(r6.a);
        r5.a.setText(r6.b);
        r5.a.setOnClickListener(new n(r5));
        MutableLiveData<Integer> r7 = r6.c;
        r5.d = r7;
        Intrinsics.checkNotNull(r7);
        x.e(r7, r5.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new TabTitleItemViewHolder(r4.inflate(2131565138, r5, false));
    }
}
