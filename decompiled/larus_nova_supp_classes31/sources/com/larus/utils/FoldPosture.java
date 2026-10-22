package com.larus.utils;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/utils/FoldPosture;", "", "<init>", "(Ljava/lang/String;I)V", "FOLDED", "HALF_OPENED", "FLAT", "UNKNOWN", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum FoldPosture extends Enum<FoldPosture> {
    public static final FoldPosture FLAT = null;
    public static final FoldPosture FOLDED = null;
    public static final FoldPosture HALF_OPENED = null;
    public static final FoldPosture UNKNOWN = null;
    public static final /* synthetic */ FoldPosture[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FoldPosture> getEntries() {
        return b;
    }

    static {
        FoldPosture r0 = new FoldPosture("FOLDED", 0);
        FOLDED = r0;
        FoldPosture r1 = new FoldPosture("HALF_OPENED", 1);
        HALF_OPENED = r1;
        FoldPosture r3 = new FoldPosture("FLAT", 2);
        FLAT = r3;
        FoldPosture r5 = new FoldPosture("UNKNOWN", 3);
        UNKNOWN = r5;
        FoldPosture[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static FoldPosture[] values() {
        return (FoldPosture[]) a.clone();
    }

    public static FoldPosture valueOf(String r1) {
        return (FoldPosture) r27.a.a(FoldPosture.class, r1);
    }

    public FoldPosture(String r1, int r2) {
        super(r1, r2);
    }
}
