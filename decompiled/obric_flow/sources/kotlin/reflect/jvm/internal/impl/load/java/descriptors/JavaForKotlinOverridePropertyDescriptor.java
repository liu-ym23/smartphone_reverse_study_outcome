package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {
    private final SimpleFunctionDescriptor getterMethod;
    private final PropertyDescriptor overriddenProperty;
    private final SimpleFunctionDescriptor setterMethod;

    public JavaForKotlinOverridePropertyDescriptor(ClassDescriptor r17, SimpleFunctionDescriptor r18, SimpleFunctionDescriptor r19, PropertyDescriptor r20) {
        Intrinsics.checkNotNullParameter(r17, "ownerDescriptor");
        Intrinsics.checkNotNullParameter(r18, "getterMethod");
        Intrinsics.checkNotNullParameter(r20, "overriddenProperty");
        Annotations r5 = Annotations.Companion.getEMPTY();
        Modality r10 = r18.getModality();
        DescriptorVisibility r11 = r18.getVisibility();
        if (r19 == null) goto L6;
        boolean r12 = true;
    L5:
        boolean r13 = r12;
        super(r17, r5, r10, r11, r13, r20.getName(), r18.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        this.getterMethod = r18;
        this.setterMethod = r19;
        this.overriddenProperty = r20;
        return;
    L6:
        r12 = false;
        goto L5
    }
}
