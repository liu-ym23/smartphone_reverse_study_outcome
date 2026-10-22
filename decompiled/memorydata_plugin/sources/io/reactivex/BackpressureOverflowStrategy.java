package io.reactivex;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum BackpressureOverflowStrategy extends Enum<BackpressureOverflowStrategy> {
    private static final /* synthetic */ BackpressureOverflowStrategy[] $VALUES = null;
    public static final BackpressureOverflowStrategy DROP_LATEST = null;
    public static final BackpressureOverflowStrategy DROP_OLDEST = null;
    public static final BackpressureOverflowStrategy ERROR = null;

    static {
        BackpressureOverflowStrategy r0 = new BackpressureOverflowStrategy(CipherConst.LEVEL_ERROR, 0);
        ERROR = r0;
        BackpressureOverflowStrategy r1 = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
        DROP_OLDEST = r1;
        BackpressureOverflowStrategy r3 = new BackpressureOverflowStrategy("DROP_LATEST", 2);
        DROP_LATEST = r3;
        $VALUES = new BackpressureOverflowStrategy[]{r0, r1, r3};
    }

    private BackpressureOverflowStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static BackpressureOverflowStrategy valueOf(String r2) {
        return (BackpressureOverflowStrategy) ZeusTransformUtils.preCheckCast(Enum.valueOf(BackpressureOverflowStrategy.class, r2), BackpressureOverflowStrategy.class, "com.obric.memorydata.plugin");
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BackpressureOverflowStrategy[].class, "com.obric.memorydata.plugin");
    }
}
