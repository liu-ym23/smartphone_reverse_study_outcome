package com.bytedance.ai.resource.core.bean;

import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001$B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J6\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u00188Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "T", "", "data", "code", "", MessageIndication.MESSAGE_TYPE_MSG, "", "<init>", "(Ljava/lang/Object;ILjava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "success", "", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;ILjava/lang/String;)Lcom/bytedance/ai/resource/core/bean/AIPackageNetworkResponse;", "equals", "other", "hashCode", "toString", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageNetworkResponse<T> {
    public static final int CODE_UNKNOWN = -999;
    public static final a Companion = null;
    private int code;
    private T data;
    private String msg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AIPackageNetworkResponse() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageNetworkResponse copy$default(AIPackageNetworkResponse r0, Object r1, int r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.code;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.msg;
    L12:
        return r0.copy(r1, r10, r11);
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

    public final AIPackageNetworkResponse<T> copy(T r10, int r11, String r12) {
        return new AIPackageNetworkResponse(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIPackageNetworkResponse) == true) goto L8;
        return false;
    L8:
        AIPackageNetworkResponse r11 = (AIPackageNetworkResponse) r10;
        if (Intrinsics.areEqual(this.data, r11.data) == true) goto L12;
        return false;
    L12:
        if (this.code == r11.code) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msg, r11.msg) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        T r0 = this.data;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = ((r10 * 31) + this.code) * 31;
        String r12 = this.msg;
        if (r12 == null) goto L11;
        r1 = r12.hashCode();
    L11:
        return r11 + r1;
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AIPackageNetworkResponse(data=" + this.data + ", code=" + this.code + ", msg=" + this.msg + ')';
    }

    public final boolean getSuccess() {
        if (getCode() != 0) goto L5;
        return true;
    L5:
        return false;
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

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final void setData(T r1) {
        this.data = r1;
    }

    public final void setMsg(String r1) {
        this.msg = r1;
    }

    public AIPackageNetworkResponse(T r1, int r10, String r11) {
        this.data = r1;
        this.code = r10;
        this.msg = r11;
    }

    public /* synthetic */ AIPackageNetworkResponse(Object r1, int r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = 0;
    L9:
        if ((r12 & 4) == 0) goto L11;
        r11 = "";
    L11:
        this(r1, r10, r11);
    }
}
