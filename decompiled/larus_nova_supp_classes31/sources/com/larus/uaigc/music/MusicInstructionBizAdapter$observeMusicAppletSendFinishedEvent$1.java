package com.larus.uaigc.music;

import com.larus.uaigc.createpage.v;
import com.larus.uaigc.music.applet.b0;
import com.larus.uaigc.music.applet.v1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.a1;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.MusicInstructionBizAdapter$observeMusicAppletSendFinishedEvent$1", f = "MusicInstructionBizAdapter.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
final class MusicInstructionBizAdapter$observeMusicAppletSendFinishedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            v1 r5 = (v1) r3;
            String r6 = this.a.l;
            if (r6 != null) goto L6;
            return Unit.INSTANCE;
        L6:
            if (Intrinsics.areEqual(r5.b, r6) == false) goto L14;
            b r7 = this.a;
            r7.l = null;
            v r8 = (v) d.a(r7.h).getAbility(v.class);
            if (r8 != null) goto L11;
            FLogger.a.e("MusicInstructionBizAdapter", "close source creation page failed, ability is null");
            return Unit.INSTANCE;
        L11:
            FLogger.a.i("MusicInstructionBizAdapter", "close source creation page after music applet send");
            r8.kB(true);
            return Unit.INSTANCE;
        L14:
            return Unit.INSTANCE;
        }
    }

    public MusicInstructionBizAdapter$observeMusicAppletSendFinishedEvent$1(b r1, Continuation<? super MusicInstructionBizAdapter$observeMusicAppletSendFinishedEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MusicInstructionBizAdapter$observeMusicAppletSendFinishedEvent$1(this.this$0, r3);
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
        a1 r6 = b0.d;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
