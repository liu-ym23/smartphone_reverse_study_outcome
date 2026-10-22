package androidx.room.compiler.processing;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0086\b\u001a\"\u0010\u0005\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\b\u001a-\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"asAnnotationBox", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/room/compiler/processing/XAnnotation;", "get", "methodName", "", "(Landroidx/room/compiler/processing/XAnnotation;Ljava/lang/String;)Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Landroidx/room/compiler/processing/XAnnotation;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XAnnotationKt {
    public static final /* synthetic */ <T extends Annotation> XAnnotationBox<T> asAnnotationBox(XAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return ((InternalXAnnotation) r5).asAnnotationBox(Annotation.class);
    }

    public static final /* synthetic */ <T> T get(XAnnotation r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) get(r5, r10, Object.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @Deprecated(message = "Use one of the getAs*() methods instead, e.g. getAsBoolean().")
    public static final <T> T get(XAnnotation r5, String r10, Class<T> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "clazz");
        XAnnotationValue r12 = r5.getAnnotationValue(r10);
        if (r12.hasListValue() == false) goto L8;
        List<XAnnotationValue> r13 = r12.asAnnotationValueList();
        ?? r14 = (T) new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L6:
        if (r15.hasNext() == false) goto L10;
        r14.add(((XAnnotationValue) r15.next()).getValue());
    L10:
        if (r11.isInstance((Object) r14) == true) goto L17;
        StringBuilder r16 = j0.x("Value of ", r10, " of type ");
        if (r14 == 0) goto L14;
        Class<?> r17 = ((Object) r14).getClass();
    L15:
        r16.append(r17);
        r16.append(" cannot be cast to ");
        r16.append(r11);
        throw new IllegalStateException(r16.toString().toString());
    L14:
        r17 = null;
        goto L15
    L17:
        return (T) r14;
    L8:
        r14 = (T) r12.getValue();
        goto L10
    }
}
