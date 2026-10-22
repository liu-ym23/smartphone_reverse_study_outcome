package com.ss.android.lark.picker.base.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.utils.DataUpdateHelper;
import com.ss.android.lark.picker.base.utils.EmptyViewManager;
import com.ss.android.lark.picker.base.utils.PrivateDescriptionHelper;
import com.ss.android.lark.picker.base.view.binder.CommonBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomBinder;
import com.ss.android.lark.picker.base.view.binder.ICustomViewTypeResolver;
import com.ss.android.lark.picker.base.view.binder.IOnProfileClickListener;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionHelperKt;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionUIDependency;
import com.ss.android.lark.search.baseview.SearchPtrFooter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchFileInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lt7.a;
import v3c.g;
import y9c.d;
import zdc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 »\u00012\u00020\u00012\u00020\u0002:\u0016»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010M\u001a\u00020JH\u0002J#\u0010N\u001a\u00020J2\n\b\u0003\u0010O\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q¢\u0006\u0002\u0010RJ\u000e\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020UJ\b\u0010V\u001a\u00020JH\u0002J\b\u0010W\u001a\u00020JH\u0002J\u0014\u0010X\u001a\u00020J2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020&0ZJ\u0016\u0010[\u001a\u00020J2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020&0ZH\u0002J\u0014\u0010\\\u001a\u00020J2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020&0ZJ\u0016\u0010]\u001a\u00020J2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020&0ZH\u0002J\u001e\u0010^\u001a\u00020J2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020&0Z2\b\b\u0002\u0010`\u001a\u00020#J\b\u0010a\u001a\u00020JH\u0002J\b\u0010b\u001a\u00020JH\u0002J\u0006\u0010c\u001a\u00020JJ\u0010\u0010c\u001a\u00020J2\b\b\u0002\u0010d\u001a\u00020#J\u000e\u0010e\u001a\u00020J2\u0006\u0010f\u001a\u000206J \u0010g\u001a\u00020J2\u0006\u0010h\u001a\u00020Q2\u0010\b\u0002\u0010i\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IJ\u0006\u0010j\u001a\u00020JJ\u0006\u0010k\u001a\u00020JJ\u0006\u0010l\u001a\u00020JJ\u000e\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020)J\u000e\u0010o\u001a\u00020J2\u0006\u0010p\u001a\u00020#J\u000e\u0010q\u001a\u00020J2\u0006\u0010r\u001a\u00020)J\u0010\u0010s\u001a\u00020J2\b\u0010t\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010u\u001a\u00020J2\u0006\u0010v\u001a\u00020\u001fJ\u000e\u0010w\u001a\u00020J2\u0006\u0010x\u001a\u00020!J\u0006\u0010y\u001a\u00020JJ\u0006\u0010z\u001a\u00020)J\u000e\u0010|\u001a\u00020J2\u0006\u0010}\u001a\u00020#J\u0010\u0010\u0080\u0001\u001a\u00020J2\u0007\u0010\u0081\u0001\u001a\u00020\u007fJ\u0011\u0010\u0082\u0001\u001a\u00020J2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001J\u0010\u0010\u0085\u0001\u001a\u00020J2\u0007\u0010\u0086\u0001\u001a\u00020#J\u0011\u0010\u0087\u0001\u001a\u00020J2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0010\u0010\u008a\u0001\u001a\u00020J2\u0007\u0010\u008b\u0001\u001a\u00020#J\u0010\u0010\u008c\u0001\u001a\u00020J2\u0007\u0010\u008d\u0001\u001a\u00020#J\u0010\u0010\u008e\u0001\u001a\u00020J2\u0007\u0010\u008f\u0001\u001a\u00020#J\u0010\u0010\u0090\u0001\u001a\u00020J2\u0007\u0010\u0091\u0001\u001a\u00020#J\"\u0010\u0092\u0001\u001a\u00020J2\u0019\u0010\u0093\u0001\u001a\u0014\u0012\u0004\u0012\u00020)\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0095\u00010\u0094\u0001J\u0010\u0010\u0096\u0001\u001a\u00020J2\u0007\u0010\u0096\u0001\u001a\u00020#J\u0010\u0010\u0097\u0001\u001a\u00020J2\u0007\u0010\u0097\u0001\u001a\u00020#J\u0011\u0010\u0098\u0001\u001a\u00020J2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\u0019\u0010\u009b\u0001\u001a\u00020J2\u0010\u0010\u009c\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010ZJ\u0013\u0010\u009e\u0001\u001a\u00020J2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001J\u0011\u0010¡\u0001\u001a\u00020J2\b\u0010¢\u0001\u001a\u00030£\u0001J\u0011\u0010¤\u0001\u001a\u00020J2\b\u0010¢\u0001\u001a\u00030¥\u0001J\u001f\u0010¦\u0001\u001a\u00020J2\u0016\u0010§\u0001\u001a\u0011\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020)\u0018\u00010¨\u0001J\u0010\u0010©\u0001\u001a\u00020J2\u0007\u0010ª\u0001\u001a\u00020\u000fJ\u0007\u0010«\u0001\u001a\u00020JJ\u0007\u0010¬\u0001\u001a\u00020JJ\u0011\u0010\u00ad\u0001\u001a\u00020J2\b\u0010®\u0001\u001a\u00030¯\u0001J\u0010\u0010°\u0001\u001a\u00020J2\u0007\u0010±\u0001\u001a\u00020&J\u0007\u0010²\u0001\u001a\u00020JJ\u0007\u0010³\u0001\u001a\u00020JJ\u0007\u0010´\u0001\u001a\u00020JJ\u0007\u0010µ\u0001\u001a\u00020JJ\t\u0010¶\u0001\u001a\u00020JH\u0007J\t\u0010·\u0001\u001a\u00020JH\u0007J\t\u0010¸\u0001\u001a\u00020JH\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u00020#2\u0006\u00100\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u0002062\u0006\u00100\u001a\u0002068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\u00020#2\u0006\u00100\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u00103\"\u0004\b>\u00105R$\u0010?\u001a\u00020#2\u0006\u00100\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u000e\u0010B\u001a\u00020CX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¹\u0001\u001a\u00030º\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Æ\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mResultRV", "Landroidx/recyclerview/widget/RecyclerView;", "mSearchResultPtrFL", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "mSearchResultLoadingView", "Landroid/view/View;", "rvSkeletonScreen", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "mSearchResultEmptyView", "mSearchEmptyHintText", "Landroid/widget/TextView;", "mSearchEmptyHintImage", "Landroid/widget/ImageView;", "mSearchResultHeadContainer", "mSearchRsultRelatelayout", "Landroid/widget/RelativeLayout;", "mResultAdapter", "Lcom/ss/android/lark/picker/base/view/SearchResultViewAdapter;", "mClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "mOnLoadMore", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnLoadMore;", "mExpandFoldDepartmentCallback", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IExpandFoldDepartmentCallback;", "isCustomEmptyView", "", "mResultData", "Ljava/util/LinkedHashSet;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/LinkedHashSet;", "itemHeight", "", "defaultItemCount", "mScrolledPx", "getMScrolledPx", "()I", "setMScrolledPx", "(I)V", "value", "mIsEnableChatPreview", "getMIsEnableChatPreview", "()Z", "setMIsEnableChatPreview", "(Z)V", "", "mScene", "getMScene", "()Ljava/lang/String;", "setMScene", "(Ljava/lang/String;)V", "mBindTagWithDynamicTag", "getMBindTagWithDynamicTag", "setMBindTagWithDynamicTag", "forceRefreshNotifyItemChangedOnUnconsumedClick", "getForceRefreshNotifyItemChangedOnUnconsumedClick", "setForceRefreshNotifyItemChangedOnUnconsumedClick", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "emptyViewManager", "Lcom/ss/android/lark/picker/base/utils/EmptyViewManager;", "dataUpdateHelper", "Lcom/ss/android/lark/picker/base/utils/DataUpdateHelper;", "onErrorRetryClick", "Lkotlin/Function0;", "", "consumeResultLayoutClickWhenEmpty", "privateDescriptionRequestSeq", "initViews", "setSearchEmptyViewConfig", "emptyIconResId", "emptyHintText", "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "enableKeyboardNavigation", "keyboardSelectionUIDependency", "Lcom/ss/android/lark/picker/base/view/keyboard/KeyboardSelectionUIDependency;", "initOnLoadMore", "resetViewBeforeShowData", "showResult", "data", "", "showResultNow", "resetResult", "resetResultNow", "refreshResult", "selectedList", "forceNotifyDataSetChanged", "resetShowCeilingBarStatus", "hideCeilingExpandBar", "showLoading", "withSkeleton", "showEmpty", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "showErrorRetry", "hintText", "onRetryClick", "hideAllResultAboutView", "emptyLoadMore", "hideUtilityView", "setColdAndHotType", "coldAndHotType", "hotToColdLoadingView", "loading", "setBottomLoadingState", "bottomLoadingState", "setClickHandler", "clickHandler", "setOnLoadMore", "onLoadMore", "setExpandFoldDepartmentCallback", "callback", "default", "totalSize", "mNeedLoadMore", "setNeedLoadMore", "needLoadMore", "mOnResultScroll", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnResultScroll;", "setOnResultScroll", "onResultScroll", "setOnClickEmptyView", "onClickEmptyView", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnClickEmptyView;", "setConsumeResultLayoutClickWhenEmpty", "consume", "setEmptyViewColdAndHotListener", "emptyViewClickListener", "Lcom/ss/android/lark/picker/base/utils/EmptyViewManager$IEmptyViewColdAndHotListener;", "switchMultiple", "isMultiple", "setSingleChoiceMode", "isSingleChoice", "setDisableRightViewHolder", "disableRightViewHolder", "setDisableExtraInfoSummary", "disableExtraInfoSummary", "registerCustomBinders", "customBinders", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "showDivider", "disableExternalChatter", "setCustomBinder", "customBinder", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "setCustomViewTypeResolvers", "resolvers", "Lcom/ss/android/lark/picker/base/view/binder/ICustomViewTypeResolver;", "setOnBusinessConsumeItem", "onBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "setProfileClickListener", "listener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "setOnItemOnScreenListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "setCalendarColorProvider", "provider", "Lkotlin/Function1;", "setHeadCustomView", "customView", "clearHeadCustomView", "onConfigurationChanged", "updateFileContent", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "notifyItemUpdate", "baseInfo", "erasePadding", "erasePaddingTop", "bgBase", "bgBody", "onPause", "onResume", "onDestroy", "state", "Lcom/ss/android/lark/picker/base/view/SearchResultView$STATE;", "Companion", "IOnLoadMore", "IOnResultScroll", "IOnClickEmptyView", "CheckBoxBindStatus", "IOnBusinessConsumeItem", "STATE", "WeakNetErrorCallback", "NoNetErrorCallback", "IExpandFoldDepartmentCallback", "IOnWeakNetRetryClickListener", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchResultView extends FrameLayout implements LifecycleObserver {
    public static final Companion Companion = null;
    public static final String TAG = "LarkSearch.Common.SearchResultView";
    private boolean consumeResultLayoutClickWhenEmpty;
    private final DataUpdateHelper dataUpdateHelper;
    private final int defaultItemCount;
    private final EmptyViewManager emptyViewManager;
    private boolean isCustomEmptyView;
    private int itemHeight;
    private UDLoadingDrawable loadingDrawable;
    private g mClickHandler;
    private IExpandFoldDepartmentCallback mExpandFoldDepartmentCallback;
    private boolean mNeedLoadMore;
    private IOnLoadMore mOnLoadMore;
    private IOnResultScroll mOnResultScroll;
    private SearchResultViewAdapter mResultAdapter;
    private LinkedHashSet<SearchBaseInfo> mResultData;
    private RecyclerView mResultRV;
    private int mScrolledPx;
    private ImageView mSearchEmptyHintImage;
    private TextView mSearchEmptyHintText;
    private View mSearchResultEmptyView;
    private FrameLayout mSearchResultHeadContainer;
    private View mSearchResultLoadingView;
    private LKUIPtrClassicFrameLayout mSearchResultPtrFL;
    private RelativeLayout mSearchRsultRelatelayout;
    private Function0<Unit> onErrorRetryClick;
    private int privateDescriptionRequestSeq;
    private a rvSkeletonScreen;
    private STATE state;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\u000b\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "", "isConsume", "", "isChecked", "isEnabled", "<init>", "(ZZZ)V", "()Z", "setConsume", "(Z)V", "setChecked", "setEnabled", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class CheckBoxBindStatus {
        private boolean isChecked;
        private boolean isConsume;
        private boolean isEnabled;

        public static /* synthetic */ CheckBoxBindStatus copy$default(CheckBoxBindStatus r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.isConsume;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.isChecked;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.isEnabled;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.isConsume;
        }

        public final boolean component2() {
            return this.isChecked;
        }

        public final boolean component3() {
            return this.isEnabled;
        }

        public final CheckBoxBindStatus copy(boolean r2, boolean r3, boolean r4) {
            return new CheckBoxBindStatus(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CheckBoxBindStatus) == true) goto L8;
            return false;
        L8:
            CheckBoxBindStatus r6 = (CheckBoxBindStatus) r5;
            if (this.isConsume == r6.isConsume) goto L12;
            return false;
        L12:
            if (this.isChecked == r6.isChecked) goto L15;
            return false;
        L15:
            if (this.isEnabled == r6.isEnabled) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r1 = 1231;
            if (this.isConsume == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.isChecked == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.isEnabled == true) goto L15;
            r1 = 1237;
        L15:
            return r4 + r1;
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "CheckBoxBindStatus(isConsume=" + this.isConsume + ", isChecked=" + this.isChecked + ", isEnabled=" + this.isEnabled + ')';
        }

        public final boolean isChecked() {
            return this.isChecked;
        }

        public final boolean isConsume() {
            return this.isConsume;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final void setChecked(boolean r1) {
            this.isChecked = r1;
        }

        public final void setConsume(boolean r1) {
            this.isConsume = r1;
        }

        public final void setEnabled(boolean r1) {
            this.isEnabled = r1;
        }

        public CheckBoxBindStatus(boolean r1, boolean r2, boolean r3) {
            this.isConsume = r1;
            this.isChecked = r2;
            this.isEnabled = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$IExpandFoldDepartmentCallback;", "", "onClick", "", "expand", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IExpandFoldDepartmentCallback {
        void onClick(boolean r1);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "", "onBusinessConsumeItemClick", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "onBusinessBindItemCheckBox", "Lcom/ss/android/lark/picker/base/view/SearchResultView$CheckBoxBindStatus;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnBusinessConsumeItem {
        CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r1);

        boolean onBusinessConsumeItemClick(SearchBaseInfo r1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnClickEmptyView;", "", "onClickEmptyView", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnClickEmptyView {
        void onClickEmptyView();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnLoadMore;", "", "canLoadMore", "", "onLoadMore", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnLoadMore {
        boolean canLoadMore();

        void onLoadMore();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnResultScroll;", "", "onResultStopScroll", "", "onResultStartScroll", "onResultScrollScreen", "pageNum", "", "onResultScrollToTop", "flag", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnResultScroll {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class DefaultImpls {
            public static void onResultScrollScreen(IOnResultScroll r0, int r1) {
            }

            public static void onResultScrollToTop(IOnResultScroll r0, boolean r1) {
            }

            public static void onResultStartScroll(IOnResultScroll r0) {
            }

            public static void onResultStopScroll(IOnResultScroll r0) {
            }
        }

        void onResultScrollScreen(int r1);

        void onResultScrollToTop(boolean r1);

        void onResultStartScroll();

        void onResultStopScroll();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnWeakNetRetryClickListener;", "", "onRetryClick", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IOnWeakNetRetryClickListener {
        void onRetryClick();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$NoNetErrorCallback;", "", "retry", "", "view", "Landroid/view/View;", "onVisibilityChange", "visibility", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface NoNetErrorCallback {
        void onVisibilityChange(int r1);

        void retry(View r1);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$STATE;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "RESULT_EMPTY", "RESULT", "ERROR_INFO", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum STATE extends Enum<STATE> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ STATE[] $VALUES = null;
        public static final STATE DEFAULT = null;
        public static final STATE ERROR_INFO = null;
        public static final STATE LOADING = null;
        public static final STATE RESULT = null;
        public static final STATE RESULT_EMPTY = null;

        private static final /* synthetic */ STATE[] $values() {
            return new STATE[]{DEFAULT, LOADING, RESULT_EMPTY, RESULT, ERROR_INFO};
        }

        public static EnumEntries<STATE> getEntries() {
            return $ENTRIES;
        }

        static {
            DEFAULT = new STATE("DEFAULT", 0);
            LOADING = new STATE("LOADING", 1);
            RESULT_EMPTY = new STATE("RESULT_EMPTY", 2);
            RESULT = new STATE("RESULT", 3);
            ERROR_INFO = new STATE("ERROR_INFO", 4);
            STATE[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static STATE[] values() {
            return (STATE[]) $VALUES.clone();
        }

        public static STATE valueOf(String r1) {
            return (STATE) r27.a.a(STATE.class, r1);
        }

        private STATE(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/SearchResultView$WeakNetErrorCallback;", "", "retry", "", "view", "Landroid/view/View;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface WeakNetErrorCallback {
        void retry(View r1);
    }

    static {
        Companion = new Companion(null);
    }

    public final void setCalendarColorProvider(Function1<? super String, Integer> r1) {
    }

    public final void showLoading() {
        showLoading(false);
    }

    private final void initOnLoadMore() {
        SearchPtrFooter r0 = new SearchPtrFooter(getContext());
        LKUIPtrFrameLayout r1 = this.mSearchResultPtrFL;
        LKUIPtrFrameLayout r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r1 = null;
    L5:
        r1.setKeepHeaderWhenRefresh(true);
        LKUIPtrFrameLayout r3 = this.mSearchResultPtrFL;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r3 = null;
    L8:
        r3.setFooterView(r0);
        LKUIPtrFrameLayout r4 = this.mSearchResultPtrFL;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r4 = null;
    L11:
        r4.addPtrUIHandler(r0);
        LKUIPtrFrameLayout r5 = this.mSearchResultPtrFL;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r5 = null;
    L14:
        r5.disableWhenHorizontalMove(true);
        LKUIPtrFrameLayout r6 = this.mSearchResultPtrFL;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r6 = null;
    L17:
        r6.setForceBackWhenComplete(true);
        LKUIPtrFrameLayout r7 = this.mSearchResultPtrFL;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r7 = null;
    L20:
        r7.setEnableScrollContentAfterLoad(true);
        LKUIPtrFrameLayout r8 = this.mSearchResultPtrFL;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
    L24:
        r2.setPtrHandler(new AnonymousClass1(this));
        return;
    L23:
        r2 = r8;
        goto L24
    }

    private final void resetShowCeilingBarStatus() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.resetShowCeilingBarStatus();
    }

    private final void resetViewBeforeShowData() {
        STATE r0 = this.state;
        STATE r1 = STATE.RESULT;
        View r5 = null;
        if (r0 != r1) goto L10;
        Log.d(TAG, "already RESULT.");
        View r2 = this.mSearchResultEmptyView;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
    L8:
        r5.setVisibility(8);
        return;
    L7:
        r5 = r2;
        goto L8
    L10:
        this.state = r1;
        Log.i(TAG, "switch view state.");
        ViewGroup r3 = this.mSearchResultPtrFL;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r3 = null;
    L13:
        r3.setVisibility(0);
        View r4 = this.mSearchResultLoadingView;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r4 = null;
    L16:
        r4.setVisibility(8);
        a r6 = this.rvSkeletonScreen;
        if (r6 == null) goto L19;
        r6.a();
    L19:
        View r7 = this.mSearchResultEmptyView;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r7 = null;
    L22:
        r7.setVisibility(8);
        View r8 = this.loadingDrawable;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L26:
        r5.stop();
        return;
    L25:
        r5 = r8;
        goto L26
    }

    public final void clearHeadCustomView() {
        FrameLayout r0 = this.mSearchResultHeadContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r2 = this.mSearchResultHeadContainer;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public final void m3355default() {
        this.privateDescriptionRequestSeq++;
        Log.d(TAG, "default!!!");
        STATE r0 = this.state;
        STATE r2 = STATE.DEFAULT;
        if (r0 != r2) goto L6;
        Log.d(TAG, "already default!!!");
        return;
    L6:
        this.state = r2;
        SearchResultViewAdapter r1 = null;
        this.onErrorRetryClick = null;
        ViewGroup r3 = this.mSearchResultPtrFL;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r3 = null;
    L9:
        r3.setVisibility(0);
        View r4 = this.mSearchResultLoadingView;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r4 = null;
    L12:
        r4.setVisibility(8);
        a r5 = this.rvSkeletonScreen;
        if (r5 == null) goto L15;
        r5.a();
    L15:
        View r6 = this.mSearchResultEmptyView;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r6 = null;
    L18:
        r6.setVisibility(8);
        hideUtilityView();
        LKUIPtrFrameLayout r7 = this.mSearchResultPtrFL;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r7 = null;
    L21:
        r7.refreshComplete();
        this.mResultData.clear();
        SearchResultViewAdapter r8 = this.mResultAdapter;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r8 = null;
    L24:
        r8.clear();
        this.mScrolledPx = 0;
        CircularProgressDrawable r9 = this.loadingDrawable;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r9 = null;
    L27:
        r9.stop();
        LinkedHashSet<SearchBaseInfo> r10 = this.mResultData;
        this.dataUpdateHelper.resetFakeData(r10);
        SearchResultViewAdapter r11 = this.mResultAdapter;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L31:
        r1.diff(r10);
        return;
    L30:
        r1 = r11;
        goto L31
    }

    public final void emptyLoadMore() {
        LKUIPtrFrameLayout r0 = this.mSearchResultPtrFL;
        SearchResultViewAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r0 = null;
    L5:
        r0.refreshComplete();
        LinkedHashSet<SearchBaseInfo> r2 = this.mResultData;
        this.dataUpdateHelper.resetFakeData(r2);
        SearchResultViewAdapter r3 = this.mResultAdapter;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L9:
        r1.diff(r2);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    public final boolean getForceRefreshNotifyItemChangedOnUnconsumedClick() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L6:
        return r0.getForceRefreshNotifyItemChangedOnUnconsumedClick();
    }

    public final boolean getMBindTagWithDynamicTag() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L6:
        return r0.getMBindTagWithDynamicTag();
    }

    public final boolean getMIsEnableChatPreview() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L6:
        return r0.getMIsEnableChatPreview();
    }

    public final String getMScene() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L6:
        return r0.getMScene();
    }

    public final void hideAllResultAboutView() {
        this.privateDescriptionRequestSeq++;
        View r0 = this.mSearchResultEmptyView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        ViewGroup r1 = this.mSearchResultPtrFL;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r1 = null;
    L8:
        r1.setVisibility(8);
        View r2 = this.mSearchResultLoadingView;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r2 = null;
    L11:
        r2.setVisibility(8);
        a r3 = this.rvSkeletonScreen;
        if (r3 == null) goto L14;
        r3.a();
    L14:
        hideUtilityView();
        this.onErrorRetryClick = null;
    }

    public final void onConfigurationChanged() {
        RecyclerView.Adapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.notifyDataSetChanged();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.onDestroy();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.onPause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.onResume();
    }

    public final int totalSize() {
        return this.dataUpdateHelper.realSize(this.mResultData);
    }

    private final void initViews() {
        this.mResultRV = findViewById(2131385582);
        this.mSearchResultPtrFL = findViewById(2131385579);
        this.mSearchResultLoadingView = findViewById(2131385575);
        this.mSearchResultEmptyView = findViewById(2131385568);
        this.mSearchEmptyHintText = (TextView) findViewById(2131385418);
        this.mSearchEmptyHintImage = (ImageView) findViewById(2131385419);
        this.mSearchResultHeadContainer = (FrameLayout) findViewById(2131385570);
        RelativeLayout r0 = (RelativeLayout) findViewById(2131384451);
        this.mSearchRsultRelatelayout = r0;
        Drawable r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
        r0 = null;
    L5:
        r0.setOnTouchListener(new ViewOnTouchListenerC03281(this));
        EmptyViewManager r2 = this.emptyViewManager;
        View r3 = this.mSearchResultEmptyView;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r3 = null;
    L8:
        TextView r4 = this.mSearchEmptyHintText;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r4 = null;
    L11:
        ImageView r5 = this.mSearchEmptyHintImage;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r5 = null;
    L14:
        r2.setEmptyView(r3, r4, r5);
        this.mResultAdapter = new SearchResultViewAdapter(getContext(), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this), new AnonymousClass5());
        final RecyclerView r6 = this.mResultRV;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mResultRV");
        r6 = null;
    L17:
        h.b(r6);
        r6.setItemAnimator(null);
        RecyclerView.Adapter r7 = this.mResultAdapter;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r7 = null;
    L20:
        r6.setAdapter(r7);
        r6.setLayoutManager(new LinearLayoutManager(r6.getContext(), 1, false));
        r6.addOnScrollListener(new SearchResultView$initViews$6$1(this, r6));
        initOnLoadMore();
        UDLoadingDrawable r8 = new UDLoadingDrawable(getContext());
        r8.setColorSchemeColors(new int[]{d.c(getContext(), 2131105548)});
        this.loadingDrawable = r8;
        ImageView r9 = (ImageView) findViewById(2131385576);
        Drawable r10 = this.loadingDrawable;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L24:
        r9.setImageDrawable(r1);
        this.itemHeight = UIUtils.dp2px(getContext(), 66.0f);
        return;
    L23:
        r1 = r10;
        goto L24
    }

    public final void bgBase() {
        findViewById(2131384451).setBackgroundColor(d.c(getContext(), 2131100545));
    }

    public final void bgBody() {
        findViewById(2131384451).setBackgroundColor(d.c(getContext(), 2131100548));
    }

    public final void erasePadding() {
        findViewById(2131384451).setPadding(0, 0, 0, 0);
    }

    public final void erasePaddingTop() {
        View r0 = findViewById(2131384451);
        r0.setPadding(r0.getPaddingLeft(), 0, r0.getPaddingRight(), r0.getPaddingBottom());
    }

    private final void hideCeilingExpandBar() {
        resetShowCeilingBarStatus();
    }

    public final int getMScrolledPx() {
        return this.mScrolledPx;
    }

    public final void hideUtilityView() {
        hideCeilingExpandBar();
    }

    public SearchResultView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ boolean access$getConsumeResultLayoutClickWhenEmpty$p(SearchResultView r0) {
        return r0.consumeResultLayoutClickWhenEmpty;
    }

    public static final /* synthetic */ int access$getDefaultItemCount$p(SearchResultView r0) {
        return r0.defaultItemCount;
    }

    public static final /* synthetic */ int access$getItemHeight$p(SearchResultView r0) {
        return r0.itemHeight;
    }

    public static final /* synthetic */ UDLoadingDrawable access$getLoadingDrawable$p(SearchResultView r0) {
        return r0.loadingDrawable;
    }

    public static final /* synthetic */ g access$getMClickHandler$p(SearchResultView r0) {
        return r0.mClickHandler;
    }

    public static final /* synthetic */ boolean access$getMNeedLoadMore$p(SearchResultView r0) {
        return r0.mNeedLoadMore;
    }

    public static final /* synthetic */ IOnLoadMore access$getMOnLoadMore$p(SearchResultView r0) {
        return r0.mOnLoadMore;
    }

    public static final /* synthetic */ IOnResultScroll access$getMOnResultScroll$p(SearchResultView r0) {
        return r0.mOnResultScroll;
    }

    public static final /* synthetic */ SearchResultViewAdapter access$getMResultAdapter$p(SearchResultView r0) {
        return r0.mResultAdapter;
    }

    public static final /* synthetic */ RecyclerView access$getMResultRV$p(SearchResultView r0) {
        return r0.mResultRV;
    }

    public static final /* synthetic */ View access$getMSearchResultEmptyView$p(SearchResultView r0) {
        return r0.mSearchResultEmptyView;
    }

    public static final /* synthetic */ View access$getMSearchResultLoadingView$p(SearchResultView r0) {
        return r0.mSearchResultLoadingView;
    }

    public static final /* synthetic */ LKUIPtrClassicFrameLayout access$getMSearchResultPtrFL$p(SearchResultView r0) {
        return r0.mSearchResultPtrFL;
    }

    public static final /* synthetic */ RelativeLayout access$getMSearchRsultRelatelayout$p(SearchResultView r0) {
        return r0.mSearchRsultRelatelayout;
    }

    public static final /* synthetic */ Function0 access$getOnErrorRetryClick$p(SearchResultView r0) {
        return r0.onErrorRetryClick;
    }

    public static final /* synthetic */ int access$getPrivateDescriptionRequestSeq$p(SearchResultView r0) {
        return r0.privateDescriptionRequestSeq;
    }

    public static final /* synthetic */ a access$getRvSkeletonScreen$p(SearchResultView r0) {
        return r0.rvSkeletonScreen;
    }

    public static final /* synthetic */ STATE access$getState$p(SearchResultView r0) {
        return r0.state;
    }

    private final void resetResultNow(List<? extends SearchBaseInfo> r5) {
        resetViewBeforeShowData();
        LinkedHashSet<SearchBaseInfo> r0 = this.mResultData;
        this.dataUpdateHelper.resetResult(r0, r5);
        SearchResultViewAdapter r6 = this.mResultAdapter;
        LKUIPtrFrameLayout r1 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r6 = null;
    L5:
        r6.resetAll(r0);
        Iterator<T> r7 = r0.iterator();
        int r2 = 0;
    L7:
        if (r7.hasNext() == false) goto L15;
        Object r3 = r7.next();
        if (r2 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        if (((SearchBaseInfo) r3).isFirstInfoForInit() == true) goto L16;
        r2 = r2 + 1;
    L16:
        if (r2 <= 0) goto L21;
        RecyclerView r8 = this.mResultRV;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mResultRV");
        r8 = null;
    L20:
        r8.scrollToPosition(r2);
    L21:
        this.mScrolledPx = 0;
        LKUIPtrFrameLayout r9 = this.mSearchResultPtrFL;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
    L25:
        r1.refreshComplete();
        return;
    L24:
        r1 = r9;
        goto L25
    L15:
        r2 = -1;
        goto L16
    }

    private final void showResultNow(List<? extends SearchBaseInfo> r3) {
        resetViewBeforeShowData();
        LinkedHashSet<SearchBaseInfo> r0 = this.mResultData;
        this.dataUpdateHelper.showResult(r0, r3);
        SearchResultViewAdapter r4 = this.mResultAdapter;
        LKUIPtrFrameLayout r1 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r4 = null;
    L5:
        r4.diff(r0);
        LKUIPtrFrameLayout r5 = this.mSearchResultPtrFL;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
    L9:
        r1.refreshComplete();
        return;
    L8:
        r1 = r5;
        goto L9
    }

    public final void disableExternalChatter(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.disableExternalChatter(r2);
    }

    public final void enableKeyboardNavigation(KeyboardSelectionUIDependency r4) {
        Intrinsics.checkNotNullParameter(r4, "keyboardSelectionUIDependency");
        RecyclerView r0 = this.mResultRV;
        SearchResultViewAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultRV");
        r0 = null;
    L5:
        SearchResultViewAdapter r2 = this.mResultAdapter;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L9:
        KeyboardSelectionHelperKt.enableKeyboardNavigation(r0, r1, r4.onBindEditText());
        return;
    L8:
        r1 = r2;
        goto L9
    }

    public final void hotToColdLoadingView(boolean r3) {
        LinkedHashSet<SearchBaseInfo> r0 = this.mResultData;
        this.dataUpdateHelper.hotToColdLoadingView(r3, r0);
        SearchResultViewAdapter r4 = this.mResultAdapter;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r4 = null;
    L5:
        r4.diff(r0);
    }

    public final void notifyItemUpdate(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "baseInfo");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.notifyItemChanged(r2);
    }

    public final void registerCustomBinders(Map<Integer, ? extends CommonBinder<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinders");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.registerCustomBinders(r2);
    }

    public final void resetResult(List<? extends SearchBaseInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        final int r0 = this.privateDescriptionRequestSeq + 1;
        this.privateDescriptionRequestSeq = r0;
        PrivateDescriptionHelper.INSTANCE.apply(r4, new C03291(r0, this));
    }

    public final void setBottomLoadingState(int r2) {
        this.dataUpdateHelper.setBottomLoadingState(r2);
    }

    public final void setClickHandler(g r1) {
        this.mClickHandler = r1;
    }

    public final void setColdAndHotType(int r2) {
        this.emptyViewManager.setEmptyType(r2);
        this.dataUpdateHelper.setEmptyType(r2);
    }

    public final void setConsumeResultLayoutClickWhenEmpty(boolean r1) {
        this.consumeResultLayoutClickWhenEmpty = r1;
    }

    public final void setCustomBinder(ICustomBinder r2) {
        Intrinsics.checkNotNullParameter(r2, "customBinder");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setCustomBinder(r2);
    }

    public final void setCustomViewTypeResolvers(List<? extends ICustomViewTypeResolver> r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setCustomViewTypeResolvers(r2);
    }

    public final void setDisableExtraInfoSummary(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setDisableExtraInfoSummary(r2);
    }

    public final void setDisableRightViewHolder(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setDisableRightViewHolder(r2);
    }

    public final void setEmptyViewColdAndHotListener(EmptyViewManager.IEmptyViewColdAndHotListener r2) {
        Intrinsics.checkNotNullParameter(r2, "emptyViewClickListener");
        this.emptyViewManager.setEmptyViewColdAndHotListener(r2);
    }

    public final void setExpandFoldDepartmentCallback(IExpandFoldDepartmentCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mExpandFoldDepartmentCallback = r2;
    }

    public final void setForceRefreshNotifyItemChangedOnUnconsumedClick(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setForceRefreshNotifyItemChangedOnUnconsumedClick(r2);
    }

    public final void setHeadCustomView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "customView");
        FrameLayout r0 = this.mSearchResultHeadContainer;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
        r0 = null;
    L5:
        r0.setVisibility(0);
        FrameLayout r2 = this.mSearchResultHeadContainer;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
        r2 = null;
    L8:
        r2.removeAllViews();
        FrameLayout r3 = this.mSearchResultHeadContainer;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
    L12:
        r1.addView(r5);
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void setMBindTagWithDynamicTag(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setMBindTagWithDynamicTag(r2);
    }

    public final void setMIsEnableChatPreview(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setMIsEnableChatPreview(r2);
    }

    public final void setMScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setMScene(r2);
    }

    public final void setMScrolledPx(int r1) {
        this.mScrolledPx = r1;
    }

    public final void setNeedLoadMore(boolean r1) {
        this.mNeedLoadMore = r1;
    }

    public final void setOnBusinessConsumeItem(IOnBusinessConsumeItem r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setOnBusinessConsumeItem(r2);
    }

    public final void setOnClickEmptyView(final IOnClickEmptyView r3) {
        Intrinsics.checkNotNullParameter(r3, "onClickEmptyView");
        this.emptyViewManager.setOnClickEmptyView(new C03301(this, r3));
    }

    public final void setOnItemOnScreenListener(v3c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setMOnItemOnScreenListener(r2);
    }

    public final void setOnLoadMore(IOnLoadMore r2) {
        Intrinsics.checkNotNullParameter(r2, "onLoadMore");
        this.mOnLoadMore = r2;
    }

    public final void setOnResultScroll(IOnResultScroll r2) {
        Intrinsics.checkNotNullParameter(r2, "onResultScroll");
        this.mOnResultScroll = r2;
    }

    public final void setProfileClickListener(IOnProfileClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setProfileClickListener(r2);
    }

    public final void setSingleChoiceMode(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.setSingleChoiceMode(r2);
    }

    public final void showDivider(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.showDivider(r2);
    }

    public final void showEmpty(String r5) {
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY);
        this.privateDescriptionRequestSeq++;
        STATE r0 = this.state;
        STATE r1 = STATE.RESULT_EMPTY;
        if (r0 != r1) goto L7;
        Log.d(TAG, "already RESULT_EMPTY.");
        return;
    L7:
        if (r0 == STATE.RESULT) goto L9;
    L12:
        this.state = r1;
        SearchResultViewAdapter r2 = null;
        this.onErrorRetryClick = null;
        LKUIPtrFrameLayout r3 = this.mSearchResultPtrFL;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r3 = null;
    L15:
        r3.refreshComplete();
        View r4 = this.mSearchResultEmptyView;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r4 = null;
    L18:
        r4.setVisibility(0);
        ViewGroup r6 = this.mSearchResultPtrFL;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r6 = null;
    L21:
        r6.setVisibility(8);
        View r7 = this.mSearchResultLoadingView;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r7 = null;
    L24:
        r7.setVisibility(8);
        a r8 = this.rvSkeletonScreen;
        if (r8 == null) goto L27;
        r8.a();
    L27:
        hideUtilityView();
        this.emptyViewManager.updateSearchResultViewEmptyView(r5);
        CircularProgressDrawable r9 = this.loadingDrawable;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r9 = null;
    L30:
        r9.stop();
        LinkedHashSet<SearchBaseInfo> r10 = this.mResultData;
        this.dataUpdateHelper.clearFakeData(r10);
        SearchResultViewAdapter r11 = this.mResultAdapter;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L34:
        r2.diff(r10);
        return;
    L33:
        r2 = r11;
        goto L34
    L9:
        if ((!this.mResultData.isEmpty()) == false) goto L12;
        Log.d(TAG, "already RESULT with data, skip showEmpty.");
    }

    public final void showLoading(final boolean r4) {
        this.privateDescriptionRequestSeq++;
        STATE r0 = this.state;
        STATE r1 = STATE.LOADING;
        if (r0 != r1) goto L6;
        Log.d(TAG, "already LOADING.");
        return;
    L6:
        this.state = r1;
        Log.d(TAG, "showLoading");
        LKUIPtrFrameLayout r2 = this.mSearchResultPtrFL;
        SearchResultViewAdapter r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r2 = null;
    L9:
        r2.refreshComplete();
        this.mResultData.clear();
        SearchResultViewAdapter r5 = this.mResultAdapter;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L13:
        r3.clear();
        post(new RunnableC03311(this, r4));
        return;
    L12:
        r3 = r5;
        goto L13
    }

    public final void showResult(List<? extends SearchBaseInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        final int r0 = this.privateDescriptionRequestSeq + 1;
        this.privateDescriptionRequestSeq = r0;
        PrivateDescriptionHelper.INSTANCE.apply(r4, new C03321(r0, this));
    }

    public final void switchMultiple(boolean r2) {
        SearchResultViewAdapter r0 = this.mResultAdapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        r0.switchMultiple(r2);
    }

    public final void updateFileContent(FileContent r8) {
        Intrinsics.checkNotNullParameter(r8, "fileContent");
        SearchResultViewAdapter r0 = this.mResultAdapter;
        SearchResultViewAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r0 = null;
    L5:
        Iterator r2 = r0.getItems().iterator();
    L7:
        if (r2.hasNext() == false) goto L46;
        SearchMessageInfo r3 = (SearchBaseInfo) r2.next();
        if ((r3 instanceof SearchFileInfo) == true) goto L10;
        if ((r3 instanceof SearchMessageInfo) == false) goto L7;
        SearchMessageInfo r4 = r3;
        if (r4.getFileContent() == null) goto L7;
        String r5 = r8.getKey();
        FileContent r6 = r4.getFileContent();
        Intrinsics.checkNotNull(r6);
        if (Intrinsics.areEqual(r5, r6.getKey()) == false) goto L7;
        r4.setFileContent(r8);
        SearchResultViewAdapter r9 = this.mResultAdapter;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L30:
        r1.notifyItemChanged(r3);
        return;
    L29:
        r1 = r9;
        goto L30
    L10:
        SearchFileInfo r7 = (SearchFileInfo) r3;
        if (r7.getFileContent() == null) goto L7;
        if (Intrinsics.areEqual(r8.getKey(), r7.getFileContent().getKey()) == false) goto L7;
        r7.setFileContent(r8);
        SearchResultViewAdapter r10 = this.mResultAdapter;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L18:
        r1.notifyItemChanged(r3);
        return;
    L17:
        r1 = r10;
        goto L18
    }

    public SearchResultView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.mResultData = new LinkedHashSet();
        this.defaultItemCount = 15;
        this.emptyViewManager = new EmptyViewManager(getContext());
        this.dataUpdateHelper = new DataUpdateHelper(getContext());
        this.mNeedLoadMore = true;
        this.state = STATE.RESULT_EMPTY;
        LayoutInflater.from(r2).inflate(2131568199, this, true);
        initViews();
    }

    public static final /* synthetic */ void access$resetResultNow(SearchResultView r0, List r1) {
        r0.resetResultNow(r1);
    }

    public static final /* synthetic */ void access$setRvSkeletonScreen$p(SearchResultView r0, a r1) {
        r0.rvSkeletonScreen = r1;
    }

    public static final /* synthetic */ void access$setState$p(SearchResultView r0, STATE r1) {
        r0.state = r1;
    }

    public static final /* synthetic */ void access$showResultNow(SearchResultView r0, List r1) {
        r0.showResultNow(r1);
    }

    public final void refreshResult(List<? extends SearchBaseInfo> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "selectedList");
        LKUIPtrFrameLayout r0 = this.mSearchResultPtrFL;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r0 = null;
    L5:
        r0.refreshComplete();
        Iterator<SearchBaseInfo> r1 = this.mResultData.iterator();
    L7:
        if (r1.hasNext() == false) goto L32;
        SearchBaseInfo r2 = r1.next();
        boolean r3 = r7.contains(r2);
        if (r2.isSelected() == r3) goto L21;
        r2.selected(r3);
        if (r8 == false) goto L16;
        RecyclerView.Adapter r4 = this.mResultAdapter;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r4 = null;
    L15:
        r4.notifyDataSetChanged();
        goto L21
    L16:
        SearchResultViewAdapter r5 = this.mResultAdapter;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r5 = null;
    L19:
        r5.notifyItemChanged(r2);
    L21:
        if (r2.isSingleChoice() == r3) goto L7;
        r2.setSingleChoice(r3);
        if (r8 == true) goto L24;
        SearchResultViewAdapter r6 = this.mResultAdapter;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r6 = null;
    L31:
        r6.notifyItemChanged(r2);
        goto L7
    L24:
        RecyclerView.Adapter r9 = this.mResultAdapter;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
        r9 = null;
    L27:
        r9.notifyDataSetChanged();
        goto L7
    }

    public final void setSearchEmptyViewConfig(Integer r2, CharSequence r3) {
        this.isCustomEmptyView = true;
        this.emptyViewManager.setCustomEmptyView(r2, r3);
    }

    public final void showErrorRetry(CharSequence r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "hintText");
        this.privateDescriptionRequestSeq++;
        this.state = STATE.ERROR_INFO;
        this.onErrorRetryClick = r7;
        LKUIPtrFrameLayout r8 = this.mSearchResultPtrFL;
        SearchResultViewAdapter r1 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r8 = null;
    L5:
        r8.refreshComplete();
        View r9 = this.mSearchResultEmptyView;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r9 = null;
    L8:
        r9.setVisibility(0);
        ImageView r10 = this.mSearchEmptyHintImage;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r10 = null;
    L11:
        r10.setVisibility(8);
        TextView r11 = this.mSearchEmptyHintText;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r11 = null;
    L14:
        r11.setText(r6);
        ViewGroup r12 = this.mSearchResultPtrFL;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r12 = null;
    L17:
        r12.setVisibility(8);
        View r13 = this.mSearchResultLoadingView;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r13 = null;
    L20:
        r13.setVisibility(8);
        a r14 = this.rvSkeletonScreen;
        if (r14 == null) goto L23;
        r14.a();
    L23:
        hideUtilityView();
        if (this.isCustomEmptyView == false) goto L29;
        View r15 = this.mSearchResultEmptyView;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r15 = null;
    L28:
        d.l(r15, false);
    L33:
        CircularProgressDrawable r16 = this.loadingDrawable;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r16 = null;
    L36:
        r16.stop();
        LinkedHashSet<SearchBaseInfo> r17 = this.mResultData;
        this.dataUpdateHelper.clearFakeData(r17);
        SearchResultViewAdapter r18 = this.mResultAdapter;
        if (r18 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mResultAdapter");
    L40:
        r1.diff(r17);
        return;
    L39:
        r1 = r18;
        goto L40
    L29:
        View r19 = this.mSearchResultEmptyView;
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r19 = null;
    L32:
        d.k(r19);
        goto L33
    }

    public static /* synthetic */ void showLoading$default(SearchResultView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.showLoading(r1);
    }

    public static /* synthetic */ void refreshResult$default(SearchResultView r0, List r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.refreshResult(r1, r2);
    }

    public static /* synthetic */ void setSearchEmptyViewConfig$default(SearchResultView r1, Integer r2, CharSequence r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        r1.setSearchEmptyViewConfig(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showErrorRetry$default(SearchResultView r0, CharSequence r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.showErrorRetry(r1, r2);
    }
}
