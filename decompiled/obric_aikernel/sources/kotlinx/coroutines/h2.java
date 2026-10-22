package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1364#1:1455,6\n*E\n"})
public final class h2 extends kotlinx.coroutines.internal.s implements p1 {
    public h2() {
    }

    @Override // kotlinx.coroutines.p1
    public h2 a() {
        return this;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return true;
    }

    public final String q(String r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append("List{");
        r11.append(r10);
        r11.append("}[");
        Object r12 = i();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode r13 = (LockFreeLinkedListNode) r12;
        boolean r14 = true;
    L4:
        if (Intrinsics.areEqual(r13, this) == true) goto L13;
        if ((r13 instanceof b2) == false) goto L12;
        b2 r15 = (b2) r13;
        if (r14 == false) goto L10;
        r14 = false;
    L11:
        r11.append(r15);
        goto L12
    L10:
        r11.append(", ");
    L12:
        r13 = r13.j();
        goto L4
    L13:
        r11.append("]");
        String r16 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        return r16;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        if (n0.c() == false) goto L6;
        return q("Active");
    L6:
        return super.toString();
    }
}
