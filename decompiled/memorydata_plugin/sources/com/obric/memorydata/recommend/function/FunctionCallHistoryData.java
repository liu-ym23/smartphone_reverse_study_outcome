package com.obric.memorydata.recommend.function;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/recommend/function/FunctionCallHistoryData;", "", "type", "", ChatMessage.TYPE_QUERY, "result", OaidModel.KEY_TIME, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getType", "()Ljava/lang/String;", "getQuery", "getResult", "getTime", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionCallHistoryData {
    private final String query;
    private final String result;
    private final long time;
    private final String type;

    public FunctionCallHistoryData(String r2, String r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r4, "result");
        this.type = r2;
        this.query = r3;
        this.result = r4;
        this.time = r5;
    }

    public /* synthetic */ FunctionCallHistoryData(String r7, String r8, String r9, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = System.currentTimeMillis();
    L5:
        this(r7, r8, r9, r10);
    }

    public static /* synthetic */ FunctionCallHistoryData copy$default(FunctionCallHistoryData r3, String r4, String r5, String r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.type;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.query;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.result;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.time;
    L14:
        String r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.query;
    }

    public final String component3() {
        return this.result;
    }

    public final long component4() {
        return this.time;
    }

    public final FunctionCallHistoryData copy(String r7, String r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r9, "result");
        return new FunctionCallHistoryData(r7, r8, r9, r10);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, FunctionCallHistoryData.class) == true) goto L8;
        return false;
    L8:
        FunctionCallHistoryData r8 = (FunctionCallHistoryData) ZeusTransformUtils.preCheckCast(r7, FunctionCallHistoryData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r8.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.query, r8.query) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.result, r8.result) == true) goto L18;
        return false;
    L18:
        if (this.time == r8.time) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getResult() {
        return this.result;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.query.hashCode()) * 31) + this.result.hashCode()) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "FunctionCallHistoryData(type=" + this.type + ", query=" + this.query + ", result=" + this.result + ", time=" + this.time + ')';
    }
}
