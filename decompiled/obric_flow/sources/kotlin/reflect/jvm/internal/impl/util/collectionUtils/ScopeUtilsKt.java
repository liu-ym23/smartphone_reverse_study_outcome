package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nscopeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n112#1,2:141\n127#1,7:143\n4307#2,2:137\n857#3,2:139\n*S KotlinDebug\n*F\n+ 1 scopeUtils.kt\norg/jetbrains/kotlin/util/collectionUtils/ScopeUtilsKt\n*L\n109#1:141,2\n124#1:143,7\n85#1:137,2\n88#1:139,2\n*E\n"})
public final class ScopeUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> concat(Collection<? extends T> r5, Collection<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "collection");
        if (r10.isEmpty() == false) goto L5;
        return r5;
    L5:
        if (r5 != 0) goto L8;
        return r10;
    L8:
        if ((r5 instanceof LinkedHashSet) == false) goto L11;
        ((LinkedHashSet) r5).addAll(r10);
        return r5;
    L11:
        LinkedHashSet r11 = new LinkedHashSet(r5);
        r11.addAll(r10);
        return r11;
    }

    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> r5) {
        Intrinsics.checkNotNullParameter(r5, "scopes");
        SmartList<MemberScope> r10 = new SmartList();
        Iterator<? extends MemberScope> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        MemberScope r12 = r11.next();
        MemberScope r13 = r12;
        if (r13 == null) goto L4;
        if (r13 == MemberScope.Empty.INSTANCE) goto L4;
        r10.add(r12);
        goto L4
    L10:
        return r10;
    }
}
