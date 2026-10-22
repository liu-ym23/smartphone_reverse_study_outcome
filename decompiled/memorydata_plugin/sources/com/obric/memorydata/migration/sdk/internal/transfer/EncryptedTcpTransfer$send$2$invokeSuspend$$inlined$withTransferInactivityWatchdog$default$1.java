package com.obric.memorydata.migration.sdk.internal.transfer;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$withTransferInactivityWatchdog$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1", f = "EncryptedTcpTransfer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $callback$inlined;
    final /* synthetic */ e $connection;
    final /* synthetic */ Ref.IntRef $lastEmitPercent$inlined;
    final /* synthetic */ String $phase;
    final /* synthetic */ w $pkg$inlined;
    final /* synthetic */ OutputStream $rawOut$inlined;
    final /* synthetic */ Ref.LongRef $sentBytes$inlined;
    final /* synthetic */ long $timeoutMs;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EncryptedTcpTransfer this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1", f = "EncryptedTcpTransfer.kt", i = {0}, l = {476}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $connection;
        final /* synthetic */ AtomicLong $lastProgressNs;
        final /* synthetic */ String $phase;
        final /* synthetic */ long $timeoutNs;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(AtomicLong r3, long r4, String r6, e r7, Continuation r8) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$lastProgressNs = r3;
            this.$timeoutNs = r4;
            this.$phase = r6;
            this.$connection = r7;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r12 = new AnonymousClass1(this.$lastProgressNs, this.$timeoutNs, this.$phase, this.$connection, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0049 -> B:14:0x004c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L14:
            long r4 = System.nanoTime() - this.$lastProgressNs.get();
            if (r4 < this.$timeoutNs) goto L10;
            t.a(t.f11981a, "tcp: " + this.$phase + " timeout, idleMs=" + (r4 / TimeUtils.NANOSECONDS_PER_MILLISECOND) + ", closing socket", null, 2, null);
            e r8 = this.$connection;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
            r8.d();     // Catch: Throwable -> L19
            Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L22:
            return Unit.INSTANCE;
        L19:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
        L10:
            if (am.a(r2) == false) goto L22;
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r2;
            this.label = 1;
            if (au.a(500, r12) != r0) goto L14;
            return r0;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ AtomicLong $lastProgressNs;

        public AnonymousClass2(AtomicLong r7) {
            this.$lastProgressNs = r7;
            super(0, Intrinsics.Kotlin.class, "markProgress", "invokeSuspend$markProgress(Ljava/util/concurrent/atomic/AtomicLong;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1.access$invokeSuspend$markProgress(this.$lastProgressNs);
        }
    }

    public EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1(long r3, String r5, e r6, Continuation r7, w r8, EncryptedTcpTransfer r9, OutputStream r10, Ref.LongRef r11, Ref.IntRef r12, m r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        m r15 = (m) ZeusTransformUtils.wrapperContextForParams(r13, m.class, "com.obric.memorydata.plugin");
        this.$timeoutMs = r3;
        this.$phase = r5;
        this.$connection = r6;
        this.$pkg$inlined = r8;
        this.this$0 = r9;
        this.$rawOut$inlined = r10;
        this.$sentBytes$inlined = r11;
        this.$lastEmitPercent$inlined = r12;
        this.$callback$inlined = r15;
        super(2, r14);
    }

    public static final /* synthetic */ void access$invokeSuspend$markProgress(AtomicLong r0) {
        invokeSuspend$markProgress(r0);
    }

    private static final void invokeSuspend$markProgress(AtomicLong r2) {
        r2.set(System.nanoTime());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r16, Continuation<?> r17) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1 r1 = new EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1(this.$timeoutMs, this.$phase, this.$connection, r8, this.$pkg$inlined, this.this$0, this.$rawOut$inlined, this.$sentBytes$inlined, this.$lastEmitPercent$inlined, this.$callback$inlined);
        r1.L$0 = r16;
        return (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r13);
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AtomicLong r14 = new AtomicLong(System.nanoTime());
        bx r0 = i.a(r2, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r14, TimeUtils.NANOSECONDS_PER_MILLISECOND * this.$timeoutMs, this.$phase, this.$connection, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        Function0 r15 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r14), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r15.invoke();     // Catch: Throwable -> L19
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(this.$pkg$inlined.a()), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        FileInputStream r1 = (FileInputStream) ZeusTransformUtils.preCheckCast(r4, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        byte[] r5 = new byte[EncryptedTcpTransfer.a(this.this$0)];     // Catch: Throwable -> L14
    L7:
        int r6 = r1.read(r5);     // Catch: Throwable -> L14
        if (r6 == (-1)) goto L10;
        this.$rawOut$inlined.write(r5, 0, r6);     // Catch: Throwable -> L14
        this.$sentBytes$inlined.element += (long) r6;     // Catch: Throwable -> L14
        r15.invoke();     // Catch: Throwable -> L14
        EncryptedTcpTransfer$send$2.access$invokeSuspend$maybeEmitProgress(this.$pkg$inlined, this.$sentBytes$inlined, this.$lastEmitPercent$inlined, this.$callback$inlined);     // Catch: Throwable -> L14
        goto L7
    L10:
        this.$rawOut$inlined.flush();     // Catch: Throwable -> L14
        r15.invoke();     // Catch: Throwable -> L14
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L19
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19
        bx.a.a(r0, null, 1, null);
        return r16;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        bx.a.a(r0, null, 1, null);
        throw th;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
