package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public interface KProperty2<D, E, V> extends KProperty<V>, Function2<D, E, V> {

    public interface Getter<D, E, V> extends KProperty.Getter<V>, Function2<D, E, V> {
    }

    V get(D r10, E r11);

    @SinceKotlin(version = "1.1")
    Object getDelegate(D r10, E r11);

    @Override // kotlin.reflect.KProperty
    Getter<D, E, V> getGetter();
}
