package com.larksuite.component.card.protocol.data.action;

import android.os.Bundle;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;", "Ljava/io/Serializable;", "selectPersonCurrentChatId", "", "cardSceneIsGroup", "", "isEphemeralCard", "openUrlExtraParams", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;ZZLandroid/os/Bundle;)V", "getSelectPersonCurrentChatId", "()Ljava/lang/String;", "getCardSceneIsGroup", "()Z", "getOpenUrlExtraParams", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardActionDependencyData implements Serializable {
    private final boolean cardSceneIsGroup;
    private final boolean isEphemeralCard;
    private final Bundle openUrlExtraParams;
    private final String selectPersonCurrentChatId;

    public static /* synthetic */ CardActionDependencyData copy$default(CardActionDependencyData r0, String r1, boolean r2, boolean r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.selectPersonCurrentChatId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.cardSceneIsGroup;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.isEphemeralCard;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.openUrlExtraParams;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.selectPersonCurrentChatId;
    }

    public final boolean component2() {
        return this.cardSceneIsGroup;
    }

    public final boolean component3() {
        return this.isEphemeralCard;
    }

    public final Bundle component4() {
        return this.openUrlExtraParams;
    }

    public final CardActionDependencyData copy(String r2, boolean r3, boolean r4, Bundle r5) {
        return new CardActionDependencyData(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardActionDependencyData) == true) goto L8;
        return false;
    L8:
        CardActionDependencyData r6 = (CardActionDependencyData) r5;
        if (Intrinsics.areEqual(this.selectPersonCurrentChatId, r6.selectPersonCurrentChatId) == true) goto L12;
        return false;
    L12:
        if (this.cardSceneIsGroup == r6.cardSceneIsGroup) goto L15;
        return false;
    L15:
        if (this.isEphemeralCard == r6.isEphemeralCard) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.openUrlExtraParams, r6.openUrlExtraParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.selectPersonCurrentChatId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.cardSceneIsGroup == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.isEphemeralCard == true) goto L14;
        r4 = 1237;
    L14:
        int r7 = (r6 + r4) * 31;
        Bundle r8 = this.openUrlExtraParams;
        if (r8 == null) goto L19;
        r1 = r8.hashCode();
    L19:
        return r7 + r1;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CardActionDependencyData(selectPersonCurrentChatId=" + this.selectPersonCurrentChatId + ", cardSceneIsGroup=" + this.cardSceneIsGroup + ", isEphemeralCard=" + this.isEphemeralCard + ", openUrlExtraParams=" + this.openUrlExtraParams + ')';
    }

    public final boolean getCardSceneIsGroup() {
        return this.cardSceneIsGroup;
    }

    public final Bundle getOpenUrlExtraParams() {
        return this.openUrlExtraParams;
    }

    public final String getSelectPersonCurrentChatId() {
        return this.selectPersonCurrentChatId;
    }

    public final boolean isEphemeralCard() {
        return this.isEphemeralCard;
    }

    public CardActionDependencyData(String r1, boolean r2, boolean r3, Bundle r4) {
        this.selectPersonCurrentChatId = r1;
        this.cardSceneIsGroup = r2;
        this.isEphemeralCard = r3;
        this.openUrlExtraParams = r4;
    }

    public /* synthetic */ CardActionDependencyData(String r2, boolean r3, boolean r4, Bundle r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
