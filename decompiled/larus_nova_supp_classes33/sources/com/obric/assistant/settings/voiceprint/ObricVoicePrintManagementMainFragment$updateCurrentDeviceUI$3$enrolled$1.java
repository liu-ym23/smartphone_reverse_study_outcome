package com.obric.assistant.settings.voiceprint;

import com.obric.assistant.t1;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1", f = "ObricVoicePrintManagementMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $macId;
    int label;

    public ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1(String r1, Continuation<? super ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1> r2) {
        this.$macId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$3$enrolled$1(this.$macId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        String r3 = this.$macId;
        if (r3 != null) goto L11;
        return null;
    L11:
        return Boxing.boxBoolean(t1.a.a(r3));
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
