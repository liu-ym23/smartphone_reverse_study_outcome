package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.r0;
import d49.c$d;
import d49.c$f;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$checkUpdates$1", f = "DoraOTAManagement.kt", i = {0, 1, 1, 1, 2, 2}, l = {659, 668, 686, 688}, m = "invokeSuspend", n = {"curDevice", "logPrefix", "device", "tryCount", "logPrefix", "device"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0", "L$1"})
public final class DoraOTAManagement$checkUpdates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAManagement$checkUpdates$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$checkUpdates$1$1", f = "DoraOTAManagement.kt", i = {0, 0}, l = {642}, m = "invokeSuspend", n = {"callback", "$this$invokeSuspend_u24lambda_u240"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DoraDevice> $curDevice;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAManagement$checkUpdates$1$1$a */
        public static final class a extends r0 {
            public final /* synthetic */ CompletableDeferred<DoraDevice> a;

            public a(CompletableDeferred<DoraDevice> r1) {
                this.a = r1;
            }

            public final void e1(DoraDevice r1, int[] r2) {
                this.a.complete(r1);
            }
        }

        public AnonymousClass1(Ref.ObjectRef<DoraDevice> r1, Continuation<? super AnonymousClass1> r2) {
            this.$curDevice = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$curDevice, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            Ref.ObjectRef<DoraDevice> r2 = (Ref.ObjectRef) this.L$2;
            kj4.a r3 = (kj4.a) this.L$1;
            a r4 = (a) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: TimeoutCancellationException -> L24
        L18:
            r2.element = r10;     // Catch: TimeoutCancellationException -> L24
        L22:
            r3.E(r4);
            return Unit.INSTANCE;
        L21:
            g49.d.b("DoraOTAManagement", "heartBeats timeout");
            goto L22
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);
            CompletableDeferred r5 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            a r6 = new a(r5);
            kj4.a r7 = kj4.a.g();
            Ref.ObjectRef<DoraDevice> r8 = this.$curDevice;
            r7.k(r6);
            mj4.f r9 = r7.c;
            DoraDevice r11 = r9.a(true);
            if (r11 == null) goto L13;
            r11.resetBudsInfo();
        L13:
            r9.d.g(1, 3, ik4.a.b());
            DoraOTAManagement$checkUpdates$1$1$1$1 r12 = new DoraOTAManagement$checkUpdates$1$1$1$1(r5, null);     // Catch: TimeoutCancellationException -> L20
            this.L$0 = r6;     // Catch: TimeoutCancellationException -> L20
            this.L$1 = r7;     // Catch: TimeoutCancellationException -> L20
            this.L$2 = r8;     // Catch: TimeoutCancellationException -> L20
            this.label = 1;     // Catch: TimeoutCancellationException -> L20
            r10 = TimeoutKt.b(3000, r12, this);     // Catch: TimeoutCancellationException -> L20
            if (r10 != r0) goto L17;
            return r0;
        L17:
            r4 = r6;
            r3 = r7;
            r2 = r8;
        L20:
            r4 = r6;
            r3 = r7;
            goto L21
        }
    }

    public DoraOTAManagement$checkUpdates$1(String r1, Continuation<? super DoraOTAManagement$checkUpdates$1> r2) {
        this.$from = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOTAManagement$checkUpdates$1(this.$from, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00ef -> B:42:0x00f2). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r15);
    L62:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        final Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$1;
        final String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
        DoraOTAManagement$checkUpdates$1 r13 = this;
    L58:
        DoraOTAManagement r8 = DoraOTAManagement.a;
        DoraDevice r9 = (DoraDevice) r2.element;
        final String r16 = r13.$from;
        Function1 r11 = new c0(r3, r2, r16);
        Function1 r12 = new d0();
        r13.L$0 = null;
        r13.L$1 = null;
        r13.label = 4;
        if (r8.C(r9, "0", r11, r12, r13) != r0) goto L62;
        return r0;
    L12:
        int r4 = this.I$0;
        Ref.ObjectRef r10 = (Ref.ObjectRef) this.L$1;
        String r14 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
        DoraOTAManagement$checkUpdates$1 r17 = this;
    L42:
        int r18 = r4 + 1;
        if (r4 <= 3) goto L45;
    L44:
        r2 = r10;
        r3 = r14;
        Object r6 = r2.element;
        if (r6 != null) goto L51;
        g49.d.b("DoraOTAManagement", r3 + " device is null");
        return Unit.INSTANCE;
    L51:
        if (o59.a.p((DoraDevice) r6) == false) goto L54;
        g49.d.d("DoraOTAManagement", r3 + " ignore doraG device");
        return Unit.INSTANCE;
    L54:
        StateFlowImpl r5 = DoraOTAManagement.e;
        c$d r7 = c$d.a;
        r17.L$0 = r3;
        r17.L$1 = r2;
        r17.label = 3;
        r5.setValue(r7);
        if (Unit.INSTANCE != r0) goto L57;
        return r0;
    L57:
        r13 = r17;
        goto L58
    L45:
        r10.element = DoraAdapterExtKt.h(kj4.a.g());
        r4 = r18;
    L28:
        DoraDevice r110 = (DoraDevice) r10.element;
        if (r110 == null) goto L31;
        String r111 = r110.softVersion;
    L32:
        if (r111 != null) goto L34;
    L37:
        boolean r112 = true;
    L38:
        if (r112 == false) goto L44;
        g49.d.d("DoraOTAManagement", "try get softVersion " + r4);
        r17.L$0 = r14;
        r17.L$1 = r10;
        r17.I$0 = r4;
        r17.label = 2;
        if (DelayKt.delay(3000, r17) != r0) goto L42;
        return r0;
    L34:
        if (r111.length() == 0) goto L37;
        r112 = false;
        goto L38
    L31:
        r111 = null;
        goto L32
    L13:
        Ref.ObjectRef r20 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r15);
    L27:
        DoraOTAManagement.F = null;
        String r113 = "checkUpdates from " + this.$from + ',';
        r10 = new Ref.ObjectRef();
        r10.element = r20.element;
        r14 = r113;
        r4 = 1;
        r17 = this;
        goto L28
    L14:
        ResultKt.throwOnFailure(r15);
        r20 = new Ref.ObjectRef();
        if (Intrinsics.areEqual(this.$from, OTAUpdateFrom.DoraLinkStateChanged.getScene()) == false) goto L17;
        BuildersKt.runBlocking$default(null, new AnonymousClass1(r20, null), 1, null);
    L19:
        if ((DoraOTAManagement.e.getValue() instanceof c$f) == false) goto L22;
        g49.d.b("DoraOTAManagement", "ota is progressing");
        return Unit.INSTANCE;
    L22:
        Job r114 = DoraOTAManagement.F;
        if (r114 == null) goto L27;
        this.L$0 = r20;
        this.label = 1;
        if (JobKt.cancelAndJoin(r114, this) != r0) goto L27;
        return r0;
    L17:
        r20.element = DoraAdapterExtKt.h(kj4.a.g());
        goto L19
    }
}
