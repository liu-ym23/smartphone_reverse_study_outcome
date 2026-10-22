package kotlin.reflect.full;

import com.bytedance.crash.entity.EventBody;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KAnnotatedElements")
public final class KAnnotatedElements {
    @SinceKotlin(version = "1.1")
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getAnnotations().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        Intrinsics.reifiedOperationMarker(3, "T");
        if ((((Annotation) r12) instanceof Annotation) == false) goto L4;
    L9:
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) r12;
    L8:
        r12 = null;
        goto L9
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> List<T> findAnnotations(KAnnotatedElement r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return findAnnotations(r10, Reflection.getOrCreateKotlinClass(Annotation.class));
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Annotation> List<T> findAnnotations(KAnnotatedElement r10, KClass<T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "klass");
        List<T> r12 = CollectionsKt.filterIsInstance(r10.getAnnotations(), JvmClassMappingKt.getJavaClass(r11));
        if ((!r12.isEmpty()) == false) goto L5;
        return r12;
    L5:
        Class<? extends Annotation> r13 = Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(JvmClassMappingKt.getJavaClass(r11));
        if (r13 == null) goto L19;
        Iterator<T> r14 = r10.getAnnotations().iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r15)), r13) == false) goto L9;
    L14:
        Annotation r16 = (Annotation) r15;
        if (r16 == null) goto L19;
        Object r17 = r16.getClass().getMethod(EventBody.KEY_VALUE, new Class[0]).invoke(r16, new Object[0]);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
        return ArraysKt.asList((Annotation[]) r17);
    L13:
        r15 = null;
    L19:
        return CollectionsKt.emptyList();
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<T> r11 = r10.getAnnotations().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        Intrinsics.reifiedOperationMarker(3, "T");
        if ((((Annotation) r12) instanceof Annotation) == false) goto L4;
    L9:
        Intrinsics.reifiedOperationMarker(1, "T?");
        if (((Annotation) r12) != null) goto L17;
        return false;
    L17:
        return true;
    L8:
        r12 = null;
        goto L9
    }
}
