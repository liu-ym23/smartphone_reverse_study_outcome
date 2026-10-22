package com.obric.memorydata.migration.sdk.internal.transfer;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.migration.sdk.e;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$withTransferInactivityWatchdog$2", f = "EncryptedTcpTransfer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EncryptedTcpTransfer$withTransferInactivityWatchdog$2<T> extends SuspendLambda implements Function2<al, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Function0<Unit>, T> $block;
    final /* synthetic */ e $connection;
    final /* synthetic */ String $phase;
    final /* synthetic */ long $timeoutMs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$withTransferInactivityWatchdog$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        final /* synthetic */ AtomicLong $lastProgressNs;

        public AnonymousClass1(AtomicLong r7) {
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
            EncryptedTcpTransfer$withTransferInactivityWatchdog$2.access$invokeSuspend$markProgress(this.$lastProgressNs);
        }
    }

    public EncryptedTcpTransfer$withTransferInactivityWatchdog$2(long r3, Function1<? super Function0<Unit>, ? extends T> r5, String r6, e r7, Continuation<? super EncryptedTcpTransfer$withTransferInactivityWatchdog$2> r8) {
        Function1<Function0<Unit>, T> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$timeoutMs = r3;
        this.$block = r9;
        this.$phase = r6;
        this.$connection = r7;
        super(2, r10);
    }

    public static final /* synthetic */ void access$invokeSuspend$markProgress(AtomicLong r0) {
        invokeSuspend$markProgress(r0);
    }

    private static final void invokeSuspend$markProgress(AtomicLong r2) {
        r2.set(System.nanoTime());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$withTransferInactivityWatchdog$2 r12 = new EncryptedTcpTransfer$withTransferInactivityWatchdog$2(this.$timeoutMs, this.$block, this.$phase, this.$connection, r8);
        r12.L$0 = r10;
        return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Object r4) {
        return invoke((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(al r3, Continuation<? super T> r4) {
        return ((EncryptedTcpTransfer$withTransferInactivityWatchdog$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$withTransferInactivityWatchdog$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r13);
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AtomicLong r14 = new AtomicLong(System.nanoTime());
        long r5 = TimeUtils.NANOSECONDS_PER_MILLISECOND * this.$timeoutMs;
        bx r0 = i.a(r2, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1(r14, r5, this.$phase, this.$connection, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        T r12 = this.$block.invoke(new AnonymousClass1(r14));     // Catch: Throwable -> L8
        bx.a.a(r0, null, 1, null);
        return r12;
    L8:
        th = move-exception;
        bx.a.a(r0, null, 1, null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invokeSuspend$$forInline(Object r12) {
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AtomicLong r13 = new AtomicLong(System.nanoTime());
        long r5 = TimeUtils.NANOSECONDS_PER_MILLISECOND * this.$timeoutMs;
        bx r0 = i.a(r2, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1(r13, r5, this.$phase, this.$connection, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        T r11 = this.$block.invoke(new AnonymousClass1(r13));     // Catch: Throwable -> L6
        bx.a.a(r0, null, 1, null);
        return r11;
    L6:
        th = move-exception;
        bx.a.a(r0, null, 1, null);
        throw th;
    }
}
