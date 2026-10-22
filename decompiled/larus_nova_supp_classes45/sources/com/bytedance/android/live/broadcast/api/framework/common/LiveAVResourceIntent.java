package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveAVResourceIntent;", "", "", "value", "I", "getValue", "()I", "StartCapture", "StopCapture", "SetAudioMute", "ResumeAudioMute", "CloseAllCapture", "SwitchAVPushSource", "StartPush", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAVResourceIntent extends Enum<LiveAVResourceIntent> {
    public static final LiveAVResourceIntent CloseAllCapture = null;
    public static final LiveAVResourceIntent ResumeAudioMute = null;
    public static final LiveAVResourceIntent SetAudioMute = null;
    public static final LiveAVResourceIntent StartCapture = null;
    public static final LiveAVResourceIntent StartPush = null;
    public static final LiveAVResourceIntent StopCapture = null;
    public static final LiveAVResourceIntent SwitchAVPushSource = null;
    public static final /* synthetic */ LiveAVResourceIntent[] a = null;
    private final int value;

    static {
        LiveAVResourceIntent r1 = new LiveAVResourceIntent("StartCapture", 0, 0);
        StartCapture = r1;
        LiveAVResourceIntent r2 = new LiveAVResourceIntent("StopCapture", 1, 1);
        StopCapture = r2;
        LiveAVResourceIntent r3 = new LiveAVResourceIntent("SetAudioMute", 2, 2);
        SetAudioMute = r3;
        LiveAVResourceIntent r4 = new LiveAVResourceIntent("ResumeAudioMute", 3, 3);
        ResumeAudioMute = r4;
        LiveAVResourceIntent r5 = new LiveAVResourceIntent("CloseAllCapture", 4, 4);
        CloseAllCapture = r5;
        LiveAVResourceIntent r6 = new LiveAVResourceIntent("SwitchAVPushSource", 5, 5);
        SwitchAVPushSource = r6;
        LiveAVResourceIntent r7 = new LiveAVResourceIntent("StartPush", 6, 6);
        StartPush = r7;
        a = new LiveAVResourceIntent[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static LiveAVResourceIntent valueOf(String r1) {
        return (LiveAVResourceIntent) r27.a.a(LiveAVResourceIntent.class, r1);
    }

    public static LiveAVResourceIntent[] values() {
        return (LiveAVResourceIntent[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveAVResourceIntent(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
