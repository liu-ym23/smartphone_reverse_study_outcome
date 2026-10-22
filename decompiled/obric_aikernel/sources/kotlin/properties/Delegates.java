package kotlin.properties;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class Delegates {
    public static final Delegates INSTANCE = null;

    static {
        INSTANCE = new Delegates();
    }

    private Delegates() {
    }

    public final <T> ReadWriteProperty<Object, T> notNull() {
        return new NotNullVar();
    }

    public final <T> ReadWriteProperty<Object, T> observable(final T r10, final Function3<? super KProperty<?>, ? super T, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "onChange");
        return new AnonymousClass1(r10, r11);
    }

    public final <T> ReadWriteProperty<Object, T> vetoable(final T r10, final Function3<? super KProperty<?>, ? super T, ? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "onChange");
        return new C04081(r10, r11);
    }
}
