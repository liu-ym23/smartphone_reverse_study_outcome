package com.larus.bmhome.miniartifact.listpage.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jk\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/MiniAppTemplateChooseState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "foo", "", "pageStatus", "Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "templatePageTitle", "", "templateEmptyHint", "myArtifactTitle", "currentRenderTemplateList", "", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationTemplate;", "inputEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "applicationEntrance", "Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "<init>", "(ZLcom/larus/bmhome/miniartifact/listpage/request/PageStatus;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;)V", "getFoo", "()Z", "getPageStatus", "()Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "getTemplatePageTitle", "()Ljava/lang/String;", "getTemplateEmptyHint", "getMyArtifactTitle", "getCurrentRenderTemplateList", "()Ljava/util/List;", "getInputEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/InputEntrance;", "getApplicationEntrance", "()Lcom/larus/bmhome/miniartifact/listpage/request/ApplicationEntrance;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppTemplateChooseState implements w1a.b {
    private final ApplicationEntrance applicationEntrance;
    private final List<ApplicationTemplate> currentRenderTemplateList;
    private final boolean foo;
    private final InputEntrance inputEntrance;
    private final String myArtifactTitle;
    private final PageStatus pageStatus;
    private final String templateEmptyHint;
    private final String templatePageTitle;

    public MiniAppTemplateChooseState() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiniAppTemplateChooseState copy$default(MiniAppTemplateChooseState r9, boolean r10, PageStatus r11, String r12, String r13, String r14, List r15, InputEntrance r16, ApplicationEntrance r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r2 = r9.foo;
    L7:
        if ((r18 & 2) == 0) goto L9;
        PageStatus r3 = r9.pageStatus;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.templatePageTitle;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.templateEmptyHint;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.myArtifactTitle;
    L23:
        if ((r18 & 32) == 0) goto L25;
        List r7 = r9.currentRenderTemplateList;
    L27:
        if ((r18 & 64) == 0) goto L29;
        InputEntrance r8 = r9.inputEntrance;
    L31:
        if ((r18 & 128) == 0) goto L33;
        ApplicationEntrance r1 = r9.applicationEntrance;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final boolean component1() {
        return this.foo;
    }

    public final PageStatus component2() {
        return this.pageStatus;
    }

    public final String component3() {
        return this.templatePageTitle;
    }

    public final String component4() {
        return this.templateEmptyHint;
    }

    public final String component5() {
        return this.myArtifactTitle;
    }

    public final List<ApplicationTemplate> component6() {
        return this.currentRenderTemplateList;
    }

    public final InputEntrance component7() {
        return this.inputEntrance;
    }

    public final ApplicationEntrance component8() {
        return this.applicationEntrance;
    }

    public final MiniAppTemplateChooseState copy(boolean r11, PageStatus r12, String r13, String r14, String r15, List<ApplicationTemplate> r16, InputEntrance r17, ApplicationEntrance r18) {
        Intrinsics.checkNotNullParameter(r12, "pageStatus");
        return new MiniAppTemplateChooseState(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MiniAppTemplateChooseState) == true) goto L8;
        return false;
    L8:
        MiniAppTemplateChooseState r6 = (MiniAppTemplateChooseState) r5;
        if (this.foo == r6.foo) goto L12;
        return false;
    L12:
        if (this.pageStatus == r6.pageStatus) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templatePageTitle, r6.templatePageTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.templateEmptyHint, r6.templateEmptyHint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.myArtifactTitle, r6.myArtifactTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.currentRenderTemplateList, r6.currentRenderTemplateList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.inputEntrance, r6.inputEntrance) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.applicationEntrance, r6.applicationEntrance) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        if (this.foo == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.pageStatus.hashCode()) * 31;
        String r2 = this.templatePageTitle;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.templateEmptyHint;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        String r9 = this.myArtifactTitle;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        List<ApplicationTemplate> r12 = this.currentRenderTemplateList;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        InputEntrance r15 = this.inputEntrance;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        ApplicationEntrance r18 = this.applicationEntrance;
        if (r18 == null) goto L31;
        r3 = r18.hashCode();
    L31:
        return r17 + r3;
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MiniAppTemplateChooseState(foo=" + this.foo + ", pageStatus=" + this.pageStatus + ", templatePageTitle=" + this.templatePageTitle + ", templateEmptyHint=" + this.templateEmptyHint + ", myArtifactTitle=" + this.myArtifactTitle + ", currentRenderTemplateList=" + this.currentRenderTemplateList + ", inputEntrance=" + this.inputEntrance + ", applicationEntrance=" + this.applicationEntrance + ')';
    }

    public final ApplicationEntrance getApplicationEntrance() {
        return this.applicationEntrance;
    }

    public final List<ApplicationTemplate> getCurrentRenderTemplateList() {
        return this.currentRenderTemplateList;
    }

    public final boolean getFoo() {
        return this.foo;
    }

    public final InputEntrance getInputEntrance() {
        return this.inputEntrance;
    }

    public final String getMyArtifactTitle() {
        return this.myArtifactTitle;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final String getTemplateEmptyHint() {
        return this.templateEmptyHint;
    }

    public final String getTemplatePageTitle() {
        return this.templatePageTitle;
    }

    public MiniAppTemplateChooseState(boolean r2, PageStatus r3, String r4, String r5, String r6, List<ApplicationTemplate> r7, InputEntrance r8, ApplicationEntrance r9) {
        Intrinsics.checkNotNullParameter(r3, "pageStatus");
        this.foo = r2;
        this.pageStatus = r3;
        this.templatePageTitle = r4;
        this.templateEmptyHint = r5;
        this.myArtifactTitle = r6;
        this.currentRenderTemplateList = r7;
        this.inputEntrance = r8;
        this.applicationEntrance = r9;
    }

    public /* synthetic */ MiniAppTemplateChooseState(boolean r10, PageStatus r11, String r12, String r13, String r14, List r15, InputEntrance r16, ApplicationEntrance r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = true;
    L7:
        if ((r18 & 2) == 0) goto L9;
        PageStatus r2 = PageStatus.LOADING;
    L10:
        ApplicationEntrance r4 = null;
        if ((r18 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        InputEntrance r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r4 = r17;
    L34:
        this(r1, r2, r3, r5, r6, r7, r8, r4);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L10
    L5:
        r1 = r10;
        goto L7
    }
}
