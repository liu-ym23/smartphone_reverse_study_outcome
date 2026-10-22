package com.larus.dora.impl.settings.voiceprint;

import com.larus.dora.impl.databinding.LarusDoraActivityVoicePrintManagementBinding;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.settings.voiceprint.VoicePrintManagementActivity$refreshStatus$1", f = "VoicePrintManagementActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoicePrintManagementActivity$refreshStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoicePrintManagementActivity this$0;

    public VoicePrintManagementActivity$refreshStatus$1(VoicePrintManagementActivity r1, Continuation<? super VoicePrintManagementActivity$refreshStatus$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoicePrintManagementActivity$refreshStatus$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r3);
        Function1<? super Boolean, Unit> r4 = PacificInterfaceManager.a;
        VoicePrintManagementActivity r5 = this.this$0;
        LarusDoraActivityVoicePrintManagementBinding r0 = null;
        if (PacificInterfaceManager.c(r5.h, r5.i) == false) goto L14;
        LarusDoraActivityVoicePrintManagementBinding r6 = this.this$0.g;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L9:
        e1.x(r6.c);
        LarusDoraActivityVoicePrintManagementBinding r7 = this.this$0.g;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        e1.o(r0.d);
    L23:
        return Unit.INSTANCE;
    L12:
        r0 = r7;
        goto L13
    L14:
        LarusDoraActivityVoicePrintManagementBinding r8 = this.this$0.g;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        e1.o(r8.c);
        LarusDoraActivityVoicePrintManagementBinding r9 = this.this$0.g;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        e1.x(r0.d);
        goto L23
    L20:
        r0 = r9;
        goto L21
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
