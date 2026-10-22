package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor implements TypeConstructor {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L7;
        if (r10 == 3) goto L7;
        if (r10 == 4) goto L7;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 1) goto L13;
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        int r11 = 3;
    L14:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L20;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        r12[0] = "storageManager";
    L22:
        if (r10 == 1) goto L27;
        if (r10 == 3) goto L26;
        if (r10 == 4) goto L26;
        r12[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L28:
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L33;
        if (r10 == 3) goto L34;
        if (r10 == 4) goto L34;
        r12[2] = "<init>";
        goto L34
    L33:
        r12[2] = "isSameClassifier";
    L34:
        String r13 = String.format(r5, r12);
        if (r10 == 1) goto L40;
        if (r10 == 3) goto L40;
        if (r10 == 4) goto L40;
        throw new IllegalArgumentException(r13);
    L40:
        throw new IllegalStateException(r13);
    L26:
        r12[1] = "getAdditionalNeighboursInSupertypeGraph";
        goto L28
    L27:
        r12[1] = "getBuiltIns";
        goto L28
    L20:
        r12[0] = "classifier";
    L21:
        r12[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L13:
        r11 = 2;
    L7:
        r5 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public AbstractClassTypeConstructor(StorageManager r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(mo1402getDeclarationDescriptor()) == false) goto L7;
        return null;
    L7:
        return getBuiltIns().getAnyType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r5) {
        DeclarationDescriptor r10 = mo1402getDeclarationDescriptor().getContainingDeclaration();
        if ((r10 instanceof ClassDescriptor) == true) goto L8;
        List r11 = Collections.emptyList();
        if (r11 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        return r11;
    L8:
        SmartList r12 = new SmartList();
        ClassDescriptor r13 = (ClassDescriptor) r10;
        r12.add(r13.getDefaultType());
        ClassDescriptor r14 = r13.mo1395getCompanionObjectDescriptor();
        if (r5 == false) goto L12;
        if (r14 == null) goto L12;
        r12.add(r14.getDefaultType());
    L12:
        return r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns r5 = DescriptorUtilsKt.getBuiltIns(mo1402getDeclarationDescriptor());
        if (r5 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract ClassDescriptor mo1402getDeclarationDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1402getDeclarationDescriptor() {
        return mo1402getDeclarationDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
    public boolean isSameClassifier(ClassifierDescriptor r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        if ((r5 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (areFqNamesEqual(mo1402getDeclarationDescriptor(), r5) == false) goto L9;
        return true;
    }
}
