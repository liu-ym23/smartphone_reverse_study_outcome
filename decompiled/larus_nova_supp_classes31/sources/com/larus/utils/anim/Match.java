package com.larus.utils.anim;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/utils/anim/Match;", "", "<init>", "(Ljava/lang/String;I)V", "X", "Y", "XY", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum Match extends Enum<Match> {
    public static final Match X = null;
    public static final Match XY = null;
    public static final Match Y = null;
    public static final /* synthetic */ Match[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Match> getEntries() {
        return b;
    }

    static {
        Match r0 = new Match("X", 0);
        X = r0;
        Match r1 = new Match("Y", 1);
        Y = r1;
        Match r3 = new Match("XY", 2);
        XY = r3;
        Match[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Match[] values() {
        return (Match[]) a.clone();
    }

    public static Match valueOf(String r1) {
        return (Match) a.a(Match.class, r1);
    }

    public Match(String r1, int r2) {
        super(r1, r2);
    }
}
