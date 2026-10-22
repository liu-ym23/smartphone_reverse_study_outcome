package com.larus.suggest.impl.wcb.request;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/suggest/impl/wcb/request/WcbRequestTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "FOREGROUND", "MODE_SWITCH", "REGENERATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum WcbRequestTrigger extends Enum<WcbRequestTrigger> {
    public static final WcbRequestTrigger FOREGROUND = null;
    public static final WcbRequestTrigger INITIAL = null;
    public static final WcbRequestTrigger MODE_SWITCH = null;
    public static final WcbRequestTrigger REGENERATE = null;
    public static final /* synthetic */ WcbRequestTrigger[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WcbRequestTrigger> getEntries() {
        return b;
    }

    static {
        WcbRequestTrigger r0 = new WcbRequestTrigger("INITIAL", 0);
        INITIAL = r0;
        WcbRequestTrigger r1 = new WcbRequestTrigger("FOREGROUND", 1);
        FOREGROUND = r1;
        WcbRequestTrigger r3 = new WcbRequestTrigger("MODE_SWITCH", 2);
        MODE_SWITCH = r3;
        WcbRequestTrigger r5 = new WcbRequestTrigger("REGENERATE", 3);
        REGENERATE = r5;
        WcbRequestTrigger[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static WcbRequestTrigger[] values() {
        return (WcbRequestTrigger[]) a.clone();
    }

    public static WcbRequestTrigger valueOf(String r1) {
        return (WcbRequestTrigger) r27.a.a(WcbRequestTrigger.class, r1);
    }

    public WcbRequestTrigger(String r1, int r2) {
        super(r1, r2);
    }
}
