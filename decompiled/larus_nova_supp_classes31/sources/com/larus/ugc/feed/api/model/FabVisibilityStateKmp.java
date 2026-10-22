package com.larus.ugc.feed.api.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/model/FabVisibilityStateKmp;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "HIDDEN_DOWNGRADE", "HIDDEN_LAUNCH_MODE", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum FabVisibilityStateKmp extends Enum<FabVisibilityStateKmp> {
    public static final FabVisibilityStateKmp HIDDEN_DOWNGRADE = null;
    public static final FabVisibilityStateKmp HIDDEN_LAUNCH_MODE = null;
    public static final FabVisibilityStateKmp VISIBLE = null;
    public static final /* synthetic */ FabVisibilityStateKmp[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FabVisibilityStateKmp> getEntries() {
        return b;
    }

    static {
        FabVisibilityStateKmp r0 = new FabVisibilityStateKmp("VISIBLE", 0);
        VISIBLE = r0;
        FabVisibilityStateKmp r1 = new FabVisibilityStateKmp("HIDDEN_DOWNGRADE", 1);
        HIDDEN_DOWNGRADE = r1;
        FabVisibilityStateKmp r3 = new FabVisibilityStateKmp("HIDDEN_LAUNCH_MODE", 2);
        HIDDEN_LAUNCH_MODE = r3;
        FabVisibilityStateKmp[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FabVisibilityStateKmp[] values() {
        return (FabVisibilityStateKmp[]) a.clone();
    }

    public static FabVisibilityStateKmp valueOf(String r1) {
        return (FabVisibilityStateKmp) a.a(FabVisibilityStateKmp.class, r1);
    }

    public FabVisibilityStateKmp(String r1, int r2) {
        super(r1, r2);
    }
}
