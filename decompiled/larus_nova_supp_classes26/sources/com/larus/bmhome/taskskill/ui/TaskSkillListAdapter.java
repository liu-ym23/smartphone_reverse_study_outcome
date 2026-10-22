package com.larus.bmhome.taskskill.ui;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.taskskill.model.SkillType;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.ui.CommonTaskItemViewHolder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0013\u0014\u0015B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/TaskSkillListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/taskskill/ui/TaskSkillUiItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onSkillClick", "Lkotlin/Function1;", "Lcom/larus/bmhome/taskskill/model/TaskSkill;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "LoadingViewHolder", "TaskSkillViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskSkillListAdapter extends ListAdapter<r, RecyclerView.ViewHolder> {
    public static final TaskSkillListAdapter$Companion$DIFF_CALLBACK$1 b = null;
    public final Function1<TaskSkill, Unit> a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/TaskSkillListAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/taskskill/ui/TaskSkillListAdapter$TaskSkillViewHolder;", "Lcom/larus/ui/CommonTaskItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/taskskill/ui/TaskSkillListAdapter;Landroid/view/View;)V", "bind", "", "skill", "Lcom/larus/bmhome/taskskill/model/TaskSkill;", "showDivider", "", "bindTypeLabel", "type", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TaskSkillViewHolder extends CommonTaskItemViewHolder {
        public static final /* synthetic */ int l = 0;
        public final /* synthetic */ TaskSkillListAdapter k;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SkillType.values().length];
                r0[SkillType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[SkillType.ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[SkillType.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[SkillType.SYSTEM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[SkillType.STORE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public TaskSkillViewHolder(TaskSkillListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.k = r2;
            super(r3);
        }
    }

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.taskskill.ui.TaskSkillListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        b = new TaskSkillListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public TaskSkillListAdapter(o r2) {
        Intrinsics.checkNotNullParameter(r2, "onSkillClick");
        super(b);
        this.a = r2;
    }

    public final int getItemViewType(int r1) {
        return getItem(r1) instanceof r.a ? 1 : 0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        r r0 = (r) getItem(r8);
        Integer r2 = null;
        if ((r7 instanceof LoadingViewHolder) == false) goto L7;
        r7.itemView.setOnClickListener(null);
        return;
    L7:
        if ((r7 instanceof TaskSkillViewHolder) == true) goto L9;
        return;
    L9:
        if ((r0 instanceof r.b) == false) goto L46;
        TaskSkillViewHolder r9 = (TaskSkillViewHolder) r7;
        final TaskSkill r1 = ((r.b) r0).a;
        if (getItemCount() > 1) goto L13;
    L15:
        boolean r10 = false;
    L16:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "skill");
        ((CommonTaskItemViewHolder) r9).b.setText(r1.c());
        TextView r3 = ((CommonTaskItemViewHolder) r9).c;
        r3.setText(r1.b());
        r3.setMaxLines(1);
        r3.setEllipsize(TextUtils.TruncateAt.END);
        ((RecyclerView.ViewHolder) r9).itemView.setBackgroundResource(2131239803);
        View r4 = ((CommonTaskItemViewHolder) r9).d;
        if (r10 == false) goto L19;
        int r11 = 0;
    L20:
        r4.setVisibility(r11);
        AppCompatImageView r12 = ((CommonTaskItemViewHolder) r9).a;
        boolean r5 = v19.h.a;
        if (v19.h.b(((RecyclerView.ViewHolder) r9).itemView.getContext()) == false) goto L23;
        int r6 = 2131242111;
    L24:
        r12.setImageResource(r6);
        int r13 = r1.getType();
        SkillType.Companion.getClass();
        SkillType r14 = SkillType.a.a(r13);
        int r15 = TaskSkillViewHolder.a.a[r14.ordinal()];
        if (r15 != 1) goto L27;
        r2 = 2131906947;
    L40:
        if (r2 != null) goto L42;
        ((CommonTaskItemViewHolder) r9).h.setVisibility(8);
    L43:
        View r16 = ((RecyclerView.ViewHolder) r9).itemView;
        final TaskSkillListAdapter r17 = r9.k;
        r16.setOnClickListener(new j(r17, r1));
        return;
    L42:
        ((CommonTaskItemViewHolder) r9).h.setText(r2.intValue());
        ((CommonTaskItemViewHolder) r9).h.setVisibility(0);
        goto L43
    L27:
        if (r15 != 2) goto L29;
        r2 = 2131906944;
        goto L40
    L29:
        if (r15 != 3) goto L31;
        r2 = 2131901680;
        goto L40
    L31:
        if (r15 == 4) goto L40;
        if (r15 == 5) goto L40;
        throw new NoWhenBranchMatchedException();
    L23:
        r6 = 2131242112;
        goto L24
    L19:
        r11 = 8;
        goto L20
    L13:
        if (r8 == (getItemCount() - 1)) goto L15;
        r10 = true;
        goto L16
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (r5 != 1) goto L6;
        return new LoadingViewHolder(r0.inflate(2131562570, r4, false));
    L6:
        return new TaskSkillViewHolder(this, r0.inflate(2131562684, r4, false));
    }
}
