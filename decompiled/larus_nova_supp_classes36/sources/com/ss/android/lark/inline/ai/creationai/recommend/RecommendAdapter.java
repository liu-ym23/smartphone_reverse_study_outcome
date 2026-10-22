package com.ss.android.lark.inline.ai.creationai.recommend;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.inline.ai.creationai.n0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "setRecommendIcon", "recommendItem", "Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "RecommendViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<MenuItem> a;
    public b b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
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
            String r1 = null;
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
            if (r9 == null) goto L34;
            r1 = r9.getIcon();
        L34:
            if (Intrinsics.areEqual(r12, r1) == true) goto L36;
            r8.putInt("icon", 1);
        L36:
            return r8;
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$RecommendViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemView", "Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "getItemView", "()Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class RecommendViewHolder extends RecyclerView.ViewHolder {
        public RecommendViewHolder(IconTextItem r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/RecommendAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RecommendAdapter a;
        public final /* synthetic */ MenuItem b;

        public c(RecommendAdapter r1, MenuItem r2) {
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

    public RecommendAdapter() {
    }

    public static void y2(MenuItem r4, IconTextItem r5) {
        String r0 = r4.getIcon();
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L14;
        Context r6 = r5.getContext();
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        int r1 = n.n(r6, r0);
        r5.a.setImageResource(r1);
    L17:
        boolean r2 = true;
    L19:
        String r7 = r4.getIcon();
        if (r7 != null) goto L22;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L32;
        if (r2 == false) goto L31;
        r5.setLeftIconVisible(true);
        ViewGroup.LayoutParams r9 = r5.getLeftIconView().getLayoutParams();
        r9.height = n0.a(24);
        ViewGroup.LayoutParams r10 = r5.getLeftIconView().getLayoutParams();
        r10.width = n0.a(24);
        r5.setEmojiVisible(false);
        return;
    L31:
        r5.setLeftIconVisible(false);
        r5.setEmojiContent(r4.getIcon());
        r5.setEmojiVisible(true);
        r5.setEmojiSize(16);
        return;
    L32:
        r5.setLeftIconVisible(false);
        return;
    L22:
        if (r7.length() <= 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 != true) goto L27;
        r8 = true;
        goto L28
    L24:
        r11 = false;
        goto L25
    L14:
        int r12 = n.o(r5.getContext(), r0);
        if (r12 == 0) goto L18;
        r5.a.setImageResource(r12);
        goto L17
    L18:
        r2 = false;
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        List<MenuItem> r0 = this.a;
        if (r0 == null) goto L9;
        MenuItem r4 = (MenuItem) ListProtector.get(r0, r3);
        if (r4 == null) goto L10;
        View r5 = r2.itemView;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.recommend.IconTextItem");
        IconTextItem r6 = (IconTextItem) r5;
        r6.setLeftLabelVisible(false);
        y2(r4, r6);
        r6.setTextSize(16);
        r6.setText(r4.getText());
        r6.setOnClickListener(new c(this, r4));
        return;
    L10:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new RecommendViewHolder(new IconTextItem(r5.getContext(), null, 6, 0));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if ((!r6.isEmpty()) == true) goto L5;
    L18:
        onBindViewHolder(r4, r5);
        return;
    L5:
        if ((ListProtector.get(r6, 0) instanceof Bundle) == false) goto L18;
        List<MenuItem> r2 = this.a;
        if (r2 == null) goto L17;
        MenuItem r7 = (MenuItem) ListProtector.get(r2, r5);
        if (r7 == null) goto L20;
        Object r8 = ListProtector.get(r6, 0);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r9 = (Bundle) r8;
        View r10 = r4.itemView;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.recommend.IconTextItem");
        IconTextItem r11 = (IconTextItem) r10;
        r11.setLeftLabelVisible(false);
        if (r9.getInt("text") != 1) goto L15;
        r11.setText(r7.getText());
    L15:
        if (r9.getInt("icon") != 1) goto L21;
        y2(r7, r11);
        return;
    L21:
        return;
    L20:
        return;
    }
}
