package com.lynx.clay.embedding.engine.plugins.platformview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum PlatformMethodCallbackResult extends Enum<PlatformMethodCallbackResult> {
    public static final PlatformMethodCallbackResult METHOD_NOT_FOUND = null;
    public static final PlatformMethodCallbackResult NODE_NOT_FOUND = null;
    public static final PlatformMethodCallbackResult PARAM_INVALID = null;
    public static final PlatformMethodCallbackResult SUCCESS = null;
    public static final PlatformMethodCallbackResult UNKNOWN = null;
    public static final /* synthetic */ PlatformMethodCallbackResult[] a = null;

    static {
        PlatformMethodCallbackResult r0 = new PlatformMethodCallbackResult("SUCCESS", 0);
        SUCCESS = r0;
        PlatformMethodCallbackResult r1 = new PlatformMethodCallbackResult("UNKNOWN", 1);
        UNKNOWN = r1;
        PlatformMethodCallbackResult r3 = new PlatformMethodCallbackResult("NODE_NOT_FOUND", 2);
        NODE_NOT_FOUND = r3;
        PlatformMethodCallbackResult r5 = new PlatformMethodCallbackResult("METHOD_NOT_FOUND", 3);
        METHOD_NOT_FOUND = r5;
        PlatformMethodCallbackResult r7 = new PlatformMethodCallbackResult("PARAM_INVALID", 4);
        PARAM_INVALID = r7;
        a = new PlatformMethodCallbackResult[]{r0, r1, r3, r5, r7};
    }

    public static PlatformMethodCallbackResult[] values() {
        return (PlatformMethodCallbackResult[]) a.clone();
    }

    public static PlatformMethodCallbackResult valueOf(String r1) {
        return (PlatformMethodCallbackResult) r27.a.a(PlatformMethodCallbackResult.class, r1);
    }

    public PlatformMethodCallbackResult(String r1, int r2) {
        super(r1, r2);
    }
}
