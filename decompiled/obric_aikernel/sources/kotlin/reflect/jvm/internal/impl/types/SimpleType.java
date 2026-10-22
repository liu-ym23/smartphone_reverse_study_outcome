package kotlin.reflect.jvm.internal.impl.types;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
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
    public abstract SimpleType makeNullableAsSpecified(boolean r10);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAttributes(TypeAttributes r10);

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        Iterator<AnnotationDescriptor> r11 = getAnnotations().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        StringsKt.append(r10, new String[]{"[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, r11.next(), null, 2, null), "] "});
        goto L4
    L6:
        r10.append(getConstructor());
        if ((!getArguments().isEmpty()) == false) goto L10;
        CollectionsKt.joinTo$default(getArguments(), r10, ", ", "<", ">", 0, null, null, 112, null);
    L10:
        if (isMarkedNullable() == false) goto L12;
        r10.append("?");
    L12:
        String r12 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "StringBuilder().apply(builderAction).toString()");
        return r12;
    }
}
