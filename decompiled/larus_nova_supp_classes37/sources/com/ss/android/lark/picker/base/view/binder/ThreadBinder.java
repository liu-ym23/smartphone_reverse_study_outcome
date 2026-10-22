package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ThreadBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchThreadInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "getMContext", "()Landroid/content/Context;", "bindAvatar", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ThreadBinder extends CommonBinder<SearchThreadInfo> {
    private final Context mContext;

    public final Context getMContext() {
        return this.mContext;
    }

    public ThreadBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
    }

    public void bindAvatar(ChatterChatViewHolder r4, SearchThreadInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        AvatarItemView r0 = r4.getAvatarItemView().getItem();
        a.a r1 = new a.a();
        r1.b(r5.getAvatarKey());
        Channel r2 = r5.getChannel();
        if (r2 == null) goto L6;
        String r3 = r2.getId();
        if (r3 == null) goto L6;
    L7:
        r1.f(r3);
        r0.avatar(new a(r1));
        a.a r6 = new a.a();
        r6.e(AppCompatResources.getDrawable(this.mContext, 2131235361));
        r6.h(AvatarModel.Size.MINI);
        a r7 = new a(r6);
        r4.getAvatarItemView().getItem().miniAvatar(r7);
        return;
    L6:
        r3 = r5.getChatId();
        goto L7
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchThreadInfo) r2);
    }
}
