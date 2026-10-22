package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String access$toRuntimeFqName(ClassId r10) {
        return toRuntimeFqName(r10);
    }

    private static final String toRuntimeFqName(ClassId r10) {
        String r11 = r10.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(r11, "relativeClassName.asString()");
        String r12 = StringsKt.replace$default(r11, '.', Typography.dollar, false, 4, null);
        if (r10.getPackageFqName().isRoot() == false) goto L6;
        return r12;
    L6:
        return r10.getPackageFqName() + '.' + r12;
    }
}
