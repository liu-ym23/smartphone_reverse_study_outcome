package com.obric.aee.utils;

import com.obric.aee.impl.EngineConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/aee/utils/EngineHelper;", "", "()V", "TAG", "", "builtinPackagesGuard", "requiredSitePackages", "", "", "ensureBuiltinPackages", "", "cfg", "Lcom/obric/aee/impl/EngineConfig;", "home", "Ljava/io/File;", "ensureBuiltinSitePackages", "handleInitFailure", "", "error", "", "overrideEvent", "key", "withBuiltinPackagesGuard", "block", "Lkotlin/Function0;", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5897a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f5898b = null;
    private static final Map<String, List<String>> c = null;

    static {
        f5897a = new b();
        f5898b = new Object();
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("jnius", CollectionsKt.listOf(new String[]{"jnius", "jnius_config", "pyjnius-"})), TuplesKt.to("msgpack", CollectionsKt.listOf("msgpack")), TuplesKt.to("numpy", CollectionsKt.listOf("numpy")), TuplesKt.to("orjson", CollectionsKt.listOf("orjson"))});
    }

    private b() {
    }

    private final void a(EngineConfig r3, Function0<Unit> r4) {
        Function0 r2 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Object r5 = f5898b;
        monitor-enter(r5);
        r3.logD("ExecutionEngine", "Engine=> ensure builtin packages in process");     // Catch: Throwable -> L7
        r2.invoke();     // Catch: Throwable -> L7
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        if (Intrinsics.areEqual(r1, "INIT") == false) goto L6;
        return "_INIT";
    L6:
        return r1;
    }

    public final Void a(EngineConfig r3, File r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "cfg");
        Intrinsics.checkNotNullParameter(r4, "home");
        Intrinsics.checkNotNullParameter(r5, "error");
        com.obric.pap.base.b.f14920a.a(r4, (com.obric.pap.base.a) ZeusTransformUtils.preCheckCast(r3, com.obric.pap.base.a.class, "com.obric.memorydata.plugin"));
        StringBuilder r2 = new StringBuilder().append("Engine=> init failed, cleared builtin package flag: ");
        String r6 = r5.getMessage();
        if (r6 != null) goto L5;
        r6 = r5.getClass().getSimpleName();
    L5:
        r3.logE("ExecutionEngine", r2.append(r6).toString());
        throw r5;
    }

    public final void a(final EngineConfig r3, final File r4) {
        Intrinsics.checkNotNullParameter(r3, "cfg");
        Intrinsics.checkNotNullParameter(r4, "home");
        a(r3, (Function0) ZeusTransformUtils.preCheckCast(new EngineHelper$ensureBuiltinPackages$1(r3, r4), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void b(EngineConfig r19, File r20) {
        Intrinsics.checkNotNullParameter(r19, "cfg");
        Intrinsics.checkNotNullParameter(r20, "home");
        File r2 = new File(r20, "python/lib/python3.13/site-packages");
        String[] r3 = r2.list();
        if (r3 == null) goto L5;
        List r4 = ArraysKt.toList(r3);
    L6:
        if (r4 != null) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        Map<String, List<String>> r5 = c;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, List<String>>> r7 = r5.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L34;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        boolean r11 = true;
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L14;
    L16:
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L32;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L22;
    L24:
        Iterator r14 = r13.iterator();
    L26:
        if (r14.hasNext() == false) goto L23;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        if (StringsKt.startsWith$default(r15, r12, false, 2, null) == false) goto L26;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L18;
        r11 = false;
    L23:
        r16 = false;
        goto L30
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L24;
    L32:
        if (r11 == false) goto L10;
        r6.put(r8.getKey(), r8.getValue());
        goto L10
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L34:
        Set r17 = ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin")).keySet();
        if (r17.isEmpty() == false) goto L38;
        r19.logI("ExecutionEngine", "Engine=> builtin site-packages check passed.");
        return;
    L38:
        r19.logW("ExecutionEngine", "Engine=> builtin site-packages missing " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + " under " + r2.getAbsolutePath() + ", clear flag before refresh.");
        com.obric.pap.base.b.f14920a.a(r20, (com.obric.pap.base.a) ZeusTransformUtils.preCheckCast(r19, com.obric.pap.base.a.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        r4 = null;
        goto L6
    }
}
