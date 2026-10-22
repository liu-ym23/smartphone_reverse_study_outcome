package com.obric.assistant.settings.voiceprint;

import com.obric.assistant.impl.databinding.ObricFragmentVoicePrintManagementBinding;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1", f = "ObricVoicePrintManagementMainFragment.kt", i = {1}, l = {464, 468}, m = "invokeSuspend", n = {"isVoicePrintExisted"}, s = {"Z$0"})
final class ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ ObricVoicePrintManagementMainFragment this$0;

    public ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1(ObricVoicePrintManagementMainFragment r1, Continuation<? super ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1(this.this$0, r3);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L16:
        ((Boolean) r6).booleanValue();
        ObricVoicePrintManagementMainFragment r7 = this.this$0;
        ObricVoicePrintManagementMainFragment.U90(r7);
        ObricFragmentVoicePrintManagementBinding r8 = r7.e;
        if (r8 == null) goto L21;
        r8.e.setVisibility(8);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        boolean r9 = ((Boolean) r6).booleanValue();
        ObricVoicePrintManagementMainFragment r2 = this.this$0;
        this.Z$0 = r9;
        this.label = 2;
        CoroutineScope r10 = ObricVoicePrintManagementMainFragment.l;
        r2.getClass();
        r6 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$2(r2, null), this);
        if (r6 != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1$isVoicePrintExisted$1 r3 = new ObricVoicePrintManagementMainFragment$requestUpdateCurrentDeviceUI$1$isVoicePrintExisted$1(null);
        this.label = 1;
        r6 = BuildersKt.withContext(r11, r3, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
