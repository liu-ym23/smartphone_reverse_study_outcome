package com.obric.memorydata.migration.sdk.internal.transfer;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$withTransferInactivityWatchdog$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1", f = "EncryptedTcpTransfer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends w>>, Object> {
    final /* synthetic */ m $callback$inlined;
    final /* synthetic */ e $connection;
    final /* synthetic */ String $expectedChecksum$inlined;
    final /* synthetic */ Ref.IntRef $lastEmitPercent$inlined;
    final /* synthetic */ File $outputFile$inlined;
    final /* synthetic */ String $phase;
    final /* synthetic */ DataInputStream $rawIn$inlined;
    final /* synthetic */ Ref.LongRef $receivedBytes$inlined;
    final /* synthetic */ long $timeoutMs;
    final /* synthetic */ long $totalBytes$inlined;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EncryptedTcpTransfer this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1$2, reason: invalid class name */
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
            EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1.access$invokeSuspend$markProgress(this.$lastProgressNs);
        }
    }

    public EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1(long r6, String r8, e r9, Continuation r10, File r11, long r12, m r14, String r15, Ref.IntRef r16, EncryptedTcpTransfer r17, DataInputStream r18, Ref.LongRef r19) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        m r2 = (m) ZeusTransformUtils.wrapperContextForParams(r14, m.class, "com.obric.memorydata.plugin");
        this.$timeoutMs = r6;
        this.$phase = r8;
        this.$connection = r9;
        this.$outputFile$inlined = r11;
        this.$totalBytes$inlined = r12;
        this.$callback$inlined = r2;
        this.$expectedChecksum$inlined = r15;
        this.$lastEmitPercent$inlined = r16;
        this.this$0 = r17;
        this.$rawIn$inlined = r18;
        this.$receivedBytes$inlined = r19;
        super(2, r1);
    }

    public static final /* synthetic */ void access$invokeSuspend$markProgress(AtomicLong r0) {
        invokeSuspend$markProgress(r0);
    }

    private static final void invokeSuspend$markProgress(AtomicLong r2) {
        r2.set(System.nanoTime());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1 r1 = new EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1(this.$timeoutMs, this.$phase, this.$connection, r8, this.$outputFile$inlined, this.$totalBytes$inlined, this.$callback$inlined, this.$expectedChecksum$inlined, this.$lastEmitPercent$inlined, this.this$0, this.$rawIn$inlined, this.$receivedBytes$inlined);
        r1.L$0 = r19;
        return (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends w>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends w>> r4) {
        return ((EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0118: MOVE (r1 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:26:0x0117 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L88;
        ResultKt.throwOnFailure(r25);
        String r3 = "com.obric.memorydata.plugin";
        al r4 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        AtomicLong r1 = new AtomicLong(System.nanoTime());
        bx r2 = i.a(r4, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1, TimeUtils.NANOSECONDS_PER_MILLISECOND * this.$timeoutMs, this.$phase, this.$connection, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        Function0 r5 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r1), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L82
        EncryptedTcpTransfer$receive$2.access$invokeSuspend$lambda$5$maybeEmitProgress(this.$totalBytes$inlined, this.$lastEmitPercent$inlined, this.$callback$inlined, 0);     // Catch: Throwable -> L82
        MessageDigest r6 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: Throwable -> L82
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new DigestOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(this.$outputFile$inlined), OutputStream.class, "com.obric.memorydata.plugin"), r6), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L82
        DigestOutputStream r8 = (DigestOutputStream) ZeusTransformUtils.preCheckCast(r7, DigestOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
        int r9 = EncryptedTcpTransfer.a(this.this$0);     // Catch: Throwable -> L72
        byte[] r10 = new byte[r9];     // Catch: Throwable -> L72
        long r11 = this.$totalBytes$inlined;     // Catch: Throwable -> L72
        long r13 = 0;
        int r12 = -1;
        boolean r14 = false;
        if (r11 > 0) goto L9;
        bx r17 = r2;
        String r16 = "com.obric.memorydata.plugin";
    L89:
        int r15 = this.$rawIn$inlined.read(r10);     // Catch: Throwable -> L70
        if (r15 == (-1)) goto L27;
        r8.write(r10, 0, r15);     // Catch: Throwable -> L25
        this.$receivedBytes$inlined.element += (long) r15;     // Catch: Throwable -> L25
        r5.invoke();     // Catch: Throwable -> L25
        goto L89
    L27:
        r14 = false;
    L28:
        r8.flush();     // Catch: Throwable -> L70
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L70
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L68
        long r19 = this.$outputFile$inlined.length();     // Catch: Throwable -> L68
        long r20 = this.$totalBytes$inlined;     // Catch: Throwable -> L68
        if (r20 > 0) goto L33;
    L49:
        String r21 = r16;
        byte[] r22 = r6.digest();     // Catch: Throwable -> L68
        Intrinsics.checkNotNullExpressionValue(r22, "digest(...)");     // Catch: Throwable -> L68
        String r23 = ArraysKt.joinToString$default(r22, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, r21), null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(EncryptedTcpTransfer$receive$2.b.f11959a, Function1.class, r21), 30, null);     // Catch: Throwable -> L68
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.$expectedChecksum$inlined, CharSequence.class, r21))) == true) goto L93;
    L57:
        t r24 = t.f11981a;     // Catch: Throwable -> L68
        StringBuilder r26 = new StringBuilder().append("tcp: recv checksum verified, checksumPresent=");     // Catch: Throwable -> L68
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.$expectedChecksum$inlined, CharSequence.class, r21)) == true) goto L60;
        r14 = true;
    L60:
        r24.a(r26.append(r14).toString());     // Catch: Throwable -> L68
        long r27 = this.$totalBytes$inlined;     // Catch: Throwable -> L68
        if (r27 <= 0) goto L63;
        long r110 = r27;
    L64:
        EncryptedTcpTransfer$receive$2.access$invokeSuspend$lambda$5$maybeEmitProgress(r27, this.$lastEmitPercent$inlined, this.$callback$inlined, r110);     // Catch: Throwable -> L68
        Object r0 = ZeusTransformUtils.preCheckCast(new z.b(new w(this.$outputFile$inlined, r19, r23)), z.class, r21);     // Catch: Throwable -> L68
    L48:
        z r28 = (z) r0;     // Catch: Throwable -> L68
        bx.a.a(r17, null, 1, null);
        return r28;
    L63:
        r110 = r19;
        goto L64
    L93:
        if (StringsKt.equals(this.$expectedChecksum$inlined, r23, true) == true) goto L57;
        o r29 = new o(MigrationErrorCode.OTHER, "checksum mismatch: expected=" + this.$expectedChecksum$inlined + ", actual=" + r23, null, 4, null);     // Catch: Throwable -> L68
        this.$callback$inlined.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r29), p.class, r21));     // Catch: Throwable -> L68
        r0 = ZeusTransformUtils.preCheckCast(new z.a(r29), z.class, r21);     // Catch: Throwable -> L68
    L55:
        th = th;
        int r30 = 1;
        bx r31 = r17;
        CancellationException r32 = null;
    L85:
        bx.a.a(r31, r32, r30, r32);
        throw th;
    L33:
        if (r19 == r20) goto L49;
        if (this.$outputFile$inlined.exists() == true) goto L37;
    L38:
        r14 = true;
    L39:
        if (r14 == false) goto L41;
        MigrationErrorCode r33 = MigrationErrorCode.NO_SPACE_LEFT;     // Catch: Throwable -> L68
    L42:
        MigrationErrorCode r34 = r33;
        if (r34 != MigrationErrorCode.NO_SPACE_LEFT) goto L46;
        StringBuilder r35 = new StringBuilder().append("存储空间不足或文件被系统清理，接收失败: header=").append(this.$totalBytes$inlined).append(", out=").append(r19);     // Catch: Throwable -> L68
    L47:
        o r36 = new o(r34, r35.toString(), null, 4, null);     // Catch: Throwable -> L68
        String r37 = r16;
        this.$callback$inlined.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r36), p.class, r37));     // Catch: Throwable -> L68
        r0 = ZeusTransformUtils.preCheckCast(new z.a(r36), z.class, r37);     // Catch: Throwable -> L68
        goto L48
    L46:
        r35 = new StringBuilder().append("size mismatch: header=").append(this.$totalBytes$inlined).append(", out=").append(r19);     // Catch: Throwable -> L68
        goto L47
    L41:
        r33 = MigrationErrorCode.OTHER;     // Catch: Throwable -> L68
        goto L42
    L37:
        if (r19 >= this.$totalBytes$inlined) goto L39;
    L68:
        th = th;
        r31 = r17;
    L84:
        r32 = null;
        r30 = 1;
    L70:
        th = th;
        r31 = r17;
    L74:
        Throwable r38 = th;
    L98:
        throw r38;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        CloseableKt.closeFinally(r7, r38);     // Catch: Throwable -> L80
        throw th;     // Catch: Throwable -> L80
    L80:
        th = th;
    L9:
        if (r11 <= r13) goto L17;
        int r111 = this.$rawIn$inlined.read(r10, r14 ? 1 : 0, (int) Math.min(r9, r11));     // Catch: Throwable -> L72
        if (r111 == r12) goto L16;
        r8.write(r10, r14 ? 1 : 0, r111);     // Catch: Throwable -> L72
        bx r112 = r2;
        String r113 = r3;
        long r39 = r111;
        this.$receivedBytes$inlined.element += r39;     // Catch: Throwable -> L25
        r11 = r11 - r39;     // Catch: Throwable -> L25
        r5.invoke();     // Catch: Throwable -> L25
        EncryptedTcpTransfer$receive$2.access$invokeSuspend$lambda$5$maybeEmitProgress(this.$totalBytes$inlined, this.$lastEmitPercent$inlined, this.$callback$inlined, this.$receivedBytes$inlined.element);     // Catch: Throwable -> L25
        r3 = r113;
        r2 = r112;
        r14 = false;
        r12 = -1;
        r13 = 0;
        goto L9
    L16:
        throw new EOFException("unexpected eof");     // Catch: Throwable -> L25
    L17:
        r17 = r2;
        r16 = r3;
    L25:
        th = move-exception;
        r38 = th;
        r31 = r17;
    L72:
        th = th;
        r31 = r2;
    L82:
        th = th;
        r31 = r2;
        goto L84
    L88:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
