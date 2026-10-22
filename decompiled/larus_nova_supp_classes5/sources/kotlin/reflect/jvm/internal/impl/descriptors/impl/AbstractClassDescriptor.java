package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbstractClassDescriptor extends ModuleAwareClassDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final NotNullLazyValue<SimpleType> defaultType;
    private final Name name;
    private final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;
    private final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;

    private static /* synthetic */ void $$$reportNull$$$0(int r19) {
        if (r19 == 2) goto L16;
        if (r19 == 3) goto L16;
        if (r19 == 4) goto L16;
        if (r19 == 5) goto L16;
        if (r19 == 6) goto L16;
        if (r19 == 9) goto L16;
        if (r19 == 12) goto L16;
        if (r19 == 14) goto L16;
        if (r19 == 16) goto L16;
        if (r19 == 17) goto L16;
        if (r19 == 19) goto L16;
        if (r19 == 20) goto L16;
        String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L17:
        if (r19 == 2) goto L30;
        if (r19 == 3) goto L30;
        if (r19 == 4) goto L30;
        if (r19 == 5) goto L30;
        if (r19 == 6) goto L30;
        if (r19 == 9) goto L30;
        if (r19 == 12) goto L30;
        if (r19 == 14) goto L30;
        if (r19 == 16) goto L30;
        if (r19 == 17) goto L30;
        if (r19 == 19) goto L30;
        if (r19 == 20) goto L30;
        int r14 = 3;
    L31:
        Object[] r15 = new Object[r14];
        switch(r19) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L38;
            case 5: goto L38;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L38;
            case 10: goto L35;
            case 11: goto L36;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L38;
            case 15: goto L35;
            case 16: goto L38;
            case 17: goto L38;
            case 18: goto L34;
            case 19: goto L38;
            case 20: goto L38;
            default: goto L33;
        };
    L33:
        r15[0] = "storageManager";
    L41:
        if (r19 == 2) goto L62;
        if (r19 == 3) goto L61;
        if (r19 == 4) goto L60;
        if (r19 == 5) goto L59;
        if (r19 == 6) goto L58;
        if (r19 == 9) goto L57;
        if (r19 == 12) goto L57;
        if (r19 == 14) goto L57;
        if (r19 == 16) goto L57;
        if (r19 == 17) goto L56;
        if (r19 == 19) goto L55;
        if (r19 == 20) goto L54;
        r15[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
    L63:
        switch(r19) {
            case 2: goto L67;
            case 3: goto L67;
            case 4: goto L67;
            case 5: goto L67;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L66;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L66;
            case 12: goto L67;
            case 13: goto L66;
            case 14: goto L67;
            case 15: goto L66;
            case 16: goto L67;
            case 17: goto L67;
            case 18: goto L65;
            case 19: goto L67;
            case 20: goto L67;
            default: goto L64;
        };
    L64:
        r15[2] = "<init>";
        goto L67
    L65:
        r15[2] = "substitute";
        goto L67
    L66:
        r15[2] = "getMemberScope";
    L67:
        String r16 = String.format(r13, r15);
        if (r19 == 2) goto L82;
        if (r19 == 3) goto L82;
        if (r19 == 4) goto L82;
        if (r19 == 5) goto L82;
        if (r19 == 6) goto L82;
        if (r19 == 9) goto L82;
        if (r19 == 12) goto L82;
        if (r19 == 14) goto L82;
        if (r19 == 16) goto L82;
        if (r19 == 17) goto L82;
        if (r19 == 19) goto L82;
        if (r19 == 20) goto L82;
        throw new IllegalArgumentException(r16);
    L82:
        throw new IllegalStateException(r16);
    L54:
        r15[1] = "getDefaultType";
        goto L63
    L55:
        r15[1] = "substitute";
        goto L63
    L56:
        r15[1] = "getUnsubstitutedMemberScope";
    L57:
        r15[1] = "getMemberScope";
        goto L63
    L58:
        r15[1] = "getContextReceivers";
        goto L63
    L59:
        r15[1] = "getThisAsReceiverParameter";
        goto L63
    L60:
        r15[1] = "getUnsubstitutedInnerClassesScope";
        goto L63
    L61:
        r15[1] = "getOriginal";
        goto L63
    L62:
        r15[1] = "getName";
        goto L63
    L34:
        r15[0] = "substitutor";
        goto L41
    L35:
        r15[0] = "typeSubstitution";
        goto L41
    L36:
        r15[0] = "kotlinTypeRefiner";
        goto L41
    L37:
        r15[0] = "typeArguments";
        goto L41
    L38:
        r15[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        goto L41
    L39:
        r15[0] = DBDefinition.NAME;
    L30:
        r14 = 2;
    L16:
        r13 = "@NotNull method %s.%s must not return null";
        goto L17
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType r0 = (SimpleType) this.defaultType.invoke();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(20);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name r0 = this.name;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(2);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor r0 = (ReceiverParameterDescriptor) this.thisAsReceiverParameter.invoke();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope r0 = (MemberScope) this.unsubstitutedInnerClassesScope.invoke();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> r0 = Collections.emptyList();
        if (r0 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope r0 = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (r0 != null) goto L5;
        $$$reportNull$$$0(17);
    L5:
        return r0;
    }

    static {
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(15);
    L4:
        MemberScope r3 = getMemberScope(r2, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (r3 != null) goto L7;
        $$$reportNull$$$0(16);
    L7:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor r2) {
        if (r2 != null) goto L5;
        $$$reportNull$$$0(18);
    L5:
        if (r2.isEmpty() == false) goto L8;
        return this;
    L8:
        return new LazySubstitutingClassDescriptor(this, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public /* bridge */ /* synthetic */ DeclarationDescriptorNonRoot substitute(TypeSubstitutor r1) {
        return substitute(r1);
    }

    public AbstractClassDescriptor(StorageManager r2, Name r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r3 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.name = r3;
        this.defaultType = r2.createLazyValue(new AnonymousClass1(this));
        this.unsubstitutedInnerClassesScope = r2.createLazyValue(new AnonymousClass2(this));
        this.thisAsReceiverParameter = r2.createLazyValue(new AnonymousClass3(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r1, D r2) {
        return r1.visitClassDescriptor(this, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution r2, KotlinTypeRefiner r3) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(10);
    L4:
        if (r3 != null) goto L7;
        $$$reportNull$$$0(11);
    L7:
        if (r2.isEmpty() == false) goto L12;
        MemberScope r4 = getUnsubstitutedMemberScope(r3);
        if (r4 != null) goto L11;
        $$$reportNull$$$0(12);
    L11:
        return r4;
    L12:
        TypeSubstitutor r5 = TypeSubstitutor.create(r2);
        return new SubstitutingScope(getUnsubstitutedMemberScope(r3), r5);
    }
}
