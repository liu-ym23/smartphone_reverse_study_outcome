package com.larus.bmhome.chat.component.bottom.core;

import com.google.gson.Gson;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.platform.model.EditPos;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import oaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputComponent$addDynamicShortcut$1", f = "CoreInputComponent.kt", i = {0}, l = {1689}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class CoreInputComponent$addDynamicShortcut$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoreInputComponent this$0;

    public CoreInputComponent$addDynamicShortcut$1(CoreInputComponent r1, Continuation<? super CoreInputComponent$addDynamicShortcut$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CoreInputComponent$addDynamicShortcut$1 r0 = new CoreInputComponent$addDynamicShortcut$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L27:
        boolean r9 = ((Boolean) r8).booleanValue();
        CoreInputComponent r3 = this.this$0;
        int r4 = CoreInputComponent.d3;
        if (ic8.n.v(r3.k4().h()) == false) goto L37;
        a r5 = this.this$0.v4();
        if (r5 != null) goto L32;
    L33:
        CoreInputComponent r6 = this.this$0;
        IShortcutPlatformService r7 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
        if (r7 == null) goto L37;
        r7.s0(r6.k4().Qd(false), r9, r6.k4().v());
        Unit r10 = Unit.INSTANCE;
        goto L37
    L32:
        if (r5.s0(this.this$0.k4().Qd(false), r9, this.this$0.k4().v()) == null) goto L33;
    L37:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Gson r12 = new Gson();
        CoreInputComponent r13 = this.this$0;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L16
        int r15 = CoreInputComponent.d3;     // Catch: Throwable -> L16
        BotModel r16 = r13.k4().q();     // Catch: Throwable -> L16
        if (r16 == null) goto L13;
        String r17 = r16.getEditPos();     // Catch: Throwable -> L16
        if (r17 == null) goto L13;
    L14:
        Object r18 = Result.constructor-impl((EditPos) r12.fromJson(r17, EditPos.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r18) == false) goto L21;
        r18 = null;
    L21:
        EditPos r19 = (EditPos) r18;
        if (r19 != null) goto L24;
        r19 = new EditPos(0);
    L24:
        ILegacyChatUiServiceDelegate r20 = ILegacyChatUiServiceDelegate.b;
        CoreInputComponent r21 = this.this$0;
        int r22 = CoreInputComponent.d3;
        BotModel r23 = r21.k4().q();
        String r24 = this.this$0.k4().v();
        this.L$0 = r11;
        this.label = 1;
        r8 = r20.v8(r19, r23, r24, this);
        if (r8 != r0) goto L27;
        return r0;
    L13:
        r17 = "";
    L16:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
