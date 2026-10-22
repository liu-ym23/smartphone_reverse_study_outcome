package kotlin.properties;

import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public interface ReadWriteProperty<T, V> extends ReadOnlyProperty<T, V> {
    @Override // kotlin.properties.ReadOnlyProperty
    V getValue(T r10, KProperty<?> r11);

    void setValue(T r10, KProperty<?> r11, V r12);
}
