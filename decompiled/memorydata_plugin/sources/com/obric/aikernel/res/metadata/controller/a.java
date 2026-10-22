package com.obric.aikernel.res.metadata.controller;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonObject;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.NativeLibVersionPolicy;
import com.obric.aikernel.res.metadata.data.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0015J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bH\u0002J,\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00150\u001fH\u0002J\u0006\u0010!\u001a\u00020\u0015J\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bJ\u0006\u0010#\u001a\u00020\u0015J \u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fJ$\u0010*\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0\u000eH\u0002J\u0006\u0010,\u001a\u00020\u0015J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0.J\u0010\u0010/\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\u000fJ!\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0\u000e2\u0006\u0010%\u001a\u00020\u000fH\u0000¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020\u0015JF\u00103\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020(2\b\b\u0002\u00105\u001a\u00020(2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0\u001fJJ\u00107\u001a\u00020(2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020(2\b\b\u0002\u00105\u001a\u00020(2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020 0\u001fJ,\u0010;\u001a\u00020(2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\n\b\u0002\u0010<\u001a\u0004\u0018\u0001092\b\b\u0002\u00105\u001a\u00020(J\u0016\u0010=\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fJ\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020 H\u0002J\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u000e\u0010@\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000fJ \u0010A\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010B\u001a\u00020(J\u000e\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020 J\u001e\u0010E\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/aikernel/res/metadata/controller/MetadataController;", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "packagesListener", "Lcom/obric/aikernel/res/metadata/PackagesListener;", "(Lcom/obric/aikernel/res/PrmContext;Lcom/obric/aikernel/res/metadata/PackagesListener;)V", "cleaner", "Lcom/obric/aikernel/res/task/StorageCleanerDaemon;", "metadataMap", "Lcom/obric/aikernel/res/metadata/controller/MetadataController$MetadataMap;", "getMetadataMap$resource_manager_release", "()Lcom/obric/aikernel/res/metadata/controller/MetadataController$MetadataMap;", "packageMap", "", "", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "getPackageMap$resource_manager_release", "()Ljava/util/Map;", "refreshTask", "Lkotlinx/coroutines/Deferred;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cleanDebug", "cleanDepends", "valid", "", "cleanDepsByType", "type", "action", "Lkotlin/Function1;", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "cleanGarbage", "cleanLoras", "destroy", "disablePackage", ActivityLifecycle.NAME, "version", "corrupted", "", "enablePackage", "findLastAvailIfNeed", "versionMap", "flushPackageUsage", "getAllPackageNames", "", "getPackage", "getPackageVersions", "getPackageVersions$resource_manager_release", CommonConsts.APM_INNER_EVENT_COST_INIT, "installLibs", "force", "fastCheck", "builder", "installPackage", "cfg", "Lcom/google/gson/JsonObject;", "override", "isPackageNeedUpdate", "config", "markPackageCorrupt", "onCorrupt", "meta", "refreshPackageAvail", "setAllPackageAbove", "uninstall", "uninstallLibs", "metadata", "uninstallPackage", "Companion", "MetadataMap", "VersionMap", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0263a f6077a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PrmContext f6078b;
    private final com.obric.aikernel.res.metadata.b c;
    private final al d;
    private final Map<String, com.obric.aikernel.res.metadata.data.b> e;
    private final b f;
    private final com.obric.aikernel.res.task.b g;
    private ar<Unit> h;

    /* JADX INFO: renamed from: com.obric.aikernel.res.metadata.controller.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/res/metadata/controller/MetadataController$Companion;", "", "()V", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0263a {
        private C0263a() {
        }

        public /* synthetic */ C0263a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/aikernel/res/metadata/controller/MetadataController$MetadataMap;", "", "typeMap", "", "", "Lcom/obric/aikernel/res/metadata/controller/MetadataController$VersionMap;", "(Ljava/util/Map;)V", "getTypeMap", "()Ljava/util/Map;", "getVersionMap", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "type", ActivityLifecycle.NAME, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, c> f6079a;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public b(Map<String, c> r3) {
            Map<String, c> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "typeMap");
            this.f6079a = r4;
        }

        public /* synthetic */ b(Map r2, int r3, DefaultConstructorMarker r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        L5:
            this(r5);
        }

        public final Map<String, c> a() {
            return this.f6079a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Map<String, com.obric.aikernel.res.metadata.data.d> a(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "type");
            Intrinsics.checkNotNullParameter(r6, ActivityLifecycle.NAME);
            monitor-enter(this);
            Map<String, c> r0 = this.f6079a;     // Catch: Throwable -> L11
            c r1 = r0.get(r5);     // Catch: Throwable -> L11
            if (r1 != null) goto L7;
            Map r3 = null;
            r1 = new c(r3, 1, 0 == true ? 1 : 0);     // Catch: Throwable -> L11
            r0.put(r5, r1);     // Catch: Throwable -> L11
        L7:
            c r7 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            monitor-exit(this);
            return r7.a(r6);
        L11:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\t\u001a\u00020\u0004R)\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/metadata/controller/MetadataController$VersionMap;", "", "versionMap", "", "", "Lcom/obric/aikernel/res/metadata/data/BaseMetadata;", "(Ljava/util/Map;)V", "getVersionMap", "()Ljava/util/Map;", ActivityLifecycle.NAME, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> f6080a;

        /* JADX WARN: Multi-variable type inference failed */
        public c() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public c(Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r3) {
            Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "versionMap");
            this.f6080a = r4;
        }

        public /* synthetic */ c(Map r2, int r3, DefaultConstructorMarker r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        L5:
            this(r5);
        }

        public final Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> a() {
            return this.f6080a;
        }

        public final Map<String, com.obric.aikernel.res.metadata.data.d> a(String r5) {
            Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);
            monitor-enter(this);
            Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r0 = this.f6080a;     // Catch: Throwable -> L10
            Map<String, com.obric.aikernel.res.metadata.data.d> r1 = r0.get(r5);     // Catch: Throwable -> L10
            if (r1 != null) goto L7;
            r1 = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            r0.put(r5, r1);     // Catch: Throwable -> L10
        L7:
            Map<String, com.obric.aikernel.res.metadata.data.d> r6 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            monitor-exit(this);
            return r6;
        L10:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            String r2 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.res.metadata.data.b.a r5 = com.obric.aikernel.res.metadata.data.b.e;
            Intrinsics.checkNotNullExpressionValue(r2, "it");
            Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5.a(r2)), Comparable.class, "com.obric.memorydata.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.res.metadata.data.b.a r8 = com.obric.aikernel.res.metadata.data.b.e;
            Intrinsics.checkNotNullExpressionValue(r7, "it");
            return ComparisonsKt.compareValues(r6, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r8.a(r7)), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e<T> implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            com.obric.aikernel.res.metadata.data.d r1 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
            Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.aikernel.res.metadata.data.b.e.a(r1.t())), Comparable.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.res.metadata.data.d r5 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
            return ComparisonsKt.compareValues(r4, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.aikernel.res.metadata.data.b.e.a(r5.t())), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            com.obric.aikernel.res.metadata.data.d r1 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
            Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.aikernel.res.metadata.data.b.e.a(r1.t())), Comparable.class, "com.obric.memorydata.plugin");
            com.obric.aikernel.res.metadata.data.d r5 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
            return ComparisonsKt.compareValues(r4, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.aikernel.res.metadata.data.b.e.a(r5.t())), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public g(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            com.obric.aikernel.runtime.utils.d.f6216a.c("PResM-MetaDataController", ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin")) + " crashed " + ExceptionsKt.stackTraceToString(r3));
        }
    }

    static {
        f6077a = new C0263a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(PrmContext r6, com.obric.aikernel.res.metadata.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "packagesListener");
        this.f6078b = r6;
        this.c = r7;
        CoroutineContext r8 = new ak("PResM-MetaDataController").plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        al r9 = am.a(r8.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new g(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.d = r9;
        this.e = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.f = new b(null, 1, 0 == true ? 1 : 0);
        this.g = new com.obric.aikernel.res.task.b(r6, r9);
    }

    private final void a(PrmContext r18, String r19, Function1<? super com.obric.aikernel.res.metadata.data.d, Unit> r20) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        String r3 = "lib";
        if (Intrinsics.areEqual(r19, "lib") == false) goto L6;
        File r4 = new File(new i("", "", r18.getConfig()).w());
    L9:
        if (r4 == null) goto L30;
        String[] r7 = r4.list($$Lambda$a$0ikSXNZ4R5PntAszPZS142joeMg.INSTANCE);
        if (r7 == null) goto L36;
        int r8 = r7.length;
        int r10 = 0;
    L13:
        if (r10 >= r8) goto L37;
        String r11 = r7[r10];
        String[] r12 = new File(r4, r11).list($$Lambda$a$TqJ254QCB7XvO43PWF1vhAjpCU0.INSTANCE);
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullExpressionValue(r12, "list { f, _ -> f.isDirectory }");
        int r13 = r12.length;
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L29;
        String r15 = r12[r14];
        if (Intrinsics.areEqual(r19, r3) == false) goto L22;
        String r16 = r3;
        Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r15, "version");
        Object r5 = new i(r11, r15, r18.getConfig());
    L21:
        com.obric.aikernel.res.metadata.data.d r6 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r5, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
    L26:
        if (r6 == null) goto L28;
        r1.invoke(r6);
    L28:
        r14 = r14 + 1;
        r3 = r16;
        goto L17
    L22:
        r16 = r3;
        if (Intrinsics.areEqual(r19, "model") == false) goto L25;
        Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r15, "version");
        r5 = new com.obric.aikernel.res.metadata.data.a(r11, r15, r18.getConfig());
        goto L21
    L25:
        r6 = null;
    L29:
        r10 = r10 + 1;
        r3 = r3;
        goto L13
    L37:
        return;
    L36:
        return;
    L30:
        return;
    L6:
        if (Intrinsics.areEqual(r19, "model") == false) goto L8;
        r4 = new File(new com.obric.aikernel.res.metadata.data.a("", "", r18.getConfig()).w());
        goto L9
    L8:
        r4 = null;
        goto L9
    }

    public static /* synthetic */ void a(a r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.b(r1, r2, r3);
    }

    private final void a(String r10, Map<String, com.obric.aikernel.res.metadata.data.d> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        monitor-enter(r12);
        com.obric.aikernel.res.metadata.data.b r0 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(this.e.get(r10), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new e(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L51
        com.obric.aikernel.res.metadata.data.b r3 = null;
    L5:
        boolean r5 = false;
        if (r1.hasNext() == false) goto L16;
        com.obric.aikernel.res.metadata.data.d r4 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L51
        com.obric.aikernel.res.metadata.data.b r6 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r4, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        if (r3 != null) goto L10;
    L12:
        if (r5 == false) goto L15;
        if (r6.d() == false) goto L5;
    L15:
        r3 = r6;
        goto L5
    L10:
        if (r3.d() != true) goto L12;
        r5 = true;
        goto L12
    L16:
        if (r3 != null) goto L18;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == true) goto L29;
        if (r0 != null) goto L24;
    L26:
        boolean r7 = false;
    L27:
        if (r7 == true) goto L29;
        this.e.remove(r10);     // Catch: Throwable -> L51
        r3 = null;
    L40:
        monitor-exit(r12);
        if (r0 == null) goto L43;
        this.c.a(r0, true);
    L43:
        if (r3 != null) goto L45;
        return;
    L45:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3.p(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L48;
        r3 = null;
    L48:
        if (r3 == null) goto L62;
        com.obric.aikernel.res.metadata.b.a(this.c, r3, false, 2, null);
        return;
    L62:
        return;
    L24:
        if (r0.d() != true) goto L26;
        r7 = true;
    L29:
        if (r3 == null) goto L38;
        String r8 = r3.t();     // Catch: Throwable -> L51
        if (r0 == null) goto L33;
        String r9 = r0.t();     // Catch: Throwable -> L51
    L35:
        if (Intrinsics.areEqual(r8, r9) == true) goto L38;
        r12.put(r3.t(), r3);     // Catch: Throwable -> L51
        this.e.put(r10, r3);     // Catch: Throwable -> L51
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L51
        goto L40
    L33:
        r9 = null;
    L38:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L51
        r3 = r0;
        r0 = null;
        goto L40
    L18:
        if (r3.d() != true) goto L20;
        r2 = true;
    L51:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ boolean a(a r7, String r8, String r9, JsonObject r10, boolean r11, boolean r12, Function1 r13, int r14, Object r15) {
        Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L5;
        r10 = null;
    L5:
        JsonObject r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        r11 = false;
    L8:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L12;
        r12 = true;
    L12:
        return r7.a(r8, r9, r3, r4, r12, r6);
    }

    public static /* synthetic */ boolean a(a r7, String r8, String r9, String r10, boolean r11, boolean r12, Function1 r13, int r14, Object r15) {
        Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        if ((r14 & 8) == 0) goto L5;
        r11 = false;
    L5:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L9;
        r12 = true;
    L9:
        return r7.a(r8, r9, r10, r4, r12, r6);
    }

    private static final boolean a(File r0, String r1) {
        return r0.isDirectory();
    }

    private final void b(com.obric.aikernel.res.metadata.data.d r6) {
        r6.L();
        if (r6.E() == false) goto L5;
        this.f6078b.tryInstallFromInstaller(r6.getType(), r6.s(), r6.t());
    L5:
        r6.L();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aikernel.res.metadata.data.b.class) == false) goto L9;
        ((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r6, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin")).p();
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.aikernel.res.metadata.data.f.class) == false) goto L11;
        List<com.obric.aikernel.res.metadata.data.a> r7 = ((com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r6, com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin")).q();
    L12:
        if (r7 == null) goto L25;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r8.hasNext() == false) goto L26;
        com.obric.aikernel.res.metadata.data.a r0 = (com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin");
        r0.L();
        if (r0.E() == false) goto L15;
        this.f6078b.tryInstallFromInstaller(r0.getType(), r0.s(), r0.t());
        goto L15
    L26:
        return;
    L25:
        return;
    L11:
        r7 = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
        goto L12
    }

    private final void b(Set<String> r3) {
        final Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Function1<? super com.obric.aikernel.res.metadata.data.d, Unit> r5 = (Function1) ZeusTransformUtils.preCheckCast(new MetadataController$cleanDepends$cleanAction$1(r4), Function1.class, "com.obric.memorydata.plugin");
        a(this.f6078b, "lib", r5);
        a(this.f6078b, "model", r5);
        com.obric.aikernel.res.b.a.f6003a.a(this.f6078b);
    }

    private static final boolean b(File r0, String r1) {
        return r0.isDirectory();
    }

    public static /* synthetic */ boolean lambda$0ikSXNZ4R5PntAszPZS142joeMg(File r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$TqJ254QCB7XvO43PWF1vhAjpCU0(File r0, String r1) {
        return b(r0, r1);
    }

    public final com.obric.aikernel.res.metadata.data.b a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(this.e.get(r2), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
    }

    public final Map<String, com.obric.aikernel.res.metadata.data.b> a() {
        return this.e;
    }

    public final Set<String> a(Set<String> r21) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r21, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "valid");
        Set<String> r3 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        File r4 = new File(new com.obric.aikernel.res.metadata.data.f("", "", this.f6078b.getConfig()).w());
        String[] r5 = r4.list();
        if (r5 == null) goto L42;
        int r6 = r5.length;
        int r8 = 0;
    L5:
        if (r8 >= r6) goto L42;
        String r9 = r5[r8];
        String[] r10 = new File(r4, r9).list();
        if (r10 == null) goto L41;
        Intrinsics.checkNotNullExpressionValue(r10, "list()");
        List r11 = ArraysKt.sortedWith(r10, (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin"));
        if (r11 == null) goto L41;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r13 = 0;
    L12:
        if (r12.hasNext() == false) goto L41;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        String r16 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
        String r17 = "lora@" + r9 + '@' + r16;
        if (r1.contains(r17) == false) goto L19;
        com.obric.aikernel.runtime.utils.d.f6216a.e("PResM-MetaDataController", "cleanLoras " + r17 + " ignore in valid.");
        Set r18 = r1;
        File r19 = r4;
        String[] r110 = r5;
        int r111 = r6;
    L40:
        r13 = r15;
        r1 = r18;
        r4 = r19;
        r5 = r110;
        r6 = r111;
        goto L12
    L19:
        r18 = r1;
        r19 = r4;
        Intrinsics.checkNotNullExpressionValue(r9, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullExpressionValue(r16, "version");
        com.obric.aikernel.res.metadata.data.f r2 = new com.obric.aikernel.res.metadata.data.f(r9, r16, this.f6078b.getConfig());
        r110 = r5;
        r111 = r6;
        Pair<com.obric.aikernel.res.metadata.data.f, com.obric.aikernel.res.metadata.data.b> r7 = com.obric.aikernel.res.metadata.data.f.f6090a.a(r2.p(), r9, this.f6078b);
        if (r7 != null) goto L22;
        a r20 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.e("PResM-MetaDataController", "cleanLoras " + r17 + " no lora info.");
        if (r13 == 0) goto L40;
    L28:
        r2.m();
        goto L40
    L22:
        if (((com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r7.getFirst(), com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin")).d() == true) goto L24;
    L34:
        com.obric.aikernel.runtime.utils.d.f6216a.e("PResM-MetaDataController", "cleanLoras " + r17 + " no avail lora.");
        if (r13 == 0) goto L40;
    L24:
        if (((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r7.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin")).d() == false) goto L34;
        if (com.obric.aikernel.res.metadata.data.b.e.a(r16) >= com.obric.aikernel.res.metadata.data.b.e.a(((com.obric.aikernel.res.metadata.data.f) ZeusTransformUtils.preCheckCast(r7.getFirst(), com.obric.aikernel.res.metadata.data.f.class, "com.obric.memorydata.plugin")).t())) goto L29;
        com.obric.aikernel.runtime.utils.d.f6216a.e("PResM-MetaDataController", "cleanLoras " + r17 + " low version code.");
        goto L28
    L29:
        r3.add("package@" + ((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r7.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin")).s() + '@' + ((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r7.getSecond(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin")).t());
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r2.q(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L31:
        if (r24.hasNext() == false) goto L33;
        com.obric.aikernel.res.metadata.data.a r25 = (com.obric.aikernel.res.metadata.data.a) ZeusTransformUtils.preCheckCast(r24.next(), com.obric.aikernel.res.metadata.data.a.class, "com.obric.memorydata.plugin");
        r23.add(r25.getType() + '@' + r25.s() + '@' + r25.t());
        goto L31
    L33:
        r3.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
    L41:
        r8 = r8 + 1;
        r1 = r1;
        r4 = r4;
        r5 = r5;
        r6 = r6;
    L42:
        return r3;
    }

    public final void a(com.obric.aikernel.res.metadata.data.d r5) {
        Intrinsics.checkNotNullParameter(r5, "metadata");
        Map<String, com.obric.aikernel.res.metadata.data.d> r0 = this.f.a(r5.getType(), r5.s());
        monitor-enter(r0);
        com.obric.aikernel.res.metadata.data.d r1 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r0.get(r5.t()), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L8;
        r5 = r1;
    L8:
        r5.m();     // Catch: Throwable -> L12
        monitor-exit(r0);
        d();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "version");
        Map<String, com.obric.aikernel.res.metadata.data.d> r0 = this.f.a("package", r11);
        monitor-enter(r0);
        final com.obric.aikernel.res.metadata.data.d r13 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r0.get(r12), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r13 == null) goto L11;
        String r2 = r13.s();     // Catch: Throwable -> L14
        String r3 = r13.t();     // Catch: Throwable -> L14
        com.obric.aikernel.res.metadata.config.a r1 = r13.J();     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        JsonObject r4 = r1.b();     // Catch: Throwable -> L14
    L10:
        Boolean.valueOf(a(this, r2, r3, r4, false, false, (Function1) ZeusTransformUtils.preCheckCast(new MetadataController$enablePackage$1$1$1(r13), Function1.class, "com.obric.memorydata.plugin"), 24, null));     // Catch: Throwable -> L14
        goto L11
    L9:
        r4 = null;
    L11:
        monitor-exit(r0);
        a(r11, r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a(String r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r10, "version");
        Map<String, com.obric.aikernel.res.metadata.data.d> r0 = this.f.a("package", r9);
        monitor-enter(r0);
        Iterator<Map.Entry<String, com.obric.aikernel.res.metadata.data.d>> r1 = r0.entrySet().iterator();     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2.getValue(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin")).t(), "debug") == true) goto L6;
        if (com.obric.aikernel.res.metadata.data.b.e.a(r10) >= com.obric.aikernel.res.metadata.data.b.e.a(((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2.getValue(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin")).t())) goto L6;
        com.obric.aikernel.res.metadata.data.d r3 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r0.remove(r2.getKey()), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r3 == null) goto L6;
        if (r11 == true) goto L14;
        r3.o();     // Catch: Throwable -> L20
        goto L6
    L14:
        r3.m();     // Catch: Throwable -> L20
        goto L6
    L16:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        a(r9, r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r8, String r9, JsonObject r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r9, "version");
        com.obric.aikernel.res.metadata.data.b r0 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(this.e.get(r8), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        boolean r2 = true;
        if (r0 != null) goto L5;
    L43:
        r1 = r2;
    L44:
        com.obric.aikernel.runtime.utils.d r7 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r12 = new StringBuilder().append(r8).append(' ').append(r9).append(" isPackageNeedUpdate ").append(r1).append(" current:");
        if (r0 == null) goto L47;
        String r13 = r0.t();
    L48:
        r7.a("PResM-MetaDataController", r12.append(r13).toString());
        return r1;
    L47:
        r13 = null;
        goto L48
    L5:
        if (r0.d() == false) goto L43;
        if (r0.a(r11) == true) goto L43;
        if (Intrinsics.areEqual(r9, "debug") == true) goto L43;
        if (Intrinsics.areEqual(r0.t(), "debug") == false) goto L39;
        Map<String, com.obric.aikernel.res.metadata.data.d> r14 = this.f.a("package", r8);
        monitor-enter(r14);
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14.values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        Iterator r17 = r15.iterator();     // Catch: Throwable -> L35
    L18:
        if (r17.hasNext() == false) goto L27;
        Object r3 = r17.next();     // Catch: Throwable -> L35
        com.obric.aikernel.res.metadata.data.d r4 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r4.t(), "debug") == false) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L18;
        r16.add(r3);     // Catch: Throwable -> L35
        goto L18
    L22:
        if (com.obric.aikernel.res.metadata.data.b.e.a(r4.t()) < com.obric.aikernel.res.metadata.data.b.e.a(r9)) goto L24;
        r5 = true;
        goto L25
    L27:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L35
    L28:
        if (r18.hasNext() == false) goto L33;
        if (((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin")).d() == false) goto L28;
        r2 = false;
        goto L28
    L33:
        monitor-exit(r14);
    L35:
        th = move-exception;
        throw th;
    L39:
        if (com.obric.aikernel.res.metadata.data.b.e.a(r9) > com.obric.aikernel.res.metadata.data.b.e.a(r0.t())) goto L43;
        if (r10 == null) goto L44;
        r1 = r0.a(r10);
        goto L44
    }

    public final boolean a(String r16, String r17, JsonObject r18, boolean r19, boolean r20, Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r21) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r17, "version");
        Intrinsics.checkNotNullParameter(r5, "builder");
        boolean r7 = true;
        if (a(r16, r17, r18, r20) == false) goto L62;
        Map<String, com.obric.aikernel.res.metadata.data.d> r6 = this.f.a("package", r16);
        monitor-enter(r6);
    L59:
        th = move-exception;
        throw th;
    L7:
        if (a(r16, r17, r18, r20) == false) goto L47;
        Object r8 = r5.invoke(this.f6078b.getConfig().getRootDir());     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L59
        com.obric.aikernel.res.metadata.data.b r9 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r8, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        if (r9.J() != null) goto L14;
        if (r18 != null) goto L14;
        com.obric.aikernel.runtime.utils.d.f6216a.c("PResM-MetaDataController", "install package err invalid config.");     // Catch: Throwable -> L59
        monitor-exit(r6);
        return false;
    L14:
        if (r19 == true) goto L23;
        if (r18 != null) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L23;
        boolean r4 = false;
    L25:
        if (r9.a(this.f6078b, r4, r20) == false) goto L45;
        com.obric.aikernel.res.metadata.data.b r10 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(this.e.get(r16), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
        if (r10 != null) goto L29;
    L31:
        boolean r11 = false;
    L32:
        if (r11 == true) goto L34;
        boolean r12 = true;
    L35:
        boolean r13 = r9.d();     // Catch: Throwable -> L59
        com.obric.aikernel.runtime.utils.d r14 = com.obric.aikernel.runtime.utils.d.f6216a;     // Catch: Throwable -> L59
        StringBuilder r15 = new StringBuilder().append(r16).append(" oldVersion:");     // Catch: Throwable -> L59
        if (r10 == null) goto L38;
        String r22 = r10.t();     // Catch: Throwable -> L59
    L39:
        r14.b("PResM-MetaDataController", r15.append(r22).append(" oldIsNotAvail:").append(r12).append(" newVersion:").append(r9.t()).append(" newIsAvail:").append(r13).toString());     // Catch: Throwable -> L59
        if (r12 == true) goto L44;
        if (r13 == true) goto L44;
        r6.putIfAbsent(r17, r9);     // Catch: Throwable -> L59
        r9 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(null, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
    L55:
        monitor-exit(r6);
        if (r9 == null) goto L58;
        com.obric.aikernel.runtime.utils.c.a.a((com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(com.obric.aikernel.runtime.utils.d.f6216a, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin"), "PResM-MetaDataController", "installPackage " + r16 + '@' + r17 + " avail:" + r9.d(), 0, 4, null);
        com.obric.aikernel.res.metadata.b.a(this.c, r9, false, 2, null);
    L58:
        return r7;
    L44:
        r6.put(r17, r9);     // Catch: Throwable -> L59
        this.e.put(r16, r9);     // Catch: Throwable -> L59
        goto L55
    L38:
        r22 = null;
        goto L39
    L34:
        r12 = false;
        goto L35
    L29:
        if (r10.d() != true) goto L31;
        r11 = true;
        goto L32
    L45:
        r6.putIfAbsent(r17, r9);     // Catch: Throwable -> L59
        r7 = false;
    L54:
        r9 = null;
        goto L55
    L17:
        if (r9.a(r18) != true) goto L19;
        r3 = true;
    L23:
        r4 = true;
        goto L25
    L47:
        if (r6.containsKey(r17) == true) goto L54;
        Object r23 = r5.invoke(this.f6078b.getConfig().getRootDir());     // Catch: Throwable -> L59
        if (ZeusTransformUtils.instanceOf(r23, com.obric.aikernel.res.metadata.data.b.class) == false) goto L51;
        com.obric.aikernel.res.metadata.data.b r24 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r23, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L59
    L52:
        if (r24 == null) goto L54;
        r6.put(r17, r24);     // Catch: Throwable -> L59
        goto L54
    L51:
        r24 = null;
        goto L52
    L62:
        return true;
    }

    public final boolean a(String r6, String r7, String r8, boolean r9, boolean r10, Function1<? super String, ? extends com.obric.aikernel.res.metadata.data.d> r11) {
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r8, "version");
        Intrinsics.checkNotNullParameter(r12, "builder");
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Map<String, com.obric.aikernel.res.metadata.data.d> r13 = this.f.a(r6, r7);
        monitor-enter(r13);
        com.obric.aikernel.res.metadata.data.d r14 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r13.get(r8), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r2 == true) goto L23;
        if (r14 != null) goto L15;
    L17:
        boolean r15 = false;
    L18:
        if (r15 == false) goto L23;
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r13);
        return true;
    L15:
        if (r14.d() != true) goto L17;
        r15 = true;
    L23:
        com.obric.aikernel.res.metadata.data.d r16 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r12.invoke(this.f6078b.getConfig().getRootDir()), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r2 == true) goto L32;
        if (r16.d() == false) goto L32;
        r13.put(r8, r16);     // Catch: Throwable -> L38
        monitor-exit(r13);
        return true;
    L32:
        if (r16.a(this.f6078b, r9, r10) == false) goto L36;
        r13.put(r8, r16);     // Catch: Throwable -> L38
        d();     // Catch: Throwable -> L38
        monitor-exit(r13);
        return true;
    L36:
        monitor-exit(r13);
        return false;
    L38:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(r8, "debug") == true) goto L8;
        r2 = false;
        goto L9
    }

    public final b b() {
        return this.f;
    }

    public final Map<String, com.obric.aikernel.res.metadata.data.d> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return this.f.a("package", r2);
    }

    public final void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "version");
        com.obric.aikernel.res.metadata.data.d r0 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(this.f.a("package", r4).get(r5), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        b(r0);
    L5:
        com.obric.aikernel.res.metadata.data.d r6 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(this.f.a("lora", r4).get(r5), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        b(r6);
        return;
    }

    public final void b(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "version");
        Map<String, com.obric.aikernel.res.metadata.data.d> r0 = this.f.a("package", r4);
        monitor-enter(r0);
        com.obric.aikernel.res.metadata.data.d r7 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r0.get(r5), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        if (r6 == false) goto L8;
        b((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L8:
        Boolean.valueOf(r7.o());     // Catch: Throwable -> L12
    L9:
        monitor-exit(r0);
        a(r4, r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final List<String> c() {
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.e.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
    }

    public final void c(String r13) {
        Intrinsics.checkNotNullParameter(r13, ActivityLifecycle.NAME);
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.f.a().get("package"), c.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L19;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r1 = r0.a();
        if (r1 == null) goto L23;
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(r1.get(r13), Map.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L24;
        monitor-enter(r14);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r14.values(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new f(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L16
    L11:
        if (r2.hasNext() == false) goto L13;
        final com.obric.aikernel.res.metadata.data.d r3 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.aikernel.res.metadata.data.AIPackage");     // Catch: Throwable -> L16
        com.obric.aikernel.res.metadata.data.b r4 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r3, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        a(this, r3.s(), r3.t(), null, false, false, (Function1) ZeusTransformUtils.preCheckCast(new MetadataController$refreshPackageAvail$1$1$2$1(r3), Function1.class, "com.obric.memorydata.plugin"), 28, null);     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r14);
        return;
    L16:
        th = move-exception;
        throw th;
    L24:
        return;
    L23:
        return;
    }

    public final void c(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "version");
        Map<String, com.obric.aikernel.res.metadata.data.d> r0 = this.f.a("package", r4);
        monitor-enter(r0);
        com.obric.aikernel.res.metadata.data.d r7 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r0.remove(r5), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        if (r6 == false) goto L8;
        b((com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast((com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r7, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin"), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L8:
        Boolean.valueOf(r7.m());     // Catch: Throwable -> L12
    L9:
        monitor-exit(r0);
        a(r4, r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized ar<Unit> d() {
        monitor-enter(this);
        ar<Unit> r0 = this.h;     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L12;
    L13:
        ar<Unit> r2 = this.h;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r2;
    L8:
        if (r0.a() != true) goto L10;
    L12:
        this.h = kotlinx.coroutines.i.b(this.d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MetadataController$refreshPackageAvail$2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void e() {
        File[] r0 = new File(new com.obric.aikernel.res.metadata.data.b("", "", this.f6078b.getConfig()).w()).listFiles();
        int r1 = 0;
        if (r0 == null) goto L17;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L17;
        File r4 = r0[r3];
        b r5 = this.f;
        String r6 = r4.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "it.name");
        Map<String, com.obric.aikernel.res.metadata.data.d> r7 = r5.a("package", r6);
        monitor-enter(r7);
        com.obric.aikernel.res.metadata.data.d r8 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r7.remove("debug"), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r8 == null) goto L11;
        r8.m();     // Catch: Throwable -> L14
    L11:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r7);
        r3 = r3 + 1;
    L14:
        th = move-exception;
        throw th;
    L17:
        File[] r10 = new File(new i("", "", this.f6078b.getConfig()).w()).listFiles();
        if (r10 == null) goto L22;
        int r11 = r10.length;
    L20:
        if (r1 >= r11) goto L27;
        String r12 = r10[r1].getName();
        Intrinsics.checkNotNullExpressionValue(r12, "it.name");
        new i(r12, "debug", this.f6078b.getConfig()).m();
        r1 = r1 + 1;
        goto L20
    L27:
        return;
    }

    public final void f() {
        Set<String> r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(this.f6078b.getCurrentRunningVersions(), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(NativeLibVersionPolicy.INSTANCE.getValidVersionMaps(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(r2.next(), Map.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r3.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.add("lib@" + ((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin")) + '@' + ((String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L7
    L9:
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        com.obric.aikernel.runtime.utils.d.f6216a.d("PResM-MetaDataController", "cleanGarbage running deps is " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(this.e.values(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        com.obric.aikernel.res.metadata.data.b r10 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");
        r8.add(r10.getType() + '@' + r10.s() + '@' + r10.t());
        goto L12
    L14:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        com.obric.aikernel.runtime.utils.d.f6216a.d("PResM-MetaDataController", "cleanGarbage current pkgMap is " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null));
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin"));
        Set<String> r12 = a(r1);
        Set<String> r13 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        c r14 = (c) ZeusTransformUtils.preCheckCast(this.f.a().get("package"), c.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L66;
        Map<String, Map<String, com.obric.aikernel.res.metadata.data.d>> r15 = r14.a();
        if (r15 == null) goto L66;
        Iterator<Map.Entry<String, Map<String, com.obric.aikernel.res.metadata.data.d>>> r16 = r15.entrySet().iterator();
    L20:
        if (r16.hasNext() == false) goto L66;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.memorydata.plugin");
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(r17.getValue(), Map.class, "com.obric.memorydata.plugin");
        monitor-enter(r19);
        com.obric.aikernel.res.metadata.data.b r20 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(this.e.get(r18), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        if (r20 != null) goto L26;
        String r21 = null;
    L33:
        Iterator r110 = r19.entrySet().iterator();     // Catch: Throwable -> L63
    L35:
        if (r110.hasNext() == false) goto L60;
        Map.Entry r111 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        com.obric.aikernel.res.metadata.data.d r113 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r111.getValue(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        String r114 = "package@" + r18 + '@' + r112;     // Catch: Throwable -> L63
        boolean r115 = false;
        if (r1.contains(r114) == false) goto L40;
    L45:
        if (r115 == true) goto L46;
        if (ZeusTransformUtils.instanceOf(r113, com.obric.aikernel.res.metadata.data.b.class) == false) goto L52;
        com.obric.aikernel.res.metadata.data.b r116 = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(r113, com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
    L53:
        if (r116 == null) goto L35;
        List<com.obric.aikernel.res.metadata.data.d> r117 = r116.p();     // Catch: Throwable -> L63
        if (r117 == null) goto L35;
        Iterator r118 = ((Iterable) ZeusTransformUtils.preCheckCast(r117, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L63
    L58:
        if (r118.hasNext() == false) goto L35;
        com.obric.aikernel.res.metadata.data.d r119 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r118.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        r13.add(r119.getType() + '@' + r119.s() + '@' + r119.t());     // Catch: Throwable -> L63
        goto L58
    L52:
        r116 = null;
        goto L53
    L46:
        com.obric.aikernel.runtime.utils.d.f6216a.b("PResM-MetaDataController", "cleanGarbage " + r18 + '@' + r112);     // Catch: Throwable -> L63
        com.obric.aikernel.res.metadata.data.d r120 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r19.remove(r112), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        if (r120 == null) goto L35;
        r120.m();     // Catch: Throwable -> L63
        goto L35
    L40:
        if (r12.contains(r114) == true) goto L45;
        if (Intrinsics.areEqual(r21, r113.t()) == true) goto L45;
        r115 = r113.G();     // Catch: Throwable -> L63
        goto L45
    L60:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r19);
        goto L20
    L26:
        if (r20.d() == false) goto L31;
        Iterator r121 = ((Iterable) ZeusTransformUtils.preCheckCast(r20.p(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L63
    L29:
        if (r121.hasNext() == false) goto L31;
        com.obric.aikernel.res.metadata.data.d r122 = (com.obric.aikernel.res.metadata.data.d) ZeusTransformUtils.preCheckCast(r121.next(), com.obric.aikernel.res.metadata.data.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L63
        r13.add(r122.getType() + '@' + r122.s() + '@' + r122.t());     // Catch: Throwable -> L63
    L31:
        r21 = r20.t();     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;
    L66:
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"));
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin"));
        b(r13);
    }

    public final void g() {
        kotlinx.coroutines.i.a(this.d, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MetadataController$flushPackageUsage$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void h() {
        long r0 = System.currentTimeMillis();
        this.f6078b.runInstaller((com.obric.aikernel.res.installer.d) ZeusTransformUtils.preCheckCast(new com.obric.aikernel.res.installer.internal.a(), com.obric.aikernel.res.installer.d.class, "com.obric.memorydata.plugin"));
        com.obric.aikernel.runtime.utils.d.f6216a.b("PResM-MetaDataController", "metadata startup scan completed costMs=" + (System.currentTimeMillis() - r0));
        this.g.a();
    }
}
