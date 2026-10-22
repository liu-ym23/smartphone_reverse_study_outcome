package com.larus.chat.search.impl.chat.section;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import com.larus.chat.search.impl.chat.p;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionEmptyBinding;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionLastBinding;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionNormalBinding;
import com.larus.chat.search.impl.databinding.LarusItemSearchSectionTimeBinding;
import com.larus.common_ui.paging.FPListAdapter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lz8.a;
import lz8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/chat/search/impl/chat/section/SectionListAdapter;", "Lcom/larus/common_ui/paging/FPListAdapter;", "Lcom/larus/chat/search/api/model/SectionItemData;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "config", "Lcom/larus/common_ui/paging/FPListAdapter$Config;", "listener", "Lcom/larus/chat/search/impl/chat/section/ISectionItemListener;", "<init>", "(Lcom/larus/common_ui/paging/FPListAdapter$Config;Lcom/larus/chat/search/impl/chat/section/ISectionItemListener;)V", "onBindViewHolder", "", "holder", "data", "position", "", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "canLoadMore", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionListAdapter extends FPListAdapter<SectionItemData, RecyclerView.ViewHolder> {
    public final a d;

    public final int getItemViewType(int r2) {
        SectionItemData r3 = (SectionItemData) CollectionsKt.getOrNull(getCurrentList(), r2);
        if (r3 == null) goto L5;
        SectionViewType r4 = r3.getViewType();
        if (r4 != null) goto L11;
        r4 = SectionViewType.EMPTY;
    L11:
        return r4.getType();
    L5:
        return SectionViewType.EMPTY.getType();
    }

    public SectionListAdapter(FPListAdapter.a r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2, new SectionItemCallback());
        this.d = r3;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        LayoutInflater r0 = LayoutInflater.from(r5.getContext());
        SectionViewType.Companion.getClass();
        SectionViewType r7 = SectionViewType.a.a(r6);
        int r1 = SectionItemTimeViewHolder.b;
        if (r7 != SectionViewType.TIME) goto L9;
        ConstraintLayout r8 = r0.inflate(2131562659, r5, false);
        AppCompatTextView r2 = ViewBindings.findChildViewById(r8, 2131385722);
        if (r2 == null) goto L8;
        return new SectionItemTimeViewHolder(new LarusItemSearchSectionTimeBinding(r8, r2));
    L8:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(2131385722)));
    L9:
        int r3 = SectionItemNormalViewHolder.b;
        if (r7 == SectionViewType.NORMAL) goto L29;
        int r4 = SectionItemLastHolder.a;
        if (r7 != SectionViewType.LAST) goto L19;
        ConstraintLayout r9 = r0.inflate(2131562657, r5, false);
        if (r9 == null) goto L18;
        return new SectionItemLastHolder(new LarusItemSearchSectionLastBinding(r9));
    L18:
        throw new NullPointerException("rootView");
    L19:
        int r10 = SectionItemExternalViewHolder.b;
        if (r7 == SectionViewType.EXTERNAL) goto L31;
        ConstraintLayout r11 = r0.inflate(2131562656, r5, false);
        if (r11 == null) goto L27;
        return new SectionItemEmptyHolder(new LarusItemSearchSectionEmptyBinding(r11));
    L27:
        throw new NullPointerException("rootView");
    L31:
        return new SectionItemExternalViewHolder(LarusItemSearchSectionNormalBinding.a(r0, r5));
    L29:
        return new SectionItemNormalViewHolder(LarusItemSearchSectionNormalBinding.a(r0, r5));
    }

    public final void y2(RecyclerView.ViewHolder r1, Object r2, int r3) {
        SectionItemData r4 = (SectionItemData) r2;
        Intrinsics.checkNotNullParameter(r1, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        if ((r1 instanceof b) == false) goto L5;
        b r5 = (b) r1;
    L6:
        if (r5 == null) goto L9;
        r5.C1(r4, this.d);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
