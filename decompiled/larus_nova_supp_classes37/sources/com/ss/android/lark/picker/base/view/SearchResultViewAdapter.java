package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.o0;
import com.ss.android.lark.picker.base.databinding.ItemSpotlightLoadingBinding;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.picker.base.view.binder.BaseViewBinder;
import com.ss.android.lark.picker.base.view.binder.BinderRepo;
import com.ss.android.lark.picker.base.view.binder.CalendarEventBinder;
import com.ss.android.lark.picker.base.view.binder.ChatBinder;
import com.ss.android.lark.picker.base.view.binder.ColdAndHotBinder;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.DepartmentBinder;
import com.ss.android.lark.picker.base.view.binder.HelpDeskBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomViewTypeResolver;
import com.ss.android.lark.picker.base.view.binder.IOnProfileClickListener;
import com.ss.android.lark.picker.base.view.binder.IViewBinder;
import com.ss.android.lark.picker.base.view.binder.LinkBinder;
import com.ss.android.lark.picker.base.view.binder.LoadingBinder;
import com.ss.android.lark.picker.base.view.binder.MailContactBinder;
import com.ss.android.lark.picker.base.view.binder.OpenAppBinder;
import com.ss.android.lark.picker.base.view.binder.OpenSearchBinder;
import com.ss.android.lark.picker.base.view.binder.ReplyInThreadBinder;
import com.ss.android.lark.picker.base.view.binder.ShieldP2PChatBinder;
import com.ss.android.lark.picker.base.view.binder.ThreadBinder;
import com.ss.android.lark.picker.base.view.binder.UserGroupBinder;
import com.ss.android.lark.picker.base.view.binder.WikiSpaceBinder;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchCalendarEventInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchFileInfo;
import com.ss.android.lark.search.dto.info.SearchHelpDeskInfo;
import com.ss.android.lark.search.dto.info.SearchLinkInfo;
import com.ss.android.lark.search.dto.info.SearchLoadingFooterInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchSecretP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.info.SearchUserTeamInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v3c.d;
import v3c.g;
import v3c.h;
import v3c.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002abB9\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020-H\u0016J&\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\f\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00109\u001a\u0002042\u0006\u00105\u001a\u00020:H\u0002J\u0006\u0010;\u001a\u000204J\u000e\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\u0019J\u000e\u0010>\u001a\u0002042\u0006\u0010?\u001a\u00020\u0019J\u000e\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u0019J\u000e\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u0019J\u000e\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020\u0019J\u000e\u0010F\u001a\u0002042\u0006\u0010F\u001a\u00020\u0019J\u000e\u0010G\u001a\u0002042\u0006\u0010G\u001a\u00020\u0019J\u0010\u0010H\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-H\u0016J\u0012\u0010I\u001a\u0004\u0018\u00010\u001f2\u0006\u0010.\u001a\u00020-H\u0016J\b\u0010J\u001a\u000204H\u0016J\u000e\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020LJ\u0016\u0010O\u001a\u0002042\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010QJ\u0010\u0010S\u001a\u0002042\b\u0010T\u001a\u0004\u0018\u00010UJ\u001e\u0010V\u001a\u0002042\u0016\u0010W\u001a\u0012\u0012\u0004\u0012\u00020-\u0012\b\u0012\u0006\u0012\u0002\b\u00030Y0XJ\u000e\u0010Z\u001a\u0002042\u0006\u0010[\u001a\u00020\\J\u0006\u0010]\u001a\u000204J\u0006\u0010^\u001a\u000204J\u0006\u0010_\u001a\u000204J\u0010\u0010`\u001a\u0002042\u0006\u00105\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR$\u0010(\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u000e\u0010+\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultViewAdapter;", "Lcom/ss/android/lark/picker/base/view/SearchRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "context", "Landroid/content/Context;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "contentViewSizeProvider", "Lcom/ss/android/lark/search/dto/SearchItemInterface$ContentViewSizeProvider;", "updateHistoryListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;", "onWeakNetRetryClickListener", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnWeakNetRetryClickListener;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/search/dto/SearchItemInterface$ContentViewSizeProvider;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnWeakNetRetryClickListener;)V", "mBinderRepo", "Lcom/ss/android/lark/picker/base/view/binder/BinderRepo;", "mOnItemOnScreenListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "getMOnItemOnScreenListener", "()Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "setMOnItemOnScreenListener", "(Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;)V", "value", "", "mIsEnableChatPreview", "getMIsEnableChatPreview", "()Z", "setMIsEnableChatPreview", "(Z)V", "", "mScene", "getMScene", "()Ljava/lang/String;", "setMScene", "(Ljava/lang/String;)V", "mBindTagWithDynamicTag", "getMBindTagWithDynamicTag", "setMBindTagWithDynamicTag", "forceRefreshNotifyItemChangedOnUnconsumedClick", "getForceRefreshNotifyItemChangedOnUnconsumedClick", "setForceRefreshNotifyItemChangedOnUnconsumedClick", "mShowDivider", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "", "resetItemSubTitle", "Lcom/ss/android/lark/picker/base/view/ChatterChatViewHolder;", "resetShowCeilingBarStatus", "switchMultiple", "isMultiple", "setSingleChoiceMode", "isSingleChoice", "switchFold", "isFold", "setDisableRightViewHolder", "disableRightViewHolder", "setDisableExtraInfoSummary", "disableExtraInfoSummary", "disableExternalChatter", "showDivider", "getItem", "getTopNRptId", "clear", "mCustomBinder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "setCustomBinder", "customBinder", "setCustomViewTypeResolvers", "resolvers", "", "Lcom/ss/android/lark/picker/base/view/binder/ICustomViewTypeResolver;", "setOnBusinessConsumeItem", "onBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "registerCustomBinders", "customBinders", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "setProfileClickListener", "listener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "onPause", "onResume", "onDestroy", "onViewRecycled", "Companion", "EmptyViewHolder", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchResultViewAdapter extends SearchRecyclerViewBaseAdapter<RecyclerView.ViewHolder, SearchBaseInfo> {
    public static final Companion Companion = null;
    public static final String TAG = "SearchResultViewAdapter";
    private final d contentViewSizeProvider;
    private final Context context;
    private boolean forceRefreshNotifyItemChangedOnUnconsumedClick;
    private boolean mBindTagWithDynamicTag;
    private final BinderRepo mBinderRepo;
    private ICustomBinder mCustomBinder;
    private boolean mIsEnableChatPreview;
    private h mOnItemOnScreenListener;
    private String mScene;
    private boolean mShowDivider;
    private final g onItemClickHandler;
    private final SearchResultView.IOnWeakNetRetryClickListener onWeakNetRetryClickListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultViewAdapter$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultViewAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            super(r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SearchResultViewAdapter(Context r10, g r11, d r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "onItemClickHandler");
        Intrinsics.checkNotNullParameter(r12, "contentViewSizeProvider");
        this(r10, r11, r12, null, null, 24, null);
    }

    public SearchResultViewAdapter(Context r10, g r11, d r12, i r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "onItemClickHandler");
        Intrinsics.checkNotNullParameter(r12, "contentViewSizeProvider");
        this(r10, r11, r12, r13, null, 16, null);
    }

    private final void resetItemSubTitle(ChatterChatViewHolder r1) {
    }

    public final void onDestroy() {
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void resetShowCeilingBarStatus() {
        this.mBinderRepo.switchFoldUnFold(true);
    }

    public void clear() {
        super.clear();
    }

    public final boolean getForceRefreshNotifyItemChangedOnUnconsumedClick() {
        return this.forceRefreshNotifyItemChangedOnUnconsumedClick;
    }

    public final boolean getMBindTagWithDynamicTag() {
        return this.mBindTagWithDynamicTag;
    }

    public final boolean getMIsEnableChatPreview() {
        return this.mIsEnableChatPreview;
    }

    public final h getMOnItemOnScreenListener() {
        return this.mOnItemOnScreenListener;
    }

    public final String getMScene() {
        return this.mScene;
    }

    public final void disableExternalChatter(boolean r2) {
        this.mBinderRepo.disableExternalChatter(r2);
        notifyDataSetChanged();
    }

    public SearchBaseInfo getItem(int r1) {
        SearchBaseInfo r2 = (SearchBaseInfo) super.getItem(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new SearchBaseInfo();
    }

    public int getItemViewType(int r4) {
        return this.mBinderRepo.resolveItemViewType(getItem(r4), r4, 4);
    }

    @Override // com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter
    public String getTopNRptId(int r1) {
        return getItem(r1).getId();
    }

    public void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
    }

    public final void registerCustomBinders(Map<Integer, ? extends CommonBinder<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinders");
        this.mBinderRepo.registerCustomBinders(r2);
        notifyDataSetChanged();
    }

    public final void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinder");
        this.mCustomBinder = r2;
        this.mBinderRepo.setCustomBinderForViewType(r2);
    }

    public final void setCustomViewTypeResolvers(List<? extends ICustomViewTypeResolver> r2) {
        this.mBinderRepo.setCustomViewTypeResolvers(r2);
        notifyDataSetChanged();
    }

    public final void setDisableExtraInfoSummary(boolean r2) {
        this.mBinderRepo.setDisableExtraInfoSummary(r2);
        notifyDataSetChanged();
    }

    public final void setDisableRightViewHolder(boolean r2) {
        this.mBinderRepo.setDisableRightViewHolder(r2);
        notifyDataSetChanged();
    }

    public final void setForceRefreshNotifyItemChangedOnUnconsumedClick(final boolean r3) {
        this.forceRefreshNotifyItemChangedOnUnconsumedClick = r3;
        this.mBinderRepo.custom(new SearchResultViewAdapter$forceRefreshNotifyItemChangedOnUnconsumedClick$1(r3));
    }

    public final void setMBindTagWithDynamicTag(final boolean r3) {
        this.mBindTagWithDynamicTag = r3;
        this.mBinderRepo.custom(new SearchResultViewAdapter$mBindTagWithDynamicTag$1(r3));
    }

    public final void setMIsEnableChatPreview(final boolean r3) {
        this.mIsEnableChatPreview = r3;
        this.mBinderRepo.custom(new SearchResultViewAdapter$mIsEnableChatPreview$1(r3));
    }

    public final void setMOnItemOnScreenListener(h r1) {
        this.mOnItemOnScreenListener = r1;
    }

    public final void setMScene(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        this.mScene = r3;
        this.mBinderRepo.custom(new SearchResultViewAdapter$mScene$1(r3));
    }

    public final void setOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r2) {
        this.mBinderRepo.setOnBusinessConsumeItem(r2);
    }

    public final void setProfileClickListener(IOnProfileClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mBinderRepo.setProfileClickListener(r2);
    }

    public final void setSingleChoiceMode(boolean r2) {
        this.mBinderRepo.setSingleChoiceMode(r2);
        notifyDataSetChanged();
    }

    public final void showDivider(boolean r1) {
        this.mShowDivider = r1;
        notifyDataSetChanged();
    }

    public final void switchFold(boolean r2) {
        this.mBinderRepo.switchFoldUnFold(r2);
        notifyDataSetChanged();
    }

    public final void switchMultiple(boolean r2) {
        this.mBinderRepo.switchMultiple(r2);
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: getItem, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3356getItem(int r1) {
        return getItem(r1);
    }

    @Override // com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter
    public void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        super.onBindViewHolder(r7, r8);
        SearchWikiSpaceInfo r0 = getItem(r8);
        if (SearchCommonUtils.INSTANCE.isUIData(r0) == true) goto L7;
        h r1 = this.mOnItemOnScreenListener;
        if (r1 == null) goto L7;
        r1.a(r0, r7);
    L7:
        int r2 = getItemViewType(r8);
        IViewBinder r3 = this.mBinderRepo.getBinderForViewType(r2);
        boolean r4 = r3 instanceof BaseViewBinder;
        if (r4 == false) goto L18;
        if (r4 == false) goto L11;
        BaseViewBinder r5 = (BaseViewBinder) r3;
    L12:
        if (r5 == null) goto L18;
        if (r5.supports(r7) == false) goto L18;
        r5.bind(r8, r0, r7);
        return;
    L11:
        r5 = null;
    L18:
        if ((r7 instanceof ChatterChatViewHolder) == false) goto L65;
        ChatterChatViewHolder r6 = (ChatterChatViewHolder) r7;
        r6.getAvatarItemView().getItem().resetAllViews();
        int r9 = r6.getItemType();
        if (r9 == 0) goto L56;
        if (r9 != 1) goto L23;
        ChatBinder r10 = this.mBinderRepo.getChatBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatInfo");
        r10.bind(r8, (SearchChatInfo) r0, r7);
        return;
    L23:
        if (r9 != 2) goto L25;
        DepartmentBinder r11 = this.mBinderRepo.getDepartmentBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchDepartmentInfo");
        r11.bind(r8, (SearchDepartmentInfo) r0, r7);
        return;
    L25:
        if (r9 != 15) goto L27;
        OpenSearchBinder r12 = this.mBinderRepo.getOpenSearchBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchOpenSearchInfo");
        r12.bind(r8, (SearchOpenSearchInfo) r0, r7);
        return;
    L27:
        if (r9 != 29) goto L29;
        MailContactBinder r13 = this.mBinderRepo.getMailContactBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchMailContactInfo");
        r13.bind(r8, (SearchMailContactInfo) r0, r7);
        return;
    L29:
        if (r9 == 40) goto L50;
        switch(r9) {
            case 4: goto L46;
            case 5: goto L39;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            default: goto L31;
        };
    L31:
        switch(r9) {
            case 33: goto L49;
            case 34: goto L48;
            case 35: goto L47;
            default: goto L98;
        };
    L47:
        WikiSpaceBinder r14 = this.mBinderRepo.getWikiSpaceBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo");
        r14.bind(r8, r0, r7);
        return;
    L48:
        ShieldP2PChatBinder r15 = this.mBinderRepo.getShieldP2PChatBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo");
        r15.bind(r8, (SearchShieldP2PChatInfo) r0, r7);
        resetItemSubTitle(r6);
        return;
    L49:
        ReplyInThreadBinder r16 = this.mBinderRepo.getReplyInThreadBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo");
        r16.bind(r8, (SearchReplyInThreadInfo) r0, r7);
        return;
    L98:
        return;
    L33:
        OpenAppBinder r17 = this.mBinderRepo.getOpenAppBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchOpenAppInfo");
        r17.bind(r8, (SearchOpenAppInfo) r0, r7);
        return;
    L34:
        HelpDeskBinder r18 = this.mBinderRepo.getHelpDeskBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchHelpDeskInfo");
        r18.bind(r8, (SearchHelpDeskInfo) r0, r7);
        return;
    L35:
        CalendarEventBinder r19 = this.mBinderRepo.getCalendarEventBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchCalendarEventInfo");
        r19.bind(r8, (SearchCalendarEventInfo) r0, r7);
        return;
    L36:
        ThreadBinder r20 = this.mBinderRepo.getThreadBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchThreadInfo");
        r20.bind(r8, (SearchThreadInfo) r0, r7);
        return;
    L37:
        this.mBinderRepo.getCcmBinder().bind(r8, r0, r7);
        return;
    L46:
        this.mBinderRepo.getCommonBinder().bind(r8, r0, r7);
        return;
    L39:
        if ((r0 instanceof SearchFileInfo) == false) goto L44;
        SearchMessageInfo r21 = new SearchMessageInfo();
        SearchFileInfo r22 = (SearchFileInfo) r0;
        r21.setMsgType(r22.getMsgType());
        r21.setUpdateTime(r22.getUpdateTime());
        r21.setPosition(r22.getPosition());
        r21.setChatId(r22.getChatId());
        r21.setFromId(r22.getFromId());
        r21.setFileContent(r22.getFileContent());
        r21.setThreadId(r22.getThreadId());
        r21.setMessageThreadPosition(r22.getThreadPosition());
        r21.setId(r22.getId());
        r21.setAvatarKey(r22.getAvatarKey());
        r21.setTitle(r22.getTitle());
        r21.setTitleTagList(r22.getTitleTagList());
        r21.setSubTitle(r22.getSubTitle());
        r21.setSubTitleTagList(r22.getSubTitleTagList());
        r21.setExtraTitle(r22.getExtraTitle());
        r21.setExtraTitleTagList(r22.getExtraTitleTagList());
        r21.setChatInsideShow(r22.isChatInsideShow());
        if (r22.isChatInsideShow() == false) goto L43;
        r21.setBinderByFile(true);
    L43:
        r21.setP2pChat(r22.isP2pChat());
        r21.setP2pChatterId(r22.getP2pChatterId());
    L45:
        this.mBinderRepo.getMessageBinder().bind(r8, r21, r7);
        return;
    L44:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchMessageInfo");
        r21 = (SearchMessageInfo) r0;
        goto L45
    L50:
        UserGroupBinder r23 = this.mBinderRepo.getUserGroupBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchUserGroupInfo");
        r23.bind(r8, (SearchUserGroupInfo) r0, r7);
        return;
    L56:
        if ((r0 instanceof SearchUserTeamInfo) == false) goto L60;
        this.mBinderRepo.getUserTeamBinder().bind(r8, (SearchUserTeamInfo) r0, r7);
        resetItemSubTitle(r6);
        return;
    L60:
        if ((r0 instanceof SearchSecretP2PChatInfo) == false) goto L62;
        SearchChatterInfo r24 = new SearchChatterInfo();
        SearchSecretP2PChatInfo r25 = (SearchSecretP2PChatInfo) r0;
        r24.setChatterType(r25.getChatterType());
        r24.setChatterDescription(r25.getChatterDescription());
        r24.setTenantId(r25.getTenantId());
        r24.setRegistered(r25.isRegistered());
        r24.setRemind(r25.isRemind());
        r24.setP2pChatId(r25.getId());
        r24.setP2pCryptoChat(true);
        r24.setCryptoChatterId(r25.getChatterId());
        r24.setId(r25.getId());
        r24.setAvatarKey(r25.getAvatarKey());
        r24.setTitle(r25.getTitle());
        r24.setTitleTagList(r25.getTitleTagList());
        r24.setSubTitle(r25.getSubTitle());
        r24.setSubTitleTagList(r25.getSubTitleTagList());
        r24.setExtraTitle(r25.getExtraTitle());
        r24.setExtraTitleTagList(r25.getExtraTitleTagList());
    L63:
        this.mBinderRepo.getChatterBinder().bind(r8, r24, r6, this.contentViewSizeProvider);
        resetItemSubTitle(r6);
        return;
    L62:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatterInfo");
        r24 = (SearchChatterInfo) r0;
        goto L63
    L65:
        if ((r7 instanceof SearchLinkViewHolder) == false) goto L68;
        LinkBinder r26 = this.mBinderRepo.getLinkBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchLinkInfo");
        r26.bind(r8, (SearchLinkInfo) r0, (SearchLinkViewHolder) r7);
        return;
    L68:
        if ((r7 instanceof ColdAndHotViewHolder) == false) goto L71;
        ColdAndHotBinder r27 = this.mBinderRepo.getColdAndHotBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchColdAndHotInfo");
        r27.bind(r8, (SearchColdAndHotInfo) r0, (ColdAndHotViewHolder) r7);
        return;
    L71:
        if ((r7 instanceof SpotlightLoadingViewHolder) == false) goto L73;
        LoadingBinder r28 = this.mBinderRepo.getLoadingBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchLoadingFooterInfo");
        r28.bind(r8, (SearchLoadingFooterInfo) r0, (SpotlightLoadingViewHolder) r7);
        return;
    L73:
        ICustomBinder r29 = this.mCustomBinder;
        if (r29 == null) goto L76;
        r29.onBindViewHolder(r7, r0, r8);
        return;
    L76:
        this.mBinderRepo.getEmptyBuilder().bind(r8, r0, r7);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        IViewBinder r0 = this.mBinderRepo.getBinderForViewType(r9);
        if ((r0 instanceof CommonBinder) == false) goto L8;
        RecyclerView.ViewHolder r1 = ((CommonBinder) r0).createCustomViewHolder(r8, r9);
        if (r1 == null) goto L8;
        return r1;
    L8:
        if (r9 != 0) goto L10;
    L36:
        AvatarItemViewWithMask r10 = new AvatarItemViewWithMask(this.context, null, 0, 6, null);
        r10.showDivider(false);
        ChatterChatViewHolder r2 = new ChatterChatViewHolder(r10, r9);
    L38:
        return r2;
    L10:
        if (r9 != 1) goto L12;
    L35:
        AvatarItemViewWithMask r11 = new AvatarItemViewWithMask(this.context, null, 0, 6, null);
        r11.showDivider(this.mShowDivider);
        r2 = new ChatterChatViewHolder(r11, r9);
        goto L38
    L12:
        if (r9 == 2) goto L35;
        if (r9 != 13) goto L16;
        RecyclerView.ViewHolder r12 = new SearchLinkViewHolder(LayoutInflater.from(this.context).inflate(2131561684, r8, false));
    L41:
        return r12;
    L16:
        if (r9 == 15) goto L35;
        if (r9 == 29) goto L35;
        if (r9 != 40) goto L22;
        AvatarItemViewWithMask r13 = new AvatarItemViewWithMask(this.context, null, 0, 6, null);
        r13.showDivider(this.mShowDivider);
        r2 = new ChatterChatViewHolder(r13, r9);
        goto L38
    L22:
        if (r9 == 44) goto L31;
        switch(r9) {
            case 4: goto L35;
            case 5: goto L35;
            case 6: goto L35;
            case 7: goto L35;
            case 8: goto L35;
            case 9: goto L35;
            case 10: goto L35;
            default: goto L24;
        };
    L24:
        switch(r9) {
            case 33: goto L35;
            case 34: goto L36;
            case 35: goto L35;
            case 36: goto L30;
            default: goto L25;
        };
    L25:
        ICustomBinder r3 = this.mCustomBinder;
        if (r3 == null) goto L40;
        RecyclerView.ViewHolder r14 = r3.onCreateViewHolder(r8, r9);
        if (r14 == null) goto L40;
        return r14;
    L40:
        return new EmptyViewHolder(new View(this.context));
    L30:
        r12 = new ColdAndHotViewHolder(LayoutInflater.from(this.context).inflate(2131561583, r8, false));
        goto L41
    L31:
        r12 = new SpotlightLoadingViewHolder(ItemSpotlightLoadingBinding.inflate(o0.a(r8), r8, false));
        goto L41
    }

    @Override // com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter, com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionAdapter
    public void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        super.onBindViewHolder(r2, r3, r4);
        if (CollectionUtils.isEmpty(r4) == false) goto L6;
        onBindViewHolder(r2, r3);
        return;
    }

    public SearchResultViewAdapter(Context r9, g r10, d r11, i r12, SearchResultView.IOnWeakNetRetryClickListener r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "onItemClickHandler");
        Intrinsics.checkNotNullParameter(r11, "contentViewSizeProvider");
        this.context = r9;
        this.onItemClickHandler = r10;
        this.contentViewSizeProvider = r11;
        this.onWeakNetRetryClickListener = r13;
        this.mBinderRepo = new BinderRepo(r9, r10, r12, null, 8, null);
        this.mScene = "";
    }

    public /* synthetic */ SearchResultViewAdapter(Context r8, g r9, d r10, i r11, SearchResultView.IOnWeakNetRetryClickListener r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        i r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        SearchResultView.IOnWeakNetRetryClickListener r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
