package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager$waitForVideoResource$completed$1", f = "CreationNoWatermarkManager.kt", i = {}, l = {1929}, m = "invokeSuspend", n = {}, s = {})
public final class CreationNoWatermarkManager$waitForVideoResource$completed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $inFlightKey;
    final /* synthetic */ String $vid;
    int label;

    public CreationNoWatermarkManager$waitForVideoResource$completed$1(String r1, String r2, Continuation<? super CreationNoWatermarkManager$waitForVideoResource$completed$1> r3) {
        this.$inFlightKey = r1;
        this.$vid = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationNoWatermarkManager$waitForVideoResource$completed$1(this.$inFlightKey, this.$vid, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
    L10:
        if (CreationNoWatermarkManager.j.contains(this.$inFlightKey) == false) goto L24;
        CreationNoWatermarkManager$e r7 = CreationNoWatermarkManager.a.x(this.$vid);
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == true) goto L24;
        if (CreationNoWatermarkManager.h.contains(this.$vid) == true) goto L24;
        this.label = 1;
        if (DelayKt.delay(50, this) != r0) goto L10;
        return r0;
    L14:
        if (CreationNoWatermarkManager.F(r7) != true) goto L16;
        r8 = true;
    L24:
        return Boxing.boxBoolean(true);
    }
}
