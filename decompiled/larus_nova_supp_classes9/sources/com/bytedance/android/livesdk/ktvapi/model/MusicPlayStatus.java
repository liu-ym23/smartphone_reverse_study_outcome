package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/MusicPlayStatus;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "UNKNOWN", "PAUSED", "PLAYING", "STOP", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicPlayStatus extends Enum<MusicPlayStatus> {
    public static final MusicPlayStatus PAUSED = null;
    public static final MusicPlayStatus PLAYING = null;
    public static final MusicPlayStatus STOP = null;
    public static final MusicPlayStatus UNKNOWN = null;
    public static final /* synthetic */ MusicPlayStatus[] a = null;
    private final int value;

    static {
        MusicPlayStatus r1 = new MusicPlayStatus("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        MusicPlayStatus r2 = new MusicPlayStatus("PAUSED", 1, 1);
        PAUSED = r2;
        MusicPlayStatus r3 = new MusicPlayStatus("PLAYING", 2, 2);
        PLAYING = r3;
        MusicPlayStatus r4 = new MusicPlayStatus("STOP", 3, 3);
        STOP = r4;
        a = new MusicPlayStatus[]{r1, r2, r3, r4};
    }

    public static MusicPlayStatus valueOf(String r1) {
        return (MusicPlayStatus) a.a(MusicPlayStatus.class, r1);
    }

    public static MusicPlayStatus[] values() {
        return (MusicPlayStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MusicPlayStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
