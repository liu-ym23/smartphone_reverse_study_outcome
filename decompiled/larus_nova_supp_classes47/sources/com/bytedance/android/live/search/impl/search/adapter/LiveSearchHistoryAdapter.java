package com.bytedance.android.live.search.impl.search.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.search.impl.search.f;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchSugHistoryMoreViewHolder;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.discover.adapter.LiveSearchSugHistoryViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ra1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<g> a;
    public final String b;
    public qa1.c c;
    public boolean d;
    public final b e;

    public static final class a {
    }

    public static final class b implements qa1.b {
        public final /* synthetic */ LiveSearchHistoryAdapter a;

        @Override // qa1.b
        public final void a() {
            LiveSearchHistoryAdapter r0 = this.a;
            r0.d = true;
            r0.notifyDataSetChanged();
            int r1 = com.bytedance.android.live.search.impl.search.g.a;
            HashMap r2 = new HashMap();
            r2.put("action_type", "show_all");
            u.l().e("search_history", r2, new Object[0]);
        }

        @Override // qa1.b
        public final void deleteAll() {
            LiveSearchHistoryAdapter r0 = this.a;
            r0.d = false;
            ((ArrayList) r0.a).clear();
            this.a.notifyDataSetChanged();
            f.d.getClass();
            f.b(new ArrayList());
            int r1 = com.bytedance.android.live.search.impl.search.g.a;
            HashMap r2 = new HashMap();
            r2.put("action_type", "clear_all");
            u.l().e("search_history", r2, new Object[0]);
        }

        public b(LiveSearchHistoryAdapter r1) {
            this.a = r1;
        }
    }

    public static final class c implements LiveSearchSugHistoryViewHolder.OnDeleteItemClickListener {
        public final /* synthetic */ LiveSearchHistoryAdapter a;

        public c(LiveSearchHistoryAdapter r1) {
            this.a = r1;
        }

        public final void a(int r2) {
            if (r2 >= 0) goto L4;
        L6:
            this.a.notifyDataSetChanged();
            return;
        L4:
            if (r2 >= ((ArrayList) this.a.a).size()) goto L6;
            ListProtector.remove(this.a.a, r2);
            goto L6
        }
    }

    static {
    }

    public final int getItemCount() {
        boolean r2 = false;
        if (this.d == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return 6;
    L11:
        if (this.d == true) goto L13;
    L15:
        if (r2 == false) goto L18;
        return y2() + 1;
    L18:
        return y2();
    L13:
        if (((ArrayList) this.a).size() <= 5) goto L15;
        r2 = true;
        goto L15
    L5:
        if (((ArrayList) this.a).size() <= 5) goto L7;
        r0 = true;
        goto L8
    }

    public final int y2() {
        if (((ArrayList) this.a).size() <= 10) goto L6;
        return 10;
    L6:
        return ((ArrayList) this.a).size();
    }

    public LiveSearchHistoryAdapter(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = new ArrayList();
        this.b = "";
        LiveSearchIntermediateViewModel r3 = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r2).get(LiveSearchIntermediateViewModel.class);
        this.e = new b(this);
    }

    public final int getItemViewType(int r5) {
        boolean r1 = false;
        if (this.d == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        if (r5 != 5) goto L12;
    L26:
        return 2;
    L12:
        if (this.d == true) goto L14;
    L16:
        if (r1 == true) goto L18;
    L20:
        if (r5 < 0) goto L26;
        if (r5 >= ((ArrayList) this.a).size()) goto L26;
        if (((g) ListProtector.get(this.a, r5)).d() == false) goto L26;
        return 1;
    L18:
        if (r5 != y2()) goto L20;
        return 3;
    L14:
        if (((ArrayList) this.a).size() <= 5) goto L16;
        r1 = true;
        goto L16
    L5:
        if (((ArrayList) this.a).size() <= 5) goto L7;
        r0 = true;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        int r0 = getItemViewType(r5);
        boolean r1 = true;
        if (r0 != 1) goto L6;
        ((LiveSearchSugHistoryViewHolder) r4).T3((g) ListProtector.get(this.a, r5), this.b, r5, new c(this));
        return;
    L6:
        if ((r4 instanceof LiveSearchSugHistoryMoreViewHolder) == true) goto L8;
        r4 = null;
    L8:
        LiveSearchSugHistoryMoreViewHolder r6 = (LiveSearchSugHistoryMoreViewHolder) r4;
        if (r6 != null) goto L11;
        return;
    L11:
        if (r0 == 2) goto L14;
        r1 = false;
    L14:
        b r7 = this.e;
        Intrinsics.checkNotNullParameter(r7, "listener");
        TextView r2 = (TextView) ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131388367);
        if (r1 == false) goto L17;
        int r3 = 2131922375;
    L18:
        r2.setText(s1.B(r3));
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new sa1.a(r1, r7));
        return;
    L17:
        r3 = 2131922376;
        goto L18
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 1) goto L6;
        LiveSearchSugHistoryViewHolder.Companion r7 = LiveSearchSugHistoryViewHolder.b;
        qa1.c r1 = this.c;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new LiveSearchSugHistoryViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131567425, r5, false), r1);
    L6:
        if (r6 != 3) goto L8;
    L11:
        int r8 = LiveSearchSugHistoryMoreViewHolder.a;
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new LiveSearchSugHistoryMoreViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131567421, r5, false));
    L8:
        if (r6 == 2) goto L11;
        int r9 = LiveSearchSugHistoryMoreViewHolder.a;
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new LiveSearchSugHistoryMoreViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131567421, r5, false));
    }
}
