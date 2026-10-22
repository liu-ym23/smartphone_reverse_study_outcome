package com.bytedance.rpc.model.kotlin;

import com.bytedance.crash.entity.Header;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/UserParams;", "Ljava/io/Serializable;", "userId", "", "deviceId", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getDeviceId", "()Ljava/lang/Long;", "setDeviceId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserId", "setUserId", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/rpc/model/kotlin/UserParams;", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class UserParams implements Serializable {

    @SerializedName("device_id")
    private Long deviceId;

    @SerializedName(Header.KEY_USER_ID)
    private Long userId;

    /* JADX WARN: Multi-variable type inference failed */
    public UserParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public UserParams(Long r1, Long r2) {
        this.userId = r1;
        this.deviceId = r2;
    }

    public /* synthetic */ UserParams(Long r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
    L8:
        this(r3, r4);
    }

    public static /* synthetic */ UserParams copy$default(UserParams r0, Long r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.userId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.deviceId;
    L9:
        return r0.copy(r1, r2);
    }

    public final Long component1() {
        return this.userId;
    }

    public final Long component2() {
        return this.deviceId;
    }

    public final UserParams copy(Long r1, Long r2) {
        return new UserParams(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UserParams.class) == false) goto L11;
        UserParams r4 = (UserParams) ZeusTransformUtils.preCheckCast(r3, UserParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.deviceId, r4.deviceId) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final Long getDeviceId() {
        return this.deviceId;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        Long r0 = this.userId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.deviceId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final void setDeviceId(Long r1) {
        this.deviceId = r1;
    }

    public final void setUserId(Long r1) {
        this.userId = r1;
    }

    public String toString() {
        return "UserParams(userId=" + this.userId + ", deviceId=" + this.deviceId + ")";
    }
}
