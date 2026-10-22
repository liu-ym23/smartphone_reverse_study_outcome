package hr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f17392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f17393b = null;

    static {
        int[] r5 = new int[ConstraintWidget$DimensionBehaviour.values().length];
        f17393b = r5;
        r5[ConstraintWidget$DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
    L36:
        f17393b[ConstraintWidget$DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
    L46:
        f17393b[ConstraintWidget$DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
    L58:
        f17393b[ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
    L10:
        int[] r10 = new int[ConstraintAnchor$Type.values().length];
        f17392a = r10;
        r10[ConstraintAnchor$Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
    L38:
        f17392a[ConstraintAnchor$Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
    L44:
        f17392a[ConstraintAnchor$Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
    L52:
        f17392a[ConstraintAnchor$Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
    L34:
        f17392a[ConstraintAnchor$Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
    L42:
        f17392a[ConstraintAnchor$Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
    L56:
        f17392a[ConstraintAnchor$Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
    L40:
        f17392a[ConstraintAnchor$Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
    L48:
        f17392a[ConstraintAnchor$Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        return;
    }
}
