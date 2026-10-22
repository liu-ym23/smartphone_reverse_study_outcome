package com.larus.bmhome.miniartifact.listpage.request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/MiniArtifactListPageResponseData;", "Ljava/io/Serializable;", "templatePageTitle", "", "templateEmptyHint", "inputEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "applicationEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "applicationTemplateList", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;Ljava/util/List;)V", "getTemplatePageTitle", "()Ljava/lang/String;", "getTemplateEmptyHint", "getInputEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "getApplicationEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "getApplicationTemplateList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageResponseData implements Serializable {

    @SerializedName("application_entrance")
    private final ApplicationEntrance applicationEntrance;

    @SerializedName("application_template_list")
    private final List<ApplicationTemplate> applicationTemplateList;

    @SerializedName("input_entrance")
    private final InputEntrance inputEntrance;

    @SerializedName("template_empty_hint")
    private final String templateEmptyHint;

    @SerializedName("template_page_title")
    private final String templatePageTitle;

    public MiniArtifactListPageResponseData() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniArtifactListPageResponseData copy$default(MiniArtifactListPageResponseData r3, String r4, String r5, InputEntrance r6, ApplicationEntrance r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.templatePageTitle;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.templateEmptyHint;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.inputEntrance;
    L11:
        InputEntrance r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.applicationEntrance;
    L14:
        ApplicationEntrance r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.applicationTemplateList;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.templatePageTitle;
    }

    public final String component2() {
        return this.templateEmptyHint;
    }

    public final InputEntrance component3() {
        return this.inputEntrance;
    }

    public final ApplicationEntrance component4() {
        return this.applicationEntrance;
    }

    public final List<ApplicationTemplate> component5() {
        return this.applicationTemplateList;
    }

    public final MiniArtifactListPageResponseData copy(String r8, String r9, InputEntrance r10, ApplicationEntrance r11, List<ApplicationTemplate> r12) {
        return new MiniArtifactListPageResponseData(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiniArtifactListPageResponseData) == true) goto L8;
        return false;
    L8:
        MiniArtifactListPageResponseData r6 = (MiniArtifactListPageResponseData) r5;
        if (Intrinsics.areEqual(this.templatePageTitle, r6.templatePageTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateEmptyHint, r6.templateEmptyHint) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputEntrance, r6.inputEntrance) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.applicationEntrance, r6.applicationEntrance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.applicationTemplateList, r6.applicationTemplateList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.templatePageTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.templateEmptyHint;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        InputEntrance r7 = this.inputEntrance;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ApplicationEntrance r10 = this.applicationEntrance;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<ApplicationTemplate> r13 = this.applicationTemplateList;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "MiniArtifactListPageResponseData(templatePageTitle=" + this.templatePageTitle + ", templateEmptyHint=" + this.templateEmptyHint + ", inputEntrance=" + this.inputEntrance + ", applicationEntrance=" + this.applicationEntrance + ", applicationTemplateList=" + this.applicationTemplateList + ')';
    }

    public final ApplicationEntrance getApplicationEntrance() {
        return this.applicationEntrance;
    }

    public final List<ApplicationTemplate> getApplicationTemplateList() {
        return this.applicationTemplateList;
    }

    public final InputEntrance getInputEntrance() {
        return this.inputEntrance;
    }

    public final String getTemplateEmptyHint() {
        return this.templateEmptyHint;
    }

    public final String getTemplatePageTitle() {
        return this.templatePageTitle;
    }

    public MiniArtifactListPageResponseData(String r1, String r2, InputEntrance r3, ApplicationEntrance r4, List<ApplicationTemplate> r5) {
        this.templatePageTitle = r1;
        this.templateEmptyHint = r2;
        this.inputEntrance = r3;
        this.applicationEntrance = r4;
        this.applicationTemplateList = r5;
    }

    public /* synthetic */ MiniArtifactListPageResponseData(String r5, String r6, InputEntrance r7, ApplicationEntrance r8, List r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        InputEntrance r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        ApplicationEntrance r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        List r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
