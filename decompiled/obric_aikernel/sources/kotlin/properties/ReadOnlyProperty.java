package kotlin.properties;

import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public interface ReadOnlyProperty<T, V> {
    V getValue(T r10, KProperty<?> r11);
}
