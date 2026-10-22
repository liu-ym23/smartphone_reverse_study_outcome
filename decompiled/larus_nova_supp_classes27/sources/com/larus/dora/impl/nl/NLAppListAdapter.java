package com.larus.dora.impl.nl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraItemApplistFooterBinding;
import com.larus.dora.impl.databinding.LarusDoraItemApplistHeaderBinding;
import com.larus.dora.impl.databinding.LarusDoraItemApplistItemBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u000f\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onAppListChangeItem", "Lkotlin/Function1;", "Lcom/larus/dora/impl/nl/AppListItem;", "", "getOnAppListChangeItem", "()Lkotlin/jvm/functions/Function1;", "setOnAppListChangeItem", "(Lkotlin/jvm/functions/Function1;)V", "dataList", "", "updateData", "data", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "Companion", "HeaderViewHolder", "ItemViewHolder", "FooterViewHolder", "AppListDiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NLAppListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Function1<? super AppListItem, Unit> a;
    public List<? extends AppListItem> b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListAdapter$AppListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/larus/dora/impl/nl/AppListItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppListDiffCallback extends DiffUtil.Callback {
        public final List<AppListItem> a;
        public final List<AppListItem> b;

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AppListDiffCallback(List<? extends AppListItem> r2, List<? extends AppListItem> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldList");
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r5, int r6) {
            AppListItem r7 = (AppListItem) ListProtector.get(this.a, r5);
            AppListItem r8 = (AppListItem) ListProtector.get(this.b, r6);
            if ((r7 instanceof AppListItem.c) == false) goto L14;
            if ((r8 instanceof AppListItem.c) == false) goto L14;
            AppListItem.c r9 = (AppListItem.c) r7;
            AppListItem.c r10 = (AppListItem.c) r8;
            if (Intrinsics.areEqual(r9.c.d(), r10.c.d()) == true) goto L9;
        L23:
            return false;
        L9:
            if (r9.a != r10.a) goto L23;
            if (r9.b != r10.b) goto L23;
            return true;
        L14:
            if ((r7 instanceof AppListItem.b) == false) goto L19;
            if ((r8 instanceof AppListItem.b) == false) goto L19;
            return Intrinsics.areEqual(((AppListItem.b) r7).a, ((AppListItem.b) r8).a);
        L19:
            if ((r7 instanceof AppListItem.a) == false) goto L23;
            if ((r8 instanceof AppListItem.a) == false) goto L23;
            return true;
        }

        public final boolean areItemsTheSame(int r1, int r2) {
            return areContentsTheSame(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemApplistFooterBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraItemApplistFooterBinding;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(LarusDoraItemApplistFooterBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemApplistHeaderBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraItemApplistHeaderBinding;)V", "bind", "", "header", "Lcom/larus/dora/impl/nl/AppListItem$Header;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final LarusDoraItemApplistHeaderBinding a;

        public HeaderViewHolder(LarusDoraItemApplistHeaderBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/nl/NLAppListAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemApplistItemBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraItemApplistItemBinding;)V", "bind", "", "item", "Lcom/larus/dora/impl/nl/AppListItem$Item;", "actionCallback", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final LarusDoraItemApplistItemBinding a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[AppListItem.BackgroundType.values().length];
                r0[AppListItem.BackgroundType.FIRST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[AppListItem.BackgroundType.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[AppListItem.BackgroundType.LAST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[AppListItem.BackgroundType.DEFAULT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public ItemViewHolder(LarusDoraItemApplistItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public NLAppListAdapter() {
        this.b = CollectionsKt.emptyList();
    }

    public final int getItemViewType(int r2) {
        AppListItem r3 = (AppListItem) ListProtector.get(this.b, r2);
        if ((r3 instanceof AppListItem.b) == false) goto L6;
        return 0;
    L6:
        if ((r3 instanceof AppListItem.c) == false) goto L9;
        return 1;
    L9:
        if ((r3 instanceof AppListItem.a) == false) goto L13;
        return 2;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof HeaderViewHolder) == false) goto L6;
        HeaderViewHolder r8 = (HeaderViewHolder) r6;
        Object r9 = ListProtector.get(this.b, r7);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.larus.dora.impl.nl.AppListItem.Header");
        AppListItem.b r10 = (AppListItem.b) r9;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "header");
        r8.a.b.setText(r10.a);
        return;
    L6:
        if ((r6 instanceof ItemViewHolder) == false) goto L62;
        ItemViewHolder r11 = (ItemViewHolder) r6;
        Object r12 = ListProtector.get(this.b, r7);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.larus.dora.impl.nl.AppListItem.Item");
        final AppListItem.c r13 = (AppListItem.c) r12;
        final Function1<? super AppListItem, Unit> r0 = this.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        LarusDoraItemApplistItemBinding r14 = r11.a;
        r14.e.setText(r13.c.c());
        AppListItem.BackgroundType r1 = r13.b;
        int r2 = ItemViewHolder.a.a[r1.ordinal()];
        String r3 = null;
        if (r2 != 1) goto L10;
        boolean r4 = v19.h.a;
        if (v19.h.a(null) == false) goto L32;
        int r5 = 2131240412;
    L33:
        r14.c.setBackgroundResource(r5);
        View r15 = r14.f;
        AppListItem.BackgroundType r16 = r13.b;
        if (r16 != AppListItem.BackgroundType.LAST) goto L36;
    L39:
        int r17 = 8;
    L40:
        r15.setVisibility(r17);
        if (com.larus.utils.o0.d(r13.c.b()) == false) goto L43;
        ImageLoaderKt.u(r14.d, r13.c.b(), "tag_dora_nl_app_list_image");
    L56:
        if (r13.a == false) goto L58;
        int r18 = 2131240507;
    L59:
        r14.b.setImageResource(r18);
        e1.d(r14.b, new e(r0, r13));
        return;
    L58:
        r18 = 2131240505;
        goto L59
    L43:
        boolean r20 = v19.h.a;
        if (v19.h.a(null) == false) goto L48;
        com.larus.dora.impl.network.g0 r21 = DoraUserSettingsManager.c.d();
        if (r21 == null) goto L52;
        r3 = r21.b();
    L52:
        if (com.larus.utils.o0.d(r3) == false) goto L54;
        ImageLoaderKt.u(r14.d, r3, "tag_dora_nl_app_list_image");
        goto L56
    L54:
        r14.d.setImageResource(2131240506);
        goto L56
    L48:
        com.larus.dora.impl.network.g0 r22 = DoraUserSettingsManager.c.d();
        if (r22 == null) goto L52;
        r3 = r22.c();
        goto L52
    L36:
        if (r16 == AppListItem.BackgroundType.DEFAULT) goto L39;
        r17 = 0;
        goto L40
    L32:
        r5 = 2131240417;
        goto L33
    L10:
        if (r2 != 2) goto L12;
        boolean r23 = v19.h.a;
        if (v19.h.a(null) == false) goto L28;
        r5 = 2131240414;
        goto L33
    L28:
        r5 = 2131240419;
        goto L33
    L12:
        if (r2 != 3) goto L14;
        boolean r24 = v19.h.a;
        if (v19.h.a(null) == false) goto L24;
        r5 = 2131240413;
        goto L33
    L24:
        r5 = 2131240418;
        goto L33
    L14:
        if (r2 != 4) goto L20;
        boolean r25 = v19.h.a;
        if (v19.h.a(null) == false) goto L18;
        r5 = 2131240428;
        goto L33
    L18:
        r5 = 2131240415;
        goto L33
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        if (r12 != 0) goto L5;
        View r13 = LayoutInflater.from(r11.getContext()).inflate(2131562212, r11, false);
        TextView r2 = (TextView) ViewBindings.findChildViewById(r13, 2131388772);
        if (r2 == null) goto L33;
        RecyclerView.ViewHolder r14 = new HeaderViewHolder(new LarusDoraItemApplistHeaderBinding((FrameLayout) r13, r2));
    L31:
        return r14;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(2131388772)));
    L5:
        if (r12 != 1) goto L7;
        ConstraintLayout r15 = LayoutInflater.from(r11.getContext()).inflate(2131562213, r11, false);
        int r1 = 2131363095;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r15, 2131363095);
        if (r5 == null) goto L27;
        r1 = 2131363096;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131363096);
        if (r6 == null) goto L27;
        r1 = 2131363097;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r15, 2131363097);
        if (r7 == null) goto L27;
        r1 = 2131363098;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, 2131363098);
        if (r8 == null) goto L27;
        ConstraintLayout r4 = r15;
        r1 = 2131369197;
        View r9 = ViewBindings.findChildViewById(r15, 2131369197);
        if (r9 == null) goto L27;
        r14 = new ItemViewHolder(new LarusDoraItemApplistItemBinding(r4, r5, r6, r7, r8, r9));
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r1)));
    L7:
        if (r12 != 2) goto L14;
        View r16 = LayoutInflater.from(r11.getContext()).inflate(2131562211, r11, false);
        if (r16 == null) goto L12;
        r14 = new FooterViewHolder(new LarusDoraItemApplistFooterBinding((Space) r16));
        goto L31
    L12:
        throw new NullPointerException("rootView");
    L14:
        throw new IllegalArgumentException("Invalid view type");
    }
}
