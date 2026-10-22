package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/CardType;", BuildConfig.FLAVOR, "None", "DIY", "Buff", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardType extends Enum<CardType> {
    public static final CardType Buff = null;
    public static final CardType DIY = null;
    public static final CardType None = null;
    public static final /* synthetic */ CardType[] a = null;

    static {
        CardType r1 = new CardType("None", 0);
        None = r1;
        CardType r2 = new CardType("DIY", 1);
        DIY = r2;
        CardType r3 = new CardType("Buff", 2);
        Buff = r3;
        a = new CardType[]{r1, r2, r3};
    }

    public static CardType valueOf(String r1) {
        return (CardType) a.a(CardType.class, r1);
    }

    public static CardType[] values() {
        return (CardType[]) a.clone();
    }

    public CardType(String r1, int r2) {
        super(r1, r2);
    }
}
