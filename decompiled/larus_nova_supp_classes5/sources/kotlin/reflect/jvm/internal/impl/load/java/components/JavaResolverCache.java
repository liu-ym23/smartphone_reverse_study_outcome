package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface JavaResolverCache {
    public static final JavaResolverCache EMPTY = null;

    ClassDescriptor getClassResolvedFromSource(FqName r1);

    void recordClass(JavaClass r1, ClassDescriptor r2);

    void recordConstructor(JavaElement r1, ConstructorDescriptor r2);

    void recordField(JavaField r1, PropertyDescriptor r2);

    void recordMethod(JavaMember r1, SimpleFunctionDescriptor r2);

    static {
        EMPTY = new AnonymousClass1();
    }
}
