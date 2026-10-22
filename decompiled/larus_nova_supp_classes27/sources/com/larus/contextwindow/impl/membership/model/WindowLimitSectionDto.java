package com.larus.contextwindow.impl.membership.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;", "", "usageExhausted", "", "windowLimitGroups", "", "Lcom/larus/contextwindow/impl/membership/model/WindowLimitGroupDto;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getUsageExhausted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getWindowLimitGroups", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/contextwindow/impl/membership/model/WindowLimitSectionDto;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowLimitSectionDto {

    @SerializedName("usage_exhausted")
    private final Boolean usageExhausted;

    @SerializedName("window_limit_groups")
    private final List<WindowLimitGroupDto> windowLimitGroups;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowLimitSectionDto() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WindowLimitSectionDto copy$default(WindowLimitSectionDto r0, Boolean r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.usageExhausted;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.windowLimitGroups;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.usageExhausted;
    }

    public final List<WindowLimitGroupDto> component2() {
        return this.windowLimitGroups;
    }

    public final WindowLimitSectionDto copy(Boolean r2, List<WindowLimitGroupDto> r3) {
        return new WindowLimitSectionDto(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowLimitSectionDto) == true) goto L8;
        return false;
    L8:
        WindowLimitSectionDto r6 = (WindowLimitSectionDto) r5;
        if (Intrinsics.areEqual(this.usageExhausted, r6.usageExhausted) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowLimitGroups, r6.windowLimitGroups) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.usageExhausted;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<WindowLimitGroupDto> r4 = this.windowLimitGroups;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "WindowLimitSectionDto(usageExhausted=" + this.usageExhausted + ", windowLimitGroups=" + this.windowLimitGroups + ')';
    }

    public final Boolean getUsageExhausted() {
        return this.usageExhausted;
    }

    public final List<WindowLimitGroupDto> getWindowLimitGroups() {
        return this.windowLimitGroups;
    }

    public WindowLimitSectionDto(Boolean r1, List<WindowLimitGroupDto> r2) {
        this.usageExhausted = r1;
        this.windowLimitGroups = r2;
    }

    public /* synthetic */ WindowLimitSectionDto(Boolean r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
