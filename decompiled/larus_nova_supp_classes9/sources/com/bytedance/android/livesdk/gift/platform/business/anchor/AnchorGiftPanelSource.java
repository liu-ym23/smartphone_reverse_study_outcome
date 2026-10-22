package com.bytedance.android.livesdk.gift.platform.business.anchor;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/anchor/AnchorGiftPanelSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MoreFunction", "UserGiftTabIcon", "UserGiftPanel", "Undefined", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorGiftPanelSource extends Enum<AnchorGiftPanelSource> {
    public static final AnchorGiftPanelSource MoreFunction = null;
    public static final AnchorGiftPanelSource Undefined = null;
    public static final AnchorGiftPanelSource UserGiftPanel = null;
    public static final AnchorGiftPanelSource UserGiftTabIcon = null;
    public static final /* synthetic */ AnchorGiftPanelSource[] a = null;
    private final String value;

    static {
        AnchorGiftPanelSource r1 = new AnchorGiftPanelSource("MoreFunction", 0, "more_function");
        MoreFunction = r1;
        AnchorGiftPanelSource r2 = new AnchorGiftPanelSource("UserGiftTabIcon", 1, "gift_icon");
        UserGiftTabIcon = r2;
        AnchorGiftPanelSource r3 = new AnchorGiftPanelSource("UserGiftPanel", 2, "user_gift_tab");
        UserGiftPanel = r3;
        AnchorGiftPanelSource r4 = new AnchorGiftPanelSource("Undefined", 3, "undefined");
        Undefined = r4;
        a = new AnchorGiftPanelSource[]{r1, r2, r3, r4};
    }

    public static AnchorGiftPanelSource valueOf(String r1) {
        return (AnchorGiftPanelSource) r27.a.a(AnchorGiftPanelSource.class, r1);
    }

    public static AnchorGiftPanelSource[] values() {
        return (AnchorGiftPanelSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public AnchorGiftPanelSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
