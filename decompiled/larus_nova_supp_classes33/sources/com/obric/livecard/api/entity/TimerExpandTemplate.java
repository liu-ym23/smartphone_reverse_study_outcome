package com.obric.livecard.api.entity;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0017\u0010G\u001a\u00020H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010JR,\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b\u0010\u0010/\"\u0004\b5\u00101R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u00106\"\u0004\b7\u00108R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/obric/livecard/api/entity/TimerExpandTemplate;", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "titleIcon", "content", "Lcom/obric/livecard/api/entity/Text;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "timeStyle", "Lcom/obric/livecard/api/entity/TimeStyle;", "current_timestamp", "", "duration", "", "is_auto", "type", "unit", "", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "contentIcon", "is_time_bottom", "", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/util/List;Lcom/obric/livecard/api/entity/TimeStyle;JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Ljava/util/List;Lcom/obric/livecard/api/entity/Icon;Z)V", "getButtonList$annotations", "()V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getContentIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setContentIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getCurrent_timestamp", "()J", "setCurrent_timestamp", "(J)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIcon", "setIcon", "set_auto", "()Z", "set_time_bottom", "(Z)V", "getTimeStyle", "()Lcom/obric/livecard/api/entity/TimeStyle;", "setTimeStyle", "(Lcom/obric/livecard/api/entity/TimeStyle;)V", "getTitleIcon", "setTitleIcon", "getType", "()I", "setType", "(I)V", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerExpandTemplate {
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon contentIcon;
    private long current_timestamp;
    private Integer duration;
    private Icon icon;
    private Integer is_auto;
    private boolean is_time_bottom;
    private TimeStyle timeStyle;
    private Icon titleIcon;
    private int type;
    private String unit;

    @Deprecated(message = "请使用buttonV2List")
    public static /* synthetic */ void getButtonList$annotations() {
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final List<ButtonV2> getButtonV2List() {
        return this.buttonV2List;
    }

    public final Text getContent() {
        return this.content;
    }

    public final Icon getContentIcon() {
        return this.contentIcon;
    }

    public final long getCurrent_timestamp() {
        return this.current_timestamp;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final Integer is_auto() {
        return this.is_auto;
    }

    public final boolean is_time_bottom() {
        return this.is_time_bottom;
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_expand_timer_template", this, r14, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r1) {
        this.buttonList = r1;
    }

    public final void setButtonV2List(List<ButtonV2> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buttonV2List = r2;
    }

    public final void setContent(Text r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setContentIcon(Icon r1) {
        this.contentIcon = r1;
    }

    public final void setCurrent_timestamp(long r1) {
        this.current_timestamp = r1;
    }

    public final void setDuration(Integer r1) {
        this.duration = r1;
    }

    public final void setIcon(Icon r1) {
        this.icon = r1;
    }

    public final void setTimeStyle(TimeStyle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.timeStyle = r2;
    }

    public final void setTitleIcon(Icon r1) {
        this.titleIcon = r1;
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

    public final void set_time_bottom(boolean r1) {
        this.is_time_bottom = r1;
    }

    public static /* synthetic */ IslandWidget create$default(TimerExpandTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Boolean.FALSE;
    L6:
        return r0.create(r1);
    }

    public TimerExpandTemplate(Icon r2, Icon r3, Text r4, List<Button> r5, TimeStyle r6, long r7, Integer r9, Integer r10, int r11, String r12, List<ButtonV2> r13, Icon r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r6, "timeStyle");
        Intrinsics.checkNotNullParameter(r12, "unit");
        Intrinsics.checkNotNullParameter(r13, "buttonV2List");
        this.icon = r2;
        this.titleIcon = r3;
        this.content = r4;
        this.buttonList = r5;
        this.timeStyle = r6;
        this.current_timestamp = r7;
        this.duration = r9;
        this.is_auto = r10;
        this.type = r11;
        this.unit = r12;
        this.buttonV2List = r13;
        this.contentIcon = r14;
        this.is_time_bottom = r15;
    }

    public /* synthetic */ TimerExpandTemplate(Icon r19, Icon r20, Text r21, List r22, TimeStyle r23, long r24, Integer r26, Integer r27, int r28, String r29, List r30, Icon r31, boolean r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        Icon r4 = null;
    L7:
        if ((r33 & 2) == 0) goto L9;
        Icon r5 = null;
    L11:
        if ((r33 & 8) == 0) goto L13;
        List r7 = null;
    L15:
        if ((r33 & 64) == 0) goto L17;
        Integer r11 = null;
    L19:
        if ((r33 & 128) == 0) goto L21;
        Integer r12 = null;
    L23:
        if ((r33 & 1024) == 0) goto L25;
        List r15 = CollectionsKt.emptyList();
    L27:
        if ((r33 & 2048) == 0) goto L29;
        Icon r16 = null;
    L31:
        if ((r33 & 4096) == 0) goto L33;
        boolean r17 = false;
    L34:
        this(r4, r5, r21, r7, r23, r24, r11, r12, r28, r29, r15, r16, r17);
        return;
    L33:
        r17 = r32;
        goto L34
    L29:
        r16 = r31;
        goto L31
    L25:
        r15 = r30;
        goto L27
    L21:
        r12 = r27;
        goto L23
    L17:
        r11 = r26;
        goto L19
    L13:
        r7 = r22;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }
}
