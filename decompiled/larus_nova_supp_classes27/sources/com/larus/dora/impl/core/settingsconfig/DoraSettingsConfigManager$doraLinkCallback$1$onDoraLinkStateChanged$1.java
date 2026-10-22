package com.larus.dora.impl.core.settingsconfig;

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
@DebugMetadata(c = "com.larus.dora.impl.core.settingsconfig.DoraSettingsConfigManager$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraSettingsConfigManager.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSettingsConfigManager$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int label;

    public DoraSettingsConfigManager$doraLinkCallback$1$onDoraLinkStateChanged$1(DoraDevice r1, Continuation<? super DoraSettingsConfigManager$doraLinkCallback$1$onDoraLinkStateChanged$1> r2) {
        this.$device = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraSettingsConfigManager$doraLinkCallback$1$onDoraLinkStateChanged$1(this.$device, r3);
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
        DoraSettingsConfigManager r5 = DoraSettingsConfigManager.a;
        DoraDevice r2 = this.$device;
        r5.getClass();
        DoraSettingsConfigManager.c(r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DoraSettingsConfigManager r6 = DoraSettingsConfigManager.a;
        DoraDevice r3 = this.$device;
        this.label = 1;
        if (r6.d(r3, this) != r0) goto L11;
        return r0;
    }
}
