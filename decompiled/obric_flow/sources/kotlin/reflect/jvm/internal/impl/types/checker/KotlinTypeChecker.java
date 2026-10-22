package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes3.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = null;

    public interface TypeConstructorEquality {
        boolean equals(TypeConstructor r5, TypeConstructor r10);
    }

    static {
        DEFAULT = NewKotlinTypeChecker.Companion.getDefault();
    }

    boolean equalTypes(KotlinType r5, KotlinType r10);

    boolean isSubtypeOf(KotlinType r5, KotlinType r10);
}
