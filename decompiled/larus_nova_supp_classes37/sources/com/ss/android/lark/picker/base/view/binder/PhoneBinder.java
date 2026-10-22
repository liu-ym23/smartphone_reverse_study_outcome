package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/PhoneBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bindTag", "", "position", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "needBindDynamicTag", "", "bindAvatar", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PhoneBinder extends CommonBinder<SearchBaseInfo> {
    private final Context mContext;
    private final g mOnItemClickHandler;

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public boolean needBindDynamicTag() {
        return false;
    }

    public PhoneBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindAvatar(ChatterChatViewHolder r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        if (TextUtils.isEmpty(r3.getAvatarKey()) == true) goto L5;
        super.bindAvatar(r2, r3);
        return;
    L5:
        Drawable r4 = UIHelper.getDrawable(2131232478);
        AvatarItemView r5 = r2.getAvatarItemView().getItem();
        a.a r0 = new a.a();
        r0.e(r4);
        r5.avatar(new a(r0));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        LarkNameTag.e r4 = new LarkNameTag.e(this.mContext);
        ((LarkNameTag.c) r4).e = true;
        r2.getAvatarItemView().getItem().setTag(r4);
    }
}
