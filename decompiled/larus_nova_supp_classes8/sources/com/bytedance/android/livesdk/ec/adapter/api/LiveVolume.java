package com.bytedance.android.livesdk.ec.adapter.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ec/adapter/api/LiveVolume;", "", "MUTE", "UNMUTE", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveVolume extends Enum<LiveVolume> {
    public static final LiveVolume MUTE = null;
    public static final LiveVolume UNMUTE = null;
    public static final /* synthetic */ LiveVolume[] a = null;

    static {
        LiveVolume r1 = new LiveVolume("MUTE", 0);
        MUTE = r1;
        LiveVolume r2 = new LiveVolume("UNMUTE", 1);
        UNMUTE = r2;
        a = new LiveVolume[]{r1, r2};
    }

    public static LiveVolume valueOf(String r1) {
        return (LiveVolume) a.a(LiveVolume.class, r1);
    }

    public static LiveVolume[] values() {
        return (LiveVolume[]) a.clone();
    }

    public LiveVolume(String r1, int r2) {
        super(r1, r2);
    }
}
