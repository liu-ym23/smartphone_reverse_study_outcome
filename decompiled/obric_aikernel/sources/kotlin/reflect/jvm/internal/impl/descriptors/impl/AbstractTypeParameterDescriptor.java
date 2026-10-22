package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeParameterDescriptor extends DeclarationDescriptorNonRootImpl implements TypeParameterDescriptor {
    private final NotNullLazyValue<SimpleType> defaultType;
    private final int index;
    private final boolean reified;
    private final StorageManager storageManager;
    private final NotNullLazyValue<TypeConstructor> typeConstructor;
    private final Variance variance;

    private class TypeParameterTypeConstructor extends AbstractTypeConstructor {
        private final SupertypeLoopChecker supertypeLoopChecker;
        final /* synthetic */ AbstractTypeParameterDescriptor this$0;

        private static /* synthetic */ void $$$reportNull$$$0(int r11) {
            if (r11 == 1) goto L10;
            if (r11 == 2) goto L10;
            if (r11 == 3) goto L10;
            if (r11 == 4) goto L10;
            if (r11 == 5) goto L10;
            if (r11 == 8) goto L10;
            String r10 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L11:
            if (r11 == 1) goto L18;
            if (r11 == 2) goto L18;
            if (r11 == 3) goto L18;
            if (r11 == 4) goto L18;
            if (r11 == 5) goto L18;
            if (r11 == 8) goto L18;
            int r12 = 3;
        L19:
            Object[] r13 = new Object[r12];
            switch(r11) {
                case 1: goto L25;
                case 2: goto L25;
                case 3: goto L25;
                case 4: goto L25;
                case 5: goto L25;
                case 6: goto L24;
                case 7: goto L23;
                case 8: goto L25;
                case 9: goto L22;
                default: goto L21;
            };
        L21:
            r13[0] = "storageManager";
        L27:
            if (r11 == 1) goto L39;
            if (r11 == 2) goto L38;
            if (r11 == 3) goto L37;
            if (r11 == 4) goto L36;
            if (r11 == 5) goto L35;
            if (r11 == 8) goto L34;
            r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        L40:
            switch(r11) {
                case 1: goto L45;
                case 2: goto L45;
                case 3: goto L45;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L44;
                case 7: goto L43;
                case 8: goto L45;
                case 9: goto L42;
                default: goto L41;
            };
        L41:
            r13[2] = "<init>";
            goto L45
        L42:
            r13[2] = "isSameClassifier";
            goto L45
        L43:
            r13[2] = "processSupertypesWithoutCycles";
            goto L45
        L44:
            r13[2] = "reportSupertypeLoopError";
        L45:
            String r14 = String.format(r10, r13);
            if (r11 == 1) goto L54;
            if (r11 == 2) goto L54;
            if (r11 == 3) goto L54;
            if (r11 == 4) goto L54;
            if (r11 == 5) goto L54;
            if (r11 == 8) goto L54;
            throw new IllegalArgumentException(r14);
        L54:
            throw new IllegalStateException(r14);
        L34:
            r13[1] = "processSupertypesWithoutCycles";
            goto L40
        L35:
            r13[1] = "getSupertypeLoopChecker";
            goto L40
        L36:
            r13[1] = "getBuiltIns";
            goto L40
        L37:
            r13[1] = "getDeclarationDescriptor";
            goto L40
        L38:
            r13[1] = "getParameters";
            goto L40
        L39:
            r13[1] = "computeSupertypes";
            goto L40
        L22:
            r13[0] = "classifier";
            goto L27
        L23:
            r13[0] = "supertypes";
            goto L27
        L24:
            r13[0] = WsConstants.KEY_CONNECTION_TYPE;
            goto L27
        L25:
            r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
        L18:
            r12 = 2;
        L10:
            r10 = "@NotNull method %s.%s must not return null";
            goto L11
        }

        public TypeParameterTypeConstructor(AbstractTypeParameterDescriptor r10, StorageManager r11, SupertypeLoopChecker r12) {
            if (r11 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.this$0 = r10;
            super(r11);
            this.supertypeLoopChecker = r12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected Collection<KotlinType> computeSupertypes() {
            List<KotlinType> r10 = this.this$0.resolveUpperBounds();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected KotlinType defaultSupertypeIfEmpty() {
            return ErrorUtils.createErrorType(ErrorTypeKind.CYCLIC_UPPER_BOUNDS, new String[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns r10 = DescriptorUtilsKt.getBuiltIns(this.this$0);
            if (r10 != null) goto L5;
            $$$reportNull$$$0(4);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo1323getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor r10 = this.this$0;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(3);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> r10 = Collections.emptyList();
            if (r10 != null) goto L5;
            $$$reportNull$$$0(2);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            SupertypeLoopChecker r10 = this.supertypeLoopChecker;
            if (r10 != null) goto L5;
            $$$reportNull$$$0(5);
        L5:
            return r10;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
        protected boolean isSameClassifier(ClassifierDescriptor r10) {
            if (r10 != null) goto L5;
            $$$reportNull$$$0(9);
        L5:
            if ((r10 instanceof TypeParameterDescriptor) == true) goto L7;
        L9:
            return false;
        L7:
            if (DescriptorEquivalenceForOverrides.INSTANCE.areTypeParametersEquivalent(this.this$0, (TypeParameterDescriptor) r10, true) == false) goto L9;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(7);
        L4:
            List<KotlinType> r11 = this.this$0.processBoundsWithoutCycles(r10);
            if (r11 != null) goto L7;
            $$$reportNull$$$0(8);
        L7:
            return r11;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected void reportSupertypeLoopError(KotlinType r10) {
            if (r10 != null) goto L4;
            $$$reportNull$$$0(6);
        L4:
            this.this$0.mo1326reportSupertypeLoopError(r10);
        }

        public String toString() {
            return this.this$0.getName().toString();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        switch(r10) {
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            default: goto L3;
        };
    L3:
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r10) {
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            default: goto L7;
        };
    L7:
        int r12 = 3;
    L9:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L13;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L13;
            case 14: goto L13;
            default: goto L11;
        };
    L11:
        r13[0] = "storageManager";
    L21:
        switch(r10) {
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            case 12: goto L22;
            case 13: goto L24;
            case 14: goto L23;
            default: goto L22;
        };
    L22:
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
    L30:
        switch(r10) {
            case 7: goto L33;
            case 8: goto L33;
            case 9: goto L33;
            case 10: goto L33;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L33;
            case 14: goto L33;
            default: goto L31;
        };
    L31:
        r13[2] = "<init>";
        goto L33
    L32:
        r13[2] = "processBoundsWithoutCycles";
    L33:
        String r14 = String.format(r11, r13);
        switch(r10) {
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L37;
            default: goto L38;
        };
    L38:
        throw new IllegalArgumentException(r14);
    L37:
        throw new IllegalStateException(r14);
    L23:
        r13[1] = "getStorageManager";
        goto L30
    L24:
        r13[1] = "processBoundsWithoutCycles";
        goto L30
    L25:
        r13[1] = "getOriginal";
        goto L30
    L26:
        r13[1] = "getDefaultType";
        goto L30
    L27:
        r13[1] = "getTypeConstructor";
        goto L30
    L28:
        r13[1] = "getUpperBounds";
        goto L30
    L29:
        r13[1] = "getVariance";
        goto L30
    L12:
        r13[0] = "bounds";
        goto L21
    L13:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
        goto L21
    L14:
        r13[0] = "supertypeLoopChecker";
        goto L21
    L15:
        r13[0] = "source";
        goto L21
    L16:
        r13[0] = "variance";
        goto L21
    L17:
        r13[0] = ActivityLifecycle.NAME;
        goto L21
    L18:
        r13[0] = "annotations";
        goto L21
    L19:
        r13[0] = "containingDeclaration";
        goto L21
    L8:
        r12 = 2;
        goto L9
    L4:
        r11 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    protected AbstractTypeParameterDescriptor(final StorageManager r10, DeclarationDescriptor r11, Annotations r12, final Name r13, Variance r14, boolean r15, int r16, SourceElement r17, final SupertypeLoopChecker r18) {
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
        if (r17 != null) goto L14;
        $$$reportNull$$$0(5);
    L14:
        if (r18 != null) goto L16;
        $$$reportNull$$$0(6);
    L16:
        super(r11, r12, r13, r17);
        this.variance = r14;
        this.reified = r15;
        this.index = r16;
        this.typeConstructor = r10.createLazyValue(new AnonymousClass1(this, r10, r18));
        this.defaultType = r10.createLazyValue(new AnonymousClass2(this, r13));
        this.storageManager = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> r10, D r11) {
        return r10.visitTypeParameterDescriptor(this, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType r10 = this.defaultType.invoke();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ DeclarationDescriptorWithSource getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor r10 = (TypeParameterDescriptor) super.getOriginal();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public StorageManager getStorageManager() {
        StorageManager r10 = this.storageManager;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(14);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor r10 = this.typeConstructor.invoke();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(9);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public List<KotlinType> getUpperBounds() {
        List<KotlinType> r10 = ((TypeParameterTypeConstructor) getTypeConstructor()).mo1324getSupertypes();
        if (r10 != null) goto L5;
        $$$reportNull$$$0(8);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public Variance getVariance() {
        Variance r10 = this.variance;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(7);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
    public boolean isReified() {
        return this.reified;
    }

    protected List<KotlinType> processBoundsWithoutCycles(List<KotlinType> r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        return r10;
    }

    /* JADX INFO: renamed from: reportSupertypeLoopError */
    protected abstract void mo1326reportSupertypeLoopError(KotlinType r10);

    protected abstract List<KotlinType> resolveUpperBounds();
}
