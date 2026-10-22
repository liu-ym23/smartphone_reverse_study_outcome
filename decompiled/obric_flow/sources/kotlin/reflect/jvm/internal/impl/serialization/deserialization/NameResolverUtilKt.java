package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class NameResolverUtilKt {
    public static final ClassId getClassId(NameResolver r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ClassId.fromString(r5.getQualifiedClassName(r10), r5.isLocalClassName(r10));
    }

    public static final Name getName(NameResolver r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Name.guessByFirstCharacter(r5.getString(r10));
    }
}
