package q21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkTabExtViewHolder;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.TabExtPagerAdapter;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.TabFragment;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends me.drakeet.multitype.b<a, AnchorLinkTabExtViewHolder> {
    public final FragmentManager b;
    public final List<TabFragment> c;
    public final me.drakeet.multitype.e d;

    public static final class a {
        public final List<b> a;
        public final MutableLiveData<Integer> b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<b> r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            MutableLiveData<Integer> r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AnchorLinkTabExtViewBinderData(tabs=" + this.a + ", tabSelectedIndex=" + this.b + ")";
        }

        public a(List<b> r2, MutableLiveData<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "tabs");
            Intrinsics.checkNotNullParameter(r3, "tabSelectedIndex");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final int a;
        public final List<Object> b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            List<Object> r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "SubTabBinderData(rivals=" + this.a + ", items=" + this.b + ")";
        }

        public b(int r2, List<? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r3, "items");
            this.a = r2;
            this.b = r3;
        }
    }

    public final void g(RecyclerView.ViewHolder r2) {
        AnchorLinkTabExtViewHolder r3 = (AnchorLinkTabExtViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        MutableLiveData<Integer> r0 = r3.d;
        if (r0 == null) goto L6;
        r0.removeObserver(r3.b);
        return;
    }

    public final void b(RecyclerView.ViewHolder r7, Object r8) {
        AnchorLinkTabExtViewHolder r9 = (AnchorLinkTabExtViewHolder) r7;
        a r10 = (a) r8;
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        r9.d = r10.b;
        TabExtPagerAdapter r0 = r9.a;
        if (r0 == null) goto L24;
        List<b> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "tabs");
        ((ArrayList) r0.a).clear();
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L24;
        b r1 = (b) r13.next();
        Iterator<T> r2 = r0.b.iterator();
    L9:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        b r4 = ((TabFragment) r3).f;
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L9;
    L19:
        TabFragment r6 = (TabFragment) r3;
        if (r6 == null) goto L22;
        r6.S90(r1);
    L23:
        ((ArrayList) r0.a).add(r6);
        goto L6
    L22:
        r6 = new TabFragment(r0.c);
        r6.S90(r1);
        r0.b.add(r6);
        goto L23
    L13:
        if (r4.a != r1.a) goto L15;
        r5 = true;
        goto L16
    L18:
        r3 = null;
    L24:
        TabExtPagerAdapter r14 = r9.a;
        if (r14 == null) goto L27;
        r14.notifyDataSetChanged();
    L27:
        MutableLiveData<Integer> r15 = r9.d;
        Intrinsics.checkNotNull(r15);
        x.e(r15, r9.b);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        View r6 = r4.inflate(2131566229, r5, false);
        r6.setId(ViewCompat.generateViewId());
        Unit r7 = Unit.INSTANCE;
        return new AnchorLinkTabExtViewHolder(r6, this.b, this.c, this.d);
    }

    public d(FragmentManager r2, List<TabFragment> r3, me.drakeet.multitype.e r4) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "tabFragmentCache");
        Intrinsics.checkNotNullParameter(r4, "typePool");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
