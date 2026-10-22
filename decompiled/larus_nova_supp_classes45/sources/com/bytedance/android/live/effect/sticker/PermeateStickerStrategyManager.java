package com.bytedance.android.live.effect.sticker;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PermeateStickerStrategyManager {

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/PermeateStickerStrategyManager$Companion$PermeateResult;", "", "Success", "FetchStickerInfoFail", "HasOpenStickerPanel", "HasStartLive", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum PermeateResult extends Enum<PermeateResult> {
            public static final PermeateResult FetchStickerInfoFail = null;
            public static final PermeateResult HasOpenStickerPanel = null;
            public static final PermeateResult HasStartLive = null;
            public static final PermeateResult Success = null;
            public static final /* synthetic */ PermeateResult[] a = null;

            static {
                PermeateResult r1 = new PermeateResult("Success", 0);
                Success = r1;
                PermeateResult r2 = new PermeateResult("FetchStickerInfoFail", 1);
                FetchStickerInfoFail = r2;
                PermeateResult r3 = new PermeateResult("HasOpenStickerPanel", 2);
                HasOpenStickerPanel = r3;
                PermeateResult r4 = new PermeateResult("HasStartLive", 3);
                HasStartLive = r4;
                a = new PermeateResult[]{r1, r2, r3, r4};
            }

            public static PermeateResult valueOf(String r1) {
                return (PermeateResult) r27.a.a(PermeateResult.class, r1);
            }

            public static PermeateResult[] values() {
                return (PermeateResult[]) a.clone();
            }

            public PermeateResult(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    static {
    }
}
