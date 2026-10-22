package androidx.room.compiler.processing;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0003\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016J@\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0003\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\bH&J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bH\u0016J,\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/InternalXAnnotated;", "Landroidx/room/compiler/processing/XAnnotated;", "getAnnotations", "", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "annotation", "Lkotlin/reflect/KClass;", "containerAnnotation", "hasAnnotation", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface InternalXAnnotated extends XAnnotated {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List getAnnotations$default(InternalXAnnotated r5, KClass r10, KClass r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = KClassExtKt.getContainerAnnotation(r10);
    L7:
        return r5.getAnnotations(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnotations");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean hasAnnotation$default(InternalXAnnotated r5, KClass r10, KClass r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L7;
        r11 = KClassExtKt.getContainerAnnotation(r10);
    L7:
        return r5.hasAnnotation(r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasAnnotation");
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    default <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return getAnnotations(r5, KClassExtKt.getContainerAnnotation(r5));
    }

    <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5, KClass<? extends Annotation> r10);

    @Override // androidx.room.compiler.processing.XAnnotated
    default boolean hasAnnotation(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return hasAnnotation(r5, KClassExtKt.getContainerAnnotation(r5));
    }

    boolean hasAnnotation(KClass<? extends Annotation> r5, KClass<? extends Annotation> r10);
}
