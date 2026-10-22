package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum EncodeStrategy extends Enum<EncodeStrategy> {
    public static final EncodeStrategy NONE = null;
    public static final EncodeStrategy SOURCE = null;
    public static final EncodeStrategy TRANSFORMED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EncodeStrategy[] f1416a = null;

    static {
        EncodeStrategy r5 = new EncodeStrategy("SOURCE", 0);
        SOURCE = r5;
        EncodeStrategy r10 = new EncodeStrategy("TRANSFORMED", 1);
        TRANSFORMED = r10;
        EncodeStrategy r11 = new EncodeStrategy("NONE", 2);
        NONE = r11;
        f1416a = new EncodeStrategy[]{r5, r10, r11};
    }

    public static EncodeStrategy valueOf(String r5) {
        return (EncodeStrategy) Enum.valueOf(EncodeStrategy.class, r5);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[]) f1416a.clone();
    }
}
