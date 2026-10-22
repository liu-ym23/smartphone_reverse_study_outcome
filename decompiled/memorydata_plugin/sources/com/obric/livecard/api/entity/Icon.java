package com.obric.livecard.api.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u008a\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\f2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001e¨\u0006E"}, d2 = {"Lcom/obric/livecard/api/entity/Icon;", "", "height", "", "width", "icon", "", "loop", "autoplay", OaidModel.KEY_ID, "backgroundIcon", "useBorderRadius", "", "iconLight", "strokeWidth", "", "strokeColor", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getAutoplay", "()Ljava/lang/Integer;", "setAutoplay", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBackgroundIcon", "()Ljava/lang/String;", "setBackgroundIcon", "(Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getIcon", "setIcon", "getIconLight", "setIconLight", "getId", "setId", "getLoop", "setLoop", "getStrokeColor", "setStrokeColor", "getStrokeWidth", "()Ljava/lang/Float;", "setStrokeWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getUseBorderRadius", "()Z", "setUseBorderRadius", "(Z)V", "getWidth", "setWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/obric/livecard/api/entity/Icon;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Icon {
    private Integer autoplay;
    private String backgroundIcon;
    private int height;
    private String icon;
    private String iconLight;
    private String id;
    private Integer loop;
    private String strokeColor;
    private Float strokeWidth;
    private boolean useBorderRadius;
    private int width;

    public Icon(int r2, int r3, String r4, Integer r5, Integer r6, String r7, String r8, boolean r9, String r10, Float r11, String r12) {
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
        this.strokeWidth = r11;
        this.strokeColor = r12;
    }

    public /* synthetic */ Icon(int r16, int r17, String r18, Integer r19, Integer r20, String r21, String r22, boolean r23, String r24, Float r25, String r26, int r27, DefaultConstructorMarker r28) {
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
        boolean r11 = false;
    L23:
        if ((r27 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r27 & 512) == 0) goto L29;
        Float r13 = null;
    L31:
        if ((r27 & 1024) == 0) goto L33;
        String r14 = null;
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

    public static /* synthetic */ Icon copy$default(Icon r12, int r13, int r14, String r15, Integer r16, Integer r17, String r18, String r19, boolean r20, String r21, Float r22, String r23, int r24, Object r25) {
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
        Float r11 = r12.strokeWidth;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.strokeColor;
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

    public final Float component10() {
        return this.strokeWidth;
    }

    public final String component11() {
        return this.strokeColor;
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

    public final Icon copy(int r14, int r15, String r16, Integer r17, Integer r18, String r19, String r20, boolean r21, String r22, Float r23, String r24) {
        Intrinsics.checkNotNullParameter(r16, "icon");
        return new Icon(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Icon.class) == true) goto L8;
        return false;
    L8:
        Icon r6 = (Icon) ZeusTransformUtils.preCheckCast(r5, Icon.class, "com.obric.memorydata.plugin");
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
        if (Intrinsics.areEqual(this.strokeWidth, r6.strokeWidth) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.strokeColor, r6.strokeColor) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final Integer getAutoplay() {
        return this.autoplay;
    }

    public final String getBackgroundIcon() {
        return this.backgroundIcon;
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

    public final String getStrokeColor() {
        return this.strokeColor;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final boolean getUseBorderRadius() {
        return this.useBorderRadius;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v31 */
    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width)) * 31) + this.icon.hashCode()) * 31;
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
        boolean r14 = this.useBorderRadius;
        ?? r15 = r14;
        if (r14 == false) goto L21;
        r15 = 1;
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.iconLight;
        if (r17 != null) goto L24;
        int r18 = 0;
    L25:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.strokeWidth;
        if (r20 != null) goto L28;
        int r21 = 0;
    L29:
        int r22 = (r19 + r21) * 31;
        String r23 = this.strokeColor;
        if (r23 == null) goto L34;
        r2 = r23.hashCode();
    L34:
        return r22 + r2;
    L28:
        r21 = r20.hashCode();
        goto L29
    L24:
        r18 = r17.hashCode();
        goto L25
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

    public final void setAutoplay(Integer r1) {
        this.autoplay = r1;
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

    public final void setStrokeColor(String r1) {
        this.strokeColor = r1;
    }

    public final void setStrokeWidth(Float r1) {
        this.strokeWidth = r1;
    }

    public final void setUseBorderRadius(boolean r1) {
        this.useBorderRadius = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Icon(height=").append(this.height).append(", width=").append(this.width).append(", icon=").append(this.icon).append(", loop=").append(this.loop).append(", autoplay=").append(this.autoplay).append(", id=").append(this.id).append(", backgroundIcon=").append(this.backgroundIcon).append(", useBorderRadius=").append(this.useBorderRadius).append(", iconLight=").append(this.iconLight).append(", strokeWidth=").append(this.strokeWidth).append(", strokeColor=").append(this.strokeColor).append(')');
        return r0.toString();
    }
}
