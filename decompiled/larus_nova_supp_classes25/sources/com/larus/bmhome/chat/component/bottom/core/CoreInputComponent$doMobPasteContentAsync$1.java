package com.larus.bmhome.chat.component.bottom.core;

import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
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
import org.json.JSONObject;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$doMobPasteContentAsync$1", f = "CoreInputComponent.kt", i = {0}, l = {458}, m = "invokeSuspend", n = {"conversationId"}, s = {"L$0"})
final class CoreInputComponent$doMobPasteContentAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $lastShownMsg;
    final /* synthetic */ String $messageType;
    Object L$0;
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$doMobPasteContentAsync$1(CoreInputComponent r1, Message r2, String r3, Continuation<? super CoreInputComponent$doMobPasteContentAsync$1> r4) {
        this.this$0 = r1;
        this.$lastShownMsg = r2;
        this.$messageType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CoreInputComponent$doMobPasteContentAsync$1(this.this$0, this.$lastShownMsg, this.$messageType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        by7.e r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
        String r9 = r2;
    L22:
        JSONObject r11 = (JSONObject) r15;
        CoreInputComponent r16 = this.this$0;
        int r4 = CoreInputComponent.d3;
        BotModel r17 = r16.F4().getBotModel();
        if (r17 == null) goto L25;
        String r5 = r17.getBotId();
    L26:
        Integer r6 = Boxing.boxInt(0);
        Integer r7 = Boxing.boxInt(0);
        com.larus.bmhome.chat.component.cvs.y r18 = this.this$0.u0();
        if (r18 == null) goto L31;
        wc9.e r19 = r18.h();
        if (r19 == null) goto L31;
        String r8 = ic8.n.f(r19);
    L32:
        String r10 = this.$messageType;
        Fragment r110 = a.c(this.this$0);
        if ((r110 instanceof by7.e) == false) goto L35;
        r3 = (by7.e) r110;
    L35:
        tx9.r2.a(r5, r6, r7, null, r8, r9, r10, r11, r3, 3976);
        return Unit.INSTANCE;
    L31:
        r8 = null;
        goto L32
    L25:
        r5 = null;
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoreInputComponent r111 = this.this$0;
        int r12 = CoreInputComponent.d3;
        com.larus.bmhome.chat.component.cvs.y r112 = r111.u0();
        if (r112 == null) goto L13;
        wc9.e r113 = r112.h();
        if (r113 == null) goto L13;
        String r114 = r113.a;
    L14:
        LruCache r13 = ko8.a.a;
        if (r114 != null) goto L17;
        String r14 = "";
    L18:
        Message r20 = this.$lastShownMsg;
        this.L$0 = r114;
        this.label = 1;
        Object r21 = IAIChatControlTraceService.a.Ob(r14, r20, this);
        if (r21 != r0) goto L21;
        return r0;
    L21:
        r9 = r114;
        r15 = r21;
        goto L22
    L17:
        r14 = r114;
    L13:
        r114 = null;
        goto L14
    }
}
