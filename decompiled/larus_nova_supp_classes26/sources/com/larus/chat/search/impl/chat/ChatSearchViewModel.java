package com.larus.chat.search.impl.chat;

import android.app.Application;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.conversation.FtsSearchParam;
import com.larus.im.internal.core.conversation.FtsSearchResult;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
import v19.b7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rJ\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ\b\u00105\u001a\u00020\u0018H\u0002J(\u00106\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001072\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u00108\u001a\u00020+H\u0082@¢\u0006\u0002\u00109J0\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\b\u0018\u00010;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0082@¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010?\u001a\u00020(J\u0018\u0010@\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010?\u001a\u00020(H\u0002J$\u0010A\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\b2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0082@¢\u0006\u0002\u0010=J\u0016\u0010B\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010?\u001a\u00020(J\u0018\u0010C\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010?\u001a\u00020(H\u0002J\u0018\u0010D\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010?\u001a\u00020(H\u0002J\u001a\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\rH\u0002R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!0\u001dj\b\u0012\u0004\u0012\u00020!`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0#j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e`$X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020&0#j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020&`$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006L"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSearchViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "searchResultLv", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/chat/search/impl/chat/ChatSearchResult;", "getSearchResultLv", "()Landroidx/lifecycle/MutableLiveData;", "latestKeyword", "", "getLatestKeyword", "()Ljava/lang/String;", "setLatestKeyword", "(Ljava/lang/String;)V", "searchInCvsId", "getSearchInCvsId", "setSearchInCvsId", "subConversationList", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "updateKeyWord", "", "keyword", "loadFirstPageData", "conversationId", "conversationResultList", "Ljava/util/ArrayList;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/collections/ArrayList;", "messageResultList", "Lcom/larus/im/bean/message/Message;", "conversationMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "botModelMap", "Lcom/larus/im/bean/bot/BotModel;", "conversationSearchFirstDone", "", "messageSearchFirstDone", "currentConversationWillShowCount", "", "currentCursorConversation", "", "currentCursorMessage", "hasMoreConversation", "hasMoreMessage", "getHasMoreMessage", "()Z", "setHasMoreMessage", "(Z)V", "reset", "searchConversation", "Lcom/larus/im/internal/core/conversation/FtsSearchResult;", "limit", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchGetBotByConversationId", "", "cvsIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadConversation", "isFirstPage", "finishSearchConversation", "batchGetConversationByIds", "loadMessage", "finishSearchMessage", "generateSearchResult", "buildMatchingKeywordString", "", "textBuilder", "Landroid/text/SpannableStringBuilder;", "toSpannableString", "originString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSearchViewModel extends AndroidViewModel {
    public static final a Companion = null;
    public static final int INIT_CONVERSATION_SHOW_COUNT = 4;
    public static final int INIT_CONVERSATION_SHOW_COUNT_NO_MESSAGE = 22;
    private static final Regex ITALIC_REGEX = null;
    public static final int LIMIT_CONVERSATION_PAGE = 20;
    private static final String TAG = "ChatSearchViewModel";
    private final HashMap<String, BotModel> botModelMap;
    private final HashMap<String, wc9.e> conversationMap;
    private final ArrayList<wc9.e> conversationResultList;
    private boolean conversationSearchFirstDone;
    private int currentConversationWillShowCount;
    private long currentCursorConversation;
    private long currentCursorMessage;
    private boolean hasMoreConversation;
    private boolean hasMoreMessage;
    private String latestKeyword;
    private final ArrayList<Message> messageResultList;
    private boolean messageSearchFirstDone;
    private String searchInCvsId;
    private final MutableLiveData<List<t>> searchResultLv;
    private List<gr9.b> subConversationList;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IIMCallback<Map<String, ? extends List<? extends BotModel>>> {
        public final /* synthetic */ Continuation<Map<String, ? extends List<BotModel>>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public b(SafeContinuation r1) {
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

    public static final class c implements IIMCallback<List<? extends wc9.e>> {
        public final /* synthetic */ Continuation<List<wc9.e>> a;

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
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    public static final class d implements IIMCallback<FtsSearchResult<wc9.e>> {
        public final /* synthetic */ Continuation<FtsSearchResult<wc9.e>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public d(SafeContinuation r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.w(ChatSearchViewModel.TAG, "searchConversation :" + r4);
            this.a.resumeWith(Result.constructor-impl(null));
        }

        public final void onSuccess(Object r4) {
            FtsSearchResult r5 = (FtsSearchResult) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.i(ChatSearchViewModel.TAG, "searchConversation size: " + r5.getData().size());
            this.a.resumeWith(Result.constructor-impl(r5));
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSearchViewModel$loadConversation$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSearchViewModel$loadConversation$1", f = "ChatSearchViewModel.kt", i = {}, l = {177, 191}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFirstPage;
        final /* synthetic */ String $keyword;
        int label;
        final /* synthetic */ ChatSearchViewModel this$0;

        public AnonymousClass1(ChatSearchViewModel r1, String r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
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

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L52:
            Map r12 = (Map) r11;
            if (r12 == null) goto L66;
            Set r13 = r12.entrySet();
            if (r13 == null) goto L66;
            ChatSearchViewModel r2 = this.this$0;
            Iterator r14 = r13.iterator();
            int r3 = 0;
        L58:
            if (r14.hasNext() == false) goto L66;
            Object r4 = r14.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L62;
            CollectionsKt.throwIndexOverflow();
        L62:
            Map.Entry r6 = (Map.Entry) r4;
            BotModel r7 = (BotModel) CollectionsKt.getOrNull((List) r6.getValue(), 0);
            if (r7 == null) goto L65;
            ChatSearchViewModel.access$getBotModelMap$p(r2).put(r6.getKey(), r7);
        L65:
            r3 = r5;
        L66:
            ChatSearchViewModel.access$finishSearchConversation(this.this$0, this.$keyword, this.$isFirstPage);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L17:
            FtsSearchResult r15 = (FtsSearchResult) r11;
            if (r15 != null) goto L22;
            return Unit.INSTANCE;
        L22:
            if (Intrinsics.areEqual(this.this$0.getLatestKeyword(), this.$keyword) == false) goto L24;
            ChatSearchViewModel.access$setCurrentCursorConversation$p(this.this$0, r15.getNewCursor());
            ChatSearchViewModel.access$setHasMoreConversation$p(this.this$0, r15.getHasMore());
            List r8 = r15.getData();
            ChatSearchViewModel r9 = this.this$0;
            Iterator r10 = r8.iterator();
        L27:
            if (r10.hasNext() == false) goto L43;
            wc9.e r16 = (wc9.e) r10.next();
            ArrayList r17 = ChatSearchViewModel.access$getConversationResultList$p(r9);
            if ((r17 instanceof Collection) == true) goto L31;
        L33:
            Iterator r18 = r17.iterator();
        L35:
            if (r18.hasNext() == false) goto L32;
            if (Intrinsics.areEqual(((wc9.e) r18.next()).a, r16.a) == false) goto L35;
            boolean r19 = false;
        L39:
            if (r19 == false) goto L27;
            if (ic8.n.d(r16) == true) goto L27;
            ChatSearchViewModel.access$getConversationResultList$p(r9).add(r16);
        L32:
            r19 = true;
            goto L39
        L31:
            if (r17.isEmpty() == false) goto L33;
        L43:
            List r110 = r15.getData();
            ArrayList r20 = new ArrayList();
            Iterator r111 = r110.iterator();
        L45:
            if (r111.hasNext() == false) goto L49;
            String r21 = ((wc9.e) r111.next()).a;
            if (r21 == null) goto L45;
            r20.add(r21);
            goto L45
        L49:
            List r112 = CollectionsKt.distinct(r20);
            ChatSearchViewModel r22 = this.this$0;
            this.label = 2;
            r11 = ChatSearchViewModel.access$batchGetBotByConversationId(r22, r112, this);
            if (r11 != r0) goto L52;
            return r0;
        L24:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r11);
            ChatSearchViewModel r113 = this.this$0;
            String r23 = this.$keyword;
            if (this.$isFirstPage == false) goto L13;
            int r24 = 22;
        L14:
            this.label = 1;
            r11 = ChatSearchViewModel.access$searchConversation(r113, r23, r24, this);
            if (r11 != r0) goto L17;
            return r0;
        L13:
            r24 = 20;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSearchViewModel$loadMessage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSearchViewModel$loadMessage$1", f = "ChatSearchViewModel.kt", i = {0, 1, 2, 4}, l = {242, 253, 257, 262, 283, 298}, m = "invokeSuspend", n = {"searchIdList", "searchIdList", "searchIdList", "cvsIdList"}, s = {"L$0", "L$0", "L$0", "L$0"})
    public static final class C02661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFirstPage;
        final /* synthetic */ String $keyword;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ChatSearchViewModel this$0;

        public C02661(ChatSearchViewModel r1, String r2, boolean r3, Continuation<? super C02661> r4) {
            this.this$0 = r1;
            this.$keyword = r2;
            this.$isFirstPage = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02661(this.this$0, this.$keyword, this.$isFirstPage, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList] */
        public final Object invokeSuspend(Object r16) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L28;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r16);
            Object r0 = r16;
        L146:
            Map r1 = (Map) r0;
            if (r1 == null) goto L160;
            Set r2 = r1.entrySet();
            if (r2 == null) goto L160;
            ChatSearchViewModel r3 = this.this$0;
            Iterator r4 = r2.iterator();
            int r5 = 0;
        L152:
            if (r4.hasNext() == false) goto L160;
            Object r6 = r4.next();
            int r7 = r5 + 1;
            if (r5 >= 0) goto L156;
            CollectionsKt.throwIndexOverflow();
        L156:
            Map.Entry r9 = (Map.Entry) r6;
            BotModel r10 = (BotModel) CollectionsKt.getOrNull((List) r9.getValue(), 0);
            if (r10 == null) goto L159;
            ChatSearchViewModel.access$getBotModelMap$p(r3).put(r9.getKey(), r10);
        L159:
            r5 = r7;
        L160:
            ChatSearchViewModel.access$finishSearchMessage(this.this$0, this.$keyword, this.$isFirstPage);
            return Unit.INSTANCE;
        L7:
            List r11 = (List) this.L$0;
            ResultKt.throwOnFailure(r16);
            Object r12 = r16;
        L119:
            List r13 = (List) r12;
            if (r13 == null) goto L143;
            ChatSearchViewModel r14 = this.this$0;
            Iterator r15 = r13.iterator();
            int r17 = 0;
        L123:
            if (r15.hasNext() == false) goto L143;
            Object r18 = r15.next();
            int r19 = r17 + 1;
            if (r17 >= 0) goto L127;
            CollectionsKt.throwIndexOverflow();
        L127:
            final wc9.e r20 = (wc9.e) r18;
            Integer r21 = r20.t;
            if (r21 == null) goto L139;
            if (r21.intValue() != 3) goto L139;
            Integer r22 = r20.j;
            if (r22 == null) goto L139;
            if (r22.intValue() != 2) goto L139;
            FLogger.a.w(ChatSearchViewModel.TAG, "message filter by conversation-status-RECOVERABLE: " + r20.a);
            Boxing.boxBoolean(CollectionsKt.removeAll(ChatSearchViewModel.access$getMessageResultList$p(r14), new y(r20)));
        L142:
            r17 = r19;
        L139:
            if (ic8.n.d(r20) == true) goto L141;
            ChatSearchViewModel.access$getConversationMap$p(r14).put(r20.a, r20);
            goto L142
        L141:
            FLogger.a.w(ChatSearchViewModel.TAG, "message filter by conversation-forbidSendMsg: " + r20.a);
        L143:
            ChatSearchViewModel r23 = this.this$0;
            this.L$0 = null;
            this.label = 6;
            r0 = ChatSearchViewModel.access$batchGetBotByConversationId(r23, r11, this);
            if (r0 != r8) goto L146;
            return r8;
        L8:
            ResultKt.throwOnFailure(r16);
            Object r24 = r16;
        L83:
            FtsSearchResult r25 = (FtsSearchResult) r24;
            if (r25 != null) goto L88;
            return Unit.INSTANCE;
        L88:
            if (Intrinsics.areEqual(this.this$0.getLatestKeyword(), this.$keyword) == false) goto L90;
            ChatSearchViewModel.access$setCurrentCursorMessage$p(this.this$0, r25.getNewCursor());
            this.this$0.setHasMoreMessage(r25.getHasMore());
            List r26 = r25.getData();
            ChatSearchViewModel r27 = this.this$0;
            Iterator r28 = r26.iterator();
        L93:
            if (r28.hasNext() == false) goto L110;
            Message r29 = (Message) r28.next();
            ArrayList r30 = ChatSearchViewModel.access$getMessageResultList$p(r27);
            if ((r30 instanceof Collection) == true) goto L97;
        L99:
            Iterator r31 = r30.iterator();
        L101:
            if (r31.hasNext() == false) goto L105;
            if (Intrinsics.areEqual(((Message) r31.next()).getMessageId(), r29.getMessageId()) == false) goto L101;
            boolean r32 = false;
        L106:
            if (r32 == false) goto L93;
            if (com.larus.bmhome.chat.bean.d.V0(r29) == true) goto L93;
            ChatSearchViewModel.access$getMessageResultList$p(r27).add(r29);
        L105:
            r32 = true;
            goto L106
        L97:
            if (r30.isEmpty() == false) goto L99;
        L110:
            List r33 = r25.getData();
            ArrayList r34 = new ArrayList();
            Iterator r35 = r33.iterator();
        L112:
            if (r35.hasNext() == false) goto L116;
            String r36 = ((Message) r35.next()).getConversationId();
            if (r36 == null) goto L112;
            r34.add(r36);
            goto L112
        L116:
            r11 = CollectionsKt.distinct(r34);
            ChatSearchViewModel r37 = this.this$0;
            this.L$0 = r11;
            this.label = 5;
            r12 = ChatSearchViewModel.access$batchGetConversationByIds(r37, r11, this);
            if (r12 != r8) goto L119;
            return r8;
        L90:
            return Unit.INSTANCE;
        L9:
            ChatSearchViewModel r38 = (ChatSearchViewModel) this.L$1;
            List r39 = (List) this.L$0;
            ResultKt.throwOnFailure(r16);
            Object r40 = r16;
        L67:
            List r41 = (List) r40;
        L68:
            ChatSearchViewModel.access$setSubConversationList$p(r38, r41);
            if (r39 == null) goto L78;
            List r42 = ChatSearchViewModel.access$getSubConversationList$p(this.this$0);
            if (r42 == null) goto L76;
            List r43 = r42;
            ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r43, 10));
            Iterator r45 = r43.iterator();
        L74:
            if (r45.hasNext() == false) goto L77;
            r44.add(((gr9.b) r45.next()).a);
        L77:
            Boxing.boxBoolean(r39.addAll(r44));
            goto L78
        L76:
            r44 = new ArrayList();
        L78:
            List r46 = r39;
        L80:
            int r47 = kz8.b.a;
            String r48 = this.$keyword;
            long r49 = ChatSearchViewModel.access$getCurrentCursorMessage$p(this.this$0);
            String r50 = this.this$0.getSearchInCvsId();
            this.L$0 = null;
            this.L$1 = null;
            this.label = 4;
            r24 = kz8.b.a(r48, r49, r50, r46, "chat_search", this);
            if (r24 != r8) goto L83;
            return r8;
        L10:
            List r51 = (List) this.L$0;
            ResultKt.throwOnFailure(r16);
            List r52 = r51;
            Object r53 = r16;
        L54:
            wc9.e r54 = (wc9.e) r53;
            r39 = r52;
        L56:
            if (r54 != null) goto L58;
        L60:
            boolean r55 = false;
        L61:
            if (r55 == false) goto L78;
            r38 = this.this$0;
            r41 = ChatSearchViewModel.access$getSubConversationList$p(r38);
            if (r41 != null) goto L68;
            IAIChatConversationService.Companion r56 = IAIChatConversationService.a;
            this.L$0 = r39;
            this.L$1 = r38;
            this.label = 3;
            r40 = r56.c(this);
            if (r40 != r8) goto L67;
            return r8;
        L58:
            if (ic8.n.v(r54) != true) goto L60;
            r55 = true;
            goto L61
        L11:
            ChatSearchViewModel r57 = (ChatSearchViewModel) this.L$1;
            r39 = (List) this.L$0;
            ResultKt.throwOnFailure(r16);
            ChatSearchViewModel.access$setSubConversationList$p(r57, (List) r16);
            List r58 = ChatSearchViewModel.access$getSubConversationList$p(this.this$0);
            if (r58 == null) goto L19;
            ?? r59 = new ArrayList();
            Iterator r60 = r58.iterator();
        L15:
            if (r60.hasNext() == false) goto L20;
            String r61 = ((gr9.b) r60.next()).a;
            if (r61 == null) goto L15;
            r59.add(r61);
        L20:
            LinkedHashSet r62 = new LinkedHashSet();
            if (r39 == null) goto L23;
            Boxing.boxBoolean(r62.addAll(r39));
        L23:
            r62.addAll((Collection) r59);
            if (r39 == null) goto L26;
            r39.clear();
        L26:
            if (r39 == null) goto L78;
            Boxing.boxBoolean(r39.addAll(r62));
            goto L78
        L19:
            r59 = CollectionsKt.emptyList();
            goto L20
        L28:
            ResultKt.throwOnFailure(r16);
            z2.a.w3();
            String r63 = this.this$0.getSearchInCvsId();
            if (r63 != null) goto L31;
        L34:
            boolean r64 = true;
        L35:
            if (r64 == false) goto L37;
            r52 = null;
        L41:
            String r65 = this.this$0.getSearchInCvsId();
            if (r65 != null) goto L44;
        L47:
            boolean r66 = true;
        L48:
            if (r66 == true) goto L79;
            String r67 = this.this$0.getSearchInCvsId();
            if (r67 == null) goto L55;
            IConversationRepoService r68 = RepoDispatcherDelegate.b.f();
            this.L$0 = r52;
            this.label = 2;
            r53 = IConversationRepoService.a.c(r68, r67, false, null, this, 6);
            if (r53 != r8) goto L54;
            return r8;
        L55:
            r39 = r52;
            r54 = null;
            goto L56
        L79:
            r46 = r52;
            goto L80
        L44:
            if (r65.length() == 0) goto L47;
            r66 = false;
            goto L48
        L37:
            String[] r69 = new String[1];
            String r70 = this.this$0.getSearchInCvsId();
            if (r70 != null) goto L40;
            r70 = "";
        L40:
            r69[0] = r70;
            r52 = CollectionsKt.mutableListOf(r69);
            goto L41
        L31:
            if (r63.length() == 0) goto L34;
            r64 = false;
            goto L35
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void reset() {
        this.conversationSearchFirstDone = false;
        this.messageSearchFirstDone = false;
        this.conversationResultList.clear();
        this.messageResultList.clear();
        this.conversationMap.clear();
        this.botModelMap.clear();
        this.currentConversationWillShowCount = 4;
        this.currentCursorConversation = Long.MAX_VALUE;
        this.currentCursorMessage = Long.MAX_VALUE;
        this.hasMoreConversation = true;
        this.hasMoreMessage = true;
    }

    static {
        Companion = new a();
        ITALIC_REGEX = new Regex("((\\(\\*).+?(\\*\\)))|((（\\*).+?(\\*）))");
    }

    public static final /* synthetic */ Regex access$getITALIC_REGEX$cp() {
        return ITALIC_REGEX;
    }

    public final boolean getHasMoreMessage() {
        return this.hasMoreMessage;
    }

    public final String getLatestKeyword() {
        return this.latestKeyword;
    }

    public final String getSearchInCvsId() {
        return this.searchInCvsId;
    }

    public final MutableLiveData<List<t>> getSearchResultLv() {
        return this.searchResultLv;
    }

    public ChatSearchViewModel(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        super(r3);
        this.searchResultLv = new MutableLiveData();
        this.subConversationList = IAIChatConversationService.a.d();
        this.conversationResultList = new ArrayList();
        this.messageResultList = new ArrayList();
        this.conversationMap = new HashMap();
        this.botModelMap = new HashMap();
        this.currentConversationWillShowCount = 4;
        this.currentCursorConversation = Long.MAX_VALUE;
        this.currentCursorMessage = Long.MAX_VALUE;
        this.hasMoreConversation = true;
        this.hasMoreMessage = true;
    }

    public static final /* synthetic */ HashMap access$getBotModelMap$p(ChatSearchViewModel r0) {
        return r0.botModelMap;
    }

    public static final /* synthetic */ HashMap access$getConversationMap$p(ChatSearchViewModel r0) {
        return r0.conversationMap;
    }

    public static final /* synthetic */ ArrayList access$getConversationResultList$p(ChatSearchViewModel r0) {
        return r0.conversationResultList;
    }

    public static final /* synthetic */ long access$getCurrentCursorMessage$p(ChatSearchViewModel r2) {
        return r2.currentCursorMessage;
    }

    public static final /* synthetic */ ArrayList access$getMessageResultList$p(ChatSearchViewModel r0) {
        return r0.messageResultList;
    }

    public static final /* synthetic */ List access$getSubConversationList$p(ChatSearchViewModel r0) {
        return r0.subConversationList;
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

    public final void setHasMoreMessage(boolean r1) {
        this.hasMoreMessage = r1;
    }

    public final void setLatestKeyword(String r1) {
        this.latestKeyword = r1;
    }

    public final void setSearchInCvsId(String r1) {
        this.searchInCvsId = r1;
    }

    public final void updateKeyWord(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyword");
        if (Intrinsics.areEqual(this.latestKeyword, r2) == true) goto L6;
        this.latestKeyword = r2;
        reset();
        return;
    }

    public static final /* synthetic */ void access$setCurrentCursorConversation$p(ChatSearchViewModel r0, long r1) {
        r0.currentCursorConversation = r1;
    }

    public static final /* synthetic */ void access$setCurrentCursorMessage$p(ChatSearchViewModel r0, long r1) {
        r0.currentCursorMessage = r1;
    }

    public static final /* synthetic */ void access$setHasMoreConversation$p(ChatSearchViewModel r0, boolean r1) {
        r0.hasMoreConversation = r1;
    }

    public static final /* synthetic */ void access$setSubConversationList$p(ChatSearchViewModel r0, List r1) {
        r0.subConversationList = r1;
    }

    private final Object batchGetBotByConversationId(List<String> r4, Continuation<? super Map<String, ? extends List<BotModel>>> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        com.larus.im.d.a().batchGetBotByConversationId(r4, new b(r0));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    private final Object batchGetConversationByIds(List<String> r4, Continuation<? super List<wc9.e>> r5) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        com.larus.im.d.d().batchGetConversationByIds(r4, new c(r0));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r6;
    }

    private final CharSequence buildMatchingKeywordString(SpannableStringBuilder r7, String r8) {
        boolean r0 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L21;
        if (r8 != null) goto L12;
    L15:
        if (r0 == true) goto L21;
        Matcher r9 = PatternProtector.compile(r8, 18).matcher(r7);
    L19:
        if (r9.find() == false) goto L21;
        int r1 = r9.start();
        int r3 = r9.end();
        int r4 = j0.a;
        r7.setSpan(new ForegroundColorSpan(j0.a(v19.c.b(2130972123, null, 2131103203))), r1, r3, 33);
        goto L19
    L12:
        if (r8.length() == 0) goto L15;
        r0 = false;
    L21:
        return r7;
    L5:
        if (r7.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final void finishSearchConversation(String r2, boolean r3) {
        this.conversationSearchFirstDone = true;
        generateSearchResult(r2, r3);
    }

    private final void finishSearchMessage(String r2, boolean r3) {
        this.messageSearchFirstDone = true;
        generateSearchResult(r2, r3);
    }

    private final void generateSearchResult(String r45, boolean r46) {
        if (Intrinsics.areEqual(this.latestKeyword, r45) == true) goto L5;
        return;
    L5:
        String r2 = this.searchInCvsId;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L19;
        if (this.conversationSearchFirstDone == true) goto L16;
        return;
    L16:
        if (this.messageSearchFirstDone == false) goto L184;
    L21:
        ArrayList r4 = new ArrayList();
        FLogger.a.i(TAG, "messageList before size: " + this.messageResultList.size());
        ArrayList<Message> r5 = this.messageResultList;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L23:
        if (r7.hasNext() == false) goto L84;
        Message r8 = (Message) r7.next();
        String r11 = iz8.c.c(r8);
        if (iz8.c.a(r45, r11, r8) == false) goto L81;
        wc9.e r12 = this.conversationMap.get(r8.getConversationId());
        if (r12 == null) goto L81;
        BotModel r17 = this.botModelMap.get(r8.getConversationId());
        String r13 = this.searchInCvsId;
        if (r13 != null) goto L32;
    L35:
        boolean r14 = true;
    L36:
        if (r14 == false) goto L38;
    L49:
        IconImage r15 = r12.b;
        if (r15 == null) goto L55;
        ImageObj r16 = r15.imageThumb;
        if (r16 == null) goto L55;
        String r18 = r16.url;
    L54:
        String r20 = r18;
    L56:
        String r19 = this.searchInCvsId;
        if (r19 != null) goto L59;
    L62:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        String r111 = r12.c;
    L70:
        String r112 = r111;
    L72:
        String r113 = r8.getMessageId();
        if (r113 != null) goto L75;
        String r114 = "";
    L76:
        CharSequence r115 = buildMatchingKeywordString(toSpannableString(r11), this.latestKeyword);
        String r28 = iz8.c.b(r11, this.latestKeyword);
        int r10 = b7.a;
        String r22 = b7.a(r8.getCreateTime());
        long r23 = r8.getLocalIndex();
        if (r17 == null) goto L79;
        Boolean r27 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.G0(r8));
    L80:
        t r9 = new t(r114, 1, r12, r17, r112, r115, r20, null, r22, r23, false, false, r27, r28, 3200);
    L82:
        if (r9 == null) goto L23;
        r6.add(r9);
        goto L23
    L79:
        r27 = null;
        goto L80
    L75:
        r114 = r113;
        goto L76
    L66:
        if (com.larus.bmhome.chat.bean.d.G0(r8) == false) goto L68;
        r111 = AccountService.a.getNickname();
        goto L70
    L68:
        if (r17 == null) goto L71;
        r111 = r17.getName();
        goto L70
    L71:
        r112 = null;
        goto L72
    L59:
        if (r19.length() == 0) goto L62;
        r110 = false;
    L55:
        r20 = null;
        goto L56
    L38:
        if (ic8.n.D(r12) == false) goto L43;
        if (com.larus.bmhome.chat.bean.d.G0(r8) == false) goto L49;
    L43:
        if (com.larus.bmhome.chat.bean.d.G0(r8) == false) goto L45;
        r18 = AccountService.a.s();
        goto L54
    L45:
        if (r17 == null) goto L55;
        BotIconImage r116 = r17.getIconImage();
        if (r116 == null) goto L55;
        r18 = r116.getTinyUrl();
        goto L54
    L32:
        if (r13.length() == 0) goto L35;
        r14 = false;
    L81:
        r9 = null;
        goto L82
    L84:
        boolean r21 = !r6.isEmpty();
        FLogger r24 = FLogger.a;
        r24.i(TAG, "messageList after size: " + r6.size());
        if (r46 == false) goto L88;
        if (r21 == true) goto L88;
        this.currentConversationWillShowCount = 22;
    L88:
        r24.i(TAG, "chatList before size: " + this.conversationResultList.size());
        ArrayList<wc9.e> r25 = this.conversationResultList;
        ArrayList r117 = new ArrayList();
        Iterator<T> r26 = r25.iterator();
    L90:
        if (r26.hasNext() == false) goto L101;
        wc9.e r118 = (wc9.e) r26.next();
        String r119 = r118.a;
        String r120 = r118.c;
        if (r120 != null) goto L94;
        r120 = "";
    L94:
        CharSequence r121 = buildMatchingKeywordString(new SpannableStringBuilder(r120), this.latestKeyword);
        IconImage r122 = r118.b;
        if (r122 == null) goto L99;
        ImageObj r123 = r122.imageThumb;
        if (r123 == null) goto L99;
        String r29 = r123.url;
    L100:
        r117.add(new t(r119, 0, r118, this.botModelMap.get(r118.a), r121, null, r29, null, null, 0, false, false, null, null, 16288));
    L99:
        r29 = null;
        goto L100
    L101:
        ArrayList r30 = new ArrayList();
        Iterator r31 = r117.iterator();
    L103:
        if (r31.hasNext() == false) goto L115;
        Object r124 = r31.next();
        CharSequence r125 = ((t) r124).e;
        if (r125 == null) goto L112;
        String r126 = this.latestKeyword;
        if (r126 != null) goto L110;
        r126 = "";
    L110:
        if (StringsKt.contains(r125, r126, true) != true) goto L112;
        boolean r127 = true;
    L113:
        if (r127 == false) goto L103;
        r30.add(r124);
    L112:
        r127 = false;
        goto L113
    L115:
        FLogger.a.i(TAG, "chatList after size: " + r30.size());
        if ((!r30.isEmpty()) == true) goto L118;
    L151:
        r4.addAll(r6);
        if (r21 == false) goto L157;
        if (this.hasMoreMessage == false) goto L157;
        r4.add(new t("3", 3, null, null, null, null, null, null, null, 0, false, false, null, null, 16380));
    L157:
        if (Intrinsics.areEqual(this.latestKeyword, r45) == true) goto L159;
        return;
    L159:
        this.searchResultLv.postValue(r4);
        return;
    L118:
        if (this.hasMoreConversation == false) goto L120;
    L123:
        boolean r32 = true;
    L124:
        if (r32 == false) goto L150;
        int r33 = Math.min(this.currentConversationWillShowCount - 1, r30.size() - 2);
        List r34 = r30.subList(0, r33);
        List r35 = r30.subList(r33, r33 + 2);
        r4.addAll(r34);
        List r36 = r35;
        Iterator r37 = r36.iterator();
    L127:
        if (r37.hasNext() == false) goto L139;
        Object r38 = r37.next();
        wc9.e r128 = ((t) r38).c;
        if (r128 == null) goto L136;
        Integer r129 = r128.j;
        if (r129 == null) goto L136;
        if (r129.intValue() != 2) goto L136;
        boolean r130 = true;
    L137:
        if (r130 == false) goto L127;
    L140:
        t r39 = (t) r38;
        if (r39 == null) goto L143;
        int r40 = j0.a;
        r4.add(new t("2", 2, null, null, j0.d(2131900833), null, r39.g, null, null, 0, false, !r21, null, null, 14252));
        goto L151
    L143:
        ArrayList r41 = new ArrayList();
        Iterator r42 = r36.iterator();
    L145:
        if (r42.hasNext() == false) goto L149;
        String r43 = ((t) r42.next()).g;
        if (r43 == null) goto L145;
        r41.add(r43);
        goto L145
    L149:
        int r44 = j0.a;
        r4.add(new t("2", 2, null, null, j0.d(2131900833), null, null, r41, null, 0, false, !r21, null, null, 14188));
    L136:
        r130 = false;
        goto L137
    L139:
        r38 = null;
        goto L140
    L150:
        r4.addAll(r30);
        r4.add(new t("2", 2, null, null, null, null, null, null, null, 0, true, !r21, null, null, 13308));
        goto L151
    L120:
        if (r30.size() > this.currentConversationWillShowCount) goto L123;
        r32 = false;
        goto L124
    L184:
        return;
    L19:
        if (this.messageSearchFirstDone == true) goto L21;
        return;
    L8:
        if (r2.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    public final void loadConversation(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "keyword");
        FLogger.a.i(TAG, "loadConversation isFirstPage: " + r9 + " hasMoreConversation: " + this.hasMoreConversation);
        if (r9 == true) goto L6;
        this.currentConversationWillShowCount += 20;
    L6:
        if (this.hasMoreConversation == true) goto L9;
        finishSearchConversation(r8, r9);
        return;
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
    }

    public final void loadFirstPageData(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "keyword");
        FLogger.a.i(TAG, "loadFirstPageData conversationId: " + r5);
        this.searchInCvsId = r5;
        if (Intrinsics.areEqual(this.latestKeyword, r4) == true) goto L5;
        this.latestKeyword = r4;
        reset();
    L5:
        String r6 = this.searchInCvsId;
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        loadConversation(r4, true);
        loadMessage(r4, true);
        return;
    L14:
        loadMessage(r4, true);
        return;
    L8:
        if (r6.length() == 0) goto L11;
        r7 = false;
        goto L12
    }

    public final void loadMessage(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "keyword");
        FLogger.a.i(TAG, "loadMessage isFirstPage: " + r9 + " hasMoreMessage: " + this.hasMoreMessage);
        if (this.hasMoreMessage == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02661(this, r8, r9, null), 3, null);
    }

    public static final /* synthetic */ Object access$batchGetBotByConversationId(ChatSearchViewModel r0, List r1, Continuation r2) {
        return r0.batchGetBotByConversationId(r1, r2);
    }

    public static final /* synthetic */ Object access$batchGetConversationByIds(ChatSearchViewModel r0, List r1, Continuation r2) {
        return r0.batchGetConversationByIds(r1, r2);
    }

    public static final /* synthetic */ void access$finishSearchConversation(ChatSearchViewModel r0, String r1, boolean r2) {
        r0.finishSearchConversation(r1, r2);
    }

    public static final /* synthetic */ void access$finishSearchMessage(ChatSearchViewModel r0, String r1, boolean r2) {
        r0.finishSearchMessage(r1, r2);
    }

    private final Object searchConversation(String r18, int r19, Continuation<? super FtsSearchResult<wc9.e>> r20) {
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r20));
        FLogger.a.i(TAG, "searchConversation start");
        NativeConversationServiceImpl r1 = com.larus.im.d.d();
        long r5 = this.currentCursorConversation;
        z2 r2 = z2.a;
        if (r2.getChatListSearchConfig().c == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        r1.searchConversationByFts(new FtsSearchParam(r18, true, r5, r19, r8, null, null, null, null, 480, null), new d(r0));
        Object r3 = r0.getOrThrow();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r20);
    L11:
        return r3;
    L5:
        if (r2.searchForceByLike() == true) goto L7;
        r8 = true;
        goto L8
    }

    public static final /* synthetic */ Object access$searchConversation(ChatSearchViewModel r0, String r1, int r2, Continuation r3) {
        return r0.searchConversation(r1, r2, r3);
    }

    public static /* synthetic */ Object searchConversation$default(ChatSearchViewModel r0, String r1, int r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 20;
    L6:
        return r0.searchConversation(r1, r2, r3);
    }
}
