package com.lynx.tasm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
final enum LynxSubErrorCode$Consumer extends Enum<LynxSubErrorCode$Consumer> {
    public static final LynxSubErrorCode$Consumer CLIENT = null;
    public static final LynxSubErrorCode$Consumer FRONT_END = null;
    public static final LynxSubErrorCode$Consumer LYNX = null;
    public static final /* synthetic */ LynxSubErrorCode$Consumer[] a = null;
    public final String value;

    static {
        LynxSubErrorCode$Consumer r0 = new LynxSubErrorCode$Consumer("FRONT_END", 0, "front-end");
        FRONT_END = r0;
        LynxSubErrorCode$Consumer r1 = new LynxSubErrorCode$Consumer("CLIENT", 1, "client");
        CLIENT = r1;
        LynxSubErrorCode$Consumer r2 = new LynxSubErrorCode$Consumer("LYNX", 2, "lynx");
        LYNX = r2;
        a = new LynxSubErrorCode$Consumer[]{r0, r1, r2};
    }

    public static LynxSubErrorCode$Consumer[] values() {
        return (LynxSubErrorCode$Consumer[]) a.clone();
    }

    public static LynxSubErrorCode$Consumer valueOf(String r1) {
        return (LynxSubErrorCode$Consumer) r27.a.a(LynxSubErrorCode$Consumer.class, r1);
    }

    public LynxSubErrorCode$Consumer(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
