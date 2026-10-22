package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    public ClassifierBasedTypeConstructor() {
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor r10) {
        if (ErrorUtils.isError(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (DescriptorUtils.isLocal(r10) == true) goto L7;
        return true;
    }

    protected final boolean areFqNamesEqual(ClassifierDescriptor r10, ClassifierDescriptor r11) {
        Intrinsics.checkNotNullParameter(r10, "first");
        Intrinsics.checkNotNullParameter(r11, "second");
        if (Intrinsics.areEqual(r10.getName(), r11.getName()) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r12 = r10.getContainingDeclaration();
        DeclarationDescriptor r13 = r11.getContainingDeclaration();
    L7:
        if (r12 == null) goto L31;
        if (r13 == null) goto L31;
        if ((r12 instanceof ModuleDescriptor) == true) goto L12;
        if ((r13 instanceof ModuleDescriptor) == true) goto L15;
        if ((r12 instanceof PackageFragmentDescriptor) == true) goto L19;
        if ((r13 instanceof PackageFragmentDescriptor) == true) goto L26;
        if (Intrinsics.areEqual(r12.getName(), r13.getName()) == false) goto L29;
        r12 = r12.getContainingDeclaration();
        r13 = r13.getContainingDeclaration();
        goto L7
    L29:
        return false;
    L26:
        return false;
    L19:
        if ((r13 instanceof PackageFragmentDescriptor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r12).getFqName(), ((PackageFragmentDescriptor) r13).getFqName()) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    L12:
        return r13 instanceof ModuleDescriptor;
    L31:
        return true;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TypeConstructor) == true) goto L9;
        return false;
    L9:
        if (r10.hashCode() == hashCode()) goto L11;
        return false;
    L11:
        TypeConstructor r11 = (TypeConstructor) r10;
        if (r11.getParameters().size() == getParameters().size()) goto L14;
        return false;
    L14:
        ClassifierDescriptor r12 = mo1323getDeclarationDescriptor();
        ClassifierDescriptor r13 = r11.mo1323getDeclarationDescriptor();
        if (r13 != null) goto L18;
        return false;
    L18:
        if (hasMeaningfulFqName(r12) == true) goto L20;
    L24:
        return false;
    L20:
        if (hasMeaningfulFqName(r13) == false) goto L24;
        return isSameClassifier(r13);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo1323getDeclarationDescriptor();

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        ClassifierDescriptor r11 = mo1323getDeclarationDescriptor();
        if (hasMeaningfulFqName(r11) == false) goto L8;
        int r12 = DescriptorUtils.getFqName(r11).hashCode();
    L9:
        this.hashCode = r12;
        return r12;
    L8:
        r12 = System.identityHashCode(this);
        goto L9
    }

    protected abstract boolean isSameClassifier(ClassifierDescriptor r10);
}
