package com.ss.android.lark.forwardv3.recentforward;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.forwardv3.recentforward.viewholder.EmptyViewHolder;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xib.c;
import xib.f;
import xib.g;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u001a\u0010\u001e\u001a\u00020\u00162\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010 H\u0016J2\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u001c2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "context", "Landroid/content/Context;", "itemClickHandler", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemClickListener;", "onItemBusinessConsumeClickListener", "Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemBusinessConsumeClickListener;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemClickListener;Lcom/ss/android/lark/forwardv3/recentforward/RecentForwardAdapterV3$OnItemBusinessConsumeClickListener;)V", "binderRepo", "Lcom/ss/android/lark/forwardv3/recentforward/binder/BinderRepo;", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "", "isValid", "", "item", "diff", "collection", "", "withPayloads", "clearCheckedStatus", "switchMultiple", "isMultiple", "OnItemClickListener", "OnItemBusinessConsumeClickListener", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RecentForwardAdapterV3 extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, SearchBaseInfo> {
    public final Context a;
    public final xib.b b;

    public interface a {
        boolean a(SearchBaseInfo r1);
    }

    public interface b {
        void a(SearchBaseInfo r1, int r2, boolean r3);
    }

    public final void y2() {
        Iterator r0 = ((LarkRecyclerViewBaseAdapter) this).items.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SearchBaseInfo) r0.next()).selected(false);
        goto L4
    L6:
        notifyDataSetChanged();
    }

    public final void diff(Collection<? extends SearchBaseInfo> r6) {
        boolean r0 = com.ss.android.lark.forwardv3.utils.b.a("lark.forward.disable_recent_forward_thread_filter", false);
        Log.i("FGUtils", "FG key: core.forward.disable_recent_forward_thread_filter: " + r0);
        if (r0 == true) goto L22;
        if (r6 == null) goto L20;
        ArrayList r1 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L19;
        Object r2 = r7.next();
        SearchBaseInfo r3 = (SearchBaseInfo) r2;
        if ((r3 instanceof SearchChatInfo) == false) goto L11;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L7;
        r1.add(r2);
        goto L7
    L11:
        if ((r3 instanceof SearchChatterInfo) == true) goto L16;
        if ((r3 instanceof SearchShieldP2PChatInfo) == true) goto L16;
        r4 = false;
        goto L17
    L19:
        List r8 = CollectionsKt.toMutableList(r1);
    L21:
        super.diff(r8);
        return;
    L20:
        r8 = null;
        goto L21
    L22:
        super.diff(r6);
    }

    public final int getItemViewType(int r2) {
        SearchBaseInfo r3 = (SearchBaseInfo) getItem(r2);
        if ((r3 instanceof SearchChatInfo) == false) goto L6;
        return 1;
    L6:
        if ((r3 instanceof SearchChatterInfo) == false) goto L9;
        return 2;
    L9:
        if ((r3 instanceof SearchShieldP2PChatInfo) == false) goto L11;
        return 3;
    L11:
        return 0;
    }

    public final void switchMultiple(boolean r3) {
        xib.b r0 = this.b;
        r0.a.a = r3;
        r0.b.a = r3;
        r0.c.a = r3;
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        z2(r4, r3, false, new ArrayList());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 == 1) goto L10;
        if (r6 == 2) goto L10;
        if (r6 == 3) goto L10;
        return new EmptyViewHolder(new View(this.a));
    L10:
        return new RecentForwardViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131561663, r5, false), r6);
    }

    public RecentForwardAdapterV3(Context r2, b r3, a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r4, "onItemBusinessConsumeClickListener");
        this.a = r2;
        this.b = new xib.b(r3, r4);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        z2(r3, r2, !r4.isEmpty(), r4);
    }

    public final void z2(int r8, RecyclerView.ViewHolder r9, boolean r10, List<Object> r11) {
        SearchShieldP2PChatInfo r0 = (SearchBaseInfo) getItem(r8);
        if ((r9 instanceof RecentForwardViewHolder) == false) goto L32;
        RecentForwardViewHolder r12 = (RecentForwardViewHolder) r9;
        int r1 = r12.a;
        int r3 = 0;
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L12;
        return;
    L12:
        if (r10 == false) goto L14;
        g r13 = this.b.c;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo");
        r13.c(r0, r12, r11);
        return;
    L14:
        g r14 = this.b.c;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo");
        SearchShieldP2PChatInfo r2 = r0;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r12, "holder");
        r14.a(r8, r2, r12);
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r12, "holder");
        ImageView r15 = r12.e;
        if (r15 == null) goto L34;
        r15.setBackground(d.e(r15.getContext(), 2131237487));
        r15.setVisibility(0);
        return;
    L34:
        return;
    L18:
        if (r10 == false) goto L20;
        c r16 = this.b.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatterInfo");
        r16.c((SearchChatterInfo) r0, r12, r11);
        return;
    L20:
        c r17 = this.b.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatterInfo");
        r17.a(r8, (SearchChatterInfo) r0, r12);
        return;
    L22:
        if (r10 == false) goto L24;
        f r18 = this.b.b;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatInfo");
        r18.c((SearchChatInfo) r0, r12, r11);
        return;
    L24:
        f r19 = this.b.b;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatInfo");
        SearchChatInfo r4 = (SearchChatInfo) r0;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r12, "holder");
        r19.a(r8, r4, r12);
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r12, "holder");
        ImageView r20 = r12.e;
        if (r20 == null) goto L39;
        r20.setBackground(d.e(r20.getContext(), 2131237487));
        if (r4.isShield() == true) goto L30;
        r3 = 8;
    L30:
        r20.setVisibility(r3);
        return;
    L39:
        return;
    }
}
