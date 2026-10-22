package com.obric.audio.continuous_talk.session.impl.plugin;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.ObricContTalkStateMachine;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.plugin.ObricContTalkAudioPlugin$onStart$1", f = "ObricContTalkAudioPlugin.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContTalkAudioPlugin$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricContTalkAudioPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContTalkAudioPlugin a;

        public a(ObricContTalkAudioPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            AVKitDuplexState r10 = (AVKitDuplexState) r8;
            ObricContTalkAudioPlugin r11 = this.a;
            int r0 = ObricContTalkAudioPlugin.b0;
            r11.getClass();
            AVKitDuplexState.UpState r1 = r10.getUpState();
            AVKitDuplexState.DownState r12 = r10.getDownState();
            if ((r12 instanceof ObricContTalkStateMachine.WhisperSpeaking) == true) goto L13;
            boolean r2 = r12 instanceof AVKitCoreStates.Speaking;
            if (r2 == false) goto L9;
            if ((r1 instanceof AVKitCoreStates.Recognizing) == true) goto L13;
        L9:
            if (r11.T == false) goto L12;
            if (r2 == true) goto L13;
        L12:
            boolean r3 = false;
        L15:
            if (r3 == false) goto L17;
            float r4 = 0.2f;
        L18:
            FLogger.a.i(r11.I, "updateTtsVolumeByDuplexState, upState=" + r1.toSimpleString() + ", downState=" + r12.toSimpleString() + ", shouldKeepTtsDucked=" + r11.T + ", shouldRestoreTtsVolumeOnNextFirstFrame=" + r11.U + ", targetDuckVolumeFactor=" + r4);
            r11.W = RangesKt.coerceIn(r4, 0.0f, 1.0f);
            r11.h4("duplex_state");
            return Unit.INSTANCE;
        L17:
            r4 = 1.0f;
        L13:
            r3 = true;
            goto L15
        }
    }

    public ObricContTalkAudioPlugin$onStart$1(ObricContTalkAudioPlugin r1, Continuation<? super ObricContTalkAudioPlugin$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContTalkAudioPlugin$onStart$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        i1 r6 = ((com.obric.audio.continuous_talk.session.impl.a) this.this$0.getContext()).a().y();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
