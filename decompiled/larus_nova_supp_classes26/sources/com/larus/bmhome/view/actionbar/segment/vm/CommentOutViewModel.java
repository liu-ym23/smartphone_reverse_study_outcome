package com.larus.bmhome.view.actionbar.segment.vm;

import android.text.TextUtils;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.view.actionbar.segment.BotCommentRemoteHttpApi;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.comment.ICommentService;
import com.larus.platform.model.comment.PublicParamsForComment;
import com.larus.platform.model.comment.api.CommentHttpApi;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J<\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010 \u001a\u0004\u0018\u00010\fJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fJ\u0018\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u0006J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u001eJ\u0006\u0010+\u001a\u00020\"J\b\u0010,\u001a\u0004\u0018\u00010\bJ\u0012\u0010-\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006/"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/vm/CommentOutViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/view/actionbar/segment/vm/CommentBotState;", "<init>", "()V", "userOperated", "", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "preloaded", "openCommentHandled", "shouldGoCommentId", "", "publicParams", "Lcom/larus/platform/model/comment/PublicParamsForComment;", "realtimeState", "disableMultiBotCommentActionbar", "immerseStyle", "getImmerseStyle", "()Z", "setImmerseStyle", "(Z)V", "updateWithBotModel", "isImmerse", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "previousPage", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "realTimeState", "checkShouldGoComment", "updateCommentDraft", "", "draft", "updateCommentCount", "count", "", "toDb", "inferenceLikeStateByClient", "checkPreloadCommentData", "argumentData", "clearPreloadData", "getSelfBotModel", "shouldDisableMultiBotLikeCommentActionbar", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentOutViewModel extends ComponentViewModel<CommentBotState> {
    public static final a Companion = null;
    private static final MutableSharedFlow<CommentBotState> flowForUpdateComment = null;
    private BotModel botModel;
    private boolean disableMultiBotCommentActionbar;
    private boolean immerseStyle;
    private boolean openCommentHandled;
    private boolean preloaded;
    private PublicParamsForComment publicParams;
    private CommentBotState realtimeState;
    private String shouldGoCommentId;
    private boolean userOperated;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.vm.CommentOutViewModel$checkPreloadCommentData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.CommentOutViewModel$checkPreloadCommentData$1", f = "CommentOutViewModel.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CommentOutViewModel this$0;

        public AnonymousClass1(CommentOutViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L22:
            final CommentHttpApi.GetCommentListData r2 = (CommentHttpApi.GetCommentListData) r8;
        L23:
            if (r2 != null) goto L26;
            FLogger.a.i("ComponentViewModel", "preloadCommentData failed");
            return Unit.INSTANCE;
        L26:
            final CommentOutViewModel r9 = this.this$0;
            CommentOutViewModel.access$setStateImmediate(r9, new h(r9, r2));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            BotModel r10 = CommentOutViewModel.access$getBotModel$p(this.this$0);
            r2 = null;
            if (r10 == null) goto L11;
            String r11 = r10.getBotId();
        L12:
            FLogger.a.i("ComponentViewModel", "preloadCommentData botId = " + r11);
            if (r11 == null) goto L29;
            if (TextUtils.isEmpty(r11) == true) goto L29;
            ICommentService.a.getClass();
            ICommentService r4 = (ICommentService) ICommentService.a.b.getValue();
            if (r4 == null) goto L23;
            BotCommentRemoteHttpApi r3 = BotCommentRemoteHttpApi.a;
            this.label = 1;
            r8 = r4.b(r3, r11, this);
            if (r8 != r0) goto L22;
            return r0;
        L29:
            return Unit.INSTANCE;
        L11:
            r11 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.vm.CommentOutViewModel$updateCommentCount$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.CommentOutViewModel$updateCommentCount$3", f = "CommentOutViewModel.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CommentOutViewModel this$0;

        public AnonymousClass3(CommentOutViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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
            CommentOutViewModel.Companion.getClass();
            MutableSharedFlow r5 = CommentOutViewModel.access$getFlowForUpdateComment$cp();
            CommentBotState r2 = CommentOutViewModel.access$getRealtimeState$p(this.this$0);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ CommentBotState No(CommentOutViewModel r0, CommentBotState r1) {
        return clearPreloadData$lambda$14(r0, r1);
    }

    public static /* synthetic */ CommentBotState Oo(CommentBotState r0) {
        return updateWithBotModel$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ CommentBotState Po(CommentBotState r0, String r1, CommentOutViewModel r2, CommentBotState r3) {
        return updateCommentDraft$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ CommentBotState Qo(CommentBotState r0) {
        return updateWithBotModel$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ CommentBotState So(CommentBotState r0) {
        return inferenceLikeStateByClient$lambda$10$lambda$9(r0);
    }

    public static /* synthetic */ CommentBotState To(CommentBotState r0) {
        return inferenceLikeStateByClient$lambda$12$lambda$11(r0);
    }

    public static /* synthetic */ CommentBotState Wo(CommentBotState r0, long r1, CommentOutViewModel r3, CommentBotState r4) {
        return updateCommentCount$lambda$7(r0, r1, r3, r4);
    }

    private static final CommentBotState inferenceLikeStateByClient$lambda$10$lambda$9(CommentBotState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setStateImmediate");
        return r1;
    }

    private static final CommentBotState inferenceLikeStateByClient$lambda$12$lambda$11(CommentBotState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setStateImmediate");
        return r1;
    }

    private static final CommentBotState updateWithBotModel$lambda$1$lambda$0(CommentBotState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setStateImmediate");
        return r1;
    }

    private static final CommentBotState updateWithBotModel$lambda$3$lambda$2(CommentBotState r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$setStateImmediate");
        return r1;
    }

    static {
        Companion = new a();
        flowForUpdateComment = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final String checkShouldGoComment() {
        if (this.disableMultiBotCommentActionbar == false) goto L7;
        this.shouldGoCommentId = null;
        return null;
    L7:
        if (TextUtils.isEmpty(this.shouldGoCommentId) == true) goto L10;
        String r0 = this.shouldGoCommentId;
        this.shouldGoCommentId = null;
        this.openCommentHandled = true;
        return r0;
    L10:
        return null;
    }

    public final void clearPreloadData() {
        setStateImmediate(new com.larus.bmhome.view.actionbar.segment.vm.a(this));
    }

    public CommentOutViewModel() {
        this.realtimeState = new CommentBotState(false, 0, null, null, null, 31, null);
    }

    public static final /* synthetic */ MutableSharedFlow access$getFlowForUpdateComment$cp() {
        return flowForUpdateComment;
    }

    public final boolean getImmerseStyle() {
        return this.immerseStyle;
    }

    public final BotModel getSelfBotModel() {
        return this.botModel;
    }

    public final PublicParamsForComment publicParams() {
        return this.publicParams;
    }

    public final CommentBotState realTimeState() {
        return this.realtimeState;
    }

    public static final /* synthetic */ BotModel access$getBotModel$p(CommentOutViewModel r0) {
        return r0.botModel;
    }

    public static final /* synthetic */ CommentBotState access$getRealtimeState$p(CommentOutViewModel r0) {
        return r0.realtimeState;
    }

    private final CommentBotState inferenceLikeStateByClient(BotModel r13) {
        if (this.disableMultiBotCommentActionbar == false) goto L6;
        CommentBotState r0 = new CommentBotState(false, 0, r13.getBotId(), null, null, 26, null);
        setStateImmediate(new b());
        this.realtimeState = r0;
        return r0;
    L6:
        e0 r1 = (e0) AuthModelDelegate.b.e().getValue();
        if (r1 == null) goto L11;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L11;
        FeatureConfig r3 = r2.y0();
    L13:
        if (r3 == null) goto L19;
        FeatureDetail r4 = r3.p0();
        if (r4 == null) goto L19;
        if (r4.b() != true) goto L19;
        boolean r5 = true;
    L20:
        CommentBotState r6 = new CommentBotState(r5, 0, r13.getBotId(), null, null, 24, null);
        setStateImmediate(new c());
        this.realtimeState = r6;
        return r6;
    L19:
        r5 = false;
    L11:
        r3 = null;
        goto L13
    }

    private final boolean shouldDisableMultiBotLikeCommentActionbar(wc9.e r4) {
        if (z2.a.x3().getDisableBotLikeCommentActionbar() == true) goto L5;
        return false;
    L5:
        if (r4 == null) goto L12;
        Integer r5 = r4.v;
        if (r5 == null) goto L12;
        if (r5.intValue() != 2) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L17;
        return true;
    L17:
        return false;
    L12:
        r6 = false;
        goto L13
    }

    public final void checkPreloadCommentData(de8.c r7) {
        Intrinsics.checkNotNullParameter(r7, "argumentData");
        if (this.preloaded == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r7.o()) == true) goto L8;
        return;
    L8:
        this.preloaded = true;
        if (Intrinsics.areEqual(z2.a.getCommentClientConfig().a(), Boolean.TRUE) == true) goto L11;
        return;
    L11:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void setImmerseStyle(boolean r1) {
        this.immerseStyle = r1;
    }

    public final void updateCommentDraft(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "draft");
        final CommentBotState r0 = this.realtimeState;
        setStateImmediate(new f(r0, r3, this));
        this.userOperated = true;
    }

    public static final /* synthetic */ void access$setRealtimeState$p(CommentOutViewModel r0, CommentBotState r1) {
        r0.realtimeState = r1;
    }

    public static final /* synthetic */ void access$setStateImmediate(CommentOutViewModel r0, Function1 r1) {
        r0.setStateImmediate(r1);
    }

    private static final CommentBotState clearPreloadData$lambda$14(CommentOutViewModel r10, CommentBotState r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$setStateImmediate");
        CommentBotState r12 = CommentBotState.copy$default(r10.realtimeState, false, 0, null, null, null, 15, null);
        r10.realtimeState = r12;
        return r12;
    }

    public final void updateCommentCount(final long r81, boolean r83) {
        final CommentBotState r1 = this.realtimeState;
        setStateImmediate(new g(r1, r81, this));
        this.userOperated = true;
        if (r83 == false) goto L13;
        BotModel r2 = this.botModel;
        if (r2 == null) goto L11;
        RepoDispatcher.a.getClass();
        BotRepo r14 = RepoDispatcher.g;
        BotCommentInfo r73 = r2.getCommentInfo();
        if (r73 == null) goto L9;
        BotCommentInfo r3 = BotCommentInfo.copy$default(r73, 1, Long.valueOf(r81), null, 4, null);
    L10:
        r14.e1(BotModel.copy$default(r2, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r3, null, -1, 1610612735, null));
        goto L11
    L9:
        r3 = null;
    L11:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass3(this, null), 3, null);
        return;
    }

    private static final CommentBotState updateCommentCount$lambda$7(CommentBotState r10, long r11, CommentOutViewModel r13, CommentBotState r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$setStateImmediate");
        CommentBotState r12 = CommentBotState.copy$default(r10, false, r11, null, null, null, 29, null);
        r13.realtimeState = r12;
        return r12;
    }

    private static final CommentBotState updateCommentDraft$lambda$5(CommentBotState r10, String r11, CommentOutViewModel r12, CommentBotState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setStateImmediate");
        CommentBotState r14 = CommentBotState.copy$default(r10, false, 0, null, r11, null, 23, null);
        r12.realtimeState = r14;
        return r14;
    }

    public static /* synthetic */ void updateCommentCount$default(CommentOutViewModel r0, long r1, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r0.updateCommentCount(r1, r3);
    }

    public final CommentBotState updateWithBotModel(BotModel r19, boolean r20, RecommendFrom r21, String r22, wc9.e r23, de8.c r24) {
        Intrinsics.checkNotNullParameter(r19, "botModel");
        Intrinsics.checkNotNullParameter(r24, "chatArgumentData");
        CommentBotState r4 = this.realtimeState;
        this.botModel = r19;
        if (this.userOperated == false) goto L6;
        FLogger.a.i("ComponentViewModel", "user operated do not change ");
        return r4;
    L6:
        String r5 = r24.o();
        if (TextUtils.isEmpty(r5) == false) goto L9;
    L11:
        this.immerseStyle = r20;
        String r9 = r19.getBotId();
        Integer r10 = Integer.valueOf(r20 ? 1 : 0);
        Integer r6 = null;
        if (r21 == null) goto L14;
        String r11 = r21.a;
    L16:
        if (r21 == null) goto L18;
        String r13 = r21.b;
    L20:
        if (r23 == null) goto L22;
        String r16 = ic8.n.f(r23);
    L23:
        if (r23 == null) goto L25;
        String r17 = r23.a;
    L26:
        this.publicParams = new PublicParamsForComment(r9, r10, r11, "chat_action_bar", r13, "chat", r22, r16, r17);
        boolean r2 = shouldDisableMultiBotLikeCommentActionbar(r23);
        this.disableMultiBotCommentActionbar = r2;
        if (r2 == false) goto L30;
        CommentBotState r1 = CommentBotState.copy$default(r4, false, 0, r19.getBotId(), null, null, 26, null);
        setStateImmediate(new d());
        this.realtimeState = r1;
        return r1;
    L30:
        BotCommentInfo r3 = r19.getCommentInfo();
        if (r3 == null) goto L38;
        Integer r7 = r3.getShowCommentButton();
        if (r7 == null) goto L38;
        if (1 != r7.intValue()) goto L38;
        boolean r8 = true;
    L39:
        BotCommentInfo r12 = r19.getCommentInfo();
        if (r12 == null) goto L42;
        r6 = r12.getShowCommentButton();
    L42:
        if (r6 != null) goto L45;
    L46:
        if (r6 == null) goto L51;
        if (r6.intValue() != 2) goto L51;
    L52:
        BotCommentInfo r14 = r19.getCommentInfo();
        if (r14 == null) goto L57;
        Long r15 = r14.getCommentCount();
        if (r15 == null) goto L57;
        long r18 = r15.longValue();
    L58:
        CommentBotState r25 = CommentBotState.copy$default(r4, r8, r18, r19.getBotId(), null, null, 24, null);
        setStateImmediate(new e());
        this.realtimeState = r25;
        return r25;
    L57:
        r18 = 0;
    L51:
        return inferenceLikeStateByClient(r19);
    L45:
        if (r6.intValue() == 1) goto L52;
    L38:
        r8 = false;
        goto L39
    L25:
        r17 = null;
        goto L26
    L22:
        r16 = null;
        goto L23
    L18:
        r13 = null;
        goto L20
    L14:
        r11 = null;
        goto L16
    L9:
        if (this.openCommentHandled == true) goto L11;
        this.openCommentHandled = true;
        this.shouldGoCommentId = r5;
        goto L11
    }
}
