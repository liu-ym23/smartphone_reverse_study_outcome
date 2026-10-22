package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractLazyTypeParameterDescriptor extends AbstractTypeParameterDescriptor {
    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        switch(r10) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        r11[0] = "storageManager";
    L11:
        r11[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        r11[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L5:
        r11[0] = "supertypeLoopChecker";
        goto L11
    L6:
        r11[0] = "source";
        goto L11
    L7:
        r11[0] = "variance";
        goto L11
    L8:
        r11[0] = ActivityLifecycle.NAME;
        goto L11
    L9:
        r11[0] = "annotations";
        goto L11
    L10:
        r11[0] = "containingDeclaration";
        goto L11
    }

    public AbstractLazyTypeParameterDescriptor(StorageManager r10, DeclarationDescriptor r11, Annotations r12, Name r13, Variance r14, boolean r15, int r16, SourceElement r17, SupertypeLoopChecker r18) {
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
        super(r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        Object[] r10 = new Object[3];
        String r11 = "";
        if (isReified() == false) goto L5;
        String r12 = "reified ";
    L6:
        r10[0] = r12;
        if (getVariance() == Variance.INVARIANT) goto L10;
        r11 = getVariance() + " ";
    L10:
        r10[1] = r11;
        r10[2] = getName();
        return String.format("%s%s%s", r10);
    L5:
        r12 = "";
        goto L6
    }
}
