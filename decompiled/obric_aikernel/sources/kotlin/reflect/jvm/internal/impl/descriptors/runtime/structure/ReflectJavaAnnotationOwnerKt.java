package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationOwnerKt {
    public static final ReflectJavaAnnotation findAnnotation(Annotation[] r10, FqName r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        int r12 = r10.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L9;
        Annotation r14 = r10[r13];
        if (Intrinsics.areEqual(ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(r14))).asSingleFqName(), r11) == true) goto L10;
        r13 = r13 + 1;
    L10:
        if (r14 != null) goto L12;
        return null;
    L12:
        return new ReflectJavaAnnotation(r14);
    L9:
        r14 = null;
        goto L10
    }

    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(new ReflectJavaAnnotation(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }
}
