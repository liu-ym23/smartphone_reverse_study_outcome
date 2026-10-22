package org.apache.logging.log4j.spi;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final enum StandardLevel extends Enum<StandardLevel> {
    private static final /* synthetic */ StandardLevel[] $VALUES = null;
    public static final StandardLevel ALL = null;
    public static final StandardLevel DEBUG = null;
    public static final StandardLevel ERROR = null;
    public static final StandardLevel FATAL = null;
    public static final StandardLevel INFO = null;
    private static final EnumSet<StandardLevel> LEVELSET = null;
    public static final StandardLevel OFF = null;
    public static final StandardLevel TRACE = null;
    public static final StandardLevel WARN = null;
    private final int intLevel;

    static {
        StandardLevel r0 = new StandardLevel("OFF", 0, 0);
        OFF = r0;
        StandardLevel r1 = new StandardLevel("FATAL", 1, 100);
        FATAL = r1;
        StandardLevel r3 = new StandardLevel(CipherConst.LEVEL_ERROR, 2, 200);
        ERROR = r3;
        StandardLevel r5 = new StandardLevel(CipherConst.LEVEL_WARN, 3, 300);
        WARN = r5;
        StandardLevel r7 = new StandardLevel(CipherConst.LEVEL_INFO, 4, 400);
        INFO = r7;
        StandardLevel r9 = new StandardLevel(CipherConst.LEVEL_DEBUG, 5, 500);
        DEBUG = r9;
        StandardLevel r11 = new StandardLevel(CipherConst.LEVEL_TRACE, 6, 600);
        TRACE = r11;
        StandardLevel r13 = new StandardLevel("ALL", 7, Integer.MAX_VALUE);
        ALL = r13;
        $VALUES = new StandardLevel[]{r0, r1, r3, r5, r7, r9, r11, r13};
        LEVELSET = EnumSet.allOf(StandardLevel.class);
    }

    private StandardLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.intLevel = r3;
    }

    public static StandardLevel getStandardLevel(int r5) {
        StandardLevel r0 = OFF;
        Iterator r1 = LEVELSET.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        StandardLevel r2 = (StandardLevel) ZeusTransformUtils.preCheckCast(r1.next(), StandardLevel.class, "com.obric.memorydata.plugin");
        if (r2.intLevel() > r5) goto L9;
        r0 = r2;
    L9:
        return r0;
    }

    public static StandardLevel valueOf(String r2) {
        return (StandardLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(StandardLevel.class, r2), StandardLevel.class, "com.obric.memorydata.plugin");
    }

    public static StandardLevel[] values() {
        return (StandardLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StandardLevel[].class, "com.obric.memorydata.plugin");
    }

    public int intLevel() {
        return this.intLevel;
    }
}
