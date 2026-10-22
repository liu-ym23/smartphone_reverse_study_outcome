package com.obric.livecard.api.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "请使用ButtonV2")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jt\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001c¨\u0006:"}, d2 = {"Lcom/obric/livecard/api/entity/Button;", "", "height", "", "width", "icon", "", OaidModel.KEY_ID, "dismissKeyguard", "", "textIconStyle", "Lcom/obric/livecard/api/entity/TextIconStyle;", "backgroundIcon", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "iconLight", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/TextIconStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundIcon", "()Ljava/lang/String;", "setBackgroundIcon", "(Ljava/lang/String;)V", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHeight", "()I", "setHeight", "(I)V", "getIcon", "setIcon", "getIconLight", "setIconLight", "getId", "setId", "getText", "setText", "getTextIconStyle", "()Lcom/obric/livecard/api/entity/TextIconStyle;", "setTextIconStyle", "(Lcom/obric/livecard/api/entity/TextIconStyle;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/obric/livecard/api/entity/TextIconStyle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/livecard/api/entity/Button;", "equals", "other", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Button {
    private String backgroundIcon;
    private Boolean dismissKeyguard;
    private int height;
    private String icon;
    private String iconLight;
    private String id;
    private String text;
    private TextIconStyle textIconStyle;
    private int width;

    public Button(int r2, int r3, String r4, String r5, Boolean r6, TextIconStyle r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "icon");
        this.height = r2;
        this.width = r3;
        this.icon = r4;
        this.id = r5;
        this.dismissKeyguard = r6;
        this.textIconStyle = r7;
        this.backgroundIcon = r8;
        this.text = r9;
        this.iconLight = r10;
    }

    public /* synthetic */ Button(int r14, int r15, String r16, String r17, Boolean r18, TextIconStyle r19, String r20, String r21, String r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r23 & 16) == 0) goto L9;
        Boolean r8 = null;
    L11:
        if ((r23 & 32) == 0) goto L13;
        TextIconStyle r9 = null;
    L15:
        if ((r23 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r23 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r23 & 256) == 0) goto L25;
        String r12 = null;
    L26:
        this(r14, r15, r16, r7, r8, r9, r10, r11, r12);
        return;
    L25:
        r12 = r22;
        goto L26
    L21:
        r11 = r21;
        goto L23
    L17:
        r10 = r20;
        goto L19
    L13:
        r9 = r19;
        goto L15
    L9:
        r8 = r18;
        goto L11
    L5:
        r7 = r17;
        goto L7
    }

    public static /* synthetic */ Button copy$default(Button r10, int r11, int r12, String r13, String r14, Boolean r15, TextIconStyle r16, String r17, String r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.height;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.width;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.icon;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.id;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Boolean r6 = r10.dismissKeyguard;
    L23:
        if ((r20 & 32) == 0) goto L25;
        TextIconStyle r7 = r10.textIconStyle;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.backgroundIcon;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.text;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.iconLight;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
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
        r2 = r11;
        goto L7
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.width;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.id;
    }

    public final Boolean component5() {
        return this.dismissKeyguard;
    }

    public final TextIconStyle component6() {
        return this.textIconStyle;
    }

    public final String component7() {
        return this.backgroundIcon;
    }

    public final String component8() {
        return this.text;
    }

    public final String component9() {
        return this.iconLight;
    }

    public final Button copy(int r12, int r13, String r14, String r15, Boolean r16, TextIconStyle r17, String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r14, "icon");
        return new Button(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Button.class) == true) goto L8;
        return false;
    L8:
        Button r6 = (Button) ZeusTransformUtils.preCheckCast(r5, Button.class, "com.obric.memorydata.plugin");
        if (this.height == r6.height) goto L12;
        return false;
    L12:
        if (this.width == r6.width) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.textIconStyle, r6.textIconStyle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backgroundIcon, r6.backgroundIcon) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.iconLight, r6.iconLight) == true) goto L35;
        return false;
    L35:
        return true;
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

    public final String getText() {
        return this.text;
    }

    public final TextIconStyle getTextIconStyle() {
        return this.textIconStyle;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int r0 = ((((Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width)) * 31) + this.icon.hashCode()) * 31;
        String r1 = this.id;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.dismissKeyguard;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        TextIconStyle r8 = this.textIconStyle;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.backgroundIcon;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.text;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.iconLight;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
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

    public final void setBackgroundIcon(String r1) {
        this.backgroundIcon = r1;
    }

    public final void setDismissKeyguard(Boolean r1) {
        this.dismissKeyguard = r1;
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

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setTextIconStyle(TextIconStyle r1) {
        this.textIconStyle = r1;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public String toString() {
        return "Button(height=" + this.height + ", width=" + this.width + ", icon=" + this.icon + ", id=" + this.id + ", dismissKeyguard=" + this.dismissKeyguard + ", textIconStyle=" + this.textIconStyle + ", backgroundIcon=" + this.backgroundIcon + ", text=" + this.text + ", iconLight=" + this.iconLight + ')';
    }
}
