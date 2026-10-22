package com.obric.contactsdk.loader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\u001bH\u0002J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/contactsdk/loader/CallSummary;", "", "summary", "", "items", "", "title", "callAssignment", "Lcom/obric/contactsdk/loader/CallAssignment;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/obric/contactsdk/loader/CallAssignment;)V", "getCallAssignment", "()Lcom/obric/contactsdk/loader/CallAssignment;", "setCallAssignment", "(Lcom/obric/contactsdk/loader/CallAssignment;)V", "getItems", "()Ljava/util/List;", "getSummary", "()Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getSummaryStr", "getTodoListStr", "hashCode", "", "summaryErr", "toString", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallSummary {
    private CallAssignment callAssignment;
    private final List<String> items;
    private final String summary;
    private String title;

    public CallSummary() {
        this(null, null, null, null, 15, null);
    }

    public CallSummary(String r3, List<String> r4, String r5, CallAssignment r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "summary");
        Intrinsics.checkNotNullParameter(r7, "items");
        Intrinsics.checkNotNullParameter(r6, "callAssignment");
        this.summary = r3;
        this.items = r7;
        this.title = r5;
        this.callAssignment = r6;
    }

    public /* synthetic */ CallSummary(String r2, List r3, String r4, CallAssignment r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = CollectionsKt.emptyList();
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = new CallAssignment(null, 1, null);
    L14:
        this(r2, r8, r4, r5);
    }

    public static /* synthetic */ CallSummary copy$default(CallSummary r1, String r2, List r3, String r4, CallAssignment r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.summary;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.items;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.title;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.callAssignment;
    L15:
        return r1.copy(r2, r8, r4, r5);
    }

    private final boolean summaryErr() {
        return Intrinsics.areEqual(this.summary, "通话内容无法总结");
    }

    public final String component1() {
        return this.summary;
    }

    public final List<String> component2() {
        return this.items;
    }

    public final String component3() {
        return this.title;
    }

    public final CallAssignment component4() {
        return this.callAssignment;
    }

    public final CallSummary copy(String r2, List<String> r3, String r4, CallAssignment r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "summary");
        Intrinsics.checkNotNullParameter(r1, "items");
        Intrinsics.checkNotNullParameter(r5, "callAssignment");
        return new CallSummary(r2, r1, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CallSummary.class) == true) goto L8;
        return false;
    L8:
        CallSummary r6 = (CallSummary) ZeusTransformUtils.preCheckCast(r5, CallSummary.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.callAssignment, r6.callAssignment) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final CallAssignment getCallAssignment() {
        return this.callAssignment;
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getSummaryStr() {
        if (summaryErr() == false) goto L6;
        return null;
    L6:
        String r0 = this.summary;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.items, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 1;
    L8:
        if (r6.hasNext() == false) goto L10;
        r0 = r0 + '\n' + r3 + '.' + ((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L8
    L10:
        return r0;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getTodoListStr() {
        List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.callAssignment.getList(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((CallAssignmentData) ZeusTransformUtils.preCheckCast(r4.next(), CallAssignmentData.class, "com.obric.memorydata.plugin")).getSummary());
        goto L4
    L6:
        return r0;
    }

    public int hashCode() {
        int r0 = ((this.summary.hashCode() * 31) + this.items.hashCode()) * 31;
        String r1 = this.title;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.callAssignment.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final void setCallAssignment(CallAssignment r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.callAssignment = r2;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public String toString() {
        return "CallSummary(summary=" + this.summary + ", items=" + this.items + ", title=" + this.title + ", callAssignment=" + this.callAssignment + ')';
    }
}
