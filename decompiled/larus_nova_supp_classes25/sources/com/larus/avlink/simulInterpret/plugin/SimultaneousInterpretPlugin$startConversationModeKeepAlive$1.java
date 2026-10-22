package com.larus.avlink.simulInterpret.plugin;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.simulInterpret.plugin.SimultaneousInterpretPlugin$startConversationModeKeepAlive$1", f = "SimultaneousInterpretPlugin.kt", i = {}, l = {538}, m = "invokeSuspend", n = {}, s = {})
final class SimultaneousInterpretPlugin$startConversationModeKeepAlive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public SimultaneousInterpretPlugin$startConversationModeKeepAlive$1(Continuation<? super SimultaneousInterpretPlugin$startConversationModeKeepAlive$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new SimultaneousInterpretPlugin$startConversationModeKeepAlive$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:12:0x0028). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        SimultaneousInterpretPlugin$startConversationModeKeepAlive$1 r7 = this;
    L12:
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 != null) goto L14;
    L9:
        r7.label = 1;
        if (DelayKt.delay(60000, r7) != r0) goto L12;
        return r0;
    L14:
        SessionService r3 = r2.d();
        if (r3 == null) goto L9;
        Boxing.boxInt(r3.j());
        goto L9
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        r7 = this;
        goto L9
    }
}
