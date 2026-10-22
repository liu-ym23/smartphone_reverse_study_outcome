package com.obric.memorydata.migration.sdk.internal.archive;

import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.aa;
import com.obric.memorydata.migration.sdk.internal.security.b;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.q;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/MigrationPackage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.archive.ZipArchive$pack$2", f = "ZipArchive.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ZipArchive$pack$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends w>>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ byte[] $dataKey;
    final /* synthetic */ File $inputDir;
    int label;
    final /* synthetic */ a this$0;

    ZipArchive$pack$2(File r3, a r4, m r5, byte[] r6, Continuation<? super ZipArchive$pack$2> r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$inputDir = r3;
        this.this$0 = r4;
        this.$callback = r8;
        this.$dataKey = r6;
        super(2, r9);
    }

    private static final CharSequence invokeSuspend$lambda$7(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$vtwj3ZfaxbPYiFWTyLvh0145z3A(byte r0) {
        return invokeSuspend$lambda$7(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ZipArchive$pack$2(this.$inputDir, this.this$0, this.$callback, this.$dataKey, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends w>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<w>> r4) {
        return ((ZipArchive$pack$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ZipArchive$pack$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L74;
        ResultKt.throwOnFailure(r23);
    L70:
        th = move-exception;
        t.f11981a.a("zip: pack failed", th);
        o r3 = new o(MigrationErrorCode.OTHER, "打包失败: " + th.getMessage(), th);
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.BACKING_UP, r3), p.class, "com.obric.memorydata.plugin"));
        return (z) ZeusTransformUtils.preCheckCast(new z.a(r3), z.class, "com.obric.memorydata.plugin");
    L6:
        if (this.$inputDir.exists() == false) goto L69;
        long r4 = a.a(this.this$0, this.$inputDir);     // Catch: Throwable -> L70
        File r0 = this.$inputDir.getParentFile();     // Catch: Throwable -> L70
        if (r0 != null) goto L10;
        r0 = this.$inputDir;     // Catch: Throwable -> L70
    L10:
        z<Unit> r5 = q.a(r0, aa.f11880a.a(r4, 2.0d), MigrationStep.BACKING_UP, this.$callback, "存储空间不足，无法打包");     // Catch: Throwable -> L70
        if (ZeusTransformUtils.instanceOf(r5, z.b.class) == false) goto L13;
        File r6 = new File(r0, "migration_" + System.currentTimeMillis() + ".zip");     // Catch: Throwable -> L70
        if (r6.exists() == false) goto L21;
        r6.delete();     // Catch: Throwable -> L70
    L21:
        MessageDigest r1 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: Throwable -> L70
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new DigestOutputStream((OutputStream) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), OutputStream.class, "com.obric.memorydata.plugin"), r1), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        a r8 = this.this$0;     // Catch: Throwable -> L70
        byte[] r9 = this.$dataKey;     // Catch: Throwable -> L70
        File r10 = this.$inputDir;     // Catch: Throwable -> L70
        DigestOutputStream r11 = (DigestOutputStream) ZeusTransformUtils.preCheckCast(r7, DigestOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        byte[] r12 = b.f11954a.a(12);     // Catch: Throwable -> L61
        r11.write(b.f11954a.b());     // Catch: Throwable -> L61
        r11.write(r12);     // Catch: Throwable -> L61
        byte[] r13 = new byte[a.a(r8)];     // Catch: Throwable -> L61
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new a.b((OutputStream) ZeusTransformUtils.preCheckCast(r11, OutputStream.class, "com.obric.memorydata.plugin"), r9, r12, a.a(r8)), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipOutputStream((OutputStream) ZeusTransformUtils.preCheckCast((a.b) ZeusTransformUtils.preCheckCast(r14, a.b.class, "com.obric.memorydata.plugin"), OutputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        ZipOutputStream r16 = (ZipOutputStream) ZeusTransformUtils.preCheckCast(r15, ZipOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Iterator r17 = ((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkTopDown(r10), Sequence.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L47
    L26:
        if (r17.hasNext() == false) goto L41;
        File r18 = (File) ZeusTransformUtils.preCheckCast(r17.next(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        if (r18.isFile() == false) goto L26;
        String r19 = FilesKt.relativeTo(r18, r10).getPath();     // Catch: Throwable -> L47
        Intrinsics.checkNotNullExpressionValue(r19, "getPath(...)");     // Catch: Throwable -> L47
        r16.putNextEntry(new ZipEntry(StringsKt.replace$default(r19, '\\', '/', false, 4, null)));     // Catch: Throwable -> L47
        Closeable r110 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r18), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        a.a(r8, (InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r110, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r16, OutputStream.class, "com.obric.memorydata.plugin"), r13);     // Catch: Throwable -> L34
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        CloseableKt.closeFinally(r110, null);     // Catch: Throwable -> L47
        r16.closeEntry();     // Catch: Throwable -> L47
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L41:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L47
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L54
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L54
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L61
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L61
        CloseableKt.closeFinally(r7, null);     // Catch: Throwable -> L70
        byte[] r24 = r1.digest();     // Catch: Throwable -> L70
        Intrinsics.checkNotNullExpressionValue(r24, "digest(...)");     // Catch: Throwable -> L70
        return (z) ZeusTransformUtils.preCheckCast(new z.b(new w(r6, r6.length(), ArraysKt.joinToString$default(r24, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$ZipArchive$pack$2$vtwj3ZfaxbPYiFWTyLvh0145z3A.INSTANCE, 30, null))), z.class, "com.obric.memorydata.plugin");
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L54
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L61
        throw th;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L13:
        if (ZeusTransformUtils.instanceOf(r5, z.a.class) == false) goto L17;
        return new z.a(((z.a) ZeusTransformUtils.preCheckCast(r5, z.a.class, "com.obric.memorydata.plugin")).a());
    L17:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L70
    L69:
        throw new IllegalArgumentException("inputDir not exists".toString());     // Catch: Throwable -> L70
    L74:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
