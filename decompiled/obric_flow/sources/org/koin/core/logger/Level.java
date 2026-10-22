package org.koin.core.logger;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lorg/koin/core/logger/Level;", "", "DEBUG", "INFO", "WARNING", "ERROR", "NONE", "koin-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum Level extends Enum<Level> {
    public static final Level DEBUG = null;
    public static final Level ERROR = null;
    public static final Level INFO = null;
    public static final Level NONE = null;
    public static final Level WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f21018a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f21019b = null;

    static {
        Level r5 = new Level("DEBUG", 0);
        DEBUG = r5;
        Level r10 = new Level("INFO", 1);
        INFO = r10;
        Level r11 = new Level("WARNING", 2);
        WARNING = r11;
        Level r12 = new Level("ERROR", 3);
        ERROR = r12;
        Level r13 = new Level("NONE", 4);
        NONE = r13;
        Level[] r14 = {r5, r10, r11, r12, r13};
        f21018a = r14;
        f21019b = EnumEntriesKt.enumEntries(r14);
    }

    public static EnumEntries<Level> getEntries() {
        return f21019b;
    }

    public static Level valueOf(String r5) {
        return (Level) Enum.valueOf(Level.class, r5);
    }

    public static Level[] values() {
        return (Level[]) f21018a.clone();
    }
}
