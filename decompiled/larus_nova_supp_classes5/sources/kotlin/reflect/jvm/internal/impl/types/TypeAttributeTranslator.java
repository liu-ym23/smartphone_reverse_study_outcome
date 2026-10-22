package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface TypeAttributeTranslator {
    TypeAttributes toAttributes(Annotations r1, TypeConstructor r2, DeclarationDescriptor r3);
}
