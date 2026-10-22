package com.larus.bmhome.bot;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.kunminx.architecture.domain.message.MutableResult;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.SpeechLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.AppLocaleUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;J\u000e\u0010=\u001a\u0002092\u0006\u0010<\u001a\u00020;J\u000e\u0010\r\u001a\u0002092\u0006\u0010<\u001a\u00020;J\u0016\u0010>\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010?\u001a\u00020;J\u000e\u0010@\u001a\u00020A2\u0006\u0010<\u001a\u00020;J\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020C0#2\u0006\u0010<\u001a\u00020;H\u0086@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u00020;2\u0006\u0010K\u001a\u00020;H\u0002J\u001e\u0010\u0018\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010L\u001a\u00020IH\u0086@¢\u0006\u0002\u0010MJ\u0006\u0010N\u001a\u000209J\u000e\u0010O\u001a\u00020A2\u0006\u0010:\u001a\u00020;J\u000e\u0010P\u001a\u00020A2\u0006\u0010:\u001a\u00020;J\u0016\u0010T\u001a\u00020A2\u0006\u0010:\u001a\u00020;2\u0006\u0010U\u001a\u00020\u001fJ\u000e\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020\u001fR!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\nR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\nR!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b \u0010\u001cR'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b%\u0010\nR'\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b(\u0010\nR\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u00020\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b6\u00107R!\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\f\u001a\u0004\bR\u0010\u001c¨\u0006X"}, d2 = {"Lcom/larus/bmhome/bot/BotSettingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "deleteBot", "Lcom/kunminx/architecture/domain/message/MutableResult;", "Lcom/larus/bmhome/bot/bean/BooleanResult;", "getDeleteBot", "()Lcom/kunminx/architecture/domain/message/MutableResult;", "deleteBot$delegate", "Lkotlin/Lazy;", "removeConversation", "getRemoveConversation", "removeConversation$delegate", "updateCvsName", "Lcom/larus/bmhome/bot/bean/ConversationUpdateResult;", "getUpdateCvsName", "updateCvsName$delegate", "chatHistoryClearSuccess", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "getChatHistoryClearSuccess", "chatHistoryClearSuccess$delegate", "updateBotAccessPermission", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/im/bean/bot/BotUpdateResult;", "getUpdateBotAccessPermission", "()Landroidx/lifecycle/MutableLiveData;", "updateBotAccessPermission$delegate", "updateBotEditItemFromDBResult", "", "getUpdateBotEditItemFromDBResult", "updateBotEditItemFromDBResult$delegate", "subjectBotInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/bot/bean/BotSubjectResult;", "getSubjectBotInfo", "subjectBotInfo$delegate", "resetBotInfo", "getResetBotInfo", "resetBotInfo$delegate", "conversationService", "Lcom/larus/im/service/IConversationService;", "getConversationService", "()Lcom/larus/im/service/IConversationService;", "conversationService$delegate", "botRepo", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "conversationRepo", "Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "shareBtnCenter", "getShareBtnCenter", "()Z", "shareBtnCenter$delegate", "", "botId", "", "conversationId", "clearHistory", "updateConversationName", "name", "requireUpdateConversationInfo", "Lkotlinx/coroutines/Job;", "requireSyncConversationInfo", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsrLanguage", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "cvsType", "", "findAsrLanguageByLanguageCode", "languageCode", "privateStatus", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBotEditSubTitle", "requireSubjectBot", "reverseBotSubject", "messagePushLiveData", "getMessagePushLiveData", "messagePushLiveData$delegate", "updateMsgPushToggle", "messagePush", "updateExpertToggle", "switch", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotSettingViewModel extends AndroidViewModel {
    private final IBotRepoService botRepo;
    private final Lazy chatHistoryClearSuccess$delegate;
    private final IConversationRepoService conversationRepo;
    private final Lazy conversationService$delegate;
    private final Lazy deleteBot$delegate;
    private final Lazy messagePushLiveData$delegate;
    private final Lazy removeConversation$delegate;
    private final Lazy resetBotInfo$delegate;
    private final ISettingRepoService settingRepo;
    private final Lazy shareBtnCenter$delegate;
    private final Lazy subjectBotInfo$delegate;
    private final Lazy updateBotAccessPermission$delegate;
    private final Lazy updateBotEditItemFromDBResult$delegate;
    private final Lazy updateCvsName$delegate;

    public static final class a implements IIMCallback<Boolean> {
        public final /* synthetic */ BotSettingViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public final void onFailure(IIMError r6) {
            Intrinsics.checkNotNullParameter(r6, "error");
            Intrinsics.checkNotNullParameter(r6, "error");
            this.a.getUpdateCvsName().postValue(new ub8.e(false, this.b, this.c, r6));
        }

        public final void onSuccess(Object r6) {
            ((Boolean) r6).booleanValue();
            this.a.getUpdateCvsName().postValue(new ub8.e(true, this.b, this.c, null));
        }

        public a(BotSettingViewModel r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$clearHistory$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$clearHistory$1", f = "BotSettingViewModel.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$clearHistory$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$clearHistory$1$1", f = "BotSettingViewModel.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_12}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $conversationId;
            final /* synthetic */ Pair<Boolean, Long> $pullSingleChainConfig;
            int label;

            public C00361(Pair<Boolean, Long> r1, String r2, Continuation<? super C00361> r3) {
                this.$pullSingleChainConfig = r1;
                this.$conversationId = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00361(this.$pullSingleChainConfig, this.$conversationId, r4);
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
            L11:
                com.larus.im.d.e().j(new uf9.a.a(this.$conversationId, 10), null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                long r3 = ((Number) this.$pullSingleChainConfig.getSecond()).longValue();
                this.label = 1;
                if (DelayKt.delay(r3, this) != r0) goto L11;
                return r0;
            }
        }

        public AnonymousClass1(String r1, BotSettingViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$conversationId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$conversationId, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            ub8.b r9 = (ub8.b) r8;
            this.this$0.getChatHistoryClearSuccess().postValue(r9);
            Pair r2 = com.larus.platform.service.z2.a.s3();
            if (ub8.d.a(r9) == false) goto L17;
            if (((Boolean) r2.getFirst()).booleanValue() == false) goto L17;
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C00361(r2, this.$conversationId, null), 2, null);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            IConversationRepoService r10 = zh8.a.b;
            String r3 = this.$conversationId;
            this.label = 1;
            r8 = r10.q(r3, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$deleteBot$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$deleteBot$4", f = "BotSettingViewModel.kt", i = {}, l = {91, 92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public AnonymousClass4(String r1, String r2, BotSettingViewModel r3, Continuation<? super AnonymousClass4> r4) {
            this.$botId = r1;
            this.$conversationId = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass4(this.$botId, this.$conversationId, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r74) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            boolean r4 = true;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r74);
            Object r3 = r74;
        L19:
            if (((Boolean) r3).booleanValue() == true) goto L22;
        L21:
            r4 = false;
        L22:
            if (r4 == false) goto L26;
            IShortcutPlatformService r5 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
            if (r5 == null) goto L26;
            r5.a(this.$conversationId);
        L26:
            this.this$0.getDeleteBot().postValue(new ub8.a(r4));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r74);
            Object r6 = r74;
        L14:
            if (((Boolean) r6).booleanValue() == false) goto L21;
            IChatRepoService r7 = zh8.a.a;
            IConversationRepoService r8 = zh8.a.b;
            String r9 = this.$conversationId;
            ConversationDeleteMode r10 = ConversationDeleteMode.DeleteMode_RealDelete;
            String r11 = this.$botId;
            this.label = 2;
            r3 = r8.l(r9, r10, r11, this);
            if (r3 != r1) goto L19;
            return r1;
        L10:
            ResultKt.throwOnFailure(r74);
            IChatRepoService r12 = zh8.a.a;
            IBotRepoService r13 = zh8.a.e;
            BotModel r15 = new BotModel(this.$botId, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
            this.label = 1;
            r6 = r13.s1(r15, this);
            if (r6 != r1) goto L14;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$removeConversation$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$removeConversation$4", f = "BotSettingViewModel.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01384 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01384(String r1, BotSettingViewModel r2, Continuation<? super C01384> r3) {
            this.$conversationId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01384(this.$conversationId, this.this$0, r4);
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
        L11:
            boolean r6 = ((Boolean) r5).booleanValue();
            this.this$0.getRemoveConversation().postValue(new ub8.a(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IConversationRepoService r7 = zh8.a.b;
            String r2 = this.$conversationId;
            ConversationDeleteMode r3 = ConversationDeleteMode.DeleteMode_RealDelete;
            this.label = 1;
            r5 = r7.l(r2, r3, null, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$requireSubjectBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$requireSubjectBot$1", f = "BotSettingViewModel.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01391(BotSettingViewModel r1, String r2, Continuation<? super C01391> r3) {
            this.this$0 = r1;
            this.$botId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01391(this.this$0, this.$botId, r4);
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
        L11:
            MutableResult<com.larus.network.http.a<ub8.c>> r2 = this.this$0.getSubjectBotInfo();
            r2.postValue((com.larus.network.http.a) r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IBotRepoService r5 = BotSettingViewModel.access$getBotRepo$p(this.this$0);
            String r3 = this.$botId;
            this.label = 1;
            r4 = r5.f1(r3, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$requireUpdateConversationInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$requireUpdateConversationInfo$1", f = "BotSettingViewModel.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01401(BotSettingViewModel r1, String r2, Continuation<? super C01401> r3) {
            this.this$0 = r1;
            this.$conversationId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01401(this.this$0, this.$conversationId, r4);
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
            IConversationRepoService r5 = BotSettingViewModel.access$getConversationRepo$p(this.this$0);
            String r2 = this.$conversationId;
            this.label = 1;
            if (r5.r(r2, "", "", this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$reverseBotSubject$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$reverseBotSubject$1", f = "BotSettingViewModel.kt", i = {}, l = {DoraCallStateCode.DORA_NEW_USER_GUIDE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01411(BotSettingViewModel r1, String r2, Continuation<? super C01411> r3) {
            this.this$0 = r1;
            this.$botId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01411(this.this$0, this.$botId, r4);
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
        L11:
            MutableResult<com.larus.network.http.a<ub8.c>> r2 = this.this$0.getResetBotInfo();
            r2.postValue((com.larus.network.http.a) r4);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            IBotRepoService r5 = BotSettingViewModel.access$getBotRepo$p(this.this$0);
            String r3 = this.$botId;
            this.label = 1;
            r4 = r5.p1(r3, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$updateAsrLanguage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$updateAsrLanguage$1", f = "BotSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $botInfo;
        final /* synthetic */ int $cvsType;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01421(BotModel r1, BotSettingViewModel r2, int r3, Continuation<? super C01421> r4) {
            this.$botInfo = r1;
            this.this$0 = r2;
            this.$cvsType = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01421(this.$botInfo, this.this$0, this.$cvsType, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            SpeakerVoice r5 = this.$botInfo.getVoiceType();
            if (r5 == null) goto L13;
            String r6 = r5.getLanguageCode();
            if (r6 == null) goto L13;
            BotSettingViewModel r0 = this.this$0;
            int r1 = this.$cvsType;
            String r7 = BotSettingViewModel.access$findAsrLanguageByLanguageCode(r0, r6);
            if (r1 != 1) goto L11;
            AudioServiceDelegate.a.g0(r7);
        L11:
            BotSettingViewModel.access$getSettingRepo$p(r0).C0(r7);
        L13:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$updateBotAccessPermission$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel", f = "BotSettingViewModel.kt", i = {}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_HEARTBEAT}, m = "updateBotAccessPermission", n = {}, s = {})
    public static final class C01434 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01434(BotSettingViewModel r1, Continuation<? super C01434> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateBotAccessPermission(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.BotSettingViewModel$updateMsgPushToggle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.BotSettingViewModel$updateMsgPushToggle$1", f = "BotSettingViewModel.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ boolean $messagePush;
        int label;
        final /* synthetic */ BotSettingViewModel this$0;

        public C01441(BotSettingViewModel r1, String r2, boolean r3, Continuation<? super C01441> r4) {
            this.this$0 = r1;
            this.$botId = r2;
            this.$messagePush = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01441(this.this$0, this.$botId, this.$messagePush, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r76) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r76);
            Object r3 = r76;
        L11:
            uc9.t r4 = (uc9.t) r3;
            if (r4 == null) goto L23;
            String r5 = this.$botId;
            boolean r6 = this.$messagePush;
            BotSettingViewModel r15 = this.this$0;
            if (r4.a == false) goto L20;
            IChatRepoService r7 = zh8.a.a;
            IBotRepoService r14 = zh8.a.e;
            BotModel r8 = r4.b;
            if (r8 != null) goto L19;
            r8 = new BotModel(r5, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, Boxing.boxBoolean(r6), null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2097154, Integer.MAX_VALUE, null);
        L19:
            r14.e1(r8);
        L21:
            r15.getMessagePushLiveData().postValue(Boxing.boxBoolean(r4.a));
            goto L23
        L20:
            r15 = r15;
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r76);
            IBotRepoService r9 = BotSettingViewModel.access$getBotRepo$p(this.this$0);
            String r10 = this.$botId;
            boolean r11 = this.$messagePush;
            this.label = 1;
            r3 = r9.m1(r10, r11, this);
            if (r3 != r1) goto L11;
            return r1;
        }
    }

    public static /* synthetic */ MutableLiveData Mo() {
        return messagePushLiveData_delegate$lambda$13();
    }

    public static /* synthetic */ MutableResult No() {
        return resetBotInfo_delegate$lambda$7();
    }

    public static /* synthetic */ MutableResult Oo() {
        return deleteBot_delegate$lambda$0();
    }

    public static /* synthetic */ MutableLiveData Po() {
        return updateBotEditItemFromDBResult_delegate$lambda$5();
    }

    public static /* synthetic */ MutableResult Qo() {
        return chatHistoryClearSuccess_delegate$lambda$3();
    }

    public static /* synthetic */ com.larus.im.service.r So() {
        return conversationService_delegate$lambda$8();
    }

    public static /* synthetic */ MutableLiveData To() {
        return updateBotAccessPermission_delegate$lambda$4();
    }

    public static /* synthetic */ MutableResult Wo() {
        return removeConversation_delegate$lambda$1();
    }

    public static /* synthetic */ MutableResult Yo() {
        return updateCvsName_delegate$lambda$2();
    }

    public static /* synthetic */ boolean Zo() {
        return shareBtnCenter_delegate$lambda$9();
    }

    public static /* synthetic */ MutableResult yo() {
        return subjectBotInfo_delegate$lambda$6();
    }

    private static final MutableResult chatHistoryClearSuccess_delegate$lambda$3() {
        return new MutableResult();
    }

    private static final MutableResult deleteBot_delegate$lambda$0() {
        return new MutableResult();
    }

    private final com.larus.im.service.r getConversationService() {
        return (com.larus.im.service.r) this.conversationService$delegate.getValue();
    }

    private static final MutableLiveData messagePushLiveData_delegate$lambda$13() {
        return new MutableLiveData();
    }

    private static final MutableResult removeConversation_delegate$lambda$1() {
        return new MutableResult();
    }

    private static final MutableResult resetBotInfo_delegate$lambda$7() {
        return new MutableResult();
    }

    private static final boolean shareBtnCenter_delegate$lambda$9() {
        if (com.larus.platform.service.z2.a.botSettingShareBtnConfig().a == true) goto L7;
        return false;
    L7:
        return true;
    }

    private static final MutableResult subjectBotInfo_delegate$lambda$6() {
        return new MutableResult();
    }

    private static final MutableLiveData updateBotAccessPermission_delegate$lambda$4() {
        return new MutableLiveData();
    }

    private static final MutableLiveData updateBotEditItemFromDBResult_delegate$lambda$5() {
        return new MutableLiveData();
    }

    private static final MutableResult updateCvsName_delegate$lambda$2() {
        return new MutableResult();
    }

    public final MutableResult<ub8.b> getChatHistoryClearSuccess() {
        return (MutableResult) this.chatHistoryClearSuccess$delegate.getValue();
    }

    public final MutableResult<ub8.a> getDeleteBot() {
        return (MutableResult) this.deleteBot$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getMessagePushLiveData() {
        return (MutableLiveData) this.messagePushLiveData$delegate.getValue();
    }

    public final MutableResult<ub8.a> getRemoveConversation() {
        return (MutableResult) this.removeConversation$delegate.getValue();
    }

    public final MutableResult<com.larus.network.http.a<ub8.c>> getResetBotInfo() {
        return (MutableResult) this.resetBotInfo$delegate.getValue();
    }

    public final boolean getShareBtnCenter() {
        return ((Boolean) this.shareBtnCenter$delegate.getValue()).booleanValue();
    }

    public final MutableResult<com.larus.network.http.a<ub8.c>> getSubjectBotInfo() {
        return (MutableResult) this.subjectBotInfo$delegate.getValue();
    }

    public final MutableLiveData<uc9.t> getUpdateBotAccessPermission() {
        return (MutableLiveData) this.updateBotAccessPermission$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getUpdateBotEditItemFromDBResult() {
        return (MutableLiveData) this.updateBotEditItemFromDBResult$delegate.getValue();
    }

    public final MutableResult<ub8.e> getUpdateCvsName() {
        return (MutableResult) this.updateCvsName$delegate.getValue();
    }

    private static final com.larus.im.service.r conversationService_delegate$lambda$8() {
        return com.larus.im.d.d();
    }

    public final void updateBotEditSubTitle() {
        getUpdateBotEditItemFromDBResult().postValue(Boolean.TRUE);
    }

    public BotSettingViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.deleteBot$delegate = LazyKt.lazy(new c());
        this.removeConversation$delegate = LazyKt.lazy(new f());
        this.updateCvsName$delegate = LazyKt.lazy(new g());
        this.chatHistoryClearSuccess$delegate = LazyKt.lazy(new h());
        this.updateBotAccessPermission$delegate = LazyKt.lazy(new i());
        this.updateBotEditItemFromDBResult$delegate = LazyKt.lazy(new j());
        this.subjectBotInfo$delegate = LazyKt.lazy(new k());
        this.resetBotInfo$delegate = LazyKt.lazy(new l());
        this.conversationService$delegate = LazyKt.lazy(new m());
        IChatRepoService r3 = zh8.a.a;
        this.botRepo = zh8.a.e;
        this.conversationRepo = zh8.a.b;
        this.settingRepo = zh8.a.c;
        this.shareBtnCenter$delegate = LazyKt.lazy(new d());
        this.messagePushLiveData$delegate = LazyKt.lazy(new e());
    }

    public static final /* synthetic */ IBotRepoService access$getBotRepo$p(BotSettingViewModel r0) {
        return r0.botRepo;
    }

    public static final /* synthetic */ IConversationRepoService access$getConversationRepo$p(BotSettingViewModel r0) {
        return r0.conversationRepo;
    }

    public static final /* synthetic */ ISettingRepoService access$getSettingRepo$p(BotSettingViewModel r0) {
        return r0.settingRepo;
    }

    private final String findAsrLanguageByLanguageCode(String r5) {
        Object r1 = null;
        if (AppHost.a.isOversea() == true) goto L5;
    L15:
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L37;
        LaunchInfo r2 = r0.a;
        if (r2 == null) goto L38;
        List r3 = r2.g1();
        if (r3 == null) goto L39;
        Iterator r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L27;
        Object r6 = r4.next();
        if (Intrinsics.areEqual(((SpeechLanguage) r6).c(), r5) == false) goto L23;
        r1 = r6;
    L27:
        SpeechLanguage r7 = (SpeechLanguage) r1;
        if (r7 == null) goto L40;
        String r8 = r7.a();
        if (r8 != null) goto L33;
        return r5;
    L33:
        return r8;
    L40:
        return r5;
    L39:
        return r5;
    L38:
        return r5;
    L37:
        return r5;
    L5:
        if (Intrinsics.areEqual(r5, "multi") == false) goto L15;
        String r9 = com.larus.utils.b0.a;
        AppLocaleUtils.a.getClass();
        String r10 = com.larus.utils.b0.c(AppLocaleUtils.c());
        if (r10.length() <= 0) goto L9;
        boolean r11 = true;
    L10:
        if (r11 == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L15;
        return r10;
    L9:
        r11 = false;
        goto L10
    }

    public final void clearHistory(String r8) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(r8, this, null), 3, null);
    }

    public final void removeConversation(String r8) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01384(r8, this, null), 3, null);
    }

    public final Job requireSubjectBot(String r8) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01391(this, r8, null), 2, null);
    }

    public final Job requireUpdateConversationInfo(String r8) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01401(this, r8, null), 3, null);
    }

    public final Job reverseBotSubject(String r8) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01411(this, r8, null), 2, null);
    }

    public final void updateExpertToggle(boolean r3) {
        IAIChatService.a.t7(r3, null);
    }

    public static final /* synthetic */ String access$findAsrLanguageByLanguageCode(BotSettingViewModel r0, String r1) {
        return r0.findAsrLanguageByLanguageCode(r1);
    }

    public final void deleteBot(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass4(r8, r9, this, null), 3, null);
    }

    public final Object requireSyncConversationInfo(String r4, Continuation<? super com.larus.network.http.a<wc9.e>> r5) {
        return IConversationRepoService$a.e(this.conversationRepo, r4, null, r5, 6);
    }

    public final Job updateAsrLanguage(BotModel r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "botInfo");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01421(r8, this, r9, null), 3, null);
    }

    public final void updateConversationName(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "name");
        getConversationService().updateConversationTitle(r3, r4, new a(this, r3, r4));
    }

    public final Job updateMsgPushToggle(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01441(this, r8, r9, null), 2, null);
    }

    public final Object updateBotAccessPermission(String r5, int r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C01434) == false) goto L7;
        C01434 r0 = (C01434) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        MutableLiveData<uc9.t> r9 = getUpdateBotAccessPermission();
        r9.postValue((uc9.t) r8);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        IBotRepoService r10 = this.botRepo;
        r0.label = 1;
        r8 = r10.o1(r5, r6, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new C01434(this, r7);
        goto L8
    }
}
