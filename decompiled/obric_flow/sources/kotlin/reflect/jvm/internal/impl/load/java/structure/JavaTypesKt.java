package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\njavaTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 javaTypes.kt\norg/jetbrains/kotlin/load/java/structure/JavaTypesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(JavaType r5) {
        if ((r5 instanceof JavaWildcardType) == false) goto L5;
        JavaWildcardType r10 = (JavaWildcardType) r5;
    L7:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (r10.getBound() != null) goto L11;
        return false;
    L11:
        if (r10.isExtends() == true) goto L16;
        return true;
    L16:
        return false;
    L5:
        r10 = null;
        goto L7
    }
}
