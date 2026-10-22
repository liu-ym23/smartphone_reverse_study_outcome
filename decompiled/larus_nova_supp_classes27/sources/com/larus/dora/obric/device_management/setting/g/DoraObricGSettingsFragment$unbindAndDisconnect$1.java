package com.larus.dora.obric.device_management.setting.g;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsFragment$unbindAndDisconnect$1", f = "DoraObricGSettingsFragment.kt", i = {}, l = {678}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGSettingsFragment$unbindAndDisconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;
    final /* synthetic */ DoraObricGSettingsFragment this$0;

    public DoraObricGSettingsFragment$unbindAndDisconnect$1(DoraObricGSettingsFragment r1, DoraDevice r2, Continuation<? super DoraObricGSettingsFragment$unbindAndDisconnect$1> r3) {
        this.this$0 = r1;
        this.$device = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricGSettingsFragment$unbindAndDisconnect$1(this.this$0, this.$device, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        FragmentActivity r5 = this.this$0.getActivity();
        if (r5 == null) goto L15;
        r5.finish();
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DoraObricGSettingsFragment r6 = this.this$0;
        int r2 = DoraObricGSettingsFragment.m;
        DoraObricGSettingsViewModel r7 = r6.aa0();
        DoraDevice r3 = this.$device;
        this.label = 1;
        if (r7.unbindAndDisconnect(r3, this) != r0) goto L11;
        return r0;
    }
}
