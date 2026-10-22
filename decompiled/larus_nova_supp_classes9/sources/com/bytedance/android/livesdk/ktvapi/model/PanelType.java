package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/PanelType;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "ORDER_SONG_PANEL", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType ORDER_SONG_PANEL = null;
    public static final PanelType UNKNOWN = null;
    public static final /* synthetic */ PanelType[] a = null;
    private final String value;

    static {
        PanelType r1 = new PanelType("UNKNOWN", 0, CardLockInfo.sUNKNOWN);
        UNKNOWN = r1;
        PanelType r2 = new PanelType("ORDER_SONG_PANEL", 1, "order_song_panel");
        ORDER_SONG_PANEL = r2;
        a = new PanelType[]{r1, r2};
    }

    public static PanelType valueOf(String r1) {
        return (PanelType) a.a(PanelType.class, r1);
    }

    public static PanelType[] values() {
        return (PanelType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public PanelType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
