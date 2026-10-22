package com.obric.memorydata.datatransport.transfer.buildmemory;

import android.content.Context;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.s;
import com.obric.memorydata.migration.sdk.z;
import com.obric.memorydata.union.build.export.c;
import com.obric.memorydata.union.build.export.d;
import com.obric.memorydata.union.build.export.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u001bJ!\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 J \u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006%"}, d2 = {"Lcom/obric/memorydata/datatransport/transfer/buildmemory/MemoryBuildDataPackageHelper;", "", "<init>", "()V", "exportPackage", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importLatestPackage", "", "(Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importPackage", "sourceFile", "(Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLatestPackage", "previewFileForPackage", "packageFile", "isPackageFileName", "", "fileName", "", "isPackageFileName$data_transport_obricRelease", "isRawObservationOnlyPackageFileName", "isRawObservationOnlyPackageFileName$data_transport_obricRelease", "pickLatestPackage", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "pickLatestPackage$data_transport_obricRelease", "([Ljava/io/File;)Ljava/io/File;", "exportPreviewPackage", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "previewFile", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9812a = null;

    static {
        f9812a = new b();
    }

    private b() {
    }

    public static /* synthetic */ Object a(b r6, MemoryBuildExportRequest r7, m r8, Continuation r9, int r10, Object r11) {
        m r12 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.memorydata.plugin");
        Continuation<? super z<? extends File>> r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if ((r10 & 1) == 0) goto L6;
        r7 = new MemoryBuildExportRequest(null, false, null, 7, null);
    L6:
        if ((r10 & 2) == 0) goto L9;
        r12 = $$Lambda$b$qzVwuB85W50yaSnzIrIEQzMkOs.INSTANCE;
    L9:
        return r6.a(r7, r12, r13);
    }

    private final void a(com.obric.memorydata.migration.sdk.b r4, File r5, m r6) {
        m r3 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        z<File> r7 = e.f13082a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r5);
        if (ZeusTransformUtils.instanceOf(r7, z.b.class) == false) goto L7;
        String r8 = ((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r7, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r8, "getAbsolutePath(...)");
        Object r9 = new p.a("preview_package", r8, ((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r7, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin")).length());
    L5:
        r3.onEvent((p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L11;
        r9 = new p.b(MigrationStep.BACKING_UP, ((z.a) ZeusTransformUtils.preCheckCast(r7, z.a.class, "com.obric.memorydata.plugin")).a());
        goto L5
    L11:
        throw new NoWhenBranchMatchedException();
    }

    private static final void a(p r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
    }

    /* JADX INFO: renamed from: lambda$qzVwuB85W50yaSnzIr-IEQzMkOs, reason: not valid java name */
    public static /* synthetic */ void m647lambda$qzVwuB85W50yaSnzIrIEQzMkOs(p r0) {
        a(r0);
    }

    public final File a() {
        return d.f13079a.a(com.obric.memorydata.datatransport.api.d.f9726a.c());
    }

    public final File a(File r1) {
        Intrinsics.checkNotNullParameter(r1, "packageFile");
        return e.f13082a.a(r1);
    }

    public final Object a(MemoryBuildExportRequest r6, m r7, Continuation<? super z<? extends File>> r8) {
        m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, MemoryBuildDataPackageHelper$exportPackage$1.class) == false) goto L7;
        MemoryBuildDataPackageHelper$exportPackage$1 r0 = (MemoryBuildDataPackageHelper$exportPackage$1) ZeusTransformUtils.preCheckCast(r10, MemoryBuildDataPackageHelper$exportPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (m) ZeusTransformUtils.preCheckCast(r0.L$1, m.class, "com.obric.memorydata.plugin");
        b this = (b) ZeusTransformUtils.preCheckCast(r0.L$0, b.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L17:
        z r12 = (z) ZeusTransformUtils.preCheckCast(r11, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, z.b.class) == false) goto L21;
        this.a(((c) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r12, z.b.class, "com.obric.memorydata.plugin")).a(), c.class, "com.obric.memorydata.plugin")).b(), this.a(((c) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r12, z.b.class, "com.obric.memorydata.plugin")).a(), c.class, "com.obric.memorydata.plugin")).a()), r9);
        return (z) ZeusTransformUtils.preCheckCast(new z.b(((c) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r12, z.b.class, "com.obric.memorydata.plugin")).a(), c.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");
    L21:
        if (ZeusTransformUtils.instanceOf(r12, z.a.class) == false) goto L24;
        return r12;
    L24:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        d r13 = d.f13079a;
        File r4 = com.obric.memorydata.datatransport.api.d.f9726a.c();
        r0.L$0 = this;
        r0.L$1 = r9;
        r0.label = 1;
        r11 = r13.b(r6, r4, r9, r0);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new MemoryBuildDataPackageHelper$exportPackage$1(this, r10);
        goto L8
    }

    public final Object a(File r13, m r14, Continuation<? super z<Unit>> r15) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r14, m.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, MemoryBuildDataPackageHelper$importPackage$1.class) == false) goto L7;
        MemoryBuildDataPackageHelper$importPackage$1 r17 = (MemoryBuildDataPackageHelper$importPackage$1) ZeusTransformUtils.preCheckCast(r16, MemoryBuildDataPackageHelper$importPackage$1.class, "com.obric.memorydata.plugin");
        if ((r17.label & Integer.MIN_VALUE) == 0) goto L7;
        r17.label -= Integer.MIN_VALUE;
    L8:
        MemoryBuildDataPackageHelper$importPackage$1 r9 = r17;
        Object r12 = r9.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r9.label;
        if (r19 == 0) goto L14;
        if (r19 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L17:
        z r110 = (z) ZeusTransformUtils.preCheckCast(r12, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r110, z.b.class) == false) goto L21;
        return a.a();
    L21:
        if (ZeusTransformUtils.instanceOf(r110, z.a.class) == false) goto L24;
        return r110;
    L24:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        s r2 = s.f11980a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.b r4 = d.f13079a.b(r13);
        r9.label = 1;
        r12 = s.a(r2, r3, r4, r13, null, null, r8, r9, 16, null);
        if (r12 != r18) goto L17;
        return r18;
    L7:
        r17 = new MemoryBuildDataPackageHelper$importPackage$1(this, r16);
        goto L8
    }
}
