package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaDescriptorUtilKt {
    public static final boolean isJavaField(PropertyDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getGetter() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
