package lr;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19699a = null;

    static {
        int[] r5 = new int[ConstraintWidget$DimensionBehaviour.values().length];
        f19699a = r5;
        r5[ConstraintWidget$DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f19699a[ConstraintWidget$DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f19699a[ConstraintWidget$DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f19699a[ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
