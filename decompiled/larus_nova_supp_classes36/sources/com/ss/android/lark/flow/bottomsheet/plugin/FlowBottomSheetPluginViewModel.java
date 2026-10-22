package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.feed.app.entity.UpdateUnreadStatusScene;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/flow/bottomsheet/plugin/FlowBottomSheetPluginViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "chatId", "", "<init>", "(Ljava/lang/String;)V", "getChatId", "()Ljava/lang/String;", "startTimeSec", "", "create", "", "destroy", "updateFeedCardUnreadStatus", "targetUnreadStatus", "", "recordStartTime", "sendTimeDuration", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowBottomSheetPluginViewModel extends ViewModel implements CoroutineScope {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String TAG = "ChatBottomSheetPluginViewModel";
    private final String chatId;
    private final CoroutineContext coroutineContext;
    private long startTimeSec;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.bottomsheet.plugin.FlowBottomSheetPluginViewModel$updateFeedCardUnreadStatus$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.bottomsheet.plugin.FlowBottomSheetPluginViewModel$updateFeedCardUnreadStatus$1", f = "FlowBottomSheetPluginViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $targetUnreadStatus;
        int label;
        final /* synthetic */ FlowBottomSheetPluginViewModel this$0;

        public AnonymousClass1(FlowBottomSheetPluginViewModel r1, boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$targetUnreadStatus = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$targetUnreadStatus, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r5);
            ChatCoreModule.a().getFeedDependency().b(this.this$0.getChatId(), FeedCard.EntityType.THREAD, this.$targetUnreadStatus, UpdateUnreadStatusScene.HALF_SCREEN);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final void create() {
        updateFeedCardUnreadStatus(false);
    }

    public final void destroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    public final void recordStartTime() {
        this.startTimeSec = System.currentTimeMillis() / ((long) AudioViewModel.ASR_SESSION_IDLE);
    }

    public final void sendTimeDuration() {
        ChatCoreModule.a().getFeedDependency().f(Long.valueOf(this.startTimeSec), Long.valueOf(System.currentTimeMillis() / ((long) AudioViewModel.ASR_SESSION_IDLE)));
        this.startTimeSec = 0;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public FlowBottomSheetPluginViewModel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        this.chatId = r3;
        this.coroutineContext = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
    }

    public final void updateFeedCardUnreadStatus(boolean r7) {
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, r7, null), 3, null);
    }
}
