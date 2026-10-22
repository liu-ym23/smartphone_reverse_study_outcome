package z6;

import com.obric.aee.impl.EngineConfig;
import com.obric.pap.base.PythonRes;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13800a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, List<String>> f13801b = null;

    static {
        f13800a = new a();
        f13801b = MapsKt.mapOf(new Pair[]{TuplesKt.to("jnius", CollectionsKt.listOf(new String[]{"jnius", "jnius_config", "pyjnius-"})), TuplesKt.to("msgpack", CollectionsKt.listOf("msgpack")), TuplesKt.to("numpy", CollectionsKt.listOf("numpy")), TuplesKt.to("orjson", CollectionsKt.listOf("orjson"))});
    }

    private a() {
    }

    public final void a(EngineConfig r19, File r20) {
        Intrinsics.checkNotNullParameter(r19, "cfg");
        Intrinsics.checkNotNullParameter(r20, "home");
        File r10 = new File(r20, "python/lib/python3.13/site-packages");
        String[] r11 = r10.list();
        if (r11 == null) goto L5;
        List r12 = ArraysKt.toList(r11);
    L6:
        if (r12 != null) goto L8;
        r12 = CollectionsKt.emptyList();
    L8:
        Map<String, List<String>> r13 = f13801b;
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<Map.Entry<String, List<String>>> r15 = r13.entrySet().iterator();
    L10:
        if (r15.hasNext() == false) goto L34;
        Map.Entry<String, List<String>> r16 = r15.next();
        List<String> r17 = r16.getValue();
        boolean r18 = true;
        if ((r17 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r21 = r17.iterator();
    L18:
        if (r21.hasNext() == false) goto L32;
        String r22 = (String) r21.next();
        if ((r12 instanceof Collection) == true) goto L22;
    L24:
        Iterator r110 = r12.iterator();
    L26:
        if (r110.hasNext() == false) goto L23;
        String r111 = (String) r110.next();
        Intrinsics.checkNotNullExpressionValue(r111, "it");
        if (StringsKt.startsWith$default(r111, r22, false, 2, null) == false) goto L26;
        boolean r23 = true;
    L30:
        if (r23 == false) goto L18;
        r18 = false;
    L23:
        r23 = false;
        goto L30
    L22:
        if (r12.isEmpty() == false) goto L24;
    L32:
        if (r18 == false) goto L10;
        r14.put(r16.getKey(), r16.getValue());
        goto L10
    L14:
        if (r17.isEmpty() == false) goto L16;
    L34:
        Set r24 = r14.keySet();
        if (r24.isEmpty() == false) goto L38;
        r19.logD("ExecutionEngine", "Engine=> builtin site-packages check passed.");
        return;
    L38:
        r19.logW("ExecutionEngine", "Engine=> builtin site-packages missing " + CollectionsKt.joinToString$default(r24, ",", null, null, 0, null, null, 62, null) + " under " + r10.getAbsolutePath() + ", clear flag before refresh.");
        PythonRes.f7779a.b(r20, r19);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final Void b(EngineConfig r10, File r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "cfg");
        Intrinsics.checkNotNullParameter(r11, "home");
        Intrinsics.checkNotNullParameter(r12, "error");
        PythonRes.f7779a.b(r11, r10);
        StringBuilder r13 = new StringBuilder();
        r13.append("Engine=> init failed, cleared builtin package flag: ");
        String r14 = r12.getMessage();
        if (r14 != null) goto L5;
        r14 = r12.getClass().getSimpleName();
    L5:
        r13.append(r14);
        r10.logE("ExecutionEngine", r13.toString());
        throw r12;
    }

    public final String c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (Intrinsics.areEqual(r10, "INIT") == false) goto L6;
        return "_INIT";
    L6:
        return r10;
    }
}
