package com.ss.android.lark.inline.ai.creationai.label;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.creationai.ItemContainer;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "LabelViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LabelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<MenuItem> a;
    public b b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
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

        public final boolean areContentsTheSame(int r2, int r3) {
            List<MenuItem> r4 = this.a;
            if (r4 == null) goto L11;
            MenuItem r5 = (MenuItem) CollectionsKt.getOrNull(r4, r2);
            if (r5 == null) goto L11;
            List<MenuItem> r0 = this.b;
            if (r0 == null) goto L9;
            MenuItem r6 = (MenuItem) CollectionsKt.getOrNull(r0, r2);
        L13:
            return r5.equals(r6);
        L9:
            r6 = null;
        L11:
            return false;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            List<MenuItem> r0 = this.a;
            String r1 = null;
            if (r0 == null) goto L5;
            MenuItem r5 = (MenuItem) CollectionsKt.getOrNull(r0, r3);
        L6:
            List<MenuItem> r2 = this.b;
            if (r2 == null) goto L9;
            MenuItem r6 = (MenuItem) CollectionsKt.getOrNull(r2, r4);
        L10:
            if (r5 == null) goto L12;
            String r7 = r5.getId();
        L13:
            if (r6 == null) goto L16;
            r1 = r6.getId();
        L16:
            return Intrinsics.areEqual(r7, r1);
        L12:
            r7 = null;
            goto L13
        L9:
            r6 = null;
            goto L10
        L5:
            r5 = null;
            goto L6
        }

        public final Object getChangePayload(int r6, int r7) {
            Bundle r8 = new Bundle();
            List<MenuItem> r0 = this.a;
            ItemContainer r1 = null;
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
            String r12 = r2.getIcon();
        L31:
            if (r9 == null) goto L33;
            String r13 = r9.getIcon();
        L35:
            if (Intrinsics.areEqual(r12, r13) == true) goto L38;
            r8.putInt("icon", 1);
        L38:
            if (DowngradeSettingUtil.a("creation_ai_label_history_entry_enable") == true) goto L47;
            if (r2 == null) goto L41;
            ItemContainer r14 = r2.getRightItem();
        L42:
            if (r9 == null) goto L45;
            r1 = r9.getRightItem();
        L45:
            if (Intrinsics.areEqual(r14, r1) == true) goto L47;
            r8.putInt("rightIcon", 1);
            goto L47
        L41:
            r14 = null;
        L47:
            return r8;
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$LabelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemView", "Lcom/ss/android/lark/inline/ai/creationai/label/LabelItem;", "getItemView", "()Lcom/ss/android/lark/inline/ai/creationai/label/LabelItem;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class LabelViewHolder extends RecyclerView.ViewHolder {
        public LabelViewHolder(LabelItem r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r1);

        void b(MenuItem r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LabelAdapter a;
        public final /* synthetic */ MenuItem b;

        public c(LabelAdapter r1, MenuItem r2) {
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
        public final /* synthetic */ LabelAdapter a;
        public final /* synthetic */ MenuItem b;

        public d(LabelAdapter r1, MenuItem r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.b(this.b);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ LabelAdapter a;
        public final /* synthetic */ MenuItem b;

        public e(LabelAdapter r1, MenuItem r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            b r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.b(this.b);
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

    public LabelAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        List<MenuItem> r0 = this.a;
        if (r0 == null) goto L31;
        MenuItem r1 = (MenuItem) ListProtector.get(r0, r8);
        if (r1 == null) goto L38;
        View r9 = r7.itemView;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.label.LabelItem");
        LabelItem r10 = (LabelItem) r9;
        r10.setText(r1.getText());
        r10.setLeftIconVisible(false);
        r10.setLeftLabelVisible(Intrinsics.areEqual(r1.getType(), "quote"));
        r10.setOnClickListener(new c(this, r1));
        if (Intrinsics.areEqual(r1.getType(), "quote") == true) goto L11;
        r10.b(6);
    L14:
        r10.setPadding(r10.a(20), r10.a(16), r10.a(20), r10.a(8));
        r10.setTextSize(14);
        r10.setTextColor("text_caption");
        if (DowngradeSettingUtil.a("creation_ai_label_history_entry_enable") == true) goto L35;
        r10.getRightIconLayout().removeAllViews();
        ItemContainer r11 = r1.getRightItem();
        if (r11 == null) goto L36;
        r10.setRightIconVisible(r11.getShow());
        ArrayList<MenuItem> r12 = r11.getData();
        if (r12 == null) goto L37;
        Iterator<MenuItem> r13 = r12.iterator();
    L22:
        if (r13.hasNext() == false) goto L39;
        MenuItem r2 = r13.next();
        RedBadgeIcon r3 = new RedBadgeIcon(r10.getContext(), null, 6, 0);
        r3.setRightIcon(r2.getIcon());
        Integer r4 = r2.getBadgeNum();
        if (r4 == null) goto L26;
        int r5 = r4.intValue();
    L27:
        if (r5 <= 0) goto L29;
        boolean r6 = true;
    L30:
        r3.setRightBadge(r6);
        r3.setOnClickListener(new d(this, r2));
        r3.setIconColor("title_color");
        r10.getRightIconLayout().addView(r3);
        goto L22
    L29:
        r6 = false;
        goto L30
    L26:
        r5 = 0;
        goto L27
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L11:
        if (r8 != 0) goto L13;
        r10.b(4);
        goto L14
    L13:
        r10.b(4);
        goto L14
    L38:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new LabelViewHolder(new LabelItem(r5.getContext(), null, 6, 0));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8, List<Object> r9) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r9, "payloads");
        if ((!r9.isEmpty()) == true) goto L5;
    L86:
        onBindViewHolder(r7, r8);
        return;
    L5:
        if ((ListProtector.get(r9, 0) instanceof Bundle) == false) goto L86;
        List<MenuItem> r2 = this.a;
        if (r2 == null) goto L85;
        MenuItem r3 = (MenuItem) ListProtector.get(r2, r8);
        if (r3 == null) goto L95;
        Object r10 = ListProtector.get(r9, 0);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r11 = (Bundle) r10;
        View r12 = r7.itemView;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.label.LabelItem");
        LabelItem r13 = (LabelItem) r12;
        if (r11.getInt("text") != 1) goto L15;
        r13.setText(r3.getText());
    L15:
        if (r11.getInt("icon") != 1) goto L29;
        String r4 = r3.getIcon();
        if (r4 == null) goto L22;
        r13.getClass();
        if (r4.length() == 0) goto L22;
        boolean r5 = false;
    L23:
        if (r5 == false) goto L25;
        r13.d.setImageResource(n.n(r13.getContext(), "ud_icon_abbreviation_outlined"));
        goto L29
    L25:
        int r6 = n.o(r13.getContext(), r4);
        if (r6 == 0) goto L29;
        r13.d.setImageResource(r6);
    L22:
        r5 = true;
    L29:
        if (r11.getInt("btnType") != 1) goto L38;
        r13.setLeftLabelVisible(Intrinsics.areEqual(r3.getType(), "quote"));
        if (Intrinsics.areEqual(r3.getType(), "quote") == true) goto L34;
        r13.b(4);
        goto L38
    L34:
        if (r8 != 0) goto L36;
        r13.b(2);
        goto L38
    L36:
        r13.b(2);
    L38:
        if (DowngradeSettingUtil.a("creation_ai_label_history_entry_enable") == false) goto L40;
        return;
    L40:
        if (r11.getInt("rightIcon") != 1) goto L97;
        ItemContainer r14 = r3.getRightItem();     // Catch: Exception -> L83
        if (r14 == null) goto L44;
        r13.setRightIconVisible(r14.getShow());     // Catch: Exception -> L83
    L44:
        ItemContainer r15 = r3.getRightItem();     // Catch: Exception -> L83
        if (r15 == null) goto L51;
        ArrayList<MenuItem> r16 = r15.getData();     // Catch: Exception -> L83
        if (r16 == null) goto L51;
        if (r16.size() != r13.getRightIconLayout().getChildCount()) goto L51;
        boolean r17 = true;
    L52:
        if (r17 == false) goto L67;
        ItemContainer r18 = r3.getRightItem();     // Catch: Exception -> L83
        if (r18 == null) goto L98;
        ArrayList<MenuItem> r19 = r18.getData();     // Catch: Exception -> L83
        if (r19 == null) goto L99;
        int r20 = r19.size();     // Catch: Exception -> L83
        int r21 = 0;
    L58:
        if (r21 >= r20) goto L103;
        View r22 = r13.getRightIconLayout().getChildAt(r21);     // Catch: Exception -> L83
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.label.RedBadgeIcon");     // Catch: Exception -> L83
        RedBadgeIcon r23 = (RedBadgeIcon) r22;     // Catch: Exception -> L83
        r23.setRightIcon(((MenuItem) ListProtector.get(r19, r21)).getIcon());     // Catch: Exception -> L83
        Integer r24 = ((MenuItem) ListProtector.get(r19, r21)).getBadgeNum();     // Catch: Exception -> L83
        if (r24 == null) goto L62;
        int r25 = r24.intValue();     // Catch: Exception -> L83
    L63:
        if (r25 <= 0) goto L65;
        boolean r26 = true;
    L66:
        r23.setRightBadge(r26);     // Catch: Exception -> L83
        r21 = r21 + 1;     // Catch: Exception -> L83
        goto L58
    L65:
        r26 = false;
        goto L66
    L62:
        r25 = 0;
        goto L63
    L103:
        return;
    L99:
        return;
    L98:
        return;
    L67:
        r13.getRightIconLayout().removeAllViews();     // Catch: Exception -> L83
        ItemContainer r27 = r3.getRightItem();     // Catch: Exception -> L83
        if (r27 == null) goto L100;
        ArrayList<MenuItem> r28 = r27.getData();     // Catch: Exception -> L83
        if (r28 == null) goto L101;
        Iterator<MenuItem> r29 = r28.iterator();     // Catch: Exception -> L83
    L73:
        if (r29.hasNext() == false) goto L104;
        MenuItem r30 = r29.next();     // Catch: Exception -> L83
        RedBadgeIcon r31 = new RedBadgeIcon(r13.getContext(), null, 6, 0);     // Catch: Exception -> L83
        r31.setRightIcon(r30.getIcon());     // Catch: Exception -> L83
        Integer r32 = r30.getBadgeNum();     // Catch: Exception -> L83
        if (r32 == null) goto L77;
        int r33 = r32.intValue();     // Catch: Exception -> L83
    L78:
        if (r33 <= 0) goto L80;
        boolean r34 = true;
    L81:
        r31.setRightBadge(r34);     // Catch: Exception -> L83
        r31.setOnClickListener(new e(this, r30));     // Catch: Exception -> L83
        r13.getRightIconLayout().addView(r31);     // Catch: Exception -> L83
        goto L73
    L80:
        r34 = false;
        goto L81
    L77:
        r33 = 0;
        goto L78
    L104:
        return;
    L101:
        return;
    L100:
        return;
    L51:
        r17 = false;
    L83:
        e = move-exception;
        Log.e("LabelAdapter", "onBindViewHolder() PAYLOAD_KEY_RIGHT_ICON change failed: ", e);
        return;
    L97:
        return;
    L95:
        return;
    }
}
