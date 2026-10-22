package com.obric.memorydata.migration.sdk;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011JN\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002J\f\u0010\u0019\u001a\u00020\u0013*\u00020\bH\u0002J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationLocalPackageKit;", "", "<init>", "()V", "LOCAL_KEY_SEED", "", "exportToFile", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "destFile", "password", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/BackupConfig;Ljava/io/File;Ljava/lang/String;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importFromFile", "", "sourceFile", "publicResourceRestoreDir", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/BackupConfig;Ljava/io/File;Ljava/lang/String;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deriveLocalDataKey", "", "prepareEmptyDir", "copyExtraFiles", "backupRootDir", "copyFile", "src", "dest", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f11980a = null;

    static {
        f11980a = new s();
    }

    private s() {
    }

    public static /* synthetic */ Object a(s r10, Context r11, b r12, File r13, String r14, File r15, m r16, Continuation r17, int r18, Object r19) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        m r0 = (m) ZeusTransformUtils.wrapperContextForParams(r16, m.class, "com.obric.memorydata.plugin");
        Continuation<? super z<Unit>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        if ((r18 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r18 & 16) == 0) goto L9;
        File r7 = r.f11979a.a(r3);
    L11:
        if ((r18 & 32) == 0) goto L14;
        r0 = $$Lambda$s$Daa85HymFrv5epcduiWOGaiKs0.INSTANCE;
    L14:
        return r10.a(r3, r12, r13, r6, r7, r0, r9);
    L9:
        r7 = r15;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }

    private final void a(Context r8, b r9, File r10) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        File r11 = new File(r10, WsConstants.KEY_EXTRA);
        r11.mkdirs();
        File r12 = r7.getDataDir();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L24;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r13.next(), File.class, "com.obric.memorydata.plugin");
        if (r1.exists() == false) goto L4;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L9
        Object r15 = Result.m1421constructorimpl(FilesKt.relativeTo(r1, r12).getPath());     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r15) == false) goto L14;
        r15 = null;
    L14:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L17;
        r16 = r1.getName();
    L17:
        File r2 = new File(r11, r16);
        if (r1.isDirectory() == true) goto L19;
        File r17 = r2.getParentFile();
        if (r17 == null) goto L23;
        r17.mkdirs();
    L23:
        f11980a.a(r1, r2);
        goto L4
    L19:
        FilesKt.copyRecursively$default(r1, r2, true, null, 4, null);
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void a(p r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
    }

    public static final /* synthetic */ void a(s r2, Context r3, b r4, File r5) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static final /* synthetic */ void a(s r0, File r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(s r0, File r1, File r2) {
        r0.a(r1, r2);
    }

    private final void a(File r1) {
        if (r1.exists() == false) goto L5;
        FilesKt.deleteRecursively(r1);
    L5:
        r1.mkdirs();
    }

    private final void a(File r5, File r6) {
        if (r5.exists() == true) goto L5;
        return;
    L5:
        File r4 = r6.getParentFile();
        if (r4 == null) goto L8;
        r4.mkdirs();
    L8:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r7, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r6), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        OutputStream r1 = (OutputStream) ZeusTransformUtils.preCheckCast(r9, OutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin"), r1, 0, 2, null);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r7, null);
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    public static final /* synthetic */ byte[] a(s r0, String r1) {
        return r0.a(r1);
    }

    private final byte[] a(String r2) {
        StringBuilder r1 = new StringBuilder().append("memory_migration_local_package_v1:");
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r3 = r1.append(r2).toString();
        MessageDigest r4 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);
        byte[] r5 = r3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r5, "getBytes(...)");
        byte[] r6 = r4.digest(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "digest(...)");
        return r6;
    }

    /* JADX INFO: renamed from: lambda$Daa85HymFrv5epcd-uiWOGaiKs0, reason: not valid java name */
    public static /* synthetic */ void m1042lambda$Daa85HymFrv5epcduiWOGaiKs0(p r0) {
        a(r0);
    }

    public final Object a(Context r9, b r10, File r11, String r12, m r13, Continuation<? super z<? extends File>> r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r13, m.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MigrationLocalPackageKit$exportToFile$3(r2, r3, r10, r12, r11, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final Object a(Context r13, b r14, File r15, String r16, File r17, m r18, Continuation<? super z<Unit>> r19) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r18, m.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MigrationLocalPackageKit$importFromFile$3(r3, r14, r15, r6, r16, r17, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }
}
