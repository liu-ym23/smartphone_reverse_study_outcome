package com.obric.assistant.dora;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.ObricVendorBluetoothQueryDelegate;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.VendorPrivateLinkServiceImpl$refreshDeviceAsync$1", f = "VendorPrivateLinkServiceImpl.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class VendorPrivateLinkServiceImpl$refreshDeviceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VendorPrivateLinkServiceImpl this$0;

    public VendorPrivateLinkServiceImpl$refreshDeviceAsync$1(VendorPrivateLinkServiceImpl r1, Continuation<? super VendorPrivateLinkServiceImpl$refreshDeviceAsync$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        VendorPrivateLinkServiceImpl$refreshDeviceAsync$1 r0 = new VendorPrivateLinkServiceImpl$refreshDeviceAsync$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        VendorPrivateLinkServiceImpl r4 = (VendorPrivateLinkServiceImpl) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L46
    L15:
        CoWakeupApi r8 = uha.a.a();     // Catch: Throwable -> L46
        if (r8 != null) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == false) goto L23;
        r4.c.set(true);     // Catch: Throwable -> L46
        FLogger.a.i(r4.a, "refreshAsync -> isVendorDevice=true");     // Catch: Throwable -> L46
    L44:
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L48:
        VendorPrivateLinkServiceImpl r0 = this.this$0;
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L52;
        FLogger.a.e(r0.a, "refreshAsync failed: " + r11.getMessage());
    L52:
        return Unit.INSTANCE;
    L23:
        lga.a r12 = ObricVendorBluetoothQueryDelegate.b.a();     // Catch: Throwable -> L46
        if (r12 != null) goto L26;
    L28:
        boolean r5 = false;
    L29:
        if (r5 == true) goto L38;
        if (r12 != null) goto L32;
    L34:
        boolean r13 = false;
    L35:
        if (r13 == true) goto L38;
        boolean r14 = false;
    L39:
        AtomicBoolean r6 = r4.c;     // Catch: Throwable -> L46
        if (r14 == true) goto L43;
        r3 = false;
    L43:
        r6.set(r3);     // Catch: Throwable -> L46
        FLogger.a.i(r4.a, "refreshAsync -> isVendorDevice=" + r4.c);     // Catch: Throwable -> L46
        goto L44
    L32:
        if (r12.c != true) goto L34;
        r13 = true;
    L38:
        r14 = true;
        goto L39
    L26:
        if (r12.b != true) goto L28;
        r5 = true;
        goto L29
    L18:
        if (r8.b() != true) goto L20;
        r9 = true;
        goto L21
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        VendorPrivateLinkServiceImpl r16 = this.this$0;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L46
        this.L$0 = r16;     // Catch: Throwable -> L46
        this.label = 1;     // Catch: Throwable -> L46
        if (DelayKt.delay(2000, this) != r1) goto L14;
        return r1;
    L14:
        r4 = r16;
    L46:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    }
}
