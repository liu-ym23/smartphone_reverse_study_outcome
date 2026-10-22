package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkmicSysKickOutSource;", "", "", "source", "I", "getSource", "()I", "LinkmicKickOutSource_Normal", "LinkmicKickOutSource_ByAudit", "LinkmicKickOutSource_NotInRtc", "LinkmicKickOutSource_NotInLinker", "LinkmicKickOutSource_UserOutOfPing", "LinkmicKickOutSource_CheckAudienceFail", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicSysKickOutSource extends Enum<LinkmicSysKickOutSource> {
    public static final LinkmicSysKickOutSource LinkmicKickOutSource_ByAudit = null;
    public static final LinkmicSysKickOutSource LinkmicKickOutSource_CheckAudienceFail = null;
    public static final LinkmicSysKickOutSource LinkmicKickOutSource_Normal = null;
    public static final LinkmicSysKickOutSource LinkmicKickOutSource_NotInLinker = null;
    public static final LinkmicSysKickOutSource LinkmicKickOutSource_NotInRtc = null;
    public static final LinkmicSysKickOutSource LinkmicKickOutSource_UserOutOfPing = null;
    public static final /* synthetic */ LinkmicSysKickOutSource[] a = null;
    private final int source;

    static {
        LinkmicSysKickOutSource r1 = new LinkmicSysKickOutSource("LinkmicKickOutSource_Normal", 0, 0);
        LinkmicKickOutSource_Normal = r1;
        LinkmicSysKickOutSource r2 = new LinkmicSysKickOutSource("LinkmicKickOutSource_ByAudit", 1, 1);
        LinkmicKickOutSource_ByAudit = r2;
        LinkmicSysKickOutSource r3 = new LinkmicSysKickOutSource("LinkmicKickOutSource_NotInRtc", 2, 2);
        LinkmicKickOutSource_NotInRtc = r3;
        LinkmicSysKickOutSource r4 = new LinkmicSysKickOutSource("LinkmicKickOutSource_NotInLinker", 3, 3);
        LinkmicKickOutSource_NotInLinker = r4;
        LinkmicSysKickOutSource r5 = new LinkmicSysKickOutSource("LinkmicKickOutSource_UserOutOfPing", 4, 4);
        LinkmicKickOutSource_UserOutOfPing = r5;
        LinkmicSysKickOutSource r6 = new LinkmicSysKickOutSource("LinkmicKickOutSource_CheckAudienceFail", 5, 5);
        LinkmicKickOutSource_CheckAudienceFail = r6;
        a = new LinkmicSysKickOutSource[]{r1, r2, r3, r4, r5, r6};
    }

    public static LinkmicSysKickOutSource valueOf(String r1) {
        return (LinkmicSysKickOutSource) r27.a.a(LinkmicSysKickOutSource.class, r1);
    }

    public static LinkmicSysKickOutSource[] values() {
        return (LinkmicSysKickOutSource[]) a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    public LinkmicSysKickOutSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.source = r3;
    }
}
