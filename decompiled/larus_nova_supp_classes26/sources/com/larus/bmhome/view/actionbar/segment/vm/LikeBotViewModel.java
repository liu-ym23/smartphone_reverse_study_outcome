package com.larus.bmhome.view.actionbar.segment.vm;

import android.app.Application;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.larus.network.http.y;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONException;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002J4\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\bJ&\u0010\u001f\u001a\u00020\u00122\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120!j\u0002`\"H\u0086@¢\u0006\u0002\u0010#J.\u0010$\u001a\u00020\u00122\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120!j\u0002`\"2\u0006\u0010%\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0012\u0010(\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotState;", "<init>", "()V", "mBotModel", "Lcom/larus/im/bean/bot/BotModel;", "mobConversation", "Lcom/larus/im/bean/conversation/Conversation;", "mobIsImmerse", "", "mobRecommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "mobPreviousPage", "", "userOperated", "disableMultiBotLikeActionbar", "syncWithOtherState", "", "state", "updateWithBotModel", "botModel", "isImmerse", "recommendFrom", "previousPage", "conversation", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "pipelineLaunched", "clickLikeOrCancelByChannel", "reverseCallback", "Lkotlin/Function1;", "Lcom/larus/bmhome/view/actionbar/segment/vm/LikeStateCallback;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickLikeOrCancelButton", "previousState", "(Lkotlin/jvm/functions/Function1;Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inferenceLikeStateByClient", "shouldDisableMultiBotLikeCommentActionbar", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LikeBotViewModel extends ComponentViewModel<LikeBotState> {
    public static final a Companion = null;
    private static final MutableSharedFlow<LikeBotState> flowForUpdateLike = null;
    private static int remainBotSaveCount;
    private static int remainPullCount;
    private static int remainRequestCount;
    private final Channel<LikeBotState> channel;
    private boolean disableMultiBotLikeActionbar;
    private BotModel mBotModel;
    private wc9.e mobConversation;
    private boolean mobIsImmerse;
    private String mobPreviousPage;
    private RecommendFrom mobRecommendFrom;
    private boolean pipelineLaunched;
    private boolean userOperated;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelButton$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel", f = "LikeBotViewModel.kt", i = {0, 0, 1, 1, 2}, l = {197, 204, 214}, m = "clickLikeOrCancelButton", n = {"reverseCallback", "previousState", "reverseCallback", "previousState", "bizResponse"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LikeBotViewModel this$0;

        public AnonymousClass1(LikeBotViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return LikeBotViewModel.access$clickLikeOrCancelButton(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelButton$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelButton$3", f = "LikeBotViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LikeBotState $previousState;
        final /* synthetic */ Function1<LikeBotState, Unit> $reverseCallback;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super LikeBotState, Unit> r1, LikeBotState r2, Continuation<? super AnonymousClass3> r3) {
            this.$reverseCallback = r1;
            this.$previousState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$reverseCallback, this.$previousState, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$reverseCallback.invoke(this.$previousState);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelByChannel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel", f = "LikeBotViewModel.kt", i = {0, 0}, l = {164, 175}, m = "clickLikeOrCancelByChannel", n = {"reverseCallback", "previousState"}, s = {"L$0", "L$1"})
    public static final class C01881 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LikeBotViewModel this$0;

        public C01881(LikeBotViewModel r1, Continuation<? super C01881> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.clickLikeOrCancelByChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelByChannel$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.segment.vm.LikeBotViewModel$clickLikeOrCancelByChannel$3", f = "LikeBotViewModel.kt", i = {}, l = {168, 169}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01893 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<LikeBotState, Unit> $reverseCallback;
        Object L$0;
        int label;
        final /* synthetic */ LikeBotViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C01893(LikeBotViewModel r1, Function1<? super LikeBotState, Unit> r2, Continuation<? super C01893> r3) {
            this.this$0 = r1;
            this.$reverseCallback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01893(this.this$0, this.$reverseCallback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:21:0x0065). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ChannelIterator r2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r9);
            ChannelIterator r10 = r2;
            C01893 r3 = this;
        L21:
            LikeBotViewModel.access$setRemainRequestCount$cp(LikeBotViewModel.access$getRemainRequestCount$cp() - 1);
        L11:
            r3.L$0 = r10;
            r3.label = 1;
            Object r4 = r10.hasNext(r3);
            if (r4 != r0) goto L14;
            return r0;
        L14:
            C01893 r7 = r3;
            ChannelIterator r5 = r10;
            r9 = r4;
            C01893 r6 = r7;
        L16:
            if (((Boolean) r9).booleanValue() == false) goto L23;
            LikeBotState r11 = (LikeBotState) r5.next();
            LikeBotViewModel r8 = r6.this$0;
            Function1<LikeBotState, Unit> r12 = r6.$reverseCallback;
            r6.L$0 = r5;
            r6.label = 2;
            if (LikeBotViewModel.access$clickLikeOrCancelButton(r8, r12, r11, r6) != r0) goto L20;
            return r0;
        L20:
            r10 = r5;
            r3 = r6;
            goto L21
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r5 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r9);
            r6 = this;
            goto L16
        L10:
            ResultKt.throwOnFailure(r9);
            r10 = this.this$0.getChannel().iterator();
            r3 = this;
            goto L11
        }
    }

    public static /* synthetic */ LikeBotState No(LikeBotState r0, LikeBotState r1) {
        return updateWithBotModel$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ LikeBotState Oo(LikeBotState r0, LikeBotState r1) {
        return updateWithBotModel$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit Po(LikeBotState r0) {
        return channel$lambda$4(r0);
    }

    public static /* synthetic */ LikeBotState Qo(LikeBotState r0, LikeBotState r1) {
        return clickLikeOrCancelByChannel$lambda$5(r0, r1);
    }

    public static /* synthetic */ LikeBotState So(LikeBotState r0, LikeBotState r1) {
        return clickLikeOrCancelButton$lambda$6(r0, r1);
    }

    public static /* synthetic */ LikeBotState To(LikeBotState r0, LikeBotState r1) {
        return syncWithOtherState$lambda$0(r0, r1);
    }

    private static final LikeBotState clickLikeOrCancelByChannel$lambda$5(LikeBotState r1, LikeBotState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    private static final LikeBotState syncWithOtherState$lambda$0(LikeBotState r1, LikeBotState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    private static final LikeBotState updateWithBotModel$lambda$2$lambda$1(LikeBotState r1, LikeBotState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    private static final LikeBotState updateWithBotModel$lambda$3(LikeBotState r1, LikeBotState r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setState");
        return r1;
    }

    static {
        Companion = new a();
        remainPullCount = -1;
        remainBotSaveCount = -1;
        flowForUpdateLike = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public LikeBotViewModel() {
        this.channel = ChannelKt.Channel(2, BufferOverflow.DROP_OLDEST, new n());
    }

    public static final /* synthetic */ MutableSharedFlow access$getFlowForUpdateLike$cp() {
        return flowForUpdateLike;
    }

    public static final /* synthetic */ int access$getRemainBotSaveCount$cp() {
        return remainBotSaveCount;
    }

    public static final /* synthetic */ int access$getRemainPullCount$cp() {
        return remainPullCount;
    }

    public static final /* synthetic */ int access$getRemainRequestCount$cp() {
        return remainRequestCount;
    }

    public final Channel<LikeBotState> getChannel() {
        return this.channel;
    }

    public static final /* synthetic */ BotModel access$getMBotModel$p(LikeBotViewModel r0) {
        return r0.mBotModel;
    }

    public static final /* synthetic */ void access$setRemainBotSaveCount$cp(int r0) {
        remainBotSaveCount = r0;
    }

    public static final /* synthetic */ void access$setRemainPullCount$cp(int r0) {
        remainPullCount = r0;
    }

    public static final /* synthetic */ void access$setRemainRequestCount$cp(int r0) {
        remainRequestCount = r0;
    }

    private static final Unit channel$lambda$4(LikeBotState r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        FLogger.a.i("ComponentViewModel", "drop one on checked job");
        return Unit.INSTANCE;
    }

    private final LikeBotState inferenceLikeStateByClient(BotModel r11) {
        if (this.disableMultiBotLikeActionbar == true) goto L5;
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L11;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L11;
        FeatureConfig r2 = r1.y0();
    L13:
        if (r2 == null) goto L19;
        FeatureDetail r3 = r2.v0();
        if (r3 == null) goto L19;
        if (r3.b() != true) goto L19;
        boolean r4 = true;
    L21:
        return new LikeBotState(r4, false, 0, r11.getBotId(), Boolean.FALSE);
    L19:
        r4 = false;
    L11:
        r2 = null;
        goto L13
    L5:
        return new LikeBotState(false, false, 0, r11.getBotId(), null, 22, null);
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

    public final void syncWithOtherState(final LikeBotState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        setState(new i(r2));
    }

    private static final LikeBotState clickLikeOrCancelButton$lambda$6(LikeBotState r10, LikeBotState r11) {
        Intrinsics.checkNotNullParameter(r11, "$this$setState");
        return LikeBotState.copy$default(r10, false, false, 0, null, null, 31, null);
    }

    public final Object clickLikeOrCancelByChannel(Function1<? super LikeBotState, Unit> r17, Continuation<? super Unit> r18) {
        if ((r18 instanceof C01881) == false) goto L7;
        C01881 r2 = (C01881) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L35:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        LikeBotState r6 = (LikeBotState) r2.L$1;
        Function1<? super LikeBotState, Unit> r7 = (Function1) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L29:
        if (this.pipelineLaunched == true) goto L31;
        this.pipelineLaunched = true;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C01893(this, r7, null), 3, null);
    L31:
        remainRequestCount++;
        Channel<LikeBotState> r8 = this.channel;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 2;
        if (r8.send(r6, r2) != r4) goto L35;
        return r4;
    L16:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelByChannel");
        if (this.disableMultiBotLikeActionbar == true) goto L19;
        this.userOperated = true;
        r6 = (LikeBotState) getState();
        if (r6.getLiked() == true) goto L23;
        final LikeBotState r9 = LikeBotState.copy$default(r6, false, true, r6.getLikeCount() + 1, null, null, 25, null);
    L24:
        setState(new m(r9));
        MutableSharedFlow<LikeBotState> r10 = flowForUpdateLike;
        r2.L$0 = r17;
        r2.L$1 = r6;
        r2.label = 1;
        if (r10.emit(r9, r2) != r4) goto L27;
        return r4;
    L27:
        r7 = r17;
        goto L29
    L23:
        r9 = LikeBotState.copy$default(r6, false, false, r6.getLikeCount() - 1, null, null, 25, null);
        goto L24
    L19:
        return Unit.INSTANCE;
    L7:
        r2 = new C01881(this, r18);
        goto L8
    }

    private final Object clickLikeOrCancelButton(Function1<? super LikeBotState, Unit> r87, LikeBotState r88, Continuation<? super Unit> r89) {
        Function1<? super LikeBotState, Unit> r1 = r87;
        final LikeBotState r2 = r88;
        if ((r89 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r89;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L18;
        if (r6 == 1) goto L17;
        if (r6 == 2) goto L16;
        if (r6 != 3) goto L15;
        y r7 = (y) r3.L$0;
        ResultKt.throwOnFailure(r0);
    L99:
        s r8 = s.a;
        AppHost.Companion r9 = AppHost.a;
        Application r10 = r9.getApplication();
        String r11 = r7.f;
        if (r11 != null) goto L102;
        r11 = r9.getApplication().getString(2131907052);
    L102:
        r8.getClass();
        s.t(r10, r11);
    L113:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        LikeBotState r12 = (LikeBotState) r3.L$1;
        Function1<? super LikeBotState, Unit> r13 = (Function1) r3.L$0;
        ResultKt.throwOnFailure(r0);
        Object r14 = r5;
        r2 = r12;
        r1 = r13;
    L82:
        com.larus.network.http.a r15 = (com.larus.network.http.a) r0;
        long r16 = r2.getLikeCount() - 1;
        int r17 = 2;
    L84:
        if ((r15 instanceof y) == false) goto L86;
        y r18 = (y) r15;
    L87:
        if (r18 == null) goto L89;
        Long r19 = r18.g;
        if (r19 != null) goto L94;
    L95:
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton result failed " + r18.f);
        setState(new l(r2));
        MainCoroutineDispatcher r20 = Dispatchers.getMain();
        AnonymousClass3 r21 = new AnonymousClass3(r1, r2, null);
        r3.L$0 = r18;
        r3.L$1 = null;
        r3.label = 3;
        if (BuildersKt.withContext(r20, r21, r3) != r14) goto L98;
        return r14;
    L98:
        r7 = r18;
        goto L99
    L94:
        if (r19.longValue() != 0) goto L95;
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton result success " + remainRequestCount);
        BotModel r22 = this.mBotModel;
        if (r22 == null) goto L113;
        LikeInfo r110 = r22.getLikeInfo();
        if (r110 == null) goto L108;
        LikeInfo r77 = LikeInfo.copy$default(r110, null, null, Boxing.boxInt(r17), Boxing.boxLong(r16), 3, null);
    L109:
        BotModel r23 = BotModel.copy$default(r22, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r77, null, null, null, null, -1, 2080374783, null);
        if (r23 == null) goto L113;
        remainPullCount++;
        remainBotSaveCount++;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new LikeBotViewModel$clickLikeOrCancelButton$4$1(this, r23, r17, r16, null), 3, null);
        goto L113
    L108:
        r77 = null;
        goto L109
    L89:
        return Unit.INSTANCE;
    L86:
        r18 = null;
        goto L87
    L17:
        LikeBotState r24 = (LikeBotState) r3.L$1;
        Function1<? super LikeBotState, Unit> r25 = (Function1) r3.L$0;
        ResultKt.throwOnFailure(r0);
        r14 = r5;
        r2 = r24;
        r1 = r25;
    L74:
        r15 = (com.larus.network.http.a) r0;
        r16 = r2.getLikeCount() + 1;
        r17 = 1;
        goto L84
    L18:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton");
        BotModel r26 = this.mBotModel;
        if (r26 == null) goto L21;
        String r27 = r26.getBotId();
    L23:
        if (this.mobIsImmerse == false) goto L25;
        String r28 = "1";
    L26:
        RecommendFrom r111 = this.mobRecommendFrom;
        if (r111 == null) goto L29;
        String r112 = r111.a;
    L31:
        if (r88.getLiked() == false) goto L33;
        String r113 = "unlike";
    L34:
        String r29 = r113;
        RecommendFrom r114 = this.mobRecommendFrom;
        if (r114 == null) goto L37;
        String r115 = r114.b;
    L38:
        String r30 = this.mobPreviousPage;
        wc9.e r31 = this.mobConversation;
        if (r31 == null) goto L41;
        String r32 = ic8.n.f(r31);
    L42:
        wc9.e r116 = this.mobConversation;
        if (r116 == null) goto L45;
        String r117 = r116.a;
    L46:
        JSONObject r33 = new JSONObject();
        Intrinsics.checkNotNullParameter(r33, "params");
        if (r27 != null) goto L114;
    L51:
        if (r112 == null) goto L53;
        r33.put("recommend_from", r112);     // Catch: JSONException -> L49
    L53:
        r33.put("is_immersive_background", r28);     // Catch: JSONException -> L49
        r33.put("click_from", "chat_action_bar");     // Catch: JSONException -> L49
        r33.put("to_status", r29);     // Catch: JSONException -> L49
        if (r115 == null) goto L56;
        r33.put("req_id", r115);     // Catch: JSONException -> L49
    L56:
        r33.put("current_page", "chat");     // Catch: JSONException -> L49
        if (r30 == null) goto L59;
        r33.put("previous_page", r30);     // Catch: JSONException -> L49
    L59:
        if (r32 == null) goto L61;
        r33.put("chat_type", r32);     // Catch: JSONException -> L49
    L61:
        if (r117 == null) goto L65;
        r33.put(MusicAppletPage.KEY_CONVERSATION_ID, r117);     // Catch: JSONException -> L49
    L49:
        e = move-exception;
        FLogger.a.e("ActionBarEventHelper", "error in ActionBarEventHelper chatActionBarSlide " + e.getLocalizedMessage());
    L65:
        TrackParams r34 = new TrackParams().merge(r33);
        by7.a r35 = new by7.a("click_like_bot");
        r35.a.merge(r34);
        r35.b();
        String r36 = "";
        if (r88.getLiked() == true) goto L75;
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton request Like " + remainRequestCount);
        BotApi r37 = (BotApi) BotApi.a.getValue();
        String r38 = r88.getBotId();
        if (r38 == null) goto L71;
        r36 = r38;
    L71:
        r3.L$0 = r1;
        r3.L$1 = r2;
        r3.label = 1;
        r37.getClass();
        r0 = BotApi.l(r36, r3);
        r14 = r5;
        if (r0 != r14) goto L74;
        return r14;
    L75:
        r14 = r5;
        FLogger.a.i("ComponentViewModel", "clickLikeOrCancelButton request cancel Like " + remainRequestCount);
        BotApi r39 = (BotApi) BotApi.a.getValue();
        String r40 = r88.getBotId();
        if (r40 == null) goto L79;
        r36 = r40;
    L79:
        r3.L$0 = r1;
        r3.L$1 = r2;
        r3.label = 2;
        r39.getClass();
        r0 = BotApi.k(r36, r3);
        if (r0 != r14) goto L82;
        return r14;
    L114:
        r33.put("bot_id", r27);     // Catch: JSONException -> L49
        goto L51
    L45:
        r117 = null;
        goto L46
    L41:
        r32 = null;
        goto L42
    L37:
        r115 = null;
        goto L38
    L33:
        r113 = "like";
        goto L34
    L29:
        r112 = null;
        goto L31
    L25:
        r28 = TriggerSendLoading.NO_LOADING;
        goto L26
    L21:
        r27 = null;
    L7:
        r3 = new AnonymousClass1(this, r89);
        goto L8
    }

    public static final /* synthetic */ Object access$clickLikeOrCancelButton(LikeBotViewModel r0, Function1 r1, LikeBotState r2, Continuation r3) {
        return r0.clickLikeOrCancelButton(r1, r2, r3);
    }

    public final LikeBotState updateWithBotModel(BotModel r18, boolean r19, RecommendFrom r20, String r21, wc9.e r22) {
        Intrinsics.checkNotNullParameter(r18, "botModel");
        final LikeBotState r4 = (LikeBotState) getState();
        if (this.userOperated == false) goto L6;
        FLogger.a.i("ComponentViewModel", "user operated do not change ");
        return r4;
    L6:
        this.mBotModel = r18;
        this.mobIsImmerse = r19;
        this.mobRecommendFrom = r20;
        this.mobPreviousPage = r21;
        this.mobConversation = r22;
        this.disableMultiBotLikeActionbar = shouldDisableMultiBotLikeCommentActionbar(r22);
        LikeInfo r3 = r18.getLikeInfo();
        if (r3 == null) goto L9;
        Integer r5 = r3.getShowLikeButton();
    L10:
        LikeInfo r7 = r18.getLikeInfo();
        if (r7 == null) goto L13;
        Integer r8 = r7.getLiked();
    L14:
        String r13 = r18.getBotId();
        if (this.disableMultiBotLikeActionbar == false) goto L18;
        final LikeBotState r1 = new LikeBotState(false, false, 0, r13, null, 22, null);
        setState(new j(r1));
        return r1;
    L18:
        boolean r9 = true;
        if (r5 != null) goto L22;
    L23:
        if (r5 == null) goto L28;
        if (r5.intValue() != 2) goto L28;
    L46:
        Boolean r2 = r4.getKnowLike();
        Boolean r10 = Boolean.TRUE;
        long r11 = 0;
        boolean r14 = false;
        if (Intrinsics.areEqual(r2, r10) == false) goto L84;
        if (r8 != null) goto L51;
    L52:
        if (r8 != null) goto L55;
    L57:
        boolean r6 = false;
    L59:
        LikeInfo r12 = r18.getLikeInfo();
        if (r12 == null) goto L62;
        Long r15 = r12.getLikeCount();
    L63:
        if (r15 == null) goto L65;
        boolean r16 = true;
    L66:
        FLogger.a.i("ComponentViewModel", "know like do not change count ");
        if (r6 == true) goto L69;
    L135:
        setState(new k(r4));
        return r4;
    L69:
        if (r8 != null) goto L72;
    L74:
        if (r16 == false) goto L79;
        LikeInfo r17 = r18.getLikeInfo();
        if (r17 == null) goto L78;
        Long r23 = r17.getLikeCount();
    L80:
        if (r23 == null) goto L82;
        long r24 = r23.longValue();
    L83:
        r4 = LikeBotState.copy$default(r4, false, r14, r24, null, r10, 9, null);
        goto L135
    L82:
        r24 = 0;
        goto L83
    L78:
        r23 = null;
        goto L80
    L79:
        r23 = Long.valueOf(r4.getLikeCount());
        goto L80
    L72:
        if (r8.intValue() != 1) goto L74;
        r14 = true;
        goto L74
    L65:
        r16 = false;
        goto L66
    L62:
        r15 = null;
        goto L63
    L55:
        if (r8.intValue() != 2) goto L57;
    L58:
        r6 = true;
        goto L59
    L51:
        if (r8.intValue() == 1) goto L58;
    L84:
        if (r5 != null) goto L87;
    L88:
        if (r5 != null) goto L91;
    L92:
        r4 = inferenceLikeStateByClient(r18);
        goto L135
    L91:
        if (r5.intValue() != 2) goto L92;
    L93:
        LikeInfo r25 = r18.getLikeInfo();
        if (r25 == null) goto L96;
        Long r26 = r25.getLikeCount();
    L97:
        if (r26 == null) goto L99;
        boolean r27 = true;
    L100:
        FLogger.a.i("ComponentViewModel", "do not know like do change state from model ");
        if (AppHost.a.isOversea() == false) goto L103;
    L102:
        boolean r28 = false;
    L108:
        if (r8 != null) goto L111;
    L113:
        boolean r29 = false;
    L114:
        if (r27 == false) goto L119;
        LikeInfo r30 = r18.getLikeInfo();
        if (r30 == null) goto L118;
        Long r31 = r30.getLikeCount();
    L120:
        if (r31 == null) goto L122;
        r11 = r31.longValue();
    L122:
        if (r8 != null) goto L125;
    L126:
        if (r8 == null) goto L131;
        if (r8.intValue() != 2) goto L131;
    L134:
        r4 = new LikeBotState(r28, r29, r11, r13, Boolean.valueOf(r9));
    L131:
        if (Intrinsics.areEqual(r4.getKnowLike(), r10) == true) goto L134;
        r9 = false;
        goto L134
    L125:
        if (r8.intValue() == 1) goto L134;
    L118:
        r31 = null;
        goto L120
    L119:
        r31 = Long.valueOf(r4.getLikeCount());
        goto L120
    L111:
        if (r8.intValue() != 1) goto L113;
        r29 = true;
        goto L114
    L103:
        if (r5 == null) goto L102;
        if (r5.intValue() != 1) goto L102;
        r28 = true;
        goto L108
    L99:
        r27 = false;
        goto L100
    L96:
        r26 = null;
        goto L97
    L87:
        if (r5.intValue() == 1) goto L93;
    L28:
        if (r18.getDisabled() == true) goto L44;
        if (r22 == null) goto L31;
        String r110 = ic8.n.f(r22);
    L33:
        if (Intrinsics.areEqual(r110, "others_created") == true) goto L46;
        if (r22 == null) goto L36;
        String r111 = ic8.n.f(r22);
    L38:
        if (Intrinsics.areEqual(r111, "self_created") == true) goto L46;
        if (r22 == null) goto L41;
        String r32 = ic8.n.f(r22);
    L43:
        if (Intrinsics.areEqual(r32, "other_default") == true) goto L46;
    L41:
        r32 = null;
        goto L43
    L36:
        r111 = null;
        goto L38
    L31:
        r110 = null;
    L44:
        FLogger.a.i("ComponentViewModel", "private bot do not change state ");
        return new LikeBotState(false, false, 0, null, null, 30, null);
    L22:
        if (r5.intValue() == 1) goto L46;
    L13:
        r8 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    }
}
