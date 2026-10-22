package com.obric.assistant.session.singleton;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.utils.logger.FLogger;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DoraWakeupDetector$ttsObserver$1 implements n68.a {
    public static final DoraWakeupDetector$ttsObserver$1 a = null;

    /* JADX INFO: renamed from: com.obric.assistant.session.singleton.DoraWakeupDetector$ttsObserver$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.session.singleton.DoraWakeupDetector$ttsObserver$1$1", f = "DoraWakeupDetector.kt", i = {}, l = {ApWakeEvent.ACCELERATING_END}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayStateEnum $playState;
        int label;

        public AnonymousClass1(PlayStateEnum r1, Continuation<? super AnonymousClass1> r2) {
            this.$playState = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$playState, r3);
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
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            AudioServiceDelegate r7 = AudioServiceDelegate.a;
            boolean r3 = r7.i0().a();
            com.obric.audio.continuous_talk.b r4 = (com.obric.audio.continuous_talk.b) ServiceManager.get().getService(com.obric.audio.continuous_talk.b.class);
            if (r4 != null) goto L14;
        L16:
            r2 = false;
        L17:
            if (r3 == false) goto L19;
        L28:
            DoraWakeupDetector.n = null;
            return Unit.INSTANCE;
        L19:
            if (r7.e0() == false) goto L28;
            if (DoraWakeupDetector.f == false) goto L28;
            if (DoraWakeupDetector.c == true) goto L28;
            DoraWakeupDetector r8 = DoraWakeupDetector.a;
            if (DoraWakeupDetector.d() == true) goto L28;
            if (r2 == true) goto L28;
            FLogger.a.i("DoraWakeupDetector", "onPlayStateChange playState: " + this.$playState + ", tts not playing after 500ms, close VUI session");
            DoraWakeupDetector.f();
            goto L28
        L14:
            if (r4.m0() != true) goto L16;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L11;
            return r0;
        }
    }

    static {
        a = new DoraWakeupDetector$ttsObserver$1();
    }

    public DoraWakeupDetector$ttsObserver$1() {
    }

    public final void d(PlayStateEnum r1) {
    }

    public final void e(TtsErrorType r1) {
    }

    public final void c(PlayStateEnum r10) {
        if (r10 != PlayStateEnum.PLAY_STATE_STOPPED) goto L5;
    L6:
        Job r0 = DoraWakeupDetector.n;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        DoraWakeupDetector.n = BuildersKt.launch$default(DoraWakeupDetector.j, null, null, new AnonymousClass1(r10, null), 3, null);
        return;
    L5:
        if (r10 == PlayStateEnum.PLAY_STATE_FAIL) goto L6;
    }

    public final void a(boolean r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void b(boolean r1, String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }
}
