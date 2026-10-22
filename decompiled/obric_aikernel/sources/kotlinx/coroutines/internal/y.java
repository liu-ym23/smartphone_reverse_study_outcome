package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.g2;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f10595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f10596b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final g2 f10597c = null;

    static {
        y r10 = new y();
        f10595a = r10;
        f10596b = j0.f("kotlinx.coroutines.fast.service.loader", true);
        f10597c = r10.a();
    }

    private y() {
    }

    private final g2 a() {
    L25:
        th = move-exception;
        return z.b(th, null, 2, null);
    L4:
        if (f10596b == false) goto L6;
        List<w> r10 = n.f10565a.c();     // Catch: Throwable -> L25
    L7:
        Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L25
        if (r11.hasNext() == true) goto L10;
        Object r12 = null;
    L19:
        w r13 = (w) r12;     // Catch: Throwable -> L25
        if (r13 == null) goto L23;
        g2 r14 = z.e(r13, r10);     // Catch: Throwable -> L25
        if (r14 == null) goto L23;
        return r14;
    L23:
        return z.b(null, null, 3, null);
    L10:
        r12 = r11.next();     // Catch: Throwable -> L25
        if (r11.hasNext() == false) goto L19;
        int r15 = ((w) r12).c();     // Catch: Throwable -> L25
    L14:
        Object r16 = r11.next();     // Catch: Throwable -> L25
        int r17 = ((w) r16).c();     // Catch: Throwable -> L25
        if (r15 >= r17) goto L18;
        r12 = r16;
        r15 = r17;
    L18:
        if (r11.hasNext() == true) goto L14;
    L6:
        r10 = SequencesKt.toList(SequencesKt.asSequence(x.a()));     // Catch: Throwable -> L25
        goto L7
    }
}
