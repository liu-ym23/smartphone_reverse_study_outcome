package com.larus.bmhome.chat.layout.widget.handler;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.handler.StreamAlphaSpanHandler$loop$1", f = "StreamAlphaSpanHandler.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class StreamAlphaSpanHandler$loop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public StreamAlphaSpanHandler$loop$1(Continuation<? super StreamAlphaSpanHandler$loop$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new StreamAlphaSpanHandler$loop$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:12:0x0027). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
        StreamAlphaSpanHandler$loop$1 r12 = this;
    L12:
        int r2 = RangesKt.coerceAtLeast((int) ((255.0d / p.e) * 33), 1);
        Map<String, p.a> r5 = p.b;
        if (r5.isEmpty() == false) goto L16;
        p.d = false;
        return Unit.INSTANCE;
    L16:
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = ((LinkedHashMap) r5).entrySet().iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (((p.a) r8.getValue()).c.isEmpty() == false) goto L18;
        r6.put(r8.getKey(), r8.getValue());
        goto L18
    L22:
        Iterator r9 = r6.entrySet().iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        p.b.remove(((Map.Entry) r9.next()).getKey());
        goto L24
    L26:
        Iterator r10 = ((LinkedHashMap) p.b).entrySet().iterator();
    L28:
        if (r10.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r10.next();
        String r14 = (String) r13.getKey();
        Iterator<Map.Entry<Integer, Integer>> r15 = ((p.a) r13.getValue()).c.entrySet().iterator();
    L31:
        if (r15.hasNext() == false) goto L35;
        Map.Entry<Integer, Integer> r16 = r15.next();
        r16.setValue(Boxing.boxInt(r16.getValue().intValue() + r2));
        if (r16.getValue().intValue() < 255) goto L31;
        r15.remove();
        goto L31
    L35:
        p.a(r14);
    L9:
        r12.label = 1;
        if (DelayKt.delay(33, r12) != r0) goto L12;
        return r0;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r12 = this;
        goto L9
    }
}
