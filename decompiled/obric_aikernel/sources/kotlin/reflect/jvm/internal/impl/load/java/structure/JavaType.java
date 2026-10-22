package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaType extends ListBasedJavaAnnotationOwner {

    public static final class DefaultImpls {
        public static JavaAnnotation findAnnotation(JavaType r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r11, "fqName");
            return ListBasedJavaAnnotationOwner.DefaultImpls.findAnnotation(r10, r11);
        }
    }
}
