package com.bytedance.android.live.search.impl.search.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.search.impl.search.helper.d;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchSugViewHolder;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.discover.adapter.LiveSearchSugHistoryViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa1.c;
import ra1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchSugAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveSearchSugAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<g> a;
    public String b;
    public String c;
    public c d;

    public static final class a {
    }

    public static final class b implements LiveSearchSugHistoryViewHolder.OnDeleteItemClickListener {
        public final /* synthetic */ LiveSearchSugAdapter a;

        public b(LiveSearchSugAdapter r1) {
            this.a = r1;
        }

        public final void a(int r2) {
            if (r2 > 0) goto L4;
        L6:
            this.a.notifyItemRemoved(r2);
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
        return ((ArrayList) this.a).size();
    }

    public LiveSearchSugAdapter(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = new ArrayList();
        this.b = "";
        this.c = "";
        LiveSearchIntermediateViewModel r3 = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r2).get(LiveSearchIntermediateViewModel.class);
    }

    public final int getItemViewType(int r2) {
        return ((g) ListProtector.get(this.a, r2)).d() ? 1 : 0;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        if ((r5 instanceof LiveSearchSugViewHolder) == false) goto L13;
        LiveSearchSugViewHolder r6 = (LiveSearchSugViewHolder) r5;
        r6.getClass();
        int r0 = com.bytedance.android.live.search.impl.search.g.a;
        String r1 = r6.e;
        String r2 = r6.c;
        g r7 = r6.b;
        if (r7 == null) goto L7;
        Map<String, String> r8 = r7.b();
    L8:
        Intrinsics.checkNotNullParameter(r1, "keyword");
        Intrinsics.checkNotNullParameter(r2, "rid");
        HashMap r3 = new HashMap();
        r3.put("raw_query", r1);
        r3.put("query_id", r2);
        r3.put("search_position", "live_square");
        r3.put("word_source", "sug");
        r3.put("rank", "-1");
        if (r8 == null) goto L11;
        r3.putAll(r8);
    L11:
        u.l().e("trending_words_show", r3, new Object[0]);
        return;
    L7:
        r8 = null;
        goto L8
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        if (getItemViewType(r14) != 1) goto L5;
        ((LiveSearchSugHistoryViewHolder) r13).T3((g) ListProtector.get(this.a, r14), this.b, r14, new b(this));
        return;
    L5:
        LiveSearchSugViewHolder r15 = (LiveSearchSugViewHolder) r13;
        g r0 = (g) ListProtector.get(this.a, r14);
        String r2 = this.b;
        String r3 = this.c;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r2, "requestId");
        Intrinsics.checkNotNullParameter(r3, "keyword");
        if (r0 == null) goto L60;
        r15.b = r0;
        r15.c = r2;
        int r4 = d.a;
        Context r5 = ((RecyclerView.ViewHolder) r15).itemView.getContext();
        String r6 = r0.a();
        List<ra1.d> r7 = r0.c();
        if (r7 != null) goto L11;
        r7 = new ArrayList();
    L11:
        Intrinsics.checkNotNullParameter(r7, "positions");
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        if (r5 != null) goto L16;
    L34:
        SpannableString r8 = new SpannableString(r6);
    L35:
        TextView r9 = r15.a;
        if (r9 == null) goto L39;
        r9.setText(r8);
    L39:
        if (r0.a == true) goto L41;
        r0.a = true;
    L41:
        ((RecyclerView.ViewHolder) r15).itemView.setOnClickListener(new sa1.b(r15, r0, r2, r14));
        View r16 = r15.d;
        if (r16 == null) goto L44;
        r16.setOnClickListener(new sa1.c(r15, r0));
    L44:
        r15.e = r3;
        r3.a(r15.d, s1.B(2131914432));
        return;
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L34;
        if (CollectionUtils.isEmpty(r7) == true) goto L34;
        r8 = new SpannableString(r6);
        Iterator<ra1.d> r10 = r7.iterator();
    L22:
        if (r10.hasNext() == false) goto L35;
        ra1.d r12 = r10.next();
        if (r12 == null) goto L22;
        int r17 = r12.a() + 0;
        int r18 = (r12.b() + 1) + 0;
        int r19 = r5.getResources().getColor(2131108258);
        Intrinsics.checkNotNullParameter(r8, "ss");
        int r20 = Math.max(0, r17);
        if (TextUtils.isEmpty(r8) == true) goto L22;
        if (r20 > r18) goto L22;
        if (r20 >= r8.length()) goto L22;
        if (r18 > r8.length()) goto L22;
        r8.setSpan(new ForegroundColorSpan(r19), r20, r18, 17);
        goto L22
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 1) goto L5;
        LiveSearchSugHistoryViewHolder.Companion r6 = LiveSearchSugHistoryViewHolder.b;
        c r1 = this.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LiveSearchSugHistoryViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567425, r4, false), r1);
    L5:
        int r7 = LiveSearchSugViewHolder.g;
        c r8 = this.d;
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new LiveSearchSugViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131567424, r4, false), r8);
    }

    public final void y2(List<g> r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "rid");
        Intrinsics.checkNotNullParameter(r4, "keyword");
        ((ArrayList) this.a).clear();
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r2);
        this.b = r3;
        this.c = r4;
    }
}
