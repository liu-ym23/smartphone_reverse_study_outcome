package com.ss.android.lark.passport.flow.mfa;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JR\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006("}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "Ljava/io/Serializable;", "category", "Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;", "message", "", "cause", "", "stepName", "serverCode", "", "logId", "<init>", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCategory", "()Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "getStepName", "getServerCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLogId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/ss/android/lark/passport/flow/mfa/FlowMfaErrorCategory;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/passport/flow/mfa/FlowMfaError;", "equals", "", "other", "", "hashCode", "toString", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class FlowMfaError implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final FlowMfaErrorCategory category;
    private final Throwable cause;
    private final String logId;
    private final String message;
    private final Integer serverCode;
    private final String stepName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ FlowMfaError copy$default(FlowMfaError r4, FlowMfaErrorCategory r5, String r6, Throwable r7, String r8, Integer r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.category;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.message;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.cause;
    L11:
        Throwable r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.stepName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.serverCode;
    L17:
        Integer r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.logId;
    L20:
        FlowMfaErrorCategory r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final FlowMfaErrorCategory component1() {
        return this.category;
    }

    public final String component2() {
        return this.message;
    }

    public final Throwable component3() {
        return this.cause;
    }

    public final String component4() {
        return this.stepName;
    }

    public final Integer component5() {
        return this.serverCode;
    }

    public final String component6() {
        return this.logId;
    }

    public final FlowMfaError copy(FlowMfaErrorCategory r9, String r10, Throwable r11, String r12, Integer r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "category");
        Intrinsics.checkNotNullParameter(r10, "message");
        return new FlowMfaError(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowMfaError) == true) goto L8;
        return false;
    L8:
        FlowMfaError r6 = (FlowMfaError) r5;
        if (this.category == r6.category) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cause, r6.cause) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.stepName, r6.stepName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.serverCode, r6.serverCode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.category.hashCode() * 31) + this.message.hashCode()) * 31;
        Throwable r1 = this.cause;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.stepName;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.serverCode;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.logId;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "FlowMfaError(category=" + this.category + ", message=" + this.message + ", cause=" + this.cause + ", stepName=" + this.stepName + ", serverCode=" + this.serverCode + ", logId=" + this.logId + ')';
    }

    public final FlowMfaErrorCategory getCategory() {
        return this.category;
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getServerCode() {
        return this.serverCode;
    }

    public final String getStepName() {
        return this.stepName;
    }

    public FlowMfaError(FlowMfaErrorCategory r2, String r3, Throwable r4, String r5, Integer r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "category");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.category = r2;
        this.message = r3;
        this.cause = r4;
        this.stepName = r5;
        this.serverCode = r6;
        this.logId = r7;
    }

    public /* synthetic */ FlowMfaError(FlowMfaErrorCategory r10, String r11, Throwable r12, String r13, Integer r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        Throwable r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        String r8 = null;
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
