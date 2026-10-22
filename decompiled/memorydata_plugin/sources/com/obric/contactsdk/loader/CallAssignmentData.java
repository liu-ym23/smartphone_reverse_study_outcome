package com.obric.contactsdk.loader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/contactsdk/loader/CallAssignmentData;", "", "summary", "", "deadline", "", "significance", "", "keys", "", "(Ljava/lang/String;JILjava/util/List;)V", "getDeadline", "()J", "getKeys", "()Ljava/util/List;", "getSignificance", "()I", "getSummary", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallAssignmentData {
    private final long deadline;
    private final List<String> keys;
    private final int significance;
    private final String summary;

    public CallAssignmentData(String r3, long r4, int r6, List<String> r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "summary");
        Intrinsics.checkNotNullParameter(r8, "keys");
        this.summary = r3;
        this.deadline = r4;
        this.significance = r6;
        this.keys = r8;
    }

    public /* synthetic */ CallAssignmentData(String r7, long r8, int r10, List r11, int r12, DefaultConstructorMarker r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        r14 = CollectionsKt.emptyList();
    L5:
        this(r7, r8, r10, r14);
    }

    public static /* synthetic */ CallAssignmentData copy$default(CallAssignmentData r6, String r7, long r8, int r10, List r11, int r12, Object r13) {
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.summary;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.deadline;
    L8:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.significance;
    L11:
        int r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r14 = r6.keys;
    L15:
        return r6.copy(r1, r2, r4, r14);
    }

    public final String component1() {
        return this.summary;
    }

    public final long component2() {
        return this.deadline;
    }

    public final int component3() {
        return this.significance;
    }

    public final List<String> component4() {
        return this.keys;
    }

    public final CallAssignmentData copy(String r7, long r8, int r10, List<String> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "summary");
        Intrinsics.checkNotNullParameter(r5, "keys");
        return new CallAssignmentData(r7, r8, r10, r5);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, CallAssignmentData.class) == true) goto L8;
        return false;
    L8:
        CallAssignmentData r10 = (CallAssignmentData) ZeusTransformUtils.preCheckCast(r9, CallAssignmentData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.summary, r10.summary) == true) goto L12;
        return false;
    L12:
        if (this.deadline == r10.deadline) goto L15;
        return false;
    L15:
        if (this.significance == r10.significance) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.keys, r10.keys) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getDeadline() {
        return this.deadline;
    }

    public final List<String> getKeys() {
        return this.keys;
    }

    public final int getSignificance() {
        return this.significance;
    }

    public final String getSummary() {
        return this.summary;
    }

    public int hashCode() {
        return (((((this.summary.hashCode() * 31) + Long.hashCode(this.deadline)) * 31) + Integer.hashCode(this.significance)) * 31) + this.keys.hashCode();
    }

    public String toString() {
        return "CallAssignmentData(summary=" + this.summary + ", deadline=" + this.deadline + ", significance=" + this.significance + ", keys=" + this.keys + ')';
    }
}
