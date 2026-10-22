package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.UserGroupType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import v3c.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/UserGroupBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchUserGroupInfo;", "context", "Landroid/content/Context;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "needBindDynamicTag", "", "bind", "", "position", "", "data", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bindAvatar", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "bindTag", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class UserGroupBinder extends CommonBinder<SearchUserGroupInfo> {
    private final Context context;
    private final g onItemClickHandler;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[UserGroupType.values().length];
            r0[UserGroupType.GROUP_TYPE_DYNAMIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[UserGroupType.GROUP_TYPE_NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public boolean needBindDynamicTag() {
        return false;
    }

    public UserGroupBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "onItemClickHandler");
        super(r8, r9, null, 4, null);
        this.context = r8;
        this.onItemClickHandler = r9;
    }

    public void bindAvatar(ChatterChatViewHolder r3, SearchUserGroupInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (TextUtils.isEmpty(r4.getAvatarKey()) == true) goto L5;
        super.bindAvatar(r3, r4);
        return;
    L5:
        AvatarItemView r5 = r3.getAvatarItemView().getItem();
        a.a r6 = new a.a();
        r6.e(AppCompatResources.getDrawable(this.context, 2131235952));
        r5.avatar(new a(r6));
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchUserGroupInfo) r2);
    }

    public void bind(int r2, SearchUserGroupInfo r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof ChatterChatViewHolder) == false) goto L6;
        r3.setTitle(r3.getName());
        super.bind(r2, r3, r4);
        return;
    }

    public void bindTag(int r3, ChatterChatViewHolder r4, SearchUserGroupInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        super.bindTag(r3, r4, r5);
        UserGroupType.a r6 = UserGroupType.Companion;
        int r7 = r5.getUserGroupType();
        r6.getClass();
        UserGroupType r8 = UserGroupType.a.a(r7);
        int r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r9 != 1) goto L5;
        LarkNameTag.c r10 = new LarkNameTag.c(this.context);
        int r0 = f.g;
        f.a r1 = new f.a();
        r1.b = 50;
        r1.d = UIHelper.getString(2131891247);
        r1.f = Integer.valueOf(UIHelper.getColor(2131109131));
        r1.h = Integer.valueOf(UIHelper.getColor(2131109095));
        r10.d(new f(r1), true);
    L9:
        if (r10 == null) goto L12;
        r4.getAvatarItemView().getItem().setTag(r10);
        return;
    L12:
        return;
    L5:
        if (r9 == 2) goto L7;
        r10 = null;
        goto L9
    L7:
        r10 = new LarkNameTag.c(this.context);
        goto L9
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder, com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bind(int r1, SearchBaseInfo r2, RecyclerView.ViewHolder r3) {
        bind(r1, (SearchUserGroupInfo) r2, r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchUserGroupInfo) r3);
    }
}
