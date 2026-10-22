package kotlin.properties;

import kotlin.SinceKotlin;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.4")
public interface PropertyDelegateProvider<T, D> {
    D provideDelegate(T r10, KProperty<?> r11);
}
