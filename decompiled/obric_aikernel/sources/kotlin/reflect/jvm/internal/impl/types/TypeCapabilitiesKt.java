package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeCapabilitiesKt {
    public static final CustomTypeParameter getCustomTypeParameter(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r11 = r10.unwrap();
        if ((r11 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r12 = (CustomTypeParameter) r11;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        if (r12.isTypeParameter() == true) goto L10;
        return null;
    L10:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    public static final boolean isCustomTypeParameter(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Object r11 = r10.unwrap();
        if ((r11 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r12 = (CustomTypeParameter) r11;
    L6:
        if (r12 != null) goto L10;
        return false;
    L10:
        return r12.isTypeParameter();
    L5:
        r12 = null;
        goto L6
    }
}
