package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.entity.ResultBottomControlType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTabControlComponent$DisplayState;", "bottomState", "Lcom/larus/camera/impl/entity/ResultBottomState;", "isInCropMode", "", "bottomReady"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$onViewCreated$displayStateFlow$1", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTabControlComponent$onViewCreated$displayStateFlow$1 extends SuspendLambda implements Function4<px8.e, Boolean, Boolean, Continuation<? super ResultTabControlComponent.DisplayState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    public ResultTabControlComponent$onViewCreated$displayStateFlow$1(Continuation<? super ResultTabControlComponent$onViewCreated$displayStateFlow$1> r2) {
        super(4, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((px8.e) r1, ((Boolean) r2).booleanValue(), ((Boolean) r3).booleanValue(), (Continuation) r4);
    }

    public final Object invoke(px8.e r2, boolean r3, boolean r4, Continuation<? super ResultTabControlComponent.DisplayState> r5) {
        ResultTabControlComponent$onViewCreated$displayStateFlow$1 r0 = new ResultTabControlComponent$onViewCreated$displayStateFlow$1(r5);
        r0.L$0 = r2;
        r0.Z$0 = r3;
        r0.Z$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r4);
        px8.e r5 = (px8.e) this.L$0;
        boolean r0 = this.Z$0;
        boolean r1 = this.Z$1;
        if (r0 == true) goto L22;
        if (r1 == false) goto L22;
        ResultBottomControlType r2 = null;
        if (r5 == null) goto L11;
        ResultBottomControlType r3 = r5.a;
    L13:
        if (r3 == ResultBottomControlType.INPUT) goto L25;
        if (r5 == null) goto L18;
        r2 = r5.a;
    L18:
        if (r2 != ResultBottomControlType.CONFIRM) goto L27;
        return ResultTabControlComponent.DisplayState.CONFIRM;
    L27:
        return ResultTabControlComponent.DisplayState.HIDDEN;
    L25:
        return ResultTabControlComponent.DisplayState.INPUT;
    L11:
        r3 = null;
    L22:
        return ResultTabControlComponent.DisplayState.HIDDEN;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
