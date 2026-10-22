package com.obric.assistant.upload.internal;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final Map<String, Set<oha.a>> a = null;
    public static final CoroutineScope b = null;

    static {
        a = Collections.synchronizedMap(new LinkedHashMap());
        b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new d())));
    }

    public static void a(String r2, oha.a r3) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "uploadListener");
        Map<String, Set<oha.a>> r0 = a;
        Set<oha.a> r1 = r0.get(r2);
        if (r1 != null) goto L5;
        r1 = new CopyOnWriteArraySet();
    L5:
        r1.add(r3);
        r0.put(r2, r1);
        if (r0.size() <= 10) goto L9;
        r0.remove(CollectionsKt.first(r0.keySet()));
        return;
    }
}
