package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.picker.base.view.binder.RelatedContactsBinder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\rJ\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rJ\u0016\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/picker/base/view/RelatedContactsAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "context", "Landroid/content/Context;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "relatedContactsBinder", "Lcom/ss/android/lark/picker/base/view/binder/RelatedContactsBinder;", "mShowDivider", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "switchMultiple", "isMultiple", "onSelected", "id", "", "selected", "onDeSelected", "deSelected", "getItem", "showDivider", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RelatedContactsAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, SearchBaseInfo> {
    private final Context context;
    private boolean mShowDivider;
    private final RelatedContactsBinder relatedContactsBinder;

    public SearchBaseInfo getItem(int r1) {
        SearchBaseInfo r2 = (SearchBaseInfo) super.getItem(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new SearchBaseInfo();
    }

    public final void showDivider(boolean r1) {
        this.mShowDivider = r1;
        notifyDataSetChanged();
    }

    public final void switchMultiple(boolean r2) {
        this.relatedContactsBinder.switchMultiple(r2);
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: getItem, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3354getItem(int r1) {
        return getItem(r1);
    }

    public RelatedContactsAdapter(Context r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onItemClickHandler");
        this.context = r2;
        this.relatedContactsBinder = new RelatedContactsBinder(r2, r3);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        SearchBaseInfo r0 = getItem(r4);
        if ((r3 instanceof ChatterChatViewHolder) == true) goto L5;
        return;
    L5:
        if ((r0 instanceof SearchChatterInfo) == false) goto L9;
        ((ChatterChatViewHolder) r3).getAvatarItemView().getItem().resetAllViews();
        this.relatedContactsBinder.bind(r4, r0, r3);
        return;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        AvatarItemViewWithMask r10 = new AvatarItemViewWithMask(this.context, null, 0, 6, null);
        r10.showDivider(this.mShowDivider);
        return new ChatterChatViewHolder(r10, r9);
    }

    public final void onDeSelected(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        if (r4 == false) goto L5;
        return;
    L5:
        List r5 = getItems();
        if (r5 == null) goto L17;
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(r3, ((SearchBaseInfo) r0).getId()) == false) goto L9;
    L14:
        SearchBaseInfo r1 = (SearchBaseInfo) r0;
        if (r1 == null) goto L17;
        r1.selected(false);
        goto L17
    L13:
        r0 = null;
    L17:
        notifyDataSetChanged();
    }

    public final void onSelected(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "id");
        if (r4 == true) goto L5;
        return;
    L5:
        List r5 = getItems();
        if (r5 == null) goto L17;
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r0 = r6.next();
        if (Intrinsics.areEqual(r3, ((SearchBaseInfo) r0).getId()) == false) goto L9;
    L14:
        SearchBaseInfo r1 = (SearchBaseInfo) r0;
        if (r1 == null) goto L17;
        r1.selected(true);
        goto L17
    L13:
        r0 = null;
    L17:
        notifyDataSetChanged();
    }

    public static /* synthetic */ void showDivider$default(RelatedContactsAdapter r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.showDivider(r1);
    }
}
