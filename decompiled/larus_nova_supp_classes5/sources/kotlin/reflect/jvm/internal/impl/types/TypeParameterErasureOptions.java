package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }

    public TypeParameterErasureOptions(boolean r1, boolean r2) {
        this.leaveNonTypeParameterTypes = r1;
        this.intersectUpperBounds = r2;
    }
}
