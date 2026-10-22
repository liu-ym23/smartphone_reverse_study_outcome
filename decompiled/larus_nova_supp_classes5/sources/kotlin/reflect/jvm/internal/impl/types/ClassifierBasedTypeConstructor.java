package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    public ClassifierBasedTypeConstructor() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    public abstract boolean isSameClassifier(ClassifierDescriptor r1);

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        ClassifierDescriptor r1 = getDeclarationDescriptor();
        if (hasMeaningfulFqName(r1) == false) goto L8;
        int r2 = DescriptorUtils.getFqName(r1).hashCode();
    L9:
        this.hashCode = r2;
        return r2;
    L8:
        r2 = System.identityHashCode(this);
        goto L9
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor r2) {
        if (ErrorUtils.isError(r2) == false) goto L5;
    L7:
        return false;
    L5:
        if (DescriptorUtils.isLocal(r2) == true) goto L7;
        return true;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TypeConstructor) == true) goto L9;
        return false;
    L9:
        if (r4.hashCode() == hashCode()) goto L11;
        return false;
    L11:
        TypeConstructor r5 = (TypeConstructor) r4;
        if (r5.getParameters().size() == getParameters().size()) goto L14;
        return false;
    L14:
        ClassifierDescriptor r0 = getDeclarationDescriptor();
        ClassifierDescriptor r6 = r5.getDeclarationDescriptor();
        if (r6 != null) goto L18;
        return false;
    L18:
        if (hasMeaningfulFqName(r0) == true) goto L20;
    L24:
        return false;
    L20:
        if (hasMeaningfulFqName(r6) == false) goto L24;
        return isSameClassifier(r6);
    }

    public final boolean areFqNamesEqual(ClassifierDescriptor r4, ClassifierDescriptor r5) {
        Intrinsics.checkNotNullParameter(r4, "first");
        Intrinsics.checkNotNullParameter(r5, "second");
        if (Intrinsics.areEqual(r4.getName(), r5.getName()) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r6 = r4.getContainingDeclaration();
        DeclarationDescriptor r7 = r5.getContainingDeclaration();
    L7:
        if (r6 == null) goto L31;
        if (r7 == null) goto L31;
        if ((r6 instanceof ModuleDescriptor) == true) goto L12;
        if ((r7 instanceof ModuleDescriptor) == true) goto L15;
        if ((r6 instanceof PackageFragmentDescriptor) == true) goto L19;
        if ((r7 instanceof PackageFragmentDescriptor) == true) goto L26;
        if (Intrinsics.areEqual(r6.getName(), r7.getName()) == false) goto L29;
        r6 = r6.getContainingDeclaration();
        r7 = r7.getContainingDeclaration();
        goto L7
    L29:
        return false;
    L26:
        return false;
    L19:
        if ((r7 instanceof PackageFragmentDescriptor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r6).getFqName(), ((PackageFragmentDescriptor) r7).getFqName()) == false) goto L40;
        return true;
    L40:
        return false;
    L15:
        return false;
    L12:
        return r7 instanceof ModuleDescriptor;
    L31:
        return true;
    }
}
