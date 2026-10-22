package com.larus.voicecall.impl.component.bottom;

import android.os.Handler;
import android.os.Looper;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.av_call.view.n0;
import com.larus.av_call.view.o0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "switchInterval", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.bottom.RealtimeBottomComponent$initRealtimeSuggest$1", f = "RealtimeBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeBottomComponent$initRealtimeSuggest$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ RealtimeBottomComponent this$0;

    public RealtimeBottomComponent$initRealtimeSuggest$1(RealtimeBottomComponent r1, Continuation<? super RealtimeBottomComponent$initRealtimeSuggest$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RealtimeBottomComponent$initRealtimeSuggest$1 r0 = new RealtimeBottomComponent$initRealtimeSuggest$1(this.this$0, r4);
        r0.J$0 = ((Number) r3).longValue();
        return r0;
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.voicecall.impl.component.bottom.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.voicecall.impl.component.bottom.k0, java.lang.Object] */
    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r6);
        long r0 = this.J$0;
        final RealtimeBottomComponent r7 = this.this$0;
        VoiceCallBottomLayout r2 = r7.M;
        if (r2 == null) goto L15;
        ?? r3 = new j0(r7);
        ?? r4 = new k0(r7);
        Intrinsics.checkNotNullParameter(r3, "onItemClick");
        Intrinsics.checkNotNullParameter(r4, "onItemUpdate");
        com.larus.av_call.view.c r8 = r2.a;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r8 = null;
    L9:
        com.larus.av_call.view.o r9 = r8.i().getDelegate();
        r9.f = r0;
        n0 r1 = new n0(r3, r2);
        Intrinsics.checkNotNullParameter(r1, "listener");
        r9.b = r1;
        o0 r5 = new o0(r4, r2);
        Intrinsics.checkNotNullParameter(r5, "listener");
        r9.c = r5;
        if (r9.d != null) goto L13;
        r9.d = new Handler(Looper.getMainLooper());
    L13:
        r9.a();
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
