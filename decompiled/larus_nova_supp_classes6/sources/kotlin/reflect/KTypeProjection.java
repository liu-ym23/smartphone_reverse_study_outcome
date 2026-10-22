package kotlin.reflect;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class KTypeProjection {
    public static final Companion Companion = null;
    public static final KTypeProjection star = null;
    private final KType type;
    private final KVariance variance;

    @JvmStatic
    public static final KTypeProjection contravariant(KType r1) {
        return Companion.contravariant(r1);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection r0, KVariance r1, KType r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.variance;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.type;
    L9:
        return r0.copy(r1, r2);
    }

    @JvmStatic
    public static final KTypeProjection covariant(KType r1) {
        return Companion.covariant(r1);
    }

    @JvmStatic
    public static final KTypeProjection invariant(KType r1) {
        return Companion.invariant(r1);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance r2, KType r3) {
        return new KTypeProjection(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KTypeProjection) == true) goto L8;
        return false;
    L8:
        KTypeProjection r6 = (KTypeProjection) r5;
        if (this.variance == r6.variance) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        KVariance r0 = this.variance;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        KType r4 = this.type;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new Companion(null);
        star = new KTypeProjection(null, null);
    }

    public String toString() {
        KVariance r0 = this.variance;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 != (-1)) goto L8;
        return "*";
    L8:
        if (r1 == 1) goto L22;
        if (r1 == 2) goto L21;
        if (r1 != 3) goto L15;
        return "out " + this.type;
    L15:
        throw new NoWhenBranchMatchedException();
    L21:
        return "in " + this.type;
    L22:
        return String.valueOf(this.type);
    L5:
        r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        goto L6
    }

    public final KType getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public KTypeProjection(KVariance r4, KType r5) {
        this.variance = r4;
        this.type = r5;
        boolean r0 = true;
        if (r4 != null) goto L5;
        boolean r2 = true;
    L6:
        if (r5 != null) goto L8;
        boolean r6 = true;
    L9:
        if (r2 == r6) goto L12;
        r0 = false;
    L12:
        if (r0 == true) goto L18;
        if (r4 != null) goto L15;
        String r7 = "Star projection must have no type specified.";
    L17:
        throw new IllegalArgumentException(r7.toString());
    L15:
        r7 = "The projection variance " + r4 + " requires type to be specified.";
        goto L17
    L18:
        return;
    L8:
        r6 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}
