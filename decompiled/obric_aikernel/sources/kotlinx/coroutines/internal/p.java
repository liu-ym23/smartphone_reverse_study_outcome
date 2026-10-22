package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@JvmInline
@SourceDebugExtension({"SMAP\nInlineList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class p<E> {
    public static <E> Object a(Object r10) {
        return r10;
    }

    public static /* synthetic */ Object b(Object r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return a(r10);
    }

    public static final Object c(Object r10, E r11) {
        if (kotlinx.coroutines.n0.a() == true) goto L5;
    L9:
        if (r10 != null) goto L12;
        return a(r11);
    L12:
        if ((r10 instanceof ArrayList) == false) goto L14;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ((ArrayList) r10).add(r11);
        return a(r10);
    L14:
        ArrayList r12 = new ArrayList(4);
        r12.add(r10);
        r12.add(r11);
        return a(r12);
    L5:
        if ((!(r11 instanceof List)) == true) goto L9;
        throw new AssertionError();
    }
}
