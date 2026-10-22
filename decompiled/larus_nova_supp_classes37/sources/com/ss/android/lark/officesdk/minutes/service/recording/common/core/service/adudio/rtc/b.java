package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006&"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/adudio/rtc/MmRtcInfo;", "", "infoType", "", "meetNumber", "passcode", "userId", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "parameter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInfoType", "()Ljava/lang/String;", "setInfoType", "(Ljava/lang/String;)V", "getMeetNumber", "setMeetNumber", "getPasscode", "setPasscode", "getUserId", "setUserId", "getToken", "setToken", "getParameter", "setParameter", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class b {

    @SerializedName("InfoType")
    private String infoType;

    @SerializedName("MeetNumber")
    private String meetNumber;

    @SerializedName("Parameter")
    private String parameter;

    @SerializedName("Passcode")
    private String passcode;

    @SerializedName("Token")
    private String token;

    @SerializedName("UserID")
    private String userId;

    public b() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.infoType, r6.infoType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.meetNumber, r6.meetNumber) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.passcode, r6.passcode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parameter, r6.parameter) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.infoType.hashCode() * 31) + this.meetNumber.hashCode()) * 31) + this.passcode.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.parameter.hashCode();
    }

    public final String toString() {
        return "MmRtcInfo(infoType='" + this.infoType + "', meetNumber='" + this.meetNumber + "', passcode='" + this.passcode + "', userId='" + this.userId + "', token='" + this.token + "', parameter='" + this.parameter + "')";
    }

    public final String a() {
        return this.meetNumber;
    }

    public final String b() {
        return this.parameter;
    }

    public final String c() {
        return this.token;
    }

    public final String d() {
        return this.userId;
    }

    public b(int r3) {
        Intrinsics.checkNotNullParameter("", "infoType");
        Intrinsics.checkNotNullParameter("", "meetNumber");
        Intrinsics.checkNotNullParameter("", "passcode");
        Intrinsics.checkNotNullParameter("", "userId");
        Intrinsics.checkNotNullParameter("", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        Intrinsics.checkNotNullParameter("{}", "parameter");
        this.infoType = "";
        this.meetNumber = "";
        this.passcode = "";
        this.userId = "";
        this.token = "";
        this.parameter = "{}";
    }
}
