package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes3.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor r10, D r11);

    R visitConstructorDescriptor(ConstructorDescriptor r10, D r11);

    R visitFunctionDescriptor(FunctionDescriptor r10, D r11);

    R visitModuleDeclaration(ModuleDescriptor r10, D r11);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor r10, D r11);

    R visitPackageViewDescriptor(PackageViewDescriptor r10, D r11);

    R visitPropertyDescriptor(PropertyDescriptor r10, D r11);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor r10, D r11);

    R visitPropertySetterDescriptor(PropertySetterDescriptor r10, D r11);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor r10, D r11);

    R visitTypeAliasDescriptor(TypeAliasDescriptor r10, D r11);

    R visitTypeParameterDescriptor(TypeParameterDescriptor r10, D r11);

    R visitValueParameterDescriptor(ValueParameterDescriptor r10, D r11);
}
