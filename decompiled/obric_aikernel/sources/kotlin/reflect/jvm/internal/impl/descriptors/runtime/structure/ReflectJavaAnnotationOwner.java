package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    public static final class DefaultImpls {
        public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r11, "fqName");
            AnnotatedElement r12 = r10.getElement();
            if (r12 == null) goto L7;
            Annotation[] r13 = r12.getDeclaredAnnotations();
            if (r13 == null) goto L7;
            return ReflectJavaAnnotationOwnerKt.findAnnotation(r13, r11);
        L7:
            return null;
        }

        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner r10) {
            AnnotatedElement r11 = r10.getElement();
            if (r11 == null) goto L9;
            Annotation[] r12 = r11.getDeclaredAnnotations();
            if (r12 == null) goto L9;
            List<ReflectJavaAnnotation> r13 = ReflectJavaAnnotationOwnerKt.getAnnotations(r12);
            if (r13 == null) goto L9;
            return r13;
        L9:
            return CollectionsKt.emptyList();
        }

        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner r10) {
            return false;
        }
    }

    AnnotatedElement getElement();
}
