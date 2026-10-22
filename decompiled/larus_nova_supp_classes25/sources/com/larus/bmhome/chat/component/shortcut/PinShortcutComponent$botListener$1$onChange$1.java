package com.larus.bmhome.chat.component.shortcut;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.trace.z;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;
import s1a.d;
import vb8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.shortcut.PinShortcutComponent$botListener$1$onChange$1", f = "PinShortcutComponent.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
final class PinShortcutComponent$botListener$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $new;
    int label;
    final /* synthetic */ PinShortcutComponent this$0;

    public PinShortcutComponent$botListener$1$onChange$1(PinShortcutComponent r1, BotModel r2, Continuation<? super PinShortcutComponent$botListener$1$onChange$1> r3) {
        this.this$0 = r1;
        this.$new = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PinShortcutComponent$botListener$1$onChange$1(this.this$0, this.$new, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        FLogger r15 = FLogger.a;
        r15.i("PinShortcutComponent", "[onBotModelChanged] doPinShortcut");
        PinShortcutComponent r2 = this.this$0;
        BotModel r3 = this.$new;
        int r4 = PinShortcutComponent.l;
        r2.getClass();
        z r5 = d.a(r2).getAbility(z.class);
        String r6 = null;
        if (r5 == null) goto L14;
        String r7 = r5.k();
    L15:
        y r8 = (y) r2.h.getValue();
        if (r8 == null) goto L18;
        String r9 = r8.Y1();
    L19:
        r15.i("PinShortcutComponent", "doPinShortcut, botId:" + r3.getBotId() + ", conversationId:" + r9);
        String r16 = r3.getBotId();
        ChatControlTrace r10 = ChatControlTrace.b;
        r10.getClass();
        String r11 = r10.h(ChatControlTrace.y);
        Boolean r12 = Boolean.valueOf(ve8.c.c(r3));
        ICoreInputAbility r13 = d.a(r2).getAbility(ICoreInputAbility.class);
        if (r13 == null) goto L22;
        Boolean r17 = Boolean.valueOf(r13.Qd(false));
    L23:
        JSONObject r18 = tx9.c.a(r7, r16, r11, r12, r17);
        IShortcutPlatformService r19 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
        if (r19 == null) goto L29;
        String r20 = r3.getName();
        BotIconImage r110 = r3.getIconImage();
        if (r110 == null) goto L28;
        r6 = r110.getOriginUrl();
    L28:
        r19.c(r9, r20, r6, a.a(r3), r18);
    L29:
        r2.j = true;
        return Unit.INSTANCE;
    L22:
        r17 = null;
        goto L23
    L18:
        r9 = null;
        goto L19
    L14:
        r7 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L11;
        return r0;
    }
}
