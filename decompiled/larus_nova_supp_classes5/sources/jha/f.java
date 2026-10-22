package jha;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static final ExecutorCoroutineDispatcher a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, a> c = null;
    public static final Object d = null;

    public static final class a {
        public final CoroutineDispatcher a;
        public final CoroutineScope b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ProducerDispatcher(dispatcher=" + this.a + ", scope=" + this.b + ')';
        }

        public a(ExecutorCoroutineDispatcher r2, CoroutineScope r3) {
            Intrinsics.checkNotNullParameter(r2, "dispatcher");
            Intrinsics.checkNotNullParameter(r3, "scope");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        ExecutorCoroutineDispatcher r0 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new d()));
        a = r0;
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r0));
        c = new ConcurrentHashMap();
        d = new Object();
    }

    public static a a(String r3) {
        final String r4 = StringsKt.take(new Regex("[^A-Za-z0-9_-]").replace(r3, "_"), 48);
        ExecutorCoroutineDispatcher r5 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new e(r4)));
        return new a(r5, CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(r5)));
    }

    public static a b(String r3) {
        ConcurrentHashMap<String, a> r0 = c;
        a r1 = r0.get(r3);
        if (r1 == null) goto L5;
        return r1;
    L5:
        Object r2 = d;
        monitor-enter(r2);
        a r4 = r0.get(r3);     // Catch: Throwable -> L12
        if (r4 != null) goto L10;
        r4 = a(r3);     // Catch: Throwable -> L12
        r0.put(r3, r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r2);
        return r4;
    L12:
        th = move-exception;
        throw th;
    }
}
