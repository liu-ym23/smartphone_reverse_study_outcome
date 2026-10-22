package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public TypeParameterErasureOptions(boolean r10, boolean r11) {
        this.leaveNonTypeParameterTypes = r10;
        this.intersectUpperBounds = r11;
    }

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }
}
