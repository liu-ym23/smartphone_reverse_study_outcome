package kotlin.reflect.jvm.internal.impl.types;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* JADX INFO: loaded from: classes3.dex */
public class TypeProjectionImpl extends TypeProjectionBase {
    private final Variance projection;
    private final KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 4) goto L6;
        if (r10 == 5) goto L6;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r10 == 4) goto L11;
        if (r10 == 5) goto L11;
        int r12 = 3;
    L12:
        Object[] r13 = new Object[r12];
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
        r13[0] = "projection";
    L19:
        if (r10 == 4) goto L23;
        if (r10 == 5) goto L22;
        r13[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
    L24:
        if (r10 == 3) goto L31;
        if (r10 == 4) goto L32;
        if (r10 == 5) goto L32;
        if (r10 == 6) goto L30;
        r13[2] = "<init>";
        goto L32
    L30:
        r13[2] = "refine";
    L32:
        String r14 = String.format(r11, r13);
        if (r10 == 4) goto L37;
        if (r10 == 5) goto L37;
        throw new IllegalArgumentException(r14);
    L37:
        throw new IllegalStateException(r14);
    L31:
        r13[2] = "replaceType";
        goto L32
    L22:
        r13[1] = "getType";
        goto L24
    L23:
        r13[1] = "getProjectionKind";
        goto L24
    L15:
        r13[0] = "kotlinTypeRefiner";
        goto L19
    L16:
        r13[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        goto L19
    L17:
        r13[0] = WsConstants.KEY_CONNECTION_TYPE;
    L11:
        r12 = 2;
    L6:
        r11 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public TypeProjectionImpl(KotlinType r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(2);
    L4:
        this(Variance.INVARIANT, r10);
    }

    public TypeProjectionImpl(Variance r10, KotlinType r11) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r11 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        this.projection = r10;
        this.type = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public Variance getProjectionKind() {
        Variance r10 = this.projection;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(4);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public KotlinType getType() {
        KotlinType r10 = this.type;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(5);
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public TypeProjection refine(KotlinTypeRefiner r10) {
        if (r10 != null) goto L5;
        $$$reportNull$$$0(6);
    L5:
        return new TypeProjectionImpl(this.projection, r10.refineType(this.type));
    }
}
