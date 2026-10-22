package com.larus.avlink.simulInterpret.page.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.impl.databinding.LayoutLanguageSelectItemBottomSheetBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter$LanguageSelectViewHolder;", "currentSelectedLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "languageList", "", "selectListener", "Lkotlin/Function1;", "", "<init>", "(Lcom/larus/avlink/simulInterpret/page/model/Language;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "updateSelectedLanguage", "newSelectedLanguage", "LanguageSelectViewHolder", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LanguageSelectBottomSheetAdapter extends RecyclerView.Adapter<LanguageSelectViewHolder> {
    public com.larus.avlink.simulInterpret.page.model.a a;
    public final List<com.larus.avlink.simulInterpret.page.model.a> b;
    public final Function1<com.larus.avlink.simulInterpret.page.model.a, Unit> c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/LanguageSelectBottomSheetAdapter$LanguageSelectViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutLanguageSelectItemBottomSheetBinding;", "<init>", "(Lcom/larus/avlink/impl/databinding/LayoutLanguageSelectItemBottomSheetBinding;)V", "bind", "", "language", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "currentSelectedLanguage", "selectListener", "Lkotlin/Function1;", "isLast", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class LanguageSelectViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final LayoutLanguageSelectItemBottomSheetBinding a;

        public LanguageSelectViewHolder(LayoutLanguageSelectItemBottomSheetBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        LanguageSelectViewHolder r9 = (LanguageSelectViewHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final com.larus.avlink.simulInterpret.page.model.a r0 = (com.larus.avlink.simulInterpret.page.model.a) ListProtector.get(this.b, r8);
        com.larus.avlink.simulInterpret.page.model.a r1 = this.a;
        final Function1<com.larus.avlink.simulInterpret.page.model.a, Unit> r2 = this.c;
        boolean r4 = true;
        if (r8 == (getItemCount() - 1)) goto L6;
        r4 = false;
    L6:
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "language");
        Intrinsics.checkNotNullParameter(r1, "currentSelectedLanguage");
        Intrinsics.checkNotNullParameter(r2, "selectListener");
        r9.a.d.setText(r0.a);
        if (Intrinsics.areEqual(r0.b, r1.b) == false) goto L9;
        r9.a.c.setVisibility(0);
    L10:
        r9.a.a.setOnClickListener(new j(r2, r0));
        if (r4 == false) goto L13;
        r9.a.b.setVisibility(8);
        return;
    L13:
        r9.a.b.setVisibility(0);
        return;
    L9:
        r9.a.c.setVisibility(8);
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        ConstraintLayout r7 = LayoutInflater.from(r5.getContext()).inflate(2131563352, r5, false);
        int r0 = 2131369197;
        View r1 = ViewBindings.findChildViewById(r7, 2131369197);
        if (r1 == null) goto L11;
        r0 = 2131377154;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r7, 2131377154);
        if (r2 == null) goto L11;
        r0 = 2131377157;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r7, 2131377157);
        if (r3 == null) goto L11;
        return new LanguageSelectViewHolder(new LayoutLanguageSelectItemBottomSheetBinding(r7, r1, r2, r3));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }

    public LanguageSelectBottomSheetAdapter(com.larus.avlink.simulInterpret.page.model.a r2, List r3, n r4) {
        Intrinsics.checkNotNullParameter(r2, "currentSelectedLanguage");
        Intrinsics.checkNotNullParameter(r3, "languageList");
        Intrinsics.checkNotNullParameter(r4, "selectListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
