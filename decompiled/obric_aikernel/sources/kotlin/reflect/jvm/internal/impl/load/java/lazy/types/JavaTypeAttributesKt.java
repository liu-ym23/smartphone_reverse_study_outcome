package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeAttributesKt {
    public static final JavaTypeAttributes toAttributes(TypeUsage r10, boolean r11, boolean r12, TypeParameterDescriptor r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r13 == null) goto L5;
        Set r14 = SetsKt.setOf(r13);
    L7:
        return new JavaTypeAttributes(r10, null, r12, r11, r14, null, 34, null);
    L5:
        r14 = null;
        goto L7
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage r10, boolean r11, boolean r12, TypeParameterDescriptor r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = false;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = null;
    L12:
        return toAttributes(r10, r11, r12, r13);
    }
}
