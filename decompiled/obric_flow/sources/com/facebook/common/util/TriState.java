package com.facebook.common.util;

/* JADX INFO: loaded from: classes2.dex */
public final enum TriState extends Enum<TriState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TriState f7696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TriState f7697b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TriState f7698c = null;
    public static final /* synthetic */ TriState[] d = null;

    static {
        TriState r5 = new TriState("YES", 0);
        f7696a = r5;
        TriState r10 = new TriState("NO", 1);
        f7697b = r10;
        TriState r11 = new TriState("UNSET", 2);
        f7698c = r11;
        d = new TriState[]{r5, r10, r11};
    }

    public TriState(String r5, int r10) {
        super(r5, r10);
    }

    public static TriState valueOf(String r5) {
        return (TriState) Enum.valueOf(TriState.class, r5);
    }

    public static TriState[] values() {
        return (TriState[]) d.clone();
    }
}
