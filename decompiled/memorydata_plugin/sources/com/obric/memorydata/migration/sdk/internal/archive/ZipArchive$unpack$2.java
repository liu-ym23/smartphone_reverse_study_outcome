package com.obric.memorydata.migration.sdk.internal.archive;

import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.aa;
import com.obric.memorydata.migration.sdk.internal.security.b;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.q;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.archive.ZipArchive$unpack$2", f = "ZipArchive.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ZipArchive$unpack$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends File>>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ byte[] $dataKey;
    final /* synthetic */ File $encryptedPackageFile;
    final /* synthetic */ File $outputDir;
    int label;
    final /* synthetic */ a this$0;

    ZipArchive$unpack$2(File r3, File r4, m r5, a r6, byte[] r7, Continuation<? super ZipArchive$unpack$2> r8) {
        m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$encryptedPackageFile = r3;
        this.$outputDir = r4;
        this.$callback = r9;
        this.this$0 = r6;
        this.$dataKey = r7;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ZipArchive$unpack$2(this.$encryptedPackageFile, this.$outputDir, this.$callback, this.this$0, this.$dataKey, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends File>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends File>> r4) {
        return ((ZipArchive$unpack$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ZipArchive$unpack$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r28) {
        ZipArchive$unpack$2 r1 = this;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r1.label != 0) goto L152;
        ResultKt.throwOnFailure(r28);
        long r3 = r1.$encryptedPackageFile.length();     // Catch: Throwable -> L140
        long r8 = aa.f11880a.a(r3, 2.0d);     // Catch: Throwable -> L140
        File r0 = r1.$outputDir.getParentFile();     // Catch: Throwable -> L140
        if (r0 != null) goto L8;
        r0 = r1.$outputDir;     // Catch: Throwable -> L140
    L8:
        z<Unit> r2 = q.a(r0, r8, MigrationStep.TRANSFERRING, r1.$callback, "存储空间不足，无法解包");     // Catch: Throwable -> L140
        if (ZeusTransformUtils.instanceOf(r2, z.b.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r2, z.a.class) == false) goto L15;
        return new z.a(((z.a) ZeusTransformUtils.preCheckCast(r2, z.a.class, "com.obric.memorydata.plugin")).a());
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L140
    L17:
        if (r1.$outputDir.exists() == false) goto L19;
        FilesKt.deleteRecursively(r1.$outputDir);     // Catch: Throwable -> L140
    L19:
        r1.$outputDir.mkdirs();     // Catch: Throwable -> L140
        String r4 = r1.$outputDir.getCanonicalFile().getPath() + File.separator;     // Catch: Throwable -> L140
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L140
        t.f11981a.a("zip: unpack start, bytes=" + r3 + ", file=" + r1.$encryptedPackageFile.getAbsolutePath());     // Catch: Throwable -> L140
        byte[] r6 = new byte[a.a(r1.this$0)];     // Catch: Throwable -> L140
        Ref.IntRef r7 = new Ref.IntRef();     // Catch: Throwable -> L140
        Ref.LongRef r9 = new Ref.LongRef();     // Catch: Throwable -> L140
        Ref.LongRef r10 = new Ref.LongRef();     // Catch: Throwable -> L140
        r10.element = r5;     // Catch: Throwable -> L140
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r1.$encryptedPackageFile), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L140
        a r12 = r1.this$0;     // Catch: Throwable -> L140
        byte[] r13 = r1.$dataKey;     // Catch: Throwable -> L140
        File r14 = r1.$outputDir;     // Catch: Throwable -> L140
        InputStream r15 = (InputStream) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast((FileInputStream) ZeusTransformUtils.preCheckCast(r11, FileInputStream.class, "com.obric.memorydata.plugin"), InputStream.class, "com.obric.memorydata.plugin"), a.a(r12)), InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L132
        t.f11981a.a("zip: unpack read header");     // Catch: Throwable -> L132
        byte[] r16 = new byte[b.f11954a.a().length];     // Catch: Throwable -> L132
        a.a(r12, r15, r16);     // Catch: Throwable -> L132
        Ref.LongRef r29 = r10;
        boolean r17 = b.f11954a.b(r16, b.f11954a.a());     // Catch: Throwable -> L132
        byte[] r18 = r6;
        boolean r19 = b.f11954a.b(r16, b.f11954a.b());     // Catch: Throwable -> L132
        if (r17 == true) goto L28;
        if (r19 == true) goto L28;
        throw new IllegalStateException("invalid encrypted package header");     // Catch: Throwable -> L26
    L28:
        t r20 = t.f11981a;     // Catch: Throwable -> L132
        StringBuilder r110 = new StringBuilder().append("zip: unpack header magic ok, v2=");     // Catch: Throwable -> L132
        if (r19 == false) goto L31;
        boolean r111 = true;
    L32:
        r20.a(r110.append(r111).toString());     // Catch: Throwable -> L132
        byte[] r21 = new byte[12];     // Catch: Throwable -> L132
        a.a(r12, r15, r21);     // Catch: Throwable -> L132
        t.f11981a.a("zip: unpack header nonce ok");     // Catch: Throwable -> L132
        if (r19 == false) goto L36;
        InputStream r22 = (InputStream) ZeusTransformUtils.preCheckCast(new a.C0644a(r15, r13, r21, a.a(r12)), InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
    L37:
        Closeable r23 = (Closeable) ZeusTransformUtils.preCheckCast(r22, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L132
        PushbackInputStream r112 = new PushbackInputStream((InputStream) ZeusTransformUtils.preCheckCast(new BufferedInputStream((InputStream) ZeusTransformUtils.preCheckCast(r23, InputStream.class, "com.obric.memorydata.plugin"), a.a(r12)), InputStream.class, "com.obric.memorydata.plugin"), 2);     // Catch: Throwable -> L122
        byte[] r24 = new byte[2];     // Catch: Throwable -> L122
        a.a(r12, (InputStream) ZeusTransformUtils.preCheckCast(r112, InputStream.class, "com.obric.memorydata.plugin"), r24);     // Catch: Throwable -> L122
        if (r24[0] != 80) goto L119;
        if (r24[1] != 75) goto L119;
        r112.unread(r24);     // Catch: Throwable -> L122
        t.f11981a.a("zip: unpack zip signature ok");     // Catch: Throwable -> L122
        Closeable r25 = (Closeable) ZeusTransformUtils.preCheckCast(new ZipInputStream((InputStream) ZeusTransformUtils.preCheckCast(r112, InputStream.class, "com.obric.memorydata.plugin")), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L122
        ZipInputStream r113 = (ZipInputStream) ZeusTransformUtils.preCheckCast(r25, ZipInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L110
        t.f11981a.a("zip: unpack zip stream opened");     // Catch: Throwable -> L110
    L44:
        ZipEntry r114 = r113.getNextEntry();     // Catch: Throwable -> L110
        if (r114 == null) goto L47;
        r7.element++;     // Catch: Throwable -> L110
        if (r7.element != 1) goto L61;
        t.f11981a.a("zip: unpack first entry=" + r114.getName());     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        Throwable r26 = th;
        Closeable r27 = r11;
    L173:
        throw r26;     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        CloseableKt.closeFinally(r25, r26);     // Catch: Throwable -> L120
        throw th;     // Catch: Throwable -> L120
    L61:
        String r30 = r114.getName();     // Catch: Throwable -> L110
        Intrinsics.checkNotNullExpressionValue(r30, "getName(...)");     // Catch: Throwable -> L110
        String r31 = StringsKt.trimStart(StringsKt.replace$default(r30, '\\', '/', false, 4, null), new char[]{'/'});     // Catch: Throwable -> L110
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L103;
        r27 = r11;
    L108:
        th = th;
    L112:
        r26 = th;
        goto L173
    L66:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("..", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L68;
        r29 = r29;
    L105:
        ZipInputStream r115 = r113;
    L106:
        r115.closeEntry();     // Catch: Throwable -> L108
        r1 = this;
        r29 = r29;
        r113 = r115;
        r14 = r14;
        r5 = r5;
        r11 = r27;
        r18 = r18;
        goto L44
    L68:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r31, CharSequence.class, "com.obric.memorydata.plugin"), ':', false, 2, null) == true) goto L105;
        File r32 = new File(r14, r31).getCanonicalFile();     // Catch: Throwable -> L108
        String r33 = r32.getPath();     // Catch: Throwable -> L108
        Intrinsics.checkNotNullExpressionValue(r33, "getPath(...)");     // Catch: Throwable -> L108
        if (StringsKt.startsWith$default(r33, r4, false, 2, null) == false) goto L101;
        if (r114.isDirectory() == false) goto L75;
        Boxing.boxBoolean(r32.mkdirs());     // Catch: Throwable -> L108
        r29 = r29;
        r14 = r14;
        r18 = r18;
        r115 = r113;
        goto L106
    L75:
        File r34 = r32.getParentFile();     // Catch: Throwable -> L108
        if (r34 == null) goto L78;
        Boxing.boxBoolean(r34.mkdirs());     // Catch: Throwable -> L108
    L78:
        Closeable r35 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r32), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L108
        FileOutputStream r36 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r35, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L93
        byte[] r116 = r18;
    L80:
        int r117 = r113.read(r116);     // Catch: Throwable -> L93
        if (r117 < 0) goto L89;
        if (r117 == 0) goto L88;
        r36.write(r116, 0, r117);     // Catch: Throwable -> L93
        ZipInputStream r118 = r113;
        byte[] r210 = r116;
        File r119 = r14;
        r9.element += (long) r117;     // Catch: Throwable -> L93
        long r37 = System.currentTimeMillis();     // Catch: Throwable -> L93
        Ref.LongRef r120 = r29;
        if ((r37 - r120.element) < 2000) goto L86;
        r120.element = r37;     // Catch: Throwable -> L93
        t.f11981a.a("zip: unpack progress, entries=" + r7.element + ", writtenBytes=" + r9.element + ", current=" + r31);     // Catch: Throwable -> L93
    L86:
        r29 = r120;
        r113 = r118;
        r14 = r119;
        r116 = r210;
        goto L80
    L88:
        throw new IllegalStateException("zip stream read 0 bytes");     // Catch: Throwable -> L93
    L89:
        r115 = r113;
        r18 = r116;
        r14 = r14;
        r29 = r29;
        Unit r38 = Unit.INSTANCE;     // Catch: Throwable -> L93
        CloseableKt.closeFinally(r35, null);     // Catch: Throwable -> L108
        Unit r39 = Unit.INSTANCE;     // Catch: Throwable -> L108
    L93:
        th = move-exception;
        throw th;     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        CloseableKt.closeFinally(r35, th);     // Catch: Throwable -> L108
        throw th;     // Catch: Throwable -> L108
    L101:
        throw new IllegalStateException("zip path traversal detected: " + r31);     // Catch: Throwable -> L108
    L103:
        r27 = r11;
        goto L105
    L47:
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L54
        CloseableKt.closeFinally(r25, null);     // Catch: Throwable -> L52
        Unit r41 = Unit.INSTANCE;     // Catch: Throwable -> L52
        CloseableKt.closeFinally(r23, null);     // Catch: Throwable -> L26
        Unit r42 = Unit.INSTANCE;     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L140
        t.f11981a.a("zip: unpack done, entries=" + r7.element + ", writtenBytes=" + r9.element + ", costMs=" + (System.currentTimeMillis() - r5));     // Catch: Throwable -> L140
        return (z) ZeusTransformUtils.preCheckCast(new z.b(r1.$outputDir), z.class, "com.obric.memorydata.plugin");
    L52:
        th = move-exception;
        Throwable r43 = th;
        r27 = r11;
    L162:
        throw r43;     // Catch: Throwable -> L126
    L126:
        th = move-exception;
        CloseableKt.closeFinally(r23, r43);     // Catch: Throwable -> L130
        throw th;     // Catch: Throwable -> L130
    L130:
        th = th;
    L134:
        Throwable r44 = th;
    L177:
        throw r44;     // Catch: Throwable -> L136
    L136:
        th = move-exception;
        CloseableKt.closeFinally(r27, r44);     // Catch: Throwable -> L140
        throw th;     // Catch: Throwable -> L140
    L110:
        th = th;
        r27 = r11;
    L119:
        throw new IllegalStateException("invalid decrypted zip signature");     // Catch: Throwable -> L120
    L120:
        th = th;
    L124:
        r43 = th;
    L122:
        th = th;
        r27 = r11;
        goto L124
    L36:
        Cipher r45 = b.f11954a.c(r13, r21);     // Catch: Throwable -> L132
        t.f11981a.a("zip: unpack cipher init ok");     // Catch: Throwable -> L132
        r22 = (InputStream) ZeusTransformUtils.preCheckCast(new a.c(r15, r45, a.a(r12)), InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L132
        goto L37
    L31:
        r111 = false;
    L26:
        th = move-exception;
        r44 = th;
        r27 = r11;
    L132:
        th = th;
        r27 = r11;
    L140:
        th = move-exception;
        t.f11981a.a("zip: unpack failed", th);
        if (q.a(th) == false) goto L144;
        MigrationErrorCode r46 = MigrationErrorCode.NO_SPACE_LEFT;
    L146:
        if (r46 != MigrationErrorCode.NO_SPACE_LEFT) goto L148;
        StringBuilder r47 = new StringBuilder();
        String r48 = "存储空间不足，解包失败: ";
    L149:
        o r49 = new o(r46, r47.append(r48).append(th.getMessage()).toString(), th);
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r49), p.class, "com.obric.memorydata.plugin"));
        return (z) ZeusTransformUtils.preCheckCast(new z.a(r49), z.class, "com.obric.memorydata.plugin");
    L148:
        r47 = new StringBuilder();
        r48 = "解包失败: ";
        goto L149
    L144:
        r46 = MigrationErrorCode.OTHER;
        goto L146
    L152:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
