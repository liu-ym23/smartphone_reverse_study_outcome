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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.MigrationLocalPackageKit$exportToFile$3", f = "MigrationLocalPackageKit.kt", i = {0, 0, 0}, l = {40}, m = "invokeSuspend", n = {"$this$withContext", "backupDir", "packageFile"}, s = {"L$0", "L$1", "L$2"})
final class MigrationLocalPackageKit$exportToFile$3 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends File>>, Object> {
    final /* synthetic */ b $backupConfig;
    final /* synthetic */ m $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ File $destFile;
    final /* synthetic */ String $password;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    MigrationLocalPackageKit$exportToFile$3(Context r3, m r4, b r5, String r6, File r7, Continuation<? super MigrationLocalPackageKit$exportToFile$3> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.$callback = r10;
        this.$backupConfig = r5;
        this.$password = r6;
        this.$destFile = r7;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        MigrationLocalPackageKit$exportToFile$3 r12 = new MigrationLocalPackageKit$exportToFile$3(this.$context, this.$callback, this.$backupConfig, this.$password, this.$destFile, r8);
        r12.L$0 = r10;
        return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends File>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends File>> r4) {
        return ((MigrationLocalPackageKit$exportToFile$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MigrationLocalPackageKit$exportToFile$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.io.File] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Boolean r3 = null;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        Ref.ObjectRef r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        File r4 = (File) ZeusTransformUtils.preCheckCast(this.L$1, File.class, "com.obric.memorydata.plugin");
        al r5 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L8
    L17:
        z r14 = (z) ZeusTransformUtils.preCheckCast(r13, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (ZeusTransformUtils.instanceOf(r14, z.b.class) == false) goto L38;
        w r15 = (w) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r14, z.b.class, "com.obric.memorydata.plugin")).a(), w.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r2.element = r15.a();     // Catch: Throwable -> L8
        File r6 = this.$destFile.getParentFile();     // Catch: Throwable -> L8
        if (r6 == null) goto L23;
        Boxing.boxBoolean(r6.mkdirs());     // Catch: Throwable -> L8
    L23:
        if (this.$destFile.exists() == false) goto L25;
        this.$destFile.delete();     // Catch: Throwable -> L8
    L25:
        s.a(s.f11980a, r15.a(), this.$destFile);     // Catch: Throwable -> L8
        m r16 = this.$callback;     // Catch: Throwable -> L8
        String r7 = this.$destFile.getAbsolutePath();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r7, "getAbsolutePath(...)");     // Catch: Throwable -> L8
        r16.onEvent((p) ZeusTransformUtils.preCheckCast(new p.a("local_package", r7, this.$destFile.length()), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.SUCCESS, "导出成功"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        r13 = (z) ZeusTransformUtils.preCheckCast(new z.b(this.$destFile), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L28
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r4)));     // Catch: Throwable -> L28
    L30:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L35
        File r18 = (File) ZeusTransformUtils.preCheckCast(r2.element, File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r18 == null) goto L33;
        r3 = Boxing.boxBoolean(r18.delete());     // Catch: Throwable -> L35
    L33:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L35
    L64:
        return r13;
    L28:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    L38:
        if (ZeusTransformUtils.instanceOf(r14, z.a.class) == false) goto L52;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r4)));     // Catch: Throwable -> L41
    L81:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L48
        File r111 = (File) ZeusTransformUtils.preCheckCast(r2.element, File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        if (r111 == null) goto L46;
        r3 = Boxing.boxBoolean(r111.delete());     // Catch: Throwable -> L48
    L46:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L48
    L50:
        return r14;
    L48:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L41:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L81
    L52:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L8
    L8:
        th = th;
    L89:
        t.f11981a.a("local package export failed", th);     // Catch: Throwable -> L65
        o r11 = new o(MigrationErrorCode.OTHER, "本地数据包导出失败: " + th.getMessage(), th);     // Catch: Throwable -> L65
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.BACKING_UP, r11), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L65
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, "导出失败"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L65
        r13 = (z) ZeusTransformUtils.preCheckCast(new z.a(r11), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L65
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L58
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r4)));     // Catch: Throwable -> L58
    L60:
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L35
        File r114 = (File) ZeusTransformUtils.preCheckCast(r2.element, File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (r114 == null) goto L63;
        r3 = Boxing.boxBoolean(r114.delete());     // Catch: Throwable -> L35
    L63:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L35
    L58:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L65:
        th = move-exception;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L68
        Result.m1421constructorimpl(Boxing.boxBoolean(FilesKt.deleteRecursively(r4)));     // Catch: Throwable -> L68
    L93:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L75
        File r117 = (File) ZeusTransformUtils.preCheckCast(r2.element, File.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L75
        if (r117 == null) goto L73;
        r3 = Boxing.boxBoolean(r117.delete());     // Catch: Throwable -> L75
    L73:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L75
        throw th;
    L75:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        throw th;
    L68:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L93
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r13);
        al r118 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.internal.db.c r23 = new com.obric.memorydata.migration.sdk.internal.db.c((com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.migration.sdk.internal.file.a(this.$context, null, null, 6, null), com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin"), null, 2, null);
        com.obric.memorydata.migration.sdk.internal.archive.a r24 = new com.obric.memorydata.migration.sdk.internal.archive.a(0, 1, null);
        File r25 = new File(this.$context.getCacheDir(), "migration_local_export_" + System.currentTimeMillis());
        Ref.ObjectRef r26 = new Ref.ObjectRef();
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.BACKING_UP, "导出本地数据包"), p.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L53
        s.a(s.f11980a, r25);     // Catch: Throwable -> L53
        r23.a(this.$context, this.$backupConfig, r25);     // Catch: Throwable -> L53
        s.a(s.f11980a, this.$context, this.$backupConfig, r25);     // Catch: Throwable -> L53
        byte[] r27 = s.a(s.f11980a, this.$password);     // Catch: Throwable -> L53
        m r28 = this.$callback;     // Catch: Throwable -> L53
        Continuation<? super z<w>> r29 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L53
        this.L$0 = r118;     // Catch: Throwable -> L53
        this.L$1 = r25;     // Catch: Throwable -> L53
        this.L$2 = r26;     // Catch: Throwable -> L53
        this.label = 1;     // Catch: Throwable -> L53
        r13 = r24.a(r25, r28, r27, r29);     // Catch: Throwable -> L53
        if (r13 != r0) goto L16;
        return r0;
    L16:
        r4 = r25;
        r2 = r26;
    L53:
        th = th;
        r4 = r25;
        r2 = r26;
    L35:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L64
    }
}
