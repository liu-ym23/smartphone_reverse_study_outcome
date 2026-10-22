package com.larus.platform.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/platform/model/HoverActionConfig;", "", "optimizeActionList", "", "showSuggestOnAction", "showQuoteOnAction", "showSuggestOnInput", "supportMainBot", "supportOfficialBot", "supportUserBot", "<init>", "(ZZZZZZZ)V", "getOptimizeActionList", "()Z", "getShowSuggestOnAction", "getShowQuoteOnAction", "getShowSuggestOnInput", "getSupportMainBot", "getSupportOfficialBot", "getSupportUserBot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class HoverActionConfig {
    public static final a Companion = null;
    private static final HoverActionConfig GROUP_CONTROL = null;
    private static final HoverActionConfig GROUP_V1 = null;
    private static final HoverActionConfig GROUP_V2 = null;
    private static final HoverActionConfig GROUP_V3 = null;
    private static final HoverActionConfig GROUP_V4 = null;

    @SerializedName("style_optimize")
    private final boolean optimizeActionList;

    @SerializedName("enable_quote")
    private final boolean showQuoteOnAction;

    @SerializedName("enable_suggest")
    private final boolean showSuggestOnAction;

    @SerializedName("enable_input_with_suggest")
    private final boolean showSuggestOnInput;

    @SerializedName("support_coco_bot")
    private final boolean supportMainBot;

    @SerializedName("support_guanfang_bot")
    private final boolean supportOfficialBot;

    @SerializedName("support_user_bot")
    private final boolean supportUserBot;

    public static final class a {
        public a() {
        }
    }

    public HoverActionConfig() {
        this(false, false, false, false, false, false, false, 127, null);
    }

    public static /* synthetic */ HoverActionConfig copy$default(HoverActionConfig r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.optimizeActionList;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.showSuggestOnAction;
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.showQuoteOnAction;
    L11:
        boolean r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.showSuggestOnInput;
    L14:
        boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.supportMainBot;
    L17:
        boolean r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.supportOfficialBot;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.supportUserBot;
    L23:
        boolean r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final boolean component1() {
        return this.optimizeActionList;
    }

    public final boolean component2() {
        return this.showSuggestOnAction;
    }

    public final boolean component3() {
        return this.showQuoteOnAction;
    }

    public final boolean component4() {
        return this.showSuggestOnInput;
    }

    public final boolean component5() {
        return this.supportMainBot;
    }

    public final boolean component6() {
        return this.supportOfficialBot;
    }

    public final boolean component7() {
        return this.supportUserBot;
    }

    public final HoverActionConfig copy(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        return new HoverActionConfig(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HoverActionConfig) == true) goto L8;
        return false;
    L8:
        HoverActionConfig r6 = (HoverActionConfig) r5;
        if (this.optimizeActionList == r6.optimizeActionList) goto L12;
        return false;
    L12:
        if (this.showSuggestOnAction == r6.showSuggestOnAction) goto L15;
        return false;
    L15:
        if (this.showQuoteOnAction == r6.showQuoteOnAction) goto L18;
        return false;
    L18:
        if (this.showSuggestOnInput == r6.showSuggestOnInput) goto L21;
        return false;
    L21:
        if (this.supportMainBot == r6.supportMainBot) goto L24;
        return false;
    L24:
        if (this.supportOfficialBot == r6.supportOfficialBot) goto L27;
        return false;
    L27:
        if (this.supportUserBot == r6.supportUserBot) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.optimizeActionList == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.showSuggestOnAction == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.showQuoteOnAction == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.showSuggestOnInput == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (r6 + r7) * 31;
        if (this.supportMainBot == false) goto L21;
        int r9 = 1231;
    L22:
        int r10 = (r8 + r9) * 31;
        if (this.supportOfficialBot == false) goto L25;
        int r11 = 1231;
    L26:
        int r12 = (r10 + r11) * 31;
        if (this.supportUserBot == true) goto L31;
        r1 = 1237;
    L31:
        return r12 + r1;
    L25:
        r11 = 1237;
        goto L26
    L21:
        r9 = 1237;
        goto L22
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "HoverActionConfig(optimizeActionList=" + this.optimizeActionList + ", showSuggestOnAction=" + this.showSuggestOnAction + ", showQuoteOnAction=" + this.showQuoteOnAction + ", showSuggestOnInput=" + this.showSuggestOnInput + ", supportMainBot=" + this.supportMainBot + ", supportOfficialBot=" + this.supportOfficialBot + ", supportUserBot=" + this.supportUserBot + ')';
    }

    static {
        Companion = new a();
        GROUP_CONTROL = new HoverActionConfig(false, false, false, false, false, false, false);
        GROUP_V1 = new HoverActionConfig(true, false, false, false, false, false, false);
        GROUP_V2 = new HoverActionConfig(true, false, true, false, false, false, false);
        GROUP_V3 = new HoverActionConfig(true, true, true, false, false, false, false);
        GROUP_V4 = new HoverActionConfig(true, true, true, true, false, false, false);
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_CONTROL$cp() {
        return GROUP_CONTROL;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V1$cp() {
        return GROUP_V1;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V2$cp() {
        return GROUP_V2;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V3$cp() {
        return GROUP_V3;
    }

    public static final /* synthetic */ HoverActionConfig access$getGROUP_V4$cp() {
        return GROUP_V4;
    }

    public final boolean getOptimizeActionList() {
        return this.optimizeActionList;
    }

    public final boolean getShowQuoteOnAction() {
        return this.showQuoteOnAction;
    }

    public final boolean getShowSuggestOnAction() {
        return this.showSuggestOnAction;
    }

    public final boolean getShowSuggestOnInput() {
        return this.showSuggestOnInput;
    }

    public final boolean getSupportMainBot() {
        return this.supportMainBot;
    }

    public final boolean getSupportOfficialBot() {
        return this.supportOfficialBot;
    }

    public final boolean getSupportUserBot() {
        return this.supportUserBot;
    }

    public HoverActionConfig(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        this.optimizeActionList = r1;
        this.showSuggestOnAction = r2;
        this.showQuoteOnAction = r3;
        this.showSuggestOnInput = r4;
        this.supportMainBot = r5;
        this.supportOfficialBot = r6;
        this.supportUserBot = r7;
    }

    public /* synthetic */ HoverActionConfig(boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        boolean r16 = false;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r14 & 4) == 0) goto L13;
        boolean r2 = false;
    L15:
        if ((r14 & 8) == 0) goto L17;
        boolean r3 = false;
    L19:
        if ((r14 & 16) == 0) goto L21;
        boolean r4 = false;
    L23:
        if ((r14 & 32) == 0) goto L25;
        boolean r5 = false;
    L27:
        if ((r14 & 64) == 0) goto L29;
        boolean r17 = false;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
