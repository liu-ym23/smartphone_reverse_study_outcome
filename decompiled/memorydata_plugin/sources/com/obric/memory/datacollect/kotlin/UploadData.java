package com.obric.memory.datacollect.kotlin;

import com.bytedance.rpc.model.kotlin.TTNetCommonParam;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JE\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/UploadData;", "Ljava/io/Serializable;", "dataType", "Lcom/obric/memory/datacollect/kotlin/DataType;", "data", "", "userParams", "Lcom/obric/memory/datacollect/kotlin/UserParams;", ObricMemoryConstants.KEY_PACKAGE_NAME, "appName", "commonParam", "Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;", "(Lcom/obric/memory/datacollect/kotlin/DataType;Ljava/lang/String;Lcom/obric/memory/datacollect/kotlin/UserParams;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getCommonParam", "()Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;", "setCommonParam", "(Lcom/bytedance/rpc/model/kotlin/TTNetCommonParam;)V", "getData", "setData", "getDataType", "()Lcom/obric/memory/datacollect/kotlin/DataType;", "setDataType", "(Lcom/obric/memory/datacollect/kotlin/DataType;)V", "getPackageName", "setPackageName", "getUserParams", "()Lcom/obric/memory/datacollect/kotlin/UserParams;", "setUserParams", "(Lcom/obric/memory/datacollect/kotlin/UserParams;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class UploadData implements Serializable {

    @SerializedName("appName")
    private String appName;

    @SerializedName("common_param")
    private TTNetCommonParam commonParam;

    @SerializedName("data")
    private String data;

    @SerializedName("dataType")
    private DataType dataType;

    @SerializedName(ObricMemoryConstants.KEY_PACKAGE_NAME)
    private String packageName;

    @SerializedName("userParams")
    private UserParams userParams;

    public UploadData(DataType r2, String r3, UserParams r4, String r5, String r6, TTNetCommonParam r7) {
        Intrinsics.checkParameterIsNotNull(r2, "dataType");
        Intrinsics.checkParameterIsNotNull(r3, "data");
        Intrinsics.checkParameterIsNotNull(r4, "userParams");
        Intrinsics.checkParameterIsNotNull(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkParameterIsNotNull(r6, "appName");
        Intrinsics.checkParameterIsNotNull(r7, "commonParam");
        this.dataType = r2;
        this.data = r3;
        this.userParams = r4;
        this.packageName = r5;
        this.appName = r6;
        this.commonParam = r7;
    }

    public static /* synthetic */ UploadData copy$default(UploadData r4, DataType r5, String r6, UserParams r7, String r8, String r9, TTNetCommonParam r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.dataType;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.data;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.userParams;
    L11:
        UserParams r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.packageName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.appName;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.commonParam;
    L20:
        DataType r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final DataType component1() {
        return this.dataType;
    }

    public final String component2() {
        return this.data;
    }

    public final UserParams component3() {
        return this.userParams;
    }

    public final String component4() {
        return this.packageName;
    }

    public final String component5() {
        return this.appName;
    }

    public final TTNetCommonParam component6() {
        return this.commonParam;
    }

    public final UploadData copy(DataType r8, String r9, UserParams r10, String r11, String r12, TTNetCommonParam r13) {
        Intrinsics.checkParameterIsNotNull(r8, "dataType");
        Intrinsics.checkParameterIsNotNull(r9, "data");
        Intrinsics.checkParameterIsNotNull(r10, "userParams");
        Intrinsics.checkParameterIsNotNull(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkParameterIsNotNull(r12, "appName");
        Intrinsics.checkParameterIsNotNull(r13, "commonParam");
        return new UploadData(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UploadData.class) == false) goto L19;
        UploadData r4 = (UploadData) ZeusTransformUtils.preCheckCast(r3, UploadData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.dataType, r4.dataType) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.userParams, r4.userParams) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.packageName, r4.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appName, r4.appName) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.commonParam, r4.commonParam) == true) goto L29;
        return false;
    L29:
        return true;
    L19:
        return false;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final TTNetCommonParam getCommonParam() {
        return this.commonParam;
    }

    public final String getData() {
        return this.data;
    }

    public final DataType getDataType() {
        return this.dataType;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final UserParams getUserParams() {
        return this.userParams;
    }

    public int hashCode() {
        DataType r0 = this.dataType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.data;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        UserParams r7 = this.userParams;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.packageName;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.appName;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        TTNetCommonParam r16 = this.commonParam;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void setAppName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.appName = r2;
    }

    public final void setCommonParam(TTNetCommonParam r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.commonParam = r2;
    }

    public final void setData(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.data = r2;
    }

    public final void setDataType(DataType r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.dataType = r2;
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.packageName = r2;
    }

    public final void setUserParams(UserParams r2) {
        Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
        this.userParams = r2;
    }

    public String toString() {
        return "UploadData(dataType=" + this.dataType + ", data=" + this.data + ", userParams=" + this.userParams + ", packageName=" + this.packageName + ", appName=" + this.appName + ", commonParam=" + this.commonParam + ")";
    }
}
