package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FieldDescriptorImpl extends AnnotatedImpl implements FieldDescriptor {
    private final PropertyDescriptor correspondingProperty;

    public FieldDescriptorImpl(Annotations r2, PropertyDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "annotations");
        Intrinsics.checkNotNullParameter(r3, "correspondingProperty");
        super(r2);
        this.correspondingProperty = r3;
    }
}
