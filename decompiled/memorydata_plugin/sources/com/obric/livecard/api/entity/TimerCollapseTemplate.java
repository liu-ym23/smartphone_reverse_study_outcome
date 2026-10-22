package com.obric.livecard.api.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003JX\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u00101J\u0017\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000105¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002052\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0005HÖ\u0001J\t\u0010:\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0006\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/obric/livecard/api/entity/TimerCollapseTemplate;", "", "current_timestamp", "", "duration", "", "is_auto", "type", Scraps.INNER_UNIT, "", "startIcon", "Lcom/obric/livecard/api/entity/Icon;", "timeStyle", "Lcom/obric/livecard/api/entity/TimeStyle;", "(JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/TimeStyle;)V", "getCurrent_timestamp", "()J", "setCurrent_timestamp", "(J)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "set_auto", "getStartIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setStartIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getTimeStyle", "()Lcom/obric/livecard/api/entity/TimeStyle;", "setTimeStyle", "(Lcom/obric/livecard/api/entity/TimeStyle;)V", "getType", "()I", "setType", "(I)V", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/TimeStyle;)Lcom/obric/livecard/api/entity/TimerCollapseTemplate;", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerCollapseTemplate {
    private long current_timestamp;
    private Integer duration;
    private Integer is_auto;
    private Icon startIcon;
    private TimeStyle timeStyle;
    private int type;
    private String unit;

    public TimerCollapseTemplate(long r2, Integer r4, Integer r5, int r6, String r7, Icon r8, TimeStyle r9) {
        Intrinsics.checkNotNullParameter(r7, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r8, "startIcon");
        Intrinsics.checkNotNullParameter(r9, "timeStyle");
        this.current_timestamp = r2;
        this.duration = r4;
        this.is_auto = r5;
        this.type = r6;
        this.unit = r7;
        this.startIcon = r8;
        this.timeStyle = r9;
    }

    public /* synthetic */ TimerCollapseTemplate(long r12, Integer r14, Integer r15, int r16, String r17, Icon r18, TimeStyle r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 2) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        Integer r6 = null;
    L10:
        this(r12, r5, r6, r16, r17, r18, r19);
        return;
    L9:
        r6 = r15;
        goto L10
    L5:
        r5 = r14;
        goto L7
    }

    public static /* synthetic */ TimerCollapseTemplate copy$default(TimerCollapseTemplate r9, long r10, Integer r12, Integer r13, int r14, String r15, Icon r16, TimeStyle r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.current_timestamp;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Integer r3 = r9.duration;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Integer r4 = r9.is_auto;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.type;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.unit;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Icon r7 = r9.startIcon;
    L27:
        if ((r18 & 64) == 0) goto L29;
        TimeStyle r8 = r9.timeStyle;
    L31:
        return r9.copy(r1, r3, r4, r5, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public static /* synthetic */ IslandWidget create$default(TimerCollapseTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final long component1() {
        return this.current_timestamp;
    }

    public final Integer component2() {
        return this.duration;
    }

    public final Integer component3() {
        return this.is_auto;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.unit;
    }

    public final Icon component6() {
        return this.startIcon;
    }

    public final TimeStyle component7() {
        return this.timeStyle;
    }

    public final TimerCollapseTemplate copy(long r11, Integer r13, Integer r14, int r15, String r16, Icon r17, TimeStyle r18) {
        Intrinsics.checkNotNullParameter(r16, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r17, "startIcon");
        Intrinsics.checkNotNullParameter(r18, "timeStyle");
        return new TimerCollapseTemplate(r11, r13, r14, r15, r16, r17, r18);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_collapse_timer_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimerCollapseTemplate.class) == true) goto L8;
        return false;
    L8:
        TimerCollapseTemplate r10 = (TimerCollapseTemplate) ZeusTransformUtils.preCheckCast(r9, TimerCollapseTemplate.class, "com.obric.memorydata.plugin");
        if (this.current_timestamp == r10.current_timestamp) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r10.duration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.is_auto, r10.is_auto) == true) goto L18;
        return false;
    L18:
        if (this.type == r10.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.unit, r10.unit) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.startIcon, r10.startIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeStyle, r10.timeStyle) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final long getCurrent_timestamp() {
        return this.current_timestamp;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Icon getStartIcon() {
        return this.startIcon;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.current_timestamp) * 31;
        Integer r1 = this.duration;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.is_auto;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((r4 + r2) * 31) + Integer.hashCode(this.type)) * 31) + this.unit.hashCode()) * 31) + this.startIcon.hashCode()) * 31) + this.timeStyle.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final Integer is_auto() {
        return this.is_auto;
    }

    public final void setCurrent_timestamp(long r1) {
        this.current_timestamp = r1;
    }

    public final void setDuration(Integer r1) {
        this.duration = r1;
    }

    public final void setStartIcon(Icon r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startIcon = r2;
    }

    public final void setTimeStyle(TimeStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timeStyle = r2;
    }

    public final void setType(int r1) {
        this.type = r1;
    }

    public final void setUnit(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.unit = r2;
    }

    public final void set_auto(Integer r1) {
        this.is_auto = r1;
    }

    public String toString() {
        return "TimerCollapseTemplate(current_timestamp=" + this.current_timestamp + ", duration=" + this.duration + ", is_auto=" + this.is_auto + ", type=" + this.type + ", unit=" + this.unit + ", startIcon=" + this.startIcon + ", timeStyle=" + this.timeStyle + ')';
    }
}
