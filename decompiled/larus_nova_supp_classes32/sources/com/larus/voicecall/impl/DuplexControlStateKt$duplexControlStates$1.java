package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/voicecall/impl/DuplexControlState;", "state", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "isMuted", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.DuplexControlStateKt$duplexControlStates$1", f = "DuplexControlState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DuplexControlStateKt$duplexControlStates$1 extends SuspendLambda implements Function3<AVKitDuplexState, Boolean, Continuation<? super c>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public DuplexControlStateKt$duplexControlStates$1(Continuation<? super DuplexControlStateKt$duplexControlStates$1> r2) {
        super(3, r2);
    }

    public final Object invoke(AVKitDuplexState r2, boolean r3, Continuation<? super c> r4) {
        DuplexControlStateKt$duplexControlStates$1 r0 = new DuplexControlStateKt$duplexControlStates$1(r4);
        r0.L$0 = r2;
        r0.Z$0 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((AVKitDuplexState) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        AVKitDuplexState r5 = (AVKitDuplexState) this.L$0;
        boolean r0 = this.Z$0;
        if ((r5.getUpState() instanceof AVKitCoreStates.Paused) == false) goto L7;
    L10:
        boolean r6 = true;
    L12:
        return new c(r0, r6);
    L7:
        if ((r5.getDownState() instanceof AVKitCoreStates.Paused) == true) goto L10;
        r6 = false;
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
