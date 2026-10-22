package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.search.v2.ExplanationTag;
import com.bytedance.lark.pb.search.v2.ResultSourceType;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.b;
import com.larksuite.component.ui.tag.f;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.utils.UiUtil;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.avatar.AvatarHelperKt;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.picker.base.view.avataritem.AvatarItemView;
import com.ss.android.lark.picker.base.view.binder.bridge.DefaultItemViewBridgeFactory;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridge;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import h18.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uz7.a;
import v3c.c;
import v3c.g;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \\*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\\B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ%\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010:J\u001f\u0010;\u001a\u00020<2\u0006\u00108\u001a\u00028\u00002\b\u0010=\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000¢\u0006\u0002\u0010BJ\u001b\u0010C\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000¢\u0006\u0002\u0010BJ\u001d\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010BJ\u001d\u0010E\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010BJ%\u0010F\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020$H\u0016J%\u0010I\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00109\u001a\u00020A2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010GJ\b\u0010J\u001a\u00020$H\u0016J\u0015\u0010K\u001a\u00020$2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010LJ\u001b\u0010M\u001a\u0002052\u0006\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00020A¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020$2\u0006\u00108\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u000e\u0010P\u001a\u0002052\u0006\u00102\u001a\u00020$J\u0006\u0010Q\u001a\u00020$J\u000e\u0010R\u001a\u0002052\u0006\u00103\u001a\u00020$J\u0006\u0010S\u001a\u00020$J\u0010\u0010T\u001a\u00020$2\u0006\u00108\u001a\u00020\u0002H\u0004J\u0016\u0010U\u001a\u0002052\u0006\u00109\u001a\u00020A2\u0006\u0010V\u001a\u00020WJ\u0015\u0010X\u001a\u00020$2\u0006\u00108\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010LJ\b\u0010Y\u001a\u000205H\u0016J\u000e\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001b\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001e\u0010\u0017R\u001b\u0010 \u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b!\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R$\u00100\u001a\u00020$2\u0006\u0010/\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u000e\u00102\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "D", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/ss/android/lark/picker/base/view/binder/BaseViewBinder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "mItemViewBridgeFactory", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;)V", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "getFgUtils", "()Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "setFgUtils", "(Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;)V", "adapterClickHandler", "officialDocTag", "Lcom/larksuite/component/ui/tag/IconTag;", "getOfficialDocTag", "()Lcom/larksuite/component/ui/tag/IconTag;", "officialDocTag$delegate", "Lkotlin/Lazy;", "privateModeTag", "getPrivateModeTag", "privateModeTag$delegate", "secretTag", "getSecretTag", "secretTag$delegate", "onCallTag", "getOnCallTag", "onCallTag$delegate", "isBindTagWithDynamicTag", "", "()Z", "setBindTagWithDynamicTag", "(Z)V", "forceRefreshNotifyItemChangedOnUnconsumedClick", "getForceRefreshNotifyItemChangedOnUnconsumedClick", "setForceRefreshNotifyItemChangedOnUnconsumedClick", "render", "Lcom/ss/android/lark/search/dto/ISearchDynamicRender;", "getRender", "()Lcom/ss/android/lark/search/dto/ISearchDynamicRender;", "value", "isFold", "setFold", "disableRightViewHolder", "disableExtraInfoSummary", "bind", "", "position", "", "data", "holder", "(ILcom/ss/android/lark/search/dto/info/SearchBaseInfo;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "buildCheckBoxModel", "Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "businessCheckResult", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;)Lcom/ss/android/lark/search/dto/bindermodel/CheckBoxModel;", "bindDynamicTag", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "(Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)V", "bindExtraInfoSummary", "bindAvatar", "bindBadge", "bindTag", "(ILcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)V", "needBindDynamicTag", "bindOthers", "needBindSubTitle", "needBindSummary", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Z", "bindSingle", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;)V", "isExternal", "setDisableRightViewHolder", "isDisableRightViewHolder", "setDisableExtraInfoSummary", "isDisableExtraInfoSummary", "isChatPreviewDisabled", "avatarAttachRightView", "view", "Landroid/view/View;", "checkDisable", "onDisableClickHandler", "setAdapterClickHandler", "onItemClickHandler", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class CommonBinder<D extends SearchBaseInfo> extends BaseViewBinder<D, RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final String TAG = "LarkSearch.Common.CommonBinder";
    private g adapterClickHandler;
    private boolean disableExtraInfoSummary;
    private boolean disableRightViewHolder;
    private SearchCommonFgUtils fgUtils;
    private boolean forceRefreshNotifyItemChangedOnUnconsumedClick;
    private boolean isBindTagWithDynamicTag;
    private final Context mContext;
    private final IItemViewBridgeFactory mItemViewBridgeFactory;
    private final g mOnItemClickHandler;
    private final Lazy officialDocTag$delegate;
    private final Lazy onCallTag$delegate;
    private final Lazy privateModeTag$delegate;
    private final c render;
    private final Lazy secretTag$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/CommonBinder$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ExplanationTag.TagStyle.values().length];
            r0[ExplanationTag.TagStyle.SHIELD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ExplanationTag.TagStyle.CRYPTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ExplanationTag.TagStyle.HELP_DESK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ExplanationTag.TagStyle.TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ExplanationTag.TagStyle.OFFICIAL_DOC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void bindOthers(int r1, ChatterChatViewHolder r2, D r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
    }

    public void bindTag(int r1, ChatterChatViewHolder r2, D r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
    }

    public boolean checkDisable(D r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return false;
    }

    public boolean needBindSubTitle() {
        return true;
    }

    public boolean needBindSummary(D r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return true;
    }

    public void onDisableClickHandler() {
    }

    private final b getOfficialDocTag() {
        return (b) this.officialDocTag$delegate.getValue();
    }

    private final b getOnCallTag() {
        return (b) this.onCallTag$delegate.getValue();
    }

    private final b getPrivateModeTag() {
        return (b) this.privateModeTag$delegate.getValue();
    }

    private final b getSecretTag() {
        return (b) this.secretTag$delegate.getValue();
    }

    public final boolean isFold() {
        return this.render.isFold();
    }

    public final SearchCommonFgUtils getFgUtils() {
        return this.fgUtils;
    }

    public final boolean getForceRefreshNotifyItemChangedOnUnconsumedClick() {
        return this.forceRefreshNotifyItemChangedOnUnconsumedClick;
    }

    public final c getRender() {
        return this.render;
    }

    public final boolean isBindTagWithDynamicTag() {
        return this.isBindTagWithDynamicTag;
    }

    public final boolean isDisableExtraInfoSummary() {
        return this.disableExtraInfoSummary;
    }

    public final boolean isDisableRightViewHolder() {
        return this.disableRightViewHolder;
    }

    public boolean needBindDynamicTag() {
        return this.isBindTagWithDynamicTag;
    }

    public static final /* synthetic */ g access$getAdapterClickHandler$p(CommonBinder r0) {
        return r0.adapterClickHandler;
    }

    public static final /* synthetic */ g access$getMOnItemClickHandler$p(CommonBinder r0) {
        return r0.mOnItemClickHandler;
    }

    public final boolean isChatPreviewDisabled(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return ExternalTargetAvatarProviderStore.INSTANCE.requiresProvider(r2);
    }

    public final boolean isExternal(D r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (PickerBaseModuleDependency.getDependency().isCustomer() == false) goto L5;
    L9:
        return false;
    L5:
        if (PickerBaseModuleDependency.getDependency().isSimpleTenant() == true) goto L9;
        if (r2.isCrossTenant() == false) goto L9;
        return true;
    }

    public final void setAdapterClickHandler(g r2) {
        Intrinsics.checkNotNullParameter(r2, "onItemClickHandler");
        this.adapterClickHandler = r2;
    }

    public final void setBindTagWithDynamicTag(boolean r1) {
        this.isBindTagWithDynamicTag = r1;
    }

    public final void setDisableExtraInfoSummary(boolean r1) {
        this.disableExtraInfoSummary = r1;
    }

    public final void setDisableRightViewHolder(boolean r1) {
        this.disableRightViewHolder = r1;
    }

    public final void setFgUtils(SearchCommonFgUtils r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fgUtils = r2;
    }

    public final void setFold(boolean r2) {
        this.render.setFold(r2);
    }

    public final void setForceRefreshNotifyItemChangedOnUnconsumedClick(boolean r1) {
        this.forceRefreshNotifyItemChangedOnUnconsumedClick = r1;
    }

    private final void bindBadge(ChatterChatViewHolder r24, D r25) {
        int r1 = 0;
        if (r25.isShowBadge() == true) goto L5;
    L97:
        AvatarItemView r0 = r24.getAvatarItemView().getItem();
        vz7.b r2 = new vz7.b();
        r2.i = false;
        r0.badge(r2);
        return;
    L5:
        if (r25.getNewMsgCount() <= 0) goto L97;
        AvatarItemView r3 = r24.getAvatarItemView().getItem();
        vz7.c r4 = new vz7.c(this.mContext);
        String r5 = String.valueOf(r25.getNewMsgCount());
        Intrinsics.checkNotNullParameter(r5, "text");
        r4.b = r5;
        if (r25.isRemind() == false) goto L9;
        r4.c = 1;
    L10:
        vz7.b r6 = new vz7.b();
        float r7 = j08.b.a(r4.a, r4.g);
        String r8 = r4.b;
        r6.a = r8;
        r6.b = r7;
        int r9 = r8.length();
        if (r9 != 1) goto L13;
        char r10 = 3;
    L16:
        com.larksuite.component.ui.imageview.b r11 = new com.larksuite.component.ui.imageview.b();
        String r12 = r4.b;
        if (Intrinsics.areEqual(r11.b, r12) == true) goto L19;
        r11.c = -1.0f;
        r11.b = r12;
    L19:
        int r13 = e.a;
        r11.a.setTypeface(e.a(r4.a));
        Context r14 = r4.a;
        float r15 = r4.g;
        Intrinsics.checkNotNullParameter(r14, "context");
        float r16 = j08.b.a(r14, 5.5f);
        float r17 = j08.b.a(r14, 2.0f);
        float r18 = j08.b.a(r14, 2.0f);
        float r19 = r15 / 12.0f;
        float r110 = j08.b.a(r14, r15);
        long r111 = r4.e;
        if ((-2147483648L) <= r111) goto L22;
    L24:
        boolean r21 = false;
    L26:
        if (r21 == false) goto L28;
        int r112 = (int) r111;
    L36:
        r6.e = r112;
        long r20 = r4.f;
        if ((-2147483648L) <= r20) goto L39;
    L41:
        boolean r113 = false;
    L42:
        if (r113 == false) goto L44;
        int r22 = (int) r20;
    L55:
        if (r10 != 0) goto L64;
        boolean r23 = r4.d;
        GradientDrawable r26 = new GradientDrawable();
        r26.setColor(r22);
        r26.setShape(0);
        if (r23 == false) goto L59;
        float r114 = r18 * r19;
    L60:
        r26.setStroke((int) r114, -1);
        r26.setCornerRadius(j08.b.a(r14, 10.0f) * r19);
        float r27 = 2;
        float r115 = r114 * r27;
        float r28 = (r16 * r19) * r27;
        r26.setSize((int) (((21.0f * r19) + r115) + r28), (int) (((16.0f * r19) + r115) + r28));
        Drawable r29 = AppCompatResources.getDrawable(r14, 2131231793);
        if (r29 == null) goto L63;
        r29.setTint(r112);
    L63:
        ScaleDrawable r30 = new ScaleDrawable(r29, 17, 1.0f, 1.0f);
        r30.setLevel((int) (OPTrace.BATCH_CODE * r19));
        int r116 = (r26.getIntrinsicWidth() / 2) - (r30.getIntrinsicWidth() / 2);
        int r117 = (r26.getIntrinsicHeight() / 2) - (r30.getIntrinsicHeight() / 2);
        LayerDrawable r31 = new LayerDrawable(new Drawable[]{r26, r30});
        r31.setLayerInset(1, r116, r117, r116, r117);
        Drawable r32 = r31;
    L96:
        r6.f = r32;
        r6.d = 0.0f;
        r6.c = 0.0f;
        r6.g = 1;
        r3.badge(r6);
        return;
    L59:
        r114 = 0.0f;
        goto L60
    L64:
        boolean r33 = r4.d;
        Intrinsics.checkNotNullParameter(r11, "helper");
        if (r11.a.getTextSize() != r110) goto L67;
        boolean r118 = true;
    L68:
        if (r118 == true) goto L70;
        r11.a.setTextSize(r110);
        r11.c = -1.0f;
        r11.d = -1.0f;
    L70:
        GradientDrawable r119 = new GradientDrawable();
        r119.setColor(r22);
        if (r10 != 1) goto L73;
    L75:
        r1 = 1;
    L76:
        r119.setShape(r1);
        if (r1 != 0) goto L79;
        r119.setCornerRadius(j08.b.a(r14, 10.0f) * r19);
    L79:
        if (r33 == false) goto L81;
        float r34 = 1.5f * r19;
    L82:
        r119.setStroke((int) j08.b.a(r14, r34), -1);
        if (r10 != 1) goto L87;
        r19 = r19 * 0.8f;
        if (Intrinsics.areEqual(r11.b, UserInfo.NONE_NAME_CARD_ID) == true) goto L87;
        r11.c = -1.0f;
        r11.b = UserInfo.NONE_NAME_CARD_ID;
    L87:
        float r35 = r11.a();
        float r36 = r11.d;
        if (r36 > 0.0f) goto L92;
        Paint.FontMetrics r37 = r11.a.getFontMetrics();
        r36 = r37.descent - r37.ascent;
    L92:
        if (r1 != 1) goto L94;
        float r38 = 2;
        float r39 = Math.max(((r35 / r38) + (r16 * r19)) + r34, ((r36 / r38) + (r17 * r19)) + r34) * r38;
        float r40 = r39;
    L95:
        r119.setSize((int) r39, (int) r40);
        r32 = r119;
        goto L96
    L94:
        float r41 = 2;
        float r42 = r34 * r41;
        float r43 = (r35 + ((r16 * r19) * r41)) + r42;
        r40 = r42 + (r36 + ((r17 * r19) * r41));
        r39 = r43;
        goto L95
    L81:
        r34 = 0.0f;
        goto L82
    L73:
        if (r10 == 3) goto L75;
    L67:
        r118 = false;
        goto L68
    L44:
        Context r44 = r4.a;
        int r45 = r4.c;
        if (r45 == 0) goto L52;
        if (r45 != 1) goto L48;
        int r46 = ContextCompat.getColor(r44, 2131103493);
    L53:
        r22 = r46;
        goto L55
    L48:
        if (r45 == 2) goto L50;
        r46 = ContextCompat.getColor(r44, 2131103454);
        goto L53
    L50:
        r46 = ContextCompat.getColor(r44, 2131103488);
        goto L53
    L52:
        r46 = ContextCompat.getColor(r44, 2131103454);
        goto L53
    L39:
        if (r20 > 2147483647L) goto L41;
        r113 = true;
        goto L42
    L28:
        int r120 = r4.c;
        if (r120 == 0) goto L35;
        if (r120 == 1) goto L34;
        if (r120 == 2) goto L33;
        r112 = ContextCompat.getColor(r4.a, 2131103449);
        goto L36
    L33:
        r112 = ContextCompat.getColor(r4.a, 2131103493);
        goto L36
    L34:
        r112 = ContextCompat.getColor(r4.a, 2131103449);
        goto L36
    L35:
        r112 = ContextCompat.getColor(r4.a, 2131103449);
        goto L36
    L22:
        if (r111 > 2147483647L) goto L24;
        r21 = true;
        goto L26
    L13:
        if (r9 <= 1) goto L15;
        r10 = 2;
        goto L16
    L15:
        r10 = 1;
        goto L16
    L9:
        r4.c = 0;
        goto L10
    }

    private final w3c.b buildCheckBoxModel(D r5, SearchResultView.CheckBoxBindStatus r6) {
        w3c.b r0 = new w3c.b();
        r0.c = isMultiple();
        if (checkDisable(r5) == false) goto L6;
        r0.b = false;
    L13:
        return r0;
    L6:
        if (r5.isRequired() == false) goto L8;
        r0.a = true;
        r0.b = false;
        goto L13
    L8:
        if (r6 != null) goto L10;
    L12:
        r0.a = r5.isSelected();
        r0.b = true;
        goto L13
    L10:
        if (r6.isConsume() == false) goto L12;
        r0.a = r6.isChecked();
        r0.b = r6.isEnabled();
        goto L13
    }

    public final void avatarAttachRightView(ChatterChatViewHolder r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "view");
        if (isDisableRightViewHolder() == false) goto L5;
        return;
    L5:
        AvatarItemView.attachRightView$default(r7.getAvatarItemView().getItem(), r8, false, false, 6, null);
    }

    public void bindAvatar(ChatterChatViewHolder r3, D r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (AvatarHelperKt.bindExternalTargetAvatar(r3.getAvatarItemView().getItem().getAvatarView(), r4) == false) goto L5;
        return;
    L5:
        AvatarItemView r5 = r3.getAvatarItemView().getItem();
        a.a r0 = new a.a();
        r0.b(r4.getAvatarKey());
        r0.f(r4.getId());
        r5.avatar(new a(r0));
    }

    public final void bindDynamicTag(ChatterChatViewHolder r7, D r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "data");
        LarkNameTag.c r0 = new LarkNameTag.c(this.mContext);
        List r9 = r8.getExplanationTags();
        if (r9 == null) goto L41;
        Iterator r10 = r9.iterator();
    L6:
        if (r10.hasNext() == false) goto L41;
        ExplanationTag r1 = (ExplanationTag) r10.next();
        ExplanationTag.TagStyle r2 = r1.tag_style;
        if (r2 == null) goto L9;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 != 1) goto L13;
        r0.c(getPrivateModeTag(), true);
        goto L6
    L13:
        if (r3 != 2) goto L15;
        r0.c(getSecretTag(), true);
        goto L6
    L15:
        if (r3 != 3) goto L17;
        r0.c(getOnCallTag(), true);
        goto L6
    L17:
        if (r3 != 4) goto L19;
        String r4 = r1.tag_type;
        if (r4 == null) goto L37;
        boolean r5 = false;
        if (r4.length() != 0) goto L27;
        boolean r6 = true;
    L28:
        if (r6 == true) goto L64;
        String r11 = r1.text;
        if (r11 == null) goto L65;
        if (r11.length() != 0) goto L34;
        r5 = true;
    L34:
        if (r5 == true) goto L66;
        int r12 = f.g;
        f.a r13 = new f.a();
        UDTagsDrawable.TagColorSet r14 = UiUtil.Companion.getColorResByTagType(r1.tag_type);
        r13.b = 50;
        r13.d = r1.text;
        r13.e = r14.getTextColorRes();
        r13.g = r14.getBackgroundColorRes();
        r0.d(new f(r13), true);
        goto L6
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L27:
        r6 = false;
        goto L28
    L37:
        return;
    L19:
        if (r3 != 5) goto L20;
        r0.b(getOfficialDocTag(), true);
        goto L6
    L20:
        return;
    L9:
        return;
    L41:
        r7.getAvatarItemView().getItem().setTag(r0);
    }

    public final void bindExtraInfoSummary(ChatterChatViewHolder r2, D r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "data");
        if (r3.getExtraInfoSummary() != null) goto L5;
        return;
    L5:
        if (r3.getExtraInfoSummary().getExtraInfoList().isEmpty() == true) goto L10;
        r2.getAvatarItemView().getItem().setExtraInfoSummary(r3.getExtraInfoSummary(), r3.getType());
        return;
    }

    public final void bindSingle(D r7, ChatterChatViewHolder r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "holder");
        if (isSingleChoice(r7) == false) goto L6;
        ImageView r1 = new ImageView(this.mContext);
        r1.setPadding(0, 0, d.a(10), 0);
        r1.setImageDrawable(UDIconUtils.getIconDrawable(r1.getContext(), 2131255020, d.c(r1.getContext(), 2131105548)));
        AvatarItemView.attachRightView$default(r8.getAvatarItemView().getItem(), r1, false, false, 6, null);
        return;
    }

    public CommonBinder(Context r2, g r3, IItemViewBridgeFactory r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mOnItemClickHandler");
        Intrinsics.checkNotNullParameter(r4, "mItemViewBridgeFactory");
        this.mContext = r2;
        this.mOnItemClickHandler = r3;
        this.mItemViewBridgeFactory = r4;
        this.fgUtils = new SearchCommonFgUtils();
        this.officialDocTag$delegate = LazyKt.lazy(CommonBinder$officialDocTag$2.INSTANCE);
        this.privateModeTag$delegate = LazyKt.lazy(new CommonBinder$privateModeTag$2(this));
        this.secretTag$delegate = LazyKt.lazy(new CommonBinder$secretTag$2(this));
        this.onCallTag$delegate = LazyKt.lazy(new CommonBinder$onCallTag$2(this));
        this.render = PickerBaseModuleDependency.getDependency().makeDynamicRender(r2);
    }

    @Override // com.ss.android.lark.picker.base.view.binder.BaseViewBinder
    public void bind(final int r10, final D r11, final RecyclerView.ViewHolder r12) {
        Intrinsics.checkNotNullParameter(r11, "data");
        Intrinsics.checkNotNullParameter(r12, "holder");
        final IItemViewBridge r0 = this.mItemViewBridgeFactory.obtain(r12);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.reset();
        if ((r12 instanceof ChatterChatViewHolder) == false) goto L37;
        ChatterChatViewHolder r1 = (ChatterChatViewHolder) r12;
        r1.getAvatarItemView().getItem().resetAllViews();
        bindAvatar(r1, r11);
        bindBadge(r1, r11);
        bindTitle(r11, r1, true);
        String r4 = r11.getRenderDSL();
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L23;
        if (needBindDynamicTag() == false) goto L23;
        Log.i(TAG, "render with renderDSL");
        View r6 = this.render.parseTemplate(r11.getRenderDSL(), r11.getRenderData(), r11.getId());
        if (r6 == null) goto L29;
        r1.getAvatarItemView().getItem().addViewToRender(r6);
    L29:
        if (r11.getSourceType() == ResultSourceType.LOCAL) goto L33;
        if (r11.getSourceType() == ResultSourceType.NET) goto L33;
    L35:
        bindTag(r10, r1, r11);
    L36:
        bindOthers(r10, r1, r11);
        bindSingle(r11, r1);
    L38:
        SearchResultView.IOnBusinessConsumeItem r2 = getMOnBusinessConsumeItem();
        if (r2 == null) goto L41;
        SearchResultView.CheckBoxBindStatus r3 = r2.onBusinessBindItemCheckBox(r11);
    L42:
        final w3c.b r7 = buildCheckBoxModel(r11, r3);
        if (r7.b == false) goto L45;
        r0.showMask(false);
    L46:
        r0.checkState(r7);
        r0.setOnItemClickListener(new CommonBinder$bind$clickListener$1(this, r11, r0, r7, r12, r10));
        return;
    L45:
        r0.showMask(true);
        int r8 = DesktopUtil.a;
        goto L46
    L41:
        r3 = null;
    L33:
        if (needBindDynamicTag() == false) goto L35;
        Log.i(TAG, "bindTag with dynamic tag");
        bindDynamicTag(r1, r11);
    L23:
        if (needBindSubTitle() == false) goto L26;
        bindSubTitle(r11, r1);
    L26:
        if (needBindSummary(r11) == false) goto L29;
        bindSummary(r11, r1);
        goto L29
    L10:
        if (StringsKt.isBlank(r4) == true) goto L13;
        r5 = false;
        goto L15
    L37:
        r0.bindData(r11);
        goto L38
    }

    public /* synthetic */ CommonBinder(Context r1, g r2, IItemViewBridgeFactory r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new DefaultItemViewBridgeFactory();
    L5:
        this(r1, r2, r3);
    }
}
