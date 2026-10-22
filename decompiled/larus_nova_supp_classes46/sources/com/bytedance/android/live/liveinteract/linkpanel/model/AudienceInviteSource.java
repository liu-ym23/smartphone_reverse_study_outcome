package com.bytedance.android.live.liveinteract.linkpanel.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/model/AudienceInviteSource;", "", "", "value", "I", "getValue", "()I", "NONE", "ORIGIN", "GAME_PANNEL", "PUBLIC_AREA_COMMENT", "USER_SEARCH", "REALTIME_CHORUS", "JoinRealTimeChorus", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AudienceInviteSource extends Enum<AudienceInviteSource> {
    public static final AudienceInviteSource GAME_PANNEL = null;
    public static final AudienceInviteSource JoinRealTimeChorus = null;
    public static final AudienceInviteSource NONE = null;
    public static final AudienceInviteSource ORIGIN = null;
    public static final AudienceInviteSource PUBLIC_AREA_COMMENT = null;
    public static final AudienceInviteSource REALTIME_CHORUS = null;
    public static final AudienceInviteSource USER_SEARCH = null;
    public static final /* synthetic */ AudienceInviteSource[] a = null;
    private final int value;

    static {
        AudienceInviteSource r1 = new AudienceInviteSource("NONE", 0, 0);
        NONE = r1;
        AudienceInviteSource r2 = new AudienceInviteSource("ORIGIN", 1, 1);
        ORIGIN = r2;
        AudienceInviteSource r3 = new AudienceInviteSource("GAME_PANNEL", 2, 2);
        GAME_PANNEL = r3;
        AudienceInviteSource r4 = new AudienceInviteSource("PUBLIC_AREA_COMMENT", 3, 3);
        PUBLIC_AREA_COMMENT = r4;
        AudienceInviteSource r5 = new AudienceInviteSource("USER_SEARCH", 4, 4);
        USER_SEARCH = r5;
        AudienceInviteSource r6 = new AudienceInviteSource("REALTIME_CHORUS", 5, 5);
        REALTIME_CHORUS = r6;
        AudienceInviteSource r7 = new AudienceInviteSource("JoinRealTimeChorus", 6, 6);
        JoinRealTimeChorus = r7;
        a = new AudienceInviteSource[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static AudienceInviteSource valueOf(String r1) {
        return (AudienceInviteSource) r27.a.a(AudienceInviteSource.class, r1);
    }

    public static AudienceInviteSource[] values() {
        return (AudienceInviteSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AudienceInviteSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
