package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012(\b\u0001\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J)\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bHÆ\u0003JG\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052(\b\u0003\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/CollectionInfo;", "Ljava/io/Serializable;", "actionType", "", "eventKey", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(ILjava/lang/String;Ljava/util/HashMap;)V", "getActionType", "()I", "getEventKey", "()Ljava/lang/String;", "getParams", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class CollectionInfo implements Serializable {
    private final int actionType;
    private final String eventKey;
    private final HashMap<String, String> params;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectionInfo copy$default(CollectionInfo r0, int r1, String r2, HashMap r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.actionType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.eventKey;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.params;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.actionType;
    }

    public final String component2() {
        return this.eventKey;
    }

    public final HashMap<String, String> component3() {
        return this.params;
    }

    public final CollectionInfo copy(@JSONField(name = "action_type") int r2, @JSONField(name = "event_key") String r3, @JSONField(name = "params") HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventKey");
        return new CollectionInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CollectionInfo) == true) goto L8;
        return false;
    L8:
        CollectionInfo r6 = (CollectionInfo) r5;
        if (this.actionType == r6.actionType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.eventKey, r6.eventKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.actionType * 31) + this.eventKey.hashCode()) * 31;
        HashMap<String, String> r1 = this.params;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CollectionInfo(actionType=" + this.actionType + ", eventKey=" + this.eventKey + ", params=" + this.params + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getEventKey() {
        return this.eventKey;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public CollectionInfo(@JSONField(name = "action_type") int r2, @JSONField(name = "event_key") String r3, @JSONField(name = "params") HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventKey");
        this.actionType = r2;
        this.eventKey = r3;
        this.params = r4;
    }

    public /* synthetic */ CollectionInfo(int r1, String r2, HashMap r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = "";
    L8:
        this(r1, r2, r3);
    }
}
