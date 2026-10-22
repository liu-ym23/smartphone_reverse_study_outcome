package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
final enum LynxSubErrorCode$Consumer extends Enum<LynxSubErrorCode$Consumer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxSubErrorCode$Consumer f10009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxSubErrorCode$Consumer f10010b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxSubErrorCode$Consumer f10011c = null;
    public static final /* synthetic */ LynxSubErrorCode$Consumer[] d = null;

    static {
        LynxSubErrorCode$Consumer r5 = new LynxSubErrorCode$Consumer("FRONT_END", 0);
        f10009a = r5;
        LynxSubErrorCode$Consumer r10 = new LynxSubErrorCode$Consumer("CLIENT", 1);
        f10010b = r10;
        LynxSubErrorCode$Consumer r11 = new LynxSubErrorCode$Consumer("LYNX", 2);
        f10011c = r11;
        d = new LynxSubErrorCode$Consumer[]{r5, r10, r11};
    }

    public LynxSubErrorCode$Consumer(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxSubErrorCode$Consumer valueOf(String r5) {
        return (LynxSubErrorCode$Consumer) Enum.valueOf(LynxSubErrorCode$Consumer.class, r5);
    }

    public static LynxSubErrorCode$Consumer[] values() {
        return (LynxSubErrorCode$Consumer[]) d.clone();
    }
}
