package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface ListBasedJavaAnnotationOwner extends JavaAnnotationOwner {

    public static final class DefaultImpls {
        public static JavaAnnotation findAnnotation(ListBasedJavaAnnotationOwner r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r11, "fqName");
            Iterator<T> r12 = r10.getAnnotations().iterator();
        L3:
            Object r13 = null;
            if (r12.hasNext() == false) goto L12;
            Object r14 = r12.next();
            ClassId r15 = ((JavaAnnotation) r14).getClassId();
            if (r15 == null) goto L9;
            r13 = r15.asSingleFqName();
        L9:
            if (Intrinsics.areEqual(r13, r11) == false) goto L3;
            r13 = r14;
        L12:
            return (JavaAnnotation) r13;
        }
    }
}
