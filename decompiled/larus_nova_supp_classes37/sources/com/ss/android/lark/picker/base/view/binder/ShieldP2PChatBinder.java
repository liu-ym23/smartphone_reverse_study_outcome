package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.reporter.SearchClickReporter;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import h18.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;
import v3c.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J \u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ShieldP2PChatBinder;", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "Lcom/ss/android/lark/search/dto/info/SearchShieldP2PChatInfo;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "updateHistoryListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;)V", "mDisableExternalChat", "", "onProfileClickListener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "getOnProfileClickListener", "()Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "setOnProfileClickListener", "(Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;)V", "bindProfileIcon", "", "holder", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "data", "handleChatterProfileCardClick", "bindTag", "position", "", "bindOthers", "checkDisable", "onDisableClickHandler", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ShieldP2PChatBinder extends CommonBinder<SearchShieldP2PChatInfo> {
    private final Context mContext;
    private boolean mDisableExternalChat;
    private final g mOnItemClickHandler;
    private IOnProfileClickListener onProfileClickListener;
    private final i updateHistoryListener;

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public void onDisableClickHandler() {
        LKUIToast.show(this.mContext, 2131890335);
    }

    public final IOnProfileClickListener getOnProfileClickListener() {
        return this.onProfileClickListener;
    }

    public static final /* synthetic */ i access$getUpdateHistoryListener$p(ShieldP2PChatBinder r0) {
        return r0.updateHistoryListener;
    }

    private final void handleChatterProfileCardClick(SearchShieldP2PChatInfo r3) {
        SearchClickReporter.INSTANCE.reportClickProfile(r3);
        PickerBaseModuleDependency.getDependency().startContactsProfileActivityByChatterId(this.mContext, r3.getChatterId());
    }

    public boolean checkDisable(SearchShieldP2PChatInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (this.mDisableExternalChat == true) goto L5;
    L7:
        return false;
    L5:
        if (isExternal(r2) == false) goto L7;
        return true;
    }

    public final void setOnProfileClickListener(IOnProfileClickListener r1) {
        this.onProfileClickListener = r1;
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ boolean checkDisable(SearchBaseInfo r1) {
        return checkDisable((SearchShieldP2PChatInfo) r1);
    }

    public static final /* synthetic */ void access$handleChatterProfileCardClick(ShieldP2PChatBinder r0, SearchShieldP2PChatInfo r1) {
        r0.handleChatterProfileCardClick(r1);
    }

    private final void bindProfileIcon(ChatterChatViewHolder r5, final SearchShieldP2PChatInfo r6) {
        ImageView r0 = new ImageView(this.mContext);
        r0.setImageDrawable(UDIconUtils.getIconDrawable(r0.getContext(), 2131254837, UIUtils.getColor(this.mContext, 2131102420)));
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r0.setPadding(0, (int) d.b(this.mContext, 13), 0, (int) d.b(this.mContext, 13));
        r0.setOnClickListener(new AnonymousClass1(this, r6));
        avatarAttachRightView(r5, r0);
    }

    public ShieldP2PChatBinder(Context r8, g r9, i r10) {
        Intrinsics.checkNotNullParameter(r8, "mContext");
        Intrinsics.checkNotNullParameter(r9, "mOnItemClickHandler");
        super(r8, r9, null, 4, null);
        this.mContext = r8;
        this.mOnItemClickHandler = r9;
        this.updateHistoryListener = r10;
    }

    public void bindOthers(int r1, ChatterChatViewHolder r2, SearchShieldP2PChatInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        bindProfileIcon(r2, r3);
    }

    public void bindTag(int r3, ChatterChatViewHolder r4, SearchShieldP2PChatInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        LarkNameTag.d r6 = new LarkNameTag.d(this.mContext);
        if (r5.getTagData() == null) goto L9;
        TagData r0 = r5.getTagData();
        if (r0 == null) goto L7;
        TagData.Companion.getClass();
        List r1 = TagData.a.b(r0);
    L8:
        r6.g(r1);
        goto L9
    L7:
        r1 = CollectionsKt.emptyList();
    L9:
        ((LarkNameTag.c) r6).f = r5.isCrossWithKa();
        r4.getAvatarItemView().getItem().setTag(r6);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindOthers(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindOthers(r1, r2, (SearchShieldP2PChatInfo) r3);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.CommonBinder
    public /* bridge */ /* synthetic */ void bindTag(int r1, ChatterChatViewHolder r2, SearchBaseInfo r3) {
        bindTag(r1, r2, (SearchShieldP2PChatInfo) r3);
    }

    public /* synthetic */ ShieldP2PChatBinder(Context r1, g r2, i r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
