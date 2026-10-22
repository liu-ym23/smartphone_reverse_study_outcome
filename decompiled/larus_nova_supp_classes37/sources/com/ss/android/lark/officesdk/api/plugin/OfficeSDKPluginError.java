package com.ss.android.lark.officesdk.api.plugin;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;", "", "stage", "Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;", "code", "", "message", "", "hostCode", "cause", "", "<init>", "(Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "getStage", "()Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getHostCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginStage;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)Lcom/ss/android/lark/officesdk/api/plugin/OfficeSDKPluginError;", "equals", "", "other", "hashCode", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKPluginError {
    private final Throwable cause;
    private final int code;
    private final Integer hostCode;
    private final String message;
    private final OfficeSDKPluginStage stage;

    public static /* synthetic */ OfficeSDKPluginError copy$default(OfficeSDKPluginError r3, OfficeSDKPluginStage r4, int r5, String r6, Integer r7, Throwable r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.stage;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.code;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.message;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.hostCode;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.cause;
    L17:
        OfficeSDKPluginStage r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final OfficeSDKPluginStage component1() {
        return this.stage;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.message;
    }

    public final Integer component4() {
        return this.hostCode;
    }

    public final Throwable component5() {
        return this.cause;
    }

    public final OfficeSDKPluginError copy(OfficeSDKPluginStage r8, int r9, String r10, Integer r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r8, "stage");
        Intrinsics.checkNotNullParameter(r10, "message");
        return new OfficeSDKPluginError(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSDKPluginError) == true) goto L8;
        return false;
    L8:
        OfficeSDKPluginError r6 = (OfficeSDKPluginError) r5;
        if (this.stage == r6.stage) goto L12;
        return false;
    L12:
        if (this.code == r6.code) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostCode, r6.hostCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cause, r6.cause) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.stage.hashCode() * 31) + this.code) * 31) + this.message.hashCode()) * 31;
        Integer r1 = this.hostCode;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Throwable r5 = this.cause;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeSDKPluginError(stage=" + this.stage + ", code=" + this.code + ", message=" + this.message + ", hostCode=" + this.hostCode + ", cause=" + this.cause + ')';
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final int getCode() {
        return this.code;
    }

    public final Integer getHostCode() {
        return this.hostCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final OfficeSDKPluginStage getStage() {
        return this.stage;
    }

    public OfficeSDKPluginError(OfficeSDKPluginStage r2, int r3, String r4, Integer r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.stage = r2;
        this.code = r3;
        this.message = r4;
        this.hostCode = r5;
        this.cause = r6;
    }

    public /* synthetic */ OfficeSDKPluginError(OfficeSDKPluginStage r8, int r9, String r10, Integer r11, Throwable r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        Throwable r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }
}
