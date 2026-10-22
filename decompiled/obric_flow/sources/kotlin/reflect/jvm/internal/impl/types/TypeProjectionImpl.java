package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L6;
        if (r10 == 5) goto L6;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 4) goto L11;
        if (r10 == 5) goto L11;
        int r11 = 3;
    L12:
        Object[] r12 = new Object[r11];
        switch(r10) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r12[0] = "projection";
    L19:
        if (r10 == 4) goto L23;
        if (r10 == 5) goto L22;
        r12[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
    L24:
        if (r10 == 3) goto L31;
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L32;
        if (r10 == 6) goto L30;
        r12[2] = "<init>";
        goto L32
    L30:
        r12[2] = "refine";
    L32:
        String r13 = String.format(r5, r12);
        if (r10 == 4) goto L37;
        if (r10 == 5) goto L37;
        throw new IllegalArgumentException(r13);
    L37:
        throw new IllegalStateException(r13);
    L31:
        r12[2] = "replaceType";
        goto L32
    L22:
        r12[1] = "getType";
        goto L24
    L23:
        r12[1] = "getProjectionKind";
        goto L24
    L15:
        r12[0] = "kotlinTypeRefiner";
        goto L19
    L16:
        r12[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        goto L19
    L17:
        r12[0] = "type";
    L11:
        r11 = 2;
    L6:
        r5 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public TypeProjectionImpl(Variance r5, KotlinType r10) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r10 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.projection = r5;
        this.type = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        Variance r5 = this.projection;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        KotlinType r5 = this.type;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner r5) {
        if (r5 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return new TypeProjectionImpl(this.projection, r5.refineType(this.type));
    }

    public TypeProjectionImpl(KotlinType r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this(Variance.INVARIANT, r5);
    }
}
