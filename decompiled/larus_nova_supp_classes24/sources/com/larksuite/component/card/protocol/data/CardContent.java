package com.larksuite.component.card.protocol.data;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/card/protocol/data/CardContent;", "Ljava/io/Serializable;", "cardJSON", "", "attachment", "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "<init>", "(Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/CardAttachment;)V", "getCardJSON", "()Ljava/lang/String;", "getAttachment", "()Lcom/larksuite/component/card/protocol/data/CardAttachment;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardContent implements Serializable {
    private final CardAttachment attachment;
    private final String cardJSON;

    public static /* synthetic */ CardContent copy$default(CardContent r0, String r1, CardAttachment r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.cardJSON;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.attachment;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.cardJSON;
    }

    public final CardAttachment component2() {
        return this.attachment;
    }

    public final CardContent copy(String r2, CardAttachment r3) {
        Intrinsics.checkNotNullParameter(r2, "cardJSON");
        Intrinsics.checkNotNullParameter(r3, "attachment");
        return new CardContent(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardContent) == true) goto L8;
        return false;
    L8:
        CardContent r6 = (CardContent) r5;
        if (Intrinsics.areEqual(this.cardJSON, r6.cardJSON) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachment, r6.attachment) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.cardJSON.hashCode() * 31) + this.attachment.hashCode();
    }

    public String toString() {
        return "CardContent(cardJSON=" + this.cardJSON + ", attachment=" + this.attachment + ')';
    }

    public final CardAttachment getAttachment() {
        return this.attachment;
    }

    public final String getCardJSON() {
        return this.cardJSON;
    }

    public CardContent(String r2, CardAttachment r3) {
        Intrinsics.checkNotNullParameter(r2, "cardJSON");
        Intrinsics.checkNotNullParameter(r3, "attachment");
        this.cardJSON = r2;
        this.attachment = r3;
    }
}
