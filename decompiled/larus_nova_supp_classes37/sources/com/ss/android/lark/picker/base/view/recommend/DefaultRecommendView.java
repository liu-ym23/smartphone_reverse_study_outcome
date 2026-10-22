package com.ss.android.lark.picker.base.view.recommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.ui.stickyheader.AnimationFixStickyRecyclerHeadersDecoration;
import com.larksuite.framework.ui.stickyheader.StickyRecyclerHeadersDecoration;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.picker.base.fg.PickerFgUtils;
import com.ss.android.lark.picker.base.utils.SearchCommonFgUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.IOnProfileClickListener;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionHelperKt;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionUIDependency;
import com.ss.android.lark.search.baseview.SearchPtrFooter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import v3c.b;
import v3c.f;
import v3c.g;
import v3c.h;
import y3c.a;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 ¦\u00012\u00020\u0001:\u0002¦\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020@H\u0002J#\u0010D\u001a\u00020@2\n\b\u0003\u0010E\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020@H\u0002J\u0018\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0002J\u000e\u0010N\u001a\u00020@2\u0006\u0010O\u001a\u00020/J\u0006\u0010P\u001a\u00020@J\u0006\u0010Q\u001a\u00020@J8\u0010R\u001a\u00020@2\b\b\u0002\u0010S\u001a\u00020\t2\b\b\u0002\u0010T\u001a\u00020\t2\b\b\u0002\u0010U\u001a\u00020\t2\b\b\u0002\u0010V\u001a\u00020\t2\b\b\u0002\u0010W\u001a\u00020\tJ \u0010X\u001a\u00020@2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010Z2\b\b\u0002\u0010W\u001a\u00020\tJ\u0016\u0010[\u001a\u00020@2\u000e\u0010Y\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010ZJ\u0014\u0010\\\u001a\u00020\t2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020!0ZJ\u001e\u0010^\u001a\u00020@2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020!0Z2\b\b\u0002\u0010`\u001a\u00020\tJ\u000e\u0010a\u001a\u00020@2\u0006\u0010b\u001a\u00020\tJ\u000e\u0010c\u001a\u00020@2\u0006\u0010d\u001a\u00020\tJ\u001e\u0010e\u001a\u00020@2\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030h0gJ\u000e\u0010i\u001a\u00020@2\u0006\u0010j\u001a\u00020kJ\u0010\u0010l\u001a\u00020@2\b\u0010m\u001a\u0004\u0018\u00010$J\u000e\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020\tJ\u0016\u0010p\u001a\u00020@2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001eJ\u0010\u0010r\u001a\u00020@2\b\u0010s\u001a\u0004\u0018\u00010&J\u000e\u0010t\u001a\u00020@2\u0006\u0010u\u001a\u00020\tJ\u0010\u0010v\u001a\u00020@2\b\u0010w\u001a\u0004\u0018\u00010xJ\u000e\u0010y\u001a\u00020@2\u0006\u0010z\u001a\u00020{J\b\u0010|\u001a\u00020@H\u0002J\u000e\u0010}\u001a\u00020@2\u0006\u0010z\u001a\u00020~J\u000f\u0010\u007f\u001a\u00020@2\u0007\u0010z\u001a\u00030\u0080\u0001J\u0010\u0010\u0081\u0001\u001a\u00020@2\u0007\u0010\u0081\u0001\u001a\u00020\tJ\u0010\u0010\u0082\u0001\u001a\u00020@2\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u0010\u0010\u0084\u0001\u001a\u00020@2\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u000f\u0010\u0085\u0001\u001a\u00020@2\u0006\u0010Y\u001a\u00020!J\u0007\u0010\u0086\u0001\u001a\u00020@J\u0007\u0010\u0087\u0001\u001a\u00020@J\u0010\u0010\u0089\u0001\u001a\u00020@2\u0007\u0010\u008a\u0001\u001a\u00020\tJ\u0007\u0010\u008b\u0001\u001a\u00020@J\u0012\u0010\u008c\u0001\u001a\u00020@2\t\u0010z\u001a\u0005\u0018\u00010\u008d\u0001J\u0010\u0010\u008e\u0001\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020\tJ\u0010\u0010\u0090\u0001\u001a\u00020@2\u0007\u0010\u0091\u0001\u001a\u00020\tJ\u0019\u0010\u0092\u0001\u001a\u00020@2\u0007\u0010\u0093\u0001\u001a\u00020\u00172\u0007\u0010\u0094\u0001\u001a\u00020\u0017J\u0010\u0010\u0095\u0001\u001a\u00020@2\u0007\u0010\u0096\u0001\u001a\u00020\tJ\u0010\u0010\u0097\u0001\u001a\u00020@2\u0007\u0010\u0098\u0001\u001a\u00020>J\u0013\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u0012\u0010\u009b\u0001\u001a\u0004\u0018\u00010!2\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u0007\u0010\u009c\u0001\u001a\u00020@J\u0007\u0010\u009d\u0001\u001a\u00020@J\u0007\u0010\u009e\u0001\u001a\u00020@J\t\u0010\u009f\u0001\u001a\u00020@H\u0002J\t\u0010 \u0001\u001a\u00020@H\u0002J\u0014\u0010¡\u0001\u001a\u00020\t2\t\b\u0002\u0010¢\u0001\u001a\u00020\u0017H\u0002J\u0014\u0010£\u0001\u001a\u00020@2\t\b\u0002\u0010¢\u0001\u001a\u00020\u0017H\u0002J\t\u0010¤\u0001\u001a\u00020@H\u0002J\t\u0010¥\u0001\u001a\u00020@H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006§\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/view/recommend/DefaultRecommendView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "isForSearch", "", "(Landroid/content/Context;Landroid/util/AttributeSet;Z)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mRecommendRv", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "recommendPtr", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "errorView", "Landroid/view/View;", "errorTextView", "Landroid/widget/TextView;", "loadingView", "consumeResultLayoutClickWhenEmpty", "customEmptyIconResId", "", "Ljava/lang/Integer;", "customEmptyHintText", "", "mRecommendAdapter", "Lcom/ss/android/lark/picker/base/view/recommend/RecommendViewAdapter;", "mRecommendDataLoadCallback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "mData", "Ljava/util/LinkedHashSet;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/LinkedHashSet;", "mDataPuller", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "mClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "mHeadersDecor", "Lcom/larksuite/framework/ui/stickyheader/StickyRecyclerHeadersDecoration;", "enableNoMoreFooter", "rvSkeletonScreen", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "itemHeight", "defaultItemCount", "mOnResultScroll", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnResultScroll;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "fgUtils", "Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "value", "mBindTagWithDynamicTag", "getMBindTagWithDynamicTag", "()Z", "setMBindTagWithDynamicTag", "(Z)V", "allowEmpty", "getAllowEmpty", "setAllowEmpty", "requestId", "", "enableKeyboardNavigation", "", "keyboardSelectionUIDependency", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionUIDependency;", "initView", "setRecommendEmptyViewConfig", "emptyIconResId", "emptyHintText", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "applyCustomEmptyConfigIfNeeded", "applyEmptyIconSizeByDrawable", "iconView", "Landroid/widget/ImageView;", "drawable", "Landroid/graphics/drawable/Drawable;", "setOnResultScroll", "onResultScroll", "showSkeleton", "hideSkeleton", "refresh", "withSkeleton", "withLoading", "enableError", "checkSequence", "scrollToTop", "resetContent", "data", "", "appendContent", "sameListContent", "newList", "refreshSelected", "selectedList", "forceNotifyDataSetChanged", "switchMultiple", "isMultiple", "setSingleChoiceMode", "isSingleChoice", "registerCustomBinders", "customBinders", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "setCustomBinder", "customBinder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "setDataPuller", "dataPuller", "setEnableNoMoreFooter", "enable", "setRecommendDataLoadCallback", "callback", "setClickHandler", "clickHandler", "setConsumeResultLayoutClickWhenEmpty", "consume", "setOnBusinessConsumeItem", "onBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "setProfileClickListener", "listener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "resetHeader", "setOnClearHistoryListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnClearHistoryListener;", "setOnMoreClickListener", "Lcom/ss/android/lark/search/dto/IOnMoreClickListener;", "showDivider", "notifyItemChange", "position", "removeItemAt", "removeItemByData", "onConfigurationChanged", "erasePadding", "mNeedLoadMore", "setNeedLoadMore", "needLoadMore", "normalRoundHeader", "setOnItemOnScreenListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "setEnableChatPreview", "isEnableChatPreview", "setDisableRightViewHolder", "disableRightViewHolder", "updateErrorView", "iv", "hint", "setDisableExtraInfoSummary", "disableExtraInfoSummary", "setScene", "scene", "getTargetViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getTargetData", "grayTitleColor", "bgBase", "bgBody", "showError", "hideError", "shouldShowNoMoreFooter", "dataSize", "updateNoMoreFooterVisibility", "showLoading", "hideLoading", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class DefaultRecommendView extends FrameLayout {
    public static final Companion Companion = null;
    private static final String FG_KEY_ENABLE_ANIMATION = "im.core.picker_enable_animation";
    private static final String TAG = "LarkSearch.Common.DefaultRecommendView";
    private boolean allowEmpty;
    private boolean consumeResultLayoutClickWhenEmpty;
    private CharSequence customEmptyHintText;
    private Integer customEmptyIconResId;
    private final int defaultItemCount;
    private boolean enableNoMoreFooter;
    private TextView errorTextView;
    private View errorView;
    private SearchCommonFgUtils fgUtils;
    private boolean isForSearch;
    private int itemHeight;
    private UDLoadingDrawable loadingDrawable;
    private View loadingView;
    private g mClickHandler;
    private LinkedHashSet<SearchBaseInfo> mData;
    private a mDataPuller;
    private StickyRecyclerHeadersDecoration mHeadersDecor;
    private boolean mNeedLoadMore;
    private SearchResultView.IOnResultScroll mOnResultScroll;
    private RecommendViewAdapter mRecommendAdapter;
    private IGetDataCallback<Boolean> mRecommendDataLoadCallback;
    private CommonRecyclerView mRecommendRv;
    private LKUIPtrClassicFrameLayout recommendPtr;
    private String requestId;
    private lt7.a rvSkeletonScreen;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/base/view/recommend/DefaultRecommendView$Companion;", "", "<init>", "()V", "TAG", "", "FG_KEY_ENABLE_ANIMATION", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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

    private final void applyCustomEmptyConfigIfNeeded() {
        if (this.errorView != null) goto L5;
        return;
    L5:
        Integer r0 = this.customEmptyIconResId;
        View r2 = null;
        TextView r3 = null;
        if (r0 == null) goto L22;
        int r1 = r0.intValue();
        View r4 = this.errorView;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
        r4 = null;
    L10:
        ImageView r5 = (ImageView) r4.findViewById(2131385419);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(AppCompatResources.getDrawable(getContext(), r1));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = null;
    L18:
        Drawable r8 = (Drawable) r7;
        if (r8 == null) goto L21;
        r5.setImageDrawable(r8);
        Intrinsics.checkNotNull(r5);
        applyEmptyIconSizeByDrawable(r5, r8);
        goto L22
    L21:
        r5.setImageResource(r1);
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        CharSequence r10 = this.customEmptyHintText;
        if (r10 == null) goto L38;
        TextView r11 = this.errorTextView;
        if (r11 == null) goto L30;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("errorTextView");
    L29:
        r3.setText(r10);
        return;
    L28:
        r3 = r11;
        goto L29
    L30:
        View r12 = this.errorView;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L34:
        ((TextView) r2.findViewById(2131385418)).setText(r10);
        return;
    L33:
        r2 = r12;
        goto L34
    }

    private final void hideError() {
        View r0 = this.errorView;
        ViewGroup r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        ViewGroup r2 = this.recommendPtr;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendPtr");
    L9:
        r1.setVisibility(0);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void hideLoading() {
        View r0 = this.loadingView;
        CircularProgressDrawable r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        ViewGroup r2 = this.recommendPtr;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendPtr");
        r2 = null;
    L8:
        r2.setVisibility(0);
        CircularProgressDrawable r3 = this.loadingDrawable;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L12:
        r1.stop();
        return;
    L11:
        r1 = r3;
        goto L12
    }

    private final void resetHeader() {
        a r0 = this.mDataPuller;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        RecyclerView r2 = this.mRecommendRv;
        RecyclerView r3 = null;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r2 = null;
    L13:
        if (r2.getItemDecorationCount() > 0) goto L15;
    L20:
        RecommendViewAdapter r4 = this.mRecommendAdapter;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r4 = null;
    L23:
        this.mHeadersDecor = new AnimationFixStickyRecyclerHeadersDecoration(r4);
        RecyclerView r5 = this.mRecommendRv;
        if (r5 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
    L27:
        StickyRecyclerHeadersDecoration r6 = this.mHeadersDecor;
        Intrinsics.checkNotNull(r6);
        r3.addItemDecoration(r6);
        return;
    L26:
        r3 = r5;
        goto L27
    L15:
        if (this.mHeadersDecor == null) goto L20;
        RecyclerView r7 = this.mRecommendRv;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r7 = null;
    L19:
        StickyRecyclerHeadersDecoration r8 = this.mHeadersDecor;
        Intrinsics.checkNotNull(r8);
        r7.removeItemDecoration(r8);
        goto L20
    L5:
        if (r0.needHeader() == true) goto L7;
        r1 = true;
        goto L7
    }

    private final void showError() {
        ViewGroup r0 = this.recommendPtr;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recommendPtr");
        r0 = null;
    L5:
        r0.setVisibility(8);
        if (PickerFgUtils.INSTANCE.isSearchEnableForseti() == false) goto L10;
        Lazy r2 = ForsetiConfig.a;
        if (ForsetiConfig.a(getContext()) == false) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return;
    L13:
        if (this.customEmptyIconResId == null) goto L22;
        View r4 = this.errorView;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
        r4 = null;
    L17:
        r4.setVisibility(4);
        View r5 = this.errorView;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L21:
        d.l(r1, true);
        return;
    L20:
        r1 = r5;
        goto L21
    L22:
        View r6 = this.errorView;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
        r6 = null;
    L25:
        r6.setVisibility(0);
        View r7 = this.errorView;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L29:
        d.k(r1);
        return;
    L28:
        r1 = r7;
    L10:
        r3 = false;
        goto L11
    }

    private final void showLoading() {
        View r0 = this.loadingView;
        CircularProgressDrawable r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        r0 = null;
    L5:
        r0.setVisibility(0);
        ViewGroup r2 = this.recommendPtr;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendPtr");
        r2 = null;
    L8:
        r2.setVisibility(8);
        CircularProgressDrawable r3 = this.loadingDrawable;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r3 = null;
    L11:
        r3.stop();
        CircularProgressDrawable r4 = this.loadingDrawable;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L15:
        r1.start();
        return;
    L14:
        r1 = r4;
        goto L15
    }

    public final boolean getMBindTagWithDynamicTag() {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L6:
        return r0.getMBindTagWithDynamicTag();
    }

    public final void grayTitleColor() {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.grayTitleColor();
    }

    public final void hideSkeleton() {
        ViewGroup r0 = this.mRecommendRv;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r0 = null;
    L5:
        r0.post(new AnonymousClass1(this));
    }

    public final void normalRoundHeader() {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.normalRoundHeader();
    }

    public final void onConfigurationChanged() {
        RecyclerView.Adapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.notifyDataSetChanged();
    }

    public final void showSkeleton() {
        ViewGroup r0 = this.mRecommendRv;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r0 = null;
    L5:
        r0.post(new RunnableC03351(this));
    }

    private final void initView() {
        setBackgroundColor(getResources().getColor(2131100545));
        setOnTouchListener(new ViewOnTouchListenerC03341(this));
        final CommonRecyclerView r0 = findViewById(2131383958);
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext(), 1, false));
        RecommendViewAdapter r1 = new RecommendViewAdapter(r0.getContext(), new DefaultRecommendView$initView$2$1(this), new DefaultRecommendView$initView$2$2(r0));
        r0.setAdapter(r1);
        this.mRecommendAdapter = r1;
        r0.addOnScrollListener(new DefaultRecommendView$initView$2$4(this));
        Drawable r2 = null;
        if (this.fgUtils.isEnable(FG_KEY_ENABLE_ANIMATION) == true) goto L5;
        r0.setItemAnimator(null);
    L5:
        this.mRecommendRv = r0;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r0 = null;
    L8:
        this.itemHeight = UIUtils.dp2px(r0.getContext(), 66.0f);
        final LKUIPtrClassicFrameLayout r3 = findViewById(2131383955);
        SearchPtrFooter r4 = new SearchPtrFooter(r3.getContext());
        r3.setKeepHeaderWhenRefresh(true);
        r3.setFooterView(r4);
        r3.addPtrUIHandler(r4);
        r3.disableWhenHorizontalMove(true);
        r3.setForceBackWhenComplete(true);
        r3.setEnableScrollContentAfterLoad(true);
        r3.setPtrHandler(new DefaultRecommendView$initView$3$1(this, r3));
        this.recommendPtr = r3;
        this.errorView = findViewById(2131385568);
        this.errorTextView = (TextView) findViewById(2131385418);
        this.loadingView = findViewById(2131379091);
        UDLoadingDrawable r5 = new UDLoadingDrawable(getContext());
        r5.setColorSchemeColors(new int[]{d.c(getContext(), 2131105568)});
        this.loadingDrawable = r5;
        ImageView r6 = (ImageView) findViewById(2131379044);
        Drawable r7 = this.loadingDrawable;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L12:
        r6.setImageDrawable(r2);
        applyCustomEmptyConfigIfNeeded();
        return;
    L11:
        r2 = r7;
        goto L12
    }

    public final void bgBase() {
        findViewById(2131383946).setBackgroundColor(d.c(getContext(), 2131100545));
    }

    public final void bgBody() {
        findViewById(2131383946).setBackgroundColor(d.c(getContext(), 2131100548));
    }

    public final void erasePadding() {
        findViewById(2131383946).setPadding(0, 0, 0, 0);
    }

    public final boolean getAllowEmpty() {
        return this.allowEmpty;
    }

    public DefaultRecommendView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ boolean access$getConsumeResultLayoutClickWhenEmpty$p(DefaultRecommendView r0) {
        return r0.consumeResultLayoutClickWhenEmpty;
    }

    public static final /* synthetic */ int access$getDefaultItemCount$p(DefaultRecommendView r0) {
        return r0.defaultItemCount;
    }

    public static final /* synthetic */ View access$getErrorView$p(DefaultRecommendView r0) {
        return r0.errorView;
    }

    public static final /* synthetic */ int access$getItemHeight$p(DefaultRecommendView r0) {
        return r0.itemHeight;
    }

    public static final /* synthetic */ g access$getMClickHandler$p(DefaultRecommendView r0) {
        return r0.mClickHandler;
    }

    public static final /* synthetic */ a access$getMDataPuller$p(DefaultRecommendView r0) {
        return r0.mDataPuller;
    }

    public static final /* synthetic */ boolean access$getMNeedLoadMore$p(DefaultRecommendView r0) {
        return r0.mNeedLoadMore;
    }

    public static final /* synthetic */ SearchResultView.IOnResultScroll access$getMOnResultScroll$p(DefaultRecommendView r0) {
        return r0.mOnResultScroll;
    }

    public static final /* synthetic */ IGetDataCallback access$getMRecommendDataLoadCallback$p(DefaultRecommendView r0) {
        return r0.mRecommendDataLoadCallback;
    }

    public static final /* synthetic */ CommonRecyclerView access$getMRecommendRv$p(DefaultRecommendView r0) {
        return r0.mRecommendRv;
    }

    public static final /* synthetic */ String access$getRequestId$p(DefaultRecommendView r0) {
        return r0.requestId;
    }

    public static final /* synthetic */ lt7.a access$getRvSkeletonScreen$p(DefaultRecommendView r0) {
        return r0.rvSkeletonScreen;
    }

    public static final /* synthetic */ void access$hideLoading(DefaultRecommendView r0) {
        r0.hideLoading();
    }

    public static final /* synthetic */ void access$showError(DefaultRecommendView r0) {
        r0.showError();
    }

    private final boolean shouldShowNoMoreFooter(int r3) {
        if (this.enableNoMoreFooter == false) goto L14;
        if (r3 <= 0) goto L15;
        a r4 = this.mDataPuller;
        if (r4 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L16;
        return true;
    L16:
        return false;
    L8:
        if (r4.canLoadMore() == true) goto L10;
        r5 = true;
        goto L11
    L15:
        return false;
    L14:
        return false;
    }

    private final void updateNoMoreFooterVisibility(int r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L6:
        r0.setShowNoMoreFooter(shouldShowNoMoreFooter(r2));
        return;
    }

    public final void appendContent(List<? extends SearchBaseInfo> r6) {
        if (r6 == null) goto L11;
        int r0 = this.mData.size();
        List<? extends SearchBaseInfo> r2 = r6;
        this.mData.addAll(r2);
        RecommendViewAdapter r1 = this.mRecommendAdapter;
        RecyclerView.Adapter r3 = null;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r1 = null;
    L6:
        r1.getItems().addAll(r2);
        RecyclerView.Adapter r4 = this.mRecommendAdapter;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
    L10:
        r3.notifyItemRangeInserted(r0, r6.size());
        goto L11
    L9:
        r3 = r4;
    L11:
        updateNoMoreFooterVisibility(this.mData.size());
    }

    public final void enableKeyboardNavigation(KeyboardSelectionUIDependency r4) {
        Intrinsics.checkNotNullParameter(r4, "keyboardSelectionUIDependency");
        RecyclerView r0 = this.mRecommendRv;
        RecommendViewAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r0 = null;
    L5:
        RecommendViewAdapter r2 = this.mRecommendAdapter;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
    L9:
        KeyboardSelectionHelperKt.enableKeyboardNavigation(r0, r1, r4.onBindEditText());
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final SearchBaseInfo getTargetData(int r4) {
        RecommendViewAdapter r0 = null;
        if (r4 <= 0) goto L15;
        RecommendViewAdapter r1 = this.mRecommendAdapter;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r1 = null;
    L8:
        if (r4 >= r1.getItems().size()) goto L16;
        RecommendViewAdapter r2 = this.mRecommendAdapter;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
    L14:
        return (SearchBaseInfo) ListProtector.get(r0.getItems(), r4);
    L12:
        r0 = r2;
        goto L14
    L16:
        return null;
    L15:
        return null;
    }

    public final RecyclerView.ViewHolder getTargetViewHolder(int r3) {
        RecyclerView r0 = null;
        if (r3 <= 0) goto L15;
        RecommendViewAdapter r1 = this.mRecommendAdapter;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r1 = null;
    L8:
        if (r3 >= r1.getItems().size()) goto L16;
        RecyclerView r2 = this.mRecommendRv;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
    L14:
        return r0.findViewHolderForAdapterPosition(r3);
    L12:
        r0 = r2;
        goto L14
    L16:
        return null;
    L15:
        return null;
    }

    public final void notifyItemChange(int r2) {
        RecyclerView.Adapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.notifyItemChanged(r2);
    }

    public final void registerCustomBinders(Map<Integer, ? extends CommonBinder<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinders");
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.registerCustomBinders(r2);
    }

    public final void removeItemAt(int r5) {
        if (r5 < 0) goto L17;
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        RecyclerView.Adapter r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L7:
        if (r5 >= r0.getItems().size()) goto L18;
        RecommendViewAdapter r2 = this.mRecommendAdapter;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r2 = null;
    L11:
        this.mData.remove((SearchBaseInfo) ListProtector.remove(r2.getItems(), r5));
        RecyclerView.Adapter r3 = this.mRecommendAdapter;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
    L15:
        r1.notifyItemRemoved(r5);
        updateNoMoreFooterVisibility(this.mData.size());
        return;
    L14:
        r1 = r3;
        goto L15
    L18:
        return;
    }

    public final void removeItemByData(SearchBaseInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        List r0 = CollectionsKt.toMutableList(this.mData);
        if (r0.remove(r4) == false) goto L6;
        resetContent$default(this, r0, false, 2, null);
        return;
    }

    public final boolean sameListContent(List<? extends SearchBaseInfo> r9) {
        Intrinsics.checkNotNullParameter(r9, "newList");
        LinkedHashSet<SearchBaseInfo> r0 = this.mData;
        if (r0 != r9) goto L6;
        return true;
    L6:
        if (r0.size() == r9.size()) goto L8;
        return false;
    L8:
        Iterator<T> r1 = this.mData.iterator();
        int r2 = 0;
    L10:
        if (r1.hasNext() == false) goto L21;
        int r4 = r2 + 1;
        SearchBaseInfo r5 = (SearchBaseInfo) r1.next();
        if (Intrinsics.areEqual(r5, ListProtector.get(r9, r2)) == false) goto L20;
        if (Intrinsics.areEqual(r5.getSession(), ((SearchBaseInfo) ListProtector.get(r9, r2)).getSession()) == true) goto L17;
        r5.setSession(((SearchBaseInfo) ListProtector.get(r9, r2)).getSession());
    L17:
        if (Intrinsics.areEqual(r5.getImprId(), ((SearchBaseInfo) ListProtector.get(r9, r2)).getImprId()) == true) goto L19;
        r5.setImprId(((SearchBaseInfo) ListProtector.get(r9, r2)).getImprId());
    L19:
        r2 = r4;
        goto L10
    L20:
        return false;
    L21:
        return true;
    }

    public final void setAllowEmpty(boolean r1) {
        this.allowEmpty = r1;
    }

    public final void setClickHandler(g r1) {
        this.mClickHandler = r1;
    }

    public final void setConsumeResultLayoutClickWhenEmpty(boolean r1) {
        this.consumeResultLayoutClickWhenEmpty = r1;
    }

    public final void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinder");
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setCustomBinder(r2);
    }

    public final void setDataPuller(a r1) {
        this.mDataPuller = r1;
        updateNoMoreFooterVisibility(this.mData.size());
    }

    public final void setDisableExtraInfoSummary(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setDisableExtraInfoSummary(r2);
    }

    public final void setDisableRightViewHolder(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setDisableRightViewHolder(r2);
    }

    public final void setEnableChatPreview(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setEnableChatPreview(r2);
    }

    public final void setEnableNoMoreFooter(boolean r1) {
        this.enableNoMoreFooter = r1;
        updateNoMoreFooterVisibility(this.mData.size());
    }

    public final void setMBindTagWithDynamicTag(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setMBindTagWithDynamicTag(r2);
    }

    public final void setNeedLoadMore(boolean r1) {
        this.mNeedLoadMore = r1;
    }

    public final void setOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setOnBusinessConsumeItem(r2);
    }

    public final void setOnClearHistoryListener(f r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setOnClearHistoryListener(r2);
    }

    public final void setOnItemOnScreenListener(h r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setOnItemOnScreenListener(r2);
    }

    public final void setOnMoreClickListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setOnMoreClickListener(r2);
    }

    public final void setOnResultScroll(SearchResultView.IOnResultScroll r2) {
        Intrinsics.checkNotNullParameter(r2, "onResultScroll");
        this.mOnResultScroll = r2;
    }

    public final void setProfileClickListener(IOnProfileClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setProfileClickListener(r2);
    }

    public final void setRecommendDataLoadCallback(IGetDataCallback<Boolean> r1) {
        this.mRecommendDataLoadCallback = r1;
    }

    public final void setScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setScene(r2);
    }

    public final void setSingleChoiceMode(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.setSingleChoiceMode(r2);
    }

    public final void showDivider(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.showDivider(r2);
    }

    public final void switchMultiple(boolean r2) {
        RecommendViewAdapter r0 = this.mRecommendAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r0 = null;
    L5:
        r0.switchMultiple(r2);
    }

    public DefaultRecommendView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.mData = new LinkedHashSet();
        this.defaultItemCount = 15;
        this.fgUtils = new SearchCommonFgUtils();
        this.requestId = "";
        this.mNeedLoadMore = true;
        LayoutInflater.from(r2).inflate(2131568154, this, true);
        initView();
    }

    public static final /* synthetic */ void access$setRvSkeletonScreen$p(DefaultRecommendView r0, lt7.a r1) {
        r0.rvSkeletonScreen = r1;
    }

    private final void applyEmptyIconSizeByDrawable(ImageView r4, Drawable r5) {
        int r0 = r5.getIntrinsicWidth();
        int r6 = r5.getIntrinsicHeight();
        if (r0 <= 0) goto L19;
        if (r6 <= 0) goto L21;
        int r1 = UIUtils.dp2px(r4.getContext(), 100.0f);
        int r2 = Math.max(r0, r6);
        if (r2 <= r1) goto L9;
        float r3 = r1 / r2;
    L10:
        int r7 = Math.max(1, MathKt.roundToInt(r0 * r3));
        int r8 = Math.max(1, MathKt.roundToInt(r6 * r3));
        r4.setAdjustViewBounds(true);
        r4.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
        if (r9 != null) goto L14;
        return;
    L14:
        if (r9.width == r7) goto L16;
    L17:
        r9.width = r7;
        r9.height = r8;
        r4.setLayoutParams(r9);
        return;
    L16:
        if (r9.height != r8) goto L17;
        return;
    L9:
        r3 = 1.0f;
        goto L10
    L21:
        return;
    }

    public final void refreshSelected(List<? extends SearchBaseInfo> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "selectedList");
        Iterator<SearchBaseInfo> r0 = this.mData.iterator();
    L4:
        if (r0.hasNext() == false) goto L31;
        SearchBaseInfo r1 = r0.next();
        RecommendViewAdapter r4 = null;
        if (r1.isSelected() == r7.contains(r1)) goto L18;
        r1.selected(r7.contains(r1));
        if (r8 == false) goto L13;
        RecyclerView.Adapter r2 = this.mRecommendAdapter;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r2 = null;
    L12:
        r2.notifyDataSetChanged();
        goto L18
    L13:
        RecommendViewAdapter r3 = this.mRecommendAdapter;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r3 = null;
    L16:
        r3.notifyItemChanged(r1);
    L18:
        if (r1.isSingleChoice() == r7.contains(r1)) goto L4;
        r1.setSingleChoice(r7.contains(r1));
        if (r8 == true) goto L21;
        RecommendViewAdapter r5 = this.mRecommendAdapter;
        if (r5 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
    L30:
        r4.notifyItemChanged(r1);
        goto L4
    L29:
        r4 = r5;
        goto L30
    L21:
        RecommendViewAdapter r6 = this.mRecommendAdapter;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
    L25:
        r4.notifyDataSetChanged();
        goto L4
    L24:
        r4 = r6;
        goto L25
    }

    public final void resetContent(List<? extends SearchBaseInfo> r6, boolean r7) {
        if (this.allowEmpty == true) goto L14;
        List<? extends SearchBaseInfo> r0 = r6;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L14;
        updateNoMoreFooterVisibility(0);
        return;
    L7:
        if (r0.isEmpty() == true) goto L10;
        r1 = false;
    L14:
        if (r6 != null) goto L17;
        r6 = CollectionsKt.emptyList();
    L17:
        if (sameListContent(r6) == false) goto L20;
        updateNoMoreFooterVisibility(r6.size());
        return;
    L20:
        LinkedHashSet<SearchBaseInfo> r2 = this.mData;
        r2.clear();
        r2.addAll(r6);
        RecommendViewAdapter r8 = this.mRecommendAdapter;
        RecyclerView r3 = null;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendAdapter");
        r8 = null;
    L23:
        r8.diff(r2, DefaultRecommendView$resetContent$1$1.INSTANCE);
        if (this.fgUtils.isEnable(FG_KEY_ENABLE_ANIMATION) == true) goto L35;
        if (r7 == false) goto L35;
        if ((!r2.isEmpty()) == false) goto L35;
        RecyclerView r9 = this.mRecommendRv;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
    L32:
        RecyclerView.LayoutManager r10 = r3.getLayoutManager();
        if (r10 == null) goto L35;
        r10.scrollToPosition(0);
        goto L35
    L31:
        r3 = r9;
    L35:
        updateNoMoreFooterVisibility(this.mData.size());
    }

    public final void setRecommendEmptyViewConfig(Integer r1, CharSequence r2) {
        this.customEmptyIconResId = r1;
        this.customEmptyHintText = r2;
        applyCustomEmptyConfigIfNeeded();
    }

    public final void updateErrorView(int r5, int r6) {
        View r0 = this.errorView;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
        r0 = null;
    L5:
        ImageView r2 = (ImageView) r0.findViewById(2131385419);
        View r3 = this.errorView;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("errorView");
    L9:
        TextView r4 = (TextView) r1.findViewById(2131385418);
        r2.setImageResource(r5);
        r4.setText(r6);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    public DefaultRecommendView(Context r2, AttributeSet r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.mData = new LinkedHashSet();
        this.defaultItemCount = 15;
        this.fgUtils = new SearchCommonFgUtils();
        this.requestId = "";
        this.mNeedLoadMore = true;
        this.isForSearch = r4;
        LayoutInflater.from(r2).inflate(2131568154, this, true);
        initView();
    }

    public static /* synthetic */ boolean shouldShowNoMoreFooter$default(DefaultRecommendView r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.mData.size();
    L7:
        return r0.shouldShowNoMoreFooter(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shouldShowNoMoreFooter");
    }

    public static /* synthetic */ void updateNoMoreFooterVisibility$default(DefaultRecommendView r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.mData.size();
    L6:
        r0.updateNoMoreFooterVisibility(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateNoMoreFooterVisibility");
    }

    public static /* synthetic */ void refreshSelected$default(DefaultRecommendView r0, List r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.refreshSelected(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshSelected");
    }

    public static /* synthetic */ void resetContent$default(DefaultRecommendView r0, List r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.resetContent(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetContent");
    }

    public static /* synthetic */ void setRecommendEmptyViewConfig$default(DefaultRecommendView r1, Integer r2, CharSequence r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = null;
    L7:
        if ((r4 & 2) == 0) goto L9;
        r3 = null;
    L9:
        r1.setRecommendEmptyViewConfig(r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRecommendEmptyViewConfig");
    }

    public final void refresh(final boolean r11, final boolean r12, final boolean r13, final boolean r14, final boolean r15) {
        resetHeader();
        final String r4 = UUID.randomUUID().toString();
        this.requestId = r4;
        if (r11 == true) goto L6;
        if (r12 == true) goto L6;
        if (r13 == true) goto L6;
    L10:
        a r0 = this.mDataPuller;
        if (r0 == null) goto L20;
        if (r13 == false) goto L14;
        hideError();
    L14:
        if (r11 == false) goto L16;
        showSkeleton();
    L16:
        if (r12 == false) goto L18;
        showLoading();
    L18:
        r0.loadData(new AnonymousClass2(r14, this, r4, r11, r12, r15, r13));
        return;
    L20:
        return;
    L6:
        RecyclerView r1 = this.mRecommendRv;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRecommendRv");
        r1 = null;
    L9:
        r1.setItemAnimator(null);
        goto L10
    }

    public static /* synthetic */ void refresh$default(DefaultRecommendView r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, Object r8) {
        if (r8 != null) goto L21;
        if ((r7 & 1) == 0) goto L7;
        r2 = false;
    L7:
        if ((r7 & 2) == 0) goto L10;
        r3 = false;
    L10:
        if ((r7 & 4) == 0) goto L13;
        r4 = false;
    L13:
        if ((r7 & 8) == 0) goto L16;
        r5 = false;
    L16:
        if ((r7 & 16) == 0) goto L18;
        r6 = false;
    L18:
        r1.refresh(r2, r3, r4, r5, r6);
        return;
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refresh");
    }
}
