package com.obric.memorydata.union.build.export;

import android.content.Context;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.datatransport.api.MemoryBuildExportRequest;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.s;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u000fJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005J\u001d\u0010\"\u001a\u0004\u0018\u00010\u00122\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0012J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010+J\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00112\u0006\u0010-\u001a\u00020.H\u0082@¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0005H\u0002J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\u0005042\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0002J!\u00106\u001a\b\u0012\u0004\u0012\u00020.042\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000508H\u0000¢\u0006\u0002\b9R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPackageExporter;", "", "<init>", "()V", "FILE_PREFIX", "", "RAW_OBSERVATION_ONLY_FILE_SUFFIX", "LEGACY_SCREEN_OBSERVATION_ONLY_FILE_SUFFIX", "FILE_EXTENSION", "LEGACY_FILE_EXTENSION", "PREVIEW_FILE_EXTENSION", "buildExportFileName", "suffix", "timestamp", "extension", "buildExportFileName$memory_build_obricRelease", "exportPackage", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/io/File;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "outputDir", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportPreviewPackage", "(Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportPackageWithConfig", "Lcom/obric/memorydata/union/build/export/MemoryBuildDataPackageExportResult;", "findLatestPackage", "isPackageFileName", "", "fileName", "isRawObservationOnlyPackageFileName", "pickLatestPackage", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "([Ljava/io/File;)Ljava/io/File;", "buildImportBackupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "sourceFile", "resolveExportPlan", "Lcom/obric/memorydata/union/build/export/MemoryBuildDataPackageExporter$ResolvedExportPlan;", "(Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveAutoMemoryExportPlan", "autoMemoryId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportFailure", "Lcom/obric/memorydata/migration/sdk/MigrationResult$Failure;", "message", "parseEntityIds", "", "raw", "resolveRawObservationIds", "values", "", "resolveRawObservationIds$memory_build_obricRelease", "ResolvedExportPlan", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13079a = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/union/build/export/MemoryBuildDataPackageExporter$ResolvedExportPlan;", "", "backupConfig", "Lcom/obric/memorydata/migration/sdk/BackupConfig;", "fileNameSuffix", "", "<init>", "(Lcom/obric/memorydata/migration/sdk/BackupConfig;Ljava/lang/String;)V", "getBackupConfig", "()Lcom/obric/memorydata/migration/sdk/BackupConfig;", "getFileNameSuffix", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.migration.sdk.b f13080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13081b;

        public a(com.obric.memorydata.migration.sdk.b r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "backupConfig");
            Intrinsics.checkNotNullParameter(r3, "fileNameSuffix");
            this.f13080a = r2;
            this.f13081b = r3;
        }

        public final com.obric.memorydata.migration.sdk.b a() {
            return this.f13080a;
        }

        public final String b() {
            return this.f13081b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13080a, r6.f13080a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13081b, r6.f13081b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f13080a.hashCode() * 31) + this.f13081b.hashCode();
        }

        public String toString() {
            return "ResolvedExportPlan(backupConfig=" + this.f13080a + ", fileNameSuffix=" + this.f13081b + ')';
        }
    }

    static {
        f13079a = new d();
    }

    private d() {
    }

    private final Object a(long r18, Continuation<? super z<a>> r20) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        AutoMemoryProEntity r4 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryById(r18), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        Set<String> r1 = d(r4.getEpisodicIds());
        Set<String> r2 = d(r4.getSemanticIds());
        List<ip> r6 = null;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        List<EpisodicMemoryEntity> r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityIds(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")));
    L13:
        if (r5 != null) goto L16;
        r5 = CollectionsKt.emptyList();
    L16:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L21;
        r6 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIds(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")));
    L21:
        if (r6 != null) goto L23;
        r6 = CollectionsKt.emptyList();
    L23:
        List r7 = CollectionsKt.createListBuilder();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r8.hasNext() == false) goto L27;
        r7.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r8.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getSourceRawRefIds());
        goto L25
    L27:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r9.hasNext() == false) goto L31;
        r7.add(((ip) ZeusTransformUtils.preCheckCast(r9.next(), ip.class, "com.obric.memorydata.plugin")).o());
        goto L29
    L31:
        Set<Long> r16 = a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.build(r7), Iterable.class, "com.obric.memorydata.plugin"));
        b r0 = b.f13076a;
        long r10 = r4.getId();
        long r11 = r4.getRuleId();
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L33:
        if (r14.hasNext() == false) goto L35;
        r13.add(Boxing.boxLong(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r14.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getId()));
        goto L33
    L35:
        Set r15 = (Set) ZeusTransformUtils.preCheckCast(r13, Set.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r17.iterator();
    L37:
        if (r21.hasNext() == false) goto L39;
        r19.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r21.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L37
    L39:
        Set r110 = (Set) ZeusTransformUtils.preCheckCast(r19, Set.class, "com.obric.memorydata.plugin");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L41:
        if (r24.hasNext() == false) goto L43;
        r23.add(Boxing.boxLong(((ip) ZeusTransformUtils.preCheckCast(r24.next(), ip.class, "com.obric.memorydata.plugin")).getId()));
        goto L41
    L43:
        Set r111 = (Set) ZeusTransformUtils.preCheckCast(r23, Set.class, "com.obric.memorydata.plugin");
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r25.iterator();
    L45:
        if (r27.hasNext() == false) goto L48;
        r26.add(((ip) ZeusTransformUtils.preCheckCast(r27.next(), ip.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L45
    L48:
        return new z.b(new a(r0.a(new com.obric.memorydata.union.build.export.a(r10, r11, r15, r110, r111, (Set) ZeusTransformUtils.preCheckCast(r26, Set.class, "com.obric.memorydata.plugin"), r16)), "AutoMemory_" + r4.getId() + '_'));
    L12:
        r5 = null;
        goto L13
    L5:
        return c("未找到自动记忆: " + r18);
    }

    private final Object a(MemoryBuildExportRequest r6, Continuation<? super z<a>> r7) {
        Continuation<? super z<a>> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        Long r0 = r6.getAutoMemoryId();
        if (r0 != null) goto L5;
    L8:
        com.obric.memorydata.migration.sdk.b r1 = b.f13076a.a(r6.getTimeRange(), r6.getOnlyRawObservation());
        if (r6.getOnlyRawObservation() == false) goto L11;
        String r9 = "RawObservation_";
    L13:
        return new z.b(new a(r1, r9));
    L11:
        r9 = "";
        goto L13
    L5:
        if (r0.longValue() <= 0) goto L8;
        return a(r0.longValue(), r8);
    }

    private static final boolean a(long r2) {
        if (r2 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final z.a c(String r8) {
        return new z.a(new o(MigrationErrorCode.OTHER, r8, null, 4, null));
    }

    private static final boolean c(File r2) {
        if (r2.isFile() == false) goto L7;
        d r0 = f13079a;
        String r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        if (r0.a(r3) == false) goto L7;
        return true;
    L7:
        return false;
    }

    private static final Comparable d(File r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2.lastModified()), Comparable.class, "com.obric.memorydata.plugin");
    }

    private final Set<String> d(String r12) {
        if (r12 == null) goto L5;
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L6:
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L13;
        return SetsKt.emptySet();
    L13:
        if (StringsKt.startsWith$default(r13, "[", false, 2, null) == false) goto L42;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L27
        d r11 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        JSONArray r14 = new JSONArray(r13);     // Catch: Throwable -> L27
        Set r6 = SetsKt.createSetBuilder();     // Catch: Throwable -> L27
        int r7 = r14.length();     // Catch: Throwable -> L27
        int r8 = 0;
    L15:
        if (r8 >= r7) goto L25;
        String r9 = r14.optString(r8);     // Catch: Throwable -> L27
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");     // Catch: Throwable -> L27
        String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L27
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L24;
        if (Intrinsics.areEqual(r10, "null") == true) goto L24;
        r6.add(r10);     // Catch: Throwable -> L27
    L24:
        r8 = r8 + 1;     // Catch: Throwable -> L27
        goto L15
    L19:
        r15 = false;
        goto L20
    L25:
        Object r16 = Result.m1421constructorimpl(SetsKt.build(r6));     // Catch: Throwable -> L27
    L30:
        if (Result.m1427isFailureimpl(r16) == false) goto L32;
        r16 = null;
    L32:
        Set<String> r17 = (Set) ZeusTransformUtils.preCheckCast(r16, Set.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L35;
    L38:
        boolean r19 = true;
    L39:
        if (r19 == true) goto L42;
        return r17;
    L35:
        if (r18.isEmpty() == true) goto L38;
        r19 = false;
    L27:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L42:
        if (StringsKt.startsWith$default(r13, "[", false, 2, null) == false) goto L47;
        if (StringsKt.endsWith$default(r13, "]", false, 2, null) == false) goto L47;
        r13 = r13.substring(1, StringsKt.getLastIndex((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")));
        Intrinsics.checkNotNullExpressionValue(r13, "substring(...)");
    L47:
        return (Set) ZeusTransformUtils.preCheckCast(SequencesKt.toCollection(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{',', ';', '|', '\n', '\t', ' '}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$d$YO88lxPl6AbvVLTBiZnOLHOkRU.INSTANCE), $$Lambda$d$virqh8bsqlF4HQdWMZ3SGcx63a0.INSTANCE), (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
    L5:
        r13 = null;
        goto L6
    }

    private static final Comparable e(File r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.getName(), Comparable.class, "com.obric.memorydata.plugin");
    }

    private static final String e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString(), new char[]{Typography.quote, '\''});
    }

    private static final boolean f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        if (Intrinsics.areEqual(r3, "null") == true) goto L11;
        return true;
    L11:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    private static final Sequence g(String r2) {
        Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(f13079a.d(r2), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private static final Long h(String r1) {
        Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
        return StringsKt.toLongOrNull(r1);
    }

    /* JADX INFO: renamed from: lambda$-Oj3cP7NmGFx_MSoPgD9pdrbSOA, reason: not valid java name */
    public static /* synthetic */ Long m1226lambda$Oj3cP7NmGFx_MSoPgD9pdrbSOA(String r0) {
        return h(r0);
    }

    public static /* synthetic */ Comparable lambda$3P5jgN6xeVkH_N0hChJRFBTEYMM(File r0) {
        return d(r0);
    }

    /* JADX INFO: renamed from: lambda$HOSe1stHWmTYX4jO1OiyRr-d-Dw, reason: not valid java name */
    public static /* synthetic */ boolean m1227lambda$HOSe1stHWmTYX4jO1OiyRrdDw(File r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$N-Kc8g02ju5jLZKLQQ2W5HMGnoU, reason: not valid java name */
    public static /* synthetic */ boolean m1228lambda$NKc8g02ju5jLZKLQQ2W5HMGnoU(long r0) {
        return a(r0);
    }

    public static /* synthetic */ Sequence lambda$UgsMZD03knWsjPhGjOLj02C9OeM(String r0) {
        return g(r0);
    }

    /* JADX INFO: renamed from: lambda$YO88lxPl6AbvVLTBi-ZnOLHOkRU, reason: not valid java name */
    public static /* synthetic */ String m1229lambda$YO88lxPl6AbvVLTBiZnOLHOkRU(String r0) {
        return e(r0);
    }

    public static /* synthetic */ boolean lambda$virqh8bsqlF4HQdWMZ3SGcx63a0(String r0) {
        return f(r0);
    }

    /* JADX INFO: renamed from: lambda$xtrVWPDLTAywS-zd5TjcLyAs4tE, reason: not valid java name */
    public static /* synthetic */ Comparable m1230lambda$xtrVWPDLTAywSzd5TjcLyAs4tE(File r0) {
        return e(r0);
    }

    public final File a(File r2) {
        Intrinsics.checkNotNullParameter(r2, "outputDir");
        return a(r2.listFiles($$Lambda$d$HOSe1stHWmTYX4jO1OiyRrdDw.INSTANCE));
    }

    public final File a(File[] r10) {
        if (r10 == null) goto L16;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r0 = r10.length;
        int r3 = 0;
    L4:
        boolean r4 = true;
        if (r3 >= r0) goto L21;
        File r5 = r10[r3];
        if (r5.isFile() == false) goto L11;
        d r6 = f13079a;
        String r7 = r5.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "getName(...)");
        if (r6.a(r7) == false) goto L11;
    L12:
        if (r4 == false) goto L14;
        r9.add(r5);
    L14:
        r3 = r3 + 1;
    L11:
        r4 = false;
        goto L12
    L21:
        return (File) ZeusTransformUtils.preCheckCast(CollectionsKt.maxWithOrNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{$$Lambda$d$3P5jgN6xeVkH_N0hChJRFBTEYMM.INSTANCE, $$Lambda$d$xtrVWPDLTAywSzd5TjcLyAs4tE.INSTANCE})), File.class, "com.obric.memorydata.plugin");
    L16:
        return null;
    }

    public final Object a(MemoryBuildExportRequest r6, File r7, m r8, Continuation<? super z<? extends File>> r9) {
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, MemoryBuildDataPackageExporter$exportPackage$1.class) == false) goto L7;
        MemoryBuildDataPackageExporter$exportPackage$1 r0 = (MemoryBuildDataPackageExporter$exportPackage$1) ZeusTransformUtils.preCheckCast(r11, MemoryBuildDataPackageExporter$exportPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L17:
        z r5 = (z) ZeusTransformUtils.preCheckCast(r12, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, z.b.class) == false) goto L21;
        return (z) ZeusTransformUtils.preCheckCast(new z.b(((c) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r5, z.b.class, "com.obric.memorydata.plugin")).a(), c.class, "com.obric.memorydata.plugin")).a()), z.class, "com.obric.memorydata.plugin");
    L21:
        if (ZeusTransformUtils.instanceOf(r5, z.a.class) == false) goto L24;
        return r5;
    L24:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.label = 1;
        r12 = b(r6, r7, r10, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new MemoryBuildDataPackageExporter$exportPackage$1(this, r11);
        goto L8
    }

    public final Object a(MemoryBuildExportRequest r6, File r7, Continuation<? super z<? extends File>> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, MemoryBuildDataPackageExporter$exportPreviewPackage$1.class) == false) goto L7;
        MemoryBuildDataPackageExporter$exportPreviewPackage$1 r0 = (MemoryBuildDataPackageExporter$exportPreviewPackage$1) ZeusTransformUtils.preCheckCast(r9, MemoryBuildDataPackageExporter$exportPreviewPackage$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (File) ZeusTransformUtils.preCheckCast(r0.L$1, File.class, "com.obric.memorydata.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r0.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L17:
        z r11 = (z) ZeusTransformUtils.preCheckCast(r10, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, z.a.class) == false) goto L20;
        return r11;
    L20:
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.MigrationResult.Success<com.obric.memorydata.union.build.export.MemoryBuildDataPackageExporter.ResolvedExportPlan>");
        a r12 = (a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r11, z.b.class, "com.obric.memorydata.plugin")).a(), a.class, "com.obric.memorydata.plugin");
        String r13 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        if (r7.exists() == true) goto L23;
        r7.mkdirs();
    L23:
        String r4 = r12.b();
        Intrinsics.checkNotNull(r13);
        return e.f13082a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r12.a(), new File(r7, this.a(r4, r13, ".preview.zip")));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r0.L$0 = this;
        r0.L$1 = r7;
        r0.label = 1;
        r10 = a(r6, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new MemoryBuildDataPackageExporter$exportPreviewPackage$1(this, r9);
        goto L8
    }

    public final String a(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "suffix");
        Intrinsics.checkNotNullParameter(r3, "timestamp");
        Intrinsics.checkNotNullParameter(r4, "extension");
        return "MemoryBuildDataPackage_" + r2 + r3 + r4;
    }

    public final Set<Long> a(Iterable<String> r3) {
        Iterable r2 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "values");
        return (Set) ZeusTransformUtils.preCheckCast(SequencesKt.toCollection(SequencesKt.filter(SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence(r2), $$Lambda$d$UgsMZD03knWsjPhGjOLj02C9OeM.INSTANCE), $$Lambda$d$Oj3cP7NmGFx_MSoPgD9pdrbSOA.INSTANCE), $$Lambda$d$NKc8g02ju5jLZKLQQ2W5HMGnoU.INSTANCE), (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fileName");
        if (StringsKt.startsWith$default(r4, "MemoryBuildDataPackage_", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (StringsKt.endsWith$default(r4, ".preview.zip", false, 2, null) == false) goto L9;
        return false;
    L9:
        if (StringsKt.endsWith$default(r4, ".mempkg", false, 2, null) == false) goto L11;
    L12:
        return true;
    L11:
        if (StringsKt.endsWith$default(r4, ".zip", false, 2, null) == true) goto L12;
        return false;
    }

    public final com.obric.memorydata.migration.sdk.b b(File r3) {
        Intrinsics.checkNotNullParameter(r3, "sourceFile");
        b r0 = b.f13076a;
        String r4 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "getName(...)");
        return b.a(r0, null, b(r4), 1, null);
    }

    public final Object b(MemoryBuildExportRequest r10, File r11, m r12, Continuation<? super z<c>> r13) {
        m r14 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, MemoryBuildDataPackageExporter$exportPackageWithConfig$1.class) == false) goto L7;
        MemoryBuildDataPackageExporter$exportPackageWithConfig$1 r0 = (MemoryBuildDataPackageExporter$exportPackageWithConfig$1) ZeusTransformUtils.preCheckCast(r15, MemoryBuildDataPackageExporter$exportPackageWithConfig$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        MemoryBuildDataPackageExporter$exportPackageWithConfig$1 r8 = r0;
        Object r16 = r8.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        z r9 = (z) ZeusTransformUtils.preCheckCast(r8.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
    L29:
        z r17 = (z) ZeusTransformUtils.preCheckCast(r16, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, z.b.class) == false) goto L33;
        return (z) ZeusTransformUtils.preCheckCast(new z.b(new c((File) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r17, z.b.class, "com.obric.memorydata.plugin")).a(), File.class, "com.obric.memorydata.plugin"), ((a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r9, z.b.class, "com.obric.memorydata.plugin")).a(), a.class, "com.obric.memorydata.plugin")).a())), z.class, "com.obric.memorydata.plugin");
    L33:
        if (ZeusTransformUtils.instanceOf(r17, z.a.class) == false) goto L36;
        return r17;
    L36:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r14 = (m) ZeusTransformUtils.preCheckCast(r8.L$2, m.class, "com.obric.memorydata.plugin");
        r11 = (File) ZeusTransformUtils.preCheckCast(r8.L$1, File.class, "com.obric.memorydata.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r8.L$0, d.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
    L19:
        m r7 = r14;
        z r18 = (z) ZeusTransformUtils.preCheckCast(r16, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r18, z.a.class) == false) goto L22;
        return r18;
    L22:
        String r19 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.MigrationResult.Success<com.obric.memorydata.union.build.export.MemoryBuildDataPackageExporter.ResolvedExportPlan>");
        String r110 = ((a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r18, z.b.class, "com.obric.memorydata.plugin")).a(), a.class, "com.obric.memorydata.plugin")).b();
        if (r11.exists() == true) goto L25;
        r11.mkdirs();
    L25:
        Intrinsics.checkNotNull(r19);
        File r5 = new File(r11, this.a(r110, r19, ".mempkg"));
        s r3 = s.f11980a;
        Context r20 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.migration.sdk.b r4 = ((a) ZeusTransformUtils.preCheckCast(((z.b) ZeusTransformUtils.preCheckCast(r18, z.b.class, "com.obric.memorydata.plugin")).a(), a.class, "com.obric.memorydata.plugin")).a();
        r8.L$0 = r18;
        r8.L$1 = null;
        r8.L$2 = null;
        r8.label = 2;
        r16 = r3.a(r20, r4, r5, null, r7, r8);
        if (r16 != r1) goto L28;
        return r1;
    L28:
        r9 = r18;
        goto L29
    L16:
        ResultKt.throwOnFailure(r16);
        r8.L$0 = this;
        r8.L$1 = r11;
        r8.L$2 = r14;
        r8.label = 1;
        r16 = a(r10, r8);
        if (r16 != r1) goto L19;
        return r1;
    L7:
        r0 = new MemoryBuildDataPackageExporter$exportPackageWithConfig$1(this, r15);
        goto L8
    }

    public final boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fileName");
        if (a(r4) == true) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r4, "MemoryBuildDataPackage_RawObservation_", false, 2, null) == false) goto L7;
    L8:
        return true;
    L7:
        if (StringsKt.startsWith$default(r4, "MemoryBuildDataPackage_ScreenObservation_", false, 2, null) == true) goto L8;
        return false;
    }
}
