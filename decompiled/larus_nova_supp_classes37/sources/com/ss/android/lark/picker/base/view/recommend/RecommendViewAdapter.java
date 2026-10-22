package com.ss.android.lark.picker.base.view.recommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.picker.base.view.AvatarItemViewWithMask;
import com.ss.android.lark.picker.base.view.ChatterChatViewHolder;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.SearchResultViewAdapter;
import com.ss.android.lark.picker.base.view.binder.AiKnowledgeBinder;
import com.ss.android.lark.picker.base.view.binder.BaseViewBinder;
import com.ss.android.lark.picker.base.view.binder.BinderRepo;
import com.ss.android.lark.picker.base.view.binder.CCMBinder;
import com.ss.android.lark.picker.base.view.binder.ChatBinder;
import com.ss.android.lark.picker.base.view.binder.ChatterBinder;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.EmptyBinder;
import com.ss.android.lark.picker.base.view.binder.HelpDeskBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomViewTypeResolver;
import com.ss.android.lark.picker.base.view.binder.IOnProfileClickListener;
import com.ss.android.lark.picker.base.view.binder.IViewBinder;
import com.ss.android.lark.picker.base.view.binder.MailContactBinder;
import com.ss.android.lark.picker.base.view.binder.MessageBinder;
import com.ss.android.lark.picker.base.view.binder.OpenAppBinder;
import com.ss.android.lark.picker.base.view.binder.OpenSearchBinder;
import com.ss.android.lark.picker.base.view.binder.ReplyInThreadBinder;
import com.ss.android.lark.picker.base.view.binder.ShieldP2PChatBinder;
import com.ss.android.lark.picker.base.view.binder.ThreadBinder;
import com.ss.android.lark.picker.base.view.binder.WikiSpaceBinder;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchHelpDeskInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q28.c;
import v3c.b;
import v3c.d;
import v3c.f;
import v3c.g;
import v3c.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 j2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002ijB\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u00106\u001a\u00020%2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010<\u001a\u0002082\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010=\u001a\u00020%2\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u000208H\u0016J&\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00022\u0006\u00107\u001a\u0002082\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH\u0016J\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00022\u0006\u00107\u001a\u000208H\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010.2\u0006\u00107\u001a\u000208H\u0016J\u0010\u0010I\u001a\u00020;2\u0006\u00107\u001a\u000208H\u0016J\u0012\u0010J\u001a\u00020\u00052\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001a\u0010K\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u000208H\u0016J\u000e\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020%J\u000e\u0010N\u001a\u00020C2\u0006\u0010O\u001a\u00020%J\u000e\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020%J\u000e\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020%J\u0010\u0010T\u001a\u00020C2\b\u0010U\u001a\u0004\u0018\u00010VJ\u000e\u0010W\u001a\u00020C2\u0006\u0010X\u001a\u00020YJ\u000e\u0010[\u001a\u00020C2\u0006\u0010[\u001a\u00020%J\u0006\u0010\\\u001a\u00020CJ\u0006\u0010]\u001a\u00020CJ\u000e\u0010^\u001a\u00020C2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010_\u001a\u00020C2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aJ\u000e\u0010c\u001a\u00020C2\u0006\u0010d\u001a\u00020%J\u001e\u0010e\u001a\u00020C2\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u000208\u0012\b\u0012\u0006\u0012\u0002\b\u00030h0gR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020%2\u0006\u0010&\u001a\u00020%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R$\u0010/\u001a\u00020.2\u0006\u0010&\u001a\u00020.@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/ss/android/lark/picker/base/view/recommend/RecommendViewAdapter;", "Lcom/ss/android/lark/picker/base/view/SearchRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/larksuite/framework/ui/stickyheader/StickyRecyclerHeadersAdapter;", "Lcom/ss/android/lark/picker/base/view/recommend/RecommendHeaderViewHolder;", "context", "Landroid/content/Context;", "onItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "contentViewSizeProvider", "Lcom/ss/android/lark/search/dto/SearchItemInterface$ContentViewSizeProvider;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/search/dto/SearchItemInterface$ContentViewSizeProvider;)V", "mBinderRepo", "Lcom/ss/android/lark/picker/base/view/binder/BinderRepo;", "customBinder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "onClearHistoryListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnClearHistoryListener;", "getOnClearHistoryListener", "()Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnClearHistoryListener;", "setOnClearHistoryListener", "(Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnClearHistoryListener;)V", "onMoreClickListener", "Lcom/ss/android/lark/search/dto/IOnMoreClickListener;", "getOnMoreClickListener", "()Lcom/ss/android/lark/search/dto/IOnMoreClickListener;", "setOnMoreClickListener", "(Lcom/ss/android/lark/search/dto/IOnMoreClickListener;)V", "onItemOnScreenListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "getOnItemOnScreenListener", "()Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "setOnItemOnScreenListener", "(Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;)V", "showNoMoreFooter", "", "value", "mBindTagWithDynamicTag", "getMBindTagWithDynamicTag", "()Z", "setMBindTagWithDynamicTag", "(Z)V", "isEnableChatPreview", "setEnableChatPreview", "", "scene", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "onClearHistory", "onMoreClick", "isNoMoreFooterPosition", "position", "", "getItemCount", "getItemId", "", "getItemViewType", "isItemSelectable", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "", "getTopNRptId", "getHeaderId", "onCreateHeaderViewHolder", "onBindHeaderViewHolder", "setDisableRightViewHolder", "disableRightViewHolder", "setDisableExtraInfoSummary", "disableExtraInfoSummary", "switchMultiple", "isMultiple", "setSingleChoiceMode", "isSingleChoice", "setOnBusinessConsumeItem", "onBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "setProfileClickListener", "listener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "mShowDivider", "showDivider", "normalRoundHeader", "grayTitleColor", "setCustomBinder", "setCustomViewTypeResolvers", "resolvers", "", "Lcom/ss/android/lark/picker/base/view/binder/ICustomViewTypeResolver;", "setShowNoMoreFooter", "show", "registerCustomBinders", "customBinders", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "NoMoreFooterViewHolder", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RecommendViewAdapter extends SearchRecyclerViewBaseAdapter<RecyclerView.ViewHolder, SearchBaseInfo> implements c<RecommendHeaderViewHolder> {
    public static final Companion Companion = null;
    private static final String NO_MORE_TEXT = "";
    private final d contentViewSizeProvider;
    private final Context context;
    private ICustomBinder customBinder;
    private boolean grayTitleColor;
    private boolean isEnableChatPreview;
    private boolean mBindTagWithDynamicTag;
    private final BinderRepo mBinderRepo;
    private boolean mShowDivider;
    private boolean normalRoundHeader;
    private final f onClearHistory;
    private f onClearHistoryListener;
    private h onItemOnScreenListener;
    private final b onMoreClick;
    private b onMoreClickListener;
    private String scene;
    private boolean showNoMoreFooter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/recommend/RecommendViewAdapter$Companion;", "", "<init>", "()V", "NO_MORE_TEXT", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/recommend/RecommendViewAdapter$NoMoreFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "textView", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;)V", "getTextView", "()Landroid/widget/TextView;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NoMoreFooterViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public final TextView getTextView() {
            return this.textView;
        }

        public NoMoreFooterViewHolder(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "textView");
            super(r2);
            this.textView = r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void grayTitleColor() {
        this.grayTitleColor = true;
    }

    public final void normalRoundHeader() {
        this.normalRoundHeader = true;
    }

    public int getItemCount() {
        return ((LarkRecyclerViewBaseAdapter) this).items.size() + (this.showNoMoreFooter ? 1 : 0);
    }

    public final boolean getMBindTagWithDynamicTag() {
        return this.mBindTagWithDynamicTag;
    }

    public final f getOnClearHistoryListener() {
        return this.onClearHistoryListener;
    }

    public final h getOnItemOnScreenListener() {
        return this.onItemOnScreenListener;
    }

    public final b getOnMoreClickListener() {
        return this.onMoreClickListener;
    }

    public final String getScene() {
        return this.scene;
    }

    public final boolean isEnableChatPreview() {
        return this.isEnableChatPreview;
    }

    private final boolean isNoMoreFooterPosition(int r2) {
        if (this.showNoMoreFooter == true) goto L5;
    L7:
        return false;
    L5:
        if (r2 != ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L7;
        return true;
    }

    public long getHeaderId(int r3) {
        if (isNoMoreFooterPosition(r3) == false) goto L10;
        SearchBaseInfo r4 = (SearchBaseInfo) CollectionsKt.lastOrNull(((LarkRecyclerViewBaseAdapter) this).items);
        if (r4 != null) goto L11;
        return Long.MIN_VALUE;
    L11:
        return r4.getHeaderId();
    L10:
        return ((SearchBaseInfo) getItem(r3)).getHeaderId();
    }

    public long getItemId(int r3) {
        if (isNoMoreFooterPosition(r3) == false) goto L6;
        return Long.MIN_VALUE;
    L6:
        return super.getItemId(r3);
    }

    public int getItemViewType(int r4) {
        if (isNoMoreFooterPosition(r4) == false) goto L7;
        return 49;
    L7:
        return this.mBinderRepo.resolveItemViewType((SearchBaseInfo) getItem(r4), r4, -1);
    }

    @Override // com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter
    public String getTopNRptId(int r2) {
        if (isNoMoreFooterPosition(r2) == false) goto L7;
        return null;
    L7:
        return ((SearchBaseInfo) getItem(r2)).getId();
    }

    @Override // com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter, com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionAdapter
    public boolean isItemSelectable(int r4) {
        if (isNoMoreFooterPosition(r4) == false) goto L5;
        return false;
    L5:
        int r5 = getItemViewType(r4);
        if (r5 == 0) goto L26;
        if (r5 == 1) goto L26;
        if (r5 == 5) goto L26;
        if (r5 == 6) goto L26;
        if (r5 == 7) goto L26;
        if (r5 == 9) goto L26;
        if (r5 == 10) goto L26;
        if (r5 == 15) goto L26;
        if (r5 == 29) goto L26;
        if (r5 == 45) goto L26;
        switch(r5) {
            case 33: goto L26;
            case 34: goto L26;
            case 35: goto L26;
            default: goto L25;
        };
    L25:
        return false;
    L26:
        return true;
    }

    /* JADX INFO: renamed from: onCreateHeaderViewHolder, reason: collision with other method in class */
    public RecommendHeaderViewHolder m3366onCreateHeaderViewHolder(ViewGroup r4) {
        if (r4 == null) goto L4;
        Context r0 = r4.getContext();
    L5:
        View r5 = LayoutInflater.from(r0).inflate(2131561571, r4, false);
        Intrinsics.checkNotNull(r5);
        return new RecommendHeaderViewHolder(r5);
    L4:
        r0 = null;
        goto L5
    }

    public final void registerCustomBinders(Map<Integer, ? extends CommonBinder<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinders");
        this.mBinderRepo.registerCustomBinders(r2);
        notifyDataSetChanged();
    }

    public final void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinder");
        this.customBinder = r2;
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

    public final void setEnableChatPreview(final boolean r3) {
        this.isEnableChatPreview = r3;
        this.mBinderRepo.custom(new AnonymousClass1(r3));
    }

    public final void setMBindTagWithDynamicTag(final boolean r3) {
        this.mBindTagWithDynamicTag = r3;
        this.mBinderRepo.custom(new RecommendViewAdapter$mBindTagWithDynamicTag$1(r3));
    }

    public final void setOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r2) {
        this.mBinderRepo.setOnBusinessConsumeItem(r2);
    }

    public final void setOnClearHistoryListener(f r1) {
        this.onClearHistoryListener = r1;
    }

    public final void setOnItemOnScreenListener(h r1) {
        this.onItemOnScreenListener = r1;
    }

    public final void setOnMoreClickListener(b r1) {
        this.onMoreClickListener = r1;
    }

    public final void setProfileClickListener(IOnProfileClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mBinderRepo.setProfileClickListener(r2);
    }

    public final void setScene(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        this.scene = r3;
        this.mBinderRepo.custom(new RecommendViewAdapter$scene$1(r3));
    }

    public final void setShowNoMoreFooter(boolean r2) {
        if (this.showNoMoreFooter != r2) goto L5;
        return;
    L5:
        this.showNoMoreFooter = r2;
        notifyDataSetChanged();
    }

    public final void setSingleChoiceMode(boolean r2) {
        this.mBinderRepo.setSingleChoiceMode(r2);
        notifyDataSetChanged();
    }

    public final void showDivider(boolean r1) {
        this.mShowDivider = r1;
        notifyDataSetChanged();
    }

    public final void switchMultiple(boolean r2) {
        this.mBinderRepo.switchMultiple(r2);
        notifyDataSetChanged();
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup r1) {
        return m3366onCreateHeaderViewHolder(r1);
    }

    public void onBindHeaderViewHolder(RecommendHeaderViewHolder r4, int r5) {
        if (isNoMoreFooterPosition(r5) == false) goto L5;
        SearchBaseInfo r6 = (SearchBaseInfo) CollectionsKt.lastOrNull(((LarkRecyclerViewBaseAdapter) this).items);
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (this.grayTitleColor == false) goto L14;
        if (r4 == null) goto L18;
        TextView r0 = r4.getTitle();
        if (r0 == null) goto L18;
        r0.setTextColor(y9c.d.c(this.context, 2131106607));
    L18:
        if (r4 == null) goto L22;
        TextView r1 = r4.getTitle();
        if (r1 == null) goto L22;
        r1.setText(r6.getHeaderLabel());
    L22:
        if (r4 == null) goto L26;
        ImageView r7 = r4.getMore();
        if (r7 == null) goto L26;
        r7.setVisibility(8);
    L26:
        if (r4 == null) goto L35;
        View r8 = ((RecyclerView.ViewHolder) r4).itemView;
        if (r8 != null) goto L30;
        return;
    L30:
        if (this.normalRoundHeader == false) goto L32;
        Drawable r9 = y9c.d.e(r8.getContext(), 2131238335);
    L33:
        r8.setBackground(r9);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r8.setPadding(y9c.d.a(16), y9c.d.a(12), y9c.d.a(16), y9c.d.a(12));
        return;
    L32:
        r9 = y9c.d.e(r8.getContext(), 2131100548);
        goto L33
    L35:
        return;
    L14:
        if (r4 == null) goto L18;
        TextView r2 = r4.getTitle();
        if (r2 == null) goto L18;
        r2.setTextColor(y9c.d.c(this.context, 2131106622));
        goto L18
    L5:
        r6 = (SearchBaseInfo) getItem(r5);
        goto L6
    }

    @Override // com.ss.android.lark.picker.base.view.SearchRecyclerViewBaseAdapter
    public void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onBindViewHolder(r4, r5);
        if ((r4 instanceof NoMoreFooterViewHolder) == false) goto L6;
        ((NoMoreFooterViewHolder) r4).getTextView().setText("");
        return;
    L6:
        SearchWikiSpaceInfo r0 = (SearchBaseInfo) getItem(r5);
        h r1 = this.onItemOnScreenListener;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        r1.a(r0, r4);
    L9:
        int r2 = getItemViewType(r5);
        IViewBinder r3 = this.mBinderRepo.getBinderForViewType(r2);
        boolean r6 = r3 instanceof BaseViewBinder;
        if (r6 == false) goto L20;
        if (r6 == false) goto L13;
        BaseViewBinder r7 = (BaseViewBinder) r3;
    L14:
        if (r7 == null) goto L20;
        if (r7.supports(r4) == false) goto L20;
        Intrinsics.checkNotNull(r0);
        r7.bind(r5, r0, r4);
        return;
    L13:
        r7 = null;
    L20:
        if ((r4 instanceof ChatterChatViewHolder) == false) goto L56;
        ChatterChatViewHolder r8 = (ChatterChatViewHolder) r4;
        r8.getAvatarItemView().getItem().resetAllViews();
        int r9 = r8.getItemType();
        if (r9 != 0) goto L24;
        ChatterBinder r10 = this.mBinderRepo.getChatterBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatterInfo");
        r10.bind(r5, (SearchChatterInfo) r0, r8, this.contentViewSizeProvider);
        return;
    L24:
        if (r9 != 1) goto L26;
        ChatBinder r11 = this.mBinderRepo.getChatBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchChatInfo");
        r11.bind(r5, (SearchChatInfo) r0, r4);
        return;
    L26:
        if (r9 != 5) goto L28;
        MessageBinder r12 = this.mBinderRepo.getMessageBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchMessageInfo");
        r12.bind(r5, (SearchMessageInfo) r0, r4);
        return;
    L28:
        if (r9 != 6) goto L30;
        CCMBinder r13 = this.mBinderRepo.getCcmBinder();
        Intrinsics.checkNotNull(r0);
        r13.bind(r5, r0, r4);
        return;
    L30:
        if (r9 != 7) goto L32;
        ThreadBinder r14 = this.mBinderRepo.getThreadBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchThreadInfo");
        r14.bind(r5, (SearchThreadInfo) r0, r4);
        return;
    L32:
        if (r9 != 9) goto L34;
        HelpDeskBinder r15 = this.mBinderRepo.getHelpDeskBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchHelpDeskInfo");
        r15.bind(r5, (SearchHelpDeskInfo) r0, r4);
        return;
    L34:
        if (r9 != 10) goto L36;
        OpenAppBinder r16 = this.mBinderRepo.getOpenAppBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchOpenAppInfo");
        r16.bind(r5, (SearchOpenAppInfo) r0, r4);
        return;
    L36:
        if (r9 != 15) goto L38;
        OpenSearchBinder r17 = this.mBinderRepo.getOpenSearchBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchOpenSearchInfo");
        r17.bind(r5, (SearchOpenSearchInfo) r0, r4);
        return;
    L38:
        if (r9 != 29) goto L40;
        MailContactBinder r18 = this.mBinderRepo.getMailContactBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchMailContactInfo");
        r18.bind(r5, (SearchMailContactInfo) r0, r4);
        return;
    L40:
        if (r9 == 45) goto L46;
        switch(r9) {
            case 33: goto L45;
            case 34: goto L44;
            case 35: goto L43;
            default: goto L75;
        };
    L43:
        WikiSpaceBinder r19 = this.mBinderRepo.getWikiSpaceBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo");
        r19.bind(r5, r0, r4);
        return;
    L44:
        ShieldP2PChatBinder r20 = this.mBinderRepo.getShieldP2PChatBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo");
        r20.bind(r5, (SearchShieldP2PChatInfo) r0, r4);
        return;
    L45:
        ReplyInThreadBinder r21 = this.mBinderRepo.getReplyInThreadBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo");
        r21.bind(r5, (SearchReplyInThreadInfo) r0, r4);
        return;
    L75:
        return;
    L46:
        AiKnowledgeBinder r22 = this.mBinderRepo.getAiKnowledgeBinder();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo");
        r22.bind(r5, (SearchAiKnowledgeInfo) r0, r4);
        return;
    L56:
        ICustomBinder r23 = this.customBinder;
        if (r23 == null) goto L59;
        Intrinsics.checkNotNull(r0);
        r23.onBindViewHolder(r4, r0, r5);
        return;
    L59:
        EmptyBinder r24 = this.mBinderRepo.getEmptyBuilder();
        Intrinsics.checkNotNull(r0);
        r24.bind(r5, r0, r4);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        IViewBinder r0 = this.mBinderRepo.getBinderForViewType(r9);
        if ((r0 instanceof CommonBinder) == false) goto L7;
        RecyclerView.ViewHolder r1 = ((CommonBinder) r0).createCustomViewHolder(r8, r9);
        if (r1 == null) goto L7;
        return r1;
    L7:
        if (r9 != 0) goto L9;
    L36:
        AvatarItemViewWithMask r10 = new AvatarItemViewWithMask(this.context, null, 0, 6, null);
        r10.showDivider(this.mShowDivider);
        ChatterChatViewHolder r2 = new ChatterChatViewHolder(r10, r9);
    L38:
        return r2;
    L9:
        if (r9 == 1) goto L36;
        if (r9 == 5) goto L36;
        if (r9 == 6) goto L36;
        if (r9 == 7) goto L36;
        if (r9 == 9) goto L36;
        if (r9 == 10) goto L36;
        if (r9 == 15) goto L36;
        if (r9 == 29) goto L36;
        if (r9 == 45) goto L36;
        if (r9 == 49) goto L35;
        switch(r9) {
            case 33: goto L36;
            case 34: goto L36;
            case 35: goto L34;
            default: goto L29;
        };
    L29:
        ICustomBinder r3 = this.customBinder;
        if (r3 == null) goto L40;
        RecyclerView.ViewHolder r11 = r3.onCreateViewHolder(r8, r9);
        if (r11 == null) goto L40;
        return r11;
    L40:
        return new SearchResultViewAdapter.EmptyViewHolder(new View(this.context));
    L34:
        AvatarItemViewWithMask r12 = new AvatarItemViewWithMask(this.context, null, 0, 6, null);
        r12.showDivider(this.mShowDivider);
        r2 = new ChatterChatViewHolder(r12, r9);
        goto L38
    L35:
        TextView r13 = new TextView(this.context);
        r13.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r13.setGravity(17);
        r13.setTextColor(y9c.d.c(r13.getContext(), 2131106607));
        r13.setPadding(0, y9c.d.a(12), 0, y9c.d.a(12));
        r13.setClickable(false);
        r13.setFocusable(false);
        r13.setText("");
        return new NoMoreFooterViewHolder(r13);
    }

    public /* bridge */ /* synthetic */ void onBindHeaderViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindHeaderViewHolder((RecommendHeaderViewHolder) r1, r2);
    }

    public RecommendViewAdapter(Context r9, g r10, d r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "onItemClickHandler");
        Intrinsics.checkNotNullParameter(r11, "contentViewSizeProvider");
        this.context = r9;
        this.contentViewSizeProvider = r11;
        this.mBinderRepo = new BinderRepo(r9, r10, null, null, 12, null);
        this.scene = "";
        this.onClearHistory = new RecommendViewAdapter$onClearHistory$1(this);
        this.onMoreClick = new RecommendViewAdapter$onMoreClick$1(this);
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
}
