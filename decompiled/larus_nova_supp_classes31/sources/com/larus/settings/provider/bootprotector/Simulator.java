package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003JF\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/settings/provider/bootprotector/Simulator;", "", "crashType", "", "injectTiming", "triggerDurationSec", "", "dirtyDataList", "", "Lcom/larus/settings/provider/bootprotector/DirtyData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getCrashType", "()Ljava/lang/String;", "getInjectTiming", "getTriggerDurationSec", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDirtyDataList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/settings/provider/bootprotector/Simulator;", "equals", "", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class Simulator {

    @SerializedName("crash_type")
    private final String crashType;

    @SerializedName("dirty_data_list")
    private final List<DirtyData> dirtyDataList;

    @SerializedName("inject_timing")
    private final String injectTiming;

    @SerializedName("trigger_duration_sec")
    private final Integer triggerDurationSec;

    public Simulator() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Simulator copy$default(Simulator r0, String r1, String r2, Integer r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.crashType;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.injectTiming;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.triggerDurationSec;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.dirtyDataList;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.crashType;
    }

    public final String component2() {
        return this.injectTiming;
    }

    public final Integer component3() {
        return this.triggerDurationSec;
    }

    public final List<DirtyData> component4() {
        return this.dirtyDataList;
    }

    public final Simulator copy(String r2, String r3, Integer r4, List<DirtyData> r5) {
        return new Simulator(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Simulator) == true) goto L8;
        return false;
    L8:
        Simulator r6 = (Simulator) r5;
        if (Intrinsics.areEqual(this.crashType, r6.crashType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.injectTiming, r6.injectTiming) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.triggerDurationSec, r6.triggerDurationSec) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dirtyDataList, r6.dirtyDataList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.crashType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.injectTiming;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.triggerDurationSec;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<DirtyData> r10 = this.dirtyDataList;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "Simulator(crashType=" + this.crashType + ", injectTiming=" + this.injectTiming + ", triggerDurationSec=" + this.triggerDurationSec + ", dirtyDataList=" + this.dirtyDataList + ')';
    }

    public final String getCrashType() {
        return this.crashType;
    }

    public final List<DirtyData> getDirtyDataList() {
        return this.dirtyDataList;
    }

    public final String getInjectTiming() {
        return this.injectTiming;
    }

    public final Integer getTriggerDurationSec() {
        return this.triggerDurationSec;
    }

    public Simulator(String r1, String r2, Integer r3, List<DirtyData> r4) {
        this.crashType = r1;
        this.injectTiming = r2;
        this.triggerDurationSec = r3;
        this.dirtyDataList = r4;
    }

    public /* synthetic */ Simulator(String r2, String r3, Integer r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = CollectionsKt.emptyList();
    L14:
        this(r2, r3, r4, r5);
    }
}
