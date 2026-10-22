package com.bytedance.android.ec.common.api.card;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/common/api/card/CardType;", "", "EXPLAIN_CARD", "COUPON_CARD", "RELATED_CARD", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum CardType extends Enum<CardType> {
    public static final CardType COUPON_CARD = null;
    public static final CardType EXPLAIN_CARD = null;
    public static final CardType RELATED_CARD = null;
    public static final /* synthetic */ CardType[] a = null;

    static {
        CardType r1 = new CardType("EXPLAIN_CARD", 0);
        EXPLAIN_CARD = r1;
        CardType r10 = new CardType("COUPON_CARD", 1);
        COUPON_CARD = r10;
        CardType r11 = new CardType("RELATED_CARD", 2);
        RELATED_CARD = r11;
        a = new CardType[]{r1, r10, r11};
    }

    public static CardType valueOf(String r1) {
        return (CardType) a.a(CardType.class, r1);
    }

    public static CardType[] values() {
        return (CardType[]) a.clone();
    }

    public CardType(String r1, int r10) {
        super(r1, r10);
    }
}
