package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    private boolean initialized;
    private final Function1<KotlinType, Void> reportCycleError;
    private final List<KotlinType> upperBounds;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 5) goto L6;
        if (r10 == 28) goto L6;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 5) goto L11;
        if (r10 == 28) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
        switch(r10) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L14;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L19;
            case 11: goto L21;
            case 12: goto L14;
            case 13: goto L24;
            case 14: goto L23;
            case 15: goto L22;
            case 16: goto L19;
            case 17: goto L18;
            case 18: goto L21;
            case 19: goto L14;
            case 20: goto L24;
            case 21: goto L23;
            case 22: goto L22;
            case 23: goto L19;
            case 24: goto L17;
            case 25: goto L21;
            case 26: goto L16;
            case 27: goto L15;
            case 28: goto L20;
            default: goto L14;
        };
    L14:
        r13[0] = "containingDeclaration";
    L26:
        if (r10 == 5) goto L30;
        if (r10 == 28) goto L29;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
    L31:
        switch(r10) {
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L36;
            case 8: goto L36;
            case 9: goto L36;
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            case 14: goto L36;
            case 15: goto L36;
            case 16: goto L36;
            case 17: goto L36;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L35;
            case 21: goto L35;
            case 22: goto L35;
            case 23: goto L35;
            case 24: goto L35;
            case 25: goto L35;
            case 26: goto L34;
            case 27: goto L33;
            case 28: goto L37;
            default: goto L32;
        };
    L32:
        r13[2] = "createWithDefaultBound";
        goto L37
    L33:
        r13[2] = "reportSupertypeLoopError";
        goto L37
    L34:
        r13[2] = "addUpperBound";
        goto L37
    L35:
        r13[2] = "<init>";
        goto L37
    L36:
        r13[2] = "createForFurtherModification";
    L37:
        String r14 = String.format(r11, r13);
        if (r10 == 5) goto L42;
        if (r10 == 28) goto L42;
        throw new IllegalArgumentException(r14);
    L42:
        throw new IllegalStateException(r14);
    L29:
        r13[1] = "resolveUpperBounds";
        goto L31
    L30:
        r13[1] = "createWithDefaultBound";
        goto L31
    L15:
        r13[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L26
    L16:
        r13[0] = "bound";
        goto L26
    L17:
        r13[0] = "supertypeLoopsChecker";
        goto L26
    L18:
        r13[0] = "supertypeLoopsResolver";
        goto L26
    L19:
        r13[0] = "source";
        goto L26
    L20:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        goto L26
    L21:
        r13[0] = "storageManager";
        goto L26
    L22:
        r13[0] = ActivityLifecycle.NAME;
        goto L26
    L23:
        r13[0] = "variance";
        goto L26
    L24:
        r13[0] = "annotations";
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    private TypeParameterDescriptorImpl(DeclarationDescriptor r12, Annotations r13, boolean r14, Variance r15, Name r16, int r17, SourceElement r18, Function1<KotlinType, Void> r19, SupertypeLoopChecker r20, StorageManager r21) {
        if (r12 != null) goto L5;
        $$$reportNull$$$0(19);
    L5:
        if (r13 != null) goto L7;
        $$$reportNull$$$0(20);
    L7:
        if (r15 != null) goto L9;
        $$$reportNull$$$0(21);
    L9:
        if (r16 != null) goto L11;
        $$$reportNull$$$0(22);
    L11:
        if (r18 != null) goto L13;
        $$$reportNull$$$0(23);
    L13:
        if (r20 != null) goto L15;
        $$$reportNull$$$0(24);
    L15:
        if (r21 != null) goto L17;
        $$$reportNull$$$0(25);
    L17:
        super(r21, r12, r13, r16, r15, r14, r17, r18, r20);
        this.upperBounds = new ArrayList(1);
        this.initialized = false;
        this.reportCycleError = r19;
    }

    private void checkInitialized() {
        if (this.initialized == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + nameForAssertions());
    }

    private void checkUninitialized() {
        if (this.initialized == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Type parameter descriptor is already initialized: " + nameForAssertions());
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor r12, Annotations r13, boolean r14, Variance r15, Name r16, int r17, SourceElement r18, Function1<KotlinType, Void> r19, SupertypeLoopChecker r20, StorageManager r21) {
        if (r12 != null) goto L4;
        $$$reportNull$$$0(12);
    L4:
        if (r13 != null) goto L6;
        $$$reportNull$$$0(13);
    L6:
        if (r15 != null) goto L8;
        $$$reportNull$$$0(14);
    L8:
        if (r16 != null) goto L10;
        $$$reportNull$$$0(15);
    L10:
        if (r18 != null) goto L12;
        $$$reportNull$$$0(16);
    L12:
        if (r20 != null) goto L14;
        $$$reportNull$$$0(17);
    L14:
        if (r21 != null) goto L17;
        $$$reportNull$$$0(18);
    L17:
        return new TypeParameterDescriptorImpl(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(DeclarationDescriptor r10, Annotations r11, boolean r12, Variance r13, Name r14, int r15, SourceElement r16, StorageManager r17) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r14 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        if (r16 != null) goto L12;
        $$$reportNull$$$0(10);
    L12:
        if (r17 != null) goto L15;
        $$$reportNull$$$0(11);
    L15:
        return createForFurtherModification(r10, r11, r12, r13, r14, r15, r16, null, SupertypeLoopChecker.EMPTY.INSTANCE, r17);
    }

    public static TypeParameterDescriptor createWithDefaultBound(DeclarationDescriptor r10, Annotations r11, boolean r12, Variance r13, Name r14, int r15, StorageManager r16) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r13 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r14 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        if (r16 != null) goto L12;
        $$$reportNull$$$0(4);
    L12:
        TypeParameterDescriptorImpl r17 = createForFurtherModification(r10, r11, r12, r13, r14, r15, SourceElement.NO_SOURCE, r16);
        r17.addUpperBound(DescriptorUtilsKt.getBuiltIns(r10).getDefaultBound());
        r17.setInitialized();
        return r17;
    }

    private void doAddUpperBound(KotlinType r10) {
        if (KotlinTypeKt.isError(r10) == false) goto L5;
        return;
    L5:
        this.upperBounds.add(r10);
    }

    private String nameForAssertions() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    public void addUpperBound(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(26);
    L4:
        checkUninitialized();
        doAddUpperBound(r10);
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    /* JADX INFO: renamed from: reportSupertypeLoopError */
    protected void mo1326reportSupertypeLoopError(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(27);
    L4:
        Function1<KotlinType, Void> r11 = this.reportCycleError;
        if (r11 != null) goto L7;
        return;
    L7:
        r11.invoke(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    protected List<KotlinType> resolveUpperBounds() {
        checkInitialized();
        List<KotlinType> r10 = this.upperBounds;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(28);
    L5:
        return r10;
    }

    public void setInitialized() {
        checkUninitialized();
        this.initialized = true;
    }
}
