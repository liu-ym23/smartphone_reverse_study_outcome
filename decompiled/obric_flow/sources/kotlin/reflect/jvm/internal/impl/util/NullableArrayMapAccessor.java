package kotlin.reflect.jvm.internal.impl.util;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    public NullableArrayMapAccessor(KClass<? extends K> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        super(r5, r10);
    }

    @Override // kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object r5, KProperty r10) {
        return getValue((AbstractArrayMapOwner) r5, r10);
    }

    public T getValue(AbstractArrayMapOwner<K, V> r5, KProperty<?> r10) {
        Intrinsics.checkNotNullParameter(r5, "thisRef");
        Intrinsics.checkNotNullParameter(r10, "property");
        return extractValue(r5);
    }
}
