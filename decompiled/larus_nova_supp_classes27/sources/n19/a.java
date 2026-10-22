package n19;

import com.larus.common_ui.presentation.UiPresentationChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final a a = null;
    public static final Map<UiPresentationChannel, Set<String>> b = null;
    public static final Map<UiPresentationChannel, Map<String, Function0<Unit>>> c = null;
    public static final Map<UiPresentationChannel, Set<b>> d = null;

    public a() {
    }

    static {
        a = new a();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
        d = new LinkedHashMap();
    }

    public final synchronized boolean d(UiPresentationChannel r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "channel");     // Catch: Throwable -> L10
        Set r3 = (Set) ((LinkedHashMap) b).get(r2);     // Catch: Throwable -> L10
        if (r3 != null) goto L6;
        r3 = SetsKt.emptySet();     // Catch: Throwable -> L10
    L6:
        boolean r4 = !r3.isEmpty();
        monitor-exit(this);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a(UiPresentationChannel r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "ownerId");
        update(r3, r4, true, null);
    }

    public final synchronized void c(UiPresentationChannel r3, b r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "channel");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r4, "listener");     // Catch: Throwable -> L9
        LinkedHashMap r0 = (LinkedHashMap) d;     // Catch: Throwable -> L9
        Object r1 = r0.get(r3);     // Catch: Throwable -> L9
        if (r1 != null) goto L6;
        r1 = new LinkedHashSet();     // Catch: Throwable -> L9
        r0.put(r3, r1);     // Catch: Throwable -> L9
    L6:
        ((Set) r1).add(r4);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void e(UiPresentationChannel r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "ownerId");
        update(r3, r4, false, null);
    }

    public final void b(UiPresentationChannel r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "channel");
        Intrinsics.checkNotNullParameter(r3, "ownerId");
        Intrinsics.checkNotNullParameter(r4, "onPreemptRequested");
        update(r2, r3, true, r4);
    }

    private final void update(UiPresentationChannel r4, String r5, boolean r6, Function0<Unit> r7) {
        if (StringsKt.isBlank(r5) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        LinkedHashMap r0 = (LinkedHashMap) b;     // Catch: Throwable -> L37
        Object r1 = r0.get(r4);     // Catch: Throwable -> L37
        if (r1 != null) goto L9;
        r1 = new LinkedHashSet();     // Catch: Throwable -> L37
        r0.put(r4, r1);     // Catch: Throwable -> L37
    L9:
        Set r2 = (Set) r1;     // Catch: Throwable -> L37
        boolean r3 = !r2.isEmpty();     // Catch: Throwable -> L37
        if (r6 == false) goto L17;
        if (r7 == null) goto L16;
        LinkedHashMap r8 = (LinkedHashMap) c;     // Catch: Throwable -> L37
        Object r9 = r8.get(r4);     // Catch: Throwable -> L37
        if (r9 != null) goto L15;
        r9 = new LinkedHashMap();     // Catch: Throwable -> L37
        r8.put(r4, r9);     // Catch: Throwable -> L37
    L15:
        ((Map) r9).put(r5, r7);     // Catch: Throwable -> L37
    L16:
        boolean r10 = r2.add(r5);     // Catch: Throwable -> L37
    L21:
        boolean r11 = !r2.isEmpty();     // Catch: Throwable -> L37
        if (r10 == false) goto L35;
        if (r3 == r11) goto L35;
        Boolean r12 = Boolean.valueOf(r11);     // Catch: Throwable -> L37
        Set r13 = (Set) ((LinkedHashMap) d).get(r4);     // Catch: Throwable -> L37
        if (r13 != null) goto L28;
        r13 = SetsKt.emptySet();     // Catch: Throwable -> L37
    L28:
        Pair r14 = TuplesKt.to(r12, CollectionsKt.toList(r13));     // Catch: Throwable -> L37
        monitor-exit(this);
        Iterator r15 = ((Iterable) r14.getSecond()).iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        ((b) r15.next()).f(r4, ((Boolean) r14.getFirst()).booleanValue());
        goto L32
    L34:
        return;
    L35:
        monitor-exit(this);
        return;
    L17:
        Map r16 = (Map) ((LinkedHashMap) c).get(r4);     // Catch: Throwable -> L37
        if (r16 == null) goto L20;
        Function0 r17 = (Function0) r16.remove(r5);     // Catch: Throwable -> L37
    L20:
        r10 = r2.remove(r5);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }
}
