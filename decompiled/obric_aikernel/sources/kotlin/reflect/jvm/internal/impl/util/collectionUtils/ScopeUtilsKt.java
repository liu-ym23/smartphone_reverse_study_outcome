package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
public final class ScopeUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> r10, Collection<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "collection");
        if (r11.isEmpty() == false) goto L5;
        return r10;
    L5:
        if (r10 != 0) goto L8;
        return r11;
    L8:
        if ((r10 instanceof LinkedHashSet) == false) goto L11;
        ((LinkedHashSet) r10).addAll(r11);
        return r10;
    L11:
        LinkedHashSet r12 = new LinkedHashSet(r10);
        r12.addAll(r11);
        return r12;
    }

    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> r10) {
        Intrinsics.checkNotNullParameter(r10, "scopes");
        SmartList<MemberScope> r11 = new SmartList();
        Iterator<? extends MemberScope> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        MemberScope r13 = r12.next();
        MemberScope r14 = r13;
        if (r14 != null) goto L8;
    L10:
        boolean r15 = false;
    L11:
        if (r15 == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        if (r14 == MemberScope.Empty.INSTANCE) goto L10;
        r15 = true;
        goto L11
    L13:
        return r11;
    }
}
