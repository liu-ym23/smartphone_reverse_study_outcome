package f3;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class c implements l {
    public final ConcurrentHashMap<String, Class<? extends AIBridgeMethod>> a;

    public c() {
        this.a = new ConcurrentHashMap();
    }

    public final void b(final Class<? extends AIBridgeMethod> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Map<Class<? extends AIBridgeMethod>, List<String>> r1 = m.a;
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L11
        Map<Class<? extends AIBridgeMethod>, List<String>> r12 = m.a;     // Catch: Throwable -> L11
        Object r13 = ((ConcurrentHashMap) r12).get(r10);     // Catch: Throwable -> L11
        if (r13 != null) goto L9;
        AIBridgeMethod r14 = r10.newInstance();     // Catch: Throwable -> L11
        LinkedHashSet r15 = new LinkedHashSet();     // Catch: Throwable -> L11
        r15.add(r14.getName());     // Catch: Throwable -> L11
        List<String> r16 = r14.getAltNames();     // Catch: Throwable -> L11
        if (r16 == null) goto L8;
        r15.addAll(r16);     // Catch: Throwable -> L11
    L8:
        r13 = CollectionsKt.toList(r15);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) r12).put(r10, r13);     // Catch: Throwable -> L11
    L9:
        Object r17 = Result.constructor-impl((List) r13);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r17) == false) goto L16;
        r17 = null;
    L16:
        List r18 = (List) r17;
        if (r18 != null) goto L19;
        r18 = CollectionsKt.emptyList();
    L19:
        Iterator r19 = r18.iterator();
    L21:
        if (r19.hasNext() == false) goto L23;
        String r20 = (String) r19.next();
        this.a.put(r20, r10);
        goto L21
    L23:
        ConcurrentHashMap<Class<? extends AIBridgeMethod>, d> r21 = g.a;
        Intrinsics.checkNotNullParameter(r10, "clazz");
        if (g.a.contains(r10) == true) goto L31;
        p2.c.c(new f(r10));
        return;
    L31:
        return;
    L11:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // f3.l
    public final AIBridgeMethod a(String r10, ContainerType r11) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "aiContainerType");
        if (r10.length() != 0) goto L5;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L9;
        return null;
    L9:
        Class<? extends AIBridgeMethod> r13 = this.a.get(r10);
        if (r13 != null) goto L12;
        return null;
    L12:
        return r13.newInstance();
    L5:
        r12 = false;
        goto L7
    }
}
