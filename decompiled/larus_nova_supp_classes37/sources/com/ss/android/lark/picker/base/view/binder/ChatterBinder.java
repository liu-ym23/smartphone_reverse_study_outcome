package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.lark.pb.search.v2.ResultSourceType;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.chat.entity.chatter.WorkStatus;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.reporter.SearchClickReporter;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.utils.UIHelper;
import h18.d;
import hpc.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz7.a;
import v3c.g;
import v3c.i;
import w3c.e;
import w3c.f;
import w3c.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001>B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J \u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J \u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\rJ\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010)\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0019\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u000204H\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u00105\u001a\u00020\rX\u0096\u000f¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u00109\u001a\u00020(X\u0096\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ChatterBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "Lcom/ss/android/lark/picker/base/view/binder/IChatPreviewBinder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "updateHistoryListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;)V", "mDisableExternalChatter", "", "viewWidth", "", "bind", "", "position", "data", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "contentViewSizeProvider", "Lcom/ss/android/lark/search/dto/SearchItemInterface$ContentViewSizeProvider;", "bindAvatar", "bindTag", "bindSubTitle", "bindOthers", "bindPreviewOrIcon", "bindUserStatus", "bindCustomStatus", "customStatusList", "", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "isUnShowUserStatus", "disableExternalChatter", "handleChatterProfileCardClick", "openContactProfileChatter", "openContactProfileForSecretP2pChat", "secretP2pChatId", "", "checkDisable", "onDisableClickHandler", "onProfileClickListener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "getOnProfileClickListener", "()Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "setOnProfileClickListener", "(Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;)V", "isCrossTenantP2PCryptoChat", "startPreview", "context", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isEnableChatPreview", "()Z", "setEnableChatPreview", "(Z)V", "scene", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ChatterBinder extends CommonBinder<SearchChatterInfo> implements IChatPreviewBinder {
    private static final int CONTACT_ICON_WIDTH = 24;
    public static final Companion Companion = null;
    private static final String PROFILE_SIGN_SCENE = "profile_sign";
    private static final float SUB_TITLE_SIZE = 12.0f;
    private static final String TAG = "LarkSearch.Common.ChatterBuilder";
    private final /* synthetic */ ChatPreviewBinder $$delegate_0;
    private final Context mContext;
    private boolean mDisableExternalChatter;
    private final g mOnItemClickHandler;
    private IOnProfileClickListener onProfileClickListener;
    private final i updateHistoryListener;
    private int viewWidth;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ChatterBinder$Companion;", "", "<init>", "()V", "TAG", "", "CONTACT_ICON_WIDTH", "", "SUB_TITLE_SIZE", "", "PROFILE_SIGN_SCENE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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
        LKUIToast.show(this.mContext, 2131890336);
    }

    public final IOnProfileClickListener getOnProfileClickListener() {
        return this.onProfileClickListener;
    }

    public static final /* synthetic */ Context access$getMContext$p(ChatterBinder r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ i access$getUpdateHistoryListener$p(ChatterBinder r0) {
        return r0.updateHistoryListener;
    }

    private final boolean isCrossTenantP2PCryptoChat(SearchChatterInfo r2) {
        if (r2.isP2pCryptoChat() == true) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2.getTenantId()) == false) goto L7;
        return false;
    L7:
        return !TextUtils.equals(r2.getTenantId(), PickerBaseModuleDependency.getDependency().getLoginUserTenantId());
    }

    private final boolean isUnShowUserStatus(SearchChatterInfo r4) {
        ChatterDescription r0 = r4.getChatterDescription();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (TextUtils.isEmpty(r0.description) == false) goto L11;
        if (r0.type != ChatterDescription.Type.DEFAULT) goto L11;
        return true;
    L11:
        if (Chatter.ChatterType.BOT == r4.getChatterType()) goto L13;
    L15:
        return false;
    L13:
        if (DesktopUtil.a(this.mContext) == true) goto L15;
        return true;
    }

    private final void openContactProfileChatter(SearchChatterInfo r3) {
        if (r3.getChatterType() != Chatter.ChatterType.USER) goto L6;
        PickerBaseModuleDependency.getDependency().startContactsProfileActivityByChatterId(this.mContext, r3.getId());
        return;
    L6:
        if (r3.getChatterType() == Chatter.ChatterType.AI) goto L8;
        PickerBaseModuleDependency.getDependency().startBotProfileActivityByBotId(this.mContext, r3.getId());
        return;
    L8:
        if (PickerBaseModuleDependency.getDependency().tryMyAIOnBoarding() == true) goto L13;
        PickerBaseModuleDependency.getDependency().startContactsProfileActivityByChatterId(this.mContext, r3.getId());
        return;
    }

    public boolean checkDisable(SearchChatterInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (this.mDisableExternalChatter == true) goto L5;
    L7:
        return false;
    L5:
        if (isExternal(r2) == false) goto L7;
        return true;
    }

    public final void disableExternalChatter(boolean r1) {
        this.mDisableExternalChatter = r1;
    }

    public final void setOnProfileClickListener(IOnProfileClickListener r1) {
        this.onProfileClickListener = r1;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ boolean checkDisable(SearchBaseInfo r1) {
        return checkDisable((SearchChatterInfo) r1);
    }

    private final void bindCustomStatus(ChatterChatViewHolder r4, List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r5) {
        Drawable r6 = PickerBaseModuleDependency.getDependency().getOpenedUserStatusDrawable(this.mContext, r5, false);
        r4.getAvatarItemView().getItem().personalStatus(new e(r6));
    }

    private final void bindUserStatus(ChatterChatViewHolder r10, SearchChatterInfo r11) {
        if (isUnShowUserStatus(r11) == true) goto L34;
        ChatterDescription r0 = r11.getChatterDescription();
        j r1 = new j();
        r1.c = r0.description;
        r1.a = Integer.valueOf(UIHelper.getColor(2131106620));
        Context r2 = this.mContext;
        b r3 = b.b();
        r0.type.getNumber();
        r3.getClass();
        r1.b = UIUtils.getDrawable(r2, 2131238071);
        boolean r4 = false;
        if (r11.isP2pCryptoChat() == false) goto L15;
        String r5 = r11.getCryptoChatterId();
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        String r7 = r11.getCryptoChatterId();
    L17:
        if (r11.getChatterType() != Chatter.ChatterType.USER) goto L32;
        if (r7 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == true) goto L32;
        r1.d = r7;
        r1.e = PROFILE_SIGN_SCENE;
        Long r13 = Long.valueOf(r0.descriptionId);
        if (r13.longValue() <= 0) goto L28;
        r4 = true;
    L28:
        if (r4 == true) goto L31;
        r13 = null;
    L31:
        r1.f = r13;
        goto L32
    L20:
        if (StringsKt.isBlank(r7) == true) goto L23;
        r12 = false;
    L32:
        r10.getAvatarItemView().getItem().userStatus(r1);
        return;
    L9:
        if (StringsKt.isBlank(r5) == true) goto L12;
        r6 = false;
    L15:
        r7 = r11.getId();
        goto L17
    }

    private final void handleChatterProfileCardClick(SearchChatterInfo r2, int r3) {
        SearchClickReporter.INSTANCE.reportClickProfile(r2);
        if (r2.isP2pCryptoChat() == false) goto L14;
        String r0 = r2.getP2pChatId();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        openContactProfileForSecretP2pChat(r2.getP2pChatId(), r3);
        return;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
    L14:
        if (r2.isP2pShieldChat() == false) goto L16;
        PickerBaseModuleDependency.getDependency().startContactsProfileActivityByChatterId(this.mContext, r2.getCryptoChatterId());
        return;
    L16:
        openContactProfileChatter(r2);
    }

    private final void openContactProfileForSecretP2pChat(String r2, int r3) {
        PickerBaseModuleDependency.getDependency().getChatById(r2, new C03331(this));
    }

    public void bindAvatar(ChatterChatViewHolder r10, SearchChatterInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "data");
        if (TextUtils.isEmpty(r11.getAvatarKey()) == true) goto L6;
        AvatarItemView r12 = r10.getAvatarItemView().getItem();
        a.a r0 = new a.a();
        r0.k = r11.getAvatarId();
        r0.b(r11.getAvatarKey());
        r0.f(r11.getAvatarId());
        r12.avatar(new a(r0));
        return;
    L6:
        if (TextUtils.isEmpty(r11.getAvatarUrl()) == true) goto L10;
        PickerBaseModuleDependency.IPickerCommonModuleDependency r1 = PickerBaseModuleDependency.getDependency();
        Context r2 = this.mContext;
        String r3 = r11.getAvatarUrl();
        ImageView r4 = r10.getAvatarItemView().getItem().getAvatarView();
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(1);
        r6.setColor(AvatarModel.k);
        Unit r13 = Unit.INSTANCE;
        AvatarModel.Size r14 = AvatarModel.Size.MIDDLE;
        r1.loadImage(r2, r3, r4, null, r6, r14.getPxValue(this.mContext), r14.getPxValue(this.mContext));
        return;
    }

    public void bindSubTitle(SearchChatterInfo r6, ChatterChatViewHolder r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "holder");
        if (isExternal(r6) == true) goto L7;
        if (isCrossTenantP2PCryptoChat(r6) == true) goto L7;
    L16:
        f r0 = new f(r6.getSubTitle());
        r0.c = r6.getSubTitleTagList();
    L17:
        r0.f = Float.valueOf(d.a(this.mContext, 12.0f));
        r0.e = isSingleChoice(r6);
        r0.g = TextUtils.TruncateAt.START;
        r7.getAvatarItemView().getItem().subTitle(r0);
        return;
    L7:
        if (getFgUtils().isOrganizationNameTagFGEnable() == false) goto L16;
        String r1 = null;
        r0 = new f(null);
        Context r2 = this.mContext;
        if (TextUtils.isEmpty(r6.getSubTitle()) == true) goto L12;
        r1 = r6.getSubTitle();
    L12:
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r1 != null) goto L15;
        r1 = UIUtils.getString(r2, 2131891717);
    L15:
        UDTagsDrawable.a r3 = new UDTagsDrawable.a(r2);
        UDTagsDrawable.d.a r4 = new UDTagsDrawable.d.a(r2);
        r4.c = r1;
        r4.c(UDTagsDrawable.TagColorSet.BLUE);
        r3.a(r4.b());
        r3.f = this.viewWidth - UIUtils.dp2px(r3.getContext(), 132.0f);
        r0.d = r3.b();
        goto L17
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchChatterInfo) r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindSubTitle(SearchBaseInfo r1, ChatterChatViewHolder r2) {
        bindSubTitle((SearchChatterInfo) r1, r2);
    }

    public ChatterBinder(Context r8, g r9, i r10) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.$$delegate_0 = new ChatPreviewBinder();
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
        this.updateHistoryListener = r10;
    }

    public static final /* synthetic */ void access$handleChatterProfileCardClick(ChatterBinder r0, SearchChatterInfo r1, int r2) {
        r0.handleChatterProfileCardClick(r1, r2);
    }

    private final void bindPreviewOrIcon(final int r6, ChatterChatViewHolder r7, final SearchChatterInfo r8) {
        r7.getAvatarItemView().getChatPreviewIcon().setVisibility(8);
        if (isEnableChatPreview() == true) goto L5;
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageDrawable(UDIconUtils.getIconDrawable(r0.getContext(), 2131254837, UIUtils.getColor(this.mContext, 2131102420)));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r0.setPadding(0, (int) d.b(this.mContext, 13), 0, (int) d.b(this.mContext, 13));
        r0.setOnClickListener(new AnonymousClass2(this, r8, r6));
        avatarAttachRightView(r7, r0);
        r7.getAvatarItemView().getItem().adjustAlign();
        return;
    L5:
        if (r8.isP2pCryptoChat() == true) goto L9;
        r7.getAvatarItemView().getChatPreviewIcon().setVisibility(0);
        r7.getAvatarItemView().getChatPreviewIcon().setOnClickListener(new AnonymousClass1(this, r8));
        return;
    }

    public void bindOthers(int r2, ChatterChatViewHolder r3, SearchChatterInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        bindPreviewOrIcon(r2, r3, r4);
        bindUserStatus(r3, r4);
        bindCustomStatus(r3, r4.getStatusList());
    }

    public void bindTag(int r5, ChatterChatViewHolder r6, SearchChatterInfo r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "data");
        LarkNameTag.d r8 = new LarkNameTag.d(this.mContext);
        if (r7.getTagData() == null) goto L10;
        TagData r0 = r7.getTagData();
        if (r0 == null) goto L7;
        TagData.Companion.getClass();
        List r1 = TagData.a.b(r0);
    L8:
        r8.g(r1);
        goto L10
    L7:
        r1 = CollectionsKt.emptyList();
    L10:
        if (getFgUtils().isSpotlightLocalTagEnable() == false) goto L17;
        if (r7.isSpotlight() == false) goto L17;
        if (r7.getSourceType() != ResultSourceType.LOCAL) goto L17;
        int r2 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r3 = new com.larksuite.component.ui.tag.f.a();
        r3.d = "Local";
        r3.e = 2131109125;
        r3.g = 2131109083;
        r8.d(new com.larksuite.component.ui.tag.f(r3), true);
    L17:
        if (Chatter.ChatterType.BOT == r7.getChatterType()) goto L26;
        if (r7.isRegistered() == true) goto L22;
        int r4 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r9 = new com.larksuite.component.ui.tag.f.a();
        r9.c = 2131892259;
        r9.e = 2131109116;
        r9.g = 2131109112;
        r8.d(new com.larksuite.component.ui.tag.f(r9), true);
    L22:
        if (WorkStatus.isInvalid(r7.getWorkStatus()) == true) goto L24;
        int r10 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r11 = new com.larksuite.component.ui.tag.f.a();
        r11.d = r7.getWorkStatus().getDisplayTextNoDuration(this.mContext);
        r11.e = 2131109132;
        r11.g = 2131109097;
        r8.d(new com.larksuite.component.ui.tag.f(r11), true);
    L24:
        Unit r12 = Unit.INSTANCE;
    L30:
        if (r7.isBlockedFromLocalSearch() == false) goto L32;
        int r13 = com.larksuite.component.ui.tag.f.g;
        com.larksuite.component.ui.tag.f.a r14 = new com.larksuite.component.ui.tag.f.a();
        r14.c = 2131892580;
        r14.e = 2131109113;
        r14.g = 2131102094;
        r8.d(new com.larksuite.component.ui.tag.f(r14), true);
    L32:
        r8.q = r7.isP2pCryptoChat();
        ((LarkNameTag.c) r8).f = r7.isCrossWithKa();
        r6.getAvatarItemView().getItem().setTag(r8);
        return;
    L26:
        if (r7.isAgent() == false) goto L28;
        r8.s = true;
        goto L30
    L28:
        r8.r = true;
        goto L30
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindOthers(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindOthers(r1, r2, (SearchChatterInfo) r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchChatterInfo) r3);
    }

    public final void bind(int r2, SearchChatterInfo r3, ChatterChatViewHolder r4, v3c.d r5) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "contentViewSizeProvider");
        this.viewWidth = r5.getContentViewSize().getWidth();
        bind(r2, r3, r4);
    }

    public /* synthetic */ ChatterBinder(Context r1, g r2, i r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
