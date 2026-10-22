package com.larus.bmhome.chat.helper;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f0 {
    public static final CoroutineScope a = null;
    public static final WeakHashMap<a, Unit> b = null;
    public static Set<String> c;

    public interface a {
        void a(Set<String> r1);
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        new Handler(Looper.getMainLooper());
        new LinkedHashMap();
        b = new WeakHashMap();
        c = SetsKt.emptySet();
    }
}
