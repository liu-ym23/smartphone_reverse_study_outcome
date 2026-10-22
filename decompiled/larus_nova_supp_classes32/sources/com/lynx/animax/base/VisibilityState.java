package com.lynx.animax.base;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum VisibilityState extends Enum<VisibilityState> {
    public static final VisibilityState AGGREGATED = null;
    public static final VisibilityState ATTACH = null;
    public static final VisibilityState BACKGROUND = null;
    public static final VisibilityState OPACITY = null;
    public static final VisibilityState SIZE = null;
    public static final VisibilityState VISIBLE = null;
    public static final /* synthetic */ VisibilityState[] a = null;
    private final int value;

    static {
        VisibilityState r0 = new VisibilityState("BACKGROUND", 0, 1);
        BACKGROUND = r0;
        VisibilityState r1 = new VisibilityState("VISIBLE", 1, 2);
        VISIBLE = r1;
        VisibilityState r4 = new VisibilityState("OPACITY", 2, 4);
        OPACITY = r4;
        VisibilityState r6 = new VisibilityState("SIZE", 3, 8);
        SIZE = r6;
        VisibilityState r8 = new VisibilityState("ATTACH", 4, 16);
        ATTACH = r8;
        VisibilityState r9 = new VisibilityState("AGGREGATED", 5, 32);
        AGGREGATED = r9;
        a = new VisibilityState[]{r0, r1, r4, r6, r8, r9};
    }

    public static VisibilityState[] values() {
        return (VisibilityState[]) a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static VisibilityState valueOf(String r1) {
        return (VisibilityState) a.a(VisibilityState.class, r1);
    }

    public VisibilityState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
