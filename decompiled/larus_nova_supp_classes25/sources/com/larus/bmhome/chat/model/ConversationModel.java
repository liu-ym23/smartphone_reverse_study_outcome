package com.larus.bmhome.chat.model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.kunminx.architecture.domain.message.MutableResult;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.api.CvsApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.s1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010$\u001a\u00020)2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010*\u001a\u0004\u0018\u00010%J\u0014\u0010+\u001a\u00020)2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020%J \u00100\u001a\u00020\u00142\u0006\u0010*\u001a\u00020%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J0\u00104\u001a\u0004\u0018\u00010%2\b\u00105\u001a\u0004\u0018\u0001062\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u000108H\u0086@¢\u0006\u0002\u00109J(\u0010:\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010%2\u0016\b\u0002\u0010;\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0014\u0018\u00010<R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R!\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b&\u0010'¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/model/ConversationModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/larus/bmhome/chat/model/repo/ConversationRepo;", "conversationListLivedata", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "getConversationListLivedata", "()Landroidx/lifecycle/MutableLiveData;", "latestConversationData", "getLatestConversationData", "()Ljava/util/List;", "setLatestConversationData", "(Ljava/util/List;)V", "reportAwemeConversation", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "service", "Lcom/larus/im/service/IConversationService;", "getService", "()Lcom/larus/im/service/IConversationService;", "service$delegate", "Lkotlin/Lazy;", "_updateNameStatus", "Lcom/kunminx/architecture/domain/message/MutableResult;", "", "updateNameStatus", "Landroidx/lifecycle/LiveData;", "getUpdateNameStatus", "()Landroidx/lifecycle/LiveData;", "delete", "", "getDelete", "()Lcom/kunminx/architecture/domain/message/MutableResult;", "delete$delegate", "Lkotlinx/coroutines/Job;", "botId", "batchDelUserConv", "data", "updateConversationName", "conversationId", "name", "changePinStatusConversation", "pin", "", "hideConversation", "createLocalConversation", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "extraData", "", "(Lcom/larus/im/bean/bot/BotModel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecommendBot", "callback", "Lkotlin/Function1;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationModel extends AndroidViewModel {
    public static final a Companion = null;
    public static final String TAG = "ConversationModel";
    private final MutableResult<Integer> _updateNameStatus;
    private final MutableLiveData<List<wh8.a>> conversationListLivedata;
    private final Lazy delete$delegate;
    private List<wh8.a> latestConversationData;
    private final ConversationRepo repo;
    private final Lazy service$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IIMCallback<Boolean> {
        public final /* synthetic */ ConversationModel a;

        public final boolean mustInMain() {
            return true;
        }

        public b(ConversationModel r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            Intrinsics.checkNotNullParameter(r2, "error");
            ConversationModel.access$get_updateNameStatus$p(this.a).postValue(Integer.valueOf(r2.getCode()));
        }

        public final void onSuccess(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            int r3 = 0;
        L6:
            ConversationModel.access$get_updateNameStatus$p(this.a).postValue(Integer.valueOf(r3));
            return;
        L5:
            r3 = -1;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationModel$batchDelUserConv$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationModel$batchDelUserConv$1", f = "ConversationModel.kt", i = {0}, l = {96}, m = "invokeSuspend", n = {"chatOnlyList"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<wh8.a> $data;
        Object L$0;
        int label;
        final /* synthetic */ ConversationModel this$0;

        public AnonymousClass1(List<wh8.a> r1, ConversationModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$data = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$data, this.this$0, r4);
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
            List r2 = (List) this.L$0;
            ResultKt.throwOnFailure(r9);
        L29:
            if (((Boolean) r9).booleanValue() == false) goto L37;
            Iterator r10 = r2.iterator();
        L32:
            if (r10.hasNext() == false) goto L39;
            Pair r3 = (Pair) r10.next();
            BotStatusCacheDelegate r4 = BotStatusCacheDelegate.b;
            String r5 = (String) r3.getSecond();
            if (r5 != null) goto L36;
            r5 = "";
        L36:
            r4.a(r5, false);
        L39:
            return Unit.INSTANCE;
        L37:
            this.this$0.getDelete().postValue("");
            goto L39
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            List<wh8.a> r11 = this.$data;
            ArrayList r6 = new ArrayList();
            Iterator<T> r12 = r11.iterator();
        L9:
            String r7 = null;
            if (r12.hasNext() == false) goto L20;
            wh8.a r8 = (wh8.a) r12.next();
            wc9.e r13 = r8.a;
            if (r13 == null) goto L15;
            String r14 = r13.a;
            if (r14 == null) goto L15;
        L16:
            BotModel r15 = r8.b;
            if (r15 == null) goto L19;
            r7 = r15.getBotId();
        L19:
            CollectionsKt.addAll(r6, CollectionsKt.listOf(TuplesKt.to(r14, r7)));
        L15:
            r14 = "";
            goto L16
        L20:
            RepoDispatcher.a.getClass();
            ConversationRepo r16 = RepoDispatcher.f;
            ArrayList r17 = new ArrayList();
            Iterator r18 = r6.iterator();
        L22:
            if (r18.hasNext() == false) goto L24;
            CollectionsKt.addAll(r17, CollectionsKt.listOf(((Pair) r18.next()).getFirst()));
            goto L22
        L24:
            this.L$0 = r6;
            this.label = 1;
            r16.getClass();
            CompletableDeferred r19 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            com.larus.im.d.d().batchDelUserConv(r17, 3, new com.larus.bmhome.chat.model.repo.n1(r17, r19));
            r9 = r19.await(this);
            if (r9 != r0) goto L27;
            return r0;
        L27:
            r2 = r6;
            goto L29
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationModel$changePinStatusConversation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationModel$changePinStatusConversation$1", f = "ConversationModel.kt", i = {}, l = {133, DoraCallStateCode.DOUBAO_ENV_OBE_STOP_CONVERSATION, 142}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ int $cellType;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ int $conversationType;
        final /* synthetic */ boolean $pin;
        int label;
        final /* synthetic */ ConversationModel this$0;

        public C01611(String r1, ConversationModel r2, String r3, boolean r4, int r5, int r6, Continuation<? super C01611> r7) {
            this.$conversationId = r1;
            this.this$0 = r2;
            this.$botId = r3;
            this.$pin = r4;
            this.$cellType = r5;
            this.$conversationType = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C01611(this.$conversationId, this.this$0, this.$botId, this.$pin, this.$cellType, this.$conversationType, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L12;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L10;
            if (r0 != 3) goto L9;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L29:
            ((Boolean) r1).booleanValue();
        L31:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r14);
            Object r2 = r14;
        L25:
            ((Boolean) r2).booleanValue();
            goto L31
        L11:
            ResultKt.throwOnFailure(r14);
            Object r3 = r14;
        L18:
            if (((wc9.e) r3) == null) goto L31;
            ConversationListModel r4 = ConversationListModel.a;
            String r5 = this.$conversationId;
            r4.getClass();
            ConversationListModel.o(r5);
            goto L31
        L12:
            ResultKt.throwOnFailure(r14);
            if (StringsKt.contains$default(this.$conversationId, "local", false, 2, null) == false) goto L20;
            ConversationRepo r6 = ConversationModel.access$getRepo$p(this.this$0);
            String r7 = this.$botId;
            boolean r8 = this.$pin;
            this.label = 1;
            r3 = IConversationRepoService$a.a(r6, r7, 2, null, null, r8, null, null, null, null, this, 492);
            if (r3 != r12) goto L18;
            return r12;
        L20:
            ConversationRepo r9 = ConversationModel.access$getRepo$p(this.this$0);
            boolean r10 = this.$pin;
            String r11 = this.$conversationId;
            int r13 = this.$cellType;
            int r15 = this.$conversationType;
            if (r10 == false) goto L26;
            this.label = 2;
            r9.getClass();
            r2 = ConversationRepo.A(r11, r13, r15, this);
            if (r2 != r12) goto L25;
            return r12;
        L26:
            this.label = 3;
            r9.getClass();
            r1 = ConversationRepo.D(r11, r13, r15, this);
            if (r1 != r12) goto L29;
            return r12;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationModel$delete$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationModel$delete$4", f = "ConversationModel.kt", i = {}, l = {60, 74}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ wc9.e $conversation;
        int label;
        final /* synthetic */ ConversationModel this$0;

        public AnonymousClass4(wc9.e r1, String r2, ConversationModel r3, Continuation<? super AnonymousClass4> r4) {
            this.$conversation = r1;
            this.$botId = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass4(this.$conversation, this.$botId, this.this$0, r5);
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
            String r6 = "";
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L46:
            if (((Boolean) r9).booleanValue() == false) goto L58;
            MutableResult<String> r10 = this.this$0.getDelete();
            wc9.e r2 = this.$conversation;
            if (r2 == null) goto L53;
            String r3 = r2.a;
            if (r3 == null) goto L53;
            r6 = r3;
        L53:
            r10.postValue(r6);
            ConversationRepo r11 = ConversationModel.access$getRepo$p(this.this$0);
            wc9.e r4 = this.$conversation;
            if (r4 == null) goto L56;
            String r5 = r4.a;
        L57:
            r11.h(r5, null);
        L60:
            return Unit.INSTANCE;
        L56:
            r5 = null;
            goto L57
        L58:
            this.this$0.getDelete().postValue("");
            goto L60
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
        L28:
            if (((Boolean) r9).booleanValue() == false) goto L36;
            BotStatusCacheDelegate r12 = BotStatusCacheDelegate.b;
            String r7 = this.$botId;
            if (r7 == null) goto L33;
            r6 = r7;
        L33:
            r12.a(r6, false);
            this.this$0.getDelete().postValue(this.$conversation.a);
            IShortcutPlatformService r13 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
            if (r13 == null) goto L60;
            r13.a(this.$conversation.a);
            goto L60
        L36:
            this.this$0.getDelete().postValue("");
            goto L60
        L10:
            ResultKt.throwOnFailure(r9);
            FLogger r14 = FLogger.a;
            StringBuilder r8 = new StringBuilder("delete conversationId: ");
            wc9.e r15 = this.$conversation;
            if (r15 == null) goto L13;
            String r16 = r15.a;
        L14:
            r8.append(r16);
            r8.append(", botId: ");
            r8.append(this.$botId);
            r14.i(ConversationModel.TAG, r8.toString());
            wc9.e r17 = this.$conversation;
            if (r17 == null) goto L22;
            Integer r18 = r17.j;
            if (r18 == null) goto L22;
            if (r18.intValue() != 3) goto L22;
            boolean r19 = true;
        L23:
            if (r19 == false) goto L37;
            ConversationRepo r20 = ConversationModel.access$getRepo$p(this.this$0);
            String r21 = this.$conversation.a;
            ConversationDeleteMode r22 = ConversationDeleteMode.DeleteMode_RealDelete;
            String r23 = this.$botId;
            this.label = 1;
            r9 = r20.l(r21, r22, r23, this);
            if (r9 != r0) goto L28;
            return r0;
        L37:
            ConversationRepo r24 = ConversationModel.access$getRepo$p(this.this$0);
            wc9.e r25 = this.$conversation;
            if (r25 == null) goto L41;
            String r26 = r25.a;
            if (r26 == null) goto L41;
        L42:
            ConversationDeleteMode r27 = ConversationDeleteMode.DeleteMode_RemoveFromChain;
            String r28 = this.$botId;
            this.label = 2;
            r9 = r24.l(r26, r27, r28, this);
            if (r9 != r0) goto L46;
            return r0;
        L41:
            r26 = "";
        L22:
            r19 = false;
            goto L23
        L13:
            r16 = null;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationModel$deleteRecommendBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationModel$deleteRecommendBot$1", f = "ConversationModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_SI_BY_NOTIFICATION}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C01621(String r1, Function1<? super Boolean, Unit> r2, Continuation<? super C01621> r3) {
            this.$botId = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01621(this.$botId, this.$callback, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L16:
            if (((Boolean) r6).booleanValue() == false) goto L20;
            Function1<Boolean, Unit> r7 = this.$callback;
            if (r7 == null) goto L24;
            r7.invoke(Boxing.boxBoolean(true));
        L24:
            return Unit.INSTANCE;
        L20:
            Function1<Boolean, Unit> r8 = this.$callback;
            if (r8 == null) goto L24;
            r8.invoke(Boxing.boxBoolean(false));
            goto L24
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            String r9 = this.$botId;
            if (r9 == null) goto L11;
            ConversationListModel r2 = ConversationListModel.a;
            this.label = 1;
            r2.getClass();
            r6 = BuildersKt.withContext(Dispatchers.getMain(), new ConversationListModel$deleteRecommendBot$2(r9, null), this);
            if (r6 != r0) goto L16;
            return r0;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationModel$hideConversation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationModel$hideConversation$1", f = "ConversationModel.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        final /* synthetic */ int $conversationType;
        int label;
        final /* synthetic */ ConversationModel this$0;

        public C01631(ConversationModel r1, String r2, int r3, Continuation<? super C01631> r4) {
            this.this$0 = r1;
            this.$conversationId = r2;
            this.$conversationType = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01631(this.this$0, this.$conversationId, this.$conversationType, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            boolean r8 = ((Boolean) r7).booleanValue();
            FLogger.a.i(ConversationModel.TAG, "hide conversation success=" + r8);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ConversationRepo r9 = ConversationModel.access$getRepo$p(this.this$0);
            String r2 = this.$conversationId;
            int r3 = this.$conversationType;
            this.label = 1;
            r9.getClass();
            CompletableDeferred r10 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            com.larus.im.d.d().operateConversation(r2, r3, 5, new s1(r10));
            r7 = r10.await(this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationModel$reportAwemeConversation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationModel$reportAwemeConversation$1", f = "ConversationModel.kt", i = {}, l = {MessageCellStateTransformerType.EDU_CONTINUE_SHOT}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ wc9.e $conversation;
        int label;
        final /* synthetic */ ConversationModel this$0;

        public C01641(ConversationModel r1, wc9.e r2, Continuation<? super C01641> r3) {
            this.this$0 = r1;
            this.$conversation = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01641(this.this$0, this.$conversation, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ConversationRepo r5 = ConversationModel.access$getRepo$p(this.this$0);
            wc9.e r2 = this.$conversation;
            this.label = 1;
            r5.getClass();
            ((CvsApi) CvsApi.a.getValue()).getClass();
            if (CvsApi.a(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ com.larus.im.service.r Mo() {
        return service_delegate$lambda$0();
    }

    public static /* synthetic */ MutableResult yo() {
        return delete_delegate$lambda$1();
    }

    private static final MutableResult delete_delegate$lambda$1() {
        return new MutableResult();
    }

    private final com.larus.im.service.r getService() {
        return (com.larus.im.service.r) this.service$delegate.getValue();
    }

    public final MutableResult<String> getDelete() {
        return (MutableResult) this.delete$delegate.getValue();
    }

    private static final com.larus.im.service.r service_delegate$lambda$0() {
        return com.larus.im.d.d();
    }

    public final MutableLiveData<List<wh8.a>> getConversationListLivedata() {
        return this.conversationListLivedata;
    }

    public final List<wh8.a> getLatestConversationData() {
        return this.latestConversationData;
    }

    public final LiveData<Integer> getUpdateNameStatus() {
        return this._updateNameStatus;
    }

    public ConversationModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        RepoDispatcher.a.getClass();
        this.repo = RepoDispatcher.f;
        this.conversationListLivedata = new MutableLiveData();
        this.service$delegate = LazyKt.lazy(new g1());
        this._updateNameStatus = new MutableResult();
        this.delete$delegate = LazyKt.lazy(new h1());
    }

    public static final /* synthetic */ ConversationRepo access$getRepo$p(ConversationModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ MutableResult access$get_updateNameStatus$p(ConversationModel r0) {
        return r0._updateNameStatus;
    }

    public final Job batchDelUserConv(List<wh8.a> r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r8, this, null), 3, null);
    }

    public final void hideConversation(wc9.e r8) {
        Intrinsics.checkNotNullParameter(r8, "conversation");
        FLogger.a.i(TAG, "hide conversation: " + r8.a);
        String r0 = r8.a;
        Integer r9 = r8.j;
        if (r9 == null) goto L5;
        int r10 = r9.intValue();
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01631(this, r0, r10, null), 3, null);
        return;
    L5:
        r10 = 0;
        goto L6
    }

    public final void reportAwemeConversation(wc9.e r8) {
        Intrinsics.checkNotNullParameter(r8, "conversation");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01641(this, r8, null), 3, null);
    }

    public final void setLatestConversationData(List<wh8.a> r1) {
        this.latestConversationData = r1;
    }

    public final Job delete(wc9.e r7, String r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass4(r7, r8, this, null), 3, null);
    }

    public final Job deleteRecommendBot(String r7, Function1<? super Boolean, Unit> r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01621(r7, r8, null), 3, null);
    }

    public final void updateConversationName(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "name");
        getService().updateConversationTitle(r3, r4, new b(this));
    }

    public final void changePinStatusConversation(String r16, wc9.e r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "botId");
        if (r17 != null) goto L5;
        return;
    L5:
        String r3 = r17.a;
        int r7 = r17.F;
        Integer r0 = r17.j;
        if (r0 == null) goto L8;
        int r8 = r0.intValue();
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01611(r3, this, r16, r18, r7, r8, null), 3, null);
        return;
    L8:
        r8 = 0;
        goto L9
    }

    public final Object createLocalConversation(BotModel r3, Map<String, String> r4, Continuation<? super String> r5) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return IConversationRepoService$a.b(this.repo, r3, r4, r5, 4);
    }

    public static /* synthetic */ Job delete$default(ConversationModel r0, wc9.e r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.delete(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job deleteRecommendBot$default(ConversationModel r0, String r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.deleteRecommendBot(r1, r2);
    }
}
