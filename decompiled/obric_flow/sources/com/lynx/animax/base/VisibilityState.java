package com.lynx.animax.base;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final enum VisibilityState extends Enum<VisibilityState> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final VisibilityState f9581b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final VisibilityState f9582c = null;
    public static final VisibilityState d = null;
    public static final VisibilityState e = null;
    public static final VisibilityState f = null;
    public static final VisibilityState g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ VisibilityState[] f9583h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9584a;

    static {
        VisibilityState r5 = new VisibilityState("BACKGROUND", 0, 1);
        f9581b = r5;
        VisibilityState r10 = new VisibilityState("VISIBLE", 1, 2);
        f9582c = r10;
        VisibilityState r11 = new VisibilityState("OPACITY", 2, 4);
        d = r11;
        VisibilityState r12 = new VisibilityState("SIZE", 3, 8);
        e = r12;
        VisibilityState r13 = new VisibilityState("ATTACH", 4, 16);
        f = r13;
        VisibilityState r14 = new VisibilityState("AGGREGATED", 5, 32);
        g = r14;
        f9583h = new VisibilityState[]{r5, r10, r11, r12, r13, r14};
    }

    public VisibilityState(String r5, int r10, int r11) {
        super(r5, r10);
        this.f9584a = r11;
    }

    public static VisibilityState valueOf(String r5) {
        return (VisibilityState) Enum.valueOf(VisibilityState.class, r5);
    }

    public static VisibilityState[] values() {
        return (VisibilityState[]) f9583h.clone();
    }
}
