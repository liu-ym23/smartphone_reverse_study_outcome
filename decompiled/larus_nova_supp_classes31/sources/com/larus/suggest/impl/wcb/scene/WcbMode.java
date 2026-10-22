package com.larus.suggest.impl.wcb.scene;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/suggest/impl/wcb/scene/WcbMode;", "", "<init>", "(Ljava/lang/String;I)V", "QUICK_EXPERT", "OFFICE_TASK", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum WcbMode extends Enum<WcbMode> {
    public static final WcbMode OFFICE_TASK = null;
    public static final WcbMode QUICK_EXPERT = null;
    public static final /* synthetic */ WcbMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WcbMode> getEntries() {
        return b;
    }

    static {
        WcbMode r0 = new WcbMode("QUICK_EXPERT", 0);
        QUICK_EXPERT = r0;
        WcbMode r1 = new WcbMode("OFFICE_TASK", 1);
        OFFICE_TASK = r1;
        WcbMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static WcbMode[] values() {
        return (WcbMode[]) a.clone();
    }

    public static WcbMode valueOf(String r1) {
        return (WcbMode) a.a(WcbMode.class, r1);
    }

    public WcbMode(String r1, int r2) {
        super(r1, r2);
    }
}
