package com.obric.aikernel.res.metadata;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.PrmContext;
import com.obric.aikernel.res.metadata.controller.MetadataController;
import com.obric.aikernel.res.metadata.data.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.h;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
@Keep
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

    public static /* synthetic */ void a(Function2 r10, Object r11, Object r12) {
        refreshNativeLibVersionPolicy$lambda$19$lambda$18(r10, r11, r12);
    }

    public static final /* synthetic */ PrmContext access$getContext$p() {
        return context;
    }

    public static /* synthetic */ int b(Function2 r10, Object r11, Object r12) {
        return recordMaxAvail$lambda$3$lambda$0(r10, r11, r12);
    }

    private final Map<String, String> getActiveVersionMap() {
        return activeVersion;
    }

    private static final int recordMaxAvail$lambda$3$lambda$0(Function2 r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        return ((Number) r10.invoke(r11, r12)).intValue();
    }

    private static final void refreshNativeLibVersionPolicy$lambda$19$lambda$18(Function2 r10, Object r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        r10.invoke(r11, r12);
    }

    public final void fillNativeLibs(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map<String, String> r11 = getActiveVersionMap();
        r10.putStringArrayList(KEY_NATIVE_LIB, new ArrayList(r11.keySet()));
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        r10.putString(r13.getKey(), r13.getValue());
        goto L4
    }

    public final Map<String, String> getNativeLibs(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList<String> r11 = r10.getStringArrayList(KEY_NATIVE_LIB);
        if (r11 == null) goto L13;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L17;
        String r14 = (String) r13.next();
        String r15 = r10.getString(r14);
        if (r15 == null) goto L11;
        r12.add(new Pair(r14, r15));
        goto L6
    L11:
        throw new IllegalArgumentException("Required value was null.".toString());
    L17:
        return MapsKt.toMap(r12);
    L13:
        return null;
    }

    public final List<Map<String, String>> getValidVersionMaps() {
        ArrayList r10 = new ArrayList();
        r10.add(activeVersion);
        Map<String, Map<String, String>> r11 = subProcVersionMap;
        if (r11 == null) goto L5;
        r10.addAll(r11.values());
    L5:
        return r10;
    }

    public final String getVersion(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return activeVersion.get(r10);
    }

    public final void init(PrmContext r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        context = r10;
    }

    public final String initOrGetVersion(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        PrmContext r11 = context;
        if (r11 == null) goto L11;
        PackageResourceManager.PresmConfig r12 = r11.getConfig();
        if (r12 == null) goto L11;
        PackageResourceManager.PresmConfig.c r13 = r12.getNativeLibLifeCycle();
        if (r13 == null) goto L11;
        r0<Unit> r14 = r13.c();
        if (r14 == null) goto L11;
        h.f(null, new NativeLibVersionPolicy$initOrGetVersion$1$1(r14, null), 1, null);
    L11:
        String r15 = getVersion(r10);
        if (r15 != null) goto L25;
        monitor-enter(this);
        NativeLibVersionPolicy r16 = INSTANCE;     // Catch: Throwable -> L22
        if (r16.getVersion(r10) != null) goto L19;
        String r17 = recordVersionMap.get(r10);     // Catch: Throwable -> L22
        if (r17 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r17, "it");     // Catch: Throwable -> L22
        r16.setVersion$resource_manager_release(r10, r17);     // Catch: Throwable -> L22
    L19:
        r15 = r16.getVersion(r10);     // Catch: Throwable -> L22
        com.obric.aikernel.runtime.utils.d.f5417a.g(TAG, "initOrGetVersion " + r10 + '@' + r15);     // Catch: Throwable -> L22
        monitor-exit(this);
    L22:
        th = move-exception;
        throw th;
    L25:
        return r15;
    }

    public final void onNativeLibInstalled$resource_manager_release(e r10) {
        Intrinsics.checkNotNullParameter(r10, "lib");
        if (r10.g0() == true) goto L6;
        refreshNativeLibVersionPolicy$resource_manager_release(r10);
        return;
    }

    public final void recordMaxAvail(String r10, PackageResourceManager.PresmConfig r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "config");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L19
        File[] r13 = new File(new e(r10, "", r11).o()).listFiles();     // Catch: Throwable -> L19
        Unit r14 = null;
        if (r13 == null) goto L17;
        final NativeLibVersionPolicy$recordMaxAvail$1$1 r15 = NativeLibVersionPolicy$recordMaxAvail$1$1.INSTANCE;     // Catch: Throwable -> L19
        File[] r16 = (File[]) ArraysKt.sortedArrayWith(r13, new b(r15));     // Catch: Throwable -> L19
        if (r16 == null) goto L17;
        int r17 = 0;
        int r18 = r16.length;     // Catch: Throwable -> L19
    L9:
        if (r17 >= r18) goto L14;
        File r19 = r16[r17];     // Catch: Throwable -> L19
        String r20 = r19.getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r20, "it.name");     // Catch: Throwable -> L19
        if (new e(r10, r20, r11).H() == true) goto L15;
        r17 = r17 + 1;     // Catch: Throwable -> L19
    L15:
        if (r19 == null) goto L17;
        com.obric.aikernel.runtime.utils.d.f5417a.g(TAG, "recordMax " + r10 + ' ' + r19.getName());     // Catch: Throwable -> L19
        String r110 = r19.getName();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r110, "it.name");     // Catch: Throwable -> L19
        recordVersion(r10, r110);     // Catch: Throwable -> L19
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
        goto L17
    L14:
        r19 = null;
    L17:
        Result.m32constructorimpl(r14);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
    }

    public final void recordVersion(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "version");
        monitor-enter(this);
        String r12 = recordVersionMap.get(r10);     // Catch: Throwable -> L12
        if (r12 != null) goto L7;
    L8:
        recordVersionMap.put(r10, r11);     // Catch: Throwable -> L12
    L9:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L7:
        if (e.f5097o.a(r12, r11) == true) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void refreshNativeLibVersionPolicy$resource_manager_release(final e r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "lib");     // Catch: Throwable -> L19
        boolean r11 = r10.g0();     // Catch: Throwable -> L19
        com.obric.aikernel.runtime.utils.d r12 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L19
        r12.g(TAG, "onNativeLibInstalled " + r10 + " isAvail:" + r11 + " loaded:" + getVersion(r10.w()));     // Catch: Throwable -> L19
        if (r11 == true) goto L17;
        Map<String, Map<String, String>> r13 = subProcVersionMap;     // Catch: Throwable -> L19
        boolean r14 = false;
        if (r13 == null) goto L10;
        final Ref.BooleanRef r15 = new Ref.BooleanRef();     // Catch: Throwable -> L19
        r15.element = true;     // Catch: Throwable -> L19
        final Function2<String, Map<String, ? extends String>, Unit> r16 = new NativeLibVersionPolicy$refreshNativeLibVersionPolicy$canUpgrade$1$1(r10, r15);     // Catch: Throwable -> L19
        r13.forEach(new c(r16));     // Catch: Throwable -> L19
        if (r15.element != true) goto L10;
        r14 = true;
    L10:
        if (r14 == true) goto L12;
        r12.i(TAG, "refreshNativeLibVersionPolicy " + r10 + " not valid, usingVersion:" + getVersion(r10.w()));     // Catch: Throwable -> L19
        goto L17
    L12:
        r12.i(TAG, "refreshNativeLibVersionPolicy " + r10 + " updated from  usingVersion:" + getVersion(r10.w()));     // Catch: Throwable -> L19
        setVersion$resource_manager_release(r10.w(), r10.D());     // Catch: Throwable -> L19
        PrmContext r17 = context;     // Catch: Throwable -> L19
        if (r17 == null) goto L17;
        MetadataController r18 = r17.getMetadataCtrl$resource_manager_release();     // Catch: Throwable -> L19
        if (r18 == null) goto L17;
        r18.B();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void setSubProcessVersionMap(String r13, Map<String, String> r14) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r13, "proc");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r14, "versionMap");     // Catch: Throwable -> L23
        if (subProcVersionMap != null) goto L6;
        subProcVersionMap = new ConcurrentHashMap();     // Catch: Throwable -> L23
    L6:
        Map<String, Map<String, String>> r10 = subProcVersionMap;     // Catch: Throwable -> L23
        if (r10 == null) goto L9;
        r10.put(r13, r14);     // Catch: Throwable -> L23
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L23
        com.obric.aikernel.runtime.utils.d.f5417a.g(TAG, "setSubProcessVersionMap " + r13 + ' ' + CollectionsKt.joinToString$default(r14.entrySet(), null, null, null, 0, null, NativeLibVersionPolicy$setSubProcessVersionMap$1$1.INSTANCE, 31, null));     // Catch: Throwable -> L23
    L9:
        Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();     // Catch: Throwable -> L23
    L10:
        if (r15.hasNext() == false) goto L21;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L23
        String r12 = r16.getKey();     // Catch: Throwable -> L23
        String r17 = r16.getValue();     // Catch: Throwable -> L23
        NativeLibVersionPolicy r18 = INSTANCE;     // Catch: Throwable -> L23
        String r19 = r18.getVersion(r12);     // Catch: Throwable -> L23
        if (r19 == null) goto L19;
        if ((!e.f5097o.a(r19, r17)) == true) goto L18;
        r19 = null;
    L18:
        if (r19 != null) goto L10;
    L19:
        r18.setVersion$resource_manager_release(r12, r17);     // Catch: Throwable -> L23
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L23
        goto L10
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void setVersion$resource_manager_release(String r10, String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r11, "version");     // Catch: Throwable -> L6
        com.obric.aikernel.runtime.utils.d.f5417a.g(TAG, "setVersion " + r10 + ' ' + r11);     // Catch: Throwable -> L6
        Map r12 = MapsKt.createMapBuilder();     // Catch: Throwable -> L6
        r12.putAll(activeVersion);     // Catch: Throwable -> L6
        r12.put(r10, r11);     // Catch: Throwable -> L6
        activeVersion = MapsKt.build(r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
