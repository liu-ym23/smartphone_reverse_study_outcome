package com.larus.suggest.impl.wcb.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/suggest/impl/wcb/model/WcbSurface;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_CONVERSATION", "NEW_CONVERSATION", "NOT_SUPPORT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum WcbSurface extends Enum<WcbSurface> {
    public static final WcbSurface MAIN_CONVERSATION = null;
    public static final WcbSurface NEW_CONVERSATION = null;
    public static final WcbSurface NOT_SUPPORT = null;
    public static final /* synthetic */ WcbSurface[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WcbSurface> getEntries() {
        return b;
    }

    static {
        WcbSurface r0 = new WcbSurface("MAIN_CONVERSATION", 0);
        MAIN_CONVERSATION = r0;
        WcbSurface r1 = new WcbSurface("NEW_CONVERSATION", 1);
        NEW_CONVERSATION = r1;
        WcbSurface r3 = new WcbSurface("NOT_SUPPORT", 2);
        NOT_SUPPORT = r3;
        WcbSurface[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static WcbSurface[] values() {
        return (WcbSurface[]) a.clone();
    }

    public static WcbSurface valueOf(String r1) {
        return (WcbSurface) a.a(WcbSurface.class, r1);
    }

    public WcbSurface(String r1, int r2) {
        super(r1, r2);
    }
}
