package com.larus.avlink.record.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.impl.databinding.LayoutRecordHistoryItemBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/avlink/record/page/RecordMinutesAdapter$RecordMinutesViewHolder;", "context", "Landroid/content/Context;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "", "onItemDeleteClick", "onItemUploadClick", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "recordHistoryList", "", "currentDeleteLayoutHolder", "hideCurrentDeleteLayout", "", "hasDeleteLayoutShowing", "updateRecordMinutesResult", "item", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "onViewRecycled", "RecordMinutesViewHolder", "RecordMinutesDiffCallback", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesAdapter extends RecyclerView.Adapter<RecordMinutesViewHolder> {
    public final Context a;
    public final Function1<i0, Unit> b;
    public final Function1<i0, Unit> c;
    public final Function1<i0, Unit> d;
    public List<i0> e;
    public RecordMinutesViewHolder f;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0006\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesAdapter$RecordMinutesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordHistoryItemBinding;", "onItemClick", "Lkotlin/Function1;", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "", "onItemDeleteClick", "onItemUploadClick", "<init>", "(Landroid/content/Context;Lcom/larus/avlink/impl/databinding/LayoutRecordHistoryItemBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "currentPopup", "Lcom/larus/avlink/record/page/RecordDeletePopupWindow;", "bindView", "item", "bindUploadView", "hideDeleteLayout", "isFullyVisible", "", "view", "Landroid/view/View;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class RecordMinutesViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int g = 0;
        public final Context a;
        public final LayoutRecordHistoryItemBinding b;
        public final Function1<i0, Unit> c;
        public final Function1<i0, Unit> d;
        public final Function1<i0, Unit> e;
        public g f;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TagType.values().length];
                r0[TagType.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[TagType.OFFLINE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[TagType.CONVERTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[TagType.OFFLINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RecordMinutesViewHolder(Context r2, LayoutRecordHistoryItemBinding r3, Function1<? super i0, Unit> r4, Function1<? super i0, Unit> r5, Function1<? super i0, Unit> r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "binding");
            Intrinsics.checkNotNullParameter(r4, "onItemClick");
            Intrinsics.checkNotNullParameter(r5, "onItemDeleteClick");
            Intrinsics.checkNotNullParameter(r6, "onItemUploadClick");
            super(r3.a);
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class a extends DiffUtil.Callback {
        public final List<i0> a;
        public final List<i0> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public a(List<i0> r2, List<i0> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldList");
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r2, int r3) {
            return Intrinsics.areEqual(ListProtector.get(this.a, r2), ListProtector.get(this.b, r3));
        }

        public final boolean areItemsTheSame(int r2, int r3) {
            return Intrinsics.areEqual(((i0) ListProtector.get(this.a, r2)).a, ((i0) ListProtector.get(this.b, r3)).a);
        }
    }

    public final int getItemCount() {
        return this.e.size();
    }

    public final void y2() {
        RecordMinutesViewHolder r0 = this.f;
        if (r0 == null) goto L12;
        g r1 = r0.f;
        if (r1 == null) goto L10;
        PopupWindow r3 = r1.e;
        if (r3 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r3);
        r3.dismiss();
    L9:
        r1.e = null;
    L10:
        r0.f = null;
        this.f = null;
        return;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r4) {
        RecordMinutesViewHolder r5 = (RecordMinutesViewHolder) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewRecycled(r5);
        if (Intrinsics.areEqual(r5, this.f) == false) goto L12;
        g r0 = r5.f;
        if (r0 == null) goto L10;
        PopupWindow r2 = r0.e;
        if (r2 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L9:
        r0.e = null;
    L10:
        r5.f = null;
        this.f = null;
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        final RecordMinutesViewHolder r11 = (RecordMinutesViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        if (Intrinsics.areEqual(r11, this.f) == false) goto L5;
        this.f = null;
    L5:
        final i0 r12 = (i0) ListProtector.get(this.e, r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "item");
        g r0 = r11.f;
        if (r0 == null) goto L11;
        PopupWindow r2 = r0.e;
        if (r2 == null) goto L10;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    L10:
        r0.e = null;
    L11:
        r11.f = null;
        r11.b.f.setText(r12.b);
        TagType r1 = r12.d;
        boolean r3 = true;
        if (r1 == null) goto L27;
        r11.b.d.setVisibility(0);
        int r4 = RecordMinutesViewHolder.a.a[r1.ordinal()];
        if (r4 != 1) goto L16;
        r11.b.d.setTextColor(r11.a.getResources().getColor(2131101300));
        r11.b.d.setBackground(AppCompatResources.getDrawable(r11.a, 2131232120));
        r11.b.d.setText(r11.a.getString(2131902916));
    L29:
        if (r12.d == TagType.OFFLINE) goto L31;
    L45:
        r11.b.g.setVisibility(8);
    L46:
        String r5 = r12.c;
        if (r5 != null) goto L49;
    L52:
        boolean r6 = true;
    L53:
        if (r6 == false) goto L55;
        r11.b.c.setVisibility(8);
    L56:
        String r7 = r12.e;
        if (r7 != null) goto L59;
    L62:
        if (r3 == false) goto L64;
        r11.b.e.setVisibility(8);
    L65:
        r11.b.a.setOnClickListener(new h(r11, r12));
        r11.b.a.setOnLongClickListener(new i(r11, r12));
        return;
    L64:
        r11.b.e.setVisibility(0);
        r11.b.e.setText(r12.e);
        goto L65
    L59:
        if (r7.length() == 0) goto L62;
        r3 = false;
        goto L62
    L55:
        r11.b.c.setVisibility(0);
        r11.b.c.setText(r12.c);
        goto L56
    L49:
        if (r5.length() == 0) goto L52;
        r6 = false;
        goto L53
    L31:
        if (Intrinsics.areEqual(r12.h, 1.0f) == true) goto L45;
        r11.b.g.setVisibility(0);
        if (r12.h == null) goto L36;
        boolean r8 = true;
    L37:
        if (r8 == false) goto L43;
        r11.b.h.setVisibility(8);
        r11.b.i.setVisibility(0);
        UploadProgressView r13 = r11.b.i;
        Float r14 = r12.h;
        if (r14 == null) goto L41;
        float r15 = r14.floatValue();
    L42:
        r13.setProgress(r15);
    L44:
        r11.b.g.setOnClickListener(new j(r12, r11));
        goto L46
    L41:
        r15 = 0.0f;
        goto L42
    L43:
        r11.b.i.setVisibility(8);
        r11.b.h.setVisibility(0);
        goto L44
    L36:
        r8 = false;
        goto L37
    L16:
        if (r4 != 2) goto L18;
        r11.b.d.setTextColor(r11.a.getResources().getColor(2131101300));
        r11.b.d.setBackground(AppCompatResources.getDrawable(r11.a, 2131232120));
        r11.b.d.setText(r11.a.getString(2131902916));
        goto L29
    L18:
        if (r4 != 3) goto L20;
        r11.b.d.setTextColor(r11.a.getResources().getColor(2131103681));
        r11.b.d.setBackground(AppCompatResources.getDrawable(r11.a, 2131231925));
        r11.b.d.setText(r11.a.getString(2131902915));
        goto L29
    L20:
        if (r4 != 4) goto L23;
        r11.b.d.setTextColor(r11.a.getResources().getColor(2131103681));
        r11.b.d.setBackground(AppCompatResources.getDrawable(r11.a, 2131231925));
        r11.b.d.setText(r11.a.getString(2131902012));
        goto L29
    L23:
        throw new NoWhenBranchMatchedException();
    L27:
        r11.b.d.setVisibility(8);
        goto L29
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r20, int r21) {
        Intrinsics.checkNotNullParameter(r20, "parent");
        ConstraintLayout r1 = LayoutInflater.from(this.a).inflate(2131563397, r20, false);
        int r2 = 2131364451;
        View r5 = ViewBindings.findChildViewById(r1, 2131364451);
        if (r5 == null) goto L21;
        r2 = 2131367855;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r1, 2131367855);
        if (r6 == null) goto L21;
        r2 = 2131388084;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r1, 2131388084);
        if (r7 == null) goto L21;
        r2 = 2131388687;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r1, 2131388687);
        if (r8 == null) goto L21;
        r2 = 2131388772;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r1, 2131388772);
        if (r9 == null) goto L21;
        r2 = 2131391916;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131391916);
        if (r10 == null) goto L21;
        r2 = 2131391921;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r1, 2131391921);
        if (r11 == null) goto L21;
        r2 = 2131391934;
        UploadProgressView r12 = (UploadProgressView) ViewBindings.findChildViewById(r1, 2131391934);
        if (r12 == null) goto L21;
        LayoutRecordHistoryItemBinding r15 = new LayoutRecordHistoryItemBinding(r1, r5, r6, r7, r8, r9, r10, r11, r12);
        return new RecordMinutesViewHolder(this.a, r15, this.b, this.c, this.d);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public RecordMinutesAdapter(Context r2, p r3, q r4, r r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        Intrinsics.checkNotNullParameter(r4, "onItemDeleteClick");
        Intrinsics.checkNotNullParameter(r5, "onItemUploadClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = CollectionsKt.emptyList();
    }
}
