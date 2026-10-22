package com.larus.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.flowskill.impl.databinding.LarusItemTaskProjectBinding;
import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0017\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/larus/project/TaskProjectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/project/TaskProjectListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/project/TaskProject;", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "ProjectViewHolder", "LoadingViewHolder", "TaskProjectDiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TaskProjectAdapter extends ListAdapter<w, RecyclerView.ViewHolder> {
    public Function1<? super i, Unit> a;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final LarusItemTaskProjectBinding a;

        public c(LarusItemTaskProjectBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class d extends DiffUtil.ItemCallback<w> {
        public d() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            w r4 = (w) r2;
            w r5 = (w) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            w r4 = (w) r2;
            w r5 = (w) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            if ((r4 instanceof w.b) == false) goto L8;
            if ((r5 instanceof w.b) == false) goto L8;
            return Intrinsics.areEqual(((w.b) r4).a.a, ((w.b) r5).a.a);
        L8:
            if (r4.getClass() != r5.getClass()) goto L10;
            return true;
        L10:
            return false;
        }
    }

    static {
    }

    public TaskProjectAdapter() {
        super(new d());
    }

    public final int getItemViewType(int r2) {
        w r3 = (w) getItem(r2);
        if ((r3 instanceof w.b) == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r3, w.a.a) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        w r8 = (w) getItem(r7);
        if ((r6 instanceof b) == false) goto L5;
    L27:
        r6.itemView.setOnClickListener(null);
        return;
    L5:
        if ((r8 instanceof w.b) == false) goto L27;
        c r9 = (c) r6;
        final i r10 = ((w.b) r8).a;
        final Function1<? super i, Unit> r0 = this.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, SlashMentionConfig.SLASH_CONTENT_PROJECT);
        LarusItemTaskProjectBinding r11 = r9.a;
        AppCompatImageView r1 = r11.e;
        r1.setImageResource(v19.c.b(2130971854, r1.getContext(), 2131242093));
        r11.f.setText(r10.b);
        AppCompatImageView r2 = r11.d;
        String r3 = r10.f;
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        int r5 = 8;
        if (r4 == false) goto L17;
        int r12 = 8;
    L18:
        r2.setVisibility(r12);
        AppCompatImageView r13 = r11.g;
        if (r10.i == false) goto L21;
        r5 = 0;
    L21:
        r13.setVisibility(r5);
        ConstraintLayout r14 = r11.b;
        if (r10.j == false) goto L24;
        float r15 = 1.0f;
    L25:
        r14.setAlpha(r15);
        r11.c.setVisibility(0);
        r11.a.setOnClickListener(new j(r0, r10));
        return;
    L24:
        r15 = 0.4f;
        goto L25
    L17:
        r12 = 0;
        goto L18
    L10:
        if (StringsKt.isBlank(r3) == true) goto L13;
        r4 = false;
        goto L14
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 1) goto L6;
        return new b(r0.inflate(2131562686, r4, false));
    L6:
        return new c(LarusItemTaskProjectBinding.a(r0.inflate(2131562685, r4, false)));
    }
}
