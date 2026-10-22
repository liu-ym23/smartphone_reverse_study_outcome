package com.bytedance.android.ec.core.monitor.listener;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/listener/BuyNowNextPage;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "THIRD_PARTY", "VIRTUAL", "SCARCE_BUY", "MEMBER_SAMPLE_APPLY", "AUCTION_PRODUCT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowNextPage extends Enum<BuyNowNextPage> {
    public static final BuyNowNextPage AUCTION_PRODUCT = null;
    public static final BuyNowNextPage MEMBER_SAMPLE_APPLY = null;
    public static final BuyNowNextPage SCARCE_BUY = null;
    public static final BuyNowNextPage THIRD_PARTY = null;
    public static final BuyNowNextPage VIRTUAL = null;
    public static final /* synthetic */ BuyNowNextPage[] a = null;
    private final String value;

    static {
        BuyNowNextPage r1 = new BuyNowNextPage("THIRD_PARTY", 0, "third_party");
        THIRD_PARTY = r1;
        BuyNowNextPage r10 = new BuyNowNextPage("VIRTUAL", 1, "virtual");
        VIRTUAL = r10;
        BuyNowNextPage r11 = new BuyNowNextPage("SCARCE_BUY", 2, "scarce_buy");
        SCARCE_BUY = r11;
        BuyNowNextPage r12 = new BuyNowNextPage("MEMBER_SAMPLE_APPLY", 3, "member_sample_apply");
        MEMBER_SAMPLE_APPLY = r12;
        BuyNowNextPage r13 = new BuyNowNextPage("AUCTION_PRODUCT", 4, "auction_product");
        AUCTION_PRODUCT = r13;
        a = new BuyNowNextPage[]{r1, r10, r11, r12, r13};
    }

    public static BuyNowNextPage valueOf(String r1) {
        return (BuyNowNextPage) r27.a.a(BuyNowNextPage.class, r1);
    }

    public static BuyNowNextPage[] values() {
        return (BuyNowNextPage[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public BuyNowNextPage(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
