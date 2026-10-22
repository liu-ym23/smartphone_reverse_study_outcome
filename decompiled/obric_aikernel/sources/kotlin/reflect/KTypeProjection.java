package kotlin.reflect;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.1")
public final class KTypeProjection {
    public static final Companion Companion = null;

    @JvmField
    public static final KTypeProjection star = null;
    private final KType type;
    private final KVariance variance;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @PublishedApi
        public static /* synthetic */ void getStar$annotations() {
        }

        @JvmStatic
        public final KTypeProjection contravariant(KType r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            return new KTypeProjection(KVariance.IN, r10);
        }

        @JvmStatic
        public final KTypeProjection covariant(KType r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            return new KTypeProjection(KVariance.OUT, r10);
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }

        @JvmStatic
        public final KTypeProjection invariant(KType r10) {
            Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
            return new KTypeProjection(KVariance.INVARIANT, r10);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KVariance.values().length];
            r10[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        Companion = new Companion(null);
        star = new KTypeProjection(null, null);
    }

    public KTypeProjection(KVariance r10, KType r11) {
        this.variance = r10;
        this.type = r11;
        boolean r12 = true;
        if (r10 != null) goto L5;
        boolean r13 = true;
    L6:
        if (r11 != null) goto L8;
        boolean r14 = true;
    L9:
        if (r13 == r14) goto L12;
        r12 = false;
    L12:
        if (r12 == true) goto L18;
        if (r10 != null) goto L15;
        String r15 = "Star projection must have no type specified.";
    L17:
        throw new IllegalArgumentException(r15.toString());
    L15:
        r15 = "The projection variance " + r10 + " requires type to be specified.";
        goto L17
    L18:
        return;
    L8:
        r14 = false;
        goto L9
    L5:
        r13 = false;
        goto L6
    }

    @JvmStatic
    public static final KTypeProjection contravariant(KType r10) {
        return Companion.contravariant(r10);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection r10, KVariance r11, KType r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.variance;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.type;
    L9:
        return r10.copy(r11, r12);
    }

    @JvmStatic
    public static final KTypeProjection covariant(KType r10) {
        return Companion.covariant(r10);
    }

    @JvmStatic
    public static final KTypeProjection invariant(KType r10) {
        return Companion.invariant(r10);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance r10, KType r11) {
        return new KTypeProjection(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof KTypeProjection) == true) goto L8;
        return false;
    L8:
        KTypeProjection r11 = (KTypeProjection) r10;
        if (this.variance == r11.variance) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r11.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final KType getType() {
        return this.type;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        KVariance r10 = this.variance;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        KType r14 = this.type;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        KVariance r10 = this.variance;
        if (r10 != null) goto L5;
        int r11 = -1;
    L6:
        if (r11 != (-1)) goto L8;
        return "*";
    L8:
        if (r11 == 1) goto L22;
        if (r11 != 2) goto L12;
        StringBuilder r12 = new StringBuilder();
        String r13 = "in ";
    L17:
        r12.append(r13);
        r12.append(this.type);
        return r12.toString();
    L12:
        if (r11 != 3) goto L15;
        r12 = new StringBuilder();
        r13 = "out ";
        goto L17
    L15:
        throw new NoWhenBranchMatchedException();
    L22:
        return String.valueOf(this.type);
    L5:
        r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        goto L6
    }
}
