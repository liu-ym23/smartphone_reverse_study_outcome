package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.InternalXAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XType;
import com.google.auto.common.o0;
import java.lang.annotation.Annotation;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\b\b\u0000\u0010\u001f*\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\"H\u0016R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacAnnotation;", "Landroidx/room/compiler/processing/InternalXAnnotation;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "mirror", "Ljavax/lang/model/element/AnnotationMirror;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/AnnotationMirror;)V", "annotationValues", "", "Landroidx/room/compiler/processing/XAnnotationValue;", "getAnnotationValues", "()Ljava/util/List;", "annotationValues$delegate", "Lkotlin/Lazy;", "getEnv", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "getMirror", "()Ljavax/lang/model/element/AnnotationMirror;", "name", "", "getName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "type", "Landroidx/room/compiler/processing/XType;", "getType", "()Landroidx/room/compiler/processing/XType;", "type$delegate", "asAnnotationBox", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "annotationClass", "Ljava/lang/Class;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacAnnotation extends InternalXAnnotation {
    private final Lazy annotationValues$delegate;
    private final JavacProcessingEnv env;
    private final AnnotationMirror mirror;
    private final Lazy type$delegate;

    public JavacAnnotation(JavacProcessingEnv r5, AnnotationMirror r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "mirror");
        this.env = r5;
        this.mirror = r10;
        this.type$delegate = LazyKt.lazy(new JavacAnnotation$type$2(this));
        this.annotationValues$delegate = LazyKt.lazy(new JavacAnnotation$annotationValues$2(this));
    }

    @Override // androidx.room.compiler.processing.InternalXAnnotation
    public <T extends Annotation> XAnnotationBox<T> asAnnotationBox(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationClass");
        return JavacAnnotationBoxKt.box(this.mirror, this.env, r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public List<XAnnotationValue> getAnnotationValues() {
        return (List) this.annotationValues$delegate.getValue();
    }

    public final JavacProcessingEnv getEnv() {
        return this.env;
    }

    public final AnnotationMirror getMirror() {
        return this.mirror;
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public String getName() {
        return this.mirror.getAnnotationType().asElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public String getQualifiedName() {
        return o0.g(this.mirror.getAnnotationType()).getQualifiedName().toString();
    }

    @Override // androidx.room.compiler.processing.XAnnotation
    public XType getType() {
        return (XType) this.type$delegate.getValue();
    }
}
