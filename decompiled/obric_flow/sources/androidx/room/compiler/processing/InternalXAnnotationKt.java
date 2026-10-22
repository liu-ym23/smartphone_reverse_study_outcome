package androidx.room.compiler.processing;

import java.lang.annotation.Repeatable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"unwrapRepeatedAnnotationsFromContainer", "", "Landroidx/room/compiler/processing/XAnnotation;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InternalXAnnotationKt {
    public static final List<XAnnotation> unwrapRepeatedAnnotationsFromContainer(XAnnotation r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getAnnotationValues().size() == 1) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r10.getAnnotationValues().get(0).getName(), "value") == true) goto L8;
        return null;
    L8:
        if (r10.getAnnotationValues().get(0).hasAnnotationListValue() == false) goto L35;
        List<XAnnotation> r11 = r10.getAsAnnotationList("value");     // Catch: Throwable -> L26
        if (r11.isEmpty() == true) goto L36;
        if (r11 != null) goto L14;
    L16:
        Iterator<T> r5 = r11.iterator();     // Catch: Throwable -> L26
    L17:
        if (r5.hasNext() == false) goto L25;
        XTypeElement r12 = ((XAnnotation) r5.next()).getType().getTypeElement();     // Catch: Throwable -> L26
        if (r12 == null) goto L38;
        if (r12.hasAnyAnnotation(new KClass[]{Reflection.getOrCreateKotlinClass(Repeatable.class), Reflection.getOrCreateKotlinClass(kotlin.annotation.Repeatable.class)}) == true) goto L17;
        return null;
    L38:
        return null;
    L25:
        return r11;
    L14:
        if (r11.isEmpty() == false) goto L16;
    L36:
        return null;
    L35:
        return null;
    L37:
        return null;
    }
}
