package org.slf4j.event;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public final enum Level extends Enum<Level> {
    private static final /* synthetic */ Level[] $VALUES = null;
    public static final Level DEBUG = null;
    public static final Level ERROR = null;
    public static final Level INFO = null;
    public static final Level TRACE = null;
    public static final Level WARN = null;
    private final int levelInt;
    private final String levelStr;

    private static /* synthetic */ Level[] $values() {
        return new Level[]{ERROR, WARN, INFO, DEBUG, TRACE};
    }

    static {
        ERROR = new Level(CipherConst.LEVEL_ERROR, 0, 40, CipherConst.LEVEL_ERROR);
        WARN = new Level(CipherConst.LEVEL_WARN, 1, 30, CipherConst.LEVEL_WARN);
        INFO = new Level(CipherConst.LEVEL_INFO, 2, 20, CipherConst.LEVEL_INFO);
        DEBUG = new Level(CipherConst.LEVEL_DEBUG, 3, 10, CipherConst.LEVEL_DEBUG);
        TRACE = new Level(CipherConst.LEVEL_TRACE, 4, 0, CipherConst.LEVEL_TRACE);
        $VALUES = $values();
    }

    private Level(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.levelInt = r3;
        this.levelStr = r4;
    }

    public static Level intToLevel(int r3) {
        if (r3 == 0) goto L22;
        if (r3 == 10) goto L20;
        if (r3 == 20) goto L18;
        if (r3 == 30) goto L16;
        if (r3 != 40) goto L14;
        return ERROR;
    L14:
        throw new IllegalArgumentException("Level integer [" + r3 + "] not recognized.");
    L16:
        return WARN;
    L18:
        return INFO;
    L20:
        return DEBUG;
    L22:
        return TRACE;
    }

    public static Level valueOf(String r2) {
        return (Level) ZeusTransformUtils.preCheckCast(Enum.valueOf(Level.class, r2), Level.class, "com.obric.memorydata.plugin");
    }

    public static Level[] values() {
        return (Level[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Level[].class, "com.obric.memorydata.plugin");
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
