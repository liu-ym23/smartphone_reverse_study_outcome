package com.larus.bmhome.chat.list.cell.text.cells.base;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.cells.base.CutMultipleCellNotifyManager$notifyDeepThinkContentItemWhenTyping$1", f = "CutMultipleCellNotifyManager.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
public final class CutMultipleCellNotifyManager$notifyDeepThinkContentItemWhenTyping$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $contentType;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $messageId;
    final /* synthetic */ Object $payload;
    final /* synthetic */ wq8.a $state;
    int label;
    final /* synthetic */ CutMultipleCellNotifyManager this$0;

    public CutMultipleCellNotifyManager$notifyDeepThinkContentItemWhenTyping$1(CutMultipleCellNotifyManager r1, String r2, int r3, Context r4, wq8.a r5, Object r6, Continuation<? super CutMultipleCellNotifyManager$notifyDeepThinkContentItemWhenTyping$1> r7) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$contentType = r3;
        this.$context = r4;
        this.$state = r5;
        this.$payload = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CutMultipleCellNotifyManager$notifyDeepThinkContentItemWhenTyping$1(this.this$0, this.$messageId, this.$contentType, this.$context, this.$state, this.$payload, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Map<String, wq8.a> r11 = this.this$0.e;
        if (r11 != null) goto L11;
    L14:
        boolean r12 = true;
    L15:
        if (r12 == true) goto L17;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<String, wq8.a>> r13 = this.this$0.e.entrySet().iterator();
    L20:
        if (r13.hasNext() == false) goto L22;
        Map.Entry<String, wq8.a> r2 = r13.next();
        r7.put(r2.getKey(), r2.getValue());
        goto L20
    L22:
        this.this$0.e.clear();
        CutMultipleCellNotifyManager r3 = this.this$0;
        String r4 = this.$messageId;
        int r5 = this.$contentType;
        Context r6 = this.$context;
        wq8.a r8 = this.$state;
        Object r9 = this.$payload;
        this.label = 1;
        if (r3.c(true, r4, r5, r6, r8, r7, r9) != r0) goto L26;
        return r0;
    L17:
        return Unit.INSTANCE;
    L11:
        if (r11.isEmpty() == true) goto L14;
        r12 = false;
        goto L15
    }
}
