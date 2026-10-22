package com.larus.contextwindow.impl.membership.model;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "", "active", "", "endTime", "Lcom/google/gson/JsonElement;", "<init>", "(Ljava/lang/Boolean;Lcom/google/gson/JsonElement;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEndTime", "()Lcom/google/gson/JsonElement;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/google/gson/JsonElement;)Lcom/larus/contextwindow/impl/membership/model/WindowLimitExemptionDto;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLimitExemptionDto {

    @SerializedName("active")
    private final Boolean active;

    @SerializedName("end_time")
    private final JsonElement endTime;

    public WindowLimitExemptionDto() {
        Boolean r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ WindowLimitExemptionDto copy$default(WindowLimitExemptionDto r0, Boolean r1, JsonElement r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.active;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.endTime;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.active;
    }

    public final JsonElement component2() {
        return this.endTime;
    }

    public final WindowLimitExemptionDto copy(Boolean r2, JsonElement r3) {
        return new WindowLimitExemptionDto(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowLimitExemptionDto) == true) goto L8;
        return false;
    L8:
        WindowLimitExemptionDto r6 = (WindowLimitExemptionDto) r5;
        if (Intrinsics.areEqual(this.active, r6.active) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.active;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        JsonElement r4 = this.endTime;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "WindowLimitExemptionDto(active=" + this.active + ", endTime=" + this.endTime + ')';
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final JsonElement getEndTime() {
        return this.endTime;
    }

    public WindowLimitExemptionDto(Boolean r1, JsonElement r2) {
        this.active = r1;
        this.endTime = r2;
    }

    public /* synthetic */ WindowLimitExemptionDto(Boolean r2, JsonElement r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
