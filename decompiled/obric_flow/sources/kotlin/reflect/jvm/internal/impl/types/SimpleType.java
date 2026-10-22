package kotlin.reflect.jvm.internal.impl.types;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    public SimpleType() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType makeNullableAsSpecified(boolean r5);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAttributes(TypeAttributes r5);

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        Iterator<AnnotationDescriptor> r5 = getAnnotations().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        AnnotationDescriptor r11 = r5.next();
        StringsKt.a(r10, new String[]{"[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, r11, null, 2, null), "] "});
        goto L4
    L6:
        r10.append(getConstructor());
        if (getArguments().isEmpty() == true) goto L10;
        CollectionsKt.p(getArguments(), r10, ", ", "<", ">", null, 112);
    L10:
        if (isMarkedNullable() == false) goto L13;
        r10.append("?");
    L13:
        return r10.toString();
    }
}
