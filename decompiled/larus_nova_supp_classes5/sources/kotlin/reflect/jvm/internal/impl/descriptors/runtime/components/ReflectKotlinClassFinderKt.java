package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String access$toRuntimeFqName(ClassId r0) {
        return toRuntimeFqName(r0);
    }

    private static final String toRuntimeFqName(ClassId r7) {
        String r0 = StringsKt.replace$default(r7.getRelativeClassName().asString(), '.', '$', false, 4, null);
        if (r7.getPackageFqName().isRoot() == false) goto L6;
        return r0;
    L6:
        return r7.getPackageFqName() + '.' + r0;
    }
}
