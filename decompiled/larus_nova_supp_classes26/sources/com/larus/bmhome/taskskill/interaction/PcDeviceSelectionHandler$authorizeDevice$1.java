package com.larus.bmhome.taskskill.interaction;

import android.content.Context;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler$authorizeDevice$1", f = "PcDeviceSelectionHandler.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
public final class PcDeviceSelectionHandler$authorizeDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PcDevice $device;
    final /* synthetic */ String $targetDeviceId;
    final /* synthetic */ String $ticket;
    int label;
    final /* synthetic */ PcDeviceSelectionHandler this$0;

    public PcDeviceSelectionHandler$authorizeDevice$1(PcDeviceSelectionHandler r1, PcDevice r2, String r3, Context r4, String r5, Continuation<? super PcDeviceSelectionHandler$authorizeDevice$1> r6) {
        this.this$0 = r1;
        this.$device = r2;
        this.$targetDeviceId = r3;
        this.$context = r4;
        this.$ticket = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new PcDeviceSelectionHandler$authorizeDevice$1(this.this$0, this.$device, this.$targetDeviceId, this.$context, this.$ticket, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        if (((Boolean) r7).booleanValue() == false) goto L16;
        PcDeviceSelectionHandler.a r8 = this.this$0.b;
        if (r8 == null) goto L21;
        r8.c(this.$device);
    L21:
        return Unit.INSTANCE;
    L16:
        PcDeviceSelectionHandler.a r9 = this.this$0.b;
        if (r9 == null) goto L19;
        r9.b(null);
    L19:
        FLogger.a.w("PcDeviceSelectionHandler", "[authorizeDevice] failed, targetDeviceId=" + this.$targetDeviceId);
        s r10 = s.a;
        Context r2 = this.$context;
        int r3 = this.this$0.a.d;
        r10.getClass();
        s.s(r2, r3);
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        PcDeviceSelectionHandler$authorizeDevice$1$success$1 r4 = new PcDeviceSelectionHandler$authorizeDevice$1$success$1(this.$targetDeviceId, this.$ticket, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r11, r4, this);
        if (r7 != r0) goto L12;
        return r0;
    }
}
