package com.larus.bmhome.bot.utils;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.z1;
import com.larus.utils.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bot.utils.PinBotShortcutLinkProcessor$process$1", f = "PinBotShortcutLinkProcessor.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class PinBotShortcutLinkProcessor$process$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $host;
    final /* synthetic */ Uri $uri;
    int label;

    public PinBotShortcutLinkProcessor$process$1(Uri r1, Activity r2, Continuation<? super PinBotShortcutLinkProcessor$process$1> r3) {
        this.$uri = r1;
        this.$host = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinBotShortcutLinkProcessor$process$1(this.$uri, this.$host, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        PinBotShortcutLinkProcessor.a r7 = (PinBotShortcutLinkProcessor.a) r6;
        if (r7 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (r7.c == false) goto L18;
        PinBotShortcutLinkProcessor r2 = PinBotShortcutLinkProcessor.a;
        Activity r3 = this.$host;
        r2.getClass();
        z1.a.c(r3);
        Bundle r8 = f.c(new Pair[]{TuplesKt.to("argPreviousPage", r7.d), TuplesKt.to("argConversationId", r7.b), TuplesKt.to("argBotId", r7.a.getBotId()), TuplesKt.to("argBotType", r7.a.getBotType()), TuplesKt.to("argCvsBgImgUrl", r7.a.getBgImgUrl()), TuplesKt.to("argCvsBgImgColor", r7.a.getBgImgColor()), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r7.a.getBgImgOpen())), TuplesKt.to("enter_method", "shortcut"), TuplesKt.to("enter_from", "shortcut"), TuplesKt.to("pin_shortcut", Boolean.TRUE)});
        i r4 = SmartRouter.buildRoute(r3, "//flow/chat_page");
        r4.c.putExtras(r8);
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
    L20:
        return Unit.INSTANCE;
    L18:
        PinBotShortcutLinkProcessor.b(PinBotShortcutLinkProcessor.a, r7);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PinBotShortcutLinkProcessor r9 = PinBotShortcutLinkProcessor.a;
        Uri r5 = this.$uri;
        this.label = 1;
        r6 = PinBotShortcutLinkProcessor.a(r9, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
