package com.larus.dora.impl.device.manage.settings;

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
@DebugMetadata(c = "com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsFragment$setUpPageView$1", f = "DoraDeviceSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraDeviceSettingsFragment$setUpPageView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.m $pageInfo;
    int label;
    final /* synthetic */ DoraDeviceSettingsFragment this$0;

    public DoraDeviceSettingsFragment$setUpPageView$1(DoraDeviceSettingsFragment r1, c59.m r2, Continuation<? super DoraDeviceSettingsFragment$setUpPageView$1> r3) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraDeviceSettingsFragment$setUpPageView$1(this.this$0, this.$pageInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        DoraDeviceSettingsFragment r4 = this.this$0;
        if (r4.f == null) goto L15;
        c59.m r0 = this.$pageInfo;
        e59.b r1 = (e59.b) r4.Y90().getConnectionState().getValue();     // Catch: Exception -> L12
        if (r1 != null) goto L10;
        r1 = e59.b.d.a;     // Catch: Exception -> L12
    L10:
        r4.ca0(r1, r0);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        g49.d.b("DoraDeviceSettingsFragment", "setUpPageView, e = " + e);
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
