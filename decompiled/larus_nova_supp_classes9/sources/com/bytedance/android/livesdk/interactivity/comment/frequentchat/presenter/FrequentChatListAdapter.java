package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/presenter/FrequentChatListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> a;
    public final b b;

    public final class a extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131362242);
            this.b = (TextView) r2.findViewById(2131362267);
        }
    }

    public interface b {
        FrequentChatShowMode L();

        void O(FrequentChatViewHolder r1);

        void R();

        void U(com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r1);

        boolean j();

        void k(CharSequence r1, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r2);

        long o();

        void u(com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r1);
    }

    public static final class c {
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ FrequentChatListAdapter a;

        public d(FrequentChatListAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            f2.c(s1.C(2131897040, new Object[]{Long.valueOf(this.a.b.o())}), 0);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ FrequentChatListAdapter a;

        public e(FrequentChatListAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b.R();
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        return ((com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) ListProtector.get(this.a, r2)).getType();
    }

    public FrequentChatListAdapter(List<com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c> r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "mDataList");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r8 = (com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c) ListProtector.get(this.a, r7);
        if ((r6 instanceof FrequentChatViewHolder) == false) goto L21;
        FrequentChatViewHolder r9 = (FrequentChatViewHolder) r6;
        r9.a.setText(r8.a);
        FrequentChatShowMode r0 = this.b.L();
        int r1 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.a.a[r0.ordinal()];
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L12;
        r9.d.setOnClickListener(null);
        r9.c.setOnClickListener(null);
        r9.a.setOnClickListener(null);
        r9.e.setOnLongClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.e(this, r9));
    L12:
        FrequentChatShowMode r10 = this.b.L();
        int r11 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.a.b[r10.ordinal()];
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L18;
        if (r11 != 3) goto L32;
        UtilityKotlinExtentionsKt.t(r9.d);
        UtilityKotlinExtentionsKt.t(r9.c);
        UtilityKotlinExtentionsKt.w(r9.e);
        return;
    L32:
        return;
    L18:
        UtilityKotlinExtentionsKt.t(r9.d);
        UtilityKotlinExtentionsKt.t(r9.c);
        UtilityKotlinExtentionsKt.t(r9.e);
        return;
    L19:
        UtilityKotlinExtentionsKt.w(r9.d);
        UtilityKotlinExtentionsKt.w(r9.c);
        UtilityKotlinExtentionsKt.t(r9.e);
        return;
    L10:
        r9.a.setOnClickListener(null);
        r9.e.setOnLongClickListener(null);
        r9.c.setOnClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.c(this, r8));
        r9.d.setOnClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.d(this, r8));
        goto L12
    L11:
        r9.d.setOnClickListener(null);
        r9.c.setOnClickListener(null);
        r9.e.setOnLongClickListener(null);
        r9.a.setOnClickListener(new com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter.b(this, r8));
        goto L12
    L21:
        if ((r6 instanceof a) == true) goto L23;
        return;
    L23:
        if (this.b.j() == false) goto L25;
        a r13 = (a) r6;
        r13.a.setBackground(s1.m(2131250662));
        r13.b.setTextColor(s1.h(2131107021));
        r6.itemView.setOnClickListener(new d(this));
        return;
    L25:
        a r14 = (a) r6;
        r14.a.setBackground(s1.m(2131248572));
        r14.b.setTextColor(s1.h(2131107032));
        r6.itemView.setOnClickListener(new e(this));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 == 1) goto L13;
        if (r7 == 2) goto L15;
        if (v.a() == true) goto L10;
        ALogger.e("FrequentChatListAdapter", "viewType{" + r7 + "}not supported");
        return new FrequentChatViewHolder(LayoutInflater.from(r6.getContext()).inflate(2131567673, r6, false));
    L10:
        throw new NoSuchElementException("FrequentChatListAdapter, viewType{" + r7 + "}not supported");
    L15:
        return new a(LayoutInflater.from(r6.getContext()).inflate(2131567596, r6, false));
    L13:
        return new FrequentChatViewHolder(LayoutInflater.from(r6.getContext()).inflate(2131567673, r6, false));
    }
}
