package com.larus.bmhome.chat.api;

import com.larus.bmhome.actionbar.model.a1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService$d;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.platform.service.z2;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ouc.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarOpResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.api.BotApi$reportCustomActionBarOperation$2", f = "BotApi.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
public final class BotApi$reportCustomActionBarOperation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a<? extends a1>>, Object> {
    final /* synthetic */ IBotRepoService$d $param;
    int label;

    public BotApi$reportCustomActionBarOperation$2(IBotRepoService$d r1, Continuation<? super BotApi$reportCustomActionBarOperation$2> r2) {
        this.$param = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotApi$reportCustomActionBarOperation$2(this.$param, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a<a1>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L38:
        return (a) r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        if (z2.a.A1() == false) goto L11;
        String r12 = "/alice/bot/action_bar_report";
    L12:
        IBotRepoService$d r3 = this.$param;
        e0 r4 = new e0();
        r4.b("language_code", ouc.k.c(r3.a));
        r4.b("bot_id", ouc.k.c(r3.b));
        r4.b("conversation_id", ouc.k.c(r3.c));
        r4.b("action_bar_key", ouc.k.c(r3.d));
        r4.b("passthrough_field", ouc.k.c(r3.e));
        Boolean r5 = r3.f;
        if (r5 == null) goto L15;
        boolean r6 = r5.booleanValue();
        LinkedHashMap r8 = new LinkedHashMap();
        ouc.g0 r7 = ouc.k.a(Boolean.valueOf(r6));
        Intrinsics.checkNotNullParameter("switch", "key");
        Intrinsics.checkNotNullParameter(r7, "element");
        ouc.i r9 = (ouc.i) r8.put("switch", r7);
        Unit r10 = Unit.INSTANCE;
        r4.b("switch_report", new ouc.d0(r8));
    L15:
        LinkedHashMap r13 = new LinkedHashMap();
        Integer r14 = r3.g;
        if (r14 != null) goto L18;
    L20:
        String r15 = r3.h;
        if (r15 != null) goto L23;
    L31:
        Unit r16 = Unit.INSTANCE;
        r4.b("instruction_report", new ouc.d0(r13));
        String r17 = r3.i;
        if (r17 == null) goto L34;
        r4.b("page_scene", ouc.k.c(r17));
    L34:
        ouc.d0 r18 = r4.a();
        juc.d r19 = ouc.d0.Companion.serializer();
        juc.d<a1> r20 = a1.Companion.serializer();
        this.label = 1;
        r11 = HttpExtKt.j(a1.class, r12, r18, r19, r20, null, this, 3776);
        if (r11 != r0) goto L38;
        return r0;
    L23:
        if (r15.length() <= 0) goto L25;
        boolean r21 = true;
    L26:
        if (r21 == true) goto L29;
        r15 = null;
    L29:
        if (r15 == null) goto L31;
        ouc.g0 r22 = ouc.k.c(r15);
        Intrinsics.checkNotNullParameter("msg_id", "key");
        Intrinsics.checkNotNullParameter(r22, "element");
        ouc.i r23 = (ouc.i) r13.put("msg_id", r22);
        goto L31
    L25:
        r21 = false;
        goto L26
    L18:
        if (r14.intValue() == 0) goto L20;
        ouc.g0 r24 = ouc.k.b(r3.g);
        Intrinsics.checkNotNullParameter("instruction_type", "key");
        Intrinsics.checkNotNullParameter(r24, "element");
        ouc.i r25 = (ouc.i) r13.put("instruction_type", r24);
        goto L20
    L11:
        r12 = "/alice/bot/action_bar_v3/report";
        goto L12
    }
}
