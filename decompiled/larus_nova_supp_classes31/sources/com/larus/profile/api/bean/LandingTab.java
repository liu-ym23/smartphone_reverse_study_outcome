package com.larus.profile.api.bean;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/profile/api/bean/LandingTab;", "", "<init>", "(Ljava/lang/String;I)V", "PROFILE_BOT_LIST", "MY_COLLECT", "MY_LIKE", "PROFILE_CREATION_LIST_PUBLIC", "PROFILE_CREATION_LIST_PRIVATE", "PROFILE_CREATION_LIST_MIX", "PROFILE_CREATION_LIST", "PUBLIC_VOICE_LIST", "ALBUM", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum LandingTab extends Enum<LandingTab> {
    public static final LandingTab ALBUM = null;
    public static final LandingTab MY_COLLECT = null;
    public static final LandingTab MY_LIKE = null;
    public static final LandingTab PROFILE_BOT_LIST = null;
    public static final LandingTab PROFILE_CREATION_LIST = null;
    public static final LandingTab PROFILE_CREATION_LIST_MIX = null;
    public static final LandingTab PROFILE_CREATION_LIST_PRIVATE = null;
    public static final LandingTab PROFILE_CREATION_LIST_PUBLIC = null;
    public static final LandingTab PUBLIC_VOICE_LIST = null;
    public static final /* synthetic */ LandingTab[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LandingTab> getEntries() {
        return b;
    }

    static {
        LandingTab r0 = new LandingTab("PROFILE_BOT_LIST", 0);
        PROFILE_BOT_LIST = r0;
        LandingTab r1 = new LandingTab("MY_COLLECT", 1);
        MY_COLLECT = r1;
        LandingTab r3 = new LandingTab("MY_LIKE", 2);
        MY_LIKE = r3;
        LandingTab r5 = new LandingTab("PROFILE_CREATION_LIST_PUBLIC", 3);
        PROFILE_CREATION_LIST_PUBLIC = r5;
        LandingTab r7 = new LandingTab("PROFILE_CREATION_LIST_PRIVATE", 4);
        PROFILE_CREATION_LIST_PRIVATE = r7;
        LandingTab r9 = new LandingTab("PROFILE_CREATION_LIST_MIX", 5);
        PROFILE_CREATION_LIST_MIX = r9;
        LandingTab r11 = new LandingTab("PROFILE_CREATION_LIST", 6);
        PROFILE_CREATION_LIST = r11;
        LandingTab r13 = new LandingTab("PUBLIC_VOICE_LIST", 7);
        PUBLIC_VOICE_LIST = r13;
        LandingTab r15 = new LandingTab("ALBUM", 8);
        ALBUM = r15;
        LandingTab[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static LandingTab[] values() {
        return (LandingTab[]) a.clone();
    }

    public static LandingTab valueOf(String r1) {
        return (LandingTab) a.a(LandingTab.class, r1);
    }

    public LandingTab(String r1, int r2) {
        super(r1, r2);
    }
}
