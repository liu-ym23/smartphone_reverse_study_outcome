package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    public NullableArrayMapAccessor(KClass<? extends K> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        super(r10, r11);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object r10, KProperty r11) {
        return getValue((AbstractArrayMapOwner) r10, r11);
    }

    public T getValue(AbstractArrayMapOwner<K, V> r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        return extractValue(r10);
    }
}
