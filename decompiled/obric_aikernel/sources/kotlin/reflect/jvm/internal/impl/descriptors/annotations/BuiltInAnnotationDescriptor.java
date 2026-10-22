package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {
    private final Map<Name, ConstantValue<?>> allValueArguments;
    private final KotlinBuiltIns builtIns;
    private final FqName fqName;
    private final Lazy type$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(KotlinBuiltIns r10, FqName r11, Map<Name, ? extends ConstantValue<?>> r12) {
        Intrinsics.checkNotNullParameter(r10, "builtIns");
        Intrinsics.checkNotNullParameter(r11, "fqName");
        Intrinsics.checkNotNullParameter(r12, "allValueArguments");
        this.builtIns = r10;
        this.fqName = r11;
        this.allValueArguments = r12;
        this.type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BuiltInAnnotationDescriptor$type$2(this));
    }

    public static final /* synthetic */ KotlinBuiltIns access$getBuiltIns$p(BuiltInAnnotationDescriptor r10) {
        return r10.builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return this.allValueArguments;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement r10 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r10, "NO_SOURCE");
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public KotlinType getType() {
        Object r10 = this.type$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r10, "<get-type>(...)");
        return (KotlinType) r10;
    }
}
