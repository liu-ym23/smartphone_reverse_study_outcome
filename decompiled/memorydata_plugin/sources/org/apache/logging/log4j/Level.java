package org.apache.logging.log4j;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.logging.log4j.spi.StandardLevel;
import org.apache.logging.log4j.util.s;

/* JADX INFO: loaded from: classes6.dex */
public final class Level implements Serializable, Comparable<Level> {
    public static final Level ALL = null;
    public static final String CATEGORY = "Level";
    public static final Level DEBUG = null;
    private static final Level[] EMPTY_ARRAY = null;
    public static final Level ERROR = null;
    public static final Level FATAL = null;
    public static final Level INFO = null;
    private static final ConcurrentMap<String, Level> LEVELS = null;
    public static final Level OFF = null;
    public static final Level TRACE = null;
    public static final Level WARN = null;
    private static final long serialVersionUID = 1581082;
    private final int intLevel;
    private final String name;
    private final StandardLevel standardLevel;

    static {
        EMPTY_ARRAY = new Level[0];
        LEVELS = new ConcurrentHashMap();
        OFF = new Level("OFF", StandardLevel.OFF.intLevel());
        FATAL = new Level("FATAL", StandardLevel.FATAL.intLevel());
        ERROR = new Level(CipherConst.LEVEL_ERROR, StandardLevel.ERROR.intLevel());
        WARN = new Level(CipherConst.LEVEL_WARN, StandardLevel.WARN.intLevel());
        INFO = new Level(CipherConst.LEVEL_INFO, StandardLevel.INFO.intLevel());
        DEBUG = new Level(CipherConst.LEVEL_DEBUG, StandardLevel.DEBUG.intLevel());
        TRACE = new Level(CipherConst.LEVEL_TRACE, StandardLevel.TRACE.intLevel());
        ALL = new Level("ALL", StandardLevel.ALL.intLevel());
    }

    private Level(String r2, int r3) {
        if (s.a(r2) == true) goto L13;
        if (r3 < 0) goto L11;
        this.name = r2;
        this.intLevel = r3;
        this.standardLevel = StandardLevel.getStandardLevel(r3);
        if (LEVELS.putIfAbsent(toUpperCase(r2.trim()), this) != null) goto L9;
        return;
    L9:
        throw new IllegalStateException("Level " + r2 + " has already been defined.");
    L11:
        throw new IllegalArgumentException("Illegal Level int less than zero.");
    L13:
        throw new IllegalArgumentException("Illegal null or empty Level name.");
    }

    public static Level forName(String r4, int r5) {
        if (s.a(r4) == true) goto L12;
        String r1 = toUpperCase(r4.trim());
        Level r2 = (Level) ZeusTransformUtils.preCheckCast(LEVELS.get(r1), Level.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        return r2;
    L13:
        return new Level(r4, r5);
    L10:
        return (Level) ZeusTransformUtils.preCheckCast(LEVELS.get(r1), Level.class, "com.obric.memorydata.plugin");
    L12:
        throw new IllegalArgumentException("Illegal null or empty Level name.");
    }

    public static Level getLevel(String r2) {
        if (s.a(r2) == true) goto L7;
        return (Level) ZeusTransformUtils.preCheckCast(LEVELS.get(toUpperCase(r2.trim())), Level.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException("Illegal null or empty Level name.");
    }

    public static Level toLevel(String r1) {
        return toLevel(r1, DEBUG);
    }

    public static Level toLevel(String r2, Level r3) {
        if (r2 != null) goto L4;
        return r3;
    L4:
        Level r4 = (Level) ZeusTransformUtils.preCheckCast(LEVELS.get(toUpperCase(r2.trim())), Level.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4;
    }

    private static String toUpperCase(String r1) {
        return r1.toUpperCase(Locale.ENGLISH);
    }

    public static <T extends Enum<T>> T valueOf(Class<T> r0, String r1) {
        return (T) Enum.valueOf(r0, r1);
    }

    public static Level valueOf(String r3) {
        Objects.requireNonNull(r3, "No level name given.");
        String r4 = toUpperCase(r3.trim());
        Level r0 = (Level) ZeusTransformUtils.preCheckCast(LEVELS.get(r4), Level.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Unknown level constant [" + r4 + "].");
    }

    public static Level[] values() {
        return (Level[]) ZeusTransformUtils.preCheckCast(LEVELS.values().toArray(EMPTY_ARRAY), Level[].class, "com.obric.memorydata.plugin");
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3151clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Level m3151clone() {
        throw new CloneNotSupportedException();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Level r3) {
        return compareTo2((Level) ZeusTransformUtils.preCheckCast(r3, Level.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Level r1) {
        int r0 = this.intLevel;
        int r2 = r1.intLevel;
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    public boolean equals(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Level.class) == false) goto L6;
        if (r2 != this) goto L6;
        return true;
    L6:
        return false;
    }

    public Class<Level> getDeclaringClass() {
        return Level.class;
    }

    public StandardLevel getStandardLevel() {
        return this.standardLevel;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public int intLevel() {
        return this.intLevel;
    }

    public boolean isInRange(Level r1, Level r2) {
        int r0 = this.intLevel;
        if (r0 >= r1.intLevel) goto L5;
    L7:
        return false;
    L5:
        if (r0 > r2.intLevel) goto L7;
        return true;
    }

    public boolean isLessSpecificThan(Level r1) {
        if (this.intLevel < r1.intLevel) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMoreSpecificThan(Level r1) {
        if (this.intLevel > r1.intLevel) goto L5;
        return true;
    L5:
        return false;
    }

    public String name() {
        return this.name;
    }

    public Object readResolve() {
        return valueOf(this.name);
    }

    public String toString() {
        return this.name;
    }
}
