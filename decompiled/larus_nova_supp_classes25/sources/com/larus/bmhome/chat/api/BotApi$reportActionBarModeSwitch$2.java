package com.larus.bmhome.chat.api;

import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService$c;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.BotApi$reportActionBarModeSwitch$2", f = "BotApi.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
public final class BotApi$reportActionBarModeSwitch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends String>>, Object> {
    final /* synthetic */ IBotRepoService$c $param;
    int label;

    public BotApi$reportActionBarModeSwitch$2(IBotRepoService$c r1, Continuation<? super BotApi$reportActionBarModeSwitch$2> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotApi$reportActionBarModeSwitch$2(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L21:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        IBotRepoService$c r4 = this.$param;
        LinkedHashMap r5 = new LinkedHashMap();
        ouc.g0 r6 = ouc.k.c(r4.a);
        Intrinsics.checkNotNullParameter("conversation_id", "key");
        Intrinsics.checkNotNullParameter(r6, "element");
        ouc.i r7 = (ouc.i) r5.put("conversation_id", r6);
        b2 r8 = r4.b;
        if (r8 == null) goto L12;
        ouc.i r9 = xt7.d.b.d(b2.Companion.serializer(), r8);
        if (r9 == null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter("from_mode", "key");
        Intrinsics.checkNotNullParameter(r9, "element");
        ouc.i r10 = (ouc.i) r5.put("from_mode", r9);
        b2 r11 = r4.c;
        if (r11 == null) goto L17;
        ouc.i r12 = xt7.d.b.d(b2.Companion.serializer(), r11);
        if (r12 == null) goto L17;
    L18:
        Intrinsics.checkNotNullParameter("to_mode", "key");
        Intrinsics.checkNotNullParameter(r12, "element");
        ouc.i r14 = (ouc.i) r5.put("to_mode", r12);
        ouc.d0 r15 = new ouc.d0(r5);
        juc.d r16 = ouc.d0.Companion.serializer();
        this.label = 1;
        ExecutorService r2 = HttpExtKt.a;
        Map r17 = MapsKt.emptyMap();
        r13 = HttpExtKt.l("Social", String.class, "/alice/bot/action_bar_v3/mode_switch/report", HttpExtKt.o(r15, r16), "application/json", r17, true, null, null, null, this);
        if (r13 != r0) goto L21;
        return r0;
    L17:
        r12 = ouc.a0.INSTANCE;
    L12:
        r9 = ouc.a0.INSTANCE;
        goto L13
    }
}
