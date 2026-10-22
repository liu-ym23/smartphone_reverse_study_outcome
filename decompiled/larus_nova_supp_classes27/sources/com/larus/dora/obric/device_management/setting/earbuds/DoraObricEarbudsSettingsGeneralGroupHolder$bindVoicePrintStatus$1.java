package com.larus.dora.obric.device_management.setting.earbuds;

import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.utils.j0;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsSettingsGeneralGroupHolder$bindVoicePrintStatus$1", f = "DoraObricEarbudsSettingsGeneralGroupHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricEarbudsSettingsGeneralGroupHolder$bindVoicePrintStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ z49.b $device;
    final /* synthetic */ OCardListItem $this_bindVoicePrintStatus;
    int label;
    final /* synthetic */ DoraObricEarbudsSettingsGeneralGroupHolder this$0;

    public DoraObricEarbudsSettingsGeneralGroupHolder$bindVoicePrintStatus$1(z49.b r1, DoraObricEarbudsSettingsGeneralGroupHolder r2, OCardListItem r3, Continuation<? super DoraObricEarbudsSettingsGeneralGroupHolder$bindVoicePrintStatus$1> r4) {
        this.$device = r1;
        this.this$0 = r2;
        this.$this_bindVoicePrintStatus = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricEarbudsSettingsGeneralGroupHolder$bindVoicePrintStatus$1(this.$device, this.this$0, this.$this_bindVoicePrintStatus, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r4);
        Function1<? super Boolean, Unit> r5 = PacificInterfaceManager.a;
        String r6 = this.$device.c();
        String r0 = "";
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        String r1 = this.$device.e();
        if (r1 == null) goto L11;
        r0 = r1;
    L11:
        boolean r7 = PacificInterfaceManager.c(r6, r0);
        DoraObricEarbudsSettingsGeneralGroupHolder r2 = this.this$0;
        OCardListItem r3 = this.$this_bindVoicePrintStatus;
        int r8 = j0.a;
        if (r7 == false) goto L14;
        int r9 = 2131904044;
    L15:
        String r10 = j0.d(r9);
        int r11 = DoraObricEarbudsSettingsGeneralGroupHolder.e;
        r2.b4(r3, r10, null);
        return Unit.INSTANCE;
    L14:
        r9 = 2131904047;
        goto L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
