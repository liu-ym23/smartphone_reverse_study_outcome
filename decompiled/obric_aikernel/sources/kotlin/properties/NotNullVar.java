package kotlin.properties;

import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
final class NotNullVar<T> implements ReadWriteProperty<Object, T> {
    private T value;

    public NotNullVar() {
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "property");
        T r12 = this.value;
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Property " + r11.getName() + " should be initialized before get.");
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object r10, KProperty<?> r11, T r12) {
        Intrinsics.checkNotNullParameter(r11, "property");
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_VALUE);
        this.value = r12;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("NotNullProperty(");
        if (this.value == null) goto L5;
        String r11 = "value=" + this.value;
    L6:
        r10.append(r11);
        r10.append(')');
        return r10.toString();
    L5:
        r11 = "value not initialized yet";
        goto L6
    }
}
