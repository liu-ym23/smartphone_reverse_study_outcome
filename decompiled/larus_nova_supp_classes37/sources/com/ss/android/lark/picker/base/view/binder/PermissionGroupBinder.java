package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchPermissionGroupInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/PermissionGroupBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchPermissionGroupInfo;", "context", "Landroid/content/Context;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "needBindDynamicTag", "", "bind", "", "position", "", "data", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bindAvatar", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "bindTag", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PermissionGroupBinder extends CommonBinder<SearchPermissionGroupInfo> {
    private final Context context;

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public boolean needBindDynamicTag() {
        return false;
    }

    public PermissionGroupBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "onItemClickHandler");
        super(r8, r9, null, 4, null);
        this.context = r8;
    }

    public void bindAvatar(ChatterChatViewHolder r3, SearchPermissionGroupInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        AvatarItemView r5 = r3.getAvatarItemView().getItem();
        a.a r6 = new a.a();
        r6.e(AppCompatResources.getDrawable(this.context, 2131247266));
        r5.avatar(new a(r6));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchPermissionGroupInfo) r2);
    }

    public void bind(int r2, SearchPermissionGroupInfo r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof ChatterChatViewHolder) == false) goto L6;
        super.bind(r2, r3, r4);
        return;
    }

    public void bindTag(int r1, ChatterChatViewHolder r2, SearchPermissionGroupInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        r2.getAvatarItemView().getItem().resetTags();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder, com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bind(int r1, SearchBaseInfo r2, RecyclerView.ViewHolder r3) {
        bind(r1, (SearchPermissionGroupInfo) r2, r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchPermissionGroupInfo) r3);
    }
}
