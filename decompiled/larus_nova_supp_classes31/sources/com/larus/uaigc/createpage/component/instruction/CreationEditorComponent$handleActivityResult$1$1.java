package com.larus.uaigc.createpage.component.instruction;

import android.content.Intent;
import android.os.Bundle;
import com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$handleActivityResult$1$1", f = "CreationEditorComponent.kt", i = {}, l = {2523}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$handleActivityResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $it;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public CreationEditorComponent$handleActivityResult$1$1(Intent r1, CreationEditorComponent r2, Continuation<? super CreationEditorComponent$handleActivityResult$1$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationEditorComponent$handleActivityResult$1$1(this.$it, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Bundle r13 = this.$it.getExtras();
        if (r13 == null) goto L12;
        String r14 = r13.getString("creation_send_trace_id");
        if (r14 == null) goto L12;
    L13:
        String r9 = r14;
        CreationEditorComponent r15 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        py9.a r16 = r15.c4();
        if (r16 == null) goto L24;
        CreatePageSendMessageProcessor r3 = r16.Ck();
        if (r3 == null) goto L24;
        Bundle r17 = this.$it.getExtras();
        if (r17 != null) goto L20;
        r17 = com.larus.utils.f.c(new Pair[0]);
    L20:
        LinkedHashMap r8 = new LinkedHashMap();
        this.label = 1;
        if (ny9.d.a.b(r3, r17, "", null, "", r8, r9, this) != r0) goto L24;
        return r0;
    L12:
        ConcurrentHashMap r18 = ko8.b.a;
        r14 = UUID.randomUUID().toString();
        ko8.b.d(r14, "single_attachment");
        goto L13
    }
}
