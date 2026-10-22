package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public class ClassDescriptorImpl extends ClassDescriptorBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Set<ClassConstructorDescriptor> constructors;
    private final ClassKind kind;
    private final Modality modality;
    private ClassConstructorDescriptor primaryConstructor;
    private final TypeConstructor typeConstructor;
    private MemberScope unsubstitutedMemberScope;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L4;
            case 18: goto L4;
            case 19: goto L4;
            default: goto L3;
        };
    L3:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            default: goto L7;
        };
    L7:
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L13;
            case 16: goto L13;
            case 17: goto L13;
            case 18: goto L13;
            case 19: goto L13;
            default: goto L11;
        };
    L11:
        r13[0] = "containingDeclaration";
    L23:
        switch(r10) {
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L24;
            case 13: goto L31;
            case 14: goto L30;
            case 15: goto L29;
            case 16: goto L28;
            case 17: goto L27;
            case 18: goto L26;
            case 19: goto L25;
            default: goto L24;
        };
    L24:
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
    L35:
        switch(r10) {
            case 7: goto L38;
            case 8: goto L38;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L39;
            case 12: goto L37;
            case 13: goto L39;
            case 14: goto L39;
            case 15: goto L39;
            case 16: goto L39;
            case 17: goto L39;
            case 18: goto L39;
            case 19: goto L39;
            default: goto L36;
        };
    L36:
        r13[2] = "<init>";
        goto L39
    L37:
        r13[2] = "getUnsubstitutedMemberScope";
        goto L39
    L38:
        r13[2] = "initialize";
    L39:
        String r14 = String.format(r11, r13);
        switch(r10) {
            case 9: goto L43;
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L44;
            case 13: goto L43;
            case 14: goto L43;
            case 15: goto L43;
            case 16: goto L43;
            case 17: goto L43;
            case 18: goto L43;
            case 19: goto L43;
            default: goto L44;
        };
    L44:
        throw new IllegalArgumentException(r14);
    L43:
        throw new IllegalStateException(r14);
    L25:
        r13[1] = "getSealedSubclasses";
        goto L35
    L26:
        r13[1] = "getDeclaredTypeParameters";
        goto L35
    L27:
        r13[1] = "getVisibility";
        goto L35
    L28:
        r13[1] = "getModality";
        goto L35
    L29:
        r13[1] = "getKind";
        goto L35
    L30:
        r13[1] = "getStaticScope";
        goto L35
    L31:
        r13[1] = "getUnsubstitutedMemberScope";
        goto L35
    L32:
        r13[1] = "getConstructors";
        goto L35
    L33:
        r13[1] = "getTypeConstructor";
        goto L35
    L34:
        r13[1] = "getAnnotations";
        goto L35
    L12:
        r13[0] = "kotlinTypeRefiner";
        goto L23
    L13:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
        goto L23
    L14:
        r13[0] = "constructors";
        goto L23
    L15:
        r13[0] = "unsubstitutedMemberScope";
        goto L23
    L16:
        r13[0] = "storageManager";
        goto L23
    L17:
        r13[0] = "source";
        goto L23
    L18:
        r13[0] = "supertypes";
        goto L23
    L19:
        r13[0] = "kind";
        goto L23
    L20:
        r13[0] = "modality";
        goto L23
    L21:
        r13[0] = ActivityLifecycle.NAME;
        goto L23
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static {
    }

    public ClassDescriptorImpl(DeclarationDescriptor r10, Name r11, Modality r12, ClassKind r13, Collection<KotlinType> r14, SourceElement r15, boolean r16, StorageManager r17) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r13 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r14 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        if (r15 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        if (r17 != null) goto L16;
        $$$reportNull$$$0(6);
    L16:
        super(r17, r10, r11, r15, r16);
        this.modality = r12;
        this.kind = r13;
        this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), r14, r17);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r10 = Annotations.Companion.getEMPTY();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo1316getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> r10 = this.constructors;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        ClassKind r10 = this.kind;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(15);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality r10 = this.modality;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(16);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List r10 = Collections.emptyList();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        MemberScope.Empty r10 = MemberScope.Empty.INSTANCE;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor r10 = this.typeConstructor;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        MemberScope r11 = this.unsubstitutedMemberScope;
        if (r11 != null) goto L7;
        $$$reportNull$$$0(13);
    L7:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo1317getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility r10 = DescriptorVisibilities.PUBLIC;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r10;
    }

    public final void initialize(MemberScope r10, Set<ClassConstructorDescriptor> r11, ClassConstructorDescriptor r12) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        this.unsubstitutedMemberScope = r10;
        this.constructors = r11;
        this.primaryConstructor = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        return "class " + getName();
    }
}
