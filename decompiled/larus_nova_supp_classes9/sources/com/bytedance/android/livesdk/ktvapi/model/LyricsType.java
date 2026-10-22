package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/LyricsType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "UNKNOWN", "LRC", "KRC", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LyricsType extends Enum<LyricsType> {
    public static final LyricsType KRC = null;
    public static final LyricsType LRC = null;
    public static final LyricsType UNKNOWN = null;
    public static final /* synthetic */ LyricsType[] a = null;
    private final int value;

    static {
        LyricsType r2 = new LyricsType("UNKNOWN", 0, 0);
        UNKNOWN = r2;
        LyricsType r3 = new LyricsType("LRC", 1, 2);
        LRC = r3;
        LyricsType r4 = new LyricsType("KRC", 2, 3);
        KRC = r4;
        a = new LyricsType[]{r2, r3, r4};
    }

    public static LyricsType valueOf(String r1) {
        return (LyricsType) a.a(LyricsType.class, r1);
    }

    public static LyricsType[] values() {
        return (LyricsType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LyricsType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
