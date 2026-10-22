package com.bytedance.android.live.revlink.impl.pk.dialog.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.PKRivalsPanelSearchWidget;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j;
import com.bytedance.android.live.revlink.impl.pk.utils.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/adapter/PKRivalsSearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "DummyViewHolder", "SearchHistoryViewHolder", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public int a;
    public final List<String> b;
    public int c;
    public String d;
    public final Context e;
    public final j f;
    public final x31.j g;
    public final u h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/adapter/PKRivalsSearchHistoryAdapter$DummyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class DummyViewHolder extends RecyclerView.ViewHolder {
        public final /* synthetic */ PKRivalsSearchHistoryAdapter a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ DummyViewHolder a;

            public a(DummyViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r1) {
                this.a.a.f.e();
            }
        }

        public DummyViewHolder(PKRivalsSearchHistoryAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.a = r2;
            super(r3);
            r3.setOnClickListener(new a(this));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/adapter/PKRivalsSearchHistoryAdapter$SearchHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class SearchHistoryViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final View c;
        public final TextView d;
        public String e;
        public final /* synthetic */ PKRivalsSearchHistoryAdapter f;

        public SearchHistoryViewHolder(PKRivalsSearchHistoryAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.f = r2;
            super(r3);
            this.a = r3.findViewById(2131374403);
            this.b = (TextView) r3.findViewById(2131374394);
            this.c = r3.findViewById(2131384272);
            this.d = (TextView) r3.findViewById(2131374394);
            this.e = "";
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public final int getItemViewType(int r1) {
        return this.a;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        if ((r6 instanceof SearchHistoryViewHolder) == false) goto L20;
        SearchHistoryViewHolder r8 = (SearchHistoryViewHolder) r6;
        String r9 = (String) ListProtector.get(this.b, r7);
        int r0 = this.a;
        int r1 = this.c;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "content");
        r8.e = r9;
        r8.b.setText(r9);
        if (r0 != 0) goto L7;
        r8.a.setVisibility(8);
        r8.c.setOnClickListener(null);
        return;
    L7:
        if (r0 == 2) goto L9;
        r8.a.setVisibility(0);
        r8.c.setBackgroundResource(2131251332);
        r8.c.setOnClickListener(new c(r8));
        r8.b.setOnClickListener(new d(r8));
        return;
    L9:
        r8.a.setVisibility(8);
        ViewGroup.LayoutParams r10 = r8.d.getLayoutParams();
        if (r10 == null) goto L17;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10;
        r12.leftMargin = s1.f(20.0f);
        SpannableString r2 = new SpannableString(r8.d.getText());
        ForegroundColorSpan r3 = new ForegroundColorSpan(s1.h(2131108036));
        if (r2.length() >= r1) goto L15;
        r1 = r2.length();
    L15:
        r2.setSpan(r3, 0, r1, 18);
        r8.d.setText(r2);
        r8.d.setLayoutParams(r12);
        r8.c.setBackgroundResource(2131251062);
        r8.c.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.adapter.a(r8));
        r8.b.setOnClickListener(new b(r8));
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        if (r4 == 1) goto L9;
        if (r4 == 2) goto L9;
        return new DummyViewHolder(this, LayoutInflater.from(this.e).inflate(2131566369, r3, false));
    L9:
        return new SearchHistoryViewHolder(this, LayoutInflater.from(this.e).inflate(2131566367, r3, false));
    }

    public PKRivalsSearchHistoryAdapter(Context r2, j r3, PKRivalsPanelSearchWidget r4, u r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mPresenter");
        Intrinsics.checkNotNullParameter(r4, "mListener");
        Intrinsics.checkNotNullParameter(r5, "searchSource");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = 1;
        this.b = new ArrayList();
        this.d = "";
    }
}
