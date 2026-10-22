package com.larus.ugc.feed.api.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/model/CommunityCreateLaunchModeKmp;", "", "<init>", "(Ljava/lang/String;I)V", "STANDALONE", "CHAT_MULTI_TAB", "SIDE_BAR", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CommunityCreateLaunchModeKmp extends Enum<CommunityCreateLaunchModeKmp> {
    public static final CommunityCreateLaunchModeKmp CHAT_MULTI_TAB = null;
    public static final CommunityCreateLaunchModeKmp SIDE_BAR = null;
    public static final CommunityCreateLaunchModeKmp STANDALONE = null;
    public static final /* synthetic */ CommunityCreateLaunchModeKmp[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommunityCreateLaunchModeKmp> getEntries() {
        return b;
    }

    static {
        CommunityCreateLaunchModeKmp r0 = new CommunityCreateLaunchModeKmp("STANDALONE", 0);
        STANDALONE = r0;
        CommunityCreateLaunchModeKmp r1 = new CommunityCreateLaunchModeKmp("CHAT_MULTI_TAB", 1);
        CHAT_MULTI_TAB = r1;
        CommunityCreateLaunchModeKmp r3 = new CommunityCreateLaunchModeKmp("SIDE_BAR", 2);
        SIDE_BAR = r3;
        CommunityCreateLaunchModeKmp[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CommunityCreateLaunchModeKmp[] values() {
        return (CommunityCreateLaunchModeKmp[]) a.clone();
    }

    public static CommunityCreateLaunchModeKmp valueOf(String r1) {
        return (CommunityCreateLaunchModeKmp) a.a(CommunityCreateLaunchModeKmp.class, r1);
    }

    public CommunityCreateLaunchModeKmp(String r1, int r2) {
        super(r1, r2);
    }
}
