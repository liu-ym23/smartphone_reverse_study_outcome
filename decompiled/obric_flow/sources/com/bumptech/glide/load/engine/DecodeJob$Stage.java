package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
final enum DecodeJob$Stage extends Enum<DecodeJob$Stage> {
    public static final DecodeJob$Stage DATA_CACHE = null;
    public static final DecodeJob$Stage ENCODE = null;
    public static final DecodeJob$Stage FINISHED = null;
    public static final DecodeJob$Stage INITIALIZE = null;
    public static final DecodeJob$Stage RESOURCE_CACHE = null;
    public static final DecodeJob$Stage SOURCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeJob$Stage[] f1437a = null;

    static {
        DecodeJob$Stage r5 = new DecodeJob$Stage("INITIALIZE", 0);
        INITIALIZE = r5;
        DecodeJob$Stage r10 = new DecodeJob$Stage("RESOURCE_CACHE", 1);
        RESOURCE_CACHE = r10;
        DecodeJob$Stage r11 = new DecodeJob$Stage("DATA_CACHE", 2);
        DATA_CACHE = r11;
        DecodeJob$Stage r12 = new DecodeJob$Stage("SOURCE", 3);
        SOURCE = r12;
        DecodeJob$Stage r13 = new DecodeJob$Stage("ENCODE", 4);
        ENCODE = r13;
        DecodeJob$Stage r14 = new DecodeJob$Stage("FINISHED", 5);
        FINISHED = r14;
        f1437a = new DecodeJob$Stage[]{r5, r10, r11, r12, r13, r14};
    }

    public static DecodeJob$Stage valueOf(String r5) {
        return (DecodeJob$Stage) Enum.valueOf(DecodeJob$Stage.class, r5);
    }

    public static DecodeJob$Stage[] values() {
        return (DecodeJob$Stage[]) f1437a.clone();
    }
}
