package com.byted.mgl.merge.service.api.rtc;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H&J\"\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H&J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u001a\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u0010 \u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\u001a\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\u001a\u0010\"\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u001fH&J\u001a\u0010$\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0007H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0007H&¨\u0006("}, d2 = {"Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEventHandler;", "", "onAudioVolumeIndication", "", a.KEY_UID, "", "volume", "", "speakerNumber", "onConnectionInterrupted", "onConnectionLost", "onError", "err", "onExtraEvent", "param", "Lorg/json/JSONObject;", "onFirstLocalAudioFrame", "elapsed", "onFirstRemoteAudioFrame", "onJoinChannelSuccess", "onLeaveChannel", "onLogReport", "log_type", "log_content", "onNetworkQuality", "txQuality", "rxQuality", "onRejoinChannelSuccess", "onStreamPublishSucceed", "onUserEnableAudio", "enabled", "", "onUserEnableLocalAudio", "onUserJoined", "onUserMuteAudio", "muted", "onUserOffline", "reason", "onWarning", IHostStyleUIDepend.TOAST_TYPE_WARN, "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface IMglRtcEventHandler {
    void onAudioVolumeIndication(String r1, int r10, int r11);

    void onConnectionInterrupted();

    void onConnectionLost();

    void onError(int r1);

    void onExtraEvent(JSONObject r1);

    void onFirstLocalAudioFrame(int r1);

    void onFirstRemoteAudioFrame(String r1, int r10);

    void onJoinChannelSuccess(String r1, int r10);

    void onLeaveChannel();

    void onLogReport(String r1, String r10);

    void onNetworkQuality(String r1, int r10, int r11);

    void onRejoinChannelSuccess(String r1, int r10);

    void onStreamPublishSucceed();

    void onUserEnableAudio(String r1, boolean r10);

    void onUserEnableLocalAudio(String r1, boolean r10);

    void onUserJoined(String r1, int r10);

    void onUserMuteAudio(String r1, boolean r10);

    void onUserOffline(String r1, int r10);

    void onWarning(int r1);
}
