package com.larus.extension.chat_extension.impl.ltm;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÂ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/InsertBotMemoryData;", "", "_status", "", "memoryId", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getMemoryId", "()Ljava/lang/String;", "getStatus", "Lcom/larus/extension/chat_extension/impl/ltm/InsertBotRespStatus;", "component1", "()Ljava/lang/Integer;", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/extension/chat_extension/impl/ltm/InsertBotMemoryData;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class InsertBotMemoryData {

    @SerializedName("status")
    private Integer _status;

    @SerializedName("memory_id")
    private final String memoryId;

    /* JADX WARN: Multi-variable type inference failed */
    public InsertBotMemoryData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    private final Integer component1() {
        return this._status;
    }

    public static /* synthetic */ InsertBotMemoryData copy$default(InsertBotMemoryData r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0._status;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.memoryId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component2() {
        return this.memoryId;
    }

    public final InsertBotMemoryData copy(Integer r2, String r3) {
        return new InsertBotMemoryData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InsertBotMemoryData) == true) goto L8;
        return false;
    L8:
        InsertBotMemoryData r6 = (InsertBotMemoryData) r5;
        if (Intrinsics.areEqual(this._status, r6._status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.memoryId, r6.memoryId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this._status;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.memoryId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InsertBotMemoryData(_status=" + this._status + ", memoryId=" + this.memoryId + ')';
    }

    public final InsertBotRespStatus getStatus() {
        InsertBotRespStatus.a r0 = InsertBotRespStatus.Companion;
        Integer r1 = this._status;
        r0.getClass();
        InsertBotRespStatus[] r2 = InsertBotRespStatus.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L14;
        InsertBotRespStatus r5 = r2[r4];
        int r6 = r5.getStatus();
        if (r1 != null) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == true) goto L18;
        r4 = r4 + 1;
        goto L3
    L18:
        return r5;
    L8:
        if (r6 != r1.intValue()) goto L10;
        r7 = true;
        goto L11
    L14:
        return null;
    }

    public final String getMemoryId() {
        return this.memoryId;
    }

    public InsertBotMemoryData(Integer r1, String r2) {
        this._status = r1;
        this.memoryId = r2;
    }

    public /* synthetic */ InsertBotMemoryData(Integer r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
