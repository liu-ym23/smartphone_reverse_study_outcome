package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "detectionReady", "tabState", "Lcom/larus/camera/impl/entity/EduResultTabState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$bottomReadyFlow$1", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTabControlComponent$bottomReadyFlow$1 extends SuspendLambda implements Function3<Boolean, px8.b, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ResultTabControlComponent$bottomReadyFlow$1(Continuation<? super ResultTabControlComponent$bottomReadyFlow$1> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Boolean) r1).booleanValue(), (px8.b) r2, (Continuation) r3);
    }

    public final Object invoke(boolean r2, px8.b r3, Continuation<? super Boolean> r4) {
        ResultTabControlComponent$bottomReadyFlow$1 r0 = new ResultTabControlComponent$bottomReadyFlow$1(r4);
        r0.Z$0 = r2;
        r0.L$0 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        px8.b r0 = (px8.b) this.L$0;
        if (r3 == true) goto L7;
    L9:
        boolean r4 = false;
    L11:
        return Boxing.boxBoolean(r4);
    L7:
        if (r0.a.contains(r0.b) == false) goto L9;
        r4 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
