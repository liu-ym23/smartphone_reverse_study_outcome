package kotlin.jvm.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object r1) {
        super(r1);
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object r10, Class r11, String r12, String r13, int r14) {
        boolean r1 = false;
        if ((r14 & 1) != 1) goto L5;
        boolean r8 = true;
    L6:
        super(r10, r11, r12, r13, r8);
        if ((r14 & 2) != 2) goto L9;
        r1 = true;
    L9:
        this.syntheticJavaProperty = r1;
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable compute() {
        if (this.syntheticJavaProperty == false) goto L6;
        return this;
    L6:
        return super.compute();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PropertyReference.class) == false) goto L19;
        PropertyReference r6 = (PropertyReference) ZeusTransformUtils.preCheckCast(r5, PropertyReference.class, "com.obric.memorydata.plugin");
        if (getOwner().equals(r6.getOwner()) == false) goto L17;
        if (getName().equals(r6.getName()) == false) goto L17;
        if (getSignature().equals(r6.getSignature()) == false) goto L17;
        if (Intrinsics.areEqual(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, KProperty.class) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    @Override // kotlin.jvm.internal.CallableReference
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KProperty getReflected() {
        if (this.syntheticJavaProperty == true) goto L7;
        return (KProperty) ZeusTransformUtils.preCheckCast(super.getReflected(), KProperty.class, "com.obric.memorydata.plugin");
    L7:
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
