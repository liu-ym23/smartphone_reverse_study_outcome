package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface SyntheticJavaPartsProvider {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final CompositeSyntheticJavaPartsProvider EMPTY = null;

        static {
            $$INSTANCE = new Companion();
            EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt.emptyList());
        }

        private Companion() {
        }

        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void generateConstructors(LazyJavaResolverContext r5, ClassDescriptor r10, List<ClassConstructorDescriptor> r11);

    void generateMethods(LazyJavaResolverContext r5, ClassDescriptor r10, Name r11, Collection<SimpleFunctionDescriptor> r12);

    void generateNestedClass(LazyJavaResolverContext r5, ClassDescriptor r10, Name r11, List<ClassDescriptor> r12);

    void generateStaticFunctions(LazyJavaResolverContext r5, ClassDescriptor r10, Name r11, Collection<SimpleFunctionDescriptor> r12);

    List<Name> getMethodNames(LazyJavaResolverContext r5, ClassDescriptor r10);

    List<Name> getNestedClassNames(LazyJavaResolverContext r5, ClassDescriptor r10);

    List<Name> getStaticFunctionNames(LazyJavaResolverContext r5, ClassDescriptor r10);
}
