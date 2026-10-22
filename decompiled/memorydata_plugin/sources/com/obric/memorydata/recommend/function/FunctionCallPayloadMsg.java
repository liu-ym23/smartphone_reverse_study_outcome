package com.obric.memorydata.recommend.function;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/recommend/function/FunctionCallPayloadMsg;", "", OaidModel.KEY_ID, "", "env", "", "functionName", "arguments", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getEnv", "()Ljava/lang/String;", "getFunctionName", "getArguments", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FunctionCallPayloadMsg {

    @SerializedName("arguments")
    private final String arguments;

    @SerializedName("env")
    private final String env;

    @SerializedName("function_name")
    private final String functionName;

    @SerializedName(OaidModel.KEY_ID)
    private final long id;

    public FunctionCallPayloadMsg(long r2, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "env");
        Intrinsics.checkNotNullParameter(r5, "functionName");
        this.id = r2;
        this.env = r4;
        this.functionName = r5;
        this.arguments = r6;
    }

    public static /* synthetic */ FunctionCallPayloadMsg copy$default(FunctionCallPayloadMsg r6, long r7, String r9, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.id;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.env;
    L8:
        String r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.functionName;
    L11:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r11 = r6.arguments;
    L15:
        return r6.copy(r1, r3, r4, r11);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.env;
    }

    public final String component3() {
        return this.functionName;
    }

    public final String component4() {
        return this.arguments;
    }

    public final FunctionCallPayloadMsg copy(long r7, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "env");
        Intrinsics.checkNotNullParameter(r10, "functionName");
        return new FunctionCallPayloadMsg(r7, r9, r10, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, FunctionCallPayloadMsg.class) == true) goto L8;
        return false;
    L8:
        FunctionCallPayloadMsg r10 = (FunctionCallPayloadMsg) ZeusTransformUtils.preCheckCast(r9, FunctionCallPayloadMsg.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.env, r10.env) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.functionName, r10.functionName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.arguments, r10.arguments) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getArguments() {
        return this.arguments;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getFunctionName() {
        return this.functionName;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.id) * 31) + this.env.hashCode()) * 31) + this.functionName.hashCode()) * 31;
        String r2 = this.arguments;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "FunctionCallPayloadMsg(id=" + this.id + ", env=" + this.env + ", functionName=" + this.functionName + ", arguments=" + this.arguments + ')';
    }
}
