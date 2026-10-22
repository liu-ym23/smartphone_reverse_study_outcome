package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String access$toRuntimeFqName(ClassId r5) {
        return toRuntimeFqName(r5);
    }

    private static final String toRuntimeFqName(ClassId r5) {
        String r10 = StringsKt.E(r5.getRelativeClassName().asString(), '.', Typography.dollar);
        if (r5.getPackageFqName().isRoot() == false) goto L6;
        return r10;
    L6:
        return r5.getPackageFqName() + '.' + r10;
    }
}
