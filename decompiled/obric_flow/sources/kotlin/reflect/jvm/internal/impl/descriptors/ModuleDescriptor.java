package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public interface ModuleDescriptor extends DeclarationDescriptor {

    public static final class DefaultImpls {
        public static <R, D> R accept(ModuleDescriptor r5, DeclarationDescriptorVisitor<R, D> r10, D r11) {
            Intrinsics.checkNotNullParameter(r10, "visitor");
            return r10.visitModuleDeclaration(r5, r11);
        }

        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor r5) {
            return null;
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> r5);

    List<ModuleDescriptor> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName r5);

    Collection<FqName> getSubPackagesOf(FqName r5, Function1<? super Name, Boolean> r10);

    boolean shouldSeeInternalsOf(ModuleDescriptor r5);
}
