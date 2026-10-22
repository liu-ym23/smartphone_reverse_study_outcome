package com.larus.voicecall.impl.component.bottom;

import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.voicecall.impl.utils.RealtimeCallSuggestManager;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "suggests", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "showFrom"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.bottom.RealtimeBottomComponent$initRealtimeSuggest$2", f = "RealtimeBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeBottomComponent$initRealtimeSuggest$2 extends SuspendLambda implements Function3<List<? extends String>, String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ RealtimeBottomComponent this$0;

    public RealtimeBottomComponent$initRealtimeSuggest$2(RealtimeBottomComponent r1, Continuation<? super RealtimeBottomComponent$initRealtimeSuggest$2> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((List) r1, (String) r2, (Continuation) r3);
    }

    public final Object invoke(List<String> r3, String r4, Continuation<? super Unit> r5) {
        RealtimeBottomComponent$initRealtimeSuggest$2 r0 = new RealtimeBottomComponent$initRealtimeSuggest$2(this.this$0, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r6);
        List r7 = (List) this.L$0;
        String r0 = (String) this.L$1;
        com.larus.av_call.view.c r2 = null;
        if (r7.isEmpty() == false) goto L7;
        RealtimeBottomComponent r1 = this.this$0;
        int r3 = RealtimeBottomComponent.Q;
        r1.G3();
    L8:
        n3a.a r4 = this.this$0.E3();
        if (r4 == null) goto L11;
        r4.k90(r0, r7.size());
    L11:
        VoiceCallBottomLayout r5 = this.this$0.M;
        if (r5 == null) goto L19;
        Intrinsics.checkNotNullParameter(r7, "suggestList");
        com.larus.av_call.view.c r8 = r5.a;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L17:
        com.larus.av_call.view.o r9 = r2.i().getDelegate();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r7, "list");
        r9.e = r7;
        r9.a();
        goto L19
    L16:
        r2 = r8;
    L19:
        return Unit.INSTANCE;
    L7:
        RealtimeBottomComponent r10 = this.this$0;
        int r11 = RealtimeBottomComponent.Q;
        RealtimeCallSuggestManager r12 = r10.D3();
        RealtimeBottomComponent$showRealtimeSuggest$1 r13 = new RealtimeBottomComponent$showRealtimeSuggest$1(r10, r0, null);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "callback");
        boolean r14 = ((h88.a) r12.b).m;
        goto L8
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
