package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nClassifierBasedTypeConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassifierBasedTypeConstructor.kt\norg/jetbrains/kotlin/types/ClassifierBasedTypeConstructor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    public ClassifierBasedTypeConstructor() {
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor r5) {
        if (ErrorUtils.isError(r5) == false) goto L5;
    L7:
        return false;
    L5:
        if (DescriptorUtils.isLocal(r5) == true) goto L7;
        return true;
    }

    public final boolean areFqNamesEqual(ClassifierDescriptor r5, ClassifierDescriptor r10) {
        Intrinsics.checkNotNullParameter(r5, "first");
        Intrinsics.checkNotNullParameter(r10, "second");
        if (Intrinsics.areEqual(r5.getName(), r10.getName()) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r11 = r5.getContainingDeclaration();
        DeclarationDescriptor r12 = r10.getContainingDeclaration();
    L7:
        if (r11 == null) goto L31;
        if (r12 == null) goto L31;
        if ((r11 instanceof ModuleDescriptor) == true) goto L12;
        if ((r12 instanceof ModuleDescriptor) == true) goto L15;
        if ((r11 instanceof PackageFragmentDescriptor) == true) goto L19;
        if ((r12 instanceof PackageFragmentDescriptor) == true) goto L26;
        if (Intrinsics.areEqual(r11.getName(), r12.getName()) == false) goto L29;
        r11 = r11.getContainingDeclaration();
        r12 = r12.getContainingDeclaration();
        goto L7
    L29:
        return false;
    L26:
        return false;
    L19:
        if ((r12 instanceof PackageFragmentDescriptor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(((PackageFragmentDescriptor) r11).getFqName(), ((PackageFragmentDescriptor) r12).getFqName()) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        return false;
    L12:
        return r12 instanceof ModuleDescriptor;
    L31:
        return true;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TypeConstructor) == true) goto L9;
        return false;
    L9:
        if (r5.hashCode() == hashCode()) goto L11;
        return false;
    L11:
        TypeConstructor r10 = (TypeConstructor) r5;
        if (r10.getParameters().size() == getParameters().size()) goto L14;
        return false;
    L14:
        ClassifierDescriptor r11 = mo1402getDeclarationDescriptor();
        ClassifierDescriptor r12 = r10.mo1402getDeclarationDescriptor();
        if (r12 != null) goto L18;
        return false;
    L18:
        if (hasMeaningfulFqName(r11) == true) goto L20;
    L24:
        return false;
    L20:
        if (hasMeaningfulFqName(r12) == false) goto L24;
        return isSameClassifier(r12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public abstract ClassifierDescriptor mo1402getDeclarationDescriptor();

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 == 0) goto L5;
        return r5;
    L5:
        ClassifierDescriptor r10 = mo1402getDeclarationDescriptor();
        if (hasMeaningfulFqName(r10) == false) goto L8;
        int r11 = DescriptorUtils.getFqName(r10).hashCode();
    L9:
        this.hashCode = r11;
        return r11;
    L8:
        r11 = System.identityHashCode(this);
        goto L9
    }

    public abstract boolean isSameClassifier(ClassifierDescriptor r5);
}
