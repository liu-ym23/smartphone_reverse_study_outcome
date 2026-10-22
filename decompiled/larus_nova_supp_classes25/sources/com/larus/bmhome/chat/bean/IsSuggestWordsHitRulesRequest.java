package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0018\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/bean/IsSuggestWordsHitRulesRequest;", "", "paramList", "", "Lcom/larus/bmhome/chat/bean/RuleRequestParamRequest;", "scene", "", "type", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getParamList", "()Ljava/util/List;", "setParamList", "(Ljava/util/List;)V", "getScene", "()Ljava/lang/Integer;", "setScene", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getType", "setType", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/IsSuggestWordsHitRulesRequest;", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class IsSuggestWordsHitRulesRequest {

    @SerializedName(ChatDraftItem.TYPE_TEXT)
    private List<RuleRequestParamRequest> paramList;

    @SerializedName("scene")
    private Integer scene;

    @SerializedName("rule_type")
    private Integer type;

    public IsSuggestWordsHitRulesRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IsSuggestWordsHitRulesRequest copy$default(IsSuggestWordsHitRulesRequest r0, List r1, Integer r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.paramList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.scene;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.type;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<RuleRequestParamRequest> component1() {
        return this.paramList;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Integer component3() {
        return this.type;
    }

    public final IsSuggestWordsHitRulesRequest copy(List<RuleRequestParamRequest> r2, Integer r3, Integer r4) {
        return new IsSuggestWordsHitRulesRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IsSuggestWordsHitRulesRequest) == true) goto L8;
        return false;
    L8:
        IsSuggestWordsHitRulesRequest r6 = (IsSuggestWordsHitRulesRequest) r5;
        if (Intrinsics.areEqual(this.paramList, r6.paramList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<RuleRequestParamRequest> r0 = this.paramList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.scene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.type;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "IsSuggestWordsHitRulesRequest(paramList=" + this.paramList + ", scene=" + this.scene + ", type=" + this.type + ')';
    }

    public final List<RuleRequestParamRequest> getParamList() {
        return this.paramList;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setParamList(List<RuleRequestParamRequest> r1) {
        this.paramList = r1;
    }

    public final void setScene(Integer r1) {
        this.scene = r1;
    }

    public final void setType(Integer r1) {
        this.type = r1;
    }

    public IsSuggestWordsHitRulesRequest(List<RuleRequestParamRequest> r1, Integer r2, Integer r3) {
        this.paramList = r1;
        this.scene = r2;
        this.type = r3;
    }

    public /* synthetic */ IsSuggestWordsHitRulesRequest(List r2, Integer r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = new ArrayList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
