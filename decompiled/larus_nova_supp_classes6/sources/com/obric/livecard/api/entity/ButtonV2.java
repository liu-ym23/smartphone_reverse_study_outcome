package com.obric.livecard.api.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0092\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%¨\u0006F"}, d2 = {"Lcom/obric/livecard/api/entity/ButtonV2;", "", "icon", "", "text", "Lcom/obric/livecard/api/entity/Text;", "height", "", "width", "id", "dismissKeyguard", "", "backgroundIcon", "iconLight", "foregroundColor", "Lcom/obric/livecard/api/entity/ColorToken;", "backgroundColor", "verification", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;Lcom/obric/livecard/api/entity/ColorToken;Ljava/lang/Boolean;)V", "getBackgroundColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setBackgroundColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "getBackgroundIcon", "()Ljava/lang/String;", "setBackgroundIcon", "(Ljava/lang/String;)V", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getForegroundColor", "setForegroundColor", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIcon", "setIcon", "getIconLight", "setIconLight", "getId", "setId", "getText", "()Lcom/obric/livecard/api/entity/Text;", "setText", "(Lcom/obric/livecard/api/entity/Text;)V", "getVerification", "setVerification", "getWidth", "setWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;Lcom/obric/livecard/api/entity/ColorToken;Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/ButtonV2;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ButtonV2 {
    private ColorToken backgroundColor;
    private String backgroundIcon;
    private Boolean dismissKeyguard;
    private ColorToken foregroundColor;
    private Integer height;
    private String icon;
    private String iconLight;
    private String id;
    private Text text;
    private Boolean verification;
    private Integer width;

    public ButtonV2() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ ButtonV2 copy$default(ButtonV2 r12, String r13, Text r14, Integer r15, Integer r16, String r17, Boolean r18, String r19, String r20, ColorToken r21, ColorToken r22, Boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.icon;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Text r3 = r12.text;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = r12.height;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = r12.width;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.id;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Boolean r7 = r12.dismissKeyguard;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.backgroundIcon;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.iconLight;
    L35:
        if ((r24 & ISmModel.VERSION_0100) == 0) goto L37;
        ColorToken r10 = r12.foregroundColor;
    L39:
        if ((r24 & ISmModel.VERSION_0200) == 0) goto L41;
        ColorToken r11 = r12.backgroundColor;
    L43:
        if ((r24 & ISmModel.VERSION_0400) == 0) goto L45;
        Boolean r1 = r12.verification;
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

    public final String component1() {
        return this.icon;
    }

    public final ColorToken component10() {
        return this.backgroundColor;
    }

    public final Boolean component11() {
        return this.verification;
    }

    public final Text component2() {
        return this.text;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Integer component4() {
        return this.width;
    }

    public final String component5() {
        return this.id;
    }

    public final Boolean component6() {
        return this.dismissKeyguard;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final String component8() {
        return this.iconLight;
    }

    public final ColorToken component9() {
        return this.foregroundColor;
    }

    public final ButtonV2 copy(String r14, Text r15, Integer r16, Integer r17, String r18, Boolean r19, String r20, String r21, ColorToken r22, ColorToken r23, Boolean r24) {
        return new ButtonV2(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ButtonV2) == true) goto L8;
        return false;
    L8:
        ButtonV2 r6 = (ButtonV2) r5;
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.width, r6.width) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundIcon, r6.backgroundIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.iconLight, r6.iconLight) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.foregroundColor, r6.foregroundColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.verification, r6.verification) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        String r0 = this.icon;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Text r4 = this.text;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.height;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.width;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.id;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.dismissKeyguard;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.backgroundIcon;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.iconLight;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        ColorToken r25 = this.foregroundColor;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        ColorToken r28 = this.backgroundColor;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.verification;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "ButtonV2(icon=" + this.icon + ", text=" + this.text + ", height=" + this.height + ", width=" + this.width + ", id=" + this.id + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundIcon=" + this.backgroundIcon + ", iconLight=" + this.iconLight + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", verification=" + this.verification + ')';
    }

    public final ColorToken getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final ColorToken getForegroundColor() {
        return this.foregroundColor;
    }

    public final Integer getHeight() {
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

    public final Text getText() {
        return this.text;
    }

    public final Boolean getVerification() {
        return this.verification;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setBackgroundColor(ColorToken r1) {
        this.backgroundColor = r1;
    }

    public final void setBackgroundIcon(String r1) {
        this.backgroundIcon = r1;
    }

    public final void setDismissKeyguard(Boolean r1) {
        this.dismissKeyguard = r1;
    }

    public final void setForegroundColor(ColorToken r1) {
        this.foregroundColor = r1;
    }

    public final void setHeight(Integer r1) {
        this.height = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setIconLight(String r1) {
        this.iconLight = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setText(Text r1) {
        this.text = r1;
    }

    public final void setVerification(Boolean r1) {
        this.verification = r1;
    }

    public final void setWidth(Integer r1) {
        this.width = r1;
    }

    public ButtonV2(String r1, Text r2, Integer r3, Integer r4, String r5, Boolean r6, String r7, String r8, ColorToken r9, ColorToken r10, Boolean r11) {
        this.icon = r1;
        this.text = r2;
        this.height = r3;
        this.width = r4;
        this.id = r5;
        this.dismissKeyguard = r6;
        this.backgroundIcon = r7;
        this.iconLight = r8;
        this.foregroundColor = r9;
        this.backgroundColor = r10;
        this.verification = r11;
    }

    public /* synthetic */ ButtonV2(String r13, Text r14, Integer r15, Integer r16, String r17, Boolean r18, String r19, String r20, ColorToken r21, ColorToken r22, Boolean r23, int r24, DefaultConstructorMarker r25) {
        Boolean r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        Text r3 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r24 & 8) == 0) goto L17;
        Integer r5 = null;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r24 & ISmModel.VERSION_0100) == 0) goto L37;
        ColorToken r10 = null;
    L39:
        if ((r24 & ISmModel.VERSION_0200) == 0) goto L41;
        ColorToken r11 = null;
    L43:
        if ((r24 & ISmModel.VERSION_0400) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
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
        r1 = r13;
        goto L7
    }
}
