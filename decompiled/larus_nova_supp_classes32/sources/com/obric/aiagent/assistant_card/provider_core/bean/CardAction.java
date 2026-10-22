package com.obric.aiagent.assistant_card.provider_core.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/assistant_card/provider_core/bean/CardAction;", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "viewId", NameKeys.UnloadStrategy_No_Strategy, "actionName", "actionParams", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getViewId", "()I", "getActionName", "getActionParams", "component1", "component2", "component3", "component4", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "assistant-card-provider-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardAction {

    @SerializedName("actionName")
    private final String actionName;

    @SerializedName("actionParams")
    private final String actionParams;

    @SerializedName("type")
    private final String type;

    @SerializedName("viewId")
    private final int viewId;

    public static /* synthetic */ CardAction copy$default(CardAction r0, String r1, int r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.viewId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.actionName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.actionParams;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.type;
    }

    public final int component2() {
        return this.viewId;
    }

    public final String component3() {
        return this.actionName;
    }

    public final String component4() {
        return this.actionParams;
    }

    public final CardAction copy(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "actionName");
        return new CardAction(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardAction) == true) goto L8;
        return false;
    L8:
        CardAction r6 = (CardAction) r5;
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (this.viewId == r6.viewId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionName, r6.actionName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionParams, r6.actionParams) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.type.hashCode() * 31) + this.viewId) * 31) + this.actionName.hashCode()) * 31;
        String r1 = this.actionParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CardAction(type=" + this.type + ", viewId=" + this.viewId + ", actionName=" + this.actionName + ", actionParams=" + this.actionParams + ')';
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getActionParams() {
        return this.actionParams;
    }

    public final String getType() {
        return this.type;
    }

    public final int getViewId() {
        return this.viewId;
    }

    public CardAction(String r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "actionName");
        this.type = r2;
        this.viewId = r3;
        this.actionName = r4;
        this.actionParams = r5;
    }
}
