package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstantValue<T> {
    private final T value;

    public ConstantValue(T r5) {
        this.value = r5;
    }

    public boolean equals(Object r5) {
        if (this == r5) goto L13;
        T r10 = getValue();
        Object r11 = null;
        if ((r5 instanceof ConstantValue) == false) goto L6;
        ConstantValue r12 = (ConstantValue) r5;
    L7:
        if (r12 == null) goto L10;
        r11 = r12.getValue();
    L10:
        if (Intrinsics.areEqual(r10, r11) == true) goto L13;
        return false;
    L6:
        r12 = null;
    L13:
        return true;
    }

    public abstract KotlinType getType(ModuleDescriptor r5);

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T r5 = getValue();
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.hashCode();
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
