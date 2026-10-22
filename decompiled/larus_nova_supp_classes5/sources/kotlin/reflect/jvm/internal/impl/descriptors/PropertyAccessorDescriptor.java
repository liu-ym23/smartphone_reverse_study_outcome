package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface PropertyAccessorDescriptor extends VariableAccessorDescriptor {
    PropertyDescriptor getCorrespondingProperty();

    boolean isDefault();
}
