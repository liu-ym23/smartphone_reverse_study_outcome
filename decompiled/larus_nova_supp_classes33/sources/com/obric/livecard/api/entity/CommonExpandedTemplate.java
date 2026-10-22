package com.obric.livecard.api.entity;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003Jc\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0017\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002002\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u00068"}, d2 = {"Lcom/obric/livecard/api/entity/CommonExpandedTemplate;", "", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "content", "Lcom/obric/livecard/api/entity/Text;", "icon", "Lcom/obric/livecard/api/entity/Icon;", "title", "titleIcon", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "contentIcon", "(Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;Lcom/obric/livecard/api/entity/Icon;)V", "getButtonList$annotations", "()V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getContentIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setContentIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getIcon", "setIcon", "getTitle", "setTitle", "getTitleIcon", "setTitleIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonExpandedTemplate {
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon contentIcon;
    private Icon icon;
    private Text title;
    private Icon titleIcon;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonExpandedTemplate copy$default(CommonExpandedTemplate r5, List r6, Text r7, Icon r8, Text r9, Icon r10, List r11, Icon r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.buttonList;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.content;
    L8:
        Text r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.icon;
    L11:
        Icon r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.title;
    L14:
        Text r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.titleIcon;
    L17:
        Icon r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.buttonV2List;
    L20:
        List r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.contentIcon;
    L23:
        List r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    @Deprecated(message = "请使用buttonV2List")
    public static /* synthetic */ void getButtonList$annotations() {
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

    public final Icon component7() {
        return this.contentIcon;
    }

    public final CommonExpandedTemplate copy(List<Button> r10, Text r11, Icon r12, Text r13, Icon r14, List<ButtonV2> r15, Icon r16) {
        Intrinsics.checkNotNullParameter(r10, "buttonList");
        Intrinsics.checkNotNullParameter(r11, "content");
        Intrinsics.checkNotNullParameter(r15, "buttonV2List");
        return new CommonExpandedTemplate(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CommonExpandedTemplate) == true) goto L8;
        return false;
    L8:
        CommonExpandedTemplate r6 = (CommonExpandedTemplate) r5;
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
        if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.contentIcon, r6.contentIcon) == true) goto L29;
        return false;
    L29:
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
        int r10 = (((r7 + r9) * 31) + this.buttonV2List.hashCode()) * 31;
        Icon r11 = this.contentIcon;
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
        return "CommonExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", buttonV2List=" + this.buttonV2List + ", contentIcon=" + this.contentIcon + ')';
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

    public final Icon getContentIcon() {
        return this.contentIcon;
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

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_expand_template", this, r14, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buttonList = r2;
    }

    public final void setButtonV2List(List<ButtonV2> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buttonV2List = r2;
    }

    public final void setContent(Text r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setContentIcon(Icon r1) {
        this.contentIcon = r1;
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

    public static /* synthetic */ IslandWidget create$default(CommonExpandedTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Boolean.FALSE;
    L6:
        return r0.create(r1);
    }

    public CommonExpandedTemplate(List<Button> r2, Text r3, Icon r4, Text r5, Icon r6, List<ButtonV2> r7, Icon r8) {
        Intrinsics.checkNotNullParameter(r2, "buttonList");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r7, "buttonV2List");
        this.buttonList = r2;
        this.content = r3;
        this.icon = r4;
        this.title = r5;
        this.titleIcon = r6;
        this.buttonV2List = r7;
        this.contentIcon = r8;
    }

    public /* synthetic */ CommonExpandedTemplate(List r10, Text r11, Icon r12, Text r13, Icon r14, List r15, Icon r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L5;
        List r2 = CollectionsKt.emptyList();
    L7:
        if ((r17 & 4) == 0) goto L9;
        Icon r4 = null;
    L11:
        if ((r17 & 8) == 0) goto L13;
        Text r5 = null;
    L15:
        if ((r17 & 16) == 0) goto L17;
        Icon r6 = null;
    L19:
        if ((r17 & 32) == 0) goto L21;
        List r7 = CollectionsKt.emptyList();
    L23:
        if ((r17 & 64) == 0) goto L25;
        Icon r8 = null;
    L26:
        this(r2, r11, r4, r5, r6, r7, r8);
        return;
    L25:
        r8 = r16;
        goto L26
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }
}
