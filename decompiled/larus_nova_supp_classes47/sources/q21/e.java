package q21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkTabTitleViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends me.drakeet.multitype.b<a, AnchorLinkTabTitleViewHolder> {

    public static final class a {
        public final List<CharSequence> a;
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
            List<CharSequence> r0 = this.a;
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
            return "AnchorLinkTabTitleViewBinderData(titles=" + this.a + ", tabSelectedIndex=" + this.b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends CharSequence> r2, MutableLiveData<Integer> r3) {
            Intrinsics.checkNotNullParameter(r2, "titles");
            Intrinsics.checkNotNullParameter(r3, "tabSelectedIndex");
            this.a = r2;
            this.b = r3;
        }
    }

    public e() {
    }

    public final void b(RecyclerView.ViewHolder r9, Object r10) {
        AnchorLinkTabTitleViewHolder r12 = (AnchorLinkTabTitleViewHolder) r9;
        a r13 = (a) r10;
        Intrinsics.checkNotNullParameter(r12, "holder");
        Intrinsics.checkNotNullParameter(r13, "item");
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        MultiTypeAdapter r0 = r12.b;
        List<CharSequence> r1 = r13.a;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
        int r4 = 0;
    L4:
        if (r3.hasNext() == false) goto L9;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r2.add(new l.a(r4, (CharSequence) r5, r13.b));
        r4 = r6;
        goto L4
    L9:
        r0.a = r2;
        r12.b.notifyDataSetChanged();
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = r3.inflate(2131566230, r4, false);
        r5.setTag("RecyclerOptBar");
        Unit r6 = Unit.INSTANCE;
        return new AnchorLinkTabTitleViewHolder(r5);
    }
}
