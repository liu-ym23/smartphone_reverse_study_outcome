package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b7\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u008a\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001f¨\u0006C"}, d2 = {"Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;", "", "height", "", "width", "icon", "", "loop", "autoplay", "id", "backgroundIcon", "useBorderRadius", "", "iconLight", "dismissKeyguard", "backgroundBorderWidth", "<init>", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getLoop", "()Ljava/lang/Integer;", "setLoop", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAutoplay", "setAutoplay", "getId", "setId", "getBackgroundIcon", "setBackgroundIcon", "getUseBorderRadius", "()Z", "setUseBorderRadius", "(Z)V", "getIconLight", "setIconLight", "getDismissKeyguard", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBackgroundBorderWidth", "setBackgroundBorderWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAINotificationTemplateIcon {
    private Integer autoplay;
    private Integer backgroundBorderWidth;
    private String backgroundIcon;
    private final Boolean dismissKeyguard;
    private int height;
    private String icon;
    private String iconLight;
    private String id;
    private Integer loop;
    private boolean useBorderRadius;
    private int width;

    public static /* synthetic */ ObricAINotificationTemplateIcon copy$default(ObricAINotificationTemplateIcon r12, int r13, int r14, String r15, Integer r16, Integer r17, String r18, String r19, boolean r20, String r21, Boolean r22, Integer r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        int r2 = r12.height;
    L7:
        if ((r24 & 2) == 0) goto L9;
        int r3 = r12.width;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.icon;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = r12.loop;
    L19:
        if ((r24 & 16) == 0) goto L21;
        Integer r6 = r12.autoplay;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.id;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.backgroundIcon;
    L31:
        if ((r24 & 128) == 0) goto L33;
        boolean r9 = r12.useBorderRadius;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.iconLight;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Boolean r11 = r12.dismissKeyguard;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        Integer r1 = r12.backgroundBorderWidth;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final int component1() {
        return this.height;
    }

    public final Boolean component10() {
        return this.dismissKeyguard;
    }

    public final Integer component11() {
        return this.backgroundBorderWidth;
    }

    public final int component2() {
        return this.width;
    }

    public final String component3() {
        return this.icon;
    }

    public final Integer component4() {
        return this.loop;
    }

    public final Integer component5() {
        return this.autoplay;
    }

    public final String component6() {
        return this.id;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final boolean component8() {
        return this.useBorderRadius;
    }

    public final String component9() {
        return this.iconLight;
    }

    public final ObricAINotificationTemplateIcon copy(int r14, int r15, String r16, Integer r17, Integer r18, String r19, String r20, boolean r21, String r22, Boolean r23, Integer r24) {
        Intrinsics.checkNotNullParameter(r16, "icon");
        return new ObricAINotificationTemplateIcon(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAINotificationTemplateIcon) == true) goto L8;
        return false;
    L8:
        ObricAINotificationTemplateIcon r6 = (ObricAINotificationTemplateIcon) r5;
        if (this.height == r6.height) goto L12;
        return false;
    L12:
        if (this.width == r6.width) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.loop, r6.loop) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.autoplay, r6.autoplay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundIcon, r6.backgroundIcon) == true) goto L30;
        return false;
    L30:
        if (this.useBorderRadius == r6.useBorderRadius) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconLight, r6.iconLight) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.backgroundBorderWidth, r6.backgroundBorderWidth) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.height * 31) + this.width) * 31) + this.icon.hashCode()) * 31;
        Integer r1 = this.loop;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.autoplay;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.id;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.backgroundIcon;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        if (this.useBorderRadius == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r13 + r14) * 31;
        String r16 = this.iconLight;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.dismissKeyguard;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.backgroundBorderWidth;
        if (r22 == null) goto L35;
        r2 = r22.hashCode();
    L35:
        return r21 + r2;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = 1237;
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricAINotificationTemplateIcon(height=" + this.height + ", width=" + this.width + ", icon=" + this.icon + ", loop=" + this.loop + ", autoplay=" + this.autoplay + ", id=" + this.id + ", backgroundIcon=" + this.backgroundIcon + ", useBorderRadius=" + this.useBorderRadius + ", iconLight=" + this.iconLight + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundBorderWidth=" + this.backgroundBorderWidth + ')';
    }

    public final Integer getAutoplay() {
        return this.autoplay;
    }

    public final Integer getBackgroundBorderWidth() {
        return this.backgroundBorderWidth;
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconLight() {
        return this.iconLight;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getLoop() {
        return this.loop;
    }

    public final boolean getUseBorderRadius() {
        return this.useBorderRadius;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setAutoplay(Integer r1) {
        this.autoplay = r1;
    }

    public final void setBackgroundBorderWidth(Integer r1) {
        this.backgroundBorderWidth = r1;
    }

    public final void setBackgroundIcon(String r1) {
        this.backgroundIcon = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setIcon(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.icon = r2;
    }

    public final void setIconLight(String r1) {
        this.iconLight = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setLoop(Integer r1) {
        this.loop = r1;
    }

    public final void setUseBorderRadius(boolean r1) {
        this.useBorderRadius = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public ObricAINotificationTemplateIcon(int r2, int r3, String r4, Integer r5, Integer r6, String r7, String r8, boolean r9, String r10, Boolean r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r4, "icon");
        this.height = r2;
        this.width = r3;
        this.icon = r4;
        this.loop = r5;
        this.autoplay = r6;
        this.id = r7;
        this.backgroundIcon = r8;
        this.useBorderRadius = r9;
        this.iconLight = r10;
        this.dismissKeyguard = r11;
        this.backgroundBorderWidth = r12;
    }

    public /* synthetic */ ObricAINotificationTemplateIcon(int r16, int r17, String r18, Integer r19, Integer r20, String r21, String r22, boolean r23, String r24, Boolean r25, Integer r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 8) == 0) goto L5;
        Integer r7 = null;
    L7:
        if ((r27 & 16) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r27 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r27 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r27 & 128) == 0) goto L21;
        boolean r11 = true;
    L23:
        if ((r27 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r27 & 512) == 0) goto L29;
        Boolean r13 = Boolean.TRUE;
    L31:
        if ((r27 & 1024) == 0) goto L33;
        Integer r14 = null;
    L34:
        this(r16, r17, r18, r7, r8, r9, r10, r11, r12, r13, r14);
        return;
    L33:
        r14 = r26;
        goto L34
    L29:
        r13 = r25;
        goto L31
    L25:
        r12 = r24;
        goto L27
    L21:
        r11 = r23;
        goto L23
    L17:
        r10 = r22;
        goto L19
    L13:
        r9 = r21;
        goto L15
    L9:
        r8 = r20;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }
}
