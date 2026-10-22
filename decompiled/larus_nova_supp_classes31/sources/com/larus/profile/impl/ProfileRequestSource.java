package com.larus.profile.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/profile/impl/ProfileRequestSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MINE_INIT", "OTHERS_INIT", "RETRY", "REFRESH", "LOAD_MORE", "BLOCK_USER_UPDATE", "LAZY_LOAD", "HOT_LAUNCH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ProfileRequestSource extends Enum<ProfileRequestSource> {
    public static final ProfileRequestSource BLOCK_USER_UPDATE = null;
    public static final ProfileRequestSource HOT_LAUNCH = null;
    public static final ProfileRequestSource LAZY_LOAD = null;
    public static final ProfileRequestSource LOAD_MORE = null;
    public static final ProfileRequestSource MINE_INIT = null;
    public static final ProfileRequestSource OTHERS_INIT = null;
    public static final ProfileRequestSource REFRESH = null;
    public static final ProfileRequestSource RETRY = null;
    public static final /* synthetic */ ProfileRequestSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ProfileRequestSource> getEntries() {
        return b;
    }

    static {
        ProfileRequestSource r0 = new ProfileRequestSource("MINE_INIT", 0, "mine_init");
        MINE_INIT = r0;
        ProfileRequestSource r1 = new ProfileRequestSource("OTHERS_INIT", 1, "others_init");
        OTHERS_INIT = r1;
        ProfileRequestSource r2 = new ProfileRequestSource("RETRY", 2, "retry");
        RETRY = r2;
        ProfileRequestSource r4 = new ProfileRequestSource("REFRESH", 3, "refresh");
        REFRESH = r4;
        ProfileRequestSource r6 = new ProfileRequestSource("LOAD_MORE", 4, "load_more");
        LOAD_MORE = r6;
        ProfileRequestSource r8 = new ProfileRequestSource("BLOCK_USER_UPDATE", 5, "block_user_update");
        BLOCK_USER_UPDATE = r8;
        ProfileRequestSource r10 = new ProfileRequestSource("LAZY_LOAD", 6, "lazy_load");
        LAZY_LOAD = r10;
        ProfileRequestSource r12 = new ProfileRequestSource("HOT_LAUNCH", 7, "hot_launch");
        HOT_LAUNCH = r12;
        ProfileRequestSource[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static ProfileRequestSource[] values() {
        return (ProfileRequestSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ProfileRequestSource valueOf(String r1) {
        return (ProfileRequestSource) r27.a.a(ProfileRequestSource.class, r1);
    }

    public ProfileRequestSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
