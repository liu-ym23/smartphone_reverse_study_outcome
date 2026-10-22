package kotlin.reflect;

import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public interface KProperty0<V> extends KProperty<V>, Function0<V> {

    public interface Getter<V> extends KProperty.Getter<V>, Function0<V> {
    }

    V get();

    @SinceKotlin(version = "1.1")
    Object getDelegate();

    @Override // kotlin.reflect.KProperty
    Getter<V> getGetter();
}
