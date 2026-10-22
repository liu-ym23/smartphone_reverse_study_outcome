package androidx.room.compiler.processing;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\b\b\u0000\u0010\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/room/compiler/processing/InternalXAnnotation;", "Landroidx/room/compiler/processing/XAnnotation;", "()V", "valuesByName", "", "", "Landroidx/room/compiler/processing/XAnnotationValue;", "getValuesByName", "()Ljava/util/Map;", "valuesByName$delegate", "Lkotlin/Lazy;", "asAnnotationBox", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "annotationClass", "Ljava/lang/Class;", "getAnnotationValue", "methodName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
@PublishedApi
public abstract class InternalXAnnotation implements XAnnotation {
    private final Lazy valuesByName$delegate;

    public InternalXAnnotation() {
        this.valuesByName$delegate = LazyKt.lazy(new InternalXAnnotation$valuesByName$2(this));
    }

    private final Map<String, XAnnotationValue> getValuesByName() {
        return (Map) this.valuesByName$delegate.getValue();
    }

    public abstract <T extends Annotation> XAnnotationBox<T> asAnnotationBox(Class<T> r5);

    @Override // androidx.room.compiler.processing.XAnnotation
    public XAnnotationValue getAnnotationValue(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        XAnnotationValue r10 = getValuesByName().get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        StringBuilder r11 = j0.x("No property named ", r5, " was found in annotation ");
        r11.append(getName());
        throw new IllegalStateException(r11.toString().toString());
    }
}
