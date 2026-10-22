package com.larus.dora.impl.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "", "notificationSummary", "", "proactiveMessage", "<init>", "(ZZ)V", "getNotificationSummary", "()Z", "getProactiveMessage", "toString", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraPushSummaryConfig {

    @SerializedName("notification_summary")
    private final boolean notificationSummary;

    @SerializedName("proactive_message")
    private final boolean proactiveMessage;

    public DoraPushSummaryConfig() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ DoraPushSummaryConfig copy$default(DoraPushSummaryConfig r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.notificationSummary;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.proactiveMessage;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.notificationSummary;
    }

    public final boolean component2() {
        return this.proactiveMessage;
    }

    public final DoraPushSummaryConfig copy(boolean r2, boolean r3) {
        return new DoraPushSummaryConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraPushSummaryConfig) == true) goto L8;
        return false;
    L8:
        DoraPushSummaryConfig r6 = (DoraPushSummaryConfig) r5;
        if (this.notificationSummary == r6.notificationSummary) goto L12;
        return false;
    L12:
        if (this.proactiveMessage == r6.proactiveMessage) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.notificationSummary == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.proactiveMessage == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "DoraPushSummaryConfig(notificationSummary=" + this.notificationSummary + ", proactiveMessage=" + this.proactiveMessage + ')';
    }

    public final boolean getNotificationSummary() {
        return this.notificationSummary;
    }

    public final boolean getProactiveMessage() {
        return this.proactiveMessage;
    }

    public DoraPushSummaryConfig(boolean r1, boolean r2) {
        this.notificationSummary = r1;
        this.proactiveMessage = r2;
    }

    public /* synthetic */ DoraPushSummaryConfig(boolean r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}
