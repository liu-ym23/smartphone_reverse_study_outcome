package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstantValue<T> {
    private final T value;

    public ConstantValue(T r10) {
        this.value = r10;
    }

    public boolean equals(Object r10) {
        if (this == r10) goto L13;
        T r11 = getValue();
        Object r12 = null;
        if ((r10 instanceof ConstantValue) == false) goto L6;
        ConstantValue r13 = (ConstantValue) r10;
    L7:
        if (r13 == null) goto L10;
        r12 = r13.getValue();
    L10:
        if (Intrinsics.areEqual(r11, r12) == true) goto L13;
        return false;
    L6:
        r13 = null;
    L13:
        return true;
    }

    public abstract KotlinType getType(ModuleDescriptor r10);

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T r10 = getValue();
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.hashCode();
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
