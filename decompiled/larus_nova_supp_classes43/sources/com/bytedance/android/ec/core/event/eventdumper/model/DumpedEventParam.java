package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedEventParam;", "Ljava/io/Serializable;", "paramValue", "", "isFromEventContext", "", "eventContextClassInfo", "Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "(Ljava/lang/String;ZLcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;)V", "getEventContextClassInfo", "()Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "setEventContextClassInfo", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;)V", "()Z", "setFromEventContext", "(Z)V", "getParamValue", "()Ljava/lang/String;", "setParamValue", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedEventParam implements Serializable {

    @SerializedName("event_context_class_info")
    private ClassInfo eventContextClassInfo;

    @SerializedName("is_from_context")
    private boolean isFromEventContext;

    @SerializedName("param_value")
    private String paramValue;

    public DumpedEventParam() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ DumpedEventParam copy$default(DumpedEventParam r0, String r1, boolean r10, ClassInfo r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.paramValue;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.isFromEventContext;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.eventContextClassInfo;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.paramValue;
    }

    public final boolean component2() {
        return this.isFromEventContext;
    }

    public final ClassInfo component3() {
        return this.eventContextClassInfo;
    }

    public final DumpedEventParam copy(String r10, boolean r11, ClassInfo r12) {
        return new DumpedEventParam(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof DumpedEventParam) == false) goto L12;
        DumpedEventParam r11 = (DumpedEventParam) r10;
        if (Intrinsics.areEqual(this.paramValue, r11.paramValue) == true) goto L8;
        return false;
    L8:
        if (this.isFromEventContext == r11.isFromEventContext) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventContextClassInfo, r11.eventContextClassInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        String r0 = this.paramValue;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.isFromEventContext;
        ?? r13 = r12;
        if (r12 == false) goto L9;
        r13 = 1;
    L9:
        int r14 = (r11 + r13) * 31;
        ClassInfo r15 = this.eventContextClassInfo;
        if (r15 == null) goto L13;
        r1 = r15.hashCode();
    L13:
        return r14 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "DumpedEventParam(paramValue=" + this.paramValue + ", isFromEventContext=" + this.isFromEventContext + ", eventContextClassInfo=" + this.eventContextClassInfo + ")";
    }

    public final ClassInfo getEventContextClassInfo() {
        return this.eventContextClassInfo;
    }

    public final String getParamValue() {
        return this.paramValue;
    }

    public final boolean isFromEventContext() {
        return this.isFromEventContext;
    }

    public final void setEventContextClassInfo(ClassInfo r1) {
        this.eventContextClassInfo = r1;
    }

    public final void setFromEventContext(boolean r1) {
        this.isFromEventContext = r1;
    }

    public final void setParamValue(String r1) {
        this.paramValue = r1;
    }

    public DumpedEventParam(String r1, boolean r10, ClassInfo r11) {
        this.paramValue = r1;
        this.isFromEventContext = r10;
        this.eventContextClassInfo = r11;
    }

    public /* synthetic */ DumpedEventParam(String r10, boolean r11, ClassInfo r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
