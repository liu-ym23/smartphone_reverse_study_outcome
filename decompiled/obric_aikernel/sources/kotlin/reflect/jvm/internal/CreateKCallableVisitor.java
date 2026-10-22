package kotlin.reflect.jvm.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;

/* JADX INFO: loaded from: classes3.dex */
public class CreateKCallableVisitor extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit> {
    private final KDeclarationContainerImpl container;

    public CreateKCallableVisitor(KDeclarationContainerImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "container");
        this.container = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor r10, Object r11) {
        return visitFunctionDescriptor(r10, (Unit) r11);
    }

    public KCallableImpl<?> visitFunctionDescriptor(FunctionDescriptor r10, Unit r11) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "data");
        return new KFunctionImpl(this.container, r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(PropertyDescriptor r10, Object r11) {
        return visitPropertyDescriptor(r10, (Unit) r11);
    }

    public KCallableImpl<?> visitPropertyDescriptor(PropertyDescriptor r10, Unit r11) {
        Intrinsics.checkNotNullParameter(r10, "descriptor");
        Intrinsics.checkNotNullParameter(r11, "data");
        int r12 = 0;
        if (r10.getDispatchReceiverParameter() == null) goto L5;
        int r13 = 1;
    L7:
        if (r10.getExtensionReceiverParameter() == null) goto L9;
        r12 = 1;
    L9:
        int r14 = r13 + r12;
        if (r10.isVar() == false) goto L20;
        if (r14 == 0) goto L19;
        if (r14 == 1) goto L17;
        if (r14 != 2) goto L26;
        return new KMutableProperty2Impl(this.container, r10);
    L26:
        throw new KotlinReflectionInternalError("Unsupported property: " + r10);
    L17:
        return new KMutableProperty1Impl(this.container, r10);
    L19:
        return new KMutableProperty0Impl(this.container, r10);
    L20:
        if (r14 == 0) goto L30;
        if (r14 == 1) goto L28;
        if (r14 != 2) goto L26;
        return new KProperty2Impl(this.container, r10);
    L28:
        return new KProperty1Impl(this.container, r10);
    L30:
        return new KProperty0Impl(this.container, r10);
    L5:
        r13 = 0;
        goto L7
    }
}
