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
        public static <R, D> R accept(ModuleDescriptor r10, DeclarationDescriptorVisitor<R, D> r11, D r12) {
            Intrinsics.checkNotNullParameter(r11, "visitor");
            return r11.visitModuleDeclaration(r10, r12);
        }

        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor r10) {
            return null;
        }
    }

    KotlinBuiltIns getBuiltIns();

    <T> T getCapability(ModuleCapability<T> r10);

    List<ModuleDescriptor> getExpectedByModules();

    PackageViewDescriptor getPackage(FqName r10);

    Collection<FqName> getSubPackagesOf(FqName r10, Function1<? super Name, Boolean> r11);

    boolean shouldSeeInternalsOf(ModuleDescriptor r10);
}
