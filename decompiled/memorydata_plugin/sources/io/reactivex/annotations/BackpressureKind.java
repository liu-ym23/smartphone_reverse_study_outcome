package io.reactivex.annotations;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum BackpressureKind extends Enum<BackpressureKind> {
    private static final /* synthetic */ BackpressureKind[] $VALUES = null;
    public static final BackpressureKind ERROR = null;
    public static final BackpressureKind FULL = null;
    public static final BackpressureKind NONE = null;
    public static final BackpressureKind PASS_THROUGH = null;
    public static final BackpressureKind SPECIAL = null;
    public static final BackpressureKind UNBOUNDED_IN = null;

    static {
        BackpressureKind r0 = new BackpressureKind("PASS_THROUGH", 0);
        PASS_THROUGH = r0;
        BackpressureKind r1 = new BackpressureKind("FULL", 1);
        FULL = r1;
        BackpressureKind r3 = new BackpressureKind("SPECIAL", 2);
        SPECIAL = r3;
        BackpressureKind r5 = new BackpressureKind("UNBOUNDED_IN", 3);
        UNBOUNDED_IN = r5;
        BackpressureKind r7 = new BackpressureKind(CipherConst.LEVEL_ERROR, 4);
        ERROR = r7;
        BackpressureKind r9 = new BackpressureKind("NONE", 5);
        NONE = r9;
        $VALUES = new BackpressureKind[]{r0, r1, r3, r5, r7, r9};
    }

    private BackpressureKind(String r1, int r2) {
        super(r1, r2);
    }

    public static BackpressureKind valueOf(String r2) {
        return (BackpressureKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(BackpressureKind.class, r2), BackpressureKind.class, "com.obric.memorydata.plugin");
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BackpressureKind[].class, "com.obric.memorydata.plugin");
    }
}
