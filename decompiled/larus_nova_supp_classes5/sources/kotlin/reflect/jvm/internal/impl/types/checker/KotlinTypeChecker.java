package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = null;

    public interface TypeConstructorEquality {
        boolean equals(TypeConstructor r1, TypeConstructor r2);
    }

    boolean equalTypes(KotlinType r1, KotlinType r2);

    boolean isSubtypeOf(KotlinType r1, KotlinType r2);

    static {
        DEFAULT = NewKotlinTypeChecker.Companion.getDefault();
    }
}
