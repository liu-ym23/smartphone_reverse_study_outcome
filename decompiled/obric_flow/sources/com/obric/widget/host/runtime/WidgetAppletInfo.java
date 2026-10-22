package com.obric.widget.host.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u008e\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\bHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00068"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "", "appletId", "", "versionCode", "", "label", "labelRes", "", "iconUri", "iconRes", "system", "", "installed", "launchInfo", "aboutUrl", "widgets", "", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "<init>", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;IZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppletId", "()Ljava/lang/String;", "getVersionCode", "()J", "getLabel", "getLabelRes", "()I", "getIconUri", "getIconRes", "getSystem", "()Z", "getInstalled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLaunchInfo", "getAboutUrl", "getWidgets", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;IZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/obric/widget/host/runtime/WidgetAppletInfo;", "equals", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetAppletInfo {
    private final String aboutUrl;
    private final String appletId;
    private final int iconRes;
    private final String iconUri;
    private final Boolean installed;
    private final String label;
    private final int labelRes;
    private final String launchInfo;
    private final boolean system;
    private final long versionCode;
    private final List<WidgetDefinitionMetadata> widgets;

    public WidgetAppletInfo(String r5, long r10, String r11, int r12, String r13, int r14, boolean r15, Boolean r16, String r17, String r18, List<WidgetDefinitionMetadata> r19) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        this.appletId = r5;
        this.versionCode = r10;
        this.label = r11;
        this.labelRes = r12;
        this.iconUri = r13;
        this.iconRes = r14;
        this.system = r15;
        this.installed = r16;
        this.launchInfo = r17;
        this.aboutUrl = r18;
        this.widgets = r19;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetAppletInfo copy$default(WidgetAppletInfo r13, String r14, long r15, String r17, int r18, String r19, int r20, boolean r21, Boolean r22, String r23, String r24, List r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        String r5 = r13.appletId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r10 = r13.versionCode;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r11 = r13.label;
    L15:
        if ((r26 & 8) == 0) goto L17;
        int r12 = r13.labelRes;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r16 = r13.iconUri;
    L23:
        if ((r26 & 32) == 0) goto L25;
        int r28 = r13.iconRes;
    L27:
        if ((r26 & 64) == 0) goto L29;
        boolean r29 = r13.system;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Boolean r110 = r13.installed;
    L35:
        if ((r26 & 256) == 0) goto L37;
        String r111 = r13.launchInfo;
    L39:
        if ((r26 & 512) == 0) goto L41;
        String r112 = r13.aboutUrl;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        List r30 = r13.widgets;
    L47:
        return r13.copy(r5, r10, r11, r12, r16, r28, r29, r110, r111, r112, r30);
    L45:
        r30 = r25;
        goto L47
    L41:
        r112 = r24;
        goto L43
    L37:
        r111 = r23;
        goto L39
    L33:
        r110 = r22;
        goto L35
    L29:
        r29 = r21;
        goto L31
    L25:
        r28 = r20;
        goto L27
    L21:
        r16 = r19;
        goto L23
    L17:
        r12 = r18;
        goto L19
    L13:
        r11 = r17;
        goto L15
    L9:
        r10 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final String component1() {
        return this.appletId;
    }

    public final String component10() {
        return this.aboutUrl;
    }

    public final List<WidgetDefinitionMetadata> component11() {
        return this.widgets;
    }

    public final long component2() {
        return this.versionCode;
    }

    public final String component3() {
        return this.label;
    }

    public final int component4() {
        return this.labelRes;
    }

    public final String component5() {
        return this.iconUri;
    }

    public final int component6() {
        return this.iconRes;
    }

    public final boolean component7() {
        return this.system;
    }

    public final Boolean component8() {
        return this.installed;
    }

    public final String component9() {
        return this.launchInfo;
    }

    public final WidgetAppletInfo copy(String r15, long r16, String r18, int r19, String r20, int r21, boolean r22, Boolean r23, String r24, String r25, List<WidgetDefinitionMetadata> r26) {
        Intrinsics.checkNotNullParameter(r15, "appletId");
        return new WidgetAppletInfo(r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetAppletInfo) == true) goto L8;
        return false;
    L8:
        WidgetAppletInfo r11 = (WidgetAppletInfo) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (this.versionCode == r11.versionCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.label, r11.label) == true) goto L18;
        return false;
    L18:
        if (this.labelRes == r11.labelRes) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconUri, r11.iconUri) == true) goto L24;
        return false;
    L24:
        if (this.iconRes == r11.iconRes) goto L27;
        return false;
    L27:
        if (this.system == r11.system) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.installed, r11.installed) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.launchInfo, r11.launchInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.aboutUrl, r11.aboutUrl) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.widgets, r11.widgets) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getAboutUrl() {
        return this.aboutUrl;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getIconUri() {
        return this.iconUri;
    }

    public final Boolean getInstalled() {
        return this.installed;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final String getLaunchInfo() {
        return this.launchInfo;
    }

    public final boolean getSystem() {
        return this.system;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final List<WidgetDefinitionMetadata> getWidgets() {
        return this.widgets;
    }

    public int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.e(this.appletId.hashCode() * 31, this.versionCode, 31);
        String r10 = this.label;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.labelRes, (r5 + r12) * 31, 31);
        String r14 = this.iconUri;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.c(this.iconRes, (r13 + r15) * 31, 31), 31, this.system);
        Boolean r17 = this.installed;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.launchInfo;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.aboutUrl;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        List<WidgetDefinitionMetadata> r26 = this.widgets;
        if (r26 == null) goto L27;
        r11 = r26.hashCode();
    L27:
        return r25 + r11;
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.appletId;
        long r10 = this.versionCode;
        String r11 = this.label;
        int r12 = this.labelRes;
        String r13 = this.iconUri;
        int r14 = this.iconRes;
        boolean r15 = this.system;
        Boolean r16 = this.installed;
        String r17 = this.launchInfo;
        String r18 = this.aboutUrl;
        List<WidgetDefinitionMetadata> r19 = this.widgets;
        StringBuilder r110 = new StringBuilder("WidgetAppletInfo(appletId=");
        r110.append(r5);
        r110.append(", versionCode=");
        r110.append(r10);
        r110.append(", label=");
        r110.append(r11);
        r110.append(", labelRes=");
        r110.append(r12);
        r110.append(", iconUri=");
        r110.append(r13);
        r110.append(", iconRes=");
        r110.append(r14);
        r110.append(", system=");
        r110.append(r15);
        r110.append(", installed=");
        r110.append(r16);
        androidx.constraintlayout.motion.widget.a.C(r110, ", launchInfo=", r17, ", aboutUrl=", r18);
        r110.append(", widgets=");
        r110.append(r19);
        r110.append(")");
        return r110.toString();
    }

    public /* synthetic */ WidgetAppletInfo(String r16, long r17, String r19, int r20, String r21, int r22, boolean r23, Boolean r24, String r25, String r26, List r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 8) == 0) goto L5;
        int r10 = 0;
    L7:
        if ((r28 & 32) == 0) goto L9;
        int r11 = 0;
    L10:
        this(r16, r17, r19, r10, r21, r11, r23, r24, r25, r26, r27);
        return;
    L9:
        r11 = r22;
        goto L10
    L5:
        r10 = r20;
        goto L7
    }
}
