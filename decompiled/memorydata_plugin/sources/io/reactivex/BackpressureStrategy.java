package io.reactivex;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum BackpressureStrategy extends Enum<BackpressureStrategy> {
    private static final /* synthetic */ BackpressureStrategy[] $VALUES = null;
    public static final BackpressureStrategy BUFFER = null;
    public static final BackpressureStrategy DROP = null;
    public static final BackpressureStrategy ERROR = null;
    public static final BackpressureStrategy LATEST = null;
    public static final BackpressureStrategy MISSING = null;

    static {
        BackpressureStrategy r0 = new BackpressureStrategy("MISSING", 0);
        MISSING = r0;
        BackpressureStrategy r1 = new BackpressureStrategy(CipherConst.LEVEL_ERROR, 1);
        ERROR = r1;
        BackpressureStrategy r3 = new BackpressureStrategy("BUFFER", 2);
        BUFFER = r3;
        BackpressureStrategy r5 = new BackpressureStrategy("DROP", 3);
        DROP = r5;
        BackpressureStrategy r7 = new BackpressureStrategy("LATEST", 4);
        LATEST = r7;
        $VALUES = new BackpressureStrategy[]{r0, r1, r3, r5, r7};
    }

    private BackpressureStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static BackpressureStrategy valueOf(String r2) {
        return (BackpressureStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(BackpressureStrategy.class, r2), BackpressureStrategy.class, "com.obric.memorydata.plugin");
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BackpressureStrategy[].class, "com.obric.memorydata.plugin");
    }
}
