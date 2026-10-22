package com.lynx.tasm.resourceprovider.media;

/* JADX INFO: loaded from: classes2.dex */
public final enum OptionalBool extends Enum<OptionalBool> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OptionalBool f10950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OptionalBool f10951b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OptionalBool f10952c = null;
    public static final /* synthetic */ OptionalBool[] d = null;

    static {
        OptionalBool r5 = new OptionalBool("TRUE", 0);
        f10950a = r5;
        OptionalBool r10 = new OptionalBool("FALSE", 1);
        f10951b = r10;
        OptionalBool r11 = new OptionalBool("UNDEFINED", 2);
        f10952c = r11;
        d = new OptionalBool[]{r5, r10, r11};
    }

    public OptionalBool(String r5, int r10) {
        super(r5, r10);
    }

    public static OptionalBool valueOf(String r5) {
        return (OptionalBool) Enum.valueOf(OptionalBool.class, r5);
    }

    public static OptionalBool[] values() {
        return (OptionalBool[]) d.clone();
    }
}
