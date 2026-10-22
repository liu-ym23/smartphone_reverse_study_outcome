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

    ClassDescriptor getClassResolvedFromSource(FqName r10);

    void recordClass(JavaClass r10, ClassDescriptor r11);

    void recordConstructor(JavaElement r10, ConstructorDescriptor r11);

    void recordField(JavaField r10, PropertyDescriptor r11);

    void recordMethod(JavaMember r10, SimpleFunctionDescriptor r11);
}
