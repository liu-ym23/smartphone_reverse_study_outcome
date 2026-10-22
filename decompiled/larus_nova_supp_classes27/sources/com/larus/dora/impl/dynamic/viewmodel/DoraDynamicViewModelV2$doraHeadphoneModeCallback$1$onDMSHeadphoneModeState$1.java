package com.larus.dora.impl.dynamic.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2$doraHeadphoneModeCallback$1$onDMSHeadphoneModeState$1", f = "DoraDynamicViewModelV2.kt", i = {}, l = {308, 310}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDynamicViewModelV2$doraHeadphoneModeCallback$1$onDMSHeadphoneModeState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte $mode;
    int label;
    final /* synthetic */ DoraDynamicViewModelV2 this$0;

    public DoraDynamicViewModelV2$doraHeadphoneModeCallback$1$onDMSHeadphoneModeState$1(byte r1, DoraDynamicViewModelV2 r2, Continuation<? super DoraDynamicViewModelV2$doraHeadphoneModeCallback$1$onDMSHeadphoneModeState$1> r3) {
        this.$mode = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDynamicViewModelV2$doraHeadphoneModeCallback$1$onDMSHeadphoneModeState$1(this.$mode, this.this$0, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L23:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        if (kj4.a.g().c() != null) goto L15;
        return Unit.INSTANCE;
    L15:
        if (this.$mode != 0) goto L19;
        z0 r6 = DoraDynamicViewModelV2.access$get_headphoneModeStateFlow$p(this.this$0);
        Boolean r2 = Boxing.boxBoolean(false);
        this.label = 1;
        if (r6.emit(r2, this) != r0) goto L23;
        return r0;
    L19:
        z0 r7 = DoraDynamicViewModelV2.access$get_headphoneModeStateFlow$p(this.this$0);
        Boolean r3 = Boxing.boxBoolean(true);
        this.label = 2;
        if (r7.emit(r3, this) != r0) goto L23;
        return r0;
    }
}
