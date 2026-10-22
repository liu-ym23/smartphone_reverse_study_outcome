package com.larus.ugc.feed.impl.detail.ability;

import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.creation.UserCreation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.detail.ability.CreationDetailBottomToolsAbilityImpl$initData$2", f = "CreationDetailBottomToolsAbilityImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailBottomToolsAbilityImpl$initData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ boolean $isFromAnchor;
    int label;
    final /* synthetic */ CreationDetailBottomToolsAbilityImpl this$0;

    public CreationDetailBottomToolsAbilityImpl$initData$2(CreationDetailBottomToolsAbilityImpl r1, String r2, boolean r3, Continuation<? super CreationDetailBottomToolsAbilityImpl$initData$2> r4) {
        this.this$0 = r1;
        this.$creationId = r2;
        this.$isFromAnchor = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDetailBottomToolsAbilityImpl$initData$2(this.this$0, this.$creationId, this.$isFromAnchor, r5);
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
        final UserCreation r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        j0a.a r7 = (j0a.a) r6;
    L19:
        if ((r7 instanceof j0a.a.c) == false) goto L21;
        j0a.a.c r8 = (j0a.a.c) r7;
    L22:
        if (r8 == null) goto L24;
        r3 = r8.a;
    L24:
        if (r3 != null) goto L27;
        c0.b.i("BottomToolsAbilityImpl", "initData forceFetch: no hit detail for " + this.$creationId);
        return Unit.INSTANCE;
    L27:
        this.this$0.b.update(new c(r3));
        return Unit.INSTANCE;
    L21:
        r8 = null;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationDetailBottomToolsAbilityImpl r9 = this.this$0;
        int r2 = CreationDetailBottomToolsAbilityImpl.f;
        i0a.b r10 = r9.e;
        if (r10 == null) goto L11;
        j0a.b r11 = r10.a;
    L12:
        if (r11 == null) goto L17;
        String r4 = this.$creationId;
        boolean r5 = this.$isFromAnchor;
        this.label = 1;
        r6 = r11.a(r4, r5);
        if (r6 != r0) goto L16;
        return r0;
    L17:
        r7 = null;
        goto L19
    L11:
        r11 = null;
        goto L12
    }
}
