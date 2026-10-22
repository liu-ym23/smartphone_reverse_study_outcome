package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistData;", "", "allowed", "", "reason", "", "<init>", "(ZI)V", "getAllowed", "()Z", "getReason", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IsInAppWhitelistData {
    private final boolean allowed;
    private final int reason;

    /* JADX WARN: Multi-variable type inference failed */
    public IsInAppWhitelistData() {
        boolean r5 = false;
        Object[] r10 = 0 == true ? 1 : 0;
        this(r5, r10, 3, null);
    }

    public static /* synthetic */ IsInAppWhitelistData copy$default(IsInAppWhitelistData r5, boolean r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.allowed;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.reason;
    L9:
        return r5.copy(r10, r11);
    }

    public final boolean component1() {
        return this.allowed;
    }

    public final int component2() {
        return this.reason;
    }

    public final IsInAppWhitelistData copy(boolean r5, int r10) {
        return new IsInAppWhitelistData(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IsInAppWhitelistData) == true) goto L8;
        return false;
    L8:
        IsInAppWhitelistData r10 = (IsInAppWhitelistData) r5;
        if (this.allowed == r10.allowed) goto L12;
        return false;
    L12:
        if (this.reason == r10.reason) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean getAllowed() {
        return this.allowed;
    }

    public final int getReason() {
        return this.reason;
    }

    public int hashCode() {
        int r5 = Boolean.hashCode(this.allowed) * 31;
        return Integer.hashCode(this.reason) + r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("IsInAppWhitelistData(allowed=");
        r5.append(this.allowed);
        r5.append(", reason=");
        return j0.n(r5, this.reason, ')');
    }

    public IsInAppWhitelistData(boolean r5, int r10) {
        this.allowed = r5;
        this.reason = r10;
    }

    public /* synthetic */ IsInAppWhitelistData(boolean r5, int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = 0;
    L8:
        this(r5, r10);
    }
}
