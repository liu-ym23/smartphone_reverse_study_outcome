package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeCallSceneConfig;", "Ljava/io/Serializable;", "autoCloseDurationSecond", "", "autoOpenCountTimes", "", "useSpringSceneIcon", "", "springSceneTitle", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAutoCloseDurationSecond", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAutoOpenCountTimes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUseSpringSceneIcon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSpringSceneTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/platform/model/audio/RealtimeCallSceneConfig;", "equals", "other", "", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RealtimeCallSceneConfig implements Serializable {
    public static final a Companion = null;
    private static final RealtimeCallSceneConfig DEFAULT = null;

    @SerializedName("scene_panel_display_duration")
    private final Double autoCloseDurationSecond;

    @SerializedName("auto_show_scene_panel_count")
    private final Long autoOpenCountTimes;

    @SerializedName("use_spring_scene_title")
    private final String springSceneTitle;

    @SerializedName("use_spring_scene_icon")
    private final Boolean useSpringSceneIcon;

    public static final class a {
        public a() {
        }
    }

    public RealtimeCallSceneConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RealtimeCallSceneConfig copy$default(RealtimeCallSceneConfig r0, Double r1, Long r2, Boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.autoCloseDurationSecond;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.autoOpenCountTimes;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.useSpringSceneIcon;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.springSceneTitle;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Double component1() {
        return this.autoCloseDurationSecond;
    }

    public final Long component2() {
        return this.autoOpenCountTimes;
    }

    public final Boolean component3() {
        return this.useSpringSceneIcon;
    }

    public final String component4() {
        return this.springSceneTitle;
    }

    public final RealtimeCallSceneConfig copy(Double r2, Long r3, Boolean r4, String r5) {
        return new RealtimeCallSceneConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RealtimeCallSceneConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallSceneConfig r6 = (RealtimeCallSceneConfig) r5;
        if (Intrinsics.areEqual(this.autoCloseDurationSecond, r6.autoCloseDurationSecond) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.autoOpenCountTimes, r6.autoOpenCountTimes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.useSpringSceneIcon, r6.useSpringSceneIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.springSceneTitle, r6.springSceneTitle) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Double r0 = this.autoCloseDurationSecond;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.autoOpenCountTimes;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.useSpringSceneIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.springSceneTitle;
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
        return "RealtimeCallSceneConfig(autoCloseDurationSecond=" + this.autoCloseDurationSecond + ", autoOpenCountTimes=" + this.autoOpenCountTimes + ", useSpringSceneIcon=" + this.useSpringSceneIcon + ", springSceneTitle=" + this.springSceneTitle + ')';
    }

    static {
        Companion = new a();
        DEFAULT = new RealtimeCallSceneConfig(null, null, null, null, 15, null);
    }

    public static final /* synthetic */ RealtimeCallSceneConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Double getAutoCloseDurationSecond() {
        return this.autoCloseDurationSecond;
    }

    public final Long getAutoOpenCountTimes() {
        return this.autoOpenCountTimes;
    }

    public final String getSpringSceneTitle() {
        return this.springSceneTitle;
    }

    public final Boolean getUseSpringSceneIcon() {
        return this.useSpringSceneIcon;
    }

    public RealtimeCallSceneConfig(Double r1, Long r2, Boolean r3, String r4) {
        this.autoCloseDurationSecond = r1;
        this.autoOpenCountTimes = r2;
        this.useSpringSceneIcon = r3;
        this.springSceneTitle = r4;
    }

    public /* synthetic */ RealtimeCallSceneConfig(Double r2, Long r3, Boolean r4, String r5, int r6, DefaultConstructorMarker r7) {
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
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
