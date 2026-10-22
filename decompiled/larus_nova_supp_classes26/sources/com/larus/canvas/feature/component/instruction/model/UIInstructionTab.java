package com.larus.canvas.feature.component.instruction.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/UIInstructionTab;", "", "tabLabel", "", "tabNameText", "selectedText", "uiOptionList", "", "Lcom/larus/canvas/feature/component/instruction/model/UIOptionItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTabLabel", "()Ljava/lang/String;", "getTabNameText", "getSelectedText", "getUiOptionList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UIInstructionTab {
    private final String selectedText;
    private final String tabLabel;
    private final String tabNameText;
    private final List<UIOptionItem> uiOptionList;

    public UIInstructionTab() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UIInstructionTab copy$default(UIInstructionTab r0, String r1, String r2, String r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.tabLabel;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.tabNameText;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.selectedText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.uiOptionList;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.tabLabel;
    }

    public final String component2() {
        return this.tabNameText;
    }

    public final String component3() {
        return this.selectedText;
    }

    public final List<UIOptionItem> component4() {
        return this.uiOptionList;
    }

    public final UIInstructionTab copy(String r2, String r3, String r4, List<UIOptionItem> r5) {
        Intrinsics.checkNotNullParameter(r2, "tabLabel");
        Intrinsics.checkNotNullParameter(r3, "tabNameText");
        Intrinsics.checkNotNullParameter(r4, "selectedText");
        Intrinsics.checkNotNullParameter(r5, "uiOptionList");
        return new UIInstructionTab(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UIInstructionTab) == true) goto L8;
        return false;
    L8:
        UIInstructionTab r6 = (UIInstructionTab) r5;
        if (Intrinsics.areEqual(this.tabLabel, r6.tabLabel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabNameText, r6.tabNameText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.selectedText, r6.selectedText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uiOptionList, r6.uiOptionList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.tabLabel.hashCode() * 31) + this.tabNameText.hashCode()) * 31) + this.selectedText.hashCode()) * 31) + this.uiOptionList.hashCode();
    }

    public String toString() {
        return "UIInstructionTab(tabLabel=" + this.tabLabel + ", tabNameText=" + this.tabNameText + ", selectedText=" + this.selectedText + ", uiOptionList=" + this.uiOptionList + ')';
    }

    public final String getSelectedText() {
        return this.selectedText;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabNameText() {
        return this.tabNameText;
    }

    public final List<UIOptionItem> getUiOptionList() {
        return this.uiOptionList;
    }

    public UIInstructionTab(String r2, String r3, String r4, List<UIOptionItem> r5) {
        Intrinsics.checkNotNullParameter(r2, "tabLabel");
        Intrinsics.checkNotNullParameter(r3, "tabNameText");
        Intrinsics.checkNotNullParameter(r4, "selectedText");
        Intrinsics.checkNotNullParameter(r5, "uiOptionList");
        this.tabLabel = r2;
        this.tabNameText = r3;
        this.selectedText = r4;
        this.uiOptionList = r5;
    }

    public /* synthetic */ UIInstructionTab(String r2, String r3, String r4, List r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = new ArrayList();
    L14:
        this(r2, r3, r4, r5);
    }
}
