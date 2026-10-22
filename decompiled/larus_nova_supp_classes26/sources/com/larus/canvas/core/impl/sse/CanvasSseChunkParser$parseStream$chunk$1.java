package com.larus.canvas.core.impl.sse;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.BufferedSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/canvas/core/impl/sse/CanvasChunkPackage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.core.impl.sse.CanvasSseChunkParser$parseStream$chunk$1", f = "CanvasSseChunkParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasSseChunkParser$parseStream$chunk$1 extends SuspendLambda implements Function1<Continuation<? super b>, Object> {
    final /* synthetic */ BufferedSource $buffer;
    int label;
    final /* synthetic */ CanvasSseChunkParser this$0;

    public CanvasSseChunkParser$parseStream$chunk$1(CanvasSseChunkParser r1, BufferedSource r2, Continuation<? super CanvasSseChunkParser$parseStream$chunk$1> r3) {
        this.this$0 = r1;
        this.$buffer = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new CanvasSseChunkParser$parseStream$chunk$1(this.this$0, this.$buffer, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super b> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r12);
        CanvasSseChunkParser r13 = this.this$0;
        BufferedSource r0 = this.$buffer;
        int r1 = CanvasSseChunkParser.b;
        r13.getClass();
    L5:
        String r14 = r0.readUtf8Line();
        if (r14 == null) goto L36;
        String r15 = StringsKt.trim(r14).toString();
        if (r15 == null) goto L36;
        if ((!StringsKt.isBlank(r15)) == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        String r3 = "json";
    L13:
        if (r15 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L35;
        int r5 = StringsKt.indexOf$default(r15, ":", 0, false, 6, null);
        if (r5 < 0) goto L21;
        String r6 = StringsKt.trim(r15.substring(0, r5)).toString();
        String r16 = StringsKt.trim(r15.substring(r5 + 1)).toString();
        if ((!StringsKt.isBlank(r16)) == false) goto L31;
        if (Intrinsics.areEqual(r6, "event") == false) goto L28;
        r3 = r16;
        goto L31
    L28:
        if (Intrinsics.areEqual(r6, "data") == false) goto L31;
        r2.append(r16);
    L31:
        if (Intrinsics.areEqual(r3, "done") == true) goto L35;
        r15 = r0.readUtf8Line();
        goto L13
    L21:
        r15 = r0.readUtf8Line();
    L35:
        return new b(r3, r2.toString());
    L15:
        if ((!StringsKt.isBlank(r15)) != true) goto L17;
        r4 = true;
    L36:
        final String r7 = "stream ended";
        final Throwable r8 = null;
        throw new CanvasSseChunkParser$ReadChunkException(r7, r8);
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
