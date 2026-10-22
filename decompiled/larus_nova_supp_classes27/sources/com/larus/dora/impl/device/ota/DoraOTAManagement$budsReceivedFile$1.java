package com.larus.dora.impl.device.ota;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.dora.impl.util.r0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$budsReceivedFile$1", f = "DoraOTAManagement.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
final class DoraOTAManagement$budsReceivedFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ Ref.BooleanRef $isReceived;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAManagement$budsReceivedFile$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$budsReceivedFile$1$1", f = "DoraOTAManagement.kt", i = {0, 0, 0}, l = {522}, m = "invokeSuspend", n = {"crcValue", "callback", "$this$invokeSuspend_u24lambda_u240"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filePath;
        final /* synthetic */ Ref.BooleanRef $isReceived;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAManagement$budsReceivedFile$1$1$a */
        public static final class a extends r0 {
            public final /* synthetic */ CompletableDeferred<byte[]> a;

            public a(CompletableDeferred<byte[]> r1) {
                this.a = r1;
            }

            public final void J(byte[] r2) {
                this.a.complete(r2);
            }
        }

        public AnonymousClass1(Ref.BooleanRef r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$isReceived = r1;
            this.$filePath = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$isReceived, this.$filePath, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r6 = true;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$3;
            kj4.a r3 = (kj4.a) this.L$2;
            a r7 = (a) this.L$1;
            Ref.ObjectRef r8 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r14);     // Catch: TimeoutCancellationException -> L39
        L15:
            r2.element = r14;     // Catch: TimeoutCancellationException -> L39
        L19:
            r3.E(r7);
            byte[] r15 = (byte[]) r8.element;
            if (r15 == null) goto L46;
            Ref.BooleanRef r4 = this.$isReceived;
            String r5 = this.$filePath;
            if (r15.length == 5) goto L25;
        L36:
            r6 = false;
        L37:
            r4.element = r6;
            return Unit.INSTANCE;
        L25:
            if (r15[0] != 1) goto L36;
            DoraOTAManagement r9 = DoraOTAManagement.a;
            byte[] r16 = ArraysKt.sliceArray(r15, new IntRange(1, 4));
            PolarisFileInputStreamWrapper r10 = new PolarisFileInputStreamWrapper(r5);     // Catch: IOException -> L29 FileNotFoundException -> L31
            int r11 = r10.available();     // Catch: IOException -> L29 FileNotFoundException -> L31
            byte[] r12 = new byte[r11];     // Catch: IOException -> L29 FileNotFoundException -> L31
            r10.read(r12, 0, r11);     // Catch: IOException -> L29 FileNotFoundException -> L31
            r10.close();     // Catch: IOException -> L29 FileNotFoundException -> L31
            long r13 = y1.a.e(r12, r11);     // Catch: IOException -> L29 FileNotFoundException -> L31
            boolean r17 = Arrays.equals(r16, new byte[]{(byte) (r13 >> 24), (byte) (r13 >> 16), (byte) (r13 >> 8), (byte) r13});     // Catch: IOException -> L29 FileNotFoundException -> L31
        L34:
            if (r17 == false) goto L36;
        L31:
            e = move-exception;
            g49.d.c("DoraOTAManagement", "checkOtaFileReceived", e);
        L33:
            r17 = false;
        L29:
            e = move-exception;
            g49.d.c("DoraOTAManagement", "checkOtaFileReceived", e);
            goto L33
        L46:
            return null;
        L18:
            g49.d.b("DoraOTAManagement", "checkOTAState timeout");
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r14);
            Ref.ObjectRef r18 = new Ref.ObjectRef();
            CompletableDeferred r20 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            r7 = new a(r20);
            kj4.a r21 = kj4.a.g();
            r21.k(r7);
            r21.c.d.i(1, 3, new byte[]{6, 0});
            DoraOTAManagement$budsReceivedFile$1$1$1$1 r22 = new DoraOTAManagement$budsReceivedFile$1$1$1$1(r20, null);     // Catch: TimeoutCancellationException -> L17
            this.L$0 = r18;     // Catch: TimeoutCancellationException -> L17
            this.L$1 = r7;     // Catch: TimeoutCancellationException -> L17
            this.L$2 = r21;     // Catch: TimeoutCancellationException -> L17
            this.L$3 = r18;     // Catch: TimeoutCancellationException -> L17
            this.label = 1;     // Catch: TimeoutCancellationException -> L17
            Object r23 = TimeoutKt.b(3000, r22, this);     // Catch: TimeoutCancellationException -> L17
            if (r23 != r0) goto L14;
            return r0;
        L14:
            r2 = r18;
            r14 = r23;
            r3 = r21;
            r8 = r2;
        L17:
            r3 = r21;
            r8 = r18;
            goto L18
        }
    }

    public DoraOTAManagement$budsReceivedFile$1(Ref.BooleanRef r1, String r2, Continuation<? super DoraOTAManagement$budsReceivedFile$1> r3) {
        this.$isReceived = r1;
        this.$filePath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOTAManagement$budsReceivedFile$1(this.$isReceived, this.$filePath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$isReceived, this.$filePath, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r8, r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
