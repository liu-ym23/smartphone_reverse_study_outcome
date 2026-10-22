package com.larus.bmhome.miniartifact.listpage.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008e\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "Ljava/io/Serializable;", "templateId", "", "templateCoverUrl", "templateTitle", "templateWebUrl", "templateInvalidTimestamp", "", "enableConfigElement", "", "configElementImage", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ConfigElementImage;", "configElementPrompt", "coverMainColor", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTemplateId", "()Ljava/lang/String;", "getTemplateCoverUrl", "getTemplateTitle", "getTemplateWebUrl", "getTemplateInvalidTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEnableConfigElement", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfigElementImage", "()Ljava/util/List;", "getConfigElementPrompt", "getCoverMainColor", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationTemplate implements Serializable {

    @SerializedName("config_element_image")
    private final List<ConfigElementImage> configElementImage;

    @SerializedName("config_element_prompt")
    private final String configElementPrompt;

    @SerializedName("cover_main_color")
    private final String coverMainColor;

    @SerializedName("enable_config_element")
    private final Boolean enableConfigElement;

    @SerializedName("template_cover_url")
    private final String templateCoverUrl;

    @SerializedName("template_id")
    private final String templateId;

    @SerializedName("template_invalid_timestamp")
    private final Long templateInvalidTimestamp;

    @SerializedName("template_title")
    private final String templateTitle;

    @SerializedName("template_web_url")
    private final String templateWebUrl;

    @SerializedName("version")
    private final String version;

    public ApplicationTemplate() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationTemplate copy$default(ApplicationTemplate r11, String r12, String r13, String r14, String r15, Long r16, Boolean r17, List r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.templateId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.templateCoverUrl;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.templateTitle;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.templateWebUrl;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Long r6 = r11.templateInvalidTimestamp;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Boolean r7 = r11.enableConfigElement;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = r11.configElementImage;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.configElementPrompt;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.coverMainColor;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.version;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.templateId;
    }

    public final String component10() {
        return this.version;
    }

    public final String component2() {
        return this.templateCoverUrl;
    }

    public final String component3() {
        return this.templateTitle;
    }

    public final String component4() {
        return this.templateWebUrl;
    }

    public final Long component5() {
        return this.templateInvalidTimestamp;
    }

    public final Boolean component6() {
        return this.enableConfigElement;
    }

    public final List<ConfigElementImage> component7() {
        return this.configElementImage;
    }

    public final String component8() {
        return this.configElementPrompt;
    }

    public final String component9() {
        return this.coverMainColor;
    }

    public final ApplicationTemplate copy(String r13, String r14, String r15, String r16, Long r17, Boolean r18, List<ConfigElementImage> r19, String r20, String r21, String r22) {
        return new ApplicationTemplate(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ApplicationTemplate) == true) goto L8;
        return false;
    L8:
        ApplicationTemplate r6 = (ApplicationTemplate) r5;
        if (Intrinsics.areEqual(this.templateId, r6.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateCoverUrl, r6.templateCoverUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateTitle, r6.templateTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateWebUrl, r6.templateWebUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.templateInvalidTimestamp, r6.templateInvalidTimestamp) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.enableConfigElement, r6.enableConfigElement) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.configElementImage, r6.configElementImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.configElementPrompt, r6.configElementPrompt) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.coverMainColor, r6.coverMainColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r0 = this.templateId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.templateCoverUrl;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.templateTitle;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.templateWebUrl;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.templateInvalidTimestamp;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.enableConfigElement;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<ConfigElementImage> r19 = this.configElementImage;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.configElementPrompt;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.coverMainColor;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.version;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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
        return "ApplicationTemplate(templateId=" + this.templateId + ", templateCoverUrl=" + this.templateCoverUrl + ", templateTitle=" + this.templateTitle + ", templateWebUrl=" + this.templateWebUrl + ", templateInvalidTimestamp=" + this.templateInvalidTimestamp + ", enableConfigElement=" + this.enableConfigElement + ", configElementImage=" + this.configElementImage + ", configElementPrompt=" + this.configElementPrompt + ", coverMainColor=" + this.coverMainColor + ", version=" + this.version + ')';
    }

    public final List<ConfigElementImage> getConfigElementImage() {
        return this.configElementImage;
    }

    public final String getConfigElementPrompt() {
        return this.configElementPrompt;
    }

    public final String getCoverMainColor() {
        return this.coverMainColor;
    }

    public final Boolean getEnableConfigElement() {
        return this.enableConfigElement;
    }

    public final String getTemplateCoverUrl() {
        return this.templateCoverUrl;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final Long getTemplateInvalidTimestamp() {
        return this.templateInvalidTimestamp;
    }

    public final String getTemplateTitle() {
        return this.templateTitle;
    }

    public final String getTemplateWebUrl() {
        return this.templateWebUrl;
    }

    public final String getVersion() {
        return this.version;
    }

    public ApplicationTemplate(String r1, String r2, String r3, String r4, Long r5, Boolean r6, List<ConfigElementImage> r7, String r8, String r9, String r10) {
        this.templateId = r1;
        this.templateCoverUrl = r2;
        this.templateTitle = r3;
        this.templateWebUrl = r4;
        this.templateInvalidTimestamp = r5;
        this.enableConfigElement = r6;
        this.configElementImage = r7;
        this.configElementPrompt = r8;
        this.coverMainColor = r9;
        this.version = r10;
    }

    public /* synthetic */ ApplicationTemplate(String r12, String r13, String r14, String r15, Long r16, Boolean r17, List r18, String r19, String r20, String r21, int r22, DefaultConstructorMarker r23) {
        String r2 = null;
        if ((r22 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Long r6 = null;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Boolean r7 = null;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r2 = r21;
    L42:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r2);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
