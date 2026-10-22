package com.obric.aikernel.res.metadata;

import android.os.Bundle;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00070\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0016\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\u0015\u0010 \u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b!J\"\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00042\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007J\u001d\u0010%\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0000¢\u0006\u0002\b&J\n\u0010'\u001a\u00020\u0014*\u00020(J\u0018\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007*\u00020(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/aikernel/res/metadata/NativeLibVersionPolicy;", "", "()V", "KEY_NATIVE_LIB", "", "TAG", "activeVersion", "", "context", "Lcom/obric/aikernel/res/PrmContext;", "recordVersionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "subProcVersionMap", "", "getActiveVersionMap", "getValidVersionMaps", "", "getVersion", ActivityLifecycle.NAME, CommonConsts.APM_INNER_EVENT_COST_INIT, "", "ctx", "initOrGetVersion", "onNativeLibInstalled", "lib", "Lcom/obric/aikernel/res/metadata/data/PythonLibrary;", "onNativeLibInstalled$resource_manager_release", "recordMaxAvail", "config", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig;", "recordVersion", "version", "refreshNativeLibVersionPolicy", "refreshNativeLibVersionPolicy$resource_manager_release", "setSubProcessVersionMap", "proc", "versionMap", "setVersion", "setVersion$resource_manager_release", "fillNativeLibs", "Landroid/os/Bundle;", "getNativeLibs", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NativeLibVersionPolicy {
    public static final NativeLibVersionPolicy INSTANCE = null;
    public static final String KEY_NATIVE_LIB = "@native_lib_active_info";
    private static final String TAG = "NativeLibVersionPolicy";
    private static Map<String, String> activeVersion;
    private static PrmContext context;
    private static ConcurrentHashMap<String, String> recordVersionMap;
    private static Map<String, Map<String, String>> subProcVersionMap;

    static {
        INSTANCE = new NativeLibVersionPolicy();
        recordVersionMap = new ConcurrentHashMap();
        activeVersion = MapsKt.emptyMap();
    }

    private NativeLibVersionPolicy() {
    }

    public static final /* synthetic */ PrmContext access$getContext$p() {
        return context;
    }

    private final Map<String, String> getActiveVersionMap() {
        return activeVersion;
    }

    public static /* synthetic */ void lambda$Oi4U7zj3A0OMdMOJRhJnfUnC3Sk(Function2 r0, Object r1, Object r2) {
        refreshNativeLibVersionPolicy$lambda$19$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ int lambda$jliuy42c6hpSLsZGiK5CCruI1dU(Function2 r0, Object r1, Object r2) {
        return recordMaxAvail$lambda$3$lambda$0(r0, r1, r2);
    }

    private static final int recordMaxAvail$lambda$3$lambda$0(Function2 r2, Object r3, Object r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        return ((Number) ZeusTransformUtils.preCheckCast(r5.invoke(r3, r4), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private static final void refreshNativeLibVersionPolicy$lambda$19$lambda$18(Function2 r2, Object r3, Object r4) {
        Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$tmp0");
        r5.invoke(r3, r4);
    }

    public final void fillNativeLibs(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map<String, String> r4 = getActiveVersionMap();
        r5.putStringArrayList(KEY_NATIVE_LIB, new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r4.keySet(), Collection.class, "com.obric.memorydata.plugin")));
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.putString((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    public final Map<String, String> getNativeLibs(Bundle r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ArrayList<String> r5 = r6.getStringArrayList(KEY_NATIVE_LIB);
        if (r5 == null) goto L13;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        String r4 = r6.getString(r2);
        if (r4 == null) goto L11;
        r0.add(new Pair(r2, r4));
        goto L6
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    L17:
        return MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L13:
        return null;
    }

    public final List<Map<String, String>> getValidVersionMaps() {
        List<Map<String, String>> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r2.add(activeVersion);
        Map<String, Map<String, String>> r0 = subProcVersionMap;
        if (r0 == null) goto L5;
        r2.addAll(r0.values());
    L5:
        return r2;
    }

    public final String getVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return (String) ZeusTransformUtils.preCheckCast(activeVersion.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public final void init(PrmContext r1) {
        Intrinsics.checkNotNullParameter(r1, "ctx");
        context = r1;
    }

    public final String initOrGetVersion(String r6) {
        Intrinsics.checkNotNullParameter(r6, ActivityLifecycle.NAME);
        PrmContext r0 = context;
        if (r0 == null) goto L11;
        PackageResourceManager.PresmConfig r1 = r0.getConfig();
        if (r1 == null) goto L11;
        PackageResourceManager.PresmConfig.b r2 = r1.getNativeLibLifeCycle();
        if (r2 == null) goto L11;
        ar<Unit> r3 = r2.a();
        if (r3 == null) goto L11;
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new NativeLibVersionPolicy$initOrGetVersion$1$1(r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
    L11:
        String r4 = getVersion(r6);
        if (r4 != null) goto L25;
        monitor-enter(this);
        NativeLibVersionPolicy r5 = INSTANCE;     // Catch: Throwable -> L22
        if (r5.getVersion(r6) != null) goto L19;
        String r7 = (String) ZeusTransformUtils.preCheckCast(recordVersionMap.get(r6), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r7 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r7, "it");     // Catch: Throwable -> L22
        r5.setVersion$resource_manager_release(r6, r7);     // Catch: Throwable -> L22
    L19:
        r4 = r5.getVersion(r6);     // Catch: Throwable -> L22
        d.f6216a.e(TAG, "initOrGetVersion " + r6 + '@' + r4);     // Catch: Throwable -> L22
        monitor-exit(this);
    L22:
        th = move-exception;
        throw th;
    L25:
        return r4;
    }

    public final void onNativeLibInstalled$resource_manager_release(com.obric.aikernel.res.metadata.data.i r2) {
        Intrinsics.checkNotNullParameter(r2, "lib");
        if (r2.j() == true) goto L6;
        refreshNativeLibVersionPolicy$resource_manager_release(r2);
        return;
    }

    public final void recordMaxAvail(String r9, PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r9, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r10, "config");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L19
        NativeLibVersionPolicy r8 = (NativeLibVersionPolicy) ZeusTransformUtils.preCheckCast(this, NativeLibVersionPolicy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        File[] r2 = new File(new com.obric.aikernel.res.metadata.data.i(r9, "", r10).w()).listFiles();     // Catch: Throwable -> L19
        Unit r3 = null;
        if (r2 == null) goto L17;
        final Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(NativeLibVersionPolicy$recordMaxAvail$1$1.INSTANCE, Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        File[] r0 = (File[]) ZeusTransformUtils.preCheckCast(ArraysKt.sortedArrayWith(r2, new $$Lambda$NativeLibVersionPolicy$jliuy42c6hpSLsZGiK5CCruI1dU(r4)), File[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r0 == null) goto L17;
        int r5 = 0;
        int r6 = r0.length;     // Catch: Throwable -> L19
    L9:
        if (r5 >= r6) goto L14;
        File r7 = r0[r5];     // Catch: Throwable -> L19
        String r11 = r7.getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r11, "it.name");     // Catch: Throwable -> L19
        if (new com.obric.aikernel.res.metadata.data.i(r9, r11, r10).d() == true) goto L15;
        r5 = r5 + 1;     // Catch: Throwable -> L19
    L15:
        if (r7 == null) goto L17;
        d.f6216a.e(TAG, "recordMax " + r9 + ' ' + r7.getName());     // Catch: Throwable -> L19
        String r12 = r7.getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r12, "it.name");     // Catch: Throwable -> L19
        r8.recordVersion(r9, r12);     // Catch: Throwable -> L19
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        goto L17
    L14:
        r7 = null;
    L17:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public final void recordVersion(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "version");
        monitor-enter(this);
        String r0 = (String) ZeusTransformUtils.preCheckCast(recordVersionMap.get(r4), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r0 != null) goto L7;
    L8:
        ((Map) ZeusTransformUtils.preCheckCast(recordVersionMap, Map.class, "com.obric.memorydata.plugin")).put(r4, r5);     // Catch: Throwable -> L12
    L9:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L7:
        if (com.obric.aikernel.res.metadata.data.i.d.a(r0, r5) == true) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void refreshNativeLibVersionPolicy$resource_manager_release(final com.obric.aikernel.res.metadata.data.i r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, "lib");     // Catch: Throwable -> L19
        boolean r0 = r8.j();     // Catch: Throwable -> L19
        d.f6216a.e(TAG, "onNativeLibInstalled " + r8 + " isAvail:" + r0 + " loaded:" + getVersion(r8.s()));     // Catch: Throwable -> L19
        if (r0 == true) goto L17;
        Map<String, Map<String, String>> r1 = subProcVersionMap;     // Catch: Throwable -> L19
        boolean r2 = false;
        if (r1 == null) goto L10;
        final Ref.BooleanRef r3 = new Ref.BooleanRef();     // Catch: Throwable -> L19
        r3.element = true;     // Catch: Throwable -> L19
        final Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new NativeLibVersionPolicy$refreshNativeLibVersionPolicy$canUpgrade$1$1(r8, r3), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        r1.forEach(new $$Lambda$NativeLibVersionPolicy$Oi4U7zj3A0OMdMOJRhJnfUnC3Sk(r4));     // Catch: Throwable -> L19
        if (r3.element != true) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L12;
        d.f6216a.b(TAG, "refreshNativeLibVersionPolicy " + r8 + " not valid, usingVersion:" + getVersion(r8.s()));     // Catch: Throwable -> L19
        goto L17
    L12:
        d.f6216a.b(TAG, "refreshNativeLibVersionPolicy " + r8 + " updated from  usingVersion:" + getVersion(r8.s()));     // Catch: Throwable -> L19
        setVersion$resource_manager_release(r8.s(), r8.t());     // Catch: Throwable -> L19
        PrmContext r9 = context;     // Catch: Throwable -> L19
        if (r9 == null) goto L17;
        com.obric.aikernel.res.metadata.controller.a r10 = r9.getMetadataCtrl$resource_manager_release();     // Catch: Throwable -> L19
        if (r10 == null) goto L17;
        r10.d();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void setSubProcessVersionMap(String r13, Map<String, String> r14) {
        monitor-enter(this);
        Map<String, String> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r13, "proc");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r15, "versionMap");     // Catch: Throwable -> L23
        if (subProcVersionMap != null) goto L6;
        subProcVersionMap = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
    L6:
        Map<String, Map<String, String>> r0 = subProcVersionMap;     // Catch: Throwable -> L23
        if (r0 == null) goto L9;
        r0.put(r13, r15);     // Catch: Throwable -> L23
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L23
        d.f6216a.e(TAG, "setSubProcessVersionMap " + r13 + ' ' + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(NativeLibVersionPolicy$setSubProcessVersionMap$1$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 31, null));     // Catch: Throwable -> L23
    L9:
        Iterator<Map.Entry<String, String>> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L23
    L10:
        if (r16.hasNext() == false) goto L21;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        String r2 = (String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.getValue(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        NativeLibVersionPolicy r3 = INSTANCE;     // Catch: Throwable -> L23
        String r4 = r3.getVersion(r2);     // Catch: Throwable -> L23
        if (r4 == null) goto L19;
        if ((!com.obric.aikernel.res.metadata.data.i.d.a(r4, r18)) == true) goto L18;
        r4 = null;
    L18:
        if (r4 != null) goto L10;
    L19:
        r3.setVersion$resource_manager_release(r2, r18);     // Catch: Throwable -> L23
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L23
        goto L10
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void setVersion$resource_manager_release(String r5, String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, ActivityLifecycle.NAME);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r6, "version");     // Catch: Throwable -> L6
        d.f6216a.e(TAG, "setVersion " + r5 + ' ' + r6);     // Catch: Throwable -> L6
        Map r0 = MapsKt.createMapBuilder();     // Catch: Throwable -> L6
        r0.putAll(activeVersion);     // Catch: Throwable -> L6
        r0.put(r5, r6);     // Catch: Throwable -> L6
        activeVersion = MapsKt.build(r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
