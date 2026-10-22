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

/* JADX INFO: loaded from: classes3.dex */
public interface JavaResolverCache {
    public static final JavaResolverCache EMPTY = null;

    static {
        EMPTY = new AnonymousClass1();
    }

    ClassDescriptor getClassResolvedFromSource(FqName r5);

    void recordClass(JavaClass r5, ClassDescriptor r10);

    void recordConstructor(JavaElement r5, ConstructorDescriptor r10);

    void recordField(JavaField r5, PropertyDescriptor r10);

    void recordMethod(JavaMember r5, SimpleFunctionDescriptor r10);
}
