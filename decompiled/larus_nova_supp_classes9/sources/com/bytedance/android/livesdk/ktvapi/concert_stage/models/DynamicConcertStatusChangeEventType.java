package com.bytedance.android.livesdk.ktvapi.concert_stage.models;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/models/DynamicConcertStatusChangeEventType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "onCheckPermissionFinished", "onAudioDeviceLoopDelayUpdate", "onNetworkDetectionResult", "onNetworkQuality", "onFirstRemoteVideoFrameDecode", "onNtpTimeSynchronizationCompleted", "onUserPublishStreamAudio", "onRtcAdvanceLinkSuccess", "onRtcLinkSuccessPre", "onRtcLinkSuccess", "onRtcLinkFail", "onRtcInitSuccess", "onRtcInitFail", "onLiveClientInitSuccess", "onLiveClientInitFail", "onRtcLeaveSuccess", "onHeadSetChange", "onExternalSoundCard", "onScreenOrientationChange", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicConcertStatusChangeEventType extends Enum<DynamicConcertStatusChangeEventType> {
    public static final /* synthetic */ DynamicConcertStatusChangeEventType[] a = null;
    public static final DynamicConcertStatusChangeEventType onAudioDeviceLoopDelayUpdate = null;
    public static final DynamicConcertStatusChangeEventType onCheckPermissionFinished = null;
    public static final DynamicConcertStatusChangeEventType onExternalSoundCard = null;
    public static final DynamicConcertStatusChangeEventType onFirstRemoteVideoFrameDecode = null;
    public static final DynamicConcertStatusChangeEventType onHeadSetChange = null;
    public static final DynamicConcertStatusChangeEventType onLiveClientInitFail = null;
    public static final DynamicConcertStatusChangeEventType onLiveClientInitSuccess = null;
    public static final DynamicConcertStatusChangeEventType onNetworkDetectionResult = null;
    public static final DynamicConcertStatusChangeEventType onNetworkQuality = null;
    public static final DynamicConcertStatusChangeEventType onNtpTimeSynchronizationCompleted = null;
    public static final DynamicConcertStatusChangeEventType onRtcAdvanceLinkSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcInitFail = null;
    public static final DynamicConcertStatusChangeEventType onRtcInitSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcLeaveSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcLinkFail = null;
    public static final DynamicConcertStatusChangeEventType onRtcLinkSuccess = null;
    public static final DynamicConcertStatusChangeEventType onRtcLinkSuccessPre = null;
    public static final DynamicConcertStatusChangeEventType onScreenOrientationChange = null;
    public static final DynamicConcertStatusChangeEventType onUserPublishStreamAudio = null;
    private final String typeName;

    public static DynamicConcertStatusChangeEventType valueOf(String r1) {
        return (DynamicConcertStatusChangeEventType) a.a(DynamicConcertStatusChangeEventType.class, r1);
    }

    public static DynamicConcertStatusChangeEventType[] values() {
        return (DynamicConcertStatusChangeEventType[]) a.clone();
    }

    static {
        DynamicConcertStatusChangeEventType r1 = new DynamicConcertStatusChangeEventType("onCheckPermissionFinished", 0, "onCheckPermissionFinished");
        onCheckPermissionFinished = r1;
        DynamicConcertStatusChangeEventType r2 = new DynamicConcertStatusChangeEventType("onAudioDeviceLoopDelayUpdate", 1, "onAudioDeviceLoopDelayUpdate");
        onAudioDeviceLoopDelayUpdate = r2;
        DynamicConcertStatusChangeEventType r3 = new DynamicConcertStatusChangeEventType("onNetworkDetectionResult", 2, "onNetworkDetectionResult");
        onNetworkDetectionResult = r3;
        DynamicConcertStatusChangeEventType r4 = new DynamicConcertStatusChangeEventType("onNetworkQuality", 3, "onNetworkQuality");
        onNetworkQuality = r4;
        DynamicConcertStatusChangeEventType r5 = new DynamicConcertStatusChangeEventType("onFirstRemoteVideoFrameDecode", 4, "onFirstRemoteVideoFrameDecode");
        onFirstRemoteVideoFrameDecode = r5;
        DynamicConcertStatusChangeEventType r6 = new DynamicConcertStatusChangeEventType("onNtpTimeSynchronizationCompleted", 5, "onNtpTimeSynchronizationCompleted");
        onNtpTimeSynchronizationCompleted = r6;
        DynamicConcertStatusChangeEventType r7 = new DynamicConcertStatusChangeEventType("onUserPublishStreamAudio", 6, "onUserPublishStreamAudio");
        onUserPublishStreamAudio = r7;
        DynamicConcertStatusChangeEventType r8 = new DynamicConcertStatusChangeEventType("onRtcAdvanceLinkSuccess", 7, "onRtcAdvanceLinkSuccess");
        onRtcAdvanceLinkSuccess = r8;
        DynamicConcertStatusChangeEventType r9 = new DynamicConcertStatusChangeEventType("onRtcLinkSuccessPre", 8, "onRtcLinkSuccessPre");
        onRtcLinkSuccessPre = r9;
        DynamicConcertStatusChangeEventType r10 = new DynamicConcertStatusChangeEventType("onRtcLinkSuccess", 9, "onRtcLinkSuccess");
        onRtcLinkSuccess = r10;
        DynamicConcertStatusChangeEventType r11 = new DynamicConcertStatusChangeEventType("onRtcLinkFail", 10, "onRtcLinkFail");
        onRtcLinkFail = r11;
        DynamicConcertStatusChangeEventType r13 = new DynamicConcertStatusChangeEventType("onRtcInitSuccess", 11, "onRtcInitSuccess");
        onRtcInitSuccess = r13;
        DynamicConcertStatusChangeEventType r14 = new DynamicConcertStatusChangeEventType("onRtcInitFail", 12, "onRtcInitFail");
        onRtcInitFail = r14;
        DynamicConcertStatusChangeEventType r15 = new DynamicConcertStatusChangeEventType("onLiveClientInitSuccess", 13, "onLiveClientInitSuccess");
        onLiveClientInitSuccess = r15;
        DynamicConcertStatusChangeEventType r16 = new DynamicConcertStatusChangeEventType("onLiveClientInitFail", 14, "onLiveClientInitFail");
        onLiveClientInitFail = r16;
        DynamicConcertStatusChangeEventType r17 = new DynamicConcertStatusChangeEventType("onRtcLeaveSuccess", 15, "onRtcLeaveSuccess");
        onRtcLeaveSuccess = r17;
        DynamicConcertStatusChangeEventType r18 = new DynamicConcertStatusChangeEventType("onHeadSetChange", 16, "onHeadSetChange");
        onHeadSetChange = r18;
        DynamicConcertStatusChangeEventType r19 = new DynamicConcertStatusChangeEventType("onExternalSoundCard", 17, "onExternalSoundCard");
        onExternalSoundCard = r19;
        DynamicConcertStatusChangeEventType r20 = new DynamicConcertStatusChangeEventType("onScreenOrientationChange", 18, "onScreenOrientationChange");
        onScreenOrientationChange = r20;
        a = new DynamicConcertStatusChangeEventType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public DynamicConcertStatusChangeEventType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
