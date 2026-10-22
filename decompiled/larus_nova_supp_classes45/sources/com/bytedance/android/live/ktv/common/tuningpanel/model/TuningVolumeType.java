package com.bytedance.android.live.ktv.common.tuningpanel.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/model/TuningVolumeType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CHORUS_SINGER_VOLUME", "VOCAL_VOLUME", "ACCOMPANIMENT_VOLUME", "EAR_BACK_VOLUME", "TONE_VOLUME", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TuningVolumeType extends Enum<TuningVolumeType> {
    public static final TuningVolumeType ACCOMPANIMENT_VOLUME = null;
    public static final TuningVolumeType CHORUS_SINGER_VOLUME = null;
    public static final TuningVolumeType EAR_BACK_VOLUME = null;
    public static final TuningVolumeType TONE_VOLUME = null;
    public static final TuningVolumeType VOCAL_VOLUME = null;
    public static final /* synthetic */ TuningVolumeType[] a = null;
    private final String value;

    static {
        TuningVolumeType r1 = new TuningVolumeType("CHORUS_SINGER_VOLUME", 0, "other_singer_volume");
        CHORUS_SINGER_VOLUME = r1;
        TuningVolumeType r2 = new TuningVolumeType("VOCAL_VOLUME", 1, "singer_volume");
        VOCAL_VOLUME = r2;
        TuningVolumeType r3 = new TuningVolumeType("ACCOMPANIMENT_VOLUME", 2, "song_volume");
        ACCOMPANIMENT_VOLUME = r3;
        TuningVolumeType r4 = new TuningVolumeType("EAR_BACK_VOLUME", 3, "earphone_volume");
        EAR_BACK_VOLUME = r4;
        TuningVolumeType r5 = new TuningVolumeType("TONE_VOLUME", 4, "key");
        TONE_VOLUME = r5;
        a = new TuningVolumeType[]{r1, r2, r3, r4, r5};
    }

    public static TuningVolumeType valueOf(String r1) {
        return (TuningVolumeType) a.a(TuningVolumeType.class, r1);
    }

    public static TuningVolumeType[] values() {
        return (TuningVolumeType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public TuningVolumeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
