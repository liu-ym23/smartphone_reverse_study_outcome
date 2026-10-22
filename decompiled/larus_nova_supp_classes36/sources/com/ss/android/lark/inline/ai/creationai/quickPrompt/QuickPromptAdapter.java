package com.ss.android.lark.inline.ai.creationai.quickPrompt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\t !\"#$%&'(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\"\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onPromptClickListener", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$OnPromptClickListener;", "setData", "", "promptGroups", "setOnPromptClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "onBindChildViewHolder", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "isSwitchView", "", "getItemViewType", "Companion", "NormalViewHolder", "DatasetViewHolder", "SelectViewHolder", "SwitchViewHolder", "DividerViewHolder", "ItemViewType", "OnPromptClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QuickPromptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<MenuItem> a;
    public b b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$DatasetViewHolder;", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "badgePoint", "getBadgePoint", "()Landroid/view/View;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DatasetViewHolder extends NormalViewHolder {
        public final View d;

        public DatasetViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.d = r2.findViewById(2131363843);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<MenuItem> a;
        public final List<MenuItem> b;

        public final int getNewListSize() {
            List<MenuItem> r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getOldListSize() {
            List<MenuItem> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public DiffCallback(List<MenuItem> r1, List<MenuItem> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            List<MenuItem> r0 = this.a;
            if (r0 == null) goto L14;
            MenuItem r5 = (MenuItem) CollectionsKt.getOrNull(r0, r3);
            if (r5 == null) goto L14;
            List<MenuItem> r1 = this.b;
            if (r1 == null) goto L14;
            MenuItem r6 = (MenuItem) CollectionsKt.getOrNull(r1, r4);
            if (r6 == null) goto L14;
            return Intrinsics.areEqual(r5, r6);
        L14:
            return false;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            List<MenuItem> r0 = this.a;
            if (r0 == null) goto L14;
            MenuItem r5 = (MenuItem) CollectionsKt.getOrNull(r0, r3);
            if (r5 == null) goto L14;
            List<MenuItem> r1 = this.b;
            if (r1 == null) goto L14;
            MenuItem r6 = (MenuItem) CollectionsKt.getOrNull(r1, r4);
            if (r6 == null) goto L14;
            return Intrinsics.areEqual(r5.getId(), r6.getId());
        L14:
            return false;
        }

        public final Object getChangePayload(int r6, int r7) {
            Bundle r8 = new Bundle();
            List<MenuItem> r0 = this.a;
            Integer r1 = null;
            if (r0 == null) goto L5;
            MenuItem r2 = (MenuItem) CollectionsKt.getOrNull(r0, r6);
        L6:
            List<MenuItem> r3 = this.b;
            if (r3 == null) goto L9;
            MenuItem r9 = (MenuItem) CollectionsKt.getOrNull(r3, r6);
        L10:
            if (r2 == null) goto L12;
            String r4 = r2.getText();
        L13:
            if (r9 == null) goto L15;
            String r5 = r9.getText();
        L17:
            if (Intrinsics.areEqual(r4, r5) == true) goto L19;
            r8.putInt("text", 1);
        L19:
            if (r2 == null) goto L21;
            String r10 = r2.getDesc();
        L22:
            if (r9 == null) goto L24;
            String r11 = r9.getDesc();
        L26:
            if (Intrinsics.areEqual(r10, r11) == true) goto L28;
            r8.putInt("text_desc", 1);
        L28:
            if (r2 == null) goto L30;
            String r12 = r2.getType();
        L31:
            if (r9 == null) goto L33;
            String r13 = r9.getType();
        L35:
            if (Intrinsics.areEqual(r12, r13) == true) goto L37;
            r8.putInt("btnType", 1);
        L37:
            if (r2 == null) goto L39;
            Boolean r14 = Boolean.valueOf(r2.getDisabled());
        L40:
            if (r9 == null) goto L42;
            Boolean r15 = Boolean.valueOf(r9.getDisabled());
        L44:
            if (Intrinsics.areEqual(r14, r15) == true) goto L46;
            r8.putInt("disable", 1);
        L46:
            if (r2 == null) goto L48;
            String r16 = r2.getIcon();
        L49:
            if (r9 == null) goto L51;
            String r17 = r9.getIcon();
        L53:
            if (Intrinsics.areEqual(r16, r17) == true) goto L55;
            r8.putInt("icon", 1);
        L55:
            if (r2 == null) goto L57;
            Boolean r18 = Boolean.valueOf(r2.getSelected());
        L58:
            if (r9 == null) goto L60;
            Boolean r19 = Boolean.valueOf(r9.getSelected());
        L62:
            if (Intrinsics.areEqual(r18, r19) == true) goto L64;
            r8.putInt("selected", 1);
        L64:
            if (r2 == null) goto L66;
            Integer r20 = r2.getBadgeNum();
        L67:
            if (r9 == null) goto L70;
            r1 = r9.getBadgeNum();
        L70:
            if (Intrinsics.areEqual(r20, r1) == true) goto L72;
            r8.putInt("badge", 1);
        L72:
            return r8;
        L66:
            r20 = null;
            goto L67
        L60:
            r19 = null;
            goto L62
        L57:
            r18 = null;
            goto L58
        L51:
            r17 = null;
            goto L53
        L48:
            r16 = null;
            goto L49
        L42:
            r15 = null;
            goto L44
        L39:
            r14 = null;
            goto L40
        L33:
            r13 = null;
            goto L35
        L30:
            r12 = null;
            goto L31
        L24:
            r11 = null;
            goto L26
        L21:
            r10 = null;
            goto L22
        L15:
            r5 = null;
            goto L17
        L12:
            r4 = null;
            goto L13
        L9:
            r9 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "description", "getDescription", "badgeNum", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "getBadgeNum", "()Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;
        public final UDBadgeView c;

        public NormalViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131388772);
            this.b = (TextView) r2.findViewById(2131387553);
            this.c = r2.findViewById(2131363842);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$SelectViewHolder;", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "select", "Landroidx/appcompat/widget/AppCompatImageView;", "getSelect", "()Landroidx/appcompat/widget/AppCompatImageView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class SelectViewHolder extends NormalViewHolder {
        public final AppCompatImageView d;

        public SelectViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.d = r2.findViewById(2131385840);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$SwitchViewHolder;", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "switch", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "getSwitch", "()Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class SwitchViewHolder extends NormalViewHolder {
        public final UDSwitch d;

        public SwitchViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.d = r2.findViewById(2131375851);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ QuickPromptAdapter a;
        public final /* synthetic */ MenuItem b;

        public c(QuickPromptAdapter r1, MenuItem r2) {
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

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ QuickPromptAdapter a;
        public final /* synthetic */ MenuItem b;

        public d(QuickPromptAdapter r1, MenuItem r2) {
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

    static {
    }

    public final int getItemCount() {
        List<MenuItem> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public QuickPromptAdapter() {
    }

    public final int getItemViewType(int r2) {
        List<MenuItem> r0 = this.a;
        if (r0 == null) goto L7;
        MenuItem r3 = (MenuItem) ListProtector.get(r0, r2);
        if (r3 == null) goto L7;
        String r4 = r3.getType();
    L9:
        if (Intrinsics.areEqual(r4, "radio") == false) goto L13;
        return 2;
    L13:
        if (Intrinsics.areEqual(r4, "switcher") == false) goto L17;
        return 1;
    L17:
        if (Intrinsics.areEqual(r4, "divider") == false) goto L21;
        return 3;
    L21:
        if (Intrinsics.areEqual(r4, "dataset") == false) goto L24;
        return 4;
    L24:
        return 0;
    L7:
        r4 = null;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        List<MenuItem> r0 = this.a;
        if (r0 == null) goto L52;
        MenuItem r7 = (MenuItem) CollectionsKt.getOrNull(r0, r6);
        if (r7 != null) goto L8;
        return;
    L8:
        if ((r5 instanceof SwitchViewHolder) == false) goto L10;
        y2((NormalViewHolder) r5, r7, true);
        SwitchViewHolder r8 = (SwitchViewHolder) r5;
        r8.d.setChecked(r7.getSelected());
        r8.d.setOnClickListener(new d(this, r7));
        return;
    L10:
        int r1 = 8;
        if ((r5 instanceof SelectViewHolder) == false) goto L21;
        y2((NormalViewHolder) r5, r7, false);
        SelectViewHolder r9 = (SelectViewHolder) r5;
        AppCompatImageView r2 = r9.d;
        if (r7.getSelected() == false) goto L15;
        r1 = 0;
    L15:
        r2.setVisibility(r1);
        TextView r10 = r9.a;
        if (r7.getSelected() == false) goto L18;
        int r11 = 2131106616;
    L19:
        r10.setTextColor(UIHelper.getColor(r11));
        return;
    L18:
        r11 = 2131106622;
        goto L19
    L21:
        if ((r5 instanceof DatasetViewHolder) == false) goto L30;
        y2((NormalViewHolder) r5, r7, false);
        Integer r12 = r7.getBadgeNum();
        if (r12 == null) goto L28;
        int r13 = r12.intValue();
        View r14 = ((DatasetViewHolder) r5).d;
        if (r13 <= 0) goto L27;
        r1 = 0;
    L27:
        r14.setVisibility(r1);
        return;
    L28:
        ((DatasetViewHolder) r5).d.setVisibility(8);
        return;
    L30:
        if ((r5 instanceof NormalViewHolder) == false) goto L57;
        NormalViewHolder r15 = (NormalViewHolder) r5;
        y2(r15, r7, false);
        Integer r16 = r7.getBadgeNum();
        if (r16 == null) goto L48;
        int r17 = r16.intValue();
        Unit r3 = null;
        if (r17 <= 0) goto L44;
        UDBadgeView r4 = r15.c;
        if (r4 == null) goto L38;
        r4.setVisibility(0);
    L38:
        UDBadgeView r18 = r15.c;
        if (r18 == null) goto L41;
        r18.setText(String.valueOf(RangesKt.coerceAtMost(r17, 99)));
    L41:
        UDBadgeView r19 = r15.c;
        if (r19 == null) goto L47;
        r19.a();
        r3 = Unit.INSTANCE;
    L47:
        if (r3 == null) goto L48;
        return;
    L44:
        UDBadgeView r20 = r15.c;
        if (r20 == null) goto L47;
        r20.setVisibility(8);
        r3 = Unit.INSTANCE;
    L48:
        UDBadgeView r21 = r15.c;
        if (r21 == null) goto L59;
        r21.setVisibility(8);
        return;
    L59:
        return;
    L57:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 == 4) goto L17;
        return new NormalViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131559965, r4, false));
    L17:
        return new DatasetViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131559963, r4, false));
    L18:
        return new DividerViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131559964, r4, false));
    L19:
        return new SelectViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131559966, r4, false));
    L15:
        return new SwitchViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131559967, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9, List<Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r10, "payloads");
        if ((!r10.isEmpty()) == false) goto L98;
        int r0 = 0;
        if ((ListProtector.get(r10, 0) instanceof Bundle) == false) goto L98;
        List<MenuItem> r2 = this.a;
        if (r2 == null) goto L97;
        MenuItem r11 = (MenuItem) ListProtector.get(r2, r9);
        if (r11 == null) goto L100;
        Object r12 = ListProtector.get(r10, 0);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r13 = (Bundle) r12;
        if ((r8 instanceof SwitchViewHolder) == false) goto L25;
        if (r13.getInt("text") != 1) goto L17;
        ((SwitchViewHolder) r8).a.setText(r11.getText());
    L17:
        if (r13.getInt("text_desc") != 1) goto L22;
        TextView r1 = ((SwitchViewHolder) r8).b;
        if (r1 == null) goto L22;
        r1.setText(r11.getDesc());
    L22:
        if (r13.getInt("selected") != 1) goto L101;
        ((SwitchViewHolder) r8).d.setChecked(r11.getSelected());
        return;
    L101:
        return;
    L25:
        if ((r8 instanceof SelectViewHolder) == false) goto L46;
        if (r13.getInt("text") != 1) goto L30;
        ((SelectViewHolder) r8).a.setText(r11.getText());
    L30:
        if (r13.getInt("text_desc") != 1) goto L35;
        TextView r3 = ((SelectViewHolder) r8).b;
        if (r3 == null) goto L35;
        r3.setText(r11.getDesc());
    L35:
        if (r13.getInt("selected") != 1) goto L103;
        SelectViewHolder r14 = (SelectViewHolder) r8;
        AppCompatImageView r15 = r14.d;
        if (r11.getSelected() == true) goto L40;
        r0 = 8;
    L40:
        r15.setVisibility(r0);
        TextView r16 = r14.a;
        if (r11.getSelected() == false) goto L43;
        int r17 = 2131106616;
    L44:
        r16.setTextColor(UIHelper.getColor(r17));
        return;
    L43:
        r17 = 2131106622;
        goto L44
    L103:
        return;
    L46:
        if ((r8 instanceof DatasetViewHolder) == false) goto L66;
        if (r13.getInt("text") != 1) goto L51;
        ((DatasetViewHolder) r8).a.setText(r11.getText());
    L51:
        if (r13.getInt("text_desc") != 1) goto L56;
        TextView r4 = ((DatasetViewHolder) r8).b;
        if (r4 == null) goto L56;
        r4.setText(r11.getDesc());
    L56:
        if (r13.getInt("badge") != 1) goto L105;
        Integer r18 = r11.getBadgeNum();
        if (r18 == null) goto L64;
        int r19 = r18.intValue();
        View r20 = ((DatasetViewHolder) r8).d;
        if (r19 > 0) goto L63;
        r0 = 8;
    L63:
        r20.setVisibility(r0);
        return;
    L64:
        ((DatasetViewHolder) r8).d.setVisibility(8);
        return;
    L105:
        return;
    L66:
        if ((r8 instanceof NormalViewHolder) == true) goto L68;
        return;
    L68:
        if (r13.getInt("text") != 1) goto L71;
        ((NormalViewHolder) r8).a.setText(r11.getText());
    L71:
        if (r13.getInt("text_desc") != 1) goto L76;
        TextView r5 = ((NormalViewHolder) r8).b;
        if (r5 == null) goto L76;
        r5.setText(r11.getDesc());
    L76:
        if (r13.getInt("badge") != 1) goto L109;
        Integer r21 = r11.getBadgeNum();
        if (r21 == null) goto L94;
        int r22 = r21.intValue();
        Unit r110 = null;
        if (r22 <= 0) goto L90;
        NormalViewHolder r6 = (NormalViewHolder) r8;
        UDBadgeView r7 = r6.c;
        if (r7 == null) goto L84;
        r7.setVisibility(0);
    L84:
        UDBadgeView r23 = r6.c;
        if (r23 == null) goto L87;
        r23.setText(String.valueOf(RangesKt.coerceAtMost(r22, 99)));
    L87:
        UDBadgeView r24 = r6.c;
        if (r24 == null) goto L93;
        r24.a();
        r110 = Unit.INSTANCE;
    L93:
        if (r110 == null) goto L94;
        return;
    L90:
        UDBadgeView r25 = ((NormalViewHolder) r8).c;
        if (r25 == null) goto L93;
        r25.setVisibility(8);
        r110 = Unit.INSTANCE;
    L94:
        UDBadgeView r26 = ((NormalViewHolder) r8).c;
        if (r26 == null) goto L111;
        r26.setVisibility(8);
        return;
    L111:
        return;
    L109:
        return;
    L100:
        return;
    L97:
        return;
    L98:
        onBindViewHolder(r8, r9);
    }

    public final void y2(NormalViewHolder r3, MenuItem r4, boolean r5) {
        r3.a.setText(r4.getText());
        TextView r0 = r3.b;
        if (r0 == null) goto L5;
        r0.setText(r4.getDesc());
    L5:
        if (r5 == true) goto L8;
        ((RecyclerView.ViewHolder) r3).itemView.setOnClickListener(new c(this, r4));
        return;
    }
}
