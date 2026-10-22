package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kac.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uz7.d;
import v3c.g;
import w3c.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0017\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J \u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/CCMBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "getMContext", "()Landroid/content/Context;", "bindAvatar", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "bindShortcutAvatar", "needBindSummary", "", "bindSummary", "getSpaceInfo", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "ccmViewInChat", "com/ss/android/lark/picker/base/view/binder/CCMBinder$ccmViewInChat$1", "Lcom/ss/android/lark/picker/base/view/binder/CCMBinder$ccmViewInChat$1;", "bindOthers", "position", "", "bindSubTitle", "bindTag", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CCMBinder extends CommonBinder<SearchBaseInfo> {
    private final CCMBinder$ccmViewInChat$1 ccmViewInChat;
    private final Context mContext;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Doc.Type.values().length];
            r0[Doc.Type.FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public static final /* synthetic */ CCMBinder$ccmViewInChat$1 access$getCcmViewInChat$p(CCMBinder r0) {
        return r0.ccmViewInChat;
    }

    private final SearchSpaceInfo getSpaceInfo(SearchBaseInfo r2) {
        if ((r2 instanceof SearchWikiInfo) == false) goto L6;
        return ((SearchWikiInfo) r2).getSpaceInfo();
    L6:
        if ((r2 instanceof SearchSpaceInfo) == true) goto L11;
        return null;
    L11:
        return (SearchSpaceInfo) r2;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public boolean needBindSummary(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return !r2.isChatInsideShow();
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.ss.android.lark.picker.base.view.binder.CCMBinder$ccmViewInChat$1] */
    public CCMBinder(Context r8, g r9) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.ccmViewInChat = new CCMBinder$ccmViewInChat$1(this);
    }

    public static final /* synthetic */ SearchSpaceInfo access$getSpaceInfo(CCMBinder r0, SearchBaseInfo r1) {
        return r0.getSpaceInfo(r1);
    }

    private final void bindShortcutAvatar(ChatterChatViewHolder r5, SearchBaseInfo r6) {
        if ((r6 instanceof SearchSpaceInfo) == false) goto L13;
        SearchSpaceInfo r7 = (SearchSpaceInfo) r6;
        Doc.Type r0 = r7.getOriType();
        if (r0 != null) goto L7;
        int r1 = -1;
    L8:
        if (r1 != 1) goto L10;
        int r8 = PickerBaseModuleDependency.getDependency().getFolderIcon(r7.getIsShareFolder().booleanValue());
    L11:
        Integer r9 = Integer.valueOf(r8);
    L22:
        Drawable[] r2 = new Drawable[2];
        Context r3 = this.mContext;
        if (r9 == null) goto L25;
        int r10 = r9.intValue();
    L26:
        r2[0] = UDIconUtils.getIconDrawable(r3, a.b(r10));
        r2[1] = UDIconUtils.getIconDrawable(this.mContext, 2131256255);
        LayerDrawable r11 = new LayerDrawable(r2);
        AvatarItemView r12 = r5.getAvatarItemView().getItem();
        d.a r4 = new d.a();
        r4.e(r11);
        r12.avatar(new d(r4));
        r12.avatarShape(false);
        return;
    L25:
        r10 = 2131237841;
        goto L26
    L10:
        r8 = PickerBaseModuleDependency.getDependency().getDocIcon(r7.getOriType().getValue(), r7.getTitle());
        goto L11
    L7:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L8
    L13:
        if ((r6 instanceof SearchWikiInfo) == false) goto L21;
        SearchWikiInfo r13 = (SearchWikiInfo) r6;
        SearchSpaceInfo r14 = r13.getSpaceInfo();
        if (r14 == null) goto L19;
        Doc.Type r15 = r14.getOriType();
        if (r15 == null) goto L19;
    L20:
        int r16 = r15.getValue();
        r9 = Integer.valueOf(PickerBaseModuleDependency.getDependency().getWikiIcon(r16, r13.getTitle()));
    L19:
        r15 = Doc.Type.UNKNOWN;
        goto L20
    L21:
        r9 = null;
        goto L22
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindAvatar(ChatterChatViewHolder r6, SearchBaseInfo r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "data");
        boolean r0 = r7 instanceof SearchSpaceInfo;
        String r1 = "";
        if (r0 == false) goto L8;
        String r2 = ((SearchSpaceInfo) r7).getIconInfo();
        if (r2 == null) goto L11;
    L12:
        Integer r4 = null;
        if (TextUtils.isEmpty(r2) == false) goto L54;
        if (r0 == false) goto L20;
        if (((SearchSpaceInfo) r7).getDocType() != Doc.Type.SHORTCUT) goto L29;
        bindShortcutAvatar(r6, r7);
        return;
    L29:
        if (r0 == false) goto L40;
        SearchSpaceInfo r8 = (SearchSpaceInfo) r7;
        Doc.Type r3 = r8.getDocType();
        if (r3 != null) goto L33;
        int r5 = -1;
    L35:
        if (r5 != 1) goto L37;
        int r9 = PickerBaseModuleDependency.getDependency().getFolderIcon(r8.getIsShareFolder().booleanValue());
    L38:
        r4 = Integer.valueOf(r9);
    L48:
        AvatarItemView r10 = r6.getAvatarItemView().getItem();
        d.a r11 = new d.a();
        if (r4 == null) goto L51;
        int r12 = r4.intValue();
    L52:
        r11.d(a.b(r12));
        r10.avatar(new d(r11));
        return;
    L51:
        r12 = 2131237841;
        goto L52
    L37:
        r9 = PickerBaseModuleDependency.getDependency().getDocIcon(r8.getDocType().getValue(), r8.getTitle());
        goto L38
    L33:
        r5 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        goto L35
    L40:
        if ((r7 instanceof SearchWikiInfo) == false) goto L48;
        SearchWikiInfo r13 = (SearchWikiInfo) r7;
        SearchSpaceInfo r14 = r13.getSpaceInfo();
        if (r14 == null) goto L46;
        Doc.Type r15 = r14.getDocType();
        if (r15 == null) goto L46;
    L47:
        r4 = Integer.valueOf(PickerBaseModuleDependency.getDependency().getWikiIcon(r15.getValue(), r13.getTitle()));
    L46:
        r15 = Doc.Type.UNKNOWN;
        goto L47
    L20:
        if ((r7 instanceof SearchWikiInfo) == false) goto L29;
        SearchSpaceInfo r16 = ((SearchWikiInfo) r7).getSpaceInfo();
        if (r16 == null) goto L24;
        Doc.Type r17 = r16.getDocType();
    L26:
        if (r17 != Doc.Type.SHORTCUT) goto L29;
        bindShortcutAvatar(r6, r7);
        return;
    L24:
        r17 = null;
        goto L26
    L54:
        if ((r7 instanceof SearchWikiInfo) == false) goto L56;
        SearchSpaceInfo r18 = ((SearchWikiInfo) r7).getSpaceInfo();
    L59:
        tz7.a.a r19 = new tz7.a.a();
        if (r18 == null) goto L71;
        String r20 = r18.getDocUrl();
        if (r20 == null) goto L65;
        r1 = r20;
    L65:
        Intrinsics.checkNotNullParameter(r1, "url");
        r19.k = r1;
        IconShape r21 = IconShape.SQUARE;
        Intrinsics.checkNotNullParameter(r21, "shape");
        r19.m = r21;
        if (r18.getDocType() != Doc.Type.SHORTCUT) goto L68;
        Boolean r22 = Boolean.TRUE;
    L69:
        obb.a r23 = new obb.a(r22, r18.getIsShareFolder(), null);
        Intrinsics.checkNotNullParameter(r23, "container");
        r19.n = r23;
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.META);
        r19.l = r2;
        goto L71
    L68:
        r22 = null;
    L71:
        if (r6.getAvatarItemView().getItem().getAvatarView() == null) goto L73;
        r6.getAvatarItemView().getItem().getAvatarView().setScaleType(ImageView.ScaleType.FIT_CENTER);
        int r24 = y9c.d.a(2);
        r6.getAvatarItemView().getItem().getAvatarView().setPadding(r24, r24, r24, r24);
        r6.getAvatarItemView().getItem().getAvatarView().setOval(false);
    L73:
        r6.getAvatarItemView().getItem().avatar(new tz7.a(r19));
        return;
    L56:
        if (r0 == false) goto L58;
        r18 = (SearchSpaceInfo) r7;
        goto L59
    L58:
        r18 = null;
    L11:
        r2 = "";
        goto L12
    L8:
        if ((r7 instanceof SearchWikiInfo) == false) goto L11;
        r2 = ((SearchWikiInfo) r7).getSpaceInfo().getIconInfo();
        if (r2 != null) goto L12;
        goto L11
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public void bindSubTitle(SearchBaseInfo r7, ChatterChatViewHolder r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "holder");
        if (r7.isChatInsideShow() == false) goto L8;
        SearchSpaceInfo r0 = getSpaceInfo(r7);
        if (r0 != null) goto L7;
        return;
    L7:
        f r1 = new f(r7.getSubTitle() + ' ' + SearchCommonUtils.getSearchResultTime(this.mContext, r0.getUpdateTime(), true));
        r1.c = r7.getSubTitleTagList();
        r1.e = isSingleChoice(r7);
        r8.getAvatarItemView().getItem().subTitle(r1);
        return;
    L8:
        super.bindSubTitle(r7, r8);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public void bindSummary(SearchBaseInfo r5, ChatterChatViewHolder r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "holder");
        if (getFgUtils().isExtraInfoEnable() == false) goto L5;
        bindExtraInfoSummary(r6, r5);
        return;
    L5:
        SearchSpaceInfo r0 = getSpaceInfo(r5);
        if (r0 != null) goto L8;
        return;
    L8:
        f r1 = new f(UIHelper.mustacheFormat(2131890234, "Date", SearchCommonUtils.getSearchResultTime(this.mContext, r0.getUpdateTime(), true)));
        r1.e = isSingleChoice(r5);
        r6.getAvatarItemView().getItem().summary(r1);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindOthers(final int r5, ChatterChatViewHolder r6, final SearchBaseInfo r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "data");
        if (r7.isChatInsideShow() == false) goto L6;
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageDrawable(UDIconUtils.getIconDrawable(r0.getContext(), 2131256151, r0.getResources().getColor(2131102419)));
        r0.setLayoutParams(new ViewGroup.LayoutParams(y9c.d.a(20), y9c.d.a(20)));
        r0.setOnClickListener(new AnonymousClass1(this, r7, r5));
        avatarAttachRightView(r6, r0);
        return;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void bindTag(int r2, ChatterChatViewHolder r3, SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        LarkNameTag.d r5 = new LarkNameTag.d(this.mContext);
        if (r4.getTagData() == null) goto L9;
        TagData r6 = r4.getTagData();
        if (r6 == null) goto L7;
        TagData.Companion.getClass();
        List r7 = TagData.a.b(r6);
    L8:
        r5.g(r7);
        goto L9
    L7:
        r7 = CollectionsKt.emptyList();
    L9:
        r3.getAvatarItemView().getItem().setTag(r5);
    }
}
