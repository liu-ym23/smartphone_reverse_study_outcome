package com.ss.android.lark.inline.ai.creationai.operates;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.ui.f0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b !\"#$%&'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tJ\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$OnOperateClickListener;", "useType", "", "setData", "", "setUseType", "setOnOperateClickListener", "listener", "getItemViewType", "position", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "updateCircleItemBackground", "normalItem", "Lcom/ss/android/lark/inline/ai/creationai/operates/NormalItem;", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "ButtonViewHolder", "IconViewHolder", "TextIconViewHolder", "DividerViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ButtonGroupsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<MenuItem> a;
    public b b;
    public int c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$ButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "button", "Lcom/ss/android/lark/inline/ai/creationai/operates/MenuButton;", "getButton", "()Lcom/ss/android/lark/inline/ai/creationai/operates/MenuButton;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ButtonViewHolder extends RecyclerView.ViewHolder {
        public final MenuButton a;

        /* JADX WARN: Multi-variable type inference failed */
        public ButtonViewHolder(MenuButton r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
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
            String r10 = r2.getType();
        L22:
            if (r9 == null) goto L24;
            String r11 = r9.getType();
        L26:
            if (Intrinsics.areEqual(r10, r11) == true) goto L28;
            r8.putInt("btnType", 1);
        L28:
            if (r2 == null) goto L30;
            Boolean r12 = Boolean.valueOf(r2.getDisabled());
        L31:
            if (r9 == null) goto L33;
            Boolean r13 = Boolean.valueOf(r9.getDisabled());
        L35:
            if (Intrinsics.areEqual(r12, r13) == true) goto L37;
            r8.putInt("disable", 1);
        L37:
            if (r2 == null) goto L39;
            String r14 = r2.getIcon();
        L40:
            if (r9 == null) goto L42;
            String r15 = r9.getIcon();
        L44:
            if (Intrinsics.areEqual(r14, r15) == true) goto L46;
            r8.putInt("icon", 1);
        L46:
            if (r2 == null) goto L48;
            Boolean r16 = Boolean.valueOf(r2.getSelected());
        L49:
            if (r9 == null) goto L51;
            Boolean r17 = Boolean.valueOf(r9.getSelected());
        L53:
            if (Intrinsics.areEqual(r16, r17) == true) goto L55;
            r8.putInt("selected", 1);
        L55:
            if (r2 == null) goto L57;
            Integer r18 = r2.getBadgeNum();
        L58:
            if (r9 == null) goto L61;
            r1 = r9.getBadgeNum();
        L61:
            if (Intrinsics.areEqual(r18, r1) == true) goto L63;
            r8.putInt("badge", 1);
        L63:
            return r8;
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$IconViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "iconView", "Lcom/ss/android/lark/inline/ai/creationai/operates/MenuIcon;", "getIconView", "()Lcom/ss/android/lark/inline/ai/creationai/operates/MenuIcon;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class IconViewHolder extends RecyclerView.ViewHolder {
        public final MenuIcon a;

        public IconViewHolder(MenuIcon r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$TextIconViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textItem", "Lcom/ss/android/lark/inline/ai/creationai/operates/NormalItem;", "getTextItem", "()Lcom/ss/android/lark/inline/ai/creationai/operates/NormalItem;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class TextIconViewHolder extends RecyclerView.ViewHolder {
        public final NormalItem a;

        public TextIconViewHolder(NormalItem r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/ButtonGroupsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ButtonGroupsAdapter a;
        public final /* synthetic */ MenuItem b;

        public c(ButtonGroupsAdapter r1, MenuItem r2) {
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
        public final /* synthetic */ ButtonGroupsAdapter a;
        public final /* synthetic */ MenuItem b;

        public d(ButtonGroupsAdapter r1, MenuItem r2) {
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
        public final /* synthetic */ ButtonGroupsAdapter a;
        public final /* synthetic */ MenuItem b;

        public e(ButtonGroupsAdapter r1, MenuItem r2) {
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

    public ButtonGroupsAdapter() {
    }

    public final int getItemViewType(int r2) {
        List<MenuItem> r0 = this.a;
        if (r0 == null) goto L7;
        MenuItem r3 = (MenuItem) ListProtector.get(r0, r2);
        if (r3 == null) goto L7;
        String r4 = r3.getType();
    L8:
        if (r4 != null) goto L10;
    L27:
        return 2;
    L10:
        switch(r4.hashCode()) {
            case -1039745817: goto L24;
            case -314765822: goto L21;
            case 3226745: goto L17;
            case 1674318617: goto L13;
            default: goto L27;
        };
    L13:
        if (r4.equals("divider") == false) goto L27;
        return 3;
    L17:
        if (r4.equals("icon") == false) goto L27;
        return 1;
    L21:
        if (r4.equals("primary") == false) goto L27;
    L26:
        return 0;
    L24:
        if (r4.equals("normal") == true) goto L26;
    L7:
        r4 = null;
        goto L8
    }

    public static void y2(MenuItem r4, NormalItem r5) {
        if (r4.getSelected() == false) goto L5;
        Drawable r0 = ContextCompat.getDrawable(r5.getContext(), 2131231919);
    L6:
        r5.b.setBackground(r0);
        LinearLayout r1 = r5.b;
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-2, r5.a(34));
        r2.addRule(15);
        r1.setLayoutParams(r2);
        if (r4.getSelected() == false) goto L9;
        r5.setTextColor("function_info_content_default");
        r5.setIconColor("function_info_content_default");
    L11:
        if (TextUtils.isEmpty(r4.getText()) == false) goto L13;
        r5.b(9, 6, 9, 6);
    L14:
        int r6 = NormalItem.i;
        r5.d(16, true);
        r5.setTextSize(14);
        return;
    L13:
        r5.b(10, 6, 10, 6);
        goto L14
    L9:
        r5.setTextColor("ud_title_color");
        r5.setIconColor("ud_title_color");
        goto L11
    L5:
        r0 = ContextCompat.getDrawable(r5.getContext(), 2131231917);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [android.widget.Button, com.ss.android.lark.inline.ai.creationai.operates.MenuButton] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        List<MenuItem> r0 = this.a;
        if (r0 == null) goto L54;
        MenuItem r1 = (MenuItem) ListProtector.get(r0, r10);
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r9 instanceof DividerViewHolder) == false) goto L10;
        return;
    L10:
        Object r11 = r9.itemView;
        boolean r2 = true;
        if ((r11 instanceof MenuIcon) == false) goto L14;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.operates.MenuIcon");
        MenuIcon r12 = (MenuIcon) r11;
        r12.setIcon(r1.getIcon());
        r12.setEnabled(!r1.getDisabled());
        r12.setOnClickListener(new c(this, r1));
        r12.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        r12.setIconColor("title_color");
        return;
    L14:
        if ((r11 instanceof MenuButton) == false) goto L17;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.operates.MenuButton");
        ?? r13 = (MenuButton) r11;
        r13.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        r13.setPadding(f0.a(16), f0.a(7), f0.a(16), f0.a(7));
        r13.setTextSize(16.0f);
        r13.setType(r1.getType());
        r13.setText(r1.getText());
        r13.setEnabled(!r1.getDisabled());
        r13.setOnClickListener(new d(this, r1));
        return;
    L17:
        if ((r11 instanceof NormalItem) == false) goto L57;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.operates.NormalItem");
        NormalItem r14 = (NormalItem) r11;
        RecyclerView.LayoutParams r3 = new RecyclerView.LayoutParams(-2, -2);
        if (this.c != 3) goto L23;
        if (r10 != 0) goto L22;
        r3.setMarginStart(f0.a(13));
        goto L23
    L22:
        r3.setMarginStart(0);
    L23:
        r14.setLayoutParams(r3);
        r14.setTextColor("ud_title_color");
        r14.c(r1.getIcon());
        r14.setText(r1.getText());
        r14.setBadge(r1.getBadgeNum());
        if (Intrinsics.areEqual(r1.getType(), "circle") == false) goto L26;
        y2(r1, r14);
    L39:
        String r15 = r1.getText();
        if (r15 != null) goto L42;
    L47:
        boolean r16 = false;
    L48:
        r14.setTextVisible(r16);
        if (r1.getIcon().length() > 0) goto L52;
        r2 = false;
    L52:
        r14.setLeftIconVisible(r2);
        r14.setOnClickListener(new e(this, r1));
        return;
    L42:
        if (r15.length() <= 0) goto L44;
        boolean r17 = true;
    L45:
        if (r17 != true) goto L47;
        r16 = true;
        goto L48
    L44:
        r17 = false;
        goto L45
    L26:
        int r4 = f0.a(2);
        r14.setPadding(r4, r4, r4, r4);
        int r5 = this.c;
        if (r5 != 1) goto L29;
        r14.setViewHeight(52);
        r14.d(22, false);
        r14.b(0, 0, 10, 0);
    L38:
        r14.setIconColor("ud_title_color");
        goto L39
    L29:
        if (r5 != 2) goto L38;
        r14.d(15, true);
        r14.setTextSize(16);
        r14.setViewHeight(52);
        if (r1.getText().length() <= 0) goto L33;
        boolean r6 = true;
    L35:
        if (r6 == false) goto L37;
        r14.d(20, true);
        r14.d.setPadding(r14.a(2), r14.a(2), r14.a(2), r14.a(2));
        goto L38
    L37:
        r14.d(20, true);
        r14.d.setPadding(r14.a(2), r14.a(0), r14.a(2), r14.a(0));
        goto L38
    L33:
        r6 = false;
        goto L35
    L57:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 == 0) goto L12;
        if (r7 == 1) goto L15;
        if (r7 != 3) goto L13;
        FrameLayout r8 = new FrameLayout(r6.getContext());
        r8.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
        View r0 = new View(r6.getContext());
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(f0.a(1), f0.a(16));
        r9.gravity = 16;
        r0.setLayoutParams(r9);
        int r10 = n.i(r0.getContext(), "divider_color");
        r0.setBackgroundColor(ContextCompat.getColor(r0.getContext(), r10));
        r8.addView(r0);
        return new DividerViewHolder(r8);
    L13:
        return new TextIconViewHolder(new NormalItem(r6.getContext(), null, 6, 0));
    L15:
        return new IconViewHolder(new MenuIcon(r6.getContext(), null, 6, 0));
    L12:
        return new ButtonViewHolder(new MenuButton(r6.getContext(), null, 6, 0));
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [android.widget.Button, com.ss.android.lark.inline.ai.creationai.operates.MenuButton] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8, List<Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        if ((!r9.isEmpty()) == false) goto L59;
        boolean r0 = false;
        if ((ListProtector.get(r9, 0) instanceof Bundle) == false) goto L59;
        List<MenuItem> r2 = this.a;
        if (r2 == null) goto L58;
        MenuItem r10 = (MenuItem) ListProtector.get(r2, r8);
        if (r10 == null) goto L61;
        Object r11 = ListProtector.get(r9, 0);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r12 = (Bundle) r11;
        if ((r7 instanceof ButtonViewHolder) == false) goto L23;
        ?? r13 = ((ButtonViewHolder) r7).a;
        if (r12.getInt("text") != 1) goto L17;
        r13.setText(r10.getText());
    L17:
        if (r12.getInt("btnType") != 1) goto L20;
        r13.setType(r10.getType());
    L20:
        if (r12.getInt("disable") != 1) goto L62;
        r13.setEnabled(!r10.getDisabled());
        return;
    L62:
        return;
    L23:
        if ((r7 instanceof IconViewHolder) == false) goto L31;
        if (r12.getInt("disable") != 1) goto L28;
        ((IconViewHolder) r7).a.setEnabled(!r10.getDisabled());
    L28:
        if (r12.getInt("icon") != 1) goto L64;
        ((IconViewHolder) r7).a.setIcon(r10.getIcon());
        return;
    L64:
        return;
    L31:
        if ((r7 instanceof TextIconViewHolder) == true) goto L33;
        return;
    L33:
        if (r12.getInt("icon") != 1) goto L40;
        TextIconViewHolder r3 = (TextIconViewHolder) r7;
        r3.a.c(r10.getIcon());
        NormalItem r4 = r3.a;
        if (r10.getIcon().length() <= 0) goto L37;
        boolean r5 = true;
    L38:
        r4.setLeftIconVisible(r5);
        goto L40
    L37:
        r5 = false;
    L40:
        if (r12.getInt("text") != 1) goto L51;
        TextIconViewHolder r6 = (TextIconViewHolder) r7;
        r6.a.setText(r10.getText());
        NormalItem r14 = r6.a;
        String r15 = r10.getText();
        if (r15 != null) goto L44;
    L49:
        r14.setTextVisible(r0);
        goto L51
    L44:
        if (r15.length() <= 0) goto L46;
        boolean r16 = true;
    L47:
        if (r16 != true) goto L49;
        r0 = true;
        goto L49
    L46:
        r16 = false;
    L51:
        if (r12.getInt("selected") != 1) goto L56;
        if (Intrinsics.areEqual(r10.getType(), "circle") == false) goto L56;
        y2(r10, ((TextIconViewHolder) r7).a);
    L56:
        if (r12.getInt("badge") != 1) goto L67;
        ((TextIconViewHolder) r7).a.setBadge(r10.getBadgeNum());
        return;
    L67:
        return;
    L61:
        return;
    L58:
        return;
    L59:
        onBindViewHolder(r7, r8);
    }
}
