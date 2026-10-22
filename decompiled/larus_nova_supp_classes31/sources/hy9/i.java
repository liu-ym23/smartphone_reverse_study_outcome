package hy9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)J°\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0013HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)¨\u0006?"}, d2 = {"Lcom/larus/uaigc/bean/StaticConfig;", "", "guideUrl", "", "guideRatio", "", "actionBarRedDotText", "actionBarRedDotItemId", "", "actionBarRedDotTextColor", "actionBarRedDotBgColor", "actionBarRedDotTextDarkColor", "actionBarRedDotBgDarkColor", "imListTxt", "onboardingMs", "", "warmUrl", "entryColor", "forceShowGuide", "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getGuideUrl", "()Ljava/lang/String;", "getGuideRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getActionBarRedDotText", "getActionBarRedDotItemId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getActionBarRedDotTextColor", "getActionBarRedDotBgColor", "getActionBarRedDotTextDarkColor", "getActionBarRedDotBgDarkColor", "getImListTxt", "getOnboardingMs", "()Ljava/util/List;", "getWarmUrl", "getEntryColor", "getForceShowGuide", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/uaigc/bean/StaticConfig;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class i {

    @SerializedName("bg_color")
    private final String actionBarRedDotBgColor;

    @SerializedName("bg_dark_color")
    private final String actionBarRedDotBgDarkColor;

    @SerializedName("item_id")
    private final Long actionBarRedDotItemId;

    @SerializedName("text")
    private final String actionBarRedDotText;

    @SerializedName("txt_color")
    private final String actionBarRedDotTextColor;

    @SerializedName("txt_dark_color")
    private final String actionBarRedDotTextDarkColor;

    @SerializedName("entry_color")
    private final String entryColor;

    @SerializedName("force_show_guide")
    private final Integer forceShowGuide;

    @SerializedName("ratio")
    private final Double guideRatio;

    @SerializedName("url")
    private final String guideUrl;

    @SerializedName("im_list_txt")
    private final String imListTxt;

    @SerializedName("onboarding_ms")
    private final List<Long> onboardingMs;

    @SerializedName("warm_url")
    private final String warmUrl;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.guideUrl, r6.guideUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideRatio, r6.guideRatio) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionBarRedDotText, r6.actionBarRedDotText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionBarRedDotItemId, r6.actionBarRedDotItemId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionBarRedDotTextColor, r6.actionBarRedDotTextColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.actionBarRedDotBgColor, r6.actionBarRedDotBgColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.actionBarRedDotTextDarkColor, r6.actionBarRedDotTextDarkColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.actionBarRedDotBgDarkColor, r6.actionBarRedDotBgDarkColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imListTxt, r6.imListTxt) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.onboardingMs, r6.onboardingMs) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.warmUrl, r6.warmUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.entryColor, r6.entryColor) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.forceShowGuide, r6.forceShowGuide) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r0 = this.guideUrl;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Double r4 = this.guideRatio;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.actionBarRedDotText;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.actionBarRedDotItemId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.actionBarRedDotTextColor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.actionBarRedDotBgColor;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.actionBarRedDotTextDarkColor;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.actionBarRedDotBgDarkColor;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.imListTxt;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<Long> r28 = this.onboardingMs;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.warmUrl;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.entryColor;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.forceShowGuide;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
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

    public final String toString() {
        return "StaticConfig(guideUrl=" + this.guideUrl + ", guideRatio=" + this.guideRatio + ", actionBarRedDotText=" + this.actionBarRedDotText + ", actionBarRedDotItemId=" + this.actionBarRedDotItemId + ", actionBarRedDotTextColor=" + this.actionBarRedDotTextColor + ", actionBarRedDotBgColor=" + this.actionBarRedDotBgColor + ", actionBarRedDotTextDarkColor=" + this.actionBarRedDotTextDarkColor + ", actionBarRedDotBgDarkColor=" + this.actionBarRedDotBgDarkColor + ", imListTxt=" + this.imListTxt + ", onboardingMs=" + this.onboardingMs + ", warmUrl=" + this.warmUrl + ", entryColor=" + this.entryColor + ", forceShowGuide=" + this.forceShowGuide + ')';
    }

    public i() {
        this.guideUrl = null;
        this.guideRatio = null;
        this.actionBarRedDotText = null;
        this.actionBarRedDotItemId = null;
        this.actionBarRedDotTextColor = null;
        this.actionBarRedDotBgColor = null;
        this.actionBarRedDotTextDarkColor = null;
        this.actionBarRedDotBgDarkColor = null;
        this.imListTxt = null;
        this.onboardingMs = null;
        this.warmUrl = null;
        this.entryColor = null;
        this.forceShowGuide = null;
    }

    public final String a() {
        return this.entryColor;
    }

    public final Integer b() {
        return this.forceShowGuide;
    }

    public final List<Long> c() {
        return this.onboardingMs;
    }

    public final String d() {
        return this.warmUrl;
    }
}
