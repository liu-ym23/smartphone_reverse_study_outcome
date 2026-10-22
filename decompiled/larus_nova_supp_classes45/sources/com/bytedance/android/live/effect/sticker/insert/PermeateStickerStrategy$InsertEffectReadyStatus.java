package com.bytedance.android.live.effect.sticker.insert;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/effect/sticker/insert/PermeateStickerStrategy$InsertEffectReadyStatus", "", "Lcom/bytedance/android/live/effect/sticker/insert/PermeateStickerStrategy$InsertEffectReadyStatus;", "SUCCESS", "FAIL", "WAITING", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PermeateStickerStrategy$InsertEffectReadyStatus extends Enum<PermeateStickerStrategy$InsertEffectReadyStatus> {
    public static final PermeateStickerStrategy$InsertEffectReadyStatus FAIL = null;
    public static final PermeateStickerStrategy$InsertEffectReadyStatus SUCCESS = null;
    public static final PermeateStickerStrategy$InsertEffectReadyStatus WAITING = null;
    public static final /* synthetic */ PermeateStickerStrategy$InsertEffectReadyStatus[] a = null;

    static {
        PermeateStickerStrategy$InsertEffectReadyStatus r1 = new PermeateStickerStrategy$InsertEffectReadyStatus("SUCCESS", 0);
        SUCCESS = r1;
        PermeateStickerStrategy$InsertEffectReadyStatus r2 = new PermeateStickerStrategy$InsertEffectReadyStatus("FAIL", 1);
        FAIL = r2;
        PermeateStickerStrategy$InsertEffectReadyStatus r3 = new PermeateStickerStrategy$InsertEffectReadyStatus("WAITING", 2);
        WAITING = r3;
        a = new PermeateStickerStrategy$InsertEffectReadyStatus[]{r1, r2, r3};
    }

    public static PermeateStickerStrategy$InsertEffectReadyStatus valueOf(String r1) {
        return (PermeateStickerStrategy$InsertEffectReadyStatus) a.a(PermeateStickerStrategy$InsertEffectReadyStatus.class, r1);
    }

    public static PermeateStickerStrategy$InsertEffectReadyStatus[] values() {
        return (PermeateStickerStrategy$InsertEffectReadyStatus[]) a.clone();
    }

    public PermeateStickerStrategy$InsertEffectReadyStatus(String r1, int r2) {
        super(r1, r2);
    }
}
