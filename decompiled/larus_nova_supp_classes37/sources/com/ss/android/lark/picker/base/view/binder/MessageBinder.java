package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b4c.b;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.component.ui.avatar.AvatarType;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.utils.UiUtil;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.MessageAttachment;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchLinkInfo;
import com.ss.android.lark.search.dto.info.SearchMessageFileInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.a0;
import e0c.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import v3c.g;
import w3c.f;
import wz7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\b\u0000\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J&\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/MessageBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchMessageInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "messageViewInChat", "com/ss/android/lark/picker/base/view/binder/MessageBinder$messageViewInChat$1", "Lcom/ss/android/lark/picker/base/view/binder/MessageBinder$messageViewInChat$1;", "aslFileStorage", "Lcom/ss/android/lark/search/dto/userscope/IASLFileStorage;", "getAslFileStorage", "()Lcom/ss/android/lark/search/dto/userscope/IASLFileStorage;", "setAslFileStorage", "(Lcom/ss/android/lark/search/dto/userscope/IASLFileStorage;)V", "bindAvatar", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "bindTitle", "isSelectable", "", "bindSubTitle", "bindOthers", "position", "", "bindSummary", "bindInnerLinks", "bindInnerLinkView", "innerLinkLayout", "Landroid/view/View;", "attachment", "Lcom/ss/android/lark/search/dto/info/MessageAttachment;", "innerLinkClick", "Lkotlin/Function0;", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MessageBinder extends CommonBinder<SearchMessageInfo> {
    public static final Companion Companion = null;
    public static final String TAG = "LarkSearch.Common.MessageBinder";
    private b aslFileStorage;
    private final Context mContext;
    private final g mOnItemClickHandler;
    private final MessageBinder$messageViewInChat$1 messageViewInChat;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/MessageBinder$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    public final b getAslFileStorage() {
        return this.aslFileStorage;
    }

    public static final /* synthetic */ Context access$getMContext$p(MessageBinder r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ g access$getMOnItemClickHandler$p(MessageBinder r0) {
        return r0.mOnItemClickHandler;
    }

    public static final /* synthetic */ MessageBinder$messageViewInChat$1 access$getMessageViewInChat$p(MessageBinder r0) {
        return r0.messageViewInChat;
    }

    public final void setAslFileStorage(b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.aslFileStorage = r2;
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.ss.android.lark.picker.base.view.binder.MessageBinder$messageViewInChat$1] */
    public MessageBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
        this.messageViewInChat = new MessageBinder$messageViewInChat$1();
        this.aslFileStorage = (b) k.a(LarkContext.getApplication(), b.class);
    }

    public void bindAvatar(ChatterChatViewHolder r8, SearchMessageInfo r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "data");
        r8.getAvatarItemView().getItem().avatarSizeAdjust(48.0f);
        r8.getAvatarItemView().getItem().avatarShape(true);
        if (r9.isChatInsideShow() == true) goto L5;
        AvatarItemView r0 = r8.getAvatarItemView().getItem();
        a.a r1 = new a.a();
        r1.b(r9.getAvatarKey());
        r1.k = r9.getAvatarId(0);
        r1.f(r9.getAvatarId(0));
        r0.avatar(new a(r1));
        r8.getAvatarItemView().getItem().miniIcon(null);
        return;
    L5:
        if (r9.isBinderByFile() == false) goto L19;
        r8.getAvatarItemView().getItem().avatarSizeAdjust(40.0f);
        r8.getAvatarItemView().getItem().avatarShape(false);
        FileContent r2 = r9.getFileContent();
        FolderContent r10 = r9.getFolderContent();
        if (r2 == null) goto L12;
        AvatarItemView r11 = r8.getAvatarItemView().getItem();
        a.a r4 = new a.a();
        r4.d(a0.b(r2.getMime(), r2.getName(), 1));
        r11.avatar(new a(r4));
        if (r2.isLanTransfer() == false) goto L11;
        r8.getAvatarItemView().getItem().miniIcon(new d(AvatarType.UNKNOWN, this.mContext.getDrawable(2131235934)));
        return;
    L11:
        r8.getAvatarItemView().getItem().miniIcon(null);
        return;
    L12:
        if (r10 == null) goto L17;
        AvatarItemView r3 = r8.getAvatarItemView().getItem();
        a.a r5 = new a.a();
        r5.d(a0.c("", r10.getName(), true));
        r3.avatar(new a(r5));
        if (r10.isLanTransfer() == false) goto L16;
        r8.getAvatarItemView().getItem().miniIcon(new d(AvatarType.UNKNOWN, this.mContext.getDrawable(2131235934)));
        return;
    L16:
        r8.getAvatarItemView().getItem().miniIcon(null);
        return;
    L17:
        Log.e(TAG, "all is null!");
        return;
    L19:
        AvatarItemView r6 = r8.getAvatarItemView().getItem();
        a.a r7 = new a.a();
        r7.b(r9.getFromAvatarKey());
        r7.k = r9.getAvatarId(1);
        r7.f(r9.getAvatarId(1));
        r6.avatar(new a(r7));
        r8.getAvatarItemView().getItem().miniIcon(null);
    }

    public void bindSubTitle(SearchMessageInfo r7, ChatterChatViewHolder r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "holder");
        if (r7.isBinderByFile() == true) goto L5;
        super.bindSubTitle(r7, r8);
        return;
    L5:
        if (r7.getAuthAction().isAccessAuth() == true) goto L15;
        if (r7.getAuthAction().isShareAuthDisable() == false) goto L10;
        String r0 = UIHelper.getString(2131891244);
    L13:
        f r1 = new f(r0);
    L20:
        r1.c = r7.getSubTitleTagList();
        r1.e = isSingleChoice(r7);
        r8.getAvatarItemView().getItem().subTitle(r1);
        return;
    L10:
        if (r7.getAuthAction().isPreViewAuthDisable() == false) goto L12;
        r0 = UIHelper.getString(2131891415);
        goto L13
    L12:
        r0 = UIHelper.getString(2131891415);
        goto L13
    L15:
        if ((r7 instanceof SearchMessageFileInfo) == false) goto L19;
        SearchMessageFileInfo r2 = (SearchMessageFileInfo) r7;
        if (r2.isDestroyed() == false) goto L19;
        SpannableStringBuilder r3 = new SpannableStringBuilder(r2.getSubTitle());
        SpannableString r4 = new SpannableString(UIHelper.getString(2131891116));
        r4.setSpan(new ForegroundColorSpan(UIHelper.getColor(2131102078)), 0, r4.length(), 34);
        r3.append("  ").append(r4);
        r1 = new f(r3);
    L19:
        r1 = new f(r7.getSubTitle() + ' ' + SearchCommonUtils.getSearchResultTime(this.mContext, r7.getCreateTime(), true));
        goto L20
    }

    public void bindSummary(SearchMessageInfo r3, ChatterChatViewHolder r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.bindSummary(r3, r4);
        r4.getAvatarItemView().getItem().avatarTopMargin(12);
        if (r3.isChatInsideShow() == true) goto L5;
        return;
    L5:
        if (r3.isBinderByFile() == false) goto L9;
        r4.getAvatarItemView().getItem().avatarTopMargin(16);
        return;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindAvatar(ChatterChatViewHolder r1, SearchBaseInfo r2) {
        bindAvatar(r1, (SearchMessageInfo) r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindSubTitle(SearchBaseInfo r1, ChatterChatViewHolder r2) {
        bindSubTitle((SearchMessageInfo) r1, r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindSummary(SearchBaseInfo r1, ChatterChatViewHolder r2) {
        bindSummary((SearchMessageInfo) r1, r2);
    }

    private final void bindInnerLinkView(View r19, final MessageAttachment r20, final Function0<Unit> r21) {
        String r2 = r20.getTitle();
        String r3 = r20.getSummary();
        ArrayList r4 = r20.getTitleTagList();
        ArrayList r5 = r20.getSummaryTagList();
        SearchLinkInfo r6 = r20.getSearchLinkInfo();
        if (r6 == null) goto L6;
        String r7 = r6.getImageUrl();
        if (r7 == null) goto L6;
    L7:
        String r12 = r7;
        SearchLinkInfo r8 = r20.getSearchLinkInfo();
        if (r8 == null) goto L10;
        UDIcon r10 = r8.getUDIcon();
    L11:
        SearchLinkInfo r9 = r20.getSearchLinkInfo();
        if (r9 == null) goto L14;
        ImageSet r11 = r9.getImageSet();
    L15:
        ImageView r13 = (ImageView) r19.findViewById(2131377990);
        TextView r14 = (TextView) r19.findViewById(2131378026);
        TextView r15 = (TextView) r19.findViewById(2131378028);
        UiUtil.Companion.loadImage(this.mContext, r13, r10, r11, r12, UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f), this.aslFileStorage);
        if (CollectionUtils.isEmpty(r4) == false) goto L18;
        r14.setText(r2);
    L20:
        if (CollectionUtils.isEmpty(r5) == false) goto L22;
        r15.setText(r3);
    L23:
        r19.setVisibility(0);
        r19.setOnClickListener(new MessageBinder$bindInnerLinkView$1$1(r20, r21));
        return;
    L22:
        PickerBaseModuleDependency.getDependency().addSearchHighLightedTag(new SpannableStringBuilder(r3), r15, r5, this.mContext.getResources().getColor(2131105548));
        goto L23
    L18:
        PickerBaseModuleDependency.getDependency().addSearchHighLightedTag(new SpannableStringBuilder(r2), r14, r4, this.mContext.getResources().getColor(2131105548));
        goto L20
    L14:
        r11 = null;
        goto L15
    L10:
        r10 = null;
    L6:
        r7 = "";
        goto L7
    }

    private final void bindInnerLinks(final int r10, ChatterChatViewHolder r11, final SearchMessageInfo r12) {
        List r0 = r12.getAttachments();
        int r1 = 0;
        if (r0 == null) goto L13;
        ArrayList r3 = new ArrayList();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        if (((MessageAttachment) r4).getAttachmentType() != Message.MessageAttachmentType.ATTACHMENT_LINK) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L6;
        r3.add(r4);
        goto L6
    L10:
        r5 = false;
    L14:
        ArrayList r6 = r3;
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
        return;
    L23:
        LinearLayout r8 = new LinearLayout(this.mContext);
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r8.setOrientation(1);
        View r9 = LayoutInflater.from(this.mContext).inflate(2131561682, r8, true);
        View r13 = r9.findViewById(2131375314);
        View r14 = r9.findViewById(2131375315);
        TextView r15 = (TextView) r9.findViewById(2131375317);
        r11.getAvatarItemView().getItem().addBottomView(r8);
        int r16 = r12.getAttachments().size();
        Iterator r17 = CollectionsKt.filterNotNull(r3).iterator();
        int r18 = 0;
    L25:
        if (r17.hasNext() == false) goto L37;
        Object r19 = r17.next();
        int r20 = r18 + 1;
        if (r18 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        MessageAttachment r21 = (MessageAttachment) r19;
        if (r18 == 0) goto L34;
        if (r18 != 1) goto L35;
        bindInnerLinkView(r14, r21, new MessageBinder$bindInnerLinks$1$2(this, r12, r10));
    L35:
        r18 = r20;
        goto L25
    L34:
        bindInnerLinkView(r13, r21, new MessageBinder$bindInnerLinks$1$1(this, r12, r10));
        goto L35
    L37:
        if ((r12.getAttachmentCount() - r16) > 0) goto L41;
        r1 = 8;
    L41:
        if ((r12.getAttachmentCount() - r16) <= 0) goto L43;
        String r110 = UIHelper.getQuantityString(2131755071, r12.getAttachmentCount() - r16);
    L44:
        r15.setText(r110);
        r15.setVisibility(r1);
        return;
    L43:
        r110 = "";
        goto L44
    L17:
        if (r6.isEmpty() == true) goto L20;
        r7 = false;
        goto L21
    L13:
        r3 = null;
        goto L14
    }

    public void bindOthers(final int r5, ChatterChatViewHolder r6, final SearchMessageInfo r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "data");
        if (r7.isBinderByFile() == false) goto L5;
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageDrawable(UDIconUtils.getIconDrawable(r0.getContext(), 2131256151, r0.getResources().getColor(2131102419)));
        r0.setLayoutParams(new ViewGroup.LayoutParams(y9c.d.a(20), y9c.d.a(20)));
        r0.setOnClickListener(new AnonymousClass1(this, r7, r5));
        avatarAttachRightView(r6, r0);
    L6:
        bindInnerLinks(r5, r6, r7);
        return;
    L5:
        String r1 = SearchCommonUtils.getSearchResultTime(this.mContext, r7.getCreateTime(), true);
        r6.getAvatarItemView().getItem().assignTime(new w3c.a(r1));
        goto L6
    }

    public void bindTitle(SearchMessageInfo r4, ChatterChatViewHolder r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "holder");
        if (r4.isChatInsideShow() == true) goto L5;
        super.bindTitle(r4, r5, r6);
        return;
    L5:
        if (r4.isBinderByFile() == false) goto L18;
        ArrayList r0 = r4.getTitleTagList();
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        w3c.g r7 = new w3c.g(r4.getTitle(), false, 14);
    L16:
        r7.e = r4.getTitleTagList();
        r7.f = r4.getAuthAction().isAccessAuth();
        r7.g = isSingleChoice(r4);
        r5.getAvatarItemView().getItem().title(r7);
        return;
    L15:
        r7 = new w3c.g(r4.getTitle(), r6, 8);
        goto L16
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L18:
        if (TextUtils.isEmpty(r4.getFromName()) == false) goto L20;
        String r2 = r4.getTitle();
    L21:
        w3c.g r8 = new w3c.g(r2, false, 14);
        r8.g = isSingleChoice(r4);
        r5.getAvatarItemView().getItem().title(r8);
        return;
    L20:
        r2 = r4.getFromName();
        goto L21
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindOthers(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindOthers(r1, r2, (SearchMessageInfo) r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public /* bridge */ /* synthetic */ void bindTitle(SearchBaseInfo r1, ChatterChatViewHolder r2, boolean r3) {
        bindTitle((SearchMessageInfo) r1, r2, r3);
    }
}
