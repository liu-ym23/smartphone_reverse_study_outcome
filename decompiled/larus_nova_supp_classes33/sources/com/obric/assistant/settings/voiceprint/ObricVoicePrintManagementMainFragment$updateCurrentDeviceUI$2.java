package com.obric.assistant.settings.voiceprint;

import com.obric.assistant.impl.databinding.ObricFragmentVoicePrintManagementBinding;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$2", f = "ObricVoicePrintManagementMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ ObricVoicePrintManagementMainFragment this$0;

    public ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$2(ObricVoicePrintManagementMainFragment r1, Continuation<? super ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricVoicePrintManagementMainFragment$updateCurrentDeviceUI$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r4);
        ObricVoicePrintManagementMainFragment r5 = this.this$0;
        ObricFragmentVoicePrintManagementBinding r0 = r5.e;
        if (r0 == null) goto L7;
        r5.g = Boxing.boxBoolean(false);
        ObricVoicePrintManagementMainFragment r6 = this.this$0;
        r6.h = null;
        r6.getClass();
        r0.f.setVisibility(8);
        r0.c.removeAllViews();
        return Boxing.boxBoolean(false);
    L7:
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
