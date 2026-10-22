package com.ss.android.lark.inline.ai.asr.subprompt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import h18.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import slb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "currentIndex", "", "lastIndex", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "SubPromptViewHolder", "OnOperateClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SubPromptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<j> a;
    public int b;
    public int c;
    public a d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "newList", "lastIndex", "", "currentIndex", "<init>", "(Ljava/util/List;Ljava/util/List;II)V", "getOldListSize", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<j> a;
        public final List<j> b;
        public final int c;
        public final int d;

        public final int getNewListSize() {
            List<j> r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getOldListSize() {
            List<j> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final boolean areContentsTheSame(int r2, int r3) {
            if (r2 != this.c) goto L5;
        L7:
            return false;
        L5:
            if (r3 == this.d) goto L7;
            return true;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            List<j> r0 = this.a;
            String r1 = null;
            if (r0 == null) goto L7;
            j r5 = (j) CollectionsKt.getOrNull(r0, r3);
            if (r5 == null) goto L7;
            String r6 = r5.a;
        L8:
            List<j> r2 = this.b;
            if (r2 == null) goto L14;
            j r7 = (j) CollectionsKt.getOrNull(r2, r4);
            if (r7 == null) goto L14;
            r1 = r7.a;
        L14:
            return Intrinsics.areEqual(r6, r1);
        L7:
            r6 = null;
            goto L8
        }

        public DiffCallback(List<j> r1, List<j> r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$SubPromptViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "subPromptTextView", "Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptTextView;", "getSubPromptTextView", "()Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptTextView;", "subPromptSelectedIv", "Landroidx/appcompat/widget/AppCompatImageView;", "getSubPromptSelectedIv", "()Landroidx/appcompat/widget/AppCompatImageView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class SubPromptViewHolder extends RecyclerView.ViewHolder {
        public final SubPromptTextView a;
        public final AppCompatImageView b;

        public SubPromptViewHolder(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (SubPromptTextView) r2.findViewById(2131387582);
            this.b = r2.findViewById(2131387581);
        }
    }

    public interface a {
        void a(j r1);
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SubPromptAdapter a;
        public final /* synthetic */ RecyclerView.ViewHolder b;
        public final /* synthetic */ j c;

        public b(SubPromptAdapter r1, RecyclerView.ViewHolder r2, j r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            SubPromptAdapter r5 = this.a;
            r5.b = this.b.getBindingAdapterPosition();
            a r6 = this.a.d;
            if (r6 == null) goto L5;
            r6.a(this.c);
        L5:
            SubPromptAdapter r0 = this.a;
            List<j> r1 = r0.a;
            DiffUtil.calculateDiff(new DiffCallback(r1, r1, r0.c, r0.b), false).dispatchUpdatesTo(this.a);
        }
    }

    public final int getItemCount() {
        List<j> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public SubPromptAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        List<j> r0 = this.a;
        if (r0 == null) goto L13;
        j r1 = (j) ListProtector.get(r0, r6);
        if (r1 == null) goto L14;
        SubPromptViewHolder r2 = (SubPromptViewHolder) r5;
        int r3 = this.b;
        if (r3 != r6) goto L10;
        this.c = r3;
        r2.b.setVisibility(0);
        AppCompatTextView r7 = r2.a;
        int r4 = e.a;
        r7.setTypeface(e.b(r7.getContext(), 1));
        r2.a.setType("primary");
    L11:
        r2.a.setText(r1.d);
        ((RecyclerView.ViewHolder) r2).itemView.setOnClickListener(new b(this, r5, r1));
        return;
    L10:
        r2.b.setVisibility(8);
        AppCompatTextView r8 = r2.a;
        int r9 = e.a;
        r8.setTypeface(e.b(r8.getContext(), 0));
        r2.a.setType(LocationHitPoint$ResultType.DEFAULT);
        goto L11
    L14:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131561543, r3, false);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        return new SubPromptViewHolder((ViewGroup) r5);
    }
}
