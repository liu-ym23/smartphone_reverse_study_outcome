package com.bytedance.android.live.multilink.impl.control.setting;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/control/setting/FetchSettingType;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "Normal", "AnchorAttach", "AnchorAudioAttach", "AudienceAttach", "onReceiveTurnOnMessage", "Attach", "handleLinkInitResult", "syncRoomStatsWhenUpdate", "refreshAudienceSettings", "AnchorStatusStart", "observeWrdsUpdate", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FetchSettingType extends Enum<FetchSettingType> {
    public static final FetchSettingType AnchorAttach = null;
    public static final FetchSettingType AnchorAudioAttach = null;
    public static final FetchSettingType AnchorStatusStart = null;
    public static final FetchSettingType Attach = null;
    public static final FetchSettingType AudienceAttach = null;
    public static final FetchSettingType Normal = null;
    public static final /* synthetic */ FetchSettingType[] a = null;
    public static final FetchSettingType handleLinkInitResult = null;
    public static final FetchSettingType observeWrdsUpdate = null;
    public static final FetchSettingType onReceiveTurnOnMessage = null;
    public static final FetchSettingType refreshAudienceSettings = null;
    public static final FetchSettingType syncRoomStatsWhenUpdate = null;
    private final String source;

    public static FetchSettingType valueOf(String r1) {
        return (FetchSettingType) a.a(FetchSettingType.class, r1);
    }

    public static FetchSettingType[] values() {
        return (FetchSettingType[]) a.clone();
    }

    static {
        FetchSettingType r1 = new FetchSettingType("Normal", 0, "NormalFetch");
        Normal = r1;
        FetchSettingType r2 = new FetchSettingType("AnchorAttach", 1, "AnchorAttach");
        AnchorAttach = r2;
        FetchSettingType r3 = new FetchSettingType("AnchorAudioAttach", 2, "AnchorAudioAttach");
        AnchorAudioAttach = r3;
        FetchSettingType r4 = new FetchSettingType("AudienceAttach", 3, "AudienceAttach");
        AudienceAttach = r4;
        FetchSettingType r5 = new FetchSettingType("onReceiveTurnOnMessage", 4, "onReceiveTurnOnMessage");
        onReceiveTurnOnMessage = r5;
        FetchSettingType r6 = new FetchSettingType("Attach", 5, "Attach");
        Attach = r6;
        FetchSettingType r7 = new FetchSettingType("handleLinkInitResult", 6, "handleLinkInitResult");
        handleLinkInitResult = r7;
        FetchSettingType r8 = new FetchSettingType("syncRoomStatsWhenUpdate", 7, "syncRoomStatsWhenUpdate");
        syncRoomStatsWhenUpdate = r8;
        FetchSettingType r9 = new FetchSettingType("refreshAudienceSettings", 8, "refreshAudienceSettings");
        refreshAudienceSettings = r9;
        FetchSettingType r10 = new FetchSettingType("AnchorStatusStart", 9, "AnchorStatusStart");
        AnchorStatusStart = r10;
        FetchSettingType r11 = new FetchSettingType("observeWrdsUpdate", 10, "observeWrdsUpdate");
        observeWrdsUpdate = r11;
        a = new FetchSettingType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getSource() {
        return this.source;
    }

    public FetchSettingType(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }
}
