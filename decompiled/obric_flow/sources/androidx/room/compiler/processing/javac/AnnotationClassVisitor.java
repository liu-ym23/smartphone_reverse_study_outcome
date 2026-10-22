package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/javac/AnnotationClassVisitor;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljavax/lang/model/util/SimpleAnnotationValueVisitor8;", "Landroidx/room/compiler/processing/javac/JavacAnnotationBox;", "Ljava/lang/Void;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "annotationClass", "Ljava/lang/Class;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljava/lang/Class;)V", "visitAnnotation", "a", "Ljavax/lang/model/element/AnnotationMirror;", "v", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AnnotationClassVisitor<T extends Annotation> extends SimpleAnnotationValueVisitor8<JavacAnnotationBox<T>, Void> {
    private final Class<T> annotationClass;
    private final JavacProcessingEnv env;

    public AnnotationClassVisitor(JavacProcessingEnv r5, Class<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "annotationClass");
        this.env = r5;
        this.annotationClass = r10;
    }

    public /* bridge */ /* synthetic */ Object visitAnnotation(AnnotationMirror r5, Object r10) {
        return visitAnnotation(r5, (Void) r10);
    }

    public JavacAnnotationBox<T> visitAnnotation(AnnotationMirror r5, Void r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return JavacAnnotationBoxKt.box(r5, this.env, this.annotationClass);
    }
}
