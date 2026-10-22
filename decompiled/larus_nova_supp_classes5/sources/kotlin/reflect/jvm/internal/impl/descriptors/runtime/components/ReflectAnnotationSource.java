package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ReflectAnnotationSource implements SourceElement {
    private final Annotation annotation;

    public final Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    public SourceFile getContainingFile() {
        return SourceFile.NO_SOURCE_FILE;
    }

    public ReflectAnnotationSource(Annotation r2) {
        Intrinsics.checkNotNullParameter(r2, "annotation");
        this.annotation = r2;
    }
}
