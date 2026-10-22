package kotlin.reflect.full;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KProperties")
public final class KProperties {
    @SinceKotlin(version = "1.1")
    public static final Object getExtensionDelegate(KProperty1<?, ?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getDelegate(KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }

    @SinceKotlin(version = "1.1")
    public static final <D> Object getExtensionDelegate(KProperty2<D, ?, ?> r10, D r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getDelegate(r11, KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }
}
