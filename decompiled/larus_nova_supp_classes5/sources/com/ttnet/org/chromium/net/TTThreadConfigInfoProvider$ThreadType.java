package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum TTThreadConfigInfoProvider$ThreadType extends Enum<TTThreadConfigInfoProvider$ThreadType> {
    private static final /* synthetic */ TTThreadConfigInfoProvider$ThreadType[] $VALUES = null;
    public static final TTThreadConfigInfoProvider$ThreadType FILE_THREAD = null;
    public static final TTThreadConfigInfoProvider$ThreadType INIT_THREAD = null;
    public static final TTThreadConfigInfoProvider$ThreadType NETWORK_THREAD = null;
    public static final TTThreadConfigInfoProvider$ThreadType THREAD_POOL_SERVICE_THREAD = null;
    public static final TTThreadConfigInfoProvider$ThreadType WORKER_THREAD = null;

    static {
        TTThreadConfigInfoProvider$ThreadType r0 = new TTThreadConfigInfoProvider$ThreadType("INIT_THREAD", 0);
        INIT_THREAD = r0;
        TTThreadConfigInfoProvider$ThreadType r1 = new TTThreadConfigInfoProvider$ThreadType("NETWORK_THREAD", 1);
        NETWORK_THREAD = r1;
        TTThreadConfigInfoProvider$ThreadType r3 = new TTThreadConfigInfoProvider$ThreadType("FILE_THREAD", 2);
        FILE_THREAD = r3;
        TTThreadConfigInfoProvider$ThreadType r5 = new TTThreadConfigInfoProvider$ThreadType("THREAD_POOL_SERVICE_THREAD", 3);
        THREAD_POOL_SERVICE_THREAD = r5;
        TTThreadConfigInfoProvider$ThreadType r7 = new TTThreadConfigInfoProvider$ThreadType("WORKER_THREAD", 4);
        WORKER_THREAD = r7;
        $VALUES = new TTThreadConfigInfoProvider$ThreadType[]{r0, r1, r3, r5, r7};
    }

    public static TTThreadConfigInfoProvider$ThreadType[] values() {
        return (TTThreadConfigInfoProvider$ThreadType[]) $VALUES.clone();
    }

    public static TTThreadConfigInfoProvider$ThreadType valueOf(String r1) {
        return (TTThreadConfigInfoProvider$ThreadType) r27.a.a(TTThreadConfigInfoProvider$ThreadType.class, r1);
    }

    private TTThreadConfigInfoProvider$ThreadType(String r1, int r2) {
        super(r1, r2);
    }
}
