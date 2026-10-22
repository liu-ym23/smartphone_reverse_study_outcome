package com.bytedance.bdinstall.dtrait.model;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum DTraitLogLevel extends Enum<DTraitLogLevel> {
    private static final /* synthetic */ DTraitLogLevel[] $VALUES = null;
    public static final DTraitLogLevel DEBUG = null;
    public static final DTraitLogLevel ERROR = null;
    public static final DTraitLogLevel WARN = null;
    private final String level;

    static {
        DTraitLogLevel r0 = new DTraitLogLevel(CipherConst.LEVEL_DEBUG, 0, CipherConst.LEVEL_DEBUG);
        DEBUG = r0;
        DTraitLogLevel r1 = new DTraitLogLevel(CipherConst.LEVEL_WARN, 1, "warn");
        WARN = r1;
        DTraitLogLevel r3 = new DTraitLogLevel(CipherConst.LEVEL_ERROR, 2, CipherConst.LEVEL_ERROR);
        ERROR = r3;
        $VALUES = new DTraitLogLevel[]{r0, r1, r3};
    }

    private DTraitLogLevel(String r1, int r2, String r3) {
        super(r1, r2);
        this.level = r3;
    }

    public static DTraitLogLevel valueOf(String r2) {
        return (DTraitLogLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(DTraitLogLevel.class, r2), DTraitLogLevel.class, "com.obric.memorydata.plugin");
    }

    public static DTraitLogLevel[] values() {
        return (DTraitLogLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DTraitLogLevel[].class, "com.obric.memorydata.plugin");
    }

    public String getLevel() {
        return this.level;
    }
}
