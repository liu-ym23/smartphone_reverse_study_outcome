package com.obric.assistant.interaction.impl;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.audio.IRealtimeCallService;
import com.larus.bmhome.audio.RealtimeCallService;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.audio.service.ObricAssistantBaseServiceDelegate;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.audio.CallType;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4", f = "ObricRealtimeCallServiceImpl.kt", i = {1}, l = {529, 567, 587}, m = "invokeSuspend", n = {"existingRtcActivity"}, s = {"L$0"})
public final class ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CallType $callType;
    final /* synthetic */ long $delayJumpMS;
    final /* synthetic */ String $from;
    final /* synthetic */ BotModel $mainBot;
    final /* synthetic */ wc9.e $mainConversation;
    final /* synthetic */ Function0<Unit> $onPreJump;
    final /* synthetic */ String $startupAttemptId;
    Object L$0;
    int label;
    final /* synthetic */ ObricRealtimeCallExtServiceImpl this$0;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4$2", f = "ObricRealtimeCallServiceImpl.kt", i = {}, l = {709}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ FragmentActivity $existingRtcActivity;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ObricRealtimeCallExtServiceImpl this$0;

        public AnonymousClass2(ObricRealtimeCallExtServiceImpl r1, FragmentActivity r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$existingRtcActivity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$existingRtcActivity, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            FragmentActivity r2 = (FragmentActivity) this.L$1;
            ObricRealtimeCallExtServiceImpl r3 = (ObricRealtimeCallExtServiceImpl) this.L$0;
            ResultKt.throwOnFailure(r6);
        L13:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ObricRealtimeCallExtServiceImpl r7 = this.this$0;
            FragmentActivity r4 = this.$existingRtcActivity;
            this.L$0 = r7;
            this.L$1 = r4;
            this.label = 1;
            final kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r5.C();
            ObricRealtimeCallExtServiceImpl.access$getActionToExecuteOnDestroy$p(r7).put(r4, new ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4$2$1$1(r5));
            r6 = r5.B();
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    public ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4(long r1, ObricRealtimeCallExtServiceImpl r3, wc9.e r4, String r5, Function0<Unit> r6, CallType r7, String r8, BotModel r9, Continuation<? super ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4> r10) {
        this.$delayJumpMS = r1;
        this.this$0 = r3;
        this.$mainConversation = r4;
        this.$startupAttemptId = r5;
        this.$onPreJump = r6;
        this.$callType = r7;
        this.$from = r8;
        this.$mainBot = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new ObricRealtimeCallExtServiceImpl$launchRealtimeCall$4(this.$delayJumpMS, this.this$0, this.$mainConversation, this.$startupAttemptId, this.$onPreJump, this.$callType, this.$from, this.$mainBot, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r9 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r26);
    L57:
        String r3 = this.$startupAttemptId;
        if (r3 != null) goto L60;
    L62:
        r3 = null;
    L63:
        RealtimeCallService r10 = RealtimeCallService.b;
        AppHost.Companion r4 = AppHost.a;
        Application r21 = r4.getApplication();
        String r12 = this.$mainConversation.a;
        RecommendFrom r5 = new RecommendFrom(this.$from, null, null, 6);
        final Function0<Unit> r6 = this.$onPreJump;
        z2a.e r7 = new AnonymousClass4(r6);
        Bundle r8 = new Bundle();
        CallType r11 = this.$callType;
        if (r11 != CallType.Video) goto L66;
        String r13 = "1";
    L67:
        r8.putString("open_vlm", r13);
        if (r3 == null) goto L70;
        r8.putString("obric_startup_attempt_id", r3);
    L70:
        r8.putBoolean("obric_back_to_background", r4.a().isAppBackground());
        String r14 = ObricRealtimeCallServiceDelegate.b.q();
        if (r11 != CallType.ScreenShare) goto L73;
        r9 = "screen_share";
    L73:
        r8.putString(r14, r9);
        IRealtimeCallService.a.a(r10, null, r12, null, null, this.$mainBot, r5, this.$from, r7, null, null, r21, Boxing.boxInt(603979776), r8, 3584);
        return Unit.INSTANCE;
    L66:
        r13 = null;
        goto L67
    L60:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("rtc_call_content_ready"), r3) == false) goto L62;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        FragmentActivity r15 = (FragmentActivity) this.L$0;
        ResultKt.throwOnFailure(r26);
        Object r16 = r26;
    L51:
        if (((Boolean) r16) != null) goto L53;
        FLogger.a.w("ObricRealtimeCallExtServiceImpl", "wait for existing rtc activity: " + r15 + " destroy timeout");
    L54:
        ObricAssistantBaseServiceDelegate.b.b();
        IAIChatAudioService.a.cancel();
        List r17 = ObricRealtimeCallExtServiceImpl.access$finishUnrelatedVideoPages(this.this$0);
        this.L$0 = null;
        this.label = 3;
        if (com.obric.assistant.common.utils.a.a(r17, this) != r1) goto L57;
        return r1;
    L53:
        FLogger.a.i("ObricRealtimeCallExtServiceImpl", "existing rtc activity: " + r15 + " is destroyed");
        goto L54
    L11:
        ResultKt.throwOnFailure(r26);
    L17:
        this.this$0.setShowWhenLockedForExistingRealtimeCallActivity();
        r15 = (FragmentActivity) CollectionsKt.firstOrNull(ObricRealtimeCallExtServiceImpl.access$getRealtimeCallActivityIntents$p(this.this$0).keySet());
        if (ObricRealtimeCallExtServiceImpl.access$isMainRtcAlive(this.this$0, this.$mainConversation.a) == false) goto L43;
        FLogger.a.i("ObricRealtimeCallExtServiceImpl", "is main rtc alive. just bring it to front");
        String r18 = this.$startupAttemptId;
        if (r18 != null) goto L22;
    L24:
        if (r15 == null) goto L30;
        if (r9 == null) goto L30;
        Intent r19 = (Intent) ObricRealtimeCallExtServiceImpl.access$getRealtimeCallActivityIntents$p(this.this$0).get(r15);
        if (r19 != null) goto L29;
        r19 = r15.getIntent();
    L29:
        r19.putExtra("obric_startup_attempt_id", r9);
        ObricRealtimeCallExtServiceImpl.access$getRealtimeCallActivityIntents$p(this.this$0).put(r15, r19);
    L30:
        Function0<Unit> r20 = this.$onPreJump;
        if (r20 == null) goto L33;
        r20.invoke();
    L33:
        IObricLaunchService r22 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r22 == null) goto L36;
        r22.resumeOrLaunchNewTask(true);
    L36:
        if (r15 == null) goto L38;
        ObricRealtimeCallExtServiceImpl.access$bindRealtimeCallStartupReadyIfNeeded(this.this$0, r15);
    L38:
        CallType r23 = this.this$0.getCurrentCallType();
        if (r23 == null) goto L42;
        this.this$0.changeCallType(r23, this.$callType);
    L42:
        return Unit.INSTANCE;
    L22:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("rtc_call_content_ready"), r18) == false) goto L24;
        r9 = r18;
        goto L24
    L43:
        if (r15 == null) goto L54;
        FLogger.a.i("ObricRealtimeCallExtServiceImpl", "has existing rtc activity: " + r15 + ", will wait for it destroy");
        if (r15.isFinishing() == true) goto L47;
        r15.finish();
    L47:
        AnonymousClass2 r24 = new AnonymousClass2(this.this$0, r15, null);
        this.L$0 = r15;
        this.label = 2;
        r16 = TimeoutKt.c(2000, r24, this);
        if (r16 != r1) goto L51;
        return r1;
    L12:
        ResultKt.throwOnFailure(r26);
        if (this.$delayJumpMS <= 0) goto L17;
        FLogger.a.i("ObricRealtimeCallExtServiceImpl", "delayJumpMS: " + this.$delayJumpMS);
        long r110 = this.$delayJumpMS;
        this.label = 1;
        if (DelayKt.delay(r110, this) != r1) goto L17;
        return r1;
    }
}
