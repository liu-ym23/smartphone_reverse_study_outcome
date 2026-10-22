package com.larus.dora.impl.dynamic;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/dynamic/CardCons$CardType;", "", "id", "", "viewType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getViewType", "()I", "CARD_TEXT", "CARD_PRODUCT_DISPLAY", "CARD_DEVICE_BANNER", "CARD_GENERAL_GROUP", "CARD_DEVICE_NAME", "CARD_DEVICE_ATTRIBUTE", "CARD_DEVICE_UNBIND_BUTTON", "CARD_DEVICE_RECONNECT", "CARD_DEVICE_KEEP_ALIVE", "CARD_SINGLE_DEVICE_PRODUCT_DISPLAY", "CARD_FEEDBACK", "CARD_SINGLE_DEVICE_PRODUCT_DISPLAY_V2", "CARD_PRODUCT_DISPLAY_EXTERNAL", "CARD_PRODUCT_ITEM_EXTERNAL", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardCons$CardType extends Enum<CardCons$CardType> {
    public static final CardCons$CardType CARD_DEVICE_ATTRIBUTE = null;
    public static final CardCons$CardType CARD_DEVICE_BANNER = null;
    public static final CardCons$CardType CARD_DEVICE_KEEP_ALIVE = null;
    public static final CardCons$CardType CARD_DEVICE_NAME = null;
    public static final CardCons$CardType CARD_DEVICE_RECONNECT = null;
    public static final CardCons$CardType CARD_DEVICE_UNBIND_BUTTON = null;
    public static final CardCons$CardType CARD_FEEDBACK = null;
    public static final CardCons$CardType CARD_GENERAL_GROUP = null;
    public static final CardCons$CardType CARD_PRODUCT_DISPLAY = null;
    public static final CardCons$CardType CARD_PRODUCT_DISPLAY_EXTERNAL = null;
    public static final CardCons$CardType CARD_PRODUCT_ITEM_EXTERNAL = null;
    public static final CardCons$CardType CARD_SINGLE_DEVICE_PRODUCT_DISPLAY = null;
    public static final CardCons$CardType CARD_SINGLE_DEVICE_PRODUCT_DISPLAY_V2 = null;
    public static final CardCons$CardType CARD_TEXT = null;
    public static final a Companion = null;
    public static final Map<String, CardCons$CardType> a = null;
    public static final /* synthetic */ CardCons$CardType[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final String id;
    private final int viewType;

    public static EnumEntries<CardCons$CardType> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.larus.dora.impl.dynamic.CardCons$CardType$a] */
    static {
        CardCons$CardType r0 = new CardCons$CardType("CARD_TEXT", 0, "product_item", 1);
        CARD_TEXT = r0;
        CardCons$CardType r1 = new CardCons$CardType("CARD_PRODUCT_DISPLAY", 1, "product_display", 2);
        CARD_PRODUCT_DISPLAY = r1;
        CardCons$CardType r3 = new CardCons$CardType("CARD_DEVICE_BANNER", 2, "banner", 3);
        CARD_DEVICE_BANNER = r3;
        CardCons$CardType r5 = new CardCons$CardType("CARD_GENERAL_GROUP", 3, "general_group", 4);
        CARD_GENERAL_GROUP = r5;
        CardCons$CardType r7 = new CardCons$CardType("CARD_DEVICE_NAME", 4, "device_name", 5);
        CARD_DEVICE_NAME = r7;
        CardCons$CardType r9 = new CardCons$CardType("CARD_DEVICE_ATTRIBUTE", 5, "device_attribute", 6);
        CARD_DEVICE_ATTRIBUTE = r9;
        CardCons$CardType r11 = new CardCons$CardType("CARD_DEVICE_UNBIND_BUTTON", 6, "unbind_button", 7);
        CARD_DEVICE_UNBIND_BUTTON = r11;
        CardCons$CardType r13 = new CardCons$CardType("CARD_DEVICE_RECONNECT", 7, "device_reconnect", 8);
        CARD_DEVICE_RECONNECT = r13;
        CardCons$CardType r14 = new CardCons$CardType("CARD_DEVICE_KEEP_ALIVE", 8, "keep_alive", 9);
        CARD_DEVICE_KEEP_ALIVE = r14;
        CardCons$CardType r12 = new CardCons$CardType("CARD_SINGLE_DEVICE_PRODUCT_DISPLAY", 9, "single_device_product_display", 10);
        CARD_SINGLE_DEVICE_PRODUCT_DISPLAY = r12;
        CardCons$CardType r10 = new CardCons$CardType("CARD_FEEDBACK", 10, "feedback", 11);
        CARD_FEEDBACK = r10;
        CardCons$CardType r8 = new CardCons$CardType("CARD_SINGLE_DEVICE_PRODUCT_DISPLAY_V2", 11, "single_device_product_display_v2", 12);
        CARD_SINGLE_DEVICE_PRODUCT_DISPLAY_V2 = r8;
        CardCons$CardType r6 = new CardCons$CardType("CARD_PRODUCT_DISPLAY_EXTERNAL", 12, "product_display_external", 13);
        CARD_PRODUCT_DISPLAY_EXTERNAL = r6;
        CardCons$CardType r4 = new CardCons$CardType("CARD_PRODUCT_ITEM_EXTERNAL", 13, "product_item_external", 14);
        CARD_PRODUCT_ITEM_EXTERNAL = r4;
        int r15 = 0;
        CardCons$CardType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r14, r12, r10, r8, r6, r4};
        b = r2;
        c = EnumEntriesKt.enumEntries(r2);
        Companion = new a();
        CardCons$CardType[] r16 = values();
        LinkedHashMap r17 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r16.length), 16));
        int r18 = r16.length;
    L3:
        if (r15 >= r18) goto L5;
        CardCons$CardType r20 = r16[r15];
        r17.put(r20.id, r20);
        r15 = r15 + 1;
        goto L3
    L5:
        a = r17;
    }

    public static CardCons$CardType[] values() {
        return (CardCons$CardType[]) b.clone();
    }

    public static final /* synthetic */ Map access$getIdToViewTypeMap$cp() {
        return a;
    }

    public final String getId() {
        return this.id;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public static CardCons$CardType valueOf(String r1) {
        return (CardCons$CardType) r27.a.a(CardCons$CardType.class, r1);
    }

    public CardCons$CardType(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.id = r3;
        this.viewType = r4;
    }
}
