package com.ss.android.lark.forsetiutils.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJn\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000e¨\u0006&"}, d2 = {"Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;", "", "enableWorkplace", "", "enableSystemFilePicker", "enableResponsiveComponentContainer", "isMiniappInHostStack", "enableFontScale", "enableSendImage", "enableRedPacket", "enableThirdShare", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnableWorkplace", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableSystemFilePicker", "getEnableResponsiveComponentContainer", "getEnableFontScale", "getEnableSendImage", "getEnableRedPacket", "getEnableThirdShare", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class a {

    @SerializedName("enable_font_scale")
    private final Boolean enableFontScale;

    @SerializedName("enable_red_packet")
    private final Boolean enableRedPacket;

    @SerializedName("enable_responsive_component_container")
    private final Boolean enableResponsiveComponentContainer;

    @SerializedName("enable_send_image")
    private final Boolean enableSendImage;

    @SerializedName("enable_system_file_picker")
    private final Boolean enableSystemFilePicker;

    @SerializedName("enable_third_share")
    private final Boolean enableThirdShare;

    @SerializedName("enable_workplace")
    private final Boolean enableWorkplace;

    @SerializedName("is_miniapp_in_host_stack")
    private final Boolean isMiniappInHostStack;

    public a() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.enableWorkplace, r6.enableWorkplace) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableSystemFilePicker, r6.enableSystemFilePicker) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableResponsiveComponentContainer, r6.enableResponsiveComponentContainer) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isMiniappInHostStack, r6.isMiniappInHostStack) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enableFontScale, r6.enableFontScale) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enableSendImage, r6.enableSendImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.enableRedPacket, r6.enableRedPacket) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enableThirdShare, r6.enableThirdShare) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enableWorkplace;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableSystemFilePicker;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.enableResponsiveComponentContainer;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isMiniappInHostStack;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.enableFontScale;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.enableSendImage;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.enableRedPacket;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.enableThirdShare;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
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

    public final String toString() {
        return "CarAdaptConfigItem(enableWorkplace=" + this.enableWorkplace + ", enableSystemFilePicker=" + this.enableSystemFilePicker + ", enableResponsiveComponentContainer=" + this.enableResponsiveComponentContainer + ", isMiniappInHostStack=" + this.isMiniappInHostStack + ", enableFontScale=" + this.enableFontScale + ", enableSendImage=" + this.enableSendImage + ", enableRedPacket=" + this.enableRedPacket + ", enableThirdShare=" + this.enableThirdShare + ')';
    }

    public final Boolean a() {
        return this.enableFontScale;
    }

    public final Boolean b() {
        return this.enableRedPacket;
    }

    public final Boolean c() {
        return this.enableResponsiveComponentContainer;
    }

    public final Boolean d() {
        return this.enableSendImage;
    }

    public final Boolean e() {
        return this.enableSystemFilePicker;
    }

    public final Boolean f() {
        return this.enableThirdShare;
    }

    public final Boolean g() {
        return this.enableWorkplace;
    }

    public final Boolean h() {
        return this.isMiniappInHostStack;
    }

    public a(Boolean r1, Boolean r2, Boolean r3, Boolean r4, Boolean r5, Boolean r6, Boolean r7, Boolean r8) {
        this.enableWorkplace = r1;
        this.enableSystemFilePicker = r2;
        this.enableResponsiveComponentContainer = r3;
        this.isMiniappInHostStack = r4;
        this.enableFontScale = r5;
        this.enableSendImage = r6;
        this.enableRedPacket = r7;
        this.enableThirdShare = r8;
    }
}
