package com.larus.canvas.feature.component.logic;

import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$explainOriginImageUrl$job$1", f = "GenImagePlannerComponent.kt", i = {}, l = {1880}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$explainOriginImageUrl$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$explainOriginImageUrl$job$1(String r1, GenImagePlannerComponent r2, Continuation<? super GenImagePlannerComponent$explainOriginImageUrl$job$1> r3) {
        this.$url = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GenImagePlannerComponent$explainOriginImageUrl$job$1(this.$url, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        com.larus.network.http.y r10 = (com.larus.network.http.a) r9;
        if ((r10 instanceof com.larus.network.http.y) == false) goto L65;
        com.larus.uaigc.api.s r11 = (com.larus.uaigc.api.s) ((com.larus.network.http.a) r10).b;
        Long r2 = null;
        if (r11 == null) goto L18;
        List r12 = r11.a();
        if (r12 == null) goto L18;
        final com.larus.uaigc.api.q r13 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r12);
    L19:
        if (r13 == null) goto L21;
        final String r3 = r13.c();
    L23:
        if (com.larus.utils.o0.d(r3) == false) goto L65;
        int r4 = 0;
        if (r13 == null) goto L27;
        boolean r5 = Intrinsics.areEqual(r13.a(), Boxing.boxBoolean(false));
    L28:
        if (r5 == false) goto L65;
        FLogger r6 = FLogger.a;
        r6.i("GenImagePlannerComponent", "explainResourceUrl success, uri: " + r3);
        ky8.j r7 = this.this$0.c4();
        ky8.j r8 = this.this$0.c4();
        if (r8 == null) goto L32;
        String r14 = r8.b;
    L34:
        if (Intrinsics.areEqual(r14, this.$url) == false) goto L65;
        if (r7 == null) goto L37;
        String r15 = r7.a;
    L38:
        if (r15 == null) goto L48;
        Integer r16 = r7.d;
        if (r16 == null) goto L42;
        int r17 = r16.intValue();
    L43:
        if (r17 == 0) goto L48;
        Integer r18 = r7.c;
        if (r18 == null) goto L47;
        r4 = r18.intValue();
    L47:
        if (r4 != 0) goto L65;
    L42:
        r17 = 0;
    L48:
        com.larus.canvas.feature.component.logic.helper.f.a(this.this$0.m, new j1(r13, r3));
        StringBuilder r19 = new StringBuilder("explainOriginImageUrl state update, uri: ");
        r19.append(r3);
        r19.append(", width: ");
        com.larus.uaigc.api.p r20 = r13.b();
        if (r20 == null) goto L55;
        com.larus.uaigc.api.n r21 = r20.a();
        if (r21 == null) goto L55;
        com.larus.uaigc.api.m r22 = r21.a();
        if (r22 == null) goto L55;
        Long r23 = r22.b();
    L56:
        r19.append(r23);
        r19.append(", height: ");
        com.larus.uaigc.api.p r24 = r13.b();
        if (r24 == null) goto L63;
        com.larus.uaigc.api.n r25 = r24.a();
        if (r25 == null) goto L63;
        com.larus.uaigc.api.m r26 = r25.a();
        if (r26 == null) goto L63;
        r2 = r26.a();
    L63:
        r19.append(r2);
        r6.i("GenImagePlannerComponent", r19.toString());
    L55:
        r23 = null;
        goto L56
    L37:
        r15 = null;
        goto L38
    L32:
        r14 = null;
        goto L34
    L27:
        r5 = false;
        goto L28
    L21:
        r3 = null;
    L18:
        r13 = null;
    L65:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        List r27 = CollectionsKt.listOf(this.$url);
        this.label = 1;
        r9 = com.larus.uaigc.api.o.a(r27, true, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
