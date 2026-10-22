package com.obric.memory.datacollect.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/UserParams;", "Ljava/io/Serializable;", "uid", "", "did", "(Ljava/lang/String;Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "setDid", "(Ljava/lang/String;)V", "getUid", "setUid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class UserParams implements Serializable {

    @SerializedName("did")
    private String did;

    @SerializedName("uid")
    private String uid;

    public UserParams(String r2, String r3) {
        Intrinsics.checkParameterIsNotNull(r2, "uid");
        Intrinsics.checkParameterIsNotNull(r3, "did");
        this.uid = r2;
        this.did = r3;
    }

    public static /* synthetic */ UserParams copy$default(UserParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.uid;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.did;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.did;
    }

    public final UserParams copy(String r1, String r2) {
        Intrinsics.checkParameterIsNotNull(r1, "uid");
        Intrinsics.checkParameterIsNotNull(r2, "did");
        return new UserParams(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UserParams.class) == false) goto L11;
        UserParams r4 = (UserParams) ZeusTransformUtils.preCheckCast(r3, UserParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.uid, r4.uid) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.did, r4.did) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final String getDid() {
        return this.did;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        String r0 = this.uid;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.did;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setDid(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.did = r2;
    }

    public final void setUid(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.uid = r2;
    }

    public String toString() {
        return "UserParams(uid=" + this.uid + ", did=" + this.did + ")";
    }
}
