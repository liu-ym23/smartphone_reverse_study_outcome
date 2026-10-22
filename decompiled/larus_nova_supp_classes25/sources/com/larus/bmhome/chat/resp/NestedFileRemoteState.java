package com.larus.bmhome.chat.resp;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/resp/NestedFileRemoteState;", "", "code", "", "msg", "", "data", "Lcom/larus/bmhome/chat/resp/EntityState;", "<init>", "(JLjava/lang/String;Lcom/larus/bmhome/chat/resp/EntityState;)V", "getCode", "()J", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/larus/bmhome/chat/resp/EntityState;", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NestedFileRemoteState {

    @SerializedName("code")
    private final long code;

    @SerializedName("data")
    private final EntityState data;

    @SerializedName("msg")
    private final String msg;

    public NestedFileRemoteState() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ NestedFileRemoteState copy$default(NestedFileRemoteState r0, long r1, String r3, EntityState r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.msg;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.data;
    L12:
        return r0.copy(r1, r3, r4);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final EntityState component3() {
        return this.data;
    }

    public final NestedFileRemoteState copy(long r2, String r4, EntityState r5) {
        return new NestedFileRemoteState(r2, r4, r5);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof NestedFileRemoteState) == true) goto L8;
        return false;
    L8:
        NestedFileRemoteState r9 = (NestedFileRemoteState) r8;
        if (this.code == r9.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r9.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r9.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r0 = this.code;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.msg;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        EntityState r6 = this.data;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        return r5 + r3;
    L5:
        r4 = r2.hashCode();
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

    public final long getCode() {
        return this.code;
    }

    public final EntityState getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public NestedFileRemoteState(long r1, String r3, EntityState r4) {
        this.code = r1;
        this.msg = r3;
        this.data = r4;
    }

    public /* synthetic */ NestedFileRemoteState(long r1, String r3, EntityState r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r1, r3, r4);
    }
}
