package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014BS\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0002\u0010%J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003JY\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012¨\u00065"}, d2 = {"Lcom/obric/assistant/live/template/ObricComplexTaskOperatingExpandedTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "content", "Lcom/obric/livecard/api/entity/Text;", "icon", "Lcom/obric/livecard/api/entity/Icon;", "title", "titleIcon", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;)V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getTitle", "setTitle", "getTitleIcon", "setTitleIcon", "getButtonV2List", "setButtonV2List", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricComplexTaskOperatingExpandedTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_applet:common_expand_template";
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon icon;
    private Text title;
    private Icon titleIcon;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricComplexTaskOperatingExpandedTemplate copy$default(ObricComplexTaskOperatingExpandedTemplate r4, List r5, Text r6, Icon r7, Text r8, Icon r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.buttonList;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.content;
    L8:
        Text r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.icon;
    L11:
        Icon r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.title;
    L14:
        Text r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.titleIcon;
    L17:
        Icon r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.buttonV2List;
    L20:
        List r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final List<Button> component1() {
        return this.buttonList;
    }

    public final Text component2() {
        return this.content;
    }

    public final Icon component3() {
        return this.icon;
    }

    public final Text component4() {
        return this.title;
    }

    public final Icon component5() {
        return this.titleIcon;
    }

    public final List<ButtonV2> component6() {
        return this.buttonV2List;
    }

    public final ObricComplexTaskOperatingExpandedTemplate copy(List<Button> r9, Text r10, Icon r11, Text r12, Icon r13, List<ButtonV2> r14) {
        Intrinsics.checkNotNullParameter(r9, "buttonList");
        Intrinsics.checkNotNullParameter(r10, "content");
        return new ObricComplexTaskOperatingExpandedTemplate(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricComplexTaskOperatingExpandedTemplate) == true) goto L8;
        return false;
    L8:
        ObricComplexTaskOperatingExpandedTemplate r6 = (ObricComplexTaskOperatingExpandedTemplate) r5;
        if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.titleIcon, r6.titleIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.buttonList.hashCode() * 31) + this.content.hashCode()) * 31;
        Icon r1 = this.icon;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Text r5 = this.title;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Icon r8 = this.titleIcon;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<ButtonV2> r11 = this.buttonV2List;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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

    public String toString() {
        return "ObricComplexTaskOperatingExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", buttonV2List=" + this.buttonV2List + ')';
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final List<ButtonV2> getButtonV2List() {
        return this.buttonV2List;
    }

    public final Text getContent() {
        return this.content;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getTitle() {
        return this.title;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r14) {
        return new IslandWidget(TEMPLATE_ID, this, r14, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buttonList = r2;
    }

    public final void setButtonV2List(List<ButtonV2> r1) {
        this.buttonV2List = r1;
    }

    public final void setContent(Text r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setIcon(Icon r1) {
        this.icon = r1;
    }

    public final void setTitle(Text r1) {
        this.title = r1;
    }

    public final void setTitleIcon(Icon r1) {
        this.titleIcon = r1;
    }

    public ObricComplexTaskOperatingExpandedTemplate(List<Button> r2, Text r3, Icon r4, Text r5, Icon r6, List<ButtonV2> r7) {
        Intrinsics.checkNotNullParameter(r2, "buttonList");
        Intrinsics.checkNotNullParameter(r3, "content");
        this.buttonList = r2;
        this.content = r3;
        this.icon = r4;
        this.title = r5;
        this.titleIcon = r6;
        this.buttonV2List = r7;
    }

    public /* synthetic */ ObricComplexTaskOperatingExpandedTemplate(List r10, Text r11, Icon r12, Text r13, Icon r14, List r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        Icon r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        Text r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        Icon r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        List r8 = null;
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }
}
