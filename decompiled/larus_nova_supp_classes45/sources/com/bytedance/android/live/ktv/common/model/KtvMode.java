package com.bytedance.android.live.ktv.common.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/KtvMode;", "", "", "Mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "SOLO_KTV", "LIVE_KTV", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvMode extends Enum<KtvMode> {
    public static final KtvMode LIVE_KTV = null;
    public static final KtvMode SOLO_KTV = null;
    public static final /* synthetic */ KtvMode[] a = null;
    private final String Mode;

    static {
        KtvMode r1 = new KtvMode("SOLO_KTV", 0, "SoloKtv");
        SOLO_KTV = r1;
        KtvMode r2 = new KtvMode("LIVE_KTV", 1, "LiveKtv");
        LIVE_KTV = r2;
        a = new KtvMode[]{r1, r2};
    }

    public static KtvMode valueOf(String r1) {
        return (KtvMode) a.a(KtvMode.class, r1);
    }

    public static KtvMode[] values() {
        return (KtvMode[]) a.clone();
    }

    public final String getMode() {
        return this.Mode;
    }

    public KtvMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.Mode = r3;
    }
}
