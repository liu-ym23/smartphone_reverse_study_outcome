package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJavaTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaTypeAttributes.kt\norg/jetbrains/kotlin/load/java/lazy/types/JavaTypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class JavaTypeAttributesKt {
    public static final JavaTypeAttributes toAttributes(TypeUsage r10, boolean r11, boolean r12, TypeParameterDescriptor r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r13 == null) goto L6;
        Set r14 = SetsKt.setOf(r13);
    L8:
        return new JavaTypeAttributes(r10, null, r12, r11, r14, null, 34, null);
    L6:
        r14 = null;
        goto L8
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage r5, boolean r10, boolean r11, TypeParameterDescriptor r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = false;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return toAttributes(r5, r10, r11, r12);
    }
}
