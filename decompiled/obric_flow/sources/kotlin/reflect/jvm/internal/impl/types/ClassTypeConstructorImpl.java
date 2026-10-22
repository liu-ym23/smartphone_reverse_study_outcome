package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public class ClassTypeConstructorImpl extends AbstractClassTypeConstructor implements TypeConstructor {
    private final ClassDescriptor classDescriptor;
    private final List<TypeParameterDescriptor> parameters;
    private final Collection<KotlinType> supertypes;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L8;
        if (r10 == 5) goto L8;
        if (r10 == 6) goto L8;
        if (r10 == 7) goto L8;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r10 == 4) goto L15;
        if (r10 == 5) goto L15;
        if (r10 == 6) goto L15;
        if (r10 == 7) goto L15;
        int r11 = 3;
    L16:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L19;
            default: goto L18;
        };
    L18:
        r12[0] = "classDescriptor";
    L24:
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L31;
        if (r10 == 6) goto L30;
        if (r10 == 7) goto L29;
        r12[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
    L33:
        if (r10 == 4) goto L38;
        if (r10 == 5) goto L38;
        if (r10 == 6) goto L38;
        if (r10 == 7) goto L38;
        r12[2] = "<init>";
    L38:
        String r13 = String.format(r5, r12);
        if (r10 == 4) goto L45;
        if (r10 == 5) goto L45;
        if (r10 == 6) goto L45;
        if (r10 == 7) goto L45;
        throw new IllegalArgumentException(r13);
    L45:
        throw new IllegalStateException(r13);
    L29:
        r12[1] = "getSupertypeLoopChecker";
        goto L33
    L30:
        r12[1] = "computeSupertypes";
        goto L33
    L31:
        r12[1] = "getDeclarationDescriptor";
        goto L33
    L32:
        r12[1] = "getParameters";
        goto L33
    L19:
        r12[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        goto L24
    L20:
        r12[0] = "storageManager";
        goto L24
    L21:
        r12[0] = "supertypes";
        goto L24
    L22:
        r12[0] = "parameters";
    L15:
        r11 = 2;
    L8:
        r5 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    public ClassTypeConstructorImpl(ClassDescriptor r5, List<? extends TypeParameterDescriptor> r10, Collection<KotlinType> r11, StorageManager r12) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r11 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r12 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r12);
        this.classDescriptor = r5;
        this.parameters = Collections.unmodifiableList(new ArrayList(r10));
        this.supertypes = Collections.unmodifiableCollection(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public Collection<KotlinType> computeSupertypes() {
        Collection<KotlinType> r5 = this.supertypes;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public /* bridge */ /* synthetic */ ClassifierDescriptor mo1402getDeclarationDescriptor() {
        return mo1402getDeclarationDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> r5 = this.parameters;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public SupertypeLoopChecker getSupertypeLoopChecker() {
        SupertypeLoopChecker.EMPTY r5 = SupertypeLoopChecker.EMPTY.INSTANCE;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return true;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.classDescriptor).asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public ClassDescriptor mo1402getDeclarationDescriptor() {
        ClassDescriptor r5 = this.classDescriptor;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }
}
