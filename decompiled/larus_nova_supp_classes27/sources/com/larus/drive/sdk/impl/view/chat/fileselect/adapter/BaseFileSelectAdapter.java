package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import com.larus.drive.sdk.impl.databinding.LarusItemBaseFileSelectBinding;
import com.larus.drive.sdk.impl.service.t;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005#$%&'B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0010H\u0014J\u0006\u0010\u0017\u001a\u00020\u0012J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0004J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0004J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0002R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006("}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$BaseViewHolder;", "<init>", "()V", "selectedIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "getSelectedIds", "()Ljava/util/LinkedHashSet;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "bindFileViewHolder", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$FileViewHolder;", "clearSelection", "replaceSelection", "newSelectedIds", "", "submitListAndPruneSelection", "list", "", "dedupeByIdKeepFirst", "updateSelection", "id", "isSelected", "", "BaseViewHolder", "FileViewHolder", "LoadMoreFooterViewHolder", "FileDiffCallback", "ViewType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFileSelectAdapter extends ListAdapter<x79.a, BaseViewHolder> {
    public final LinkedHashSet<String> a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "isSelected", "", "onClick", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        public void T3(x79.a r1, boolean r2, Function1<? super x79.a, Unit> r3) {
            Intrinsics.checkNotNullParameter(r1, "item");
            Intrinsics.checkNotNullParameter(r3, "onClick");
        }

        public BaseViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$FileDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FileDiffCallback extends DiffUtil.ItemCallback<x79.a> {
        public FileDiffCallback() {
        }

        public final boolean areContentsTheSame(Object r2, Object r3) {
            x79.a r4 = (x79.a) r2;
            x79.a r5 = (x79.a) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4, r5);
        }

        public final boolean areItemsTheSame(Object r2, Object r3) {
            x79.a r4 = (x79.a) r2;
            x79.a r5 = (x79.a) r3;
            Intrinsics.checkNotNullParameter(r4, "oldItem");
            Intrinsics.checkNotNullParameter(r5, "newItem");
            return Intrinsics.areEqual(r4.a, r5.a);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$FileViewHolder;", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$BaseViewHolder;", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusItemBaseFileSelectBinding;", "<init>", "(Lcom/larus/drive/sdk/impl/databinding/LarusItemBaseFileSelectBinding;)V", "bind", "", "item", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "isSelected", "", "onClick", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class FileViewHolder extends BaseViewHolder {
        public static final /* synthetic */ int b = 0;
        public final LarusItemBaseFileSelectBinding a;

        public FileViewHolder(LarusItemBaseFileSelectBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }

        @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter.BaseViewHolder
        public final void T3(final x79.a r8, boolean r9, final Function1<? super x79.a, Unit> r10) {
            Intrinsics.checkNotNullParameter(r8, "item");
            Intrinsics.checkNotNullParameter(r10, "onClick");
            this.a.f.setText(r8.b);
            AppCompatTextView r0 = this.a.f;
            boolean r2 = true;
            r0.setTypeface(r0.getTypeface(), 1);
            this.a.d.setText(r8.c);
            this.a.c.setSelected(r9);
            if (r8.h == BaseFileSelectFromType.DRIVE) goto L5;
        L15:
            this.a.b.setVisibility(0);
            this.a.e.setVisibility(8);
            ImageLoaderKt.e(this.a.e);
            this.a.b.setImageResource(r8.d);
        L16:
            e1.d(this.a.a, new d(r10, r8));
            return;
        L5:
            if (r8.g == false) goto L15;
            Resources r11 = this.a.a.getResources();
            int r12 = RangesKt.coerceAtLeast(r11.getDimensionPixelSize(v19.c.b(2130971512, null, 2131167393)) - (r11.getDimensionPixelSize(v19.c.b(2130971480, null, 2131167331)) * 2), 1);
            String r13 = t.b().f(r8.a, r12, r12);
            if (r13 != null) goto L9;
        L12:
            if (r2 == true) goto L14;
            this.a.b.setVisibility(8);
            this.a.e.setVisibility(0);
            ImageLoaderKt.u(this.a.e, r13, "chat.single.img_thumb");
            goto L16
        L14:
            this.a.b.setVisibility(0);
            this.a.e.setVisibility(8);
            ImageLoaderKt.e(this.a.e);
            this.a.b.setImageResource(r8.d);
            goto L16
        L9:
            if (r13.length() == 0) goto L12;
            r2 = false;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$LoadMoreFooterViewHolder;", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/larus/drive/sdk/api/file/select/BaseFileSelectConfig;", "isSelected", "", "onClick", "Lkotlin/Function1;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadMoreFooterViewHolder extends BaseViewHolder {
        public LoadMoreFooterViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }

        @Override // com.larus.drive.sdk.impl.view.chat.fileselect.adapter.BaseFileSelectAdapter.BaseViewHolder
        public final void T3(x79.a r1, boolean r2, Function1<? super x79.a, Unit> r3) {
            Intrinsics.checkNotNullParameter(r1, "item");
            Intrinsics.checkNotNullParameter(r3, "onClick");
            AlphaAnimation r4 = new AlphaAnimation(0.6f, 1.0f);
            r4.setDuration(600);
            r4.setRepeatMode(2);
            r4.setRepeatCount(-1);
            ((RecyclerView.ViewHolder) this).itemView.clearAnimation();
            ((RecyclerView.ViewHolder) this).itemView.startAnimation(r4);
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/adapter/BaseFileSelectAdapter$ViewType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "FILE", "LOADING_FOOTER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ViewType extends Enum<ViewType> {
        public static final ViewType FILE = null;
        public static final ViewType LOADING_FOOTER = null;
        public static final /* synthetic */ ViewType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int id;

        public static EnumEntries<ViewType> getEntries() {
            return b;
        }

        static {
            ViewType r0 = new ViewType("FILE", 0, 0);
            FILE = r0;
            ViewType r1 = new ViewType("LOADING_FOOTER", 1, 1);
            LOADING_FOOTER = r1;
            ViewType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ViewType[] values() {
            return (ViewType[]) a.clone();
        }

        public final int getId() {
            return this.id;
        }

        public static ViewType valueOf(String r1) {
            return (ViewType) r27.a.a(ViewType.class, r1);
        }

        public ViewType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }
    }

    public BaseFileSelectAdapter() {
        super(new FileDiffCallback());
        this.a = new LinkedHashSet();
    }

    public final void A2(List<x79.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        if ((!this.a.isEmpty()) == false) goto L5;
        this.a.retainAll(SequencesKt.toHashSet(SequencesKt.map(CollectionsKt.asSequence(r3), new a())));
    L5:
        submitList(r3);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BaseViewHolder r5 = (BaseViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        if ((r5 instanceof FileViewHolder) == false) goto L5;
        y2((FileViewHolder) r5, r4);
        return;
    L5:
        r5.T3((x79.a) getItem(r4), false, new b());
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1, r2);
    }

    public void y2(FileViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        x79.a r5 = (x79.a) getItem(r4);
        Intrinsics.checkNotNull(r5);
        r3.T3(r5, this.a.contains(r5.a), new c(this));
    }

    public BaseViewHolder z2(ViewGroup r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        ConstraintLayout r11 = LayoutInflater.from(r9.getContext()).inflate(2131562501, r9, false);
        int r12 = 2131363983;
        AppCompatImageView r3 = ViewBindings.findChildViewById(r11, 2131363983);
        if (r3 == null) goto L19;
        r12 = 2131363984;
        if (((RoundFrameLayout) ViewBindings.findChildViewById(r11, 2131363984)) == null) goto L19;
        r12 = 2131363985;
        View r4 = ViewBindings.findChildViewById(r11, 2131363985);
        if (r4 == null) goto L19;
        r12 = 2131363986;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r11, 2131363986);
        if (r5 == null) goto L19;
        r12 = 2131363987;
        if (((LinearLayout) ViewBindings.findChildViewById(r11, 2131363987)) == null) goto L19;
        r12 = 2131363988;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r11, 2131363988);
        if (r6 == null) goto L19;
        r12 = 2131363989;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r11, 2131363989);
        if (r7 == null) goto L19;
        return new FileViewHolder(new LarusItemBaseFileSelectBinding(r11, r3, r4, r5, r6, r7));
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
