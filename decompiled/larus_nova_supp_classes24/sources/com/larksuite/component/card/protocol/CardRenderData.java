package com.larksuite.component.card.protocol;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001)B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J=\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larksuite/component/card/protocol/CardRenderData;", "Ljava/io/Serializable;", "linkType", "Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;", "bizID", "", "cardData", "Lcom/larksuite/component/card/protocol/CardData;", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "cardConfig", "Lcom/larksuite/component/card/protocol/CardConfig;", "<init>", "(Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;Ljava/lang/String;Lcom/larksuite/component/card/protocol/CardData;Lcom/larksuite/component/card/protocol/CardContext;Lcom/larksuite/component/card/protocol/CardConfig;)V", "getLinkType", "()Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;", "getBizID", "()Ljava/lang/String;", "getCardData", "()Lcom/larksuite/component/card/protocol/CardData;", "getCardContext", "()Lcom/larksuite/component/card/protocol/CardContext;", "setCardContext", "(Lcom/larksuite/component/card/protocol/CardContext;)V", "getCardConfig", "()Lcom/larksuite/component/card/protocol/CardConfig;", "setCardConfig", "(Lcom/larksuite/component/card/protocol/CardConfig;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "LinkType", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardRenderData implements Serializable {
    private final String bizID;
    private CardConfig cardConfig;
    private CardContext cardContext;
    private final CardData cardData;
    private final LinkType linkType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/protocol/CardRenderData$LinkType;", "", "<init>", "(Ljava/lang/String;I)V", "MESSAGE", "STREAMING_POLLING", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum LinkType extends Enum<LinkType> {
        public static final LinkType MESSAGE = null;
        public static final LinkType STREAMING_POLLING = null;
        public static final /* synthetic */ LinkType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LinkType> getEntries() {
            return b;
        }

        static {
            LinkType r0 = new LinkType("MESSAGE", 0);
            MESSAGE = r0;
            LinkType r1 = new LinkType("STREAMING_POLLING", 1);
            STREAMING_POLLING = r1;
            LinkType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static LinkType[] values() {
            return (LinkType[]) a.clone();
        }

        public static LinkType valueOf(String r1) {
            return (LinkType) a.a(LinkType.class, r1);
        }

        public LinkType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ CardRenderData copy$default(CardRenderData r3, LinkType r4, String r5, CardData r6, CardContext r7, CardConfig r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.linkType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.bizID;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.cardData;
    L11:
        CardData r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.cardContext;
    L14:
        CardContext r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.cardConfig;
    L17:
        LinkType r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final LinkType component1() {
        return this.linkType;
    }

    public final String component2() {
        return this.bizID;
    }

    public final CardData component3() {
        return this.cardData;
    }

    public final CardContext component4() {
        return this.cardContext;
    }

    public final CardConfig component5() {
        return this.cardConfig;
    }

    public final CardRenderData copy(LinkType r8, String r9, CardData r10, CardContext r11, CardConfig r12) {
        Intrinsics.checkNotNullParameter(r9, "bizID");
        Intrinsics.checkNotNullParameter(r10, "cardData");
        Intrinsics.checkNotNullParameter(r11, "cardContext");
        Intrinsics.checkNotNullParameter(r12, "cardConfig");
        return new CardRenderData(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardRenderData) == true) goto L8;
        return false;
    L8:
        CardRenderData r6 = (CardRenderData) r5;
        if (this.linkType == r6.linkType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizID, r6.bizID) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardData, r6.cardData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cardContext, r6.cardContext) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardConfig, r6.cardConfig) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        LinkType r0 = this.linkType;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((r1 * 31) + this.bizID.hashCode()) * 31) + this.cardData.hashCode()) * 31) + this.cardContext.hashCode()) * 31) + this.cardConfig.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "CardRenderData(linkType=" + this.linkType + ", bizID=" + this.bizID + ", cardData=" + this.cardData + ", cardContext=" + this.cardContext + ", cardConfig=" + this.cardConfig + ')';
    }

    public final String getBizID() {
        return this.bizID;
    }

    public final CardConfig getCardConfig() {
        return this.cardConfig;
    }

    public final CardContext getCardContext() {
        return this.cardContext;
    }

    public final CardData getCardData() {
        return this.cardData;
    }

    public final LinkType getLinkType() {
        return this.linkType;
    }

    public final void setCardConfig(CardConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardConfig = r2;
    }

    public final void setCardContext(CardContext r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cardContext = r2;
    }

    public CardRenderData(LinkType r2, String r3, CardData r4, CardContext r5, CardConfig r6) {
        Intrinsics.checkNotNullParameter(r3, "bizID");
        Intrinsics.checkNotNullParameter(r4, "cardData");
        Intrinsics.checkNotNullParameter(r5, "cardContext");
        Intrinsics.checkNotNullParameter(r6, "cardConfig");
        this.linkType = r2;
        this.bizID = r3;
        this.cardData = r4;
        this.cardContext = r5;
        this.cardConfig = r6;
    }
}
