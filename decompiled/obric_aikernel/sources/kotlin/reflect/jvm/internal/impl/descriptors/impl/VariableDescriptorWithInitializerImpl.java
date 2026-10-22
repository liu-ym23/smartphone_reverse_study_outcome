package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VariableDescriptorWithInitializerImpl extends VariableDescriptorImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected NullableLazyValue<ConstantValue<?>> compileTimeInitializer;
    protected Function0<NullableLazyValue<ConstantValue<?>>> compileTimeInitializerFactory;
    private final boolean isVar;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        Object[] r11 = new Object[3];
        if (r10 == 1) goto L12;
        if (r10 == 2) goto L11;
        if (r10 == 3) goto L10;
        if (r10 == 4) goto L9;
        if (r10 == 5) goto L9;
        r11[0] = "containingDeclaration";
    L13:
        r11[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (r10 == 4) goto L18;
        if (r10 == 5) goto L17;
        r11[2] = "<init>";
    L20:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r11));
    L17:
        r11[2] = "setCompileTimeInitializer";
        goto L20
    L18:
        r11[2] = "setCompileTimeInitializerFactory";
    L9:
        r11[0] = "compileTimeInitializerFactory";
        goto L13
    L10:
        r11[0] = "source";
        goto L13
    L11:
        r11[0] = ActivityLifecycle.NAME;
        goto L13
    L12:
        r11[0] = "annotations";
        goto L13
    }

    static {
    }

    public VariableDescriptorWithInitializerImpl(DeclarationDescriptor r10, Annotations r11, Name r12, KotlinType r13, boolean r14, SourceElement r15) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r12 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r15 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        super(r10, r11, r12, r13, r15);
        this.isVar = r14;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer */
    public ConstantValue<?> mo1319getCompileTimeInitializer() {
        NullableLazyValue<ConstantValue<?>> r10 = this.compileTimeInitializer;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return this.isVar;
    }

    public void setCompileTimeInitializer(NullableLazyValue<ConstantValue<?>> r10, Function0<NullableLazyValue<ConstantValue<?>>> r11) {
        if (r11 != null) goto L4;
        $$$reportNull$$$0(5);
    L4:
        this.compileTimeInitializerFactory = r11;
        if (r10 != null) goto L8;
        r10 = r11.invoke();
    L8:
        this.compileTimeInitializer = r10;
    }

    public void setCompileTimeInitializerFactory(Function0<NullableLazyValue<ConstantValue<?>>> r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        setCompileTimeInitializer(null, r10);
    }
}
