package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeCapabilitiesKt {
    public static final CustomTypeParameter getCustomTypeParameter(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r10 = r5.unwrap();
        if ((r10 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r11 = (CustomTypeParameter) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r11.isTypeParameter() == true) goto L10;
        return null;
    L10:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public static final boolean isCustomTypeParameter(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r10 = r5.unwrap();
        if ((r10 instanceof CustomTypeParameter) == false) goto L5;
        CustomTypeParameter r11 = (CustomTypeParameter) r10;
    L6:
        if (r11 != null) goto L10;
        return false;
    L10:
        return r11.isTypeParameter();
    L5:
        r11 = null;
        goto L6
    }
}
