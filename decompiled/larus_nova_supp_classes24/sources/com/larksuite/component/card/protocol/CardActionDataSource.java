package com.larksuite.component.card.protocol;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/protocol/CardActionDataSource;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "IM_CONTENT", "CARD_ENTITY", "STREAMING_CARD_ENTITY", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum CardActionDataSource extends Enum<CardActionDataSource> implements Serializable {
    public static final CardActionDataSource CARD_ENTITY = null;
    public static final CardActionDataSource IM_CONTENT = null;
    public static final CardActionDataSource STREAMING_CARD_ENTITY = null;
    public static final /* synthetic */ CardActionDataSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CardActionDataSource> getEntries() {
        return b;
    }

    static {
        CardActionDataSource r0 = new CardActionDataSource("IM_CONTENT", 0);
        IM_CONTENT = r0;
        CardActionDataSource r1 = new CardActionDataSource("CARD_ENTITY", 1);
        CARD_ENTITY = r1;
        CardActionDataSource r3 = new CardActionDataSource("STREAMING_CARD_ENTITY", 2);
        STREAMING_CARD_ENTITY = r3;
        CardActionDataSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CardActionDataSource[] values() {
        return (CardActionDataSource[]) a.clone();
    }

    public static CardActionDataSource valueOf(String r1) {
        return (CardActionDataSource) a.a(CardActionDataSource.class, r1);
    }

    public CardActionDataSource(String r1, int r2) {
        super(r1, r2);
    }
}
