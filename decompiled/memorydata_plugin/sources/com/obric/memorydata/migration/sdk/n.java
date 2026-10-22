package com.obric.memorydata.migration.sdk;

import android.content.Context;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001'BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0013\u001a\u00020\u0014J8\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJH\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationClient;", "", "context", "Landroid/content/Context;", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "postRestoreHook", "Lcom/obric/memorydata/migration/sdk/PostRestoreHook;", "observer", "Lcom/obric/memorydata/migration/sdk/MigrationObserver;", "keepArtifacts", "", "addons", "", "Lcom/obric/memorydata/migration/sdk/MigrationAddon;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/migration/sdk/BackupConfig;Lcom/obric/memorydata/migration/sdk/PostRestoreHook;Lcom/obric/memorydata/migration/sdk/MigrationObserver;ZLjava/util/List;)V", "runningRunner", "Lcom/obric/memorydata/migration/sdk/internal/run/MigrationRunner;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "startSender", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "uid", "", "appVersionCode", "", "exportScope", "", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Ljava/lang/String;JLjava/lang/Integer;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startReceiverByQrText", "qrText", "clearNonRestoredTables", "options", "Lcom/obric/memorydata/migration/sdk/MigrationClient$ReceiverOptions;", "(Ljava/lang/String;Ljava/lang/String;JZLcom/obric/memorydata/migration/sdk/MigrationClient$ReceiverOptions;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newRunner", "ReceiverOptions", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f11964b;
    private final ab c;
    private final v d;
    private final boolean e;
    private final List<k> f;
    private volatile com.obric.memorydata.migration.sdk.internal.run.a g;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011RC\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationClient$ReceiverOptions;", "", "publicResourceRestoreDir", "Ljava/io/File;", "restoreTableFilter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "dbName", "tableName", "", "backupConfigOverride", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "<init>", "(Ljava/io/File;Lkotlin/jvm/functions/Function2;Lcom/obric/memorydata/migration/sdk/BackupConfig;)V", "getPublicResourceRestoreDir", "()Ljava/io/File;", "getRestoreTableFilter", "()Lkotlin/jvm/functions/Function2;", "getBackupConfigOverride", "()Lcom/obric/memorydata/migration/sdk/BackupConfig;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f11965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function2<String, String, Boolean> f11966b;
        private final b c;

        public a() {
            this(null, null, null, 7, null);
        }

        public a(File r3, Function2<? super String, ? super String, Boolean> r4, b r5) {
            Function2<String, String, Boolean> r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
            this.f11965a = r3;
            this.f11966b = r6;
            this.c = r5;
        }

        public /* synthetic */ a(File r2, Function2 r3, b r4, int r5, DefaultConstructorMarker r6) {
            Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r7 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r7, r4);
        }

        public final File a() {
            return this.f11965a;
        }

        public final Function2<String, String, Boolean> b() {
            return this.f11966b;
        }

        public final b c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11965a, r6.f11965a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11966b, r6.f11966b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            File r0 = this.f11965a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Function2<String, String, Boolean> r4 = this.f11966b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            b r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ReceiverOptions(publicResourceRestoreDir=" + this.f11965a + ", restoreTableFilter=" + this.f11966b + ", backupConfigOverride=" + this.c + ')';
        }
    }

    public n(Context r3, b r4, ab r5, v r6, boolean r7, List<? extends k> r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ab r10 = (ab) ZeusTransformUtils.wrapperContextForParams(r5, ab.class, "com.obric.memorydata.plugin");
        v r11 = (v) ZeusTransformUtils.wrapperContextForParams(r6, v.class, "com.obric.memorydata.plugin");
        List<k> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r4, "backupConfig");
        Intrinsics.checkNotNullParameter(r11, "observer");
        Intrinsics.checkNotNullParameter(r12, "addons");
        this.f11963a = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.f11964b = r4;
        this.c = r10;
        this.d = r11;
        this.e = r7;
        this.f = r12;
    }

    private final com.obric.memorydata.migration.sdk.internal.run.a b() {
        return new com.obric.memorydata.migration.sdk.internal.run.a(this.f11963a, this.f11964b, this.c, this.d, this.e, this.f);
    }

    public final Object a(String r16, long r17, Integer r19, m r20, Continuation<? super z<Unit>> r21) {
        n r1 = this;
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r20, m.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MigrationClient$startSender$1.class) == false) goto L7;
        MigrationClient$startSender$1 r3 = (MigrationClient$startSender$1) ZeusTransformUtils.preCheckCast(r0, MigrationClient$startSender$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        MigrationClient$startSender$1 r2 = r3;
        Object r4 = r2.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        r1 = (n) ZeusTransformUtils.preCheckCast(r2.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L23
    L20:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r4, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        r1.g = null;
        return r6;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r4);
        com.obric.memorydata.migration.sdk.internal.run.a r13 = b();
        r1.g = r13;
        ah r14 = new ah(r16, r17, r1.f11964b, r8, r19);     // Catch: Throwable -> L23
        r2.L$0 = r1;     // Catch: Throwable -> L23
        r2.label = 1;     // Catch: Throwable -> L23
        r4 = r13.a(r14, r2);     // Catch: Throwable -> L23
        if (r4 != r10) goto L20;
        return r10;
    L23:
        th = move-exception;
        r1.g = null;
        throw th;
    L7:
        r3 = new MigrationClient$startSender$1(this, r0);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r18, String r19, long r20, boolean r22, a r23, m r24, Continuation<? super z<Unit>> r25) {
        n r1 = this;
        m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r24, m.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, MigrationClient$startReceiverByQrText$1.class) == false) goto L7;
        MigrationClient$startReceiverByQrText$1 r3 = (MigrationClient$startReceiverByQrText$1) ZeusTransformUtils.preCheckCast(r0, MigrationClient$startReceiverByQrText$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        MigrationClient$startReceiverByQrText$1 r2 = r3;
        Object r4 = r2.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        ae r14 = null;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        r1 = (n) ZeusTransformUtils.preCheckCast(r2.L$0, n.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L14
    L40:
        z r6 = (z) ZeusTransformUtils.preCheckCast(r4, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        r1.g = null;
        return r6;
    L43:
        th = th;
        com.obric.memorydata.migration.sdk.internal.run.a r7 = 0;
    L45:
        r1.g = r7;
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r4);
        z<QrPayload> r8 = r.f11979a.a(r18, r19, r20);
        if (ZeusTransformUtils.instanceOf(r8, z.b.class) == false) goto L48;
        QrPayload r10 = (QrPayload) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r8, z.b.class, "com.obric.memorydata.plugin")).a(), QrPayload.class, "com.obric.memorydata.plugin");
        if (r23.c() == null) goto L25;
        b r11 = r23.c();
    L23:
        b r13 = r11;
    L28:
        File r15 = r23.a();
        if (r15 != null) goto L31;
        r15 = r.f11979a.a(r1.f11963a);
    L31:
        File r16 = r15;
        com.obric.memorydata.migration.sdk.internal.run.a r17 = b();
        r1.g = r17;
        d r21 = new d(r10, null, 2, null);     // Catch: Throwable -> L14
        if (r22 == false) goto L35;
        boolean r110 = true;
    L36:
        r14 = r11;
        ae r111 = new ae(r19, r20, r21, r16, r9, r13, r110);     // Catch: Throwable -> L43
        r2.L$0 = r1;     // Catch: Throwable -> L43
        r2.label = 1;     // Catch: Throwable -> L43
        r4 = r17.a(r14, r2);     // Catch: Throwable -> L43
        if (r4 != r12) goto L40;
        return r12;
    L35:
        r110 = false;
        goto L36
    L25:
        if (r23.b() == null) goto L27;
        r11 = c.a(r1.f11964b, r23.b());
        goto L23
    L27:
        r13 = null;
        goto L28
    L48:
        if (ZeusTransformUtils.instanceOf(r8, z.a.class) == false) goto L51;
        return r8;
    L51:
        throw new NoWhenBranchMatchedException();
    L14:
        th = th;
        r7 = r14;
    L7:
        r3 = new MigrationClient$startReceiverByQrText$1(r1, r0);
        goto L8
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        com.obric.memorydata.migration.sdk.internal.run.a r2 = ((n) ZeusTransformUtils.preCheckCast(this, n.class, "com.obric.memorydata.plugin")).g;     // Catch: Throwable -> L8
        if (r2 == null) goto L5;
        r2.a();     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L8
        return;
    L5:
        r3 = null;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }
}
