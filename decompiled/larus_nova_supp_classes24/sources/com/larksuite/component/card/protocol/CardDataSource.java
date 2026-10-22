package com.larksuite.component.card.protocol;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/protocol/CardDataSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IM_CONTENT", "IM_ENTITY", "CARD_ENTITY", "STREAMING_ENTITY", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum CardDataSource extends Enum<CardDataSource> {
    public static final CardDataSource CARD_ENTITY = null;
    public static final CardDataSource IM_CONTENT = null;
    public static final CardDataSource IM_ENTITY = null;
    public static final CardDataSource STREAMING_ENTITY = null;
    public static final /* synthetic */ CardDataSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CardDataSource> getEntries() {
        return b;
    }

    static {
        CardDataSource r0 = new CardDataSource("IM_CONTENT", 0, "im_content");
        IM_CONTENT = r0;
        CardDataSource r1 = new CardDataSource("IM_ENTITY", 1, "im_entity");
        IM_ENTITY = r1;
        CardDataSource r2 = new CardDataSource("CARD_ENTITY", 2, "card_entity");
        CARD_ENTITY = r2;
        CardDataSource r4 = new CardDataSource("STREAMING_ENTITY", 3, "streaming_entity");
        STREAMING_ENTITY = r4;
        CardDataSource[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static CardDataSource[] values() {
        return (CardDataSource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CardDataSource valueOf(String r1) {
        return (CardDataSource) a.a(CardDataSource.class, r1);
    }

    public CardDataSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
