package com.larus.canvas.service.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0003J\u0086\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0006HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 ¨\u00064"}, d2 = {"Lcom/larus/canvas/service/bean/InstructionTab;", "", "tabLabel", "", "tabName", "tabType", "", "extra", "Lcom/larus/canvas/service/bean/TabExtra;", "icon", "Lcom/larus/canvas/service/bean/Icon;", "darkModeIcon", "optionList", "", "Lcom/larus/canvas/service/bean/OptionItem;", "singleOption", "featureOptionPanelList", "Lcom/larus/canvas/service/bean/FeatureOptionPanelItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/TabExtra;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;Ljava/util/List;Lcom/larus/canvas/service/bean/OptionItem;Ljava/util/List;)V", "getTabLabel", "()Ljava/lang/String;", "getTabName", "getTabType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtra", "()Lcom/larus/canvas/service/bean/TabExtra;", "getIcon", "()Lcom/larus/canvas/service/bean/Icon;", "getDarkModeIcon", "getOptionList", "()Ljava/util/List;", "getSingleOption", "()Lcom/larus/canvas/service/bean/OptionItem;", "getFeatureOptionPanelList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/canvas/service/bean/TabExtra;Lcom/larus/canvas/service/bean/Icon;Lcom/larus/canvas/service/bean/Icon;Ljava/util/List;Lcom/larus/canvas/service/bean/OptionItem;Ljava/util/List;)Lcom/larus/canvas/service/bean/InstructionTab;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionTab {

    @SerializedName("dark_mode_icon")
    private final Icon darkModeIcon;

    @SerializedName("extra")
    private final TabExtra extra;

    @SerializedName("feature_option_panel_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FeatureOptionPanelItem> featureOptionPanelList;

    @SerializedName("icon")
    private final Icon icon;

    @SerializedName("option_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OptionItem> optionList;

    @SerializedName("single_option")
    private final OptionItem singleOption;

    @SerializedName("tab_label")
    private final String tabLabel;

    @SerializedName("tab_name")
    private final String tabName;

    @SerializedName("tab_type")
    private final Integer tabType;

    public InstructionTab() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InstructionTab copy$default(InstructionTab r10, String r11, String r12, Integer r13, TabExtra r14, Icon r15, Icon r16, List r17, OptionItem r18, List r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.tabLabel;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.tabName;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r4 = r10.tabType;
    L15:
        if ((r20 & 8) == 0) goto L17;
        TabExtra r5 = r10.extra;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Icon r6 = r10.icon;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Icon r7 = r10.darkModeIcon;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r8 = r10.optionList;
    L31:
        if ((r20 & 128) == 0) goto L33;
        OptionItem r9 = r10.singleOption;
    L35:
        if ((r20 & 256) == 0) goto L37;
        List r1 = r10.featureOptionPanelList;
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

    public final String component1() {
        return this.tabLabel;
    }

    public final String component2() {
        return this.tabName;
    }

    public final Integer component3() {
        return this.tabType;
    }

    public final TabExtra component4() {
        return this.extra;
    }

    public final Icon component5() {
        return this.icon;
    }

    public final Icon component6() {
        return this.darkModeIcon;
    }

    public final List<OptionItem> component7() {
        return this.optionList;
    }

    public final OptionItem component8() {
        return this.singleOption;
    }

    public final List<FeatureOptionPanelItem> component9() {
        return this.featureOptionPanelList;
    }

    public final InstructionTab copy(String r12, String r13, Integer r14, TabExtra r15, Icon r16, Icon r17, List<OptionItem> r18, OptionItem r19, List<FeatureOptionPanelItem> r20) {
        return new InstructionTab(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InstructionTab) == true) goto L8;
        return false;
    L8:
        InstructionTab r6 = (InstructionTab) r5;
        if (Intrinsics.areEqual(this.tabLabel, r6.tabLabel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabName, r6.tabName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabType, r6.tabType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.darkModeIcon, r6.darkModeIcon) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.optionList, r6.optionList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.singleOption, r6.singleOption) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.featureOptionPanelList, r6.featureOptionPanelList) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        String r0 = this.tabLabel;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.tabName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.tabType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        TabExtra r10 = this.extra;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Icon r13 = this.icon;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Icon r16 = this.darkModeIcon;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<OptionItem> r19 = this.optionList;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        OptionItem r22 = this.singleOption;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<FeatureOptionPanelItem> r25 = this.featureOptionPanelList;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        return "InstructionTab(tabLabel=" + this.tabLabel + ", tabName=" + this.tabName + ", tabType=" + this.tabType + ", extra=" + this.extra + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ", optionList=" + this.optionList + ", singleOption=" + this.singleOption + ", featureOptionPanelList=" + this.featureOptionPanelList + ')';
    }

    public final Icon getDarkModeIcon() {
        return this.darkModeIcon;
    }

    public final TabExtra getExtra() {
        return this.extra;
    }

    public final List<FeatureOptionPanelItem> getFeatureOptionPanelList() {
        return this.featureOptionPanelList;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final List<OptionItem> getOptionList() {
        return this.optionList;
    }

    public final OptionItem getSingleOption() {
        return this.singleOption;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public InstructionTab(String r1, String r2, Integer r3, TabExtra r4, Icon r5, Icon r6, List<OptionItem> r7, OptionItem r8, List<FeatureOptionPanelItem> r9) {
        this.tabLabel = r1;
        this.tabName = r2;
        this.tabType = r3;
        this.extra = r4;
        this.icon = r5;
        this.darkModeIcon = r6;
        this.optionList = r7;
        this.singleOption = r8;
        this.featureOptionPanelList = r9;
    }

    public /* synthetic */ InstructionTab(String r11, String r12, Integer r13, TabExtra r14, Icon r15, Icon r16, List r17, OptionItem r18, List r19, int r20, DefaultConstructorMarker r21) {
        List r2 = null;
        if ((r20 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        TabExtra r5 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Icon r6 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Icon r7 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        OptionItem r9 = null;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r2 = r19;
    L38:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
        return;
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
        r1 = r11;
        goto L7
    }
}
