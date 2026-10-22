package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.utils.l0;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraConnectionInitializer$doInit$1", f = "DoraConnectionInitializer.kt", i = {}, l = {51, 59, 64, 67}, m = "invokeSuspend", n = {}, s = {})
final class DoraConnectionInitializer$doInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraConnectionInitializer$doInit$1(Continuation<? super DoraConnectionInitializer$doInit$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraConnectionInitializer$doInit$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r9);
    L46:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r9);
    L37:
        v r10 = v.a;
        this.label = 4;
        DoraSetting.a.getClass();     // Catch: Throwable -> L40
        int r2 = l0.a;     // Catch: Throwable -> L40
        boolean r3 = ((Boolean) l0.a(Boolean.FALSE, new com.larus.dora.impl.settings.q())).booleanValue();     // Catch: Throwable -> L40
        g49.d.d("DoraConnectionInitializer", "syncDynamicQpEnableState: isEnabled=" + r3 + ", result=" + kj4.a.g().d.h(r3));     // Catch: Throwable -> L40
    L43:
        if (Unit.INSTANCE != r0) goto L46;
        return r0;
    L40:
        th = move-exception;
        g49.d.c("DoraConnectionInitializer", "syncDynamicQpEnableState failed", th);
        goto L43
    L12:
        ResultKt.throwOnFailure(r9);
    L34:
        v r11 = v.a;
        this.label = 3;
        if (v.a(r11, this) != r0) goto L37;
        return r0;
    L13:
        ResultKt.throwOnFailure(r9);
    L17:
        DoraDevice r12 = DoraAdapterExtKt.h(kj4.a.g());
        if (r12 == null) goto L34;
        String r4 = r12.mac;
        String r6 = "";
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        String r13 = r12.name;
        if (r13 == null) goto L27;
        r6 = r13;
    L27:
        if (r4.length() > 0) goto L30;
        r5 = false;
    L30:
        if (r5 == false) goto L34;
        Function1<? super Boolean, Unit> r14 = PacificInterfaceManager.a;
        this.label = 2;
        if (PacificInterfaceManager.b(r4, r6, this) != r0) goto L34;
        return r0;
    L14:
        ResultKt.throwOnFailure(r9);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L17;
        return r0;
    }
}
