package com.bytedance.android.live.anchormodelink.model;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/model/DynamicCenterUpdateType;", "", "dynamic_none", "sendSEI", "registerSEI", "videoLinkmicAction", "liveLinkCall", "common_set_data", "linkmicBeautyPanel", NewBroadcastMonitor.STAGE.EFFECT, "nativeCallChannel", "inviteMore", "check_media_permission", "send_private_invite", "switchRoom", "updatePublicScreenAvoidOffset", "fullScreenDoubleTap", "updateGlobalTracker", "closeVideoChorus", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicCenterUpdateType extends Enum<DynamicCenterUpdateType> {
    public static final /* synthetic */ DynamicCenterUpdateType[] a = null;
    public static final DynamicCenterUpdateType check_media_permission = null;
    public static final DynamicCenterUpdateType closeVideoChorus = null;
    public static final DynamicCenterUpdateType common_set_data = null;
    public static final DynamicCenterUpdateType dynamic_none = null;
    public static final DynamicCenterUpdateType effect = null;
    public static final DynamicCenterUpdateType fullScreenDoubleTap = null;
    public static final DynamicCenterUpdateType inviteMore = null;
    public static final DynamicCenterUpdateType linkmicBeautyPanel = null;
    public static final DynamicCenterUpdateType liveLinkCall = null;
    public static final DynamicCenterUpdateType nativeCallChannel = null;
    public static final DynamicCenterUpdateType registerSEI = null;
    public static final DynamicCenterUpdateType sendSEI = null;
    public static final DynamicCenterUpdateType send_private_invite = null;
    public static final DynamicCenterUpdateType switchRoom = null;
    public static final DynamicCenterUpdateType updateGlobalTracker = null;
    public static final DynamicCenterUpdateType updatePublicScreenAvoidOffset = null;
    public static final DynamicCenterUpdateType videoLinkmicAction = null;

    static {
        DynamicCenterUpdateType r1 = new DynamicCenterUpdateType("dynamic_none", 0);
        dynamic_none = r1;
        DynamicCenterUpdateType r2 = new DynamicCenterUpdateType("sendSEI", 1);
        sendSEI = r2;
        DynamicCenterUpdateType r3 = new DynamicCenterUpdateType("registerSEI", 2);
        registerSEI = r3;
        DynamicCenterUpdateType r4 = new DynamicCenterUpdateType("videoLinkmicAction", 3);
        videoLinkmicAction = r4;
        DynamicCenterUpdateType r5 = new DynamicCenterUpdateType("liveLinkCall", 4);
        liveLinkCall = r5;
        DynamicCenterUpdateType r6 = new DynamicCenterUpdateType("common_set_data", 5);
        common_set_data = r6;
        DynamicCenterUpdateType r7 = new DynamicCenterUpdateType("linkmicBeautyPanel", 6);
        linkmicBeautyPanel = r7;
        DynamicCenterUpdateType r8 = new DynamicCenterUpdateType(NewBroadcastMonitor.STAGE.EFFECT, 7);
        effect = r8;
        DynamicCenterUpdateType r9 = new DynamicCenterUpdateType("nativeCallChannel", 8);
        nativeCallChannel = r9;
        DynamicCenterUpdateType r11 = new DynamicCenterUpdateType("inviteMore", 9);
        inviteMore = r11;
        DynamicCenterUpdateType r12 = new DynamicCenterUpdateType("check_media_permission", 10);
        check_media_permission = r12;
        DynamicCenterUpdateType r13 = new DynamicCenterUpdateType("send_private_invite", 11);
        send_private_invite = r13;
        DynamicCenterUpdateType r14 = new DynamicCenterUpdateType("switchRoom", 12);
        switchRoom = r14;
        DynamicCenterUpdateType r15 = new DynamicCenterUpdateType("updatePublicScreenAvoidOffset", 13);
        updatePublicScreenAvoidOffset = r15;
        DynamicCenterUpdateType r16 = new DynamicCenterUpdateType("fullScreenDoubleTap", 14);
        fullScreenDoubleTap = r16;
        DynamicCenterUpdateType r17 = new DynamicCenterUpdateType("updateGlobalTracker", 15);
        updateGlobalTracker = r17;
        DynamicCenterUpdateType r18 = new DynamicCenterUpdateType("closeVideoChorus", 16);
        closeVideoChorus = r18;
        a = new DynamicCenterUpdateType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18};
    }

    public static DynamicCenterUpdateType valueOf(String r1) {
        return (DynamicCenterUpdateType) a.a(DynamicCenterUpdateType.class, r1);
    }

    public static DynamicCenterUpdateType[] values() {
        return (DynamicCenterUpdateType[]) a.clone();
    }

    public DynamicCenterUpdateType(String r1, int r2) {
        super(r1, r2);
    }
}
