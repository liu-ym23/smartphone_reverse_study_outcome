package com.bytedance.android.annie.monitor;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.crash.Npth;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SlardarMonitorUtils {
    public static final Set<String> a = null;
    public static final Map<String, Pair<String, String>> b = null;
    public static String c;
    public static String d;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/monitor/SlardarMonitorUtils$HybridType;", "", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface HybridType {
    }

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/monitor/SlardarMonitorUtils$ViewType;", "", "annie_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ViewType {
    }

    static {
        a = new LinkedHashSet();
        b = new LinkedHashMap();
        c = "";
        d = "";
    }

    public static void d() {
        LinkedHashMap r0 = new LinkedHashMap();
        Set<String> r10 = a;
        r0.put("hybrid_view_url", CollectionsKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null));
        if ((!r10.isEmpty()) == false) goto L5;
        String r1 = c;
    L6:
        r0.put("hybrid_view_type", r1);
        r0.put("hybrid_type", d);
        Npth.addTags(r0);
        return;
    L5:
        r1 = "";
        goto L6
    }

    public static void c(String r10) {
        Object r0 = "";
        Intrinsics.checkNotNullParameter(r10, a.KEY_URL);
        Set<String> r1 = a;
        if (r1.contains(r10) == false) goto L25;
        r1.remove(r10);
        Map<String, Pair<String, String>> r11 = b;
        r11.remove(r10);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L16
        if ((!r1.isEmpty()) == false) goto L13;
        Pair r13 = (Pair) ((LinkedHashMap) r11).get(CollectionsKt.first(r1));     // Catch: Throwable -> L16
        if (r13 == null) goto L13;
        Object r14 = r13.getFirst();     // Catch: Throwable -> L16
        r0 = r13.getSecond();     // Catch: Throwable -> L11
    L14:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L19:
        c = (String) r14;
        d = (String) r0;
        d();
        return;
    L11:
        th = th;
    L18:
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L13:
        r14 = "";
    L16:
        th = th;
        r14 = "";
        goto L18
    }

    public static void a(final String r10, LifecycleOwner r11, @HybridType final String r12) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_URL);
        Intrinsics.checkNotNullParameter("fragment", "type");
        Intrinsics.checkNotNullParameter(r12, "hybridType");
        if (r11 != null) goto L5;
        return;
    L5:
        b.put(r10, new Pair("fragment", r12));
        b(r10, "fragment", r12);
        r11.getLifecycle().addObserver(new SlardarMonitorUtils$monitorCrashTag$1(r10, r12));
    }

    public static void b(String r10, @ViewType String r11, @HybridType String r12) {
        Intrinsics.checkNotNullParameter(r10, a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "hybridType");
        Set<String> r0 = a;
        if (r0.contains(r10) == false) goto L5;
        return;
    L5:
        r0.add(r10);
        c = r11;
        d = r12;
        d();
    }
}
