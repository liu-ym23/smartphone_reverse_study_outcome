package com.ss.android.lark.inline.ai.ui.prompts;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.ui.f0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b\u001d\u001e\u001f !\"#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tJ \u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$PromptForRv;", "onPromptClickListener", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$OnPromptClickListener;", "setData", "", "promptGroups", "Lcom/ss/android/lark/inline/ai/api/ui/PromptGroup;", "setOnPromptClickListener", "listener", "convertPromptGroup", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onBindChildViewHolder", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ChildViewHolder;", "getItemViewType", "Companion", "ParentViewHolder", "ChildViewHolder", "RecentViewHolder", "PromptForRv", "ItemViewType", "OnPromptClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PromptsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<c> a;
    public b b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroidx/appcompat/widget/AppCompatImageView;", "getIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "text", "Landroidx/appcompat/widget/AppCompatTextView;", "getText", "()Landroidx/appcompat/widget/AppCompatTextView;", "rightArrow", "getRightArrow", "background", "Landroid/graphics/drawable/StateListDrawable;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static class ChildViewHolder extends RecyclerView.ViewHolder {
        public final AppCompatImageView a;
        public final AppCompatTextView b;
        public final AppCompatImageView c;

        public final StateListDrawable T3() {
            StateListDrawable r0 = new StateListDrawable();
            int[] r1 = {R.attr.state_pressed};
            GradientDrawable r2 = new GradientDrawable();
            r2.setColor(ContextCompat.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131101950));
            r2.setCornerRadius(f0.a(6));
            Unit r5 = Unit.INSTANCE;
            r0.addState(r1, r2);
            GradientDrawable r3 = new GradientDrawable();
            Context r4 = ((RecyclerView.ViewHolder) this).itemView.getContext();
            com.ss.android.lark.storage.a r6 = com.ss.android.lark.inline.ai.logic.b.a;
            r3.setColor(ContextCompat.getColor(r4, 2131100557));
            r3.setCornerRadius(f0.a(6));
            r0.addState(new int[0], r3);
            return r0;
        }

        public ChildViewHolder(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super(r3);
            this.a = r3.findViewById(2131383380);
            AppCompatTextView r0 = r3.findViewById(2131383381);
            this.b = r0;
            this.c = r3.findViewById(2131383391);
            r0.setTextSize(16.0f);
            r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131106622));
            ((RecyclerView.ViewHolder) this).itemView.setBackground(T3());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$PromptForRv;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<c> a;
        public final List<c> b;

        public final boolean areContentsTheSame(int r1, int r2) {
            return true;
        }

        public final int getNewListSize() {
            List<c> r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getOldListSize() {
            List<c> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public DiffCallback(List<c> r1, List<c> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean areItemsTheSame(int r4, int r5) {
            List<c> r0 = this.a;
            if (r0 == null) goto L24;
            c r6 = (c) CollectionsKt.getOrNull(r0, r4);
            if (r6 == null) goto L27;
            List<c> r1 = this.b;
            if (r1 == null) goto L25;
            c r7 = (c) CollectionsKt.getOrNull(r1, r5);
            if (r7 == null) goto L28;
            boolean r2 = r6.a;
            if (r2 == r7.a) goto L15;
            return false;
        L15:
            if (r2 == true) goto L17;
        L20:
            Prompt r8 = r6.c;
            if (r8 != null) goto L23;
            return false;
        L23:
            return r8.equals(r7.c);
        L17:
            if (Intrinsics.areEqual(r6.b, r7.b) == false) goto L20;
            return true;
        L28:
            return false;
        L25:
            return false;
        L27:
            return false;
        L24:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ParentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ParentViewHolder extends RecyclerView.ViewHolder {
        public ParentViewHolder(AppCompatTextView r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super(r3);
            View r4 = ((RecyclerView.ViewHolder) this).itemView;
            Context r0 = r4.getContext();
            com.ss.android.lark.storage.a r1 = com.ss.android.lark.inline.ai.logic.b.a;
            r4.setBackgroundColor(ContextCompat.getColor(r0, 2131100557));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$RecentViewHolder;", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ChildViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "deleteIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getDeleteIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "leftContentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLeftContentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class RecentViewHolder extends ChildViewHolder {
        public final AppCompatImageView d;
        public final ConstraintLayout e;

        public RecentViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.d = r2.findViewById(2131387819);
            ConstraintLayout r3 = r2.findViewById(2131375720);
            this.e = r3;
            r3.setBackground(T3());
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Prompt r1);

        void b(Prompt r1);
    }

    public static final class c {
        public final boolean a;
        public final String b;
        public final Prompt c;

        public c(boolean r1, String r2, Prompt r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PromptsAdapter a;
        public final /* synthetic */ Prompt b;

        public d(PromptsAdapter r1, Prompt r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ PromptsAdapter b;

        public e(c r1, PromptsAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Prompt r3 = this.a.c;
            if (r3 == null) goto L8;
            b r0 = this.b.b;
            if (r0 == null) goto L9;
            r0.b(r3);
            return;
        L9:
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ PromptsAdapter b;

        public f(c r1, PromptsAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Prompt r3 = this.a.c;
            if (r3 == null) goto L8;
            b r0 = this.b.b;
            if (r0 == null) goto L9;
            r0.a(r3);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final int getItemCount() {
        List<c> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public PromptsAdapter() {
    }

    public final int getItemViewType(int r4) {
        List<c> r0 = this.a;
        if (r0 == null) goto L9;
        c r1 = (c) ListProtector.get(r0, r4);
        if (r1 == null) goto L9;
        if (r1.a != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        return 0;
    L12:
        List<c> r3 = this.a;
        if (r3 == null) goto L19;
        c r5 = (c) ListProtector.get(r3, r4);
        if (r5 == null) goto L19;
        Prompt r6 = r5.c;
        if (r6 == null) goto L19;
        String r7 = r6.getType();
    L21:
        if (Intrinsics.areEqual(r7, "history_prompt") == false) goto L25;
        return 2;
    L25:
        return 1;
    L19:
        r7 = null;
    L9:
        r2 = false;
        goto L10
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        List<c> r0 = this.a;
        if (r0 == null) goto L21;
        c r1 = (c) CollectionsKt.getOrNull(r0, r5);
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r4 instanceof ParentViewHolder) == false) goto L15;
        AppCompatTextView r2 = r4.itemView;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        r2.setText(r1.b);
        View r6 = r4.itemView;
        if (r5 != 0) goto L12;
        int r7 = 0;
    L13:
        r6.setPadding(r6.getPaddingLeft(), r7, r6.getPaddingRight(), r6.getPaddingBottom());
        return;
    L12:
        r7 = f0.a(8);
        goto L13
    L15:
        if ((r4 instanceof RecentViewHolder) == false) goto L18;
        y2((ChildViewHolder) r4, r1);
        RecentViewHolder r8 = (RecentViewHolder) r4;
        r8.d.setImageResource(2131254201);
        ColorStateList r9 = UDColorUtils.getColorStateList(r8.d.getContext(), 2131109391);
        r8.d.setImageTintList(r9);
        r8.d.setOnClickListener(new e(r1, this));
        r8.e.setOnClickListener(new f(r1, this));
        return;
    L18:
        if ((r4 instanceof ChildViewHolder) == false) goto L24;
        y2((ChildViewHolder) r4, r1);
        return;
    L24:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        if (r6 != 0) goto L5;
        AppCompatTextView r7 = new AppCompatTextView(r5.getContext());
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r7.setPadding(f0.a(14), 0, f0.a(14), f0.a(4));
        r7.setTextSize(14.0f);
        r7.setTextColor(ContextCompat.getColor(r5.getContext(), 2131106607));
        return new ParentViewHolder(r7);
    L5:
        if (r6 == 2) goto L11;
        return new ChildViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131561548, r5, false));
    L11:
        return new RecentViewHolder(LayoutInflater.from(r5.getContext()).inflate(2131561549, r5, false));
    }

    public final void y2(ChildViewHolder r6, c r7) {
        Prompt r8 = r7.c;
        if (r8 != null) goto L5;
        return;
    L5:
        r6.b.setText(Html.fromHtml(r8.getText()));
        int r1 = 8;
        if (r8.getIcon() <= 0) goto L8;
        r6.a.setVisibility(0);
        r6.a.setImageDrawable(AppCompatResources.getDrawable(((RecyclerView.ViewHolder) r6).itemView.getContext(), r8.getIcon()));
    L9:
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new d(this, r8));
        AppCompatImageView r9 = r6.c;
        if (r8.getRightArrow() == false) goto L12;
        r1 = 0;
    L12:
        r9.setVisibility(r1);
        return;
    L8:
        r6.a.setVisibility(8);
        goto L9
    }
}
