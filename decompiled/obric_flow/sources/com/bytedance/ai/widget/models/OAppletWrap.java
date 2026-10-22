package com.bytedance.ai.widget.models;

import androidx.constraintlayout.motion.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/widget/models/OAppletWrap;", "", "groupName", "", "monitorEnable", "", "<init>", "(Ljava/lang/String;Z)V", "getGroupName", "()Ljava/lang/String;", "getMonitorEnable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OAppletWrap {
    private final String groupName;
    private final boolean monitorEnable;

    /* JADX WARN: Multi-variable type inference failed */
    public OAppletWrap() {
        String r5 = null;
        this(r5, false, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OAppletWrap copy$default(OAppletWrap r5, String r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.groupName;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.monitorEnable;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.groupName;
    }

    public final boolean component2() {
        return this.monitorEnable;
    }

    public final OAppletWrap copy(String r5, boolean r10) {
        return new OAppletWrap(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OAppletWrap) == true) goto L8;
        return false;
    L8:
        OAppletWrap r10 = (OAppletWrap) r5;
        if (Intrinsics.areEqual(this.groupName, r10.groupName) == true) goto L12;
        return false;
    L12:
        if (this.monitorEnable == r10.monitorEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final boolean getMonitorEnable() {
        return this.monitorEnable;
    }

    public int hashCode() {
        String r5 = this.groupName;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = Boolean.hashCode(this.monitorEnable);
        return r11 + (r10 * 31);
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("OAppletWrap(groupName=");
        r5.append(this.groupName);
        r5.append(", monitorEnable=");
        return a.w(r5, this.monitorEnable, ')');
    }

    public OAppletWrap(String r5, boolean r10) {
        this.groupName = r5;
        this.monitorEnable = r10;
    }

    public /* synthetic */ OAppletWrap(String r5, boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = true;
    L8:
        this(r5, r10);
    }
}
