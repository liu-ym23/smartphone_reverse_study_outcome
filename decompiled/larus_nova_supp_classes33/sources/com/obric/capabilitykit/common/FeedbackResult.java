package com.obric.capabilitykit.common;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/FeedbackResult;", "", "code", "", "msg", "", "data", "uiType", "replyFor", "shouldNotify", "", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getMsg", "getReplyFor", "getShouldNotify", "()Z", "getUiType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FeedbackResult {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final String data;

    @SerializedName("msg")
    private final String msg;

    @SerializedName("replyFor")
    private final String replyFor;

    @SerializedName("shouldNotify")
    private final boolean shouldNotify;

    @SerializedName("uiType")
    private final int uiType;

    public FeedbackResult() {
        this(0, null, null, 0, null, false, 63, null);
    }

    public FeedbackResult(int r1, String r2, String r3, int r4, String r5, boolean r6) {
        this.code = r1;
        this.msg = r2;
        this.data = r3;
        this.uiType = r4;
        this.replyFor = r5;
        this.shouldNotify = r6;
    }

    public /* synthetic */ FeedbackResult(int r5, String r6, String r7, int r8, String r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        int r0 = 0;
        if ((r11 & 1) == 0) goto L5;
        int r13 = 0;
    L6:
        String r1 = null;
        if ((r11 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r11 & 4) != 0) goto L15;
        r1 = r7;
    L15:
        if ((r11 & 8) != 0) goto L19;
        r0 = r8;
    L19:
        if ((r11 & 16) == 0) goto L21;
        r9 = "";
    L21:
        String r3 = r9;
        if ((r11 & 32) == 0) goto L24;
        boolean r14 = true;
    L25:
        this(r13, r2, r1, r0, r3, r14);
        return;
    L24:
        r14 = r10;
        goto L25
    L9:
        r2 = r6;
        goto L11
    L5:
        r13 = r5;
        goto L6
    }

    public static /* synthetic */ FeedbackResult copy$default(FeedbackResult r4, int r5, String r6, String r7, int r8, String r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.code;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.msg;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.data;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.uiType;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.replyFor;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.shouldNotify;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.data;
    }

    public final int component4() {
        return this.uiType;
    }

    public final String component5() {
        return this.replyFor;
    }

    public final boolean component6() {
        return this.shouldNotify;
    }

    public final FeedbackResult copy(int r9, String r10, String r11, int r12, String r13, boolean r14) {
        return new FeedbackResult(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeedbackResult) == true) goto L8;
        return false;
    L8:
        FeedbackResult r6 = (FeedbackResult) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (this.uiType == r6.uiType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.replyFor, r6.replyFor) == true) goto L24;
        return false;
    L24:
        if (this.shouldNotify == r6.shouldNotify) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final boolean getShouldNotify() {
        return this.shouldNotify;
    }

    public final int getUiType() {
        return this.uiType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int r0 = this.code * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.data;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.uiType) * 31;
        String r8 = this.replyFor;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        int r9 = (r7 + r2) * 31;
        boolean r10 = this.shouldNotify;
        ?? r11 = r10;
        if (r10 == false) goto L18;
        r11 = 1;
    L18:
        return r9 + r11;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", shouldNotify=" + this.shouldNotify + ')';
    }
}
