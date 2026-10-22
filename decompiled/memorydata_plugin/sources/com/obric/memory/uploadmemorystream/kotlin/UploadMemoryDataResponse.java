package com.obric.memory.uploadmemorystream.kotlin;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/memory/uploadmemorystream/kotlin/UploadMemoryDataResponse;", "Ljava/io/Serializable;", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "(ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class UploadMemoryDataResponse implements Serializable {

    @SerializedName("code")
    private int code;

    @SerializedName(NotificationCompat.CATEGORY_MESSAGE)
    private String msg;

    public UploadMemoryDataResponse(int r2, String r3) {
        Intrinsics.checkParameterIsNotNull(r3, NotificationCompat.CATEGORY_MESSAGE);
        this.code = r2;
        this.msg = r3;
    }

    public static /* synthetic */ UploadMemoryDataResponse copy$default(UploadMemoryDataResponse r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.msg;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final UploadMemoryDataResponse copy(int r1, String r2) {
        Intrinsics.checkParameterIsNotNull(r2, NotificationCompat.CATEGORY_MESSAGE);
        return new UploadMemoryDataResponse(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UploadMemoryDataResponse.class) == false) goto L11;
        UploadMemoryDataResponse r4 = (UploadMemoryDataResponse) ZeusTransformUtils.preCheckCast(r3, UploadMemoryDataResponse.class, "com.obric.memorydata.plugin");
        if (this.code == r4.code) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.msg, r4.msg) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return false;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.msg;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setMsg(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.msg = r2;
    }

    public String toString() {
        return "UploadMemoryDataResponse(code=" + this.code + ", msg=" + this.msg + ")";
    }
}
