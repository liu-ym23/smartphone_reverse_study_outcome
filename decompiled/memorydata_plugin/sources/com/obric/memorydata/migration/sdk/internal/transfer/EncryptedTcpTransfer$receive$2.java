package com.obric.memorydata.migration.sdk.internal.transfer;

import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.aa;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.q;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.File;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/MigrationPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$receive$2", f = "EncryptedTcpTransfer.kt", i = {0}, l = {580}, m = "invokeSuspend", n = {"startMs"}, s = {"J$0"})
final class EncryptedTcpTransfer$receive$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends w>>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ e $connection;
    final /* synthetic */ File $outputFile;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EncryptedTcpTransfer this$0;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11958a = null;

        static {
            int[] r0 = new int[MigrationErrorCode.values().length];
            r0[MigrationErrorCode.NO_SPACE_LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MigrationErrorCode.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11958a = r0;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class b implements Function1<Byte, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11959a = null;

        static {
            f11959a = new b();
        }

        b() {
        }

        public final CharSequence a(byte r3) {
            String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
            Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CharSequence invoke(Byte r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).byteValue());
        }
    }

    EncryptedTcpTransfer$receive$2(File r3, e r4, EncryptedTcpTransfer r5, m r6, Continuation<? super EncryptedTcpTransfer$receive$2> r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$outputFile = r3;
        this.$connection = r4;
        this.this$0 = r5;
        this.$callback = r8;
        super(2, r9);
    }

    public static final /* synthetic */ void access$invokeSuspend$lambda$5$maybeEmitProgress(long r6, Ref.IntRef r8, m r9, long r10) {
        invokeSuspend$lambda$5$maybeEmitProgress(r6, r8, (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.memorydata.plugin"), r10);
    }

    private static final void invokeSuspend$lambda$5$maybeEmitProgress(long r9, Ref.IntRef r11, m r12, long r13) {
        m r14 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.memorydata.plugin");
        if (r9 > 0) goto L5;
        return;
    L5:
        int r0 = RangesKt.coerceIn((int) ((((long) 100) * r13) / r9), 0, 100);
        if (r0 == r11.element) goto L9;
        r11.element = r0;
        r14.onEvent((p) ZeusTransformUtils.preCheckCast(new p.c(MigrationStep.TRANSFERRING, r13, r9), p.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$receive$2 r11 = new EncryptedTcpTransfer$receive$2(this.$outputFile, this.$connection, this.this$0, this.$callback, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends w>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<w>> r4) {
        return ((EncryptedTcpTransfer$receive$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$receive$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r30) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 != 1) goto L9;
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r30);     // Catch: Throwable -> L58
        Object r1 = r30;
    L49:
        z r3 = (z) ZeusTransformUtils.preCheckCast(r1, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        if (ZeusTransformUtils.instanceOf(r3, z.b.class) == false) goto L54;
        t.f11981a.a("tcp: recv done, bytes=" + ((w) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r3, z.b.class, "com.obric.memorydata.plugin")).a(), w.class, "com.obric.memorydata.plugin")).b() + ", costMs=" + (System.currentTimeMillis() - r5));     // Catch: Throwable -> L58
        return r3;
    L54:
        if (ZeusTransformUtils.instanceOf(r3, z.a.class) == false) goto L57;
        t.f11981a.a("tcp: recv result failed, code=" + ((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().a() + ", costMs=" + (System.currentTimeMillis() - r5), ((z.a) ZeusTransformUtils.preCheckCast(r3, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L58
        return r3;
    L57:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L58
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r30);
        al r4 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        r5 = System.currentTimeMillis();
        File r6 = this.$outputFile.getParentFile();     // Catch: Throwable -> L58
        if (r6 == null) goto L15;
        Boxing.boxBoolean(r6.mkdirs());     // Catch: Throwable -> L58
    L15:
        if (this.$outputFile.exists() == false) goto L17;
        this.$outputFile.delete();     // Catch: Throwable -> L58
    L17:
        Ref.LongRef r21 = new Ref.LongRef();     // Catch: Throwable -> L58
        Ref.IntRef r14 = new Ref.IntRef();     // Catch: Throwable -> L58
        r14.element = -1;     // Catch: Throwable -> L58
        t.f11981a.a("tcp: recv start");     // Catch: Throwable -> L58
        DataInputStream r15 = new DataInputStream(this.$connection.b());     // Catch: Throwable -> L58
        Pair r7 = EncryptedTcpTransfer.a(this.this$0, this.$connection, r15);     // Catch: Throwable -> L58
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(r7.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L58
        String r17 = (String) ZeusTransformUtils.preCheckCast(r7.component2(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        if (r12 <= 0) goto L35;
        long r23 = aa.f11880a.a(r12, 2.0d);     // Catch: Throwable -> L58
        File r8 = this.$outputFile.getParentFile();     // Catch: Throwable -> L58
        if (r8 != null) goto L22;
        r8 = this.$outputFile;     // Catch: Throwable -> L58
    L22:
        z<Unit> r9 = q.a(r8, r23, MigrationStep.TRANSFERRING, this.$callback, "存储空间不足，无法接收");     // Catch: Throwable -> L58
        if (ZeusTransformUtils.instanceOf(r9, z.b.class) == true) goto L35;
        if (ZeusTransformUtils.instanceOf(r9, z.a.class) == false) goto L34;
        EncryptedTcpTransfer r10 = this.this$0;     // Catch: Throwable -> L58
        e r11 = this.$connection;     // Catch: Throwable -> L58
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L29
        EncryptedTcpTransfer.a(r10, r11, new EncryptedTcpTransfer.Ack("READY", false, ((z.a) ZeusTransformUtils.preCheckCast(r9, z.a.class, "com.obric.memorydata.plugin")).a().a().name(), ((z.a) ZeusTransformUtils.preCheckCast(r9, z.a.class, "com.obric.memorydata.plugin")).a().b()));     // Catch: Throwable -> L29
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L32:
        return new z.a(((z.a) ZeusTransformUtils.preCheckCast(r9, z.a.class, "com.obric.memorydata.plugin")).a());
    L29:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L58
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L32
    L34:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L58
    L35:
        EncryptedTcpTransfer r18 = this.this$0;     // Catch: Throwable -> L58
        e r19 = this.$connection;     // Catch: Throwable -> L58
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L38
        EncryptedTcpTransfer.a(r18, r19, new EncryptedTcpTransfer.Ack("READY", true, null, null, 12, null));     // Catch: Throwable -> L38
        Object r22 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L41:
        if (Result.m1428isSuccessimpl(r22) == false) goto L43;
        Unit r24 = (Unit) ZeusTransformUtils.preCheckCast(r22, Unit.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        t.f11981a.a("tcp: recv ready ack sent");     // Catch: Throwable -> L58
    L43:
        Throwable r25 = Result.m1424exceptionOrNullimpl(r22);     // Catch: Throwable -> L58
        if (r25 == null) goto L46;
        t.f11981a.a("tcp: recv ready ack send failed", r25);     // Catch: Throwable -> L58
    L46:
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.TRANSFERRING, "传输中"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L58
        Function2 r26 = (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$receive$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1(7000, "recv", this.$connection, null, this.$outputFile, r12, this.$callback, r17, r14, this.this$0, r15, r21), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        Continuation r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        this.J$0 = r5;     // Catch: Throwable -> L58
        this.label = 1;     // Catch: Throwable -> L58
        r1 = am.a(r26, r27);     // Catch: Throwable -> L58
        if (r1 != r2) goto L49;
        return r2;
    L38:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L58
        r22 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        t.f11981a.a("tcp: recv failed", th);
        if (ZeusTransformUtils.instanceOf(th, EncryptedTcpTransfer.RemoteErrorException.class) == false) goto L67;
        MigrationErrorCode r29 = MigrationErrorCode.OTHER;
        String r31 = th.getMessage();
        if (r31 != null) goto L64;
        r31 = "对端失败";
    L64:
        o r32 = new o(r29, r31, th);
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.BACKING_UP, r32), p.class, "com.obric.memorydata.plugin"));
        return new z.a(r32);
    L67:
        if (q.a(th) == false) goto L69;
        MigrationErrorCode r33 = MigrationErrorCode.NO_SPACE_LEFT;
    L70:
        int r34 = a.f11958a[r33.ordinal()];
        if (r34 != 1) goto L73;
        StringBuilder r35 = new StringBuilder();
        String r36 = "存储空间不足，接收失败: ";
    L80:
        String r37 = r35.append(r36).append(th.getMessage()).toString();
    L81:
        o r38 = new o(r33, r37, th);
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r38), p.class, "com.obric.memorydata.plugin"));
        return (z) ZeusTransformUtils.preCheckCast(new z.a(r38), z.class, "com.obric.memorydata.plugin");
    L73:
        if (r34 == 2) goto L76;
        r35 = new StringBuilder();
        r36 = "导入导出错误: ";
        goto L80
    L76:
        if (ZeusTransformUtils.instanceOf(th, SocketTimeoutException.class) == false) goto L78;
        r37 = "等待旧机响应超时（可能旧机断网或退出）";
        goto L81
    L78:
        r35 = new StringBuilder();
        r36 = "传输中断: ";
        goto L80
    L69:
        r33 = MigrationErrorCode.DISCONNECTED;
        goto L70
    }
}
