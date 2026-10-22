package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* JADX INFO: loaded from: classes3.dex */
public interface KotlinTypeChecker {
    public static final KotlinTypeChecker DEFAULT = null;

    public interface TypeConstructorEquality {
        boolean equals(TypeConstructor r10, TypeConstructor r11);
    }

    static {
        DEFAULT = NewKotlinTypeChecker.Companion.getDefault();
    }

    boolean equalTypes(KotlinType r10, KotlinType r11);

    boolean isSubtypeOf(KotlinType r10, KotlinType r11);
}
