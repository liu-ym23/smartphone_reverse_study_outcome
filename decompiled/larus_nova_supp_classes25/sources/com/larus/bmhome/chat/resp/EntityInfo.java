package com.larus.bmhome.chat.resp;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0005HÆ\u0003J;\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/resp/EntityInfo;", "", "localMsgID", "", "posIndexList", "", "", "entityInfoList", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getLocalMsgID", "()Ljava/lang/String;", "getPosIndexList", "()Ljava/util/List;", "getEntityInfoList", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class EntityInfo {

    @SerializedName("entity_state_map")
    private final List<EntityInfo> entityInfoList;

    @SerializedName("local_message_id")
    private final String localMsgID;

    @SerializedName("pos_index_list")
    private final List<Integer> posIndexList;

    public EntityInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityInfo copy$default(EntityInfo r0, String r1, List r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.localMsgID;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.posIndexList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.entityInfoList;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.localMsgID;
    }

    public final List<Integer> component2() {
        return this.posIndexList;
    }

    public final List<EntityInfo> component3() {
        return this.entityInfoList;
    }

    public final EntityInfo copy(String r2, List<Integer> r3, List<EntityInfo> r4) {
        return new EntityInfo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EntityInfo) == true) goto L8;
        return false;
    L8:
        EntityInfo r6 = (EntityInfo) r5;
        if (Intrinsics.areEqual(this.localMsgID, r6.localMsgID) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.posIndexList, r6.posIndexList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityInfoList, r6.entityInfoList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.localMsgID;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.posIndexList;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<EntityInfo> r7 = this.entityInfoList;
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
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 != null) goto L15;
        return "";
    L15:
        return r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final List<EntityInfo> getEntityInfoList() {
        return this.entityInfoList;
    }

    public final String getLocalMsgID() {
        return this.localMsgID;
    }

    public final List<Integer> getPosIndexList() {
        return this.posIndexList;
    }

    public EntityInfo(String r1, List<Integer> r2, List<EntityInfo> r3) {
        this.localMsgID = r1;
        this.posIndexList = r2;
        this.entityInfoList = r3;
    }

    public /* synthetic */ EntityInfo(String r2, List r3, List r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
