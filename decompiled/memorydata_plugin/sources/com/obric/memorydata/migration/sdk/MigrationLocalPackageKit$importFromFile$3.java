package com.obric.memorydata.migration.sdk;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.MigrationLocalPackageKit$importFromFile$3", f = "MigrationLocalPackageKit.kt", i = {0, 0, 0, 1, 1}, l = {90, 104}, m = "invokeSuspend", n = {"$this$withContext", "importer", "unpackDir", "$this$withContext", "unpackDir"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
final class MigrationLocalPackageKit$importFromFile$3 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ b $backupConfig;
    final /* synthetic */ m $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $password;
    final /* synthetic */ File $publicResourceRestoreDir;
    final /* synthetic */ File $sourceFile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    MigrationLocalPackageKit$importFromFile$3(Context r3, b r4, File r5, m r6, String r7, File r8, Continuation<? super MigrationLocalPackageKit$importFromFile$3> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        m r11 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.$backupConfig = r4;
        this.$sourceFile = r5;
        this.$callback = r11;
        this.$password = r7;
        this.$publicResourceRestoreDir = r8;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        MigrationLocalPackageKit$importFromFile$3 r13 = new MigrationLocalPackageKit$importFromFile$3(this.$context, this.$backupConfig, this.$sourceFile, this.$callback, this.$password, this.$publicResourceRestoreDir, r9);
        r13.L$0 = r11;
        return (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((MigrationLocalPackageKit$importFromFile$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MigrationLocalPackageKit$importFromFile$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, java.io.File] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r26) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        z r4 = null;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        File r3 = (File) ZeusTransformUtils.preCheckCast(this.L$1, File.class, "com.obric.memorydata.plugin");
        al r1 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L54
        Object r5 = r26;
    L32:
        r4 = (z) ZeusTransformUtils.preCheckCast(r5, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        m r6 = this.$callback;     // Catch: Throwable -> L54
        if (ZeusTransformUtils.instanceOf(r4, z.b.class) == false) goto L35;
        MigrationStep r7 = MigrationStep.SUCCESS;     // Catch: Throwable -> L54
    L37:
        if (ZeusTransformUtils.instanceOf(r4, z.b.class) == false) goto L39;
        String r8 = "导入成功";
    L40:
        r6.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(r7, r8), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L43
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r3)));     // Catch: Throwable -> L43
    L57:
        return r4;
    L39:
        r8 = "导入失败";
        goto L40
    L35:
        r7 = MigrationStep.FAILED;     // Catch: Throwable -> L54
        goto L37
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = (File) ZeusTransformUtils.preCheckCast(this.L$2, File.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.db.b r10 = (com.obric.memorydata.migration.sdk.internal.db.b) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.memorydata.migration.sdk.internal.db.b.class, "com.obric.memorydata.plugin");
        al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r26);     // Catch: Throwable -> L54
        al r12 = r11;
        com.obric.memorydata.migration.sdk.internal.db.b r13 = r10;
        Object r14 = r26;
    L27:
        z r15 = (z) ZeusTransformUtils.preCheckCast(r14, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (ZeusTransformUtils.instanceOf(r15, z.b.class) == false) goto L46;
        File r16 = (File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r15, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        com.obric.memorydata.migration.sdk.internal.db.d.a(r16, this.$backupConfig, this.$callback);     // Catch: Throwable -> L54
        File r17 = this.$publicResourceRestoreDir;     // Catch: Throwable -> L54
        m r18 = this.$callback;     // Catch: Throwable -> L54
        Continuation<? super z<Unit>> r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        this.L$0 = r12;     // Catch: Throwable -> L54
        this.L$1 = r3;     // Catch: Throwable -> L54
        this.L$2 = null;     // Catch: Throwable -> L54
        this.label = 2;     // Catch: Throwable -> L54
        r5 = r13.a(r16, r17, null, r18, r19);     // Catch: Throwable -> L54
        if (r5 != r0) goto L32;
        return r0;
    L46:
        if (ZeusTransformUtils.instanceOf(r15, z.a.class) == false) goto L53;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L49
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r3)));     // Catch: Throwable -> L49
    L51:
        return r15;
    L49:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L51
    L53:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L54
    L14:
        ResultKt.throwOnFailure(r26);
        al r22 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.file.a r23 = new com.obric.memorydata.migration.sdk.internal.file.a(this.$context, null, null, 6, null);
        com.obric.memorydata.migration.sdk.internal.archive.a r110 = new com.obric.memorydata.migration.sdk.internal.archive.a(0, 1, null);
        com.obric.memorydata.migration.sdk.internal.db.b r24 = new com.obric.memorydata.migration.sdk.internal.db.b(this.$context, this.$backupConfig, (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.preCheckCast(r23, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin"), null, null, 24, null);
        r3 = new File(this.$context.getCacheDir(), "migration_local_import_" + System.currentTimeMillis());
        if (this.$sourceFile.isFile() == true) goto L23;
        o r25 = new o(MigrationErrorCode.OTHER, "本地数据包不存在: " + this.$sourceFile.getAbsolutePath(), null, 4, null);     // Catch: Throwable -> L54
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r25), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
        z.a r27 = new z.a(r25);     // Catch: Throwable -> L54
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L20
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r3)));     // Catch: Throwable -> L20
    L22:
        return r27;
    L20:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    L23:
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.RESTORING, "导入本地数据包"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L54
        byte[] r111 = s.a(s.f11980a, this.$password);     // Catch: Throwable -> L54
        File r112 = this.$sourceFile;     // Catch: Throwable -> L54
        m r113 = this.$callback;     // Catch: Throwable -> L54
        Continuation<? super z<? extends File>> r210 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        this.L$0 = r22;     // Catch: Throwable -> L54
        this.L$1 = r24;     // Catch: Throwable -> L54
        this.L$2 = r3;     // Catch: Throwable -> L54
        this.label = 1;     // Catch: Throwable -> L54
        r14 = r110.a(r112, r3, r113, r111, r210);     // Catch: Throwable -> L54
        if (r14 != r0) goto L26;
        return r0;
    L26:
        r12 = r22;
        r13 = r24;
    L43:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L54:
        th = move-exception;
        t.f11981a.a("local package import failed", th);     // Catch: Throwable -> L58
        o r31 = new o(MigrationErrorCode.OTHER, "本地数据包导入失败: " + th.getMessage(), th);     // Catch: Throwable -> L58
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.RESTORING, r31), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L58
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, "导入失败"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L58
        r4 = (z) ZeusTransformUtils.preCheckCast(new z.a(r31), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L43
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r2)));     // Catch: Throwable -> L43
    L58:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L62
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r2)));     // Catch: Throwable -> L62
        throw th;
    L62:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    }
}
