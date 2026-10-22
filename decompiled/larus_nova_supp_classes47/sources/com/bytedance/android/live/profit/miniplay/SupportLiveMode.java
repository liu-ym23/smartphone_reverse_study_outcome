package com.bytedance.android.live.profit.miniplay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/miniplay/SupportLiveMode;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "VIDEO", "OBS", "MEDIA", "AUDIO", "SCREEN_RECORD", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SupportLiveMode extends Enum<SupportLiveMode> {
    public static final SupportLiveMode AUDIO = null;
    public static final SupportLiveMode MEDIA = null;
    public static final SupportLiveMode OBS = null;
    public static final SupportLiveMode SCREEN_RECORD = null;
    public static final SupportLiveMode UNKNOWN = null;
    public static final SupportLiveMode VIDEO = null;
    public static final /* synthetic */ SupportLiveMode[] a = null;
    private final int value;

    static {
        SupportLiveMode r1 = new SupportLiveMode("UNKNOWN", 0, -1);
        UNKNOWN = r1;
        SupportLiveMode r2 = new SupportLiveMode("VIDEO", 1, 0);
        VIDEO = r2;
        SupportLiveMode r3 = new SupportLiveMode("OBS", 2, 1);
        OBS = r3;
        SupportLiveMode r4 = new SupportLiveMode("MEDIA", 3, 2);
        MEDIA = r4;
        SupportLiveMode r5 = new SupportLiveMode("AUDIO", 4, 3);
        AUDIO = r5;
        SupportLiveMode r6 = new SupportLiveMode("SCREEN_RECORD", 5, 4);
        SCREEN_RECORD = r6;
        a = new SupportLiveMode[]{r1, r2, r3, r4, r5, r6};
    }

    public static SupportLiveMode valueOf(String r1) {
        return (SupportLiveMode) a.a(SupportLiveMode.class, r1);
    }

    public static SupportLiveMode[] values() {
        return (SupportLiveMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SupportLiveMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
