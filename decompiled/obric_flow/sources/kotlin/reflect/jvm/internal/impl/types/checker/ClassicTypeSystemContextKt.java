package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* JADX INFO: loaded from: classes3.dex */
public final class ClassicTypeSystemContextKt {
    public static final /* synthetic */ UnwrappedType access$makeDefinitelyNotNullOrNotNullInternal(UnwrappedType r5) {
        return makeDefinitelyNotNullOrNotNullInternal(r5);
    }

    private static final UnwrappedType makeDefinitelyNotNullOrNotNullInternal(UnwrappedType r5) {
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull$default(r5, false, 1, null);
    }
}
