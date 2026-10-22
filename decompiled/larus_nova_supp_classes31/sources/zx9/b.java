package zx9;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements a {
    public final ConcurrentHashMap<String, List<Pair<String, wx9.a>>> a;

    public final io.opentelemetry.context.b root() {
        return io.opentelemetry.context.a.b;
    }

    public final io.opentelemetry.context.b current() {
        wx9.b r0 = wx9.b.c;
        return wx9.b.c;
    }

    public b() {
        this.a = new ConcurrentHashMap();
    }

    @Override // zx9.a
    public final void b(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "traceId");
        Intrinsics.checkNotNullParameter(r7, "spanId");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r0 = this.a.get(r6);     // Catch: Throwable -> L22
        if (r0 == null) goto L19;
        Iterator<Pair<String, wx9.a>> r1 = r0.iterator();     // Catch: Throwable -> L22
        int r2 = 0;
    L8:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r1.next().getFirst(), r7) == true) goto L14;
        r2 = r2 + 1;     // Catch: Throwable -> L22
    L14:
        if (r2 == (-1)) goto L17;
        r0.remove(r2);     // Catch: Throwable -> L22
    L17:
        if (r0.isEmpty() == false) goto L19;
        this.a.remove(r6);     // Catch: Throwable -> L22
        goto L19
    L13:
        r2 = -1;
    L19:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // zx9.a
    public final wx9.a c(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "tag");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r6 = this.a.get(r4);     // Catch: Throwable -> L21
        wx9.a r0 = null;
        if (r6 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Iterator<T> r7 = r6.iterator();     // Catch: Throwable -> L21
    L11:
        if (r7.hasNext() == false) goto L15;
        Object r1 = r7.next();     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(((wx9.a) ((Pair) r1).getSecond()).c().h, r5) == false) goto L11;
    L16:
        Pair r2 = (Pair) r1;     // Catch: Throwable -> L21
        if (r2 == null) goto L19;
        r0 = (wx9.a) r2.getSecond();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return r0;
    L15:
        r1 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // zx9.a
    public wx9.a getContext(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "spanId");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r6 = this.a.get(r4);     // Catch: Throwable -> L21
        wx9.a r0 = null;
        if (r6 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Iterator<T> r7 = r6.iterator();     // Catch: Throwable -> L21
    L11:
        if (r7.hasNext() == false) goto L15;
        Object r1 = r7.next();     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(((Pair) r1).getFirst(), r5) == false) goto L11;
    L16:
        Pair r2 = (Pair) r1;     // Catch: Throwable -> L21
        if (r2 == null) goto L19;
        r0 = (wx9.a) r2.getSecond();     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return r0;
    L15:
        r1 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // zx9.a
    public final void a(String r7, String r8, wx9.a r9) {
        Intrinsics.checkNotNullParameter(r7, "traceId");
        Intrinsics.checkNotNullParameter(r8, "spanId");
        Intrinsics.checkNotNullParameter(r9, "context");
        monitor-enter(this);
        List<Pair<String, wx9.a>> r0 = this.a.get(r7);     // Catch: Throwable -> L25
        Pair<String, wx9.a> r10 = TuplesKt.to(r8, r9);     // Catch: Throwable -> L25
        boolean r1 = true;
        if (r0 != null) goto L7;
        this.a.put(r7, CollectionsKt.mutableListOf(new Pair[]{r10}));     // Catch: Throwable -> L25
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L7:
        Iterator<Pair<String, wx9.a>> r12 = r0.iterator();     // Catch: Throwable -> L25
        int r3 = 0;
    L9:
        if (r12.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(r12.next().getFirst(), r8) == true) goto L15;
        r3 = r3 + 1;     // Catch: Throwable -> L25
    L15:
        if (r3 == (-1)) goto L18;
        r1 = false;
    L18:
        if (r1 == true) goto L21;
        r0 = null;
    L21:
        if (r0 == null) goto L23;
        r0.add(r10);     // Catch: Throwable -> L25
        goto L23
    L14:
        r3 = -1;
    L25:
        th = move-exception;
        throw th;
    }
}
