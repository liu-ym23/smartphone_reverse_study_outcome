package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public final enum BoundType extends Enum<BoundType> {
    public static final BoundType CLOSED = null;
    public static final BoundType OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BoundType[] f8790a = null;
    final boolean inclusive;

    static {
        BoundType r5 = new BoundType("OPEN", 0, false);
        OPEN = r5;
        BoundType r10 = new BoundType("CLOSED", 1, true);
        CLOSED = r10;
        f8790a = new BoundType[]{r5, r10};
    }

    public BoundType(String r5, int r10, boolean r11) {
        super(r5, r10);
        this.inclusive = r11;
    }

    public static BoundType forBoolean(boolean r5) {
        if (r5 == false) goto L5;
        return CLOSED;
    L5:
        return OPEN;
    }

    public static BoundType valueOf(String r5) {
        return (BoundType) Enum.valueOf(BoundType.class, r5);
    }

    public static BoundType[] values() {
        return (BoundType[]) f8790a.clone();
    }
}
