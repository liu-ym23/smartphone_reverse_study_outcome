package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationValue extends ConstantValue<AnnotationDescriptor> {
    public AnnotationValue(AnnotationDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        super(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        return getValue().getType();
    }
}
