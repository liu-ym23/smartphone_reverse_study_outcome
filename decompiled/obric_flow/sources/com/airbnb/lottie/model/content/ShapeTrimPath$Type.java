package com.airbnb.lottie.model.content;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public final enum ShapeTrimPath$Type extends Enum<ShapeTrimPath$Type> {
    public static final ShapeTrimPath$Type INDIVIDUALLY = null;
    public static final ShapeTrimPath$Type SIMULTANEOUSLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShapeTrimPath$Type[] f1290a = null;

    static {
        ShapeTrimPath$Type r5 = new ShapeTrimPath$Type("SIMULTANEOUSLY", 0);
        SIMULTANEOUSLY = r5;
        ShapeTrimPath$Type r10 = new ShapeTrimPath$Type("INDIVIDUALLY", 1);
        INDIVIDUALLY = r10;
        f1290a = new ShapeTrimPath$Type[]{r5, r10};
    }

    public static ShapeTrimPath$Type forId(int r5) {
        if (r5 == 1) goto L11;
        if (r5 != 2) goto L9;
        return INDIVIDUALLY;
    L9:
        throw new IllegalArgumentException(j0.g(r5, "Unknown trim path type "));
    L11:
        return SIMULTANEOUSLY;
    }

    public static ShapeTrimPath$Type valueOf(String r5) {
        return (ShapeTrimPath$Type) Enum.valueOf(ShapeTrimPath$Type.class, r5);
    }

    public static ShapeTrimPath$Type[] values() {
        return (ShapeTrimPath$Type[]) f1290a.clone();
    }
}
