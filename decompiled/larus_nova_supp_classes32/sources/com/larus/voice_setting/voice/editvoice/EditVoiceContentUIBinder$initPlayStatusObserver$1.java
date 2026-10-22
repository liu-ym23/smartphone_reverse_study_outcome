package com.larus.voice_setting.voice.editvoice;

import android.content.Context;
import com.larus.audio.AudioServiceDelegate;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.editvoice.EditVoiceContentUIBinder$initPlayStatusObserver$1", f = "EditVoiceContentUIBinder.kt", i = {}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_UPLINKACK}, m = "invokeSuspend", n = {}, s = {})
final class EditVoiceContentUIBinder$initPlayStatusObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ j0 this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ j0 a;

        public a(j0 r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            a1 r5 = (a1) r3;
            if (Intrinsics.areEqual(r5, a1.b.a) == false) goto L9;
            if (AudioServiceDelegate.a.F().b() == false) goto L7;
            t19.s r6 = t19.s.a;
            Context r7 = this.a.a;
            r6.getClass();
            t19.s.s(r7, 2131901654);
        L12:
            return Unit.INSTANCE;
        L7:
            t19.s r8 = t19.s.a;
            Context r9 = this.a.a;
            r8.getClass();
            t19.s.s(r9, 2131901103);
            goto L12
        L9:
            if (Intrinsics.areEqual(r5, a1.a.a) == false) goto L14;
            v2a.g r10 = v2a.g.a;
            v2a.g.b(this.a.d.g(), "auto", this.a.d.j(), this.a.e);
            goto L12
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    public EditVoiceContentUIBinder$initPlayStatusObserver$1(j0 r1, Continuation<? super EditVoiceContentUIBinder$initPlayStatusObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EditVoiceContentUIBinder$initPlayStatusObserver$1(this.this$0, r3);
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
        j0 r6 = this.this$0;
        MutableSharedFlow r2 = r6.d.A;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
