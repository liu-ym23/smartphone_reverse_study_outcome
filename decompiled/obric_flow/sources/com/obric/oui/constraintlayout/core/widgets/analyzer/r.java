package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12591a = null;

    static {
        int[] r5 = new int[ConstraintAnchor$Type.values().length];
        f12591a = r5;
        r5[ConstraintAnchor$Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L14:
        f12591a[ConstraintAnchor$Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L18:
        f12591a[ConstraintAnchor$Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L22:
        f12591a[ConstraintAnchor$Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L16:
        f12591a[ConstraintAnchor$Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
        return;
    }
}
