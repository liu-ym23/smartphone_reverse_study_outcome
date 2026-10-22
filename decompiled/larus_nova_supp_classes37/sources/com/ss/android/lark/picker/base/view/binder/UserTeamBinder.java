package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchUserTeamInfo;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;
import w3c.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/UserTeamBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchUserTeamInfo;", "context", "Landroid/content/Context;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "needBindDynamicTag", "", "bind", "", "position", "", "data", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bindTag", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "bindSubTitle", "bindOthers", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class UserTeamBinder extends CommonBinder<SearchUserTeamInfo> {
    public static final Companion Companion = null;
    private static final float SUB_TITLE_SIZE = 12.0f;
    private final Context context;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/UserTeamBinder$Companion;", "", "<init>", "()V", "SUB_TITLE_SIZE", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public boolean needBindDynamicTag() {
        return false;
    }

    public UserTeamBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "onItemClickHandler");
        super(r8, r9, null, 4, null);
        this.context = r8;
    }

    public void bindSubTitle(SearchUserTeamInfo r4, ChatterChatViewHolder r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "holder");
        f r0 = new f(r4.getSubTitle());
        r0.c = r4.getSubTitleTagList();
        r0.f = Float.valueOf(d.a(this.context, 12.0f));
        r0.e = isSingleChoice(r4);
        r0.g = TextUtils.TruncateAt.START;
        r5.getAvatarItemView().getItem().subTitle(r0);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindSubTitle(SearchBaseInfo r1, ChatterChatViewHolder r2) {
        bindSubTitle((SearchUserTeamInfo) r1, r2);
    }

    public void bind(int r2, SearchUserTeamInfo r3, RecyclerView.ViewHolder r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof ChatterChatViewHolder) == false) goto L6;
        super.bind(r2, r3, r4);
        return;
    }

    public void bindOthers(int r1, ChatterChatViewHolder r2, SearchUserTeamInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        r2.getAvatarItemView().getChatPreviewIcon().setVisibility(8);
        r2.getAvatarItemView().getItem().userTeamBadge();
    }

    public void bindTag(int r1, ChatterChatViewHolder r2, SearchUserTeamInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        r2.getAvatarItemView().getItem().resetTags();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder, com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bind(int r1, SearchBaseInfo r2, RecyclerView.ViewHolder r3) {
        bind(r1, (SearchUserTeamInfo) r2, r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindOthers(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindOthers(r1, r2, (SearchUserTeamInfo) r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchUserTeamInfo) r3);
    }
}
