package com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.ui.NoSwipeViewPager;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/viewholder/AnchorLinkTabExtViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorLinkTabExtViewHolder extends RecyclerView.ViewHolder {
    public final TabExtPagerAdapter a;
    public final a b;
    public final NoSwipeViewPager c;
    public MutableLiveData<Integer> d;

    public static final class a<T> implements Observer {
        public final /* synthetic */ AnchorLinkTabExtViewHolder a;

        public a(AnchorLinkTabExtViewHolder r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            NoSwipeViewPager r0 = this.a.c;
            if (r0 == null) goto L6;
            int r1 = r0.getCurrentItem();
            Intrinsics.checkNotNull(r4);
            if (r1 != r4.intValue()) goto L6;
            return;
        L6:
            NoSwipeViewPager r2 = this.a.c;
            if (r2 == null) goto L9;
            Intrinsics.checkNotNull(r4);
            r2.setCurrentItem(r4.intValue());
        L9:
            TabExtPagerAdapter r5 = this.a.a;
            if (r5 == null) goto L20;
            Intrinsics.checkNotNull(r4);
            int r6 = r4.intValue();
            if (r6 >= 0) goto L14;
            return;
        L14:
            if (r6 >= ((ArrayList) r5.a).size()) goto L22;
            PkItemExposeRecyclerView r7 = ((TabFragment) ListProtector.get(r5.a, r6)).d;
            if (r7 == null) goto L23;
            r7.scrollToPosition(0);
            return;
        L23:
            return;
        L22:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorLinkTabExtViewHolder(View r2, FragmentManager r3, List<TabFragment> r4, me.drakeet.multitype.e r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "fm");
        Intrinsics.checkNotNullParameter(r4, "tabFragmentCache");
        Intrinsics.checkNotNullParameter(r5, "typePool");
        super(r2);
        this.b = new a(this);
        NoSwipeViewPager r6 = (NoSwipeViewPager) r2;
        this.c = r6;
        TabExtPagerAdapter r0 = new TabExtPagerAdapter(r3, r4, r5);
        this.a = r0;
        r6.setAdapter(r0);
        r6.addOnPageChangeListener(new AnonymousClass1(this));
    }
}
