package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/c;", "", "", "videoPublish", "I", "c", "()I", "setVideoPublish", "(I)V", "audioPublish", "a", "setAudioPublish", "videoCapture", "getVideoCapture", "setVideoCapture", "audioCapture", "getAudioCapture", "setAudioCapture", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "rtcUserId", "b", "setRtcUserId", "streamType", "getStreamType", "setStreamType", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("AudioCapture")
    private int audioCapture;

    @SerializedName("AudioPublish")
    private int audioPublish;

    @SerializedName("RoomId")
    private String roomId;

    @SerializedName("UserId")
    private String rtcUserId;

    @SerializedName("StreamType")
    private int streamType;

    @SerializedName("VideoCapture")
    private int videoCapture;

    @SerializedName("VideoPublish")
    private int videoPublish;

    public c() {
    }

    public final String toString() {
        return "StatsInfos(videoPublish=" + this.videoPublish + ", audioPublish=" + this.audioPublish + ", videoCapture=" + this.videoCapture + ", audioCapture=" + this.audioCapture + ", roomId=" + this.roomId + ", rtcUserId=" + this.rtcUserId + ", streamType=" + this.streamType + ')';
    }

    public final int a() {
        return this.audioPublish;
    }

    public final String b() {
        return this.rtcUserId;
    }

    public final int c() {
        return this.videoPublish;
    }
}
