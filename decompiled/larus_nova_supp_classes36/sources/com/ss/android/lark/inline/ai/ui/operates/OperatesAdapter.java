package com.ss.android.lark.inline.ai.ui.operates;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class OperatesAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<Operate> a;
    public b b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<Operate> a;
        public final List<Operate> b;

        public final int getNewListSize() {
            List<Operate> r0 = this.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getOldListSize() {
            List<Operate> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public DiffCallback(List<Operate> r1, List<Operate> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean areContentsTheSame(int r2, int r3) {
            List<Operate> r4 = this.a;
            if (r4 == null) goto L11;
            Operate r5 = (Operate) CollectionsKt.getOrNull(r4, r2);
            if (r5 == null) goto L11;
            List<Operate> r0 = this.b;
            if (r0 == null) goto L9;
            Operate r6 = (Operate) CollectionsKt.getOrNull(r0, r2);
        L13:
            return r5.equals(r6);
        L9:
            r6 = null;
        L11:
            return false;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            List<Operate> r5 = this.a;
            String r0 = null;
            if (r5 == null) goto L7;
            Operate r6 = (Operate) CollectionsKt.getOrNull(r5, r3);
            if (r6 == null) goto L7;
            String r7 = r6.getType();
        L8:
            List<Operate> r1 = this.b;
            if (r1 == null) goto L14;
            Operate r8 = (Operate) CollectionsKt.getOrNull(r1, r3);
            if (r8 == null) goto L14;
            r0 = r8.getType();
        L14:
            return Intrinsics.areEqual(r7, r0);
        L7:
            r7 = null;
            goto L8
        }

        public final Object getChangePayload(int r6, int r7) {
            Bundle r8 = new Bundle();
            List<Operate> r0 = this.a;
            Boolean r1 = null;
            if (r0 == null) goto L5;
            Operate r2 = (Operate) CollectionsKt.getOrNull(r0, r6);
        L6:
            List<Operate> r3 = this.b;
            if (r3 == null) goto L9;
            Operate r9 = (Operate) CollectionsKt.getOrNull(r3, r6);
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
            String r10 = r2.getBtnType();
        L22:
            if (r9 == null) goto L24;
            String r11 = r9.getBtnType();
        L26:
            if (Intrinsics.areEqual(r10, r11) == true) goto L28;
            r8.putInt("btnType", 1);
        L28:
            if (r2 == null) goto L30;
            Boolean r12 = Boolean.valueOf(r2.getDisabled());
        L31:
            if (r9 == null) goto L34;
            r1 = Boolean.valueOf(r9.getDisabled());
        L34:
            if (Intrinsics.areEqual(r12, r1) == true) goto L36;
            r8.putInt("disable", 1);
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(OperateButton r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Operate r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OperatesAdapter a;
        public final /* synthetic */ Operate b;

        public c(OperatesAdapter r1, Operate r2) {
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
        List<Operate> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public OperatesAdapter() {
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((ViewHolder) r1, r2);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.Button, com.ss.android.lark.inline.ai.ui.operates.OperateButton] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        ?? r6 = new OperateButton(r4.getContext(), null, 6, 0);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r6.setPadding(f0.a(16), f0.a(7), f0.a(16), f0.a(7));
        r6.setTextSize(16.0f);
        return new ViewHolder(r6);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [android.widget.Button, com.ss.android.lark.inline.ai.ui.operates.OperateButton] */
    public final void y2(ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        List<Operate> r0 = this.a;
        if (r0 == null) goto L12;
        Operate r4 = (Operate) ListProtector.get(r0, r3);
        if (r4 == null) goto L13;
        Object r5 = ((RecyclerView.ViewHolder) r2).itemView;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.ui.operates.OperateButton");
        ?? r6 = (OperateButton) r5;
        String r1 = r4.getBtnType();
        if (r1 != null) goto L10;
        r1 = LocationHitPoint$ResultType.DEFAULT;
    L10:
        r6.setType(r1);
        r6.setText(r4.getText());
        r6.setEnabled(!r4.getDisabled());
        r6.setOnClickListener(new c(this, r4));
        return;
    L13:
        return;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [android.widget.Button, com.ss.android.lark.inline.ai.ui.operates.OperateButton] */
    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List r6) {
        ViewHolder r7 = (ViewHolder) r4;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if ((!r6.isEmpty()) == true) goto L5;
    L24:
        y2(r7, r5);
        return;
    L5:
        if ((ListProtector.get(r6, 0) instanceof Bundle) == false) goto L24;
        List<Operate> r2 = this.a;
        if (r2 == null) goto L26;
        Operate r8 = (Operate) ListProtector.get(r2, r5);
        if (r8 == null) goto L28;
        Object r9 = ListProtector.get(r6, 0);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r10 = (Bundle) r9;
        Object r11 = ((RecyclerView.ViewHolder) r7).itemView;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.ui.operates.OperateButton");
        ?? r12 = (OperateButton) r11;
        if (r10.getInt("text") != 1) goto L15;
        r12.setText(r8.getText());
    L15:
        if (r10.getInt("btnType") != 1) goto L21;
        String r0 = r8.getBtnType();
        if (r0 != null) goto L19;
        r0 = LocationHitPoint$ResultType.DEFAULT;
    L19:
        r12.setType(r0);
    L21:
        if (r10.getInt("disable") != 1) goto L23;
        r12.setEnabled(!r8.getDisabled());
    L23:
        r12.setOnClickListener(new com.ss.android.lark.inline.ai.ui.operates.a(this, r8));
        return;
    L28:
        return;
    }
}
