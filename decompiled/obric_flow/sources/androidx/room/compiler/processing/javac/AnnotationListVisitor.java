package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00042\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/room/compiler/processing/javac/AnnotationListVisitor;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljavax/lang/model/util/SimpleAnnotationValueVisitor8;", "", "Landroidx/room/compiler/processing/javac/JavacAnnotationBox;", "Ljava/lang/Void;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "annotationClass", "Ljava/lang/Class;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljava/lang/Class;)V", "visitArray", "values", "", "Ljavax/lang/model/element/AnnotationValue;", "void", "(Ljava/util/List;Ljava/lang/Void;)[Landroidx/room/compiler/processing/javac/JavacAnnotationBox;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AnnotationListVisitor<T extends Annotation> extends SimpleAnnotationValueVisitor8<JavacAnnotationBox<T>[], Void> {
    private final Class<T> annotationClass;
    private final JavacProcessingEnv env;

    public AnnotationListVisitor(JavacProcessingEnv r5, Class<T> r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "annotationClass");
        this.env = r5;
        this.annotationClass = r10;
    }

    public /* bridge */ /* synthetic */ Object visitArray(List r5, Object r10) {
        return visitArray(r5, (Void) r10);
    }

    public JavacAnnotationBox<T>[] visitArray(List<? extends AnnotationValue> r5, Void r10) {
        AnnotationClassVisitor r11 = new AnnotationClassVisitor(this.env, this.annotationClass);
        if (r5 == null) goto L13;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r5.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        JavacAnnotationBox r14 = (JavacAnnotationBox) r11.visit((AnnotationValue) r13.next());
        if (r14 == null) goto L6;
        r12.add(r14);
        goto L6
    L10:
        Object[] r15 = r12.toArray(new JavacAnnotationBox[0]);
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        JavacAnnotationBox<T>[] r16 = (JavacAnnotationBox[]) r15;
        if (r16 == null) goto L13;
        return r16;
    L13:
        return new JavacAnnotationBox[0];
    }
}
