package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b!\u0010\"R.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/hk1;", "", "", "", "extraToServer", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setExtraToServer", "(Ljava/util/Map;)V", "", "enableEglContext", "Z", "getEnableEglContext", "()Z", "setEnableEglContext", "(Z)V", "", "videoFrameFormat", "I", "c", "()I", "setVideoFrameFormat", "(I)V", "enableHalveVideoFrame", "a", "setEnableHalveVideoFrame", "videoSimulcast", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setVideoSimulcast", "(Ljava/lang/String;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hk1 {
    public static final hk1 a = null;

    @SerializedName("enable_eglcontext")
    private boolean enableEglContext;

    @SerializedName("enable_halve_video_frame")
    private boolean enableHalveVideoFrame;

    @SerializedName("extra_to_server")
    private Map<String, String> extraToServer;

    @SerializedName("video_frame_format")
    private int videoFrameFormat;

    @SerializedName("video_simulcast")
    private String videoSimulcast;

    public static final class a {
    }

    static {
        a = new hk1();
    }

    public hk1() {
        this.extraToServer = MapsKt.emptyMap();
        this.videoFrameFormat = 1;
        this.videoSimulcast = "";
    }

    public final boolean a() {
        return this.enableHalveVideoFrame;
    }

    public final Map<String, String> b() {
        return this.extraToServer;
    }

    public final int c() {
        return this.videoFrameFormat;
    }

    public final String d() {
        return this.videoSimulcast;
    }
}
