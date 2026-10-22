package org.checkerframework.dataflow.qual;

/* JADX INFO: loaded from: classes3.dex */
public final enum Pure$Kind extends Enum<Pure$Kind> {
    public static final Pure$Kind DETERMINISTIC = null;
    public static final Pure$Kind SIDE_EFFECT_FREE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Pure$Kind[] f20985a = null;

    static {
        Pure$Kind r5 = new Pure$Kind("SIDE_EFFECT_FREE", 0);
        SIDE_EFFECT_FREE = r5;
        Pure$Kind r10 = new Pure$Kind("DETERMINISTIC", 1);
        DETERMINISTIC = r10;
        f20985a = new Pure$Kind[]{r5, r10};
    }

    public static Pure$Kind valueOf(String r5) {
        return (Pure$Kind) Enum.valueOf(Pure$Kind.class, r5);
    }

    public static Pure$Kind[] values() {
        return (Pure$Kind[]) f20985a.clone();
    }
}
