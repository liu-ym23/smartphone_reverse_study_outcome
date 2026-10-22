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
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L7;
        if (r10 == 3) goto L7;
        if (r10 == 4) goto L7;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L9:
        if (r10 == 1) goto L13;
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        int r12 = 3;
    L14:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L21;
        if (r10 == 2) goto L20;
        if (r10 == 3) goto L21;
        if (r10 == 4) goto L21;
        r13[0] = "storageManager";
    L22:
        if (r10 == 1) goto L27;
        if (r10 == 3) goto L26;
        if (r10 == 4) goto L26;
        r13[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L28:
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L33;
        if (r10 == 3) goto L34;
        if (r10 == 4) goto L34;
        r13[2] = "<init>";
        goto L34
    L33:
        r13[2] = "isSameClassifier";
    L34:
        String r14 = String.format(r11, r13);
        if (r10 == 1) goto L40;
        if (r10 == 3) goto L40;
        if (r10 == 4) goto L40;
        throw new IllegalArgumentException(r14);
    L40:
        throw new IllegalStateException(r14);
    L26:
        r13[1] = "getAdditionalNeighboursInSupertypeGraph";
        goto L28
    L27:
        r13[1] = "getBuiltIns";
        goto L28
    L20:
        r13[0] = "classifier";
    L21:
        r13[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
    L13:
        r12 = 2;
    L7:
        r11 = "@NotNull method %s.%s must not return null";
        goto L9
    }

    public AbstractClassTypeConstructor(StorageManager r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        super(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(mo1323getDeclarationDescriptor()) == false) goto L7;
        return null;
    L7:
        return getBuiltIns().getAnyType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean r10) {
        DeclarationDescriptor r11 = mo1323getDeclarationDescriptor().getContainingDeclaration();
        if ((r11 instanceof ClassDescriptor) == true) goto L8;
        List r12 = Collections.emptyList();
        if (r12 != null) goto L7;
        $$$reportNull$$$0(3);
    L7:
        return r12;
    L8:
        SmartList r13 = new SmartList();
        ClassDescriptor r14 = (ClassDescriptor) r11;
        r13.add(r14.getDefaultType());
        ClassDescriptor r15 = r14.mo1316getCompanionObjectDescriptor();
        if (r10 == false) goto L12;
        if (r15 == null) goto L12;
        r13.add(r15.getDefaultType());
    L12:
        return r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns r10 = DescriptorUtilsKt.getBuiltIns(mo1323getDeclarationDescriptor());
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract ClassDescriptor mo1323getDeclarationDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1323getDeclarationDescriptor() {
        return mo1323getDeclarationDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
    protected boolean isSameClassifier(ClassifierDescriptor r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        if ((r10 instanceof ClassDescriptor) == true) goto L7;
    L9:
        return false;
    L7:
        if (areFqNamesEqual(mo1323getDeclarationDescriptor(), r10) == false) goto L9;
        return true;
    }
}
