package com.larus.avlink.simulInterpret.page.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.impl.databinding.LayoutTranslateResultItemBinding;
import com.larus.avlink.simulInterpret.page.model.AREA;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter$TranslationResultHolder;", "context", "Landroid/content/Context;", "area", "Lcom/larus/avlink/simulInterpret/page/model/AREA;", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "<init>", "(Landroid/content/Context;Lcom/larus/avlink/simulInterpret/page/model/AREA;Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;)V", "translationResultList", "", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultItem;", "updateTranslationResult", "", "item", "clear", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "TranslationResultHolder", "TranslationResultDiffCallback", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class TranslationResultAdapter extends RecyclerView.Adapter<TranslationResultHolder> {
    public final Context a;
    public final AREA b;
    public final DoraDeviceType c;
    public List<ea8.w> d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/view/TranslationResultAdapter$TranslationResultHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutTranslateResultItemBinding;", "<init>", "(Lcom/larus/avlink/impl/databinding/LayoutTranslateResultItemBinding;)V", "bindView", "", "result", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultItem;", "area", "Lcom/larus/avlink/simulInterpret/page/model/AREA;", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class TranslationResultHolder extends RecyclerView.ViewHolder {
        public final LayoutTranslateResultItemBinding a;

        public TranslationResultHolder(LayoutTranslateResultItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a extends DiffUtil.Callback {
        public final List<ea8.w> a;
        public final List<ea8.w> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public a(List<ea8.w> r2, List<ea8.w> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldList");
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            if (Intrinsics.areEqual(((ea8.w) ListProtector.get(this.a, r3)).b, ((ea8.w) ListProtector.get(this.b, r4)).b) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(((ea8.w) ListProtector.get(this.a, r3)).c, ((ea8.w) ListProtector.get(this.b, r4)).c) == false) goto L7;
            return true;
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            return Intrinsics.areEqual(((ea8.w) ListProtector.get(this.a, r2)).a, ((ea8.w) ListProtector.get(this.b, r3)).a);
        }
    }

    public final int getItemCount() {
        return this.d.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        TranslationResultHolder r6 = (TranslationResultHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        ea8.w r7 = (ea8.w) ListProtector.get(this.d, r5);
        AREA r0 = this.b;
        DoraDeviceType r1 = this.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "result");
        Intrinsics.checkNotNullParameter(r0, "area");
        Intrinsics.checkNotNullParameter(r1, "deviceType");
        if (r0 != AREA.BOTTOM) goto L5;
        TextView r2 = r6.a.c;
        r2.setTextColor(r2.getResources().getColor(2131103136));
    L5:
        r6.a.b.setText(r7.b);
        r6.a.c.setText(r7.c);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(this.a).inflate(2131563418, r3, false);
        int r6 = 2131388476;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r5, 2131388476);
        if (r0 == null) goto L9;
        r6 = 2131388518;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r5, 2131388518);
        if (r1 == null) goto L9;
        return new TranslationResultHolder(new LayoutTranslateResultItemBinding(r5, r0, r1));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public TranslationResultAdapter(Context r2, AREA r3, DoraDeviceType r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "area");
        Intrinsics.checkNotNullParameter(r4, "deviceType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = CollectionsKt.emptyList();
    }
}
