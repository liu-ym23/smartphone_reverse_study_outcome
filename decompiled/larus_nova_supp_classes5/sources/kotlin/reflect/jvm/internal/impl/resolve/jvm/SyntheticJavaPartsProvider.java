package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final CompositeSyntheticJavaPartsProvider EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void generateConstructors(ClassDescriptor r1, List<ClassConstructorDescriptor> r2, LazyJavaResolverContext r3);

    void generateMethods(ClassDescriptor r1, Name r2, Collection<SimpleFunctionDescriptor> r3, LazyJavaResolverContext r4);

    void generateNestedClass(ClassDescriptor r1, Name r2, List<ClassDescriptor> r3, LazyJavaResolverContext r4);

    void generateStaticFunctions(ClassDescriptor r1, Name r2, Collection<SimpleFunctionDescriptor> r3, LazyJavaResolverContext r4);

    List<Name> getMethodNames(ClassDescriptor r1, LazyJavaResolverContext r2);

    List<Name> getNestedClassNames(ClassDescriptor r1, LazyJavaResolverContext r2);

    List<Name> getStaticFunctionNames(ClassDescriptor r1, LazyJavaResolverContext r2);

    PropertyDescriptorImpl modifyField(ClassDescriptor r1, PropertyDescriptorImpl r2, LazyJavaResolverContext r3);
}
