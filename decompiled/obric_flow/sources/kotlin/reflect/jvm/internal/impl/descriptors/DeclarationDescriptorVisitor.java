package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor r5, D r10);

    R visitConstructorDescriptor(ConstructorDescriptor r5, D r10);

    R visitFunctionDescriptor(FunctionDescriptor r5, D r10);

    R visitModuleDeclaration(ModuleDescriptor r5, D r10);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor r5, D r10);

    R visitPackageViewDescriptor(PackageViewDescriptor r5, D r10);

    R visitPropertyDescriptor(PropertyDescriptor r5, D r10);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor r5, D r10);

    R visitPropertySetterDescriptor(PropertySetterDescriptor r5, D r10);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor r5, D r10);

    R visitTypeAliasDescriptor(TypeAliasDescriptor r5, D r10);

    R visitTypeParameterDescriptor(TypeParameterDescriptor r5, D r10);

    R visitValueParameterDescriptor(ValueParameterDescriptor r5, D r10);
}
