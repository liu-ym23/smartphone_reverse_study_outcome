package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u00188Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "code", "", "msg", "", "<init>", "(Ljava/lang/Object;ILjava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;ILjava/lang/String;)Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "equals", "other", "hashCode", "toString", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageNetworkResponse<T> {
    public static final int CODE_UNKNOWN = -999;
    public static final Companion Companion = null;
    private int code;
    private T data;
    private String msg;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse$Companion;", "", "", "CODE_UNKNOWN", "I", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }
    }

    static {
        Companion = new Companion();
    }

    public AIPackageNetworkResponse() {
        Object r5 = null;
        int r10 = 0;
        String r11 = null;
        this(r5, r10, r11, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageNetworkResponse copy$default(AIPackageNetworkResponse r5, Object r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.data;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.code;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.msg;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final T component1() {
        return this.data;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.msg;
    }

    public final AIPackageNetworkResponse<T> copy(T r5, int r10, String r11) {
        return new AIPackageNetworkResponse(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPackageNetworkResponse) == true) goto L8;
        return false;
    L8:
        AIPackageNetworkResponse r10 = (AIPackageNetworkResponse) r5;
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L12;
        return false;
    L12:
        if (this.code == r10.code) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msg, r10.msg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        T r5 = this.data;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = d.a(this.code, r11 * 31);
        String r13 = this.msg;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final void setCode(int r5) {
        this.code = r5;
    }

    public final void setData(T r5) {
        this.data = r5;
    }

    public final void setMsg(String r5) {
        this.msg = r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("AIPackageNetworkResponse(data=");
        r5.append(this.data);
        r5.append(", code=");
        r5.append(this.code);
        r5.append(", msg=");
        return j0.p(r5, this.msg, ')');
    }

    public AIPackageNetworkResponse(T r5, int r10, String r11) {
        this.data = r5;
        this.code = r10;
        this.msg = r11;
    }

    public /* synthetic */ AIPackageNetworkResponse(Object r5, int r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = 0;
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = "";
    L11:
        this(r5, r10, r11);
    }
}
