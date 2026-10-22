package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class MemberScopeKt {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        HashSet r11 = new HashSet();
        Iterator<? extends MemberScope> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Set<Name> r13 = r12.next().getClassifierNames();
        if (r13 == null) goto L7;
        CollectionsKt.addAll(r11, r13);
        goto L4
    L7:
        return null;
    L12:
        return r11;
    }
}
