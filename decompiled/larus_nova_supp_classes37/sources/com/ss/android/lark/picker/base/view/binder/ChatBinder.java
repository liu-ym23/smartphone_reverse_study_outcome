package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.bytedance.lark.pb.search.v2.ResultSourceType;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;
import w3c.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0019\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u001aH\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\u00020\u000bX\u0096\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u00020 X\u0096\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ChatBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchChatInfo;", "Lcom/ss/android/lark/picker/base/view/binder/IChatPreviewBinder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "mDisableExternalChat", "", "bindSubTitle", "", "data", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "bindTag", "position", "", "bindOthers", "disableExternalChat", "checkDisable", "onDisableClickHandler", "startPreview", "context", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isEnableChatPreview", "()Z", "setEnableChatPreview", "(Z)V", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ChatBinder extends CommonBinder<SearchChatInfo> implements IChatPreviewBinder {
    private final /* synthetic */ ChatPreviewBinder $$delegate_0;
    private final Context mContext;
    private boolean mDisableExternalChat;
    private final g mOnItemClickHandler;

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public String getScene() {
        return this.$$delegate_0.getScene();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public boolean isEnableChatPreview() {
        return this.$$delegate_0.isEnableChatPreview();
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public void setEnableChatPreview(boolean r2) {
        this.$$delegate_0.setEnableChatPreview(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setScene(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.IChatPreviewBinder
    public void startPreview(Context r2, SearchBaseInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.$$delegate_0.startPreview(r2, r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void onDisableClickHandler() {
        LKUIToast.show(this.mContext, 2131890335);
    }

    public static final /* synthetic */ Context access$getMContext$p(ChatBinder r0) {
        return r0.mContext;
    }

    public boolean checkDisable(SearchChatInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (this.mDisableExternalChat == true) goto L5;
    L7:
        return false;
    L5:
        if (isExternal(r2) == false) goto L7;
        return true;
    }

    public final void disableExternalChat(boolean r1) {
        this.mDisableExternalChat = r1;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ boolean checkDisable(SearchBaseInfo r1) {
        return checkDisable((SearchChatInfo) r1);
    }

    public ChatBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.$$delegate_0 = new ChatPreviewBinder();
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
    }

    public void bindSubTitle(SearchChatInfo r2, ChatterChatViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "holder");
        if (getFgUtils().isExtraInfoEnable() == true) goto L5;
    L7:
        super.bindSubTitle(r2, r3);
        return;
    L5:
        if (isDisableExtraInfoSummary() == true) goto L7;
        r2.setSubTitle("");
        super.bindSubTitle(r2, r3);
        bindExtraInfoSummary(r3, r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindSubTitle(SearchBaseInfo r1, ChatterChatViewHolder r2) {
        bindSubTitle((SearchChatInfo) r1, r2);
    }

    public void bindOthers(int r6, ChatterChatViewHolder r7, final SearchChatInfo r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "data");
        if (r8.getChatType() == Chat.Type.P2P) goto L23;
        if (r8.getChatType() == Chat.Type.THREAD_DETAIL) goto L23;
        int r9 = r8.getUserCount();
        if (r9 > 0) goto L9;
        r9 = r8.getMemberCount();
    L9:
        if (r9 > 0) goto L11;
    L13:
        String r10 = "";
    L15:
        if (isSingleChoice(r8) == false) goto L18;
        h r0 = new h(r10, 2131105548, 4);
    L21:
        r7.getAvatarItemView().getItem().titleTail(r0);
    L27:
        r7.getAvatarItemView().getChatPreviewIcon().setVisibility(8);
        r7.getAvatarItemView().getChatPreviewIcon().setOnClickListener(null);
        if (r8.isMember() == true) goto L30;
        return;
    L30:
        if (isEnableChatPreview() == true) goto L32;
        return;
    L32:
        if (r8.isSecretChat() == false) goto L34;
        return;
    L34:
        if (isChatPreviewDisabled(r8) == true) goto L40;
        r7.getAvatarItemView().getChatPreviewIcon().setVisibility(0);
        r7.getAvatarItemView().getChatPreviewIcon().setOnClickListener(new AnonymousClass1(this, r8));
        return;
    L40:
        return;
    L18:
        if (r8.isCountLightStyle() == false) goto L20;
        r0 = new h(r10, 2131106620, 4);
        goto L21
    L20:
        r0 = new h(r10, 2131106622, 4);
        goto L21
    L11:
        if (r8.isUserCountVisible() == false) goto L13;
        r10 = SearchCommonUtils.getCountString(r9);
    L23:
        if (isSingleChoice(r8) == false) goto L25;
        h r11 = new h(null, 2131105548, 4);
    L26:
        r7.getAvatarItemView().getItem().titleTail(r11);
        goto L27
    L25:
        r11 = new h(null, 0, 7);
        goto L26
    }

    public void bindTag(int r7, ChatterChatViewHolder r8, SearchChatInfo r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "data");
        LarkNameTag.d r10 = new LarkNameTag.d(this.mContext);
        if (r9.getTagData() == null) goto L9;
        TagData r0 = r9.getTagData();
        if (r0 == null) goto L7;
        TagData.Companion.getClass();
        List r1 = TagData.a.b(r0);
    L8:
        r10.g(r1);
        goto L9
    L7:
        r1 = CollectionsKt.emptyList();
    L9:
        boolean r2 = true;
        if (getFgUtils().isSpotlightLocalTagEnable() == true) goto L12;
    L16:
        List r3 = r9.getTags();
        if (r3 == null) goto L19;
        boolean r4 = r3.contains(Tag.ON_CALL);
    L20:
        if (r4 == true) goto L28;
        List r5 = r9.getTags();
        if (r5 == null) goto L24;
        boolean r6 = r5.contains(Tag.ONCALL_OFFLINE);
    L25:
        if (r6 == true) goto L28;
        boolean r11 = false;
    L29:
        List r12 = r9.getTags();
        if (r12 == null) goto L32;
        boolean r13 = r12.contains(Tag.ONCALL_OFFLINE);
    L34:
        if (r9.isOfficialOnCall() == true) goto L42;
        List r14 = r9.getTags();
        if (r14 == null) goto L38;
        boolean r15 = r14.contains(Tag.OFFICIAL);
    L39:
        if (r15 == true) goto L42;
        r2 = false;
        goto L42
    L38:
        r15 = false;
    L42:
        r10.w = r9.isPublic();
        r10.t = r9.isDepartment();
        r10.p = r9.isMeeting();
        r10.v = r9.isTenant();
        r10.q = r9.isSecretChat();
        r10.y = r2;
        r10.n = r11;
        r10.o = r13;
        ((LarkNameTag.c) r10).f = r9.isCrossWithKa();
        r8.getAvatarItemView().getItem().setTag(r10);
        return;
    L32:
        r13 = false;
        goto L34
    L24:
        r6 = false;
    L28:
        r11 = true;
        goto L29
    L19:
        r4 = false;
        goto L20
    L12:
        if (r9.isSpotlight() == false) goto L16;
        if (r9.getSourceType() != ResultSourceType.LOCAL) goto L16;
        int r16 = f.g;
        f.a r17 = new f.a();
        r17.d = "Local";
        r17.e = 2131109125;
        r17.g = 2131109083;
        r10.d(new f(r17), true);
        goto L16
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindOthers(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindOthers(r1, r2, (SearchChatInfo) r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchChatInfo) r3);
    }
}
