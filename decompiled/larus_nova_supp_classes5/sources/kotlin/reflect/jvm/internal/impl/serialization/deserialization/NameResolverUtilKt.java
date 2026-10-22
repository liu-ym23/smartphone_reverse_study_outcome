package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return ClassId.Companion.fromString(r2.getQualifiedClassName(r3), r2.isLocalClassName(r3));
    }

    public static final Name getName(NameResolver r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Name.guessByFirstCharacter(r1.getString(r2));
    }
}
