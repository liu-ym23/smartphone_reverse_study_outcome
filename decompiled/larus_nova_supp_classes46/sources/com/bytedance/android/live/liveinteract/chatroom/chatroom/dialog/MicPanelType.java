package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/MicPanelType;", "", "UNKNOWN", "VIDEO_COMMON_WINDOW_LAYOUT", "AUDIO_COMMON_WINDOW_LAYOUT", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MicPanelType extends Enum<MicPanelType> {
    public static final MicPanelType AUDIO_COMMON_WINDOW_LAYOUT = null;
    public static final MicPanelType UNKNOWN = null;
    public static final MicPanelType VIDEO_COMMON_WINDOW_LAYOUT = null;
    public static final /* synthetic */ MicPanelType[] a = null;

    static {
        MicPanelType r1 = new MicPanelType("UNKNOWN", 0);
        UNKNOWN = r1;
        MicPanelType r2 = new MicPanelType("VIDEO_COMMON_WINDOW_LAYOUT", 1);
        VIDEO_COMMON_WINDOW_LAYOUT = r2;
        MicPanelType r3 = new MicPanelType("AUDIO_COMMON_WINDOW_LAYOUT", 2);
        AUDIO_COMMON_WINDOW_LAYOUT = r3;
        a = new MicPanelType[]{r1, r2, r3};
    }

    public static MicPanelType valueOf(String r1) {
        return (MicPanelType) r27.a.a(MicPanelType.class, r1);
    }

    public static MicPanelType[] values() {
        return (MicPanelType[]) a.clone();
    }

    public MicPanelType(String r1, int r2) {
        super(r1, r2);
    }
}
