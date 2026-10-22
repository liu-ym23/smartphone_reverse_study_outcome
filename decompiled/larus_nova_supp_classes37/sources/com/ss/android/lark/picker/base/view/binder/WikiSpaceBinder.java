package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz7.d;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/WikiSpaceBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchWikiSpaceInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "getMContext", "()Landroid/content/Context;", "bindAvatar", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "needBindSummary", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class WikiSpaceBinder extends CommonBinder<SearchWikiSpaceInfo> {
    private final Context mContext;

    public boolean needBindSummary(SearchWikiSpaceInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return false;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ boolean needBindSummary(SearchBaseInfo r1) {
        return needBindSummary((SearchWikiSpaceInfo) r1);
    }

    public WikiSpaceBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
    }

    public void bindAvatar(ChatterChatViewHolder r2, SearchWikiSpaceInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        AvatarItemView r4 = r2.getAvatarItemView().getItem();
        d.a r5 = new d.a();
        r5.d(2131256279);
        r4.avatar(new d(r5));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchWikiSpaceInfo) r2);
    }
}
