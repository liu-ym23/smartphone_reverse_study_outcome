package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor r1, D r2);

    R visitConstructorDescriptor(ConstructorDescriptor r1, D r2);

    R visitFunctionDescriptor(FunctionDescriptor r1, D r2);

    R visitModuleDeclaration(ModuleDescriptor r1, D r2);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor r1, D r2);

    R visitPackageViewDescriptor(PackageViewDescriptor r1, D r2);

    R visitPropertyDescriptor(PropertyDescriptor r1, D r2);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor r1, D r2);

    R visitPropertySetterDescriptor(PropertySetterDescriptor r1, D r2);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor r1, D r2);

    R visitTypeAliasDescriptor(TypeAliasDescriptor r1, D r2);

    R visitTypeParameterDescriptor(TypeParameterDescriptor r1, D r2);

    R visitValueParameterDescriptor(ValueParameterDescriptor r1, D r2);
}
