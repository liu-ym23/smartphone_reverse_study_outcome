package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i0 f10545a = null;

    static {
        f10545a = new i0("CLOSED");
    }

    public static final /* synthetic */ i0 a() {
        return f10545a;
    }

    public static final <N extends f<N>> N b(N r10) {
    L2:
        Object r11 = f.a(r10);
        if (r11 == a()) goto L4;
        f r12 = (f) r11;
        if (r12 == null) goto L8;
        r10 = (N) r12;
        goto L2
    L8:
        if (r10.j() == false) goto L2;
        return r10;
    L4:
        return r10;
    }

    public static final <S extends f0<S>> Object c(S r10, long r11, Function2<? super Long, ? super S, ? extends S> r12) {
    L3:
        if (r10.f10550h >= r11) goto L5;
    L9:
        Object r13 = f.a(r10);
        if (r13 == a()) goto L12;
        S r14 = (S) ((f) r13);
        if (r14 != null) goto L15;
        r14 = r12.invoke(Long.valueOf(r10.f10550h + 1), r10);
        if (r10.l(r14) == false) goto L3;
        if (r10.h() == false) goto L15;
        r10.k();
    L15:
        r10 = (Object) r14;
        goto L3
    L12:
        return g0.a(f10545a);
    L5:
        if (r10.h() == true) goto L9;
        return g0.a(r10);
    }
}
