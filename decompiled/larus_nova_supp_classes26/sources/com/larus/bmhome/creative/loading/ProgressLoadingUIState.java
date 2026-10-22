package com.larus.bmhome.creative.loading;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/larus/bmhome/creative/loading/ProgressLoadingUIState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "Ljava/io/Serializable;", "loadingLocalMessageId", "", "loadingReplyId", "taskId", "progress", "", "updateId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "getLoadingLocalMessageId", "()Ljava/lang/String;", "getLoadingReplyId", "getTaskId", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpdateId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/larus/bmhome/creative/loading/ProgressLoadingUIState;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressLoadingUIState implements b, Serializable {
    private final String loadingLocalMessageId;
    private final String loadingReplyId;
    private final Integer progress;
    private final String taskId;
    private final Long updateId;

    public ProgressLoadingUIState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ProgressLoadingUIState copy$default(ProgressLoadingUIState r3, String r4, String r5, String r6, Integer r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.loadingLocalMessageId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.loadingReplyId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.taskId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.progress;
    L14:
        Integer r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.updateId;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.loadingLocalMessageId;
    }

    public final String component2() {
        return this.loadingReplyId;
    }

    public final String component3() {
        return this.taskId;
    }

    public final Integer component4() {
        return this.progress;
    }

    public final Long component5() {
        return this.updateId;
    }

    public final ProgressLoadingUIState copy(String r8, String r9, String r10, Integer r11, Long r12) {
        return new ProgressLoadingUIState(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProgressLoadingUIState) == true) goto L8;
        return false;
    L8:
        ProgressLoadingUIState r6 = (ProgressLoadingUIState) r5;
        if (Intrinsics.areEqual(this.loadingLocalMessageId, r6.loadingLocalMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadingReplyId, r6.loadingReplyId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.progress, r6.progress) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateId, r6.updateId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.loadingLocalMessageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.loadingReplyId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.taskId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.progress;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.updateId;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ProgressLoadingUIState(loadingLocalMessageId=" + this.loadingLocalMessageId + ", loadingReplyId=" + this.loadingReplyId + ", taskId=" + this.taskId + ", progress=" + this.progress + ", updateId=" + this.updateId + ')';
    }

    public final String getLoadingLocalMessageId() {
        return this.loadingLocalMessageId;
    }

    public final String getLoadingReplyId() {
        return this.loadingReplyId;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Long getUpdateId() {
        return this.updateId;
    }

    public ProgressLoadingUIState(String r1, String r2, String r3, Integer r4, Long r5) {
        this.loadingLocalMessageId = r1;
        this.loadingReplyId = r2;
        this.taskId = r3;
        this.progress = r4;
        this.updateId = r5;
    }

    public /* synthetic */ ProgressLoadingUIState(String r5, String r6, String r7, Integer r8, Long r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        Long r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
