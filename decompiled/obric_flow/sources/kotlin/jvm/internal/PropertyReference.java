package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
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
        if ((r5 instanceof PropertyReference) == false) goto L19;
        PropertyReference r10 = (PropertyReference) r5;
        if (getOwner().equals(r10.getOwner()) == false) goto L17;
        if (getName().equals(r10.getName()) == false) goto L17;
        if (getSignature().equals(r10.getSignature()) == false) goto L17;
        if (Intrinsics.areEqual(getBoundReceiver(), r10.getBoundReceiver()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if ((r5 instanceof KProperty) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public int hashCode() {
        int r5 = getOwner().hashCode() * 31;
        int r10 = (getName().hashCode() + r5) * 31;
        return getSignature().hashCode() + r10;
    }

    @Override // kotlin.reflect.KProperty
    @SinceKotlin(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    @SinceKotlin(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable r5 = compute();
        if (r5 == this) goto L7;
        return r5.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public KProperty getReflected() {
        if (this.syntheticJavaProperty == true) goto L7;
        return (KProperty) super.getReflected();
    L7:
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference(Object r5) {
        super(r5);
        this.syntheticJavaProperty = false;
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference(Object r10, Class r11, String r12, String r13, int r14) {
        boolean r5 = false;
        if ((r14 & 1) != 1) goto L5;
        boolean r15 = true;
    L6:
        super(r10, r11, r12, r13, r15);
        if ((r14 & 2) != 2) goto L9;
        r5 = true;
    L9:
        this.syntheticJavaProperty = r5;
        return;
    L5:
        r15 = false;
        goto L6
    }
}
