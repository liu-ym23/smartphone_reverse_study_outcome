package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
final /* synthetic */ class a2 {
    public static final z a(v1 r10) {
        return new x1(r10);
    }

    public static /* synthetic */ z b(v1 r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return y1.a(r10);
    }

    public static final void c(CoroutineContext r10, CancellationException r11) {
        v1 r12 = (v1) r10.get(v1.f10723e);
        if (r12 == null) goto L6;
        r12.c(r11);
        return;
    }

    public static /* synthetic */ void d(CoroutineContext r10, CancellationException r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = null;
    L5:
        y1.c(r10, r11);
    }

    public static final b1 e(v1 r10, b1 r11) {
        return r10.A(new d1(r11));
    }

    public static final void f(CoroutineContext r10) {
        v1 r11 = (v1) r10.get(v1.f10723e);
        if (r11 == null) goto L6;
        y1.h(r11);
        return;
    }

    public static final void g(v1 r10) {
        if (r10.isActive() == false) goto L6;
        return;
    L6:
        throw r10.p();
    }

    public static final v1 h(CoroutineContext r10) {
        v1 r11 = (v1) r10.get(v1.f10723e);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r10).toString());
    }
}
