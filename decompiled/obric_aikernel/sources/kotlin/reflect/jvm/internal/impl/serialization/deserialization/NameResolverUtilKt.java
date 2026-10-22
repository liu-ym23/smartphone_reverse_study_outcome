package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ClassId r12 = ClassId.fromString(r10.getQualifiedClassName(r11), r10.isLocalClassName(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "fromString(getQualifiedC… isLocalClassName(index))");
        return r12;
    }

    public static final Name getName(NameResolver r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Name r12 = Name.guessByFirstCharacter(r10.getString(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "guessByFirstCharacter(getString(index))");
        return r12;
    }
}
