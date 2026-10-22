package com.obric.memorydata.migration.sdk.internal.run;

import android.content.Context;
import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationSecurityProtocol;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.ab;
import com.obric.memorydata.migration.sdk.ae;
import com.obric.memorydata.migration.sdk.ah;
import com.obric.memorydata.migration.sdk.b;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.internal.db.c;
import com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer;
import com.obric.memorydata.migration.sdk.k;
import com.obric.memorydata.migration.sdk.l;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.v;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010'\u001a\u00020(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020(0*2\u0006\u0010+\u001a\u00020,H\u0086@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020(0*2\u0006\u0010+\u001a\u00020/H\u0086@¢\u0006\u0002\u00100J$\u00101\u001a\b\u0012\u0004\u0012\u00020(0*2\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0082@¢\u0006\u0002\u00105J$\u00106\u001a\b\u0012\u0004\u0012\u00020(0*2\u0006\u00107\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\u0012\u00108\u001a\u00020(2\b\b\u0002\u00109\u001a\u00020\u000bH\u0002J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u0002H;0*\"\u0004\b\u0000\u0010;H\u0002J\u0010\u0010<\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/run/MigrationRunner;", "", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "postRestoreHook", "Lcom/obric/memorydata/migration/sdk/PostRestoreHook;", "observer", "Lcom/obric/memorydata/migration/sdk/MigrationObserver;", "keepArtifacts", "", "addons", "", "Lcom/obric/memorydata/migration/sdk/MigrationAddon;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/PostRestoreHook;Lcom/obric/memorydata/migration/sdk/MigrationObserver;ZLjava/util/List;)V", "fileUriMapper", "Lcom/obric/memorydata/migration/sdk/internal/file/ConfigurableFileUriMapper;", "lanConnector", "Lcom/obric/memorydata/migration/sdk/internal/net/LanConnector;", "zipArchive", "Lcom/obric/memorydata/migration/sdk/internal/archive/ZipArchive;", "transfer", "Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer;", "exporter", "Lcom/obric/memorydata/migration/sdk/internal/db/DbSnapshotExporter;", "importer", "Lcom/obric/memorydata/migration/sdk/internal/db/DbImporter;", "cancelled", "activeConnection", "Lcom/obric/memorydata/migration/sdk/Connection;", "activeServerSocket", "Ljava/net/ServerSocket;", "activeBackupDir", "Ljava/io/File;", "activeSendZip", "activeRecvZip", "activeUnpackDir", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "runSender", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "config", "Lcom/obric/memorydata/migration/sdk/SenderRunConfig;", "(Lcom/obric/memorydata/migration/sdk/SenderRunConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runReceiver", "Lcom/obric/memorydata/migration/sdk/ReceiverRunConfig;", "(Lcom/obric/memorydata/migration/sdk/ReceiverRunConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportAddons", "backupRootDir", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreAddons", "restoreDir", "cleanupArtifacts", "force", "cancelledResult", ExifInterface.GPS_DIRECTION_TRUE, "buildBackupDir", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f11949b;
    private final ab c;
    private final v d;
    private final boolean e;
    private final List<k> f;
    private final com.obric.memorydata.migration.sdk.internal.file.a g;
    private final com.obric.memorydata.migration.sdk.internal.net.a h;
    private final com.obric.memorydata.migration.sdk.internal.archive.a i;
    private final EncryptedTcpTransfer j;
    private final c k;
    private final com.obric.memorydata.migration.sdk.internal.db.b l;
    private volatile boolean m;
    private volatile e n;
    private volatile ServerSocket o;
    private volatile File p;
    private volatile File q;
    private volatile File r;
    private volatile File s;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r15, b r16, ab r17, v r18, boolean r19, List<? extends k> r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        ab r5 = (ab) ZeusTransformUtils.wrapperContextForParams(r17, ab.class, "com.obric.memorydata.plugin");
        v r4 = (v) ZeusTransformUtils.wrapperContextForParams(r18, v.class, "com.obric.memorydata.plugin");
        List<k> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r16, "backupConfig");
        Intrinsics.checkNotNullParameter(r4, "observer");
        Intrinsics.checkNotNullParameter(r6, "addons");
        Context r7 = ZeusTransformUtils.wrapperContext(r1, "com.obric.memorydata.plugin");
        this.f11948a = r7;
        this.f11949b = r16;
        this.c = r5;
        this.d = r4;
        this.e = r19;
        this.f = r6;
        com.obric.memorydata.migration.sdk.internal.file.a r2 = new com.obric.memorydata.migration.sdk.internal.file.a(r7, null, null, 6, null);
        this.g = r2;
        int r8 = 2;
        this.h = new com.obric.memorydata.migration.sdk.internal.net.a(r7, null, r8, 0 == true ? 1 : 0);
        int r9 = 0;
        this.i = new com.obric.memorydata.migration.sdk.internal.archive.a(r9, 1, 0 == true ? 1 : 0);
        Object[] r10 = 0 == true ? 1 : 0;
        this.j = new EncryptedTcpTransfer(r9, r10, 3, 0 == true ? 1 : 0);
        this.k = new c((com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin"), 0 == true ? 1 : 0, r8, 0 == true ? 1 : 0);
        Object[] r11 = 0 == true ? 1 : 0;
        this.l = new com.obric.memorydata.migration.sdk.internal.db.b(r7, r16, (com.obric.memorydata.migration.sdk.internal.file.b) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.migration.sdk.internal.file.b.class, "com.obric.memorydata.plugin"), r5, r11, 16, null);
    }

    private static final z<Unit> a(m r3, z.a r4, MigrationStep r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        c(r6, (p) ZeusTransformUtils.preCheckCast(new p.b(r5, r4.a()), p.class, "com.obric.memorydata.plugin"));
        c(r6, (p) ZeusTransformUtils.preCheckCast(new p.e(MigrationStep.FAILED, "导出失败"), p.class, "com.obric.memorydata.plugin"));
        return (z) ZeusTransformUtils.preCheckCast(r4, z.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ z a(m r1, z.a r2, MigrationStep r3, int r4, Object r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r1, m.class, "com.obric.memorydata.plugin");
        if ((r4 & 4) == 0) goto L6;
        r3 = MigrationStep.CONNECTING;
    L6:
        return a(r6, r2, r3);
    }

    private final File a(b r12) {
        File r0 = new File(this.f11948a.getCacheDir().getParentFile(), "migration_backup_" + System.currentTimeMillis());
        if (r0.exists() == false) goto L5;
        FilesKt.deleteRecursively(r0);
    L5:
        r0.mkdirs();
        this.k.a(this.f11948a, r12, r0);
        com.obric.memorydata.migration.sdk.internal.a.a.f11904a.a(this.f11948a, r12.c(), r0);
        File r1 = new File(r0, WsConstants.KEY_EXTRA);
        r1.mkdirs();
        File r2 = this.f11948a.getDataDir();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r13.hasNext() == false) goto L41;
        File r5 = (File) ZeusTransformUtils.preCheckCast(r13.next(), File.class, "com.obric.memorydata.plugin");
        if (r5.exists() == false) goto L7;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L12
        Object r6 = Result.m1421constructorimpl(FilesKt.relativeTo(r5, r2).getPath());     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r6) == false) goto L17;
        r6 = null;
    L17:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L20;
        r7 = r5.getName();
    L20:
        File r8 = new File(r1, r7);
        if (r5.isDirectory() == true) goto L22;
        File r9 = r8.getParentFile();
        if (r9 == null) goto L26;
        r9.mkdirs();
    L26:
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r11 = (FileInputStream) ZeusTransformUtils.preCheckCast(r10, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r8), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        ByteStreamsKt.copyTo$default((InputStream) ZeusTransformUtils.preCheckCast(r11, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r14, OutputStream.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r14, null);     // Catch: Throwable -> L36
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r10, null);
        goto L7
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L22:
        FilesKt.copyRecursively$default(r5, r8, true, null, 4, null);
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L41:
        return r0;
    }

    public static final /* synthetic */ File a(a r0, b r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(a r2, File r3, m r4, Continuation r5) {
        return r2.a(r3, (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00e1 -> B:12:0x006f). Please report as a decompilation issue!!! */
    private final Object a(File r10, m r11, Continuation<? super z<Unit>> r12) {
        m r13 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, MigrationRunner$exportAddons$1.class) == false) goto L7;
        MigrationRunner$exportAddons$1 r0 = (MigrationRunner$exportAddons$1) ZeusTransformUtils.preCheckCast(r14, MigrationRunner$exportAddons$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        Iterator<k> r9 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$3, Iterator.class, "com.obric.memorydata.plugin");
        File r16 = (File) ZeusTransformUtils.preCheckCast(r0.L$2, File.class, "com.obric.memorydata.plugin");
        r13 = (m) ZeusTransformUtils.preCheckCast(r0.L$1, m.class, "com.obric.memorydata.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        MigrationRunner$exportAddons$1 r8 = r0;
        File r1 = r16;
        a r17 = r4;
    L12:
        Object r5 = r2;
        MigrationRunner$exportAddons$1 r6 = r8;
        z r18 = (z) ZeusTransformUtils.preCheckCast(r15, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, z.a.class) == false) goto L33;
        return r18;
    L33:
        File r19 = r1;
        r0 = r6;
        r2 = r5;
    L21:
        if (r9.hasNext() == false) goto L35;
        k r7 = (k) ZeusTransformUtils.preCheckCast(r9.next(), k.class, "com.obric.memorydata.plugin");
        if (r17.m == true) goto L25;
        File r20 = new File(r19, l.f11962a.a(r7.a()));
        r20.mkdirs();
        Context r21 = r17.f11948a;
        r0.L$0 = r17;
        r0.L$1 = r13;
        r0.L$2 = r19;
        r0.L$3 = r9;
        r0.label = 1;
        Object r22 = r7.a(r21, r20, r13, r0);
        if (r22 != r2) goto L29;
        return r2;
    L29:
        r8 = r0;
        r1 = r19;
        r15 = r22;
        goto L12
    L25:
        return r17.b();
    L35:
        return new z.b(Unit.INSTANCE);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        if (this.f.isEmpty() == true) goto L18;
        r19 = new File(r10, "addons");
        r19.mkdirs();
        r17 = this;
        r9 = this.f.iterator();
        goto L21
    L18:
        return new z.b(Unit.INSTANCE);
    L7:
        r0 = new MigrationRunner$exportAddons$1(this, r14);
        goto L8
    }

    public static final /* synthetic */ List a(a r0) {
        return r0.f;
    }

    private static final void a(ae r1, a r2, p r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        r1.e().onEvent(r3);
        r2.d.onEvent(r3);
    }

    private static final void a(ah r1, a r2, p r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        r1.d().onEvent(r3);
        r2.d.onEvent(r3);
    }

    public static final /* synthetic */ void a(a r0, e r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ void a(a r0, File r1) {
        r0.q = r1;
    }

    public static final /* synthetic */ void a(a r0, ServerSocket r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.m = r1;
    }

    static /* synthetic */ void a(a r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    public static final /* synthetic */ void a(m r2, p r3) {
        c((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin"), r3);
    }

    private final void a(boolean r5) {
        if (r5 == true) goto L44;
        if (this.e == false) goto L44;
        return;
    L44:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        File r3 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).q;     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        Boolean r4 = Boolean.valueOf(r3.delete());     // Catch: Throwable -> L14
    L12:
        Result.m1421constructorimpl(r4);     // Catch: Throwable -> L14
    L46:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L22
        File r7 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).r;     // Catch: Throwable -> L22
        if (r7 == null) goto L19;
        Boolean r8 = Boolean.valueOf(r7.delete());     // Catch: Throwable -> L22
    L20:
        Result.m1421constructorimpl(r8);     // Catch: Throwable -> L22
    L48:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L30
        File r10 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).s;     // Catch: Throwable -> L30
        if (r10 == null) goto L27;
        Boolean r11 = Boolean.valueOf(FilesKt.deleteRecursively(r10));     // Catch: Throwable -> L30
    L28:
        Result.m1421constructorimpl(r11);     // Catch: Throwable -> L30
    L42:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L38
        File r0 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).p;     // Catch: Throwable -> L38
        if (r0 == null) goto L35;
        Boolean r1 = Boolean.valueOf(FilesKt.deleteRecursively(r0));     // Catch: Throwable -> L38
    L36:
        Result.m1421constructorimpl(r1);     // Catch: Throwable -> L38
    L40:
        this.q = null;
        this.r = null;
        this.s = null;
        this.p = null;
        return;
    L35:
        r1 = null;
    L38:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L40
    L27:
        r11 = null;
    L30:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L42
    L19:
        r8 = null;
    L22:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L48
    L11:
        r4 = null;
    L14:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L46
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.internal.net.a b(a r0) {
        return r0.h;
    }

    private final <T> z<T> b() {
        return (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "已取消", null, 4, null)), z.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object b(a r2, File r3, m r4, Continuation r5) {
        return r2.b(r3, (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x011f -> B:12:0x006f). Please report as a decompilation issue!!! */
    private final Object b(File r11, m r12, Continuation<? super z<Unit>> r13) {
        m r14 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, MigrationRunner$restoreAddons$1.class) == false) goto L7;
        MigrationRunner$restoreAddons$1 r0 = (MigrationRunner$restoreAddons$1) ZeusTransformUtils.preCheckCast(r15, MigrationRunner$restoreAddons$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        Iterator<k> r10 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$3, Iterator.class, "com.obric.memorydata.plugin");
        File r17 = (File) ZeusTransformUtils.preCheckCast(r0.L$2, File.class, "com.obric.memorydata.plugin");
        r14 = (m) ZeusTransformUtils.preCheckCast(r0.L$1, m.class, "com.obric.memorydata.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
        MigrationRunner$restoreAddons$1 r9 = r0;
        File r1 = r17;
        a r18 = r4;
    L12:
        Object r5 = r2;
        MigrationRunner$restoreAddons$1 r6 = r9;
        z r19 = (z) ZeusTransformUtils.preCheckCast(r16, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, z.a.class) == false) goto L43;
        return r19;
    L43:
        File r110 = r1;
        r0 = r6;
        r2 = r5;
    L28:
        if (r10.hasNext() == false) goto L45;
        k r7 = (k) ZeusTransformUtils.preCheckCast(r10.next(), k.class, "com.obric.memorydata.plugin");
        if (r18.m == true) goto L32;
        File r8 = new File(r110, l.f11962a.a(r7.a()));
        if (r8.exists() == true) goto L36;
        t.f11981a.a("restore: addon dir missing, skip id=" + r7.a() + " path=" + r8.getAbsolutePath());
        goto L28
    L36:
        Context r20 = r18.f11948a;
        r0.L$0 = r18;
        r0.L$1 = r14;
        r0.L$2 = r110;
        r0.L$3 = r10;
        r0.label = 1;
        Object r21 = r7.b(r20, r8, r14, r0);
        if (r21 != r2) goto L39;
        return r2;
    L39:
        r9 = r0;
        r1 = r110;
        r16 = r21;
        goto L12
    L32:
        return r18.b();
    L45:
        return new z.b(Unit.INSTANCE);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        if (this.f.isEmpty() == true) goto L18;
        r110 = new File(r11, "addons");
        if (r110.exists() == true) goto L23;
        r110 = null;
    L23:
        if (r110 == null) goto L25;
        r18 = this;
        r10 = this.f.iterator();
        goto L28
    L25:
        return new z.b(Unit.INSTANCE);
    L18:
        return new z.b(Unit.INSTANCE);
    L7:
        r0 = new MigrationRunner$restoreAddons$1(this, r15);
        goto L8
    }

    public static final /* synthetic */ void b(a r0, File r1) {
        r0.p = r1;
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void b(m r2, p r3) {
        d((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final /* synthetic */ void c(a r0, File r1) {
        r0.r = r1;
    }

    private static final void c(m r2, p r3) {
        ((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin")).onEvent(r3);
    }

    public static final /* synthetic */ boolean c(a r0) {
        return r0.m;
    }

    public static final /* synthetic */ z d(a r0) {
        return r0.b();
    }

    public static final /* synthetic */ void d(a r0, File r1) {
        r0.s = r1;
    }

    private static final void d(m r2, p r3) {
        ((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.memorydata.plugin")).onEvent(r3);
    }

    public static final /* synthetic */ EncryptedTcpTransfer e(a r0) {
        return r0.j;
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.internal.archive.a f(a r0) {
        return r0.i;
    }

    public static final /* synthetic */ e g(a r0) {
        return r0.n;
    }

    public static final /* synthetic */ ServerSocket h(a r0) {
        return r0.o;
    }

    public static final /* synthetic */ Context i(a r0) {
        return r0.f11948a;
    }

    public static final /* synthetic */ b j(a r0) {
        return r0.f11949b;
    }

    public static final /* synthetic */ com.obric.memorydata.migration.sdk.internal.db.b k(a r0) {
        return r0.l;
    }

    public static /* synthetic */ void lambda$txrv6GMVdy9TQlSZOJc6IQvzTNI(ah r0, a r1, p r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$uWjtHPrUUrYT1jBGcKaPkoX9ikQ(ae r0, a r1, p r2) {
        a(r0, r1, r2);
    }

    public final Object a(final ae r6, Continuation<? super z<Unit>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        m r0 = new $$Lambda$a$uWjtHPrUUrYT1jBGcKaPkoX9ikQ(r6, this);
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MigrationRunner$runReceiver$2(this, r6, r0, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final Object a(final ah r6, Continuation<? super z<Unit>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        m r0 = new $$Lambda$a$txrv6GMVdy9TQlSZOJc6IQvzTNI(r6, this);
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MigrationRunner$runSender$2(this, r6, r0, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final void a() {
        this.m = true;
        t r2 = t.f11981a;
        StringBuilder r3 = new StringBuilder().append("migration: cancel requested, activeProtocol=");
        e r4 = this.n;
        Unit r7 = null;
        if (ZeusTransformUtils.instanceOf(r4, e.a.class) == false) goto L5;
        e.a r5 = (e.a) ZeusTransformUtils.preCheckCast(r4, e.a.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L10;
        MigrationSecurityProtocol r6 = r5.g();
        if (r6 == null) goto L10;
        String r8 = r6.getWireVersion();
    L11:
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r2.a(r3.append(r8).toString());
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L20
        e r10 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).n;     // Catch: Throwable -> L20
        if (r10 == null) goto L17;
        r10.d();     // Catch: Throwable -> L20
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.m1421constructorimpl(r11);     // Catch: Throwable -> L20
    L46:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L33
        e r13 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).n;     // Catch: Throwable -> L33
        if (ZeusTransformUtils.instanceOf(r13, e.a.class) == false) goto L25;
        e.a r14 = (e.a) ZeusTransformUtils.preCheckCast(r13, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
    L26:
        if (r14 == null) goto L30;
        byte[] r15 = r14.f();     // Catch: Throwable -> L33
        if (r15 == null) goto L30;
        ArraysKt.fill$default(r15, (byte) 0, 0, 0, 6, null);     // Catch: Throwable -> L33
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L33
    L31:
        Result.m1421constructorimpl(r16);     // Catch: Throwable -> L33
    L44:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L40
        ServerSocket r0 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).o;     // Catch: Throwable -> L40
        if (r0 == null) goto L38;
        r0.close();     // Catch: Throwable -> L40
        r7 = Unit.INSTANCE;     // Catch: Throwable -> L40
    L38:
        Result.m1421constructorimpl(r7);     // Catch: Throwable -> L40
    L42:
        a(true);
        return;
    L40:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L30:
        r16 = null;
        goto L31
    L25:
        r14 = null;
    L33:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L44
    L17:
        r11 = null;
    L20:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L10:
        r8 = null;
        goto L11
    L5:
        r5 = null;
        goto L6
    }
}
