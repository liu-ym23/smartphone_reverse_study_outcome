package com.obric.flow.cardlistpage.mvi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/flow/cardlistpage/mvi/MviLogLevel;", "", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum MviLogLevel extends Enum<MviLogLevel> {
    public static final MviLogLevel DEBUG = null;
    public static final MviLogLevel ERROR = null;
    public static final MviLogLevel INFO = null;
    public static final MviLogLevel VERBOSE = null;
    public static final MviLogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MviLogLevel[] f11527a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f11528b = null;

    static {
        MviLogLevel r5 = new MviLogLevel("VERBOSE", 0);
        VERBOSE = r5;
        MviLogLevel r10 = new MviLogLevel("DEBUG", 1);
        DEBUG = r10;
        MviLogLevel r11 = new MviLogLevel("INFO", 2);
        INFO = r11;
        MviLogLevel r12 = new MviLogLevel("WARN", 3);
        WARN = r12;
        MviLogLevel r13 = new MviLogLevel("ERROR", 4);
        ERROR = r13;
        MviLogLevel[] r14 = {r5, r10, r11, r12, r13};
        f11527a = r14;
        f11528b = EnumEntriesKt.enumEntries(r14);
    }

    public static EnumEntries<MviLogLevel> getEntries() {
        return f11528b;
    }

    public static MviLogLevel valueOf(String r5) {
        return (MviLogLevel) Enum.valueOf(MviLogLevel.class, r5);
    }

    public static MviLogLevel[] values() {
        return (MviLogLevel[]) f11527a.clone();
    }
}
