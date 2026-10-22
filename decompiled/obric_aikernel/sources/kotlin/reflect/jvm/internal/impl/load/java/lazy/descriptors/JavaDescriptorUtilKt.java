package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaDescriptorUtilKt {
    public static final boolean isJavaField(PropertyDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getGetter() != null) goto L5;
        return true;
    L5:
        return false;
    }
}
