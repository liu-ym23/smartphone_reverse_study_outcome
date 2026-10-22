package com.bytedance.android.anniex.lite.flow.base;

import com.byted.cast.sink.api.ServerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager$releaseTask$1", f = "BaseAnnieXDispatchManager.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
final class BaseAnnieXDispatchManager$releaseTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    public BaseAnnieXDispatchManager$releaseTask$1(b r1, Continuation<? super BaseAnnieXDispatchManager$releaseTask$1> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new BaseAnnieXDispatchManager$releaseTask$1(this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L19:
        this.this$0.e();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Map r11 = x26.a.a;
        g r12 = (g) x26.a.a(g.class);
        if (r12 == null) goto L15;
        w26.e r13 = (w26.e) r12.n0(w26.e.class);
        if (r13 == null) goto L15;
        Integer r14 = r13.f();
        if (r14 == null) goto L15;
        int r15 = r14.intValue();
    L16:
        this.label = 1;
        if (DelayKt.delay(r15, this) != r0) goto L19;
        return r0;
    L15:
        r15 = ServerInfo.ERROR_BIND_SERVICE;
        goto L16
    }
}
