package com.larus.chat.search.impl.chat;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.chat.search.api.SearchSectionExternalServiceDelegate;
import com.larus.chat.search.api.model.SectionItemData;
import com.larus.chat.search.api.model.SectionViewType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.x3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 J2\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\u0017J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bJ\u0018\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u0012J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001dH\u0002J\u0012\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010$H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\u0018\u00107\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u00108\u001a\u000209J\u0016\u0010:\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010;J$\u0010<\u001a\u00020\u00122\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0002J\b\u0010?\u001a\u00020\u0012H\u0002J\u0018\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u0002062\u0006\u0010B\u001a\u000206H\u0002J\u0018\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\u000f*\b\u0012\u0004\u0012\u0002060\u000fH\u0002J,\u0010D\u001a\b\u0012\u0004\u0012\u0002060\u000f2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010E\u001a\u0002092\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010FJ(\u0010G\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fH\u0002J\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/chat/search/impl/chat/ChatSectionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_sectionListFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/chat/search/api/model/SectionItemData;", "messageSectionList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "searchConversationProvider", "Lcom/larus/platform/api/ISearchConversationProvider;", "latestSubCvsSnapshot", "", "Lcom/larus/platform/model/search/SubConversationSimplifyModel;", "legacyConversationListLoaded", "", "cachedBottomSections", "messagePagingDone", "firstMessagePageLoaded", "getDataFlow", "Lkotlinx/coroutines/flow/StateFlow;", "maxIndex", "", "searchCvsId", "", "loadFirstData", "", "cvsId", "refreshCurrentConversations", "reason", "rebuild", "resetAndInit", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "getConversation", "()Lcom/larus/im/bean/conversation/Conversation;", "setConversation", "(Lcom/larus/im/bean/conversation/Conversation;)V", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "getBotModel", "()Lcom/larus/im/bean/bot/BotModel;", "setBotModel", "(Lcom/larus/im/bean/bot/BotModel;)V", "loadConversation", "shouldShowSubConversationsAsSection", "currentConversation", "onlyShowConversationItems", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "preMsg", "Lcom/larus/im/bean/message/Message;", "loadMoreData", "needSize", "", "rebuildAndEmit", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSameSectionList", "oldList", "newList", "hasNoData", "createTimeStampMessage", "current", "preMessage", "extractFirstRecords", "getMessageList", "limit", "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appendEnd", "bottomSections", "timeGroup", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSectionViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final int GET_LIST_LIMIT = 500;
    private static final int PAGE_SIZE = 25;
    private static final String TAG = "ChatSearchViewModel";
    private static final String TIME_GROUP_MESSAGE_SUFFIX = "-time-group";
    private static final String TIME_STAMP_MESSAGE_SUFFIX = "-time-stamp";
    private final z0<List<SectionItemData>> _sectionListFlow;
    private BotModel botModel;
    private volatile List<SectionItemData> cachedBottomSections;
    private wc9.e conversation;
    private volatile boolean firstMessagePageLoaded;
    private final AtomicBoolean isLoading;
    private volatile List<gr9.b> latestSubCvsSnapshot;
    private volatile boolean legacyConversationListLoaded;
    private long maxIndex;
    private volatile boolean messagePagingDone;
    private final CopyOnWriteArrayList<SectionItemData> messageSectionList;
    private Message preMsg;
    private final x3 searchConversationProvider;
    private String searchCvsId;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ kotlinx.coroutines.i<List<Message>> a;

        public final boolean mustInMain() {
            return !y0.a();
        }

        public b(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            kotlinx.coroutines.i<List<Message>> r3 = this.a;
            Result.Companion r0 = Result.Companion;
            r3.resumeWith(Result.constructor-impl(CollectionsKt.emptyList()));
        }

        public final void onSuccess(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.resumeWith(Result.constructor-impl(r3));
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((SectionItemData) r4).getCreateTime()), Long.valueOf(((SectionItemData) r3).getCreateTime()));
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((SectionItemData) r4).getCreateTime()), Long.valueOf(((SectionItemData) r3).getCreateTime()));
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSectionViewModel$loadConversation$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSectionViewModel$loadConversation$1", f = "ChatSectionViewModel.kt", i = {}, l = {116, 117}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ChatSectionViewModel this$0;

        public AnonymousClass1(ChatSectionViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            ChatSectionViewModel r2 = (ChatSectionViewModel) this.L$0;
            ResultKt.throwOnFailure(r11);
        L17:
            r2.setBotModel((BotModel) r11);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ChatSectionViewModel r3 = (ChatSectionViewModel) this.L$0;
            ResultKt.throwOnFailure(r11);
        L13:
            r3.setConversation((wc9.e) r11);
            ChatSectionViewModel r12 = this.this$0;
            IBotRepoService r4 = RepoDispatcherDelegate.b.b();
            String r5 = ChatSectionViewModel.access$getSearchCvsId$p(this.this$0);
            this.L$0 = r12;
            this.label = 2;
            Object r6 = r4.j1(r5, false, this);
            if (r6 != r0) goto L16;
            return r0;
        L16:
            r2 = r12;
            r11 = r6;
            goto L17
        L10:
            ResultKt.throwOnFailure(r11);
            r3 = this.this$0;
            IConversationRepoService r7 = RepoDispatcherDelegate.b.f();
            String r8 = ChatSectionViewModel.access$getSearchCvsId$p(this.this$0);
            this.L$0 = r3;
            this.label = 1;
            r11 = IConversationRepoService.a.c(r7, r8, false, null, this, 6);
            if (r11 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSectionViewModel$loadMoreData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSectionViewModel$loadMoreData$1", f = "ChatSectionViewModel.kt", i = {}, l = {153, 157, 160}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ChatSectionViewModel this$0;

        public C02671(ChatSectionViewModel r1, Continuation<? super C02671> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02671(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r6);
        L27:
            ChatSectionViewModel.access$isLoading$p(this.this$0).set(false);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ChatSectionViewModel r2 = (ChatSectionViewModel) this.L$0;
            ResultKt.throwOnFailure(r6);
        L20:
            List r7 = (List) r6;
            if (r7 != null) goto L23;
            r7 = CollectionsKt.emptyList();
        L23:
            ChatSectionViewModel.access$setLatestSubCvsSnapshot$p(r2, r7);
            ChatSectionViewModel.access$setLegacyConversationListLoaded$p(this.this$0, true);
        L24:
            ChatSectionViewModel r8 = this.this$0;
            this.L$0 = null;
            this.label = 3;
            if (ChatSectionViewModel.access$rebuildAndEmit(r8, "onlyConversationItems", this) != r0) goto L27;
            return r0;
        L11:
            ChatSectionViewModel r3 = (ChatSectionViewModel) this.L$0;
            ResultKt.throwOnFailure(r6);
        L15:
            ChatSectionViewModel.access$setCachedBottomSections$p(r3, (List) r6);
            ChatSectionViewModel.access$setMessagePagingDone$p(this.this$0, true);
            ChatSectionViewModel.access$setFirstMessagePageLoaded$p(this.this$0, true);
            ChatSectionViewModel.access$getSearchConversationProvider$p(this.this$0);
            if (ChatSectionViewModel.access$getLegacyConversationListLoaded$p(this.this$0) == true) goto L24;
            r2 = this.this$0;
            IAIChatConversationService.Companion r9 = IAIChatConversationService.a;
            this.L$0 = r2;
            this.label = 2;
            r6 = r9.c(this);
            if (r6 != r0) goto L20;
            return r0;
        L12:
            ResultKt.throwOnFailure(r6);
            ChatSectionViewModel.access$getMessageSectionList$p(this.this$0).clear();
            r3 = this.this$0;
            SearchSectionExternalServiceDelegate r10 = SearchSectionExternalServiceDelegate.b;
            this.L$0 = r3;
            this.label = 1;
            r6 = r10.a(this);
            if (r6 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSectionViewModel$loadMoreData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSectionViewModel$loadMoreData$2", f = "ChatSectionViewModel.kt", i = {1, 2}, l = {171, 178, 185, 188}, m = "invokeSuspend", n = {"newList", "newList"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cvsId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ChatSectionViewModel this$0;

        public AnonymousClass2(ChatSectionViewModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$cvsId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$cvsId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r6 = true;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r15);
        L47:
            ChatSectionViewModel.access$isLoading$p(this.this$0).set(false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ChatSectionViewModel r2 = (ChatSectionViewModel) this.L$1;
            List r4 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);
        L43:
            ChatSectionViewModel.access$setCachedBottomSections$p(r2, (List) r15);
            List r16 = r4;
        L44:
            ChatSectionViewModel r3 = this.this$0;
            String r17 = "loadMoreData done=" + ChatSectionViewModel.access$getMessagePagingDone$p(this.this$0) + " newMsgs=" + r16.size();
            this.L$0 = null;
            this.L$1 = null;
            this.label = 4;
            if (ChatSectionViewModel.access$rebuildAndEmit(r3, r17, this) != r0) goto L47;
            return r0;
        L12:
            ChatSectionViewModel r5 = (ChatSectionViewModel) this.L$1;
            List r7 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);
        L27:
            List r18 = (List) r15;
            if (r18 != null) goto L30;
            r18 = CollectionsKt.emptyList();
        L30:
            ChatSectionViewModel.access$setLatestSubCvsSnapshot$p(r5, r18);
            ChatSectionViewModel.access$setLegacyConversationListLoaded$p(this.this$0, true);
            r16 = r7;
        L31:
            ChatSectionViewModel r8 = this.this$0;
            if (r16.size() >= ChatSectionViewModel.GET_LIST_LIMIT) goto L34;
        L37:
            ChatSectionViewModel.access$setMessagePagingDone$p(r8, r6);
            if (ChatSectionViewModel.access$getMessagePagingDone$p(this.this$0) == false) goto L44;
            r2 = this.this$0;
            SearchSectionExternalServiceDelegate r9 = SearchSectionExternalServiceDelegate.b;
            this.L$0 = r16;
            this.L$1 = r2;
            this.label = 3;
            Object r10 = r9.a(this);
            if (r10 != r0) goto L42;
            return r0;
        L42:
            r4 = r16;
            r15 = r10;
            goto L43
        L34:
            if (r16.isEmpty() == true) goto L37;
            r6 = false;
            goto L37
        L13:
            ResultKt.throwOnFailure(r15);
        L17:
            ChatSectionViewModel r11 = this.this$0;
            r16 = (List) r15;
            Message r12 = (Message) CollectionsKt.lastOrNull(r16);
            if (r12 == null) goto L20;
            long r13 = r12.getLocalIndex();
        L21:
            ChatSectionViewModel.access$setMaxIndex$p(r11, r13);
            ChatSectionViewModel.access$getMessageSectionList$p(this.this$0).addAll(ChatSectionViewModel.access$extractFirstRecords(this.this$0, r16));
            ChatSectionViewModel.access$setFirstMessagePageLoaded$p(this.this$0, true);
            ChatSectionViewModel.access$getSearchConversationProvider$p(this.this$0);
            if (ChatSectionViewModel.access$getLegacyConversationListLoaded$p(this.this$0) == true) goto L31;
            r5 = this.this$0;
            IAIChatConversationService.Companion r14 = IAIChatConversationService.a;
            this.L$0 = r16;
            this.L$1 = r5;
            this.label = 2;
            Object r19 = r14.c(this);
            if (r19 != r0) goto L26;
            return r0;
        L26:
            r7 = r16;
            r15 = r19;
            goto L27
        L20:
            r13 = ChatSectionViewModel.access$getMaxIndex$p(r11);
            goto L21
        L14:
            ResultKt.throwOnFailure(r15);
            ChatSectionViewModel r20 = this.this$0;
            String r21 = this.$cvsId;
            long r110 = ChatSectionViewModel.access$getMaxIndex$p(r20);
            this.label = 1;
            r15 = ChatSectionViewModel.access$getMessageList(r20, r21, ChatSectionViewModel.GET_LIST_LIMIT, r110, this);
            if (r15 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSectionViewModel$rebuildAndEmit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSectionViewModel", f = "ChatSectionViewModel.kt", i = {0}, l = {195, 257}, m = "rebuildAndEmit", n = {"reason"}, s = {"L$0"})
    public static final class C02681 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatSectionViewModel this$0;

        public C02681(ChatSectionViewModel r1, Continuation<? super C02681> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ChatSectionViewModel.access$rebuildAndEmit(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.chat.search.impl.chat.ChatSectionViewModel$refreshCurrentConversations$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.chat.search.impl.chat.ChatSectionViewModel$refreshCurrentConversations$1", f = "ChatSectionViewModel.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        int label;
        final /* synthetic */ ChatSectionViewModel this$0;

        public C02691(ChatSectionViewModel r1, String r2, Continuation<? super C02691> r3) {
            this.this$0 = r1;
            this.$reason = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02691(this.this$0, this.$reason, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ChatSectionViewModel r6 = this.this$0;
            String r2 = "refreshCurrentConversations:" + this.$reason;
            this.label = 1;
            if (ChatSectionViewModel.access$rebuildAndEmit(r6, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public final void refreshCurrentConversations(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "reason");
    }

    private final boolean hasNoData() {
        SectionItemData r0 = (SectionItemData) CollectionsKt.lastOrNull((List) this._sectionListFlow.getValue());
        if (r0 == null) goto L5;
        SectionViewType r1 = r0.getViewType();
    L7:
        if (r1 != SectionViewType.LAST) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    private final boolean onlyShowConversationItems() {
        z2.a.w3();
        return false;
    }

    private final void loadConversation() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final BotModel getBotModel() {
        return this.botModel;
    }

    public final wc9.e getConversation() {
        return this.conversation;
    }

    public final i1<List<SectionItemData>> getDataFlow() {
        return this._sectionListFlow;
    }

    public ChatSectionViewModel(Application r3) {
        Intrinsics.checkNotNullParameter(r3, "application");
        super(r3);
        this._sectionListFlow = j1.a(new ArrayList());
        this.messageSectionList = new CopyOnWriteArrayList();
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L5;
        r4.X();
    L5:
        this.latestSubCvsSnapshot = CollectionsKt.emptyList();
        this.maxIndex = Long.MAX_VALUE;
        this.searchCvsId = "";
        this.isLoading = new AtomicBoolean(false);
    }

    public static final /* synthetic */ boolean access$getLegacyConversationListLoaded$p(ChatSectionViewModel r0) {
        return r0.legacyConversationListLoaded;
    }

    public static final /* synthetic */ long access$getMaxIndex$p(ChatSectionViewModel r2) {
        return r2.maxIndex;
    }

    public static final /* synthetic */ boolean access$getMessagePagingDone$p(ChatSectionViewModel r0) {
        return r0.messagePagingDone;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getMessageSectionList$p(ChatSectionViewModel r0) {
        return r0.messageSectionList;
    }

    public static final /* synthetic */ x3 access$getSearchConversationProvider$p(ChatSectionViewModel r0) {
        r0.getClass();
        return null;
    }

    public static final /* synthetic */ String access$getSearchCvsId$p(ChatSectionViewModel r0) {
        return r0.searchCvsId;
    }

    public static final /* synthetic */ AtomicBoolean access$isLoading$p(ChatSectionViewModel r0) {
        return r0.isLoading;
    }

    private final List<SectionItemData> extractFirstRecords(List<Message> r7) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r2 = r8.next();
        if ((!com.larus.bmhome.chat.bean.d.V0((Message) r2)) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r9 = r1.iterator();
        int r3 = 0;
    L10:
        if (r9.hasNext() == false) goto L30;
        Message r4 = (Message) r9.next();
        Message r5 = this.preMsg;
        if (r5 == null) goto L29;
        String r6 = null;
        if (r5 == null) goto L17;
        String r10 = r5.getSectionId();
    L19:
        if (Intrinsics.areEqual(r10, r4.getSectionId()) == true) goto L29;
        Message r11 = this.preMsg;
        if (r11 == null) goto L24;
        r6 = r11.getSectionId();
    L24:
        if (o0.d(r6) == false) goto L29;
        Message r12 = this.preMsg;
        Intrinsics.checkNotNull(r12);
        SectionItemData r13 = createTimeStampMessage(r4, r12);
        if (o0.d(r13.getSectionName()) == false) goto L28;
        r0.add(r13);
        goto L29
    L28:
        r3 = r3 + 1;
        goto L29
    L17:
        r10 = null;
    L29:
        this.preMsg = r4;
        goto L10
    L30:
        if (r3 <= 0) goto L32;
        FLogger.a.i(TAG, "extractFirstRecords timeStampErrorCount=" + r3);
    L32:
        return r0;
    }

    private final void resetAndInit(String r4) {
        this.maxIndex = Long.MAX_VALUE;
        this._sectionListFlow.setValue(new ArrayList());
        this.messageSectionList.clear();
        this.cachedBottomSections = null;
        this.messagePagingDone = false;
        this.firstMessagePageLoaded = false;
        this.isLoading.set(false);
        this.preMsg = null;
        this.searchCvsId = r4;
        this.conversation = null;
        this.botModel = null;
        loadConversation();
    }

    private final boolean shouldShowSubConversationsAsSection(wc9.e r1) {
        if (ic8.n.v(r1) == false) goto L6;
        return true;
    L6:
        z2.a.w3();
        return false;
    }

    private final List<SectionItemData> timeGroup(List<SectionItemData> r25) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r25.iterator();
        String r3 = "";
    L4:
        if (r1.hasNext() == false) goto L47;
        SectionItemData r4 = (SectionItemData) r1.next();
        Calendar r5 = iz8.a.a;
        long r6 = r4.getCreateTime();
        long r7 = System.currentTimeMillis();
        long r9 = RangesKt.coerceAtLeast((r7 / 1000) - r6, 60);
        Calendar r11 = iz8.a.a;
        r11.setTimeInMillis(r7);
        Calendar r8 = iz8.a.b;
        r8.setTimeInMillis(r6 * ((long) GuidePriority.COMMERCE_CREDIT_PRIORITY));
        int r10 = r11.get(6) - r8.get(6);
        boolean r12 = false;
        if (r10 == 0) goto L37;
        if (r10 != 1) goto L11;
        String r13 = AppHost.a.getApplication().getString(2131900671);
    L39:
        if (Intrinsics.areEqual(r13, r3) == true) goto L46;
        if (r13.length() != 0) goto L43;
        r12 = true;
    L43:
        if (r12 == true) goto L46;
        r0.add(new SectionItemData(r4.getCreateTime(), r13 + TIME_GROUP_MESSAGE_SUFFIX, null, r13, SectionViewType.TIME.getType(), 0, null, false, null, 0, null, 2020, null));
        r0.add(r4);
        r3 = r13;
    L46:
        r0.add(r4);
        goto L4
    L11:
        if (86400 <= r9) goto L13;
    L15:
        boolean r14 = false;
    L16:
        if (r14 == false) goto L19;
        r13 = AppHost.a.getApplication().getString(2131900669);
        goto L39
    L19:
        if (604800 <= r9) goto L21;
    L23:
        boolean r15 = false;
    L24:
        if (r15 == false) goto L27;
        r13 = AppHost.a.getApplication().getString(2131900668);
        goto L39
    L27:
        if (2592000 <= r9) goto L29;
    L31:
        boolean r16 = false;
    L32:
        if (r16 == false) goto L35;
        r13 = AppHost.a.getApplication().getString(2131900667);
        goto L39
    L35:
        if (r9 <= 31536000) goto L37;
        r13 = AppHost.a.getApplication().getString(2131900670);
        goto L39
    L29:
        if (r9 >= 31536000) goto L31;
        r16 = true;
        goto L32
    L21:
        if (r9 >= 2592000) goto L23;
        r15 = true;
        goto L24
    L13:
        if (r9 >= 604800) goto L15;
        r14 = true;
    L37:
        r13 = "";
        goto L39
    L47:
        return r0;
    }

    public final void loadFirstData(String r4) {
        Intrinsics.checkNotNullParameter(r4, "cvsId");
        resetAndInit(r4);
        refreshCurrentConversations("loadFirstData", false);
        loadMoreData$default(this, r4, 0, 2, null);
    }

    public final void setBotModel(BotModel r1) {
        this.botModel = r1;
    }

    public final void setConversation(wc9.e r1) {
        this.conversation = r1;
    }

    public static final /* synthetic */ List access$extractFirstRecords(ChatSectionViewModel r0, List r1) {
        return r0.extractFirstRecords(r1);
    }

    public static final /* synthetic */ void access$setCachedBottomSections$p(ChatSectionViewModel r0, List r1) {
        r0.cachedBottomSections = r1;
    }

    public static final /* synthetic */ void access$setFirstMessagePageLoaded$p(ChatSectionViewModel r0, boolean r1) {
        r0.firstMessagePageLoaded = r1;
    }

    public static final /* synthetic */ void access$setLatestSubCvsSnapshot$p(ChatSectionViewModel r0, List r1) {
        r0.latestSubCvsSnapshot = r1;
    }

    public static final /* synthetic */ void access$setLegacyConversationListLoaded$p(ChatSectionViewModel r0, boolean r1) {
        r0.legacyConversationListLoaded = r1;
    }

    public static final /* synthetic */ void access$setMaxIndex$p(ChatSectionViewModel r0, long r1) {
        r0.maxIndex = r1;
    }

    public static final /* synthetic */ void access$setMessagePagingDone$p(ChatSectionViewModel r0, boolean r1) {
        r0.messagePagingDone = r1;
    }

    private final List<SectionItemData> appendEnd(List<SectionItemData> r19, List<SectionItemData> r20) {
        if (r20 == null) goto L5;
        r19.addAll(r20);
    L5:
        r19.add(new SectionItemData(0, null, null, null, SectionViewType.LAST.getType(), 0, null, false, null, 0, null, 2031, null));
        return r19;
    }

    private final SectionItemData createTimeStampMessage(Message r18, Message r19) {
        long r1 = r19.getCreateTime();
        String r0 = r19.getSectionId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r3 = r0;
        if (o0.d(r19.getSectionName()) == false) goto L8;
        String r2 = r19.getSectionName();
        Intrinsics.checkNotNull(r2);
    L10:
        return new SectionItemData(r1, r3, null, r2, SectionViewType.NORMAL.getType(), r18.getLocalIndex() + 1, b0.k(r18.getMessageId() + TIME_STAMP_MESSAGE_SUFFIX, 3), o0.d(r19.getSectionName()), null, 0, null, 1796, null);
    L8:
        r2 = iz8.c.c(r19);
        goto L10
    }

    private final boolean isSameSectionList(List<SectionItemData> r11, List<SectionItemData> r12) {
        if (r11.size() == r12.size()) goto L5;
        return false;
    L5:
        Collection r0 = CollectionsKt.getIndices(r11);
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        IntIterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        int r2 = r1.nextInt();
        SectionItemData r4 = (SectionItemData) ListProtector.get(r11, r2);
        SectionItemData r3 = (SectionItemData) ListProtector.get(r12, r2);
        if (r4.getCreateTime() == r3.getCreateTime()) goto L16;
    L34:
        boolean r5 = false;
    L35:
        if (r5 == true) goto L12;
        return false;
    L16:
        if (Intrinsics.areEqual(r4.getSectionId(), r3.getSectionId()) == false) goto L34;
        if (Intrinsics.areEqual(r4.getConversationId(), r3.getConversationId()) == false) goto L34;
        if (Intrinsics.areEqual(r4.getSectionName(), r3.getSectionName()) == false) goto L34;
        if (r4.getViewType() != r3.getViewType()) goto L34;
        if (r4.getLocalIndex() != r3.getLocalIndex()) goto L34;
        if (Intrinsics.areEqual(r4.getMessageId(), r3.getMessageId()) == false) goto L34;
        if (r4.isSectionName() != r3.isSectionName()) goto L34;
        if (Intrinsics.areEqual(r4.getUrl(), r3.getUrl()) == false) goto L34;
        if (r4.getUnreadCount() != r3.getUnreadCount()) goto L34;
        r5 = true;
    L9:
        return true;
    L8:
        if (r0.isEmpty() == false) goto L10;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.util.ArrayList] */
    private final Object rebuildAndEmit(String r31, Continuation<? super Unit> r32) {
        if ((r32 instanceof C02681) == false) goto L7;
        C02681 r2 = (C02681) r32;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L106:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r5 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L22:
        wc9.e r6 = (wc9.e) r1;
        this.conversation = r6;
    L24:
        boolean r7 = onlyShowConversationItems();
        int r8 = 0;
        if (r7 == false) goto L27;
    L30:
        boolean r10 = true;
    L32:
        if (r10 == false) goto L37;
        List<gr9.b> r11 = this.latestSubCvsSnapshot;
        ?? r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L35:
        if (r13.hasNext() == false) goto L38;
        gr9.b r14 = (gr9.b) r13.next();
        r12.add(new SectionItemData(r14.c, null, r14.a, r14.b, SectionViewType.NORMAL.getType(), 0, null, false, null, RangesKt.coerceAtLeast(r14.e - r14.f, r8), null, 1506, null));
        r8 = 0;
    L38:
        if (r7 == false) goto L40;
        List r15 = CollectionsKt.emptyList();
    L41:
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("rebuildAndEmit reason=");
        r17.append(r5);
        r17.append(" onlyConversationItems=");
        r17.append(r7);
        r17.append(" showCvsSection=");
        r17.append(r10);
        r17.append(" msg=");
        r17.append(r15.size());
        r17.append(" subCvs=");
        r17.append(r12.size());
        r17.append(" redDotItems=");
        Iterable r18 = (Iterable) r12;
        if ((r18 instanceof Collection) == true) goto L44;
    L46:
        Iterator r19 = r18.iterator();
        int r110 = 0;
    L48:
        if (r19.hasNext() == false) goto L57;
        if (((SectionItemData) r19.next()).getUnreadCount() <= 0) goto L52;
        boolean r111 = true;
    L53:
        if (r111 == false) goto L48;
        r110 = r110 + 1;
        if (r110 >= 0) goto L48;
        CollectionsKt.throwCountOverflow();
        goto L48
    L52:
        r111 = false;
    L57:
        r17.append(r110);
        r17.append(" totalUnread=");
        Iterator r20 = r18.iterator();
        int r112 = 0;
    L59:
        if (r20.hasNext() == false) goto L61;
        r112 = r112 + ((SectionItemData) r20.next()).getUnreadCount();
        goto L59
    L61:
        r17.append(r112);
        r17.append(" done=");
        r17.append(this.messagePagingDone);
        r16.i(TAG, r17.toString());
        List<gr9.b> r21 = this.latestSubCvsSnapshot;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L63:
        if (r23.hasNext() == false) goto L67;
        Object r113 = r23.next();
        if (((gr9.b) r113).g == false) goto L63;
        r22.add(r113);
        goto L63
    L67:
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r25 = r22.iterator();
    L69:
        if (r25.hasNext() == false) goto L71;
        r24.add(((gr9.b) r25.next()).a);
        goto L69
    L71:
        Set r26 = CollectionsKt.toSet(r24);
        ArrayList r27 = new ArrayList();
        Iterator r28 = r18.iterator();
    L73:
        if (r28.hasNext() == false) goto L77;
        Object r114 = r28.next();
        if (CollectionsKt.contains(r26, ((SectionItemData) r114).getConversationId()) == false) goto L73;
        r27.add(r114);
        goto L73
    L77:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r18.iterator();
    L79:
        if (r30.hasNext() == false) goto L83;
        Object r115 = r30.next();
        if (CollectionsKt.contains(r26, ((SectionItemData) r115).getConversationId()) == true) goto L79;
        r29.add(r115);
        goto L79
    L83:
        List r33 = CollectionsKt.sortedWith(r29, new c());
        if (r7 == false) goto L86;
        List<SectionItemData> r34 = CollectionsKt.toMutableList(CollectionsKt.plus(r27, timeGroup(CollectionsKt.toMutableList(r33))));
    L88:
        if (this.messagePagingDone == false) goto L90;
        r34 = appendEnd(r34, this.cachedBottomSections);
    L90:
        SectionItemData r35 = (SectionItemData) CollectionsKt.firstOrNull(r34);
        FLogger r36 = FLogger.a;
        StringBuilder r37 = new StringBuilder("rebuildAndEmit result firstCvsId=");
        if (r35 == null) goto L93;
        String r116 = r35.getConversationId();
    L94:
        r37.append(r116);
        r37.append(" mainId=");
        Set r38 = r26;
        r37.append((String) CollectionsKt.firstOrNull(r38));
        r37.append(" mainItems=");
        r37.append(r27.size());
        r37.append(" mainPinned=");
        if (r35 == null) goto L97;
        String r39 = r35.getConversationId();
    L98:
        r37.append(CollectionsKt.contains(r38, r39));
        r37.append(" finalSize=");
        r37.append(r34.size());
        r36.i(TAG, r37.toString());
        if (isSameSectionList((List) this._sectionListFlow.getValue(), r34) == false) goto L102;
        r36.i(TAG, "rebuildAndEmit skip same list reason=" + r5 + " size=" + r34.size());
        return Unit.INSTANCE;
    L102:
        z0<List<SectionItemData>> r40 = this._sectionListFlow;
        r2.L$0 = null;
        r2.label = 2;
        if (r40.emit(r34, r2) != r9) goto L106;
        return r9;
    L97:
        r39 = null;
        goto L98
    L93:
        r116 = null;
        goto L94
    L86:
        r34 = CollectionsKt.toMutableList(CollectionsKt.plus(r27, timeGroup(CollectionsKt.toMutableList(CollectionsKt.sortedWith(CollectionsKt.plus(r15, r33), new d())))));
        goto L88
    L44:
        if (((Collection) r18).isEmpty() == false) goto L46;
        r110 = 0;
        goto L57
    L40:
        r15 = CollectionsKt.toList(this.messageSectionList);
        goto L41
    L37:
        r12 = CollectionsKt.emptyList();
        goto L38
    L27:
        if (shouldShowSubConversationsAsSection(r6) == true) goto L30;
        r10 = false;
        goto L32
    L16:
        ResultKt.throwOnFailure(r1);
        r6 = this.conversation;
        if (r6 != null) goto L23;
        IConversationRepoService r41 = RepoDispatcherDelegate.b.f();
        String r42 = this.searchCvsId;
        r2.L$0 = r31;
        r2.label = 1;
        r1 = IConversationRepoService.a.c(r41, r42, false, null, r2, 6);
        if (r1 != r9) goto L21;
        return r9;
    L21:
        r5 = r31;
        goto L22
    L23:
        r5 = r31;
    L7:
        r2 = new C02681(this, r32);
        goto L8
    }

    public final synchronized void loadMoreData(String r9, int r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "cvsId");     // Catch: Throwable -> L25
        if (this.isLoading.get() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.isLoading.set(true);     // Catch: Throwable -> L25
        if (r10 > 0) goto L13;
        this.isLoading.set(false);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L13:
        if (onlyShowConversationItems() == false) goto L18;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02671(this, null), 2, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L18:
        if (hasNoData() == false) goto L22;
        this.isLoading.set(false);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L22:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(this, r9, null), 2, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ Object access$rebuildAndEmit(ChatSectionViewModel r0, String r1, Continuation r2) {
        return r0.rebuildAndEmit(r1, r2);
    }

    private final Object getMessageList(String r13, int r14, long r15, Continuation<? super List<Message>> r17) {
        MessageListRequest r11 = new MessageListRequest(r13, 0, 0, r14, r15, null, false, 102, null);
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r17), 1);
        r0.C();
        com.larus.im.d.e().getMessageListFromLocal(r11, new b(r0));
        Object r1 = r0.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r17);
    L5:
        return r1;
    }

    public static final /* synthetic */ Object access$getMessageList(ChatSectionViewModel r0, String r1, int r2, long r3, Continuation r5) {
        return r0.getMessageList(r1, r2, r3, r5);
    }

    public static /* synthetic */ void loadMoreData$default(ChatSectionViewModel r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = PAGE_SIZE;
    L5:
        r0.loadMoreData(r1, r2);
    }

    public static /* synthetic */ void refreshCurrentConversations$default(ChatSectionViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.refreshCurrentConversations(r1, r2);
    }
}
