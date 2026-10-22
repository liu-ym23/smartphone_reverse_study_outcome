package com.larus.search.impl.combine;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.f5;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.utils.a4;
import com.larus.business.search.impl.databinding.LarusFragmentCombineSearchBinding;
import com.larus.chat.search.common.view.SearchHistoryItemView;
import com.larus.common_res.common_ui.databinding.LarusViewSearchBarBinding;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.search.SearchBar;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatService;
import com.larus.search.impl.combine.recommend.SearchRecommendBotAdapter;
import com.larus.search.impl.combine.recommend.SearchRecommendBotModel;
import com.larus.search.impl.common.ConversationRepoManager;
import com.larus.search.impl.global.view.SearchResultItemView;
import com.larus.search.impl.view.SingleItemAdapter;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.trace.tracknode.a$a;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import ic8.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import tx9.a1;
import tx9.e1;
import tx9.i3;
import tx9.w3;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t*\u0004\u0095\u0001\u009b\u0001\u0018\u0000 ¦\u00012\u00020\u0001:\u0006¥\u0001¦\u0001§\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00103\u001a\u000204H\u0002J<\u00105\u001a\u0002042\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\"2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010A\u001a\u00020B2\u0006\u0010>\u001a\u00020?2\u0006\u0010C\u001a\u00020\u0018H\u0002J\u0012\u0010D\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010BH\u0016J&\u0010F\u001a\u0004\u0018\u00010-2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010E\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020BH\u0016J\u0012\u0010M\u001a\u0002042\b\u0010E\u001a\u0004\u0018\u00010BH\u0016J\u000f\u0010N\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010OJ\b\u0010P\u001a\u000204H\u0002J\u001a\u0010Q\u001a\u0002042\u0006\u0010R\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00010BH\u0016J\b\u0010S\u001a\u000204H\u0002J\b\u0010T\u001a\u000204H\u0002J\b\u0010U\u001a\u00020\u0012H\u0002J\b\u0010V\u001a\u000204H\u0016J\b\u0010W\u001a\u000204H\u0016J\b\u0010X\u001a\u000204H\u0016J\u0010\u0010[\u001a\u0002042\u0006\u0010%\u001a\u00020\u0018H\u0002J\b\u0010\\\u001a\u00020\u0018H\u0002J\u001c\u0010]\u001a\u0002042\b\b\u0002\u0010^\u001a\u00020\u00122\b\b\u0002\u0010_\u001a\u00020\u0012H\u0002J\b\u0010a\u001a\u000204H\u0002J\b\u0010b\u001a\u000204H\u0002J\b\u0010c\u001a\u000204H\u0002J\b\u0010d\u001a\u000204H\u0002J\b\u0010e\u001a\u000204H\u0002J\b\u0010f\u001a\u000204H\u0002J\b\u0010g\u001a\u000204H\u0002J\u0010\u0010h\u001a\u0002042\u0006\u0010i\u001a\u00020\u001cH\u0002J\u0010\u0010j\u001a\u0002042\u0006\u0010i\u001a\u00020\u001cH\u0002J \u0010k\u001a\u0002042\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010n\u001a\u00020\u0012H\u0016J\b\u0010o\u001a\u000204H\u0016J\b\u0010p\u001a\u00020\u0018H\u0016J\u0010\u0010q\u001a\u0002042\u0006\u0010>\u001a\u00020rH\u0016J\u0018\u0010s\u001a\u0002042\u0006\u0010t\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u001cH\u0002J\u0018\u0010|\u001a\u0004\u0018\u00010\u00182\u0006\u0010}\u001a\u00020~H\u0082@¢\u0006\u0002\u0010\u007fJ\u0013\u0010\u0080\u0001\u001a\u00020\u00182\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J6\u0010\u0081\u0001\u001a\u0002042\u0006\u0010}\u001a\u00020~2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J1\u0010\u0085\u0001\u001a\u0002042\u0006\u0010}\u001a\u00020~2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010u\u001a\u00020\u001c2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0092\u0001\u001a\u0002042\u0007\u0010\u0093\u0001\u001a\u00020~H\u0002J!\u0010\u0097\u0001\u001a\u0002042\u0006\u0010t\u001a\u00020\u00122\u0007\u0010\u0098\u0001\u001a\u000207H\u0082@¢\u0006\u0003\u0010\u0099\u0001J1\u0010\u009d\u0001\u001a\u0002042\u0006\u0010t\u001a\u00020\u00122\u000e\u0010\u009e\u0001\u001a\t\u0012\u0004\u0012\u0002090\u009f\u00012\u0007\u0010 \u0001\u001a\u00020\u0018H\u0082@¢\u0006\u0003\u0010¡\u0001J\u0011\u0010¢\u0001\u001a\u0002042\u0006\u0010}\u001a\u00020~H\u0002J\u0011\u0010£\u0001\u001a\u0002042\u0006\u0010}\u001a\u00020~H\u0002J\u0011\u0010¤\u0001\u001a\u0002042\u0006\u0010}\u001a\u00020~H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000b\u001a\u0004\b0\u00101R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0088\u0001\u001a\u00030\u0089\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u0010\u000b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u008d\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010\u000b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0013\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0096\u0001R\u0013\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009c\u0001¨\u0006¨\u0001"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/business/search/impl/databinding/LarusFragmentCombineSearchBinding;", "model", "Lcom/larus/search/impl/combine/CombineSearchViewModel;", "getModel", "()Lcom/larus/search/impl/combine/CombineSearchViewModel;", "model$delegate", "Lkotlin/Lazy;", "recommendBotModel", "Lcom/larus/search/impl/combine/recommend/SearchRecommendBotModel;", "getRecommendBotModel", "()Lcom/larus/search/impl/combine/recommend/SearchRecommendBotModel;", "recommendBotModel$delegate", "shouldShowRecommend", "", "getShouldShowRecommend", "()Z", "shouldShowRecommend$delegate", "historyHasExpand", "keyword", "", "keywordId", "lastKeyword", "imePadding", "", "decorViewRect", "Landroid/graphics/Rect;", "autoSearchInfo", "Lcom/larus/search/impl/combine/model/SearchResultSnapshot;", "searchResultStartTime", "", "searchType", "openFromSearchBar", "enterMethod", "previousPage", "lastLoadMoreKey", "Lcom/larus/search/impl/combine/CombineSearchFragment$LoadMoreKey;", "lastLoadMoreTime", "searchHistoryList", "Landroid/widget/LinearLayout;", "recommendBotLoadingView", "Landroid/view/View;", "searchHistoryRepo", "Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "getSearchHistoryRepo", "()Lcom/larus/chat/search/api/GlobalSearchHistoryRepo;", "searchHistoryRepo$delegate", "tryHideSoftKeyboard", "", "openChat", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "localIndex", "messageId", "searchHighlightKeyword", "switchConversation", "params", "Lcom/larus/bmhome/chat/resp/SwitchConversationParams;", "keepConversationOnTop", "getCommonBundle", "Landroid/os/Bundle;", "pageName", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewStateRestored", "setImeHeightListener", "()Lkotlin/Unit;", "resetPadding", "onViewCreated", "view", "startCreateBot", "initHistoryAndRecommendView", "isInOnlySearchPage", "onResume", "onPause", "onDestroyView", "loadStatus", "Lcom/larus/paging/LoadState;", "setDataSource", "getQuery", "updateLoadingView", "showLoading", "showEmpty", "recordClickHistory", "loadRecommendBots", "loadHistoryList", "addHistory", "loadSearchHistory", "addHistoryClearAllView", "addHistoryExpandView", "addHistoryDivider", "reportSearchItemShow", "index", "reportRecommendItemShow", "reportStayTime", "query", "queryId", "autoLogEnterPage", "logEnterPage", "getCurrentPageName", "fillTrackParams", "Lcom/ixigua/lib/track/TrackParams;", "notifyItemChange", "isFromRecommend", "position", "searchItemListener", "Lcom/larus/search/impl/combine/CombineSearchItemListener;", "globalSearchResultAdapter", "Lcom/larus/search/impl/combine/CombineSearchResultAdapter;", "recommendBotAdapter", "Lcom/larus/search/impl/combine/recommend/SearchRecommendBotAdapter;", "checkAndCreateLocalConversation", "data", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatType", "directToRealtimeCall", "conversationId", "clickEnterFrom", "argPosition", "toChatFragment", "observeBotChangeJob", "Lkotlinx/coroutines/Job;", "service", "Lcom/larus/im/service/IConversationReceiverService;", "getService", "()Lcom/larus/im/service/IConversationReceiverService;", "service$delegate", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "observeBotChange", "bot", "botStatusObserver", "com/larus/search/impl/combine/CombineSearchFragment$botStatusObserver$1", "Lcom/larus/search/impl/combine/CombineSearchFragment$botStatusObserver$1;", "notifyItemChangedWhenConversationChange", "newConversation", "(ZLcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "botUpdateListener", "com/larus/search/impl/combine/CombineSearchFragment$botUpdateListener$1", "Lcom/larus/search/impl/combine/CombineSearchFragment$botUpdateListener$1;", "notifyItemChangedWhenBotUpdate", "changedBots", "", "botId", "(ZLjava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportBotAdd", "reportConfirmUnfollowBot", "reportBotRemove", "LoadMoreKey", "Companion", "EventHelper", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CombineSearchFragment extends TraceFragment {
    public static final /* synthetic */ int G = 0;
    public final SearchRecommendBotAdapter A;
    public Job B;
    public final Lazy C;
    public final Lazy D;
    public final c E;
    public final CombineSearchFragment$botUpdateListener$1 F;
    public LarusFragmentCombineSearchBinding e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public boolean i;
    public String j;
    public String k;
    public int l;
    public final Rect m;
    public us9.a n;
    public long o;
    public int p;
    public boolean q;
    public String r;
    public String s;
    public b t;
    public long u;
    public LinearLayout v;
    public View w;
    public final Lazy x;
    public boolean y;
    public final CombineSearchResultAdapter z;

    public final class EventHelper implements SearchResultItemView.b {
        public final boolean a;
        public final /* synthetic */ CombineSearchFragment b;

        public static final class a implements com.larus.common_ui.dialog.u {
            public a() {
            }

            public final void cancel() {
            }
        }

        public EventHelper(CombineSearchFragment r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void a(RecommendBot r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "data");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new CombineSearchFragment$EventHelper$onBotAdd$1(this.b, r11, this, r12, null), 3, null);
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void b(final RecommendBot r23, final int r24) {
            Intrinsics.checkNotNullParameter(r23, "data");
            CombineSearchFragment r2 = this.b;
            int r3 = CombineSearchFragment.G;
            r2.da0().a(this.b.j);
            CommonDialog.a r4 = new CommonDialog.a();
            r4.i(this.b.getString(2131900768));
            r4.g(this.b.getString(2131900204));
            final CombineSearchFragment r5 = this.b;
            boolean r6 = false;
            CommonDialog.a.f(r4, new CombineSearchFragment$EventHelper$onBotRemove$1(r5, r23, this, r24), r5.getString(2131900203), false, 12);
            CommonDialog.a.e(r4, new a(), this.b.getString(2131900202), 4);
            CommonDialog r7 = r4.a();
            FragmentManager r8 = this.b.getChildFragmentManager();
            LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            String r10 = null;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, null, r9);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r7, r9) == false) goto L40;
        L7:
            a4.a.getClass();
            a4.a(a4.b);
            CombineSearchFragment r11 = this.b;
            r11.getClass();
            if (AudioServiceDelegate.a.B(r23.o(), r23.r(), r23.c0()) == null) goto L11;
            r6 = true;
        L11:
            if (r6 == false) goto L13;
            String r18 = "1";
        L14:
            String r12 = r23.o();
            SearchMobParam r13 = r23.b;
            if (r13 == null) goto L17;
            String r15 = r13.c;
        L18:
            if (r13 == null) goto L20;
            String r16 = r13.d;
        L21:
            if (r13 == null) goto L23;
            String r17 = r13.e;
        L24:
            if (r13 == null) goto L26;
            String r14 = r13.f;
        L28:
            if (o0.d(r23.e()) == false) goto L30;
            String r19 = "1";
        L31:
            RecommendFrom r1 = r23.a;
            if (r1 == null) goto L34;
            String r110 = r1.b;
        L35:
            if (r1 == null) goto L37;
            r10 = r1.a;
        L37:
            w3.a(r12, "click_check", null, r19, null, r14, r10, r110, r15, r16, r17, r18, null, r11, 99444);
            return;
        L34:
            r110 = null;
            goto L35
        L30:
            r19 = "0";
            goto L31
        L26:
            r14 = null;
            goto L28
        L23:
            r17 = null;
            goto L24
        L20:
            r16 = null;
            goto L21
        L17:
            r15 = null;
            goto L18
        L13:
            r18 = "0";
            goto L14
        L40:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
        L6:
            r7.show(r8, null);
            goto L7
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void c(RecommendBot r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "data");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new CombineSearchFragment$EventHelper$onUpdateCreateScene$1(this.b, r11, this, r12, null), 3, null);
        }

        @Override // com.larus.search.impl.global.view.SearchResultItemView.b
        public final void d(RecommendBot r11, int r12) {
            Intrinsics.checkNotNullParameter(r11, "data");
            CombineSearchFragment r0 = this.b;
            int r1 = CombineSearchFragment.G;
            r0.da0().a(this.b.j);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new CombineSearchFragment$EventHelper$onBotClick$1(this.b, r11, r12, this, null), 3, null);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final boolean b;
        public final int c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((r0 + r1) * 31) + this.c) * 31;
            String r3 = this.d;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "LoadMoreKey(keyword=" + this.a + ", loadMoreBot=" + this.b + ", itemCount=" + this.c + ", lastItemId=" + this.d + ')';
        }

        public b(String r2, boolean r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "keyword");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c implements com.larus.im.service.z<List<? extends wc9.e>> {
        public final /* synthetic */ CombineSearchFragment a;

        public c(CombineSearchFragment r1) {
            this.a = r1;
        }

        public final void c(Object r5) {
            List r6 = (List) r5;
            Intrinsics.checkNotNullParameter(r6, SlashMentionConfig.MENTION_CONTENT_CONVERSATION);
            wc9.e r7 = (wc9.e) CollectionsKt.getOrNull(r6, 0);
            if (r7 == null) goto L13;
            Integer r0 = r7.f;
            if (r0 != null) goto L9;
        L11:
            LifecycleOwnerKt.getLifecycleScope(this.a).launchWhenResumed(new CombineSearchFragment$botStatusObserver$1$onChange$1(this.a, r7, null));
            return;
        L9:
            if (r0.intValue() != 1) goto L11;
            return;
        }
    }

    public static final class d implements com.larus.search.impl.combine.recommend.a {
        public final /* synthetic */ CombineSearchFragment a;

        @Override // com.larus.search.impl.combine.recommend.a
        public final void a() {
            CombineSearchFragment r0 = this.a;
            int r1 = CombineSearchFragment.G;
            ((SearchRecommendBotModel) r0.g.getValue()).loadMore();
        }

        public d(CombineSearchFragment r1) {
            this.a = r1;
        }
    }

    public static final class e implements a0 {
        public final /* synthetic */ CombineSearchFragment a;

        @Override // com.larus.search.impl.combine.a0
        public final void a() {
            CombineSearchFragment r0 = this.a;
            int r1 = r0.p;
            String r2 = null;
            boolean r3 = true;
            if (r1 != 1) goto L5;
        L21:
            FLogger.a.i("CombineSearchFragment", "loadMore loadMoreBot: " + r3);
            CombineSearchFragment r4 = this.a;
            String r5 = r4.j;
            int r6 = r4.z.getItemCount();
            c0 r7 = (c0) CollectionsKt.lastOrNull(this.a.z.getCurrentList());
            if (r7 == null) goto L24;
            r2 = r7.a;
        L24:
            b r8 = new b(r5, r3, r6, r2);
            long r9 = SystemClock.elapsedRealtime();
            if (Intrinsics.areEqual(this.a.t, r8) == true) goto L27;
        L29:
            CombineSearchFragment r10 = this.a;
            r10.t = r8;
            r10.u = r9;
            if (r3 == false) goto L32;
            r10.ca0().loadBots(this.a.j, false);
            return;
        L32:
            r10.ca0().loadMessage(this.a.j, false);
            return;
        L27:
            if ((r9 - this.a.u) >= 500) goto L29;
            return;
        L5:
            if (r1 == 2) goto L20;
            CombineSearchResultAdapter r11 = r0.z;
            int r12 = CollectionsKt.getLastIndex(r11.getCurrentList());
            if (r12 >= 0) goto L9;
        L11:
            r3 = false;
        L12:
            if (r3 == false) goto L16;
            c0 r13 = (c0) CollectionsKt.getOrNull(r11.getCurrentList(), r12);
            if (r13 == null) goto L16;
            Boolean r14 = Boolean.valueOf(r13.c);
        L17:
            if (r14 == null) goto L19;
            r3 = r14.booleanValue();
            goto L21
        L19:
            return;
        L16:
            r14 = null;
            goto L17
        L9:
            if (r12 >= r11.getItemCount()) goto L11;
        L20:
            r3 = false;
            goto L21
        }

        public e(CombineSearchFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.search.impl.combine.a0
        public final void b(c0 r31) {
            Intrinsics.checkNotNullParameter(r31, "result");
            wc9.e r4 = r31.d;
            BotModel r5 = r31.e;
            long r7 = r31.k;
            CombineSearchFragment r2 = this.a;
            int r3 = CombineSearchFragment.G;
            r2.Z90();
            LarusFragmentCombineSearchBinding r6 = this.a.e;
            if (r6 == null) goto L8;
            SearchBar r8 = r6.c;
            if (r8 == null) goto L8;
            ViewExtKt.g(r8);
        L8:
            if (r31.getType() != 17) goto L10;
            String r9 = r31.a;
        L12:
            if (r31.getType() != 17) goto L14;
            String r10 = r31.p;
        L15:
            CombineSearchFragment r11 = this.a;
            r11.getClass();
            if (r4 == null) goto L40;
            ConversationPage r12 = r4.g;
            if (r12 == null) goto L21;
            List r13 = r12.getPageList();
        L22:
            boolean r14 = l0.b(r13);
            FLogger r15 = FLogger.a;
            r15.i("CombineSearchFragment", "name is >>> " + r4.c);
            r15.i("CombineSearchFragment", "botConversationType is >>> " + r4.v);
            StringBuilder r16 = new StringBuilder("open chat from combine search conversationId=");
            r16.append(r4.a);
            r16.append(", messageId=");
            r16.append(r9);
            r16.append(", localIndex=");
            r16.append(r7);
            r16.append(", highlight=");
            if (r10 != null) goto L25;
            String r17 = "";
        L26:
            String r18 = StringsKt.replace$default(StringsKt.replace$default(r17, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (r18.length() <= 32) goto L30;
            r18 = StringsKt.take(r18, 32) + "...";
        L30:
            r16.append(r18);
            r16.append(", isShowTab=");
            r16.append(r14);
            r15.d("search_landing", r16.toString());
            Integer r19 = r4.v;
            if (r19 != null) goto L34;
        L36:
            boolean r20 = false;
        L37:
            if (r20 == false) goto L39;
            r15.i("CombineSearchFragment", "current conversation is douyin");
            SmartRouter.buildRoute(r11.getContext(), "//flow/douyin_bot").d();
            goto L40
        L39:
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), null, null, new CombineSearchFragment$openChat$1(r4, r5, r14, r7, r9, r10, r11, null), 3, null);
            goto L40
        L34:
            if (r19.intValue() != 4) goto L36;
            r20 = true;
            goto L37
        L25:
            r17 = r10;
            goto L26
        L21:
            r13 = null;
        L40:
            String r110 = IAIChatService.a.U7(r31.d);
            if (r31.getType() != 16) goto L43;
            String r21 = "chat";
        L44:
            String r24 = r21;
            Boolean r1 = r31.n;
            if (r1 != null) goto L48;
            String r25 = null;
        L52:
            i3.e(null, r110, null, null, null, null, null, r24, r25, null, Boolean.TRUE, this.a, 21501);
            return;
        L48:
            if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L50;
            String r22 = "user";
        L51:
            r25 = r22;
            goto L52
        L50:
            r22 = "bot";
            goto L51
        L43:
            r21 = "chat_history";
            goto L44
        L14:
            r10 = null;
            goto L15
        L10:
            r9 = null;
            goto L12
        }

        @Override // com.larus.search.impl.combine.a0
        public final void c(boolean r5) {
            CombineSearchFragment r0 = this.a;
            int r1 = CombineSearchFragment.G;
            r0.Z90();
            us9.a r2 = b0.a;
            us9.a r3 = this.a.ca0().getAutoSearchInfo();
            Intrinsics.checkNotNullParameter(r3, "autoSearchInfo");
            b0.a = r3;
            com.bytedance.router.i r4 = SmartRouter.buildRoute(this.a.getContext(), "//flow/combine_search");
            if (r5 == false) goto L5;
            int r6 = 1;
        L6:
            r4.c.putExtra("key.search.type", r6);
            r4.c.putExtra("key_auto_search", true);
            boolean r7 = this.a.q;
            r4.c.putExtra("key_open_from_search_bar", r7);
            Bundle r8 = BundleKt.bundleOf();
            by7.h.k(r8, this.a);
            r4.c.putExtras(r8);
            r4.d = 2130772401;
            r4.e = 2130772399;
            r4.e(1);
            return;
        L5:
            r6 = 2;
            goto L6
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final void T90() {
        String r15 = k();
        String r0 = this.s;
        a1.c(null, null, null, null, null, null, null, null, this.r, null, null, null, null, null, null, r15, r0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -1573889, -16777217, 7);
    }

    public final CombineSearchViewModel ca0() {
        return (CombineSearchViewModel) this.f.getValue();
    }

    public final hz8.a da0() {
        return (hz8.a) this.x.getValue();
    }

    public final boolean ea0() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    public final boolean fa0() {
        if (this.p == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void ga0() {
        CombineSearchResultAdapter r0 = this.z;
        r0.c = 0;
        r0.submitList(CollectionsKt.emptyList());
        r0.notifyDataSetChanged();
        this.t = null;
        this.u = 0;
        LarusFragmentCombineSearchBinding r1 = this.e;
        if (r1 == null) goto L7;
        RecyclerView r2 = r1.f;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
    L7:
        LarusFragmentCombineSearchBinding r3 = this.e;
        if (r3 == null) goto L12;
        LoadingWithRetryView r4 = r3.b;
        if (r4 == null) goto L12;
        r4.setVisibility(8);
    L12:
        ha0();
    }

    public final String k() {
        if (Intrinsics.areEqual(this.r, "click_navigation_cell") == false) goto L6;
        return "chat_list_discover_search";
    L6:
        if (fa0() == false) goto L12;
        if (this.q == false) goto L10;
        return "chat_list_discover_search_sec";
    L10:
        return "chat_list_icon_search_sec";
    L12:
        if (this.q == true) goto L19;
        return "chat_list_icon_search";
    L19:
        return "chat_list_discover_search";
    }

    public CombineSearchFragment() {
        final Function0<Fragment> r0 = new CombineSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CombineSearchViewModel.class), new CombineSearchFragment$special$$inlined$viewModels$default$2(r0), new CombineSearchFragment$special$$inlined$viewModels$default$3(r0, this));
        final Function0<Fragment> r1 = new CombineSearchFragment$special$$inlined$viewModels$default$4(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SearchRecommendBotModel.class), new CombineSearchFragment$special$$inlined$viewModels$default$5(r1), new CombineSearchFragment$special$$inlined$viewModels$default$6(r1, this));
        this.h = LazyKt.lazy(new com.larus.search.impl.combine.a());
        this.j = "";
        this.m = new Rect();
        this.x = LazyKt.lazy(new l());
        this.z = new CombineSearchResultAdapter(new e(this), new EventHelper(this, false));
        this.A = new SearchRecommendBotAdapter(new d(this), new EventHelper(this, true));
        this.C = LazyKt.lazy(new n());
        this.D = LazyKt.lazy(new o());
        this.E = new c(this);
        this.F = new CombineSearchFragment$botUpdateListener$1(this);
    }

    public final void Z90() {
        if (fa0() == false) goto L5;
        return;
    L5:
        da0().a(this.j);
    }

    public final void ha0() {
        if (fa0() == false) goto L5;
        return;
    L5:
        LinearLayout r0 = this.v;
        if (r0 == null) goto L8;
        r0.removeAllViews();
    L8:
        LarusFragmentCombineSearchBinding r1 = this.e;
        if (r1 == null) goto L13;
        FrameLayout r2 = r1.d;
        if (r2 == null) goto L13;
        r2.setVisibility(0);
    L13:
        Context r3 = getContext();
        if (r3 != null) goto L16;
        return;
    L16:
        List r4 = da0().d;
        ArrayList r5 = new ArrayList();
        Iterator r6 = ((ArrayList) r4).iterator();
    L18:
        if (r6.hasNext() == false) goto L21;
        final String r7 = (String) r6.next();
        SearchHistoryItemView r8 = new SearchHistoryItemView(r3, null);
        r8.a(r7);
        r8.setOnItemClickListener(new q(this, r7));
        r8.setOnRemoveClickListener(new r(this, r7));
        r5.add(r8);
        goto L18
    L21:
        if (ea0() == true) goto L23;
    L36:
        Iterator r9 = r5.iterator();
    L38:
        if (r9.hasNext() == false) goto L42;
        View r10 = (SearchHistoryItemView) r9.next();
        LinearLayout r11 = this.v;
        if (r11 == null) goto L38;
        r11.addView(r10);
        goto L38
    L42:
        int r12 = r5.size();
        List r13 = r5;
        if (r12 <= 2) goto L48;
        LinearLayout r14 = this.v;
        r13 = r5;
        if (r14 == null) goto L48;
        TextView r15 = new TextView(getContext());
        r15.setText(r15.getContext().getText(2131909137));
        r15.setTextSize(1, 15.0f);
        r15.setTextColor(ContextCompat.getColor(r15.getContext(), 2131103143));
        r15.setGravity(17);
        r15.setOnClickListener(new g(this));
        r14.addView(r15, new LinearLayout.LayoutParams(-1, i5.W()));
        r13 = r5;
    L48:
        if (ea0() == true) goto L50;
        return;
    L50:
        if ((!r13.isEmpty()) == false) goto L67;
        LinearLayout r16 = this.v;
        if (r16 == null) goto L68;
        View r17 = new View(getContext());
        r17.setBackgroundResource(2131103162);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-1, i5.a());
        r18.setMargins(i5.q(), i5.h(), i5.q(), i5.h());
        Unit r19 = Unit.INSTANCE;
        r16.addView(r17, r18);
        return;
    L68:
        return;
    L67:
        return;
    L23:
        if (this.i == true) goto L36;
        List r20 = r5.subList(0, Math.min(2, r5.size()));
        Iterator r21 = r20.iterator();
    L26:
        if (r21.hasNext() == false) goto L31;
        View r22 = (SearchHistoryItemView) r21.next();
        LinearLayout r110 = this.v;
        if (r110 == null) goto L26;
        r110.addView(r22);
        goto L26
    L31:
        if (r5.size() <= 2) goto L35;
        LinearLayout r23 = this.v;
        if (r23 == null) goto L35;
        TextView r24 = new TextView(getContext());
        r24.setText(r24.getContext().getText(2131900828));
        r24.setTextSize(1, 15.0f);
        r24.setTextColor(ContextCompat.getColor(r24.getContext(), 2131103143));
        r24.setGravity(17);
        r24.setOnClickListener(new m(this));
        r23.addView(r24, new LinearLayout.LayoutParams(-1, i5.W()));
    L35:
        r13 = r20;
        goto L48
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        ((com.larus.im.service.q) this.C.getValue()).unRegisterConversationChangeListener(this.E);
        com.larus.im.service.o r0 = (com.larus.im.service.o) this.D.getValue();
        CombineSearchFragment$botUpdateListener$1 r1 = this.F;
        r0.unregisterBotChangeListener(r1.a, r1);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        LarusFragmentCombineSearchBinding r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L9;
        RecyclerView r2 = r0.f;
        if (r2 == null) goto L9;
        if (r2.getVisibility() != 0) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (this.z.getItemCount() <= 0) goto L15;
        ia0(this.j, this.k);
        return;
    }

    public final void onResume() {
        super.onResume();
        LarusFragmentCombineSearchBinding r0 = this.e;
        boolean r1 = false;
        if (r0 == null) goto L20;
        RelativeLayout r2 = r0.a;
        if (r2.isAttachedToWindow() == false) goto L19;
        WindowInsetsCompat r3 = ViewCompat.getRootWindowInsets(r2);
        if (r3 == null) goto L11;
        Insets r4 = r3.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r4 == null) goto L11;
        int r5 = r4.bottom;
    L12:
        WindowInsetsCompat r6 = ViewCompat.getRootWindowInsets(r2);
        if (r6 == null) goto L17;
        Insets r7 = r6.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r7 == null) goto L17;
        int r8 = r7.top;
    L18:
        int r9 = r2.getPaddingStart();
        int r10 = r2.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r2.getClass().getSimpleName() + ",source:resetPadding,start:" + r9 + ",top:" + r8 + ",end:" + r10 + ",bottom:" + r5);
        r2.setPaddingRelative(r9, r8, r10, r5);
    L17:
        r8 = 0;
    L11:
        r5 = 0;
        goto L12
    L19:
        r2.addOnAttachStateChangeListener(new y(r2));
    L20:
        LarusFragmentCombineSearchBinding r11 = this.e;
        if (r11 == null) goto L27;
        RecyclerView r12 = r11.f;
        if (r12 == null) goto L27;
        if (r12.getVisibility() != 0) goto L27;
        r1 = true;
    L27:
        if (r1 == true) goto L29;
        return;
    L29:
        if (this.z.getItemCount() <= 0) goto L33;
        this.o = SystemClock.elapsedRealtime();
        return;
    }

    public final String aa0(RecommendBot r5) {
        String r0 = null;
        if (r5 == null) goto L5;
        Integer r1 = r5.r();
    L6:
        if (r1 != null) goto L9;
    L11:
        if (r1 != null) goto L14;
    L22:
        if (r1 != null) goto L25;
    L27:
        return "other_default";
    L25:
        if (r1.intValue() != 4) goto L27;
        return "notice";
    L14:
        if (r1.intValue() != 0) goto L22;
        BotCreatorInfo r6 = r5.j();
        if (r6 == null) goto L19;
        r0 = r6.getId();
    L19:
        if (Intrinsics.areEqual(r0, AccountService.a.getUserId()) == false) goto L21;
        return "self_created";
    L21:
        return "others_created";
    L9:
        if (r1.intValue() != 1) goto L11;
        return "default";
    L5:
        r1 = null;
        goto L6
    }

    public final void fillTrackParams(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        a$a.a(this, r3);
        r3.putIfNull("query", this.j);
        r3.putIfNull("query_id", this.k);
        r3.putIfNull("function_type", "chat_bot_search");
        if (fa0() == true) goto L5;
        return;
    L5:
        if (this.p != 1) goto L7;
        String r0 = "click_search_bot_all";
    L8:
        r3.putIfNull("enter_method", r0);
        return;
    L7:
        r0 = "click_search_chat_all";
        goto L8
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        IFlowChatThemeConfigProvider r5 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r5 == null) goto L5;
        r5.d(new com.larus.search.impl.combine.e(this), new f(this), AdaptThemeFeatureKey.CHAT_SEARCH_TYPE);
    L5:
        Bundle r6 = getArguments();
        boolean r0 = false;
        if (r6 == null) goto L8;
        boolean r7 = r6.getBoolean("key_open_from_search_bar", false);
    L9:
        this.q = r7;
        Bundle r8 = getArguments();
        String r1 = null;
        if (r8 == null) goto L12;
        String r9 = r8.getString("enter_method");
    L13:
        this.r = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L16;
        r1 = r10.getString("previous_page");
    L16:
        this.s = r1;
        Bundle r11 = getArguments();
        if (r11 != null) goto L19;
    L21:
        if (r0 == false) goto L24;
        us9.a r12 = b0.a;
        this.n = b0.a;
        return;
    L24:
        return;
    L19:
        if (r11.getBoolean("key_auto_search", false) != true) goto L21;
        r0 = true;
        goto L21
    L12:
        r9 = null;
        goto L13
    L8:
        r7 = false;
        goto L9
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r3);
        LarusFragmentCombineSearchBinding r0 = this.e;
        if (r0 == null) goto L7;
        SearchBar r1 = r0.c;
        if (r1 == null) goto L7;
        boolean r2 = ViewExtKt.h(r1);
    L8:
        r3.putBoolean("show_ime", r2);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void onViewStateRestored(Bundle r3) {
        super/*androidx.fragment.app.Fragment*/.onViewStateRestored(r3);
        boolean r0 = false;
        if (r3 != null) goto L5;
    L7:
        if (r0 == false) goto L14;
        LarusFragmentCombineSearchBinding r4 = this.e;
        if (r4 == null) goto L15;
        SearchBar r5 = r4.c;
        if (r5 == null) goto L16;
        r5.b();
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r3.getBoolean("show_ime") != true) goto L7;
        r0 = true;
        goto L7
    }

    public static final void X90(CombineSearchFragment r18, RecommendBot r19) {
        r18.getClass();
        String r1 = r19.o();
        String r14 = r19.o();
        String r7 = r18.aa0(r19);
        SearchMobParam r2 = r19.b;
        if (r2 == null) goto L5;
        String r10 = r2.c;
    L6:
        if (r2 == null) goto L8;
        String r11 = r2.d;
    L9:
        if (r2 == null) goto L11;
        String r12 = r2.e;
    L12:
        if (r2 == null) goto L14;
        String r8 = r2.f;
    L15:
        RecommendFrom r3 = r19.a;
        if (r3 == null) goto L18;
        String r9 = r3.b;
    L19:
        if (r3 == null) goto L21;
        String r16 = r3.c;
    L22:
        e1.a(r1, r7, null, null, "click_plus", null, null, r8, r16, r9, r10, r11, r12, "private", r14, r19.I0("").a(null), r18, 280505);
        return;
    L21:
        r16 = null;
        goto L22
    L18:
        r9 = null;
        goto L19
    L14:
        r8 = null;
        goto L15
    L11:
        r12 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    public static final void Y90(CombineSearchFragment r6, String r7) {
        r6.ca0().updateKeyWord(r6.j);
        if (r6.j.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank(r6.j) == true) goto L36;
        LarusFragmentCombineSearchBinding r1 = r6.e;
        if (r1 == null) goto L15;
        RecyclerView r2 = r1.f;
        if (r2 == null) goto L15;
        y6.i(r2);
    L15:
        LarusFragmentCombineSearchBinding r3 = r6.e;
        int r4 = 8;
        if (r3 == null) goto L20;
        FrameLayout r5 = r3.d;
        if (r5 == null) goto L20;
        r5.setVisibility(8);
    L20:
        LarusFragmentCombineSearchBinding r8 = r6.e;
        if (r8 == null) goto L28;
        LoadingWithRetryView r9 = r8.b;
        if (r9 == null) goto L28;
        if (Intrinsics.areEqual(null, com.larus.paging.u.b.b) == false) goto L27;
        r4 = 0;
    L27:
        r9.setVisibility(r4);
    L28:
        LarusFragmentCombineSearchBinding r10 = r6.e;
        if (r10 == null) goto L33;
        RecyclerView r11 = r10.f;
        if (r11 == null) goto L33;
        r11.setVisibility(0);
    L33:
        CombineSearchResultAdapter r12 = r6.z;
        r12.c = 0;
        r12.submitList(CollectionsKt.emptyList());
        r12.notifyDataSetChanged();
        r6.t = null;
        r6.u = 0;
        r6.ca0().loadFirstPageData(r6.j, r6.p, r7);
        ka0(r6, true, false, 2);
        return;
    L36:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final Bundle ba0(ni8.e r4, String r5) {
        return com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r5), TuplesKt.to("argConversationId", r4.a), TuplesKt.to("argBotId", r4.j), TuplesKt.to("argBotType", r4.n), TuplesKt.to("argClickEnterFrom", r4.k), TuplesKt.to("argCvsBgImgUrl", r4.b), TuplesKt.to("argCvsBgImgColor", r4.c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r4.d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r4.i)), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "bot_list"), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("target_middle_msg_local_index", Long.valueOf(r4.o)), TuplesKt.to("target_middle_msg_id", r4.q), TuplesKt.to("message_id", r4.q), TuplesKt.to("is_single_mode", Boolean.TRUE), TuplesKt.to("is_unread_dot_enable", Boolean.FALSE), TuplesKt.to("search_keyword", r4.r), TuplesKt.to("search_highlight_keyword", r4.s), TuplesKt.to("argBotConversationType", Integer.valueOf(r4.v))});
    }

    public final void ia0(String r13, String r14) {
        if (this.o != 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.elapsedRealtime() - this.o;
        CombineSearchResultAdapter r4 = this.z;
        int r5 = CollectionsKt.getLastIndex(r4.getCurrentList());
    L6:
        String r7 = null;
        if ((-1) >= r5) goto L19;
        ws9.b r6 = ((c0) ListProtector.get(r4.getCurrentList(), r5)).q;
        if (r6 == null) goto L16;
        RecommendBot r8 = r6.a();
        if (r8 == null) goto L16;
        SearchMobParam r9 = r8.b;
        if (r9 == null) goto L16;
        r7 = r9.c;
    L16:
        if (o0.d(r7) == true) goto L19;
        r5 = r5 - 1;
    L19:
        i3.g(Long.valueOf(r0), r13, r14, r7, this, 433);
        this.o = 0;
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        ca0().setTrackNode(this);
        ca0().getSearchResultLv().observe(getViewLifecycleOwner(), new z(new s(this)));
        if (ea0() == false) goto L5;
        ((SearchRecommendBotModel) this.g.getValue()).getRecommendBotDataLv().observe(getViewLifecycleOwner(), new z(new t(this)));
    L5:
        final LarusFragmentCombineSearchBinding r2 = this.e;
        if (r2 == null) goto L10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CombineSearchFragment$onViewCreated$3$1(r2, this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CombineSearchFragment$onViewCreated$3$2(r2, this, null), 3, null);
        r2.f.setItemAnimator(null);
        r2.f.setLayoutManager(new LinearLayoutManager(getContext()));
        r2.f.setAdapter(this.z);
        r2.f.addOnScrollListener(new CombineSearchFragment$onViewCreated$3$3(r2));
        r2.f.addItemDecoration(new CombineSearchFragment$onViewCreated$3$4(this));
        y6.d(r2.f, new u(this), null, null, new com.larus.search.impl.combine.b(this), 13);
        r2.b.a();
        e10 r4 = e10.a;
        if (e10.i() == false) goto L10;
        r2.b.setTipsAction(new com.larus.search.impl.combine.c(this));
    L10:
        LarusFragmentCombineSearchBinding r3 = this.e;
        if (r3 != null) goto L13;
    L32:
        LarusFragmentCombineSearchBinding r5 = this.e;
        if (r5 == null) goto L44;
        ViewGroup r6 = r5.e;
        if (r6 == null) goto L44;
        r6.setItemAnimator(null);
        r6.setLayoutManager(new LinearLayoutManager(getContext()));
        ConcatAdapter r7 = new ConcatAdapter(new RecyclerView.Adapter[0]);
        LinearLayout r8 = new LinearLayout(getActivity());
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r8.setOrientation(1);
        int r9 = SingleItemAdapter.c;
        Intrinsics.checkNotNullParameter(r8, "view");
        r7.addAdapter(new SingleItemAdapter(r8));
        this.v = r8;
        if (ea0() == false) goto L43;
        View r10 = com.larus.utils.e1.m(r6).inflate(2131562650, r6, false);
        if (((ProgressBar) ViewBindings.findChildViewById(r10, 2131378977)) == null) goto L42;
        LinearLayout r11 = (LinearLayout) r10;
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNullParameter(r11, "view");
        r7.addAdapter(new SingleItemAdapter(r11));
        this.w = r11;
        r7.addAdapter(this.A);
        goto L43
    L42:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(2131378977)));
    L43:
        r6.setAdapter(r7);
        r6.addOnScrollListener(new CombineSearchFragment$initHistoryAndRecommendView$1$2(this));
        r6.addItemDecoration(new CombineSearchFragment$initHistoryAndRecommendView$1$3(this));
        y6.d(r6, new j(this), null, null, new k(this), 13);
    L44:
        ga0();
        if (fa0() == false) goto L48;
    L50:
        LarusFragmentCombineSearchBinding r1 = this.e;
        if (r1 == null) goto L72;
        SearchBar r12 = r1.c;
        if (r12 == null) goto L72;
        if (fa0() == false) goto L62;
        int r13 = r12.getPaddingTop();
        int r14 = r12.getPaddingEnd();
        int r15 = r12.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:SearchBar,source:,start:0,top:" + r13 + ",end:" + r14 + ",bottom:" + r15);
        r12.setPaddingRelative(0, r13, r14, r15);
        LarusViewSearchBarBinding r16 = r12.a;
        if (r16 == null) goto L62;
        AppCompatImageView r17 = r16.b;
        if (r17 == null) goto L62;
        r17.setVisibility(0);
    L62:
        if (fa0() == true) goto L64;
    L67:
        int r18 = 2131909105;
    L68:
        r12.setHint(getString(r18));
        if (this.n != null) goto L71;
        r12.b();
    L71:
        r12.setCustomCancelClickAction(new com.larus.search.impl.combine.d(this));
        goto L72
    L64:
        if (this.p == 2) goto L67;
        r18 = 2131906530;
    L72:
        ((com.larus.im.service.q) this.C.getValue()).registerConversationChangeListener(this.E);
        us9.a r19 = this.n;
        if (r19 == null) goto L81;
        String r22 = r19.a;
        this.j = r22;
        LarusFragmentCombineSearchBinding r23 = this.e;
        if (r23 == null) goto L79;
        SearchBar r24 = r23.c;
        if (r24 == null) goto L79;
        r24.setTextNoSearch(r22);
        ViewExtKt.g(r24);
    L79:
        ca0().setInitSearchInfo(r19);
        this.n = null;
        return;
    L81:
        return;
    L48:
        if (ea0() == false) goto L50;
        ((SearchRecommendBotModel) this.g.getValue()).loadFirstPageData(this);
        goto L50
    L13:
        if (Build.VERSION.SDK_INT >= 30) goto L30;
        final FragmentActivity r25 = getActivity();
        if (r25 == null) goto L31;
        Window r26 = r25.getWindow();
        if (r26 == null) goto L31;
        final View r27 = r26.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L24;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r28 = ThreadMethodProxy.currentThread();
        if (r28 == com.larus.home.impl.utils.c.a) goto L24;
        com.larus.home.impl.utils.c.a(r28, "getDecorView");
    L24:
        if (r27 == null) goto L31;
        View r29 = r27.findViewById(R.id.content);
        if (r29 == null) goto L31;
        r29.getViewTreeObserver().addOnGlobalLayoutListener(new h(r27, this, r25));
    L31:
        Unit r30 = Unit.INSTANCE;
        goto L32
    L30:
        ViewExtKt.a(r3.a, new i(this));
        goto L31
    }

    public static final Object U90(CombineSearchFragment r9, RecommendBot r10, Continuation r11) {
        r9.getClass();
        if ((r11 instanceof CombineSearchFragment$checkAndCreateLocalConversation$1) == false) goto L7;
        CombineSearchFragment$checkAndCreateLocalConversation$1 r0 = (CombineSearchFragment$checkAndCreateLocalConversation$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = false;
        String r4 = "";
        if (r2 == 0) goto L21;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L17;
        if (r2 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L89:
        String r14 = (String) r12;
    L91:
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        wc9.e r15 = (wc9.e) r0.L$1;
        RecommendBot r5 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L65:
        FLogger r16 = FLogger.a;
        StringBuilder r6 = new StringBuilder("checkAndCreateLocalConversation data.conversationId: ");
        r6.append(r5.E());
        r6.append(" conversation.status:");
        if (r15 == null) goto L68;
        Integer r7 = r15.t;
    L69:
        r6.append(r7);
        r6.append(" conversation.isLocal:");
        if (r15 == null) goto L72;
        Integer r8 = r15.f;
    L73:
        r6.append(r8);
        r16.i("CombineSearchFragment", r6.toString());
        if (r15 == null) goto L82;
        Integer r17 = r15.t;
        if (r17 != null) goto L79;
    L81:
        if (r3 == true) goto L82;
    L84:
        if (o0.d(r5.E()) == false) goto L86;
        r14 = r5.E();
        goto L91
    L86:
        ConversationRepoManager r18 = ConversationRepoManager.a;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 4;
        r12 = r18.b(r5, r0);
        if (r12 != r13) goto L89;
        return r13;
    L79:
        if (r17.intValue() != 2) goto L81;
        r3 = true;
    L82:
        r16.w("CombineSearchFragment", "checkAndCreateLocalConversation + data.conversationId = null");
        r5.G0(null);
        goto L84
    L72:
        r8 = null;
        goto L73
    L68:
        r7 = null;
        goto L69
    L18:
        r10 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        r5 = r10;
        r15 = (wc9.e) r12;
        if (r15 == null) goto L60;
        Integer r19 = r15.f;
        if (r19 == null) goto L60;
        if (r19.intValue() != 1) goto L60;
        boolean r20 = true;
    L61:
        if (r20 == false) goto L65;
        ConversationRepoManager r21 = ConversationRepoManager.a;
        String r22 = r15.a;
        r0.L$0 = r5;
        r0.L$1 = r15;
        r0.label = 3;
        if (ConversationRepoManager.g(r22, r5, r0) != r13) goto L65;
        return r13;
    L60:
        r20 = false;
        goto L61
    L20:
        r10 = (RecommendBot) r0.L$1;
        RecommendBot r23 = (RecommendBot) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L44:
        r10.G0((String) r12);
        r10 = r23;
    L45:
        ConversationRepoManager r24 = ConversationRepoManager.a;
        String r25 = r10.o();
        if (r25 == null) goto L49;
        r4 = r25;
    L49:
        r0.L$0 = r10;
        r0.L$1 = null;
        r0.label = 2;
        r12 = ConversationRepoManager.c(r4, r0);
        if (r12 != r13) goto L19;
        return r13;
    L21:
        ResultKt.throwOnFailure(r12);
        if (r10.j0() == false) goto L34;
        String r26 = r10.E();
        if (r26 != null) goto L26;
    L29:
        boolean r27 = true;
    L30:
        if (r27 == true) goto L37;
        int r28 = wf9.a.a;
        if (wf9.a.a(r10.E()) == false) goto L34;
    L37:
        ConversationRepoManager r29 = ConversationRepoManager.a;
        String r30 = r10.o();
        if (r30 != null) goto L40;
        r30 = "";
    L40:
        r0.L$0 = r10;
        r0.L$1 = r10;
        r0.label = 1;
        r12 = ConversationRepoManager.d(r30, r0);
        if (r12 == r13) goto L92;
        r23 = r10;
        goto L44
    L92:
        return r13;
    L26:
        if (r26.length() == 0) goto L29;
        r27 = false;
    L34:
        if (r10.j0() == true) goto L45;
        int r31 = wf9.a.a;
        if (wf9.a.a(r10.E()) == true) goto L45;
    L7:
        r0 = new CombineSearchFragment$checkAndCreateLocalConversation$1(r9, r11);
        goto L8
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562359, r9, false);
        int r12 = 2131379091;
        LoadingWithRetryView r2 = ViewBindings.findChildViewById(r11, 2131379091);
        if (r2 == null) goto L18;
        r12 = 2131385326;
        SearchBar r3 = ViewBindings.findChildViewById(r11, 2131385326);
        if (r3 == null) goto L18;
        r12 = 2131385503;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131385503);
        if (r4 == null) goto L18;
        r12 = 2131385504;
        RecyclerView r5 = ViewBindings.findChildViewById(r11, 2131385504);
        if (r5 == null) goto L18;
        r12 = 2131385573;
        RecyclerView r6 = ViewBindings.findChildViewById(r11, 2131385573);
        if (r6 == null) goto L18;
        RelativeLayout r13 = (RelativeLayout) r11;
        this.e = new LarusFragmentCombineSearchBinding(r13, r2, r3, r4, r5, r6);
        if (r13 == null) goto L15;
        r13.setTag(2131377847, this);
        return r13;
    L15:
        return null;
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }

    public static final Object W90(CombineSearchFragment r11, boolean r12, wc9.e r13, Continuation r14) {
        r11.getClass();
        if ((r14 instanceof CombineSearchFragment$notifyItemChangedWhenConversationChange$1) == false) goto L7;
        CombineSearchFragment$notifyItemChangedWhenConversationChange$1 r0 = (CombineSearchFragment$notifyItemChangedWhenConversationChange$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        String r6 = null;
        if (r3 == 0) goto L17;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r16 = r0.I$0;
        c0 r17 = (c0) r0.L$2;
        ListAdapter r18 = (ListAdapter) r0.L$1;
        wc9.e r4 = (wc9.e) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L78:
        List r19 = (List) r15;
        if (r19 == null) goto L81;
        String r110 = (String) CollectionsKt.getOrNull(r19, 0);
    L82:
        RecommendBot r5 = r17.q.a();
        if (r5 == null) goto L86;
        r6 = r5.o();
    L86:
        if (Intrinsics.areEqual(r6, r110) == false) goto L95;
        RecommendBot r111 = r17.q.a();
        if (r111 == null) goto L92;
        String r112 = r111.o();
        if (r112 == null) goto L92;
        BotStatusCacheDelegate.b.a(r112, true);
    L92:
        RecommendBot r113 = r17.q.a();
        if (r113 == null) goto L95;
        r113.G0(r4.a);
    L95:
        int r7 = r16;
    L96:
        r18.notifyItemChanged(r7);
        return Unit.INSTANCE;
    L81:
        r110 = null;
        goto L82
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ListAdapter r114 = (ListAdapter) r0.L$1;
        r13 = (wc9.e) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L16:
        wc9.e r10 = r13;
        r18 = r114;
        BotModel r115 = (BotModel) r15;
        if (r115 == null) goto L27;
        String r116 = r115.getBotId();
    L28:
        int r117 = r18.getItemCount();
        r7 = 0;
    L29:
        if (r7 >= r117) goto L99;
        c0 r8 = (c0) CollectionsKt.getOrNull(r18.getCurrentList(), r7);
        if (r116 != null) goto L33;
    L35:
        boolean r9 = false;
    L36:
        if (r9 == false) goto L97;
        if (r8 == null) goto L43;
        ws9.b r20 = r8.q;
        if (r20 == null) goto L43;
        RecommendBot r21 = r20.a();
        if (r21 == null) goto L43;
        String r22 = r21.o();
    L45:
        if (Intrinsics.areEqual(r116, r22) == false) goto L97;
        Integer r23 = r10.t;
        String r24 = "";
        if (r23 == null) goto L61;
        if (r23.intValue() != 2) goto L61;
        RecommendBot r25 = r8.q.a();
        if (r25 == null) goto L54;
        r25.G0("");
    L54:
        BotStatusCacheDelegate r26 = BotStatusCacheDelegate.b;
        RecommendBot r27 = r8.q.a();
        if (r27 == null) goto L60;
        String r28 = r27.o();
        if (r28 == null) goto L60;
        r24 = r28;
    L60:
        r26.a(r24, false);
    L61:
        String r118 = r10.a;
        RecommendBot r119 = r8.q.a();
        if (r119 == null) goto L64;
        String r120 = r119.E();
    L66:
        if (Intrinsics.areEqual(r118, r120) == false) goto L74;
        BotStatusCacheDelegate r121 = BotStatusCacheDelegate.b;
        RecommendBot r122 = r8.q.a();
        if (r122 == null) goto L73;
        String r123 = r122.o();
        if (r123 == null) goto L73;
        r24 = r123;
    L73:
        r121.a(r24, true);
        goto L96
    L74:
        IAIChatService.Companion r124 = IAIChatService.a;
        r0.L$0 = r10;
        r0.L$1 = r18;
        r0.L$2 = r8;
        r0.I$0 = r7;
        r0.label = 2;
        r15 = r124.s7(r10, r0);
        if (r15 == r2) goto L108;
        r4 = r10;
        r16 = r7;
        r17 = r8;
        goto L78
    L108:
        return r2;
    L64:
        r120 = null;
    L43:
        r22 = null;
    L97:
        r7 = r7 + 1;
        goto L29
    L33:
        if (o0.d(r116) != true) goto L35;
        r9 = true;
        goto L36
    L99:
        return Unit.INSTANCE;
    L27:
        r116 = null;
        goto L28
    L17:
        ResultKt.throwOnFailure(r15);
        if (r12 == false) goto L20;
        r114 = r11.A;
    L21:
        IBotRepoService r125 = RepoDispatcherDelegate.b.b();
        String r126 = r13.a;
        r0.L$0 = r13;
        r0.L$1 = r114;
        r0.label = 1;
        r15 = r125.j1(r126, false, r0);
        if (r15 != r2) goto L16;
        return r2;
    L20:
        r114 = r11.z;
    L7:
        r0 = new CombineSearchFragment$notifyItemChangedWhenConversationChange$1(r11, r14);
        goto L8
    }

    public static void ja0(CombineSearchFragment r27, RecommendBot r28, String r29, int r30) {
        LarusFragmentCombineSearchBinding r3 = r27.e;
        if (r3 == null) goto L8;
        SearchBar r4 = r3.c;
        if (r4 == null) goto L8;
        ViewExtKt.g(r4);
    L8:
        if (AudioServiceDelegate.a.B(r28.o(), r28.r(), r28.c0()) == null) goto L14;
        String r5 = String.valueOf(r30 + 1);
        com.bytedance.router.i r12 = SmartRouter.buildRoute(r27.getContext(), "//flow/realtime_chat_gate");
        Pair[] r14 = new Pair[10];
        r14[0] = TuplesKt.to("argConversationId", r29);
        r14[1] = TuplesKt.to("argClickEnterFrom", "");
        r14[2] = TuplesKt.to("argBotRecommendFrom", r28.a);
        r14[3] = TuplesKt.to("argPreviousPage", r27.k());
        r14[4] = TuplesKt.to("enter_method", "click_chat");
        r14[5] = TuplesKt.to("enter_from", r27.k());
        r14[6] = TuplesKt.to("argBotPosition", r5);
        r14[7] = TuplesKt.to("recommend_bot_mob_segment", r28.I0(""));
        SearchMobParam r1 = r28.b;
        if (r1 == null) goto L12;
        r1.a = r27.j;
        r1.b = r27.k;
        Unit r2 = Unit.INSTANCE;
        SearchMobParam r11 = r1;
    L13:
        r14[8] = TuplesKt.to("argSearchMobParam", r11);
        r14[9] = TuplesKt.to("is_call_bot", "1");
        Bundle r6 = com.larus.utils.f.c(r14);
        by7.h.k(r6, r27);
        r12.c.putExtras(r6);
        r12.d = 2130772401;
        r12.e = 2130772399;
        r12.d();
        return;
    L12:
        r11 = null;
        goto L13
    L14:
        ConversationPage r13 = r28.F();
        if (r13 == null) goto L17;
        List r15 = r13.getPageList();
    L19:
        if (l0.b(r15) == false) goto L29;
        com.bytedance.router.i r7 = SmartRouter.buildRoute(r27.getContext(), "//flow/chat_page_double_tab");
        Pair[] r16 = new Pair[14];
        r16[0] = TuplesKt.to("argPreviousPage", r27.k());
        r16[1] = TuplesKt.to("argConversationId", r29);
        r16[2] = TuplesKt.to("argClickEnterFrom", "");
        r16[3] = TuplesKt.to("enter_method", "click_chat");
        r16[4] = TuplesKt.to("argBotPosition", String.valueOf(r30 + 1));
        r16[5] = TuplesKt.to("argBotRecommendFrom", r28.a);
        r16[6] = TuplesKt.to("enter_from", "bot_search");
        r16[7] = TuplesKt.to("navigate_up_from", r27.k());
        int r8 = f5.a;
        ConversationPage r9 = r28.F();
        if (r9 == null) goto L23;
        Integer r10 = r9.getDefaultStatus();
    L24:
        r16[8] = TuplesKt.to("default_tab", Integer.valueOf(f5.a(r10)));
        r16[9] = TuplesKt.to("conversation_page", r28.F());
        r16[10] = TuplesKt.to("is_create_sub_conversation", Boolean.FALSE);
        SearchMobParam r17 = r28.b;
        if (r17 == null) goto L27;
        r17.a = r27.j;
        r17.b = r27.k;
        Unit r18 = Unit.INSTANCE;
        SearchMobParam r19 = r17;
    L28:
        r16[11] = TuplesKt.to("argSearchMobParam", r19);
        r16[12] = TuplesKt.to("recommend_bot_mob_segment", r28.I0(""));
        r16[13] = TuplesKt.to("argBotId", r28.o());
        Bundle r20 = com.larus.utils.f.c(r16);
        by7.h.k(r20, r27);
        r7.c.putExtras(r20);
        r7.d();
        return;
    L27:
        r19 = null;
        goto L28
    L23:
        r10 = null;
        goto L24
    L29:
        com.bytedance.router.i r0 = SmartRouter.buildRoute(r27.getContext(), "//flow/chat_page");
        Pair[] r21 = new Pair[14];
        r21[0] = TuplesKt.to("argPreviousPage", r27.k());
        r21[1] = TuplesKt.to("argConversationId", r29);
        r21[2] = TuplesKt.to("argClickEnterFrom", "");
        r21[3] = TuplesKt.to("argCvsBgImgUrl", r28.e());
        r21[4] = TuplesKt.to("argCvsBgImgColor", r28.a());
        r21[5] = TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r28.c()));
        r21[6] = TuplesKt.to("enter_method", "click_chat");
        r21[7] = TuplesKt.to("argBotRecommendFrom", r28.a);
        r21[8] = TuplesKt.to("argBotPosition", String.valueOf(r30 + 1));
        r21[9] = TuplesKt.to("enter_from", "bot_search");
        r21[10] = TuplesKt.to("navigate_up_from", r27.k());
        r21[11] = TuplesKt.to("recommend_bot_mob_segment", r28.I0(""));
        SearchMobParam r22 = r28.b;
        if (r22 == null) goto L32;
        CombineSearchFragment r23 = r27;
        r22.a = r23.j;
        r22.b = r23.k;
        Unit r24 = Unit.INSTANCE;
    L33:
        r21[12] = TuplesKt.to("argSearchMobParam", r22);
        r21[13] = TuplesKt.to("argBotId", r28.o());
        Bundle r25 = com.larus.utils.f.c(r21);
        by7.h.k(r25, r23);
        r0.c.putExtras(r25);
        r0.d();
        Job r26 = r23.B;
        if (r26 == null) goto L36;
        Job.DefaultImpls.cancel$default(r26, null, 1, null);
    L36:
        r23.B = null;
        com.larus.im.service.o r31 = (com.larus.im.service.o) r23.D.getValue();
        CombineSearchFragment$botUpdateListener$1 r32 = r23.F;
        r31.unregisterBotChangeListener(r32.a, r32);
        if (r23.e == null) goto L43;
        r23.B = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r27.getViewLifecycleOwner()), null, null, new CombineSearchFragment$observeBotChange$1(r23, r28, null), 3, null);
        return;
    L43:
        return;
    L32:
        r23 = r27;
        r22 = null;
        goto L33
    L17:
        r15 = null;
        goto L19
    }

    public static void ka0(final CombineSearchFragment r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r6 = false;
    L8:
        final LarusFragmentCombineSearchBinding r8 = r4.e;
        if (r8 != null) goto L11;
        return;
    L11:
        if (r5 == false) goto L13;
        r8.b.b();
        r8.d.setVisibility(8);
        r8.f.setVisibility(8);
    L26:
        r4.ca0().resetNetErrorCode();
        return;
    L13:
        if (r6 == false) goto L25;
        r8.b.d(2131906532);
        e10 r9 = e10.a;
        if (e10.i() == false) goto L24;
        Long r10 = r4.ca0().getNetErrorCode();
        if (r10 != null) goto L20;
    L21:
        IFlowChatThemeConfigProvider r11 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r11 == null) goto L24;
        r11.a(new p(r8, r4), AdaptThemeFeatureKey.CHAT_SEARCH_EMPTY_CREATE_BOT);
        goto L24
    L20:
        if (r10.longValue() != 710012005) goto L21;
    L24:
        r8.f.setVisibility(8);
        r8.d.setVisibility(8);
        goto L26
    L25:
        r8.f.setVisibility(0);
        r8.b.setVisibility(8);
        r8.d.setVisibility(8);
        r4.o = SystemClock.elapsedRealtime();
        goto L26
    }

    public static final Object V90(CombineSearchFragment r6, boolean r7, List r8, String r9, Continuation r10) {
        if (r7 == false) goto L4;
        ListAdapter r11 = r6.A;
    L5:
        ListAdapter r3 = r11;
        int r12 = r3.getItemCount();
        BotModel r2 = (BotModel) CollectionsKt.firstOrNull(r8);
        if (r2 == null) goto L27;
        if (Intrinsics.areEqual(r2.getBotId(), r9) == false) goto L27;
        int r4 = 0;
    L10:
        if (r4 >= r12) goto L27;
        c0 r1 = (c0) CollectionsKt.getOrNull(r3.getCurrentList(), r4);
        if (r1 == null) goto L18;
        ws9.b r13 = r1.q;
        if (r13 == null) goto L18;
        RecommendBot r14 = r13.a();
        if (r14 == null) goto L18;
        String r15 = r14.o();
    L20:
        if (Intrinsics.areEqual(r9, r15) == true) goto L21;
        r4 = r4 + 1;
        goto L10
    L21:
        Object r16 = BuildersKt.withContext(Dispatchers.getMain(), new CombineSearchFragment$notifyItemChangedWhenBotUpdate$2(r1, r2, r3, r4, null), r10);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        return r16;
    L30:
        return Unit.INSTANCE;
    L18:
        r15 = null;
    L27:
        return Unit.INSTANCE;
    L4:
        r11 = r6.z;
        goto L5
    }
}
