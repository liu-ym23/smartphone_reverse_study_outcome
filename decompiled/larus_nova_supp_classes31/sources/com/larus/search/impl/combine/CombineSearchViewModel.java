package com.larus.search.impl.combine;

import android.app.Application;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.bmhome.chat.bean.BotAction;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.chat.search.api.SdkSearchServiceDelegate;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.search.impl.combine.model.AutoSearchType;
import com.larus.settings.value.e10;
import com.larus.settings.value.hq;
import com.larus.utils.j0;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.i3;
import v19.b7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 n2\u00020\u0001:\u0001nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0019\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#J\u001e\u0010$\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010@\u001a\u00020\u001cH\u0002J(\u0010A\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010B2\u0006\u0010 \u001a\u00020\r2\b\b\u0002\u0010C\u001a\u00020&H\u0082@¢\u0006\u0002\u0010DJ0\u0010E\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\b\u0018\u00010F2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0082@¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fJ\u0018\u0010K\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010L\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010M\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010N\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fH\u0002J$\u0010O\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\b2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0082@¢\u0006\u0002\u0010HJ\u0016\u0010P\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fJ\u0018\u0010Q\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0018\u0010R\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\r2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0012\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u000103H\u0002J\u001a\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010Z\u001a\u00020Y2\u0006\u0010[\u001a\u00020\rH\u0002J&\u0010\\\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010B2\u0006\u0010]\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010_J$\u0010b\u001a\u00020\u001c2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010^\u001a\u00020\u00172\b\u0010e\u001a\u0004\u0018\u00010\rH\u0002J6\u0010f\u001a\b\u0012\u0004\u0012\u00020,0B2\u0006\u0010g\u001a\u00020\r2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\b2\u0006\u0010^\u001a\u00020\u00172\u0006\u0010c\u001a\u00020dH\u0002J,\u0010i\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\r2\b\u0010j\u001a\u0004\u0018\u00010\r2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010k\u001a\u00020\u000fH\u0002J\u0006\u0010l\u001a\u00020#J\b\u0010m\u001a\u00020\u001cH\u0014R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000e\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u001e\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020,0(j\b\u0012\u0004\u0012\u00020,`*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020.0(j\b\u0012\u0004\u0012\u00020.`*X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020)00j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020)`1X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00102\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020300j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000203`1X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/larus/search/impl/combine/CombineSearchViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "searchResultLv", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/search/impl/combine/CombineSearchResult;", "getSearchResultLv", "()Landroidx/lifecycle/MutableLiveData;", "latestKeyword", "", "isFirstSectionShowMessage", "", "()Z", "isFirstSectionShowMessage$delegate", "Lkotlin/Lazy;", "enterMethod", "trackNode", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "netErrorCode", "", "Ljava/lang/Long;", "getNetErrorCode", "()Ljava/lang/Long;", "resetNetErrorCode", "", "setTrackNode", "node", "updateKeyWord", "keyword", "setInitSearchInfo", "initSearchInfo", "Lcom/larus/search/impl/combine/model/SearchResultSnapshot;", "loadFirstPageData", "searchType", "", "localBotConversationResultList", "Ljava/util/ArrayList;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/collections/ArrayList;", "netBotResultList", "Lcom/larus/search/impl/global/model/GlobalSearchResultItemWrapper;", "messageResultList", "Lcom/larus/im/bean/message/Message;", "conversationMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "botModelMap", "Lcom/larus/im/bean/bot/BotModel;", "firstSectionSearchType", "Lcom/larus/search/impl/combine/model/AutoSearchType;", "botLocalSearchFirstDone", "messageSearchFirstDone", "botNetSearchFirstDone", "currentCursorConversation", "currentCursorMessage", "currentCursorBot", "hasMoreConversation", "hasMoreMessage", "hasMoreBots", "loadingMore", "reset", "searchConversation", "Lcom/larus/im/internal/core/conversation/FtsSearchResult;", "limit", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchGetBotByConversationId", "", "cvsIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBots", "isFirstPage", "loadBotsFromLocal", "loadBotsFromNet", "finishSearchConversation", "finishSearchBot", "batchGetConversationByIds", "loadMessage", "finishSearchMessage", "generateSearchResult", "buildGlobalSearchResultItem", "Lcom/larus/search/impl/global/model/GlobalSearchResultItem;", "botModel", "buildMatchingKeywordString", "", "textBuilder", "Landroid/text/SpannableStringBuilder;", "toSpannableString", "originString", "searchBot", "currentQuery", "offset", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchRequestId", "searchId", "fillParamForMob", "result", "Lcom/larus/search/impl/global/model/GlobalSearchResult;", "currentPage", "filterBotIdAndAddQuery", "query", "data", "mobSearchResult", "errCode", "success", "getAutoSearchInfo", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CombineSearchViewModel extends AndroidViewModel {
    public static final a Companion = null;
    public static final int FIRST_SECTION_SHOW_COUNT = 6;
    private static final int INDEX_TYPE_BOT = 2;
    private static final Regex ITALIC_REGEX = null;
    private static final int LIMIT_BOTS_PAGE = 20;
    public static final int LIMIT_CONVERSATION_PAGE = 20;
    private static final String TAG = "CombineSearchViewModel";
    private boolean botLocalSearchFirstDone;
    private final HashMap<String, BotModel> botModelMap;
    private boolean botNetSearchFirstDone;
    private final HashMap<String, wc9.e> conversationMap;
    private long currentCursorBot;
    private long currentCursorConversation;
    private long currentCursorMessage;
    private String enterMethod;
    private AutoSearchType firstSectionSearchType;
    private boolean hasMoreBots;
    private boolean hasMoreConversation;
    private boolean hasMoreMessage;
    private final Lazy isFirstSectionShowMessage$delegate;
    private String latestKeyword;
    private boolean loadingMore;
    private final ArrayList<wc9.e> localBotConversationResultList;
    private final ArrayList<Message> messageResultList;
    private boolean messageSearchFirstDone;
    private final ArrayList<ws9.c> netBotResultList;
    private Long netErrorCode;
    private String searchId;
    private String searchRequestId;
    private final MutableLiveData<List<c0>> searchResultLv;
    private int searchType;
    private com.larus.trace.tracknode.a trackNode;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AutoSearchType.values().length];
            r0[AutoSearchType.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AutoSearchType.BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements IIMCallback<Map<String, ? extends List<? extends BotModel>>> {
        public final /* synthetic */ Continuation<Map<String, ? extends List<BotModel>>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public c(SafeContinuation r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r2) {
            Map r3 = (Map) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    public static final class d implements IIMCallback<List<? extends wc9.e>> {
        public final /* synthetic */ Continuation<List<wc9.e>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public d(SafeContinuation r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    public static final class e implements IIMCallback<FtsSearchResult<wc9.e>> {
        public final /* synthetic */ Continuation<FtsSearchResult<wc9.e>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public e(SafeContinuation r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.w(CombineSearchViewModel.TAG, "searchConversation :" + r4);
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r4) {
            FtsSearchResult r5 = (FtsSearchResult) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.i(CombineSearchViewModel.TAG, "searchConversation size: " + r5.getData().size());
            this.a.resumeWith(Result.constructor-impl(r5));
        }
    }

    /* JADX INFO: renamed from: com.larus.search.impl.combine.CombineSearchViewModel$loadBotsFromLocal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchViewModel$loadBotsFromLocal$1", f = "CombineSearchViewModel.kt", i = {}, l = {278, 290}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFirstPage;
        final /* synthetic */ String $keyword;
        int label;
        final /* synthetic */ CombineSearchViewModel this$0;

        public AnonymousClass1(CombineSearchViewModel r1, String r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$keyword = r2;
            this.$isFirstPage = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$keyword, this.$isFirstPage, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L53:
            Map r13 = (Map) r12;
            if (r13 == null) goto L68;
            Set r14 = r13.entrySet();
            if (r14 == null) goto L68;
            CombineSearchViewModel r2 = this.this$0;
            Iterator r15 = r14.iterator();
            int r3 = 0;
        L59:
            if (r15.hasNext() == false) goto L68;
            Object r4 = r15.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L63;
            CollectionsKt.throwIndexOverflow();
        L63:
            Map.Entry r6 = (Map.Entry) r4;
            BotModel r7 = (BotModel) CollectionsKt.getOrNull((List) r6.getValue(), 0);
            if (r7 == null) goto L66;
            CombineSearchViewModel.access$getBotModelMap$p(r2).put(r6.getKey(), r7);
        L66:
            r3 = r5;
        L68:
            if (this.$isFirstPage == true) goto L70;
        L72:
            CombineSearchViewModel.access$finishSearchConversation(this.this$0, this.$keyword, this.$isFirstPage);
        L74:
            return Unit.INSTANCE;
        L70:
            if (CombineSearchViewModel.access$getLocalBotConversationResultList$p(this.this$0).size() >= 20) goto L72;
            CombineSearchViewModel.access$loadBotsFromNet(this.this$0, this.$keyword, this.$isFirstPage);
            goto L74
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L13:
            FtsSearchResult r16 = (FtsSearchResult) r12;
            if (r16 != null) goto L18;
            return Unit.INSTANCE;
        L18:
            if (Intrinsics.areEqual(CombineSearchViewModel.access$getLatestKeyword$p(this.this$0), this.$keyword) == false) goto L20;
            CombineSearchViewModel.access$setCurrentCursorConversation$p(this.this$0, r16.getNewCursor());
            CombineSearchViewModel.access$setHasMoreConversation$p(this.this$0, r16.getHasMore());
            List r8 = r16.getData();
            CombineSearchViewModel r9 = this.this$0;
            Iterator r10 = r8.iterator();
        L23:
            if (r10.hasNext() == false) goto L44;
            wc9.e r11 = (wc9.e) r10.next();
            Integer r17 = r11.v;
            if (r17 == null) goto L23;
            if (r17.intValue() != 2) goto L23;
            ArrayList r18 = CombineSearchViewModel.access$getLocalBotConversationResultList$p(r9);
            if ((r18 instanceof Collection) == true) goto L32;
        L34:
            Iterator r19 = r18.iterator();
        L36:
            if (r19.hasNext() == false) goto L33;
            if (Intrinsics.areEqual(((wc9.e) r19.next()).a, r11.a) == false) goto L36;
            boolean r20 = false;
        L40:
            if (r20 == false) goto L23;
            if (ic8.n.d(r11) == true) goto L23;
            CombineSearchViewModel.access$getLocalBotConversationResultList$p(r9).add(r11);
        L33:
            r20 = true;
            goto L40
        L32:
            if (r18.isEmpty() == false) goto L34;
        L44:
            List r110 = r16.getData();
            ArrayList r21 = new ArrayList();
            Iterator r111 = r110.iterator();
        L46:
            if (r111.hasNext() == false) goto L50;
            String r22 = ((wc9.e) r111.next()).a;
            if (r22 == null) goto L46;
            r21.add(r22);
            goto L46
        L50:
            List r112 = CollectionsKt.distinct(r21);
            CombineSearchViewModel r23 = this.this$0;
            this.label = 2;
            r12 = CombineSearchViewModel.access$batchGetBotByConversationId(r23, r112, this);
            if (r12 != r0) goto L53;
            return r0;
        L20:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r12);
            CombineSearchViewModel r113 = this.this$0;
            String r24 = this.$keyword;
            this.label = 1;
            r12 = CombineSearchViewModel.access$searchConversation(r113, r24, 20, this);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.search.impl.combine.CombineSearchViewModel$loadBotsFromNet$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchViewModel$loadBotsFromNet$1", f = "CombineSearchViewModel.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFirstPage;
        final /* synthetic */ String $keyword;
        int label;
        final /* synthetic */ CombineSearchViewModel this$0;

        public C01101(CombineSearchViewModel r1, String r2, boolean r3, Continuation<? super C01101> r4) {
            this.this$0 = r1;
            this.$keyword = r2;
            this.$isFirstPage = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01101(this.this$0, this.$keyword, this.$isFirstPage, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L11:
            FtsSearchResult r10 = (FtsSearchResult) r9;
            CombineSearchViewModel.access$setLoadingMore$p(this.this$0, false);
            if (Intrinsics.areEqual(CombineSearchViewModel.access$getLatestKeyword$p(this.this$0), this.$keyword) == false) goto L14;
            if (r10 == null) goto L40;
            CombineSearchViewModel.access$setCurrentCursorBot$p(this.this$0, r10.getNewCursor());
            CombineSearchViewModel.access$setHasMoreBots$p(this.this$0, r10.getHasMore());
            List r11 = r10.getData();
            CombineSearchViewModel r2 = this.this$0;
            Iterator r12 = r11.iterator();
        L18:
            if (r12.hasNext() == false) goto L42;
            ws9.c r3 = (ws9.c) r12.next();
            ArrayList r4 = CombineSearchViewModel.access$getNetBotResultList$p(r2);
            if ((r4 instanceof Collection) == true) goto L22;
        L24:
            Iterator r5 = r4.iterator();
        L26:
            if (r5.hasNext() == false) goto L23;
            RecommendBot r6 = ((ws9.c) r5.next()).b.a();
            String r7 = null;
            if (r6 == null) goto L30;
            String r8 = r6.o();
        L31:
            RecommendBot r13 = r3.b.a();
            if (r13 == null) goto L35;
            r7 = r13.o();
        L35:
            if (Intrinsics.areEqual(r8, r7) == false) goto L26;
            boolean r14 = false;
        L37:
            if (r14 == false) goto L18;
            CombineSearchViewModel.access$getNetBotResultList$p(r2).add(r3);
            goto L18
        L30:
            r8 = null;
        L23:
            r14 = true;
            goto L37
        L22:
            if (r4.isEmpty() == false) goto L24;
        L42:
            CombineSearchViewModel.access$finishSearchBot(this.this$0, this.$keyword, this.$isFirstPage);
            return Unit.INSTANCE;
        L40:
            if (CombineSearchViewModel.access$getSearchType$p(this.this$0) != 1) goto L42;
            CombineSearchViewModel.access$setHasMoreBots$p(this.this$0, false);
            goto L42
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            CombineSearchViewModel r15 = this.this$0;
            String r16 = this.$keyword;
            long r17 = CombineSearchViewModel.access$getCurrentCursorBot$p(r15);
            this.label = 1;
            r9 = CombineSearchViewModel.access$searchBot(r15, r16, r17, this);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.search.impl.combine.CombineSearchViewModel$loadMessage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchViewModel$loadMessage$1", f = "CombineSearchViewModel.kt", i = {1}, l = {369, 391, 406}, m = "invokeSuspend", n = {"cvsIdList"}, s = {"L$0"})
    public static final class C01111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFirstPage;
        final /* synthetic */ String $keyword;
        Object L$0;
        int label;
        final /* synthetic */ CombineSearchViewModel this$0;

        public C01111(String r1, CombineSearchViewModel r2, boolean r3, Continuation<? super C01111> r4) {
            this.$keyword = r1;
            this.this$0 = r2;
            this.$isFirstPage = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01111(this.$keyword, this.this$0, this.$isFirstPage, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r13);
        L82:
            Map r14 = (Map) r13;
            if (r14 == null) goto L96;
            Set r15 = r14.entrySet();
            if (r15 == null) goto L96;
            CombineSearchViewModel r2 = this.this$0;
            Iterator r16 = r15.iterator();
            int r3 = 0;
        L88:
            if (r16.hasNext() == false) goto L96;
            Object r4 = r16.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L92;
            CollectionsKt.throwIndexOverflow();
        L92:
            Map.Entry r6 = (Map.Entry) r4;
            BotModel r7 = (BotModel) CollectionsKt.getOrNull((List) r6.getValue(), 0);
            if (r7 == null) goto L95;
            CombineSearchViewModel.access$getBotModelMap$p(r2).put(r6.getKey(), r7);
        L95:
            r3 = r5;
        L96:
            CombineSearchViewModel.access$finishSearchMessage(this.this$0, this.$keyword, this.$isFirstPage);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            List r8 = (List) this.L$0;
            ResultKt.throwOnFailure(r13);
        L55:
            List r17 = (List) r13;
            if (r17 == null) goto L79;
            CombineSearchViewModel r9 = this.this$0;
            Iterator r18 = r17.iterator();
            int r10 = 0;
        L59:
            if (r18.hasNext() == false) goto L79;
            Object r11 = r18.next();
            int r12 = r10 + 1;
            if (r10 >= 0) goto L63;
            CollectionsKt.throwIndexOverflow();
        L63:
            final wc9.e r19 = (wc9.e) r11;
            Integer r20 = r19.t;
            if (r20 == null) goto L75;
            if (r20.intValue() != 3) goto L75;
            Integer r21 = r19.j;
            if (r21 == null) goto L75;
            if (r21.intValue() != 2) goto L75;
            FLogger.a.w(CombineSearchViewModel.TAG, "message filter by conversation-status-RECOVERABLE: " + r19.a);
            Boxing.boxBoolean(CollectionsKt.removeAll(CombineSearchViewModel.access$getMessageResultList$p(r9), new h0(r19)));
        L78:
            r10 = r12;
        L75:
            if (ic8.n.d(r19) == true) goto L77;
            CombineSearchViewModel.access$getConversationMap$p(r9).put(r19.a, r19);
            goto L78
        L77:
            FLogger.a.w(CombineSearchViewModel.TAG, "message filter by conversation-forbidSendMsg: " + r19.a);
        L79:
            CombineSearchViewModel r110 = this.this$0;
            this.L$0 = null;
            this.label = 3;
            r13 = CombineSearchViewModel.access$batchGetBotByConversationId(r110, r8, this);
            if (r13 != r0) goto L82;
            return r0;
        L11:
            ResultKt.throwOnFailure(r13);
        L19:
            FtsSearchResult r111 = (FtsSearchResult) r13;
            if (r111 != null) goto L24;
            return Unit.INSTANCE;
        L24:
            if (Intrinsics.areEqual(CombineSearchViewModel.access$getLatestKeyword$p(this.this$0), this.$keyword) == false) goto L26;
            CombineSearchViewModel.access$setCurrentCursorMessage$p(this.this$0, r111.getNewCursor());
            CombineSearchViewModel.access$setHasMoreMessage$p(this.this$0, r111.getHasMore());
            List r22 = r111.getData();
            CombineSearchViewModel r23 = this.this$0;
            Iterator r24 = r22.iterator();
        L29:
            if (r24.hasNext() == false) goto L46;
            Message r25 = (Message) r24.next();
            ArrayList r26 = CombineSearchViewModel.access$getMessageResultList$p(r23);
            if ((r26 instanceof Collection) == true) goto L33;
        L35:
            Iterator r27 = r26.iterator();
        L37:
            if (r27.hasNext() == false) goto L41;
            if (Intrinsics.areEqual(((Message) r27.next()).getMessageId(), r25.getMessageId()) == false) goto L37;
            boolean r28 = false;
        L42:
            if (r28 == false) goto L29;
            if (com.larus.bmhome.chat.bean.d.V0(r25) == true) goto L29;
            CombineSearchViewModel.access$getMessageResultList$p(r23).add(r25);
        L41:
            r28 = true;
            goto L42
        L33:
            if (r26.isEmpty() == false) goto L35;
        L46:
            List r112 = r111.getData();
            ArrayList r29 = new ArrayList();
            Iterator r113 = r112.iterator();
        L48:
            if (r113.hasNext() == false) goto L52;
            String r30 = ((Message) r113.next()).getConversationId();
            if (r30 == null) goto L48;
            r29.add(r30);
            goto L48
        L52:
            r8 = CollectionsKt.distinct(r29);
            CombineSearchViewModel r114 = this.this$0;
            this.L$0 = r8;
            this.label = 2;
            r13 = CombineSearchViewModel.access$batchGetConversationByIds(r114, r8, this);
            if (r13 != r0) goto L55;
            return r0;
        L26:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r13);
            SdkSearchServiceDelegate r31 = SdkSearchServiceDelegate.b;
            String r32 = this.$keyword;
            long r33 = CombineSearchViewModel.access$getCurrentCursorMessage$p(this.this$0);
            if (this.$isFirstPage == false) goto L15;
            int r115 = 40;
        L16:
            this.label = 1;
            r13 = r31.a(r32, r33, r115, this);
            if (r13 != r0) goto L19;
            return r0;
        L15:
            r115 = 20;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.larus.search.impl.combine.CombineSearchViewModel$searchBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.search.impl.combine.CombineSearchViewModel", f = "CombineSearchViewModel.kt", i = {0, 0}, l = {749}, m = "searchBot", n = {"currentQuery", "offset"}, s = {"L$0", "J$0"})
    public static final class C01121 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CombineSearchViewModel this$0;

        public C01121(CombineSearchViewModel r1, Continuation<? super C01121> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return CombineSearchViewModel.access$searchBot(this.this$0, null, 0, this);
        }
    }

    private final void reset() {
        this.botLocalSearchFirstDone = false;
        this.messageSearchFirstDone = false;
        this.botNetSearchFirstDone = false;
        this.localBotConversationResultList.clear();
        this.netBotResultList.clear();
        this.messageResultList.clear();
        this.conversationMap.clear();
        this.botModelMap.clear();
        this.firstSectionSearchType = AutoSearchType.UNKNOWN;
        this.currentCursorConversation = Long.MAX_VALUE;
        this.currentCursorMessage = Long.MAX_VALUE;
        this.currentCursorBot = 0;
        this.hasMoreConversation = true;
        this.hasMoreMessage = true;
        this.hasMoreBots = true;
        this.loadingMore = false;
    }

    public static /* synthetic */ boolean yo() {
        return isFirstSectionShowMessage_delegate$lambda$0();
    }

    public final void resetNetErrorCode() {
        this.netErrorCode = null;
    }

    static {
        Companion = new a();
        ITALIC_REGEX = new Regex("((\\(\\*).+?(\\*\\)))|((（\\*).+?(\\*）))");
    }

    private final boolean isFirstSectionShowMessage() {
        return ((Boolean) this.isFirstSectionShowMessage$delegate.getValue()).booleanValue();
    }

    private static final boolean isFirstSectionShowMessage_delegate$lambda$0() {
        e10 r0 = e10.a;
        return e10.H().f();
    }

    public final us9.a getAutoSearchInfo() {
        String r1 = this.latestKeyword;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        return new us9.a(r1, this.firstSectionSearchType, this.localBotConversationResultList, this.netBotResultList, this.messageResultList, this.conversationMap, this.botModelMap, this.currentCursorConversation, this.currentCursorMessage, this.currentCursorBot, this.hasMoreConversation, this.hasMoreMessage, this.hasMoreBots);
    }

    public void onCleared() {
        super/*androidx.lifecycle.ViewModel*/.onCleared();
        this.trackNode = null;
    }

    public static final /* synthetic */ Regex access$getITALIC_REGEX$cp() {
        return ITALIC_REGEX;
    }

    public final Long getNetErrorCode() {
        return this.netErrorCode;
    }

    public final MutableLiveData<List<c0>> getSearchResultLv() {
        return this.searchResultLv;
    }

    public CombineSearchViewModel(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        super(r3);
        this.searchResultLv = new MutableLiveData();
        this.isFirstSectionShowMessage$delegate = LazyKt.lazy(new g0());
        this.localBotConversationResultList = new ArrayList();
        this.netBotResultList = new ArrayList();
        this.messageResultList = new ArrayList();
        this.conversationMap = new HashMap();
        this.botModelMap = new HashMap();
        this.firstSectionSearchType = AutoSearchType.UNKNOWN;
        this.currentCursorConversation = Long.MAX_VALUE;
        this.currentCursorMessage = Long.MAX_VALUE;
        this.hasMoreConversation = true;
        this.hasMoreMessage = true;
        this.hasMoreBots = true;
    }

    public static final /* synthetic */ HashMap access$getBotModelMap$p(CombineSearchViewModel r0) {
        return r0.botModelMap;
    }

    public static final /* synthetic */ HashMap access$getConversationMap$p(CombineSearchViewModel r0) {
        return r0.conversationMap;
    }

    public static final /* synthetic */ long access$getCurrentCursorBot$p(CombineSearchViewModel r2) {
        return r2.currentCursorBot;
    }

    public static final /* synthetic */ long access$getCurrentCursorMessage$p(CombineSearchViewModel r2) {
        return r2.currentCursorMessage;
    }

    public static final /* synthetic */ String access$getLatestKeyword$p(CombineSearchViewModel r0) {
        return r0.latestKeyword;
    }

    public static final /* synthetic */ ArrayList access$getLocalBotConversationResultList$p(CombineSearchViewModel r0) {
        return r0.localBotConversationResultList;
    }

    public static final /* synthetic */ ArrayList access$getMessageResultList$p(CombineSearchViewModel r0) {
        return r0.messageResultList;
    }

    public static final /* synthetic */ ArrayList access$getNetBotResultList$p(CombineSearchViewModel r0) {
        return r0.netBotResultList;
    }

    public static final /* synthetic */ int access$getSearchType$p(CombineSearchViewModel r0) {
        return r0.searchType;
    }

    private final ws9.b buildGlobalSearchResultItem(BotModel r50) {
        ws9.b r2 = new ws9.b(null, 7);
        String r3 = "";
        if (r50 == null) goto L124;
        Intrinsics.checkNotNullParameter(r50, "<this>");
        String r6 = r50.getBotId();
        if (r6 != null) goto L7;
        String r8 = "";
    L8:
        String r7 = r50.getName();
        if (r7 != null) goto L11;
        String r9 = "";
    L12:
        BotIconImage r10 = r50.getIconImage();
        if (r10 == null) goto L15;
        String r11 = r10.getUri();
    L16:
        BotIconImage r12 = r50.getIconImage();
        if (r12 == null) goto L19;
        String r13 = r12.getTinyUrl();
    L20:
        BotIconImage r14 = r50.getIconImage();
        if (r14 == null) goto L23;
        String r15 = r14.getOriginUrl();
    L24:
        BotIconImage r16 = new BotIconImage(r11, r13, r15, null, null, 24, null);
        long r17 = r50.getCreateTime();
        Long r18 = r50.getUpdateTime();
        if (r18 == null) goto L27;
        long r19 = r18.longValue();
    L28:
        List r33 = r50.getBotConf();
        Integer r110 = r50.getBotType();
        ShareInfo r29 = r50.getShareInfo();
        BotCreatorInfo r111 = r50.getBotCreatorInfo();
        if (r111 == null) goto L31;
        String r112 = r111.getName();
    L32:
        BotCreatorInfo r113 = r50.getBotCreatorInfo();
        if (r113 == null) goto L35;
        String r114 = r113.getId();
    L36:
        BotCreatorInfo r115 = r50.getBotCreatorInfo();
        if (r115 == null) goto L41;
        BotIconImage r116 = r115.getAvatar();
        if (r116 == null) goto L41;
        String r20 = r116.getUri();
    L42:
        BotCreatorInfo r117 = r50.getBotCreatorInfo();
        if (r117 == null) goto L47;
        BotIconImage r118 = r117.getAvatar();
        if (r118 == null) goto L47;
        String r21 = r118.getTinyUrl();
    L48:
        BotCreatorInfo r119 = r50.getBotCreatorInfo();
        if (r119 == null) goto L53;
        BotIconImage r120 = r119.getAvatar();
        if (r120 == null) goto L53;
        String r22 = r120.getOriginUrl();
    L54:
        BotCreatorInfo r23 = new BotCreatorInfo(r112, r114, new BotIconImage(r20, r21, r22, null, null, 24, null));
        BotStatistic r24 = r50.getBotStatic();
        Integer r30 = r50.getPrivateStatus();
        ConversationPage r39 = r50.getConversationPage();
        String r4 = r50.getDescriptionForHuman();
        if (r4 != null) goto L57;
        String r25 = "";
    L58:
        Intrinsics.checkNotNullParameter(r50, "<this>");
        Integer r5 = r50.getBotStatus();
        if (r5 != null) goto L62;
    L64:
        if (r5 != null) goto L67;
    L69:
        if (r5 != null) goto L72;
    L74:
        if (r5 != null) goto L77;
    L79:
        if (r5 == null) goto L85;
        if (r5.intValue() != (-50)) goto L85;
        String r26 = "rollback";
    L87:
        String r31 = r26;
    L89:
        ModelItem r27 = r50.getModel();
        String r28 = r50.getEditPos();
        if (r28 != null) goto L92;
        String r210 = "";
    L93:
        boolean r32 = r50.getMuted();
        Integer r34 = r50.getRecommendIndex();
        if (r34 == null) goto L96;
        long r121 = r34.intValue();
    L97:
        BotOnBoarding r35 = r50.getOnBoarding();
        if (r35 == null) goto L103;
        String r36 = r35.getPrologue();
        if (r36 == null) goto L103;
        String r41 = r36;
    L104:
        BotOnBoarding r37 = r50.getOnBoarding();
        if (r37 == null) goto L107;
        List r42 = r37.getSuggests();
    L108:
        BotOnBoarding r38 = r50.getOnBoarding();
        if (r38 == null) goto L114;
        String r40 = r38.getContent();
        if (r40 == null) goto L114;
        String r43 = r40;
    L115:
        BotOnBoarding r44 = r50.getOnBoarding();
        if (r44 == null) goto L118;
        int r45 = r44.getCallMode();
    L119:
        com.larus.bmhome.chat.bean.BotOnBoarding r211 = new com.larus.bmhome.chat.bean.BotOnBoarding(r41, r42, r43, r45, 16);
        String r310 = r50.getBio();
        SpeakerVoice r212 = r50.getVoiceType();
        String r311 = r50.getBgImgColor();
        String r312 = r50.getBgImgUrl();
        String r313 = r50.getBgVideoModel();
        String r314 = r50.getBgImgUri();
        BgImageInfo r315 = r50.getBgImgInfo();
        String r46 = r50.getCallerName();
        Boolean r47 = r50.getCallerNameSetting();
        String r122 = r50.getBotFeatureLabel();
        LikeInfo r48 = r50.getLikeInfo();
        BotCommentInfo r49 = r50.getCommentInfo();
        List r51 = r50.getTagList();
        if (r51 == null) goto L122;
        ArrayList r410 = new ArrayList(r51);
    L123:
        RecommendBot r52 = new RecommendBot(r8, r9, r110, r122, r16, r17, r19, r121, false, null, r211, r23, r24, Boolean.valueOf(r32), r25, r27, r212, r210, r29, r30, r31, r310, r33, r312, r311, r313, r314, r315, r39, r46, r47, r410, r48, r49, false, null, 4199952, 7955);
        r52.F0(new BotAction(2, 2));
        String r53 = null;
        r52.a = new RecommendFrom("chat_list_discover_search_rcmd", null, "chat_list_discover_search_rcmd", 2);
    L125:
        r2.c(r52);
        if (r50 == null) goto L128;
        String r1 = r50.getName();
    L129:
        if (r1 == null) goto L132;
        r3 = r1;
    L132:
        r2.a = buildMatchingKeywordString(new SpannableStringBuilder(r3), this.latestKeyword);
        return r2;
    L128:
        r1 = r53;
        goto L129
    L122:
        r410 = null;
        goto L123
    L118:
        r45 = 0;
    L114:
        r43 = "";
        goto L115
    L107:
        r42 = null;
    L103:
        r41 = "";
        goto L104
    L96:
        r121 = 0;
        goto L97
    L92:
        r210 = r28;
    L85:
        if (r50.getDisabled() == false) goto L88;
    L86:
        r26 = "deleted";
        goto L87
    L88:
        r31 = "";
        goto L89
    L77:
        if (r5.intValue() != (-40)) goto L79;
        r26 = "private";
        goto L87
    L72:
        if (r5.intValue() != (-30)) goto L74;
        r26 = "ban";
        goto L87
    L67:
        if (r5.intValue() != (-20)) goto L69;
        r26 = "reviewing";
        goto L87
    L62:
        if (r5.intValue() != (-10)) goto L64;
    L57:
        r25 = r4;
    L53:
        r22 = null;
    L47:
        r21 = null;
    L41:
        r20 = null;
        goto L42
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L15:
        r11 = null;
        goto L16
    L11:
        r9 = r7;
        goto L12
    L7:
        r8 = r6;
        goto L8
    L124:
        r53 = null;
        r52 = null;
        goto L125
    }

    private final SpannableStringBuilder toSpannableString(String r15) {
        int r2 = 0;
        List r0 = SequencesKt.toList(Regex.findAll$default(ITALIC_REGEX, r15, 0, 2, null));     // Catch: Exception -> L20
        if ((!r0.isEmpty()) == false) goto L23;
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L20
        Iterator r3 = r0.iterator();     // Catch: Exception -> L20
        String r4 = r15;
    L6:
        if (r3.hasNext() == false) goto L8;
        MatchResult r5 = (MatchResult) r3.next();     // Catch: Exception -> L20
        String r12 = r5.getValue();     // Catch: Exception -> L20
        IntRange r13 = r5.getRange();     // Catch: Exception -> L20
        r4 = StringsKt.replaceFirst$default(r4, r12, StringsKt.replace$default(r12, "*", "", false, 4, null), false, 4, null);     // Catch: Exception -> L20
        int r6 = (r13.getFirst() + 1) - (r2 * 2);     // Catch: Exception -> L20
        r2 = r2 + 1;     // Catch: Exception -> L20
        r1.add(new IntRange(r6, r13.getLast() - (r2 * 2)));     // Catch: Exception -> L20
        goto L6
    L8:
        SpannableStringBuilder r7 = new SpannableStringBuilder(r4);     // Catch: Exception -> L20
        Iterator r8 = r1.iterator();     // Catch: Exception -> L20
    L9:
        if (r8.hasNext() == false) goto L19;
        IntRange r9 = (IntRange) r8.next();     // Catch: Exception -> L20
        if (r9.getFirst() <= 0) goto L9;
        if (r9.getLast() <= 0) goto L9;
        if (r9.getLast() < r9.getFirst()) goto L9;
        r7.setSpan(new StyleSpan(2), r9.getFirst(), r9.getLast(), 33);     // Catch: Exception -> L20
        goto L9
    L19:
        return r7;
    L23:
        return new SpannableStringBuilder(r15);
    L20:
        e = move-exception;
        FLogger.a.e(TAG, e.getMessage());
        goto L23
    }

    public final void setInitSearchInfo(us9.a r4) {
        Intrinsics.checkNotNullParameter(r4, "initSearchInfo");
        this.latestKeyword = r4.a;
        this.localBotConversationResultList.addAll(r4.c);
        this.netBotResultList.addAll(r4.d);
        this.messageResultList.addAll(r4.e);
        this.conversationMap.putAll(r4.f);
        this.botModelMap.putAll(r4.g);
        this.currentCursorBot = r4.j;
        this.currentCursorConversation = r4.h;
        this.currentCursorMessage = r4.i;
        this.hasMoreConversation = r4.k;
        this.hasMoreMessage = r4.l;
        this.hasMoreBots = r4.m;
        AutoSearchType r0 = r4.b;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L7;
        if (r1 != 2) goto L8;
        this.searchType = 1;
        this.botLocalSearchFirstDone = true;
        this.botNetSearchFirstDone = true;
    L8:
        generateSearchResult(r4.a, true);
        return;
    L7:
        this.searchType = 2;
        this.messageSearchFirstDone = true;
        goto L8
    }

    public final void setTrackNode(com.larus.trace.tracknode.a r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        this.trackNode = r2;
    }

    public final void updateKeyWord(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        if (Intrinsics.areEqual(this.latestKeyword, r2) == true) goto L6;
        this.latestKeyword = r2;
        reset();
        return;
    }

    public static final /* synthetic */ void access$setCurrentCursorBot$p(CombineSearchViewModel r0, long r1) {
        r0.currentCursorBot = r1;
    }

    public static final /* synthetic */ void access$setCurrentCursorConversation$p(CombineSearchViewModel r0, long r1) {
        r0.currentCursorConversation = r1;
    }

    public static final /* synthetic */ void access$setCurrentCursorMessage$p(CombineSearchViewModel r0, long r1) {
        r0.currentCursorMessage = r1;
    }

    public static final /* synthetic */ void access$setHasMoreBots$p(CombineSearchViewModel r0, boolean r1) {
        r0.hasMoreBots = r1;
    }

    public static final /* synthetic */ void access$setHasMoreConversation$p(CombineSearchViewModel r0, boolean r1) {
        r0.hasMoreConversation = r1;
    }

    public static final /* synthetic */ void access$setHasMoreMessage$p(CombineSearchViewModel r0, boolean r1) {
        r0.hasMoreMessage = r1;
    }

    public static final /* synthetic */ void access$setLoadingMore$p(CombineSearchViewModel r0, boolean r1) {
        r0.loadingMore = r1;
    }

    private final Object batchGetBotByConversationId(List<String> r4, Continuation<? super Map<String, ? extends List<BotModel>>> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        com.larus.im.d.a().batchGetBotByConversationId(r4, new c(r0));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    private final Object batchGetConversationByIds(List<String> r4, Continuation<? super List<wc9.e>> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        com.larus.im.d.d().batchGetConversationByIds(r4, new d(r0));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    private final CharSequence buildMatchingKeywordString(SpannableStringBuilder r5, String r6) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L21;
        if (r6 != null) goto L12;
    L15:
        if (r0 == true) goto L21;
        Matcher r7 = PatternProtector.compile(r6, 18).matcher(r5);
    L19:
        if (r7.find() == false) goto L21;
        int r1 = r7.start();
        int r3 = r7.end();
        int r4 = j0.a;
        r5.setSpan(new ForegroundColorSpan(j0.a(2131103203)), r1, r3, 33);
        goto L19
    L12:
        if (r6.length() == 0) goto L15;
        r0 = false;
    L21:
        return r5;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final void finishSearchBot(String r2, boolean r3) {
        this.botNetSearchFirstDone = true;
        generateSearchResult(r2, r3);
    }

    private final void finishSearchConversation(String r2, boolean r3) {
        this.botLocalSearchFirstDone = true;
        generateSearchResult(r2, r3);
    }

    private final void finishSearchMessage(String r2, boolean r3) {
        this.messageSearchFirstDone = true;
        generateSearchResult(r2, r3);
    }

    private final void generateSearchResult(String r49, boolean r50) {
        if (Intrinsics.areEqual(this.latestKeyword, r49) == true) goto L5;
        return;
    L5:
        int r2 = this.searchType;
        if (r2 == 0) goto L8;
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L22;
    L24:
        ArrayList r3 = new ArrayList();
        FLogger.a.i(TAG, "messageList before size: " + this.messageResultList.size());
        ArrayList<Message> r5 = this.messageResultList;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L26:
        if (r7.hasNext() == false) goto L50;
        Message r8 = (Message) r7.next();
        String r11 = iz8.c.c(r8);
        if (iz8.c.a(r49, r11, r8) == false) goto L47;
        wc9.e r12 = this.conversationMap.get(r8.getConversationId());
        if (r12 == null) goto L47;
        BotModel r18 = this.botModelMap.get(r8.getConversationId());
        IconImage r13 = r12.b;
        if (r13 == null) goto L37;
        ImageObj r14 = r13.imageThumb;
        if (r14 == null) goto L37;
        String r21 = r14.url;
    L38:
        String r19 = ic8.n.g(r12, "");
        String r15 = r8.getMessageId();
        if (r15 != null) goto L41;
        String r16 = "";
    L42:
        CharSequence r20 = buildMatchingKeywordString(toSpannableString(r11), this.latestKeyword);
        String r27 = iz8.c.b(r11, this.latestKeyword);
        int r9 = b7.a;
        String r22 = b7.a(r8.getCreateTime());
        long r23 = r8.getLocalIndex();
        if (r18 == null) goto L45;
        Boolean r25 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.G0(r8));
    L46:
        c0 r10 = new c0(r16, 17, false, r12, r18, r19, r20, r21, r22, r23, r25, null, r27, null, 88320);
    L48:
        if (r10 == null) goto L26;
        r6.add(r10);
        goto L26
    L45:
        r25 = null;
        goto L46
    L41:
        r16 = r15;
    L37:
        r21 = null;
    L47:
        r10 = null;
        goto L48
    L50:
        boolean r17 = !r6.isEmpty();
        FLogger r24 = FLogger.a;
        r24.i(TAG, "messageList after size: " + r6.size());
        r24.i(TAG, "localBotList before size: " + this.localBotConversationResultList.size());
        ArrayList<wc9.e> r26 = this.localBotConversationResultList;
        ArrayList r110 = new ArrayList();
        Iterator<T> r28 = r26.iterator();
    L52:
        if (r28.hasNext() == false) goto L68;
        wc9.e r111 = (wc9.e) r28.next();
        ws9.b r29 = buildGlobalSearchResultItem(this.botModelMap.get(r111.a));
        RecommendBot r112 = r29.a();
        if (r112 == null) goto L57;
        String r113 = r112.o();
        if (r113 == null) goto L57;
    L58:
        String r114 = r113;
        String r115 = r111.c;
        if (r115 != null) goto L61;
        r115 = "";
    L61:
        CharSequence r116 = buildMatchingKeywordString(new SpannableStringBuilder(r115), this.latestKeyword);
        IconImage r117 = r111.b;
        if (r117 == null) goto L66;
        ImageObj r118 = r117.imageThumb;
        if (r118 == null) goto L66;
        String r210 = r118.url;
    L67:
        r110.add(new c0(r114, 16, true, r111, this.botModelMap.get(r111.a), r116, null, r210, null, 0, null, null, null, r29, 65344));
    L66:
        r210 = null;
    L57:
        r113 = r111.a;
        goto L58
    L68:
        ArrayList r30 = new ArrayList();
        Iterator r119 = r110.iterator();
    L70:
        if (r119.hasNext() == false) goto L89;
        Object r120 = r119.next();
        c0 r121 = (c0) r120;
        CharSequence r122 = r121.f;
        if (r122 == null) goto L79;
        String r123 = this.latestKeyword;
        if (r123 != null) goto L77;
        r123 = "";
    L77:
        if (StringsKt.contains(r122, r123, true) != true) goto L79;
        boolean r124 = true;
    L80:
        if (r124 == false) goto L86;
        BotModel r125 = r121.e;
        if (r125 == null) goto L86;
        if (r125.getDisabled() == true) goto L86;
        boolean r126 = true;
    L87:
        if (r126 == false) goto L70;
        r30.add(r120);
    L86:
        r126 = false;
    L79:
        r124 = false;
        goto L80
    L89:
        boolean r127 = !r30.isEmpty();
        FLogger r128 = FLogger.a;
        r128.i(TAG, "localBotList after size: " + r30.size());
        r128.i(TAG, "netBotList before size: " + this.netBotResultList.size());
        ArrayList<ws9.c> r129 = this.netBotResultList;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L91:
        if (r131.hasNext() == false) goto L130;
        ws9.c r132 = (ws9.c) r131.next();
        if (r30.isEmpty() == true) goto L106;
        Iterator r133 = r30.iterator();
    L97:
        if (r133.hasNext() == false) goto L106;
        String r134 = ((c0) r133.next()).a;
        RecommendBot r4 = r132.b.a();
        if (r4 == null) goto L101;
        String r31 = r4.o();
    L103:
        if (Intrinsics.areEqual(r134, r31) == false) goto L97;
        boolean r32 = false;
    L107:
        if (r32 == false) goto L126;
        RecommendBot r135 = r132.b.a();
        if (r135 == null) goto L111;
        String r136 = r135.o();
    L112:
        if (r136 != null) goto L114;
        String r33 = "";
    L115:
        RecommendBot r137 = r132.b.a();
        if (r137 == null) goto L118;
        String r138 = r137.getName();
    L119:
        CharSequence r37 = buildMatchingKeywordString(new SpannableStringBuilder(r138), this.latestKeyword);
        RecommendBot r139 = r132.b.a();
        if (r139 == null) goto L124;
        BotIconImage r140 = r139.O();
        if (r140 == null) goto L124;
        String r39 = r140.getThumbnailUrl();
    L125:
        c0 r34 = new c0(r33, 16, true, null, null, r37, null, r39, null, 0, null, null, null, r132.b, 65368);
    L127:
        if (r34 == null) goto L91;
        r130.add(r34);
    L124:
        r39 = null;
        goto L125
    L118:
        r138 = null;
        goto L119
    L114:
        r33 = r136;
        goto L115
    L111:
        r136 = null;
        goto L112
    L126:
        r34 = null;
        goto L127
    L101:
        r31 = null;
    L106:
        r32 = true;
        goto L107
    L130:
        boolean r35 = !r130.isEmpty();
        FLogger.a.i(TAG, "netBotList after size: " + r130.size());
        int r36 = this.searchType;
        if (r36 != 0) goto L141;
        if (r17 == false) goto L137;
        if (r127 == true) goto L136;
        if (r35 == false) goto L137;
    L136:
        boolean r38 = false;
    L138:
        if (r17 == false) goto L140;
        int r40 = 2;
    L142:
        if (r38 == false) goto L161;
        if (r40 != 1) goto L145;
        r3.addAll(r30);
        r3.addAll(r130);
        if (r127 == true) goto L156;
        if (r35 == true) goto L156;
    L177:
        if (Intrinsics.areEqual(this.latestKeyword, r49) == true) goto L179;
        return;
    L179:
        this.searchResultLv.postValue(r3);
        return;
    L156:
        if (this.hasMoreConversation == false) goto L158;
    L159:
        r3.add(new c0("32", 32, true, null, null, null, null, null, null, 0, null, null, null, null, 131064));
        goto L177
    L158:
        if (this.hasMoreBots == false) goto L177;
    L145:
        if (r40 != 2) goto L177;
        r3.addAll(r6);
        if (r17 == false) goto L177;
        if (this.hasMoreMessage == false) goto L177;
        r3.add(new c0("32", 32, false, null, null, null, null, null, null, 0, null, null, null, null, 131064));
        goto L177
    L161:
        if (isFirstSectionShowMessage() == false) goto L170;
        int r141 = j0.a;
        r3.add(new c0("48", 48, false, null, null, null, null, null, null, 0, null, new i0(j0.d(2131900831), true, false), null, null, 114680));
        if (r50 == false) goto L165;
        this.firstSectionSearchType = AutoSearchType.MESSAGE;
    L165:
        r3.addAll(r6.subList(0, Math.min(6, r6.size())));
        r3.add(new c0("48", 48, true, null, null, null, null, null, null, 0, null, new i0(j0.d(2131900830), false, true), null, null, 114680));
        r3.addAll(r30);
        r3.addAll(r130);
        if (this.hasMoreConversation == false) goto L168;
    L169:
        r3.add(new c0("32", 32, true, null, null, null, null, null, null, 0, null, null, null, null, 131064));
        goto L177
    L168:
        if (this.hasMoreBots == false) goto L177;
    L170:
        int r142 = j0.a;
        r3.add(new c0("48", 48, true, null, null, null, null, null, null, 0, null, new i0(j0.d(2131900830), true, false), null, null, 114680));
        ArrayList r41 = new ArrayList();
        r41.addAll(r30);
        r41.addAll(r130);
        if (r50 == false) goto L173;
        this.firstSectionSearchType = AutoSearchType.BOT;
    L173:
        r3.addAll(r41.subList(0, Math.min(6, r41.size())));
        r3.add(new c0("48", 48, false, null, null, null, null, null, null, 0, null, new i0(j0.d(2131900831), false, true), null, null, 114680));
        r3.addAll(r6);
        if (this.hasMoreMessage == false) goto L177;
        r3.add(new c0("32", 32, false, null, null, null, null, null, null, 0, null, null, null, null, 131064));
        goto L177
    L140:
        r40 = 1;
    L137:
        r38 = true;
        goto L138
    L141:
        r40 = r36;
        r38 = true;
        goto L142
    L22:
        if (this.messageSearchFirstDone == true) goto L24;
        return;
    L16:
        if (this.botLocalSearchFirstDone == true) goto L24;
        if (this.botNetSearchFirstDone == true) goto L24;
        return;
    L8:
        if (this.messageSearchFirstDone == true) goto L10;
        return;
    L10:
        if (this.botLocalSearchFirstDone == true) goto L24;
        if (this.botNetSearchFirstDone == true) goto L24;
    }

    private final void loadBotsFromLocal(String r8, boolean r9) {
        FLogger.a.i(TAG, "loadBotsFromLocal isFirstPage: " + r9 + " hasMoreConversation: " + this.hasMoreConversation);
        if (this.hasMoreConversation == true) goto L6;
        finishSearchConversation(r8, r9);
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
    }

    private final void loadBotsFromNet(String r8, boolean r9) {
        FLogger.a.i(TAG, "loadBots isFirstPage: " + r9 + " hasMoreBots: " + this.hasMoreBots);
        if (this.hasMoreBots == true) goto L7;
        finishSearchBot(r8, r9);
        return;
    L7:
        if (this.loadingMore == false) goto L9;
        return;
    L9:
        this.loadingMore = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01101(this, r8, r9, null), 3, null);
    }

    public final void loadBots(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "keyword");
        FLogger.a.i(TAG, "loadBots isFirstPage: " + r5 + " hasMoreConversation: " + this.hasMoreConversation);
        if (this.hasMoreConversation == false) goto L5;
        loadBotsFromLocal(r4, r5);
        return;
    L5:
        loadBotsFromNet(r4, r5);
    }

    public final void loadMessage(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "keyword");
        FLogger.a.i(TAG, "loadMessage isFirstPage: " + r9 + " hasMoreMessage: " + this.hasMoreMessage);
        if (this.hasMoreMessage == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01111(r8, this, r9, null), 3, null);
    }

    public static final /* synthetic */ Object access$batchGetBotByConversationId(CombineSearchViewModel r0, List r1, Continuation r2) {
        return r0.batchGetBotByConversationId(r1, r2);
    }

    public static final /* synthetic */ Object access$batchGetConversationByIds(CombineSearchViewModel r0, List r1, Continuation r2) {
        return r0.batchGetConversationByIds(r1, r2);
    }

    public static final /* synthetic */ void access$finishSearchBot(CombineSearchViewModel r0, String r1, boolean r2) {
        r0.finishSearchBot(r1, r2);
    }

    public static final /* synthetic */ void access$finishSearchConversation(CombineSearchViewModel r0, String r1, boolean r2) {
        r0.finishSearchConversation(r1, r2);
    }

    public static final /* synthetic */ void access$finishSearchMessage(CombineSearchViewModel r0, String r1, boolean r2) {
        r0.finishSearchMessage(r1, r2);
    }

    public static final /* synthetic */ void access$loadBotsFromNet(CombineSearchViewModel r0, String r1, boolean r2) {
        r0.loadBotsFromNet(r1, r2);
    }

    private final void fillParamForMob(ws9.a r16, long r17, String r19) {
        if (r16 == null) goto L7;
        Map<String, String> r2 = r16.e();
        if (r2 == null) goto L7;
        String r3 = r2.get("request_id");
    L8:
        this.searchRequestId = r3;
        if (r17 != 0) goto L11;
        this.searchId = r3;
    L11:
        if (r16 == null) goto L31;
        List<ws9.b> r4 = r16.a();
        if (r4 == null) goto L35;
        Iterator<T> r5 = r4.iterator();
        int r6 = 0;
    L16:
        if (r5.hasNext() == false) goto L36;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        ws9.b r9 = (ws9.b) r7;
        RecommendBot r10 = r9.a();
        if (r10 == null) goto L27;
        String r11 = this.searchId;
        String r12 = this.searchRequestId;
        RecommendBot r13 = r9.a();
        if (r13 == null) goto L25;
        String r14 = r13.o();
    L26:
        r10.b = new SearchMobParam(r11, r12, r14, String.valueOf(r17 + ((long) r6)), r19, 3);
        goto L27
    L25:
        r14 = null;
    L27:
        RecommendBot r15 = r9.a();
        if (r15 == null) goto L30;
        r15.a = new RecommendFrom("chat_list_discover_search_rcmd", this.searchRequestId, "chat_list_discover_search_rcmd");
    L30:
        r6 = r8;
        goto L16
    L36:
        return;
    L35:
        return;
    L31:
        return;
    L7:
        r3 = null;
        goto L8
    }

    private final Object searchBot(String r20, long r21, Continuation<? super FtsSearchResult<ws9.c>> r23) {
        if ((r23 instanceof C01121) == false) goto L7;
        C01121 r4 = (C01121) r23;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        long r0 = r4.J$0;
        String r2 = (String) r4.L$0;
        ResultKt.throwOnFailure(r3);
        long r8 = r0;
        String r1 = r2;
    L18:
        com.larus.network.http.y r9 = (com.larus.network.http.a) r3;
        ws9.a r10 = (ws9.a) ((com.larus.network.http.a) r9).b;
        com.larus.trace.tracknode.a r11 = this.trackNode;
        if (r11 == null) goto L21;
        String r12 = r11.k();
    L22:
        fillParamForMob(r10, r8, r12);
        if ((r9 instanceof com.larus.network.http.y) == false) goto L36;
        com.larus.network.http.y r13 = r9;
        Long r14 = r13.g;
        if (r14 != null) goto L28;
    L30:
        Long r15 = r13.g;
        if (r15 == null) goto L33;
        String r16 = r15.toString();
    L34:
        mobSearchResult(r1, r16, (ws9.a) ((com.larus.network.http.a) r13).b, false);
    L39:
        ws9.a r17 = (ws9.a) ((com.larus.network.http.a) r9).b;
        if (r17 != null) goto L43;
        return null;
    L43:
        return filterBotIdAndAddQuery(r1, r17.a(), r8, r17);
    L33:
        r16 = null;
        goto L34
    L28:
        if (r14.longValue() != 0) goto L30;
        mobSearchResult(r1, null, (ws9.a) ((com.larus.network.http.a) r13).b, true);
        goto L39
    L36:
        if ((r9 instanceof com.larus.network.http.f) == false) goto L39;
        com.larus.network.http.f r18 = (com.larus.network.http.f) r9;
        this.netErrorCode = Boxing.boxLong(r18.d.getCode());
        mobSearchResult(r1, String.valueOf(r18.d.getCode()), (ws9.a) ((com.larus.network.http.a) r18).b, false);
        return new FtsSearchResult(CollectionsKt.emptyList(), 0, false);
    L21:
        r12 = null;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        JSONObject r19 = new JSONObject();
        r19.put("keyword", r20);
        r19.put("offset", r21);
        r19.put("index_type", 2);
        r19.put("size", 20);
        Unit r22 = Unit.INSTANCE;
        r4.L$0 = r20;
        r4.J$0 = r21;
        r4.label = 1;
        r3 = HttpExtKt.k("Basic", ws9.a.class, "/alice/comprehensive/search", r19, null, null, false, null, null, null, r4, 1008);
        if (r3 != r6) goto L17;
        return r6;
    L17:
        r8 = r21;
        r1 = r20;
    L7:
        r4 = new C01121(this, r23);
        goto L8
    }

    private final Object searchConversation(String r18, int r19, Continuation<? super FtsSearchResult<wc9.e>> r20) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r20));
        FLogger.a.i(TAG, "searchConversation start");
        NativeConversationServiceImpl r1 = com.larus.im.d.d();
        long r5 = this.currentCursorConversation;
        e10 r2 = e10.a;
        if (e10.H().h() == false) goto L7;
        int r3 = l0.a;
        if (((Boolean) l0.a(Boolean.TRUE, new hq())).booleanValue() == true) goto L7;
        boolean r8 = true;
    L8:
        r1.searchConversationByFts(new FtsSearchParam(r18, true, r5, r19, r8, null, null, null, null, 480, null), new e(r0));
        Object r4 = r0.getOrThrow();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r20);
    L11:
        return r4;
    L7:
        r8 = false;
        goto L8
    }

    public final void loadFirstPageData(String r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "keyword");
        Intrinsics.checkNotNullParameter(r6, "enterMethod");
        FLogger.a.i(TAG, "loadFirstPageData");
        if (Intrinsics.areEqual(this.latestKeyword, r4) == true) goto L5;
        this.latestKeyword = r4;
        reset();
    L5:
        this.searchType = r5;
        this.enterMethod = r6;
        if (r5 != 0) goto L8;
        loadBots(r4, true);
        loadMessage(r4, true);
        return;
    L8:
        if (r5 != 1) goto L10;
        loadBots(r4, true);
        return;
    L10:
        if (r5 != 2) goto L17;
        loadMessage(r4, true);
        return;
    }

    public static final /* synthetic */ Object access$searchBot(CombineSearchViewModel r0, String r1, long r2, Continuation r4) {
        return r0.searchBot(r1, r2, r4);
    }

    public static final /* synthetic */ Object access$searchConversation(CombineSearchViewModel r0, String r1, int r2, Continuation r3) {
        return r0.searchConversation(r1, r2, r3);
    }

    private final FtsSearchResult<ws9.c> filterBotIdAndAddQuery(String r8, List<ws9.b> r9, long r10, ws9.a r12) {
        Integer r0 = r12.c();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        long r3 = ((long) r2) + r10;
        Integer r4 = r12.d();
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        long r6 = r5;
        List r7 = null;
        if (r3 < r6) goto L13;
        Boolean r11 = Boolean.FALSE;
        Long r13 = null;
    L17:
        if (r9 == null) goto L22;
        r7 = new ArrayList();
        Iterator<T> r14 = r9.iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        r7.add(new ws9.c(r8, (ws9.b) r14.next()));
    L22:
        if (r7 != null) goto L24;
        r7 = CollectionsKt.emptyList();
    L24:
        if (r13 == null) goto L26;
        long r15 = r13.longValue();
    L28:
        return new FtsSearchResult(r7, r15, r11.booleanValue());
    L26:
        r15 = 0;
        goto L28
    L13:
        r11 = Boolean.TRUE;
        Integer r16 = r12.c();
        if (r16 == null) goto L16;
        r1 = r16.intValue();
    L16:
        r13 = Long.valueOf(r10 + ((long) r1));
        goto L17
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    private final void mobSearchResult(String r15, String r16, ws9.a r17, boolean r18) {
        String r2 = this.enterMethod;
        String r1 = null;
        if (r17 == null) goto L7;
        Integer r3 = r17.d();
        if (r3 == null) goto L7;
        Long r4 = Long.valueOf(r3.intValue());
    L8:
        String r6 = iz8.c.d(r15);
        String r8 = this.searchRequestId;
        String r7 = this.searchId;
        if (r17 == null) goto L11;
        r1 = r17.b();
    L11:
        String r10 = r1;
        if (r18 == false) goto L14;
        String r5 = "1";
    L15:
        i3.c(null, r2, r16, r4, r15, r6, r7, r8, "chat_list_discover_search_rcmd", r10, r5, this.trackNode, 4161);
        return;
    L14:
        r5 = "0";
    L7:
        r4 = null;
        goto L8
    }

    public static /* synthetic */ Object searchConversation$default(CombineSearchViewModel r0, String r1, int r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 20;
    L6:
        return r0.searchConversation(r1, r2, r3);
    }
}
