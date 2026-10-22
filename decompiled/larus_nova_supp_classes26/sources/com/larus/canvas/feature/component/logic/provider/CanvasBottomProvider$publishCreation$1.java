package com.larus.canvas.feature.component.logic.provider;

import com.larus.utils.o0;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.provider.CanvasBottomProvider$publishCreation$1", f = "CanvasBottomProvider.kt", i = {}, l = {223, 225}, m = "invokeSuspend", n = {}, s = {})
final class CanvasBottomProvider$publishCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ i this$0;

    public CanvasBottomProvider$publishCreation$1(i r1, Continuation<? super CanvasBottomProvider$publishCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CanvasBottomProvider$publishCreation$1(this.this$0, r3);
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
    L28:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r5);
        i r6 = this.this$0;
        Map<String, String> r2 = r6.f.f;
        ky8.a r7 = (ky8.a) ((com.larus.gallery.api.t) r6).d;
        if (r7 == null) goto L13;
        String r8 = r7.a;
    L15:
        if (o0.d(r2.get(r8)) == false) goto L24;
        i r9 = this.this$0;
        ky8.a r3 = (ky8.a) ((com.larus.gallery.api.t) r9).d;
        if (r3 == null) goto L21;
        String r4 = r3.a;
        if (r4 == null) goto L21;
        r9.f.e.put(r4, Boxing.boxInt(2));
    L21:
        i r10 = this.this$0;
        this.label = 1;
        if (i.z(r10, false, this) != r0) goto L28;
        return r0;
    L24:
        i r11 = this.this$0;
        this.label = 2;
        if (i.y(r11, this) != r0) goto L28;
        return r0;
    L13:
        r8 = null;
        goto L15
    }
}
