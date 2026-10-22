package com.obric.livecard.api.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.dumper.Scraps;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\u0017\u0010G\u001a\u00020H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010JR,\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b\u0010\u0010/\"\u0004\b5\u00101R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u00106\"\u0004\b7\u00108R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006K"}, d2 = {"Lcom/obric/livecard/api/entity/TimerExpandTemplate;", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "titleIcon", Params.CONTENT, "Lcom/obric/livecard/api/entity/Text;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "timeStyle", "Lcom/obric/livecard/api/entity/TimeStyle;", "current_timestamp", "", "duration", "", "is_auto", "type", Scraps.INNER_UNIT, "", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "contentIcon", "is_time_bottom", "", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/util/List;Lcom/obric/livecard/api/entity/TimeStyle;JLjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Ljava/util/List;Lcom/obric/livecard/api/entity/Icon;Z)V", "getButtonList$annotations", "()V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getContentIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setContentIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getCurrent_timestamp", "()J", "setCurrent_timestamp", "(J)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIcon", "setIcon", "set_auto", "()Z", "set_time_bottom", "(Z)V", "getTimeStyle", "()Lcom/obric/livecard/api/entity/TimeStyle;", "setTimeStyle", "(Lcom/obric/livecard/api/entity/TimeStyle;)V", "getTitleIcon", "setTitleIcon", "getType", "()I", "setType", "(I)V", "getUnit", "()Ljava/lang/String;", "setUnit", "(Ljava/lang/String;)V", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public TimerExpandTemplate(Icon r9, Icon r10, Text r11, List<Button> r12, TimeStyle r13, long r14, Integer r16, Integer r17, int r18, String r19, List<ButtonV2> r20, Icon r21, boolean r22) {
        List<Button> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List<ButtonV2> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r13, "timeStyle");
        Intrinsics.checkNotNullParameter(r19, Scraps.INNER_UNIT);
        Intrinsics.checkNotNullParameter(r5, "buttonV2List");
        this.icon = r9;
        this.titleIcon = r10;
        this.content = r11;
        this.buttonList = r4;
        this.timeStyle = r13;
        this.current_timestamp = r14;
        this.duration = r16;
        this.is_auto = r17;
        this.type = r18;
        this.unit = r19;
        this.buttonV2List = r5;
        this.contentIcon = r21;
        this.is_time_bottom = r22;
    }

    public /* synthetic */ TimerExpandTemplate(Icon r21, Icon r22, Text r23, List r24, TimeStyle r25, long r26, Integer r28, Integer r29, int r30, String r31, List r32, Icon r33, boolean r34, int r35, DefaultConstructorMarker r36) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        if ((r35 & 1) == 0) goto L5;
        Icon r6 = null;
    L7:
        if ((r35 & 2) == 0) goto L9;
        Icon r7 = null;
    L11:
        if ((r35 & 8) == 0) goto L13;
        List r9 = null;
    L15:
        if ((r35 & 64) == 0) goto L17;
        Integer r13 = null;
    L19:
        if ((r35 & 128) == 0) goto L21;
        Integer r14 = null;
    L23:
        if ((r35 & 1024) == 0) goto L25;
        r2 = CollectionsKt.emptyList();
    L25:
        List r17 = r2;
        if ((r35 & 2048) == 0) goto L28;
        Icon r18 = null;
    L30:
        if ((r35 & 4096) == 0) goto L32;
        boolean r19 = false;
    L33:
        this(r6, r7, r23, r9, r25, r26, r13, r14, r30, r31, r17, r18, r19);
        return;
    L32:
        r19 = r34;
        goto L33
    L28:
        r18 = r33;
        goto L30
    L21:
        r14 = r29;
        goto L23
    L17:
        r13 = r28;
        goto L19
    L13:
        r9 = r1;
        goto L15
    L9:
        r7 = r22;
        goto L11
    L5:
        r6 = r21;
        goto L7
    }

    public static /* synthetic */ IslandWidget create$default(TimerExpandTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    @Deprecated(message = "请使用buttonV2List")
    public static /* synthetic */ void getButtonList$annotations() {
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_expand_timer_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
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

    public final void setButtonList(List<Button> r3) {
        this.buttonList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setButtonV2List(List<ButtonV2> r3) {
        List<ButtonV2> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.buttonV2List = r4;
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
}
